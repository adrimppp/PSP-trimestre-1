import java.util.ArrayList;

public class Consumidor extends Thread{
    private ArrayList<Character> letrasConsumidas=new ArrayList<>();
    private Character letraAConsumir;
    private Baul baulCompartido;
    int vecesConsumidas=0;

    public ArrayList<Character> getLetrasConsumidas() {
        return letrasConsumidas;
    }

    public void setLetrasConsumidas(ArrayList<Character> letrasConsumidas) {
        this.letrasConsumidas = letrasConsumidas;
    }

    public Character getLetraAConsumir() {
        return letraAConsumir;
    }

    public void setLetraAConsumir(Character letraAConsumir) {
        this.letraAConsumir = letraAConsumir;
    }

    public Baul getBaulCompartido() {
        return baulCompartido;
    }


    public int getVecesConsumidas() {
        return vecesConsumidas;
    }

    public void setVecesConsumidas(int vecesConsumidas) {
        this.vecesConsumidas = vecesConsumidas;
    }

    public Consumidor(Baul baul, char letraAConsumir){
        baulCompartido=baul;
        this.letraAConsumir=letraAConsumir;
    }
    @Override
    public void run() {
        System.out.println("Consumidor "+letrasConsumidas);
        synchronized(baulCompartido){
            while(vecesConsumidas<3){
                if(letraAConsumir.equals(baulCompartido.getCaracteresLista()[baulCompartido.getPosLectura()])){
                    baulCompartido.consumir(letrasConsumidas);
                    vecesConsumidas++;
                }
                int posLectura=baulCompartido.getPosLectura()+1;
                baulCompartido.setPosLectura(posLectura);
            }
        }
    }
}
