package com.huawei.hms.adapter;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.adapter.sysobs.SystemObserver;
import com.huawei.hms.adapter.ui.BaseResolutionAdapter;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class BaseAdapter {
  private static final String TAG = "BaseAdapter";
  
  private WeakReference<Activity> activityWeakReference;
  
  private WeakReference<ApiClient> api;
  
  private Context appContext;
  
  private BaseCallBack baseCallBackReplay;
  
  private BaseCallBack callback;
  
  private String jsonHeaderReplay;
  
  private String jsonObjectReplay;
  
  private SystemObserver observer;
  
  private Parcelable parcelableReplay;
  
  private RequestHeader requestHeader = new RequestHeader();
  
  private ResponseHeader responseHeader = new ResponseHeader();
  
  private String transactionId;
  
  public BaseAdapter(ApiClient paramApiClient) {
    this.api = new WeakReference<ApiClient>(paramApiClient);
  }
  
  public BaseAdapter(ApiClient paramApiClient, Activity paramActivity) {
    this.api = new WeakReference<ApiClient>(paramApiClient);
    this.activityWeakReference = new WeakReference<Activity>(paramActivity);
    this.appContext = paramActivity.getApplicationContext();
  }
  
  private PendingResult<ResolveResult<CoreBaseResponse>> baseRequest(ApiClient paramApiClient, String paramString, CoreBaseRequest paramCoreBaseRequest) {
    return (PendingResult<ResolveResult<CoreBaseResponse>>)new MPendingResultImpl(paramApiClient, paramString, paramCoreBaseRequest);
  }
  
  private void biReportRequestEntryIpc(Context paramContext, RequestHeader paramRequestHeader) {
    Map<String, String> map = HiAnalyticsUtil.getInstance().getMapFromRequestHeader(paramRequestHeader);
    map.put("direction", "req");
    map.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(paramRequestHeader.getKitSdkVersion())));
    map.put("phoneType", Util.getSystemProperties("ro.logsystem.usertype", ""));
    HiAnalyticsUtil.getInstance().onNewEvent(paramContext, "HMS_SDK_BASE_CALL_AIDL", map);
  }
  
  private void biReportRequestEntrySolution(Context paramContext, RequestHeader paramRequestHeader) {
    Map<String, String> map = HiAnalyticsUtil.getInstance().getMapFromRequestHeader(paramRequestHeader);
    map.put("direction", "req");
    map.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(paramRequestHeader.getKitSdkVersion())));
    map.put("phoneType", Util.getSystemProperties("ro.logsystem.usertype", ""));
    HiAnalyticsUtil.getInstance().onNewEvent(paramContext, "HMS_SDK_BASE_START_RESOLUTION", map);
  }
  
  private void biReportRequestReturnIpc(Context paramContext, ResponseHeader paramResponseHeader) {
    HiAnalyticsUtil.getInstance();
    Map<String, String> map = HiAnalyticsUtil.getMapFromRequestHeader(paramResponseHeader);
    map.put("direction", "rsp");
    map.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.requestHeader.getKitSdkVersion())));
    map.put("phoneType", Util.getSystemProperties("ro.logsystem.usertype", ""));
    HiAnalyticsUtil.getInstance().onNewEvent(paramContext, "HMS_SDK_BASE_CALL_AIDL", map);
  }
  
  private void biReportRequestReturnSolution(Context paramContext, ResponseHeader paramResponseHeader, long paramLong) {
    HiAnalyticsUtil.getInstance();
    Map<String, String> map = HiAnalyticsUtil.getMapFromRequestHeader(paramResponseHeader);
    map.put("direction", "rsp");
    map.put("waitTime", String.valueOf(paramLong));
    map.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.requestHeader.getKitSdkVersion())));
    map.put("phoneType", Util.getSystemProperties("ro.logsystem.usertype", ""));
    HiAnalyticsUtil.getInstance().onNewEvent(paramContext, "HMS_SDK_BASE_START_RESOLUTION", map);
  }
  
  private BaseCallBack getBaseCallBackReplay() {
    return this.baseCallBackReplay;
  }
  
  private BaseCallBack getCallBack() {
    BaseCallBack baseCallBack2 = this.callback;
    BaseCallBack baseCallBack1 = baseCallBack2;
    if (baseCallBack2 == null) {
      HMSLog.e("BaseAdapter", "callback null");
      baseCallBack1 = null;
    } 
    return baseCallBack1;
  }
  
  private Activity getCpActivity() {
    if (this.activityWeakReference == null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("activityWeakReference is ");
      stringBuilder1.append(this.activityWeakReference);
      HMSLog.i("BaseAdapter", stringBuilder1.toString());
      return null;
    } 
    ApiClient apiClient = this.api.get();
    if (apiClient == null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("tmpApi is ");
      stringBuilder1.append(apiClient);
      HMSLog.i("BaseAdapter", stringBuilder1.toString());
      return null;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("activityWeakReference has ");
    stringBuilder.append(this.activityWeakReference.get());
    HMSLog.i("BaseAdapter", stringBuilder.toString());
    return Util.getActiveActivity(this.activityWeakReference.get(), apiClient.getContext());
  }
  
  private String getJsonHeaderReplay() {
    return this.jsonHeaderReplay;
  }
  
  private String getJsonObjectReplay() {
    return this.jsonObjectReplay;
  }
  
  private Parcelable getParcelableReplay() {
    return this.parcelableReplay;
  }
  
  private String getResponseHeaderForError(int paramInt) {
    this.responseHeader.setTransactionId(this.requestHeader.getTransactionId());
    this.responseHeader.setAppID(this.requestHeader.getAppID());
    this.responseHeader.setApiName(this.requestHeader.getApiName());
    this.responseHeader.setSrvName(this.requestHeader.getSrvName());
    this.responseHeader.setPkgName(this.requestHeader.getPkgName());
    this.responseHeader.setStatusCode(1);
    this.responseHeader.setErrorCode(paramInt);
    this.responseHeader.setErrorReason("Core error");
    return this.responseHeader.toJson();
  }
  
  private void initObserver() {
    this.observer = new SystemObserver() {
        public boolean onSolutionResult(Intent param1Intent, String param1String) {
          BaseAdapter.BaseCallBack baseCallBack;
          if (TextUtils.isEmpty(param1String)) {
            HMSLog.e("BaseAdapter", "onSolutionResult but id is null");
            baseCallBack = BaseAdapter.this.getCallBack();
            if (baseCallBack == null) {
              HMSLog.e("BaseAdapter", "onSolutionResult baseCallBack null");
              return true;
            } 
            baseCallBack.onError(BaseAdapter.this.getResponseHeaderForError(-6));
            return true;
          } 
          if (param1String.equals(BaseAdapter.this.transactionId)) {
            String str1;
            StringBuilder stringBuilder1;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("onSolutionResult + id is :");
            stringBuilder2.append(param1String);
            HMSLog.i("BaseAdapter", stringBuilder2.toString());
            BaseAdapter.BaseCallBack baseCallBack1 = BaseAdapter.this.getCallBack();
            if (baseCallBack1 == null) {
              HMSLog.e("BaseAdapter", "onResult baseCallBack null");
              return true;
            } 
            long l2 = 0L;
            if (baseCallBack == null) {
              HMSLog.e("BaseAdapter", "onSolutionResult but data is null");
              str1 = BaseAdapter.this.getResponseHeaderForError(-7);
              BaseAdapter baseAdapter = BaseAdapter.this;
              baseAdapter.biReportRequestReturnSolution(baseAdapter.appContext, BaseAdapter.this.responseHeader, 0L);
              baseCallBack1.onError(str1);
              return true;
            } 
            if (str1.hasExtra("kit_update_result")) {
              int i = str1.getIntExtra("kit_update_result", 0);
              stringBuilder1 = new StringBuilder();
              stringBuilder1.append("kit_update_result is ");
              stringBuilder1.append(i);
              HMSLog.i("BaseAdapter", stringBuilder1.toString());
              if (i == 1) {
                HMSLog.e("BaseAdapter", "kit update success,replay request");
                BaseAdapter.this.replayRequest();
                return true;
              } 
              HMSLog.e("BaseAdapter", "kit update failed");
              baseCallBack1.onError(BaseAdapter.this.getResponseHeaderForError(-10));
              return true;
            } 
            HMSLog.e("BaseAdapter", "onComplete for on activity result");
            String str2 = stringBuilder1.getStringExtra("json_header");
            String str3 = stringBuilder1.getStringExtra("json_body");
            Object object1 = JsonUtil.getInfoFromJsonobject(str2, "status_code");
            Object object2 = JsonUtil.getInfoFromJsonobject(str2, "error_code");
            long l1 = l2;
            if (stringBuilder1.hasExtra("HMS_FOREGROUND_RES_UI")) {
              Object object = JsonUtil.getInfoFromJsonobject(stringBuilder1.getStringExtra("HMS_FOREGROUND_RES_UI"), "uiDuration");
              l1 = l2;
              if (object instanceof Long)
                l1 = ((Long)object).longValue(); 
            } 
            if (object1 instanceof Integer && object2 instanceof Integer) {
              int i = ((Integer)object1).intValue();
              int j = ((Integer)object2).intValue();
              BaseAdapter.this.getResponseHeaderForError(j);
              BaseAdapter.this.responseHeader.setStatusCode(i);
              BaseAdapter baseAdapter = BaseAdapter.this;
              baseAdapter.biReportRequestReturnSolution(baseAdapter.appContext, BaseAdapter.this.responseHeader, l1);
            } else {
              BaseAdapter.this.getResponseHeaderForError(-8);
              BaseAdapter baseAdapter = BaseAdapter.this;
              baseAdapter.biReportRequestReturnSolution(baseAdapter.appContext, BaseAdapter.this.responseHeader, l1);
            } 
            baseCallBack1.onComplete(str2, str3, null);
            return true;
          } 
          return false;
        }
        
        public boolean onUpdateResult(int param1Int) {
          return false;
        }
      };
  }
  
  private void replayRequest() {
    if (this.jsonHeaderReplay != null) {
      if (this.baseCallBackReplay == null)
        return; 
      this.responseHeader = null;
      this.responseHeader = new ResponseHeader();
      baseRequest(getJsonHeaderReplay(), getJsonObjectReplay(), getParcelableReplay(), getBaseCallBackReplay());
    } 
  }
  
  private void setBaseCallBackReplay(BaseCallBack paramBaseCallBack) {
    this.baseCallBackReplay = paramBaseCallBack;
  }
  
  private void setJsonHeaderReplay(String paramString) {
    this.jsonHeaderReplay = paramString;
  }
  
  private void setJsonObjectReplay(String paramString) {
    this.jsonObjectReplay = paramString;
  }
  
  private void setParcelableReplay(Parcelable paramParcelable) {
    this.parcelableReplay = paramParcelable;
  }
  
  private void setReplayData(String paramString1, String paramString2, Parcelable paramParcelable, BaseCallBack paramBaseCallBack) {
    setJsonHeaderReplay(paramString1);
    setJsonObjectReplay(paramString2);
    setParcelableReplay(paramParcelable);
    setBaseCallBackReplay(paramBaseCallBack);
  }
  
  private void startResolution(Activity paramActivity, Parcelable paramParcelable) {
    HMSLog.i("BaseAdapter", "startResolution");
    RequestHeader requestHeader = this.requestHeader;
    if (requestHeader != null)
      biReportRequestEntrySolution(this.appContext, requestHeader); 
    if (this.observer == null)
      initObserver(); 
    SystemManager.getSystemNotifier().registerObserver(this.observer);
    Intent intent = BridgeActivity.getIntentStartBridgeActivity(paramActivity, BaseResolutionAdapter.class.getName());
    Bundle bundle = new Bundle();
    bundle.putParcelable("resolution", paramParcelable);
    intent.putExtras(bundle);
    intent.putExtra("transaction_id", this.transactionId);
    paramActivity.startActivity(intent);
  }
  
  public void baseRequest(String paramString1, String paramString2, Parcelable paramParcelable, BaseCallBack paramBaseCallBack) {
    setReplayData(paramString1, paramString2, paramParcelable, paramBaseCallBack);
    if (this.api == null) {
      HMSLog.e("BaseAdapter", "client is null");
      paramBaseCallBack.onError(getResponseHeaderForError(-2));
      return;
    } 
    this.callback = paramBaseCallBack;
    JsonUtil.jsonToEntity(paramString1, (IMessageEntity)this.requestHeader);
    CoreBaseRequest coreBaseRequest = new CoreBaseRequest();
    coreBaseRequest.setJsonObject(paramString2);
    coreBaseRequest.setJsonHeader(paramString1);
    coreBaseRequest.setParcelable(paramParcelable);
    paramString1 = this.requestHeader.getApiName();
    if (TextUtils.isEmpty(paramString1)) {
      HMSLog.e("BaseAdapter", "get uri null");
      paramBaseCallBack.onError(getResponseHeaderForError(-5));
      return;
    } 
    this.transactionId = this.requestHeader.getTransactionId();
    if (TextUtils.isEmpty(this.transactionId)) {
      HMSLog.e("BaseAdapter", "get transactionId null");
      paramBaseCallBack.onError(getResponseHeaderForError(-6));
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("in baseRequest + uri is :");
    stringBuilder.append(paramString1);
    stringBuilder.append(", transactionId is : ");
    stringBuilder.append(this.transactionId);
    HMSLog.i("BaseAdapter", stringBuilder.toString());
    biReportRequestEntryIpc(this.appContext, this.requestHeader);
    baseRequest(this.api.get(), paramString1, coreBaseRequest).setResultCallback(new BaseRequestResultCallback());
  }
  
  public static interface BaseCallBack {
    void onComplete(String param1String1, String param1String2, Parcelable param1Parcelable);
    
    void onError(String param1String);
  }
  
  public class BaseRequestResultCallback implements ResultCallback<ResolveResult<CoreBaseResponse>> {
    private AtomicBoolean isFirstRsp = new AtomicBoolean(true);
    
    private void handleSolutionIntent(BaseAdapter.BaseCallBack param1BaseCallBack, CoreBaseResponse param1CoreBaseResponse) {
      HMSLog.i("BaseAdapter", "baseCallBack.onComplete");
      PendingIntent pendingIntent = param1CoreBaseResponse.getPendingIntent();
      if (pendingIntent != null) {
        param1BaseCallBack.onComplete(param1CoreBaseResponse.getJsonHeader(), param1CoreBaseResponse.getJsonBody(), (Parcelable)pendingIntent);
        return;
      } 
      Intent intent = param1CoreBaseResponse.getIntent();
      if (intent != null) {
        param1BaseCallBack.onComplete(param1CoreBaseResponse.getJsonHeader(), param1CoreBaseResponse.getJsonBody(), (Parcelable)intent);
        return;
      } 
      param1BaseCallBack.onComplete(param1CoreBaseResponse.getJsonHeader(), param1CoreBaseResponse.getJsonBody(), null);
    }
    
    public void onResult(ResolveResult<CoreBaseResponse> param1ResolveResult) {
      Intent intent;
      BaseAdapter.BaseCallBack baseCallBack = BaseAdapter.this.getCallBack();
      if (baseCallBack == null) {
        HMSLog.e("BaseAdapter", "onResult baseCallBack null");
        return;
      } 
      if (param1ResolveResult == null) {
        HMSLog.e("BaseAdapter", "result null");
        baseCallBack.onError(BaseAdapter.this.getResponseHeaderForError(-1));
        return;
      } 
      CoreBaseResponse coreBaseResponse = (CoreBaseResponse)param1ResolveResult.getValue();
      if (coreBaseResponse == null) {
        HMSLog.e("BaseAdapter", "response null");
        baseCallBack.onError(BaseAdapter.this.getResponseHeaderForError(-1));
        return;
      } 
      if (TextUtils.isEmpty(coreBaseResponse.getJsonHeader())) {
        HMSLog.e("BaseAdapter", "jsonHeader null");
        baseCallBack.onError(BaseAdapter.this.getResponseHeaderForError(-1));
        return;
      } 
      JsonUtil.jsonToEntity(coreBaseResponse.getJsonHeader(), (IMessageEntity)BaseAdapter.this.responseHeader);
      if (this.isFirstRsp.compareAndSet(true, false)) {
        BaseAdapter baseAdapter = BaseAdapter.this;
        baseAdapter.biReportRequestReturnIpc(baseAdapter.appContext, BaseAdapter.this.responseHeader);
      } 
      if ("intent".equals(BaseAdapter.this.responseHeader.getResolution())) {
        Activity activity = BaseAdapter.this.getCpActivity();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("activity is ");
        stringBuilder.append(activity);
        HMSLog.i("BaseAdapter", stringBuilder.toString());
        if (activity == null || activity.isFinishing()) {
          HMSLog.e("BaseAdapter", "activity null");
          handleSolutionIntent(baseCallBack, coreBaseResponse);
          return;
        } 
        PendingIntent pendingIntent = coreBaseResponse.getPendingIntent();
        if (pendingIntent != null) {
          if (Util.isAvailableLibExist(BaseAdapter.this.appContext)) {
            BaseAdapter.this.startResolution(activity, (Parcelable)pendingIntent);
            return;
          } 
          baseCallBack.onError(BaseAdapter.this.getResponseHeaderForError(-9));
          return;
        } 
        intent = coreBaseResponse.getIntent();
        if (intent != null) {
          if (Util.isAvailableLibExist(BaseAdapter.this.appContext)) {
            BaseAdapter.this.startResolution(activity, (Parcelable)intent);
            return;
          } 
          baseCallBack.onError(BaseAdapter.this.getResponseHeaderForError(-9));
          return;
        } 
        HMSLog.e("BaseAdapter", "hasResolution is true but NO_SOLUTION");
        baseCallBack.onError(BaseAdapter.this.getResponseHeaderForError(-4));
        return;
      } 
      handleSolutionIntent(baseCallBack, (CoreBaseResponse)intent);
    }
  }
  
  static class MPendingResultImpl extends PendingResultImpl<ResolveResult<CoreBaseResponse>, CoreBaseResponse> {
    public MPendingResultImpl(ApiClient param1ApiClient, String param1String, IMessageEntity param1IMessageEntity) {
      super(param1ApiClient, param1String, param1IMessageEntity);
    }
    
    public ResolveResult<CoreBaseResponse> onComplete(CoreBaseResponse param1CoreBaseResponse) {
      ResolveResult<CoreBaseResponse> resolveResult = new ResolveResult(param1CoreBaseResponse);
      resolveResult.setStatus(Status.SUCCESS);
      return resolveResult;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\adapter\BaseAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */