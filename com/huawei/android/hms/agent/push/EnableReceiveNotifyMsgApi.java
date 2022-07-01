package com.huawei.android.hms.agent.push;

import android.os.Handler;
import android.os.Looper;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.huawei.android.hms.agent.common.ApiClientMgr;
import com.huawei.android.hms.agent.common.BaseApiAgent;
import com.huawei.android.hms.agent.common.CallbackCodeRunnable;
import com.huawei.android.hms.agent.common.HMSAgentLog;
import com.huawei.android.hms.agent.common.StrUtils;
import com.huawei.android.hms.agent.common.handler.ICallbackCode;
import com.huawei.android.hms.agent.push.handler.EnableReceiveNotifyMsgHandler;
import com.huawei.hms.api.HuaweiApiClient;

public class EnableReceiveNotifyMsgApi extends BaseApiAgent {
  boolean enable;
  
  private EnableReceiveNotifyMsgHandler handler;
  
  public void enableReceiveNotifyMsg(boolean paramBoolean, EnableReceiveNotifyMsgHandler paramEnableReceiveNotifyMsgHandler) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("enableReceiveNotifyMsg:enable=");
    stringBuilder.append(paramBoolean);
    stringBuilder.append(" handler=");
    stringBuilder.append(StrUtils.objDesc(paramEnableReceiveNotifyMsgHandler));
    HMSAgentLog.i(stringBuilder.toString());
    this.enable = paramBoolean;
    this.handler = paramEnableReceiveNotifyMsgHandler;
    connect();
  }
  
  public void onConnect(final int rst, final HuaweiApiClient client) {
    ThreadManager.a().a(new ThreadExecutor("ReceiveNotifyMsgOnConnect") {
          public void execute() {
            if (client == null || !ApiClientMgr.INST.isConnect(client)) {
              HMSAgentLog.e("client not connted");
              EnableReceiveNotifyMsgApi.this.onEnableReceiveNotifyMsgResult(rst);
              return;
            } 
            EnableReceiveNotifyMsgApi.this.onEnableReceiveNotifyMsgResult(0);
          }
        });
  }
  
  void onEnableReceiveNotifyMsgResult(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("enableReceiveNotifyMsg:callback=");
    stringBuilder.append(StrUtils.objDesc(this.handler));
    stringBuilder.append(" retCode=");
    stringBuilder.append(paramInt);
    HMSAgentLog.i(stringBuilder.toString());
    if (this.handler != null) {
      (new Handler(Looper.getMainLooper())).post((Runnable)new CallbackCodeRunnable((ICallbackCode)this.handler, paramInt));
      this.handler = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\android\hms\agent\push\EnableReceiveNotifyMsgApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */