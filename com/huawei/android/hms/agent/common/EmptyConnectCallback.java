package com.huawei.android.hms.agent.common;

import com.huawei.hms.api.HuaweiApiClient;

public class EmptyConnectCallback implements IClientConnectCallback {
  private String msgPre;
  
  public EmptyConnectCallback(String paramString) {
    this.msgPre = paramString;
  }
  
  public void onConnect(int paramInt, HuaweiApiClient paramHuaweiApiClient) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.msgPre);
    stringBuilder.append(paramInt);
    HMSAgentLog.d(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\android\hms\agent\common\EmptyConnectCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */