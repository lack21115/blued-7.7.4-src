package com.soft.blued.ui.msg.observer;

import java.util.ArrayList;
import java.util.List;

public class MessageSetSelectedTab {
  private static MessageSetSelectedTab a = new MessageSetSelectedTab();
  
  private List<IMessageSetSelectedTab> b = new ArrayList<IMessageSetSelectedTab>();
  
  public static MessageSetSelectedTab a() {
    return a;
  }
  
  public void a(IMessageSetSelectedTab paramIMessageSetSelectedTab) {
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
  
  public void b(IMessageSetSelectedTab paramIMessageSetSelectedTab) {
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
  
  public static interface IMessageSetSelectedTab {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\observer\MessageSetSelectedTab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */