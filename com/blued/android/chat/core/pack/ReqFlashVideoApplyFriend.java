package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import java.util.Map;

public class ReqFlashVideoApplyFriend extends ReqBasePackage {
  public final long matchedUid;
  
  public final String roomId;
  
  public ReqFlashVideoApplyFriend(long paramLong1, String paramString, long paramLong2) {
    super((short)36, paramLong2);
    this.matchedUid = paramLong1;
    this.roomId = paramString;
  }
  
  protected Map<String, Object> getReqInfo() {
    ArrayMap<String, String> arrayMap = new ArrayMap();
    arrayMap.put("room_id", this.roomId);
    arrayMap.put("uid", Long.valueOf(this.matchedUid));
    return (Map)arrayMap;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\ReqFlashVideoApplyFriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */