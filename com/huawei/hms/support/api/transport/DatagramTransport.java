package com.huawei.hms.support.api.transport;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;

public interface DatagramTransport {
  void post(ApiClient paramApiClient, CallBack paramCallBack);
  
  void send(ApiClient paramApiClient, CallBack paramCallBack);
  
  public static interface CallBack {
    void onCallback(int param1Int, IMessageEntity param1IMessageEntity);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\transport\DatagramTransport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */