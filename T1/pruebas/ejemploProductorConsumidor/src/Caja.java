public class Caja {
    private int numeros [];
    private static int posicionLect=0;
    private static int posicionEsc=0;
    public Caja(int tamanio) {
        numeros = new int[tamanio];
    }
    public int escribir(int num){
        numeros[posicionEsc] = num;
        posicionEsc++;
        num++;
        leerNumeros();
        if(posicionEsc==numeros.length){
            posicionEsc=0;
        }
        return num;
    }
    public int leer(){
        int numeroLeido=numeros[posicionLect];
        numeros[posicionLect] = 0;
        posicionLect++;
        leerNumeros();
        if(posicionLect==numeros.length){
            posicionLect=0;
        }
        return numeroLeido;
    }
    public boolean vacio(){
        for(int i:numeros){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
    public boolean lleno(){
        for(int i:numeros){
            if(i==0){
                return false;
            }
        }
        return true;
    }
    private void leerNumeros(){
        System.out.print("[");
        for(int i:numeros){
            System.out.print(i+",");
        }
        System.out.print("]");
    }
}
