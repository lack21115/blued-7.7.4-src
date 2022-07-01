package com.soft.blued.ui.find.observer;

import java.util.ArrayList;

public class FeedRefreshObserver {
  private static FeedRefreshObserver a = new FeedRefreshObserver();
  
  private ArrayList<IFeedRefreshObserver> b = new ArrayList<IFeedRefreshObserver>();
  
  public static FeedRefreshObserver a() {
    return a;
  }
  
  public void a(IFeedRefreshObserver paramIFeedRefreshObserver) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 34
    //   6: aload_0
    //   7: getfield b : Ljava/util/ArrayList;
    //   10: aload_1
    //   11: invokevirtual contains : (Ljava/lang/Object;)Z
    //   14: ifne -> 34
    //   17: aload_0
    //   18: getfield b : Ljava/util/ArrayList;
    //   21: aload_1
    //   22: invokevirtual add : (Ljava/lang/Object;)Z
    //   25: pop
    //   26: goto -> 34
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    // Exception table:
    //   from	to	target	type
    //   6	26	29	finally
  }
  
  public void a(Object paramObject, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/ArrayList;
    //   6: invokevirtual iterator : ()Ljava/util/Iterator;
    //   9: astore_3
    //   10: aload_3
    //   11: invokeinterface hasNext : ()Z
    //   16: ifeq -> 47
    //   19: aload_3
    //   20: invokeinterface next : ()Ljava/lang/Object;
    //   25: checkcast com/soft/blued/ui/find/observer/FeedRefreshObserver$IFeedRefreshObserver
    //   28: astore #4
    //   30: aload #4
    //   32: ifnull -> 10
    //   35: aload #4
    //   37: aload_1
    //   38: iload_2
    //   39: invokeinterface a : (Ljava/lang/Object;I)V
    //   44: goto -> 10
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	50	finally
    //   10	30	50	finally
    //   35	44	50	finally
  }
  
  public void b(IFeedRefreshObserver paramIFeedRefreshObserver) {
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
  
  public static interface IFeedRefreshObserver {
    void a(Object param1Object, int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\observer\FeedRefreshObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */