package com.facebook.stetho.inspector.jsonrpc;

import javax.annotation.Nullable;

public class PendingRequest {
  @Nullable
  public final PendingRequestCallback callback;
  
  public final long requestId;
  
  public PendingRequest(long paramLong, @Nullable PendingRequestCallback paramPendingRequestCallback) {
    this.requestId = paramLong;
    this.callback = paramPendingRequestCallback;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\jsonrpc\PendingRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */