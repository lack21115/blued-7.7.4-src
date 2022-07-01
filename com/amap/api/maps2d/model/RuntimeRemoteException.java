package com.amap.api.maps2d.model;

import android.os.RemoteException;

public final class RuntimeRemoteException extends RuntimeException {
  public RuntimeRemoteException(RemoteException paramRemoteException) {
    super((Throwable)paramRemoteException);
  }
  
  public RuntimeRemoteException(String paramString) {
    super(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\RuntimeRemoteException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */