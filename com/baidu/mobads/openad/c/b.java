package com.baidu.mobads.openad.c;

import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import java.util.HashMap;
import java.util.Map;

public class b implements IOAdEvent {
  public static final String COMPLETE = "complete";
  
  public static final String EVENT_INFO = "instanceInfo";
  
  public static final String EVENT_MESSAGE = "message";
  
  private final String a;
  
  private final HashMap<String, Object> b;
  
  private final int c;
  
  private Object d;
  
  public b(String paramString) {
    this(paramString, 0, new HashMap<String, Object>());
  }
  
  public b(String paramString, int paramInt) {
    this(paramString, paramInt, new HashMap<String, Object>());
  }
  
  public b(String paramString1, int paramInt, String paramString2) {
    this(paramString1, paramInt, new HashMap<String, Object>());
    this.b.put("message", paramString2);
  }
  
  public b(String paramString, int paramInt, HashMap<String, Object> paramHashMap) {
    this.a = paramString;
    this.c = paramInt;
    this.b = paramHashMap;
  }
  
  public b(String paramString1, String paramString2) {
    this(paramString1, 0, paramString2);
  }
  
  public b(String paramString, HashMap<String, Object> paramHashMap) {
    this(paramString, 0, paramHashMap);
  }
  
  public int getCode() {
    return this.c;
  }
  
  public HashMap<String, Object> getData() {
    return this.b;
  }
  
  public String getMessage() {
    try {
      return (String)this.b.get("message");
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public Object getTarget() {
    return this.d;
  }
  
  public String getType() {
    return this.a;
  }
  
  public void setData(IXAdInstanceInfo paramIXAdInstanceInfo) {
    if (paramIXAdInstanceInfo != null)
      this.b.put("instanceInfo", paramIXAdInstanceInfo.getUniqueId()); 
  }
  
  public void setTarget(Object paramObject) {
    this.d = paramObject;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\openad\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */