package com.baidu.mobads.interfaces.utils;

public interface IBase64 {
  String decodeStr(String paramString);
  
  String encode(String paramString);
  
  public static interface EventHandler {
    void onTimer(int param1Int);
    
    void onTimerComplete();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\interface\\utils\IBase64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */