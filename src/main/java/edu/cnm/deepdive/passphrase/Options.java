package edu.cnm.deepdive.passphrase;



import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.MissingArgumentException;
import org.apache.commons.cli.MissingOptionException;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.UnrecognizedOptionException;

import edu.cnm.deepdive.passphrase.util.Constants;
import edu.cnm.deepdive.passphrase.util.UsageStrings;

/**
 * Provides a framework of Options for the CommandLine to use a reference.
 * Contains Parse Options, buildOptions, Map Implementations, Options Validation.
 *
 */
public class Options {

  /** Locates a given option */
  public final Map<String, Object> map;
//  public Map<String, Object> getMap() {
//    return map;
//  }

  /**
   *
   * @param args return response to exceptions
   * @throws ParseException throws and catches ParseExeption
   * @throws HelpRequestedException throws and catches HelpRequestedException
   * @throws IllegalArgumentException throws and catches IllegalArgumentException
   */
  public Options(String[] args)
      throws ParseException, HelpRequestedException, IllegalArgumentException {
    ResourceBundle resourceBundle = UsageStrings.getBundle();
    org.apache.commons.cli.Options options = null;
    try {
      options = buildOptions();
      map = parse(args, options);
      validate();
    } catch (UnrecognizedOptionException e) {
      System.out.println(resourceBundle.getString(Constants.UNRECOGNIZED_OPTION));
      throw e;
    } catch (MissingOptionException e) {
      // Use this in error msg (Option) e.getMissingOptions().get(0)
      System.out.println(resourceBundle.getString(Constants.MISSING_OPTION));
      throw e;
    } catch (MissingArgumentException e) {
      System.out.println(resourceBundle.getString(Constants.ARGUMENT_ERROR));// Print out error message from usage strings
      // Use this in error msg e.getOption().getLongOpt()
      throw e;
    } catch (ParseException e) {
      throw e;
    } catch (HelpRequestedException e) {
      HelpFormatter formatter = new HelpFormatter();
      formatter.printHelp("java " + Options.class.getName(), options);
      throw e;
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      throw e;
    }
  }

  /**
   * Checks individual user entries for validity, and throws errors and warnings.
   *
   * @throws IllegalArgumentException throws an exception if an illegal argument is used
   */
  private void validate()
      throws IllegalArgumentException {
    ResourceBundle resourceBundle = UsageStrings.getBundle();
    if(map.containsKey(Constants.PASSWORD_MODE_OPTION)) {
      System.out.println(Constants.PASSWORD_MODE_OPTION);
      // check validity of password options
      if (map.containsKey(Constants.EXCLUDES_UPPERCASE)
          && map.containsKey(Constants.EXCLUDES_LOWERCASE)
          && map.containsKey(Constants.EXCLUDES_DIGITS)
          && map.containsKey(Constants.EXCLUDES_SYMBOLS)) { // confirm with team that this is ok (symbols?)
        throw new IllegalArgumentException(String.format(resourceBundle.getString(Constants.ARGUMENT_ERROR)));
      }

      int length = ((Number) map.get(Constants.LENGTH_OPTION)).intValue();
      if ((length < Constants.MINIMUM_PASSWORD_LENGTH) || (length > Constants.MAXIMUM_PASSWORD_LENGTH)) { // use a constant instead of "12"
        throw new IllegalArgumentException(String.format(Constants.LENGTH_ERROR));
      }
      if (map.containsKey(Constants.DELIMITER_OPTION)) { // No exception thrown warning for Delimiter option
        System.out.printf(resourceBundle.getString(Constants.DELIMITER_ERROR),
            Arrays.toString(Constants.DELIMITER_SELECTION));
      }
      // Check "no-order" option, throw warning
    } else {
      // TODO check delimiter exception
      if(map.containsKey(Constants.EXCLUDES_ORDER)) {
        System.out.println(Constants.MODE_SELECT_ERROR);
      }
      if (map.containsKey(Constants.LENGTH_OPTION)) {
        int length = ((Number) map.get(Constants.LENGTH_OPTION)).intValue();
        if ((length < Constants.MINIMUM_PASSPHRASE_LENGTH) || (length > Constants.MAXIMUM_PASSPHRASE_LENGTH)) { // use a constant instead of "6"
          throw new IllegalArgumentException(String.format(Constants.LENGTH_ERROR));
        }
      }
    }
  }

  /**
   * Enables CommandLine to parse through options provided by the buildOptions.
   *
   * @param args String[]
   * @param options Options object
   * @return map
   * @throws ParseException stopping the program from running unavailable option
   * @throws HelpRequestedException informs the program that it needs to print help option
   */
  private Map parse(String[] args, org.apache.commons.cli.Options options)
      throws ParseException, HelpRequestedException {
    CommandLineParser parser = new DefaultParser();
    org.apache.commons.cli.CommandLine cmdLine = parser.parse(options, args);
    ResourceBundle resourceBundle = UsageStrings.getBundle();

    if(cmdLine.hasOption(Constants.HELP_OPTION)) {
      throw new HelpRequestedException();
    }
    Map<String, Object> map = new HashMap<>(); // map is a field(lookup table)
    for (Option option : cmdLine.getOptions()) {
      if (option.hasArg()) {
        Object argValue = cmdLine.getParsedOptionValue(option.getLongOpt());
        map.put(option.getLongOpt(), argValue);
      } else {
        map.put(option.getLongOpt(), null);
      }
    }
    return map;
  }

  /**
   *  Defines my options and associates them with Constants class. Returns
   *  populated options object that is used by the Map, Validation, and Parse to CommandLine
   */
  private org.apache.commons.cli.Options buildOptions() {
    //returns a builder      //this list of options can be in any order I want
    ResourceBundle bundle = UsageStrings.getBundle();
    Option repeatOpt = Option.builder("r").hasArg(false)
                            .required(false)
                            .longOpt(Constants.NO_REPEAT_OPTION)
                            .desc(String.format(bundle.getString(Constants.EXCLUDES_REPEAT)))
                            .build();
    Option uppercaseOpt = Option.builder("u").hasArg(false)
                                .required(false)
                                .longOpt(Constants.NO_UPPER_OPTION)
                                .desc(String.format(bundle.getString(Constants.EXCLUDES_UPPERCASE)))
                                .build();
    Option lowercaseOpt = Option.builder("w").hasArg(false)
                                .required(false)
                                .longOpt(Constants.NO_LOWER_OPTION)
                                .desc(String.format(bundle.getString(Constants.EXCLUDES_LOWERCASE)))
                                .build();
    Option digitsOpt = Option.builder("g").hasArg(false)
                            .required(false)
                            .longOpt(Constants.NO_DIGITS_OPTION)
                            .desc(String.format(bundle.getString(Constants.EXCLUDES_DIGITS)))
                            .build();
    Option ambiguousOpt = Option.builder("a").hasArg(false)
                                .required(false)
                                .longOpt(Constants.NO_AMBIGUOUS_CHARACTERS_OPTION)
                                .desc(String.format(bundle.getString(Constants.EXCLUDES_AMBIGUOUS)))
                                .build();
    Option orderOpt = Option.builder().hasArg(false)
                                      .required(false)
                                      .longOpt(Constants.EXCLUDES_ORDER_OPTION)
                                      .desc(String.format(bundle.getString(Constants.EXCLUDES_ORDER)))
                                      .build();
    Option symbolsOpt = Option.builder("s").hasArg(true)
                                          .required(false)
                                          .optionalArg(true)
                                          .numberOfArgs(1)
                                          .longOpt(Constants.EXCLUDES_SYMBOLS_OPTION)
                                          .desc(String.format(bundle.getString(Constants.EXCLUDES_SYMBOLS)))
                                          .type(String.class)
                                          .build();
    Option lengthOpt = Option.builder("l").argName("value") // TODO set its arg name
                                            .optionalArg(false) // mark the builder object as an optional option
                                            .hasArg(true)
                                            .numberOfArgs(1)
                                            .longOpt(Constants.LENGTH_OPTION)
                                            .desc(String.format(bundle.getString(Constants.SPECIFY_LENGTH)))
                                            .required(false)
                                            .type(Number.class)
                                            .build(); // returns an option
    Option delimiterOpt = Option.builder("d").argName("value") // set its arg name
                                            .optionalArg(false) // mark the builder object as an optional option
                                            .hasArg(true)
                                            .numberOfArgs(1)
                                            .longOpt(Constants.DELIMITER_OPTION)
                                            .desc(String.format(bundle.getString(Constants.SPECIFY_DELIMITER)))
                                            .required(false)
                                            .type(String.class)
                                            .build();
    Option helpOpt = Option.builder("?").longOpt(Constants.HELP_OPTION)
                                        .required(false)
                                        .hasArg(false)
                                        .desc(String.format(bundle.getString(Constants.HELP_MSG)))
                                        .build();
    Option modeOpt = Option.builder("x").hasArg(false)
                                      .required(false)
                                      .longOpt(Constants.PASSWORD_MODE_OPTION)
                                      .desc(String.format(bundle.getString(Constants.MODE_SWITCH)))
                                      .build();

    org.apache.commons.cli.Options options = new org.apache.commons.cli.Options();
    options.addOption(repeatOpt);
    options.addOption(uppercaseOpt);
    options.addOption(lowercaseOpt);
    options.addOption(digitsOpt);
    options.addOption(symbolsOpt);
    options.addOption(lengthOpt);
    options.addOption(delimiterOpt);
    options.addOption(ambiguousOpt);
    options.addOption(orderOpt);
    options.addOption(modeOpt);
    options.addOption(helpOpt);
    return options;
  }

  /**
   * Added new HelpRequestException to handle help option related exceptions
   */
  public static class HelpRequestedException extends Exception {

    public HelpRequestedException() {
    }

    public HelpRequestedException(String message) {
      super(message);
    }

    public HelpRequestedException(String message, Throwable cause) {
      super(message, cause);
    }

    public HelpRequestedException(Throwable cause) {
      super(cause);
    }

    public HelpRequestedException(String message, Throwable cause, boolean enableSuppression,
        boolean writableStackTrace) {
      super(message, cause, enableSuppression, writableStackTrace);
    }
  }
}