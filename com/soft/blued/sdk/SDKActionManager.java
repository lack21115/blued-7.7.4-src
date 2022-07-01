package com.soft.blued.sdk;

import android.content.Context;
import com.soft.blued.utils.Logger;

public class SDKActionManager {
  private static SDKBaseAction a;
  
  public static void a() {
    // Byte code:
    //   0: ldc com/soft/blued/sdk/SDKActionManager
    //   2: monitorenter
    //   3: invokestatic b : ()Lcom/soft/blued/sdk/SDKBaseAction;
    //   6: astore_0
    //   7: ldc 'SDKAction'
    //   9: iconst_2
    //   10: anewarray java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: ldc 'sdkManager finishAction, sdkAction:'
    //   17: aastore
    //   18: dup
    //   19: iconst_1
    //   20: aload_0
    //   21: aastore
    //   22: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: aload_0
    //   26: ifnull -> 33
    //   29: aload_0
    //   30: invokevirtual b : ()V
    //   33: aconst_null
    //   34: invokestatic b : (Lcom/soft/blued/sdk/SDKBaseAction;)V
    //   37: ldc com/soft/blued/sdk/SDKActionManager
    //   39: monitorexit
    //   40: return
    //   41: astore_0
    //   42: ldc com/soft/blued/sdk/SDKActionManager
    //   44: monitorexit
    //   45: aload_0
    //   46: athrow
    // Exception table:
    //   from	to	target	type
    //   3	25	41	finally
    //   29	33	41	finally
    //   33	37	41	finally
  }
  
  public static void a(Context paramContext) {
    SDKBaseAction sDKBaseAction = b();
    Logger.a("SDKAction", new Object[] { "sdkManager startAction, sdkAction:", sDKBaseAction });
    if (sDKBaseAction != null)
      sDKBaseAction.a(paramContext); 
  }
  
  public static void a(Context paramContext, long paramLong) {
    // Byte code:
    //   0: ldc com/soft/blued/sdk/SDKActionManager
    //   2: monitorenter
    //   3: ldc 'SDKAction'
    //   5: iconst_2
    //   6: anewarray java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: ldc 'sdkManager cancelAction, actionId:'
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: lload_1
    //   17: invokestatic valueOf : (J)Ljava/lang/Long;
    //   20: aastore
    //   21: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: invokestatic b : ()Lcom/soft/blued/sdk/SDKBaseAction;
    //   27: astore_3
    //   28: lload_1
    //   29: aload_3
    //   30: invokestatic a : (JLcom/soft/blued/sdk/SDKBaseAction;)Z
    //   33: ifeq -> 63
    //   36: ldc 'SDKAction'
    //   38: iconst_2
    //   39: anewarray java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: ldc 'action id checked and cancel it, sdkAction:'
    //   46: aastore
    //   47: dup
    //   48: iconst_1
    //   49: aload_3
    //   50: aastore
    //   51: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   54: aload_3
    //   55: aload_0
    //   56: invokevirtual d : (Landroid/content/Context;)V
    //   59: aconst_null
    //   60: invokestatic b : (Lcom/soft/blued/sdk/SDKBaseAction;)V
    //   63: ldc com/soft/blued/sdk/SDKActionManager
    //   65: monitorexit
    //   66: return
    //   67: astore_0
    //   68: ldc com/soft/blued/sdk/SDKActionManager
    //   70: monitorexit
    //   71: aload_0
    //   72: athrow
    // Exception table:
    //   from	to	target	type
    //   3	63	67	finally
  }
  
  public static void a(SDKBaseAction paramSDKBaseAction) {
    Logger.a("SDKAction", new Object[] { "sdkManager setAction, newAction:", paramSDKBaseAction });
    SDKBaseAction sDKBaseAction = b();
    if (sDKBaseAction != null) {
      Logger.a("SDKAction", new Object[] { "has oldAction, so finish it, oldAction:", sDKBaseAction });
      sDKBaseAction.b();
    } 
    b(paramSDKBaseAction);
  }
  
  public static boolean a(long paramLong) {
    return (paramLong == 0L) ? true : a(paramLong, b());
  }
  
  public static boolean a(long paramLong, SDKBaseAction paramSDKBaseAction) {
    return (paramSDKBaseAction != null && !paramSDKBaseAction.c() && paramSDKBaseAction.a() == paramLong);
  }
  
  private static SDKBaseAction b() {
    // Byte code:
    //   0: ldc com/soft/blued/sdk/SDKActionManager
    //   2: monitorenter
    //   3: getstatic com/soft/blued/sdk/SDKActionManager.a : Lcom/soft/blued/sdk/SDKBaseAction;
    //   6: ifnull -> 27
    //   9: getstatic com/soft/blued/sdk/SDKActionManager.a : Lcom/soft/blued/sdk/SDKBaseAction;
    //   12: invokevirtual c : ()Z
    //   15: ifne -> 27
    //   18: getstatic com/soft/blued/sdk/SDKActionManager.a : Lcom/soft/blued/sdk/SDKBaseAction;
    //   21: astore_0
    //   22: ldc com/soft/blued/sdk/SDKActionManager
    //   24: monitorexit
    //   25: aload_0
    //   26: areturn
    //   27: ldc com/soft/blued/sdk/SDKActionManager
    //   29: monitorexit
    //   30: aconst_null
    //   31: areturn
    //   32: astore_0
    //   33: ldc com/soft/blued/sdk/SDKActionManager
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    // Exception table:
    //   from	to	target	type
    //   3	22	32	finally
  }
  
  public static SDKBaseAction b(long paramLong) {
    SDKBaseAction sDKBaseAction = b();
    return a(paramLong, sDKBaseAction) ? sDKBaseAction : null;
  }
  
  private static void b(SDKBaseAction paramSDKBaseAction) {
    // Byte code:
    //   0: ldc com/soft/blued/sdk/SDKActionManager
    //   2: monitorenter
    //   3: aload_0
    //   4: putstatic com/soft/blued/sdk/SDKActionManager.a : Lcom/soft/blued/sdk/SDKBaseAction;
    //   7: ldc com/soft/blued/sdk/SDKActionManager
    //   9: monitorexit
    //   10: return
    //   11: astore_0
    //   12: ldc com/soft/blued/sdk/SDKActionManager
    //   14: monitorexit
    //   15: aload_0
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	11	finally
  }
  
  public static void c(long paramLong) {
    // Byte code:
    //   0: ldc com/soft/blued/sdk/SDKActionManager
    //   2: monitorenter
    //   3: ldc 'SDKAction'
    //   5: iconst_2
    //   6: anewarray java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: ldc 'sdkManager finishAction, actionId:'
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: lload_0
    //   17: invokestatic valueOf : (J)Ljava/lang/Long;
    //   20: aastore
    //   21: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: invokestatic b : ()Lcom/soft/blued/sdk/SDKBaseAction;
    //   27: astore_2
    //   28: lload_0
    //   29: aload_2
    //   30: invokestatic a : (JLcom/soft/blued/sdk/SDKBaseAction;)Z
    //   33: ifeq -> 62
    //   36: ldc 'SDKAction'
    //   38: iconst_2
    //   39: anewarray java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: ldc 'action id checked and finish it, sdkAction:'
    //   46: aastore
    //   47: dup
    //   48: iconst_1
    //   49: aload_2
    //   50: aastore
    //   51: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   54: aload_2
    //   55: invokevirtual b : ()V
    //   58: aconst_null
    //   59: invokestatic b : (Lcom/soft/blued/sdk/SDKBaseAction;)V
    //   62: ldc com/soft/blued/sdk/SDKActionManager
    //   64: monitorexit
    //   65: return
    //   66: astore_2
    //   67: ldc com/soft/blued/sdk/SDKActionManager
    //   69: monitorexit
    //   70: aload_2
    //   71: athrow
    // Exception table:
    //   from	to	target	type
    //   3	62	66	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\sdk\SDKActionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */