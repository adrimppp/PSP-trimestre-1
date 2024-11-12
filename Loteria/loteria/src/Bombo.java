import java.util.ArrayList;
import java.util.Collections;

public class Bombo {
    ArrayList<Bola> bomboNumeros = new ArrayList<>();
    public Bombo() {
        llenarBombo();
    }
    public void llenarBombo() {
        for(int i = 0; i < 10; i++) {
            Bola bola=new Bola(i);
            bomboNumeros.add(bola);
        }
    }
    public void removerBombo() {
        Collections.shuffle(bomboNumeros);
    }

    public ArrayList<Bola> getBomboNumeros() {
        return bomboNumeros;
    }

    public void setBomboNumeros(ArrayList<Bola> bomboNumeros) {
        this.bomboNumeros = bomboNumeros;
    }

    @Override
    public String toString() {
        String bombo="";
        for(Bola bola:bomboNumeros) {
            bombo+=bola.toString();
        }
        return bombo;
    }
}
