import java.io.*;

public class Utilidades {
    public static void leerErrores(Process p) throws IOException {
        System.out.println("SALIDA DE ERRORES");
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getErrorStream(), "CP850"));
        String linea;
        while((linea=reader.readLine())!=null){
            System.out.println(linea);
        }
    }
    public static void leerSalidaEstandar(Process p) throws IOException {
        System.out.println("SALIDA ESTANDAR");
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream(), "CP850"));
        String linea;
        while((linea=reader.readLine())!=null){
            System.out.println(linea);
        }
    }
    public static void escribirEntrada(Process p, String escribir) throws IOException {
        OutputStream os = p.getOutputStream();
        try (PrintWriter writer = new PrintWriter(os)) {
            writer.println(escribir);  // Simular la entrada
            writer.flush();
        }
    }
}
