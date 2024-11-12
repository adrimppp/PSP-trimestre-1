import java.security.SecureRandom;

public class Infante extends Thread {
    private String nombre;
    private Juguete juguete1;
    private Juguete juguete2;
    private int tiempoEspera;
    public Infante(String nombre, Juguete jug1,Juguete jug2, int tiempoEspera) {
        this.nombre = nombre;
        juguete1 = jug1;
        juguete2=jug2;
        this.tiempoEspera=tiempoEspera;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void disparar(){
        int num= (int) (Math.random()*10);
        if(num>5){
            System.out.println("Se disparó en la manzana. Por el niño "+ nombre);
        }
        else{
            System.out.println("Se disparó a la madera.Por el niño "+ nombre);
        }
    }

    public void run() {
        SecureRandom random= new SecureRandom();
        while(true){
            try {
                Thread.sleep(tiempoEspera);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (juguete1){
                try {
                    Thread.sleep(tiempoEspera);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(juguete1.getNombreJuguete()+" obtenido por "+this.getNombre());
                System.out.println("Esperando al  "+ juguete2.getNombreJuguete()+ " " +this.getNombre());
                synchronized (juguete2){
                    disparar();
                }
            }
        }
    }

}
