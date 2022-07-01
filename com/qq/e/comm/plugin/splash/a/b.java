package com.qq.e.comm.plugin.splash.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.s.f;
import com.qq.e.comm.plugin.s.g;
import com.qq.e.comm.plugin.s.h;
import com.qq.e.comm.plugin.splash.l;
import com.qq.e.comm.plugin.util.ac;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.plugin.util.aj;
import com.qq.e.comm.plugin.util.av;
import com.qq.e.comm.plugin.util.t;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class b extends BroadcastReceiver {
  private static Object a = new Object();
  
  private static volatile b b;
  
  private b() {
    a(GDTADManager.getInstance().getAppContext());
  }
  
  public static b a() {
    // Byte code:
    //   0: getstatic com/qq/e/comm/plugin/splash/a/b.b : Lcom/qq/e/comm/plugin/splash/a/b;
    //   3: ifnonnull -> 37
    //   6: ldc com/qq/e/comm/plugin/splash/a/b
    //   8: monitorenter
    //   9: getstatic com/qq/e/comm/plugin/splash/a/b.b : Lcom/qq/e/comm/plugin/splash/a/b;
    //   12: ifnonnull -> 25
    //   15: new com/qq/e/comm/plugin/splash/a/b
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/qq/e/comm/plugin/splash/a/b.b : Lcom/qq/e/comm/plugin/splash/a/b;
    //   25: ldc com/qq/e/comm/plugin/splash/a/b
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/qq/e/comm/plugin/splash/a/b
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/qq/e/comm/plugin/splash/a/b.b : Lcom/qq/e/comm/plugin/splash/a/b;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private void a(Context paramContext) {
    try {
      return;
    } finally {
      paramContext = null;
      paramContext.printStackTrace();
    } 
  }
  
  public static void a(a parama) {
    if (parama == null)
      return; 
    if (!TextUtils.isEmpty(parama.b()))
      t.a.submit(new Runnable(parama) {
            public void run() {
              synchronized (b.g()) {
                String str = this.a.a();
                if (!TextUtils.isEmpty(str)) {
                  StringBuilder stringBuilder2 = new StringBuilder();
                  stringBuilder2.append(aj.c());
                  stringBuilder2.append(File.separator);
                  stringBuilder2.append(this.a.b());
                  aj.a(new File(stringBuilder2.toString()), str);
                  StringBuilder stringBuilder1 = new StringBuilder();
                  stringBuilder1.append("FirstPlayHelpercache fb report data ");
                  stringBuilder1.append(this.a.b());
                  GDTLogger.d(stringBuilder1.toString());
                } 
                return;
              } 
            }
          }); 
  }
  
  public static boolean a(f paramf) {
    boolean bool2 = false;
    if (paramf == null)
      return false; 
    List list = paramf.j();
    boolean bool1 = bool2;
    if (list != null) {
      bool1 = bool2;
      if (list.size() > 0) {
        Iterator<h> iterator = list.iterator();
        while (true) {
          bool1 = bool2;
          if (iterator.hasNext()) {
            h h = iterator.next();
            if (h != null && h.e() && a(h)) {
              bool1 = true;
              break;
            } 
            continue;
          } 
          break;
        } 
      } 
    } 
    return bool1;
  }
  
  private static boolean a(h paramh) {
    if (paramh != null) {
      List list = paramh.c();
      if (list != null) {
        if (list.isEmpty())
          return true; 
        Iterator<Point> iterator = list.iterator();
        while (true) {
          if (iterator.hasNext()) {
            Point point = iterator.next();
            int j = point.x;
            int k = point.y;
            int i = j;
            if (j < 0)
              i = 0; 
            j = k;
            if (k > 1440)
              j = 1440; 
            if (i < j) {
              k = h();
              if (k <= j && k >= i)
                break; 
            } 
            continue;
          } 
          return false;
        } 
      } 
      return true;
    } 
    return false;
  }
  
  public static void b(f paramf) {
    if (paramf == null)
      return; 
    a a = new a();
    a.f = paramf.f();
    a.g = l.a();
    a.h = paramf.q();
    if (paramf.R() != null && paramf.R().size() > 0) {
      a.i = new ArrayList<String>();
      for (g g : paramf.R())
        a.i.add(g.a()); 
    } 
    if (paramf.S() != null && paramf.S().size() > 0) {
      a.j = new ArrayList<String>();
      for (g g : paramf.S())
        a.j.add(g.a()); 
    } 
    a(a);
  }
  
  public static boolean c() {
    return l.a().equalsIgnoreCase(i());
  }
  
  public static void d() {
    av.a("first_play_date", l.a());
  }
  
  public static void e() {
    GDTLogger.d("FirstPlayHelper clear fp report Data");
    aj.b(aj.c());
  }
  
  private static int h() {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(System.currentTimeMillis());
    int i = calendar.get(11);
    return calendar.get(12) + i * 60;
  }
  
  private static String i() {
    return av.b("first_play_date", "");
  }
  
  private static List<a> j() {
    null = aj.c().listFiles();
    if (null.length == 0) {
      GDTLogger.d("FirstPlayHelper no first play cache data");
      return null;
    } 
    ArrayList<a> arrayList = new ArrayList();
    synchronized (a) {
      int j = null.length;
      for (int i = 0; i < j; i++) {
        a a = new a(aj.c(null[i]));
        arrayList.add(a);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("bean ");
        stringBuilder.append(a.toString());
        GDTLogger.d(stringBuilder.toString());
      } 
      e();
      return arrayList;
    } 
  }
  
  public void b() {
    t.a.submit(new Runnable(this) {
          public void run() {
            List list = b.f();
            if (list != null) {
              if (list.size() == 0)
                return; 
              for (a a : list) {
                if (a != null && !TextUtils.isEmpty(a.b())) {
                  ah.a(a.h);
                  if (a.i != null && a.i.size() > 0)
                    for (String str : a.i) {
                      if (!TextUtils.isEmpty(str))
                        ah.a(str); 
                    }  
                  if (a.j != null && a.j.size() > 0)
                    for (String str : a.j) {
                      if (!TextUtils.isEmpty(str))
                        ac.a(str); 
                    }  
                } 
              } 
            } 
          }
        });
  }
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    GDTLogger.d("FirstPlayHelper：网络状态变化");
    if (l.a(paramContext)) {
      GDTLogger.d("FirstPlayHelper：有网络尝试补报第一刷");
      b();
      return;
    } 
    GDTLogger.d("FirstPlayHelper：当前无网络连接");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\splash\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */