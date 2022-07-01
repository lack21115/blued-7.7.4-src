package com.huawei.updatesdk.service.otaupdate;

import android.content.Intent;

public class d {
  private static final Object b = new Object();
  
  private static d c;
  
  private CheckUpdateCallBack a;
  
  public static d a() {
    synchronized (b) {
      if (c == null)
        c = new d(); 
      return c;
    } 
  }
  
  public void a(int paramInt) {
    CheckUpdateCallBack checkUpdateCallBack = this.a;
    if (checkUpdateCallBack != null)
      checkUpdateCallBack.onMarketStoreError(paramInt); 
  }
  
  public void a(Intent paramIntent) {
    CheckUpdateCallBack checkUpdateCallBack = this.a;
    if (checkUpdateCallBack != null)
      checkUpdateCallBack.onMarketInstallInfo(paramIntent); 
  }
  
  public void a(CheckUpdateCallBack paramCheckUpdateCallBack) {
    this.a = paramCheckUpdateCallBack;
  }
  
  public void b(Intent paramIntent) {
    CheckUpdateCallBack checkUpdateCallBack = this.a;
    if (checkUpdateCallBack != null)
      checkUpdateCallBack.onUpdateInfo(paramIntent); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\service\otaupdate\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */