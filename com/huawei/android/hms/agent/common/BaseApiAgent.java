package com.huawei.android.hms.agent.common;

public abstract class BaseApiAgent implements IClientConnectCallback {
  protected void connect() {
    HMSAgentLog.d("connect");
    ApiClientMgr.INST.connect(this, true);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\android\hms\agent\common\BaseApiAgent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */