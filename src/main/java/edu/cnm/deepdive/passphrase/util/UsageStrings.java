package edu.cnm.deepdive.passphrase.util;

import java.util.ResourceBundle;

/**
 * Access usage-strings usage bundle
 */
public class UsageStrings {

  /** Declares ResourceBundle bundle */
  private final ResourceBundle bundle;

  /** Implements Singleton pattern to keep track of one INSTANCE of a class at a time */
  private static class Singleton {

    /** Creates an instance of a UsageStrings class */
    private static final UsageStrings INSTANCE = new UsageStrings();
  }

  /** Instantiates ResourceBundle bundle constant*/
  private UsageStrings() {
    bundle = ResourceBundle.getBundle(Constants.USAGE_BUNDLE);
  }

  /**
   *  Accesses to the produced ResourceBundle bundle
   *
   * @return returns singleton instance of bundle
   */
  public static ResourceBundle getBundle() {
    return Singleton.INSTANCE.bundle;
  }
}