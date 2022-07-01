package com.facebook.stetho.inspector.helper;

import com.facebook.stetho.common.LogRedirector;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.jsonrpc.DisconnectReceiver;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.PendingRequestCallback;
import java.nio.channels.NotYetConnectedException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public class ChromePeerManager {
  private static final String TAG = "ChromePeerManager";
  
  private PeerRegistrationListener mListener;
  
  private final Map<JsonRpcPeer, DisconnectReceiver> mReceivingPeers = new HashMap<JsonRpcPeer, DisconnectReceiver>();
  
  private JsonRpcPeer[] mReceivingPeersSnapshot;
  
  private JsonRpcPeer[] getReceivingPeersSnapshot() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mReceivingPeersSnapshot : [Lcom/facebook/stetho/inspector/jsonrpc/JsonRpcPeer;
    //   6: ifnonnull -> 42
    //   9: aload_0
    //   10: aload_0
    //   11: getfield mReceivingPeers : Ljava/util/Map;
    //   14: invokeinterface keySet : ()Ljava/util/Set;
    //   19: aload_0
    //   20: getfield mReceivingPeers : Ljava/util/Map;
    //   23: invokeinterface size : ()I
    //   28: anewarray com/facebook/stetho/inspector/jsonrpc/JsonRpcPeer
    //   31: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   36: checkcast [Lcom/facebook/stetho/inspector/jsonrpc/JsonRpcPeer;
    //   39: putfield mReceivingPeersSnapshot : [Lcom/facebook/stetho/inspector/jsonrpc/JsonRpcPeer;
    //   42: aload_0
    //   43: getfield mReceivingPeersSnapshot : [Lcom/facebook/stetho/inspector/jsonrpc/JsonRpcPeer;
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: areturn
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Exception table:
    //   from	to	target	type
    //   2	42	51	finally
    //   42	47	51	finally
  }
  
  private void sendMessageToPeers(String paramString, Object paramObject, @Nullable PendingRequestCallback paramPendingRequestCallback) {
    for (JsonRpcPeer jsonRpcPeer : getReceivingPeersSnapshot()) {
      try {
        jsonRpcPeer.invokeMethod(paramString, paramObject, paramPendingRequestCallback);
      } catch (NotYetConnectedException notYetConnectedException) {
        LogRedirector.e("ChromePeerManager", "Error delivering data to Chrome", notYetConnectedException);
      } 
    } 
  }
  
  public boolean addPeer(JsonRpcPeer paramJsonRpcPeer) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mReceivingPeers : Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   12: istore_2
    //   13: iload_2
    //   14: ifeq -> 21
    //   17: aload_0
    //   18: monitorexit
    //   19: iconst_0
    //   20: ireturn
    //   21: new com/facebook/stetho/inspector/helper/ChromePeerManager$UnregisterOnDisconnect
    //   24: dup
    //   25: aload_0
    //   26: aload_1
    //   27: invokespecial <init> : (Lcom/facebook/stetho/inspector/helper/ChromePeerManager;Lcom/facebook/stetho/inspector/jsonrpc/JsonRpcPeer;)V
    //   30: astore_3
    //   31: aload_1
    //   32: aload_3
    //   33: invokevirtual registerDisconnectReceiver : (Lcom/facebook/stetho/inspector/jsonrpc/DisconnectReceiver;)V
    //   36: aload_0
    //   37: getfield mReceivingPeers : Ljava/util/Map;
    //   40: aload_1
    //   41: aload_3
    //   42: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   47: pop
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield mReceivingPeersSnapshot : [Lcom/facebook/stetho/inspector/jsonrpc/JsonRpcPeer;
    //   53: aload_0
    //   54: getfield mListener : Lcom/facebook/stetho/inspector/helper/PeerRegistrationListener;
    //   57: ifnull -> 70
    //   60: aload_0
    //   61: getfield mListener : Lcom/facebook/stetho/inspector/helper/PeerRegistrationListener;
    //   64: aload_1
    //   65: invokeinterface onPeerRegistered : (Lcom/facebook/stetho/inspector/jsonrpc/JsonRpcPeer;)V
    //   70: aload_0
    //   71: monitorexit
    //   72: iconst_1
    //   73: ireturn
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	74	finally
    //   21	70	74	finally
  }
  
  public boolean hasRegisteredPeers() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mReceivingPeers : Ljava/util/Map;
    //   6: invokeinterface isEmpty : ()Z
    //   11: istore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: iload_1
    //   15: iconst_1
    //   16: ixor
    //   17: ireturn
    //   18: astore_2
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_2
    //   22: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	18	finally
  }
  
  public void invokeMethodOnPeers(String paramString, Object paramObject, PendingRequestCallback paramPendingRequestCallback) {
    Util.throwIfNull(paramPendingRequestCallback);
    sendMessageToPeers(paramString, paramObject, paramPendingRequestCallback);
  }
  
  public void removePeer(JsonRpcPeer paramJsonRpcPeer) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mReceivingPeers : Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   12: ifnull -> 37
    //   15: aload_0
    //   16: aconst_null
    //   17: putfield mReceivingPeersSnapshot : [Lcom/facebook/stetho/inspector/jsonrpc/JsonRpcPeer;
    //   20: aload_0
    //   21: getfield mListener : Lcom/facebook/stetho/inspector/helper/PeerRegistrationListener;
    //   24: ifnull -> 37
    //   27: aload_0
    //   28: getfield mListener : Lcom/facebook/stetho/inspector/helper/PeerRegistrationListener;
    //   31: aload_1
    //   32: invokeinterface onPeerUnregistered : (Lcom/facebook/stetho/inspector/jsonrpc/JsonRpcPeer;)V
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Exception table:
    //   from	to	target	type
    //   2	37	40	finally
  }
  
  public void sendNotificationToPeers(String paramString, Object paramObject) {
    sendMessageToPeers(paramString, paramObject, null);
  }
  
  public void setListener(PeerRegistrationListener paramPeerRegistrationListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield mListener : Lcom/facebook/stetho/inspector/helper/PeerRegistrationListener;
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_1
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	10	finally
  }
  
  class UnregisterOnDisconnect implements DisconnectReceiver {
    private final JsonRpcPeer mPeer;
    
    public UnregisterOnDisconnect(JsonRpcPeer param1JsonRpcPeer) {
      this.mPeer = param1JsonRpcPeer;
    }
    
    public void onDisconnect() {
      ChromePeerManager.this.removePeer(this.mPeer);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\helper\ChromePeerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */