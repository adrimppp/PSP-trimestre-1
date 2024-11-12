import java.util.Scanner;

public class LectorPeso {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce tu peso");
        int peso = sc.nextInt();
        System.out.println("TU PESO ES DE "+peso+" KG");
        sc.close();
    }

}
