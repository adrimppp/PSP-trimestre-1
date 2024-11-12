public class Bola {
    private int numBola;
    public Bola(int numBola) {
        this.numBola = numBola;
    }

    public int getNumBola() {
        return numBola;
    }

    public void setNumBola(int numBola) {
        this.numBola = numBola;
    }

    @Override
    public String toString() {
        return "Bola{" +
                "numBola=" + numBola +
                '}';
    }
}
