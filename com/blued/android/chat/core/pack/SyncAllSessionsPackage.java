package com.blued.android.chat.core.pack;

import com.blued.android.chat.utils.BytesUtils;

public class SyncAllSessionsPackage extends SyncBasePackage {
  public SyncAllSessionsPackage(long paramLong) {
    super((short)1, paramLong);
  }
  
  protected BytesData msgDataToByte() {
    BytesData bytesData = new BytesData(9);
    BytesUtils.numberTo1Byte(bytesData.data, 0, this.syncType);
    BytesUtils.numberTo4Bytes(bytesData.data, 1, this.localId);
    return bytesData;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[SyncAll]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\SyncAllSessionsPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */