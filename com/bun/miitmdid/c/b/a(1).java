package com.bun.miitmdid.c.b;

import android.content.Context;
import android.os.IBinder;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;
import com.asus.msa.sdid.IDIDBinderStatusListener;
import com.asus.msa.sdid.SupplementaryDIDManager;
import com.bun.supplier.InnerIdSupplier;
import com.bun.supplier.SupplierListener;

public class a implements IDIDBinderStatusListener, InnerIdSupplier {
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
  
  public native void a(IDidAidlInterface paramIDidAidlInterface);
  
  public native void a(SupplierListener paramSupplierListener);
  
  public native boolean a();
  
  public native IBinder asBinder();
  
  public native void b();
  
  public native String getAAID();
  
  public native String getOAID();
  
  public native String getUDID();
  
  public native String getVAID();
  
  public native boolean isSupported();
  
  public native void shutDown();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bun\miitmdid\c\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */