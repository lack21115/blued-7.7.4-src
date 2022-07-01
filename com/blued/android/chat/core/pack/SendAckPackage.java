package com.blued.android.chat.core.pack;

import com.blued.android.chat.utils.BytesUtils;

public class SendAckPackage extends SendBasePackage {
  public long msgId;
  
  public long msgPreviousId;
  
  public long msgTime;
  
  public short result;
  
  protected void parseMsgData(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    this.result = BytesUtils.byteTo1Number(paramArrayOfbyte, paramInt1);
    this.localId = BytesUtils.bytesTo4Number(paramArrayOfbyte, ++paramInt1);
    paramInt1 += 4;
    this.msgTime = BytesUtils.bytesTo4Number(paramArrayOfbyte, paramInt1);
    if (this.result == 0) {
      this.msgId = BytesUtils.byteTo8Number(paramArrayOfbyte, paramInt1 + 4);
      this.msgPreviousId = this.msgId - 1L;
    } 
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[result:");
    stringBuilder.append(this.result);
    stringBuilder.append(", localId:");
    stringBuilder.append(this.localId);
    stringBuilder.append(", msgTime:");
    stringBuilder.append(this.msgTime);
    stringBuilder.append(", msgId:");
    stringBuilder.append(this.msgId);
    stringBuilder.append(", msgPreviousId:");
    stringBuilder.append(this.msgPreviousId);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\SendAckPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */