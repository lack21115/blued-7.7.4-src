package com.huawei.hms.support.api.opendevice;

import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.opendevice.OdidReq;
import com.huawei.hms.support.api.entity.opendevice.OdidResp;
import com.huawei.hms.support.log.HMSLog;

public class HuaweiOpendeviceApiImpl implements HuaweiOpendeviceApi {
  public static final String TAG = "OpenIdentifierApiImpl";
  
  public PendingResult<OdidResult> getOdid(HuaweiApiClient paramHuaweiApiClient) {
    HMSLog.i("OpenIdentifierApiImpl", "Enter getOdid");
    return (PendingResult)new PendingResultImpl<OdidResult, OdidResp>((ApiClient)paramHuaweiApiClient, "opendevice.getodid", (IMessageEntity)new OdidReq()) {
        public OdidResult onComplete(OdidResp param1OdidResp) {
          if (param1OdidResp == null) {
            HMSLog.e("OpenIdentifierApiImpl", "getOdid OaidResp is null");
            return null;
          } 
          Status status = param1OdidResp.getCommonStatus();
          if (status == null) {
            HMSLog.e("OpenIdentifierApiImpl", "getOdid commonStatus is null");
            return null;
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("getOdid onComplete:");
          stringBuilder.append(status.getStatusCode());
          HMSLog.i("OpenIdentifierApiImpl", stringBuilder.toString());
          OdidResult odidResult = new OdidResult();
          odidResult.setStatus(status);
          odidResult.setId(param1OdidResp.getId());
          return odidResult;
        }
      };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\opendevice\HuaweiOpendeviceApiImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */