import java.util.Collections;

public class Infante implements Runnable {
    private String nombre;
    private Bola bola;
    private Bombo bombo;
    private Combinacion combinacion;
    public Infante(String nombre, Bombo bombo, Combinacion combinacion) {
        this.nombre = nombre;
        this.bombo = bombo;
        this.combinacion=combinacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Bola getBola() {
        return bola;
    }

    public void setBola(Bola bola) {
        this.bola = bola;
    }

    public Bombo getBombo() {
        return bombo;
    }

    public void setBombo(Bombo bombo) {
        this.bombo = bombo;
    }



    @Override
    public void run() {
        synchronized (bombo) {
            bombo.removerBombo();
            System.out.println(bombo.toString());
            this.setBola(bombo.getBomboNumeros().get(0));
            bombo.getBomboNumeros().remove(0);
            combinacion.aniadirNumeroACombinacion(bola.getNumBola());
            bombo.getBomboNumeros().add(bola);
            this.setBola(null);
        }
    }

    @Override
    public String toString() {
        return "Infante{" +
                "nombre='" + nombre + '\'' +
                ", bola=" + bola +
                ", bombo=" + bombo.toString() +
                '}';
    }
}
