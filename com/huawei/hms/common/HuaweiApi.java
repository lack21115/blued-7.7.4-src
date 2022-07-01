package com.huawei.hms.common;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.common.internal.ConnectionManagerKey;
import com.huawei.hms.common.internal.HuaweiApiManager;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.hianalytics.HiAnalyticsInnerClient;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSBIInitializer;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

public class HuaweiApi<TOption extends Api.ApiOptions> {
  private static final String TAG = "HuaweiApi";
  
  private int apiLevel = 1;
  
  private String innerHmsPkg;
  
  private boolean isFirstReqSent = false;
  
  private WeakReference<Activity> mActivity;
  
  private String mAppID;
  
  private AbstractClientBuilder<?, TOption> mClientBuilder;
  
  private ConnectionManagerKey<TOption> mConnectionManagerKey;
  
  private Context mContext;
  
  private String mCpID;
  
  private String mHostAppid;
  
  private HuaweiApiManager mHuaweiApiManager;
  
  private int mKitSdkVersion;
  
  private TOption mOption;
  
  private SubAppInfo mSubAppInfo;
  
  public HuaweiApi(Activity paramActivity, Api<TOption> paramApi, TOption paramTOption, AbstractClientBuilder paramAbstractClientBuilder) {
    Checker.checkNonNull(paramActivity, "Null activity is not permitted.");
    this.mActivity = new WeakReference<Activity>(paramActivity);
    init((Context)paramActivity, paramApi, paramTOption, paramAbstractClientBuilder, 0, null);
  }
  
  public HuaweiApi(Activity paramActivity, Api<TOption> paramApi, TOption paramTOption, AbstractClientBuilder paramAbstractClientBuilder, int paramInt) {
    Checker.checkNonNull(paramActivity, "Null activity is not permitted.");
    this.mActivity = new WeakReference<Activity>(paramActivity);
    init((Context)paramActivity, paramApi, paramTOption, paramAbstractClientBuilder, paramInt, null);
  }
  
  public HuaweiApi(Activity paramActivity, Api<TOption> paramApi, TOption paramTOption, AbstractClientBuilder paramAbstractClientBuilder, int paramInt, String paramString) {
    Checker.checkNonNull(paramActivity, "Null activity is not permitted.");
    this.mActivity = new WeakReference<Activity>(paramActivity);
    init((Context)paramActivity, paramApi, paramTOption, paramAbstractClientBuilder, paramInt, paramString);
  }
  
  public HuaweiApi(Context paramContext, Api<TOption> paramApi, TOption paramTOption, AbstractClientBuilder paramAbstractClientBuilder) {
    Checker.checkNonNull(paramContext, "Null context is not permitted.");
    init(paramContext, paramApi, paramTOption, paramAbstractClientBuilder, 0, null);
  }
  
  public HuaweiApi(Context paramContext, Api<TOption> paramApi, TOption paramTOption, AbstractClientBuilder paramAbstractClientBuilder, int paramInt) {
    Checker.checkNonNull(paramContext, "Null context is not permitted.");
    init(paramContext, paramApi, paramTOption, paramAbstractClientBuilder, paramInt, null);
  }
  
  public HuaweiApi(Context paramContext, Api<TOption> paramApi, TOption paramTOption, AbstractClientBuilder paramAbstractClientBuilder, int paramInt, String paramString) {
    Checker.checkNonNull(paramContext, "Null context is not permitted.");
    init(paramContext, paramApi, paramTOption, paramAbstractClientBuilder, paramInt, paramString);
  }
  
  private void init(Context paramContext, Api<TOption> paramApi, TOption paramTOption, AbstractClientBuilder<?, TOption> paramAbstractClientBuilder, int paramInt, String paramString) {
    this.mContext = paramContext.getApplicationContext();
    this.mHuaweiApiManager = HuaweiApiManager.getInstance(this.mContext);
    this.mConnectionManagerKey = ConnectionManagerKey.createConnectionManagerKey(paramContext, paramApi, (Api.ApiOptions)paramTOption, paramString);
    this.mOption = paramTOption;
    this.mClientBuilder = paramAbstractClientBuilder;
    this.mHostAppid = Util.getAppId(paramContext);
    this.mAppID = this.mHostAppid;
    this.mCpID = Util.getCpId(paramContext);
    this.mSubAppInfo = new SubAppInfo("");
    this.mKitSdkVersion = paramInt;
    if (!TextUtils.isEmpty(paramString))
      if (paramString.equals(this.mHostAppid)) {
        HMSLog.e("HuaweiApi", "subAppId is host appid");
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("subAppId is ");
        stringBuilder.append(paramString);
        HMSLog.i("HuaweiApi", stringBuilder.toString());
        this.mSubAppInfo = new SubAppInfo(paramString);
      }  
    initBI(paramContext);
  }
  
  private void initBI(Context paramContext) {
    HMSBIInitializer.getInstance(paramContext).initBI();
  }
  
  private <TResult, TClient extends AnyClient> Task<TResult> sendRequest(TaskApiCall<TClient, TResult> paramTaskApiCall) {
    TaskCompletionSource taskCompletionSource;
    if (paramTaskApiCall.getToken() == null) {
      taskCompletionSource = new TaskCompletionSource();
    } else {
      taskCompletionSource = new TaskCompletionSource(paramTaskApiCall.getToken());
    } 
    this.mHuaweiApiManager.sendRequest(this, paramTaskApiCall, taskCompletionSource);
    return taskCompletionSource.a();
  }
  
  public Task<Boolean> disconnectService() {
    TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
    this.mHuaweiApiManager.disconnectService(this, taskCompletionSource);
    return taskCompletionSource.a();
  }
  
  public <TResult, TClient extends AnyClient> Task<TResult> doWrite(TaskApiCall<TClient, TResult> paramTaskApiCall) {
    TaskCompletionSource taskCompletionSource;
    String str;
    this.isFirstReqSent = true;
    if (paramTaskApiCall == null) {
      HMSLog.e("HuaweiApi", "in doWrite:taskApiCall is null");
      taskCompletionSource = new TaskCompletionSource();
      taskCompletionSource.a(new ApiException(Status.FAILURE));
      return taskCompletionSource.a();
    } 
    if (TextUtils.isEmpty(this.mSubAppInfo.getSubAppID())) {
      str = this.mAppID;
    } else {
      str = this.mSubAppInfo.getSubAppID();
    } 
    HiAnalyticsInnerClient.reportEntryClient(this.mContext, taskCompletionSource.getUri(), str, taskCompletionSource.getTransactionId(), String.valueOf(getKitSdkVersion()));
    return sendRequest((TaskApiCall<AnyClient, TResult>)taskCompletionSource);
  }
  
  public Activity getActivity() {
    WeakReference<Activity> weakReference = this.mActivity;
    return (weakReference != null) ? weakReference.get() : null;
  }
  
  public int getApiLevel() {
    return this.apiLevel;
  }
  
  public String getAppID() {
    return this.mAppID;
  }
  
  public AnyClient getClient(Looper paramLooper, HuaweiApiManager.ConnectionManager paramConnectionManager) {
    return this.mClientBuilder.buildClient(this.mContext, getClientSetting(), (BaseHmsClient.OnConnectionFailedListener)paramConnectionManager, (BaseHmsClient.ConnectionCallbacks)paramConnectionManager);
  }
  
  protected ClientSettings getClientSetting() {
    ClientSettings clientSettings = new ClientSettings(this.mContext.getPackageName(), this.mContext.getClass().getName(), getScopes(), this.mHostAppid, null, this.mSubAppInfo);
    clientSettings.setCpID(this.mCpID);
    if (TextUtils.isEmpty(this.innerHmsPkg)) {
      this.innerHmsPkg = HMSPackageManager.getInstance(this.mContext).getHMSPackageName();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("inner hms is empty,hms pkg name is ");
      stringBuilder.append(this.innerHmsPkg);
      HMSLog.i("HuaweiApi", stringBuilder.toString());
    } 
    clientSettings.setInnerHmsPkg(this.innerHmsPkg);
    WeakReference<Activity> weakReference = this.mActivity;
    if (weakReference != null)
      clientSettings.setCpActivity(weakReference.get()); 
    return clientSettings;
  }
  
  public ConnectionManagerKey<TOption> getConnectionManagerKey() {
    return this.mConnectionManagerKey;
  }
  
  public Context getContext() {
    return this.mContext;
  }
  
  public int getKitSdkVersion() {
    return this.mKitSdkVersion;
  }
  
  public TOption getOption() {
    return this.mOption;
  }
  
  protected List<Scope> getScopes() {
    return Collections.emptyList();
  }
  
  public String getSubAppID() {
    return this.mSubAppInfo.getSubAppID();
  }
  
  public void setApiLevel(int paramInt) {
    this.apiLevel = paramInt;
  }
  
  public void setInnerHms() {
    this.innerHmsPkg = this.mContext.getPackageName();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("init inner hms pkg info:");
    stringBuilder.append(this.innerHmsPkg);
    HMSLog.i("HuaweiApi", stringBuilder.toString());
  }
  
  public void setKitSdkVersion(int paramInt) {
    this.mKitSdkVersion = paramInt;
  }
  
  public void setSubAppId(String paramString) throws ApiException {
    if (setSubAppInfo(new SubAppInfo(paramString)))
      return; 
    throw new ApiException(Status.FAILURE);
  }
  
  @Deprecated
  public boolean setSubAppInfo(SubAppInfo paramSubAppInfo) {
    HMSLog.i("HuaweiApi", "Enter setSubAppInfo");
    SubAppInfo subAppInfo = this.mSubAppInfo;
    if (subAppInfo != null && !TextUtils.isEmpty(subAppInfo.getSubAppID())) {
      HMSLog.e("HuaweiApi", "subAppInfo is already set");
      return false;
    } 
    if (paramSubAppInfo == null) {
      HMSLog.e("HuaweiApi", "subAppInfo is null");
      return false;
    } 
    String str = paramSubAppInfo.getSubAppID();
    if (TextUtils.isEmpty(str)) {
      HMSLog.e("HuaweiApi", "subAppId is empty");
      return false;
    } 
    if (str.equals(this.mHostAppid)) {
      HMSLog.e("HuaweiApi", "subAppId is host appid");
      return false;
    } 
    if (this.isFirstReqSent) {
      HMSLog.e("HuaweiApi", "Client has sent request to Huawei Mobile Services, setting subAppId is not allowed");
      return false;
    } 
    this.mSubAppInfo = new SubAppInfo(paramSubAppInfo);
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\HuaweiApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */