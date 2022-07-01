package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import java.util.Map;

public class ReqCloseVideoChatPackage extends ReqBasePackage {
  public final long chatTimeSec;
  
  public final int closeReason;
  
  public final String roomId;
  
  public ReqCloseVideoChatPackage(String paramString, int paramInt, long paramLong1, long paramLong2) {
    super((short)14, paramLong2);
    this.roomId = paramString;
    this.closeReason = paramInt;
    this.chatTimeSec = paramLong1;
  }
  
  protected Map<String, Object> getReqInfo() {
    ArrayMap<String, String> arrayMap = new ArrayMap();
    arrayMap.put("room_id", this.roomId);
    arrayMap.put("reason", Integer.valueOf(this.closeReason));
    arrayMap.put("total_time", Long.valueOf(this.chatTimeSec));
    return (Map)arrayMap;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[roomId:");
    stringBuilder.append(this.roomId);
    stringBuilder.append(", closeReason:");
    stringBuilder.append(this.closeReason);
    stringBuilder.append(", chatTimeSec:");
    stringBuilder.append(this.chatTimeSec);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\ReqCloseVideoChatPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */