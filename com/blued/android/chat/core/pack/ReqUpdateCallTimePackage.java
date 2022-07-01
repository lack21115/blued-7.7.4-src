package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import java.util.Map;

public class ReqUpdateCallTimePackage extends ReqBasePackage {
  public final int callTimeSec;
  
  public final String roomId;
  
  public ReqUpdateCallTimePackage(String paramString, int paramInt, long paramLong) {
    super((short)15, paramLong);
    this.roomId = paramString;
    this.callTimeSec = paramInt;
  }
  
  protected Map<String, Object> getReqInfo() {
    ArrayMap<String, String> arrayMap = new ArrayMap();
    arrayMap.put("room_id", this.roomId);
    arrayMap.put("total_time", Integer.valueOf(this.callTimeSec));
    return (Map)arrayMap;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[roomId:");
    stringBuilder.append(this.roomId);
    stringBuilder.append(", callTimeSec:");
    stringBuilder.append(this.callTimeSec);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\ReqUpdateCallTimePackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */