package com.blued.android.module.live_china.liveForMsg.model;

import java.io.Serializable;

public class LiveMsgShareEntity implements Serializable {
  public String avatar;
  
  public String copywriting;
  
  public String description;
  
  public String lid;
  
  public String link;
  
  public int msg_type;
  
  public String name;
  
  public String pic_url;
  
  public String push_type;
  
  public int redirect;
  
  public String room_id;
  
  public int room_type;
  
  public long session_id;
  
  public short session_type;
  
  public String uid;
  
  public int vbadge;
  
  public int watch_count;
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("LiveMsgShareEntity{pic_url='");
    stringBuilder.append(this.pic_url);
    stringBuilder.append('\'');
    stringBuilder.append(", name='");
    stringBuilder.append(this.name);
    stringBuilder.append('\'');
    stringBuilder.append(", description='");
    stringBuilder.append(this.description);
    stringBuilder.append('\'');
    stringBuilder.append(", watch_count=");
    stringBuilder.append(this.watch_count);
    stringBuilder.append(", vbadge=");
    stringBuilder.append(this.vbadge);
    stringBuilder.append(", avatar='");
    stringBuilder.append(this.avatar);
    stringBuilder.append('\'');
    stringBuilder.append(", uid='");
    stringBuilder.append(this.uid);
    stringBuilder.append('\'');
    stringBuilder.append(", lid='");
    stringBuilder.append(this.lid);
    stringBuilder.append('\'');
    stringBuilder.append(", copywriting='");
    stringBuilder.append(this.copywriting);
    stringBuilder.append('\'');
    stringBuilder.append(", session_type=");
    stringBuilder.append(this.session_type);
    stringBuilder.append(", session_id=");
    stringBuilder.append(this.session_id);
    stringBuilder.append(", room_id='");
    stringBuilder.append(this.room_id);
    stringBuilder.append('\'');
    stringBuilder.append(", room_type=");
    stringBuilder.append(this.room_type);
    stringBuilder.append(", msg_type=");
    stringBuilder.append(this.msg_type);
    stringBuilder.append(", redirect=");
    stringBuilder.append(this.redirect);
    stringBuilder.append(", link='");
    stringBuilder.append(this.link);
    stringBuilder.append('\'');
    stringBuilder.append(", push_type='");
    stringBuilder.append(this.push_type);
    stringBuilder.append('\'');
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\liveForMsg\model\LiveMsgShareEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */