package com.huawei.hms.support.api.client;

import android.content.Context;

public interface ApiClient {
  String getAppID();
  
  Context getContext();
  
  String getCpID();
  
  String getPackageName();
  
  String getSessionId();
  
  SubAppInfo getSubAppInfo();
  
  String getTransportName();
  
  boolean isConnected();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\client\ApiClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */