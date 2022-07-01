package com.huawei.hms.aaid.plugin;

import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import org.json.JSONObject;

public interface PushProxy {
  void deleteAllToken(Context paramContext) throws ApiException;
  
  void deleteToken(Context paramContext, String paramString1, String paramString2) throws ApiException;
  
  JSONObject getPlatform();
  
  String getProxyType();
  
  void getToken(Context paramContext, String paramString1, String paramString2) throws ApiException;
  
  Task<Void> subscribe(Context paramContext, String paramString1, String paramString2);
  
  Task<Void> turnOff(Context paramContext, String paramString);
  
  Task<Void> turnOn(Context paramContext, String paramString);
  
  Task<Void> unsubscribe(Context paramContext, String paramString1, String paramString2);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\aaid\plugin\PushProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */