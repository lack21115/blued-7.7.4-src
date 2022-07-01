package com.bun.miitmdid.supplier.msa;

import android.content.Context;
import android.text.TextUtils;
import com.bun.lib.sysParamters;
import com.bun.miitmdid.c.e.a;
import com.bun.supplier.InnerIdSupplier;
import com.bun.supplier.SupplierListener;

public class b implements a, InnerIdSupplier {
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bun\miitmdid\supplier\msa\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */