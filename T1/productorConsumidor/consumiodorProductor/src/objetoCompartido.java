import static java.lang.Thread.sleep;

public class objetoCompartido {
    private int[] buffer;
    private int siguiente;
    private int numero;

    public int[] getBuffer() {
        return buffer;
    }

    public void setBuffer(int[] buffer) {
        this.buffer = buffer;
    }

    public int getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(int siguiente) {
        this.siguiente = siguiente;
    }

    public boolean isEstaVacia() {
        return estaVacia;
    }

    public void setEstaVacia(boolean estaVacia) {
        this.estaVacia = estaVacia;
    }

    public boolean isEstaLlena() {
        return estaLlena;
    }

    public void setEstaLlena(boolean estaLlena) {
        this.estaLlena = estaLlena;
    }

    private boolean estaVacia;
    private boolean estaLlena;
    objetoCompartido(int tamanio) {
        this.buffer=new int[tamanio];
        this.siguiente=0;
        this.estaVacia=true;
        this.estaLlena=false;
    }
    public synchronized int produce(int num)  {
        while(estaLlena){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if(buffer[siguiente]==0){
            buffer[siguiente]=num;
            System.out.println("Se ha escrito en la posicion "+siguiente+ " el numero "+num);
            siguiente++;
            num++;
            System.out.print("[");
            for(int iteracion:buffer){
                System.out.print(iteracion+",");
            }
            System.out.print("]");
            System.out.println();
        }
        else{
            siguiente++;
        }
        this.estaVacia=false;
        if(siguiente==buffer.length){
            estaLlena=true;
            siguiente=0;
        }
        try {
            sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        notifyAll();
        return num;
    }
    public synchronized void consume(consumidor consumidor){
        System.out.println("Inicia hilo "+ Thread.currentThread().getName());
        while(estaVacia){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if(buffer[siguiente]==0){
            if(siguiente==0){
                siguiente=buffer.length-1;
            }
            else{
                siguiente--;
            }
        }
        else if(buffer[siguiente]!=0){
            System.out.println("Se ha borrado en la posicion "+siguiente +" "+ Thread.currentThread().getName());
            consumidor.getNumGuardados().add(buffer[siguiente]);
            buffer[siguiente]=0;
            if(siguiente==0){
                siguiente=buffer.length-1;
            }
            else{
                siguiente--;
            }
        }
        estaLlena=false;
        System.out.print("[");
        boolean esCero=true;
        for(int num:buffer){
            System.out.print(num+",");
            if(num!=0){
                esCero=false;
            }
        }
        if(esCero){
            estaVacia=true;
        }
        System.out.print("]");
        System.out.println();
        notify();
        try {
            sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
