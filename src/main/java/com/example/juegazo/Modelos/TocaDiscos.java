package com.example.juegazo.Modelos;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
public class TocaDiscos {

    private boolean muteado = false;
    private Clip clip;

    public TocaDiscos() {}

    public boolean isMuteado() {
        return muteado;
    }

    public void setMuteado(boolean muteado) {
        this.muteado = muteado;
    }

    public Clip getClip() {
        return clip;
    }

    public void setClip(Clip clip) {
        this.clip = clip;
    }

    public void iniciar (String cancion){
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(cancion));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            clip.addLineListener(event -> {
                if (!muteado){
                    if (event.getType() == LineEvent.Type.STOP) {
                        clip.setMicrosecondPosition(0);
                        clip.start();
                    }
                }
            });

            clip.start();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void mutear() {
        if (muteado) {
            muteado = false;
            clip.setMicrosecondPosition(clip.getMicrosecondPosition() + 1000);
            clip.start();
        }else {
            muteado = true;
            clip.stop();

        }
    }

    public void detenerMusica() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }

}
