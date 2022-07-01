package com.soft.blued.ui.live.manager;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class LiveHotViewScrollObserver {
  private static LiveHotViewScrollObserver a = new LiveHotViewScrollObserver();
  
  private ArrayList<IScrollObserver> b = new ArrayList<IScrollObserver>();
  
  public static LiveHotViewScrollObserver a() {
    return a;
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/ArrayList;
    //   6: invokevirtual iterator : ()Ljava/util/Iterator;
    //   9: astore #4
    //   11: aload #4
    //   13: invokeinterface hasNext : ()Z
    //   18: ifeq -> 51
    //   21: aload #4
    //   23: invokeinterface next : ()Ljava/lang/Object;
    //   28: checkcast com/soft/blued/ui/live/manager/LiveHotViewScrollObserver$IScrollObserver
    //   31: astore #5
    //   33: aload #5
    //   35: ifnull -> 11
    //   38: aload #5
    //   40: aload_1
    //   41: iload_2
    //   42: iload_3
    //   43: invokeinterface a : (Landroidx/recyclerview/widget/RecyclerView;II)V
    //   48: goto -> 11
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	54	finally
    //   11	33	54	finally
    //   38	48	54	finally
  }
  
  public void a(IScrollObserver paramIScrollObserver) {
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
  
  public void b(IScrollObserver paramIScrollObserver) {
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
  
  public static interface IScrollObserver {
    void a(RecyclerView param1RecyclerView, int param1Int1, int param1Int2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\manager\LiveHotViewScrollObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */