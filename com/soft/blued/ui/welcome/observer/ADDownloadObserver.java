package com.soft.blued.ui.welcome.observer;

import java.util.ArrayList;

public class ADDownloadObserver {
  private static ADDownloadObserver a = new ADDownloadObserver();
  
  private ArrayList<IADDownloadObserver> b = new ArrayList<IADDownloadObserver>();
  
  public static ADDownloadObserver a() {
    return a;
  }
  
  public void a(IADDownloadObserver paramIADDownloadObserver) {
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
    //   16: ifeq -> 42
    //   19: aload_1
    //   20: invokeinterface next : ()Ljava/lang/Object;
    //   25: checkcast com/soft/blued/ui/welcome/observer/ADDownloadObserver$IADDownloadObserver
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull -> 10
    //   33: aload_2
    //   34: invokeinterface n : ()V
    //   39: goto -> 10
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	45	finally
    //   10	29	45	finally
    //   33	39	45	finally
  }
  
  public void b(IADDownloadObserver paramIADDownloadObserver) {
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
    //   16: ifeq -> 42
    //   19: aload_1
    //   20: invokeinterface next : ()Ljava/lang/Object;
    //   25: checkcast com/soft/blued/ui/welcome/observer/ADDownloadObserver$IADDownloadObserver
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull -> 10
    //   33: aload_2
    //   34: invokeinterface o : ()V
    //   39: goto -> 10
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	45	finally
    //   10	29	45	finally
    //   33	39	45	finally
  }
  
  public void d() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/ArrayList;
    //   6: invokevirtual iterator : ()Ljava/util/Iterator;
    //   9: astore_1
    //   10: aload_1
    //   11: invokeinterface hasNext : ()Z
    //   16: ifeq -> 42
    //   19: aload_1
    //   20: invokeinterface next : ()Ljava/lang/Object;
    //   25: checkcast com/soft/blued/ui/welcome/observer/ADDownloadObserver$IADDownloadObserver
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull -> 10
    //   33: aload_2
    //   34: invokeinterface m : ()V
    //   39: goto -> 10
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	45	finally
    //   10	29	45	finally
    //   33	39	45	finally
  }
  
  public static interface IADDownloadObserver {
    void m();
    
    void n();
    
    void o();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\welcome\observer\ADDownloadObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */