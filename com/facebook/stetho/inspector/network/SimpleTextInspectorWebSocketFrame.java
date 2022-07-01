package com.facebook.stetho.inspector.network;

public class SimpleTextInspectorWebSocketFrame implements NetworkEventReporter.InspectorWebSocketFrame {
  private final String mPayload;
  
  private final String mRequestId;
  
  public SimpleTextInspectorWebSocketFrame(String paramString1, String paramString2) {
    this.mRequestId = paramString1;
    this.mPayload = paramString2;
  }
  
  public boolean mask() {
    return false;
  }
  
  public int opcode() {
    return 1;
  }
  
  public String payloadData() {
    return this.mPayload;
  }
  
  public String requestId() {
    return this.mRequestId;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\network\SimpleTextInspectorWebSocketFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */