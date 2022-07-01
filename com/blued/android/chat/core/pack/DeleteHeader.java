package com.blued.android.chat.core.pack;

public class DeleteHeader {
  public static final short DELETE_ALL = 1;
  
  public static final short DELETE_MESSAGE = 3;
  
  public static final short DELETE_RETRACT = 4;
  
  public static final short DELETE_SESSION = 2;
  
  public short deleteFlag = 0;
  
  public short deleteType;
  
  public DeleteHeader(byte paramByte) {
    this.deleteType = (short)(paramByte >> 4);
    this.deleteFlag = (short)(paramByte & 0xF);
  }
  
  public DeleteHeader(short paramShort, boolean paramBoolean) {}
  
  public byte toByte() {
    return (byte)((byte)(this.deleteType << 4 | 0x0) | this.deleteFlag & 0xF);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[deleteType:");
    stringBuilder.append(this.deleteType);
    stringBuilder.append(", deleteFlag:");
    stringBuilder.append(this.deleteFlag);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\DeleteHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */