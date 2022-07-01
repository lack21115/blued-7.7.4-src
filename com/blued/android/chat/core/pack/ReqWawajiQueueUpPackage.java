package com.blued.android.chat.core.pack;

import java.util.HashMap;
import java.util.Map;

public class ReqWawajiQueueUpPackage extends ReqBasePackage {
  public final long sessionId;
  
  public final short sessionType = 6;
  
  public ReqWawajiQueueUpPackage(long paramLong1, long paramLong2) {
    super((short)26, paramLong2);
    this.sessionId = paramLong1;
  }
  
  protected Map<String, Object> getReqInfo() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("session_type", Short.valueOf((short)6));
    hashMap.put("session_id", Long.valueOf(this.sessionId));
    return (Map)hashMap;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\ReqWawajiQueueUpPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */