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
import com.huawei.android.hms.agent.push.handler.QueryAgreementHandler;
import com.huawei.hms.api.HuaweiApiClient;

public class QueryAgreementApi extends BaseApiAgent {
  private QueryAgreementHandler handler;
  
  public void onConnect(final int rst, final HuaweiApiClient client) {
    ThreadManager.a().a(new ThreadExecutor("QueryAgreementOnConnect") {
          public void execute() {
            if (client == null || !ApiClientMgr.INST.isConnect(client)) {
              HMSAgentLog.e("client not connted");
              QueryAgreementApi.this.onQueryAgreementResult(rst);
              return;
            } 
            QueryAgreementApi.this.onQueryAgreementResult(0);
          }
        });
  }
  
  void onQueryAgreementResult(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("queryAgreement:callback=");
    stringBuilder.append(StrUtils.objDesc(this.handler));
    stringBuilder.append(" retCode=");
    stringBuilder.append(paramInt);
    HMSAgentLog.i(stringBuilder.toString());
    if (this.handler != null) {
      (new Handler(Looper.getMainLooper())).post((Runnable)new CallbackCodeRunnable((ICallbackCode)this.handler, paramInt));
      this.handler = null;
    } 
  }
  
  public void queryAgreement(QueryAgreementHandler paramQueryAgreementHandler) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("queryAgreement:handler=");
    stringBuilder.append(StrUtils.objDesc(paramQueryAgreementHandler));
    HMSAgentLog.i(stringBuilder.toString());
    this.handler = paramQueryAgreementHandler;
    connect();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\android\hms\agent\push\QueryAgreementApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */