package org.phonepe.log.configuration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.IOException;

public class ConfigurationInterpreterImpl implements  ConfigurationInterpreter{

  @Override
  public Configuration interpretConfiguration(String pathToConfig) throws IOException{
    ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    return mapper.readValue(new File(pathToConfig), Configuration.class);
  }

}
