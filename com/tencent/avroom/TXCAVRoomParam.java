package com.tencent.avroom;

public class TXCAVRoomParam {
  public int authBits = -1;
  
  public byte[] authBuffer = null;
  
  public long roomID;
  
  public TXCAVRoomParam(long paramLong) {
    this.roomID = paramLong;
  }
  
  public TXCAVRoomParam authBits(int paramInt) {
    this.authBits = paramInt;
    return this;
  }
  
  public TXCAVRoomParam authBuffer(byte[] paramArrayOfbyte) {
    this.authBuffer = paramArrayOfbyte;
    return this;
  }
  
  public int getAuthBits() {
    return this.authBits;
  }
  
  public byte[] getAuthBuffer() {
    return this.authBuffer;
  }
  
  public long getRoomID() {
    return this.roomID;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\avroom\TXCAVRoomParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */