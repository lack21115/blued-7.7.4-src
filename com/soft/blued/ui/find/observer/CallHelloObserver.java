package com.soft.blued.ui.find.observer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.soft.blued.ui.find.model.CallMeStatusData;
import java.util.ArrayList;

public class CallHelloObserver {
  private static CallHelloObserver a = new CallHelloObserver();
  
  private ArrayList<ICallHelloObserver> b = new ArrayList<ICallHelloObserver>();
  
  public static CallHelloObserver a() {
    return a;
  }
  
  public void a(int paramInt) {
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
    //   25: checkcast com/soft/blued/ui/find/observer/CallHelloObserver$ICallHelloObserver
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull -> 10
    //   33: aload_3
    //   34: iload_1
    //   35: invokeinterface b : (I)V
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
  
  public void a(CallMeStatusData paramCallMeStatusData) {
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
    //   25: checkcast com/soft/blued/ui/find/observer/CallHelloObserver$ICallHelloObserver
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull -> 10
    //   33: aload_3
    //   34: aload_1
    //   35: invokeinterface a : (Lcom/soft/blued/ui/find/model/CallMeStatusData;)V
    //   40: goto -> 10
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	46	finally
    //   10	29	46	finally
    //   33	40	46	finally
  }
  
  public void a(ICallHelloObserver paramICallHelloObserver, Lifecycle paramLifecycle) {
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
    //   20: new com/soft/blued/ui/find/observer/CallHelloObserver$1
    //   23: dup
    //   24: aload_0
    //   25: aload_1
    //   26: invokespecial <init> : (Lcom/soft/blued/ui/find/observer/CallHelloObserver;Lcom/soft/blued/ui/find/observer/CallHelloObserver$ICallHelloObserver;)V
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
  
  public void a(boolean paramBoolean, String paramString) {
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
    //   25: checkcast com/soft/blued/ui/find/observer/CallHelloObserver$ICallHelloObserver
    //   28: astore #4
    //   30: aload #4
    //   32: ifnull -> 10
    //   35: aload #4
    //   37: iload_1
    //   38: aload_2
    //   39: invokeinterface a : (ZLjava/lang/String;)V
    //   44: goto -> 10
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: astore_2
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_2
    //   54: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	50	finally
    //   10	30	50	finally
    //   35	44	50	finally
  }
  
  public static interface ICallHelloObserver {
    void a(CallMeStatusData param1CallMeStatusData);
    
    void a(boolean param1Boolean, String param1String);
    
    void b(int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\observer\CallHelloObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */