package com.blued.android.chat.core.pack;

import com.blued.android.chat.utils.BytesUtils;

public class PingPackage extends BasePackage {
  public int freqMs = 0;
  
  public PingPackage() {}
  
  public PingPackage(short paramShort) {
    this.ack = true;
    this.freqMs = paramShort;
  }
  
  protected BytesData msgDataToByte() {
    if (this.freqMs > 0) {
      BytesData bytesData = new BytesData(2);
      BytesUtils.numberTo2Bytes(bytesData.data, 0, this.freqMs);
      return bytesData;
    } 
    return null;
  }
  
  protected void parseMsgData(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    this.freqMs = BytesUtils.bytesTo2Number(paramArrayOfbyte, paramInt1);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[freqMs:");
    stringBuilder.append(this.freqMs);
    stringBuilder.append(", ack:");
    stringBuilder.append(this.ack);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\PingPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */