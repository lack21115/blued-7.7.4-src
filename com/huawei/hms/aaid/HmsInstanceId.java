package com.huawei.hms.aaid;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.opendevice.c;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.opendevice.j;
import com.huawei.hms.opendevice.k;
import com.huawei.hms.opendevice.l;
import com.huawei.hms.opendevice.o;
import com.huawei.hms.opendevice.p;
import com.huawei.hms.opendevice.q;
import com.huawei.hms.support.log.HMSLog;
import java.util.concurrent.Callable;

public class HmsInstanceId {
  public static final String TAG = "HmsInstanceId";
  
  public Context a;
  
  public PushPreferences b;
  
  public HuaweiApi<Api.ApiOptions.NoOptions> c;
  
  public HmsInstanceId(Context paramContext) {
    this.a = paramContext.getApplicationContext();
    this.b = new PushPreferences(paramContext, "aaid");
    Api api = new Api("HuaweiPush.API");
    if (paramContext instanceof Activity) {
      this.c = new HuaweiApi((Activity)paramContext, api, null, (AbstractClientBuilder)new PushClientBuilder());
    } else {
      this.c = new HuaweiApi(paramContext, api, null, (AbstractClientBuilder)new PushClientBuilder());
    } 
    this.c.setKitSdkVersion(50004300);
  }
  
  public static HmsInstanceId getInstance(Context paramContext) {
    Preconditions.checkNotNull(paramContext);
    c.c(paramContext);
    return new HmsInstanceId(paramContext);
  }
  
  public final String a(TokenReq paramTokenReq, int paramInt) throws ApiException {
    if (ProxyCenter.getProxy() != null) {
      HMSLog.i(TAG, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
      ProxyCenter.getProxy().getToken(this.a, paramTokenReq.getSubjectId(), null);
      return null;
    } 
    a(paramTokenReq.getSubjectId());
    String str = q.a(this.a, "push.gettoken");
    try {
      String str1 = TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getToken req :");
      stringBuilder.append(paramTokenReq.toString());
      HMSLog.d(str1, stringBuilder.toString());
      l l = new l("push.gettoken", paramTokenReq, this.a, str);
      l.setApiLevel(paramInt);
      return ((TokenResult)Tasks.a(this.c.doWrite((TaskApiCall)l))).getToken();
    } catch (Exception exception) {
      if (exception.getCause() instanceof ApiException) {
        ApiException apiException = (ApiException)exception.getCause();
        q.a(this.a, "push.gettoken", str, apiException.getStatusCode());
        throw apiException;
      } 
      q.a(this.a, "push.gettoken", str, ErrorEnum.ERROR_INTERNAL_ERROR);
      throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
    } 
  }
  
  public final void a() throws ApiException {
    if (Looper.getMainLooper() != Looper.myLooper())
      return; 
    throw ErrorEnum.ERROR_MAIN_THREAD.toApiException();
  }
  
  public final void a(DeleteTokenReq paramDeleteTokenReq, int paramInt) throws ApiException {
    String str2 = paramDeleteTokenReq.getSubjectId();
    if (ProxyCenter.getProxy() != null) {
      HMSLog.i(TAG, "use proxy delete token");
      ProxyCenter.getProxy().deleteToken(this.a, str2, null);
      return;
    } 
    String str1 = q.a(this.a, "push.deletetoken");
    try {
      String str3;
      String str4 = i.a(this.a).b(str2);
      if (paramDeleteTokenReq.isMultiSender() && (TextUtils.isEmpty(str4) || str4.equals(i.a(this.a).b(null)))) {
        i.a(this.a).removeKey(str2);
        str3 = TAG;
        HMSLog.i(str3, "The local subject token is null");
        return;
      } 
      str3.setToken(str4);
      k k = new k("push.deletetoken", (DeleteTokenReq)str3, str1);
      k.setApiLevel(paramInt);
      Tasks.a(this.c.doWrite((TaskApiCall)k));
      i.a(this.a).c(str2);
      return;
    } catch (Exception exception) {
      if (exception.getCause() instanceof ApiException) {
        ApiException apiException = (ApiException)exception.getCause();
        q.a(this.a, "push.deletetoken", str1, apiException.getStatusCode());
        throw apiException;
      } 
      q.a(this.a, "push.deletetoken", str1, ErrorEnum.ERROR_INTERNAL_ERROR);
      throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
    } 
  }
  
  public final void a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    if (p.b(this.a)) {
      String str = i.a(this.a).getString("subjectId");
      if (TextUtils.isEmpty(str)) {
        i.a(this.a).saveString("subjectId", paramString);
        return;
      } 
      if (!str.contains(paramString)) {
        i i = i.a(this.a);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(",");
        stringBuilder.append(paramString);
        i.saveString("subjectId", stringBuilder.toString());
        return;
      } 
    } else {
      i.a(this.a).removeKey("subjectId");
    } 
  }
  
  public void deleteAAID() throws ApiException {
    a();
    try {
      if (!this.b.containsKey("aaid"))
        return; 
      this.b.removeKey("aaid");
      PushPreferences pushPreferences = this.b;
      pushPreferences.removeKey("creationTime");
      if (!o.e(this.a))
        return; 
      if (ProxyCenter.getProxy() != null) {
        String str = TAG;
        HMSLog.i(str, "use proxy delete all token after delete AaId.");
        ProxyCenter.getProxy().deleteAllToken(this.a);
        return;
      } 
      DeleteTokenReq deleteTokenReq = o.b(this.a);
      deleteTokenReq.setDeleteType(1);
      deleteTokenReq.setMultiSender(false);
      a(deleteTokenReq, 1);
      BaseUtils.deleteAllTokenCache(this.a);
      return;
    } catch (ApiException apiException) {
      throw apiException;
    } catch (Exception exception) {
      throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
    } 
  }
  
  public void deleteToken(String paramString) throws ApiException {
    a();
    if (!TextUtils.isEmpty(paramString)) {
      String str = o.d(this.a);
      if (!TextUtils.isEmpty(str)) {
        if (paramString.equals(str)) {
          deleteToken(null, null);
          return;
        } 
        DeleteTokenReq deleteTokenReq = o.a(this.a, paramString);
        deleteTokenReq.setMultiSender(true);
        a(deleteTokenReq, 2);
        return;
      } 
      throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
    } 
    throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
  }
  
  public void deleteToken(String paramString1, String paramString2) throws ApiException {
    a();
    DeleteTokenReq deleteTokenReq = o.a(this.a, paramString1, paramString2);
    deleteTokenReq.setMultiSender(false);
    a(deleteTokenReq, 1);
  }
  
  public Task<AAIDResult> getAAID() {
    try {
      return Tasks.a((Callable)new j(this.a.getApplicationContext()));
    } catch (Exception exception) {
      TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
      taskCompletionSource.a((Exception)ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
      return taskCompletionSource.a();
    } 
  }
  
  public long getCreationTime() {
    try {
      if (!this.b.containsKey("creationTime"))
        getAAID(); 
      return this.b.getLong("creationTime");
    } catch (Exception exception) {
      return 0L;
    } 
  }
  
  public String getId() {
    return o.c(this.a);
  }
  
  @Deprecated
  public String getToken() {
    try {
      return getToken(null, null);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public String getToken(String paramString) throws ApiException {
    a();
    if (!TextUtils.isEmpty(paramString)) {
      String str = o.d(this.a);
      if (!TextUtils.isEmpty(str)) {
        if (paramString.equals(str))
          return getToken(null, null); 
        TokenReq tokenReq = o.b(this.a, paramString);
        tokenReq.setAaid(getId());
        tokenReq.setMultiSender(true);
        return a(tokenReq, 2);
      } 
      throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
    } 
    throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
  }
  
  public String getToken(String paramString1, String paramString2) throws ApiException {
    a();
    TokenReq tokenReq = o.b(this.a, paramString1, paramString2);
    tokenReq.setAaid(getId());
    tokenReq.setMultiSender(false);
    i.a(this.a).saveString(this.a.getPackageName(), "1");
    return a(tokenReq, 1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\aaid\HmsInstanceId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */