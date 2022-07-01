package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import java.util.Map;

public class ReqNotifyLiveJoinEndPackage extends ReqBasePackage {
  public final long endTime;
  
  public final long sessionId;
  
  public final short sessionType;
  
  public final long uid;
  
  public ReqNotifyLiveJoinEndPackage(short paramShort, long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
    super((short)32, paramLong4);
    this.sessionType = paramShort;
    this.sessionId = paramLong1;
    this.uid = paramLong2;
    this.endTime = paramLong3;
  }
  
  protected Map<String, Object> getReqInfo() {
    ArrayMap<String, Short> arrayMap = new ArrayMap();
    arrayMap.put("session_type", Short.valueOf(this.sessionType));
    arrayMap.put("session_id", Long.valueOf(this.sessionId));
    arrayMap.put("uid", Long.valueOf(this.uid));
    arrayMap.put("end_time", Long.valueOf(this.endTime));
    return (Map)arrayMap;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[sessionType:");
    stringBuilder.append(this.sessionType);
    stringBuilder.append(", sessionId:");
    stringBuilder.append(this.sessionId);
    stringBuilder.append(", uid:");
    stringBuilder.append(this.uid);
    stringBuilder.append(", endTime:");
    stringBuilder.append(this.endTime);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\ReqNotifyLiveJoinEndPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */