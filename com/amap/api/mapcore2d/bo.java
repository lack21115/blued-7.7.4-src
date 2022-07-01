package com.amap.api.mapcore2d;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

class bo<T> {
  protected LinkedList<T> a = new LinkedList<T>();
  
  protected final Semaphore b = new Semaphore(0, false);
  
  protected boolean c = true;
  
  public ArrayList<T> a(int paramInt, boolean paramBoolean) {
    LinkedList<T> linkedList = this.a;
    ArrayList<T> arrayList1 = null;
    ArrayList<T> arrayList2 = null;
    if (linkedList != null) {
      if (linkedList.size() == 0)
        return null; 
      try {
        this.b.acquire();
      } catch (InterruptedException interruptedException) {}
      arrayList1 = arrayList2;
      try {
      
      } finally {
        arrayList1 = null;
      } 
      this.b.release();
    } 
    return arrayList1;
  }
  
  public void a() {
    this.c = false;
    this.b.release(100);
  }
  
  public void a(List<T> paramList, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Ljava/util/LinkedList;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnonnull -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: iload_2
    //   15: iconst_1
    //   16: if_icmpne -> 26
    //   19: aload_0
    //   20: getfield a : Ljava/util/LinkedList;
    //   23: invokevirtual clear : ()V
    //   26: aload_1
    //   27: ifnull -> 39
    //   30: aload_0
    //   31: getfield a : Ljava/util/LinkedList;
    //   34: aload_1
    //   35: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   38: pop
    //   39: aload_0
    //   40: getfield b : Ljava/util/concurrent/Semaphore;
    //   43: invokevirtual release : ()V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    //   54: astore_1
    //   55: goto -> 46
    // Exception table:
    //   from	to	target	type
    //   2	7	49	finally
    //   19	26	54	finally
    //   30	39	54	finally
    //   39	46	54	finally
  }
  
  protected ArrayList<T> b(int paramInt, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Ljava/util/LinkedList;
    //   6: astore #5
    //   8: aload #5
    //   10: ifnonnull -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: aconst_null
    //   16: areturn
    //   17: aload_0
    //   18: getfield a : Ljava/util/LinkedList;
    //   21: invokevirtual size : ()I
    //   24: istore #4
    //   26: iload_1
    //   27: istore_3
    //   28: iload_1
    //   29: iload #4
    //   31: if_icmple -> 37
    //   34: iload #4
    //   36: istore_3
    //   37: new java/util/ArrayList
    //   40: dup
    //   41: iload_3
    //   42: invokespecial <init> : (I)V
    //   45: astore #5
    //   47: iconst_0
    //   48: istore_1
    //   49: iload_1
    //   50: iload_3
    //   51: if_icmpge -> 83
    //   54: aload #5
    //   56: aload_0
    //   57: getfield a : Ljava/util/LinkedList;
    //   60: iconst_0
    //   61: invokevirtual get : (I)Ljava/lang/Object;
    //   64: invokevirtual add : (Ljava/lang/Object;)Z
    //   67: pop
    //   68: aload_0
    //   69: getfield a : Ljava/util/LinkedList;
    //   72: invokevirtual removeFirst : ()Ljava/lang/Object;
    //   75: pop
    //   76: iload_1
    //   77: iconst_1
    //   78: iadd
    //   79: istore_1
    //   80: goto -> 49
    //   83: aload_0
    //   84: monitorexit
    //   85: aload #5
    //   87: areturn
    //   88: astore #5
    //   90: aload_0
    //   91: monitorexit
    //   92: aload #5
    //   94: athrow
    // Exception table:
    //   from	to	target	type
    //   2	8	88	finally
    //   17	26	88	finally
    //   37	47	88	finally
    //   54	76	88	finally
  }
  
  public void b() {
    LinkedList<T> linkedList = this.a;
    if (linkedList == null)
      return; 
    linkedList.clear();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */