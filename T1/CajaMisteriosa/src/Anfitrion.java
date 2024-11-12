import java.util.ArrayList;

public class Anfitrion extends Thread{
    private Regalo[] listaRegalos=new Regalo[6];
    private CajaMisteriosa cajaMisteriosa;
    private String nombre;
    private int posicionRegalo;
    private boolean fiestaSigue = true;

    public Anfitrion(CajaMisteriosa cajaMisteriosa) {
        this.cajaMisteriosa = cajaMisteriosa;
        nombre="Mustafa";
        generarObjetos();
    }


    public int getPosicionRegalo() {
        return posicionRegalo;
    }

    public void setPosicionRegalo(int posicionRegalo) {
        this.posicionRegalo = posicionRegalo;
    }

    public boolean isFiestaSigue() {
        return fiestaSigue;
    }

    public void setFiestaSigue(boolean fiestaSigue) {
        this.fiestaSigue = fiestaSigue;
    }

    public Regalo[] getListaRegalos() {
        return listaRegalos;
    }

    public CajaMisteriosa getCajaMisteriosa() {
        return cajaMisteriosa;
    }

    public void setCajaMisteriosa(CajaMisteriosa cajaMisteriosa) {
        this.cajaMisteriosa = cajaMisteriosa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setListaRegalos(Regalo[] listaRegalos) {
        this.listaRegalos = listaRegalos;
    }
    private void generarObjetos(){
        String[] RegalosDisponibles={"ANILLO","RELOJ","PISTOLA","CARAMELO", "MOVIL", "ROSA"};
        for (int i = 0; i < RegalosDisponibles.length; i++) {
            Regalo r=new Regalo(RegalosDisponibles[i]);
            listaRegalos[i]=r;
        }
    }

    public boolean regalosAcabados(){
        if(listaRegalos!=null){
            return false;
        }
        return true;
    }

    public void tocarCampana(CajaMisteriosa cajaMisteriosa){
        cajaMisteriosa.notifyAll();
        System.out.println("HE DEJADO UN REGALO!!");
    }

    public void run(){
        while (fiestaSigue){
            while(posicionRegalo<listaRegalos.length){
                synchronized(cajaMisteriosa){
                    while(!cajaMisteriosa.estaVacia()){
                        try {
                            cajaMisteriosa.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    if(posicionRegalo<6){
                        int posicionAuxiliar=posicionRegalo;
                        cajaMisteriosa.dejarRegalo(listaRegalos[posicionRegalo++]);
                        listaRegalos[posicionAuxiliar]=null;
                        tocarCampana(cajaMisteriosa);
                        for(Regalo regalo:listaRegalos){
                            if(regalo==null){
                                System.out.println("null,");
                            }
                            else{System.out.println(regalo.toString());
                            }
                        }
                    }
                    if(posicionRegalo>=6){
                        cajaMisteriosa.notifyAll();
                    }
                    System.out.println(posicionRegalo);
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
