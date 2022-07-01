package com.bun.miitmdid.c.h;

import android.content.Context;
import com.bun.lib.sysParamters;
import com.bun.supplier.IdSupplier;
import com.bun.supplier.InnerIdSupplier;
import com.bun.supplier.SupplierListener;

public class b implements InnerIdSupplier {
  private Context a;
  
  public b(Context paramContext) {
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
      return a.a(this.a, sysParamters.g());
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public String getOAID() {
    try {
      return a.a(this.a);
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public String getUDID() {
    return "";
  }
  
  public String getVAID() {
    try {
      return a.b(this.a, sysParamters.g());
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public boolean isSupported() {
    try {
      return a.b(this.a);
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public void shutDown() {}
  
  class a implements Runnable {
    a(b this$0, SupplierListener param1SupplierListener) {}
    
    public void run() {
      try {
        if (this.a != null)
          this.a.OnSupport(this.b.isSupported(), (IdSupplier)this.b); 
        return;
      } catch (Exception exception) {
        com.bun.lib.a.a("buniasuplier", "exception", exception);
        return;
      } finally {}
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\miitmdid\c\h\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */