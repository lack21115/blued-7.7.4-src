package com.amap.api.col.s;

import java.util.HashMap;

public class ad {
  private static volatile ad a;
  
  private HashMap<String, ae> b = new HashMap<String, ae>();
  
  public static ad a() {
    // Byte code:
    //   0: getstatic com/amap/api/col/s/ad.a : Lcom/amap/api/col/s/ad;
    //   3: ifnonnull -> 37
    //   6: ldc com/amap/api/col/s/ad
    //   8: monitorenter
    //   9: getstatic com/amap/api/col/s/ad.a : Lcom/amap/api/col/s/ad;
    //   12: ifnonnull -> 25
    //   15: new com/amap/api/col/s/ad
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/amap/api/col/s/ad.a : Lcom/amap/api/col/s/ad;
    //   25: ldc com/amap/api/col/s/ad
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/amap/api/col/s/ad
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/amap/api/col/s/ad.a : Lcom/amap/api/col/s/ad;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public final c a(b paramb) {
    if (paramb == null)
      return null; 
    for (ae ae : this.b.values()) {
      if (ae != null) {
        c c = ae.a(paramb);
        if (c != null)
          return c; 
      } 
    } 
    return null;
  }
  
  public final ae a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/HashMap;
    //   6: aload_1
    //   7: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast com/amap/api/col/s/ae
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: astore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_1
    //   22: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	18	finally
  }
  
  public final void a(a parama) {
    if (parama == null)
      return; 
    for (ae ae : this.b.values()) {
      if (ae != null)
        ae.a(parama); 
    } 
  }
  
  public final void a(b paramb, Object paramObject) {
    for (ae ae : this.b.values()) {
      if (ae != null)
        ae.a(paramb, paramObject); 
    } 
  }
  
  public final void a(String paramString, a parama) {
    if (paramString != null) {
      if (parama == null)
        return; 
      ae ae = this.b.get(paramString);
      if (ae != null)
        ae.a(parama); 
    } 
  }
  
  public final void a(String paramString, ae paramae) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/HashMap;
    //   6: aload_1
    //   7: aload_2
    //   8: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   11: pop
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	15	finally
  }
  
  public final boolean b(b paramb) {
    if (paramb == null)
      return false; 
    for (ae ae : this.b.values()) {
      if (ae != null && ae.b(paramb))
        return true; 
    } 
    return false;
  }
  
  static final class a {
    private boolean a = true;
    
    private long b = 86400L;
    
    private int c = 10;
    
    private double d = 0.0D;
    
    public final void a(double param1Double) {
      this.d = param1Double;
    }
    
    public final void a(int param1Int) {
      this.c = param1Int;
    }
    
    public final void a(long param1Long) {
      this.b = param1Long;
    }
    
    public final void a(boolean param1Boolean) {
      this.a = param1Boolean;
    }
    
    public final boolean a() {
      return this.a;
    }
    
    public final long b() {
      return this.b;
    }
    
    public final int c() {
      return this.c;
    }
    
    public final double d() {
      return this.d;
    }
  }
  
  static final class b {
    String a;
    
    Object b;
    
    public final boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (param1Object != null) {
        if (getClass() != param1Object.getClass())
          return false; 
        param1Object = param1Object;
        String str = this.a;
        if (str == null)
          return (((b)param1Object).a != null) ? false : ((this.b == ((b)param1Object).b)); 
        if (str.equals(((b)param1Object).a) && this.b == ((b)param1Object).b)
          return true; 
      } 
      return false;
    }
    
    public final int hashCode() {
      int i;
      String str = this.a;
      int j = 0;
      if (str == null) {
        i = 0;
      } else {
        i = str.hashCode();
      } 
      Object object = this.b;
      if (object != null)
        j = object.hashCode(); 
      return (i + 31) * 31 + j;
    }
  }
  
  static final class c {
    Object a;
    
    boolean b;
    
    public c(Object param1Object, boolean param1Boolean) {
      this.a = param1Object;
      this.b = param1Boolean;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */