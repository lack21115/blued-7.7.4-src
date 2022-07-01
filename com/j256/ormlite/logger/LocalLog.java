package com.j256.ormlite.logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class LocalLog implements Log {
  private static final Log.Level DEFAULT_LEVEL = Log.Level.DEBUG;
  
  public static final String LOCAL_LOG_FILE_PROPERTY = "com.j256.ormlite.logger.file";
  
  public static final String LOCAL_LOG_LEVEL_PROPERTY = "com.j256.ormlite.logger.level";
  
  public static final String LOCAL_LOG_PROPERTIES_FILE = "/ormliteLocalLog.properties";
  
  private static final List<PatternLevel> classLevels;
  
  private static final ThreadLocal<DateFormat> dateFormatThreadLocal = new ThreadLocal<DateFormat>() {
      protected DateFormat initialValue() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
      }
    };
  
  private static PrintStream printStream;
  
  private final String className;
  
  private final Log.Level level;
  
  static {
    classLevels = readLevelResourceFile(LocalLog.class.getResourceAsStream("/ormliteLocalLog.properties"));
    openLogFile(System.getProperty("com.j256.ormlite.logger.file"));
  }
  
  public LocalLog(String paramString) {
    this.className = LoggerFactory.getSimpleClassName(paramString);
    List<PatternLevel> list = classLevels;
    PatternLevel patternLevel2 = null;
    PatternLevel patternLevel3 = null;
    if (list != null) {
      Iterator<PatternLevel> iterator = list.iterator();
      while (true) {
        patternLevel2 = patternLevel3;
        if (iterator.hasNext()) {
          patternLevel2 = iterator.next();
          if (patternLevel2.pattern.matcher(paramString).matches() && (patternLevel3 == null || patternLevel2.level.ordinal() < patternLevel3.ordinal()))
            Log.Level level = patternLevel2.level; 
          continue;
        } 
        break;
      } 
    } 
    PatternLevel patternLevel1 = patternLevel2;
    if (patternLevel2 == null) {
      String str = System.getProperty("com.j256.ormlite.logger.level");
      if (str == null) {
        Log.Level level = DEFAULT_LEVEL;
      } else {
        try {
          Log.Level level = Log.Level.valueOf(str.toUpperCase());
        } catch (IllegalArgumentException illegalArgumentException) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Level '");
          stringBuilder.append(str);
          stringBuilder.append("' was not found");
          throw new IllegalArgumentException(stringBuilder.toString(), illegalArgumentException);
        } 
      } 
    } 
    this.level = (Log.Level)illegalArgumentException;
  }
  
  private static List<PatternLevel> configureClassLevels(InputStream paramInputStream) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
    ArrayList<PatternLevel> arrayList = new ArrayList();
    while (true) {
      PrintStream printStream;
      String str = bufferedReader.readLine();
      if (str == null)
        return arrayList; 
      if (str.length() == 0 || str.charAt(0) == '#')
        continue; 
      String[] arrayOfString = str.split("=");
      if (arrayOfString.length != 2) {
        printStream = System.err;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Line is not in the format of 'pattern = level': ");
        stringBuilder.append(str);
        printStream.println(stringBuilder.toString());
        continue;
      } 
      Pattern pattern = Pattern.compile(printStream[0].trim());
      try {
        Log.Level level = Log.Level.valueOf(printStream[1].trim());
        arrayList.add(new PatternLevel(pattern, level));
      } catch (IllegalArgumentException illegalArgumentException) {
        PrintStream printStream1 = System.err;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Level '");
        stringBuilder.append((String)printStream[1]);
        stringBuilder.append("' was not found");
        printStream1.println(stringBuilder.toString());
      } 
    } 
  }
  
  public static void openLogFile(String paramString) {
    if (paramString == null) {
      printStream = System.out;
      return;
    } 
    try {
      printStream = new PrintStream(new File(paramString));
      return;
    } catch (FileNotFoundException fileNotFoundException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Log file ");
      stringBuilder.append(paramString);
      stringBuilder.append(" was not found");
      throw new IllegalArgumentException(stringBuilder.toString(), fileNotFoundException);
    } 
  }
  
  private void printMessage(Log.Level paramLevel, String paramString, Throwable paramThrowable) {
    if (!isLevelEnabled(paramLevel))
      return; 
    StringBuilder stringBuilder = new StringBuilder(128);
    stringBuilder.append(((DateFormat)dateFormatThreadLocal.get()).format(new Date()));
    stringBuilder.append(" [");
    stringBuilder.append(paramLevel.name());
    stringBuilder.append("] ");
    stringBuilder.append(this.className);
    stringBuilder.append(' ');
    stringBuilder.append(paramString);
    printStream.println(stringBuilder.toString());
    if (paramThrowable != null)
      paramThrowable.printStackTrace(printStream); 
  }
  
  static List<PatternLevel> readLevelResourceFile(InputStream paramInputStream) {
    if (paramInputStream != null)
      try {
        List<PatternLevel> list = configureClassLevels(paramInputStream);
        try {
          paramInputStream.close();
          return list;
        } catch (IOException iOException) {
          return list;
        } 
      } catch (IOException iOException1) {
        PrintStream printStream = System.err;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("IO exception reading the log properties file '/ormliteLocalLog.properties': ");
        stringBuilder.append(iOException1);
        printStream.println(stringBuilder.toString());
        try {
          iOException.close();
        } catch (IOException iOException2) {}
      } finally {
        Exception exception;
      }  
    return null;
  }
  
  void flush() {
    printStream.flush();
  }
  
  public boolean isLevelEnabled(Log.Level paramLevel) {
    return this.level.isEnabled(paramLevel);
  }
  
  public void log(Log.Level paramLevel, String paramString) {
    printMessage(paramLevel, paramString, null);
  }
  
  public void log(Log.Level paramLevel, String paramString, Throwable paramThrowable) {
    printMessage(paramLevel, paramString, paramThrowable);
  }
  
  static class PatternLevel {
    Log.Level level;
    
    Pattern pattern;
    
    public PatternLevel(Pattern param1Pattern, Log.Level param1Level) {
      this.pattern = param1Pattern;
      this.level = param1Level;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\logger\LocalLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */