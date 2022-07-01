package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import android.os.Build;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.a;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.common.strategy.a;
import com.tencent.bugly.crashreport.crash.anr.b;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class c {
  public static int a = 0;
  
  public static boolean b = false;
  
  public static int c = 2;
  
  public static boolean d = true;
  
  public static int e = 20480;
  
  public static int f = 20480;
  
  public static long g = 604800000L;
  
  public static String h;
  
  public static boolean i = false;
  
  public static String j;
  
  public static int k = 5000;
  
  public static boolean l = true;
  
  public static boolean m = false;
  
  public static String n;
  
  public static String o;
  
  private static c r;
  
  public final b p;
  
  private final Context q;
  
  private final e s;
  
  private final NativeCrashHandler t;
  
  private a u;
  
  private w v;
  
  private final b w;
  
  private Boolean x;
  
  private int y = 31;
  
  private boolean z = false;
  
  private c(int paramInt, Context paramContext, w paramw, boolean paramBoolean, BuglyStrategy.a parama, o paramo, String paramString) {
    a = paramInt;
    paramContext = z.a(paramContext);
    this.q = paramContext;
    this.u = a.a();
    this.v = paramw;
    this.p = new b(paramInt, paramContext, u.a(), p.a(), this.u, parama, paramo);
    a a1 = a.a(paramContext);
    this.s = new e(paramContext, this.p, this.u, a1);
    this.t = NativeCrashHandler.getInstance(paramContext, a1, this.p, this.u, paramw, paramBoolean, paramString);
    a1.F = (a)this.t;
    this.w = new b(paramContext, this.u, a1, paramw, this.p);
  }
  
  public static c a() {
    // Byte code:
    //   0: ldc com/tencent/bugly/crashreport/crash/c
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/crashreport/crash/c.r : Lcom/tencent/bugly/crashreport/crash/c;
    //   6: astore_0
    //   7: ldc com/tencent/bugly/crashreport/crash/c
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/tencent/bugly/crashreport/crash/c
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static c a(int paramInt, Context paramContext, boolean paramBoolean, BuglyStrategy.a parama, o paramo, String paramString) {
    // Byte code:
    //   0: ldc com/tencent/bugly/crashreport/crash/c
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/crashreport/crash/c.r : Lcom/tencent/bugly/crashreport/crash/c;
    //   6: ifnonnull -> 30
    //   9: new com/tencent/bugly/crashreport/crash/c
    //   12: dup
    //   13: sipush #1004
    //   16: aload_1
    //   17: invokestatic a : ()Lcom/tencent/bugly/proguard/w;
    //   20: iload_2
    //   21: aload_3
    //   22: aconst_null
    //   23: aconst_null
    //   24: invokespecial <init> : (ILandroid/content/Context;Lcom/tencent/bugly/proguard/w;ZLcom/tencent/bugly/BuglyStrategy$a;Lcom/tencent/bugly/proguard/o;Ljava/lang/String;)V
    //   27: putstatic com/tencent/bugly/crashreport/crash/c.r : Lcom/tencent/bugly/crashreport/crash/c;
    //   30: getstatic com/tencent/bugly/crashreport/crash/c.r : Lcom/tencent/bugly/crashreport/crash/c;
    //   33: astore_1
    //   34: ldc com/tencent/bugly/crashreport/crash/c
    //   36: monitorexit
    //   37: aload_1
    //   38: areturn
    //   39: astore_1
    //   40: ldc com/tencent/bugly/crashreport/crash/c
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Exception table:
    //   from	to	target	type
    //   3	30	39	finally
    //   30	34	39	finally
  }
  
  public final void a(int paramInt) {
    this.y = paramInt;
  }
  
  public final void a(long paramLong) {
    w.a().a(new Thread(this) {
          public final void run() {
            if (!z.a(c.b(this.a), "local_crash_lock", 10000L))
              return; 
            List<CrashDetailBean> list = this.a.p.a();
            if (list != null && list.size() > 0) {
              int j = list.size();
              int i = 0;
              x.c("Size of crash list: %s", new Object[] { Integer.valueOf(j) });
              j = list.size();
              if (j > 20L) {
                ArrayList<CrashDetailBean> arrayList = new ArrayList();
                Collections.sort(list);
                while (i < 20L) {
                  arrayList.add(list.get(j - 1 - i));
                  i++;
                } 
                list = arrayList;
              } 
              this.a.p.a(list, 0L, false, false, false);
            } 
            z.b(c.b(this.a), "local_crash_lock");
          }
        }paramLong);
  }
  
  public final void a(StrategyBean paramStrategyBean) {
    this.s.a(paramStrategyBean);
    this.t.onStrategyChanged(paramStrategyBean);
    this.w.c();
    w.a().a(new Thread(this) {
          public final void run() {
            if (!z.a(c.b(this.a), "local_crash_lock", 10000L))
              return; 
            List<CrashDetailBean> list = this.a.p.a();
            if (list != null && list.size() > 0) {
              int j = list.size();
              int i = 0;
              x.c("Size of crash list: %s", new Object[] { Integer.valueOf(j) });
              j = list.size();
              if (j > 20L) {
                ArrayList<CrashDetailBean> arrayList = new ArrayList();
                Collections.sort(list);
                while (i < 20L) {
                  arrayList.add(list.get(j - 1 - i));
                  i++;
                } 
                list = arrayList;
              } 
              this.a.p.a(list, 0L, false, false, false);
            } 
            z.b(c.b(this.a), "local_crash_lock");
          }
        }3000L);
  }
  
  public final void a(CrashDetailBean paramCrashDetailBean) {
    this.p.e(paramCrashDetailBean);
  }
  
  public final void a(Thread paramThread, Throwable paramThrowable, boolean paramBoolean1, String paramString, byte[] paramArrayOfbyte, boolean paramBoolean2) {
    this.v.a(new Runnable(this, false, paramThread, paramThrowable, null, null, paramBoolean2) {
          public final void run() {
            try {
              return;
            } finally {
              Exception exception = null;
              if (x.b(exception) != true)
                exception.printStackTrace(); 
              x.e("java catch error: %s", new Object[] { this.c.toString() });
            } 
          }
        });
  }
  
  public final void a(boolean paramBoolean) {
    this.z = paramBoolean;
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield t : Lcom/tencent/bugly/crashreport/crash/jni/NativeCrashHandler;
    //   6: iload_1
    //   7: iload_2
    //   8: iload_3
    //   9: invokevirtual testNativeCrash : (ZZZ)V
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: astore #4
    //   17: aload_0
    //   18: monitorexit
    //   19: aload #4
    //   21: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	15	finally
  }
  
  public final boolean b() {
    Boolean bool = this.x;
    if (bool != null)
      return bool.booleanValue(); 
    String str = (a.b()).d;
    List list = p.a().a(1);
    ArrayList<r> arrayList = new ArrayList();
    if (list != null && list.size() > 0) {
      for (r r : list) {
        if (str.equals(r.c)) {
          this.x = Boolean.valueOf(true);
          arrayList.add(r);
        } 
      } 
      if (arrayList.size() > 0)
        p.a().a(arrayList); 
      return true;
    } 
    this.x = Boolean.valueOf(false);
    return false;
  }
  
  public final void c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield s : Lcom/tencent/bugly/crashreport/crash/e;
    //   6: invokevirtual a : ()V
    //   9: aload_0
    //   10: getfield t : Lcom/tencent/bugly/crashreport/crash/jni/NativeCrashHandler;
    //   13: iconst_1
    //   14: invokevirtual setUserOpened : (Z)V
    //   17: getstatic android/os/Build$VERSION.SDK_INT : I
    //   20: bipush #19
    //   22: if_icmpgt -> 36
    //   25: aload_0
    //   26: getfield w : Lcom/tencent/bugly/crashreport/crash/anr/b;
    //   29: iconst_1
    //   30: invokevirtual a : (Z)V
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: aload_0
    //   37: getfield w : Lcom/tencent/bugly/crashreport/crash/anr/b;
    //   40: invokevirtual d : ()Z
    //   43: pop
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Exception table:
    //   from	to	target	type
    //   2	33	47	finally
    //   36	44	47	finally
  }
  
  public final void d() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield s : Lcom/tencent/bugly/crashreport/crash/e;
    //   6: invokevirtual b : ()V
    //   9: aload_0
    //   10: getfield t : Lcom/tencent/bugly/crashreport/crash/jni/NativeCrashHandler;
    //   13: iconst_0
    //   14: invokevirtual setUserOpened : (Z)V
    //   17: getstatic android/os/Build$VERSION.SDK_INT : I
    //   20: bipush #19
    //   22: if_icmpge -> 36
    //   25: aload_0
    //   26: getfield w : Lcom/tencent/bugly/crashreport/crash/anr/b;
    //   29: iconst_0
    //   30: invokevirtual a : (Z)V
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: aload_0
    //   37: getfield w : Lcom/tencent/bugly/crashreport/crash/anr/b;
    //   40: invokevirtual e : ()Z
    //   43: pop
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Exception table:
    //   from	to	target	type
    //   2	33	47	finally
    //   36	44	47	finally
  }
  
  public final void e() {
    this.s.a();
  }
  
  public final void f() {
    this.t.setUserOpened(false);
  }
  
  public final void g() {
    this.t.setUserOpened(true);
  }
  
  public final void h() {
    if (Build.VERSION.SDK_INT <= 19) {
      this.w.a(true);
      return;
    } 
    this.w.d();
  }
  
  public final void i() {
    if (Build.VERSION.SDK_INT < 19) {
      this.w.a(false);
      return;
    } 
    this.w.e();
  }
  
  public final void j() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield w : Lcom/tencent/bugly/crashreport/crash/anr/b;
    //   6: astore_3
    //   7: iconst_0
    //   8: istore_1
    //   9: iload_1
    //   10: iconst_1
    //   11: iadd
    //   12: istore_2
    //   13: iload_1
    //   14: bipush #30
    //   16: if_icmpge -> 62
    //   19: ldc 'try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!'
    //   21: iconst_1
    //   22: anewarray java/lang/Object
    //   25: dup
    //   26: iconst_0
    //   27: iload_2
    //   28: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   31: aastore
    //   32: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   35: pop
    //   36: ldc2_w 5000
    //   39: invokestatic b : (J)V
    //   42: iload_2
    //   43: istore_1
    //   44: goto -> 9
    //   47: astore_3
    //   48: aload_3
    //   49: invokestatic a : (Ljava/lang/Throwable;)Z
    //   52: ifne -> 59
    //   55: aload_3
    //   56: invokevirtual printStackTrace : ()V
    //   59: aload_0
    //   60: monitorexit
    //   61: return
    //   62: aload_0
    //   63: monitorexit
    //   64: return
    //   65: astore_3
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_3
    //   69: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	65	finally
    //   19	42	47	finally
    //   48	59	65	finally
  }
  
  public final boolean k() {
    return this.w.a();
  }
  
  public final void l() {
    this.t.checkUploadRecordCrash();
  }
  
  public final void m() {
    if ((a.b()).d.equals(AppInfo.a(this.q)))
      this.t.removeEmptyNativeRecordFiles(); 
  }
  
  public final boolean n() {
    return this.z;
  }
  
  public final boolean o() {
    return ((this.y & 0x10) > 0);
  }
  
  public final boolean p() {
    return ((this.y & 0x8) > 0);
  }
  
  public final boolean q() {
    return ((this.y & 0x4) > 0);
  }
  
  public final boolean r() {
    return ((this.y & 0x2) > 0);
  }
  
  public final boolean s() {
    return ((this.y & 0x1) > 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\crashreport\crash\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */