import java.io.File;
import java.io.IOException;

public class ProcesoDir403 {
    public static void main(String[] args) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "dir");
            processBuilder.directory(new File(System.getProperty("user.home")));
            Process process = processBuilder.start();
            int exitCode = process.waitFor();
            System.out.printf("Ejecutado: %s. Proceso finalizado con código: %d", processBuilder.command(), exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
