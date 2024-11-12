import java.util.ArrayList;

public class principal {
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

        System.out.println("FIN");

    }
}