import java.io.File;
import java.io.IOException;

public class ProcesoDir400 {
    public static void main(String[] args) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("dir", "/w /p");
            processBuilder.directory(new File(System.getProperty("user.home")));
            Process process = processBuilder.start();
            int exitCode = process.waitFor();
            System.out.println("Proceso finalizado con código: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}