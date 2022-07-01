package com.blued.android.module.yy_china.model;

public class YYHeartModel {
  public int in_room;
  
  public int is_mics;
  
  public String room_id;
  
  public String uid;
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("YYHeartModel{uid='");
    stringBuilder.append(this.uid);
    stringBuilder.append('\'');
    stringBuilder.append(", room_id='");
    stringBuilder.append(this.room_id);
    stringBuilder.append('\'');
    stringBuilder.append(", is_mics=");
    stringBuilder.append(this.is_mics);
    stringBuilder.append(", in_room=");
    stringBuilder.append(this.in_room);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\model\YYHeartModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */