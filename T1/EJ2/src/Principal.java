import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        final int NUM_HILOS=3;
        ArrayList <Hilo> listaHilos=new ArrayList<Hilo>();
        for(int i=0; i<NUM_HILOS;i++){
            Hilo t= new Hilo(new Tarea());
            listaHilos.add(t);
        }
        for (int i = 0; i < listaHilos.size(); i++) {
            listaHilos.get(i).start();
        }
        for (int i = 0; i < listaHilos.size(); i++) {
            try {
                listaHilos.get(i).join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("FIN");

    }
}