package com.soft.blued.ui.feed.observer;

import java.util.ArrayList;
import java.util.List;

public class AlbumViewObserver {
  private static AlbumViewObserver a = new AlbumViewObserver();
  
  private List<IAblumViewObserver> b = new ArrayList<IAblumViewObserver>();
  
  public static AlbumViewObserver a() {
    return a;
  }
  
  public void a(IAblumViewObserver paramIAblumViewObserver) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 25
    //   6: aload_0
    //   7: getfield b : Ljava/util/List;
    //   10: aload_1
    //   11: invokeinterface add : (Ljava/lang/Object;)Z
    //   16: pop
    //   17: goto -> 25
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    // Exception table:
    //   from	to	target	type
    //   6	17	20	finally
  }
  
  public void b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/List;
    //   6: invokeinterface iterator : ()Ljava/util/Iterator;
    //   11: astore_1
    //   12: aload_1
    //   13: invokeinterface hasNext : ()Z
    //   18: ifeq -> 44
    //   21: aload_1
    //   22: invokeinterface next : ()Ljava/lang/Object;
    //   27: checkcast com/soft/blued/ui/feed/observer/AlbumViewObserver$IAblumViewObserver
    //   30: astore_2
    //   31: aload_2
    //   32: ifnull -> 12
    //   35: aload_2
    //   36: invokeinterface a : ()V
    //   41: goto -> 12
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	47	finally
    //   12	31	47	finally
    //   35	41	47	finally
  }
  
  public void b(IAblumViewObserver paramIAblumViewObserver) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 25
    //   6: aload_0
    //   7: getfield b : Ljava/util/List;
    //   10: aload_1
    //   11: invokeinterface remove : (Ljava/lang/Object;)Z
    //   16: pop
    //   17: goto -> 25
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    // Exception table:
    //   from	to	target	type
    //   6	17	20	finally
  }
  
  public static interface IAblumViewObserver {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\observer\AlbumViewObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */