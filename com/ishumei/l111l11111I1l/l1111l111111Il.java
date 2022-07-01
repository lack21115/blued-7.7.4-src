package com.ishumei.l111l11111I1l;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.SparseArray;
import java.util.HashMap;
import java.util.Map;

public class l1111l111111Il {
  private static String l1111l111111Il = "sm";
  
  private static int l111l11111I1l = 2;
  
  private static int l111l11111Il = 3;
  
  private static int l111l11111lIl = 1;
  
  private static int l111l1111l1Il = 4;
  
  private static int l111l1111lI1l = 7;
  
  private static int[] l111l1111lIl = new int[] { 1, 2, 4, 6, 7 };
  
  private static int l111l1111llIl = 6;
  
  private static l1111l111111Il l11l1111I1l = null;
  
  private SparseArray<Handler> l11l1111I11l = new SparseArray();
  
  private Map<Long, Integer> l11l1111lIIl = new HashMap<Long, Integer>();
  
  private l1111l111111Il() {
    int[] arrayOfInt = l111l1111lIl;
    for (int i = 0; i < 5; i++) {
      int j = arrayOfInt[i];
      StringBuilder stringBuilder = new StringBuilder("sm-thread-");
      stringBuilder.append(j);
      HandlerThread handlerThread = new HandlerThread(stringBuilder.toString());
      handlerThread.start();
      Handler handler1 = new Handler(handlerThread.getLooper());
      this.l11l1111lIIl.put(Long.valueOf(handlerThread.getLooper().getThread().getId()), Integer.valueOf(j));
      this.l11l1111I11l.put(j, handler1);
    } 
    Handler handler = new Handler(Looper.getMainLooper());
    this.l11l1111lIIl.put(Long.valueOf(handler.getLooper().getThread().getId()), Integer.valueOf(3));
    this.l11l1111I11l.put(3, handler);
  }
  
  private int l1111l111111Il(long paramLong) {
    return ((Integer)this.l11l1111lIIl.get(Long.valueOf(paramLong))).intValue();
  }
  
  public static l1111l111111Il l111l11111lIl() {
    // Byte code:
    //   0: getstatic com/ishumei/l111l11111I1l/l1111l111111Il.l11l1111I1l : Lcom/ishumei/l111l11111I1l/l1111l111111Il;
    //   3: ifnonnull -> 37
    //   6: ldc com/ishumei/l111l11111I1l/l1111l111111Il
    //   8: monitorenter
    //   9: getstatic com/ishumei/l111l11111I1l/l1111l111111Il.l11l1111I1l : Lcom/ishumei/l111l11111I1l/l1111l111111Il;
    //   12: ifnonnull -> 25
    //   15: new com/ishumei/l111l11111I1l/l1111l111111Il
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/ishumei/l111l11111I1l/l1111l111111Il.l11l1111I1l : Lcom/ishumei/l111l11111I1l/l1111l111111Il;
    //   25: ldc com/ishumei/l111l11111I1l/l1111l111111Il
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/ishumei/l111l11111I1l/l1111l111111Il
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/ishumei/l111l11111I1l/l1111l111111Il.l11l1111I1l : Lcom/ishumei/l111l11111I1l/l1111l111111Il;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public final int l1111l111111Il() {
    return ((Integer)this.l11l1111lIIl.get(Long.valueOf(Thread.currentThread().getId()))).intValue();
  }
  
  public final Handler l1111l111111Il(int paramInt) {
    return (Handler)this.l11l1111I11l.get(paramInt);
  }
  
  public final void l1111l111111Il(Runnable paramRunnable, int paramInt) {
    l1111l111111Il(paramRunnable, paramInt, false, 0L, false);
  }
  
  public final void l1111l111111Il(Runnable paramRunnable, int paramInt, long paramLong, boolean paramBoolean) {
    l1111l111111Il(paramRunnable, paramInt, false, paramLong, paramBoolean);
  }
  
  public final void l1111l111111Il(Runnable paramRunnable, int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2) {
    Handler handler = l1111l111111Il(paramInt);
    if (handler == null)
      return; 
    if (paramBoolean2)
      handler.removeCallbacks(paramRunnable); 
    if (paramBoolean1) {
      handler.postAtFrontOfQueue(paramRunnable);
      return;
    } 
    handler.postDelayed(paramRunnable, paramLong);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111I1l\l1111l111111Il.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */