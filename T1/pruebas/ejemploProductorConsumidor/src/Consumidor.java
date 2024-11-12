import java.time.Instant;

public class Consumidor extends Thread{
    private String letras;
    private Caja caja;
    public Consumidor(Caja caja) {
        this.caja = caja;
    }
    public void run(){
        while(true){
            synchronized(caja){
                while(caja.vacio()){
                    try {
                        caja.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                int numLeido=caja.leer();
                Instant ahora= Instant.now();
                System.out.println(ahora+" ||Se ha leído el número "+numLeido);
                if(caja.vacio()){
                    caja.notifyAll();
                }
            }try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
