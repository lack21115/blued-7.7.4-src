package com.blued.android.module.chat.model;

public class SessionBaseModel {
  private long loadName;
  
  private long sessionId;
  
  private short sessionType;
  
  public long getLoadName() {
    return this.loadName;
  }
  
  public long getSessionId() {
    return this.sessionId;
  }
  
  public short getSessionType() {
    return this.sessionType;
  }
  
  public void setLoadName(long paramLong) {
    this.loadName = paramLong;
  }
  
  public void setSessionId(long paramLong) {
    this.sessionId = paramLong;
  }
  
  public void setSessionType(short paramShort) {
    this.sessionType = paramShort;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SessionBaseModel{sessionId=");
    stringBuilder.append(this.sessionId);
    stringBuilder.append(", sessionType=");
    stringBuilder.append(this.sessionType);
    stringBuilder.append(", loadName=");
    stringBuilder.append(this.loadName);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\chat\model\SessionBaseModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */