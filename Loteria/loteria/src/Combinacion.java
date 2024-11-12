public class Combinacion {
    private int[] numeros=new int[5];
    private int posicion=0;
    public Combinacion() {
    }
    public void aniadirNumeroACombinacion(int num) {
        numeros[posicion]=num;
        for(int numero:numeros){
            System.out.print(numero+",");
            System.out.println();
        }
        posicion++;
    }
}
