import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        new Fabrica();
        ExecutorService executorService= Executors.newFixedThreadPool(Fabrica.getListaNombres().size());
        for(Infante infante:Fabrica.getListaInfantes()){
            System.out.println(infante.toString());
            executorService.execute(infante);
        }
        executorService.shutdown();

    }
}