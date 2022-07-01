package com.bun.miitmdid.c.g;

import android.content.Context;
import com.bun.miitmdid.c.e.a;
import com.bun.supplier.InnerIdSupplier;
import com.bun.supplier.SupplierListener;

public class b implements a, InnerIdSupplier {
  private a a;
  
  private SupplierListener b;
  
  public b(Context paramContext, SupplierListener paramSupplierListener) {
    this.b = paramSupplierListener;
    this.a = new a(paramContext, this);
  }
  
  public native void a(SupplierListener paramSupplierListener);
  
  public native void a(boolean paramBoolean);
  
  public native boolean a();
  
  public native void b();
  
  public native String getAAID();
  
  public native String getOAID();
  
  public native String getUDID();
  
  public native String getVAID();
  
  public native boolean isSupported();
  
  public native void shutDown();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bun\miitmdid\c\g\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */