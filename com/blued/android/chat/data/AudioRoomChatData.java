package com.blued.android.chat.data;

import java.io.Serializable;
import java.util.Map;

public class AudioRoomChatData implements Serializable {
  public long msg_type;
  
  public AudioRoomChatExtraData room_data;
  
  public long session_id;
  
  public short session_type;
  
  public void parseExtraData(Map<String, Object> paramMap) {
    if (paramMap == null)
      return; 
    this.room_data = new AudioRoomChatExtraData();
    this.room_data.parseData(paramMap);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("AudioRoomChatData{session_type=");
    stringBuilder.append(this.session_type);
    stringBuilder.append(", session_id=");
    stringBuilder.append(this.session_id);
    stringBuilder.append(", msg_type=");
    stringBuilder.append(this.msg_type);
    stringBuilder.append(", room_data=");
    stringBuilder.append(this.room_data.toString());
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\data\AudioRoomChatData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */