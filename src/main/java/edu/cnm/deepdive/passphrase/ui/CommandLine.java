package edu.cnm.deepdive.passphrase.ui;

import edu.cnm.deepdive.passphrase.Options;
import edu.cnm.deepdive.passphrase.RandomArtifactGenerator;
import edu.cnm.deepdive.passphrase.RandomPassphraseGenerator;
import edu.cnm.deepdive.passphrase.RandomPasswordGenerator;
import edu.cnm.deepdive.passphrase.util.Constants;
import edu.cnm.deepdive.passphrase.util.UsageStrings;
import java.security.SecureRandom;
import java.util.Map;
import java.util.ResourceBundle;

/**
 *
 */
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
            RandomArtifactGenerator generator;

            if (passwordMode) {
                generator = new RandomPasswordGenerator();
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
                generator = new RandomPassphraseGenerator();
                for (String key : map.keySet()) {
                    switch (key) {
                        // TODO - invoke setters on passphrase generator
                        case Constants.NO_REPEAT_OPTION:
                            generator.setRepeatedAllowed(false);
                            break;
                        case Constants.LENGTH_OPTION:
                            generator.setLength(((Number) map.get(Constants.LENGTH_OPTION)).intValue());
                            break;
                        case Constants.DELIMITER_OPTION:
                            ((RandomPassphraseGenerator) generator)
                                .setDelimiter(((String) map.get(Constants.DELIMITER_OPTION)).charAt(0));
                            break;
                    }
                }
            }
            generator.setRng(new SecureRandom());
            System.out.println(generator.generate());
        } catch (Exception ex) {
            System.exit(-1);
        }


    }
}