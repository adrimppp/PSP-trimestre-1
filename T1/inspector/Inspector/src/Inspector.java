import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Inspector implements Runnable {
    private ArrayList <Thread> arrayListHilos=new ArrayList<>();
    private final HashMap<String ,ArrayList<String>> hilosEstados=new HashMap<>();
    public Inspector(ArrayList <Thread> arrayListHilos){
        this.arrayListHilos=arrayListHilos;
    }
    @Override
    public void run() {
        boolean seguir=true;
        while(seguir){
            for(Thread hilo:arrayListHilos){
                String estado=hilo.getState().toString();
                ArrayList<String> estadosIniciar= null;
                if(hilosEstados.get(hilo.getName())==null){
                     estadosIniciar= new ArrayList<>();
                }
                else{
                     estadosIniciar= hilosEstados.get(hilo.getName());
                }
                if(!estadosIniciar.contains(estado)){
                    estadosIniciar.add(estado);
                    hilosEstados.put(hilo.getName(),estadosIniciar);
                }
                if(Objects.equals(estado, "TERMINATED")){
                    seguir=false;
                }

            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        // Recorrer el HashMap hilosEstados e imprimir cada hilo y sus estados
        System.out.println("Inspector terminado");
        for (Map.Entry<String, ArrayList<String>> entry : hilosEstados.entrySet()) {
            String nombreHilo = entry.getKey();
            ArrayList<String> estados = entry.getValue();

            System.out.println("Hilo: " + nombreHilo + ", Estados: " + estados);
        }

    }

    public ArrayList<Thread> getArrayListHilos() {
        return arrayListHilos;
    }

    public void setArrayListHilos(ArrayList<Thread> arrayListHilos) {
        this.arrayListHilos = arrayListHilos;
    }
}
