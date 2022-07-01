package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResp;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

public class l extends TaskApiCall<PushClient, TokenResult> {
  public Context a;
  
  public TokenReq b;
  
  public l(String paramString1, TokenReq paramTokenReq, Context paramContext, String paramString2) {
    super(paramString1, JsonUtil.createJsonString((IMessageEntity)paramTokenReq), paramString2);
    this.a = paramContext;
    this.b = paramTokenReq;
  }
  
  public void a(PushClient paramPushClient, ResponseErrorCode paramResponseErrorCode, String paramString, TaskCompletionSource<TokenResult> paramTaskCompletionSource) {
    ErrorEnum errorEnum;
    if (paramResponseErrorCode.getErrorCode() != 0) {
      paramString = HmsInstanceId.TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("TokenTask failed, ErrorCode: ");
      stringBuilder.append(paramResponseErrorCode.getErrorCode());
      HMSLog.e(paramString, stringBuilder.toString());
      errorEnum = ErrorEnum.fromCode(paramResponseErrorCode.getErrorCode());
      if (errorEnum != ErrorEnum.ERROR_UNKNOWN) {
        paramTaskCompletionSource.a((Exception)errorEnum.toApiException());
      } else {
        paramTaskCompletionSource.a((Exception)new ApiException(new Status(paramResponseErrorCode.getErrorCode(), paramResponseErrorCode.getErrorReason())));
      } 
    } else {
      String str;
      StringBuilder stringBuilder;
      TokenResp tokenResp = (TokenResp)JsonUtil.jsonToEntity((String)errorEnum, (IMessageEntity)new TokenResp());
      errorEnum = ErrorEnum.fromCode(tokenResp.getRetCode());
      if (errorEnum != ErrorEnum.SUCCESS) {
        paramTaskCompletionSource.a((Exception)errorEnum.toApiException());
        str = HmsInstanceId.TAG;
        stringBuilder = new StringBuilder();
        stringBuilder.append("TokenTask failed, StatusCode:");
        stringBuilder.append(errorEnum.getExternalCode());
        HMSLog.e(str, stringBuilder.toString());
      } else {
        TokenResult tokenResult = new TokenResult();
        tokenResult.setToken(stringBuilder.getToken());
        tokenResult.setBelongId(stringBuilder.getBelongId());
        tokenResult.setRetCode(ErrorEnum.fromCode(stringBuilder.getRetCode()).getExternalCode());
        str.a(tokenResult);
        String str1 = stringBuilder.getToken();
        if (TextUtils.isEmpty(str1)) {
          HMSLog.i(HmsInstanceId.TAG, "GetTokenTask receive a empty token, please check HmsMessageService.onNewToken receive result.");
          q.a(paramPushClient.getContext(), getUri(), paramResponseErrorCode);
          return;
        } 
        a(str1, this.b.getSubjectId());
        n.a(this.a, str1);
      } 
    } 
    q.a(paramPushClient.getContext(), getUri(), paramResponseErrorCode);
  }
  
  public final void a(String paramString1, String paramString2) {
    if (!i.a(this.a).b(paramString2).equals(paramString1)) {
      HMSLog.i(HmsInstanceId.TAG, "receive a token, refresh the local token");
      i.a(this.a).b(paramString2, paramString1);
    } 
  }
  
  public int getMinApkVersion() {
    return this.b.isMultiSender() ? 50004300 : 30000000;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\opendevice\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */