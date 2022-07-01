package com.blued.android.module.base.shortvideo;

import android.os.Bundle;
import com.blued.android.module.base.base.BaseProxy;

public class ShortVideoProxy extends BaseProxy<IShortVideo> implements IShortVideo {
  private static ShortVideoProxy b;
  
  public static ShortVideoProxy e() {
    // Byte code:
    //   0: getstatic com/blued/android/module/base/shortvideo/ShortVideoProxy.b : Lcom/blued/android/module/base/shortvideo/ShortVideoProxy;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/module/base/shortvideo/ShortVideoProxy
    //   8: monitorenter
    //   9: getstatic com/blued/android/module/base/shortvideo/ShortVideoProxy.b : Lcom/blued/android/module/base/shortvideo/ShortVideoProxy;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/module/base/shortvideo/ShortVideoProxy
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/module/base/shortvideo/ShortVideoProxy.b : Lcom/blued/android/module/base/shortvideo/ShortVideoProxy;
    //   25: ldc com/blued/android/module/base/shortvideo/ShortVideoProxy
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/module/base/shortvideo/ShortVideoProxy
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/module/base/shortvideo/ShortVideoProxy.b : Lcom/blued/android/module/base/shortvideo/ShortVideoProxy;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void a(Bundle paramBundle, int paramInt, ISaveInterface paramISaveInterface) {
    if (this.a != null)
      ((IShortVideo)this.a).a(paramBundle, paramInt, paramISaveInterface); 
  }
  
  public void a(Object paramObject, int paramInt1, int paramInt2) {
    if (this.a != null)
      ((IShortVideo)this.a).a(paramObject, paramInt1, paramInt2); 
  }
  
  public void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3) {
    if (this.a != null)
      ((IShortVideo)this.a).a(paramObject, paramInt1, paramInt2, paramInt3); 
  }
  
  public void a(Object paramObject, int paramInt1, String paramString1, String paramString2, int paramInt2) {
    if (this.a != null)
      ((IShortVideo)this.a).a(paramObject, paramInt1, paramString1, paramString2, paramInt2); 
  }
  
  public void a(Object paramObject, Bundle paramBundle, int paramInt) {
    if (this.a != null)
      ((IShortVideo)this.a).a(paramObject, paramBundle, paramInt); 
  }
  
  public void a(Object paramObject, Bundle paramBundle, int paramInt1, int paramInt2) {
    if (this.a != null)
      ((IShortVideo)this.a).a(paramObject, paramBundle, paramInt1, paramInt2); 
  }
  
  public void a(Object paramObject, String paramString, int paramInt1, int paramInt2) {
    if (this.a != null)
      ((IShortVideo)this.a).a(paramObject, paramString, paramInt1, paramInt2); 
  }
  
  public void a(Object paramObject, String paramString1, String paramString2, int paramInt) {
    if (this.a != null)
      ((IShortVideo)this.a).a(paramObject, paramString1, paramString2, paramInt); 
  }
  
  public void a(String paramString) {
    if (this.a != null)
      ((IShortVideo)this.a).a(paramString); 
  }
  
  public void a(String paramString, ITranscodingVideoListener paramITranscodingVideoListener) {
    if (this.a != null)
      ((IShortVideo)this.a).a(paramString, paramITranscodingVideoListener); 
  }
  
  public boolean a() {
    return (this.a != null) ? ((IShortVideo)this.a).a() : false;
  }
  
  public void b(Object paramObject, int paramInt1, int paramInt2) {
    if (this.a != null)
      ((IShortVideo)this.a).b(paramObject, paramInt1, paramInt2); 
  }
  
  public void b(String paramString) {
    if (this.a != null)
      ((IShortVideo)this.a).b(paramString); 
  }
  
  public boolean b() {
    return (this.a != null) ? ((IShortVideo)this.a).b() : false;
  }
  
  public void c() {
    if (this.a != null)
      ((IShortVideo)this.a).c(); 
  }
  
  public void d() {
    if (this.a != null)
      ((IShortVideo)this.a).d(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\base\shortvideo\ShortVideoProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */