package com.blued.android.chat.grpc.core.link;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.chat.grpc.PrivateChatManager;
import com.blued.android.chat.grpc.core.a;
import com.blued.android.chat.grpc.info.ChatConnectInfo;
import com.blued.android.chat.grpc.listener.ConnectListener;
import com.blued.android.chat.grpc.listener.MsgConsumer;
import com.blued.android.chat.grpc.listener.ReceiveMsgListener;
import com.blued.android.chat.grpc.utils.ChatLog;
import com.blued.android.module.im.IM;
import com.blued.android.module.im.grpc.OnConnectStateListener;
import com.google.protobuf.Any;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class a extends a {
  private AtomicBoolean b = new AtomicBoolean(false);
  
  private ChatConnectInfo c;
  
  private final Set<MsgConsumer> d = new HashSet<MsgConsumer>();
  
  private final Set<ReceiveMsgListener> e = new HashSet<ReceiveMsgListener>();
  
  private final Set<ConnectListener> f = new HashSet<ConnectListener>();
  
  private OnConnectStateListener g = new a(this);
  
  public void a(ChatConnectInfo paramChatConnectInfo) {
    if (paramChatConnectInfo != null) {
      if (this.b.get())
        i(); 
      this.c = paramChatConnectInfo;
      if (this.c != null && (PrivateChatManager.getInstance().getChatAppInfo()).context != null) {
        ChatLog.d("com.blued.android.chat.grpc.core.link.a", "initIM");
        Context context = (PrivateChatManager.getInstance().getChatAppInfo()).context;
        ChatConnectInfo chatConnectInfo = this.c;
        IM.a(context, chatConnectInfo.host, chatConnectInfo.dnsManager);
        IM.c().b((PrivateChatManager.getInstance().getChatAppInfo()).platform).c((PrivateChatManager.getInstance().getChatAppInfo()).appVersionName).d((PrivateChatManager.getInstance().getChatAppInfo()).language).a((PrivateChatManager.getInstance().getChatAppInfo()).channel).a((PrivateChatManager.getInstance().getChatAppInfo()).appVersionCode);
      } 
      return;
    } 
    throw new RuntimeException(" connectInfo is null ");
  }
  
  public void a(ConnectListener paramConnectListener) {
    synchronized (this.f) {
      this.f.add(paramConnectListener);
      return;
    } 
  }
  
  public void a(MsgConsumer paramMsgConsumer) {
    synchronized (this.d) {
      this.d.add(paramMsgConsumer);
      return;
    } 
  }
  
  public void a(ReceiveMsgListener paramReceiveMsgListener) {
    synchronized (this.e) {
      this.e.add(paramReceiveMsgListener);
      return;
    } 
  }
  
  public void b() {
    if (this.b.compareAndSet(true, false)) {
      ChatLog.d("com.blued.android.chat.grpc.core.link.a", "stopConnect====");
      IM.b();
      IM.b(this.g);
    } 
  }
  
  public void b(ConnectListener paramConnectListener) {
    synchronized (this.f) {
      this.f.remove(paramConnectListener);
      return;
    } 
  }
  
  public void b(MsgConsumer paramMsgConsumer) {
    synchronized (this.d) {
      this.d.remove(paramMsgConsumer);
      return;
    } 
  }
  
  public void b(ReceiveMsgListener paramReceiveMsgListener) {
    synchronized (this.e) {
      this.e.remove(paramReceiveMsgListener);
      return;
    } 
  }
  
  public void c() {
    if (this.b.compareAndSet(false, true)) {
      ChatLog.d("com.blued.android.chat.grpc.core.link.a", "startConnect====");
      String str = (PrivateChatManager.getInstance().getUserInfo()).token;
      if (TextUtils.isEmpty(str)) {
        ChatLog.e("com.blued.android.chat.grpc.core.link.a", "startConnect token is empty !!");
        return;
      } 
      IM.a(str);
      IM.a(this.g);
      IM.a();
    } 
  }
  
  class a implements OnConnectStateListener {
    a(a this$0) {}
    
    public void onConnected() {
      a.b(this.a).set(true);
      synchronized (a.a(this.a)) {
        if (a.a(this.a).size() > 0) {
          Iterator<ConnectListener> iterator = a.a(this.a).iterator();
          while (iterator.hasNext())
            ((ConnectListener)iterator.next()).onConnected(); 
        } 
        return;
      } 
    }
    
    public void onConnecting() {
      synchronized (a.a(this.a)) {
        if (a.a(this.a).size() > 0) {
          Iterator<ConnectListener> iterator = a.a(this.a).iterator();
          while (iterator.hasNext())
            ((ConnectListener)iterator.next()).onConnecting(); 
        } 
        return;
      } 
    }
    
    public void onDisconnected() {
      a.b(this.a).set(false);
      synchronized (a.a(this.a)) {
        if (a.a(this.a).size() > 0) {
          Iterator<ConnectListener> iterator = a.a(this.a).iterator();
          while (iterator.hasNext())
            ((ConnectListener)iterator.next()).onDisconnected(-1, "主动断开"); 
        } 
        return;
      } 
    }
    
    public void onReceive(Any param1Any) {
      // Byte code:
      //   0: new java/lang/StringBuilder
      //   3: dup
      //   4: invokespecial <init> : ()V
      //   7: astore #5
      //   9: aload #5
      //   11: ldc 'onMessage-thread==='
      //   13: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   16: pop
      //   17: aload #5
      //   19: invokestatic currentThread : ()Ljava/lang/Thread;
      //   22: invokevirtual getName : ()Ljava/lang/String;
      //   25: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   28: pop
      //   29: ldc 'a'
      //   31: aload #5
      //   33: invokevirtual toString : ()Ljava/lang/String;
      //   36: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
      //   39: pop
      //   40: new java/lang/StringBuilder
      //   43: dup
      //   44: invokespecial <init> : ()V
      //   47: astore #5
      //   49: aload #5
      //   51: ldc 'onMessage==='
      //   53: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   56: pop
      //   57: aload #5
      //   59: aload_1
      //   60: invokevirtual toString : ()Ljava/lang/String;
      //   63: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   66: pop
      //   67: ldc 'a'
      //   69: aload #5
      //   71: invokevirtual toString : ()Ljava/lang/String;
      //   74: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
      //   77: pop
      //   78: aload_0
      //   79: getfield a : Lcom/blued/android/chat/grpc/core/link/a;
      //   82: invokestatic c : (Lcom/blued/android/chat/grpc/core/link/a;)Ljava/util/Set;
      //   85: astore #5
      //   87: aload #5
      //   89: monitorenter
      //   90: aload_0
      //   91: getfield a : Lcom/blued/android/chat/grpc/core/link/a;
      //   94: invokestatic c : (Lcom/blued/android/chat/grpc/core/link/a;)Ljava/util/Set;
      //   97: invokeinterface size : ()I
      //   102: istore #4
      //   104: iconst_0
      //   105: istore_3
      //   106: iconst_0
      //   107: istore_2
      //   108: iload #4
      //   110: ifle -> 161
      //   113: aload_0
      //   114: getfield a : Lcom/blued/android/chat/grpc/core/link/a;
      //   117: invokestatic c : (Lcom/blued/android/chat/grpc/core/link/a;)Ljava/util/Set;
      //   120: invokeinterface iterator : ()Ljava/util/Iterator;
      //   125: astore #6
      //   127: iload_2
      //   128: istore_3
      //   129: aload #6
      //   131: invokeinterface hasNext : ()Z
      //   136: ifeq -> 161
      //   139: iload_2
      //   140: aload #6
      //   142: invokeinterface next : ()Ljava/lang/Object;
      //   147: checkcast com/blued/android/chat/grpc/listener/MsgConsumer
      //   150: aload_1
      //   151: invokeinterface consumeMsg : (Lcom/google/protobuf/Any;)Z
      //   156: ior
      //   157: istore_2
      //   158: goto -> 127
      //   161: aload #5
      //   163: monitorexit
      //   164: aload_0
      //   165: getfield a : Lcom/blued/android/chat/grpc/core/link/a;
      //   168: invokestatic d : (Lcom/blued/android/chat/grpc/core/link/a;)Ljava/util/Set;
      //   171: astore #5
      //   173: aload #5
      //   175: monitorenter
      //   176: iload_3
      //   177: ifne -> 238
      //   180: aload_0
      //   181: getfield a : Lcom/blued/android/chat/grpc/core/link/a;
      //   184: invokestatic d : (Lcom/blued/android/chat/grpc/core/link/a;)Ljava/util/Set;
      //   187: invokeinterface size : ()I
      //   192: ifle -> 238
      //   195: aload_0
      //   196: getfield a : Lcom/blued/android/chat/grpc/core/link/a;
      //   199: invokestatic d : (Lcom/blued/android/chat/grpc/core/link/a;)Ljava/util/Set;
      //   202: invokeinterface iterator : ()Ljava/util/Iterator;
      //   207: astore #6
      //   209: aload #6
      //   211: invokeinterface hasNext : ()Z
      //   216: ifeq -> 238
      //   219: aload #6
      //   221: invokeinterface next : ()Ljava/lang/Object;
      //   226: checkcast com/blued/android/chat/grpc/listener/ReceiveMsgListener
      //   229: aload_1
      //   230: invokeinterface onReceiveMsg : (Lcom/google/protobuf/Any;)V
      //   235: goto -> 209
      //   238: aload #5
      //   240: monitorexit
      //   241: return
      //   242: astore_1
      //   243: aload #5
      //   245: monitorexit
      //   246: aload_1
      //   247: athrow
      //   248: astore_1
      //   249: aload #5
      //   251: monitorexit
      //   252: aload_1
      //   253: athrow
      //   254: astore_1
      //   255: new java/lang/StringBuilder
      //   258: dup
      //   259: invokespecial <init> : ()V
      //   262: astore #5
      //   264: aload #5
      //   266: ldc 'onMessage error : '
      //   268: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   271: pop
      //   272: aload #5
      //   274: aload_1
      //   275: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   278: pop
      //   279: ldc 'a'
      //   281: aload #5
      //   283: invokevirtual toString : ()Ljava/lang/String;
      //   286: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
      //   289: pop
      //   290: return
      // Exception table:
      //   from	to	target	type
      //   78	90	254	finally
      //   90	104	248	finally
      //   113	127	248	finally
      //   129	158	248	finally
      //   161	164	248	finally
      //   164	176	254	finally
      //   180	209	242	finally
      //   209	235	242	finally
      //   238	241	242	finally
      //   243	246	242	finally
      //   246	248	254	finally
      //   249	252	248	finally
      //   252	254	254	finally
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\grpc\core\link\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */