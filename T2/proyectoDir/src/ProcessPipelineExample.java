import java.io.*;

public class ProcessPipelineExample {
    public static void main(String[] args) {
        try {
            // Crear el primer proceso: echo "Hola desde Java"
            ProcessBuilder echoProcessBuilder = new ProcessBuilder("cmd", "/c", "echo Hola desde Java");
            Process echoProcess = echoProcessBuilder.start();

            // Crear el segundo proceso: findstr "Java"
            ProcessBuilder findstrProcessBuilder = new ProcessBuilder("cmd", "/c", "findstr Java");
            Process findstrProcess = findstrProcessBuilder.start();

            // Conectar la salida del primer proceso al flujo de entrada del segundo
            InputStream echoInputStream = echoProcess.getInputStream();
            OutputStream findstrOutputStream = findstrProcess.getOutputStream();
            // Copiar la salida de echoProcess a la entrada de findstrProcess
            Thread echoToFindstrThread = new Thread(() -> {
                try (BufferedInputStream echoIn = new BufferedInputStream(echoInputStream);
                     BufferedOutputStream findstrOut = new BufferedOutputStream(findstrOutputStream)) {
                    int byteRead;
                    while ((byteRead = echoIn.read()) != -1) {
                        findstrOut.write(byteRead);  // Escribir cada byte del echo al findstr
                    }
                    findstrOut.flush();  // Asegurar que los datos se envíen
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            echoToFindstrThread.start();

            // Leer la salida del proceso findstr
            InputStream findstrInputStream = findstrProcess.getInputStream();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(findstrInputStream))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);  // Imprime lo que findstr encuentra
                }
            }

            // Esperar a que ambos procesos terminen
            echoProcess.waitFor();
            findstrProcess.waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
