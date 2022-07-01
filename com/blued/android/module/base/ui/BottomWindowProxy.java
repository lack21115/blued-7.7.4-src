package com.blued.android.module.base.ui;

import com.blued.android.module.base.base.BaseProxy;

public class BottomWindowProxy extends BaseProxy<IBottomWindow> implements IBottomWindow {
  private static BottomWindowProxy b;
  
  public static BottomWindowProxy a() {
    // Byte code:
    //   0: getstatic com/blued/android/module/base/ui/BottomWindowProxy.b : Lcom/blued/android/module/base/ui/BottomWindowProxy;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/module/base/ui/BottomWindowProxy
    //   8: monitorenter
    //   9: getstatic com/blued/android/module/base/ui/BottomWindowProxy.b : Lcom/blued/android/module/base/ui/BottomWindowProxy;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/module/base/ui/BottomWindowProxy
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/module/base/ui/BottomWindowProxy.b : Lcom/blued/android/module/base/ui/BottomWindowProxy;
    //   25: ldc com/blued/android/module/base/ui/BottomWindowProxy
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/module/base/ui/BottomWindowProxy
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/module/base/ui/BottomWindowProxy.b : Lcom/blued/android/module/base/ui/BottomWindowProxy;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public static interface IActionSheetListener {
    void a(int param1Int);
    
    void a(boolean param1Boolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\bas\\ui\BottomWindowProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */