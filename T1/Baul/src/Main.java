import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Baul baulCompartido=new Baul();
        ArrayList <Consumidor> consumidores=new ArrayList<>();
        Productor productor = new Productor(baulCompartido);
        Character[] añadirLetras=new Character[3];
        añadirLetras[0]='A';
        añadirLetras[1]='B';
        añadirLetras[2]='C';
        for (int i = 0; i < 3; i++) {
            Consumidor cons=new Consumidor(baulCompartido,añadirLetras[i]);
            consumidores.add(cons);
        }
        productor.start();
        for(Consumidor consumidor:consumidores){
            consumidor.start();
        }
        System.out.println(baulCompartido.toString());
        for(Consumidor consumidor:consumidores){
            System.out.println(consumidor.getLetrasConsumidas());
        }
    }
}