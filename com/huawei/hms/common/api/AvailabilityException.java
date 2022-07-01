package com.huawei.hms.common.api;

import android.content.Context;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.support.log.HMSLog;

public class AvailabilityException extends Exception {
  private String TAG = "AvailabilityException";
  
  private String message = null;
  
  private ConnectionResult generateConnectionResult(int paramInt) {
    String str = this.TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("The availability check result is: ");
    stringBuilder.append(paramInt);
    HMSLog.i(str, stringBuilder.toString());
    setMessage(paramInt);
    return new ConnectionResult(paramInt);
  }
  
  private void setMessage(int paramInt) {
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2) {
          if (paramInt != 3) {
            if (paramInt != 21) {
              this.message = "INTERNAL_ERROR";
              return;
            } 
            this.message = "ANDROID_VERSION_UNSUPPORT";
            return;
          } 
          this.message = "SERVICE_DISABLED";
          return;
        } 
        this.message = "SERVICE_VERSION_UPDATE_REQUIRED";
        return;
      } 
      this.message = "SERVICE_MISSING";
      return;
    } 
    this.message = "success";
  }
  
  public ConnectionResult getConnectionResult(HuaweiApi<? extends Api.ApiOptions> paramHuaweiApi) {
    if (paramHuaweiApi == null) {
      HMSLog.e(this.TAG, "The huaweiApi is null.");
      return generateConnectionResult(8);
    } 
    Context context = paramHuaweiApi.getContext();
    return generateConnectionResult(HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(context, 30000000));
  }
  
  public ConnectionResult getConnectionResult(HuaweiApiCallable paramHuaweiApiCallable) {
    if (paramHuaweiApiCallable == null || paramHuaweiApiCallable.getHuaweiApi() == null) {
      HMSLog.e(this.TAG, "The huaweiApi is null.");
      return generateConnectionResult(8);
    } 
    Context context = paramHuaweiApiCallable.getHuaweiApi().getContext();
    return generateConnectionResult(HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(context, 30000000));
  }
  
  public String getMessage() {
    return this.message;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\api\AvailabilityException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */