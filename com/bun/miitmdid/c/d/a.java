package com.bun.miitmdid.c.d;

import android.content.Context;
import android.text.TextUtils;
import com.bun.lib.sysParamters;
import com.bun.supplier.DefaultSupplier;
import com.bun.supplier.IdSupplier;
import com.bun.supplier.InnerIdSupplier;
import com.bun.supplier.SupplierListener;
import com.huawei.android.hms.pps.AdvertisingIdClient;

public class a implements InnerIdSupplier {
  private Context a;
  
  private String b = "";
  
  private String c = "";
  
  private String d = "";
  
  private boolean e = false;
  
  private SupplierListener f;
  
  public a(Context paramContext) {
    this.a = paramContext;
  }
  
  private void b() {
    try {
      boolean bool;
      if (!TextUtils.isEmpty(this.b)) {
        bool = true;
      } else {
        bool = false;
      } 
      this.e = bool;
      if (!this.e) {
        if (this.f != null) {
          this.f.OnSupport(this.e, (IdSupplier)new DefaultSupplier());
          return;
        } 
      } else if (this.f != null) {
        this.f.OnSupport(this.e, (IdSupplier)this);
        return;
      } 
    } catch (Exception exception) {
      com.bun.lib.a.a(a.class.getSimpleName(), "CallBack", exception);
    } 
  }
  
  public void a(SupplierListener paramSupplierListener) {
    this.f = paramSupplierListener;
    (new Thread(new a(this))).start();
  }
  
  public boolean a() {
    return false;
  }
  
  public String getAAID() {
    return TextUtils.isEmpty(this.d) ? sysParamters.e() : this.d;
  }
  
  public String getOAID() {
    return this.b;
  }
  
  public String getUDID() {
    return "";
  }
  
  public String getVAID() {
    return this.c;
  }
  
  public boolean isSupported() {
    return this.e;
  }
  
  public void shutDown() {}
  
  class a implements Runnable {
    a(a this$0) {}
    
    public void run() {
      try {
        AdvertisingIdClient.Info info = AdvertisingIdClient.getAdvertisingIdInfo(a.a(this.a));
        a.a(this.a, info.getId());
        info.isLimitAdTrackingEnabled();
      } catch (Exception exception) {
        com.bun.lib.a.a(a.class.getSimpleName(), "thread", exception);
      } 
      a.b(this.a);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\miitmdid\c\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */