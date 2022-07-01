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
import com.huawei.android.hms.agent.push.handler.EnableReceiveNormalMsgHandler;
import com.huawei.hms.api.HuaweiApiClient;

public class EnableReceiveNormalMsgApi extends BaseApiAgent {
  boolean enable;
  
  private EnableReceiveNormalMsgHandler handler;
  
  public void enableReceiveNormalMsg(boolean paramBoolean, EnableReceiveNormalMsgHandler paramEnableReceiveNormalMsgHandler) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("enableReceiveNormalMsg:enable=");
    stringBuilder.append(paramBoolean);
    stringBuilder.append("  handler=");
    stringBuilder.append(StrUtils.objDesc(paramEnableReceiveNormalMsgHandler));
    HMSAgentLog.i(stringBuilder.toString());
    this.enable = paramBoolean;
    this.handler = paramEnableReceiveNormalMsgHandler;
    connect();
  }
  
  public void onConnect(final int rst, final HuaweiApiClient client) {
    ThreadManager.a().a(new ThreadExecutor("ReceiveNormalMsgApiOnConnect") {
          public void execute() {
            if (client == null || !ApiClientMgr.INST.isConnect(client)) {
              HMSAgentLog.e("client not connted");
              EnableReceiveNormalMsgApi.this.onEnableReceiveNormalMsgResult(rst);
              return;
            } 
            EnableReceiveNormalMsgApi.this.onEnableReceiveNormalMsgResult(0);
          }
        });
  }
  
  void onEnableReceiveNormalMsgResult(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("enableReceiveNormalMsg:callback=");
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\android\hms\agent\push\EnableReceiveNormalMsgApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */