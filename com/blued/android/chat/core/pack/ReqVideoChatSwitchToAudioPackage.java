package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import java.util.Map;

public class ReqVideoChatSwitchToAudioPackage extends ReqBasePackage {
  public final String roomId;
  
  public ReqVideoChatSwitchToAudioPackage(String paramString, long paramLong) {
    super((short)16, paramLong);
    this.roomId = paramString;
  }
  
  protected Map<String, Object> getReqInfo() {
    ArrayMap<String, String> arrayMap = new ArrayMap();
    arrayMap.put("room_id", this.roomId);
    return (Map)arrayMap;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[roomId:");
    stringBuilder.append(this.roomId);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\ReqVideoChatSwitchToAudioPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */