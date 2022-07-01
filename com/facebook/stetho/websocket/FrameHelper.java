package com.facebook.stetho.websocket;

import com.facebook.stetho.common.Utf8Charset;

class FrameHelper {
  public static Frame createBinaryFrame(byte[] paramArrayOfbyte) {
    return createSimpleFrame((byte)2, paramArrayOfbyte);
  }
  
  public static Frame createCloseFrame(int paramInt, String paramString) {
    byte b;
    if (paramString != null) {
      byte[] arrayOfByte1 = Utf8Charset.encodeUTF8(paramString);
      b = arrayOfByte1.length + 2;
    } else {
      paramString = null;
      b = 2;
    } 
    byte[] arrayOfByte = new byte[b];
    arrayOfByte[0] = (byte)(paramInt >> 8 & 0xFF);
    arrayOfByte[1] = (byte)(paramInt & 0xFF);
    if (paramString != null)
      System.arraycopy(paramString, 0, arrayOfByte, 2, paramString.length); 
    return createSimpleFrame((byte)8, arrayOfByte);
  }
  
  public static Frame createPingFrame(byte[] paramArrayOfbyte, int paramInt) {
    return createSimpleFrame((byte)9, paramArrayOfbyte, paramInt);
  }
  
  public static Frame createPongFrame(byte[] paramArrayOfbyte, int paramInt) {
    return createSimpleFrame((byte)10, paramArrayOfbyte, paramInt);
  }
  
  private static Frame createSimpleFrame(byte paramByte, byte[] paramArrayOfbyte) {
    return createSimpleFrame(paramByte, paramArrayOfbyte, paramArrayOfbyte.length);
  }
  
  private static Frame createSimpleFrame(byte paramByte, byte[] paramArrayOfbyte, int paramInt) {
    Frame frame = new Frame();
    frame.fin = true;
    frame.hasMask = false;
    frame.opcode = paramByte;
    frame.payloadLen = paramInt;
    frame.payloadData = paramArrayOfbyte;
    return frame;
  }
  
  public static Frame createTextFrame(String paramString) {
    return createSimpleFrame((byte)1, Utf8Charset.encodeUTF8(paramString));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\websocket\FrameHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */