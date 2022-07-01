package com.jeremyliao.liveeventbus.logger;

import java.util.logging.Level;

public interface Logger {
  void log(Level paramLevel, String paramString);
  
  void log(Level paramLevel, String paramString, Throwable paramThrowable);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\jeremyliao\liveeventbus\logger\Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */