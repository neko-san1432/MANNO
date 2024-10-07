package MANNO.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Load {
  //includes file handling
  static String filePath = "MANNO/data/data.txt",
  l1 = "";
  static int l2 = 0,
  l3 = 0;

  public static int getPrevHighScoreTimeRush() {
    return l2;
  }

  public static int getPrevHighScoreHard() {
    return l3;
  }

  public static boolean[] getDiscoveriesStatus() {
    boolean[] tmp = new boolean[100];
    char[] tmp2 = l1.toCharArray();
    int i = 0;
    for (char c : tmp2) {
      if (c == 'f') {
        tmp[i] = false;
        System.out.println("ht");
        i++;
      } else if (c == 't') {
        tmp[i] = true;
        System.out.println("hjit");
        i++;
      }
    }
    return tmp;
  }

  public static void run() {
    File myObj = new File(filePath);
    Scanner s;
    try {
      s = new Scanner(myObj);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    int i = 0;
    while (s.hasNextLine() && i < 3) {
      if (i == 0) {
        l1 = s.nextLine();
        System.out.println(l1);
        i++;
      }
      if (i == 1) {
        l2 = s.nextInt();
        i++;
      }
      if (i == 2) {
        l3 = s.nextInt();
        i++;
      }
    }
    s.close();
  }

}
