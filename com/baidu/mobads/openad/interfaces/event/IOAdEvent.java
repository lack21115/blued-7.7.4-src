package com.baidu.mobads.openad.interfaces.event;

import java.util.Map;

public interface IOAdEvent {
  int getCode();
  
  Map<String, Object> getData();
  
  String getMessage();
  
  Object getTarget();
  
  String getType();
  
  void setTarget(Object paramObject);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\openad\interfaces\event\IOAdEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */