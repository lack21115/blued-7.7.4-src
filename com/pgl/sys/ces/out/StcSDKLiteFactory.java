package com.pgl.sys.ces.out;

import android.content.Context;

public class StcSDKLiteFactory {
  private static ISdkLite a;
  
  public static ISdkLite getInstance() {
    return a;
  }
  
  @Deprecated
  public static ISdkLite getSDK(Context paramContext, String paramString) {
    // Byte code:
    //   0: getstatic com/pgl/sys/ces/out/StcSDKLiteFactory.a : Lcom/pgl/sys/ces/out/ISdkLite;
    //   3: ifnonnull -> 38
    //   6: ldc com/pgl/sys/ces/out/StcSDKLiteFactory
    //   8: monitorenter
    //   9: getstatic com/pgl/sys/ces/out/StcSDKLiteFactory.a : Lcom/pgl/sys/ces/out/ISdkLite;
    //   12: ifnonnull -> 26
    //   15: aload_0
    //   16: aload_1
    //   17: sipush #255
    //   20: invokestatic a : (Landroid/content/Context;Ljava/lang/String;I)Lcom/pgl/sys/ces/b;
    //   23: putstatic com/pgl/sys/ces/out/StcSDKLiteFactory.a : Lcom/pgl/sys/ces/out/ISdkLite;
    //   26: ldc com/pgl/sys/ces/out/StcSDKLiteFactory
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/pgl/sys/ces/out/StcSDKLiteFactory
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/pgl/sys/ces/out/StcSDKLiteFactory.a : Lcom/pgl/sys/ces/out/ISdkLite;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  public static ISdkLite getSDK(Context paramContext, String paramString, int paramInt) {
    // Byte code:
    //   0: getstatic com/pgl/sys/ces/out/StcSDKLiteFactory.a : Lcom/pgl/sys/ces/out/ISdkLite;
    //   3: ifnonnull -> 36
    //   6: ldc com/pgl/sys/ces/out/StcSDKLiteFactory
    //   8: monitorenter
    //   9: getstatic com/pgl/sys/ces/out/StcSDKLiteFactory.a : Lcom/pgl/sys/ces/out/ISdkLite;
    //   12: ifnonnull -> 24
    //   15: aload_0
    //   16: aload_1
    //   17: iload_2
    //   18: invokestatic a : (Landroid/content/Context;Ljava/lang/String;I)Lcom/pgl/sys/ces/b;
    //   21: putstatic com/pgl/sys/ces/out/StcSDKLiteFactory.a : Lcom/pgl/sys/ces/out/ISdkLite;
    //   24: ldc com/pgl/sys/ces/out/StcSDKLiteFactory
    //   26: monitorexit
    //   27: goto -> 36
    //   30: astore_0
    //   31: ldc com/pgl/sys/ces/out/StcSDKLiteFactory
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    //   36: getstatic com/pgl/sys/ces/out/StcSDKLiteFactory.a : Lcom/pgl/sys/ces/out/ISdkLite;
    //   39: areturn
    // Exception table:
    //   from	to	target	type
    //   9	24	30	finally
    //   24	27	30	finally
    //   31	34	30	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\pgl\sys\ces\out\StcSDKLiteFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */