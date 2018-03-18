# Logger

Logger library is a basic logger to print the logs in the console and save to the file.

### Features
  - Console sink logger
  - File sink logger
  - Benefit of adding custom implementation of logger sink to save. 

### How to use ?
Maven repository :
```sh
    <dependency>
        <groupId>org.phonepe.log</groupId>
        <artifactId>phonepe</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>
```

Configuration (Using YAML config) to initialize the Logger in the application :
```sh
sinkConfigurations: // Multiple Sink configurations
  - ts_format: "<timestamp format>"
    log_level: //Multiple log level
      - "INFO"
      - "ERROR"
      - "WARN"
    sink_type: "<CONSOLE/ FILE/ DATABASE>"
    file_location: "<File location>"
  - ts_format: "<timestamp format>"
    log_level: // Multiple log level
      - "FATAL"
      - "VERBOSE"
      - "DEBUG"
    sink_type: "<CONSOLE/ FILE/ DATABASE>"
    file_location: "<File location>"
```

Logger intialization :
```sh
Logger logger = new LoggerImpl(<Log configuration path>);
```

Logging :
```sh
      logger.info(<namespace>, <message>);
      logger.error(<namespace>, <message>);
      logger.fatal(<namespace>, <message>);
      logger.verbose(<namespace>, <message>);
      logger.warn(<namespace>, <message>);
```

To implement custom sink : 
```sh
      CustomSink {
        CustomSink() {
            // Build Sink using Configuration builder  
        }
        
        @Override
        writeToSink() {
            // Function to save the data to sink 
        }
      }
      
      // To Log
      logger.warn(<namespace>, <message>, CustomSinkInstance);
```

Log statement : 
```sh
    [2018-03-18 20:40:52] INFO : org.phonepe.log.TestLoggerClass : Hello 
    [<Timestamp>] <Loglevel> : <namespace> : <message>
```

### TODO 
  - Database sink
  - Modes of writing log to sink (Sync or Async)
  - Benefit of adding custom implementation of logger sink to save. 

