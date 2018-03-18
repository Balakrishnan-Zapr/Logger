package org.phonepe.log.sink;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.phonepe.log.configuration.SinkConfiguration;
import org.phonepe.log.constants.Constants;

public class ConsoleSink extends Sink {

  private SimpleDateFormat simpleDateFormat;

  public ConsoleSink(SinkConfiguration sinkConfiguration) {
    this.simpleDateFormat = new SimpleDateFormat(sinkConfiguration.getTimestampFormat());
  }

  @Override
  public void writeToSink(String logLevel, String message, String namespace) {
    String timestamp = simpleDateFormat.format(new Date(System.currentTimeMillis()));
    if (logLevel.equalsIgnoreCase(Constants.LogLevel.ERROR) ||
        logLevel.equalsIgnoreCase(Constants.LogLevel.FATAL)) {
      System.err.format(Constants.MESSAGE_FORMAT, timestamp, logLevel, namespace, message,
          "");
    }
    System.out.format(Constants.MESSAGE_FORMAT, timestamp, logLevel, namespace, message,
        "");
  }


}
