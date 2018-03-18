package org.phonepe.log.sink;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.phonepe.log.configuration.SinkConfiguration;
import org.phonepe.log.constants.Constants;

public class FileSink extends Sink {

  private SinkConfiguration sinkConfiguration;
  private Map<String, FileWriter> fileMap = new HashMap<String, FileWriter>();
  private FileWriter fileWriter = null;
  private SimpleDateFormat simpleDateFormat;

  FileSink(SinkConfiguration sinkConfiguration) {
    this.sinkConfiguration = sinkConfiguration;
    this.fileWriter = getFileWriter(sinkConfiguration.getFileLocation());
    this.simpleDateFormat = new SimpleDateFormat(sinkConfiguration.getTimestampFormat());
  }

  private FileWriter getFileWriter(String fileLocation){
    try {
      File file = new File(fileLocation);

      if (!file.exists()) {
        createIfNotExistsDirectory(fileLocation);
        file.createNewFile();
      }

      return new FileWriter(fileLocation, true);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public void createIfNotExistsDirectory(String fileLocation) {
    String[] filePath = fileLocation.split("/");
    filePath[filePath.length - 1] = "";
    File file = new File(String.join("/", filePath));
    if (!file.exists()) {
      file.mkdirs();
    }
  }

  @Override
  public void writeToSink(String logLevel, String message, String namespace) {
    String timestamp = simpleDateFormat.format(new Date(System.currentTimeMillis()));
    try {
      fileWriter.append(
          String.format(Constants.MESSAGE_FORMAT, timestamp, logLevel, namespace, message));
      fileWriter.flush();
      fileWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
