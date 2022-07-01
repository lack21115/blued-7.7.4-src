package com.facebook.stetho.inspector.jsonrpc;

import android.database.Observable;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcRequest;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.websocket.SimpleSession;
import java.nio.channels.NotYetConnectedException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONObject;

public class JsonRpcPeer {
  private final DisconnectObservable mDisconnectObservable = new DisconnectObservable();
  
  private long mNextRequestId;
  
  private final ObjectMapper mObjectMapper;
  
  private final SimpleSession mPeer;
  
  private final Map<Long, PendingRequest> mPendingRequests = new HashMap<Long, PendingRequest>();
  
  public JsonRpcPeer(ObjectMapper paramObjectMapper, SimpleSession paramSimpleSession) {
    this.mObjectMapper = paramObjectMapper;
    this.mPeer = (SimpleSession)Util.throwIfNull(paramSimpleSession);
  }
  
  private long preparePendingRequest(PendingRequestCallback paramPendingRequestCallback) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mNextRequestId : J
    //   6: lstore_2
    //   7: aload_0
    //   8: lconst_1
    //   9: lload_2
    //   10: ladd
    //   11: putfield mNextRequestId : J
    //   14: aload_0
    //   15: getfield mPendingRequests : Ljava/util/Map;
    //   18: lload_2
    //   19: invokestatic valueOf : (J)Ljava/lang/Long;
    //   22: new com/facebook/stetho/inspector/jsonrpc/PendingRequest
    //   25: dup
    //   26: lload_2
    //   27: aload_1
    //   28: invokespecial <init> : (JLcom/facebook/stetho/inspector/jsonrpc/PendingRequestCallback;)V
    //   31: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   36: pop
    //   37: aload_0
    //   38: monitorexit
    //   39: lload_2
    //   40: lreturn
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Exception table:
    //   from	to	target	type
    //   2	37	41	finally
  }
  
  public PendingRequest getAndRemovePendingRequest(long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mPendingRequests : Ljava/util/Map;
    //   6: lload_1
    //   7: invokestatic valueOf : (J)Ljava/lang/Long;
    //   10: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   15: checkcast com/facebook/stetho/inspector/jsonrpc/PendingRequest
    //   18: astore_3
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_3
    //   22: areturn
    //   23: astore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	23	finally
  }
  
  public SimpleSession getWebSocket() {
    return this.mPeer;
  }
  
  public void invokeDisconnectReceivers() {
    this.mDisconnectObservable.onDisconnect();
  }
  
  public void invokeMethod(String paramString, Object paramObject, @Nullable PendingRequestCallback paramPendingRequestCallback) throws NotYetConnectedException {
    Util.throwIfNull(paramString);
    if (paramPendingRequestCallback != null) {
      Long long_ = Long.valueOf(preparePendingRequest(paramPendingRequestCallback));
    } else {
      paramPendingRequestCallback = null;
    } 
    JsonRpcRequest jsonRpcRequest = new JsonRpcRequest((Long)paramPendingRequestCallback, paramString, (JSONObject)this.mObjectMapper.convertValue(paramObject, JSONObject.class));
    String str = ((JSONObject)this.mObjectMapper.convertValue(jsonRpcRequest, JSONObject.class)).toString();
    this.mPeer.sendText(str);
  }
  
  public void registerDisconnectReceiver(DisconnectReceiver paramDisconnectReceiver) {
    this.mDisconnectObservable.registerObserver(paramDisconnectReceiver);
  }
  
  public void unregisterDisconnectReceiver(DisconnectReceiver paramDisconnectReceiver) {
    this.mDisconnectObservable.unregisterObserver(paramDisconnectReceiver);
  }
  
  static class DisconnectObservable extends Observable<DisconnectReceiver> {
    private DisconnectObservable() {}
    
    public void onDisconnect() {
      int j = this.mObservers.size();
      for (int i = 0; i < j; i++)
        ((DisconnectReceiver)this.mObservers.get(i)).onDisconnect(); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\jsonrpc\JsonRpcPeer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */