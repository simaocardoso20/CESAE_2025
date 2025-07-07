package Audio;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Audio {
    /**
     * Método para correr ficheiros áudio durante a execução do programa
     * *     * @param caminho Caminho para o ficheiro áudio
     */
    public static void playMusic(String caminho) {
        try {
            File audio = new File(caminho);
            if (audio.exists()) { //

                AudioInputStream audioInput = AudioSystem.getAudioInputStream(audio);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            } else {

            }
        } catch (Exception e) {
            System.out.println();
        }
    }
}