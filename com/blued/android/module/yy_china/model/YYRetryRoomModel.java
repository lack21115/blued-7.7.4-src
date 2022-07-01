package com.blued.android.module.yy_china.model;

import java.util.List;

public class YYRetryRoomModel extends YYRoomModel {
  public List<BlindPublishModel> blind_publish;
  
  public String chat_anchor;
  
  public String is_mic;
  
  public int is_open_mic;
  
  public long vote_countdown;
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("YYRetryRoomModel{is_open_mic=");
    stringBuilder.append(this.is_open_mic);
    stringBuilder.append(", chat_anchor='");
    stringBuilder.append(this.chat_anchor);
    stringBuilder.append('\'');
    stringBuilder.append(", is_mic='");
    stringBuilder.append(this.is_mic);
    stringBuilder.append('\'');
    stringBuilder.append(", room_id='");
    stringBuilder.append(this.room_id);
    stringBuilder.append('\'');
    stringBuilder.append(", room_name='");
    stringBuilder.append(this.room_name);
    stringBuilder.append('\'');
    stringBuilder.append(", mute='");
    stringBuilder.append(this.mute);
    stringBuilder.append('\'');
    stringBuilder.append(", vote_countdown='");
    stringBuilder.append(this.vote_countdown);
    stringBuilder.append('\'');
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\model\YYRetryRoomModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */