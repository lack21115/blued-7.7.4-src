package com.blued.android.chat.core.pack;

import com.blued.android.chat.compatible.IReceiptSender;
import com.blued.android.chat.utils.BytesUtils;

public class SendReceiptPackage extends BasePackage {
  public final MsgHeader msgHeader;
  
  public final long msgId;
  
  public final long sessionId;
  
  public final short sessionType;
  
  public SendReceiptPackage(short paramShort, long paramLong1, long paramLong2, IReceiptSender.ReceiptType paramReceiptType) {
    boolean bool;
    this.type = 3;
    this.sessionType = paramShort;
    this.sessionId = paramLong1;
    this.msgId = paramLong2;
    this.msgHeader = new MsgHeader();
    MsgHeader msgHeader = this.msgHeader;
    if (paramReceiptType == IReceiptSender.ReceiptType.READED) {
      bool = true;
    } else {
      bool = false;
    } 
    msgHeader.isReaded = bool;
    this.msgHeader.isReceiptFlag = true;
  }
  
  public SendReceiptPackage(short paramShort, long paramLong1, long paramLong2, IReceiptSender.ReceiptType paramReceiptType, boolean paramBoolean) {
    boolean bool;
    this.type = 3;
    this.sessionType = paramShort;
    this.sessionId = paramLong1;
    this.msgId = paramLong2;
    this.msgHeader = new MsgHeader();
    MsgHeader msgHeader2 = this.msgHeader;
    if (paramReceiptType == IReceiptSender.ReceiptType.READED) {
      bool = true;
    } else {
      bool = false;
    } 
    msgHeader2.isReaded = bool;
    MsgHeader msgHeader1 = this.msgHeader;
    msgHeader1.isReceiptFlag = true;
    msgHeader1.isOrder = paramBoolean;
  }
  
  protected BytesData msgDataToByte() {
    BytesData bytesData = new BytesData(14);
    bytesData.data[0] = this.msgHeader.toByte();
    BytesUtils.numberTo1Byte(bytesData.data, 1, this.sessionType);
    BytesUtils.numberTo4Bytes(bytesData.data, 2, this.sessionId);
    BytesUtils.numberTo8Bytes(bytesData.data, 6, this.msgId);
    return bytesData;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[msgHeader:");
    stringBuilder.append(this.msgHeader);
    stringBuilder.append(", sessionType:");
    stringBuilder.append(this.sessionType);
    stringBuilder.append(", sessionId:");
    stringBuilder.append(this.sessionId);
    stringBuilder.append(", msgId:");
    stringBuilder.append(this.msgId);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\SendReceiptPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */