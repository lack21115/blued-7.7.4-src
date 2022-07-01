package com.blued.android.chat.core.pack;

import com.blued.android.chat.utils.BytesUtils;

public class DeleteAckPackage extends BasePackage {
  public int result;
  
  protected void parseMsgData(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    this.result = BytesUtils.byteTo1Number(paramArrayOfbyte, paramInt1);
    this.localId = BytesUtils.bytesTo4Number(paramArrayOfbyte, paramInt1 + 1);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[result:");
    stringBuilder.append(this.result);
    stringBuilder.append(", localId:");
    stringBuilder.append(this.localId);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\DeleteAckPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */