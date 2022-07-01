package com.facebook.stetho.inspector.network;

import java.io.UnsupportedEncodingException;

public class SimpleBinaryInspectorWebSocketFrame implements NetworkEventReporter.InspectorWebSocketFrame {
  private final byte[] mPayload;
  
  private final String mRequestId;
  
  public SimpleBinaryInspectorWebSocketFrame(String paramString, byte[] paramArrayOfbyte) {
    this.mRequestId = paramString;
    this.mPayload = paramArrayOfbyte;
  }
  
  public boolean mask() {
    return false;
  }
  
  public int opcode() {
    return 2;
  }
  
  public String payloadData() {
    try {
      return new String(this.mPayload, "UTF-8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new RuntimeException(unsupportedEncodingException);
    } 
  }
  
  public String requestId() {
    return this.mRequestId;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\network\SimpleBinaryInspectorWebSocketFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */