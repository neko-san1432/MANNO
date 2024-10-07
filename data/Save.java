package MANNO.data;

import java.io.FileWriter;
import java.io.IOException;

public class  Save {
    static int hScoreTRush = Load.getPrevHighScoreTimeRush(), hScoreHard = Load.getPrevHighScoreHard();
    static String filePath = "MANNO/data/data.txt";
    public static void getScoreTimeRush(int score){
        hScoreTRush = score;
    }
    public static void getScoreHardMode(int score){
        hScoreHard = score;
    }
    public static void getIsDiscoverData(boolean[] data) throws IOException {
        StringBuilder tmp = new StringBuilder();
        for (boolean datum : data) {
            if (!datum) {
                tmp.append("f ");
            } else {
                tmp.append("t ");
            }
        }
        FileWriter f = new FileWriter(filePath);    
        f.write(tmp + "\n"+hScoreTRush+"\n"+hScoreHard+"\n");
        f.close();
    }

}
