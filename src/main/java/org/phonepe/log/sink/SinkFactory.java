package org.phonepe.log.sink;


import org.phonepe.log.configuration.SinkConfiguration;
import org.phonepe.log.constants.Constants.SinkType;

public class SinkFactory {

  public static Sink getSink(SinkConfiguration sinkConfiguration) {

    if (sinkConfiguration == null) {
      sinkConfiguration = SinkConfiguration.builder()
          .sinkType(SinkType.CONSOLE)
          .timestampFormat("yyyy-MM-dd HH:mm:ss")
          .build();
      return new ConsoleSink(sinkConfiguration);
    }

    switch (sinkConfiguration.getSinkType().toUpperCase()) {
      case SinkType.CONSOLE : {
        return new ConsoleSink(sinkConfiguration);
      }

      case SinkType.FILE : {
        return new FileSink(sinkConfiguration);
      }

      // TODO : Database Sink
      case SinkType.DATABASE : {
        return new ConsoleSink(sinkConfiguration);
      }

      default : {
        return new ConsoleSink(sinkConfiguration);
      }

    }


  }

}
