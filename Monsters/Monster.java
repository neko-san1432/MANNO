package MANNO.Monsters;

import javax.swing.*;
import java.io.IOException;

abstract class Monster extends JFrame{
    public static int MonsterLife = 0;
    static String MonsterName = "";
    static ImageIcon monsterImage= null;
    public abstract void setMonsterLife();
    public abstract void setMonsterName();
    public abstract void setMonsterImage() throws IOException;
    public abstract int getMonsterLife();
    public abstract String getMonsterName();
    public abstract ImageIcon getMonsterImage();
}