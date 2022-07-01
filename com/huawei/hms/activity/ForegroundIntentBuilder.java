package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.activity.internal.ForegroundInnerHeader;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.utils.Util;

public class ForegroundIntentBuilder {
  private Activity activity;
  
  private String foregroundBody;
  
  private RequestHeader foregroundHeader;
  
  private ForegroundInnerHeader innerHeader;
  
  public ForegroundIntentBuilder(Activity paramActivity) throws IllegalArgumentException {
    if (paramActivity != null) {
      this.activity = paramActivity;
      this.foregroundHeader = new RequestHeader();
      this.foregroundHeader.setPkgName(paramActivity.getPackageName());
      this.foregroundHeader.setSdkVersion(50004301);
      this.foregroundBody = "";
      this.innerHeader = new ForegroundInnerHeader();
      this.innerHeader.setApkVersion(30000000);
      return;
    } 
    throw new IllegalArgumentException("listener must not be null.");
  }
  
  public static void registerResponseCallback(String paramString, BusResponseCallback paramBusResponseCallback) {
    ForegroundBusResponseMgr.getInstance().registerObserver(paramString, paramBusResponseCallback);
  }
  
  public static void unregisterResponseCallback(String paramString) {
    ForegroundBusResponseMgr.getInstance().unRegisterObserver(paramString);
  }
  
  public Intent build() {
    Intent intent = BridgeActivity.getIntentStartBridgeActivity(this.activity, ForegroundBusDelegate.class.getName());
    if (this.foregroundHeader.getAppID() == null) {
      RequestHeader requestHeader = this.foregroundHeader;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(Util.getAppId((Context)this.activity));
      stringBuilder.append("|");
      requestHeader.setAppID(stringBuilder.toString());
    } else {
      RequestHeader requestHeader = this.foregroundHeader;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(Util.getAppId((Context)this.activity));
      stringBuilder.append("|");
      stringBuilder.append(this.foregroundHeader.getAppID());
      requestHeader.setAppID(stringBuilder.toString());
    } 
    if (TextUtils.isEmpty(this.foregroundHeader.getTransactionId())) {
      RequestHeader requestHeader = this.foregroundHeader;
      requestHeader.setTransactionId(TransactionIdCreater.getId(requestHeader.getAppID(), "hub.request"));
    } 
    intent.putExtra("HMS_FOREGROUND_REQ_HEADER", this.foregroundHeader.toJson());
    intent.putExtra("HMS_FOREGROUND_REQ_BODY", this.foregroundBody);
    intent.putExtra("HMS_FOREGROUND_REQ_INNER", this.innerHeader.toJson());
    return intent;
  }
  
  public ForegroundIntentBuilder setAction(String paramString) {
    this.foregroundHeader.setApiName(paramString);
    return this;
  }
  
  public ForegroundIntentBuilder setKitSdkVersion(int paramInt) {
    this.foregroundHeader.setKitSdkVersion(paramInt);
    return this;
  }
  
  public ForegroundIntentBuilder setMinApkVersion(int paramInt) {
    this.innerHeader.setApkVersion(paramInt);
    return this;
  }
  
  public ForegroundIntentBuilder setRequestBody(String paramString) {
    this.foregroundBody = paramString;
    return this;
  }
  
  public ForegroundIntentBuilder setResponseCallback(String paramString) {
    this.innerHeader.setResponseCallbackKey(paramString);
    return this;
  }
  
  public ForegroundIntentBuilder setResponseCallback(String paramString, BusResponseCallback paramBusResponseCallback) {
    this.innerHeader.setResponseCallbackKey(paramString);
    ForegroundBusResponseMgr.getInstance().registerObserver(paramString, paramBusResponseCallback);
    return this;
  }
  
  public ForegroundIntentBuilder setServiceName(String paramString) {
    this.foregroundHeader.setSrvName(paramString);
    return this;
  }
  
  public ForegroundIntentBuilder setSubAppId(String paramString) {
    this.foregroundHeader.setAppID(paramString);
    return this;
  }
  
  public ForegroundIntentBuilder setTransactionId(String paramString) {
    this.foregroundHeader.setTransactionId(paramString);
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\activity\ForegroundIntentBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */