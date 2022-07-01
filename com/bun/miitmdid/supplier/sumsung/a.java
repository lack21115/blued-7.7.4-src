package com.bun.miitmdid.supplier.sumsung;

import android.content.Context;
import com.bun.miitmdid.c.e.a;
import com.bun.supplier.DefaultSupplier;
import com.bun.supplier.IdSupplier;
import com.bun.supplier.InnerIdSupplier;
import com.bun.supplier.SupplierListener;

public class a implements InnerIdSupplier, a {
  public SupplierListener a;
  
  private SumsungCore b;
  
  public a(Context paramContext, SupplierListener paramSupplierListener) {
    this.a = paramSupplierListener;
    this.b = new SumsungCore(paramContext, this);
  }
  
  public void a(SupplierListener paramSupplierListener) {}
  
  public void a(boolean paramBoolean) {
    SupplierListener supplierListener = this.a;
    if (supplierListener != null)
      supplierListener.OnSupport(isSupported(), (IdSupplier)this); 
  }
  
  public boolean a() {
    return false;
  }
  
  public void b() {
    SupplierListener supplierListener = this.a;
    if (supplierListener != null)
      supplierListener.OnSupport(false, (IdSupplier)new DefaultSupplier()); 
  }
  
  public String getAAID() {
    if (!isSupported())
      return ""; 
    String str2 = this.b.getAAID();
    String str1 = str2;
    return (str2 == null) ? "" : str1;
  }
  
  public String getOAID() {
    if (!isSupported())
      return ""; 
    String str2 = this.b.getOAID();
    String str1 = str2;
    return (str2 == null) ? "" : str1;
  }
  
  public String getUDID() {
    if (!isSupported())
      return ""; 
    String str2 = this.b.getUDID();
    String str1 = str2;
    return (str2 == null) ? "" : str1;
  }
  
  public String getVAID() {
    if (!isSupported())
      return ""; 
    String str2 = this.b.getVAID();
    String str1 = str2;
    return (str2 == null) ? "" : str1;
  }
  
  public boolean isSupported() {
    SumsungCore sumsungCore = this.b;
    return (sumsungCore != null) ? sumsungCore.isSupported() : false;
  }
  
  public void shutDown() {
    SumsungCore sumsungCore = this.b;
    if (sumsungCore != null)
      sumsungCore.shutdown(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\miitmdid\supplier\sumsung\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */