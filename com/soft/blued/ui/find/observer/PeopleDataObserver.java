package com.soft.blued.ui.find.observer;

import java.util.ArrayList;

public class PeopleDataObserver {
  private static PeopleDataObserver a = new PeopleDataObserver();
  
  private ArrayList<IFriendsDataRefreshObserver> b = new ArrayList<IFriendsDataRefreshObserver>();
  
  public static PeopleDataObserver a() {
    return a;
  }
  
  public void a(IFriendsDataRefreshObserver paramIFriendsDataRefreshObserver) {
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
    //   25: checkcast com/soft/blued/ui/find/observer/PeopleDataObserver$IFriendsDataRefreshObserver
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull -> 10
    //   33: aload_2
    //   34: invokeinterface p : ()V
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
  
  public void b(IFriendsDataRefreshObserver paramIFriendsDataRefreshObserver) {
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
    //   25: checkcast com/soft/blued/ui/find/observer/PeopleDataObserver$IFriendsDataRefreshObserver
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull -> 10
    //   33: aload_2
    //   34: invokeinterface q : ()V
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
  
  public static interface IFriendsDataRefreshObserver {
    void p();
    
    void q();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\observer\PeopleDataObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */