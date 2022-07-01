package com.blued.android.module.live_china.observer;

import java.util.ArrayList;

public class BeansRefreshObserver {
  private static BeansRefreshObserver a = new BeansRefreshObserver();
  
  private ArrayList<IBeansRefreshObserver> b = new ArrayList<IBeansRefreshObserver>();
  
  public static BeansRefreshObserver a() {
    return a;
  }
  
  public void a(double paramDouble1, double paramDouble2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/ArrayList;
    //   6: invokevirtual iterator : ()Ljava/util/Iterator;
    //   9: astore #5
    //   11: aload #5
    //   13: invokeinterface hasNext : ()Z
    //   18: ifeq -> 50
    //   21: aload #5
    //   23: invokeinterface next : ()Ljava/lang/Object;
    //   28: checkcast com/blued/android/module/live_china/observer/BeansRefreshObserver$IBeansRefreshObserver
    //   31: astore #6
    //   33: aload #6
    //   35: ifnull -> 11
    //   38: aload #6
    //   40: dload_1
    //   41: dload_3
    //   42: invokeinterface a : (DD)V
    //   47: goto -> 11
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: astore #5
    //   55: aload_0
    //   56: monitorexit
    //   57: aload #5
    //   59: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	53	finally
    //   11	33	53	finally
    //   38	47	53	finally
  }
  
  public void a(IBeansRefreshObserver paramIBeansRefreshObserver) {
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
  
  public void b(IBeansRefreshObserver paramIBeansRefreshObserver) {
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
  
  public static interface IBeansRefreshObserver {
    void a(double param1Double1, double param1Double2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\observer\BeansRefreshObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */