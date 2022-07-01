package com.bytedance.sdk.openadsdk.core.b;

import android.os.Handler;
import com.bytedance.sdk.openadsdk.core.h.l;
import com.bytedance.sdk.openadsdk.core.o;
import java.util.LinkedList;
import java.util.Queue;

public class a {
  private static volatile a a;
  
  private static volatile boolean b;
  
  private static volatile long c;
  
  private final Queue<a> d = new LinkedList<a>();
  
  private Handler e;
  
  private final l f = o.h();
  
  public static a a() {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/core/b/a.a : Lcom/bytedance/sdk/openadsdk/core/b/a;
    //   3: ifnonnull -> 37
    //   6: ldc com/bytedance/sdk/openadsdk/core/b/a
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/core/b/a.a : Lcom/bytedance/sdk/openadsdk/core/b/a;
    //   12: ifnonnull -> 25
    //   15: new com/bytedance/sdk/openadsdk/core/b/a
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bytedance/sdk/openadsdk/core/b/a.a : Lcom/bytedance/sdk/openadsdk/core/b/a;
    //   25: ldc com/bytedance/sdk/openadsdk/core/b/a
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/bytedance/sdk/openadsdk/core/b/a
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/bytedance/sdk/openadsdk/core/b/a.a : Lcom/bytedance/sdk/openadsdk/core/b/a;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private void a(long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield e : Landroid/os/Handler;
    //   6: ifnonnull -> 23
    //   9: aload_0
    //   10: new android/os/Handler
    //   13: dup
    //   14: invokestatic getMainLooper : ()Landroid/os/Looper;
    //   17: invokespecial <init> : (Landroid/os/Looper;)V
    //   20: putfield e : Landroid/os/Handler;
    //   23: aload_0
    //   24: getfield e : Landroid/os/Handler;
    //   27: new com/bytedance/sdk/openadsdk/core/b/a$1
    //   30: dup
    //   31: aload_0
    //   32: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/core/b/a;)V
    //   35: lload_1
    //   36: invokevirtual postDelayed : (Ljava/lang/Runnable;J)Z
    //   39: pop
    //   40: aload_0
    //   41: monitorexit
    //   42: return
    //   43: astore_3
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_3
    //   47: athrow
    // Exception table:
    //   from	to	target	type
    //   2	23	43	finally
    //   23	40	43	finally
  }
  
  private void a(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: putstatic com/bytedance/sdk/openadsdk/core/b/a.b : Z
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: astore_2
    //   10: aload_0
    //   11: monitorexit
    //   12: aload_2
    //   13: athrow
    // Exception table:
    //   from	to	target	type
    //   2	6	9	finally
  }
  
  private void b(long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: lload_1
    //   3: putstatic com/bytedance/sdk/openadsdk/core/b/a.c : J
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: astore_3
    //   10: aload_0
    //   11: monitorexit
    //   12: aload_3
    //   13: athrow
    // Exception table:
    //   from	to	target	type
    //   2	6	9	finally
  }
  
  private boolean b(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic currentTimeMillis : ()J
    //   5: lstore_3
    //   6: aload_0
    //   7: getfield f : Lcom/bytedance/sdk/openadsdk/core/h/l;
    //   10: invokevirtual l : ()I
    //   13: istore_2
    //   14: aload_0
    //   15: getfield f : Lcom/bytedance/sdk/openadsdk/core/h/l;
    //   18: invokevirtual k : ()J
    //   21: lstore #5
    //   23: aload_0
    //   24: getfield d : Ljava/util/Queue;
    //   27: invokeinterface size : ()I
    //   32: ifle -> 124
    //   35: aload_0
    //   36: getfield d : Ljava/util/Queue;
    //   39: invokeinterface size : ()I
    //   44: iload_2
    //   45: if_icmplt -> 124
    //   48: lload_3
    //   49: aload_0
    //   50: getfield d : Ljava/util/Queue;
    //   53: invokeinterface peek : ()Ljava/lang/Object;
    //   58: checkcast com/bytedance/sdk/openadsdk/core/b/a$a
    //   61: invokestatic a : (Lcom/bytedance/sdk/openadsdk/core/b/a$a;)J
    //   64: lsub
    //   65: invokestatic abs : (J)J
    //   68: lstore #7
    //   70: lload #7
    //   72: lload #5
    //   74: lcmp
    //   75: ifgt -> 91
    //   78: aload_0
    //   79: lload #5
    //   81: lload #7
    //   83: lsub
    //   84: invokespecial b : (J)V
    //   87: aload_0
    //   88: monitorexit
    //   89: iconst_1
    //   90: ireturn
    //   91: aload_0
    //   92: getfield d : Ljava/util/Queue;
    //   95: invokeinterface poll : ()Ljava/lang/Object;
    //   100: pop
    //   101: aload_0
    //   102: getfield d : Ljava/util/Queue;
    //   105: new com/bytedance/sdk/openadsdk/core/b/a$a
    //   108: dup
    //   109: lload_3
    //   110: aload_1
    //   111: aconst_null
    //   112: invokespecial <init> : (JLjava/lang/String;Lcom/bytedance/sdk/openadsdk/core/b/a$1;)V
    //   115: invokeinterface offer : (Ljava/lang/Object;)Z
    //   120: pop
    //   121: goto -> 144
    //   124: aload_0
    //   125: getfield d : Ljava/util/Queue;
    //   128: new com/bytedance/sdk/openadsdk/core/b/a$a
    //   131: dup
    //   132: lload_3
    //   133: aload_1
    //   134: aconst_null
    //   135: invokespecial <init> : (JLjava/lang/String;Lcom/bytedance/sdk/openadsdk/core/b/a$1;)V
    //   138: invokeinterface offer : (Ljava/lang/Object;)Z
    //   143: pop
    //   144: aload_0
    //   145: monitorexit
    //   146: iconst_0
    //   147: ireturn
    //   148: astore_1
    //   149: aload_0
    //   150: monitorexit
    //   151: aload_1
    //   152: athrow
    // Exception table:
    //   from	to	target	type
    //   2	70	148	finally
    //   78	87	148	finally
    //   91	121	148	finally
    //   124	144	148	finally
  }
  
  public boolean a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial b : (Ljava/lang/String;)Z
    //   7: ifeq -> 25
    //   10: aload_0
    //   11: iconst_1
    //   12: invokespecial a : (Z)V
    //   15: aload_0
    //   16: getstatic com/bytedance/sdk/openadsdk/core/b/a.c : J
    //   19: invokespecial a : (J)V
    //   22: goto -> 30
    //   25: aload_0
    //   26: iconst_0
    //   27: invokespecial a : (Z)V
    //   30: getstatic com/bytedance/sdk/openadsdk/core/b/a.b : Z
    //   33: istore_2
    //   34: aload_0
    //   35: monitorexit
    //   36: iload_2
    //   37: ireturn
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	38	finally
    //   25	30	38	finally
    //   30	34	38	finally
  }
  
  public boolean b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/bytedance/sdk/openadsdk/core/b/a.b : Z
    //   5: istore_1
    //   6: aload_0
    //   7: monitorexit
    //   8: iload_1
    //   9: ireturn
    //   10: astore_2
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_2
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	6	10	finally
  }
  
  public String c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/util/HashMap
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore #5
    //   11: aload_0
    //   12: getfield d : Ljava/util/Queue;
    //   15: invokeinterface iterator : ()Ljava/util/Iterator;
    //   20: astore_3
    //   21: aload_3
    //   22: invokeinterface hasNext : ()Z
    //   27: ifeq -> 107
    //   30: aload_3
    //   31: invokeinterface next : ()Ljava/lang/Object;
    //   36: checkcast com/bytedance/sdk/openadsdk/core/b/a$a
    //   39: astore #4
    //   41: aload #5
    //   43: aload #4
    //   45: invokestatic b : (Lcom/bytedance/sdk/openadsdk/core/b/a$a;)Ljava/lang/String;
    //   48: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   51: ifeq -> 89
    //   54: aload #5
    //   56: aload #4
    //   58: invokestatic b : (Lcom/bytedance/sdk/openadsdk/core/b/a$a;)Ljava/lang/String;
    //   61: aload #5
    //   63: aload #4
    //   65: invokestatic b : (Lcom/bytedance/sdk/openadsdk/core/b/a$a;)Ljava/lang/String;
    //   68: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   71: checkcast java/lang/Integer
    //   74: invokevirtual intValue : ()I
    //   77: iconst_1
    //   78: iadd
    //   79: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   82: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   85: pop
    //   86: goto -> 21
    //   89: aload #5
    //   91: aload #4
    //   93: invokestatic b : (Lcom/bytedance/sdk/openadsdk/core/b/a$a;)Ljava/lang/String;
    //   96: iconst_1
    //   97: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   100: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   103: pop
    //   104: goto -> 21
    //   107: aload #5
    //   109: invokevirtual keySet : ()Ljava/util/Set;
    //   112: invokeinterface iterator : ()Ljava/util/Iterator;
    //   117: astore #6
    //   119: ldc -2147483648
    //   121: istore_1
    //   122: ldc ''
    //   124: astore_3
    //   125: aload #6
    //   127: invokeinterface hasNext : ()Z
    //   132: ifeq -> 174
    //   135: aload #6
    //   137: invokeinterface next : ()Ljava/lang/Object;
    //   142: checkcast java/lang/String
    //   145: astore #4
    //   147: aload #5
    //   149: aload #4
    //   151: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   154: checkcast java/lang/Integer
    //   157: invokevirtual intValue : ()I
    //   160: istore_2
    //   161: iload_1
    //   162: iload_2
    //   163: if_icmpge -> 125
    //   166: aload #4
    //   168: astore_3
    //   169: iload_2
    //   170: istore_1
    //   171: goto -> 125
    //   174: aload_0
    //   175: monitorexit
    //   176: aload_3
    //   177: areturn
    //   178: astore_3
    //   179: aload_0
    //   180: monitorexit
    //   181: aload_3
    //   182: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	178	finally
    //   21	86	178	finally
    //   89	104	178	finally
    //   107	119	178	finally
    //   125	161	178	finally
  }
  
  static class a {
    private final long a;
    
    private final String b;
    
    private a(long param1Long, String param1String) {
      this.a = param1Long;
      this.b = param1String;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */