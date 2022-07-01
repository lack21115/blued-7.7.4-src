package com.huawei.hms.opendevice;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.DeleteTokenResp;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

public class k extends TaskApiCall<PushClient, Void> {
  public DeleteTokenReq a;
  
  public k(String paramString1, DeleteTokenReq paramDeleteTokenReq, String paramString2) {
    super(paramString1, JsonUtil.createJsonString((IMessageEntity)paramDeleteTokenReq), paramString2);
    this.a = paramDeleteTokenReq;
  }
  
  public void a(PushClient paramPushClient, ResponseErrorCode paramResponseErrorCode, String paramString, TaskCompletionSource<Void> paramTaskCompletionSource) {
    ErrorEnum errorEnum1;
    StringBuilder stringBuilder;
    if (paramResponseErrorCode.getErrorCode() != 0) {
      String str = HmsInstanceId.TAG;
      stringBuilder = new StringBuilder();
      stringBuilder.append("DeleteTokenTask failed, ErrorCode: ");
      stringBuilder.append(paramResponseErrorCode.getErrorCode());
      HMSLog.e(str, stringBuilder.toString());
      errorEnum1 = ErrorEnum.fromCode(paramResponseErrorCode.getErrorCode());
      if (errorEnum1 != ErrorEnum.ERROR_UNKNOWN) {
        paramTaskCompletionSource.a((Exception)errorEnum1.toApiException());
        return;
      } 
      paramTaskCompletionSource.a((Exception)new ApiException(new Status(paramResponseErrorCode.getErrorCode(), paramResponseErrorCode.getErrorReason())));
      return;
    } 
    ErrorEnum errorEnum2 = ErrorEnum.fromCode(((DeleteTokenResp)JsonUtil.jsonToEntity((String)stringBuilder, (IMessageEntity)new DeleteTokenResp())).getRetCode());
    if (errorEnum2 != ErrorEnum.SUCCESS) {
      paramTaskCompletionSource.a((Exception)errorEnum2.toApiException());
      return;
    } 
    paramTaskCompletionSource.a(null);
    q.a(errorEnum1.getContext(), getUri(), paramResponseErrorCode);
  }
  
  public int getMinApkVersion() {
    return this.a.isMultiSender() ? 50004300 : 30000000;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\opendevice\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */