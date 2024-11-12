import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // Crear CajaMisteriosa
        CajaMisteriosa cajaMisteriosa = new CajaMisteriosa();

        // Crear todos los invitados
        String[] nombresInvitados = {"SR.PIZARRO", "DR.MANDARINO", "SRTA.AMAPOLA", "SRTA.PRADO", "PROFESORA RUBIO", "MARQUES DE MARINA"};
        ArrayList<Invitado> listaInvitados = new ArrayList<>();

        for (String nombre : nombresInvitados) {
            listaInvitados.add(new Invitado(nombre, cajaMisteriosa));
        }

        // Crear anfitrión
        Anfitrion anfitrion = new Anfitrion(cajaMisteriosa);

        // Crear Colombo
        Colombo colombo = new Colombo("Colombo", listaInvitados, anfitrion);

        // Configurar el ExecutorService con un número fijo de hilos
        ExecutorService executor = Executors.newFixedThreadPool(listaInvitados.size() + 2);

        // Ejecutar los hilos
        executor.execute(anfitrion); // Ejecutar anfitrión

        for (Invitado invitado : listaInvitados) {
            executor.execute(invitado); // Ejecutar cada invitado
        }

        executor.execute(colombo); // Ejecutar Colombo

        // Cerrar el executor y esperar a que finalicen las tareas
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            System.err.println("Ocurrió un error: " + e.getMessage());
            Thread.currentThread().interrupt();
        }

        System.out.println("FIN DE PROGRAMA");
    }
}
