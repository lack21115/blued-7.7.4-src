package com.blued.android.module.live_china.observer;

import android.app.AlertDialog;
import com.blued.android.module.live_china.model.GrabBoxModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import java.util.ArrayList;

public class LiveRefreshUIObserver {
  private static LiveRefreshUIObserver a = new LiveRefreshUIObserver();
  
  private ArrayList<ILiveRefreshUIObserver> b = new ArrayList<ILiveRefreshUIObserver>();
  
  public static LiveRefreshUIObserver a() {
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
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull -> 10
    //   33: aload_3
    //   34: iload_1
    //   35: invokeinterface h : (I)V
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
  
  public void a(int paramInt, String paramString) {
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
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
    //   28: astore #4
    //   30: aload #4
    //   32: ifnull -> 10
    //   35: aload #4
    //   37: iload_1
    //   38: aload_2
    //   39: invokeinterface a : (ILjava/lang/String;)V
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
  
  public void a(long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/ArrayList;
    //   6: invokevirtual iterator : ()Ljava/util/Iterator;
    //   9: astore_3
    //   10: aload_3
    //   11: invokeinterface hasNext : ()Z
    //   16: ifeq -> 46
    //   19: aload_3
    //   20: invokeinterface next : ()Ljava/lang/Object;
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
    //   28: astore #4
    //   30: aload #4
    //   32: ifnull -> 10
    //   35: aload #4
    //   37: lload_1
    //   38: invokeinterface c : (J)V
    //   43: goto -> 10
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_3
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_3
    //   53: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	49	finally
    //   10	30	49	finally
    //   35	43	49	finally
  }
  
  public void a(AlertDialog paramAlertDialog) {
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
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull -> 10
    //   33: aload_3
    //   34: aload_1
    //   35: invokeinterface a : (Landroid/app/AlertDialog;)V
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
  
  public void a(GrabBoxModel paramGrabBoxModel) {
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
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull -> 10
    //   33: aload_3
    //   34: aload_1
    //   35: invokeinterface a : (Lcom/blued/android/module/live_china/model/GrabBoxModel;)V
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
  
  public void a(LiveGiftModel paramLiveGiftModel) {
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
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull -> 10
    //   33: aload_3
    //   34: aload_1
    //   35: invokeinterface a : (Lcom/blued/android/module/live_china/model/LiveGiftModel;)V
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
  
  public void a(ILiveRefreshUIObserver paramILiveRefreshUIObserver) {
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
  
  public void a(String paramString, int paramInt) {
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
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
    //   28: astore #4
    //   30: aload #4
    //   32: ifnull -> 10
    //   35: aload #4
    //   37: aload_1
    //   38: iload_2
    //   39: invokeinterface c : (Ljava/lang/String;I)V
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
  
  public void a(String paramString1, String paramString2) {
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
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
    //   28: astore #4
    //   30: aload #4
    //   32: ifnull -> 10
    //   35: aload #4
    //   37: aload_1
    //   38: aload_2
    //   39: invokeinterface b : (Ljava/lang/String;Ljava/lang/String;)V
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
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
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
  
  public void a(boolean paramBoolean, int paramInt) {
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
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
    //   28: astore #4
    //   30: aload #4
    //   32: ifnull -> 10
    //   35: aload #4
    //   37: iload_1
    //   38: iload_2
    //   39: invokeinterface a : (ZI)V
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
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull -> 10
    //   33: aload_2
    //   34: invokeinterface aL : ()V
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
  
  public void b(int paramInt) {
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
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull -> 10
    //   33: aload_3
    //   34: iload_1
    //   35: invokeinterface g : (I)V
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
  
  public void b(ILiveRefreshUIObserver paramILiveRefreshUIObserver) {
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
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull -> 10
    //   33: aload_3
    //   34: iload_1
    //   35: invokeinterface h : (Z)V
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
  
  public void b(boolean paramBoolean, int paramInt) {
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
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
    //   28: astore #4
    //   30: aload #4
    //   32: ifnull -> 10
    //   35: aload #4
    //   37: iload_1
    //   38: iload_2
    //   39: invokeinterface b : (ZI)V
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
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull -> 10
    //   33: aload_2
    //   34: invokeinterface aM : ()V
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
  
  public void c(int paramInt) {
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
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull -> 10
    //   33: aload_3
    //   34: iload_1
    //   35: invokeinterface f : (I)V
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
  
  public void c(boolean paramBoolean) {
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
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull -> 10
    //   33: aload_3
    //   34: iload_1
    //   35: invokeinterface c : (Z)V
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
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull -> 10
    //   33: aload_2
    //   34: invokeinterface aI : ()V
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
  
  public void d(int paramInt) {
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
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull -> 10
    //   33: aload_3
    //   34: iload_1
    //   35: invokeinterface i : (I)V
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
  
  public void d(boolean paramBoolean) {
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
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull -> 10
    //   33: aload_3
    //   34: iload_1
    //   35: invokeinterface d : (Z)V
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
  
  public boolean e() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/ArrayList;
    //   6: invokevirtual iterator : ()Ljava/util/Iterator;
    //   9: astore_2
    //   10: aload_2
    //   11: invokeinterface hasNext : ()Z
    //   16: ifeq -> 44
    //   19: aload_2
    //   20: invokeinterface next : ()Ljava/lang/Object;
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull -> 10
    //   33: aload_3
    //   34: invokeinterface aH : ()Z
    //   39: istore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: iload_1
    //   43: ireturn
    //   44: aload_0
    //   45: monitorexit
    //   46: iconst_1
    //   47: ireturn
    //   48: astore_2
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_2
    //   52: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	48	finally
    //   10	29	48	finally
    //   33	40	48	finally
  }
  
  public void f() {
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
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull -> 10
    //   33: aload_2
    //   34: invokeinterface am : ()V
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
  
  public void g() {
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
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull -> 10
    //   33: aload_2
    //   34: invokeinterface an : ()V
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
  
  public void h() {
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
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull -> 10
    //   33: aload_2
    //   34: invokeinterface J : ()V
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
  
  public void i() {
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
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull -> 10
    //   33: aload_2
    //   34: invokeinterface Z : ()V
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
  
  public void j() {
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
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull -> 10
    //   33: aload_2
    //   34: invokeinterface T : ()V
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
  
  public void k() {
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
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull -> 10
    //   33: aload_2
    //   34: invokeinterface U : ()V
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
  
  public void l() {
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
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull -> 10
    //   33: aload_2
    //   34: invokeinterface S : ()V
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
  
  public void m() {
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
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull -> 10
    //   33: aload_2
    //   34: invokeinterface aY : ()V
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
  
  public void n() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/ArrayList;
    //   6: invokevirtual iterator : ()Ljava/util/Iterator;
    //   9: astore_1
    //   10: aload_1
    //   11: invokeinterface hasNext : ()Z
    //   16: ifeq -> 43
    //   19: aload_1
    //   20: invokeinterface next : ()Ljava/lang/Object;
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull -> 10
    //   33: aload_2
    //   34: invokeinterface V_ : ()Z
    //   39: pop
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
  
  public void o() {
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
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull -> 10
    //   33: aload_2
    //   34: invokeinterface O : ()V
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
  
  public void p() {
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
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull -> 10
    //   33: aload_2
    //   34: invokeinterface aQ : ()V
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
  
  public void q() {
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
    //   25: checkcast com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull -> 10
    //   33: aload_2
    //   34: invokeinterface aN : ()V
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
  
  public static interface ILiveRefreshUIObserver {
    void J();
    
    void O();
    
    void S();
    
    void T();
    
    void U();
    
    boolean V_();
    
    void Z();
    
    void a(int param1Int, String param1String);
    
    void a(AlertDialog param1AlertDialog);
    
    void a(GrabBoxModel param1GrabBoxModel);
    
    void a(LiveGiftModel param1LiveGiftModel);
    
    void a(boolean param1Boolean, int param1Int);
    
    boolean aH();
    
    void aI();
    
    void aL();
    
    void aM();
    
    void aN();
    
    void aQ();
    
    void aY();
    
    void am();
    
    void an();
    
    void b(String param1String1, String param1String2);
    
    void b(boolean param1Boolean);
    
    void b(boolean param1Boolean, int param1Int);
    
    void c(long param1Long);
    
    void c(String param1String, int param1Int);
    
    void c(boolean param1Boolean);
    
    void d(boolean param1Boolean);
    
    void f(int param1Int);
    
    void g(int param1Int);
    
    void h(int param1Int);
    
    void h(boolean param1Boolean);
    
    void i(int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\observer\LiveRefreshUIObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */