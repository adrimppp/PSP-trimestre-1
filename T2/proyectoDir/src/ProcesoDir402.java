import java.io.File;
// import java.io.IOException;

public class ProcesoDir402 {
    public static void main(String[] args) {
        //try {
        ProcessBuilder processBuilder = new ProcessBuilder("dir", "/w /p");
        processBuilder.directory(new File(System.getProperty("user.home")));

        // Comando, directorio de trabajo, variable de entorno USERPROFILE y entorno del proceso
        System.out.println("Comando: "+processBuilder.command());
        System.out.println("Directorio de trabajo: "+processBuilder.directory());
        System.out.println("Variable de entorno USERPROFILE: "+System.getenv("USERPROFILE"));
        System.out.println("Entorno del proceso: "+processBuilder.environment());

        // Process process = processBuilder.start();
        // int exitCode = process.waitFor();
        // System.out.println("Proceso finalizado con código: " + exitCode);
        // } catch (IOException | InterruptedException e) {
        //     e.printStackTrace();
        // }
    }
} 