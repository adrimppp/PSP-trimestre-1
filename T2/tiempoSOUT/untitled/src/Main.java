import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor=  Executors.newFixedThreadPool(1);
        Instant tiempoAhora = Instant.now();
        Thread hilo= new Thread(new imprime());
        System.out.println("Tiempo Inicio: "+tiempoAhora);
        /*hilo.start();
        try {
            hilo.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        System.out.println("Imprimir tarda");
        Instant tiempoAhora2 = Instant.now();
        System.out.println("Tiempo fin: "+tiempoAhora2);
    }
}