package com.blued.android.chat.core.pack;

import com.blued.android.chat.utils.BytesUtils;

public class SyncIntervalMsgsPackage extends SyncBasePackage {
  private long endMsgId;
  
  private long sessionId;
  
  private short sessionType;
  
  private long startMsgId;
  
  public SyncIntervalMsgsPackage(short paramShort, long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
    super((short)3, paramLong4);
    this.sessionType = paramShort;
    this.sessionId = paramLong1;
    this.startMsgId = paramLong2;
    this.endMsgId = paramLong3;
  }
  
  protected BytesData msgDataToByte() {
    BytesData bytesData = new BytesData(26);
    BytesUtils.numberTo1Byte(bytesData.data, 0, this.syncType);
    BytesUtils.numberTo4Bytes(bytesData.data, 1, this.localId);
    BytesUtils.numberTo1Byte(bytesData.data, 5, this.sessionType);
    BytesUtils.numberTo4Bytes(bytesData.data, 6, this.sessionId);
    BytesUtils.numberTo8Bytes(bytesData.data, 10, this.startMsgId);
    BytesUtils.numberTo8Bytes(bytesData.data, 18, this.endMsgId);
    return bytesData;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[sessionType:");
    stringBuilder.append(this.sessionType);
    stringBuilder.append(", sessionId:");
    stringBuilder.append(this.sessionId);
    stringBuilder.append(", startMsgId:");
    stringBuilder.append(this.startMsgId);
    stringBuilder.append(", endMsgId:");
    stringBuilder.append(this.endMsgId);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\SyncIntervalMsgsPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */