public class Main {
    public static void main(String[] args) {
        int espera1=5;
        int espera2=10000;
        Juguete arco=new Juguete("Arco");
        Juguete flecha=new Juguete("Flecha");
        Infante nino1=new Infante("Javi",arco,flecha,espera1);
        Infante nino2=new Infante("Marcos",flecha,arco,espera2);
        nino1.start();
        nino2.start();

    }
}