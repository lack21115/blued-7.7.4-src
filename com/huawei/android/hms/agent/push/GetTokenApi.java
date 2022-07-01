package com.huawei.android.hms.agent.push;

import android.os.Handler;
import android.os.Looper;
import com.huawei.android.hms.agent.common.ApiClientMgr;
import com.huawei.android.hms.agent.common.BaseApiAgent;
import com.huawei.android.hms.agent.common.CallbackCodeRunnable;
import com.huawei.android.hms.agent.common.HMSAgentLog;
import com.huawei.android.hms.agent.common.StrUtils;
import com.huawei.android.hms.agent.common.handler.ICallbackCode;
import com.huawei.android.hms.agent.push.handler.GetTokenHandler;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.api.HuaweiApiClient;

public class GetTokenApi extends BaseApiAgent {
  private static final int MAX_RETRY_TIMES = 1;
  
  private GetTokenHandler handler;
  
  private int retryTimes = 1;
  
  public void getToken(GetTokenHandler paramGetTokenHandler) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getToken:handler=");
    stringBuilder.append(StrUtils.objDesc(paramGetTokenHandler));
    HMSAgentLog.i(stringBuilder.toString());
    this.handler = paramGetTokenHandler;
    this.retryTimes = 1;
    connect();
  }
  
  public void onConnect(int paramInt, HuaweiApiClient paramHuaweiApiClient) {
    if (paramHuaweiApiClient == null || !ApiClientMgr.INST.isConnect(paramHuaweiApiClient)) {
      HMSAgentLog.e("client not connted");
      onPushTokenResult(paramInt, null);
      return;
    } 
  }
  
  void onPushTokenResult(int paramInt, TokenResult paramTokenResult) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getToken:callback=");
    stringBuilder.append(StrUtils.objDesc(this.handler));
    stringBuilder.append(" retCode=");
    stringBuilder.append(paramInt);
    HMSAgentLog.i(stringBuilder.toString());
    if (this.handler != null) {
      (new Handler(Looper.getMainLooper())).post((Runnable)new CallbackCodeRunnable((ICallbackCode)this.handler, paramInt));
      this.handler = null;
    } 
    this.retryTimes = 1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\android\hms\agent\push\GetTokenApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */