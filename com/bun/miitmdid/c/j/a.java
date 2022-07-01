package com.bun.miitmdid.c.j;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bun.lib.sysParamters;
import com.bun.miitmdid.c.j.b.d;
import com.bun.supplier.DefaultSupplier;
import com.bun.supplier.IdSupplier;
import com.bun.supplier.InnerIdSupplier;
import com.bun.supplier.SupplierListener;

public class a implements InnerIdSupplier {
  private String a;
  
  private Context b;
  
  public a(Context paramContext) {
    this.b = paramContext;
    this.a = "";
  }
  
  public void a(SupplierListener paramSupplierListener) {
    (new Thread(new a(this, paramSupplierListener))).start();
  }
  
  public void a(String paramString) {
    this.a = paramString;
  }
  
  public boolean a() {
    return false;
  }
  
  public String getAAID() {
    String str2 = d.a(this.b, this.a);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = sysParamters.e(); 
    return str1;
  }
  
  public String getOAID() {
    String str2 = d.a(this.b);
    String str1 = str2;
    if (str2 == null)
      str1 = ""; 
    return str1;
  }
  
  public String getUDID() {
    return "";
  }
  
  public String getVAID() {
    String str2 = d.b(this.b, this.a);
    String str1 = str2;
    if (str2 == null)
      str1 = ""; 
    return str1;
  }
  
  public boolean isSupported() {
    return d.b(this.b);
  }
  
  public void shutDown() {}
  
  class a implements Runnable {
    a(a this$0, SupplierListener param1SupplierListener) {}
    
    public void run() {
      try {
        if (this.a != null) {
          if (Build.VERSION.SDK_INT < 28) {
            this.a.OnSupport(false, (IdSupplier)new DefaultSupplier());
            return;
          } 
          this.a.OnSupport(this.b.isSupported(), (IdSupplier)this.b);
          return;
        } 
      } catch (Exception exception) {
        com.bun.lib.a.a("vivosuplier", "exception", exception);
        return;
      } finally {}
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\miitmdid\c\j\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */