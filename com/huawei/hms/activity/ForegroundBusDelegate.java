package com.huawei.hms.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.BusResponseResult;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.activity.internal.ForegroundInnerHeader;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.Map;

public class ForegroundBusDelegate implements IBridgeActivityDelegate {
  private static final String EXTRA_DELEGATE_NAME = "intent.extra.hms.core.DELEGATE_NAME";
  
  private static final String EXTRA_DELEGATE_VALUE = "com.huawei.hms.core.activity.ForegroundBus";
  
  public static final String HMS_FOREGROUND_REQ_BODY = "HMS_FOREGROUND_REQ_BODY";
  
  public static final String HMS_FOREGROUND_REQ_HEADER = "HMS_FOREGROUND_REQ_HEADER";
  
  public static final String HMS_FOREGROUND_REQ_INNER = "HMS_FOREGROUND_REQ_INNER";
  
  public static final String HMS_FOREGROUND_RESP_HEADER = "HMS_FOREGROUND_RESP_HEADER";
  
  private static final int REQUEST_CODE_BUS = 431057;
  
  private static final String TAG = "ForegroundBusDelegate";
  
  private static final String UI_JUMP_ACTIVITY_NAME = "com.huawei.hms.core.activity.UiJumpActivity";
  
  private String foregroundBody;
  
  private RequestHeader foregroundHeader;
  
  private ForegroundInnerHeader innerHeader = new ForegroundInnerHeader();
  
  private WeakReference<Activity> mThisWeakRef;
  
  private ResponseHeader responseHeader;
  
  private void biReportRequestEntryForegroundBus() {
    Map<String, String> map = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.foregroundHeader);
    map.put("direction", "req");
    map.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.foregroundHeader.getKitSdkVersion())));
    if (getActivity() != null)
      HiAnalyticsUtil.getInstance().onNewEvent(getActivity().getApplicationContext(), "HMS_SDK_BASE_ACTIVITY_STARTED", map); 
  }
  
  private void biReportRequestEntryStartCore() {
    Map<String, String> map = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.foregroundHeader);
    map.put("direction", "req");
    map.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.foregroundHeader.getKitSdkVersion())));
    if (getActivity() != null)
      HiAnalyticsUtil.getInstance().onNewEvent(getActivity().getApplicationContext(), "HMS_SDK_BASE_START_CORE_ACTIVITY", map); 
  }
  
  private void biReportRequestReturnForegroundBus() {
    if (this.foregroundHeader != null) {
      Map<String, String> map = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.foregroundHeader);
      map.put("direction", "rsp");
      map.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.foregroundHeader.getKitSdkVersion())));
      ResponseHeader responseHeader = this.responseHeader;
      if (responseHeader != null) {
        map.put("statusCode", String.valueOf(responseHeader.getStatusCode()));
        map.put("result", String.valueOf(this.responseHeader.getErrorCode()));
      } 
      if (getActivity() != null)
        HiAnalyticsUtil.getInstance().onNewEvent(getActivity().getApplicationContext(), "HMS_SDK_BASE_ACTIVITY_STARTED", map); 
    } 
  }
  
  private void biReportRequestReturnStartCore() {
    Map<String, String> map = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.foregroundHeader);
    map.put("direction", "rsp");
    map.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.foregroundHeader.getKitSdkVersion())));
    ResponseHeader responseHeader = this.responseHeader;
    if (responseHeader != null) {
      map.put("statusCode", String.valueOf(responseHeader.getStatusCode()));
      map.put("result", String.valueOf(this.responseHeader.getErrorCode()));
    } 
    if (getActivity() != null)
      HiAnalyticsUtil.getInstance().onNewEvent(getActivity().getApplicationContext(), "HMS_SDK_BASE_START_CORE_ACTIVITY", map); 
  }
  
  private void checkMinVersion() {
    if (getActivity() == null) {
      HMSLog.e("ForegroundBusDelegate", "checkMinVersion failed, activity must not be null.");
      return;
    } 
    if (!Util.isAvailableLibExist(getActivity().getApplicationContext())) {
      if (HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(getActivity().getApplicationContext(), this.innerHeader.getApkVersion()) != 0) {
        HMSLog.e("ForegroundBusDelegate", "checkMinVersion failed, and no available lib exists.");
        return;
      } 
      startApkHubActivity();
      return;
    } 
    MyAvailableCallBack myAvailableCallBack = new MyAvailableCallBack();
    AvailableAdapter availableAdapter = new AvailableAdapter(this.innerHeader.getApkVersion());
    int i = availableAdapter.isHuaweiMobileServicesAvailable((Context)getActivity());
    if (i == 0) {
      myAvailableCallBack.onComplete(i);
      return;
    } 
    if (availableAdapter.isUserResolvableError(i)) {
      resolution(getActivity(), availableAdapter, myAvailableCallBack);
      return;
    } 
    myAvailableCallBack.onComplete(i);
  }
  
  private void errorReturn(int paramInt, String paramString) {
    HMSLog.e("ForegroundBusDelegate", paramString);
    Activity activity = getActivity();
    if (activity == null)
      return; 
    BusResponseCallback busResponseCallback = getResponseCallback(this.innerHeader.getResponseCallbackKey());
    if (busResponseCallback != null) {
      BusResponseResult busResponseResult = busResponseCallback.innerError(this.mThisWeakRef.get(), paramInt, paramString);
      if (busResponseResult == null) {
        activity.setResult(0);
      } else {
        activity.setResult(busResponseResult.getCode(), busResponseResult.getIntent());
      } 
    } else {
      activity.setResult(0);
    } 
    finishBridgeActivity();
  }
  
  private void finishBridgeActivity() {
    Activity activity = getActivity();
    if (activity != null) {
      if (activity.isFinishing())
        return; 
      activity.finish();
    } 
  }
  
  private Activity getActivity() {
    WeakReference<Activity> weakReference = this.mThisWeakRef;
    return (weakReference == null) ? null : weakReference.get();
  }
  
  private BusResponseCallback getResponseCallback(String paramString) {
    return ForegroundBusResponseMgr.getInstance().get(paramString);
  }
  
  private static void resolution(Activity paramActivity, AvailableAdapter paramAvailableAdapter, AvailableAdapter.AvailableCallBack paramAvailableCallBack) {
    if (paramActivity == null)
      HMSLog.i("ForegroundBusDelegate", "null activity, could not start resolution intent"); 
    paramAvailableAdapter.startResolution(paramActivity, paramAvailableCallBack);
  }
  
  private void startApkHubActivity() {
    HMSLog.i("ForegroundBusDelegate", "startApkHubActivity");
    Activity activity = getActivity();
    if (activity == null) {
      HMSLog.e("ForegroundBusDelegate", "startApkHubActivity but activity is null");
      return;
    } 
    String str = HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageName();
    Intent intent = new Intent(this.innerHeader.getAction());
    intent.putExtra("HMS_FOREGROUND_REQ_BODY", this.foregroundBody);
    intent.setPackage(str);
    intent.setClassName(str, "com.huawei.hms.core.activity.UiJumpActivity");
    intent.putExtra("HMS_FOREGROUND_REQ_HEADER", this.foregroundHeader.toJson());
    intent.putExtra("intent.extra.hms.core.DELEGATE_NAME", "com.huawei.hms.core.activity.ForegroundBus");
    try {
      biReportRequestEntryStartCore();
      activity.startActivityForResult(intent, 431057);
      return;
    } catch (ActivityNotFoundException activityNotFoundException) {
      HMSLog.e("ForegroundBusDelegate", "Launch sign in Intent failed. hms is probably being updated：", (Throwable)activityNotFoundException);
      errorReturn(0, "launch bus intent failed");
      return;
    } 
  }
  
  private void succeedReturn(int paramInt, Intent paramIntent) {
    HMSLog.i("ForegroundBusDelegate", "succeedReturn");
    Activity activity = getActivity();
    if (activity == null)
      return; 
    activity.setResult(paramInt, paramIntent);
    finishBridgeActivity();
  }
  
  public int getRequestCode() {
    return 431057;
  }
  
  public void onBridgeActivityCreate(Activity paramActivity) {
    this.mThisWeakRef = new WeakReference<Activity>(paramActivity);
    Intent intent = paramActivity.getIntent();
    String str = intent.getStringExtra("HMS_FOREGROUND_REQ_HEADER");
    this.foregroundHeader = new RequestHeader();
    if (!this.foregroundHeader.fromJson(str)) {
      errorReturn(0, "header is invalid");
      return;
    } 
    this.foregroundBody = intent.getStringExtra("HMS_FOREGROUND_REQ_BODY");
    this.innerHeader.fromJson(intent.getStringExtra("HMS_FOREGROUND_REQ_INNER"));
    if (this.innerHeader == null) {
      errorReturn(0, "inner header is invalid");
      return;
    } 
    if (TextUtils.isEmpty(this.foregroundHeader.getApiName())) {
      errorReturn(0, "action is invalid");
      return;
    } 
    biReportRequestEntryForegroundBus();
    checkMinVersion();
  }
  
  public void onBridgeActivityDestroy() {
    biReportRequestReturnForegroundBus();
    this.mThisWeakRef = null;
  }
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt1 == 431057) {
      if (paramIntent != null && paramIntent.hasExtra("HMS_FOREGROUND_RESP_HEADER")) {
        String str = paramIntent.getStringExtra("HMS_FOREGROUND_RESP_HEADER");
        this.responseHeader = new ResponseHeader();
        JsonUtil.jsonToEntity(str, (IMessageEntity)this.responseHeader);
      } 
      biReportRequestReturnStartCore();
      BusResponseCallback busResponseCallback = getResponseCallback(this.innerHeader.getResponseCallbackKey());
      if (busResponseCallback == null) {
        succeedReturn(paramInt2, paramIntent);
      } else {
        BusResponseResult busResponseResult = busResponseCallback.succeedReturn(this.mThisWeakRef.get(), paramInt2, paramIntent);
        if (busResponseResult == null) {
          succeedReturn(paramInt2, paramIntent);
        } else {
          succeedReturn(busResponseResult.getCode(), busResponseResult.getIntent());
        } 
      } 
      return true;
    } 
    return false;
  }
  
  public void onBridgeConfigurationChanged() {}
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent) {}
  
  class MyAvailableCallBack implements AvailableAdapter.AvailableCallBack {
    private MyAvailableCallBack() {}
    
    public void onComplete(int param1Int) {
      if (param1Int == 0) {
        ForegroundBusDelegate.this.startApkHubActivity();
        return;
      } 
      HMSLog.i("ForegroundBusDelegate", "version check failed");
      ForegroundBusDelegate.this.errorReturn(0, "apk version is invalid");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\activity\ForegroundBusDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */