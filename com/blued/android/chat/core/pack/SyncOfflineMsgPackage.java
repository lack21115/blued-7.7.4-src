package com.blued.android.chat.core.pack;

import com.blued.android.chat.utils.BytesUtils;

public class SyncOfflineMsgPackage extends SyncBasePackage {
  private final long multiSyncLocalId;
  
  public SyncOfflineMsgPackage(long paramLong1, long paramLong2) {
    super((short)2, paramLong1);
    this.multiSyncLocalId = paramLong2;
  }
  
  protected BytesData msgDataToByte() {
    BytesData bytesData = new BytesData(9);
    BytesUtils.numberTo1Byte(bytesData.data, 0, this.syncType);
    BytesUtils.numberTo4Bytes(bytesData.data, 1, this.localId);
    BytesUtils.numberTo4Bytes(bytesData.data, 5, this.multiSyncLocalId);
    return bytesData;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[SyncNew, multiSyncLocalId: ");
    stringBuilder.append(this.multiSyncLocalId);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\SyncOfflineMsgPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */