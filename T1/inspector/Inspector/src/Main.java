import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Cuántos hilos quieres creer");
        Scanner sc = new Scanner(System.in);
        int numHilos = sc.nextInt();
        //ExecutorService executorService= Executors.newFixedThreadPool(numHilos);
        ArrayList <Thread> arrayListHilos=new ArrayList<>();
        for (int i = 0; i < numHilos; i++) {
            //executorService.execute(hilo);
            Thread hiloThread = new Thread(new Hilos(), String.valueOf(i));
            hiloThread.start();
            arrayListHilos.add(hiloThread);
        }
        Thread inspector=new Thread(new Inspector(arrayListHilos));
        inspector.start();
        //executorService.shutdown();
        //sc.close();
    }
}