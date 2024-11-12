public class Productor extends Thread {
    private String nombre;
    private int numEjecuciones=30;
    private MiBuffer buffer;
    public Productor(String nombre, MiBuffer buffer) {
        super(nombre);
        this.nombre = nombre;
        this.buffer = buffer;
    }
    public void run() {
        int contador = 0;
        while (++contador<=numEjecuciones) {
            //System.out.printf("#%d | [%s] Soy el productor y voy a intentar escribir en el buffer\n", contador, nombre);
            synchronized (buffer) {
                //System.out.printf("#%d | [%s] Buffer: %s\n", contador, nombre, buffer);
                while(buffer.estaLleno()){
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if(buffer.estaVacio()){
                    buffer.agregar(contador);
                    buffer.notifyAll();
                }
                else{
                    buffer.agregar(contador);
                }

                System.out.printf("#%d | Soy el productor y he agregado el numero %d", contador, contador);
                System.out.printf("#%d | [%s] Buffer: %s\n", contador, nombre, buffer);

            }
            System.out.println("sale del synchronyzed");
        }

    }
}
