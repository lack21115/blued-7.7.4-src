package com.qq.e.comm.plugin.a;

import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.a.b.a;
import com.qq.e.comm.plugin.a.b.b;
import com.qq.e.comm.plugin.a.b.d;
import com.qq.e.comm.plugin.a.c.a;
import com.qq.e.comm.plugin.a.c.b;
import com.qq.e.comm.plugin.a.d.a;
import com.qq.e.comm.plugin.a.d.b;
import com.qq.e.comm.plugin.a.e.a;
import com.qq.e.comm.plugin.j.a.a;
import com.qq.e.comm.plugin.j.a.b;
import com.qq.e.comm.plugin.j.a.c;
import com.qq.e.comm.plugin.j.b;
import com.qq.e.comm.plugin.j.b.f;
import com.qq.e.comm.plugin.j.d;
import com.qq.e.comm.plugin.j.e;
import com.qq.e.comm.plugin.j.f;
import com.qq.e.comm.plugin.util.aj;
import com.qq.e.comm.plugin.util.t;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

class o implements d {
  private final Context a;
  
  private final a b;
  
  private final b c;
  
  private d.a d;
  
  private final c e;
  
  private final Intent f;
  
  private final Lock g;
  
  private Future<Bitmap> h;
  
  private final a i;
  
  private a j;
  
  public o(Context paramContext, c paramc, Intent paramIntent, Lock paramLock) {
    this.a = paramContext;
    this.b = new i();
    this.c = (b)new a();
    this.e = paramc;
    this.f = paramIntent;
    this.i = new a(paramContext, this.e);
    this.i.a((d)new b(this.f, paramc, paramContext));
    this.g = paramLock;
  }
  
  private int a(int paramInt) {
    return (paramInt != 5) ? ((paramInt != 6) ? 0 : 2048) : 1024;
  }
  
  private int a(File paramFile, c paramc) {
    // Byte code:
    //   0: invokestatic a : ()Lcom/qq/e/comm/plugin/a/d/b;
    //   3: aload_0
    //   4: getfield a : Landroid/content/Context;
    //   7: aload_2
    //   8: invokevirtual h : ()Ljava/lang/String;
    //   11: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;)I
    //   14: istore #4
    //   16: new java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial <init> : ()V
    //   23: astore #6
    //   25: aload #6
    //   27: ldc 'check apk status:'
    //   29: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload #6
    //   35: iload #4
    //   37: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload #6
    //   43: invokevirtual toString : ()Ljava/lang/String;
    //   46: invokestatic d : (Ljava/lang/String;)V
    //   49: aload_1
    //   50: invokevirtual exists : ()Z
    //   53: istore #5
    //   55: bipush #8
    //   57: istore_3
    //   58: iload #5
    //   60: ifeq -> 106
    //   63: aload_1
    //   64: aload_2
    //   65: invokevirtual h : ()Ljava/lang/String;
    //   68: aload_0
    //   69: getfield a : Landroid/content/Context;
    //   72: invokestatic a : (Ljava/io/File;Ljava/lang/String;Landroid/content/Context;)Z
    //   75: ifeq -> 98
    //   78: ldc 'apk exist and valid'
    //   80: invokestatic d : (Ljava/lang/String;)V
    //   83: invokestatic a : ()Lcom/qq/e/comm/plugin/a/d/b;
    //   86: aload_2
    //   87: invokevirtual h : ()Ljava/lang/String;
    //   90: bipush #8
    //   92: invokevirtual a : (Ljava/lang/String;I)V
    //   95: goto -> 119
    //   98: aload_1
    //   99: invokevirtual delete : ()Z
    //   102: pop
    //   103: goto -> 114
    //   106: iload #4
    //   108: invokestatic c : (I)Z
    //   111: ifeq -> 119
    //   114: aload_0
    //   115: aload_2
    //   116: invokespecial d : (Lcom/qq/e/comm/plugin/a/c;)V
    //   119: invokestatic a : ()Lcom/qq/e/comm/plugin/a/d/b;
    //   122: aload_0
    //   123: getfield a : Landroid/content/Context;
    //   126: aload_2
    //   127: invokevirtual h : ()Ljava/lang/String;
    //   130: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;)I
    //   133: istore #4
    //   135: new java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial <init> : ()V
    //   142: astore_1
    //   143: aload_1
    //   144: ldc 'after check status is:'
    //   146: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload_1
    //   151: iload #4
    //   153: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_1
    //   158: invokevirtual toString : ()Ljava/lang/String;
    //   161: invokestatic d : (Ljava/lang/String;)V
    //   164: iload #4
    //   166: invokestatic a : (I)Z
    //   169: ifeq -> 175
    //   172: bipush #7
    //   174: ireturn
    //   175: iload #4
    //   177: invokestatic b : (I)Z
    //   180: ifne -> 261
    //   183: iload #4
    //   185: invokestatic c : (I)Z
    //   188: ifeq -> 194
    //   191: bipush #9
    //   193: ireturn
    //   194: iload #4
    //   196: ifne -> 226
    //   199: ldc 'reset download task progress and total'
    //   201: invokestatic d : (Ljava/lang/String;)V
    //   204: aload_2
    //   205: ldc 'progress'
    //   207: iconst_0
    //   208: invokevirtual a : (Ljava/lang/String;I)V
    //   211: invokestatic a : ()Lcom/qq/e/comm/plugin/a/d/b;
    //   214: aload_2
    //   215: invokevirtual h : ()Ljava/lang/String;
    //   218: invokevirtual a : (Ljava/lang/String;)V
    //   221: aload_0
    //   222: iconst_3
    //   223: invokespecial b : (I)V
    //   226: ldc 'set download task to downloading'
    //   228: invokestatic d : (Ljava/lang/String;)V
    //   231: invokestatic a : ()Lcom/qq/e/comm/plugin/a/d/b;
    //   234: aload_2
    //   235: invokevirtual h : ()Ljava/lang/String;
    //   238: iconst_4
    //   239: invokevirtual a : (Ljava/lang/String;I)V
    //   242: aload_2
    //   243: iconst_4
    //   244: invokevirtual a : (I)V
    //   247: aload_0
    //   248: getfield a : Landroid/content/Context;
    //   251: invokestatic a : (Landroid/content/Context;)Lcom/qq/e/comm/plugin/a/t;
    //   254: aload_2
    //   255: invokevirtual b : (Lcom/qq/e/comm/plugin/a/c;)I
    //   258: pop
    //   259: iconst_0
    //   260: istore_3
    //   261: iload_3
    //   262: ireturn
  }
  
  private e a(c paramc, File paramFile) {
    String str = paramc.h();
    f f = new f(paramc.g(), paramFile, this.b.a(), (new b.a()).a(t.a).a());
    this.j = new a(this, str, f) {
        public void a(String param1String, int param1Int1, int param1Int2, long param1Long) {
          if (!TextUtils.isEmpty(this.a)) {
            if (!this.a.equals(param1String))
              return; 
            if (param1Int1 == 32) {
              this.b.d();
              return;
            } 
            if (param1Int1 == 64)
              this.b.e(); 
          } 
        }
      };
    b.a().a(str, this.j);
    a a1 = new a((e)f, (c)new b(paramc.e()));
    a1.a(new f(this, paramc) {
          public void a(long param1Long1, long param1Long2) {
            int i;
            o.a(this.b, param1Long1, param1Long2);
            if (param1Long2 <= 0L) {
              i = 0;
            } else {
              i = (int)(100L * param1Long1 / param1Long2);
            } 
            b.a().a(this.a.h(), i, param1Long2);
            this.a.a("progress", i);
            o.b(this.b, param1Long1, param1Long2);
          }
        });
    return (e)a1;
  }
  
  private void a() {
    Future<Bitmap> future = this.h;
    if (future != null && future.isDone())
      try {
        this.e.a(this.h.get());
        return;
      } catch (Exception exception) {
        return;
      }  
  }
  
  private void a(int paramInt, String paramString) {
    a(paramInt, paramString, (File)null);
  }
  
  private void a(int paramInt, String paramString, File paramFile) {
    d.a a1 = this.d;
    if (a1 != null)
      a1.a(paramInt, paramString, paramFile); 
  }
  
  private void a(long paramLong1, long paramLong2) {
    d.a a1 = this.d;
    if (a1 != null)
      a1.a(paramLong1, paramLong2); 
  }
  
  private void a(c paramc) {
    try {
      this.g.lockInterruptibly();
      GDTLogger.d("download start");
      b(paramc);
    } finally {}
    GDTLogger.d("download stop");
    this.g.unlock();
  }
  
  private void a(c paramc, int paramInt) {
    if (paramInt == 0) {
      paramInt = 8;
    } else if ((d.e(paramInt) && GDTADManager.getInstance().getSM().getInteger("download_pause", 0) == 1) || d.c(paramInt)) {
      paramInt = 32;
    } else if (d.d(paramInt)) {
      paramInt = 64;
    } else {
      paramInt = 16;
    } 
    b.a().a(paramc.h(), paramInt);
    paramc.a(paramInt);
    t.a(this.a).b(paramc);
  }
  
  private Pair<Integer, File> b() {
    File file = aj.h();
    return (file == null) ? new Pair(Integer.valueOf(5), null) : ((!file.exists() && !file.mkdirs()) ? new Pair(Integer.valueOf(6), null) : new Pair(Integer.valueOf(0), file));
  }
  
  private void b(int paramInt) {
    d.a a1 = this.d;
    if (a1 != null)
      a1.a(paramInt); 
  }
  
  private void b(long paramLong1, long paramLong2) {
    c().a(paramLong1, paramLong2);
  }
  
  private void b(c paramc) {
    b(1);
    int i = c(paramc);
    if (i != 0) {
      a(i, "");
      return;
    } 
    Pair<Integer, File> pair = b();
    i = ((Integer)pair.first).intValue();
    if (i != 0) {
      d(a(i));
      a(i, "");
      return;
    } 
    b(2);
    File file = a.a((File)pair.second, paramc);
    i = a(file, paramc);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("check apk file result:");
    stringBuilder1.append(i);
    GDTLogger.d(stringBuilder1.toString());
    if (c(i))
      f(paramc); 
    if (i != 0) {
      a(i, "", file);
      return;
    } 
    b(4);
    d();
    e e = a(paramc, file);
    e.c();
    int j = e.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("download code:");
    stringBuilder2.append(j);
    stringBuilder2.append(",download message:");
    stringBuilder2.append(e.b());
    GDTLogger.d(stringBuilder2.toString());
    if (j == 0) {
      b(6);
      if (a.a(file, paramc.h(), this.a)) {
        a();
        i = 0;
      } else {
        if (file != null && file.exists())
          file.delete(); 
        j = 8;
        i = 12;
      } 
    } else if (d.a(j)) {
      i = 11;
    } else {
      i = 10;
    } 
    b(7);
    if (i != 0)
      paramc.e(String.format("[%d]%s", new Object[] { Integer.valueOf(j), e.b() })); 
    d(j);
    a(paramc, j);
    a(i, "", file);
  }
  
  private int c(c paramc) {
    if (paramc.q()) {
      if (this.c.a(paramc)) {
        e(paramc);
        return 2;
      } 
      if (!this.c.b(paramc))
        return 3; 
    } else if (paramc.r()) {
      return 4;
    } 
    return 0;
  }
  
  private a c() {
    if (this.h == null) {
      this.h = t.a.submit(new h(this.e.i()));
      this.i.a(this.h);
    } 
    return this.i;
  }
  
  private boolean c(int paramInt) {
    return (paramInt != 2 && paramInt != 3 && paramInt != 9 && paramInt != 7 && paramInt != 8);
  }
  
  private void d() {
    c().a();
  }
  
  private void d(int paramInt) {
    if (paramInt == 0) {
      c().b();
      return;
    } 
    if (!d.d(paramInt)) {
      if (d.c(paramInt) || d.e(paramInt)) {
        c().a(e(paramInt));
        return;
      } 
      c().b(e(paramInt));
      return;
    } 
  }
  
  private void d(c paramc) {
    paramc.a("progress", 0);
    b.a().a(paramc.h(), 0, 0L);
    b.a().a(paramc.h(), 0);
    GDTLogger.d("reset progress");
  }
  
  private String e(int paramInt) {
    return d.e(paramInt) ? "连接到运营商网络，暂停下载，点击这里继续！" : (d.c(paramInt) ? "已暂停" : (d.a(paramInt) ? "看起来网络出问题了，快去检查网络正常后点这里重试吧！" : (d.b(paramInt) ? "存储卡不可用或者存储空间不足，快去检查存储卡状态后点这里重试吧！" : "真遗憾，下载失败了，稍后点这里重试吧")));
  }
  
  private void e(c paramc) {
    try {
      t.a(this.a).d(paramc);
      return;
    } catch (SQLException sQLException) {
      return;
    } 
  }
  
  private void f(c paramc) {
    if (paramc.q())
      return; 
    try {
      t t = t.a(this.a);
      c c1 = t.a(paramc.h());
      if (c1 != null) {
        paramc.b(c1.m());
        t.b(paramc);
        return;
      } 
      if (paramc.r()) {
        t.c(paramc);
        return;
      } 
      t.a(paramc);
      return;
    } catch (SQLException sQLException) {
      return;
    } 
  }
  
  public void a(d.a parama) {
    this.d = parama;
  }
  
  public void run() {
    a(this.e);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\a\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */