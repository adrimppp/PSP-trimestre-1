import java.util.ArrayList;
import java.util.Collections;

public class Productor extends Thread {
    private ArrayList<Character> caracteres=new ArrayList<Character>();
    private Baul baulCompartido;
    public Productor(Baul baul) {
        baulCompartido=baul;
        setCaracteres(caracteres);
    }

    public ArrayList<Character> getCaracteres() {
        return caracteres;
    }

    public void setCaracteres(ArrayList<Character> caracteres) {
        Character[] añadirLetras=new Character[3];
        añadirLetras[0]='A';
        añadirLetras[1]='B';
        añadirLetras[2]='C';
        for(int i=0;i<3;i++){
            for (int j = 0; j < 3; j++) {
                caracteres.add(añadirLetras[j]);
            }
        }
        Collections.shuffle(caracteres);
        System.out.println(caracteres);
    }
    public void run() {
        synchronized (baulCompartido) {
            int i=0;
            while(i<9){
                baulCompartido.producir(caracteres.get(i));
                i++;
            }
        }
    }

}
