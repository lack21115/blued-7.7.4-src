package com.huawei.hms.push.task;

import android.content.Intent;
import android.os.Bundle;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.push.base.RemoteService;
import com.huawei.hms.support.log.HMSLog;

public class SendUpStreamTask extends TaskApiCall<PushClient, BaseVoidTask> {
  public String a;
  
  public String b;
  
  public SendUpStreamTask(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    super(paramString1, paramString2, paramString3);
    this.a = paramString4;
    this.b = paramString5;
  }
  
  public final void a(PushClient paramPushClient, ResponseErrorCode paramResponseErrorCode) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("receive upstream, msgId :");
    stringBuilder.append(this.b);
    stringBuilder.append(" , packageName = ");
    stringBuilder.append(this.a);
    stringBuilder.append(" , errorCode = ");
    stringBuilder.append(paramResponseErrorCode.getErrorCode());
    HMSLog.i("SendUpStreamTask", stringBuilder.toString());
    Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
    intent.setPackage(this.a);
    Bundle bundle = new Bundle();
    bundle.putString("message_id", this.b);
    bundle.putInt("error", paramResponseErrorCode.getErrorCode());
    if (ErrorEnum.SUCCESS.getInternalCode() == paramResponseErrorCode.getErrorCode()) {
      bundle.putString("message_type", "sent_message");
    } else {
      bundle.putString("message_type", "send_error");
    } 
    if ((new RemoteService()).startMsgService(paramPushClient.getContext(), bundle, intent)) {
      HMSLog.i("SendUpStreamTask", "receive upstream, start service success");
      PushBiUtil.reportExit(paramPushClient.getContext(), getUri(), paramResponseErrorCode);
      return;
    } 
    HMSLog.w("SendUpStreamTask", "receive upstream, start service failed");
    PushBiUtil.reportExit(paramPushClient.getContext(), getUri(), paramResponseErrorCode.getTransactionId(), ErrorEnum.ERROR_BIND_SERVICE_SELF_MAPPING);
  }
  
  public void doExecute(PushClient paramPushClient, ResponseErrorCode paramResponseErrorCode, String paramString, TaskCompletionSource<BaseVoidTask> paramTaskCompletionSource) {
    if (paramResponseErrorCode.getErrorCode() == 0) {
      HMSLog.i("SendUpStreamTask", "send up stream task,Operate succeed");
      paramTaskCompletionSource.a(null);
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("send up stream task,Operate failed with ret=");
      stringBuilder.append(paramResponseErrorCode.getErrorCode());
      HMSLog.e("SendUpStreamTask", stringBuilder.toString());
      ErrorEnum errorEnum = ErrorEnum.fromCode(paramResponseErrorCode.getErrorCode());
      if (errorEnum != ErrorEnum.ERROR_UNKNOWN) {
        paramTaskCompletionSource.a((Exception)errorEnum.toApiException());
      } else {
        paramTaskCompletionSource.a((Exception)new ApiException(new Status(paramResponseErrorCode.getErrorCode(), paramResponseErrorCode.getErrorReason())));
      } 
    } 
    a(paramPushClient, paramResponseErrorCode);
  }
  
  public int getMinApkVersion() {
    return 40003000;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\push\task\SendUpStreamTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */