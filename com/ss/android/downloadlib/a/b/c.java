package com.ss.android.downloadlib.a.b;

import android.text.TextUtils;
import com.ss.android.downloadlib.d;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class c {
  private final AtomicBoolean a = new AtomicBoolean(false);
  
  private final ConcurrentHashMap<Long, com.ss.android.a.a.b.c> b = new ConcurrentHashMap<Long, com.ss.android.a.a.b.c>();
  
  private final ConcurrentHashMap<Long, com.ss.android.a.a.b.b> c = new ConcurrentHashMap<Long, com.ss.android.a.a.b.b>();
  
  private final ConcurrentHashMap<Long, com.ss.android.a.a.b.a> d = new ConcurrentHashMap<Long, com.ss.android.a.a.b.a>();
  
  private final ConcurrentHashMap<Long, com.ss.android.downloadad.a.b.a> e = new ConcurrentHashMap<Long, com.ss.android.downloadad.a.b.a>();
  
  private c() {}
  
  public static c a() {
    return b.a();
  }
  
  public com.ss.android.a.a.b.c a(long paramLong) {
    return this.b.get(Long.valueOf(paramLong));
  }
  
  public com.ss.android.downloadad.a.b.a a(com.ss.android.socialbase.downloader.g.c paramc) {
    if (paramc == null)
      return null; 
    for (com.ss.android.downloadad.a.b.a a : this.e.values()) {
      if (a == null)
        continue; 
      if (a.k() == paramc.g())
        return a; 
      if (TextUtils.equals(a.q(), paramc.j()))
        return a; 
    } 
    return null;
  }
  
  public com.ss.android.downloadad.a.b.a a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    for (com.ss.android.downloadad.a.b.a a : this.e.values()) {
      if (a != null && paramString.equals(a.d()))
        return a; 
    } 
    return null;
  }
  
  public void a(long paramLong, com.ss.android.a.a.b.a parama) {
    if (parama != null)
      this.d.put(Long.valueOf(paramLong), parama); 
  }
  
  public void a(long paramLong, com.ss.android.a.a.b.b paramb) {
    if (paramb != null)
      this.c.put(Long.valueOf(paramLong), paramb); 
  }
  
  public void a(com.ss.android.a.a.b.c paramc) {
    if (paramc != null) {
      this.b.put(Long.valueOf(paramc.d()), paramc);
      if (paramc.u() != null) {
        paramc.u().a(paramc.d());
        paramc.u().d(paramc.t());
      } 
    } 
  }
  
  public void a(com.ss.android.downloadad.a.b.a parama) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_0
    //   10: getfield e : Ljava/util/concurrent/ConcurrentHashMap;
    //   13: aload_1
    //   14: invokevirtual a : ()J
    //   17: invokestatic valueOf : (J)Ljava/lang/Long;
    //   20: aload_1
    //   21: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   24: pop
    //   25: invokestatic a : ()Lcom/ss/android/downloadlib/a/b/e;
    //   28: aload_1
    //   29: invokevirtual a : (Lcom/ss/android/downloadad/a/b/a;)V
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	32	35	finally
  }
  
  public void a(com.ss.android.downloadad.a.b.a parama, com.ss.android.socialbase.downloader.g.c paramc, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 157
    //   6: aload_2
    //   7: ifnonnull -> 13
    //   10: goto -> 157
    //   13: new org/json/JSONObject
    //   16: dup
    //   17: invokespecial <init> : ()V
    //   20: astore #4
    //   22: aload #4
    //   24: ldc 'download_url'
    //   26: aload_2
    //   27: invokevirtual j : ()Ljava/lang/String;
    //   30: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   33: pop
    //   34: aload #4
    //   36: ldc 'app_name'
    //   38: aload_2
    //   39: invokevirtual i : ()Ljava/lang/String;
    //   42: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   45: pop
    //   46: aload #4
    //   48: ldc 'cur_bytes'
    //   50: aload_2
    //   51: invokevirtual Z : ()J
    //   54: invokevirtual put : (Ljava/lang/String;J)Lorg/json/JSONObject;
    //   57: pop
    //   58: aload #4
    //   60: ldc 'total_bytes'
    //   62: aload_2
    //   63: invokevirtual ab : ()J
    //   66: invokevirtual put : (Ljava/lang/String;J)Lorg/json/JSONObject;
    //   69: pop
    //   70: aload #4
    //   72: ldc 'chunk_count'
    //   74: aload_2
    //   75: invokevirtual aV : ()I
    //   78: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   81: pop
    //   82: aload #4
    //   84: ldc 'network_quality'
    //   86: aload_2
    //   87: invokevirtual ad : ()Ljava/lang/String;
    //   90: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   93: pop
    //   94: aload #4
    //   96: ldc 'download_time'
    //   98: aload_2
    //   99: invokevirtual aw : ()J
    //   102: invokevirtual put : (Ljava/lang/String;J)Lorg/json/JSONObject;
    //   105: pop
    //   106: goto -> 114
    //   109: astore_2
    //   110: aload_2
    //   111: invokevirtual printStackTrace : ()V
    //   114: aload_1
    //   115: invokevirtual h : ()Lorg/json/JSONObject;
    //   118: aload #4
    //   120: invokestatic a : (Lorg/json/JSONObject;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   123: pop
    //   124: aload_1
    //   125: aload #4
    //   127: invokevirtual a : (Lorg/json/JSONObject;)V
    //   130: aload_3
    //   131: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   134: ifne -> 142
    //   137: aload_1
    //   138: aload_3
    //   139: invokevirtual a : (Ljava/lang/String;)V
    //   142: invokestatic a : ()Lcom/ss/android/downloadlib/a/b/e;
    //   145: aload_1
    //   146: invokevirtual a : (Lcom/ss/android/downloadad/a/b/a;)V
    //   149: aload_0
    //   150: monitorexit
    //   151: return
    //   152: astore_1
    //   153: aload_0
    //   154: monitorexit
    //   155: aload_1
    //   156: athrow
    //   157: aload_0
    //   158: monitorexit
    //   159: return
    // Exception table:
    //   from	to	target	type
    //   13	22	152	finally
    //   22	106	109	java/lang/Exception
    //   22	106	152	finally
    //   110	114	152	finally
    //   114	142	152	finally
    //   142	149	152	finally
  }
  
  public void a(List<Long> paramList) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/util/ArrayList
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore #4
    //   11: aload_1
    //   12: invokeinterface iterator : ()Ljava/util/Iterator;
    //   17: astore_1
    //   18: aload_1
    //   19: invokeinterface hasNext : ()Z
    //   24: ifeq -> 67
    //   27: aload_1
    //   28: invokeinterface next : ()Ljava/lang/Object;
    //   33: checkcast java/lang/Long
    //   36: invokevirtual longValue : ()J
    //   39: lstore_2
    //   40: aload #4
    //   42: lload_2
    //   43: invokestatic valueOf : (J)Ljava/lang/String;
    //   46: invokeinterface add : (Ljava/lang/Object;)Z
    //   51: pop
    //   52: aload_0
    //   53: getfield e : Ljava/util/concurrent/ConcurrentHashMap;
    //   56: lload_2
    //   57: invokestatic valueOf : (J)Ljava/lang/Long;
    //   60: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   63: pop
    //   64: goto -> 18
    //   67: invokestatic a : ()Lcom/ss/android/downloadlib/a/b/e;
    //   70: aload #4
    //   72: invokevirtual b : (Ljava/util/List;)V
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    // Exception table:
    //   from	to	target	type
    //   2	18	78	finally
    //   18	64	78	finally
    //   67	75	78	finally
  }
  
  public com.ss.android.a.a.b.b b(long paramLong) {
    return this.c.get(Long.valueOf(paramLong));
  }
  
  public void b() {
    d.a().b(new Runnable(this) {
          public void run() {
            if (c.a(this.a).compareAndSet(false, true))
              c.b(this.a).putAll(e.a().b()); 
          }
        });
  }
  
  public com.ss.android.a.a.b.a c(long paramLong) {
    return this.d.get(Long.valueOf(paramLong));
  }
  
  public ConcurrentHashMap<Long, com.ss.android.downloadad.a.b.a> c() {
    return this.e;
  }
  
  public com.ss.android.downloadad.a.b.a d(long paramLong) {
    return this.e.get(Long.valueOf(paramLong));
  }
  
  public a e(long paramLong) {
    a a = new a();
    a.a = paramLong;
    a.b = a(paramLong);
    a.c = b(paramLong);
    a.d = c(paramLong);
    if (a.d == null)
      a.d = (com.ss.android.a.a.b.a)new com.ss.android.downloadad.a.a.a(); 
    return a;
  }
  
  public void f(long paramLong) {
    this.b.remove(Long.valueOf(paramLong));
    this.c.remove(Long.valueOf(paramLong));
    this.d.remove(Long.valueOf(paramLong));
  }
  
  public static class a {
    public long a;
    
    public com.ss.android.a.a.b.c b;
    
    public com.ss.android.a.a.b.b c;
    
    public com.ss.android.a.a.b.a d;
    
    public a() {}
    
    public a(long param1Long, com.ss.android.a.a.b.c param1c, com.ss.android.a.a.b.b param1b, com.ss.android.a.a.b.a param1a) {
      this.a = param1Long;
      this.b = param1c;
      this.c = param1b;
      this.d = param1a;
    }
    
    public boolean a() {
      return (this.a <= 0L || this.b == null || this.c == null || this.d == null);
    }
  }
  
  static class b {
    private static c a = new c();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\a\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */