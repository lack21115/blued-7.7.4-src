package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import java.util.Map;

public class ReqFlashVideoEmoji extends ReqBasePackage {
  public final String emojiTag;
  
  public final long matchedUid;
  
  public final String roomId;
  
  public ReqFlashVideoEmoji(long paramLong1, String paramString1, long paramLong2, String paramString2) {
    super((short)40, paramLong2);
    this.matchedUid = paramLong1;
    this.roomId = paramString1;
    this.emojiTag = paramString2;
  }
  
  protected Map<String, Object> getReqInfo() {
    ArrayMap<String, String> arrayMap = new ArrayMap();
    arrayMap.put("room_id", this.roomId);
    arrayMap.put("uid", Long.valueOf(this.matchedUid));
    arrayMap.put("emoji_tag", this.emojiTag);
    return (Map)arrayMap;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\ReqFlashVideoEmoji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */