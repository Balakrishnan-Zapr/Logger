package org.phonepe.log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.phonepe.log.configuration.Configuration;
import org.phonepe.log.configuration.ConfigurationInterpreter;
import org.phonepe.log.configuration.ConfigurationInterpreterImpl;
import org.phonepe.log.configuration.SinkConfiguration;
import org.phonepe.log.constants.Constants;
import org.phonepe.log.constants.Constants.LogLevel;
import org.phonepe.log.constants.Constants.SinkType;
import org.phonepe.log.exception.LoggerException;
import org.phonepe.log.file.FileUtils;
import org.phonepe.log.sink.ConsoleSink;
import org.phonepe.log.sink.Sink;
import org.phonepe.log.sink.SinkFactory;

public class LoggerImpl implements Logger{

  private Map<String, SinkConfiguration> configurationMap = new HashMap<>();


  public LoggerImpl(String configurationPath) throws LoggerException {

    ConfigurationInterpreter configurationInterpreter = new ConfigurationInterpreterImpl();
    Configuration configuration = null;

    try {
      configuration = configurationInterpreter.interpretConfiguration(
          configurationPath
      );
    } catch (IOException e) {
      error("Logger", "Configuration is not available, using default logger configuration");
    }

    if (configuration != null) {

      for (SinkConfiguration sinkConfiguration : configuration.getSinkConfigurations()) {
        for (String logLevel : sinkConfiguration.getLogLevel()) {
          configurationMap.put(logLevel, sinkConfiguration);

          if (sinkConfiguration.getSinkType().equalsIgnoreCase(SinkType.FILE)) {
            if (!FileUtils.isWritable(sinkConfiguration.getFileLocation())) {
              throw new LoggerException("Unable to write to file, write permission is unavailable");
            }
          }

        }
      }
    }

  }

  @Override
  public void fatal(String namespace, String message) {

      fatal(namespace, message, SinkFactory.getSink(configurationMap.get(LogLevel.FATAL)));

  }

  @Override
  public void error(String namespace, String message) {

      error(namespace, message, SinkFactory.getSink(configurationMap.get(LogLevel.ERROR)));

  }

  @Override
  public void warn(String namespace, String message) {

      warn(namespace, message, SinkFactory.getSink(configurationMap.get(LogLevel.WARN)));

  }

  @Override
  public void info(String namespace, String message) {
      info(namespace, message, SinkFactory.getSink(configurationMap.get(LogLevel.INFO)));

  }

  @Override
  public void debug(String namespace, String message) {
      debug(namespace, message, SinkFactory.getSink(configurationMap.get(LogLevel.DEBUG)));

  }

  @Override
  public void verbose(String namespace, String message) {
      verbose(namespace, message, SinkFactory.getSink(configurationMap.get(LogLevel.VERBOSE)));
  }




  @Override
  public void fatal(String namespace, String message, Sink sink) {
    if (sink != null) {
      sink.writeToSink(LogLevel.FATAL, message, namespace);
    }
  }

  @Override
  public void error(String namespace, String message, Sink sink) {
    sink.writeToSink(LogLevel.ERROR, message, namespace);
  }

  @Override
  public void warn(String namespace, String message, Sink sink) {
    sink.writeToSink(LogLevel.WARN, message, namespace);
  }

  @Override
  public void info(String namespace, String message, Sink sink) {
    sink.writeToSink(LogLevel.INFO, message, namespace);
  }

  @Override
  public void debug(String namespace, String message, Sink sink) {
    sink.writeToSink(LogLevel.DEBUG, message, namespace);
  }

  @Override
  public void verbose(String namespace, String message, Sink sink) {
    sink.writeToSink(LogLevel.VERBOSE, message, namespace);
  }

}
