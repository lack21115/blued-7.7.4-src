package com.j256.ormlite.logger;

public class LoggerFactory {
  public static final String LOG_TYPE_SYSTEM_PROPERTY = "com.j256.ormlite.logger.type";
  
  private static LogType logType;
  
  private static LogType findLogType() {
    String str = System.getProperty("com.j256.ormlite.logger.type");
    if (str != null)
      try {
        return LogType.valueOf(str);
      } catch (IllegalArgumentException illegalArgumentException) {
        LocalLog localLog = new LocalLog(LoggerFactory.class.getName());
        Log.Level level = Log.Level.WARNING;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Could not find valid log-type from system property 'com.j256.ormlite.logger.type', value '");
        stringBuilder.append(str);
        stringBuilder.append("'");
        localLog.log(level, stringBuilder.toString());
      }  
    for (LogType logType : LogType.values()) {
      if (logType.isAvailable())
        return logType; 
    } 
    return LogType.LOCAL;
  }
  
  public static Logger getLogger(Class<?> paramClass) {
    return getLogger(paramClass.getName());
  }
  
  public static Logger getLogger(String paramString) {
    if (logType == null)
      logType = findLogType(); 
    return new Logger(logType.createLog(paramString));
  }
  
  public static String getSimpleClassName(String paramString) {
    String[] arrayOfString = paramString.split("\\.");
    return (arrayOfString.length <= 1) ? paramString : arrayOfString[arrayOfString.length - 1];
  }
  
  public enum LogType {
    ANDROID("android.util.Log", "com.j256.ormlite.android.AndroidLog"),
    COMMONS_LOGGING("android.util.Log", "com.j256.ormlite.android.AndroidLog"),
    LOCAL("android.util.Log", "com.j256.ormlite.android.AndroidLog"),
    LOG4J("android.util.Log", "com.j256.ormlite.android.AndroidLog"),
    LOG4J2("android.util.Log", "com.j256.ormlite.android.AndroidLog"),
    SLF4J("org.slf4j.LoggerFactory", "com.j256.ormlite.logger.Slf4jLoggingLog");
    
    private final String detectClassName;
    
    private final String logClassName;
    
    static {
      LOG4J = new LogType("LOG4J", 4, "org.apache.log4j.Logger", "com.j256.ormlite.logger.Log4jLog");
      LOCAL = new null("LOCAL", 5, LocalLog.class.getName(), LocalLog.class.getName());
      $VALUES = new LogType[] { ANDROID, SLF4J, COMMONS_LOGGING, LOG4J2, LOG4J, LOCAL };
    }
    
    LogType(String param1String1, String param1String2) {
      this.detectClassName = param1String1;
      this.logClassName = param1String2;
    }
    
    public Log createLog(String param1String) {
      try {
        return createLogFromClassName(param1String);
      } catch (Exception exception) {
        LocalLog localLog = new LocalLog(param1String);
        Log.Level level = Log.Level.WARNING;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to call constructor with single String argument for class ");
        stringBuilder.append(this.logClassName);
        stringBuilder.append(", so had to use local log: ");
        stringBuilder.append(exception.getMessage());
        localLog.log(level, stringBuilder.toString());
        return localLog;
      } 
    }
    
    Log createLogFromClassName(String param1String) throws Exception {
      return Class.forName(this.logClassName).getConstructor(new Class[] { String.class }).newInstance(new Object[] { param1String });
    }
    
    public boolean isAvailable() {
      if (!isAvailableTestClass())
        return false; 
      try {
        createLogFromClassName(getClass().getName()).isLevelEnabled(Log.Level.INFO);
        return true;
      } catch (Exception exception) {
        return false;
      } 
    }
    
    boolean isAvailableTestClass() {
      try {
        Class.forName(this.detectClassName);
        return true;
      } catch (Exception exception) {
        return false;
      } 
    }
  }
  
  enum null {
    public Log createLog(String param1String) {
      return new LocalLog(param1String);
    }
    
    public boolean isAvailable() {
      return true;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\logger\LoggerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */