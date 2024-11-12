import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        int numHilos=2;
        ArrayList<Thread> listaHilos= new ArrayList<>();
        Tarea t1=new Tarea();
        for (int i = 0; i < numHilos; i++) {
            listaHilos.add(new Thread(t1, String.valueOf(i)));
        }
        TareaInspector inspeccionar=new TareaInspector(listaHilos);
        Thread Inspector=new Thread(inspeccionar,"Inspector");
        Inspector.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for(Thread hilo:listaHilos) {
            hilo.start();
        }
        for(Thread hilo:listaHilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(inspeccionar.getListaEstados());
    }
}