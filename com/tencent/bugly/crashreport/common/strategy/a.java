package com.tencent.bugly.crashreport.common.strategy;

import android.content.Context;
import com.tencent.bugly.crashreport.biz.b;
import com.tencent.bugly.proguard.as;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.List;
import java.util.Map;

public final class a {
  public static int a = 1000;
  
  private static a b;
  
  private static String h;
  
  private final List<com.tencent.bugly.a> c;
  
  private final w d;
  
  private final StrategyBean e;
  
  private StrategyBean f;
  
  private Context g;
  
  private a(Context paramContext, List<com.tencent.bugly.a> paramList) {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial <init> : ()V
    //   4: aload_0
    //   5: aconst_null
    //   6: putfield f : Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
    //   9: aload_0
    //   10: aload_1
    //   11: putfield g : Landroid/content/Context;
    //   14: aload_1
    //   15: invokestatic a : (Landroid/content/Context;)Lcom/tencent/bugly/crashreport/common/info/a;
    //   18: ifnull -> 82
    //   21: aload_1
    //   22: invokestatic a : (Landroid/content/Context;)Lcom/tencent/bugly/crashreport/common/info/a;
    //   25: getfield z : Ljava/lang/String;
    //   28: astore_1
    //   29: ldc 'oversea'
    //   31: aload_1
    //   32: invokevirtual equals : (Ljava/lang/Object;)Z
    //   35: ifeq -> 52
    //   38: ldc 'http://astat.bugly.qcloud.com/rqd/async'
    //   40: astore_1
    //   41: aload_1
    //   42: putstatic com/tencent/bugly/crashreport/common/strategy/StrategyBean.b : Ljava/lang/String;
    //   45: aload_1
    //   46: putstatic com/tencent/bugly/crashreport/common/strategy/StrategyBean.c : Ljava/lang/String;
    //   49: goto -> 82
    //   52: ldc 'na_https'
    //   54: aload_1
    //   55: invokevirtual equals : (Ljava/lang/Object;)Z
    //   58: ifeq -> 67
    //   61: ldc 'https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async'
    //   63: astore_1
    //   64: goto -> 41
    //   67: ldc 'na_http'
    //   69: aload_1
    //   70: invokevirtual equals : (Ljava/lang/Object;)Z
    //   73: ifeq -> 82
    //   76: ldc 'http://astat.bugly.cros.wr.pvp.net/:8180/rqd/async'
    //   78: astore_1
    //   79: goto -> 41
    //   82: aload_0
    //   83: new com/tencent/bugly/crashreport/common/strategy/StrategyBean
    //   86: dup
    //   87: invokespecial <init> : ()V
    //   90: putfield e : Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
    //   93: aload_0
    //   94: aload_2
    //   95: putfield c : Ljava/util/List;
    //   98: aload_0
    //   99: invokestatic a : ()Lcom/tencent/bugly/proguard/w;
    //   102: putfield d : Lcom/tencent/bugly/proguard/w;
    //   105: return
  }
  
  public static a a() {
    // Byte code:
    //   0: ldc com/tencent/bugly/crashreport/common/strategy/a
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/crashreport/common/strategy/a.b : Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   6: astore_0
    //   7: ldc com/tencent/bugly/crashreport/common/strategy/a
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/tencent/bugly/crashreport/common/strategy/a
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static a a(Context paramContext, List<com.tencent.bugly.a> paramList) {
    // Byte code:
    //   0: ldc com/tencent/bugly/crashreport/common/strategy/a
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/crashreport/common/strategy/a.b : Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   6: ifnonnull -> 21
    //   9: new com/tencent/bugly/crashreport/common/strategy/a
    //   12: dup
    //   13: aload_0
    //   14: aload_1
    //   15: invokespecial <init> : (Landroid/content/Context;Ljava/util/List;)V
    //   18: putstatic com/tencent/bugly/crashreport/common/strategy/a.b : Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   21: getstatic com/tencent/bugly/crashreport/common/strategy/a.b : Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   24: astore_0
    //   25: ldc com/tencent/bugly/crashreport/common/strategy/a
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: astore_0
    //   31: ldc com/tencent/bugly/crashreport/common/strategy/a
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	30	finally
    //   21	25	30	finally
  }
  
  public static void a(String paramString) {
    if (z.a(paramString) || !z.c(paramString)) {
      x.d("URL user set is invalid.", new Object[0]);
      return;
    } 
    h = paramString;
  }
  
  public static StrategyBean d() {
    List<r> list = p.a().a(2);
    if (list != null && list.size() > 0) {
      r r = list.get(0);
      if (r.g != null)
        return (StrategyBean)z.a(r.g, StrategyBean.CREATOR); 
    } 
    return null;
  }
  
  public final void a(long paramLong) {
    this.d.a(new Thread(this) {
          public final void run() {
            try {
              Map map = p.a().a(a.a, null, true);
              if (map != null) {
                byte[] arrayOfByte1 = (byte[])map.get("device");
                byte[] arrayOfByte2 = (byte[])map.get("gateway");
                if (arrayOfByte1 != null)
                  com.tencent.bugly.crashreport.common.info.a.a(a.a(this.a)).e(new String(arrayOfByte1)); 
                if (arrayOfByte2 != null)
                  com.tencent.bugly.crashreport.common.info.a.a(a.a(this.a)).d(new String(arrayOfByte2)); 
              } 
              a a2 = this.a;
              a a3 = this.a;
              a.a(a2, a.d());
            } finally {
              Exception exception = null;
            } 
            a a1 = this.a;
            a1.a(a.b(a1), false);
          }
        }paramLong);
  }
  
  protected final void a(StrategyBean paramStrategyBean, boolean paramBoolean) {
    x.c("[Strategy] Notify %s", new Object[] { b.class.getName() });
    b.a(paramStrategyBean, paramBoolean);
    for (com.tencent.bugly.a a1 : this.c) {
      try {
        x.c("[Strategy] Notify %s", new Object[] { a1.getClass().getName() });
        a1.onServerStrategyChanged(paramStrategyBean);
      } finally {
        a1 = null;
      } 
    } 
  }
  
  public final void a(as paramas) {
    if (paramas == null)
      return; 
    if (this.f != null && paramas.h == this.f.p)
      return; 
    StrategyBean strategyBean = new StrategyBean();
    strategyBean.g = paramas.a;
    strategyBean.i = paramas.c;
    strategyBean.h = paramas.b;
    if (z.a(h) || !z.c(h)) {
      if (z.c(paramas.d)) {
        x.c("[Strategy] Upload url changes to %s", new Object[] { paramas.d });
        strategyBean.r = paramas.d;
      } 
      if (z.c(paramas.e)) {
        x.c("[Strategy] Exception upload url changes to %s", new Object[] { paramas.e });
        strategyBean.s = paramas.e;
      } 
    } 
    if (paramas.f != null && !z.a(paramas.f.a))
      strategyBean.u = paramas.f.a; 
    if (paramas.h != 0L)
      strategyBean.p = paramas.h; 
    if (paramas.g != null && paramas.g.size() > 0) {
      strategyBean.v = paramas.g;
      String str = (String)paramas.g.get("B11");
      if (str != null && str.equals("1")) {
        strategyBean.j = true;
      } else {
        strategyBean.j = false;
      } 
      str = (String)paramas.g.get("B3");
      if (str != null)
        strategyBean.y = Long.valueOf(str).longValue(); 
      strategyBean.q = paramas.i;
      strategyBean.x = paramas.i;
      str = (String)paramas.g.get("B27");
      if (str != null && str.length() > 0)
        try {
          int i = Integer.parseInt(str);
          if (i > 0)
            strategyBean.w = i; 
        } catch (Exception exception) {
          if (!x.a(exception))
            exception.printStackTrace(); 
        }  
      str = (String)paramas.g.get("B25");
      if (str != null && str.equals("1")) {
        strategyBean.l = true;
      } else {
        strategyBean.l = false;
      } 
    } 
    x.a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", new Object[] { Boolean.valueOf(strategyBean.g), Boolean.valueOf(strategyBean.i), Boolean.valueOf(strategyBean.h), Boolean.valueOf(strategyBean.j), Boolean.valueOf(strategyBean.k), Boolean.valueOf(strategyBean.n), Boolean.valueOf(strategyBean.o), Long.valueOf(strategyBean.q), Boolean.valueOf(strategyBean.l), Long.valueOf(strategyBean.p) });
    this.f = strategyBean;
    if (!z.c(paramas.d)) {
      x.c("[Strategy] download url is null", new Object[0]);
      this.f.r = "";
    } 
    if (!z.c(paramas.e)) {
      x.c("[Strategy] download crashurl is null", new Object[0]);
      this.f.s = "";
    } 
    p.a().b(2);
    r r = new r();
    r.b = 2;
    r.a = strategyBean.e;
    r.e = strategyBean.f;
    r.g = z.a(strategyBean);
    p.a().a(r);
    a(strategyBean, true);
  }
  
  public final boolean b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull -> 17
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_1
    //   19: goto -> 13
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public final StrategyBean c() {
    StrategyBean strategyBean = this.f;
    if (strategyBean != null) {
      if (!z.c(strategyBean.r))
        this.f.r = StrategyBean.b; 
      if (!z.c(this.f.s))
        this.f.s = StrategyBean.c; 
      return this.f;
    } 
    if (!z.a(h) && z.c(h)) {
      strategyBean = this.e;
      String str = h;
      strategyBean.r = str;
      strategyBean.s = str;
    } 
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\crashreport\common\strategy\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */