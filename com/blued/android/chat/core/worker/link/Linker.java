package com.blued.android.chat.core.worker.link;

import android.os.SystemClock;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.pack.BasePackage;
import com.blued.android.chat.core.utils.Log;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Linker implements IPackageQueue, LinkListener, ReLinkTimer.ReLinkListener {
  private static final String TAG = "Chat_Linker";
  
  private Stack<BasePackage> connStack = new Stack<BasePackage>();
  
  private ExecutorService executor = Executors.newSingleThreadExecutor();
  
  private AbstractLinkerImpl linkImpl;
  
  private LinkListener linkListener = null;
  
  private Object linkLock = new Object();
  
  private Stack<BasePackage> normalStack = new Stack<BasePackage>();
  
  private ReLinkTimer reLinkTimer;
  
  private Stack<BasePackage> sendingStack = this.connStack;
  
  private Object stackLock = new Object();
  
  public void appActiveChanged(boolean paramBoolean) {
    if (paramBoolean) {
      ReLinkTimer reLinkTimer = this.reLinkTimer;
      if (reLinkTimer != null)
        reLinkTimer.stop(); 
      checkNet();
    } 
  }
  
  public void cancelPackage(BasePackage paramBasePackage) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("cancelPackage(), pack:");
      stringBuilder.append(paramBasePackage);
      Log.v("Chat_Linker", stringBuilder.toString());
    } 
    synchronized (this.stackLock) {
      this.connStack.remove(paramBasePackage);
      this.normalStack.remove(paramBasePackage);
      return;
    } 
  }
  
  public void checkNet() {
    if (ChatManager.debug)
      Log.v("Chat_Linker", "checkNet()"); 
    synchronized (this.linkLock) {
      if (this.linkImpl == null || this.linkImpl.getState() == 0 || this.linkImpl.isReleased()) {
        if (ChatManager.debug)
          Log.v("Chat_Linker", "link is unlink, so link it"); 
        link();
      } else if (!AbstractLinkerImpl.isLinkerMatch(this.linkImpl)) {
        if (ChatManager.debug)
          Log.v("Chat_Linker", "link is not match the net, so release it and link new one"); 
        this.linkImpl.release();
        this.linkImpl = null;
        link();
      } 
      return;
    } 
  }
  
  public BasePackage getNext() {
    if (ChatManager.debug)
      Log.v("Chat_Linker", "getNext()"); 
    synchronized (this.stackLock) {
      if (this.sendingStack != null && !this.sendingStack.isEmpty())
        return this.sendingStack.get(0); 
      return null;
    } 
  }
  
  public int getState() {
    synchronized (this.linkLock) {
      if (this.linkImpl == null)
        return 0; 
      return this.linkImpl.getState();
    } 
  }
  
  public void link() {
    link(false);
  }
  
  public void link(boolean paramBoolean) {
    if (ChatManager.debug)
      Log.v("Chat_Linker", "link()"); 
    synchronized (this.linkLock) {
      if (this.executor.isShutdown())
        this.executor = Executors.newSingleThreadExecutor(); 
      if (this.linkImpl != null && !AbstractLinkerImpl.isLinkerMatch(this.linkImpl)) {
        if (ChatManager.debug)
          Log.v("Chat_Linker", "link is not match net, release it"); 
        this.linkImpl.release();
        this.linkImpl = null;
      } 
      if (this.linkImpl == null || this.linkImpl.isReleased()) {
        if (ChatManager.debug)
          Log.v("Chat_Linker", "create a new link, and link it"); 
        this.linkImpl = AbstractLinkerImpl.createNewLinker(this, this);
        this.linkImpl.link(paramBoolean);
      } else if (this.linkImpl.getState() == 0) {
        if (ChatManager.debug)
          Log.v("Chat_Linker", "link state is UNLINK, link it"); 
        this.linkImpl.link(paramBoolean);
      } 
      return;
    } 
  }
  
  public void linkAuthed() {
    if (ChatManager.debug)
      Log.v("Chat_Linker", "linkAuthed()"); 
    synchronized (this.linkLock) {
      if (this.linkImpl != null)
        this.linkImpl.linkAuthed(); 
      return;
    } 
  }
  
  public void onLinkReceive(BasePackage paramBasePackage) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield executor : Ljava/util/concurrent/ExecutorService;
    //   6: new com/blued/android/chat/core/worker/link/Linker$1
    //   9: dup
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial <init> : (Lcom/blued/android/chat/core/worker/link/Linker;Lcom/blued/android/chat/core/pack/BasePackage;)V
    //   15: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	23	finally
  }
  
  public void onLinkSendFailed(BasePackage paramBasePackage, String paramString) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onLinkSendFailed(), pack:");
      stringBuilder.append(paramBasePackage);
      stringBuilder.append(", failedMessage:");
      stringBuilder.append(paramString);
      Log.v("Chat_Linker", stringBuilder.toString());
    } 
    synchronized (this.stackLock) {
      this.normalStack.remove(paramBasePackage);
      this.connStack.remove(paramBasePackage);
      null = this.linkListener;
      if (null != null)
        null.onLinkSendFailed(paramBasePackage, paramString); 
      return;
    } 
  }
  
  public void onLinkSendSuccess(BasePackage paramBasePackage) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onLinkSendSuccess(), pack:");
      stringBuilder.append(paramBasePackage);
      Log.v("Chat_Linker", stringBuilder.toString());
    } 
    synchronized (this.stackLock) {
      this.normalStack.remove(paramBasePackage);
      this.connStack.remove(paramBasePackage);
      null = this.linkListener;
      if (null != null)
        null.onLinkSendSuccess(paramBasePackage); 
      return;
    } 
  }
  
  public void onLinkStateChanged(int paramInt) {
    // Byte code:
    //   0: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   3: ifeq -> 37
    //   6: new java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial <init> : ()V
    //   13: astore_2
    //   14: aload_2
    //   15: ldc 'onLinkStateChanged(), newState:'
    //   17: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_2
    //   22: iload_1
    //   23: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: ldc 'Chat_Linker'
    //   29: aload_2
    //   30: invokevirtual toString : ()Ljava/lang/String;
    //   33: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   36: pop
    //   37: aload_0
    //   38: getfield stackLock : Ljava/lang/Object;
    //   41: astore_2
    //   42: aload_2
    //   43: monitorenter
    //   44: iload_1
    //   45: iconst_3
    //   46: if_icmpge -> 74
    //   49: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   52: ifeq -> 63
    //   55: ldc 'Chat_Linker'
    //   57: ldc 'switch sendingStack to connStack'
    //   59: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   62: pop
    //   63: aload_0
    //   64: aload_0
    //   65: getfield connStack : Ljava/util/Stack;
    //   68: putfield sendingStack : Ljava/util/Stack;
    //   71: goto -> 96
    //   74: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   77: ifeq -> 88
    //   80: ldc 'Chat_Linker'
    //   82: ldc 'switch sendingStack to normalStack'
    //   84: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   87: pop
    //   88: aload_0
    //   89: aload_0
    //   90: getfield normalStack : Ljava/util/Stack;
    //   93: putfield sendingStack : Ljava/util/Stack;
    //   96: aload_2
    //   97: monitorexit
    //   98: aload_0
    //   99: getfield linkLock : Ljava/lang/Object;
    //   102: astore_2
    //   103: aload_2
    //   104: monitorenter
    //   105: iload_1
    //   106: ifne -> 213
    //   109: aload_0
    //   110: getfield linkImpl : Lcom/blued/android/chat/core/worker/link/AbstractLinkerImpl;
    //   113: ifnull -> 165
    //   116: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   119: ifeq -> 153
    //   122: new java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial <init> : ()V
    //   129: astore_3
    //   130: aload_3
    //   131: ldc 'socketlinker failed, so change to httplinker, and start pendingLink for SocketLinker'
    //   133: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload_3
    //   138: iload_1
    //   139: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: ldc 'Chat_Linker'
    //   145: aload_3
    //   146: invokevirtual toString : ()Ljava/lang/String;
    //   149: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   152: pop
    //   153: aload_0
    //   154: getfield linkImpl : Lcom/blued/android/chat/core/worker/link/AbstractLinkerImpl;
    //   157: invokevirtual release : ()V
    //   160: aload_0
    //   161: aconst_null
    //   162: putfield linkImpl : Lcom/blued/android/chat/core/worker/link/AbstractLinkerImpl;
    //   165: aload_0
    //   166: getfield executor : Ljava/util/concurrent/ExecutorService;
    //   169: ifnull -> 246
    //   172: aload_0
    //   173: getfield executor : Ljava/util/concurrent/ExecutorService;
    //   176: invokeinterface isShutdown : ()Z
    //   181: ifne -> 246
    //   184: aload_0
    //   185: getfield reLinkTimer : Lcom/blued/android/chat/core/worker/link/ReLinkTimer;
    //   188: ifnonnull -> 203
    //   191: aload_0
    //   192: new com/blued/android/chat/core/worker/link/ReLinkTimer
    //   195: dup
    //   196: aload_0
    //   197: invokespecial <init> : (Lcom/blued/android/chat/core/worker/link/ReLinkTimer$ReLinkListener;)V
    //   200: putfield reLinkTimer : Lcom/blued/android/chat/core/worker/link/ReLinkTimer;
    //   203: aload_0
    //   204: getfield reLinkTimer : Lcom/blued/android/chat/core/worker/link/ReLinkTimer;
    //   207: invokevirtual start : ()V
    //   210: goto -> 246
    //   213: iload_1
    //   214: iconst_2
    //   215: if_icmplt -> 246
    //   218: aload_0
    //   219: getfield reLinkTimer : Lcom/blued/android/chat/core/worker/link/ReLinkTimer;
    //   222: ifnull -> 232
    //   225: aload_0
    //   226: getfield reLinkTimer : Lcom/blued/android/chat/core/worker/link/ReLinkTimer;
    //   229: invokevirtual stop : ()V
    //   232: aload_0
    //   233: getfield linkImpl : Lcom/blued/android/chat/core/worker/link/AbstractLinkerImpl;
    //   236: ifnull -> 246
    //   239: aload_0
    //   240: getfield linkImpl : Lcom/blued/android/chat/core/worker/link/AbstractLinkerImpl;
    //   243: invokevirtual notifyPackageHandler : ()V
    //   246: aload_2
    //   247: monitorexit
    //   248: aload_0
    //   249: getfield linkListener : Lcom/blued/android/chat/core/worker/link/LinkListener;
    //   252: astore_2
    //   253: aload_2
    //   254: ifnull -> 264
    //   257: aload_2
    //   258: iload_1
    //   259: invokeinterface onLinkStateChanged : (I)V
    //   264: iload_1
    //   265: ifne -> 390
    //   268: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   271: ifeq -> 282
    //   274: ldc 'Chat_Linker'
    //   276: ldc 'newState is unlink, clear pack stack and notify failed'
    //   278: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   281: pop
    //   282: new java/util/ArrayList
    //   285: dup
    //   286: invokespecial <init> : ()V
    //   289: astore_3
    //   290: aload_0
    //   291: getfield stackLock : Ljava/lang/Object;
    //   294: astore_2
    //   295: aload_2
    //   296: monitorenter
    //   297: aload_3
    //   298: aload_0
    //   299: getfield connStack : Ljava/util/Stack;
    //   302: invokeinterface addAll : (Ljava/util/Collection;)Z
    //   307: pop
    //   308: aload_3
    //   309: aload_0
    //   310: getfield normalStack : Ljava/util/Stack;
    //   313: invokeinterface addAll : (Ljava/util/Collection;)Z
    //   318: pop
    //   319: aload_0
    //   320: getfield connStack : Ljava/util/Stack;
    //   323: invokevirtual clear : ()V
    //   326: aload_0
    //   327: getfield normalStack : Ljava/util/Stack;
    //   330: invokevirtual clear : ()V
    //   333: aload_2
    //   334: monitorexit
    //   335: aload_3
    //   336: invokeinterface iterator : ()Ljava/util/Iterator;
    //   341: astore_2
    //   342: aload_2
    //   343: invokeinterface hasNext : ()Z
    //   348: ifeq -> 390
    //   351: aload_2
    //   352: invokeinterface next : ()Ljava/lang/Object;
    //   357: checkcast com/blued/android/chat/core/pack/BasePackage
    //   360: astore_3
    //   361: aload_0
    //   362: getfield linkListener : Lcom/blued/android/chat/core/worker/link/LinkListener;
    //   365: astore #4
    //   367: aload #4
    //   369: ifnull -> 342
    //   372: aload #4
    //   374: aload_3
    //   375: ldc 'link state is changed to UNLINK'
    //   377: invokeinterface onLinkSendFailed : (Lcom/blued/android/chat/core/pack/BasePackage;Ljava/lang/String;)V
    //   382: goto -> 342
    //   385: astore_3
    //   386: aload_2
    //   387: monitorexit
    //   388: aload_3
    //   389: athrow
    //   390: return
    //   391: aload_2
    //   392: monitorexit
    //   393: aload_3
    //   394: athrow
    //   395: astore_3
    //   396: aload_2
    //   397: monitorexit
    //   398: aload_3
    //   399: athrow
    //   400: astore_3
    //   401: goto -> 391
    // Exception table:
    //   from	to	target	type
    //   49	63	395	finally
    //   63	71	395	finally
    //   74	88	395	finally
    //   88	96	395	finally
    //   96	98	395	finally
    //   109	153	400	finally
    //   153	165	400	finally
    //   165	203	400	finally
    //   203	210	400	finally
    //   218	232	400	finally
    //   232	246	400	finally
    //   246	248	400	finally
    //   297	335	385	finally
    //   386	388	385	finally
    //   391	393	400	finally
    //   396	398	395	finally
  }
  
  public boolean onReLink(int paramInt1, int paramInt2) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onReLink(), retryCount:");
      stringBuilder.append(paramInt1);
      stringBuilder.append(", timeFreqMs:");
      stringBuilder.append(paramInt2);
      Log.v("Chat_Linker", stringBuilder.toString());
    } 
    checkNet();
    return true;
  }
  
  public void registerLinkListener(LinkListener paramLinkListener) {
    this.linkListener = paramLinkListener;
  }
  
  public void relink(boolean paramBoolean) {
    if (ChatManager.debug)
      Log.v("Chat_Linker", "relink()"); 
    synchronized (this.linkLock) {
      if (this.linkImpl != null && !this.linkImpl.isReleased()) {
        this.linkImpl.relink(paramBoolean);
      } else {
        link(paramBoolean);
      } 
      return;
    } 
  }
  
  public void sendPackage(BasePackage paramBasePackage) {
    sendPackage(paramBasePackage, true);
  }
  
  public void sendPackage(BasePackage paramBasePackage, boolean paramBoolean) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("sendPackage(), pack:");
      stringBuilder.append(paramBasePackage);
      stringBuilder.append(", retryLink:");
      stringBuilder.append(paramBoolean);
      Log.v("Chat_Linker", stringBuilder.toString());
    } 
    paramBasePackage.sendTime = SystemClock.uptimeMillis();
    synchronized (this.stackLock) {
      if (paramBasePackage instanceof com.blued.android.chat.core.pack.ConnPackage) {
        this.connStack.add(paramBasePackage);
      } else {
        this.normalStack.add(paramBasePackage);
      } 
      synchronized (this.linkLock) {
        if (this.linkImpl != null && this.linkImpl.getState() != 0 && !this.linkImpl.isReleased()) {
          if (ChatManager.debug)
            Log.v("Chat_Linker", "add this pack to stack"); 
          this.linkImpl.notifyPackageHandler();
        } else if (paramBoolean) {
          if (ChatManager.debug)
            Log.v("Chat_Linker", "current link is unlink, so link it"); 
          link();
        } 
        return;
      } 
    } 
  }
  
  public void unlink() {
    if (ChatManager.debug)
      Log.v("Chat_Linker", "unlink()"); 
    synchronized (this.linkLock) {
      this.executor.shutdownNow();
      if (this.linkImpl != null) {
        this.linkImpl.release();
        this.linkImpl = null;
      } 
      if (this.reLinkTimer != null)
        this.reLinkTimer.stop(); 
      onLinkStateChanged(0);
      return;
    } 
  }
  
  public void unregisterLinkListener(LinkListener paramLinkListener) {
    if (this.linkListener == paramLinkListener)
      this.linkListener = null; 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\worker\link\Linker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */