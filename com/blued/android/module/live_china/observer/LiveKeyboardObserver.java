package com.blued.android.module.live_china.observer;

import java.util.ArrayList;

public class LiveKeyboardObserver {
  private static LiveKeyboardObserver a = new LiveKeyboardObserver();
  
  private ArrayList<ILiveKeyboardObserver> b = new ArrayList<ILiveKeyboardObserver>();
  
  public static LiveKeyboardObserver a() {
    return a;
  }
  
  public void a(ILiveKeyboardObserver paramILiveKeyboardObserver) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 23
    //   6: aload_0
    //   7: getfield b : Ljava/util/ArrayList;
    //   10: aload_1
    //   11: invokevirtual add : (Ljava/lang/Object;)Z
    //   14: pop
    //   15: goto -> 23
    //   18: astore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_1
    //   22: athrow
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    // Exception table:
    //   from	to	target	type
    //   6	15	18	finally
  }
  
  public void b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/ArrayList;
    //   6: invokevirtual iterator : ()Ljava/util/Iterator;
    //   9: astore_1
    //   10: aload_1
    //   11: invokeinterface hasNext : ()Z
    //   16: ifeq -> 39
    //   19: aload_1
    //   20: invokeinterface next : ()Ljava/lang/Object;
    //   25: checkcast com/blued/android/module/live_china/observer/LiveKeyboardObserver$ILiveKeyboardObserver
    //   28: astore_1
    //   29: aload_1
    //   30: ifnull -> 39
    //   33: aload_1
    //   34: invokeinterface g : ()V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Exception table:
    //   from	to	target	type
    //   2	29	42	finally
    //   33	39	42	finally
  }
  
  public void b(ILiveKeyboardObserver paramILiveKeyboardObserver) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 23
    //   6: aload_0
    //   7: getfield b : Ljava/util/ArrayList;
    //   10: aload_1
    //   11: invokevirtual remove : (Ljava/lang/Object;)Z
    //   14: pop
    //   15: goto -> 23
    //   18: astore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_1
    //   22: athrow
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    // Exception table:
    //   from	to	target	type
    //   6	15	18	finally
  }
  
  public void c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/ArrayList;
    //   6: invokevirtual iterator : ()Ljava/util/Iterator;
    //   9: astore_1
    //   10: aload_1
    //   11: invokeinterface hasNext : ()Z
    //   16: ifeq -> 39
    //   19: aload_1
    //   20: invokeinterface next : ()Ljava/lang/Object;
    //   25: checkcast com/blued/android/module/live_china/observer/LiveKeyboardObserver$ILiveKeyboardObserver
    //   28: astore_1
    //   29: aload_1
    //   30: ifnull -> 39
    //   33: aload_1
    //   34: invokeinterface h : ()V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Exception table:
    //   from	to	target	type
    //   2	29	42	finally
    //   33	39	42	finally
  }
  
  public static interface ILiveKeyboardObserver {
    void g();
    
    void h();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\observer\LiveKeyboardObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */