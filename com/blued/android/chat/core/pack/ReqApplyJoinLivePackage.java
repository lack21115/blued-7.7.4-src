package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import java.util.Map;

public class ReqApplyJoinLivePackage extends ReqBasePackage {
  public final long answerId;
  
  public final long sessionId;
  
  public final short sessionType;
  
  public ReqApplyJoinLivePackage(short paramShort, long paramLong1, long paramLong2, long paramLong3) {
    super((short)11, paramLong2);
    this.sessionType = paramShort;
    this.sessionId = paramLong1;
    this.answerId = paramLong3;
  }
  
  protected Map<String, Object> getReqInfo() {
    ArrayMap<String, Short> arrayMap = new ArrayMap();
    arrayMap.put("session_type", Short.valueOf(this.sessionType));
    arrayMap.put("session_id", Long.valueOf(this.sessionId));
    arrayMap.put("answer", Long.valueOf(this.answerId));
    return (Map)arrayMap;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[sessionType:");
    stringBuilder.append(this.sessionType);
    stringBuilder.append(", sessionId:");
    stringBuilder.append(this.sessionId);
    stringBuilder.append(", answerId:");
    stringBuilder.append(this.answerId);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\ReqApplyJoinLivePackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */