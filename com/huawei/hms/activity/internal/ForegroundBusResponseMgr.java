package com.huawei.hms.activity.internal;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class ForegroundBusResponseMgr {
  private static final ForegroundBusResponseMgr instance = new ForegroundBusResponseMgr();
  
  private final Map<String, BusResponseCallback> callbackMap = new HashMap<String, BusResponseCallback>();
  
  public static ForegroundBusResponseMgr getInstance() {
    return instance;
  }
  
  public BusResponseCallback get(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    synchronized (this.callbackMap) {
      return this.callbackMap.get(paramString);
    } 
  }
  
  public void registerObserver(String paramString, BusResponseCallback paramBusResponseCallback) {
    if (!TextUtils.isEmpty(paramString)) {
      if (paramBusResponseCallback == null)
        return; 
      synchronized (this.callbackMap) {
        if (!this.callbackMap.containsKey(paramString))
          this.callbackMap.put(paramString, paramBusResponseCallback); 
        return;
      } 
    } 
  }
  
  public void unRegisterObserver(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    synchronized (this.callbackMap) {
      this.callbackMap.remove(paramString);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\activity\internal\ForegroundBusResponseMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */