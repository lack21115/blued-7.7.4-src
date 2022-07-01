package com.taobao.tao.remotebusiness;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.tao.remotebusiness.auth.RemoteAuth;
import com.taobao.tao.remotebusiness.listener.c;
import com.taobao.tao.remotebusiness.login.LoginContext;
import com.taobao.tao.remotebusiness.login.RemoteLogin;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.ApiID;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.IMTOPDataObject;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.global.SDKConfig;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopBuilder;
import mtopsdk.xstate.a;

public class MtopBusiness extends MtopBuilder {
  public static final int MAX_RETRY_TIMES = 3;
  
  private static final String TAG = "mtop.rb-RemoteBusiness";
  
  private static AtomicInteger seqGen = new AtomicInteger(0);
  
  private ApiID apiID;
  
  public String authParam = null;
  
  public Class clazz;
  
  public boolean isCached = false;
  
  private boolean isCanceled = false;
  
  private boolean isErrorNotifyAfterCache = false;
  
  public MtopListener listener;
  
  private MtopResponse mtopResponse = null;
  
  public long onBgFinishTime = 0L;
  
  public long reqStartTime = 0L;
  
  protected int requestType = 0;
  
  protected int retryTime = 0;
  
  public long sendStartTime = 0L;
  
  private final String seqNo = genSeqNo();
  
  public boolean showAuthUI = true;
  
  private boolean showLoginUI = true;
  
  private CountDownLatch syncRequestLatch = null;
  
  protected MtopBusiness(IMTOPDataObject paramIMTOPDataObject, String paramString) {
    super(paramIMTOPDataObject, paramString);
  }
  
  protected MtopBusiness(MtopRequest paramMtopRequest, String paramString) {
    super(paramMtopRequest, paramString);
  }
  
  public static MtopBusiness build(IMTOPDataObject paramIMTOPDataObject) {
    return new MtopBusiness(paramIMTOPDataObject, null);
  }
  
  public static MtopBusiness build(IMTOPDataObject paramIMTOPDataObject, String paramString) {
    return new MtopBusiness(paramIMTOPDataObject, paramString);
  }
  
  public static MtopBusiness build(MtopRequest paramMtopRequest) {
    return new MtopBusiness(paramMtopRequest, null);
  }
  
  public static MtopBusiness build(MtopRequest paramMtopRequest, String paramString) {
    return new MtopBusiness(paramMtopRequest, paramString);
  }
  
  private void cancelRequest(boolean paramBoolean) {
    if (paramBoolean)
      TBSdkLog.b("mtop.rb-RemoteBusiness", this.seqNo, c.a("cancelRequest.", this, false, null)); 
    this.isCanceled = true;
    ApiID apiID = this.apiID;
    if (apiID != null)
      try {
        apiID.b();
      } finally {
        apiID = null;
      }  
    a.b(this);
  }
  
  private void doQuery() {
    boolean bool1 = this.request.d();
    boolean bool2 = isNeedAuth();
    if (bool1 && !RemoteLogin.isSessionValid()) {
      a.a(this);
      RemoteLogin.login(this.showLoginUI, this.request);
      return;
    } 
    if (bool1)
      try {
        if (StringUtils.b(a.a())) {
          TBSdkLog.c("mtop.rb-RemoteBusiness", this.seqNo, "[doQuery] session in loginContext is valid but XState's sid is null");
          LoginContext loginContext = RemoteLogin.getLoginContext();
          if (loginContext != null && !StringUtils.b(loginContext.sid)) {
            Mtop.a(SDKConfig.a().b()).a(loginContext.sid, loginContext.userId);
          } else {
            a.a(this);
            RemoteLogin.login(this.showLoginUI, this.request);
            return;
          } 
        } 
      } catch (Exception exception) {
        TBSdkLog.b("mtop.rb-RemoteBusiness", this.seqNo, "error happens in confirming session info");
      }  
    if (bool1 && bool2) {
      if (!RemoteAuth.isAuthInfoValid()) {
        a.a(this);
        RemoteAuth.authorize(this.authParam, this.request.f(), null, this.showAuthUI);
        return;
      } 
      String str = RemoteAuth.getAuthToken();
      if (!TextUtils.isEmpty(str)) {
        a.a("accessToken", str);
      } else {
        a.a(this);
        RemoteAuth.authorize(this.authParam, this.request.f(), null, this.showAuthUI);
        return;
      } 
    } 
    this.sendStartTime = System.currentTimeMillis();
    this.apiID = super.asyncRequest();
  }
  
  private String genSeqNo() {
    StringBuilder stringBuilder = new StringBuilder(16);
    stringBuilder.append("RB");
    stringBuilder.append(seqGen.getAndIncrement());
    stringBuilder.append('.');
    stringBuilder.append(this.stat.g());
    return stringBuilder.toString();
  }
  
  public static void init(Context paramContext, String paramString) {
    Mtop.a(paramContext, paramString);
  }
  
  private void onErrorCallback(MtopResponse paramMtopResponse, boolean paramBoolean) {
    IRemoteBaseListener iRemoteBaseListener = (IRemoteBaseListener)this.listener;
    if (paramBoolean) {
      try {
        iRemoteBaseListener.onSystemError(this.requestType, paramMtopResponse, getReqContext());
      } finally {
        paramMtopResponse = null;
      } 
    } else {
      iRemoteBaseListener.onError(this.requestType, paramMtopResponse, getReqContext());
    } 
    if (TBSdkLog.a(TBSdkLog.LogEnable.c)) {
      String str1;
      String str2 = this.seqNo;
      StringBuilder stringBuilder = new StringBuilder("listener onError callback, ");
      if (paramBoolean) {
        str1 = "sys error";
      } else {
        str1 = "biz error";
      } 
      stringBuilder.append(str1);
      TBSdkLog.b("mtop.rb-RemoteBusiness", str2, stringBuilder.toString());
    } 
  }
  
  private void resetMtopListener() {
    if (!this.isCanceled) {
      MtopListener mtopListener = this.listener;
      if (mtopListener == null)
        return; 
      super.addListener(c.a(this, mtopListener));
    } 
  }
  
  public MtopBusiness addListener(MtopListener paramMtopListener) {
    return registeListener(paramMtopListener);
  }
  
  public ApiID asyncRequest() {
    startRequest();
    return this.apiID;
  }
  
  public void cancelRequest() {
    cancelRequest(true);
  }
  
  public void doFinish(MtopResponse paramMtopResponse, BaseOutDo paramBaseOutDo) {
    CountDownLatch countDownLatch = this.syncRequestLatch;
    if (countDownLatch != null) {
      this.mtopResponse = paramMtopResponse;
      countDownLatch.countDown();
    } 
    if (TBSdkLog.a(TBSdkLog.LogEnable.c)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("doFinish api=[");
      stringBuilder.append(this.request.a());
      stringBuilder.append("]");
      if (paramMtopResponse != null) {
        stringBuilder.append(" retCode=");
        stringBuilder.append(paramMtopResponse.a());
        stringBuilder.append(" retMsg=");
        stringBuilder.append(paramMtopResponse.a());
      } 
      TBSdkLog.b("mtop.rb-RemoteBusiness", this.seqNo, stringBuilder.toString());
    } 
    if (!this.isCanceled) {
      MtopListener mtopListener = this.listener;
      if (mtopListener instanceof IRemoteBaseListener) {
        mtopListener = mtopListener;
        if (paramMtopResponse == null) {
          TBSdkLog.b("mtop.rb-RemoteBusiness", this.seqNo, "response is null.");
          onErrorCallback(paramMtopResponse, false);
          return;
        } 
        if (paramMtopResponse != null && paramMtopResponse.i()) {
          try {
            mtopListener.onSuccess(this.requestType, paramMtopResponse, paramBaseOutDo, getReqContext());
          } finally {
            paramMtopResponse = null;
          } 
          return;
        } 
        if (this.isCached && !this.isErrorNotifyAfterCache) {
          TBSdkLog.a("mtop.rb-RemoteBusiness", this.seqNo, "listenr onCached callback,doNothing in doFinish()");
          return;
        } 
        if (paramMtopResponse.m()) {
          if (TBSdkLog.a(TBSdkLog.LogEnable.c)) {
            TBSdkLog.b("mtop.rb-RemoteBusiness", this.seqNo, c.a("尝试登录后仍session失效，或用户取消登录。", this, false, null));
            TBSdkLog.b("mtop.rb-RemoteBusiness", this.seqNo, "response.isSessionInvalid().");
          } 
          onErrorCallback(paramMtopResponse, true);
          return;
        } 
        if (paramMtopResponse.q() || paramMtopResponse.p() || paramMtopResponse.l() || paramMtopResponse.k() || paramMtopResponse.j() || paramMtopResponse.n() || paramMtopResponse.o()) {
          onErrorCallback(paramMtopResponse, true);
          return;
        } 
        onErrorCallback(paramMtopResponse, false);
        return;
      } 
    } 
    TBSdkLog.a("mtop.rb-RemoteBusiness", this.seqNo, "doFinish no callback.");
  }
  
  public int getRequestType() {
    return this.requestType;
  }
  
  public int getRetryTime() {
    return this.retryTime;
  }
  
  public String getSeqNo() {
    return this.seqNo;
  }
  
  public boolean isNeedAuth() {
    return (this.authParam != null);
  }
  
  public boolean isShowLoginUI() {
    return this.showLoginUI;
  }
  
  public boolean isTaskCanceled() {
    return this.isCanceled;
  }
  
  public MtopBusiness registeListener(MtopListener paramMtopListener) {
    this.listener = paramMtopListener;
    return this;
  }
  
  void retryRequest() {
    if (TBSdkLog.a(TBSdkLog.LogEnable.c))
      TBSdkLog.b("mtop.rb-RemoteBusiness", this.seqNo, c.a("retryRequest.", this, false, null)); 
    if (this.retryTime >= 3) {
      this.retryTime = 0;
      doFinish((MtopResponse)null, (BaseOutDo)null);
      return;
    } 
    cancelRequest(false);
    startRequest(this.requestType, this.clazz);
    this.retryTime++;
  }
  
  public MtopBusiness setBizId(int paramInt) {
    return (MtopBusiness)super.setBizId(paramInt);
  }
  
  public MtopBusiness setErrorNotifyAfterCache(boolean paramBoolean) {
    this.isErrorNotifyAfterCache = paramBoolean;
    return this;
  }
  
  public MtopBusiness setNeedAuth(String paramString, boolean paramBoolean) {
    if (TBSdkLog.a(TBSdkLog.LogEnable.b)) {
      StringBuilder stringBuilder = new StringBuilder("setNeedAuth. authParam");
      stringBuilder.append(paramString);
      TBSdkLog.a("mtop.rb-RemoteBusiness", stringBuilder.toString());
    } 
    this.authParam = paramString;
    this.showAuthUI = paramBoolean;
    return this;
  }
  
  public MtopBusiness showLoginUI(boolean paramBoolean) {
    this.showLoginUI = paramBoolean;
    return this;
  }
  
  public void startRequest() {
    startRequest(0, (Class)null);
  }
  
  public void startRequest(int paramInt, Class paramClass) {
    if (this.request == null) {
      TBSdkLog.d("mtop.rb-RemoteBusiness", this.seqNo, "request is null!!!");
      return;
    } 
    if (TBSdkLog.a(TBSdkLog.LogEnable.c)) {
      String str = this.seqNo;
      StringBuilder stringBuilder = new StringBuilder("start request api=[");
      stringBuilder.append(this.request.a());
      stringBuilder.append("]");
      TBSdkLog.b("mtop.rb-RemoteBusiness", str, stringBuilder.toString());
    } 
    this.reqStartTime = System.currentTimeMillis();
    this.isCanceled = false;
    this.isCached = false;
    this.clazz = paramClass;
    this.requestType = paramInt;
    resetMtopListener();
    mtopCommitStatData(false);
    doQuery();
  }
  
  public void startRequest(Class paramClass) {
    startRequest(0, paramClass);
  }
  
  public MtopResponse syncRequest() {
    String str = "";
    TBSdkLog.b("mtop.rb-RemoteBusiness", this.seqNo, "syncRequest");
    this.syncRequestLatch = new CountDownLatch(1);
    if (this.listener == null)
      this.listener = new MtopBusiness$1(this); 
    startRequest();
    try {
      if (!this.syncRequestLatch.await(120L, TimeUnit.SECONDS)) {
        String str1;
        String str2 = this.seqNo;
        StringBuilder stringBuilder = new StringBuilder("syncRequest timeout . apiKey=");
        stringBuilder.append(this.request);
        if (stringBuilder.toString() != null) {
          str1 = this.request.f();
        } else {
          str1 = "";
        } 
        TBSdkLog.c("mtop.rb-RemoteBusiness", str2, str1);
        cancelRequest();
      } 
    } catch (InterruptedException interruptedException) {
      if (TBSdkLog.a(TBSdkLog.LogEnable.e)) {
        String str2 = this.seqNo;
        StringBuilder stringBuilder = new StringBuilder("SyncRequest InterruptedException. apiKey=");
        stringBuilder.append(this.request);
        String str1 = str;
        if (stringBuilder.toString() != null)
          str1 = this.request.f(); 
        TBSdkLog.d("mtop.rb-RemoteBusiness", str2, str1);
      } 
    } 
    if (this.mtopResponse == null)
      this.mtopResponse = new MtopResponse(this.request.a(), this.request.b(), "ANDROID_SYS_MTOP_APICALL_ASYNC_TIMEOUT", "MTOP异步调用超时"); 
    return this.mtopResponse;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\taobao\tao\remotebusiness\MtopBusiness.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */