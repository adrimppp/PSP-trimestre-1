import java.io.*;

public class ProcesoDir406 {
    public static void main(String[] args) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "dir", "/w/p"/*, "/y"*/);
            processBuilder.directory(new File(System.getProperty("user.home")));

            // Redirigir la salida de error al flujo de salida estándar
            processBuilder.redirectErrorStream(true);

            Process process = processBuilder.start();
            mostrarSalida(process);

            int exitCode = process.waitFor();
            System.out.printf("Ejecutado: %s. Proceso finalizado con código: %d", processBuilder.command(), exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void mostrarSalida(Process p) throws IOException {
        // Capturar la salida del proceso
        // Se ha usado el código de página CP850 para que se muestren correctamente las vocales con tilde en Windows
        // Hay formas de obtener automáticamente el código de página que está usando el Sistema Operativo pero no son
        // triviales y no desviaremos el foco por ahora
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream(), "CP850")); //especificamos el mapa de caracteres

        // Mostramos por pantalla la salida capturada del proceso
        String line;
        System.out.println("Salida del proceso [estándar+errores]:");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}