import java.security.SecureRandom;
import java.time.Instant;

public class Hilos implements Runnable{


    public Hilos(){
    }
    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            Instant momentoActual= Instant.now();
            System.out.printf(" %s||Mensaje %s del hilo %s \n",momentoActual, i,Thread.currentThread().getName());
            SecureRandom random = new SecureRandom();
            try {
                Thread.sleep(random.nextInt(4000,5000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Thread tarea=new Thread(new Tarea2());
            tarea.start();
            try {
                tarea.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }


}
