package edu.cnm.deepdive.passphrase;

import edu.cnm.deepdive.passphrase.util.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**Generates delimited random passphrase*/
public class RandomPassphraseGenerator extends RandomArtifactGenerator {

  /**  Stores delimiter provided by user selection. */
  private char delimiter = Constants.DEFAULT_DELIMITER;

  /**Constructor for the passphrase length */
  public RandomPassphraseGenerator () {
    setLength(Constants.DEFAULT_PASSPHRASE_LENGTH);
  }

  /**
   * Uses an ArrayList to store words and to check for repeated words
   * @return returns delimited string of words
   */
  public String generate() {
    List<String> words = new ArrayList<>();

    while (words.size() < getLength()) {
      String word = WordList.getRandom(getRng());
      if (isRepeatedAllowed() || !words.contains(word)) {
        words.add(word);
      }
    }
    return words.stream().collect(Collectors.joining(Character.toString(delimiter)));
  }

  /**
   * Provides access to delimiter
   * @return returns a delimiter
   */
  public char getDelimiter() {
    return delimiter;
  }

  /**
   * Allows mutation of the delimiter
   * @param delimiter passes user defined delimiter
   */
  public void setDelimiter(char delimiter) {
    this.delimiter = delimiter;
  }

}
