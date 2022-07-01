package com.soft.blued.ui.video.manager;

import com.blued.android.module.common.listener.SysNetworkListener;
import java.util.ArrayList;

public class NetWorkObserverManager {
  private static final NetWorkObserverManager a = new NetWorkObserverManager();
  
  private ArrayList<SysNetworkListener> b = new ArrayList<SysNetworkListener>();
  
  public static NetWorkObserverManager a() {
    return a;
  }
  
  public void a(boolean paramBoolean) {
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
    //   25: checkcast com/blued/android/module/common/listener/SysNetworkListener
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull -> 10
    //   33: aload_3
    //   34: iload_1
    //   35: invokeinterface a : (Z)V
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
  
  public void b(boolean paramBoolean) {
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
    //   25: checkcast com/blued/android/module/common/listener/SysNetworkListener
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull -> 10
    //   33: aload_3
    //   34: iload_1
    //   35: invokeinterface b : (Z)V
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
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\manager\NetWorkObserverManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */