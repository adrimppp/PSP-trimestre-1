import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "java", "LectorPeso");

        // Establecer el directorio de trabajo para el proceso (cambia según tu entorno)
        File dir = new File("E:\\DAM+DAW\\CURSO2\\PSP\\T2\\2.3\\out\\production\\2.3");
        pb.directory(dir);

        // Imprimir información sobre el directorio y el comando
        System.out.println("Directorio de trabajo: " + pb.directory());
        System.out.println("Comando: " + pb.command());

        try {
            Process p = pb.start();
            escribirEntrada(p);
            leerErrores(p);
            leerSalidaEstandar(p);

            // Esperar a que el proceso termine y obtener el código de salida
            int exitCode = p.waitFor();
            System.out.println("Proceso finalizado con código de salida: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void escribirEntrada(Process p) throws IOException {
        OutputStream os = p.getOutputStream();
        try (PrintWriter writer = new PrintWriter(os)) {
            writer.println("50");  // Simular la entrada del peso (e.g., 50 kg)
            writer.flush();
        }
    }

    private static void leerErrores(Process p) throws IOException {
        System.out.println("SALIDA DE ERRORES:");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(p.getErrorStream(), StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        }
    }

    private static void leerSalidaEstandar(Process p) throws IOException {
        System.out.println("SALIDA ESTANDAR:");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream(), StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        }
    }
}
