package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import java.util.Map;

public class ReqStartJoinLive extends ReqBasePackage {
  public final long invitedUid;
  
  public final long sessionId;
  
  public final short sessionType;
  
  public ReqStartJoinLive(short paramShort, long paramLong1, long paramLong2, long paramLong3) {
    super((short)10, paramLong3);
    this.sessionType = paramShort;
    this.sessionId = paramLong1;
    this.invitedUid = paramLong2;
  }
  
  protected Map<String, Object> getReqInfo() {
    ArrayMap<String, Short> arrayMap = new ArrayMap();
    arrayMap.put("session_type", Short.valueOf(this.sessionType));
    arrayMap.put("session_id", Long.valueOf(this.sessionId));
    long l = this.invitedUid;
    if (l > 0L)
      arrayMap.put("invited_uid", Long.valueOf(l)); 
    return (Map)arrayMap;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[sessionType:");
    stringBuilder.append(this.sessionType);
    stringBuilder.append(", sessionId:");
    stringBuilder.append(this.sessionId);
    stringBuilder.append(", invitedUid:");
    stringBuilder.append(this.invitedUid);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\ReqStartJoinLive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */