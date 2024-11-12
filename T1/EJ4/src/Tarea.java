public class Tarea implements Runnable{
    private Cofre cofre;
    public Tarea(Cofre cofre){
        this.cofre=cofre;
    }
    @Override
    public synchronized void run() {
        for(int i=0; i<19;i++){
            cofre.escribir(Thread.currentThread().getName().charAt(0));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
