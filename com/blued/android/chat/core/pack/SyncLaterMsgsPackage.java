package com.blued.android.chat.core.pack;

import com.blued.android.chat.utils.BytesUtils;

public class SyncLaterMsgsPackage extends SyncBasePackage {
  private final long sessionId;
  
  private final short sessionType;
  
  public SyncLaterMsgsPackage(short paramShort, long paramLong1, long paramLong2) {
    super((short)4, paramLong2);
    this.sessionType = paramShort;
    this.sessionId = paramLong1;
  }
  
  protected BytesData msgDataToByte() {
    BytesData bytesData = new BytesData(10);
    BytesUtils.numberTo1Byte(bytesData.data, 0, this.syncType);
    BytesUtils.numberTo4Bytes(bytesData.data, 1, this.localId);
    BytesUtils.numberTo1Byte(bytesData.data, 5, this.sessionType);
    BytesUtils.numberTo4Bytes(bytesData.data, 6, this.sessionId);
    return bytesData;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[sessionType:");
    stringBuilder.append(this.sessionType);
    stringBuilder.append(", sessionId:");
    stringBuilder.append(this.sessionId);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\SyncLaterMsgsPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */