import java.util.ArrayList;

public class consumidor implements Runnable{
    private objetoCompartido objetoCompartido;
    public consumidor(objetoCompartido objetoCompartido){
        this.objetoCompartido = objetoCompartido;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while(true){
            objetoCompartido.consume(this);
        }
    }
    private ArrayList<Integer> numGuardados= new ArrayList<>();

    public ArrayList<Integer> getNumGuardados() {
        return numGuardados;
    }

    public void setNumGuardados(ArrayList<Integer> numGuardados) {
        this.numGuardados = numGuardados;
    }
}
