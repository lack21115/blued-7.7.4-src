package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import java.util.Map;

public class ReqGetLiveChatInfoPackage extends ReqBasePackage {
  public static final int GET_ALL = 0;
  
  public static final int GRT_VIEWERS = 1;
  
  public final int getType;
  
  public final long sessionId;
  
  public final short sessionType;
  
  public ReqGetLiveChatInfoPackage(short paramShort, long paramLong1, int paramInt, long paramLong2) {
    super((short)8, paramLong2);
    this.sessionType = paramShort;
    this.sessionId = paramLong1;
    this.getType = paramInt;
  }
  
  protected Map<String, Object> getReqInfo() {
    ArrayMap<String, Short> arrayMap = new ArrayMap();
    arrayMap.put("session_type", Short.valueOf(this.sessionType));
    arrayMap.put("session_id", Long.valueOf(this.sessionId));
    arrayMap.put("type", Integer.valueOf(this.getType));
    return (Map)arrayMap;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[sessionType:");
    stringBuilder.append(this.sessionType);
    stringBuilder.append(", sessionId:");
    stringBuilder.append(this.sessionId);
    stringBuilder.append(", getType:");
    stringBuilder.append(this.getType);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\ReqGetLiveChatInfoPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */