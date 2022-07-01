package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import java.util.Map;

public class ReqCreateVideoChatPackage extends ReqBasePackage {
  public final int chatSdkType;
  
  public final long invitedUid;
  
  public final String roomId;
  
  public final int roomType;
  
  public ReqCreateVideoChatPackage(long paramLong1, String paramString, int paramInt1, long paramLong2, int paramInt2) {
    super((short)13, paramLong2);
    this.invitedUid = paramLong1;
    this.roomId = paramString;
    this.roomType = paramInt1;
    this.chatSdkType = paramInt2;
  }
  
  protected Map<String, Object> getReqInfo() {
    ArrayMap<String, Long> arrayMap = new ArrayMap();
    arrayMap.put("invited_uid", Long.valueOf(this.invitedUid));
    arrayMap.put("room_id", this.roomId);
    arrayMap.put("room_type", Integer.valueOf(this.roomType));
    arrayMap.put("chat_sdk_type", Integer.valueOf(this.chatSdkType));
    return (Map)arrayMap;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[invitedUid:");
    stringBuilder.append(this.invitedUid);
    stringBuilder.append(", roomId:");
    stringBuilder.append(this.roomId);
    stringBuilder.append(", roomType:");
    stringBuilder.append(this.roomType);
    stringBuilder.append(", chatSdkType:");
    stringBuilder.append(this.chatSdkType);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\ReqCreateVideoChatPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */