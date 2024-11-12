import java.io.*;
import java.util.*;

public class InputReaderExample {
    public static void main(String[] args) throws IOException {
        // Crear un proceso que espera entrada
        ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "set /p userinput=Introduce algo: ");
        Process process = processBuilder.start();

        // Leer la entrada estándar del proceso
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.inputReader()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);  // Muestra lo que el proceso escribe en la entrada estándar
        }
    }
}
