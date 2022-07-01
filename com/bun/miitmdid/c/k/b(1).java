package com.bun.miitmdid.c.k;

import android.content.Context;
import com.bun.supplier.InnerIdSupplier;
import com.bun.supplier.SupplierListener;

public class b implements InnerIdSupplier {
  private Context a;
  
  public b(Context paramContext) {
    this.a = paramContext;
  }
  
  public native void a(SupplierListener paramSupplierListener);
  
  public native boolean a();
  
  public native String getAAID();
  
  public native String getOAID();
  
  public native String getUDID();
  
  public native String getVAID();
  
  public native boolean isSupported();
  
  public native void shutDown();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bun\miitmdid\c\k\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */