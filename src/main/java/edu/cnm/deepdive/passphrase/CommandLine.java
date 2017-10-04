package edu.cnm.deepdive.passphrase;

import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class CommandLine {

  public static void main(String[] args) {
    try {
      Options options = buildOptions();
      CommandLineParser parser = new DefaultParser();
      org.apache.commons.cli.CommandLine cmdLine = parser.parse(options, args);
      if(cmdLine.hasOption("?")) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("java " + CommandLine.class.getName(),
                             options);
      }
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  // defines my options
  private static Options buildOptions() {
                            //returns a builder      //this list of options can be in any order I want
    Option sampleOpt =      Option.builder("s").argName("value") // set its arg name
                                               .optionalArg(true) // mark the builder object as an optional option
                                               .hasArg(true)
                                               .numberOfArgs(1)
                                               .longOpt("sample")
                                               .desc("Silly description")
                                               .required()
                                               .type(Number.class)
                                               .build(); // returns an option
    Option switchOpt =      Option.builder("x").hasArg(false)
                                               .longOpt("exclude")
                                               .desc("Another description")
                                               .build();
    Option helpOpt =        Option.builder("?").longOpt("help")
                                               .required(false)
                                               .hasArg(false)
                                               .desc("Display this screen")
                                               .build();
    Options options = new Options();
    options.addOption(sampleOpt);
    options.addOption(switchOpt);
    options.addOption(helpOpt);
    return options;
  }

}
