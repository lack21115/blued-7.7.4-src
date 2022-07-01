package com.baidu.mobads.openad.interfaces.utils;

public interface IOAdTimer {
  int getCurrentCount();
  
  int getRepeatCount();
  
  void pause();
  
  void reset();
  
  void resume();
  
  void setEventHandler(EventHandler paramEventHandler);
  
  void start();
  
  void stop();
  
  public static interface EventHandler {
    void onTimer(int param1Int);
    
    void onTimerComplete();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\openad\interface\\utils\IOAdTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */