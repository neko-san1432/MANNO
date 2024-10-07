package MANNO.Images;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ResizeImages extends JFrame {
  static String[] fileLocations = {
  "D/MANNO/Images/Texts/MANNO.png",
  "MANNO/Images/Texts/Credits.png",
  "MANNO/Images/Texts/Creditsw.png",
  "MANNO/Images/Texts/start.png",
  "MANNO/Images/Texts/startw.png",
  "MANNO/Images/Texts/discoveryw.png",
  "MANNO/Images/Texts/discovery.png",
  "MANNO/Images/Texts/exit.png",
  "MANNO/Images/Texts/exitw.png",
  "MANNO/Images/Texts/freemode.png",
  "MANNO/Images/Texts/freemodew.png",
  "MANNO/Images/Texts/timerush.png",
  "MANNO/Images/Texts/timerushw.png",
  "MANNO/Images/Texts/hardmode.png",
  "MANNO/Images/Texts/hardmodew.png",
  "MANNO/Images/Texts/choose your mode.png",
  "MANNO/Images/Texts/back.png",
  "MANNO/Images/Texts/backw.png",
  "MANNO/Images/MonsterImg/kapre.gif",
  "MANNO/Images/MonsterImg/tikbalang.gif",
  "MANNO/Images/MonsterImg/tiktik.gif",
  "MANNO/Images/MonsterImg/manananggal.gif",
  "MANNO/Images/MonsterImg/bampira.gif",
  "MANNO/Images/MonsterImg/mangkukulam.gif",
  "MANNO/Images/MonsterImg/sigbin.gif",
  "MANNO/Images/pauseBlur.png",
  "MANNO/Images/MC.gif",
  "MANNO/Images/Graveyard_01.jpg",
  "MANNO/Images/soul.gif",
  "MANNO/Images/Icons/home.png",
  "MANNO/Images/Icons/homew.png",
  "MANNO/Images/Icons/pause.png",
  "MANNO/Images/Icons/pausew.png",
  "MANNO/Images/Icons/play.png",
  "MANNO/Images/Icons/playw.png",
  "MANNO/Images/Icons/restart.png",
  "MANNO/Images/Icons/restartw.png",
  "MANNO/Images/Icons/return.png",
  "MANNO/Images/Icons/returnw.png",
  "MANNO/Images/Icons/prev.png",
  "MANNO/Images/Icons/prevw.png",
  "MANNO/Images/background/gameplay.gif",
  "MANNO/Images/background/mainmenu.gif",
  "MANNO/Images/background/mainmenu.gif",};

  static BufferedImage imgs;
  static Image img;

  static Image resized(int[] sizes, int frameSize, BufferedImage b) {
    float[] percentage = {(float) sizes[0] / b.getWidth(), (float) sizes[1] / b.getHeight()};
    int[] finalSizes = {(int) (frameSize * percentage[0]), (int) (frameSize * percentage[1])};
    return b.getScaledInstance(finalSizes[0], finalSizes[1], Image.SCALE_DEFAULT);
  }
  public static ImageIcon getResizedManno(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[0]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w - 200, h - 170};
    return new ImageIcon(resized(sizes, size, imgs));
  }

  public static ImageIcon getResizedPlay(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[3]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w - 231, h - 142};
    return new ImageIcon(resized(sizes, size, imgs));
  }

  public static ImageIcon getResizedPlay_enlarged(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[4]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w - 230, h - 140};
    return new ImageIcon(resized(sizes, size, imgs));
  }

  public static ImageIcon getResizedDiscovery(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[5]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w - 410, h - 140};
    return new ImageIcon(resized(sizes, size, imgs));
  }

  public static ImageIcon getResizedDiscovery_enlarged(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[6]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w - 407, h - 142};
    return new ImageIcon(resized(sizes, size, imgs));
  }

  public static ImageIcon getResizedExit(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[7]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w - 198, h - 118};
    return new ImageIcon(resized(sizes, size, imgs));
  }

  public static ImageIcon getResizedExit_enlarged(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[8]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w - 197, h - 117};
    return new ImageIcon(resized(sizes, size, imgs));
  }

  public static ImageIcon getResizedFreeMode(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[9]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w - 425, h - 163};
    return new ImageIcon(resized(sizes, size, imgs));
  }

  public static ImageIcon getResizedFreeMode_enlarged(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[10]));
    img = imgs.getScaledInstance(150, 45, Image.SCALE_DEFAULT);
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w - 425, h - 123};
    return new ImageIcon(resized(sizes, size, imgs));
  }

  public static ImageIcon getResizedTimeRush(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[11]));
    img = imgs.getScaledInstance(130, 50, Image.SCALE_DEFAULT);
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w - 366, h - 140};
    return new ImageIcon(resized(sizes, size, imgs));
  }

  public static ImageIcon getResizedTimeRush_enlarged(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[12]));
    img = imgs.getScaledInstance(140, 60, Image.SCALE_DEFAULT);
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w - 364, h - 137};
    return new ImageIcon(resized(sizes, size, imgs));
  }

  public static ImageIcon getResizedHardMode(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[13]));
    img = imgs.getScaledInstance(130, 50, Image.SCALE_DEFAULT);
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w - 420, h - 134};
    return new ImageIcon(resized(sizes, size, imgs));
  }

  public static ImageIcon getResizedHardMode_enlarged(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[14]));
    img = imgs.getScaledInstance(140, 60, Image.SCALE_DEFAULT);
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w - 418, h - 132};
    return new ImageIcon(resized(sizes, size, imgs));
  }

  public static ImageIcon getResizedChooseMode(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[15]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w - 210, h - 180};
    return new ImageIcon(resized(sizes, size, imgs));
  }

  public static ImageIcon getResizedBack(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[16]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w - 240, h - 180};
    return new ImageIcon(resized(sizes, size, imgs));
  }


  public static ImageIcon getResizedReturn_enlarged(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[17]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w - 235, h - 170};
    return new ImageIcon(resized(sizes, size, imgs));
  }

  public static ImageIcon getResizedPauseBackground(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[25]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w, h};
    return new ImageIcon(resized(sizes, size, imgs));
  }
  public static ImageIcon getResizedHome(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[29]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w/6, h/6};
    return new ImageIcon(resized(sizes, size, imgs));
  }
  public static ImageIcon getResizedHome_Enlarged(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[30]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w/6, h/6};
    return new ImageIcon(resized(sizes, size, imgs));
  }

  public static ImageIcon getResizedPause(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[31]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w/6, h/6};
    return new ImageIcon(resized(sizes, size, imgs));
  }
  public static ImageIcon getResizedPause_Enlarged(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[32]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w/6, h/6};
    return new ImageIcon(resized(sizes, size, imgs));
  }
  public static ImageIcon getResizedResume(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[33]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w/6, h/6};
    return new ImageIcon(resized(sizes, size, imgs));
  }
  public static ImageIcon getResizedResume_Enlarged(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[34]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w/6, h/6};
    return new ImageIcon(resized(sizes, size, imgs));
  }
  public static ImageIcon getResizedRestart(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[35]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w/6, h/6};
    return new ImageIcon(resized(sizes, size, imgs));
  }
  public static ImageIcon getResizedRestart_Enlarged(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[36]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w/6, h/6};
    return new ImageIcon(resized(sizes, size, imgs));
  }
  public static ImageIcon getResizedReturn(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[37]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w/6, h/6};
    return new ImageIcon(resized(sizes, size, imgs));
  }
  public static ImageIcon getResizedReturn_Enlarged(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[38]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w/6, h/6};
    return new ImageIcon(resized(sizes, size, imgs));
  }
  public static ImageIcon getResizedBackground(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[27]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w, h/2};
    return new ImageIcon(resized(sizes, size, imgs));
  }
  public static ImageIcon getResizedNext(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[33]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w/6, h/6};
    return new ImageIcon(resized(sizes, size, imgs));
  }
  public static ImageIcon getResizedNext_enlarged(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[34]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w/6, h/6};
    return new ImageIcon(resized(sizes, size, imgs));
  }
  public static ImageIcon getResizedPrevious(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[39]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w/6, h/6};
    return new ImageIcon(resized(sizes, size, imgs));
  }
  public static ImageIcon getResizedPrevious_enlarged(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[40]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w/6, h/6};
    return new ImageIcon(resized(sizes, size, imgs));
  }


  //gifs
  static ImageIcon resizedGIF(int[] sizes, int frameSize, ImageIcon ii) {
    float[] percentage = {(float) sizes[0] / 590, (float) sizes[1] / 590};
    int[] finalSizes = {(int) (frameSize * percentage[0]), (int) (frameSize * percentage[1])};
    ii.setImage(ii.getImage().getScaledInstance(finalSizes[0], finalSizes[1], Image.SCALE_DEFAULT));
    return ii;
  }

  public static ImageIcon getResizedTiktik(int size)throws IOException {
    imgs = ImageIO.read(new File(fileLocations[20]));
    ImageIcon i = new ImageIcon(String.valueOf(fileLocations[20]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w - 1115, h - 1380};
    return resizedGIF(sizes, size,i);
  }

  public static ImageIcon getResizedKapre(int size)throws IOException {
    imgs = ImageIO.read(new File(fileLocations[18]));
    ImageIcon i = new ImageIcon(String.valueOf(fileLocations[18]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w-130, h-130};
    return resizedGIF(sizes, size,i);
  }

  public static ImageIcon getResizedBampira(int size)throws IOException {
    imgs = ImageIO.read(new File(fileLocations[22]));
    ImageIcon i = new ImageIcon(String.valueOf(fileLocations[22]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w-140, h-140};
    return resizedGIF(sizes, size,i);
  }

  public static ImageIcon getResizedTikbalang(int size)throws IOException {
    imgs = ImageIO.read(new File(fileLocations[19]));
    ImageIcon i = new ImageIcon(String.valueOf(fileLocations[19]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w-1400, h-1738};
    return resizedGIF(sizes, size,i);
  }
  public static ImageIcon getResizedMananangal(int size)throws IOException {
    imgs = ImageIO.read(new File(fileLocations[21]));
    ImageIcon i = new ImageIcon(String.valueOf(fileLocations[21]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w-1047, h-1744};
    return resizedGIF(sizes, size,i);
  }

  public static ImageIcon getResizedMangkukulam(int size)throws IOException {
    imgs = ImageIO.read(new File(fileLocations[23]));
    ImageIcon i = new ImageIcon(String.valueOf(fileLocations[23]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w-1100, h-1100};
    return resizedGIF(sizes, size,i);
  }
  public static ImageIcon getResizedSigbin(int size) throws IOException{
    imgs = ImageIO.read(new File(fileLocations[24]));
    ImageIcon i = new ImageIcon(String.valueOf(fileLocations[24]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w-1400, h-700};
    return resizedGIF(sizes, size,i);
  }
  public static ImageIcon getResizedMC(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[26]));
    ImageIcon i = new ImageIcon(String.valueOf(fileLocations[26]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w-700, h-1400};
    return resizedGIF(sizes, size,i);
  }
  public static ImageIcon getResizedLife(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[28]));
    ImageIcon i = new ImageIcon(String.valueOf(fileLocations[28]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w-282, h-523};
    return resizedGIF(sizes, size,i);
  }

  public static ImageIcon getResizedGamePlayBG(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[41]));
    ImageIcon i = new ImageIcon(String.valueOf(fileLocations[41]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w, h};
    return resizedGIF(sizes, size,i);
  }
  public static ImageIcon getResizedMainMenu(int size) throws IOException {
    imgs = ImageIO.read(new File(fileLocations[42]));
    ImageIcon i = new ImageIcon(String.valueOf(fileLocations[42]));
    int w = imgs.getWidth(), h = imgs.getHeight();
    int[] sizes = {w, h};
    return resizedGIF(sizes, size,i);
  }
}

