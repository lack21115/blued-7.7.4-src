package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import java.util.Map;

public class ReqLiveChatStopTalkPackage extends ReqBasePackage {
  public final int enable;
  
  public final long sessionId;
  
  public final short sessionType;
  
  public final long stopTalkUid;
  
  public ReqLiveChatStopTalkPackage(short paramShort, long paramLong1, long paramLong2, int paramInt, long paramLong3) {
    super((short)5, paramLong3);
    this.sessionType = paramShort;
    this.sessionId = paramLong1;
    this.stopTalkUid = paramLong2;
    this.enable = paramInt;
  }
  
  protected Map<String, Object> getReqInfo() {
    ArrayMap<String, Short> arrayMap = new ArrayMap();
    arrayMap.put("session_type", Short.valueOf(this.sessionType));
    arrayMap.put("session_id", Long.valueOf(this.sessionId));
    arrayMap.put("uid", Long.valueOf(this.stopTalkUid));
    arrayMap.put("enable", Integer.valueOf(this.enable));
    return (Map)arrayMap;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[sessionType:");
    stringBuilder.append(this.sessionType);
    stringBuilder.append(", sessionId:");
    stringBuilder.append(this.sessionId);
    stringBuilder.append(", stopTalkUid:");
    stringBuilder.append(this.stopTalkUid);
    stringBuilder.append(", enable:");
    stringBuilder.append(this.enable);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\ReqLiveChatStopTalkPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */