package com.qq.e.comm.plugin.a;

import android.content.Context;
import android.content.Intent;
import com.qq.e.comm.plugin.a.d.b;
import com.qq.e.comm.plugin.a.d.d;
import java.util.List;

class k {
  private final Context a;
  
  private final t b;
  
  k(Context paramContext) {
    this.a = paramContext;
    this.b = t.a(this.a);
  }
  
  private void a(c paramc, int paramInt) {
    paramc.a(paramInt);
    this.b.b(paramc);
  }
  
  private void a(c paramc, int paramInt1, int paramInt2) {
    paramc.a("manualPause", paramInt2);
    a(paramc, paramInt1);
  }
  
  private void a(c paramc, t paramt, int paramInt, long paramLong) {
    paramc.a("totalSize", paramLong);
    paramc.a("progress", paramInt);
    paramt.b(paramc);
  }
  
  int a(c paramc) {
    return this.b.b(paramc);
  }
  
  boolean a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_2
    //   4: aload_0
    //   5: getfield b : Lcom/qq/e/comm/plugin/a/t;
    //   8: invokevirtual a : ()Ljava/util/List;
    //   11: astore_3
    //   12: aload_3
    //   13: invokeinterface iterator : ()Ljava/util/Iterator;
    //   18: astore #4
    //   20: aload #4
    //   22: invokeinterface hasNext : ()Z
    //   27: ifeq -> 119
    //   30: aload #4
    //   32: invokeinterface next : ()Ljava/lang/Object;
    //   37: checkcast com/qq/e/comm/plugin/a/c
    //   40: astore #5
    //   42: aload #5
    //   44: invokevirtual o : ()I
    //   47: bipush #8
    //   49: if_icmpeq -> 20
    //   52: invokestatic a : ()Lcom/qq/e/comm/plugin/a/d/b;
    //   55: aload_0
    //   56: getfield a : Landroid/content/Context;
    //   59: aload #5
    //   61: invokevirtual h : ()Ljava/lang/String;
    //   64: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;)I
    //   67: invokestatic c : (I)Z
    //   70: ifeq -> 84
    //   73: aload_0
    //   74: aload #5
    //   76: bipush #8
    //   78: invokespecial a : (Lcom/qq/e/comm/plugin/a/c;I)V
    //   81: goto -> 20
    //   84: aload #5
    //   86: iconst_1
    //   87: invokevirtual d : (I)V
    //   90: aload_0
    //   91: getfield a : Landroid/content/Context;
    //   94: aload #5
    //   96: invokestatic a : (Landroid/content/Context;Lcom/qq/e/comm/plugin/a/c;)Landroid/content/Intent;
    //   99: astore #5
    //   101: aload #5
    //   103: ifnull -> 20
    //   106: aload_0
    //   107: getfield a : Landroid/content/Context;
    //   110: aload #5
    //   112: invokevirtual startService : (Landroid/content/Intent;)Landroid/content/ComponentName;
    //   115: pop
    //   116: goto -> 20
    //   119: iconst_1
    //   120: istore_2
    //   121: goto -> 189
    //   124: astore #4
    //   126: goto -> 133
    //   129: astore #4
    //   131: aconst_null
    //   132: astore_3
    //   133: aload #4
    //   135: invokevirtual toString : ()Ljava/lang/String;
    //   138: astore #4
    //   140: aload #4
    //   142: invokestatic e : (Ljava/lang/String;)V
    //   145: new com/qq/e/comm/plugin/y/d
    //   148: dup
    //   149: invokespecial <init> : ()V
    //   152: astore #5
    //   154: aload #5
    //   156: ldc 'msg'
    //   158: aload #4
    //   160: invokevirtual a : (Ljava/lang/String;Ljava/lang/Object;)Lcom/qq/e/comm/plugin/y/d;
    //   163: pop
    //   164: aload_3
    //   165: ifnonnull -> 173
    //   168: iconst_0
    //   169: istore_1
    //   170: goto -> 180
    //   173: aload_3
    //   174: invokeinterface size : ()I
    //   179: istore_1
    //   180: ldc 100262
    //   182: iload_1
    //   183: aconst_null
    //   184: aload #5
    //   186: invokestatic a : (IILcom/qq/e/comm/plugin/y/c;Lcom/qq/e/comm/plugin/y/d;)V
    //   189: aload_0
    //   190: monitorexit
    //   191: iload_2
    //   192: ireturn
    //   193: astore_3
    //   194: aload_3
    //   195: athrow
    //   196: astore_3
    //   197: aload_0
    //   198: monitorexit
    //   199: aload_3
    //   200: athrow
    // Exception table:
    //   from	to	target	type
    //   4	12	129	finally
    //   12	20	124	finally
    //   20	81	124	finally
    //   84	101	124	finally
    //   106	116	124	finally
    //   133	164	193	finally
    //   173	180	193	finally
    //   180	189	193	finally
    //   194	196	196	finally
  }
  
  boolean a(int paramInt) {
    try {
      c c = this.b.c(paramInt);
      if (c != null && c.o() != 8) {
        if (d.c(b.a().a(this.a, c.h()))) {
          a(c, 8);
        } else {
          b.a().a(c.h(), 128);
          c.a(128);
          Intent intent = j.a(this.a, c);
          if (intent != null)
            this.a.startService(intent); 
        } 
        return true;
      } 
    } finally {
      Exception exception;
    } 
    return false;
  }
  
  boolean a(int paramInt1, int paramInt2) {
    try {
      c c = this.b.b(paramInt1);
      return false;
    } finally {
      null = null;
    } 
  }
  
  boolean a(int paramInt1, int paramInt2, long paramLong) {
    try {
      c c = this.b.a(paramInt1);
      return false;
    } finally {
      null = null;
    } 
  }
  
  boolean a(int paramInt1, String paramString, int paramInt2) {
    try {
      c c = this.b.a(paramInt1);
      return true;
    } finally {
      paramString = null;
    } 
  }
  
  List<c> b() {
    return this.b.b();
  }
  
  List<c> c() {
    return this.b.c();
  }
  
  List<c> d() {
    return this.b.d();
  }
  
  public List<c> e() {
    return this.b.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */