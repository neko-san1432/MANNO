package MANNO;

import MANNO.Monsters.*;
import MANNO.audio.AudioPlayer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;
import java.util.Objects;

public class Gameplay {
  static char[] capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray(),
  smallLetters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
  static int monsterLife = 0,
  currentMonsterLife = 0,
  monsterChoice = 0,
  scoring = 0,
  life = 2,
  showScore = 0;
  static ImageIcon monsterImg = null;
  static String theWord = "",
  monsterName = "",
  prevMonsterName = "",
  input = "",
  prevWord = "";
  static Words l = new Words();
  static boolean isIt = true;
  static AudioPlayer ap = new AudioPlayer();

  public static int getWordLength() {
    return theWord.length();
  }

  static String lowerCasingInput(String word) {
    char[] tmp = word.toCharArray();
    for (int i = 0; i < tmp.length; i++) {
      for (int j = 0; j < smallLetters.length; j++) {
        if (tmp[i] == capitalLetters[j] || tmp[i] == smallLetters[j]) {
          tmp[i] = smallLetters[j];
        }
      }
    }
    return new String(tmp);
  }

  static void setTempScore(int score) {
    showScore = score;
  }

  static int getScore() {
    return showScore;
  }

  static int calculateDamage(String word) {
    int score = 0;
    char[] tmp = word.toCharArray();
    for (char c : tmp) {
      for (int j = 0; j < 24; j++) {
        if (c == capitalLetters[j] || c == smallLetters[j]) {
          score += (j + 1);
        }
      }
    }
    return score;
  }

  public static void checkMonsterLife() {
    if (currentMonsterLife < 0) {
      killSound();
      setMonster();
    }
  }

  static void killSound() {
    switch (monsterName) {
      case "bampira" -> {
        try {
          ap.playBampira();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
          throw new RuntimeException(e);
        }
      }
      case "kapre" -> {
        try {
          ap.playKapre();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
          throw new RuntimeException(e);
        }
      }
      case "mananangal" -> {
        try {
          ap.playMaananangal();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
          throw new RuntimeException(e);
        }
      }
      case "mangkukulam" -> {
        try {
          ap.playMangkukulam();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
          throw new RuntimeException(e);
        }
      }
      case "sigbin" -> {
        try {
          ap.playSigbin();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
          throw new RuntimeException(e);
        }
      }
      case "tiktik" -> {
        try {
          ap.playTiktik();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
          throw new RuntimeException(e);
        }
      }
      case "tikbalang" -> {
        try {
          ap.playTikbalang();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
          throw new RuntimeException(e);
        }
      }

    }
  }

  static void setMonsterChoice() {
    monsterChoice = ((int) (Math.random() * 7)) % 7;
  }

  static void setMonster() {
    setMonsterChoice();
    switch (monsterChoice) {
      case 0 -> {
        Bampira b = new Bampira();
        b.setMonsterName();
        b.setMonsterLife();
        try {
          b.setMonsterImage();
        } catch (java.io.IOException e) {
          throw new RuntimeException(e);
        }
        monsterLife = b.getMonsterLife();
        monsterName = b.getMonsterName();
        currentMonsterLife = b.getMonsterLife();
        monsterImg = b.getMonsterImage();
      }
      case 1 -> {
        Tiktik t = new Tiktik();
        t.setMonsterLife();
        t.setMonsterName();
        try {
          t.setMonsterImage();
        } catch (java.io.IOException e) {
          throw new RuntimeException(e);
        }
        monsterLife = t.getMonsterLife();
        monsterName = t.getMonsterName();
        currentMonsterLife = t.getMonsterLife();
        monsterImg = t.getMonsterImage();
      }
      case 2 -> {
        Tikbalang tb = new Tikbalang();
        tb.setMonsterLife();
        tb.setMonsterName();
        try {
          tb.setMonsterImage();
        } catch (java.io.IOException e) {
          throw new RuntimeException(e);
        }
        monsterLife = tb.getMonsterLife();
        monsterName = tb.getMonsterName();
        currentMonsterLife = tb.getMonsterLife();
        monsterImg = tb.getMonsterImage();
      }
      case 3 -> {
        Kapre k = new Kapre();
        k.setMonsterLife();
        k.setMonsterName();
        try {
          k.setMonsterImage();
        } catch (java.io.IOException e) {
          throw new RuntimeException(e);
        }
        monsterLife = k.getMonsterLife();
        monsterName = k.getMonsterName();
        currentMonsterLife = k.getMonsterLife();
        monsterImg = k.getMonsterImage();
      }
      case 4 -> {
        Mananangal m = new Mananangal();
        m.setMonsterLife();
        m.setMonsterName();
        try {
          m.setMonsterImage();
        } catch (java.io.IOException e) {
          throw new RuntimeException(e);
        }
        monsterLife = m.getMonsterLife();
        monsterName = m.getMonsterName();
        currentMonsterLife = m.getMonsterLife();
        monsterImg = m.getMonsterImage();
      }
      case 5 -> {
        Sigbin s = new Sigbin();
        s.setMonsterLife();
        s.setMonsterName();
        try {
          s.setMonsterImage();
        } catch (java.io.IOException e) {
          throw new RuntimeException(e);
        }
        monsterLife = s.getMonsterLife();
        monsterName = s.getMonsterName();
        currentMonsterLife = s.getMonsterLife();
        monsterImg = s.getMonsterImage();
      }
      case 6 -> {
        Mangkukulam mkk = new Mangkukulam();
        mkk.setMonsterLife();
        mkk.setMonsterName();
        try {
          mkk.setMonsterImage();
        } catch (java.io.IOException e) {
          throw new RuntimeException(e);
        }
        monsterLife = mkk.getMonsterLife();
        monsterName = mkk.getMonsterName();
        currentMonsterLife = mkk.getMonsterLife();
        monsterImg = mkk.getMonsterImage();
      }
    }
    if (!Objects.equals(prevMonsterName, monsterName)) {
      Main.monsterImg.setIcon(monsterImg);
      Main.monsterName.setText(getMonsterName());
      Main.currentMLife.setText(String.valueOf(currentMonsterLife));
      Main.monsterLife.setText(String.valueOf(monsterLife));
      prevMonsterName = getMonsterName();
    } else {
      setMonster();
    }
  }

  static void setWord() {
    Words.setRandomIndexWord();
    theWord = l.getWordForGameplay();
    if (prevWord.equals(theWord)) {
      Words.setRandomIndexWord();
      setWord();
    }
    Main.currentWord.setText(theWord);
  }

  static void mainFunction() {
    checkMonsterLife();
    String in = lowerCasingInput(getInput());
    if (theWord.equals(in)) {
      int score = calculateDamage(getInput());
      currentMonsterLife -= score;
      Main.currentMLife.setText(String.valueOf(currentMonsterLife));
      isIt = true;
      scoring += score;
      setTempScore(scoring);
      Main.score.setText("Score " + scoring);
      Words.setRandomIndexWord();
      prevWord = theWord;
      setWord();
      checkMonsterLife();
    } else {
      isIt = false;
      if (Main.modes[2]) {
        try {
          Main.lives[life].setVisible(false);
          if (life > 0) {
            life--;
          } else {
            life -= 1;
            Main.lives[life].setVisible(false);
          }
        } catch (ArrayIndexOutOfBoundsException e) {
          Main.score.setText("Score " + scoring);
          Main.resultUI.setVisible(true);
          throw new OutOfLife("Game Over");
        }
      }
    }
  }

  static boolean isCorrect() {
    return isIt;
  }

  private static String getInput() {
    return input;
  }

  static void setInput(String in) {
    input = in;
  }

  static String getMonsterName() {
    return monsterName;
  }
}