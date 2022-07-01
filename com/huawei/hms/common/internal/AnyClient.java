package com.huawei.hms.common.internal;

import com.huawei.hms.core.aidl.IMessageEntity;

public interface AnyClient {
  void connect(int paramInt);
  
  void connect(int paramInt, boolean paramBoolean);
  
  void disconnect();
  
  String getSessionId();
  
  boolean isConnected();
  
  boolean isConnecting();
  
  void post(IMessageEntity paramIMessageEntity, String paramString, CallBack paramCallBack);
  
  public static interface CallBack {
    void onCallback(IMessageEntity param1IMessageEntity, String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\internal\AnyClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */