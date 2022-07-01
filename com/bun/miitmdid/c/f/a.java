package com.bun.miitmdid.c.f;

import android.content.Context;
import com.bun.supplier.InnerIdSupplier;
import com.bun.supplier.SupplierListener;
import com.meizu.flyme.openidsdk.OpenIdHelper;

public class a implements InnerIdSupplier {
  private Context a;
  
  public a(Context paramContext) {
    this.a = paramContext;
  }
  
  public void a(SupplierListener paramSupplierListener) {}
  
  public boolean a() {
    return true;
  }
  
  public String getAAID() {
    try {
      return OpenIdHelper.a(this.a);
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public String getOAID() {
    try {
      return OpenIdHelper.b(this.a);
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public String getUDID() {
    try {
      return OpenIdHelper.c(this.a);
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public String getVAID() {
    try {
      return OpenIdHelper.d(this.a);
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public boolean isSupported() {
    try {
      return OpenIdHelper.a();
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public void shutDown() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\miitmdid\c\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */