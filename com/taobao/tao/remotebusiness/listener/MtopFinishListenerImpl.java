package com.taobao.tao.remotebusiness.listener;

import com.taobao.tao.remotebusiness.IRemoteParserListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import com.taobao.tao.remotebusiness.a;
import com.taobao.tao.remotebusiness.a.a;
import com.taobao.tao.remotebusiness.a.b;
import com.taobao.tao.remotebusiness.auth.RemoteAuth;
import com.taobao.tao.remotebusiness.login.RemoteLogin;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopEvent;
import mtopsdk.mtop.common.MtopFinishEvent;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.util.MtopConvert;
import mtopsdk.mtop.util.MtopStatistics;

class MtopFinishListenerImpl extends b implements MtopCallback.MtopFinishListener {
  private static final String TAG = "mtop.rb-FinishListener";
  
  public MtopFinishListenerImpl(MtopBusiness paramMtopBusiness, MtopListener paramMtopListener) {
    super(paramMtopBusiness, paramMtopListener);
  }
  
  public void onFinished(MtopFinishEvent paramMtopFinishEvent, Object paramObject) {
    long l2;
    TBSdkLog.b("mtop.rb-FinishListener", this.mtopBusiness.getSeqNo(), "Mtop onFinish event received.");
    if (this.mtopBusiness.isTaskCanceled()) {
      TBSdkLog.a("mtop.rb-FinishListener", this.mtopBusiness.getSeqNo(), "The request of RemoteBusiness is canceled.");
      return;
    } 
    MtopResponse mtopResponse = paramMtopFinishEvent.a();
    if (mtopResponse == null) {
      TBSdkLog.a("mtop.rb-FinishListener", this.mtopBusiness.getSeqNo(), "The MtopResponse is null.");
      return;
    } 
    if (mtopResponse.m() && this.mtopBusiness.request.d() && this.mtopBusiness.getRetryTime() == 0) {
      a.a(this.mtopBusiness);
      RemoteLogin.login(this.mtopBusiness.isShowLoginUI(), mtopResponse);
      return;
    } 
    paramObject = mtopResponse.a();
    if (("FAIL_SYS_ACCESS_TOKEN_EXPIRED".equalsIgnoreCase((String)paramObject) || "FAIL_SYS_ILLEGAL_ACCESS_TOKEN".equalsIgnoreCase((String)paramObject)) && this.mtopBusiness.isNeedAuth()) {
      int i = this.mtopBusiness.getRetryTime();
      paramObject = this.mtopBusiness;
      if (i < 3) {
        a.a(this.mtopBusiness);
        RemoteAuth.authorize(this.mtopBusiness.authParam, this.mtopBusiness.request.f(), c.a(mtopResponse.e(), "x-act-hint"), this.mtopBusiness.showAuthUI);
        return;
      } 
    } 
    long l3 = System.currentTimeMillis();
    if (this.listener instanceof IRemoteParserListener)
      ((IRemoteParserListener)this.listener).parseResponse(paramMtopFinishEvent.a()); 
    b b1 = a.a(this.listener, (MtopEvent)paramMtopFinishEvent, this.mtopBusiness);
    b1.e = mtopResponse;
    long l1 = System.currentTimeMillis();
    if (mtopResponse != null) {
      long l;
      if (mtopResponse.i() && this.mtopBusiness.clazz != null) {
        b1.c = MtopConvert.a(mtopResponse, this.mtopBusiness.clazz);
        l = System.currentTimeMillis();
      } else {
        l = l1;
      } 
      paramObject = mtopResponse.g();
      l2 = l;
      Object object = paramObject;
      if (paramObject == null) {
        object = new MtopStatistics();
        mtopResponse.a((MtopStatistics)object);
        l2 = l;
      } 
    } else {
      paramMtopFinishEvent = null;
      l2 = l1;
    } 
    this.mtopBusiness.onBgFinishTime = System.currentTimeMillis();
    if (paramMtopFinishEvent != null) {
      MtopStatistics.RbStatisticData rbStatisticData = paramMtopFinishEvent.i();
      rbStatisticData.b = this.mtopBusiness.sendStartTime - this.mtopBusiness.reqStartTime;
      rbStatisticData.a = l3 - this.mtopBusiness.sendStartTime;
      rbStatisticData.c = this.mtopBusiness.onBgFinishTime - l3;
      rbStatisticData.f = l1 - l3;
      rbStatisticData.e = l2 - l1;
      rbStatisticData.d = this.mtopBusiness.onBgFinishTime - this.mtopBusiness.reqStartTime;
    } 
    a.a().obtainMessage(3, b1).sendToTarget();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\taobao\tao\remotebusiness\listener\MtopFinishListenerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */