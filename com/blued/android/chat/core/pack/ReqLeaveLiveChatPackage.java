package com.blued.android.chat.core.pack;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import java.util.Map;

public class ReqLeaveLiveChatPackage extends ReqBasePackage {
  public final String from;
  
  public final long sessionId;
  
  public final short sessionType;
  
  public ReqLeaveLiveChatPackage(short paramShort, long paramLong1, long paramLong2, String paramString) {
    super((short)7, paramLong2);
    this.sessionType = paramShort;
    this.sessionId = paramLong1;
    this.from = paramString;
  }
  
  protected Map<String, Object> getReqInfo() {
    ArrayMap<String, Short> arrayMap = new ArrayMap();
    arrayMap.put("session_type", Short.valueOf(this.sessionType));
    arrayMap.put("session_id", Long.valueOf(this.sessionId));
    if (!TextUtils.isEmpty(this.from))
      arrayMap.put("from", this.from); 
    return (Map)arrayMap;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[sessionType:");
    stringBuilder.append(this.sessionType);
    stringBuilder.append(", sessionId:");
    stringBuilder.append(this.sessionId);
    stringBuilder.append(", from:");
    stringBuilder.append(this.from);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\ReqLeaveLiveChatPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */