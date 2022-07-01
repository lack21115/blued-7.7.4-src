package com.blued.android.chat.core.pack;

import com.blued.android.chat.utils.BytesUtils;

public class DeleteMessagePackage extends DeleteBasePackage {
  private final DeleteHeader deleteHeader = new DeleteHeader((short)3, true);
  
  public final long messageId;
  
  public final long sessionId;
  
  public final short sessionType;
  
  public DeleteMessagePackage(short paramShort, long paramLong1, long paramLong2, long paramLong3) {
    super(paramLong3);
    this.sessionType = paramShort;
    this.sessionId = paramLong1;
    this.messageId = paramLong2;
  }
  
  protected BytesData msgDataToByte() {
    BytesData bytesData = new BytesData(18);
    bytesData.data[0] = this.deleteHeader.toByte();
    BytesUtils.numberTo4Bytes(bytesData.data, 1, this.localId);
    BytesUtils.numberTo1Byte(bytesData.data, 5, this.sessionType);
    BytesUtils.numberTo4Bytes(bytesData.data, 6, this.sessionId);
    BytesUtils.numberTo8Bytes(bytesData.data, 10, this.messageId);
    return bytesData;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[DeleteMessage, sessionType:");
    stringBuilder.append(this.sessionType);
    stringBuilder.append(", sessionId:");
    stringBuilder.append(this.sessionId);
    stringBuilder.append(", messageId:");
    stringBuilder.append(this.messageId);
    stringBuilder.append(", deleteHeader:");
    stringBuilder.append(this.deleteHeader);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\DeleteMessagePackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */