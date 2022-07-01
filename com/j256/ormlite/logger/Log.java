package com.j256.ormlite.logger;

public interface Log {
  boolean isLevelEnabled(Level paramLevel);
  
  void log(Level paramLevel, String paramString);
  
  void log(Level paramLevel, String paramString, Throwable paramThrowable);
  
  public enum Level {
    DEBUG,
    ERROR,
    FATAL,
    INFO,
    TRACE(1),
    WARNING(1);
    
    private int level;
    
    static {
      ERROR = new Level("ERROR", 4, 5);
      FATAL = new Level("FATAL", 5, 6);
      $VALUES = new Level[] { TRACE, DEBUG, INFO, WARNING, ERROR, FATAL };
    }
    
    Level(int param1Int1) {
      this.level = param1Int1;
    }
    
    public boolean isEnabled(Level param1Level) {
      return (this.level <= param1Level.level);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\logger\Log.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */