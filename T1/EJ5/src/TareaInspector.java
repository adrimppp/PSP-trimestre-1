import java.util.ArrayList;
import java.util.HashSet;

public class TareaInspector implements Runnable {
    public TareaInspector(ArrayList<Thread> listaHilos) {
        this.listaHilos = listaHilos;
    }
    ArrayList<Thread> listaHilos;
    HashSet<String> listaEstados= new HashSet<>();

    public ArrayList<Thread> getListaHilos() {
        return listaHilos;
    }

    public void setListaHilos(ArrayList<Thread> listaHilos) {
        this.listaHilos = listaHilos;
    }

    public HashSet<String> getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(HashSet<String> listaEstados) {
        this.listaEstados = listaEstados;
    }

    @Override
    public void run() {
        boolean terminado = false;
        do{
            final int dormir=75;
            for(Thread hilo: listaHilos){
                listaEstados.add(hilo.getState().toString());

            }
            if(listaEstados.contains(Thread.State.TERMINATED.toString())){
                terminado = true;
            }
            try {
                Thread.sleep(dormir);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }while (!terminado);
    }
}
