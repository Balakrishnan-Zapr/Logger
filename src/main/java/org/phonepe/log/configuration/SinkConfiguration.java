package org.phonepe.log.configuration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@JsonIgnoreProperties
@Builder
public class SinkConfiguration {

  @JsonProperty("ts_format")
  private String timestampFormat;
  @JsonProperty("log_level")
  private String[] logLevel;

  // FILE / DB / CONSOLE
  @JsonProperty("sink_type")
  private String sinkType;

  @JsonProperty("file_location")
  private String fileLocation;

  private DatabaseConfiguration databaseConfiguration;

  @JsonProperty("thread_model")
  private String threadMode; // SINGLE / MULTI

  @JsonProperty("write_mode")
  private String writeMode; // SYNC / ASYNC

}
