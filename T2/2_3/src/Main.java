import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "java", "HolaMundo");
        processBuilder.directory(new File("D:\\DAM+DAW\\CURSO2\\PSP\\T2\\2_3\\out\\production\\leeSalidaErroresYestandar"));
        System.out.println("DIRECTORIO");
        Process process= processBuilder.start();
        leerErrores(process);
        leerSalidaEstandar(process);

    }
    private static void leerErrores(Process p) throws IOException {
        System.out.println("SALIDA DE ERRORES");
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getErrorStream(), "CP850"));
        String linea;
        while((linea=reader.readLine())!=null){
            System.out.println(linea);
        }
    }
    private static void leerSalidaEstandar(Process p) throws IOException {
        System.out.println("SALIDA ESTANDAR");
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream(), "CP850"));
        String linea;
        while((linea=reader.readLine())!=null){
            System.out.println(linea);
        }
    }
}