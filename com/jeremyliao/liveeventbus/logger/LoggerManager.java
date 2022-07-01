package com.jeremyliao.liveeventbus.logger;

import java.util.logging.Level;

public class LoggerManager implements Logger {
  private boolean enable = true;
  
  private Logger logger;
  
  public LoggerManager(Logger paramLogger) {
    this.logger = paramLogger;
  }
  
  public Logger getLogger() {
    return this.logger;
  }
  
  public boolean isEnable() {
    return this.enable;
  }
  
  public void log(Level paramLevel, String paramString) {
    if (this.enable)
      this.logger.log(paramLevel, paramString); 
  }
  
  public void log(Level paramLevel, String paramString, Throwable paramThrowable) {
    if (this.enable)
      this.logger.log(paramLevel, paramString, paramThrowable); 
  }
  
  public void setEnable(boolean paramBoolean) {
    this.enable = paramBoolean;
  }
  
  public void setLogger(Logger paramLogger) {
    this.logger = paramLogger;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\jeremyliao\liveeventbus\logger\LoggerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */