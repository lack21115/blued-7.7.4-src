package com.blued.android.chat.core.pack;

import com.blued.android.chat.utils.BytesUtils;

public class DeleteAllPackage extends DeleteBasePackage {
  private final DeleteHeader deleteHeader;
  
  public DeleteAllPackage(long paramLong, boolean paramBoolean) {
    super(paramLong);
    this.deleteHeader = new DeleteHeader((short)1, paramBoolean);
  }
  
  protected BytesData msgDataToByte() {
    BytesData bytesData = new BytesData(5);
    byte b = this.deleteHeader.toByte();
    bytesData.data[0] = b;
    BytesUtils.numberTo4Bytes(bytesData.data, 1, this.localId);
    return bytesData;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[deleteHeader:");
    stringBuilder.append(this.deleteHeader);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\DeleteAllPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */