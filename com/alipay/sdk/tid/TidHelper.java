package com.alipay.sdk.tid;

import android.content.Context;
import android.os.Looper;
import com.alipay.sdk.data.c;
import com.alipay.sdk.packet.b;
import com.alipay.sdk.packet.impl.c;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.sys.b;
import com.alipay.sdk.util.a;
import com.alipay.sdk.util.c;

public class TidHelper {
  private static Tid a(Context paramContext, b paramb) {
    return (paramb == null || paramb.e()) ? null : new Tid(paramb.a(), paramb.b(), paramb.i().longValue());
  }
  
  private static void a(Context paramContext) {
    if (paramContext == null)
      return; 
    b.a().a(paramContext);
  }
  
  private static Tid b(Context paramContext) throws Exception {
    try {
      b b = (new c()).a(a.a(), paramContext);
      return null;
    } finally {
      paramContext = null;
    } 
  }
  
  public static void clearTID(Context paramContext) {
    b.a(paramContext).g();
  }
  
  public static String getIMEI(Context paramContext) {
    a(paramContext);
    return a.a(paramContext).b();
  }
  
  public static String getIMSI(Context paramContext) {
    a(paramContext);
    return a.a(paramContext).a();
  }
  
  public static String getTIDValue(Context paramContext) {
    // Byte code:
    //   0: ldc com/alipay/sdk/tid/TidHelper
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic loadOrCreateTID : (Landroid/content/Context;)Lcom/alipay/sdk/tid/Tid;
    //   7: astore_0
    //   8: aload_0
    //   9: invokestatic isEmpty : (Lcom/alipay/sdk/tid/Tid;)Z
    //   12: ifeq -> 21
    //   15: ldc ''
    //   17: astore_0
    //   18: goto -> 26
    //   21: aload_0
    //   22: invokevirtual getTid : ()Ljava/lang/String;
    //   25: astore_0
    //   26: ldc com/alipay/sdk/tid/TidHelper
    //   28: monitorexit
    //   29: aload_0
    //   30: areturn
    //   31: astore_0
    //   32: ldc com/alipay/sdk/tid/TidHelper
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   3	15	31	finally
    //   21	26	31	finally
  }
  
  public static String getVirtualImei(Context paramContext) {
    a(paramContext);
    c.b();
    return c.c();
  }
  
  public static String getVirtualImsi(Context paramContext) {
    a(paramContext);
    c.b();
    return c.d();
  }
  
  public static Tid loadLocalTid(Context paramContext) {
    b b = b.a(paramContext);
    return b.h() ? null : new Tid(b.a(), b.b(), b.i().longValue());
  }
  
  public static Tid loadOrCreateTID(Context paramContext) {
    // Byte code:
    //   0: ldc com/alipay/sdk/tid/TidHelper
    //   2: monitorenter
    //   3: ldc 'mspl'
    //   5: ldc 'load_create_tid'
    //   7: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   10: aload_0
    //   11: invokestatic a : (Landroid/content/Context;)V
    //   14: aload_0
    //   15: invokestatic loadTID : (Landroid/content/Context;)Lcom/alipay/sdk/tid/Tid;
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_2
    //   22: invokestatic isEmpty : (Lcom/alipay/sdk/tid/Tid;)Z
    //   25: ifeq -> 51
    //   28: invokestatic myLooper : ()Landroid/os/Looper;
    //   31: astore_1
    //   32: invokestatic getMainLooper : ()Landroid/os/Looper;
    //   35: astore_3
    //   36: aload_1
    //   37: aload_3
    //   38: if_acmpne -> 46
    //   41: ldc com/alipay/sdk/tid/TidHelper
    //   43: monitorexit
    //   44: aconst_null
    //   45: areturn
    //   46: aload_0
    //   47: invokestatic b : (Landroid/content/Context;)Lcom/alipay/sdk/tid/Tid;
    //   50: astore_1
    //   51: ldc com/alipay/sdk/tid/TidHelper
    //   53: monitorexit
    //   54: aload_1
    //   55: areturn
    //   56: astore_0
    //   57: ldc com/alipay/sdk/tid/TidHelper
    //   59: monitorexit
    //   60: aload_0
    //   61: athrow
    //   62: astore_0
    //   63: aload_2
    //   64: astore_1
    //   65: goto -> 51
    // Exception table:
    //   from	to	target	type
    //   3	19	56	finally
    //   21	36	56	finally
    //   46	51	62	finally
  }
  
  public static Tid loadTID(Context paramContext) {
    a(paramContext);
    Tid tid = a(paramContext, b.a(paramContext));
    if (tid == null)
      c.a("mspl", "load_tid null"); 
    return tid;
  }
  
  public static boolean resetTID(Context paramContext) throws Exception {
    c.a("mspl", "reset_tid");
    if (Looper.myLooper() != Looper.getMainLooper()) {
      a(paramContext);
      clearTID(paramContext);
      Context context = null;
      try {
        Tid tid = b(paramContext);
      } finally {
        paramContext = null;
      } 
    } 
    throw new Exception("Must be called on worker thread");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\tid\TidHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */