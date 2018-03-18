package org.phonepe.log.sink;

import org.phonepe.log.configuration.SinkConfiguration;

public abstract class Sink {

  Sink() {}

  Sink(SinkConfiguration sinkConfiguration) {}

  public void writeToSink(String logLevel, String message, String namespace) {}

}
