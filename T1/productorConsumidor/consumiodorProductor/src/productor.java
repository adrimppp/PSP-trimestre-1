public class productor implements Runnable{
    private objetoCompartido objetoCompartido;
    public productor(objetoCompartido objetoCompartido){
        this.objetoCompartido = objetoCompartido;
    }

    @Override
    public void run() {
        int contador = 1;
        while(true){
        contador=objetoCompartido.produce(contador);

        }
    }
}
