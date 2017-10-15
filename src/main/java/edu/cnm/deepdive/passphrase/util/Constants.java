package edu.cnm.deepdive.passphrase.util;

//keys for accessing resource bundle properties, resources

public class Constants {

  /**Resource bundle key for Usage Strings  */
  public static final String USAGE_BUNDLE = "usage-strings";
  /** Resource bundle key for Dice ware words  */
  public static final String WORDS_BUNDLE = "diceware-words";



  /** Usage string key for excluding repeated characters*/
  public static final String EXCLUDES_REPEAT = "repeatExcluded";
  /** Usage string key for excluding Uppercase characters*/
  public static final String EXCLUDES_UPPERCASE = "uppercaseExcluded";
  /** Usage string key for excluding Lowercase characters*/
  public static final String EXCLUDES_LOWERCASE = "lowercaseExcluded";
  /** Usage string key for excluding Digit characters*/
  public static final String EXCLUDES_DIGITS = "digitsExcluded";
  /** Usage string key for excluding Symbols*/
  public static final String EXCLUDES_SYMBOLS = "symbolsExcluded";
  /** Usage string key for excluding Ambiguous characters*/
  public static final String EXCLUDES_AMBIGUOUS = "ambiguousExcluded";
  /** Usage string key for excluding Ordered sequences*/
  public static final String EXCLUDES_ORDER = "orderExcluded";




  /** Usage string key for specifying length*/
  public static final String SPECIFY_LENGTH = "specifyLength";
  /** Usage string key for specifying Delimiter*/
  public static final String SPECIFY_DELIMITER = "specifyDelimiter";
  /** Defines the minimum password length*/
  public static final int MINIMUM_PASSWORD_LENGTH = 5;
  /** Defines the maximum password length*/
  public static final int MAXIMUM_PASSWORD_LENGTH = 20;
  /** Defines the minimum passphrase length*/
  public static final int MINIMUM_PASSPHRASE_LENGTH = 7;
  /** Defines the maximum passphrase length*/
  public static final int MAXIMUM_PASSPHRASE_LENGTH = 12;
  /** Defines the delimiters to chose from*/
  public static final char[] DELIMITER_SELECTION = {'_','-','*'};

  /** Defines the mode switch string key*/
  public static final String MODE_SWITCH = "modeSwitch";


  /** Defines the Help Message string*/
  public static final String HELP_MSG = "helpMsg";



  /** Usage string key for  Mode select error message*/
  public static final String MODE_SELECT_ERROR = "modeSelectError";
  /** Usage string key for  length error message*/
  public static final String LENGTH_ERROR = "lengthError";
  /** Usage string key for  for Argument error message*/
  public static final String ARGUMENT_ERROR = "argumentError";
  /** Usage string key for  Delimiter error message*/
  public static final String DELIMITER_ERROR = "delimiterErrorMessage";


  /** Usage string key for  Excluded Symbols Args*/
  public static final String EXCLUDES_SYMBOLS_ARGS = "excludesSymbolsArgs";
  /** Usage string key for Specify Length Args*/
  public static final String SPECIFY_LENGTH_ARGS = "specifyLengthArgs";
  /** Usage string key for  Specify Delimiter Args*/
  public static final String SPECIFY_DELEMITER_ARGS = "specifyDelimiterArgs";



  /**Long option for no Repeat Option*/
  public static final String NO_REPEAT_OPTION = "no-repeat";
  /**Long option for no Uppercase Option*/
  public static final String NO_UPPER_OPTION = "no-upper";
  /**Long option for no Lowercase Option*/
  public static final String NO_LOWER_OPTION = "no-lower";
  /**Long option for no Digits Option*/
  public static final String NO_DIGITS_OPTION = "no-digits";
  /**Long option for no Ambiguous Characters Option*/
  public static final String NO_AMBIGUOUS_CHARACTERS_OPTION = "no-ambiguous-characters";
  /**Long option for Exclude Order Option*/
  public static final String EXCLUDES_ORDER_OPTION = "exclude-order";
  /**Long option for Exclude Symbols Option*/
  public static final String EXCLUDES_SYMBOLS_OPTION = "exclude-symbols";
  /**Long option for Length Option*/
  public static final String LENGTH_OPTION = "length";
  /**Long option for Delimiter Option*/
  public static final String DELIMITER_OPTION = "delimiter";
  /**Long option for Help Option*/
  public static final String HELP_OPTION = "help";
  /**Long option for Password Mode Option*/
  public static final String PASSWORD_MODE_OPTION = "password-mode";

  /**Default value if Repeat is allowed*/
  public static final boolean DEFAULT_REPEAT_ALLOWED = true;
  /**Default value for Delimiter*/
  public static final char DEFAULT_DELIMITER = ' ';
  /**Default value for Passphrase Length*/
  public static final int DEFAULT_PASSPHRASE_LENGTH = 6;
  /**Default value for Password Length*/
  public static final int DEFAULT_PASSWORD_LENGTH = 12;
  /**Default Order Configuration*/
  public static final boolean DEFAULT_ORDER_CONFIGURATION = false;
  /**Default of Uppercase Exclusion*/
  public static final boolean DEFAULT_EXCLUDES_UPPERCASE = false;
  /**Default of Lowercase Exclusion*/
  public static final boolean DEFAULT_EXCLUDES_LOWERCASE = false;
  /**Default of Digits Exclusion*/
  public static final boolean DEFAULT_EXCLUDES_DIGITS = false;
  /**Default of Symbols Exclusion*/
  public static final boolean DEFAULT_EXCLUDES_SYMBOLS = false;
  /**Default of Ambiguous Characters Exclusion*/
  public static final boolean DEFAULT_EXCLUDES_AMBIGUOUS = false;


  /**Uppercase Character String*/
  public static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  /**Lowercase Character String*/
  public static final String LOWERCASE = UPPERCASE.toLowerCase();
  /**Digits String*/
  public static final String DIGITS = "0123456789";
  /**Symbols String*/
  public static final String SYMBOLS = "*!<>?/@#$%^&()-+_,.\\|{}[]~`:;\'\"";
  /**Ambiguous Character String*/
  public static final char[] AMBIGUOUS = {'l', '1', 'o', 'O'};
  /**Maximum sequence of Ordered Characters*/
  public static final int MAX_ORDER_LENGTH = 2;


  /** Usage String key for Length Warning Messages*/
  public static final String LENGTH_WARNING = "lengthWarning";
  /** Usage String key for Mode Warning Messages*/
  public static final String MODE_WARNING = "modeWarning";
  /** Usage String key for Repeat Warning Messages*/
  public static final String REPEAT_WARNING = "repeatWarning";
  /** Usage String key for Unrecognized Option*/
  public static final String UNRECOGNIZED_OPTION = "unrecognizedOption";
  /** Usage String key for Missing Option*/
  public static final String MISSING_OPTION = "missingOption";
  /** Usage String key for Uppercase Warning*/
  public static final String UPPERCASE_WARNING = "uppercaseWarning";
  /** Usage String key for Lowercase Warning*/
  public static final String LOWERCASE_WARNING = "lowercaseWarning";
  /** Usage String key for Digit Warning*/
  public static final String DIGIT_WARNING = "digitWarning";
  /** Usage String key for Ambiguous Character Warning*/
  public static final String AMBIGUOUS_WARNING = "ambiguousWarning";
  /** Usage String key for Order Warning*/
  public static final String ORDER_WARNING = "orderWarning";
  /** Usage String key for Symbol Warning*/
  public static final String SYMBOL_WARNING = "symbolWarning";
  /** Usage String key for Delimiter Warning*/
  public static final String DELIMITER_WARNING = "delimiterWarning";
}


