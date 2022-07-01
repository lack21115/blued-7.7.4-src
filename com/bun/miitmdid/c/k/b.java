package com.bun.miitmdid.c.k;

import android.content.Context;
import android.text.TextUtils;
import com.bun.lib.sysParamters;
import com.bun.supplier.InnerIdSupplier;
import com.bun.supplier.SupplierListener;

public class b implements InnerIdSupplier {
  private Context a;
  
  public b(Context paramContext) {
    this.a = paramContext;
  }
  
  public void a(SupplierListener paramSupplierListener) {}
  
  public boolean a() {
    return true;
  }
  
  public String getAAID() {
    String str2 = a.a(this.a);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = sysParamters.e(); 
    return str1;
  }
  
  public String getOAID() {
    String str2 = a.b(this.a);
    String str1 = str2;
    if (str2 == null)
      str1 = ""; 
    return str1;
  }
  
  public String getUDID() {
    return "";
  }
  
  public String getVAID() {
    String str2 = a.c(this.a);
    String str1 = str2;
    if (str2 == null)
      str1 = ""; 
    return str1;
  }
  
  public boolean isSupported() {
    return a.a();
  }
  
  public void shutDown() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\miitmdid\c\k\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */