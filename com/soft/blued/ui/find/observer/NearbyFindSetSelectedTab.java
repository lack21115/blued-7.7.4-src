package com.soft.blued.ui.find.observer;

import java.util.ArrayList;
import java.util.List;

public class NearbyFindSetSelectedTab {
  private static NearbyFindSetSelectedTab a = new NearbyFindSetSelectedTab();
  
  private List<INearbyFindSetSelectedTab> b = new ArrayList<INearbyFindSetSelectedTab>();
  
  public static NearbyFindSetSelectedTab a() {
    return a;
  }
  
  public void a(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/List;
    //   6: invokeinterface iterator : ()Ljava/util/Iterator;
    //   11: astore_2
    //   12: aload_2
    //   13: invokeinterface hasNext : ()Z
    //   18: ifeq -> 45
    //   21: aload_2
    //   22: invokeinterface next : ()Ljava/lang/Object;
    //   27: checkcast com/soft/blued/ui/find/observer/NearbyFindSetSelectedTab$INearbyFindSetSelectedTab
    //   30: astore_3
    //   31: aload_3
    //   32: ifnull -> 12
    //   35: aload_3
    //   36: iload_1
    //   37: invokeinterface a : (I)V
    //   42: goto -> 12
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: astore_2
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_2
    //   52: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	48	finally
    //   12	31	48	finally
    //   35	42	48	finally
  }
  
  public void a(INearbyFindSetSelectedTab paramINearbyFindSetSelectedTab) {
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
  
  public void b(INearbyFindSetSelectedTab paramINearbyFindSetSelectedTab) {
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
  
  public static interface INearbyFindSetSelectedTab {
    void a(int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\observer\NearbyFindSetSelectedTab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */