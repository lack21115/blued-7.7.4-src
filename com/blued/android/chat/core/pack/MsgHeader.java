package com.blued.android.chat.core.pack;

public class MsgHeader {
  public boolean isDeleted;
  
  public boolean isNeedReceiptFlag;
  
  public boolean isOrder;
  
  public boolean isReaded;
  
  public boolean isReceiptFlag;
  
  public boolean isSendByUser;
  
  public MsgHeader() {
    this.isOrder = false;
    this.isDeleted = false;
    this.isSendByUser = false;
    this.isReaded = false;
    this.isReceiptFlag = false;
    this.isNeedReceiptFlag = false;
  }
  
  public MsgHeader(byte paramByte) {
    boolean bool2 = false;
    if ((paramByte & 0x20) > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.isOrder = bool1;
    if ((paramByte & 0x10) > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.isDeleted = bool1;
    if ((paramByte & 0x8) > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.isSendByUser = bool1;
    if ((paramByte & 0x4) > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.isReaded = bool1;
    if ((paramByte & 0x2) > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.isReceiptFlag = bool1;
    boolean bool1 = bool2;
    if ((paramByte & 0x1) > 0)
      bool1 = true; 
    this.isNeedReceiptFlag = bool1;
  }
  
  public byte toByte() {
    if (this.isOrder) {
      b2 = (byte)32;
    } else {
      b2 = 0;
    } 
    byte b1 = b2;
    if (this.isDeleted)
      b1 = (byte)(b2 | 0x10); 
    byte b2 = b1;
    if (this.isSendByUser)
      b2 = (byte)(b1 | 0x8); 
    b1 = b2;
    if (this.isReaded)
      b1 = (byte)(b2 | 0x4); 
    b2 = b1;
    if (this.isReceiptFlag)
      b2 = (byte)(b1 | 0x2); 
    b1 = b2;
    if (this.isNeedReceiptFlag)
      b1 = (byte)(b2 | 0x1); 
    return b1;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[isOrder:");
    stringBuilder.append(this.isOrder);
    stringBuilder.append(", isDeleted:");
    stringBuilder.append(this.isDeleted);
    stringBuilder.append(", isSendByUser:");
    stringBuilder.append(this.isSendByUser);
    stringBuilder.append(", isReaded:");
    stringBuilder.append(this.isReaded);
    stringBuilder.append(", isReceiptFlag:");
    stringBuilder.append(this.isReceiptFlag);
    stringBuilder.append(", isNeedReceiptFlag:");
    stringBuilder.append(this.isNeedReceiptFlag);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\MsgHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */