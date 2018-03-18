package org.phonepe.log;

import java.io.IOException;
import org.phonepe.log.configuration.Configuration;
import org.phonepe.log.configuration.ConfigurationInterpreter;
import org.phonepe.log.configuration.ConfigurationInterpreterImpl;
import org.phonepe.log.exception.LoggerException;

public class TestLoggerClass {

  public static void main(String[] args) {

    ConfigurationInterpreter configurationInterpreter = new ConfigurationInterpreterImpl();

    try {
      Configuration configuration = configurationInterpreter.interpretConfiguration(
          "/Users/ebizu/Work/opensrcprojects/Logger/src/main/resources/config.yaml"
      );

      Logger logger = new LoggerImpl("/Users/ebizu/Work/opensrcprojects/Logger/src/main/resources/config1.yaml");


      logger.info(TestLoggerClass.class.getName(), "Hello");

      logger.error(TestLoggerClass.class.getName(), "Hello");

      logger.fatal(TestLoggerClass.class.getName(), "Hello");

      logger.verbose(TestLoggerClass.class.getName(), "Hello");

      logger.warn(TestLoggerClass.class.getName(), "Hello");


    } catch (IOException | LoggerException e) {
      e.printStackTrace();
    }

  }

}
