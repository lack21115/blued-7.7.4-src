package com.huawei.agconnect;

import android.content.Context;

public abstract class AGConnectInstance {
  private static AGConnectInstance a;
  
  public static void a(Context paramContext) {
    // Byte code:
    //   0: ldc com/huawei/agconnect/AGConnectInstance
    //   2: monitorenter
    //   3: ldc 'AGConnectInstance'
    //   5: ldc 'AGConnectInstance#initialize'
    //   7: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   10: pop
    //   11: aload_0
    //   12: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnonnull -> 50
    //   20: goto -> 23
    //   23: getstatic com/huawei/agconnect/AGConnectInstance.a : Lcom/huawei/agconnect/AGConnectInstance;
    //   26: ifnonnull -> 40
    //   29: new com/huawei/agconnect/core/a/a
    //   32: dup
    //   33: aload_0
    //   34: invokespecial <init> : (Landroid/content/Context;)V
    //   37: putstatic com/huawei/agconnect/AGConnectInstance.a : Lcom/huawei/agconnect/AGConnectInstance;
    //   40: ldc com/huawei/agconnect/AGConnectInstance
    //   42: monitorexit
    //   43: return
    //   44: astore_0
    //   45: ldc com/huawei/agconnect/AGConnectInstance
    //   47: monitorexit
    //   48: aload_0
    //   49: athrow
    //   50: aload_1
    //   51: astore_0
    //   52: goto -> 23
    // Exception table:
    //   from	to	target	type
    //   3	16	44	finally
    //   23	40	44	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\agconnect\AGConnectInstance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */