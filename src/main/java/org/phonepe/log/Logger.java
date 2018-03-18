package org.phonepe.log;

import org.phonepe.log.sink.Sink;

public interface Logger {

  public void fatal(String namespace, String message);
  public void error(String namespace, String message);
  public void warn(String namespace, String message);
  public void info(String namespace, String message);
  public void debug(String namespace, String message);
  public void verbose(String namespace, String message);


  public void fatal(String namespace, String message, Sink sink);
  public void error(String namespace, String message, Sink sink);
  public void warn(String namespace, String message, Sink sink);
  public void info(String namespace, String message, Sink sink);
  public void debug(String namespace, String message, Sink sink);
  public void verbose(String namespace, String message, Sink sink);


}
