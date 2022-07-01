package com.taobao.tao.remotebusiness.listener;

import com.taobao.tao.remotebusiness.MtopBusiness;
import com.taobao.tao.remotebusiness.a.a;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopEvent;
import mtopsdk.mtop.common.MtopHeaderEvent;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.common.MtopProgressEvent;

class MtopProgressListenerImpl extends b implements MtopCallback.MtopHeaderListener, MtopCallback.MtopProgressListener {
  private static final String TAG = "mtop.rb-ProgressListener";
  
  public MtopProgressListenerImpl(MtopBusiness paramMtopBusiness, MtopListener paramMtopListener) {
    super(paramMtopBusiness, paramMtopListener);
  }
  
  public void onDataReceived(MtopProgressEvent paramMtopProgressEvent, Object paramObject) {
    String str;
    TBSdkLog.b("mtop.rb-ProgressListener", this.mtopBusiness.getSeqNo(), "Mtop onDataReceived event received.");
    if (this.mtopBusiness.isTaskCanceled()) {
      str = this.mtopBusiness.getSeqNo();
      paramObject = "The request of RemoteBusiness is canceled.";
    } else if (this.listener == null) {
      str = this.mtopBusiness.getSeqNo();
      paramObject = "The listener of RemoteBusiness is null.";
    } else {
      if (this.listener instanceof com.taobao.tao.remotebusiness.IRemoteProcessListener)
        a.a().obtainMessage(1, a.a(this.listener, (MtopEvent)str, this.mtopBusiness)).sendToTarget(); 
      return;
    } 
    TBSdkLog.a("mtop.rb-ProgressListener", str, (String)paramObject);
  }
  
  public void onHeader(MtopHeaderEvent paramMtopHeaderEvent, Object paramObject) {
    String str;
    TBSdkLog.b("mtop.rb-ProgressListener", this.mtopBusiness.getSeqNo(), "Mtop onHeader event received.");
    if (this.mtopBusiness.isTaskCanceled()) {
      str = this.mtopBusiness.getSeqNo();
      paramObject = "The request of RemoteBusiness is canceled.";
    } else if (this.listener == null) {
      str = this.mtopBusiness.getSeqNo();
      paramObject = "The listener of RemoteBusiness is null.";
    } else {
      if (this.listener instanceof com.taobao.tao.remotebusiness.IRemoteProcessListener)
        a.a().obtainMessage(2, a.a(this.listener, (MtopEvent)str, this.mtopBusiness)).sendToTarget(); 
      return;
    } 
    TBSdkLog.a("mtop.rb-ProgressListener", str, (String)paramObject);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\taobao\tao\remotebusiness\listener\MtopProgressListenerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */