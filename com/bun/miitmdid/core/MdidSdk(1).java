package com.bun.miitmdid.core;

import android.content.Context;
import com.bun.miitmdid.a.b;
import com.bun.supplier.IIdentifierListener;
import com.bun.supplier.IdSupplier;
import com.bun.supplier.SupplierListener;

public class MdidSdk implements SupplierListener {
  private IIdentifierListener _InnerListener;
  
  private b _setting;
  
  public MdidSdk() {
    try {
      com.bun.lib.a.a(true);
      return;
    } catch (Exception exception) {
      com.bun.lib.a.b("mdidsdk", "extractor exception!", exception);
      return;
    } 
  }
  
  public MdidSdk(boolean paramBoolean) {
    try {
      com.bun.lib.a.a(paramBoolean);
      return;
    } catch (Exception exception) {
      com.bun.lib.a.b("mdidsdk", "extractor exception!", exception);
      return;
    } 
  }
  
  private native int _InnerFailed(int paramInt, IdSupplier paramIdSupplier);
  
  public native int InitSdk(Context paramContext, IIdentifierListener paramIIdentifierListener);
  
  public native void OnSupport(boolean paramBoolean, IdSupplier paramIdSupplier);
  
  public native void UnInitSdk();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bun\miitmdid\core\MdidSdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */