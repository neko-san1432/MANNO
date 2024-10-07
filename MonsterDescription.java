package MANNO;

import java.util.HashMap;


public class MonsterDescription {
  static String[] monsterName = {"bampira","kapre","mananangal","mangkukulam","sigbin","tikbalang","tiktik"};
  static String[] monsterDescription = {"<html>It looks like you've mentioned \"bampira.\" \"Bampira\" is the Tagalog term for \"vampire.\" Vampires are mythical creatures often associated with folklore, legends, and popular culture. They are typically depicted as beings that sustain themselves by consuming the blood of the living.</html>",
          "<html>In Philippine mythology, a \"kapre\" is a mythical creature often described as a tall, dark, and hairy tree spirit. It is said to reside in big trees, and some stories depict it as a friendly being, while others describe it as mischievous or even malevolent.</html>",
          "<html>\n" +
                  "The \"manananggal\" is a mythical creature in Philippine folklore, particularly in the Visayan region. It is often depicted as a monstrous, female, shape-shifting creature that can detach its upper torso and wings from its lower body. The term \"manananggal\" comes from the Tagalog word \"tanggal,\" which means \"to remove\" or \"to separate.</html>",
          "<html>\n" +
                  "\"Mangkukulam\" is a Tagalog term for a practitioner of witchcraft or sorcery in Filipino folklore. A mangkukulam is believed to possess supernatural abilities and is often associated with casting spells or curses on individuals. The practice of mangkukulam is deeply rooted in traditional beliefs and superstitions.</html>",
          "<html>The \"sigbin\" is a mythical creature in Philippine folklore, particularly in the Visayan region. Descriptions of the sigbin vary, but it is commonly depicted as a creature resembling a hornless goat or a large dog. It is said to have large ears that it can clap together, and it is believed to be nocturnal.</html>",
          "<html>The \"tikbalang\" is a mythical creature in Philippine folklore, known for its distinctive appearance and mischievous behavior. It is often described as a tall, humanoid creature with the head of a horse. The name \"tikbalang\" is derived from the words \"tik\" (meaning \"spur\") and \"balang\" (meaning \"a curse\" or \"a spell\"), reflecting the creature's association with magical and supernatural elements.</html>",
          "<html>\n" +
                  "The \"tiktik\" is a mythical creature or supernatural entity in Philippine folklore. It is often associated with the \"aswang,\" which is a generic term for various shape-shifting creatures or monsters in Filipino mythology. The tiktik is said to be a type of aswang with distinct characteristics.</html>"};
  static HashMap<String, Integer> index = new HashMap<>();
  static String getMonsterDescription(int index){
    return monsterDescription[index];
  }
  static {
    for (int i = 0; i<monsterName.length;i++) {
      index.put(monsterName[i],i);
    }
  }
}