package com.huawei.hms.push;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.push.task.ProfileTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.ProfileReq;
import com.huawei.hms.support.api.push.utils.CommFun;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.secure.android.common.encrypt.hash.SHA;

public class HmsProfile {
  public static final int CUSTOM_PROFILE = 2;
  
  public static final int HUAWEI_PROFILE = 1;
  
  public static final String a = "HmsProfile";
  
  public Context b = null;
  
  public HuaweiApi<Api.ApiOptions.NoOptions> c;
  
  public HmsProfile(Context paramContext) {
    Preconditions.checkNotNull(paramContext);
    this.b = paramContext;
    Api api = new Api("HuaweiPush.API");
    if (paramContext instanceof Activity) {
      this.c = new HuaweiApi((Activity)paramContext, api, null, (AbstractClientBuilder)new PushClientBuilder());
    } else {
      this.c = new HuaweiApi(paramContext, api, null, (AbstractClientBuilder)new PushClientBuilder());
    } 
    this.c.setKitSdkVersion(50004300);
  }
  
  public static String a(Context paramContext) {
    return AGConnectServicesConfig.a(paramContext).a("client/project_id");
  }
  
  public static HmsProfile getInstance(Context paramContext) {
    return new HmsProfile(paramContext);
  }
  
  public final Task<Void> a(int paramInt1, String paramString1, int paramInt2, String paramString2) {
    TaskCompletionSource taskCompletionSource1;
    String str2;
    if (!isSupportProfile()) {
      taskCompletionSource1 = new TaskCompletionSource();
      taskCompletionSource1.a((Exception)ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.toApiException());
      return taskCompletionSource1.a();
    } 
    TaskCompletionSource taskCompletionSource2 = taskCompletionSource1;
    if (!TextUtils.isEmpty((CharSequence)taskCompletionSource1)) {
      String str = a(this.b);
      if (TextUtils.isEmpty(str)) {
        HMSLog.i(a, "agc connect services config missing project id.");
        taskCompletionSource1 = new TaskCompletionSource();
        taskCompletionSource1.a((Exception)ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException());
        return taskCompletionSource1.a();
      } 
      taskCompletionSource2 = taskCompletionSource1;
      if (taskCompletionSource1.equals(str))
        str2 = ""; 
    } 
    ProfileReq profileReq = new ProfileReq();
    if (paramInt1 == 0) {
      profileReq.setOperation(0);
      profileReq.setType(paramInt2);
    } else {
      profileReq.setOperation(1);
    } 
    String str1 = PushBiUtil.reportEntry(this.b, "push.profile");
    try {
      profileReq.setSubjectId(str2);
      profileReq.setProfileId(SHA.a(paramString2));
      profileReq.setPkgName(this.b.getPackageName());
      return this.c.doWrite((TaskApiCall)new ProfileTask("push.profile", JsonUtil.createJsonString((IMessageEntity)profileReq), str1));
    } catch (Exception exception) {
      if (exception.getCause() instanceof ApiException) {
        TaskCompletionSource taskCompletionSource3 = new TaskCompletionSource();
        ApiException apiException = (ApiException)exception.getCause();
        taskCompletionSource3.a((Exception)apiException);
        PushBiUtil.reportExit(this.b, "push.profile", str1, apiException.getStatusCode());
        return taskCompletionSource3.a();
      } 
      TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
      PushBiUtil.reportExit(this.b, "push.profile", str1, ErrorEnum.ERROR_INTERNAL_ERROR);
      taskCompletionSource.a((Exception)ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
      return taskCompletionSource.a();
    } 
  }
  
  public Task<Void> addProfile(int paramInt, String paramString) {
    return addProfile("", paramInt, paramString);
  }
  
  public Task<Void> addProfile(String paramString1, int paramInt, String paramString2) {
    TaskCompletionSource taskCompletionSource;
    if (paramInt != 1 && paramInt != 2) {
      HMSLog.i(a, "add profile type undefined.");
      taskCompletionSource = new TaskCompletionSource();
      taskCompletionSource.a((Exception)ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
      return taskCompletionSource.a();
    } 
    if (TextUtils.isEmpty(paramString2)) {
      HMSLog.i(a, "add profile params is empty.");
      taskCompletionSource = new TaskCompletionSource();
      taskCompletionSource.a((Exception)ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
      return taskCompletionSource.a();
    } 
    return a(0, (String)taskCompletionSource, paramInt, paramString2);
  }
  
  public final boolean b(Context paramContext) {
    return (CommFun.getNCVersionCode(paramContext) >= 110001400L);
  }
  
  public Task<Void> deleteProfile(String paramString) {
    return deleteProfile("", paramString);
  }
  
  public Task<Void> deleteProfile(String paramString1, String paramString2) {
    TaskCompletionSource taskCompletionSource;
    if (TextUtils.isEmpty(paramString2)) {
      HMSLog.e(a, "del profile params is empty.");
      taskCompletionSource = new TaskCompletionSource();
      taskCompletionSource.a((Exception)ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
      return taskCompletionSource.a();
    } 
    return a(1, (String)taskCompletionSource, -1, paramString2);
  }
  
  public boolean isSupportProfile() {
    if (CommFun.isFrameworkPushExist(this.b)) {
      if (CommFun.isEmui91Below()) {
        HMSLog.i(a, "current EMUI version below 9.1, not support profile operation.");
        return false;
      } 
      if (!b(this.b)) {
        HMSLog.i(a, "current HwPushService.apk version below 11.0.1.400,please upgrade your HwPushService.apk version.");
        return false;
      } 
    } 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\push\HmsProfile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */