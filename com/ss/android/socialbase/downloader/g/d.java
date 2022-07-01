package com.ss.android.socialbase.downloader.g;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.b.g;
import com.ss.android.socialbase.downloader.b.h;
import com.ss.android.socialbase.downloader.d.ac;
import com.ss.android.socialbase.downloader.d.l;
import com.ss.android.socialbase.downloader.d.p;
import com.ss.android.socialbase.downloader.d.q;
import com.ss.android.socialbase.downloader.d.u;
import com.ss.android.socialbase.downloader.d.v;
import com.ss.android.socialbase.downloader.d.w;
import com.ss.android.socialbase.downloader.d.x;
import com.ss.android.socialbase.downloader.d.z;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.downloader.h;
import com.ss.android.socialbase.downloader.downloader.i;
import com.ss.android.socialbase.downloader.downloader.r;
import com.ss.android.socialbase.downloader.e.a;
import com.ss.android.socialbase.downloader.f.a;
import com.ss.android.socialbase.downloader.h.a;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class d {
  private c a;
  
  private h b;
  
  private i c;
  
  private final Map<h, w> d = new ConcurrentHashMap<h, w>();
  
  private final SparseArray<h> e = new SparseArray();
  
  private final SparseArray<w> f = new SparseArray();
  
  private final SparseArray<w> g = new SparseArray();
  
  private final SparseArray<w> h = new SparseArray();
  
  private z i;
  
  private v j;
  
  private l k;
  
  private x l;
  
  private c.a m = new c.a();
  
  private u n;
  
  private p o;
  
  private r p;
  
  private ac q;
  
  private boolean r = false;
  
  private q s;
  
  public d() {}
  
  public d(c paramc) {
    this();
    this.a = paramc;
  }
  
  private void a(SparseArray<w> paramSparseArray1, SparseArray<w> paramSparseArray2) {
    paramSparseArray1.clear();
    for (int j = 0; j < paramSparseArray2.size(); j++) {
      int k = paramSparseArray2.keyAt(j);
      w w = (w)paramSparseArray2.get(k);
      if (w != null)
        paramSparseArray1.put(k, w); 
    } 
  }
  
  private void b(SparseArray paramSparseArray1, SparseArray paramSparseArray2) {
    if (paramSparseArray1 != null) {
      if (paramSparseArray2 == null)
        return; 
      int k = paramSparseArray1.size();
      for (int j = 0; j < k; j++) {
        int m = paramSparseArray1.keyAt(j);
        paramSparseArray2.put(m, paramSparseArray1.get(m));
      } 
    } 
  }
  
  private void c(SparseArray paramSparseArray1, SparseArray paramSparseArray2) {
    if (paramSparseArray1 != null) {
      if (paramSparseArray2 == null)
        return; 
      int k = paramSparseArray2.size();
      for (int j = 0; j < k; j++)
        paramSparseArray1.remove(paramSparseArray2.keyAt(j)); 
    } 
  }
  
  private void d(h paramh) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual a : (Lcom/ss/android/socialbase/downloader/b/h;)Landroid/util/SparseArray;
    //   5: astore_3
    //   6: aload_3
    //   7: monitorenter
    //   8: iconst_0
    //   9: istore_2
    //   10: iload_2
    //   11: aload_3
    //   12: invokevirtual size : ()I
    //   15: if_icmpge -> 54
    //   18: aload_3
    //   19: aload_3
    //   20: iload_2
    //   21: invokevirtual keyAt : (I)I
    //   24: invokevirtual get : (I)Ljava/lang/Object;
    //   27: checkcast com/ss/android/socialbase/downloader/d/w
    //   30: astore #4
    //   32: aload #4
    //   34: ifnull -> 62
    //   37: invokestatic a : ()Lcom/ss/android/socialbase/downloader/downloader/c;
    //   40: aload_0
    //   41: invokevirtual o : ()I
    //   44: aload #4
    //   46: aload_1
    //   47: iconst_0
    //   48: invokevirtual b : (ILcom/ss/android/socialbase/downloader/d/w;Lcom/ss/android/socialbase/downloader/b/h;Z)V
    //   51: goto -> 62
    //   54: aload_3
    //   55: monitorexit
    //   56: return
    //   57: astore_1
    //   58: aload_3
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    //   62: iload_2
    //   63: iconst_1
    //   64: iadd
    //   65: istore_2
    //   66: goto -> 10
    // Exception table:
    //   from	to	target	type
    //   10	32	57	finally
    //   37	51	57	finally
    //   54	56	57	finally
    //   58	60	57	finally
  }
  
  public SparseArray<w> a(h paramh) {
    return (paramh == h.a) ? this.f : ((paramh == h.b) ? this.g : ((paramh == h.c) ? this.h : null));
  }
  
  public w a(h paramh, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual a : (Lcom/ss/android/socialbase/downloader/b/h;)Landroid/util/SparseArray;
    //   5: astore_1
    //   6: aload_1
    //   7: ifnull -> 52
    //   10: iload_2
    //   11: ifge -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: aload_1
    //   17: monitorenter
    //   18: iload_2
    //   19: aload_1
    //   20: invokevirtual size : ()I
    //   23: if_icmpge -> 43
    //   26: aload_1
    //   27: aload_1
    //   28: iload_2
    //   29: invokevirtual keyAt : (I)I
    //   32: invokevirtual get : (I)Ljava/lang/Object;
    //   35: checkcast com/ss/android/socialbase/downloader/d/w
    //   38: astore_3
    //   39: aload_1
    //   40: monitorexit
    //   41: aload_3
    //   42: areturn
    //   43: aload_1
    //   44: monitorexit
    //   45: aconst_null
    //   46: areturn
    //   47: astore_3
    //   48: aload_1
    //   49: monitorexit
    //   50: aload_3
    //   51: athrow
    //   52: aconst_null
    //   53: areturn
    // Exception table:
    //   from	to	target	type
    //   18	41	47	finally
    //   43	45	47	finally
    //   48	50	47	finally
  }
  
  public c a() {
    return this.a;
  }
  
  public d a(int paramInt) {
    this.m.a(paramInt);
    return this;
  }
  
  public d a(int paramInt, w paramw) {
    if (paramw != null)
      synchronized (this.f) {
        this.f.put(paramInt, paramw);
        this.d.put(h.a, paramw);
        synchronized (this.e) {
          this.e.put(paramInt, h.a);
          return this;
        } 
      }  
    return this;
  }
  
  public d a(g paramg) {
    this.m.a(paramg);
    return this;
  }
  
  public d a(ac paramac) {
    this.q = paramac;
    return this;
  }
  
  public d a(l paraml) {
    this.k = paraml;
    return this;
  }
  
  public d a(p paramp) {
    this.o = paramp;
    return this;
  }
  
  public d a(q paramq) {
    this.s = paramq;
    return this;
  }
  
  public d a(u paramu) {
    this.n = paramu;
    return this;
  }
  
  public d a(v paramv) {
    this.j = paramv;
    return this;
  }
  
  public d a(w paramw) {
    return (paramw == null) ? this : a(paramw.hashCode(), paramw);
  }
  
  public d a(x paramx) {
    this.l = paramx;
    return this;
  }
  
  public d a(z paramz) {
    this.i = paramz;
    return this;
  }
  
  public d a(h paramh) {
    this.b = paramh;
    return this;
  }
  
  public d a(i parami) {
    this.c = parami;
    return this;
  }
  
  public d a(r paramr) {
    this.p = paramr;
    return this;
  }
  
  public d a(String paramString) {
    this.m.a(paramString);
    return this;
  }
  
  public d a(List<e> paramList) {
    this.m.a(paramList);
    return this;
  }
  
  public d a(JSONObject paramJSONObject) {
    this.m.a(paramJSONObject);
    return this;
  }
  
  public void a(int paramInt, w paramw, h paramh, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: aload_3
    //   2: invokevirtual a : (Lcom/ss/android/socialbase/downloader/b/h;)Landroid/util/SparseArray;
    //   5: astore #5
    //   7: aload #5
    //   9: ifnonnull -> 42
    //   12: iload #4
    //   14: ifeq -> 41
    //   17: aload_0
    //   18: getfield d : Ljava/util/Map;
    //   21: aload_3
    //   22: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   27: ifeq -> 41
    //   30: aload_0
    //   31: getfield d : Ljava/util/Map;
    //   34: aload_3
    //   35: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   40: pop
    //   41: return
    //   42: aload #5
    //   44: monitorenter
    //   45: iload #4
    //   47: ifeq -> 121
    //   50: aload_0
    //   51: getfield d : Ljava/util/Map;
    //   54: aload_3
    //   55: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   60: ifeq -> 88
    //   63: aload_0
    //   64: getfield d : Ljava/util/Map;
    //   67: aload_3
    //   68: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   73: checkcast com/ss/android/socialbase/downloader/d/w
    //   76: astore_2
    //   77: aload_0
    //   78: getfield d : Ljava/util/Map;
    //   81: aload_3
    //   82: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   87: pop
    //   88: aload_2
    //   89: ifnull -> 184
    //   92: aload #5
    //   94: aload_2
    //   95: invokevirtual indexOfValue : (Ljava/lang/Object;)I
    //   98: istore_1
    //   99: iload_1
    //   100: iflt -> 184
    //   103: iload_1
    //   104: aload #5
    //   106: invokevirtual size : ()I
    //   109: if_icmpge -> 184
    //   112: aload #5
    //   114: iload_1
    //   115: invokevirtual removeAt : (I)V
    //   118: goto -> 184
    //   121: aload #5
    //   123: iload_1
    //   124: invokevirtual remove : (I)V
    //   127: aload_0
    //   128: getfield e : Landroid/util/SparseArray;
    //   131: astore_2
    //   132: aload_2
    //   133: monitorenter
    //   134: aload_0
    //   135: getfield e : Landroid/util/SparseArray;
    //   138: iload_1
    //   139: invokevirtual get : (I)Ljava/lang/Object;
    //   142: checkcast com/ss/android/socialbase/downloader/b/h
    //   145: astore_3
    //   146: aload_3
    //   147: ifnull -> 182
    //   150: aload_0
    //   151: getfield d : Ljava/util/Map;
    //   154: aload_3
    //   155: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   160: ifeq -> 182
    //   163: aload_0
    //   164: getfield d : Ljava/util/Map;
    //   167: aload_3
    //   168: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   173: pop
    //   174: aload_0
    //   175: getfield e : Landroid/util/SparseArray;
    //   178: iload_1
    //   179: invokevirtual remove : (I)V
    //   182: aload_2
    //   183: monitorexit
    //   184: aload #5
    //   186: monitorexit
    //   187: return
    //   188: astore_3
    //   189: aload_2
    //   190: monitorexit
    //   191: aload_3
    //   192: athrow
    //   193: astore_2
    //   194: aload #5
    //   196: monitorexit
    //   197: aload_2
    //   198: athrow
    // Exception table:
    //   from	to	target	type
    //   50	88	193	finally
    //   92	99	193	finally
    //   103	118	193	finally
    //   121	134	193	finally
    //   134	146	188	finally
    //   150	182	188	finally
    //   182	184	188	finally
    //   184	187	193	finally
    //   189	191	188	finally
    //   191	193	193	finally
    //   194	197	193	finally
  }
  
  public void a(SparseArray<w> paramSparseArray, h paramh) {
    if (paramSparseArray == null)
      return; 
    try {
      if (paramh == h.a)
        synchronized (this.f) {
          return;
        }  
      if (paramh == h.b)
        synchronized (this.g) {
          return;
        }  
    } finally {
      paramSparseArray = null;
    } 
  }
  
  public void a(d paramd) {
    this.b = paramd.b;
    this.c = paramd.c;
    this.d.clear();
    this.d.putAll(paramd.d);
    this.f.clear();
    b(paramd.f, this.f);
    this.g.clear();
    b(paramd.g, this.g);
    this.h.clear();
    b(paramd.h, this.h);
    this.i = paramd.i;
    this.j = paramd.j;
    this.k = paramd.k;
    this.l = paramd.l;
    this.n = paramd.n;
    this.o = paramd.o;
    this.p = paramd.p;
    this.q = paramd.q;
    this.s = paramd.s;
  }
  
  public void a(boolean paramBoolean) {
    this.r = paramBoolean;
  }
  
  public int b(h paramh) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual a : (Lcom/ss/android/socialbase/downloader/b/h;)Landroid/util/SparseArray;
    //   5: astore_1
    //   6: aload_1
    //   7: ifnonnull -> 12
    //   10: iconst_0
    //   11: ireturn
    //   12: aload_1
    //   13: monitorenter
    //   14: aload_1
    //   15: invokevirtual size : ()I
    //   18: istore_2
    //   19: aload_1
    //   20: monitorexit
    //   21: iload_2
    //   22: ireturn
    //   23: astore_3
    //   24: aload_1
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    // Exception table:
    //   from	to	target	type
    //   14	21	23	finally
    //   24	26	23	finally
  }
  
  public d b(int paramInt) {
    this.m.b(paramInt);
    return this;
  }
  
  public d b(int paramInt, w paramw) {
    if (paramw != null)
      synchronized (this.g) {
        this.g.put(paramInt, paramw);
        this.d.put(h.b, paramw);
        synchronized (this.e) {
          this.e.put(paramInt, h.b);
          return this;
        } 
      }  
    return this;
  }
  
  public d b(w paramw) {
    return (paramw == null) ? this : c(paramw.hashCode(), paramw);
  }
  
  public d b(String paramString) {
    this.m.b(paramString);
    return this;
  }
  
  public d b(List<String> paramList) {
    this.m.b(paramList);
    return this;
  }
  
  public d b(boolean paramBoolean) {
    this.m.a(paramBoolean);
    return this;
  }
  
  public void b(int paramInt, w paramw, h paramh, boolean paramBoolean) {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull -> 5
    //   4: return
    //   5: iload #4
    //   7: ifeq -> 61
    //   10: aload_0
    //   11: getfield d : Ljava/util/Map;
    //   14: astore #5
    //   16: aload #5
    //   18: ifnull -> 61
    //   21: aload #5
    //   23: aload_3
    //   24: aload_2
    //   25: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   30: pop
    //   31: aload_0
    //   32: getfield e : Landroid/util/SparseArray;
    //   35: astore #5
    //   37: aload #5
    //   39: monitorenter
    //   40: aload_0
    //   41: getfield e : Landroid/util/SparseArray;
    //   44: iload_1
    //   45: aload_3
    //   46: invokevirtual put : (ILjava/lang/Object;)V
    //   49: aload #5
    //   51: monitorexit
    //   52: goto -> 61
    //   55: astore_2
    //   56: aload #5
    //   58: monitorexit
    //   59: aload_2
    //   60: athrow
    //   61: aload_0
    //   62: aload_3
    //   63: invokevirtual a : (Lcom/ss/android/socialbase/downloader/b/h;)Landroid/util/SparseArray;
    //   66: astore_3
    //   67: aload_3
    //   68: ifnonnull -> 72
    //   71: return
    //   72: aload_3
    //   73: monitorenter
    //   74: aload_3
    //   75: iload_1
    //   76: aload_2
    //   77: invokevirtual put : (ILjava/lang/Object;)V
    //   80: aload_3
    //   81: monitorexit
    //   82: return
    //   83: astore_2
    //   84: aload_3
    //   85: monitorexit
    //   86: aload_2
    //   87: athrow
    // Exception table:
    //   from	to	target	type
    //   40	52	55	finally
    //   56	59	55	finally
    //   74	82	83	finally
    //   84	86	83	finally
  }
  
  public void b(z paramz) {
    this.i = paramz;
  }
  
  public void b(d paramd) {
    for (Map.Entry<h, w> entry : paramd.d.entrySet()) {
      if (entry != null && !this.d.containsKey(entry.getKey()))
        this.d.put((h)entry.getKey(), (w)entry.getValue()); 
    } 
    try {
      if (paramd.f.size() != 0)
        synchronized (this.f) {
          c(this.f, paramd.f);
          b(paramd.f, this.f);
        }  
      if (paramd.g.size() != 0)
        synchronized (this.g) {
          c(this.g, paramd.g);
          b(paramd.g, this.g);
        }  
    } finally {
      paramd = null;
    } 
  }
  
  public boolean b() {
    return this.r;
  }
  
  public v c() {
    return this.j;
  }
  
  public w c(h paramh) {
    return this.d.get(paramh);
  }
  
  public d c(int paramInt) {
    this.m.c(paramInt);
    return this;
  }
  
  public d c(int paramInt, w paramw) {
    if (paramw != null)
      synchronized (this.h) {
        this.h.put(paramInt, paramw);
        this.d.put(h.c, paramw);
        synchronized (this.e) {
          this.e.put(paramInt, h.c);
          return this;
        } 
      }  
    return this;
  }
  
  public d c(String paramString) {
    this.m.c(paramString);
    return this;
  }
  
  public d c(boolean paramBoolean) {
    this.m.b(paramBoolean);
    return this;
  }
  
  public l d() {
    return this.k;
  }
  
  public d d(int paramInt) {
    this.m.d(paramInt);
    return this;
  }
  
  public d d(String paramString) {
    this.m.d(paramString);
    return this;
  }
  
  public d d(boolean paramBoolean) {
    this.m.d(paramBoolean);
    return this;
  }
  
  public x e() {
    return this.l;
  }
  
  public d e(String paramString) {
    this.m.e(paramString);
    return this;
  }
  
  public d e(boolean paramBoolean) {
    this.m.c(paramBoolean);
    return this;
  }
  
  public i f() {
    return this.c;
  }
  
  public d f(String paramString) {
    this.m.f(paramString);
    return this;
  }
  
  public d f(boolean paramBoolean) {
    this.m.e(paramBoolean);
    return this;
  }
  
  public r g() {
    return this.p;
  }
  
  public d g(String paramString) {
    this.m.g(paramString);
    return this;
  }
  
  public d g(boolean paramBoolean) {
    this.m.f(paramBoolean);
    return this;
  }
  
  public u h() {
    return this.n;
  }
  
  public d h(String paramString) {
    this.m.h(paramString);
    return this;
  }
  
  public d h(boolean paramBoolean) {
    this.m.i(paramBoolean);
    return this;
  }
  
  public p i() {
    return this.o;
  }
  
  public d i(String paramString) {
    this.m.i(paramString);
    return this;
  }
  
  public d i(boolean paramBoolean) {
    this.m.g(paramBoolean);
    return this;
  }
  
  public z j() {
    return this.i;
  }
  
  public d j(boolean paramBoolean) {
    this.m.j(paramBoolean);
    return this;
  }
  
  public ac k() {
    return this.q;
  }
  
  public d k(boolean paramBoolean) {
    this.m.m(paramBoolean);
    return this;
  }
  
  public q l() {
    return this.s;
  }
  
  public d l(boolean paramBoolean) {
    this.m.h(paramBoolean);
    return this;
  }
  
  public d m(boolean paramBoolean) {
    this.m.k(paramBoolean);
    return this;
  }
  
  public boolean m() {
    c c1 = this.a;
    return (c1 != null) ? c1.af() : false;
  }
  
  public int n() {
    this.a = this.m.a();
    c.a().a(this);
    c c1 = this.a;
    return (c1 == null) ? 0 : c1.g();
  }
  
  public d n(boolean paramBoolean) {
    this.m.l(paramBoolean);
    return this;
  }
  
  public int o() {
    c c1 = this.a;
    return (c1 == null) ? 0 : c1.g();
  }
  
  public void p() {
    a.b("DownloadTask", "same task just tryDownloading, so add listener in last task instead of tryDownload");
    d(h.a);
    d(h.b);
    a.a(this.l, this.a, new a(1003, "has another same task, add Listener to old task"), 0);
  }
  
  public h q() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\g\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */