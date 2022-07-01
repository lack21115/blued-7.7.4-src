package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import java.util.Map;

public class ReqDestroyMsgPackage extends ReqBasePackage {
  public final long msgId;
  
  public final long sessionId;
  
  public final short sessionType;
  
  public ReqDestroyMsgPackage(short paramShort, long paramLong1, long paramLong2, long paramLong3) {
    super((short)2, paramLong3);
    this.sessionType = paramShort;
    this.sessionId = paramLong1;
    this.msgId = paramLong2;
  }
  
  protected Map<String, Object> getReqInfo() {
    ArrayMap<String, Short> arrayMap = new ArrayMap();
    arrayMap.put("session_type", Short.valueOf(this.sessionType));
    arrayMap.put("session_id", Long.valueOf(this.sessionId));
    arrayMap.put("msg_id", Long.valueOf(this.msgId));
    return (Map)arrayMap;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\ReqDestroyMsgPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */