package com.blued.android.chat.core.worker.heart;

import com.blued.android.chat.ChatManager;
import com.blued.android.chat.ChatManagerInner;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.core.worker.Connector;
import com.blued.android.chat.listener.IMStatusListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class PingCheckerManager {
  private static final int PING_COUNT = 6;
  
  private static final int PING_INTERVAL = 5000;
  
  private static final String TAG = "Chat_PingChecker";
  
  private static final int WAIT_TIMEOUT = 30000;
  
  private IMStatusListener _imStatusListener = new IMStatusListener() {
      public void onConnected() {
        if (ChatManager.debug)
          Log.v("Chat_PingChecker", "im connected, start ping test"); 
        PingCheckerManager.this.startPingTest();
      }
      
      public void onConnecting() {}
      
      public void onDisconnected() {}
      
      public void onReceiving() {}
    };
  
  private Heart.PingReceiveListener _pingReceiveListener = new Heart.PingReceiveListener() {
      public void onReceivePing() {
        if (ChatManager.debug)
          Log.v("Chat_PingChecker", "receive ping, checker finish"); 
        PingCheckerManager.this.notifyPingCheckerFinish();
        PingCheckerManager.this.stopAllCheckImLink();
      }
    };
  
  private Timer _pingTestTimer;
  
  private HashSet<PingCheckerListener> pingCheckerListeners = new HashSet<PingCheckerListener>();
  
  private int pingTestCount = 0;
  
  private AtomicBoolean pingTimerTesting = new AtomicBoolean(false);
  
  private PingCheckerManager() {}
  
  public static PingCheckerManager getInstance() {
    return SingletonCreator.instance;
  }
  
  private void notifyPingCheckerFinish() {
    HashSet<PingCheckerListener> hashSet;
    Iterator<PingCheckerListener> iterator;
    if (ChatManager.debug)
      Log.v("Chat_PingChecker", "notifyPingCheckerFinish()"); 
    null = new ArrayList();
    synchronized (this.pingCheckerListeners) {
      null.addAll(this.pingCheckerListeners);
      iterator = null.iterator();
      while (iterator.hasNext())
        ((PingCheckerListener)iterator.next()).onPingCheckFinish(); 
      return;
    } 
  }
  
  private void startPingTest() {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("startPingTest(), pingTimerTesting:");
      stringBuilder.append(this.pingTimerTesting.get());
      Log.v("Chat_PingChecker", stringBuilder.toString());
    } 
    if (!this.pingTimerTesting.compareAndSet(false, true))
      return; 
    Timer timer2 = this._pingTestTimer;
    if (timer2 != null) {
      timer2.cancel();
      this._pingTestTimer = null;
    } 
    this.pingTestCount = 0;
    Heart heart = ChatManagerInner.getHeart();
    if (heart != null)
      heart.registerPingReceiveListener(this._pingReceiveListener); 
    Timer timer1 = new Timer();
    timer1.schedule(new TimerTask() {
          public void run() {
            PingCheckerManager.access$308(PingCheckerManager.this);
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("ping testing, pingTestCount:");
              stringBuilder.append(PingCheckerManager.this.pingTestCount);
              Log.v("Chat_PingChecker", stringBuilder.toString());
            } 
            Heart heart = ChatManagerInner.getHeart();
            if (heart != null)
              heart.pingTest(); 
            if (PingCheckerManager.this.pingTestCount > 6) {
              if (PingCheckerManager.this.pingTimerTesting.get()) {
                Connector connector = ChatManagerInner.getConnector();
                if (connector != null)
                  connector.pingFailed(); 
              } 
              if (PingCheckerManager.this._pingTestTimer != null) {
                PingCheckerManager.this._pingTestTimer.cancel();
                PingCheckerManager.access$502(PingCheckerManager.this, null);
              } 
              PingCheckerManager.this.pingTimerTesting.set(false);
            } 
          }
        }0L, 5000L);
    this._pingTestTimer = timer1;
  }
  
  private void stopPingTest() {
    if (ChatManager.debug)
      Log.v("Chat_PingChecker", "stopPingTest()"); 
    Timer timer = this._pingTestTimer;
    if (timer != null) {
      timer.cancel();
      this._pingTestTimer = null;
    } 
    this.pingTimerTesting.set(false);
    Heart heart = ChatManagerInner.getHeart();
    if (heart != null)
      heart.unregisterPingReceiveListener(this._pingReceiveListener); 
  }
  
  public boolean checkImLink(PingCheckerListener paramPingCheckerListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   5: ifeq -> 39
    //   8: new java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial <init> : ()V
    //   15: astore_2
    //   16: aload_2
    //   17: ldc 'checkImLink(), listener:'
    //   19: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload_2
    //   24: aload_1
    //   25: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: ldc 'Chat_PingChecker'
    //   31: aload_2
    //   32: invokevirtual toString : ()Ljava/lang/String;
    //   35: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   38: pop
    //   39: invokestatic getConnector : ()Lcom/blued/android/chat/core/worker/Connector;
    //   42: astore_3
    //   43: aload_3
    //   44: ifnull -> 122
    //   47: aload_3
    //   48: invokevirtual isWorking : ()Z
    //   51: ifne -> 57
    //   54: goto -> 122
    //   57: aload_1
    //   58: ifnull -> 87
    //   61: aload_0
    //   62: getfield pingCheckerListeners : Ljava/util/HashSet;
    //   65: astore_2
    //   66: aload_2
    //   67: monitorenter
    //   68: aload_0
    //   69: getfield pingCheckerListeners : Ljava/util/HashSet;
    //   72: aload_1
    //   73: invokevirtual add : (Ljava/lang/Object;)Z
    //   76: pop
    //   77: aload_2
    //   78: monitorexit
    //   79: goto -> 87
    //   82: astore_1
    //   83: aload_2
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    //   87: aload_3
    //   88: invokevirtual getConnectStatus : ()Lcom/blued/android/chat/data/ConnectState;
    //   91: getstatic com/blued/android/chat/data/ConnectState.CONNECTED : Lcom/blued/android/chat/data/ConnectState;
    //   94: if_acmpeq -> 114
    //   97: invokestatic getInstance : ()Lcom/blued/android/chat/ChatManager;
    //   100: aload_0
    //   101: getfield _imStatusListener : Lcom/blued/android/chat/listener/IMStatusListener;
    //   104: invokevirtual registerIMStatusListener : (Lcom/blued/android/chat/listener/IMStatusListener;)V
    //   107: aload_3
    //   108: invokevirtual checkNet : ()V
    //   111: goto -> 118
    //   114: aload_0
    //   115: invokespecial startPingTest : ()V
    //   118: aload_0
    //   119: monitorexit
    //   120: iconst_0
    //   121: ireturn
    //   122: aload_0
    //   123: monitorexit
    //   124: iconst_1
    //   125: ireturn
    //   126: astore_1
    //   127: aload_0
    //   128: monitorexit
    //   129: aload_1
    //   130: athrow
    // Exception table:
    //   from	to	target	type
    //   2	39	126	finally
    //   39	43	126	finally
    //   47	54	126	finally
    //   61	68	126	finally
    //   68	79	82	finally
    //   83	85	82	finally
    //   85	87	126	finally
    //   87	111	126	finally
    //   114	118	126	finally
  }
  
  public void stopAllCheckImLink() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   5: ifeq -> 16
    //   8: ldc 'Chat_PingChecker'
    //   10: ldc 'stopAllCheckImLink()'
    //   12: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   15: pop
    //   16: aload_0
    //   17: getfield pingCheckerListeners : Ljava/util/HashSet;
    //   20: astore_1
    //   21: aload_1
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield pingCheckerListeners : Ljava/util/HashSet;
    //   27: invokevirtual clear : ()V
    //   30: aload_1
    //   31: monitorexit
    //   32: invokestatic getInstance : ()Lcom/blued/android/chat/ChatManager;
    //   35: aload_0
    //   36: getfield _imStatusListener : Lcom/blued/android/chat/listener/IMStatusListener;
    //   39: invokevirtual unregisterIMStatusListener : (Lcom/blued/android/chat/listener/IMStatusListener;)V
    //   42: invokestatic getHeart : ()Lcom/blued/android/chat/core/worker/heart/Heart;
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull -> 58
    //   50: aload_1
    //   51: aload_0
    //   52: getfield _pingReceiveListener : Lcom/blued/android/chat/core/worker/heart/Heart$PingReceiveListener;
    //   55: invokevirtual unregisterPingReceiveListener : (Lcom/blued/android/chat/core/worker/heart/Heart$PingReceiveListener;)V
    //   58: aload_0
    //   59: invokespecial stopPingTest : ()V
    //   62: aload_0
    //   63: monitorexit
    //   64: return
    //   65: astore_2
    //   66: aload_1
    //   67: monitorexit
    //   68: aload_2
    //   69: athrow
    //   70: astore_1
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	70	finally
    //   16	23	70	finally
    //   23	32	65	finally
    //   32	46	70	finally
    //   50	58	70	finally
    //   58	62	70	finally
    //   66	68	65	finally
    //   68	70	70	finally
  }
  
  public void stopCheckImLink(PingCheckerListener paramPingCheckerListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   5: ifeq -> 39
    //   8: new java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial <init> : ()V
    //   15: astore_3
    //   16: aload_3
    //   17: ldc 'stopCheckImLink(), listener:'
    //   19: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload_3
    //   24: aload_1
    //   25: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: ldc 'Chat_PingChecker'
    //   31: aload_3
    //   32: invokevirtual toString : ()Ljava/lang/String;
    //   35: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   38: pop
    //   39: aload_1
    //   40: ifnull -> 119
    //   43: aload_0
    //   44: getfield pingCheckerListeners : Ljava/util/HashSet;
    //   47: astore_3
    //   48: aload_3
    //   49: monitorenter
    //   50: aload_0
    //   51: getfield pingCheckerListeners : Ljava/util/HashSet;
    //   54: aload_1
    //   55: invokevirtual remove : (Ljava/lang/Object;)Z
    //   58: pop
    //   59: aload_0
    //   60: getfield pingCheckerListeners : Ljava/util/HashSet;
    //   63: invokevirtual size : ()I
    //   66: istore_2
    //   67: aload_3
    //   68: monitorexit
    //   69: goto -> 77
    //   72: astore_1
    //   73: aload_3
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    //   77: iload_2
    //   78: ifgt -> 111
    //   81: invokestatic getInstance : ()Lcom/blued/android/chat/ChatManager;
    //   84: aload_0
    //   85: getfield _imStatusListener : Lcom/blued/android/chat/listener/IMStatusListener;
    //   88: invokevirtual unregisterIMStatusListener : (Lcom/blued/android/chat/listener/IMStatusListener;)V
    //   91: invokestatic getHeart : ()Lcom/blued/android/chat/core/worker/heart/Heart;
    //   94: astore_1
    //   95: aload_1
    //   96: ifnull -> 107
    //   99: aload_1
    //   100: aload_0
    //   101: getfield _pingReceiveListener : Lcom/blued/android/chat/core/worker/heart/Heart$PingReceiveListener;
    //   104: invokevirtual unregisterPingReceiveListener : (Lcom/blued/android/chat/core/worker/heart/Heart$PingReceiveListener;)V
    //   107: aload_0
    //   108: invokespecial stopPingTest : ()V
    //   111: aload_0
    //   112: monitorexit
    //   113: return
    //   114: astore_1
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_1
    //   118: athrow
    //   119: iconst_0
    //   120: istore_2
    //   121: goto -> 77
    // Exception table:
    //   from	to	target	type
    //   2	39	114	finally
    //   43	50	114	finally
    //   50	69	72	finally
    //   73	75	72	finally
    //   75	77	114	finally
    //   81	95	114	finally
    //   99	107	114	finally
    //   107	111	114	finally
  }
  
  public static interface PingCheckerListener {
    void onPingCheckFinish();
  }
  
  static class SingletonCreator {
    public static final PingCheckerManager instance = new PingCheckerManager();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\worker\heart\PingCheckerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */