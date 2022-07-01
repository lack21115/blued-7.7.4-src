package com.blued.android.module.base.ui;

import com.blued.android.module.base.base.BaseProxy;

public class GuideDialogProxy extends BaseProxy<IGuideDialog> implements IGuideDialog {
  private static GuideDialogProxy b;
  
  public static GuideDialogProxy a() {
    // Byte code:
    //   0: getstatic com/blued/android/module/base/ui/GuideDialogProxy.b : Lcom/blued/android/module/base/ui/GuideDialogProxy;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/module/base/ui/GuideDialogProxy
    //   8: monitorenter
    //   9: getstatic com/blued/android/module/base/ui/GuideDialogProxy.b : Lcom/blued/android/module/base/ui/GuideDialogProxy;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/module/base/ui/GuideDialogProxy
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/module/base/ui/GuideDialogProxy.b : Lcom/blued/android/module/base/ui/GuideDialogProxy;
    //   25: ldc com/blued/android/module/base/ui/GuideDialogProxy
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/module/base/ui/GuideDialogProxy
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/module/base/ui/GuideDialogProxy.b : Lcom/blued/android/module/base/ui/GuideDialogProxy;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\bas\\ui\GuideDialogProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */