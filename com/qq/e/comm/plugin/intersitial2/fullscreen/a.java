package com.qq.e.comm.plugin.intersitial2.fullscreen;

import android.text.TextUtils;
import com.qq.e.comm.plugin.aa.a.b;
import com.qq.e.comm.plugin.j.c;
import com.qq.e.comm.plugin.util.aj;
import com.qq.e.comm.plugin.util.bc;
import com.qq.e.comm.plugin.util.y;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class a {
  private static volatile a a;
  
  private Map<String, Set<a>> b = new ConcurrentHashMap<String, Set<a>>();
  
  public static a a() {
    // Byte code:
    //   0: getstatic com/qq/e/comm/plugin/intersitial2/fullscreen/a.a : Lcom/qq/e/comm/plugin/intersitial2/fullscreen/a;
    //   3: ifnonnull -> 37
    //   6: ldc com/qq/e/comm/plugin/intersitial2/fullscreen/a
    //   8: monitorenter
    //   9: getstatic com/qq/e/comm/plugin/intersitial2/fullscreen/a.a : Lcom/qq/e/comm/plugin/intersitial2/fullscreen/a;
    //   12: ifnonnull -> 25
    //   15: new com/qq/e/comm/plugin/intersitial2/fullscreen/a
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/qq/e/comm/plugin/intersitial2/fullscreen/a.a : Lcom/qq/e/comm/plugin/intersitial2/fullscreen/a;
    //   25: ldc com/qq/e/comm/plugin/intersitial2/fullscreen/a
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/qq/e/comm/plugin/intersitial2/fullscreen/a
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/qq/e/comm/plugin/intersitial2/fullscreen/a.a : Lcom/qq/e/comm/plugin/intersitial2/fullscreen/a;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    Set set = this.b.get(paramString);
    if (set != null)
      set.clear(); 
  }
  
  public void a(String paramString1, String paramString2, a parama, c paramc) {
    if (TextUtils.isEmpty(paramString1)) {
      GDTLogger.e("download url null");
      return;
    } 
    if (parama != null) {
      Set<a> set2 = this.b.get(paramString1);
      Set<a> set1 = set2;
      if (set2 == null)
        set1 = new HashSet(); 
      set1.add(parama);
      this.b.put(paramString1, set1);
    } 
    b b = (new b.a()).b(paramString1).a(aj.a(paramString1)).a(aj.f()).a();
    com.qq.e.comm.plugin.aa.a.a.a().a(b, paramString1, new com.qq.e.comm.plugin.j.a(this, paramString1, paramc) {
          private int d;
          
          public void a() {
            GDTLogger.d("onStarted");
            y.a(new Runnable(this) {
                  public void run() {
                    Set set = (Set)a.a(this.a.c).get(this.a.a);
                    if (set != null && set.size() > 0) {
                      Iterator<a.a> iterator = set.iterator();
                      while (iterator.hasNext())
                        ((a.a)iterator.next()).a(); 
                    } 
                  }
                });
          }
          
          public void a(long param1Long1, long param1Long2, int param1Int) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("downloading video ---> Progress: ");
            stringBuilder.append(param1Int);
            stringBuilder.append("%");
            GDTLogger.d(stringBuilder.toString());
            y.a(new Runnable(this, param1Int) {
                  public void run() {
                    Set set = (Set)a.a(this.b.c).get(this.b.a);
                    if (set != null && set.size() > 0) {
                      Iterator<a.a> iterator = set.iterator();
                      while (iterator.hasNext())
                        ((a.a)iterator.next()).a(this.a); 
                    } 
                  }
                });
          }
          
          public void a(long param1Long, boolean param1Boolean) {
            this.d = (int)(param1Long >> 10L);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onConnected isRangeSupport: ");
            stringBuilder.append(param1Boolean);
            stringBuilder.append(", total: ");
            stringBuilder.append(param1Long);
            GDTLogger.d(stringBuilder.toString());
          }
          
          public void a(c param1c) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Video download Failed, code: ");
            stringBuilder.append(param1c.a());
            stringBuilder.append(", msg: ");
            stringBuilder.append(param1c.b());
            GDTLogger.w(stringBuilder.toString(), null);
            y.a(new Runnable(this, param1c) {
                  public void run() {
                    Set set = (Set)a.a(this.b.c).get(this.b.a);
                    if (set != null && set.size() > 0) {
                      Iterator<a.a> iterator = set.iterator();
                      while (iterator.hasNext())
                        ((a.a)iterator.next()).a(this.a); 
                    } 
                    a.a(this.b.c).remove(this.b.a);
                  }
                });
          }
          
          public void a(File param1File, long param1Long) {
            GDTLogger.d("onCompleted");
            y.a(new Runnable(this) {
                  public void run() {
                    Set set = (Set)a.a(this.a.c).get(this.a.a);
                    if (set != null && set.size() > 0)
                      for (a.a a : set) {
                        String str;
                        File file = aj.d(this.a.a);
                        if (file == null) {
                          str = "";
                        } else {
                          str = str.getAbsolutePath();
                        } 
                        a.a(str);
                      }  
                    a.a(this.a.c).remove(this.a.a);
                  }
                });
            bc.a(param1Long, this.d, this.a, this.b);
          }
          
          public void b() {}
          
          public void c() {}
        });
  }
  
  public static interface a {
    void a();
    
    void a(int param1Int);
    
    void a(c param1c);
    
    void a(String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\intersitial2\fullscreen\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */