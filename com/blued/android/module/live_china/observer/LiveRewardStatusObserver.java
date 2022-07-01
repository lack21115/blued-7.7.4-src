package com.blued.android.module.live_china.observer;

import java.util.ArrayList;

public class LiveRewardStatusObserver {
  private static LiveRewardStatusObserver a = new LiveRewardStatusObserver();
  
  private ArrayList<ILiveRewardStatusObserver> b = new ArrayList<ILiveRewardStatusObserver>();
  
  public static LiveRewardStatusObserver a() {
    return a;
  }
  
  public void a(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/ArrayList;
    //   6: invokevirtual iterator : ()Ljava/util/Iterator;
    //   9: astore_2
    //   10: aload_2
    //   11: invokeinterface hasNext : ()Z
    //   16: ifeq -> 43
    //   19: aload_2
    //   20: invokeinterface next : ()Ljava/lang/Object;
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRewardStatusObserver$ILiveRewardStatusObserver
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull -> 10
    //   33: aload_3
    //   34: iload_1
    //   35: invokeinterface a : (I)V
    //   40: goto -> 10
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: astore_2
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_2
    //   50: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	46	finally
    //   10	29	46	finally
    //   33	40	46	finally
  }
  
  public void a(ILiveRewardStatusObserver paramILiveRewardStatusObserver) {
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
  
  public void b(ILiveRewardStatusObserver paramILiveRewardStatusObserver) {
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
  
  public static interface ILiveRewardStatusObserver {
    void a(int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\observer\LiveRewardStatusObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */