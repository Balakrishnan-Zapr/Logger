package org.phonepe.log.constants;

public class Constants {

  public static final String MESSAGE_FORMAT = "[%s] %s : %s : %s %s";

  public class LogLevel {
    public static final String ERROR = "ERROR";
    public static final String FATAL = "FATAL";
    public static final String WARN = "WARN";
    public static final String DEBUG = "DEBUG";
    public static final String INFO = "INFO";
    public static final String VERBOSE = "VERBOSE";

  }

  public class SinkType {
    public static final String CONSOLE = "CONSOLE";
    public static final String DATABASE = "DB";
    public static final String FILE = "FILE";
  }

}
