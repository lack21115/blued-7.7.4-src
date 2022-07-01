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
import com.huawei.android.hms.agent.push.handler.GetPushStateHandler;
import com.huawei.hms.api.HuaweiApiClient;

public class GetPushStateApi extends BaseApiAgent {
  private GetPushStateHandler handler;
  
  public void getPushState(GetPushStateHandler paramGetPushStateHandler) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getPushState:handler=");
    stringBuilder.append(StrUtils.objDesc(paramGetPushStateHandler));
    HMSAgentLog.i(stringBuilder.toString());
    this.handler = paramGetPushStateHandler;
    connect();
  }
  
  public void onConnect(final int rst, final HuaweiApiClient client) {
    ThreadManager.a().a(new ThreadExecutor("GetPushStateOnConnect") {
          public void execute() {
            if (client == null || !ApiClientMgr.INST.isConnect(client)) {
              HMSAgentLog.e("client not connted");
              GetPushStateApi.this.onGetPushStateResult(rst);
              return;
            } 
            GetPushStateApi.this.onGetPushStateResult(0);
          }
        });
  }
  
  void onGetPushStateResult(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getPushState:callback=");
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\android\hms\agent\push\GetPushStateApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */