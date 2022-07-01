package com.huawei.hms.push;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.encrypt.PushEncrypter;
import com.huawei.hms.aaid.init.AutoInitHelper;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.push.task.BaseVoidTask;
import com.huawei.hms.push.task.IntentCallable;
import com.huawei.hms.push.task.SendUpStreamTask;
import com.huawei.hms.push.task.SubscribeTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.EnableNotifyReq;
import com.huawei.hms.support.api.entity.push.SubscribeReq;
import com.huawei.hms.support.api.entity.push.UpSendMsgReq;
import com.huawei.hms.support.api.push.utils.CommFun;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.NetWorkUtil;
import java.util.concurrent.Callable;
import java.util.regex.Pattern;

public class HmsMessaging {
  public static final String DEFAULT_TOKEN_SCOPE = "HCM";
  
  public static final Pattern a = Pattern.compile("[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
  
  public Context b;
  
  public HuaweiApi<Api.ApiOptions.NoOptions> c;
  
  public HmsMessaging(Context paramContext) {
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
  
  public static HmsMessaging getInstance(Context paramContext) {
    // Byte code:
    //   0: ldc com/huawei/hms/push/HmsMessaging
    //   2: monitorenter
    //   3: new com/huawei/hms/push/HmsMessaging
    //   6: dup
    //   7: aload_0
    //   8: invokespecial <init> : (Landroid/content/Context;)V
    //   11: astore_0
    //   12: ldc com/huawei/hms/push/HmsMessaging
    //   14: monitorexit
    //   15: aload_0
    //   16: areturn
    //   17: astore_0
    //   18: ldc com/huawei/hms/push/HmsMessaging
    //   20: monitorexit
    //   21: aload_0
    //   22: athrow
    // Exception table:
    //   from	to	target	type
    //   3	12	17	finally
  }
  
  public final Task<Void> a(String paramString1, String paramString2) {
    String str = PushBiUtil.reportEntry(this.b, "push.subscribe");
    if (paramString1 != null && a.matcher(paramString1).matches()) {
      if (ProxyCenter.getProxy() != null) {
        HMSLog.i("HmsMessaging", "use proxy subscribe.");
        return TextUtils.equals(paramString2, "Sub") ? ProxyCenter.getProxy().subscribe(this.b, paramString1, str) : ProxyCenter.getProxy().unsubscribe(this.b, paramString1, str);
      } 
      try {
        ErrorEnum errorEnum = d.a(this.b);
        if (errorEnum == ErrorEnum.SUCCESS) {
          if (NetWorkUtil.getNetworkType(this.b) != 0) {
            SubscribeReq subscribeReq = new SubscribeReq(this.b, paramString2, paramString1);
            subscribeReq.setToken(BaseUtils.getLocalToken(this.b, null));
            return CommFun.isEmui10Plus() ? this.c.doWrite((TaskApiCall)new BaseVoidTask("push.subscribe", JsonUtil.createJsonString((IMessageEntity)subscribeReq), str)) : this.c.doWrite((TaskApiCall)new SubscribeTask("push.subscribe", JsonUtil.createJsonString((IMessageEntity)subscribeReq), str));
          } 
          HMSLog.e("HmsMessaging", "no network");
          throw ErrorEnum.ERROR_NO_NETWORK.toApiException();
        } 
        throw errorEnum.toApiException();
      } catch (ApiException apiException) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.a((Exception)apiException);
        PushBiUtil.reportExit(this.b, "push.subscribe", str, apiException.getStatusCode());
        return taskCompletionSource.a();
      } catch (Exception exception) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.a((Exception)ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
        PushBiUtil.reportExit(this.b, "push.subscribe", str, ErrorEnum.ERROR_INTERNAL_ERROR);
        return taskCompletionSource.a();
      } 
    } 
    PushBiUtil.reportExit(this.b, "push.subscribe", str, ErrorEnum.ERROR_ARGUMENTS_INVALID);
    HMSLog.e("HmsMessaging", "Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
    throw new IllegalArgumentException("Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
  }
  
  public final Task<Void> a(boolean paramBoolean) {
    String str = PushBiUtil.reportEntry(this.b, "push.setNotifyFlag");
    if (!CommFun.isFrameworkPushExist(this.b) || CommFun.isEmui10Plus()) {
      HMSLog.i("HmsMessaging", "turn on/off with AIDL");
      EnableNotifyReq enableNotifyReq = new EnableNotifyReq();
      enableNotifyReq.setPackageName(this.b.getPackageName());
      enableNotifyReq.setEnable(paramBoolean);
      return this.c.doWrite((TaskApiCall)new BaseVoidTask("push.setNotifyFlag", JsonUtil.createJsonString((IMessageEntity)enableNotifyReq), str));
    } 
    if (HwBuildEx.VERSION.EMUI_SDK_INT < 12) {
      HMSLog.e("HmsMessaging", "operation not available on Huawei device with EMUI lower than 5.1");
      TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
      taskCompletionSource.a((Exception)ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.toApiException());
      PushBiUtil.reportExit(this.b, "push.setNotifyFlag", str, ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED);
      return taskCompletionSource.a();
    } 
    if (CommFun.getNCVersionCode(this.b) < 90101310L) {
      HMSLog.i("HmsMessaging", "turn on/off with broadcast v1");
      Context context = this.b;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.b.getPackageName());
      stringBuilder1.append("#");
      stringBuilder1.append(paramBoolean);
      String str1 = PushEncrypter.encrypterOld(context, stringBuilder1.toString());
      Intent intent1 = (new Intent("com.huawei.intent.action.SELF_SHOW_FLAG")).putExtra("enalbeFlag", str1);
      intent1.setPackage("android");
      return Tasks.a((Callable)new IntentCallable(this.b, intent1, str));
    } 
    HMSLog.i("HmsMessaging", "turn on/off with broadcast v2");
    (new PushPreferences(this.b, "push_notify_flag")).saveBoolean("notify_msg_enable", paramBoolean ^ true);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("content://");
    stringBuilder.append(this.b.getPackageName());
    stringBuilder.append(".huawei.push.provider/");
    stringBuilder.append("push_notify_flag");
    stringBuilder.append(".xml");
    Uri uri = Uri.parse(stringBuilder.toString());
    Intent intent = new Intent("com.huawei.android.push.intent.SDK_COMMAND");
    intent.putExtra("type", "enalbeFlag");
    intent.putExtra("pkgName", this.b.getPackageName());
    intent.putExtra("url", (Parcelable)uri);
    intent.setPackage("android");
    return Tasks.a((Callable)new IntentCallable(this.b, intent, str));
  }
  
  public final void a(RemoteMessage paramRemoteMessage) {
    UpSendMsgReq upSendMsgReq;
    String str = PushBiUtil.reportEntry(this.b, "push.sendMessage");
    ErrorEnum errorEnum = d.a(this.b);
    if (errorEnum == ErrorEnum.SUCCESS) {
      if (!TextUtils.isEmpty(paramRemoteMessage.getTo())) {
        if (!TextUtils.isEmpty(paramRemoteMessage.getMessageId())) {
          if (!TextUtils.isEmpty(paramRemoteMessage.getData())) {
            upSendMsgReq = new UpSendMsgReq();
            upSendMsgReq.setPackageName(this.b.getPackageName());
            upSendMsgReq.setMessageId(paramRemoteMessage.getMessageId());
            upSendMsgReq.setTo(paramRemoteMessage.getTo());
            upSendMsgReq.setData(paramRemoteMessage.getData());
            upSendMsgReq.setMessageType(paramRemoteMessage.getMessageType());
            upSendMsgReq.setTtl(paramRemoteMessage.getTtl());
            upSendMsgReq.setCollapseKey(paramRemoteMessage.getCollapseKey());
            upSendMsgReq.setSendMode(paramRemoteMessage.getSendMode());
            upSendMsgReq.setReceiptMode(paramRemoteMessage.getReceiptMode());
            if (CommFun.isEmui10Plus()) {
              this.c.doWrite((TaskApiCall)new BaseVoidTask("push.sendMessage", JsonUtil.createJsonString((IMessageEntity)upSendMsgReq), str));
              return;
            } 
            a(upSendMsgReq, str);
            return;
          } 
          HMSLog.e("HmsMessaging", "Mandatory parameter 'data' missing");
          PushBiUtil.reportExit(this.b, "push.sendMessage", str, ErrorEnum.ERROR_ARGUMENTS_INVALID);
          throw new IllegalArgumentException("Mandatory parameter 'data' missing");
        } 
        HMSLog.e("HmsMessaging", "Mandatory parameter 'message_id' missing");
        PushBiUtil.reportExit(this.b, "push.sendMessage", str, ErrorEnum.ERROR_ARGUMENTS_INVALID);
        throw new IllegalArgumentException("Mandatory parameter 'message_id' missing");
      } 
      HMSLog.e("HmsMessaging", "Mandatory parameter 'to' missing");
      PushBiUtil.reportExit(this.b, "push.sendMessage", str, ErrorEnum.ERROR_ARGUMENTS_INVALID);
      throw new IllegalArgumentException("Mandatory parameter 'to' missing");
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Message sent failed:");
    stringBuilder.append(upSendMsgReq.getExternalCode());
    stringBuilder.append(':');
    stringBuilder.append(upSendMsgReq.getMessage());
    HMSLog.e("HmsMessaging", stringBuilder.toString());
    PushBiUtil.reportExit(this.b, "push.sendMessage", str, (ErrorEnum)upSendMsgReq);
    throw new UnsupportedOperationException(upSendMsgReq.getMessage());
  }
  
  public final void a(UpSendMsgReq paramUpSendMsgReq, String paramString) {
    paramUpSendMsgReq.setToken(BaseUtils.getLocalToken(this.b, null));
    try {
      HuaweiApi<Api.ApiOptions.NoOptions> huaweiApi = this.c;
      huaweiApi.doWrite((TaskApiCall)new SendUpStreamTask("push.sendMessage", JsonUtil.createJsonString((IMessageEntity)paramUpSendMsgReq), paramString, paramUpSendMsgReq.getPackageName(), paramUpSendMsgReq.getMessageId()));
      return;
    } catch (Exception exception) {
      if (exception.getCause() instanceof ApiException) {
        ApiException apiException = (ApiException)exception.getCause();
        PushBiUtil.reportExit(this.b, "push.sendMessage", paramString, apiException.getStatusCode());
        return;
      } 
      PushBiUtil.reportExit(this.b, "push.sendMessage", paramString, ErrorEnum.ERROR_INTERNAL_ERROR);
      return;
    } 
  }
  
  public boolean isAutoInitEnabled() {
    return AutoInitHelper.isAutoInitEnabled(this.b);
  }
  
  public void send(RemoteMessage paramRemoteMessage) {
    if (ProxyCenter.getProxy() == null) {
      HMSLog.i("HmsMessaging", "send upstream message");
      a(paramRemoteMessage);
      return;
    } 
    HMSLog.e("HmsMessaging", "Operation(send) unsupported");
    throw new UnsupportedOperationException("Operation(send) unsupported");
  }
  
  public void setAutoInitEnabled(boolean paramBoolean) {
    AutoInitHelper.setAutoInitEnabled(this.b, paramBoolean);
  }
  
  public Task<Void> subscribe(String paramString) {
    HMSLog.i("HmsMessaging", "invoke subscribe");
    return a(paramString, "Sub");
  }
  
  public Task<Void> turnOffPush() {
    if (ProxyCenter.getProxy() != null) {
      HMSLog.i("HmsMessaging", "turn off for proxy");
      return ProxyCenter.getProxy().turnOff(this.b, null);
    } 
    HMSLog.i("HmsMessaging", "invoke turnOffPush");
    return a(false);
  }
  
  public Task<Void> turnOnPush() {
    if (ProxyCenter.getProxy() != null) {
      HMSLog.i("HmsMessaging", "turn on for proxy");
      return ProxyCenter.getProxy().turnOn(this.b, null);
    } 
    HMSLog.i("HmsMessaging", "invoke turnOnPush");
    return a(true);
  }
  
  public Task<Void> unsubscribe(String paramString) {
    HMSLog.i("HmsMessaging", "invoke unsubscribe");
    return a(paramString, "UnSub");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\push\HmsMessaging.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */