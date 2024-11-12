import java.io.*;

public class OutputWriterExample {
    public static void main(String[] args) throws IOException {
        // Crear un proceso con un comando Windows (ejemplo: "echo")
        ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "echo Hola Mundo");
        Process process = processBuilder.start();

        // Obtener el outputWriter y escribir en la salida estándar
        Writer writer = process.outputWriter();
        writer.write("Texto de prueba en la salida estándar.");
        writer.flush();
        writer.close();

        // Leer la salida del proceso
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);  // Esto mostrará "Hola Mundo"
        }
    }
}
