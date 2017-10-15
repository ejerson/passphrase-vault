package edu.cnm.deepdive.passphrase;

import edu.cnm.deepdive.passphrase.util.Constants;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

/**
 * Accesses and processes a list of words for the random passphrase generator.
 */
public class WordList {

  /**Creates a String array to store generated words.*/
  private final String[] words;

  /**Implements Singleton pattern to keep track of one INSTANCE of a class at a time.*/
  private static class Singleton {

    /**Creates an instance of a WordList class.*/
    private static final WordList INSTANCE = new WordList();
  }
  /**Creates a WordList by streaming reading and writing the WORDS_BUNDLE.*/
  private WordList() {
    ResourceBundle bundle = ResourceBundle.getBundle(Constants.WORDS_BUNDLE);
    List<String> wordList = new LinkedList<>();
    for (Enumeration<String> e = bundle.getKeys(); e.hasMoreElements();) {
      wordList.add(bundle.getString(e.nextElement()));
    }
    words = wordList.toArray(new String[wordList.size()]);
  }

  /**
   * Uses the random class to randomly pick from the WordList.
   *
   * @param rng Accesses random from the getter.
   * @return Returns a random word.
   */
  public static String getRandom(Random rng) {
    return Singleton.INSTANCE.words[rng.nextInt(Singleton.INSTANCE.words.length)];
  }

}


