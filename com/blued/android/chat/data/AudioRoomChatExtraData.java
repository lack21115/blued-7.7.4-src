package com.blued.android.chat.data;

import com.blued.android.chat.utils.MsgPackHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AudioRoomChatExtraData implements Serializable {
  public int apply_count;
  
  public String bg_color;
  
  public List<RoomMember> change_members = new ArrayList<RoomMember>();
  
  public int is_public;
  
  public int looker_count;
  
  public List<RoomMember> looker_list = new ArrayList<RoomMember>();
  
  public int member_role = 2;
  
  public long room_create_time;
  
  public long room_id;
  
  public AudioLanguageModel room_language;
  
  public int room_member_count;
  
  public int room_member_lock_count;
  
  public int room_member_total;
  
  public List<RoomMember> room_members = new ArrayList<RoomMember>();
  
  public String room_name;
  
  public long room_owner;
  
  public String tags;
  
  public String user_sig;
  
  private void parseMembersMap(List<RoomMember> paramList, List<Map<String, Object>> paramList1) {
    if (paramList1 == null)
      return; 
    for (Map<String, Object> map : paramList1) {
      RoomMember roomMember = new RoomMember();
      roomMember.parseData(map);
      paramList.add(roomMember);
    } 
  }
  
  public void parseData(Map<String, Object> paramMap) {
    if (paramMap == null)
      return; 
    this.room_id = MsgPackHelper.getLongValue(paramMap, "room_id");
    this.room_name = MsgPackHelper.getStringValue(paramMap, "room_name");
    this.room_create_time = MsgPackHelper.getLongValue(paramMap, "room_create_time");
    this.room_owner = MsgPackHelper.getLongValue(paramMap, "room_owner");
    this.user_sig = MsgPackHelper.getStringValue(paramMap, "user_sig");
    this.member_role = MsgPackHelper.getIntValue(paramMap, "member_role");
    this.is_public = MsgPackHelper.getIntValue(paramMap, "is_public");
    this.room_language = new AudioLanguageModel();
    this.room_language.parseData(MsgPackHelper.getMapValue(paramMap, "room_language"));
    this.room_member_total = MsgPackHelper.getIntValue(paramMap, "room_member_total");
    this.room_member_lock_count = MsgPackHelper.getIntValue(paramMap, "room_member_lock_count");
    this.looker_count = MsgPackHelper.getIntValue(paramMap, "looker_count");
    this.apply_count = MsgPackHelper.getIntValue(paramMap, "apply_count");
    this.room_member_count = MsgPackHelper.getIntValue(paramMap, "room_member_count");
    this.bg_color = MsgPackHelper.getStringValue(paramMap, "bg_color");
    List<Map<String, Object>> list1 = MsgPackHelper.getListValue(paramMap, "room_members");
    List<Map<String, Object>> list2 = MsgPackHelper.getListValue(paramMap, "looker_list");
    List<Map<String, Object>> list3 = MsgPackHelper.getListValue(paramMap, "change_members");
    parseMembersMap(this.room_members, list1);
    parseMembersMap(this.looker_list, list2);
    parseMembersMap(this.change_members, list3);
    this.tags = MsgPackHelper.getStringValue(paramMap, "tags");
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("AudioRoomChatExtraData{room_id=");
    stringBuilder.append(this.room_id);
    stringBuilder.append(", room_name='");
    stringBuilder.append(this.room_name);
    stringBuilder.append('\'');
    stringBuilder.append(", room_create_time=");
    stringBuilder.append(this.room_create_time);
    stringBuilder.append(", room_owner=");
    stringBuilder.append(this.room_owner);
    stringBuilder.append(", user_sig=");
    stringBuilder.append(this.user_sig);
    stringBuilder.append(", member_role=");
    stringBuilder.append(this.member_role);
    stringBuilder.append(", is_public=");
    stringBuilder.append(this.is_public);
    stringBuilder.append(", room_language='");
    stringBuilder.append(this.room_language);
    stringBuilder.append('\'');
    stringBuilder.append(", roomMembersMaxCount=");
    stringBuilder.append(this.room_member_total);
    stringBuilder.append(", looker_count=");
    stringBuilder.append(this.looker_count);
    stringBuilder.append(", apply_count=");
    stringBuilder.append(this.apply_count);
    stringBuilder.append(", room_member_count=");
    stringBuilder.append(this.room_member_count);
    stringBuilder.append(", bg_color=");
    stringBuilder.append(this.bg_color);
    stringBuilder.append(", tags=");
    stringBuilder.append(this.tags);
    stringBuilder.append(", room_member_lock_count=");
    stringBuilder.append(this.room_member_lock_count);
    stringBuilder.append(", room_members=");
    stringBuilder.append(this.room_members);
    stringBuilder.append(", looker_list=");
    stringBuilder.append(this.looker_list);
    stringBuilder.append(", change_members=");
    stringBuilder.append(this.change_members);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public static class AudioLanguageModel implements Serializable {
    public String lan;
    
    public String lan_sim;
    
    public void parseData(Map<String, Object> param1Map) {
      if (param1Map == null)
        return; 
      this.lan = MsgPackHelper.getStringValue(param1Map, "lan");
      this.lan_sim = MsgPackHelper.getStringValue(param1Map, "lan_sim");
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("AudioLanguageModel{lan='");
      stringBuilder.append(this.lan);
      stringBuilder.append('\'');
      stringBuilder.append(", lan_sim='");
      stringBuilder.append(this.lan_sim);
      stringBuilder.append('\'');
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
  }
  
  public static class RoomMember implements Serializable {
    public String avatar;
    
    public int member_role;
    
    public String name;
    
    public long uid;
    
    public void parseData(Map<String, Object> param1Map) {
      if (param1Map == null)
        return; 
      this.uid = MsgPackHelper.getLongValue(param1Map, "uid");
      this.name = MsgPackHelper.getStringValue(param1Map, "name");
      this.avatar = MsgPackHelper.getStringValue(param1Map, "avatar");
      this.member_role = MsgPackHelper.getIntValue(param1Map, "member_role");
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("RoomMember{uid=");
      stringBuilder.append(this.uid);
      stringBuilder.append(", name='");
      stringBuilder.append(this.name);
      stringBuilder.append('\'');
      stringBuilder.append(", avatar='");
      stringBuilder.append(this.avatar);
      stringBuilder.append('\'');
      stringBuilder.append(", member_role='");
      stringBuilder.append(this.member_role);
      stringBuilder.append('\'');
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
    
    public static interface MemberRole {
      public static final int ANCHOR = 1;
      
      public static final int AUDIENCE = 2;
    }
  }
  
  public static interface MemberRole {
    public static final int ANCHOR = 1;
    
    public static final int AUDIENCE = 2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\data\AudioRoomChatExtraData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */