package com.ss.android.downloadlib;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.a.a.b.a;
import com.ss.android.a.a.b.a.a;
import com.ss.android.a.a.b.b;
import com.ss.android.a.a.b.c;
import com.ss.android.a.a.b.d;
import com.ss.android.downloadlib.a.f;
import com.ss.android.downloadlib.a.g;
import com.ss.android.socialbase.downloader.e.a;
import com.ss.android.socialbase.downloader.g.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class g implements f {
  private static volatile g a;
  
  private final Handler b = new Handler(Looper.getMainLooper());
  
  private final List<g> c = new CopyOnWriteArrayList<g>();
  
  private final Map<String, g> d = new ConcurrentHashMap<String, g>();
  
  private final CopyOnWriteArrayList<a> e = new CopyOnWriteArrayList<a>();
  
  private long f;
  
  public static g a() {
    // Byte code:
    //   0: getstatic com/ss/android/downloadlib/g.a : Lcom/ss/android/downloadlib/g;
    //   3: ifnonnull -> 37
    //   6: ldc com/ss/android/downloadlib/g
    //   8: monitorenter
    //   9: getstatic com/ss/android/downloadlib/g.a : Lcom/ss/android/downloadlib/g;
    //   12: ifnonnull -> 25
    //   15: new com/ss/android/downloadlib/g
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/ss/android/downloadlib/g.a : Lcom/ss/android/downloadlib/g;
    //   25: ldc com/ss/android/downloadlib/g
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/ss/android/downloadlib/g
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/ss/android/downloadlib/g.a : Lcom/ss/android/downloadlib/g;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private void b() {
    long l = System.currentTimeMillis();
    if (l - this.f < 120000L)
      return; 
    this.f = l;
    if (!this.c.isEmpty())
      c(); 
  }
  
  private void b(Context paramContext, int paramInt, d paramd, c paramc) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Ljava/util/List;
    //   6: invokeinterface size : ()I
    //   11: ifgt -> 26
    //   14: aload_0
    //   15: aload_1
    //   16: iload_2
    //   17: aload_3
    //   18: aload #4
    //   20: invokespecial c : (Landroid/content/Context;ILcom/ss/android/a/a/b/d;Lcom/ss/android/a/a/b/c;)V
    //   23: goto -> 87
    //   26: aload_0
    //   27: getfield c : Ljava/util/List;
    //   30: iconst_0
    //   31: invokeinterface remove : (I)Ljava/lang/Object;
    //   36: checkcast com/ss/android/downloadlib/a/g
    //   39: astore #5
    //   41: aload #5
    //   43: aload_1
    //   44: invokeinterface b : (Landroid/content/Context;)Lcom/ss/android/downloadlib/a/g;
    //   49: iload_2
    //   50: aload_3
    //   51: invokeinterface b : (ILcom/ss/android/a/a/b/d;)Lcom/ss/android/downloadlib/a/g;
    //   56: aload #4
    //   58: invokeinterface b : (Lcom/ss/android/a/a/b/c;)Lcom/ss/android/downloadlib/a/g;
    //   63: invokeinterface a : ()V
    //   68: aload_0
    //   69: getfield d : Ljava/util/Map;
    //   72: aload #4
    //   74: invokeinterface a : ()Ljava/lang/String;
    //   79: aload #5
    //   81: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   86: pop
    //   87: aload_0
    //   88: monitorexit
    //   89: return
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Exception table:
    //   from	to	target	type
    //   2	23	90	finally
    //   26	87	90	finally
  }
  
  private void c() {
    long l = System.currentTimeMillis();
    ArrayList<g> arrayList = new ArrayList();
    for (g g1 : this.c) {
      if (!g1.b() && l - g1.d() > 120000L) {
        g1.g();
        arrayList.add(g1);
      } 
    } 
    if (!arrayList.isEmpty())
      this.c.removeAll(arrayList); 
  }
  
  private void c(Context paramContext, int paramInt, d paramd, c paramc) {
    if (paramc == null)
      return; 
    f f1 = new f();
    f1.b(paramContext).b(paramInt, paramd).b(paramc).a();
    this.d.put(paramc.a(), f1);
  }
  
  public f a(String paramString) {
    Map<String, g> map = this.d;
    if (map != null && map.size() != 0) {
      if (TextUtils.isEmpty(paramString))
        return null; 
      g g1 = this.d.get(paramString);
      if (g1 instanceof f)
        return (f)g1; 
    } 
    return null;
  }
  
  public void a(Context paramContext, int paramInt, d paramd, c paramc) {
    if (paramc != null) {
      if (TextUtils.isEmpty(paramc.a()))
        return; 
      g g1 = this.d.get(paramc.a());
      if (g1 != null) {
        g1.b(paramContext).b(paramInt, paramd).b(paramc).a();
        return;
      } 
      if (!this.c.isEmpty()) {
        b(paramContext, paramInt, paramd, paramc);
        return;
      } 
      c(paramContext, paramInt, paramd, paramc);
    } 
  }
  
  public void a(a parama) {
    if (parama != null)
      this.e.add(parama); 
  }
  
  public void a(c paramc, a parama, b paramb) {
    this.b.post(new Runnable(this, paramc, parama, paramb) {
          public void run() {
            Iterator<a> iterator = g.a(this.d).iterator();
            while (iterator.hasNext())
              ((a)iterator.next()).a(this.a, this.b, this.c); 
          }
        });
  }
  
  public void a(c paramc) {
    this.b.post(new Runnable(this, paramc) {
          public void run() {
            Iterator<a> iterator = g.a(this.b).iterator();
            while (iterator.hasNext())
              ((a)iterator.next()).a(this.a); 
          }
        });
  }
  
  public void a(c paramc, a parama, String paramString) {
    this.b.post(new Runnable(this, paramc, parama, paramString) {
          public void run() {
            Iterator<a> iterator = g.a(this.d).iterator();
            while (iterator.hasNext())
              ((a)iterator.next()).a(this.a, this.b, this.c); 
          }
        });
  }
  
  public void a(c paramc, String paramString) {
    this.b.post(new Runnable(this, paramc, paramString) {
          public void run() {
            Iterator<a> iterator = g.a(this.c).iterator();
            while (iterator.hasNext())
              ((a)iterator.next()).a(this.a, this.b); 
          }
        });
  }
  
  public void a(String paramString, int paramInt) {
    if (TextUtils.isEmpty(paramString))
      return; 
    g g1 = this.d.get(paramString);
    if (g1 != null) {
      if (g1.a(paramInt)) {
        this.c.add(g1);
        this.d.remove(paramString);
      } 
      b();
    } 
  }
  
  public void a(String paramString, long paramLong, int paramInt) {
    a(paramString, paramLong, paramInt, null, null);
  }
  
  public void a(String paramString, long paramLong, int paramInt, b paramb, a parama) {
    if (TextUtils.isEmpty(paramString))
      return; 
    g g1 = this.d.get(paramString);
    if (g1 != null)
      g1.b(paramb).b(parama).a(paramLong, paramInt); 
  }
  
  public void a(String paramString, boolean paramBoolean) {
    if (TextUtils.isEmpty(paramString))
      return; 
    g g1 = this.d.get(paramString);
    if (g1 != null)
      g1.a(paramBoolean); 
  }
  
  public void b(c paramc, String paramString) {
    this.b.post(new Runnable(this, paramc, paramString) {
          public void run() {
            Iterator<a> iterator = g.a(this.c).iterator();
            while (iterator.hasNext())
              ((a)iterator.next()).b(this.a, this.b); 
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */