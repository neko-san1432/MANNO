package MANNO.audio;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


public class AudioPlayer{
    static String[] audioLocations = {
    "MANNO/audio/clack.wav",
    "MANNO/audio/gameplaymusic.wav",
    "MANNO/audio/kapre scream.wav",
    "MANNO/audio/mainmenu.wav",
    "MANNO/audio/mananangal scream.wav",
    "MANNO/audio/mangkukulam scream.wav",
    "MANNO/audio/sigbin scream.wav",
    "MANNO/audio/tikbalang scream.wav",
    "MANNO/audio/tiktik scream.wav",
    "MANNO/audio/vampire death.wav",
    "MANNO/audio/typing.wav"};
    public static Clip hovering, sfx, bg;
    static AudioInputStream ais;
    public void playHoverIn() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        ais = AudioSystem.getAudioInputStream(new File(audioLocations[0]).getAbsoluteFile());
        hovering = AudioSystem.getClip();
        hovering.open(ais);
        hovering.start();
    }
    public void playMaananangal() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        ais = AudioSystem.getAudioInputStream(new File(audioLocations[4]).getAbsoluteFile());
        sfx = AudioSystem.getClip();
        sfx.open(ais);
        sfx.start();
    }
    public void playMangkukulam() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        ais = AudioSystem.getAudioInputStream(new File(audioLocations[5]).getAbsoluteFile());
        sfx = AudioSystem.getClip();
        sfx.open(ais);
        sfx.start();
    }
    public void playTyping() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        ais = AudioSystem.getAudioInputStream(new File(audioLocations[10]).getAbsoluteFile());
        sfx = AudioSystem.getClip();
        sfx.open(ais);
        sfx.start();
    }
    public void playSigbin() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        ais = AudioSystem.getAudioInputStream(new File(audioLocations[6]).getAbsoluteFile());
        sfx = AudioSystem.getClip();
        sfx.open(ais);
        sfx.start();
    }
    public void playBampira() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        ais = AudioSystem.getAudioInputStream(new File(audioLocations[2]).getAbsoluteFile());
        sfx = AudioSystem.getClip();
        sfx.open(ais);
        sfx.start();
    }
    public void playTikbalang() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        ais = AudioSystem.getAudioInputStream(new File(audioLocations[7]).getAbsoluteFile());
        sfx = AudioSystem.getClip();
        sfx.open(ais);
        sfx.start();
    }
    public void playKapre() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        ais = AudioSystem.getAudioInputStream(new File(audioLocations[2]).getAbsoluteFile());
        sfx = AudioSystem.getClip();
        sfx.open(ais);
        sfx.start();
    }
    public void playTiktik() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        ais = AudioSystem.getAudioInputStream(new File(audioLocations[5]).getAbsoluteFile());
        sfx = AudioSystem.getClip();
        sfx.open(ais);
        sfx.start();
    }
    public void playBackgroundMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        ais = AudioSystem.getAudioInputStream(new File(audioLocations[3]).getAbsoluteFile());
        bg = AudioSystem.getClip();
        bg.open(ais);
        bg.start();
        bg.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void playBattleSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        ais = AudioSystem.getAudioInputStream(new File(audioLocations[1]).getAbsoluteFile());
        bg = AudioSystem.getClip();
        bg.open(ais);
        bg.start();
        bg.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
