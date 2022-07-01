package com.huawei.hms.api;

import android.content.Intent;

public class HuaweiServicesRepairableException extends UserRecoverableException {
  private final int a;
  
  public HuaweiServicesRepairableException(int paramInt, String paramString, Intent paramIntent) {
    super(paramString, paramIntent);
    this.a = paramInt;
  }
  
  public int getConnectionStatusCode() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\api\HuaweiServicesRepairableException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */