import java.util.ArrayList;
import java.util.Random;


public class Colombo extends Thread {
    private String nombre;
    private ArrayList<Invitado> listaInvitados;
    private boolean cazado=false;
    private Anfitrion anfitrion;

    public Colombo(String nombre, ArrayList<Invitado> listaInvitados, Anfitrion anfitrion) {
        this.nombre = nombre;
        this.listaInvitados = listaInvitados;
        this.anfitrion=anfitrion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public ArrayList<Invitado> getListaInvitados() {
        return listaInvitados;
    }

    public void setListaInvitados(ArrayList<Invitado> listaInvitados) {
        this.listaInvitados = listaInvitados;
    }

    public void run() {
        while(!cazado) {
            Random random = new Random();
            int randomNumber = random.nextInt(5);
            System.out.println("INTENTO DE CAZAR A "+ listaInvitados.get(randomNumber).getNombre());

            try{
                if(listaInvitados.get(randomNumber).getRegalo().getNombre().equals("PISTOLA")){
                    for (Invitado invitado:listaInvitados) {
                        try {
                            invitado.setFiestaSigue(false);
                            invitado.join();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        invitado.interrupt();
                    }
                    anfitrion.setFiestaSigue(false);
                    anfitrion.interrupt();
                    System.out.println("CAZADO");
                    Thread.currentThread().interrupt();
                }
            } catch (NullPointerException e) {
                System.out.println("AHORA MISMO "+listaInvitados.get(randomNumber).getNombre()+" NO TIENE REGALO :(");
            }
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
