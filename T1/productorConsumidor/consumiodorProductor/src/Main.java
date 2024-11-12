import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        objetoCompartido objetoCompartido=new objetoCompartido(10);
        ArrayList <Thread> listaHilos=new ArrayList<>();
        for (int i=1;i<=4;i++){
            if(i==1){
                Thread hilo =new Thread(new productor(objetoCompartido),"productor");
                listaHilos.add(hilo);
            }
            else{
                Thread hilo =new Thread(new consumidor(objetoCompartido),"consumidor"+i);
                listaHilos.add(hilo);
            }
        }
        for (Thread hilo:listaHilos){
            hilo.start();
        }
    }
}