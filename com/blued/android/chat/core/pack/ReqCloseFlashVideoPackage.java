package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import java.util.Map;

public class ReqCloseFlashVideoPackage extends ReqBasePackage {
  public final long matchedUid;
  
  public final int reason;
  
  public final String roomId;
  
  public ReqCloseFlashVideoPackage(long paramLong1, String paramString, int paramInt, long paramLong2) {
    super((short)20, paramLong2);
    this.matchedUid = paramLong1;
    this.roomId = paramString;
    this.reason = paramInt;
  }
  
  protected Map<String, Object> getReqInfo() {
    ArrayMap<String, String> arrayMap = new ArrayMap();
    arrayMap.put("room_id", this.roomId);
    arrayMap.put("uid", Long.valueOf(this.matchedUid));
    arrayMap.put("reason", Integer.valueOf(this.reason));
    return (Map)arrayMap;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[uid:");
    stringBuilder.append(this.matchedUid);
    stringBuilder.append(", roomId:");
    stringBuilder.append(this.roomId);
    stringBuilder.append(", reason:");
    stringBuilder.append(this.reason);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\ReqCloseFlashVideoPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */