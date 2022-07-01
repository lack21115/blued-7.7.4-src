package com.bun.miitmdid.c.g;

import android.content.Context;
import com.bun.miitmdid.c.e.a;
import com.bun.supplier.IdSupplier;
import com.bun.supplier.InnerIdSupplier;
import com.bun.supplier.SupplierListener;

public class b implements InnerIdSupplier, a {
  private a a;
  
  private SupplierListener b;
  
  public b(Context paramContext, SupplierListener paramSupplierListener) {
    this.b = paramSupplierListener;
    this.a = new a(paramContext, this);
  }
  
  public void a(SupplierListener paramSupplierListener) {}
  
  public void a(boolean paramBoolean) {
    SupplierListener supplierListener = this.b;
    if (supplierListener != null)
      supplierListener.OnSupport(isSupported(), (IdSupplier)this); 
  }
  
  public boolean a() {
    return false;
  }
  
  public void b() {
    SupplierListener supplierListener = this.b;
    if (supplierListener != null)
      supplierListener.OnSupport(isSupported(), (IdSupplier)this); 
  }
  
  public String getAAID() {
    if (!isSupported())
      return ""; 
    String str2 = this.a.a();
    String str1 = str2;
    return (str2 == null) ? "" : str1;
  }
  
  public String getOAID() {
    if (!isSupported())
      return ""; 
    String str2 = this.a.b();
    String str1 = str2;
    return (str2 == null) ? "" : str1;
  }
  
  public String getUDID() {
    if (!isSupported())
      return ""; 
    String str2 = this.a.c();
    String str1 = str2;
    return (str2 == null) ? "" : str1;
  }
  
  public String getVAID() {
    if (!isSupported())
      return ""; 
    String str2 = this.a.d();
    String str1 = str2;
    return (str2 == null) ? "" : str1;
  }
  
  public boolean isSupported() {
    a a1 = this.a;
    return (a1 != null) ? a1.e() : false;
  }
  
  public void shutDown() {
    a a1 = this.a;
    if (a1 != null)
      a1.f(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\miitmdid\c\g\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */