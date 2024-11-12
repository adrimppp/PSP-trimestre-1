public class Hilo extends Thread{
    private static int contador=0;
    private int numero;//autoincremento
    private static final String prefijo="T";

    public Hilo(Runnable tarea) {
        super(tarea);
        setNumero(++contador);
        setName(getNombre());
    }
    public String getNombre() {
        return prefijo + numero;
    }

    public void setNumero(int numero) {
        if(numero<0){
            throw new IllegalArgumentException(String.format("El número debe ser>=1;[numero= %d]", numero));
        }
        this.numero=numero;
        //Null pointer exception y IllegalArgumentException
    }
}
