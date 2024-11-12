public class Cofre{
    private Mensaje mensaje;

    public Cofre(Mensaje mensaje){
        this.mensaje=mensaje;
    }

    public String toString(){
        return "Cofre: "+ mensaje;
    }
    public void escribir(char letra){
        mensaje.escribir(letra);
    }


}
