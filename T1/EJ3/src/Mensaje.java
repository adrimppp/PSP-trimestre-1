public class Mensaje {
    //va acontener el Array de caractéres
    private char[] contenido=new char[3];           //

    private int pos;                                // Rango: 0-2

    public Mensaje(){
        setPos(0);
    }

    public char[] getContenido() {                  //
        return contenido;
    }
    private void setPos(int i){
        if(i<0 || i>2){
            throw new IllegalArgumentException(String.format("El valor de posición tiene que estar entre [0,%d]. pos=%d",contenido.length-1, i ));
        }
        this.pos=i;
    }

    public void setContenido(char[] contenido) {    //
        this.contenido = contenido;
    }

    public void escribir(char letra) {
        contenido[pos]=letra;
        setPos(pos+1);
    }

    public String toString() {
        return String.valueOf(contenido);
    }
}
