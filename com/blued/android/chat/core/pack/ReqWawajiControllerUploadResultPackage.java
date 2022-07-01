package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import java.util.Map;

public class ReqWawajiControllerUploadResultPackage extends ReqBasePackage {
  public final String orderId;
  
  public final int result;
  
  public final long sessionId;
  
  public final long userId;
  
  public ReqWawajiControllerUploadResultPackage(long paramLong1, long paramLong2, String paramString, int paramInt, long paramLong3) {
    super((short)28, paramLong3);
    this.sessionId = paramLong1;
    this.userId = paramLong2;
    this.orderId = paramString;
    this.result = paramInt;
  }
  
  protected Map<String, Object> getReqInfo() {
    ArrayMap<String, Short> arrayMap = new ArrayMap();
    arrayMap.put("session_type", Short.valueOf((short)6));
    arrayMap.put("session_id", Long.valueOf(this.sessionId));
    arrayMap.put("uid", Long.valueOf(this.userId));
    arrayMap.put("order_id", this.orderId);
    arrayMap.put("result", Integer.valueOf(this.result));
    return (Map)arrayMap;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[sessionId:");
    stringBuilder.append(this.sessionId);
    stringBuilder.append(", userId:");
    stringBuilder.append(this.userId);
    stringBuilder.append(", orderId:");
    stringBuilder.append(this.orderId);
    stringBuilder.append(", result:");
    stringBuilder.append(this.result);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\ReqWawajiControllerUploadResultPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */