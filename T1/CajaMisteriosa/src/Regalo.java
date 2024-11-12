public class Regalo {
    private String nombre;

    public Regalo(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Regalo{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
