import java.time.Instant;

public class Productor extends Thread {
    private Caja caja;
    private int num=1;
    public Productor(Caja caja) {
        this.caja = caja;
    }
    public void run() {
        while(true) {
            synchronized(caja) {
                while(caja.lleno()){
                    try {
                        caja.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                num=caja.escribir(num);
                Instant ahora = Instant.now();
                System.out.println(ahora+"||Se ha producido el número " + (num-1));
                if(caja.lleno()) {
                    caja.notify();
                }
            }
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
