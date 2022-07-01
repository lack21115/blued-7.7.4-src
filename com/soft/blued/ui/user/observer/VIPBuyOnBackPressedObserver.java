package com.soft.blued.ui.user.observer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.ArrayList;

public class VIPBuyOnBackPressedObserver {
  private static VIPBuyOnBackPressedObserver a = new VIPBuyOnBackPressedObserver();
  
  private ArrayList<IVIPBuyOnBackPressedObserver> b = new ArrayList<IVIPBuyOnBackPressedObserver>();
  
  public static VIPBuyOnBackPressedObserver a() {
    return a;
  }
  
  public void a(IVIPBuyOnBackPressedObserver paramIVIPBuyOnBackPressedObserver, Lifecycle paramLifecycle) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 40
    //   6: aload_2
    //   7: ifnull -> 40
    //   10: aload_0
    //   11: getfield b : Ljava/util/ArrayList;
    //   14: aload_1
    //   15: invokevirtual add : (Ljava/lang/Object;)Z
    //   18: pop
    //   19: aload_2
    //   20: new com/soft/blued/ui/user/observer/VIPBuyOnBackPressedObserver$1
    //   23: dup
    //   24: aload_0
    //   25: aload_1
    //   26: invokespecial <init> : (Lcom/soft/blued/ui/user/observer/VIPBuyOnBackPressedObserver;Lcom/soft/blued/ui/user/observer/VIPBuyOnBackPressedObserver$IVIPBuyOnBackPressedObserver;)V
    //   29: invokevirtual addObserver : (Landroidx/lifecycle/LifecycleObserver;)V
    //   32: goto -> 40
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    //   40: aload_0
    //   41: monitorexit
    //   42: return
    // Exception table:
    //   from	to	target	type
    //   10	32	35	finally
  }
  
  public boolean b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/ArrayList;
    //   6: invokevirtual iterator : ()Ljava/util/Iterator;
    //   9: astore_1
    //   10: aload_1
    //   11: invokeinterface hasNext : ()Z
    //   16: ifeq -> 43
    //   19: aload_1
    //   20: invokeinterface next : ()Ljava/lang/Object;
    //   25: checkcast com/soft/blued/ui/user/observer/VIPBuyOnBackPressedObserver$IVIPBuyOnBackPressedObserver
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull -> 10
    //   33: aload_2
    //   34: invokeinterface V_ : ()Z
    //   39: pop
    //   40: goto -> 10
    //   43: aload_0
    //   44: monitorexit
    //   45: iconst_0
    //   46: ireturn
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	47	finally
    //   10	29	47	finally
    //   33	40	47	finally
  }
  
  public static interface IVIPBuyOnBackPressedObserver {
    boolean V_();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\observer\VIPBuyOnBackPressedObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */