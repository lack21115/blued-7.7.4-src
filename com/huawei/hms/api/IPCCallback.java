package com.huawei.hms.api;

import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.ResponseHeader;
import com.huawei.hms.core.aidl.a;
import com.huawei.hms.core.aidl.b;
import com.huawei.hms.core.aidl.c;
import com.huawei.hms.core.aidl.e;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.log.HMSLog;

public class IPCCallback extends c.a {
  private final Class<? extends IMessageEntity> a;
  
  private final DatagramTransport.CallBack b;
  
  public IPCCallback(Class<? extends IMessageEntity> paramClass, DatagramTransport.CallBack paramCallBack) {
    this.a = paramClass;
    this.b = paramCallBack;
  }
  
  public void call(b paramb) throws RemoteException {
    if (paramb != null && !TextUtils.isEmpty(paramb.a)) {
      e e = a.a(paramb.c());
      IMessageEntity iMessageEntity = null;
      if (paramb.b() > 0) {
        IMessageEntity iMessageEntity1 = newResponseInstance();
        iMessageEntity = iMessageEntity1;
        if (iMessageEntity1 != null) {
          e.a(paramb.a(), iMessageEntity1);
          iMessageEntity = iMessageEntity1;
        } 
      } 
      if (paramb.b != null) {
        ResponseHeader responseHeader = new ResponseHeader();
        e.a(paramb.b, (IMessageEntity)responseHeader);
        this.b.onCallback(responseHeader.getStatusCode(), iMessageEntity);
        return;
      } 
      this.b.onCallback(0, iMessageEntity);
      return;
    } 
    HMSLog.e("IPCCallback", "In call, URI cannot be empty.");
    throw new RemoteException();
  }
  
  protected IMessageEntity newResponseInstance() {
    Class<? extends IMessageEntity> clazz = this.a;
    if (clazz != null) {
      try {
        return clazz.newInstance();
      } catch (IllegalAccessException illegalAccessException) {
      
      } catch (InstantiationException instantiationException) {}
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("In newResponseInstance, instancing exception.");
      stringBuilder.append(instantiationException.getMessage());
      HMSLog.e("IPCCallback", stringBuilder.toString());
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\api\IPCCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */