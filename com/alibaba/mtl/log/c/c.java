package com.alibaba.mtl.log.c;

import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.r;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class c {
  private static c a;
  
  private a a = new b(com.alibaba.mtl.log.a.getContext());
  
  private Runnable b = new Runnable(this) {
      public void run() {
        this.b.G();
      }
    };
  
  private List<com.alibaba.mtl.log.model.a> l = new CopyOnWriteArrayList<com.alibaba.mtl.log.model.a>();
  
  private c() {
    com.alibaba.mtl.log.d.a.a().start();
    r.a().b(new a(this));
  }
  
  private void H() {
    Calendar calendar = Calendar.getInstance();
    calendar.add(5, -3);
    long l = calendar.getTimeInMillis();
    this.a.c("time", String.valueOf(l));
  }
  
  private void I() {
    this.a.e(1000);
  }
  
  public static c a() {
    // Byte code:
    //   0: ldc com/alibaba/mtl/log/c/c
    //   2: monitorenter
    //   3: getstatic com/alibaba/mtl/log/c/c.a : Lcom/alibaba/mtl/log/c/c;
    //   6: ifnonnull -> 19
    //   9: new com/alibaba/mtl/log/c/c
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/alibaba/mtl/log/c/c.a : Lcom/alibaba/mtl/log/c/c;
    //   19: getstatic com/alibaba/mtl/log/c/c.a : Lcom/alibaba/mtl/log/c/c;
    //   22: astore_0
    //   23: ldc com/alibaba/mtl/log/c/c
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/alibaba/mtl/log/c/c
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
  }
  
  public void G() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'LogStoreMgr'
    //   4: iconst_1
    //   5: anewarray java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: ldc '[store]'
    //   12: aastore
    //   13: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   16: aconst_null
    //   17: astore_1
    //   18: aload_0
    //   19: getfield l : Ljava/util/List;
    //   22: astore_2
    //   23: aload_2
    //   24: monitorenter
    //   25: aload_0
    //   26: getfield l : Ljava/util/List;
    //   29: invokeinterface size : ()I
    //   34: ifle -> 58
    //   37: new java/util/ArrayList
    //   40: dup
    //   41: aload_0
    //   42: getfield l : Ljava/util/List;
    //   45: invokespecial <init> : (Ljava/util/Collection;)V
    //   48: astore_1
    //   49: aload_0
    //   50: getfield l : Ljava/util/List;
    //   53: invokeinterface clear : ()V
    //   58: aload_2
    //   59: monitorexit
    //   60: aload_1
    //   61: ifnull -> 92
    //   64: aload_1
    //   65: invokeinterface size : ()I
    //   70: ifle -> 92
    //   73: aload_0
    //   74: getfield a : Lcom/alibaba/mtl/log/c/a;
    //   77: aload_1
    //   78: invokeinterface a : (Ljava/util/List;)Z
    //   83: pop
    //   84: goto -> 92
    //   87: astore_1
    //   88: aload_2
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    //   92: aload_0
    //   93: monitorexit
    //   94: return
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    //   100: astore_1
    //   101: goto -> 92
    // Exception table:
    //   from	to	target	type
    //   2	16	95	finally
    //   18	25	100	finally
    //   25	58	87	finally
    //   58	60	87	finally
    //   64	84	100	finally
    //   88	90	87	finally
    //   90	92	100	finally
  }
  
  public int a(List<com.alibaba.mtl.log.model.a> paramList) {
    i.a("LogStoreMgr", new Object[] { paramList });
    return this.a.a(paramList);
  }
  
  public List<com.alibaba.mtl.log.model.a> a(String paramString, int paramInt) {
    List<com.alibaba.mtl.log.model.a> list = this.a.a(paramString, paramInt);
    i.a("LogStoreMgr", new Object[] { "[get]", list });
    return list;
  }
  
  public void a(com.alibaba.mtl.log.model.a parama) {
    i.a("LogStoreMgr", new Object[] { "[add] :", parama.X });
    com.alibaba.mtl.log.b.a.m(parama.T);
    this.l.add(parama);
    if (this.l.size() >= 100) {
      r.a().f(1);
      r.a().a(1, this.b, 0L);
      return;
    } 
    if (!r.a().b(1))
      r.a().a(1, this.b, 5000L); 
  }
  
  public void clear() {
    i.a("LogStoreMgr", new Object[] { "[clear]" });
    this.a.clear();
    this.l.clear();
  }
  
  class a implements Runnable {
    a(c this$0) {}
    
    public void run() {
      c.a(this.b);
      if (c.a(this.b).g() > 9000)
        c.b(this.b); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */