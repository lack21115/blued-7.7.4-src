package com.bun.miitmdid.c.b;

import android.content.Context;
import android.os.IBinder;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;
import com.asus.msa.sdid.IDIDBinderStatusListener;
import com.asus.msa.sdid.SupplementaryDIDManager;
import com.bun.supplier.IdSupplier;
import com.bun.supplier.InnerIdSupplier;
import com.bun.supplier.SupplierListener;

public class a implements InnerIdSupplier, IDIDBinderStatusListener {
  private SupplierListener a;
  
  private String b = "";
  
  private String c = "";
  
  private String d = "";
  
  private String e = "";
  
  private SupplementaryDIDManager f;
  
  private boolean g = false;
  
  private boolean h = false;
  
  public a(Context paramContext, SupplierListener paramSupplierListener) {
    this.a = paramSupplierListener;
    this.f = new SupplementaryDIDManager(paramContext);
  }
  
  public void a(IDidAidlInterface paramIDidAidlInterface) {
    try {
      this.b = paramIDidAidlInterface.getUDID();
      if (this.b == null)
        this.b = ""; 
    } catch (Exception exception) {}
    try {
      this.c = paramIDidAidlInterface.getOAID();
      if (this.c == null)
        this.c = ""; 
    } catch (Exception exception) {}
    try {
      this.d = paramIDidAidlInterface.getVAID();
      if (this.d == null)
        this.d = ""; 
    } catch (Exception exception) {}
    try {
      this.e = paramIDidAidlInterface.getAAID();
      if (this.e == null)
        this.e = ""; 
    } catch (Exception exception) {}
    try {
      this.h = paramIDidAidlInterface.a();
    } catch (Exception exception) {}
    this.g = true;
    SupplierListener supplierListener = this.a;
    if (supplierListener != null)
      supplierListener.OnSupport(this.h, (IdSupplier)this); 
  }
  
  public void a(SupplierListener paramSupplierListener) {
    this.f.init(this);
  }
  
  public boolean a() {
    return false;
  }
  
  public IBinder asBinder() {
    return null;
  }
  
  public void b() {
    SupplierListener supplierListener = this.a;
    if (supplierListener != null)
      supplierListener.OnSupport(false, (IdSupplier)this); 
  }
  
  public String getAAID() {
    return this.e;
  }
  
  public String getOAID() {
    return this.c;
  }
  
  public String getUDID() {
    return this.b;
  }
  
  public String getVAID() {
    return this.d;
  }
  
  public boolean isSupported() {
    return this.h;
  }
  
  public void shutDown() {
    if (this.g) {
      SupplementaryDIDManager supplementaryDIDManager = this.f;
      if (supplementaryDIDManager != null)
        supplementaryDIDManager.deInit(); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\miitmdid\c\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */