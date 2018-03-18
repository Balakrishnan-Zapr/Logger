package org.phonepe.log.configuration;

import java.io.IOException;

public interface ConfigurationInterpreter {

  public Configuration interpretConfiguration(String pathToConfig) throws IOException;

}
