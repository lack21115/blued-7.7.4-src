package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import com.blued.android.chat.ChatManager;
import java.util.Map;

public class ReqCreateLiveChatPackage extends ReqBasePackage {
  public final String cover;
  
  public final String description;
  
  public final int liveType;
  
  public final int privateFlag;
  
  public final int screenPattern;
  
  public final short sessionType;
  
  public final int shareMirror;
  
  public final int showNearby;
  
  public ReqCreateLiveChatPackage(int paramInt1, int paramInt2, String paramString1, String paramString2, long paramLong, int paramInt3, int paramInt4, int paramInt5) {
    super((short)3, paramLong);
    if (ChatManager.clientType == ChatManager.ClientType.CHINA) {
      this.sessionType = 4;
    } else if (ChatManager.clientType == ChatManager.ClientType.INTERNATIONAL) {
      this.sessionType = 5;
    } else {
      this.sessionType = -1;
    } 
    this.liveType = paramInt2;
    this.description = paramString1;
    this.cover = paramString2;
    this.screenPattern = paramInt3;
    this.showNearby = paramInt4;
    this.privateFlag = paramInt5;
    this.shareMirror = paramInt1;
  }
  
  protected Map<String, Object> getReqInfo() {
    ArrayMap<String, Short> arrayMap = new ArrayMap();
    short s = this.sessionType;
    if (s > 0)
      arrayMap.put("session_type", Short.valueOf(s)); 
    arrayMap.put("share_mirror", Integer.valueOf(this.shareMirror));
    arrayMap.put("live_type", Integer.valueOf(this.liveType));
    arrayMap.put("description", this.description);
    arrayMap.put("pic_url", this.cover);
    arrayMap.put("screen_pattern", Integer.valueOf(this.screenPattern));
    arrayMap.put("show_in_nearby", Integer.valueOf(this.showNearby));
    arrayMap.put("is_private", Integer.valueOf(this.privateFlag));
    return (Map)arrayMap;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[sessionType:");
    stringBuilder.append(this.sessionType);
    stringBuilder.append(", share_mirror:");
    stringBuilder.append(this.shareMirror);
    stringBuilder.append(", liveType:");
    stringBuilder.append(this.liveType);
    stringBuilder.append(", description:");
    stringBuilder.append(this.description);
    stringBuilder.append(", cover:");
    stringBuilder.append(this.cover);
    stringBuilder.append(", screenPattern:");
    stringBuilder.append(this.screenPattern);
    stringBuilder.append(", showNearby:");
    stringBuilder.append(this.showNearby);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\ReqCreateLiveChatPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */