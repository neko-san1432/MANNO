package MANNO.Monsters;

import MANNO.Images.ResizeImages;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Bampira extends Monster {
    Dimension dimension = getToolkit().getScreenSize();
    private final double s = dimension.getHeight() / 1.3;
    private final int size = (int) s;
    @Override
    public void setMonsterLife() {
        MonsterLife = 300;
    }

    @Override
    public void setMonsterName() {
        MonsterName = "bampira";
    }

    @Override
    public void setMonsterImage() throws IOException {
        monsterImage = ResizeImages.getResizedBampira(size);
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
