import java.security.SecureRandom;
import java.time.Instant;

public class Tarea implements Runnable{
    @Override
    public synchronized void run() {
        SecureRandom numeroDeMs=new SecureRandom();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 10; i++) {
            try {
                int tiempoADormir=numeroDeMs.nextInt(200,300);
                Thread.sleep(tiempoADormir);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
            System.out.println(Instant.now());

        }
        Thread t1 = new Thread(new Tarea2());
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
