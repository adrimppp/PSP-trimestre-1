import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sonido implements Runnable {
    @Override
    public void run() {
        try {
            // Ruta del archivo de sonido
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Sonido.class.getResource("mipistola.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

            // Mantener el programa en ejecución mientras se reproduce el sonido
            System.out.println("Reproduciendo sonido...");
            Thread.sleep(clip.getMicrosecondLength() / 1000);
            clip.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
