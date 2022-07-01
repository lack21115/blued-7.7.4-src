package com.huawei.hms.opendevice;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.opendevice.OdidResp;
import com.huawei.hms.support.api.opendevice.OdidResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

public class OpenDeviceTaskApiCall extends TaskApiCall<OpenDeviceHmsClient, OdidResult> {
  public OpenDeviceTaskApiCall(String paramString1, String paramString2, String paramString3) {
    super(paramString1, paramString2, paramString3);
  }
  
  public void doExecute(OpenDeviceHmsClient paramOpenDeviceHmsClient, ResponseErrorCode paramResponseErrorCode, String paramString, TaskCompletionSource<OdidResult> paramTaskCompletionSource) {
    OdidResult odidResult;
    if (paramResponseErrorCode == null) {
      paramTaskCompletionSource.a((Exception)new ApiException(new Status(1)));
      return;
    } 
    HiAnalyticsClient.reportExit(paramOpenDeviceHmsClient.getContext(), getUri(), getTransactionId(), paramResponseErrorCode.getStatusCode(), paramResponseErrorCode.getErrorCode(), 50004300);
    if (paramResponseErrorCode.getErrorCode() == 0) {
      HMSLog.i("OpenDeviceTaskApiCall", "onResult, success");
      OdidResp odidResp = new OdidResp();
      JsonUtil.jsonToEntity(paramString, (IMessageEntity)odidResp);
      odidResult = new OdidResult();
      odidResult.setId(odidResp.getId());
      odidResult.setStatus(new Status(0));
      paramTaskCompletionSource.a(odidResult);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onResult, returnCode: ");
    stringBuilder.append(odidResult.getErrorCode());
    HMSLog.i("OpenDeviceTaskApiCall", stringBuilder.toString());
    paramTaskCompletionSource.a((Exception)new ApiException(new Status(odidResult.getErrorCode(), odidResult.getErrorReason())));
  }
  
  public int getApiLevel() {
    return 2;
  }
  
  public int getMinApkVersion() {
    return 50002300;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\opendevice\OpenDeviceTaskApiCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */