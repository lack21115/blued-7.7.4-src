package com.bytedance.sdk.openadsdk.f.b;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.o;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class b {
  private static volatile b a;
  
  private Context b;
  
  private AtomicBoolean c = new AtomicBoolean(false);
  
  private b() {
    b();
  }
  
  public static b a() {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/f/b/b.a : Lcom/bytedance/sdk/openadsdk/f/b/b;
    //   3: ifnonnull -> 37
    //   6: ldc com/bytedance/sdk/openadsdk/f/b/b
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/f/b/b.a : Lcom/bytedance/sdk/openadsdk/f/b/b;
    //   12: ifnonnull -> 25
    //   15: new com/bytedance/sdk/openadsdk/f/b/b
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bytedance/sdk/openadsdk/f/b/b.a : Lcom/bytedance/sdk/openadsdk/f/b/b;
    //   25: ldc com/bytedance/sdk/openadsdk/f/b/b
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/bytedance/sdk/openadsdk/f/b/b
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/bytedance/sdk/openadsdk/f/b/b.a : Lcom/bytedance/sdk/openadsdk/f/b/b;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void b() {
    if (this.c.get())
      return; 
    if (o.a() == null)
      return; 
    this.b = o.a();
    this.c.set(true);
  }
  
  public void c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: invokevirtual get : ()Z
    //   9: ifne -> 19
    //   12: aload_0
    //   13: invokevirtual b : ()V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: getfield b : Landroid/content/Context;
    //   23: ldc 'logstats'
    //   25: ldc 'retry >=?'
    //   27: iconst_1
    //   28: anewarray java/lang/String
    //   31: dup
    //   32: iconst_0
    //   33: iconst_5
    //   34: invokestatic valueOf : (I)Ljava/lang/String;
    //   37: aastore
    //   38: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   41: pop
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: goto -> 42
    // Exception table:
    //   from	to	target	type
    //   2	16	45	finally
    //   19	42	50	finally
  }
  
  public List<c.a> d() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/util/LinkedList
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_2
    //   10: aload_0
    //   11: getfield c : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   14: invokevirtual get : ()Z
    //   17: ifne -> 28
    //   20: aload_0
    //   21: invokevirtual b : ()V
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_2
    //   27: areturn
    //   28: aload_0
    //   29: getfield b : Landroid/content/Context;
    //   32: ldc 'logstats'
    //   34: iconst_2
    //   35: anewarray java/lang/String
    //   38: dup
    //   39: iconst_0
    //   40: ldc 'id'
    //   42: aastore
    //   43: dup
    //   44: iconst_1
    //   45: ldc 'value'
    //   47: aastore
    //   48: ldc 'retry <?'
    //   50: iconst_1
    //   51: anewarray java/lang/String
    //   54: dup
    //   55: iconst_0
    //   56: iconst_5
    //   57: invokestatic valueOf : (I)Ljava/lang/String;
    //   60: aastore
    //   61: aconst_null
    //   62: aconst_null
    //   63: aconst_null
    //   64: invokestatic a : (Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   67: astore_1
    //   68: aload_1
    //   69: ifnull -> 165
    //   72: aload_1
    //   73: invokeinterface moveToNext : ()Z
    //   78: ifeq -> 139
    //   81: aload_1
    //   82: aload_1
    //   83: ldc 'id'
    //   85: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   90: invokeinterface getString : (I)Ljava/lang/String;
    //   95: astore_3
    //   96: aload_1
    //   97: aload_1
    //   98: ldc 'value'
    //   100: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   105: invokeinterface getString : (I)Ljava/lang/String;
    //   110: astore #4
    //   112: aload_2
    //   113: new com/bytedance/sdk/openadsdk/f/b/c$a
    //   116: dup
    //   117: aload_3
    //   118: new org/json/JSONObject
    //   121: dup
    //   122: aload #4
    //   124: invokespecial <init> : (Ljava/lang/String;)V
    //   127: invokespecial <init> : (Ljava/lang/String;Lorg/json/JSONObject;)V
    //   130: invokeinterface add : (Ljava/lang/Object;)Z
    //   135: pop
    //   136: goto -> 72
    //   139: aload_1
    //   140: ifnull -> 165
    //   143: aload_1
    //   144: invokeinterface close : ()V
    //   149: goto -> 165
    //   152: astore_2
    //   153: aload_1
    //   154: ifnull -> 163
    //   157: aload_1
    //   158: invokeinterface close : ()V
    //   163: aload_2
    //   164: athrow
    //   165: aload_0
    //   166: monitorexit
    //   167: aload_2
    //   168: areturn
    //   169: astore_1
    //   170: aload_0
    //   171: monitorexit
    //   172: aload_1
    //   173: athrow
    //   174: astore_3
    //   175: goto -> 72
    // Exception table:
    //   from	to	target	type
    //   2	24	169	finally
    //   28	68	169	finally
    //   72	112	152	finally
    //   112	136	174	java/lang/Exception
    //   112	136	152	finally
    //   143	149	169	finally
    //   157	163	169	finally
    //   163	165	169	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\f\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */