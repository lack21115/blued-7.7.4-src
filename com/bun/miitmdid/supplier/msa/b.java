package com.bun.miitmdid.supplier.msa;

import android.content.Context;
import android.text.TextUtils;
import com.bun.lib.sysParamters;
import com.bun.miitmdid.c.e.a;
import com.bun.supplier.DefaultSupplier;
import com.bun.supplier.IdSupplier;
import com.bun.supplier.InnerIdSupplier;
import com.bun.supplier.SupplierListener;

public class b implements InnerIdSupplier, a {
  public SupplierListener a;
  
  private MsaClient b;
  
  public b(Context paramContext) {
    if (MsaClient.CheckService(paramContext)) {
      String str = sysParamters.g();
      if (!TextUtils.isEmpty(str))
        MsaClient.StartMsaKlService(paramContext, str); 
      this.b = new MsaClient(paramContext, this);
    } 
  }
  
  public void a(SupplierListener paramSupplierListener) {
    this.a = paramSupplierListener;
    if (this.b != null) {
      String str = sysParamters.g();
      this.b.BindService(str);
      return;
    } 
    b();
  }
  
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
    MsaClient msaClient = this.b;
    return (msaClient != null) ? msaClient.isSupported() : false;
  }
  
  public void shutDown() {
    MsaClient msaClient = this.b;
    if (msaClient != null)
      msaClient.shutdown(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\miitmdid\supplier\msa\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */