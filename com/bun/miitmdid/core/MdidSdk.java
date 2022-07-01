package com.bun.miitmdid.core;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Keep;
import com.bun.lib.b;
import com.bun.miitmdid.a.b;
import com.bun.miitmdid.b.c;
import com.bun.miitmdid.c.g.b;
import com.bun.miitmdid.c.h.b;
import com.bun.miitmdid.c.k.b;
import com.bun.miitmdid.supplier.msa.b;
import com.bun.supplier.DefaultSupplier;
import com.bun.supplier.IIdentifierListener;
import com.bun.supplier.IdSupplier;
import com.bun.supplier.InnerIdSupplier;
import com.bun.supplier.SupplierListener;

@Keep
public class MdidSdk implements SupplierListener {
  private IIdentifierListener _InnerListener;
  
  private b _setting;
  
  @Keep
  public MdidSdk() {
    try {
      com.bun.lib.a.a(true);
      return;
    } catch (Exception exception) {
      com.bun.lib.a.b("mdidsdk", "extractor exception!", exception);
      return;
    } 
  }
  
  @Keep
  public MdidSdk(boolean paramBoolean) {
    try {
      com.bun.lib.a.a(paramBoolean);
      return;
    } catch (Exception exception) {
      com.bun.lib.a.b("mdidsdk", "extractor exception!", exception);
      return;
    } 
  }
  
  private int _InnerFailed(int paramInt, IdSupplier paramIdSupplier) {
    if (paramIdSupplier != null) {
      boolean bool1 = paramIdSupplier.isSupported();
      OnSupport(bool1, paramIdSupplier);
      return paramInt;
    } 
    boolean bool = false;
    OnSupport(bool, paramIdSupplier);
    return paramInt;
  }
  
  @Keep
  public int InitSdk(Context paramContext, IIdentifierListener paramIIdentifierListener) {
    b b4;
    b b3;
    com.bun.miitmdid.c.f.a a5;
    com.bun.miitmdid.supplier.sumsung.a a4;
    com.bun.miitmdid.c.b.a a3;
    b b2;
    com.bun.miitmdid.c.i.a a2;
    com.bun.miitmdid.c.d.a a1;
    com.bun.miitmdid.c.j.a a;
    b b1;
    this._InnerListener = paramIIdentifierListener;
    b.a(paramContext);
    com.bun.miitmdid.c.a a8 = com.bun.miitmdid.c.a.a(Build.MANUFACTURER);
    com.bun.miitmdid.c.a a6 = a8;
    if (a8 == com.bun.miitmdid.c.a.b) {
      a8 = com.bun.miitmdid.c.c.a.a();
      a6 = a8;
      if (a8 == com.bun.miitmdid.c.a.b)
        return _InnerFailed(1008611, (IdSupplier)new DefaultSupplier()); 
    } 
    com.bun.miitmdid.a.a a7 = com.bun.miitmdid.a.a.a(paramContext);
    if (a7 == null)
      return _InnerFailed(1008613, (IdSupplier)new DefaultSupplier()); 
    this._setting = (b)a7;
    switch (a.a[a6.ordinal()]) {
      default:
        paramContext = null;
        if (paramContext == null)
          return _InnerFailed(1008612, (IdSupplier)new DefaultSupplier()); 
        break;
      case 13:
      case 14:
      case 15:
        b4 = new b(paramContext);
        if (b4 == null)
          return _InnerFailed(1008612, (IdSupplier)new DefaultSupplier()); 
        break;
      case 12:
        b3 = new b((Context)b4);
        if (b3 == null)
          return _InnerFailed(1008612, (IdSupplier)new DefaultSupplier()); 
        break;
      case 11:
        a5 = new com.bun.miitmdid.c.f.a((Context)b3);
        if (a5 == null)
          return _InnerFailed(1008612, (IdSupplier)new DefaultSupplier()); 
        break;
      case 10:
        a4 = new com.bun.miitmdid.supplier.sumsung.a((Context)a5, this);
        if (a4 == null)
          return _InnerFailed(1008612, (IdSupplier)new DefaultSupplier()); 
        break;
      case 9:
        a3 = new com.bun.miitmdid.c.b.a((Context)a4, this);
        if (a3 == null)
          return _InnerFailed(1008612, (IdSupplier)new DefaultSupplier()); 
        break;
      case 7:
      case 8:
        b2 = new b((Context)a3, this);
        if (b2 == null)
          return _InnerFailed(1008612, (IdSupplier)new DefaultSupplier()); 
        break;
      case 5:
      case 6:
        a2 = new com.bun.miitmdid.c.i.a((Context)b2);
        if (a2 == null)
          return _InnerFailed(1008612, (IdSupplier)new DefaultSupplier()); 
        break;
      case 4:
        a1 = new com.bun.miitmdid.c.d.a((Context)a2);
        if (a1 == null)
          return _InnerFailed(1008612, (IdSupplier)new DefaultSupplier()); 
        break;
      case 3:
        a = new com.bun.miitmdid.c.j.a((Context)a1);
        a.a(this._setting.a());
        if (a == null)
          return _InnerFailed(1008612, (IdSupplier)new DefaultSupplier()); 
        break;
      case 1:
      case 2:
        b1 = new b((Context)a);
        if (b1 == null)
          return _InnerFailed(1008612, (IdSupplier)new DefaultSupplier()); 
        break;
    } 
    if (b1.a()) {
      if (!b1.isSupported())
        return _InnerFailed(1008612, (IdSupplier)b1); 
      OnSupport(true, (IdSupplier)b1);
      return 0;
    } 
    b1.a(this);
    return 1008614;
  }
  
  public void OnSupport(boolean paramBoolean, IdSupplier paramIdSupplier) {
    IIdentifierListener iIdentifierListener = this._InnerListener;
    if (iIdentifierListener != null)
      iIdentifierListener.OnSupport(paramBoolean, paramIdSupplier); 
    c c = new c();
    String str1 = "";
    String str2 = "";
    String str3 = "";
    if (paramIdSupplier != null) {
      String str4 = paramIdSupplier.getOAID();
      String str5 = paramIdSupplier.getVAID();
      String str6 = paramIdSupplier.getAAID();
      str1 = str4;
      str2 = str5;
      str3 = str6;
      if (paramIdSupplier instanceof InnerIdSupplier) {
        ((InnerIdSupplier)paramIdSupplier).shutDown();
        str3 = str6;
        str2 = str5;
        str1 = str4;
      } 
    } 
    c.a(paramBoolean, "", str1, str2, str3);
  }
  
  public void UnInitSdk() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\miitmdid\core\MdidSdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */