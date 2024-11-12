import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Cofre cofre = new Cofre (new Mensaje());
        ArrayList<Thread> listaHilos= new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            listaHilos.add(new Thread(new Tarea(cofre),Character.toString('A'+i)));
        }
        for (Thread hilo: listaHilos){
            hilo.start();
            System.out.println("Se inicia el hilo "+ hilo.getName());
        }
        for (Thread hilo: listaHilos){
            hilo.join();
        }
        System.out.println(cofre);
    }
}
