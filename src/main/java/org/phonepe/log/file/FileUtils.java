package org.phonepe.log.file;

import java.io.File;

public class FileUtils {

  public static boolean isWritable(String pathLocn) {
    File file = new File(pathLocn);
    if (file.exists()) {
      return file.canWrite();
    } else {
      String[] path = pathLocn.split("/");
      path[path.length - 1] = "";

      if (isDirectoryWritable(String.join("/", path))) {
        return true;
      }

      path[path.length - 2] = "";

      return isDirectoryWritable(String.join("/", path));
    }
  }

  public static boolean isDirectoryWritable(String pathLocn) {
    File file = new File(pathLocn);
    return file != null && file.exists() && file.canWrite();
  }

}
