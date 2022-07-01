package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import java.util.Map;

public class ReqWawajiControllerReadyPackage extends ReqBasePackage {
  public final long sessionId;
  
  public final int sessionType = 6;
  
  public ReqWawajiControllerReadyPackage(long paramLong1, long paramLong2) {
    super((short)22, paramLong2);
    this.sessionId = paramLong1;
  }
  
  protected Map<String, Object> getReqInfo() {
    ArrayMap<String, Integer> arrayMap = new ArrayMap();
    arrayMap.put("session_type", Integer.valueOf(6));
    arrayMap.put("session_id", Long.valueOf(this.sessionId));
    return (Map)arrayMap;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[sessionId:");
    stringBuilder.append(this.sessionId);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\ReqWawajiControllerReadyPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */