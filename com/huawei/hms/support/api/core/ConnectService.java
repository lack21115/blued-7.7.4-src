package com.huawei.hms.support.api.core;

import android.text.TextUtils;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolvePendingResult;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.InnerPendingResult;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.core.CheckConnectInfo;
import com.huawei.hms.support.api.entity.core.CheckConnectResp;
import com.huawei.hms.support.api.entity.core.ConnectInfo;
import com.huawei.hms.support.api.entity.core.ConnectResp;
import com.huawei.hms.support.api.entity.core.DisconnectInfo;
import com.huawei.hms.support.api.entity.core.DisconnectResp;
import com.huawei.hms.support.api.entity.core.JosGetNoticeReq;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;
import com.huawei.hms.support.log.HMSLog;

public final class ConnectService {
  private static final String TAG = "connectservice";
  
  public static InnerPendingResult<ResolveResult<CheckConnectResp>> checkconnect(ApiClient paramApiClient, CheckConnectInfo paramCheckConnectInfo) {
    return (InnerPendingResult<ResolveResult<CheckConnectResp>>)ResolvePendingResult.build(paramApiClient, "core.checkconnect", (IMessageEntity)paramCheckConnectInfo, CheckConnectResp.class);
  }
  
  public static PendingResult<ResolveResult<ConnectResp>> connect(ApiClient paramApiClient, ConnectInfo paramConnectInfo) {
    return (PendingResult)new PendingResultImpl<ResolveResult<ConnectResp>, ConnectResp>(paramApiClient, "core.connect", (IMessageEntity)paramConnectInfo) {
        public boolean checkApiClient(ApiClient param1ApiClient) {
          return (param1ApiClient != null);
        }
        
        public ResolveResult<ConnectResp> onComplete(ConnectResp param1ConnectResp) {
          ResolveResult<ConnectResp> resolveResult = new ResolveResult(param1ConnectResp);
          resolveResult.setStatus(Status.SUCCESS);
          HMSLog.d("connectservice", "connect - onComplete: success");
          return resolveResult;
        }
      };
  }
  
  public static ResolvePendingResult<DisconnectResp> disconnect(ApiClient paramApiClient, DisconnectInfo paramDisconnectInfo) {
    return ResolvePendingResult.build(paramApiClient, "core.disconnect", (IMessageEntity)paramDisconnectInfo, DisconnectResp.class);
  }
  
  public static PendingResult<ResolveResult<ConnectResp>> forceConnect(ApiClient paramApiClient, ConnectInfo paramConnectInfo) {
    return (PendingResult)new PendingResultImpl<ResolveResult<ConnectResp>, ConnectResp>(paramApiClient, "core.foreconnect", (IMessageEntity)paramConnectInfo) {
        public boolean checkApiClient(ApiClient param1ApiClient) {
          return (param1ApiClient != null);
        }
        
        public ResolveResult<ConnectResp> onComplete(ConnectResp param1ConnectResp) {
          ResolveResult<ConnectResp> resolveResult = new ResolveResult(param1ConnectResp);
          resolveResult.setStatus(Status.SUCCESS);
          HMSLog.d("connectservice", "forceConnect - onComplete: success");
          return resolveResult;
        }
      };
  }
  
  public static PendingResult<ResolveResult<JosGetNoticeResp>> getNotice(ApiClient paramApiClient, int paramInt, String paramString) {
    JosGetNoticeReq josGetNoticeReq = new JosGetNoticeReq();
    josGetNoticeReq.setNoticeType(paramInt);
    josGetNoticeReq.setHmsSdkVersionName(paramString);
    if (!TextUtils.isEmpty(paramApiClient.getCpID()))
      josGetNoticeReq.setCpID(paramApiClient.getCpID()); 
    return (PendingResult)new PendingResultImpl<ResolveResult<JosGetNoticeResp>, JosGetNoticeResp>(paramApiClient, "core.getNoticeIntent", (IMessageEntity)josGetNoticeReq) {
        public ResolveResult<JosGetNoticeResp> onComplete(JosGetNoticeResp param1JosGetNoticeResp) {
          if (param1JosGetNoticeResp == null) {
            HMSLog.e("connectservice", "JosNoticeResp is null");
            return null;
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("josNoticeResp status code :");
          stringBuilder.append(param1JosGetNoticeResp.getStatusCode());
          HMSLog.i("connectservice", stringBuilder.toString());
          ResolveResult<JosGetNoticeResp> resolveResult = new ResolveResult(param1JosGetNoticeResp);
          resolveResult.setStatus(Status.SUCCESS);
          return resolveResult;
        }
      };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\core\ConnectService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */