package com.bytedance.sdk.openadsdk.core.f;

import android.os.Looper;
import java.util.HashSet;
import java.util.Set;

public abstract class e {
  private static final String a = e.class.getSimpleName();
  
  private final Set<String> b = new HashSet<String>(1);
  
  private Looper c = Looper.getMainLooper();
  
  public abstract void a();
  
  public abstract void a(String paramString);
  
  protected final void a(String[] paramArrayOfString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/Set;
    //   6: aload_1
    //   7: invokestatic addAll : (Ljava/util/Collection;[Ljava/lang/Object;)Z
    //   10: pop
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	14	finally
  }
  
  protected final boolean a(String paramString, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_2
    //   3: ifne -> 19
    //   6: aload_0
    //   7: aload_1
    //   8: getstatic com/bytedance/sdk/openadsdk/core/f/c.a : Lcom/bytedance/sdk/openadsdk/core/f/c;
    //   11: invokevirtual a : (Ljava/lang/String;Lcom/bytedance/sdk/openadsdk/core/f/c;)Z
    //   14: istore_3
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_3
    //   18: ireturn
    //   19: aload_0
    //   20: aload_1
    //   21: getstatic com/bytedance/sdk/openadsdk/core/f/c.b : Lcom/bytedance/sdk/openadsdk/core/f/c;
    //   24: invokevirtual a : (Ljava/lang/String;Lcom/bytedance/sdk/openadsdk/core/f/c;)Z
    //   27: istore_3
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_3
    //   31: ireturn
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   6	15	32	finally
    //   19	28	32	finally
  }
  
  protected final boolean a(String paramString, c paramc) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/Set;
    //   6: aload_1
    //   7: invokeinterface remove : (Ljava/lang/Object;)Z
    //   12: pop
    //   13: getstatic com/bytedance/sdk/openadsdk/core/f/e$5.a : [I
    //   16: aload_2
    //   17: invokevirtual ordinal : ()I
    //   20: iaload
    //   21: istore_3
    //   22: iload_3
    //   23: iconst_1
    //   24: if_icmpeq -> 143
    //   27: iload_3
    //   28: iconst_2
    //   29: if_icmpeq -> 115
    //   32: iload_3
    //   33: iconst_3
    //   34: if_icmpeq -> 40
    //   37: goto -> 182
    //   40: aload_0
    //   41: aload_1
    //   42: invokevirtual b : (Ljava/lang/String;)Z
    //   45: ifeq -> 87
    //   48: aload_0
    //   49: getfield b : Ljava/util/Set;
    //   52: invokeinterface isEmpty : ()Z
    //   57: ifeq -> 182
    //   60: new android/os/Handler
    //   63: dup
    //   64: aload_0
    //   65: getfield c : Landroid/os/Looper;
    //   68: invokespecial <init> : (Landroid/os/Looper;)V
    //   71: new com/bytedance/sdk/openadsdk/core/f/e$3
    //   74: dup
    //   75: aload_0
    //   76: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/core/f/e;)V
    //   79: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   82: pop
    //   83: aload_0
    //   84: monitorexit
    //   85: iconst_1
    //   86: ireturn
    //   87: new android/os/Handler
    //   90: dup
    //   91: aload_0
    //   92: getfield c : Landroid/os/Looper;
    //   95: invokespecial <init> : (Landroid/os/Looper;)V
    //   98: new com/bytedance/sdk/openadsdk/core/f/e$4
    //   101: dup
    //   102: aload_0
    //   103: aload_1
    //   104: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/core/f/e;Ljava/lang/String;)V
    //   107: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   110: pop
    //   111: aload_0
    //   112: monitorexit
    //   113: iconst_1
    //   114: ireturn
    //   115: new android/os/Handler
    //   118: dup
    //   119: aload_0
    //   120: getfield c : Landroid/os/Looper;
    //   123: invokespecial <init> : (Landroid/os/Looper;)V
    //   126: new com/bytedance/sdk/openadsdk/core/f/e$2
    //   129: dup
    //   130: aload_0
    //   131: aload_1
    //   132: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/core/f/e;Ljava/lang/String;)V
    //   135: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   138: pop
    //   139: aload_0
    //   140: monitorexit
    //   141: iconst_1
    //   142: ireturn
    //   143: aload_0
    //   144: getfield b : Ljava/util/Set;
    //   147: invokeinterface isEmpty : ()Z
    //   152: ifeq -> 182
    //   155: new android/os/Handler
    //   158: dup
    //   159: aload_0
    //   160: getfield c : Landroid/os/Looper;
    //   163: invokespecial <init> : (Landroid/os/Looper;)V
    //   166: new com/bytedance/sdk/openadsdk/core/f/e$1
    //   169: dup
    //   170: aload_0
    //   171: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/core/f/e;)V
    //   174: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   177: pop
    //   178: aload_0
    //   179: monitorexit
    //   180: iconst_1
    //   181: ireturn
    //   182: aload_0
    //   183: monitorexit
    //   184: iconst_0
    //   185: ireturn
    //   186: astore_1
    //   187: aload_0
    //   188: monitorexit
    //   189: aload_1
    //   190: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	186	finally
    //   40	83	186	finally
    //   87	111	186	finally
    //   115	139	186	finally
    //   143	178	186	finally
  }
  
  public boolean b(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/bytedance/sdk/openadsdk/core/f/e.a : Ljava/lang/String;
    //   5: astore_2
    //   6: new java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial <init> : ()V
    //   13: astore_3
    //   14: aload_3
    //   15: ldc 'Permission not found: '
    //   17: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_3
    //   22: aload_1
    //   23: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_2
    //   28: aload_3
    //   29: invokevirtual toString : ()Ljava/lang/String;
    //   32: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   35: pop
    //   36: aload_0
    //   37: monitorexit
    //   38: iconst_1
    //   39: ireturn
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Exception table:
    //   from	to	target	type
    //   2	36	40	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\f\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */