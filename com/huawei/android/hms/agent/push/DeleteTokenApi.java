package com.huawei.android.hms.agent.push;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.huawei.android.hms.agent.common.ApiClientMgr;
import com.huawei.android.hms.agent.common.BaseApiAgent;
import com.huawei.android.hms.agent.common.CallbackCodeRunnable;
import com.huawei.android.hms.agent.common.HMSAgentLog;
import com.huawei.android.hms.agent.common.StrUtils;
import com.huawei.android.hms.agent.common.handler.ICallbackCode;
import com.huawei.android.hms.agent.push.handler.DeleteTokenHandler;
import com.huawei.hms.api.HuaweiApiClient;

public class DeleteTokenApi extends BaseApiAgent {
  private DeleteTokenHandler handler;
  
  private String token;
  
  public void deleteToken(String paramString, DeleteTokenHandler paramDeleteTokenHandler) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("deleteToken:token:");
    stringBuilder.append(StrUtils.objDesc(paramString));
    stringBuilder.append(" handler=");
    stringBuilder.append(StrUtils.objDesc(paramDeleteTokenHandler));
    HMSAgentLog.i(stringBuilder.toString());
    this.token = paramString;
    this.handler = paramDeleteTokenHandler;
    connect();
  }
  
  public void onConnect(final int rst, final HuaweiApiClient client) {
    ThreadManager.a().a(new ThreadExecutor("DeleteTokenOnConnect") {
          public void execute() {
            if (!TextUtils.isEmpty(DeleteTokenApi.this.token)) {
              if (client == null || !ApiClientMgr.INST.isConnect(client)) {
                HMSAgentLog.e("client not connted");
                DeleteTokenApi.this.onDeleteTokenResult(rst);
                return;
              } 
              try {
                DeleteTokenApi.this.onDeleteTokenResult(0);
                return;
              } catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("删除TOKEN失败:");
                stringBuilder.append(exception.getMessage());
                HMSAgentLog.e(stringBuilder.toString());
                DeleteTokenApi.this.onDeleteTokenResult(-1008);
                return;
              } 
            } 
            HMSAgentLog.e("删除TOKEN失败: 要删除的token为空");
            DeleteTokenApi.this.onDeleteTokenResult(-1009);
          }
        });
  }
  
  void onDeleteTokenResult(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("deleteToken:callback=");
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\android\hms\agent\push\DeleteTokenApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */