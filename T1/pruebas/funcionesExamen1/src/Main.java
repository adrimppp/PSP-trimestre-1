import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "dir");
        pb.redirectErrorStream(true);
        Process p= pb.start();
        Utilidades.leerSalidaEstandar(p);
    }
}