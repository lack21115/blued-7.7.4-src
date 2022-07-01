package com.j256.ormlite.logger;

import java.util.Arrays;

public class Logger {
  private static final String ARG_STRING = "{}";
  
  private static final int ARG_STRING_LENGTH = 2;
  
  private static final Object UNKNOWN_ARG = new Object();
  
  private final Log log;
  
  public Logger(Log paramLog) {
    this.log = paramLog;
  }
  
  private void appendArg(StringBuilder paramStringBuilder, Object paramObject) {
    if (paramObject == UNKNOWN_ARG)
      return; 
    if (paramObject == null) {
      paramStringBuilder.append("null");
      return;
    } 
    if (paramObject.getClass().isArray()) {
      paramStringBuilder.append(Arrays.toString((Object[])paramObject));
      return;
    } 
    paramStringBuilder.append(paramObject);
  }
  
  private String buildFullMessage(String paramString, Object paramObject1, Object paramObject2, Object paramObject3, Object[] paramArrayOfObject) {
    int j = 0;
    StringBuilder stringBuilder = null;
    int i = 0;
    while (true) {
      int k = paramString.indexOf("{}", j);
      if (k == -1) {
        if (stringBuilder == null)
          return paramString; 
        stringBuilder.append(paramString, j, paramString.length());
        return stringBuilder.toString();
      } 
      StringBuilder stringBuilder1 = stringBuilder;
      if (stringBuilder == null)
        stringBuilder1 = new StringBuilder(128); 
      stringBuilder1.append(paramString, j, k);
      j = ARG_STRING_LENGTH + k;
      if (paramArrayOfObject == null) {
        if (!i) {
          appendArg(stringBuilder1, paramObject1);
        } else if (i == 1) {
          appendArg(stringBuilder1, paramObject2);
        } else if (i == 2) {
          appendArg(stringBuilder1, paramObject3);
        } 
      } else if (i < paramArrayOfObject.length) {
        appendArg(stringBuilder1, paramArrayOfObject[i]);
      } 
      i++;
      stringBuilder = stringBuilder1;
    } 
  }
  
  private void innerLog(Log.Level paramLevel, Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2, Object paramObject3, Object[] paramArrayOfObject) {
    if (this.log.isLevelEnabled(paramLevel)) {
      paramString = buildFullMessage(paramString, paramObject1, paramObject2, paramObject3, paramArrayOfObject);
      if (paramThrowable == null) {
        this.log.log(paramLevel, paramString);
        return;
      } 
      this.log.log(paramLevel, paramString, paramThrowable);
    } 
  }
  
  public void debug(String paramString) {
    Log.Level level = Log.Level.DEBUG;
    Object object = UNKNOWN_ARG;
    innerLog(level, null, paramString, object, object, object, null);
  }
  
  public void debug(String paramString, Object paramObject) {
    Log.Level level = Log.Level.DEBUG;
    Object object = UNKNOWN_ARG;
    innerLog(level, null, paramString, paramObject, object, object, null);
  }
  
  public void debug(String paramString, Object paramObject1, Object paramObject2) {
    innerLog(Log.Level.DEBUG, null, paramString, paramObject1, paramObject2, UNKNOWN_ARG, null);
  }
  
  public void debug(String paramString, Object paramObject1, Object paramObject2, Object paramObject3) {
    innerLog(Log.Level.DEBUG, null, paramString, paramObject1, paramObject2, paramObject3, null);
  }
  
  public void debug(String paramString, Object[] paramArrayOfObject) {
    Log.Level level = Log.Level.DEBUG;
    Object object = UNKNOWN_ARG;
    innerLog(level, null, paramString, object, object, object, paramArrayOfObject);
  }
  
  public void debug(Throwable paramThrowable, String paramString) {
    Log.Level level = Log.Level.DEBUG;
    Object object = UNKNOWN_ARG;
    innerLog(level, paramThrowable, paramString, object, object, object, null);
  }
  
  public void debug(Throwable paramThrowable, String paramString, Object paramObject) {
    Log.Level level = Log.Level.DEBUG;
    Object object = UNKNOWN_ARG;
    innerLog(level, paramThrowable, paramString, paramObject, object, object, null);
  }
  
  public void debug(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2) {
    innerLog(Log.Level.DEBUG, paramThrowable, paramString, paramObject1, paramObject2, UNKNOWN_ARG, null);
  }
  
  public void debug(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2, Object paramObject3) {
    innerLog(Log.Level.DEBUG, paramThrowable, paramString, paramObject1, paramObject2, paramObject3, null);
  }
  
  public void debug(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject) {
    Log.Level level = Log.Level.DEBUG;
    Object object = UNKNOWN_ARG;
    innerLog(level, paramThrowable, paramString, object, object, object, paramArrayOfObject);
  }
  
  public void error(String paramString) {
    Log.Level level = Log.Level.ERROR;
    Object object = UNKNOWN_ARG;
    innerLog(level, null, paramString, object, object, object, null);
  }
  
  public void error(String paramString, Object paramObject) {
    Log.Level level = Log.Level.ERROR;
    Object object = UNKNOWN_ARG;
    innerLog(level, null, paramString, paramObject, object, object, null);
  }
  
  public void error(String paramString, Object paramObject1, Object paramObject2) {
    innerLog(Log.Level.ERROR, null, paramString, paramObject1, paramObject2, UNKNOWN_ARG, null);
  }
  
  public void error(String paramString, Object paramObject1, Object paramObject2, Object paramObject3) {
    innerLog(Log.Level.ERROR, null, paramString, paramObject1, paramObject2, paramObject3, null);
  }
  
  public void error(String paramString, Object[] paramArrayOfObject) {
    Log.Level level = Log.Level.ERROR;
    Object object = UNKNOWN_ARG;
    innerLog(level, null, paramString, object, object, object, paramArrayOfObject);
  }
  
  public void error(Throwable paramThrowable, String paramString) {
    Log.Level level = Log.Level.ERROR;
    Object object = UNKNOWN_ARG;
    innerLog(level, paramThrowable, paramString, object, object, object, null);
  }
  
  public void error(Throwable paramThrowable, String paramString, Object paramObject) {
    Log.Level level = Log.Level.ERROR;
    Object object = UNKNOWN_ARG;
    innerLog(level, paramThrowable, paramString, paramObject, object, object, null);
  }
  
  public void error(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2) {
    innerLog(Log.Level.ERROR, paramThrowable, paramString, paramObject1, paramObject2, UNKNOWN_ARG, null);
  }
  
  public void error(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2, Object paramObject3) {
    innerLog(Log.Level.ERROR, paramThrowable, paramString, paramObject1, paramObject2, paramObject3, null);
  }
  
  public void error(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject) {
    Log.Level level = Log.Level.ERROR;
    Object object = UNKNOWN_ARG;
    innerLog(level, paramThrowable, paramString, object, object, object, paramArrayOfObject);
  }
  
  public void fatal(String paramString) {
    Log.Level level = Log.Level.FATAL;
    Object object = UNKNOWN_ARG;
    innerLog(level, null, paramString, object, object, object, null);
  }
  
  public void fatal(String paramString, Object paramObject) {
    Log.Level level = Log.Level.FATAL;
    Object object = UNKNOWN_ARG;
    innerLog(level, null, paramString, paramObject, object, object, null);
  }
  
  public void fatal(String paramString, Object paramObject1, Object paramObject2) {
    innerLog(Log.Level.FATAL, null, paramString, paramObject1, paramObject2, UNKNOWN_ARG, null);
  }
  
  public void fatal(String paramString, Object paramObject1, Object paramObject2, Object paramObject3) {
    innerLog(Log.Level.FATAL, null, paramString, paramObject1, paramObject2, paramObject3, null);
  }
  
  public void fatal(String paramString, Object[] paramArrayOfObject) {
    Log.Level level = Log.Level.FATAL;
    Object object = UNKNOWN_ARG;
    innerLog(level, null, paramString, object, object, object, paramArrayOfObject);
  }
  
  public void fatal(Throwable paramThrowable, String paramString) {
    Log.Level level = Log.Level.FATAL;
    Object object = UNKNOWN_ARG;
    innerLog(level, paramThrowable, paramString, object, object, object, null);
  }
  
  public void fatal(Throwable paramThrowable, String paramString, Object paramObject) {
    Log.Level level = Log.Level.FATAL;
    Object object = UNKNOWN_ARG;
    innerLog(level, paramThrowable, paramString, paramObject, object, object, null);
  }
  
  public void fatal(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2) {
    innerLog(Log.Level.FATAL, paramThrowable, paramString, paramObject1, paramObject2, UNKNOWN_ARG, null);
  }
  
  public void fatal(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2, Object paramObject3) {
    innerLog(Log.Level.FATAL, paramThrowable, paramString, paramObject1, paramObject2, paramObject3, null);
  }
  
  public void fatal(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject) {
    Log.Level level = Log.Level.FATAL;
    Object object = UNKNOWN_ARG;
    innerLog(level, paramThrowable, paramString, object, object, object, paramArrayOfObject);
  }
  
  public void info(String paramString) {
    Log.Level level = Log.Level.INFO;
    Object object = UNKNOWN_ARG;
    innerLog(level, null, paramString, object, object, object, null);
  }
  
  public void info(String paramString, Object paramObject) {
    Log.Level level = Log.Level.INFO;
    Object object = UNKNOWN_ARG;
    innerLog(level, null, paramString, paramObject, object, object, null);
  }
  
  public void info(String paramString, Object paramObject1, Object paramObject2) {
    innerLog(Log.Level.INFO, null, paramString, paramObject1, paramObject2, UNKNOWN_ARG, null);
  }
  
  public void info(String paramString, Object paramObject1, Object paramObject2, Object paramObject3) {
    innerLog(Log.Level.INFO, null, paramString, paramObject1, paramObject2, paramObject3, null);
  }
  
  public void info(String paramString, Object[] paramArrayOfObject) {
    Log.Level level = Log.Level.INFO;
    Object object = UNKNOWN_ARG;
    innerLog(level, null, paramString, object, object, object, paramArrayOfObject);
  }
  
  public void info(Throwable paramThrowable, String paramString) {
    Log.Level level = Log.Level.INFO;
    Object object = UNKNOWN_ARG;
    innerLog(level, paramThrowable, paramString, object, object, object, null);
  }
  
  public void info(Throwable paramThrowable, String paramString, Object paramObject) {
    Log.Level level = Log.Level.INFO;
    Object object = UNKNOWN_ARG;
    innerLog(level, paramThrowable, paramString, paramObject, object, object, null);
  }
  
  public void info(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2) {
    innerLog(Log.Level.INFO, paramThrowable, paramString, paramObject1, paramObject2, UNKNOWN_ARG, null);
  }
  
  public void info(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2, Object paramObject3) {
    innerLog(Log.Level.INFO, paramThrowable, paramString, paramObject1, paramObject2, paramObject3, null);
  }
  
  public void info(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject) {
    Log.Level level = Log.Level.INFO;
    Object object = UNKNOWN_ARG;
    innerLog(level, paramThrowable, paramString, object, object, object, paramArrayOfObject);
  }
  
  public boolean isLevelEnabled(Log.Level paramLevel) {
    return this.log.isLevelEnabled(paramLevel);
  }
  
  public void log(Log.Level paramLevel, String paramString) {
    Object object = UNKNOWN_ARG;
    innerLog(paramLevel, null, paramString, object, object, object, null);
  }
  
  public void log(Log.Level paramLevel, String paramString, Object paramObject) {
    Object object = UNKNOWN_ARG;
    innerLog(paramLevel, null, paramString, paramObject, object, object, null);
  }
  
  public void log(Log.Level paramLevel, String paramString, Object paramObject1, Object paramObject2) {
    innerLog(paramLevel, null, paramString, paramObject1, paramObject2, UNKNOWN_ARG, null);
  }
  
  public void log(Log.Level paramLevel, String paramString, Object paramObject1, Object paramObject2, Object paramObject3) {
    innerLog(paramLevel, null, paramString, paramObject1, paramObject2, paramObject3, null);
  }
  
  public void log(Log.Level paramLevel, String paramString, Object[] paramArrayOfObject) {
    Object object = UNKNOWN_ARG;
    innerLog(paramLevel, null, paramString, object, object, object, paramArrayOfObject);
  }
  
  public void log(Log.Level paramLevel, Throwable paramThrowable, String paramString) {
    Object object = UNKNOWN_ARG;
    innerLog(paramLevel, paramThrowable, paramString, object, object, object, null);
  }
  
  public void log(Log.Level paramLevel, Throwable paramThrowable, String paramString, Object paramObject) {
    Object object = UNKNOWN_ARG;
    innerLog(paramLevel, paramThrowable, paramString, paramObject, object, object, null);
  }
  
  public void log(Log.Level paramLevel, Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2) {
    innerLog(paramLevel, paramThrowable, paramString, paramObject1, paramObject2, UNKNOWN_ARG, null);
  }
  
  public void log(Log.Level paramLevel, Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2, Object paramObject3) {
    innerLog(paramLevel, paramThrowable, paramString, paramObject1, paramObject2, paramObject3, null);
  }
  
  public void log(Log.Level paramLevel, Throwable paramThrowable, String paramString, Object[] paramArrayOfObject) {
    Object object = UNKNOWN_ARG;
    innerLog(paramLevel, paramThrowable, paramString, object, object, object, paramArrayOfObject);
  }
  
  public void trace(String paramString) {
    Log.Level level = Log.Level.TRACE;
    Object object = UNKNOWN_ARG;
    innerLog(level, null, paramString, object, object, object, null);
  }
  
  public void trace(String paramString, Object paramObject) {
    Log.Level level = Log.Level.TRACE;
    Object object = UNKNOWN_ARG;
    innerLog(level, null, paramString, paramObject, object, object, null);
  }
  
  public void trace(String paramString, Object paramObject1, Object paramObject2) {
    innerLog(Log.Level.TRACE, null, paramString, paramObject1, paramObject2, UNKNOWN_ARG, null);
  }
  
  public void trace(String paramString, Object paramObject1, Object paramObject2, Object paramObject3) {
    innerLog(Log.Level.TRACE, null, paramString, paramObject1, paramObject2, paramObject3, null);
  }
  
  public void trace(String paramString, Object[] paramArrayOfObject) {
    Log.Level level = Log.Level.TRACE;
    Object object = UNKNOWN_ARG;
    innerLog(level, null, paramString, object, object, object, paramArrayOfObject);
  }
  
  public void trace(Throwable paramThrowable, String paramString) {
    Log.Level level = Log.Level.TRACE;
    Object object = UNKNOWN_ARG;
    innerLog(level, paramThrowable, paramString, object, object, object, null);
  }
  
  public void trace(Throwable paramThrowable, String paramString, Object paramObject) {
    Log.Level level = Log.Level.TRACE;
    Object object = UNKNOWN_ARG;
    innerLog(level, paramThrowable, paramString, paramObject, object, object, null);
  }
  
  public void trace(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2) {
    innerLog(Log.Level.TRACE, paramThrowable, paramString, paramObject1, paramObject2, UNKNOWN_ARG, null);
  }
  
  public void trace(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2, Object paramObject3) {
    innerLog(Log.Level.TRACE, paramThrowable, paramString, paramObject1, paramObject2, paramObject3, null);
  }
  
  public void trace(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject) {
    Log.Level level = Log.Level.TRACE;
    Object object = UNKNOWN_ARG;
    innerLog(level, paramThrowable, paramString, object, object, object, paramArrayOfObject);
  }
  
  public void warn(String paramString) {
    Log.Level level = Log.Level.WARNING;
    Object object = UNKNOWN_ARG;
    innerLog(level, null, paramString, object, object, object, null);
  }
  
  public void warn(String paramString, Object paramObject) {
    Log.Level level = Log.Level.WARNING;
    Object object = UNKNOWN_ARG;
    innerLog(level, null, paramString, paramObject, object, object, null);
  }
  
  public void warn(String paramString, Object paramObject1, Object paramObject2) {
    innerLog(Log.Level.WARNING, null, paramString, paramObject1, paramObject2, UNKNOWN_ARG, null);
  }
  
  public void warn(String paramString, Object paramObject1, Object paramObject2, Object paramObject3) {
    innerLog(Log.Level.WARNING, null, paramString, paramObject1, paramObject2, paramObject3, null);
  }
  
  public void warn(String paramString, Object[] paramArrayOfObject) {
    Log.Level level = Log.Level.WARNING;
    Object object = UNKNOWN_ARG;
    innerLog(level, null, paramString, object, object, object, paramArrayOfObject);
  }
  
  public void warn(Throwable paramThrowable, String paramString) {
    Log.Level level = Log.Level.WARNING;
    Object object = UNKNOWN_ARG;
    innerLog(level, paramThrowable, paramString, object, object, object, null);
  }
  
  public void warn(Throwable paramThrowable, String paramString, Object paramObject) {
    Log.Level level = Log.Level.WARNING;
    Object object = UNKNOWN_ARG;
    innerLog(level, paramThrowable, paramString, paramObject, object, object, null);
  }
  
  public void warn(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2) {
    innerLog(Log.Level.WARNING, paramThrowable, paramString, paramObject1, paramObject2, UNKNOWN_ARG, null);
  }
  
  public void warn(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2, Object paramObject3) {
    innerLog(Log.Level.WARNING, paramThrowable, paramString, paramObject1, paramObject2, paramObject3, null);
  }
  
  public void warn(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject) {
    Log.Level level = Log.Level.WARNING;
    Object object = UNKNOWN_ARG;
    innerLog(level, paramThrowable, paramString, object, object, object, paramArrayOfObject);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\logger\Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */