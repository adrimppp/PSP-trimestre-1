import java.time.Instant;
import java.util.ArrayList;

public class Baul {
    private Character[] caracteresLista=new Character[9];
    private int posLectura=0;
    private int posEscritura=0;
    public Baul() {

    }
    public void producir(char caracter) {
        try{
            Instant now = Instant.now();
            int nanoAdjustment = now.getNano();
            System.out.println();
            System.out.println("Voy a escribir : " + nanoAdjustment);
            System.out.println("Voy a producir : " + caracter);
            caracteresLista[posEscritura++]=caracter;
        }catch(ArrayIndexOutOfBoundsException e){
            posEscritura=0;
            producir(caracter);
        }
        System.out.print("[");
        for (int i = 0; i < 9; i++) {
            System.out.print(caracteresLista[i]+",");
        }
        System.out.println("]");
    }
    public void consumir(ArrayList<Character> letrasConsumidas){
        System.out.println("Voy a consumir : " + caracteresLista[posLectura]);
        Instant now = Instant.now();
        int nanoAdjustment = now.getNano();
        try{
            System.out.println("Voy a escribir : " + nanoAdjustment);
            System.out.println("Voy a quitar : " + caracteresLista[posLectura]);
            letrasConsumidas.add(caracteresLista[posLectura]);
            caracteresLista[posLectura++]=null;
        }catch(ArrayIndexOutOfBoundsException e){
            posLectura=0;
        }

    }

    public Character[] getCaracteresLista() {
        return caracteresLista;
    }

    public void setCaracteresLista(Character[] caracteresLista) {
        this.caracteresLista = caracteresLista;
    }

    public int getPosLectura() {
        if(posLectura>=caracteresLista.length){
            posLectura=0;
        }
        return posLectura;
    }

    public void setPosLectura(int posLectura) {
        this.posLectura = posLectura;
    }

    public int getPosEscritura() {
        return posEscritura;
    }

    public void setPosEscritura(int posEscritura) {
        this.posEscritura = posEscritura;
    }
    @Override
    public String toString() {
        String cadena="";
        cadena+="[";
        for (int i = 0; i < 9; i++) {
            cadena+=caracteresLista[i]+",";
        }
        cadena+="]";
        return cadena;
    }

}
