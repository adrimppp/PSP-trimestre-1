import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int numeroConsumidores=5;
        ExecutorService executorService = Executors.newFixedThreadPool((numeroConsumidores+1));
        Caja caja=new Caja(numeroConsumidores);
        Productor productor=new Productor(caja);
        productor.start();
        for (int i = 0; i < numeroConsumidores; i++) {
            Consumidor consumidor=new Consumidor(caja);
            executorService.execute(consumidor);
        }
        executorService.shutdown();
        System.out.println("FIN");
    }
}