package com.huawei.hms.aaid;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.opendevice.l;
import com.huawei.hms.opendevice.o;
import com.huawei.hms.opendevice.q;
import com.huawei.hms.support.log.HMSLog;
import java.util.UUID;

@Deprecated
public class HmsInstanceIdEx {
  public static final String TAG = "HmsInstanceIdEx";
  
  public Context a = null;
  
  public PushPreferences b = null;
  
  public HuaweiApi<Api.ApiOptions.NoOptions> c;
  
  public HmsInstanceIdEx(Context paramContext) {
    this.a = paramContext;
    this.b = new PushPreferences(paramContext, "aaid");
    Api api = new Api("HuaweiPush.API");
    if (paramContext instanceof Activity) {
      this.c = new HuaweiApi((Activity)paramContext, api, null, (AbstractClientBuilder)new PushClientBuilder());
    } else {
      this.c = new HuaweiApi(paramContext, api, null, (AbstractClientBuilder)new PushClientBuilder());
    } 
    this.c.setKitSdkVersion(50004300);
  }
  
  public static HmsInstanceIdEx getInstance(Context paramContext) {
    Preconditions.checkNotNull(paramContext);
    return new HmsInstanceIdEx(paramContext);
  }
  
  public final Task<TokenResult> a(Exception paramException) {
    TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
    taskCompletionSource.a(paramException);
    return taskCompletionSource.a();
  }
  
  public final String a(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("creationTime");
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
  
  public void deleteAAID(String paramString) throws ApiException {
    if (paramString != null)
      try {
        if (this.b.containsKey(paramString)) {
          this.b.removeKey(paramString);
          this.b.removeKey(a(paramString));
        } 
        return;
      } catch (RuntimeException runtimeException) {
        throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
      } catch (Exception exception) {
        throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
      }  
    throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
  }
  
  public String getAAId(String paramString) throws ApiException {
    if (paramString != null)
      try {
        if (this.b.containsKey(paramString))
          return this.b.getString(paramString); 
        String str = UUID.randomUUID().toString();
        this.b.saveString(paramString, str);
        this.b.saveLong(a(paramString), Long.valueOf(System.currentTimeMillis()));
        return str;
      } catch (RuntimeException runtimeException) {
        throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
      } catch (Exception exception) {
        throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
      }  
    throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
  }
  
  public long getCreationTime(String paramString) throws ApiException {
    if (paramString != null)
      try {
        if (!this.b.containsKey(a(paramString)))
          getAAId(paramString); 
        return this.b.getLong(a(paramString));
      } catch (RuntimeException runtimeException) {
        throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
      } catch (Exception exception) {
        throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
      }  
    throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
  }
  
  public Task<TokenResult> getToken() {
    if (ProxyCenter.getProxy() != null)
      try {
        String str1 = TAG;
        HMSLog.i(str1, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
        ProxyCenter.getProxy().getToken(this.a, null, null);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.a(new TokenResult());
        return taskCompletionSource.a();
      } catch (ApiException apiException) {
        return a((Exception)apiException);
      } catch (Exception exception) {
        return a((Exception)ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
      }  
    String str = q.a(this.a, "push.gettoken");
    try {
      TokenReq tokenReq = o.b(this.a, null, null);
      tokenReq.setAaid(HmsInstanceId.getInstance(this.a).getId());
      return this.c.doWrite((TaskApiCall)new l("push.gettoken", tokenReq, this.a, str));
    } catch (RuntimeException runtimeException) {
      q.a(this.a, "push.gettoken", str, ErrorEnum.ERROR_INTERNAL_ERROR);
      return a((Exception)ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
    } catch (Exception exception) {
      q.a(this.a, "push.gettoken", str, ErrorEnum.ERROR_INTERNAL_ERROR);
      return a((Exception)ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\aaid\HmsInstanceIdEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */