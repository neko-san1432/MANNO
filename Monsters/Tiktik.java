package MANNO.Monsters;

import MANNO.Images.ResizeImages;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Tiktik extends Monster {
    Dimension dimension = getToolkit().getScreenSize();
    private final double s = dimension.getHeight() / 1.3;
    private final int size = (int) s;
    @Override
    public void setMonsterLife() {
        MonsterLife = 100;
    }

    @Override
    public void setMonsterName() {
        MonsterName = "tiktik";
    }

    @Override
    public void setMonsterImage() throws IOException {
        try {
            monsterImage = ResizeImages.getResizedTiktik(size);
            System.out.println(monsterImage.getIconHeight()+" "+monsterImage.getIconWidth());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getMonsterLife() {
        return MonsterLife;
    }

    @Override
    public String getMonsterName() {
        return MonsterName;
    }

    @Override
    public ImageIcon getMonsterImage() {
        return monsterImage;
    }
}
