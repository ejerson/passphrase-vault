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

            boolean passwordMode = map.containsKey(Constants.PASSWORD_MODE_OPTION);
            RandomArtifactGenerator generator;

            if (passwordMode) {
                generator = new RandomPasswordGenerator();
                for (String key : map.keySet()) {
                    switch (key) {
                        case Constants.NO_REPEAT_OPTION:
                            generator.setRepeatedAllowed(false);
                            break;
                        case Constants.NO_UPPER_OPTION:
                          ((RandomPasswordGenerator) generator)
                              .setUppercaseExcluded(true);
                            break;
                        case Constants.NO_LOWER_OPTION:
                          ((RandomPasswordGenerator) generator)
                              .setLowercaseExcluded(true);
                            break;
                        case Constants.NO_DIGITS_OPTION:
                            ((RandomPasswordGenerator) generator)
                                .setDigitsExcluded(true);
                            break;
                        case Constants.NO_AMBIGUOUS_CHARACTERS_OPTION:
                            ((RandomPasswordGenerator) generator)
                                .setAmbiguousExcluded(true);
                            break;
                        case Constants.EXCLUDES_ORDER_OPTION:
                            ((RandomPasswordGenerator) generator)
                                .setOrderExcluded(true);
                            break;
                        case Constants.EXCLUDES_SYMBOLS_OPTION:
                            ((RandomPasswordGenerator) generator)
                                .setSymbolsExcluded(true);
                            break;
                        case Constants.LENGTH_OPTION:
                            generator.setLength(((Number) map.get(Constants.LENGTH_OPTION)).intValue());
                            break;
                    }

                }
            } else {
                //passphrase mode
                generator = new RandomPassphraseGenerator();
                for (String key : map.keySet()) {
                    switch (key) {
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