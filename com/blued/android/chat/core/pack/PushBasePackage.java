package com.blued.android.chat.core.pack;

public class PushBasePackage extends BasePackage {
  public MsgHeader msgHeader;
  
  public PushMsgPackage pushMsgPackage;
  
  public PushReadedPackage pushReadedPackage;
  
  public static PushBasePackage getDefaultInstance() {
    PushBasePackage pushBasePackage = new PushBasePackage();
    pushBasePackage.msgHeader = new MsgHeader();
    PushMsgPackage pushMsgPackage = new PushMsgPackage();
    pushMsgPackage.pushBasePackage = pushBasePackage;
    pushBasePackage.pushMsgPackage = pushMsgPackage;
    return pushBasePackage;
  }
  
  protected void parseMsgData(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    this.msgHeader = new MsgHeader(paramArrayOfbyte[paramInt1]);
    paramInt1++;
    if (this.msgHeader.isReceiptFlag) {
      this.pushReadedPackage = new PushReadedPackage();
      PushReadedPackage pushReadedPackage = this.pushReadedPackage;
      pushReadedPackage.pushBasePackage = this;
      pushReadedPackage.parseSubPackageData(paramArrayOfbyte, paramInt1, paramInt2);
      return;
    } 
    this.pushMsgPackage = new PushMsgPackage();
    PushMsgPackage pushMsgPackage = this.pushMsgPackage;
    pushMsgPackage.pushBasePackage = this;
    pushMsgPackage.parseSubPackageData(paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[msgHeader:");
    stringBuilder.append(this.msgHeader);
    stringBuilder.append(", pushReadedPackage:");
    stringBuilder.append(this.pushReadedPackage);
    stringBuilder.append(", _pushMsgPackage:");
    stringBuilder.append(this.pushMsgPackage);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\PushBasePackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */