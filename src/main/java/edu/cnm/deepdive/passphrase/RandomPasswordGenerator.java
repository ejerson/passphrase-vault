package edu.cnm.deepdive.passphrase;

import edu.cnm.deepdive.passphrase.util.Constants;
import java.util.LinkedList;
import java.util.List;

/**
 * Generates random passwords with user input.
 */

public class RandomPasswordGenerator extends RandomArtifactGenerator {

  /** Excludes user options */
  private boolean orderExcluded = Constants.DEFAULT_ORDER_CONFIGURATION;
  /** Accesses and stores user's UpperCase preference*/
  private boolean uppercaseExcluded = Constants.DEFAULT_EXCLUDES_UPPERCASE;
  /** Accesses and stores user's LowerCase preference*/
  private boolean lowercaseExcluded = Constants.DEFAULT_EXCLUDES_LOWERCASE;
  /** Accesses and stores user's Digits preference*/
  private boolean digitsExcluded = Constants.DEFAULT_EXCLUDES_DIGITS;
  /** Accesses and stores user's Symbol preference*/
  private boolean symbolsExcluded = Constants.DEFAULT_EXCLUDES_SYMBOLS;
  /** Accesses and stores user's Ambiguous preference*/
  private boolean ambiguousExcluded = Constants.DEFAULT_EXCLUDES_AMBIGUOUS;

  /** Constructor for the Password Length*/
  public RandomPasswordGenerator() {
    setLength(Constants.DEFAULT_PASSWORD_LENGTH);
  }

  /**Checks for user input and generates random password based on options selected.
   *
   * @return returns a random generated password
   */
  public String generate() {
    StringBuilder pool = new StringBuilder();
    String ambiguousRegex;
    if (ambiguousExcluded) {
      ambiguousRegex = "[" + new String(Constants.AMBIGUOUS) + "]";
    } else {
      ambiguousRegex = "(?!a)a";
    }
    if (!uppercaseExcluded) {
      pool.append(Constants.UPPERCASE.replaceAll(ambiguousRegex, ""));
    }

    if (!lowercaseExcluded) {
      pool.append(Constants.LOWERCASE.replaceAll(ambiguousRegex, ""));
    }
    if (!digitsExcluded) {
      pool.append(Constants.DIGITS.replaceAll(ambiguousRegex, ""));
    }
    if (!symbolsExcluded) {
      pool.append(Constants.SYMBOLS.replaceAll(ambiguousRegex, ""));
    }

    String source = pool.toString();
    List<Character> characters = new LinkedList<>();
    while (characters.size() < getLength()) {
      char c = source.charAt(getRng().nextInt(source.length()));
      if (isRepeatedAllowed() || !characters.contains(c)) {
        if (!orderExcluded) {
          characters.add(c);
        } else {
          boolean searchAscending = true;
          boolean searchDescending = true;
          for (int i = 0; i <= Constants.MAX_ORDER_LENGTH; i++) {
            if (searchAscending && characters.get(characters.size() - i) == (char) (c - i)) {
              searchDescending = false;
            } else if (searchDescending && characters.get(characters.size() - i) == (char) (c
                + i)) {
              searchAscending = false;
            } else {
              characters.add(c);
              break;
            }
          }
        }
      }
    }

    StringBuilder password = new StringBuilder();
    for (char c : characters) {
      password.append(c);
    }
    return password.toString();
  }


  /**
   * Provides access to Order preference
   * @return returns user specified order
   */
  public boolean isOrderExcluded() {
    return orderExcluded;
  }

  /**
   * Allows mutation of order preference
   * @param orderExcluded passes user defined order
   */
  public void setOrderExcluded(boolean orderExcluded) {
    this.orderExcluded = orderExcluded;
  }

  /**
   * Provides access to Uppercase Exclusion
   * @return returns an Uppercase selection
   */
  public boolean isUppercaseExcluded() {
    return uppercaseExcluded;
  }

  /**
   * Allows mutation of the Uppercase preference
   * @param uppercaseExcluded passes user defined selection
   */
  public void setUppercaseExcluded(boolean uppercaseExcluded) {
    this.uppercaseExcluded = uppercaseExcluded;
  }

  /**
   * Provides access to Lowercase Exclusion
   * @return returns a Lowercase selection
   */
  public boolean isLowercaseExcluded() {
    return lowercaseExcluded;
  }


  /**
   * Allows mutation of the Lowercase preference
   * @param lowercaseExcluded passes user defined selection
   */
  public void setLowercaseExcluded(boolean lowercaseExcluded) {
    this.lowercaseExcluded = lowercaseExcluded;
  }

  /**
   * Provides access to Digit Exclusion
   * @return returns digit selection
   */
  public boolean isDigitsExcluded() {
    return digitsExcluded;
  }

  /**
   * Allows mutation of Digits preference
   * @param digitsExcluded passes user defined selection
   */
  public void setDigitsExcluded(boolean digitsExcluded) {
    this.digitsExcluded = digitsExcluded;
  }

  /**
   * Provides access to Symbol Exclusion
   * @return returns symbol selection
   */
  public boolean isSymbolsExcluded() {
    return symbolsExcluded;
  }

  /**
   * Allows mutation of Symbols preference
   * @param symbolsExcluded passes user defined selection
   */
  public void setSymbolsExcluded(boolean symbolsExcluded) {
    this.symbolsExcluded = symbolsExcluded;
  }

  /**
   * Provides access to Ambiguous Exclusions
   * @return returns ambiguous selection
   */
  public boolean isAmbiguousExcluded() {
    return ambiguousExcluded;
  }

  /**
   * Allows mutation of Ambiguous preference
   * @param ambiguousExcluded passes user defined selection
   */
  public void setAmbiguousExcluded(boolean ambiguousExcluded) {
    this.ambiguousExcluded = ambiguousExcluded;
  }

}

