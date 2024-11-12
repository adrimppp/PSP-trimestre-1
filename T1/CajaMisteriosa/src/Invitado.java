import javax.swing.plaf.TableHeaderUI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Invitado extends Thread{
    private String nombre;
    private Regalo regalo;
    private CajaMisteriosa cajaMisteriosa;
    private boolean fiestaSigue = true;


    public Invitado(String nombre, CajaMisteriosa cajaMisteriosa) {
        this.nombre = nombre;
        this.cajaMisteriosa = cajaMisteriosa;
    }

    public boolean isFiestaSigue() {
        return fiestaSigue;
    }

    public void setFiestaSigue(boolean fiestaSigue) {
        this.fiestaSigue = fiestaSigue;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Regalo getRegalo() {
        return regalo;
    }
    public void setRegalo(Regalo regalo) {
        this.regalo = regalo;
    }

    public boolean tieneRegalo() {
        if (regalo == null) {
            return false;
        }
        return true;
    }

    public CajaMisteriosa getCajaMisteriosa() {
        return cajaMisteriosa;
    }

    public void setCajaMisteriosa(CajaMisteriosa cajaMisteriosa) {
        this.cajaMisteriosa = cajaMisteriosa;
    }

    @Override
    public void run() {

        while(fiestaSigue){
            while(!tieneRegalo()){
                synchronized (cajaMisteriosa) {
                    while(cajaMisteriosa.estaVacia()){
                        try {
                            cajaMisteriosa.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    regalo = cajaMisteriosa.cogerRegalo();
                    cajaMisteriosa.notify();
                }
                try {
                    Thread.currentThread().sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(regalo.getNombre().equals("PISTOLA")){
                    ExecutorService executor = Executors.newSingleThreadExecutor();

                    // Enviar la tarea al ExecutorService
                    executor.submit(new Sonido());
                    // Cerrar el ExecutorService
                    executor.shutdown();
                    try {
                        Thread.sleep(5000); // Simula que el sonido dura 5 segundos
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(getNombre()+ ": QUE FIESTA MAS ABURRIDA AL MENOS TENGO MI "+regalo.getNombre());
            }
            if(tieneRegalo()){
                System.out.println(getNombre()+ ": QUE FIESTA MAS ABURRIDA AL MENOS TENGO MI "+regalo.getNombre());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
