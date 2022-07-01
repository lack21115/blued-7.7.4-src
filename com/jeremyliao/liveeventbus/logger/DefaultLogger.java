package com.jeremyliao.liveeventbus.logger;

import android.util.Log;
import java.util.logging.Level;

public class DefaultLogger implements Logger {
  private static final String TAG = "[LiveEventBus]";
  
  public void log(Level paramLevel, String paramString) {
    if (paramLevel == Level.SEVERE) {
      Log.e("[LiveEventBus]", paramString);
      return;
    } 
    if (paramLevel == Level.WARNING) {
      Log.w("[LiveEventBus]", paramString);
      return;
    } 
    if (paramLevel == Level.INFO) {
      Log.i("[LiveEventBus]", paramString);
      return;
    } 
    if (paramLevel == Level.CONFIG) {
      Log.d("[LiveEventBus]", paramString);
      return;
    } 
    if (paramLevel != Level.OFF)
      Log.v("[LiveEventBus]", paramString); 
  }
  
  public void log(Level paramLevel, String paramString, Throwable paramThrowable) {
    if (paramLevel == Level.SEVERE) {
      Log.e("[LiveEventBus]", paramString, paramThrowable);
      return;
    } 
    if (paramLevel == Level.WARNING) {
      Log.w("[LiveEventBus]", paramString, paramThrowable);
      return;
    } 
    if (paramLevel == Level.INFO) {
      Log.i("[LiveEventBus]", paramString, paramThrowable);
      return;
    } 
    if (paramLevel == Level.CONFIG) {
      Log.d("[LiveEventBus]", paramString, paramThrowable);
      return;
    } 
    if (paramLevel != Level.OFF)
      Log.v("[LiveEventBus]", paramString, paramThrowable); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\jeremyliao\liveeventbus\logger\DefaultLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */