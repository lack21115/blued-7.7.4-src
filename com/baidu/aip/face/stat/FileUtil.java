package com.baidu.aip.face.stat;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtil {
  private static final String TAG = "FileUtil";
  
  private FileUtil() {
    throw new RuntimeException("This class instance can not be created.");
  }
  
  public static boolean createFile(File paramFile) {
    if (paramFile == null)
      return false; 
    if (paramFile.getParentFile() != null && !paramFile.getParentFile().exists())
      paramFile.getParentFile().mkdirs(); 
    if (paramFile.exists() && paramFile.length() > 3145728L)
      paramFile.delete(); 
    if (!paramFile.exists())
      try {
        paramFile.createNewFile();
      } catch (IOException iOException) {
        iOException.printStackTrace();
        return false;
      }  
    return true;
  }
  
  public static boolean loadPropertiesFile(File paramFile, Properties paramProperties) {
    File file2 = null;
    IOException iOException = null;
    try {
      BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(paramFile));
      try {
      
      } catch (Exception null) {
      
      } finally {
        Properties properties;
        paramProperties = null;
        iOException = iOException1;
      } 
    } catch (Exception exception) {
      paramFile = file2;
    } finally {}
    File file1 = paramFile;
    exception.printStackTrace();
    if (paramFile != null)
      try {
        paramFile.close();
        return false;
      } catch (IOException iOException1) {
        return false;
      }  
    return false;
  }
  
  public static boolean savePropertiesFile(File paramFile, Properties paramProperties) {
    File file2 = null;
    IOException iOException = null;
    try {
      BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(paramFile));
      try {
      
      } catch (Exception null) {
      
      } finally {
        Properties properties;
        paramProperties = null;
        iOException = iOException1;
      } 
    } catch (Exception exception) {
      paramFile = file2;
    } finally {}
    File file1 = paramFile;
    exception.printStackTrace();
    if (paramFile != null)
      try {
        paramFile.close();
        return false;
      } catch (IOException iOException1) {
        return false;
      }  
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\aip\face\stat\FileUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */