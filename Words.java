package MANNO;

import MANNO.data.Load;

import java.util.HashMap;

public class Words {
    static String[] salita = { "araw", "bata", "kamay", "lupa", "sama", "unang",
    "bahay", "dahon", "isda", "langit", "puno", "tubig",
    "bilog", "gatas", "lapis", "niyog", "saging", "ulan",
    "dilaw", "gulay", "larawan", "oso", "pusa", "tala",
    "arko", "diwa", "hangin", "liham", "pinto", "tinapay",
    "asul", "dugo", "hapunan", "lobo", "prutas", "tindahan",
    "barya", "eskuwela", "harap", "lupa", "papel", "titik",
    "bilog", "espada", "hapon", "maleta", "papel", "tsokolate",
    "bituin", "gulay", "ibon", "martes", "pisara", "utot",
    "botika", "guro", "itlog", "martilyo", "pitong", "wika",
    "bulaklak", "hagdang", "kandila", "mesang", "prutas", "yaman",
    "bulig", "hanggang", "kahon", "nagmula", "punong", "yelo",
    "buntot", "hatid", "kalye", "niyebe", "saing", "tsinelas",
    "damit", "hawak", "kamatis", "niyog", "salapi", "sapatos",
    "eksena", "hagdan", "kape", "ospital", "sili", "zebra",
    "eksperto", "hapunan", "karayom", "oras", "singkamas", "zoo","prinsesa",
    "prinsipe","hari","reyna"};
    static String[] meaning = {"day", "child", "hand", "land", "together", "first",
    "house", "leaf", "fish", "sky", "tree", "water",
    "circle", "milk", "pencil", "coconut", "banana", "rain",
    "yellow", "vegetable", "picture", "bear", "cat", "star",
    "arch", "spirit", "air", "letter", "door", "bread",
    "blue", "blood", "dinner", "balloon", "fruit", "store",
    "coin", "school", "front", "earth", "paper", "letter",
    "circle", "sword", "afternoon", "suitcase", "paper", "chocolate",
    "star", "vegetable", "bird", "tuesday", "blackboard", "fart",
    "pharmacy", "teacher", "egg", "hammer", "seven", "language",
    "flower", "direction", "candle", "table", "fruit", "wealth",
    "help", "until", "box", "originated", "tree", "ice",
    "tail", "bring", "street", "snow", "cooking", "slippers",
    "cloth", "hold", "tomato", "coconut", "money", "shoes",
    "scene", "stairs", "coffee", "hospital", "chili", "zebra",
    "expert", "dinner", "needle", "time", "turnip", "zoo","princess","prince","king","queen"};
    static int index = 0;
    static boolean[] isDiscovered = Load.getDiscoveriesStatus();


    static {
        for (int i = 0; i < salita.length; i++) {
            for (int j = i + 1; j < salita.length; j++) {
                if (salita[i].compareTo(salita[j]) > 0) {
                    String tempSalita = salita[i];
                    salita[i] = salita[j];
                    salita[j] = tempSalita;
                    String tempMeaning = meaning[i];
                    meaning[i] = meaning[j];
                    meaning[j] = tempMeaning;
                }
            }
        }
    }
    static HashMap<String, Integer> indexMeaning =  new HashMap<>();
    public String getWordForGameplay() {
        isDiscovered[index] = true;
        return salita[index];
    }
    static String getWord(int index) {
        if (isDiscovered[index]) {
            return salita[index];
        } else {
            return "???";
        }
    }
    static{
        for(int i = 0; i< salita.length;i++){
            indexMeaning.put(salita[i], i);
        }
    }
    static void setRandomIndexWord(){
        index= ((int) (Math.random() * salita.length)) % salita.length;
    }
    static String getMeaning(int index) {
        return meaning[index];
    }
}