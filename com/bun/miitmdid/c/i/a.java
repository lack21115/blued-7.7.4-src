package com.bun.miitmdid.c.i;

import android.content.Context;
import android.os.Build;
import com.bun.supplier.DefaultSupplier;
import com.bun.supplier.IdSupplier;
import com.bun.supplier.InnerIdSupplier;
import com.bun.supplier.SupplierListener;
import com.heytap.openid.sdk.OpenIDSDK;

public class a implements InnerIdSupplier {
  private Context a;
  
  public a(Context paramContext) {
    OpenIDSDK.d(paramContext);
    this.a = paramContext;
  }
  
  public void a(SupplierListener paramSupplierListener) {
    (new Thread(new a(this, paramSupplierListener))).start();
  }
  
  public boolean a() {
    return false;
  }
  
  public String getAAID() {
    try {
      String str1 = OpenIDSDK.a(this.a);
      String str2 = str1;
      if (str1 == null)
        str2 = ""; 
      return str2;
    } catch (Exception exception) {
      exception.printStackTrace();
      return "";
    } 
  }
  
  public String getOAID() {
    try {
      String str1 = OpenIDSDK.b(this.a);
      String str2 = str1;
      if (str1 == null)
        str2 = ""; 
      return str2;
    } catch (Exception exception) {
      exception.printStackTrace();
      return "";
    } 
  }
  
  public String getUDID() {
    return "";
  }
  
  public String getVAID() {
    try {
      String str1 = OpenIDSDK.c(this.a);
      String str2 = str1;
      if (str1 == null)
        str2 = ""; 
      return str2;
    } catch (Exception exception) {
      exception.printStackTrace();
      return "";
    } 
  }
  
  public boolean isSupported() {
    return OpenIDSDK.a();
  }
  
  public void shutDown() {}
  
  class a implements Runnable {
    a(a this$0, SupplierListener param1SupplierListener) {}
    
    public void run() {
      try {
        if (this.a != null) {
          if (Build.VERSION.SDK_INT <= 28) {
            this.a.OnSupport(false, (IdSupplier)new DefaultSupplier());
            return;
          } 
          this.a.OnSupport(this.b.isSupported(), (IdSupplier)this.b);
          return;
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
        return;
      } finally {}
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\miitmdid\c\i\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */