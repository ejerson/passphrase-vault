package edu.cnm.deepdive.passphrase.ui;

import edu.cnm.deepdive.passphrase.Options;
import edu.cnm.deepdive.passphrase.util.Constants;
import edu.cnm.deepdive.passphrase.util.UsageStrings;
import java.util.Map;
import java.util.ResourceBundle;

public class CommandLine {

    public static void main(String[] args) {
        ResourceBundle resourceBundle = UsageStrings.getBundle();
        try {
            Options options = new Options(args);
            Map<String, Object> map = options.map;

            for (Map.Entry<String, Object> entry : map.entrySet()) {
                System.out.printf("%s = %s%n", entry.getKey(), entry.getValue());

            }
            boolean passwordMode = map.containsKey(Constants.PASSWORD_MODE_OPTION);
            if (passwordMode) {
                for (String key : map.keySet()) {
                    switch (key) {
                        // TODO - invoke setters on password generator
                        case Constants.EXCLUDES_REPEAT:
                            System.out.println(Constants.REPEAT_WARNING);
                            break;
                        case Constants.EXCLUDES_UPPERCASE:
                            System.out.println(Constants.UPPERCASE_WARNING);
                            break;
                        case Constants.EXCLUDES_LOWERCASE:
                            System.out.println(Constants.LOWERCASE_WARNING);
                            break;
                        case Constants.EXCLUDES_DIGITS:
                            System.out.println(Constants.DIGIT_WARNING);
                            break;
                        case Constants.EXCLUDES_AMBIGUOUS:
                            System.out.println(Constants.AMBIGUOUS_WARNING);
                            break;
                        case Constants.EXCLUDES_ORDER:
                            System.out.println(Constants.ORDER_WARNING);
                            break;
                        case Constants.EXCLUDES_SYMBOLS:
                            System.out.println(Constants.SYMBOL_WARNING);
                            break;
                        case Constants.SPECIFY_LENGTH:
                            System.out.println(Constants.LENGTH_WARNING);
                            break;
                    }

                }
            } else {
                //passphrase mode
                for (String key : map.keySet()) {
                    switch (key) {
                        // TODO - invoke setters on password generator
                        case Constants.NO_REPEAT_OPTION:
                            System.out.println(Constants.REPEAT_WARNING);
                            break;
                        case Constants.SPECIFY_LENGTH:
                            System.out.println(Constants.LENGTH_WARNING);
                            break;
                        case Constants.SPECIFY_DELIMITER:
                            System.out.println(Constants.DELIMITER_WARNING);
                            break;
                        case Constants.PASSWORD_MODE_OPTION:
                            System.out.println(Constants.MODE_WARNING);
                            break;

                    }
                }
            }
        } catch (Exception ex) {
            System.exit(-1);
        }


    }
}