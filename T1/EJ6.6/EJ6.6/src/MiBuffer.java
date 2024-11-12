import java.util.ArrayList;
import java.util.Arrays;

public class MiBuffer {
    private ArrayList <Integer> guardados=new ArrayList <> ();
    private int [] buffer;
    private static int posLectura=0;
    private static int posEscritura =0;
    private static final int MIN = 1;  // Longitud minima del buffer
    public MiBuffer(int size) {
        crearArray(size);
    }
    public void imprimirArrayList(){
        for(int i:guardados){
            System.out.println(i);
        }
    }
    private void crearArray(int size){
        if(size<MIN){
            throw new IllegalArgumentException(
                    "La longitud debe ser >= %s [longitud = %d".formatted(MIN, size));
        }
        this.buffer = new int[size];
    }
    public void agregar(int numero){
        try{
            buffer[posEscritura] = numero;
            posEscritura++;
            System.out.println("NUMERO"+numero);}//primer hace buffer[i]=numero y a la que lee el ++ lo suma pero seguimos con la otra estructura
        catch(ArrayIndexOutOfBoundsException e){
            posEscritura=0;
            agregar(numero);
        }
    }

    public ArrayList<Integer> getGuardados() {
        return guardados;
    }

    public int extraer(){
        int aux=0;
            try{
                if(buffer[posLectura]!=0){
                    aux=buffer[posLectura];
                    buffer[posLectura++] = 0;
                    guardados.add(aux);
                    System.out.println(posLectura);
                }
                else if(buffer[posLectura]==0){
                    extraer();
                }
            } catch(ArrayIndexOutOfBoundsException e){
                posLectura=0;
            }


        return aux;
    }
    public boolean estaLleno() {
        for (int i : buffer) {
            if (i == 0)
                return false;
        }
        return true;
    }

    public boolean estaVacio() {
        for (int i : buffer) {
            if (i != 0)
                return false;
        }
        return true;
    }
    public boolean niVacioNiLLeno(){
        return !estaVacio() && !estaLleno();
    }
    @Override
    public String toString() {
        return "Array=%s posEscritura=%d posLectura=%d".
                formatted(Arrays.toString(buffer), posEscritura, posLectura);
    }
}

