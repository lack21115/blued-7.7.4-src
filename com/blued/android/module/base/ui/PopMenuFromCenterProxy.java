package com.blued.android.module.base.ui;

import android.content.Context;
import com.blued.android.module.base.base.BaseProxy;

public class PopMenuFromCenterProxy extends BaseProxy<IPopMenuFromCenter> implements IPopMenuFromCenter {
  private static PopMenuFromCenterProxy b;
  
  public static PopMenuFromCenterProxy a() {
    // Byte code:
    //   0: getstatic com/blued/android/module/base/ui/PopMenuFromCenterProxy.b : Lcom/blued/android/module/base/ui/PopMenuFromCenterProxy;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/module/base/ui/PopMenuFromCenterProxy
    //   8: monitorenter
    //   9: getstatic com/blued/android/module/base/ui/PopMenuFromCenterProxy.b : Lcom/blued/android/module/base/ui/PopMenuFromCenterProxy;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/module/base/ui/PopMenuFromCenterProxy
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/module/base/ui/PopMenuFromCenterProxy.b : Lcom/blued/android/module/base/ui/PopMenuFromCenterProxy;
    //   25: ldc com/blued/android/module/base/ui/PopMenuFromCenterProxy
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/module/base/ui/PopMenuFromCenterProxy
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/module/base/ui/PopMenuFromCenterProxy.b : Lcom/blued/android/module/base/ui/PopMenuFromCenterProxy;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public boolean a(Context paramContext) {
    return (this.a != null) ? ((IPopMenuFromCenter)this.a).a(paramContext) : false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\bas\\ui\PopMenuFromCenterProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */