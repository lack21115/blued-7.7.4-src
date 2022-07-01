package com.blued.android.chat.core.pack;

import com.blued.android.chat.utils.BytesUtils;

public class PushReadedPackage {
  public long msgId;
  
  public PushBasePackage pushBasePackage;
  
  public long sessionId;
  
  public short sessionType;
  
  protected void parseSubPackageData(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    this.sessionType = BytesUtils.byteTo1Number(paramArrayOfbyte, paramInt1);
    this.sessionId = BytesUtils.bytesTo4Number(paramArrayOfbyte, ++paramInt1);
    this.msgId = BytesUtils.byteTo8Number(paramArrayOfbyte, paramInt1 + 4);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[sessionType:");
    stringBuilder.append(this.sessionType);
    stringBuilder.append(", sessionId:");
    stringBuilder.append(this.sessionId);
    stringBuilder.append(", msgId:");
    stringBuilder.append(this.msgId);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\PushReadedPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */