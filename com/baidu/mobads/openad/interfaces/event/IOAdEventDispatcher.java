package com.baidu.mobads.openad.interfaces.event;

public interface IOAdEventDispatcher {
  void addEventListener(String paramString, IOAdEventListener paramIOAdEventListener);
  
  void dispatchEvent(IOAdEvent paramIOAdEvent);
  
  boolean hasEventListener(String paramString);
  
  void removeAllListeners();
  
  void removeEventListener(String paramString, IOAdEventListener paramIOAdEventListener);
  
  void removeEventListeners(String paramString);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\openad\interfaces\event\IOAdEventDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */