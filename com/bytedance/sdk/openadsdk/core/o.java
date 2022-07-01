package com.bytedance.sdk.openadsdk.core;

import android.app.Application;
import android.content.Context;
import com.bytedance.sdk.openadsdk.c.b;
import com.bytedance.sdk.openadsdk.c.e;
import com.bytedance.sdk.openadsdk.c.g;
import com.bytedance.sdk.openadsdk.c.l;
import com.bytedance.sdk.openadsdk.c.n;
import com.bytedance.sdk.openadsdk.core.h.k;
import com.bytedance.sdk.openadsdk.core.h.l;
import com.bytedance.sdk.openadsdk.f.b.c;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.w;
import java.lang.reflect.Method;

public class o {
  private static volatile b<com.bytedance.sdk.openadsdk.c.a> a;
  
  private static volatile b<c.a> b;
  
  private static volatile b<c.a> c;
  
  private static volatile p<com.bytedance.sdk.openadsdk.c.a> d;
  
  private static volatile com.bytedance.sdk.openadsdk.j.a e;
  
  private static volatile com.bytedance.sdk.openadsdk.f.b.a f;
  
  private static volatile Context g;
  
  private static volatile l h;
  
  private static volatile k i;
  
  public static Context a() {
    if (g == null)
      a(null); 
    return g;
  }
  
  public static b<c.a> a(String paramString1, String paramString2, boolean paramBoolean) {
    g.b b1;
    l l1;
    if (paramBoolean) {
      n n = new n(g);
      b1 = g.b.a();
    } else {
      b1 = g.b.b();
      l1 = new l(g);
    } 
    g.a a1 = b(g);
    return new b((e)l1, null, b1, a1, (g)new com.bytedance.sdk.openadsdk.c.o(paramString1, paramString2, (e)l1, null, b1, a1));
  }
  
  public static void a(Context paramContext) {
    // Byte code:
    //   0: ldc com/bytedance/sdk/openadsdk/core/o
    //   2: monitorenter
    //   3: getstatic com/bytedance/sdk/openadsdk/core/o.g : Landroid/content/Context;
    //   6: ifnonnull -> 46
    //   9: invokestatic a : ()Landroid/app/Application;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull -> 35
    //   17: invokestatic a : ()Landroid/app/Application;
    //   20: putstatic com/bytedance/sdk/openadsdk/core/o.g : Landroid/content/Context;
    //   23: getstatic com/bytedance/sdk/openadsdk/core/o.g : Landroid/content/Context;
    //   26: astore_1
    //   27: aload_1
    //   28: ifnull -> 35
    //   31: ldc com/bytedance/sdk/openadsdk/core/o
    //   33: monitorexit
    //   34: return
    //   35: aload_0
    //   36: ifnull -> 46
    //   39: aload_0
    //   40: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   43: putstatic com/bytedance/sdk/openadsdk/core/o.g : Landroid/content/Context;
    //   46: ldc com/bytedance/sdk/openadsdk/core/o
    //   48: monitorexit
    //   49: return
    //   50: astore_0
    //   51: ldc com/bytedance/sdk/openadsdk/core/o
    //   53: monitorexit
    //   54: aload_0
    //   55: athrow
    //   56: astore_1
    //   57: goto -> 35
    // Exception table:
    //   from	to	target	type
    //   3	13	50	finally
    //   17	27	56	finally
    //   39	46	50	finally
  }
  
  private static g.a b(Context paramContext) {
    return new g.a(paramContext) {
        public boolean a() {
          Context context2 = this.a;
          Context context1 = context2;
          if (context2 == null)
            context1 = o.a(); 
          return w.a(context1);
        }
      };
  }
  
  public static void b() {
    a = null;
    e = null;
    f = null;
  }
  
  public static b<com.bytedance.sdk.openadsdk.c.a> c() {
    // Byte code:
    //   0: invokestatic a : ()Z
    //   3: ifne -> 10
    //   6: invokestatic c : ()Lcom/bytedance/sdk/openadsdk/c/b$a;
    //   9: areturn
    //   10: getstatic com/bytedance/sdk/openadsdk/core/o.a : Lcom/bytedance/sdk/openadsdk/c/b;
    //   13: ifnonnull -> 88
    //   16: ldc com/bytedance/sdk/openadsdk/core/o
    //   18: monitorenter
    //   19: getstatic com/bytedance/sdk/openadsdk/core/o.a : Lcom/bytedance/sdk/openadsdk/c/b;
    //   22: ifnonnull -> 76
    //   25: invokestatic b : ()Z
    //   28: ifeq -> 44
    //   31: new com/bytedance/sdk/openadsdk/c/c
    //   34: dup
    //   35: invokespecial <init> : ()V
    //   38: putstatic com/bytedance/sdk/openadsdk/core/o.a : Lcom/bytedance/sdk/openadsdk/c/b;
    //   41: goto -> 76
    //   44: new com/bytedance/sdk/openadsdk/c/b
    //   47: dup
    //   48: new com/bytedance/sdk/openadsdk/c/f
    //   51: dup
    //   52: getstatic com/bytedance/sdk/openadsdk/core/o.g : Landroid/content/Context;
    //   55: invokespecial <init> : (Landroid/content/Context;)V
    //   58: invokestatic f : ()Lcom/bytedance/sdk/openadsdk/core/p;
    //   61: invokestatic k : ()Lcom/bytedance/sdk/openadsdk/c/g$b;
    //   64: getstatic com/bytedance/sdk/openadsdk/core/o.g : Landroid/content/Context;
    //   67: invokestatic b : (Landroid/content/Context;)Lcom/bytedance/sdk/openadsdk/c/g$a;
    //   70: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/c/e;Lcom/bytedance/sdk/openadsdk/core/p;Lcom/bytedance/sdk/openadsdk/c/g$b;Lcom/bytedance/sdk/openadsdk/c/g$a;)V
    //   73: putstatic com/bytedance/sdk/openadsdk/core/o.a : Lcom/bytedance/sdk/openadsdk/c/b;
    //   76: ldc com/bytedance/sdk/openadsdk/core/o
    //   78: monitorexit
    //   79: goto -> 88
    //   82: astore_0
    //   83: ldc com/bytedance/sdk/openadsdk/core/o
    //   85: monitorexit
    //   86: aload_0
    //   87: athrow
    //   88: getstatic com/bytedance/sdk/openadsdk/core/o.a : Lcom/bytedance/sdk/openadsdk/c/b;
    //   91: areturn
    // Exception table:
    //   from	to	target	type
    //   19	41	82	finally
    //   44	76	82	finally
    //   76	79	82	finally
    //   83	86	82	finally
  }
  
  public static b<c.a> d() {
    // Byte code:
    //   0: invokestatic a : ()Z
    //   3: ifne -> 10
    //   6: invokestatic d : ()Lcom/bytedance/sdk/openadsdk/c/b$b;
    //   9: areturn
    //   10: getstatic com/bytedance/sdk/openadsdk/core/o.c : Lcom/bytedance/sdk/openadsdk/c/b;
    //   13: ifnonnull -> 68
    //   16: ldc com/bytedance/sdk/openadsdk/core/o
    //   18: monitorenter
    //   19: getstatic com/bytedance/sdk/openadsdk/core/o.c : Lcom/bytedance/sdk/openadsdk/c/b;
    //   22: ifnonnull -> 56
    //   25: invokestatic b : ()Z
    //   28: ifeq -> 45
    //   31: new com/bytedance/sdk/openadsdk/c/m
    //   34: dup
    //   35: iconst_0
    //   36: invokespecial <init> : (Z)V
    //   39: putstatic com/bytedance/sdk/openadsdk/core/o.c : Lcom/bytedance/sdk/openadsdk/c/b;
    //   42: goto -> 56
    //   45: ldc 'ttad_bk_batch_stats'
    //   47: ldc 'AdStatsEventBatchThread'
    //   49: iconst_0
    //   50: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Z)Lcom/bytedance/sdk/openadsdk/c/b;
    //   53: putstatic com/bytedance/sdk/openadsdk/core/o.c : Lcom/bytedance/sdk/openadsdk/c/b;
    //   56: ldc com/bytedance/sdk/openadsdk/core/o
    //   58: monitorexit
    //   59: goto -> 68
    //   62: astore_0
    //   63: ldc com/bytedance/sdk/openadsdk/core/o
    //   65: monitorexit
    //   66: aload_0
    //   67: athrow
    //   68: getstatic com/bytedance/sdk/openadsdk/core/o.c : Lcom/bytedance/sdk/openadsdk/c/b;
    //   71: areturn
    // Exception table:
    //   from	to	target	type
    //   19	42	62	finally
    //   45	56	62	finally
    //   56	59	62	finally
    //   63	66	62	finally
  }
  
  public static b<c.a> e() {
    // Byte code:
    //   0: invokestatic a : ()Z
    //   3: ifne -> 10
    //   6: invokestatic d : ()Lcom/bytedance/sdk/openadsdk/c/b$b;
    //   9: areturn
    //   10: getstatic com/bytedance/sdk/openadsdk/core/o.b : Lcom/bytedance/sdk/openadsdk/c/b;
    //   13: ifnonnull -> 68
    //   16: ldc com/bytedance/sdk/openadsdk/core/o
    //   18: monitorenter
    //   19: getstatic com/bytedance/sdk/openadsdk/core/o.b : Lcom/bytedance/sdk/openadsdk/c/b;
    //   22: ifnonnull -> 56
    //   25: invokestatic b : ()Z
    //   28: ifeq -> 45
    //   31: new com/bytedance/sdk/openadsdk/c/m
    //   34: dup
    //   35: iconst_1
    //   36: invokespecial <init> : (Z)V
    //   39: putstatic com/bytedance/sdk/openadsdk/core/o.b : Lcom/bytedance/sdk/openadsdk/c/b;
    //   42: goto -> 56
    //   45: ldc 'ttad_bk_stats'
    //   47: ldc 'AdStatsEventThread'
    //   49: iconst_1
    //   50: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Z)Lcom/bytedance/sdk/openadsdk/c/b;
    //   53: putstatic com/bytedance/sdk/openadsdk/core/o.b : Lcom/bytedance/sdk/openadsdk/c/b;
    //   56: ldc com/bytedance/sdk/openadsdk/core/o
    //   58: monitorexit
    //   59: goto -> 68
    //   62: astore_0
    //   63: ldc com/bytedance/sdk/openadsdk/core/o
    //   65: monitorexit
    //   66: aload_0
    //   67: athrow
    //   68: getstatic com/bytedance/sdk/openadsdk/core/o.b : Lcom/bytedance/sdk/openadsdk/c/b;
    //   71: areturn
    // Exception table:
    //   from	to	target	type
    //   19	42	62	finally
    //   45	56	62	finally
    //   56	59	62	finally
    //   63	66	62	finally
  }
  
  public static p<com.bytedance.sdk.openadsdk.c.a> f() {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/core/o.d : Lcom/bytedance/sdk/openadsdk/core/p;
    //   3: ifnonnull -> 40
    //   6: ldc com/bytedance/sdk/openadsdk/core/o
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/core/o.d : Lcom/bytedance/sdk/openadsdk/core/p;
    //   12: ifnonnull -> 28
    //   15: new com/bytedance/sdk/openadsdk/core/q
    //   18: dup
    //   19: getstatic com/bytedance/sdk/openadsdk/core/o.g : Landroid/content/Context;
    //   22: invokespecial <init> : (Landroid/content/Context;)V
    //   25: putstatic com/bytedance/sdk/openadsdk/core/o.d : Lcom/bytedance/sdk/openadsdk/core/p;
    //   28: ldc com/bytedance/sdk/openadsdk/core/o
    //   30: monitorexit
    //   31: goto -> 40
    //   34: astore_0
    //   35: ldc com/bytedance/sdk/openadsdk/core/o
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    //   40: getstatic com/bytedance/sdk/openadsdk/core/o.d : Lcom/bytedance/sdk/openadsdk/core/p;
    //   43: areturn
    // Exception table:
    //   from	to	target	type
    //   9	28	34	finally
    //   28	31	34	finally
    //   35	38	34	finally
  }
  
  public static com.bytedance.sdk.openadsdk.j.a g() {
    // Byte code:
    //   0: invokestatic a : ()Z
    //   3: ifne -> 10
    //   6: invokestatic c : ()Lcom/bytedance/sdk/openadsdk/j/a;
    //   9: areturn
    //   10: getstatic com/bytedance/sdk/openadsdk/core/o.e : Lcom/bytedance/sdk/openadsdk/j/a;
    //   13: ifnonnull -> 79
    //   16: ldc com/bytedance/sdk/openadsdk/j/a
    //   18: monitorenter
    //   19: getstatic com/bytedance/sdk/openadsdk/core/o.e : Lcom/bytedance/sdk/openadsdk/j/a;
    //   22: ifnonnull -> 67
    //   25: invokestatic b : ()Z
    //   28: ifeq -> 44
    //   31: new com/bytedance/sdk/openadsdk/j/c
    //   34: dup
    //   35: invokespecial <init> : ()V
    //   38: putstatic com/bytedance/sdk/openadsdk/core/o.e : Lcom/bytedance/sdk/openadsdk/j/a;
    //   41: goto -> 67
    //   44: new com/bytedance/sdk/openadsdk/j/b
    //   47: dup
    //   48: getstatic com/bytedance/sdk/openadsdk/core/o.g : Landroid/content/Context;
    //   51: new com/bytedance/sdk/openadsdk/j/g
    //   54: dup
    //   55: getstatic com/bytedance/sdk/openadsdk/core/o.g : Landroid/content/Context;
    //   58: invokespecial <init> : (Landroid/content/Context;)V
    //   61: invokespecial <init> : (Landroid/content/Context;Lcom/bytedance/sdk/openadsdk/j/f;)V
    //   64: putstatic com/bytedance/sdk/openadsdk/core/o.e : Lcom/bytedance/sdk/openadsdk/j/a;
    //   67: ldc com/bytedance/sdk/openadsdk/j/a
    //   69: monitorexit
    //   70: goto -> 79
    //   73: astore_0
    //   74: ldc com/bytedance/sdk/openadsdk/j/a
    //   76: monitorexit
    //   77: aload_0
    //   78: athrow
    //   79: getstatic com/bytedance/sdk/openadsdk/core/o.e : Lcom/bytedance/sdk/openadsdk/j/a;
    //   82: areturn
    // Exception table:
    //   from	to	target	type
    //   19	41	73	finally
    //   44	67	73	finally
    //   67	70	73	finally
    //   74	77	73	finally
  }
  
  public static l h() {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/core/o.h : Lcom/bytedance/sdk/openadsdk/core/h/l;
    //   3: ifnonnull -> 37
    //   6: ldc com/bytedance/sdk/openadsdk/core/h/l
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/core/o.h : Lcom/bytedance/sdk/openadsdk/core/h/l;
    //   12: ifnonnull -> 25
    //   15: new com/bytedance/sdk/openadsdk/core/h/l
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bytedance/sdk/openadsdk/core/o.h : Lcom/bytedance/sdk/openadsdk/core/h/l;
    //   25: ldc com/bytedance/sdk/openadsdk/core/h/l
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/bytedance/sdk/openadsdk/core/h/l
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/bytedance/sdk/openadsdk/core/o.h : Lcom/bytedance/sdk/openadsdk/core/h/l;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public static k i() {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/core/o.i : Lcom/bytedance/sdk/openadsdk/core/h/k;
    //   3: ifnonnull -> 43
    //   6: ldc com/bytedance/sdk/openadsdk/core/h/l
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/core/o.i : Lcom/bytedance/sdk/openadsdk/core/h/k;
    //   12: ifnonnull -> 31
    //   15: new com/bytedance/sdk/openadsdk/core/h/k
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bytedance/sdk/openadsdk/core/o.i : Lcom/bytedance/sdk/openadsdk/core/h/k;
    //   25: getstatic com/bytedance/sdk/openadsdk/core/o.i : Lcom/bytedance/sdk/openadsdk/core/h/k;
    //   28: invokevirtual b : ()V
    //   31: ldc com/bytedance/sdk/openadsdk/core/h/l
    //   33: monitorexit
    //   34: goto -> 43
    //   37: astore_0
    //   38: ldc com/bytedance/sdk/openadsdk/core/h/l
    //   40: monitorexit
    //   41: aload_0
    //   42: athrow
    //   43: getstatic com/bytedance/sdk/openadsdk/core/o.i : Lcom/bytedance/sdk/openadsdk/core/h/k;
    //   46: areturn
    // Exception table:
    //   from	to	target	type
    //   9	31	37	finally
    //   31	34	37	finally
    //   38	41	37	finally
  }
  
  public static com.bytedance.sdk.openadsdk.f.b.a j() {
    // Byte code:
    //   0: invokestatic a : ()Z
    //   3: ifne -> 10
    //   6: invokestatic c : ()Lcom/bytedance/sdk/openadsdk/f/b/a;
    //   9: areturn
    //   10: getstatic com/bytedance/sdk/openadsdk/core/o.f : Lcom/bytedance/sdk/openadsdk/f/b/a;
    //   13: ifnonnull -> 66
    //   16: ldc com/bytedance/sdk/openadsdk/f/b/c
    //   18: monitorenter
    //   19: getstatic com/bytedance/sdk/openadsdk/core/o.f : Lcom/bytedance/sdk/openadsdk/f/b/a;
    //   22: ifnonnull -> 54
    //   25: invokestatic b : ()Z
    //   28: ifeq -> 44
    //   31: new com/bytedance/sdk/openadsdk/f/b/d
    //   34: dup
    //   35: invokespecial <init> : ()V
    //   38: putstatic com/bytedance/sdk/openadsdk/core/o.f : Lcom/bytedance/sdk/openadsdk/f/b/a;
    //   41: goto -> 54
    //   44: new com/bytedance/sdk/openadsdk/f/b/c
    //   47: dup
    //   48: invokespecial <init> : ()V
    //   51: putstatic com/bytedance/sdk/openadsdk/core/o.f : Lcom/bytedance/sdk/openadsdk/f/b/a;
    //   54: ldc com/bytedance/sdk/openadsdk/f/b/c
    //   56: monitorexit
    //   57: goto -> 66
    //   60: astore_0
    //   61: ldc com/bytedance/sdk/openadsdk/f/b/c
    //   63: monitorexit
    //   64: aload_0
    //   65: athrow
    //   66: getstatic com/bytedance/sdk/openadsdk/core/o.f : Lcom/bytedance/sdk/openadsdk/f/b/a;
    //   69: areturn
    // Exception table:
    //   from	to	target	type
    //   19	41	60	finally
    //   44	54	60	finally
    //   54	57	60	finally
    //   61	64	60	finally
  }
  
  private static g.b k() {
    return g.b.a();
  }
  
  static class a {
    private static volatile Application a;
    
    static {
      try {
        Object object = b();
        return;
      } finally {
        Exception exception = null;
        t.c("MyApplication", "application get failed", exception);
      } 
    }
    
    public static Application a() {
      return a;
    }
    
    private static Object b() {
      try {
        return method.invoke((Object)null, new Object[0]);
      } finally {
        Exception exception = null;
        t.c("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", exception);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */