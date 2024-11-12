public class Consumidor extends Thread {
    private String nombre;
    private int numEjecuciones=10;
    private MiBuffer buffer;
    public Consumidor(String nombre, MiBuffer buffer) {
        super(nombre);
        this.nombre = nombre;
        this.buffer = buffer;
    }
    public void run() {
        int contador = 0;

        while (contador<=numEjecuciones) {
            synchronized (buffer) {
            /*System.out.printf(
                    "#%d | [%s] Soy el consumidor y voy a intentar consumir del buffer\n",numEjecuciones, nombre);*/
                int aux;
                while (buffer.estaVacio()) {
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                aux= buffer.extraer();
                System.out.printf("%s #%d | Soy el consumidor y he quitado el numero %d",nombre, contador, aux);
                System.out.printf("#%d | [%s] Buffer: %s\n", contador, nombre, buffer);
                buffer.notifyAll();
            }
            System.out.println("sale del synchronyzed");
        }

    }
}
