package com.huawei.hms.push.task;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;

public class BaseVoidTask extends TaskApiCall<PushClient, Void> {
  public BaseVoidTask(String paramString1, String paramString2, String paramString3) {
    super(paramString1, paramString2, paramString3);
  }
  
  public void doExecute(PushClient paramPushClient, ResponseErrorCode paramResponseErrorCode, String paramString, TaskCompletionSource<Void> paramTaskCompletionSource) {
    if (paramResponseErrorCode.getErrorCode() == 0) {
      HMSLog.i("BaseVoidTask", "Operate succeed");
      paramTaskCompletionSource.a(null);
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Operate failed with ret=");
      stringBuilder.append(paramResponseErrorCode.getErrorCode());
      HMSLog.e("BaseVoidTask", stringBuilder.toString());
      ErrorEnum errorEnum = ErrorEnum.fromCode(paramResponseErrorCode.getErrorCode());
      if (errorEnum != ErrorEnum.ERROR_UNKNOWN) {
        paramTaskCompletionSource.a((Exception)errorEnum.toApiException());
      } else {
        paramTaskCompletionSource.a((Exception)new ApiException(new Status(paramResponseErrorCode.getErrorCode(), paramResponseErrorCode.getErrorReason())));
      } 
    } 
    PushBiUtil.reportExit(paramPushClient.getContext(), getUri(), paramResponseErrorCode);
  }
  
  public int getMinApkVersion() {
    return 30000000;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\push\task\BaseVoidTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */