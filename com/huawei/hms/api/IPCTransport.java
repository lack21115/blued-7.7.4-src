package com.huawei.hms.api;

import android.os.Bundle;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.RequestHeader;
import com.huawei.hms.core.aidl.a;
import com.huawei.hms.core.aidl.b;
import com.huawei.hms.core.aidl.c;
import com.huawei.hms.core.aidl.e;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.log.HMSLog;

public class IPCTransport implements DatagramTransport {
  private final String a;
  
  private final IMessageEntity b;
  
  private final Class<? extends IMessageEntity> c;
  
  private int d;
  
  public IPCTransport(String paramString, IMessageEntity paramIMessageEntity, Class<? extends IMessageEntity> paramClass) {
    this.a = paramString;
    this.b = paramIMessageEntity;
    this.c = paramClass;
  }
  
  public IPCTransport(String paramString, IMessageEntity paramIMessageEntity, Class<? extends IMessageEntity> paramClass, int paramInt) {
    this.a = paramString;
    this.b = paramIMessageEntity;
    this.c = paramClass;
    this.d = paramInt;
  }
  
  private int a(ApiClient paramApiClient, c paramc) {
    StringBuilder stringBuilder;
    if (paramApiClient instanceof HuaweiApiClientImpl) {
      b b = new b(this.a, ProtocolNegotiate.getInstance().getVersion());
      e e = a.a(b.c());
      b.a(e.a(this.b, new Bundle()));
      RequestHeader requestHeader = new RequestHeader();
      requestHeader.setAppID(paramApiClient.getAppID());
      requestHeader.setPackageName(paramApiClient.getPackageName());
      requestHeader.setSdkVersion(50004301);
      requestHeader.setApiNameList(((HuaweiApiClientImpl)paramApiClient).getApiNameList());
      requestHeader.setSessionId(paramApiClient.getSessionId());
      requestHeader.setApiLevel(this.d);
      b.b = e.a((IMessageEntity)requestHeader, new Bundle());
      try {
        HuaweiApiClientImpl huaweiApiClientImpl = (HuaweiApiClientImpl)paramApiClient;
        if (huaweiApiClientImpl.getService() == null) {
          HMSLog.e("IPCTransport", "HuaweiApiClient is not binded to service yet.");
          return 907135001;
        } 
        huaweiApiClientImpl.getService().a(b, paramc);
        return 0;
      } catch (Exception exception) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("sync call ex:");
        stringBuilder.append(exception);
        HMSLog.e("IPCTransport", stringBuilder.toString());
        return 907135001;
      } 
    } 
    if (exception instanceof AidlApiClient) {
      AidlApiClient aidlApiClient = (AidlApiClient)exception;
      int i = ProtocolNegotiate.getInstance().getVersion();
      b b = new b(this.a, i);
      b.a(a.a(b.c()).a(this.b, new Bundle()));
      try {
        aidlApiClient.getService().a(b, (c)stringBuilder);
        return 0;
      } catch (Exception exception1) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("sync call ex:");
        stringBuilder.append(exception1);
        HMSLog.e("IPCTransport", stringBuilder.toString());
      } 
    } 
    return 907135001;
  }
  
  public final void post(ApiClient paramApiClient, DatagramTransport.CallBack paramCallBack) {
    send(paramApiClient, paramCallBack);
  }
  
  public final void send(ApiClient paramApiClient, DatagramTransport.CallBack paramCallBack) {
    int i = a(paramApiClient, (c)new IPCCallback(this.c, paramCallBack));
    if (i != 0)
      paramCallBack.onCallback(i, null); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\api\IPCTransport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */