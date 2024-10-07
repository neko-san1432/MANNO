package MANNO;

import MANNO.Images.ResizeImages;
import MANNO.audio.AudioPlayer;
import MANNO.data.Load;
import MANNO.data.Save;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

public class Main extends JFrame {
  private static final JPanel pauseUI = new JPanel();
  static Time t = new Time();
  static Color globalColor = Color.decode("#ff0000");
  static JTextArea invisibleTAre = new JTextArea();
  static JLabel currentMLife = new JLabel(),
  monsterLife = new JLabel(),
  slash = new JLabel("/"),
  countdown = new JLabel(""),
  minutes = new JLabel("3"),
  seconds = new JLabel("00"),
  colon = new JLabel(":"),
  monsterName = new JLabel(),
  life = new JLabel(),
  potion = new JLabel(), monsterImg = new JLabel(),
  score = new JLabel("Score 0"),
  currentWord = new JLabel(),
  incorrect = new JLabel("Try again"),
  pressSpace = new JLabel("press space!"),
  characterImage = new JLabel(),
  wordTyped = new JLabel(),
  pause_GameplayUI = new JLabel(),
  end = new JLabel("game over"),
  scoreEnding = new JLabel(),
  highScore = new JLabel();
  static JLayeredPane mainMenuUI = new JLayeredPane(),
  discoveryUI = new JLayeredPane(),
  resultUI = new JLayeredPane(),
  gameModeUI = new JLayeredPane(),
  gameplayUI = new JLayeredPane();
  static JLabel[] lives = {new JLabel(), new JLabel(), new JLabel()};
  static boolean[] modes = {false, false, false};
  static AudioPlayer ap = new AudioPlayer();
  char[] capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray(),
  smallLetters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
  ArrayList<Character> capsL = new ArrayList<>(),
  smallL = new ArrayList<>();
  float buttonsPercentageReferenceSize;
  Dimension dimension = getToolkit().getScreenSize();
  private final double s = dimension.getHeight() / 1.3;
  private final int size = (int) s;
  JLabel chooseMode = new JLabel(ResizeImages.getResizedChooseMode(size)),
  pauseBlur = new JLabel(ResizeImages.getResizedPauseBackground(size)),
  brandName = new JLabel(ResizeImages.getResizedManno(size)),
  wordsSection = new JLabel("<html>Filipino<br>words</html>"),
  monstersSection = new JLabel("<html>filipino<br>monsters</html>"),
  previous = new JLabel(ResizeImages.getResizedPrevious(size / 2)),
  next = new JLabel(ResizeImages.getResizedNext(size / 2)),
  background = new JLabel(),
  currentDiscovery = new JLabel(),
  currentDescription = new JLabel(),
  bg;
  JButton discovery_MainMenu = new JButton(ResizeImages.getResizedDiscovery(size)),
  exit_MainMenu = new JButton(ResizeImages.getResizedExit(size)),
  start_MainMenu = new JButton(ResizeImages.getResizedPlay(size)),
  timeRush_GameModeUI = new JButton(ResizeImages.getResizedTimeRush(size)),
  freeMode_GameModeUI = new JButton(ResizeImages.getResizedFreeMode(size)),
  hardMode_GameModeUI = new JButton(ResizeImages.getResizedHardMode(size)),
  return_GameModeUI = new JButton(ResizeImages.getResizedBack(size)),
  back_DiscoveryUI = new JButton(ResizeImages.getResizedReturn(size / 2)),
  resume_GameplayUI = new JButton(ResizeImages.getResizedResume(size)),
  menu_GameplayUI = new JButton(ResizeImages.getResizedHome(size)),
  restart_GameplayUI = new JButton(ResizeImages.getResizedRestart(size)),
  menu = new JButton(ResizeImages.getResizedHome(size)),
  restart = new JButton(ResizeImages.getResizedRestart(size));
  Countdown c;
  JLabel[] words = new JLabel[20],
  monsters = new JLabel[4];
  String current = "words";
  int maxIndexWords = 19, maxIndexMonsters = 3, minIndexWords = 0, minIndexMonsters = 0;
  Icon[] monster;

  {
    try {
      monster = new ImageIcon[]{ResizeImages.getResizedKapre(size), ResizeImages.getResizedBampira(size), ResizeImages.getResizedSigbin(size), ResizeImages.getResizedMananangal(size), ResizeImages.getResizedMangkukulam(size), ResizeImages.getResizedTikbalang(size), ResizeImages.getResizedTiktik(size)};
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    for (int i = 0; i < monsters.length; i++) {
      monsters[i] = new JLabel(monster[i]);
    }
    for (int i = 0; i < words.length; i++) {
      words[i] = new JLabel(Words.getWord(i));
    }

    try {
      bg = new JLabel(ResizeImages.getResizedMainMenu(size));
      bg.setSize(size, size);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    try {
      pause_GameplayUI.setIcon(ResizeImages.getResizedPause(size / 2));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public Main() throws IOException {
    setTitle("Manno");
    setSize(size, size);
    setLocationRelativeTo(null);
    setResizable(false);
    setLayout(null);
    addWindowFocusListener(new WindowAdapter() {
      public void windowGainedFocus(WindowEvent e) {
        invisibleTAre.requestFocusInWindow();
      }
    });
    invisibleTAre.setFocusable(true);
    transferFocus();
    invisibleTAre.requestFocusInWindow();
    gameplayUI.transferFocus();
    System.out.println(invisibleTAre.hasFocus());
    setAll(size, size);
    add(resultUI, 0);
    add(pauseUI);
    add(gameplayUI);
    add(gameModeUI);
    add(mainMenuUI);
    add(discoveryUI);
    add(bg);
    try {
      ap.playBackgroundMusic();
    } catch (UnsupportedAudioFileException | LineUnavailableException e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      try {
        new Main().setVisible(true);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    });
  }

  private static void setGameplayElementsVisibility(boolean b) {
    monsterImg.setVisible(b);
    minutes.setVisible(b);
    seconds.setVisible(b);
    colon.setVisible(b);
    pause_GameplayUI.setVisible(b);
    monsterName.setVisible(b);
    currentWord.setVisible(b);
    score.setVisible(b);
    life.setVisible(b);
    potion.setVisible(b);
    wordTyped.setVisible(b);
    slash.setVisible(b);
    currentMLife.setVisible(b);
    monsterLife.setVisible(b);
    invisibleTAre.setEnabled(b);
    characterImage.setVisible(b);
    highScore.setVisible(b);
    if (modes[2]) {
      lives[0].setVisible(b);
      lives[1].setVisible(b);
      lives[2].setVisible(b);
    }
  }

  static void clear() {
    invisibleTAre.setText("");
    invisibleTAre.setEnabled(false);
    wordTyped.setText("");
    pressSpace.setVisible(false);
    incorrect.setVisible(false);
  }

  void setFocusable() {
    invisibleTAre.setFocusable(true);
    characterImage.setFocusable(false);
    background.setFocusable(false);
    life.setFocusable(false);
    currentMLife.setFocusable(false);
    currentWord.setFocusable(false);
    monsterLife.setFocusable(false);
    countdown.setFocusable(false);
    score.setFocusable(false);
    monsterName.setFocusable(false);
    monsterImg.setFocusable(false);
    slash.setFocusable(false);
    pressSpace.setFocusable(false);
    incorrect.setFocusable(false);
    pauseBlur.setFocusable(false);
    seconds.setFocusable(false);
    colon.setFocusable(false);
    minutes.setFocusable(false);
  }

  private void setAll(int width, int height) {
    setDefault();
    setCharReference();
    setButtonPropertiesForMainMenuUI(height);
    setLabelPropertiesForMainMenu(width, height);
    setMainMenuUI(width, height);
    setDiscoveryUI(width, height);
    setButtonPropertiesForDiscoveryUI(width, height);
    setButtonPropertiesForPauseUI(width, height);
    setPauseUI(width, height);
    setGameModeUI(width, height);
    setButtonsGameModeUI(height);
    setLabelGameModeUI(width, height);
    setResultUI(width, height);
    setArea(width, height);
    setLabelsForGameplay(width, height);
    setTextArea(width, height);
    setPauseUI(width, height);
    setLabelsForResultUI(width, height);
    setButtonsForResultUI(width, height);
    setLives(width, height);
  }

  private void setDefault() {
    discoveryUI.setVisible(false);
    pauseUI.setVisible(false);
    gameModeUI.setVisible(false);
    gameplayUI.setVisible(false);
    mainMenuUI.setVisible(true);
    resultUI.setVisible(false);
  }

  private void setMainMenuUI(int width, int height) {
    mainMenuUI.setSize(width, height);
    mainMenuUI.setLayout(null);
    mainMenuUI.add(brandName, JLayeredPane.DRAG_LAYER);
    mainMenuUI.add(discovery_MainMenu, JLayeredPane.DRAG_LAYER);
    mainMenuUI.add(exit_MainMenu, JLayeredPane.DRAG_LAYER);
    mainMenuUI.add(start_MainMenu, JLayeredPane.DRAG_LAYER);
  }

  private void setButtonPropertiesForMainMenuUI(int size) {
    buttonsPercentageReferenceSize = (float) 150 / 590;
    start_MainMenu.setSize((int) (size * buttonsPercentageReferenceSize), size / 10);
    start_MainMenu.setLocation((int) (size / 2.8), (int) (size / 2.5));
    start_MainMenu.setContentAreaFilled(false);
    start_MainMenu.setBorderPainted(false);
    start_MainMenu.setBorder(null);
    start_MainMenu.setFocusable(false);
    start_MainMenu.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        mainMenuUI.setVisible(false);
        gameModeUI.setVisible(true);
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        try {
          start_MainMenu.setIcon(ResizeImages.getResizedPlay_enlarged(size));
          ap.playHoverIn();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException ex) {
          throw new RuntimeException(ex);
        }
      }

      @Override
      public void mouseExited(MouseEvent e) {
        try {
          start_MainMenu.setIcon(ResizeImages.getResizedPlay(size));

        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }
    });

    buttonsPercentageReferenceSize = (float) 140 / 590;
    discovery_MainMenu.setSize((int) (buttonsPercentageReferenceSize * size), size / 10);
    discovery_MainMenu.setLocation((int) (size / 2.73), (size / 2));
    discovery_MainMenu.setContentAreaFilled(false);
    discovery_MainMenu.setBorderPainted(false);
    discovery_MainMenu.setBorder(null);
    discovery_MainMenu.setFocusable(false);
    discovery_MainMenu.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        mainMenuUI.setVisible(false);
        discoveryUI.setVisible(true);
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        try {
          discovery_MainMenu.setIcon(ResizeImages.getResizedDiscovery_enlarged(size));
          ap.playHoverIn();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException ex) {
          throw new RuntimeException(ex);
        }
      }

      @Override
      public void mouseExited(MouseEvent e) {
        try {
          discovery_MainMenu.setIcon(ResizeImages.getResizedDiscovery(size));

        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }
    });
    buttonsPercentageReferenceSize = (float) 140 / 590;
    exit_MainMenu.setSize((int) (buttonsPercentageReferenceSize * size), size / 10);
    exit_MainMenu.setLocation((int) (size / 2.73), (int) (size / 1.65) + 5);
    exit_MainMenu.setContentAreaFilled(false);
    exit_MainMenu.setBorderPainted(false);
    exit_MainMenu.setBorder(null);
    exit_MainMenu.setFocusable(false);
    exit_MainMenu.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        AudioPlayer.bg.stop();
        AudioPlayer.sfx.stop();
        AudioPlayer.hovering.stop();
        System.exit(0);

      }

      @Override
      public void mouseEntered(MouseEvent e) {
        try {
          exit_MainMenu.setIcon(ResizeImages.getResizedExit_enlarged(size));
          ap.playHoverIn();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException ex) {
          throw new RuntimeException(ex);
        }
      }

      @Override
      public void mouseExited(MouseEvent e) {
        try {
          exit_MainMenu.setIcon(ResizeImages.getResizedExit(size));

        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }
    });
  }

  private void setLabelPropertiesForMainMenu(int width, int height) {
    brandName.setSize(width, (int) (height / 2.6));
    brandName.setLocation(0, 0);
  }

  private void setGameModeUI(int width, int height) {
    gameModeUI.setSize(width, height);
    gameModeUI.setLayout(null);
    gameModeUI.add(freeMode_GameModeUI);
    gameModeUI.add(return_GameModeUI);
    gameModeUI.add(hardMode_GameModeUI);
    gameModeUI.add(timeRush_GameModeUI);
    gameModeUI.add(chooseMode);
  }

  private void setButtonsGameModeUI(int size) {
    buttonsPercentageReferenceSize = (float) 175 / 590;
    freeMode_GameModeUI.setSize((int) (size * buttonsPercentageReferenceSize) + 5, size / 10);
    freeMode_GameModeUI.setLocation((int) (size / 3.01), (int) (size / 2.76));
    freeMode_GameModeUI.setContentAreaFilled(false);
    freeMode_GameModeUI.setBorderPainted(false);
    freeMode_GameModeUI.setBorder(null);
    freeMode_GameModeUI.setFocusable(false);
    freeMode_GameModeUI.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        modes[0] = true;
        gameModeUI.setVisible(false);
        setFreeModeGameplay(size, size);
        gameplayUI.setVisible(true);
        invisibleTAre.requestFocusInWindow();
        gameplayUI.transferFocus();
        AudioPlayer.bg.stop();
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        try {
          freeMode_GameModeUI.setIcon(ResizeImages.getResizedFreeMode_enlarged(size));
          ap.playHoverIn();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException ex) {
          throw new RuntimeException(ex);
        }
      }

      @Override
      public void mouseExited(MouseEvent e) {
        try {
          freeMode_GameModeUI.setIcon(ResizeImages.getResizedFreeMode(size));
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }
    });

    buttonsPercentageReferenceSize = (float) 180 / 590;
    timeRush_GameModeUI.setSize((int) (size * buttonsPercentageReferenceSize) + 5, size / 10);
    timeRush_GameModeUI.setLocation((int) (size / 3.06), (int) (size / 2.2));
    timeRush_GameModeUI.setContentAreaFilled(false);
    timeRush_GameModeUI.setBorderPainted(false);
    timeRush_GameModeUI.setBorder(null);
    timeRush_GameModeUI.setFocusable(false);
    timeRush_GameModeUI.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        modes[1] = true;
        gameModeUI.setVisible(false);
        setTimeRushGameplay(size, size);
        gameplayUI.setVisible(true);
        invisibleTAre.requestFocusInWindow();
        gameplayUI.transferFocus();
        AudioPlayer.bg.stop();
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        try {
          timeRush_GameModeUI.setIcon(ResizeImages.getResizedTimeRush_enlarged(size));
          ap.playHoverIn();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException ex) {
          throw new RuntimeException(ex);
        }
      }

      @Override
      public void mouseExited(MouseEvent e) {
        try {
          timeRush_GameModeUI.setIcon(ResizeImages.getResizedTimeRush(size));

        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }
    });

    hardMode_GameModeUI.setSize(size / 4, size / 10);
    hardMode_GameModeUI.setLocation((int) (size / 2.73), (int) (size / 1.8));
    hardMode_GameModeUI.setContentAreaFilled(false);
    hardMode_GameModeUI.setBorderPainted(false);
    hardMode_GameModeUI.setFocusable(false);
    hardMode_GameModeUI.setBorder(null);
    hardMode_GameModeUI.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        modes[2] = true;
        gameModeUI.setVisible(false);
        setHardModeGameplay(size);
        gameplayUI.setVisible(true);
        invisibleTAre.requestFocusInWindow();
        gameplayUI.transferFocus();
        AudioPlayer.bg.stop();
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        try {
          hardMode_GameModeUI.setIcon(ResizeImages.getResizedHardMode_enlarged(size));
          ap.playHoverIn();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException ex) {
          throw new RuntimeException(ex);
        }
      }

      @Override
      public void mouseExited(MouseEvent e) {
        try {
          hardMode_GameModeUI.setIcon(ResizeImages.getResizedHardMode(size));
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }
    });

    buttonsPercentageReferenceSize = (float) 150 / 590;
    return_GameModeUI.setSize((int) (buttonsPercentageReferenceSize * size), 80);
    return_GameModeUI.setLocation(size / (size - 70), (int) (size / 1.2));
    return_GameModeUI.setContentAreaFilled(false);
    return_GameModeUI.setBorderPainted(false);
    return_GameModeUI.setFocusable(false);
    return_GameModeUI.setBorder(null);
    return_GameModeUI.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        gameModeUI.setVisible(false);
        mainMenuUI.setVisible(true);
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        try {
          return_GameModeUI.setIcon(ResizeImages.getResizedReturn_enlarged(size));
          ap.playHoverIn();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException ex) {
          throw new RuntimeException(ex);
        }
      }

      @Override
      public void mouseExited(MouseEvent e) {
        try {
          return_GameModeUI.setIcon(ResizeImages.getResizedBack(size));
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }
    });
  }

  private void setLabelGameModeUI(int width, int height) {
    chooseMode.setSize(width, (int) (height / 4.5));
    chooseMode.setLocation(0, height / 14);
  }

  private void setPauseUI(int width, int height) {
    pauseUI.setSize(width, (int) (height / 1.5));
    pauseUI.setLayout(null);
    pauseUI.setLocation(0, (int) (width / 6.8));
    pauseUI.setBackground(Color.black);
    pauseUI.add(resume_GameplayUI);
    pauseUI.add(restart_GameplayUI);
    pauseUI.add(menu_GameplayUI);
  }

  private void setButtonPropertiesForPauseUI(int width, int height) {
    menu_GameplayUI.setSize((int) (width / 6.6), (int) (height / 6.6));
    menu_GameplayUI.setBackground(Color.gray);
    menu_GameplayUI.setLocation((int) (width / 1.46), (int) (height / 3.9));
    menu_GameplayUI.setOpaque(false);
    menu_GameplayUI.setBorderPainted(false);
    menu_GameplayUI.setFocusable(false);
    menu_GameplayUI.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        gameplayUI.setVisible(false);
        pauseUI.setVisible(false);
        mainMenuUI.setVisible(true);
        pauseBlur.setVisible(false);
        t.pause();
        t.reset();
        if (modes[0]) {
          modes[0] = false;
        }
        if (modes[1]) {
          modes[1] = false;
        }
        if (modes[2]) {
          modes[2] = false;
        }
        try {
          bg.setIcon(ResizeImages.getResizedMainMenu(height));
        } catch (IOException t) {
          throw new RuntimeException(t);
        }
        try {
          AudioPlayer.bg.stop();
          ap.playBackgroundMusic();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
          throw new RuntimeException(ex);
        }
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        try {
          menu_GameplayUI.setIcon(ResizeImages.getResizedHome_Enlarged(height));
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }

      @Override
      public void mouseExited(MouseEvent e) {
        try {
          menu_GameplayUI.setIcon(ResizeImages.getResizedHome(height));
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }
    });

    resume_GameplayUI.setSize((int) (width / 6.6), (int) (height / 6.6));
    resume_GameplayUI.setBackground(Color.gray);
    resume_GameplayUI.setLocation((int) (width / 8.6), (int) (height / 3.9));
    resume_GameplayUI.setOpaque(false);
    resume_GameplayUI.setFocusable(false);
    resume_GameplayUI.setBorderPainted(false);
    resume_GameplayUI.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        play();
        AudioPlayer.bg.start();
        t.start();
        pauseBlur.setVisible(false);
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        try {
          resume_GameplayUI.setIcon(ResizeImages.getResizedResume_Enlarged(height));
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }

      @Override
      public void mouseExited(MouseEvent e) {
        try {
          resume_GameplayUI.setIcon(ResizeImages.getResizedResume(height));
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }
    });

    restart_GameplayUI.setSize((int) (width / 6.6), (int) (height / 6.6));
    restart_GameplayUI.setBackground(Color.gray);
    restart_GameplayUI.setLocation((int) (width / 2.47), (int) (height / 3.9));
    restart_GameplayUI.setOpaque(false);
    resume_GameplayUI.setBorderPainted(false);
    restart_GameplayUI.setFocusable(false);
    restart_GameplayUI.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        AudioPlayer.bg.stop();
        setGameplayElementsVisibility(false);
        toBeRestarted();
        pressSpace.setVisible(false);
        pauseBlur.setVisible(false);
        countdown.setVisible(true);
        pauseUI.setVisible(false);
        seconds.setText("00");
        minutes.setText("3");
        invisibleTAre.setText("");
        wordTyped.setText("");
        t.reset();
        c = new Countdown();
        c.start();
        if (c.isAlive()) {
          t.start();
        }
        try {
          ap.playBattleSound();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
          throw new RuntimeException(ex);
        }
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        try {
          restart_GameplayUI.setIcon(ResizeImages.getResizedRestart_Enlarged(height));
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }

      @Override
      public void mouseExited(MouseEvent e) {
        try {
          restart_GameplayUI.setIcon(ResizeImages.getResizedRestart(height));
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }
    });
  }

  private void setTimeRushGameplay(int width, int height) {
    clear();
    Gameplay.setMonsterChoice();
    Words.setRandomIndexWord();
    Gameplay.setWord();
    Gameplay.setMonster();
    try {
      bg.setIcon(ResizeImages.getResizedGamePlayBG(height));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    gameplayUI.removeAll();
    gameplayUI.setSize(width, height);
    gameplayUI.setBackground(Color.black);
    setGameplayElementsVisibility(false);
    countdown.setVisible(true);
    c = new Countdown();
    c.start();
    pauseBlur.setVisible(false);
    pauseBlur.setVisible(false);
    gameplayUI.setLayout(null);
    setFocusable();
    gameplayUI.add(invisibleTAre, JLayeredPane.DRAG_LAYER);
    gameplayUI.add(monsterImg, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(countdown, JLayeredPane.MODAL_LAYER);
    gameplayUI.add(pauseBlur, JLayeredPane.POPUP_LAYER);
    gameplayUI.add(minutes, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(seconds, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(colon, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(pause_GameplayUI, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(incorrect, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(pressSpace, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(monsterName, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(highScore, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(score, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(currentWord, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(slash, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(monsterLife, JLayeredPane.PALETTE_LAYER);
    highScore.setText("HScore " + Load.getPrevHighScoreTimeRush());
    gameplayUI.add(currentMLife, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(background, JLayeredPane.DEFAULT_LAYER);
    gameplayUI.add(characterImage, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(wordTyped, JLayeredPane.PALETTE_LAYER);
    score.setText("score ");
    Gameplay.scoring = 0;
    invisibleTAre.requestFocus();
  }

  private void setFreeModeGameplay(int width, int height) {
    clear();
    Gameplay.setMonsterChoice();
    Words.setRandomIndexWord();
    Gameplay.setWord();
    Gameplay.setMonster();
    try {
      bg.setIcon(ResizeImages.getResizedGamePlayBG(height));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    c = new Countdown();
    c.start();
    gameplayUI.removeAll();
    gameplayUI.setSize(width, height);
    gameplayUI.setBackground(Color.black);
    setGameplayElementsVisibility(false);
    countdown.setVisible(true);
    pauseBlur.setVisible(false);
    gameplayUI.setLayout(null);
    setFocusable();
    gameplayUI.add(invisibleTAre, JLayeredPane.DRAG_LAYER);
    gameplayUI.add(monsterImg, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(countdown, JLayeredPane.MODAL_LAYER);
    gameplayUI.add(pauseBlur, JLayeredPane.POPUP_LAYER);
    gameplayUI.add(pause_GameplayUI, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(incorrect, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(pressSpace, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(monsterName, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(score, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(currentWord, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(slash, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(monsterLife, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(currentMLife, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(background, JLayeredPane.DEFAULT_LAYER);
    gameplayUI.add(characterImage, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(wordTyped, JLayeredPane.PALETTE_LAYER);
    score.setText("score ");
    Gameplay.scoring = 0;
    gameplayUI.add(highScore, JLayeredPane.PALETTE_LAYER);
    invisibleTAre.requestFocus();
  }

  private void setHardModeGameplay(int size) {
    clear();
    Gameplay.setMonsterChoice();
    Words.setRandomIndexWord();
    Gameplay.setWord();
    Gameplay.setMonster();
    try {
      bg.setIcon(ResizeImages.getResizedGamePlayBG(size));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    gameplayUI.removeAll();

    setGameplayElementsVisibility(false);
    countdown.setVisible(true);
    c = new Countdown();
    c.start();

    pauseBlur.setVisible(false);

    gameplayUI.add(invisibleTAre, JLayeredPane.DRAG_LAYER);
    gameplayUI.setSize(size, size);
    gameplayUI.setLayout(null);
    setFocusable();
    gameplayUI.add(pause_GameplayUI, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(monsterImg, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(countdown, JLayeredPane.MODAL_LAYER);
    gameplayUI.add(pauseBlur, JLayeredPane.POPUP_LAYER);
    gameplayUI.add(minutes, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(seconds, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(colon, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(highScore, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(incorrect, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(pressSpace, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(monsterName, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(score, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(currentWord, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(slash, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(monsterLife, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(currentMLife, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(background, JLayeredPane.DEFAULT_LAYER);
    gameplayUI.add(characterImage, JLayeredPane.PALETTE_LAYER);
    gameplayUI.add(wordTyped, JLayeredPane.PALETTE_LAYER);
    highScore.setText("HScore " + Load.getPrevHighScoreHard());
    Gameplay.scoring = 0;
    addLife();
    invisibleTAre.requestFocus();
  }

  private void setLabelsForGameplay(int width, int height) {
    minutes.setSize((int) (width / 4.916), (int) (height / 11.8));
    minutes.setLocation((int) (width / 1.26), 1);
    minutes.setVisible(true);
    minutes.setFont(new Font("who asks satan", Font.PLAIN, 50));
    minutes.setForeground(globalColor);
    minutes.setVisible(false);

    colon.setSize((int) (width / 4.916), (int) (height / 11.8));
    colon.setLocation((int) (width / 1.2), -7);
    colon.setVisible(true);
    colon.setFont(new Font("Times New Roman", Font.PLAIN, 50));
    colon.setForeground(globalColor);
    colon.setVisible(false);

    seconds.setSize((int) (width / 4.916), (int) (height / 11.8));
    seconds.setLocation((int) (width / 1.15), 1);
    seconds.setVisible(true);
    seconds.setFont(new Font("who asks satan", Font.PLAIN, 50));
    seconds.setForeground(globalColor);
    seconds.setVisible(false);

    countdown.setSize(width, height);
    countdown.setLocation(0, 0);
    countdown.setFont(new Font("who asks satan", Font.PLAIN, 200));
    countdown.setForeground(globalColor);
    countdown.setHorizontalAlignment(JLabel.CENTER);
    countdown.setVerticalAlignment(JLabel.CENTER);

    pauseBlur.setSize(width, height);
    pauseBlur.setLocation(0, 0);
    pauseBlur.setVisible(false);

    incorrect.setSize((int) (width / 6.8), height / 20);
    incorrect.setLocation((int) (width / 2.34), (int) (height / 1.16));
    incorrect.setFont(new Font("who asks satan", Font.PLAIN, 25));
    incorrect.setForeground(globalColor);
    incorrect.setVisible(false);

    pressSpace.setSize(width / 5, height / 20);
    pressSpace.setLocation((int) (width / 2.5), (int) (height / 1.24));
    pressSpace.setFont(new Font("who asks satan", Font.PLAIN, 25));
    pressSpace.setForeground(globalColor);
    pressSpace.setVisible(false);

    monsterName.setSize((int) (width / 3.5), height / 18);
    monsterName.setLocation((int) (width / 1.78), height / 8);
    monsterName.setFont(new Font("who asks satan", Font.PLAIN, 33));
    monsterName.setForeground(globalColor);
    monsterName.setHorizontalAlignment(JLabel.CENTER);
    monsterName.setVerticalAlignment(JLabel.CENTER);

    slash.setSize((int) (width / 5.6), height / 18);
    slash.setLocation((int) (width / 1.63), (int) (height / 5.5));
    slash.setFont(new Font("Times New Roman", Font.PLAIN, 20));
    slash.setForeground(globalColor);
    slash.setHorizontalAlignment(JLabel.CENTER);
    slash.setVerticalAlignment(JLabel.CENTER);

    monsterLife.setSize((int) (width / 10.7), height / 18);
    monsterLife.setLocation((int) (width / 1.45), (int) (height / 5.5));
    monsterLife.setFont(new Font("who asks satan", Font.PLAIN, 20));
    monsterLife.setForeground(globalColor);
    monsterLife.setHorizontalAlignment(JLabel.CENTER);
    monsterLife.setVerticalAlignment(JLabel.CENTER);

    currentMLife.setSize((int) (width / 10.7), height / 18);
    currentMLife.setLocation((int) (width / 1.6), (int) (height / 5.5));
    currentMLife.setFont(new Font("who asks satan", Font.PLAIN, 20));
    currentMLife.setForeground(globalColor);
    currentMLife.setHorizontalAlignment(JLabel.CENTER);
    currentMLife.setVerticalAlignment(JLabel.CENTER);

    monsterImg.setSize((int) (width / 5.6), (int) (height / 3.5));
    monsterImg.setLocation((int) (width / 1.6), height / 4);
    monsterImg.setHorizontalAlignment(JLabel.CENTER);
    monsterImg.setVerticalAlignment(JLabel.BOTTOM);

    highScore.setSize((int) (width / 4.5), height / 18);
    highScore.setLocation((int) (width / 1.3), (int) (height / 1.14));
    highScore.setFont(new Font("who asks satan", Font.PLAIN, 25));
    highScore.setForeground(globalColor);

    score.setSize((int) (width / 5.6), height / 18);
    score.setLocation(20, (int) (height / 1.14));
    score.setFont(new Font("who asks satan", Font.PLAIN, 25));
    score.setForeground(globalColor);

    currentWord.setSize(width / 3, height / 18);
    currentWord.setLocation((int) (width / 3.1), (int) (height / 1.62));
    currentWord.setFont(new Font("who asks satan", Font.PLAIN, 25));
    currentWord.setHorizontalAlignment(JLabel.CENTER);
    currentWord.setVerticalAlignment(JLabel.CENTER);
    currentWord.setForeground(globalColor);

    background.setSize(width, (height / 2));
    background.setLocation(0, (height / 10));
    background.setOpaque(true);
    try {
      background.setIcon(ResizeImages.getResizedBackground(height));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    background.setBackground(Color.black);

    characterImage.setSize((int) (width / 5.6), (int) (height / 3.5));
    characterImage.setLocation(width / 10, height / 4);
    try {
      characterImage.setIcon(ResizeImages.getResizedMC(height));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    characterImage.setHorizontalAlignment(JLabel.CENTER);
    characterImage.setVerticalAlignment(JLabel.BOTTOM);

    pause_GameplayUI.setSize((int) (width * 0.0847457627118), (int) (height * 0.0847457627118));
    pause_GameplayUI.setLocation(0, 0);
    pause_GameplayUI.setBorder(null);
    pause_GameplayUI.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        t.pause();
        AudioPlayer.bg.stop();
        pause();
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        try {
          pause_GameplayUI.setIcon(ResizeImages.getResizedPause_Enlarged(height / 2));
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }

      @Override
      public void mouseExited(MouseEvent e) {
        try {
          pause_GameplayUI.setIcon(ResizeImages.getResizedPause(height / 2));
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }
    });
    pause_GameplayUI.setFocusable(false);
  }

  private void toBeRestarted() {
    if (modes[0]) {
      setFreeModeGameplay(size, size);
    }
    if (modes[1]) {
      setTimeRushGameplay(size, size);
    }
    if (modes[2]) {
      setHardModeGameplay(size);
      Main.lives[0].setVisible(true);
      Main.lives[1].setVisible(true);
      Main.lives[2].setVisible(true);
    }
  }

  private void setTextArea(int width, int height) {
    invisibleTAre.setSize(100, 100);
    invisibleTAre.setLocation(width, height);
    invisibleTAre.setFocusable(true);
    invisibleTAre.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        if (keyChecking(e) && wordTyped.getText().length() < Gameplay.getWordLength()) {
          String prevWord = wordTyped.getText();
          prevWord += e.getKeyChar();
          wordTyped.setText(prevWord);
          try {
            ap.playTyping();
          } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            throw new RuntimeException(ex);
          }
        }
        if (wordTyped.getText().length() == Gameplay.getWordLength()) {
          pressSpace.setVisible(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE && wordTyped.getText().length() == Gameplay.getWordLength()) {
          pressSpace.setVisible(false);
          Gameplay.setInput(wordTyped.getText());
          Gameplay.mainFunction();
          Gameplay.checkMonsterLife();
          invisibleTAre.setText("");
          wordTyped.setText("");
          if (!Gameplay.isCorrect()) {
            Delay d = new Delay();
            d.start();
          }
        }
      }
    });
  }

  private void setCharReference() {
    for (Character k : capitalLetters) {
      capsL.add(k);
    }
    for (Character k : smallLetters) {
      smallL.add(k);
    }
  }

  private boolean keyChecking(KeyEvent e) {
    return capsL.contains(e.getKeyChar()) || smallL.contains(e.getKeyChar());
  }

    private void setLives(int width, int height) {
      try {
        lives[0].setIcon(ResizeImages.getResizedLife(height));
        lives[1].setIcon(ResizeImages.getResizedLife(height));
        lives[2].setIcon(ResizeImages.getResizedLife(height));
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
      lives[0].setSize((int) (width / 32.8), (int) (height / 17.9));
      lives[0].setLocation((width / 21), (int) (height / 1.62));

      lives[1].setSize((int) (width / 32.8), (int) (height / 17.9));
      lives[1].setLocation((int) (width / 13.36), (int) (height / 1.62));

      lives[2].setSize((int) (width / 32.8), (int) (height / 17.9));
      lives[2].setLocation((width / 10), (int) (height / 1.62));
    }

  private void addLife() {
    gameplayUI.add(lives[0], JLayeredPane.POPUP_LAYER);
    gameplayUI.add(lives[1], JLayeredPane.POPUP_LAYER);
    gameplayUI.add(lives[2], JLayeredPane.POPUP_LAYER);
  }

  private void setArea(int width, int height) {
    wordTyped.setSize(width, height / 8);
    wordTyped.setLocation((int) -(width * 0.0169491525423729), (int) (height / 1.4));
    wordTyped.setFont(new Font("who asks satan", Font.PLAIN, 75));
    wordTyped.setForeground(globalColor);
    wordTyped.setHorizontalAlignment(JLabel.CENTER);
    wordTyped.setVerticalAlignment(JLabel.CENTER);
    wordTyped.setFocusable(false);
  }

  private void setResultUI(int width, int height) {
    resultUI.setSize(width, height);
    resultUI.setLocation(0, 0);
    resultUI.setLayout(null);
    resultUI.add(restart);
    resultUI.add(menu);
    resultUI.add(end);
    resultUI.add(scoreEnding);
    resultUI.setBackground(Color.black);
  }

  private void setLabelsForResultUI(int width, int height) {
    end.setSize(width / 2, height / 6);
    end.setLocation(width / 4, height / 13);
    end.setHorizontalAlignment(JLabel.CENTER);
    end.setVerticalAlignment(JLabel.CENTER);
    end.setForeground(globalColor);
    end.setFont(new Font("who asks satan", Font.PLAIN, 80));

    scoreEnding.setSize(width / 2, height / 6);
    scoreEnding.setLocation(width / 4, height / 4);
    scoreEnding.setHorizontalAlignment(JLabel.CENTER);
    scoreEnding.setVerticalAlignment(JLabel.CENTER);
    scoreEnding.setForeground(globalColor);
    scoreEnding.setFont(new Font("who asks satan", Font.PLAIN, 40));
  }

  private void setButtonsForResultUI(int width, int height) {
    menu.setSize((int) (width / 6.6), (int) (height / 6.68));
    menu.setLocation((int) (width / 1.66), height / 2);
    menu.setContentAreaFilled(false);
    menu.setBorderPainted(false);
    menu.setBorder(null);
    menu.setOpaque(false);
    menu.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        gameplayUI.setVisible(false);
        mainMenuUI.setVisible(true);
        resultUI.setVisible(false);
        try {
          bg.setIcon(ResizeImages.getResizedMainMenu(size));
          AudioPlayer.bg.stop();
          ap.playBackgroundMusic();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException ex) {
          throw new RuntimeException(ex);
        }
      }
    });

    restart.setSize((int) (width / 6.6), (int) (height / 6.6));
    restart.setLocation(width / 4, height / 2);
    restart.setContentAreaFilled(false);
    restart.setBorderPainted(false);
    restart.setBorder(null);
    restart.setOpaque(false);
    restart.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        setGameplayElementsVisibility(false);
        toBeRestarted();
        countdown.setVisible(true);
        pauseUI.setVisible(false);
        seconds.setText("00");
        minutes.setText("3");
        invisibleTAre.setText("");
        wordTyped.setText("");
        t.reset();
        c = new Countdown();
        c.start();
        if (c.isAlive()) {
          t.start();
        }
        resultUI.setVisible(false);
      }
    });
  }

  private void setDiscoveryUI(int width, int height) {
    setWordVisibilities();
    setLabelPropertiesForDiscoveryUI(width, height);
    discoveryUI.setSize(width, height);
    discoveryUI.setLayout(null);
    discoveryUI.add(back_DiscoveryUI);
    stream(monsters).forEach(jLabel -> discoveryUI.add(jLabel));
    stream(words).forEach(word -> discoveryUI.add(word));
    discoveryUI.add(wordsSection);
    discoveryUI.add(monstersSection);
    discoveryUI.add(currentDiscovery);
    discoveryUI.add(currentDescription);
    discoveryUI.add(previous);
    discoveryUI.add(next);
    next.requestFocusInWindow();
    previous.requestFocusInWindow();
  }

  private void setLabelPropertiesForDiscoveryUI(int width, int height) {
    wordsSection.setSize((int) (width * 0.16949153), (int) (height * 0.084745765));
    wordsSection.setLocation(width / 4, 10);
    wordsSection.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        if (!(Objects.equals(current, "words"))) {
          current = "words";
          setWordVisibilities();
        }
      }
    });
    wordsSection.setForeground(globalColor);
    wordsSection.setFont(new Font("who asks satan", Font.PLAIN, 17));
    wordsSection.setVerticalAlignment(JLabel.CENTER);
    wordsSection.setHorizontalAlignment(JLabel.CENTER);

    monstersSection.setSize((int) (width * 0.16949153), (int) (height * 0.084745765));
    monstersSection.setLocation((int) (width / 1.8), 10);
    monstersSection.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        if (!(current.equals("monsters"))) {
          current = "monsters";
          setMonsterVisibilities();
        }
      }
    });
    monstersSection.setForeground(globalColor);
    monstersSection.setFont(new Font("who asks satan", Font.PLAIN, 17));
    monstersSection.setHorizontalAlignment(JLabel.CENTER);
    monstersSection.setVerticalAlignment(JLabel.CENTER);
    int count1 = 0, wordHeight = (int) (height * 0.06779661), wordWidth = (int) (width * 0.15762712), ten = (int) (width * 0.016949152);
    int h = (int) (height * 0.22033899), count = 0, monsterHeight = (int) (height * 0.2542372881355), monsterWidth = (int) (height * 0.2542372881355);
    int w = (int) (width * 0.1016949152);
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        monsters[count].setSize(monsterWidth, monsterHeight);
        monsters[count].setLocation((monsterWidth + ten) * j + w, (monsterHeight + ten) * i + h);
        int finalCount1 = count;
        monsters[count].addMouseListener(new MouseAdapter() {
          @Override
          public void mousePressed(MouseEvent e) {
            String txt = monsterChecking(monsters[finalCount1].getIcon());
            currentDiscovery.setText(txt);
            currentDescription.setText(MonsterDescription.getMonsterDescription(MonsterDescription.index.get(txt)));
          }
        });
        count++;
      }
    }
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 4; j++) {
        words[count1].setSize(wordWidth, wordHeight);
        words[count1].setLocation((wordWidth + ten) * j + ten, (wordHeight + (ten * 2)) * i + h);
        words[count1].setVerticalAlignment(JLabel.CENTER);
        words[count1].setHorizontalAlignment(JLabel.CENTER);
        words[count1].setFont(new Font("who asks satan", Font.PLAIN, 23));
        words[count1].setForeground(globalColor);
        int finalCount = count1;
        words[count1].addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            if (words[finalCount].getText().equals("???")) {
              currentDiscovery.setText("???");
              currentDescription.setText("???");
            } else {
              currentDiscovery.setText(words[finalCount].getText());
              String tmp = Words.getMeaning(Words.indexMeaning.get(words[finalCount].getText()));
              currentDescription.setText(tmp);
            }
          }
        });
        count1++;
      }
    }
    next.setSize((int) (width * 0.12711865), (int) (height * 0.12711865));
    next.setLocation((int) (width / 2.3), (int) (height / 1.3));
    next.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if (current.equals("words")) {
          if (maxIndexWords < 99) {
            minIndexWords += 20;
            maxIndexWords += 20;
            update();
          }
        } else {
          if (maxIndexMonsters < 7) {
            minIndexMonsters += 4;
            maxIndexMonsters += 3;
            update();
          }
        }
        System.out.println("clicked");
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        try {
          next.setIcon(ResizeImages.getResizedNext_enlarged(size / 2));
          ap.playHoverIn();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException ex) {
          throw new RuntimeException(ex);
        }
      }

      @Override
      public void mouseExited(MouseEvent e) {
        try {
          next.setIcon(ResizeImages.getResizedNext(size / 2));
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }
    });

    previous.setSize((int) (width * 0.12711865), (int) (height * 0.12711865));
    previous.setLocation((int) (width / 4.7), (int) (height / 1.3));
    previous.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        if (current.equals("words")) {
          if (maxIndexWords > 19) {
            minIndexWords -= 20;
            maxIndexWords -= 20;
            update();
          }
        } else {
          if (maxIndexMonsters > 3) {
            maxIndexMonsters -= 3;
            minIndexMonsters -= 4;
            update();
          }
        }
      }


      @Override
      public void mouseEntered(MouseEvent e) {
        try {
          previous.setIcon(ResizeImages.getResizedPrevious_enlarged(size / 2));
          ap.playHoverIn();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException ex) {
          throw new RuntimeException(ex);
        }
      }

      @Override
      public void mouseExited(MouseEvent e) {
        try {
          previous.setIcon(ResizeImages.getResizedPrevious(size / 2));

        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }
    });
    currentDiscovery.setSize(monsterWidth, 50);
    currentDiscovery.setLocation((int) (width / 1.4), (height / 5));
    currentDiscovery.setFont(new Font("who asks satan", Font.PLAIN, 33));
    currentDiscovery.setHorizontalAlignment(JLabel.CENTER);
    currentDiscovery.setVerticalAlignment(JLabel.CENTER);
    currentDiscovery.setForeground(globalColor);

    currentDescription.setSize(monsterWidth, monsterHeight * 2);
    currentDescription.setLocation((int) (width / 1.4), (int) (height / 3.4));
    currentDescription.setHorizontalAlignment(JLabel.CENTER);
    currentDescription.setFont(new Font("who asks satan", Font.PLAIN, 16));
    currentDescription.setVerticalAlignment(JLabel.TOP);
    currentDescription.setForeground(globalColor);
  }

  private void setButtonPropertiesForDiscoveryUI(int width, int height) {
    back_DiscoveryUI.setSize((int) (width * 0.0847457627118), (int) (height * 0.0847457627118));
    back_DiscoveryUI.setLocation(0, 0);
    back_DiscoveryUI.setContentAreaFilled(false);
    back_DiscoveryUI.setBorderPainted(false);
    back_DiscoveryUI.setBorder(null);
    back_DiscoveryUI.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        maxIndexMonsters = 3;
        maxIndexWords = 19;
        minIndexWords = 0;
        minIndexMonsters = 0;
        current = "monsters";
        update();
        current = "words";
        update();
        discoveryUI.setVisible(false);
        mainMenuUI.setVisible(true);
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        try {
          back_DiscoveryUI.setIcon(ResizeImages.getResizedReturn_Enlarged(size / 2));
          ap.playHoverIn();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException ex) {
          throw new RuntimeException(ex);
        }
      }

      @Override
      public void mouseExited(MouseEvent e) {
        try {
          back_DiscoveryUI.setIcon(ResizeImages.getResizedReturn(size / 2));
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }
    });
  }

  private void setWordVisibilities() {
    range(0, monsters.length).forEach(i -> monsters[i].setVisible(false));
    int bound = words.length;
    maxIndexWords = 19;
    minIndexWords = 0;
    for (int i = 0; i < bound; i++) {
      words[i].setVisible(true);
    }
    update();
    currentDiscovery.setText("...");
    currentDescription.setText("...");
  }

  private void setMonsterVisibilities() {
    range(0, monsters.length).forEachOrdered(i -> {
      maxIndexMonsters = 2;
      minIndexMonsters = 0;
      update();
      monsters[i].setVisible(true);
    });
    range(0, words.length).forEachOrdered(i -> words[i].setVisible(false));
    currentDiscovery.setText("...");
    currentDescription.setText("...");
  }

  private void update() {
    if (current.equals("words")) {
      int idx = minIndexWords;
      for (int i = 0; i < 20; i++, idx++) {
        if (Words.isDiscovered[idx]) {
          words[i].setText(Words.getWord(idx));
        } else {
          words[i].setText("???");
        }
      }
    } else {
      int idx = minIndexMonsters;
      for (int i = 0; i <= 3 && idx < 7; i++, idx++) {
        monsters[i].setIcon(monster[idx]);
        if (idx == 6) {
          monsters[monsters.length - 1].setIcon(null);
        }
      }
    }
  }

  private String monsterChecking(Icon ii) {
    if (ii == monster[0]) {
      return "kapre";
    }
    if (ii == monster[1]) {
      return "bampira";
    }
    if (ii == monster[2]) {
      return "sigbin";
    }
    if (ii == monster[3]) {
      return "mananangal";
    }
    if (ii == monster[4]) {
      return "mangkukulam";
    }
    if (ii == monster[5]) {
      return "tikbalang";
    }
    if (ii == monster[6]) {
      return "tiktik";
    } else {
      return "";
    }
  }

  private void play() {
    invisibleTAre.setEnabled(true);
    pauseBlur.setVisible(false);
    pauseUI.setVisible(false);
  }

  private void pause() {
    pauseUI.setVisible(true);
    pauseBlur.setVisible(true);
    invisibleTAre.setEnabled(false);
  }
    static class Time {
    static int seconds = 0;
    static int minutes = 3;

    void start() {
      timer.start();
    }

    void pause() {
      timer.stop();
    }
    javax.swing.Timer timer = new javax.swing.Timer(1000, e -> {
      if (seconds == 1 && minutes == 0) {
        Main.seconds.setText("00");
        Main.minutes.setText("0");
        Main.end.setText("times up");
        Main.clear();
        Main.gameplayUI.removeAll();
        Main.resultUI.setVisible(true);
        Main. scoreEnding.setText("Score " + Gameplay.scoring);
        if (modes[1]) {
          if (Load.getPrevHighScoreTimeRush() < Gameplay.scoring) {
            Save.getScoreTimeRush(Gameplay.scoring);
          }
        }
        if (modes[2]) {
          if (MANNO.data.Load.getPrevHighScoreHard() < Gameplay.scoring) {
            Save.getScoreHardMode(Gameplay.scoring);
          }
        }
        try {
          Save.getIsDiscoverData(Words.isDiscovered);
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
        reset();
        AudioPlayer.bg.stop();
        try {
          ap.playBackgroundMusic();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
          throw new RuntimeException(ex);
        }
      }
      if (seconds == 0) {
        minutes--;
        seconds = 59;
      } else {
        seconds--;
      }
      if (seconds < 10) {
        Main.seconds.setText("0" + seconds);
      } else {
        Main.seconds.setText(String.valueOf(seconds));
      }
      Main.minutes.setText(String.valueOf(minutes));
    });

    void reset() {
      timer.stop();
      minutes = 3;
      seconds = 0;
    }
  }

  static class Delay extends Thread {
    int seconds = 2;

    @Override
    public void run() {
      Timer time = new Timer();
      TimerTask task = new TimerTask() {
        @Override
        public void run() {
          if (Delay.this.seconds == 2) {
            incorrect.setVisible(true);
            Delay.this.seconds--;
          } else if (Delay.this.seconds == 1) {
            incorrect.setVisible(false);
            time.cancel();
            cancel();
            t.start();
          }
        }
      };
      time.scheduleAtFixedRate(task, 0, 500);
    }
  }

  static class Countdown extends Thread {
    int seconds = 4;

    @Override
    public void run() {
      lives[0].setVisible(false);
      lives[1].setVisible(false);
      lives[2].setVisible(false);
      Timer time = new Timer();
      TimerTask task = new TimerTask() {
        @Override
        public void run() {
          if (Countdown.this.seconds > 1) {
            Main.countdown.setText(String.valueOf(seconds - 1));
            Countdown.this.seconds--;
          } else if (Countdown.this.seconds == 1) {
            Main.countdown.setFont(new Font("who asks satan", Font.PLAIN, 50));
            Main.countdown.setText("Nandiyan na ang mga aswang!!!");
            Countdown.this.seconds--;
          } else if (Countdown.this.seconds == 0) {
            Main.setGameplayElementsVisibility(true);
            Main.countdown.setVisible(false);
            time.cancel();
            cancel();
            Main.countdown.setFont(new Font("who asks satan", Font.PLAIN, 200));
            if (modes[1] || modes[2]) {
              t.start();
            }
            try {
              ap.playBattleSound();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
              throw new RuntimeException(e);
            }
          }
        }
      };
      time.scheduleAtFixedRate(task, 0, 1000);
    }
  }
}