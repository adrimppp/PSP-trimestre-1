import java.security.SecureRandom;

public class Tarea implements Runnable{
    private SecureRandom random= new SecureRandom();
    @Override
    public synchronized void run() {
        /*Secure Random es criptograficamente más seguro*/
        for(int i=0;i<10;i++){
            System.out.println("Hola soy el hilo "+ Thread.currentThread().getName());
            try {
                Thread.sleep(random.nextInt(500)); //cuando no hay pausa le da más tiempo a hacer los print en el quantum de tiempo, el sleep es más grande que el quanutm
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
