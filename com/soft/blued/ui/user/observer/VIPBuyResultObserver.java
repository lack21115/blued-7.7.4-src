package com.soft.blued.ui.user.observer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.ArrayList;

public class VIPBuyResultObserver {
  private static VIPBuyResultObserver a = new VIPBuyResultObserver();
  
  private ArrayList<IVIPBuyResultObserver> b = new ArrayList<IVIPBuyResultObserver>();
  
  public static VIPBuyResultObserver a() {
    return a;
  }
  
  public void a(int paramInt, boolean paramBoolean) {
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
    //   25: checkcast com/soft/blued/ui/user/observer/VIPBuyResultObserver$IVIPBuyResultObserver
    //   28: astore #4
    //   30: aload #4
    //   32: ifnull -> 10
    //   35: aload #4
    //   37: iload_1
    //   38: iload_2
    //   39: invokeinterface a : (IZ)V
    //   44: goto -> 10
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: astore_3
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_3
    //   54: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	50	finally
    //   10	30	50	finally
    //   35	44	50	finally
  }
  
  public void a(IVIPBuyResultObserver paramIVIPBuyResultObserver) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 26
    //   6: aload_0
    //   7: getfield b : Ljava/util/ArrayList;
    //   10: aload_1
    //   11: invokevirtual contains : (Ljava/lang/Object;)Z
    //   14: ifne -> 26
    //   17: aload_0
    //   18: getfield b : Ljava/util/ArrayList;
    //   21: aload_1
    //   22: invokevirtual add : (Ljava/lang/Object;)Z
    //   25: pop
    //   26: new java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial <init> : ()V
    //   33: astore_1
    //   34: aload_1
    //   35: ldc 'add==='
    //   37: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_1
    //   42: aload_0
    //   43: getfield b : Ljava/util/ArrayList;
    //   46: invokevirtual size : ()I
    //   49: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: ldc 'VIPBuyResultObserver'
    //   55: iconst_1
    //   56: anewarray java/lang/Object
    //   59: dup
    //   60: iconst_0
    //   61: aload_1
    //   62: invokevirtual toString : ()Ljava/lang/String;
    //   65: aastore
    //   66: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: aload_0
    //   70: monitorexit
    //   71: return
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    // Exception table:
    //   from	to	target	type
    //   6	26	72	finally
    //   26	69	72	finally
  }
  
  public void a(IVIPBuyResultObserver paramIVIPBuyResultObserver, Lifecycle paramLifecycle) {
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
    //   20: new com/soft/blued/ui/user/observer/VIPBuyResultObserver$1
    //   23: dup
    //   24: aload_0
    //   25: aload_1
    //   26: invokespecial <init> : (Lcom/soft/blued/ui/user/observer/VIPBuyResultObserver;Lcom/soft/blued/ui/user/observer/VIPBuyResultObserver$IVIPBuyResultObserver;)V
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
  
  public void b(IVIPBuyResultObserver paramIVIPBuyResultObserver) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 15
    //   6: aload_0
    //   7: getfield b : Ljava/util/ArrayList;
    //   10: aload_1
    //   11: invokevirtual remove : (Ljava/lang/Object;)Z
    //   14: pop
    //   15: new java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: astore_1
    //   23: aload_1
    //   24: ldc 'remove==='
    //   26: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_1
    //   31: aload_0
    //   32: getfield b : Ljava/util/ArrayList;
    //   35: invokevirtual size : ()I
    //   38: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: ldc 'VIPBuyResultObserver'
    //   44: iconst_1
    //   45: anewarray java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: aload_1
    //   51: invokevirtual toString : ()Ljava/lang/String;
    //   54: aastore
    //   55: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   58: aload_0
    //   59: monitorexit
    //   60: return
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Exception table:
    //   from	to	target	type
    //   6	15	61	finally
    //   15	58	61	finally
  }
  
  public static interface IVIPBuyResultObserver {
    void a(int param1Int, boolean param1Boolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\observer\VIPBuyResultObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */