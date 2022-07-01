package com.bytedance.tea.crash.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Printer;
import android.util.SparseArray;
import com.bytedance.tea.crash.g.j;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class f implements Handler.Callback {
  private static Printer a;
  
  private static f b;
  
  private static final Printer j = new Printer() {
      public void println(String param1String) {
        if (param1String == null)
          return; 
        if (param1String.startsWith(">>>>> Dispatching")) {
          f.a().a(param1String);
        } else if (param1String.startsWith("<<<<< Finished")) {
          f.a().b(param1String);
        } 
        if (f.c() != null && f.c() != f.d())
          f.c().println(param1String); 
      }
    };
  
  private Handler c = new Handler(h.a().getLooper(), this);
  
  private int d = 0;
  
  private long e;
  
  private long f;
  
  private final SparseArray<List<Runnable>> g = new SparseArray();
  
  private final List<Printer> h = new LinkedList<Printer>();
  
  private final List<Printer> i = new LinkedList<Printer>();
  
  private boolean k = false;
  
  private boolean l;
  
  private f() {
    b();
  }
  
  public static f a() {
    // Byte code:
    //   0: getstatic com/bytedance/tea/crash/e/f.b : Lcom/bytedance/tea/crash/e/f;
    //   3: ifnonnull -> 37
    //   6: ldc com/bytedance/tea/crash/e/f
    //   8: monitorenter
    //   9: getstatic com/bytedance/tea/crash/e/f.b : Lcom/bytedance/tea/crash/e/f;
    //   12: ifnonnull -> 25
    //   15: new com/bytedance/tea/crash/e/f
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bytedance/tea/crash/e/f.b : Lcom/bytedance/tea/crash/e/f;
    //   25: ldc com/bytedance/tea/crash/e/f
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/bytedance/tea/crash/e/f
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/bytedance/tea/crash/e/f.b : Lcom/bytedance/tea/crash/e/f;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private static void a(List<? extends Runnable> paramList) {
    if (paramList != null) {
      if (paramList.isEmpty())
        return; 
      try {
        Iterator<? extends Runnable> iterator = paramList.iterator();
        while (iterator.hasNext())
          ((Runnable)iterator.next()).run(); 
      } catch (Exception exception) {
        j.a(exception);
      } 
    } 
  }
  
  private void a(List<? extends Printer> paramList, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 67
    //   6: aload_1
    //   7: invokeinterface isEmpty : ()Z
    //   12: istore_3
    //   13: iload_3
    //   14: ifeq -> 20
    //   17: goto -> 67
    //   20: aload_1
    //   21: invokeinterface iterator : ()Ljava/util/Iterator;
    //   26: astore_1
    //   27: aload_1
    //   28: invokeinterface hasNext : ()Z
    //   33: ifeq -> 59
    //   36: aload_1
    //   37: invokeinterface next : ()Ljava/lang/Object;
    //   42: checkcast android/util/Printer
    //   45: aload_2
    //   46: invokeinterface println : (Ljava/lang/String;)V
    //   51: goto -> 27
    //   54: astore_1
    //   55: aload_1
    //   56: invokestatic a : (Ljava/lang/Throwable;)V
    //   59: aload_0
    //   60: monitorexit
    //   61: return
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    //   67: aload_0
    //   68: monitorexit
    //   69: return
    // Exception table:
    //   from	to	target	type
    //   6	13	62	finally
    //   20	27	54	java/lang/Exception
    //   20	27	62	finally
    //   27	51	54	java/lang/Exception
    //   27	51	62	finally
    //   55	59	62	finally
  }
  
  private Printer e() {
    try {
      Field field = Class.forName("android.os.Looper").getDeclaredField("mLogging");
      field.setAccessible(true);
      return (Printer)field.get(Looper.getMainLooper());
    } catch (Exception exception) {
      j.b(exception);
      return null;
    } 
  }
  
  public void a(long paramLong, Runnable paramRunnable) {
    a(paramLong, paramRunnable, 1, 0L);
  }
  
  public void a(long paramLong1, Runnable paramRunnable, int paramInt, long paramLong2) {
    if (paramLong1 < 0L)
      return; 
    int i;
    for (i = 0; i < paramInt; i++) {
      SparseArray<List<Runnable>> sparseArray = this.g;
      int j = (int)paramLong1;
      List<Runnable> list2 = (List)sparseArray.get(j);
      List<Runnable> list1 = list2;
      if (list2 == null)
        synchronized (this.g) {
          list2 = (List)this.g.get(j);
          list1 = list2;
          if (list2 == null) {
            list1 = new LinkedList();
            this.g.put(j, list1);
          } 
        }  
      list1.add(paramRunnable);
      paramLong1 += paramLong2;
    } 
  }
  
  public void a(Printer paramPrinter) {
    this.i.add(paramPrinter);
  }
  
  void a(String paramString) {
    if (!this.l) {
      g.a(32L);
      this.l = true;
    } 
    this.e = SystemClock.uptimeMillis();
    try {
      a(this.h, paramString);
      this.c.sendEmptyMessage(0);
      return;
    } catch (Exception exception) {
      j.a(exception);
      return;
    } 
  }
  
  public void b() {
    if (this.k)
      return; 
    this.k = true;
    a = e();
    if (a == j)
      a = null; 
    Looper.getMainLooper().setMessageLogging(j);
  }
  
  public void b(Printer paramPrinter) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield h : Ljava/util/List;
    //   6: aload_1
    //   7: invokeinterface add : (Ljava/lang/Object;)Z
    //   12: pop
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	16	finally
  }
  
  void b(String paramString) {
    this.f = SystemClock.uptimeMillis();
    try {
      this.c.removeMessages(2);
      a(this.i, paramString);
      this.c.sendEmptyMessage(1);
      return;
    } catch (Exception exception) {
      j.b(exception);
      return;
    } 
  }
  
  public boolean handleMessage(Message paramMessage) {
    if (this.c.hasMessages(0))
      return true; 
    int i = paramMessage.what;
    if (i != 0) {
      if (i != 1) {
        if (i == 2) {
          a((List<? extends Runnable>)this.g.valueAt(this.d));
          this.d++;
        } 
      } else {
        this.c.removeMessages(2);
        if (this.g.size() != 0) {
          SparseArray<List<Runnable>> sparseArray = this.g;
          if (sparseArray.keyAt(sparseArray.size() - 1) == 0)
            a((List<? extends Runnable>)this.g.get(2147483647)); 
        } 
        return true;
      } 
    } else {
      this.d = 0;
      if (this.g.size() != 0 && this.g.keyAt(0) == 0) {
        a((List<? extends Runnable>)this.g.valueAt(0));
        this.d++;
      } 
    } 
    if (this.d >= this.g.size())
      return true; 
    long l = this.g.keyAt(this.d);
    if (l != 2147483647L)
      this.c.sendEmptyMessageAtTime(2, this.e + l); 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\e\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */