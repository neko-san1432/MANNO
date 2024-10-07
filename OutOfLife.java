package MANNO;

import java.awt.*;

public class OutOfLife extends ArrayIndexOutOfBoundsException{
  public OutOfLife(String text){
    super(text);
    Main.t.pause();
    Main.end.setText(text);
    Main.clear();
    String score = "Score "+Gameplay.getScore();
    Main.scoreEnding.setText(score);
    Main.resultUI.setVisible(true);
    Main.resultUI.setBackground(Color.BLACK);
    Main.gameplayUI.removeAll();
    Gameplay.life = 2;
    Main.pause_GameplayUI.setEnabled(false);
  }
}
