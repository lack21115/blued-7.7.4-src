package com.huawei.android.hms.agent.common;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.huawei.android.hms.agent.common.handler.CheckUpdateHandler;
import com.huawei.android.hms.agent.common.handler.ICallbackCode;
import com.huawei.hms.api.CheckUpdatelistener;
import com.huawei.hms.api.HuaweiApiClient;

public class CheckUpdateApi extends BaseApiAgent implements CheckUpdatelistener {
  private Activity activity;
  
  private CheckUpdateHandler handler;
  
  private void onCheckUpdateResult(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("checkUpdate:callback=");
    stringBuilder.append(StrUtils.objDesc(this.handler));
    stringBuilder.append(" retCode=");
    stringBuilder.append(paramInt);
    HMSAgentLog.i(stringBuilder.toString());
    if (this.handler != null) {
      (new Handler(Looper.getMainLooper())).post(new CallbackCodeRunnable((ICallbackCode)this.handler, paramInt));
      this.handler = null;
    } 
    this.activity = null;
  }
  
  public void checkUpdate(Activity paramActivity, CheckUpdateHandler paramCheckUpdateHandler) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("checkUpdate:handler=");
    stringBuilder.append(StrUtils.objDesc(paramCheckUpdateHandler));
    HMSAgentLog.i(stringBuilder.toString());
    this.handler = paramCheckUpdateHandler;
    this.activity = paramActivity;
    connect();
  }
  
  public void onConnect(int paramInt, HuaweiApiClient paramHuaweiApiClient) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onConnect:");
    stringBuilder.append(paramInt);
    HMSAgentLog.d(stringBuilder.toString());
    Activity activity = ActivityMgr.INST.getLastActivity();
    if (activity != null && paramHuaweiApiClient != null) {
      paramHuaweiApiClient.checkUpdate(activity, this);
      return;
    } 
    activity = this.activity;
    if (activity != null && paramHuaweiApiClient != null) {
      paramHuaweiApiClient.checkUpdate(activity, this);
      return;
    } 
    HMSAgentLog.e("no activity to checkUpdate");
    onCheckUpdateResult(-1001);
  }
  
  public void onResult(int paramInt) {
    onCheckUpdateResult(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\android\hms\agent\common\CheckUpdateApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */