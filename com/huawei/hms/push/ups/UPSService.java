package com.huawei.hms.push.ups;

import android.content.Context;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.HmsMessaging;
import com.huawei.hms.push.ups.entity.CodeResult;
import com.huawei.hms.push.ups.entity.TokenResult;
import com.huawei.hms.push.ups.entity.UPSRegisterCallBack;
import com.huawei.hms.push.ups.entity.UPSTurnCallBack;
import com.huawei.hms.push.ups.entity.UPSUnRegisterCallBack;
import com.huawei.hms.support.api.push.utils.CommFun;
import com.huawei.hms.support.log.HMSLog;

public final class UPSService {
  public static void registerToken(Context paramContext, String paramString1, String paramString2, String paramString3, UPSRegisterCallBack paramUPSRegisterCallBack) {
    HMSLog.i("UPSService", "invoke registerToken");
    Preconditions.checkNotNull(paramUPSRegisterCallBack);
    if (!CommFun.isEmui10Plus()) {
      paramUPSRegisterCallBack.onResult(new TokenResult(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.getExternalCode()));
      return;
    } 
    try {
      paramUPSRegisterCallBack.onResult(new TokenResult(HmsInstanceId.getInstance(paramContext).getToken(paramString1, null)));
      return;
    } catch (ApiException apiException) {
      paramUPSRegisterCallBack.onResult(new TokenResult(apiException.getStatusCode(), apiException.getMessage()));
      return;
    } 
  }
  
  public static void turnOffPush(Context paramContext, UPSTurnCallBack paramUPSTurnCallBack) {
    HMSLog.i("UPSService", "invoke turnOffPush");
    Preconditions.checkNotNull(paramUPSTurnCallBack);
    if (!CommFun.isEmui10Plus()) {
      paramUPSTurnCallBack.onResult(new TokenResult(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.getExternalCode()));
      return;
    } 
    HmsMessaging.getInstance(paramContext).turnOffPush().a(new OnCompleteListener<Void>(paramUPSTurnCallBack) {
          public void onComplete(Task<Void> param1Task) {
            if (param1Task.b()) {
              this.a.onResult(new CodeResult());
              return;
            } 
            ApiException apiException = (ApiException)param1Task.e();
            this.a.onResult(new CodeResult(apiException.getStatusCode(), apiException.getMessage()));
          }
        });
  }
  
  public static void turnOnPush(Context paramContext, UPSTurnCallBack paramUPSTurnCallBack) {
    HMSLog.i("UPSService", "invoke turnOnPush");
    Preconditions.checkNotNull(paramUPSTurnCallBack);
    if (!CommFun.isEmui10Plus()) {
      paramUPSTurnCallBack.onResult(new TokenResult(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.getExternalCode()));
      return;
    } 
    HmsMessaging.getInstance(paramContext).turnOnPush().a(new OnCompleteListener<Void>(paramUPSTurnCallBack) {
          public void onComplete(Task<Void> param1Task) {
            if (param1Task.b()) {
              this.a.onResult(new CodeResult());
              return;
            } 
            ApiException apiException = (ApiException)param1Task.e();
            this.a.onResult(new CodeResult(apiException.getStatusCode(), apiException.getMessage()));
          }
        });
  }
  
  public static void unRegisterToken(Context paramContext, UPSUnRegisterCallBack paramUPSUnRegisterCallBack) {
    HMSLog.i("UPSService", "invoke unRegisterToken");
    Preconditions.checkNotNull(paramUPSUnRegisterCallBack);
    if (!CommFun.isEmui10Plus()) {
      paramUPSUnRegisterCallBack.onResult(new TokenResult(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.getExternalCode()));
      return;
    } 
    try {
      HmsInstanceId.getInstance(paramContext).deleteToken(null, null);
      paramUPSUnRegisterCallBack.onResult(new TokenResult());
      return;
    } catch (ApiException apiException) {
      paramUPSUnRegisterCallBack.onResult(new TokenResult(apiException.getStatusCode(), apiException.getMessage()));
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\pus\\ups\UPSService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */