public class Tarea implements Runnable{
    private Cofre cofre;
    public Tarea(Cofre cofre){
        this.cofre=cofre;
    }
    @Override
    public void run() {
        cofre.escribir(Thread.currentThread().getName().charAt(0));
    }
}
