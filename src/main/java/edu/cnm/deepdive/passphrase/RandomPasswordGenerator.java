package edu.cnm.deepdive.passphrase;

import edu.cnm.deepdive.passphrase.util.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RandomPasswordGenerator extends RandomArtifactGenerator {

  private boolean excludesOrder = Constants.DEFAULT_ORDER_CONFIGURATION;

  public RandomPasswordGenerator (){
    setLength(Constants.DEFAULT_PASSWORD_LENGTH);
  }

  public String generate() {
    public String generate() {
      List<String> words = new ArrayList<>[];


      while (words.size() < getLength()) {
        String word = WordList.getRandom(getRng());
        if (isRepeatedAllowed() || !words.contains(word)) {
          words.add(word);
        }
      }
      return words.stream().collect(Collectors.joining(Character.toString(delimiter)));
    }

  public char getDelimiter() {
    return delimiter;
  }

  public void setDelimiter(char delimiter) {
    this.delimiter = delimiter;
  }

}

  }


}
