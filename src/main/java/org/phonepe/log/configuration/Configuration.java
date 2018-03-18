package org.phonepe.log.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Configuration {

  SinkConfiguration[] sinkConfigurations;

}
