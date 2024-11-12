import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int numHilosCons=3;
        MiBuffer buffer = new MiBuffer(10);
        Productor p1 = new Productor("PRODUCTOR", buffer);
        ArrayList<Consumidor> consumidores = new ArrayList<>();
        for (int i = 0; i <numHilosCons; i++) {
            consumidores.add(new Consumidor("CONSUMIDOR_" + i, buffer));
        }
        p1.start();
        for (Consumidor consumidor : consumidores) {
            consumidor.start(); // Consumidores
            System.out.println("Hilo "+ consumidor.getName()+" iniciado");
        }
        try {
            p1.join();
            for (Consumidor consumidor : consumidores) {
                consumidor.join(); // Consumidores
                System.out.println("Hilo "+ consumidor.getName()+" iniciado");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}