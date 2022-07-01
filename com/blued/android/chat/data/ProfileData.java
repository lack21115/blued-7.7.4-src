package com.blued.android.chat.data;

import com.blued.android.chat.ChatManager;
import com.blued.android.chat.utils.MsgPackHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfileData implements Serializable {
  public int age;
  
  public String avatar;
  
  public String avatarPendant;
  
  public String bluedBadgeImage;
  
  public int channelType;
  
  public String citySettled;
  
  public int height;
  
  public int hideVipLook;
  
  public long invisibleUid;
  
  public boolean isLiveManager;
  
  public String liangId;
  
  public int liangType;
  
  public int liveViewerRank;
  
  public String name;
  
  public int oFaceStatus;
  
  public int ohideVipLook;
  
  public int ovipGrade;
  
  public int richLevel;
  
  public String role;
  
  public long uid;
  
  public int vBadge;
  
  public int vipAnnual;
  
  public int vipExpLvl;
  
  public int vipGrade;
  
  public int weight;
  
  public static ProfileData parseProfile(Map<String, Object> paramMap, String paramString) {
    paramMap = MsgPackHelper.getMapValue(paramMap, paramString);
    if (paramMap != null) {
      ProfileData profileData = new ProfileData();
      profileData.parseMsgPackData(paramMap);
      return profileData;
    } 
    return null;
  }
  
  public static List<ProfileData> parseProfileList(List<Map<String, Object>> paramList) {
    if (paramList == null)
      return null; 
    ArrayList<ProfileData> arrayList = new ArrayList();
    for (Map<String, Object> map : paramList) {
      ProfileData profileData = new ProfileData();
      profileData.parseMsgPackData(map);
      arrayList.add(profileData);
    } 
    return arrayList;
  }
  
  public void parseMsgPackData(Map<String, Object> paramMap) {
    boolean bool;
    if (paramMap == null)
      return; 
    this.uid = MsgPackHelper.getLongValue(paramMap, "uid");
    this.name = MsgPackHelper.getStringValue(paramMap, "name");
    this.avatar = MsgPackHelper.getStringValue(paramMap, "avatar");
    this.vBadge = MsgPackHelper.getIntValue(paramMap, "vbadge");
    this.bluedBadgeImage = MsgPackHelper.getStringValue(paramMap, "blued_badge_pic");
    if (ChatManager.clientType == ChatManager.ClientType.CHINA) {
      this.richLevel = MsgPackHelper.getIntValue(paramMap, "rich_level");
    } else if (ChatManager.clientType == ChatManager.ClientType.INTERNATIONAL) {
      this.richLevel = MsgPackHelper.getIntValue(paramMap, "o_rich_level");
    } 
    this.vipGrade = MsgPackHelper.getIntValue(paramMap, "vip_grade");
    this.vipAnnual = MsgPackHelper.getIntValue(paramMap, "vip_annual");
    this.vipExpLvl = MsgPackHelper.getIntValue(paramMap, "vip_exp_lvl");
    this.hideVipLook = MsgPackHelper.getIntValue(paramMap, "is_hide_vip_look");
    this.ovipGrade = MsgPackHelper.getIntValue(paramMap, "o_vip_grade");
    this.ohideVipLook = MsgPackHelper.getIntValue(paramMap, "o_is_hide_vip_look");
    this.oFaceStatus = MsgPackHelper.getIntValue(paramMap, "o_face_status");
    this.age = MsgPackHelper.getIntValue(paramMap, "age");
    this.height = MsgPackHelper.getIntValue(paramMap, "height");
    this.weight = MsgPackHelper.getIntValue(paramMap, "weight");
    this.role = MsgPackHelper.getStringValue(paramMap, "role");
    this.citySettled = MsgPackHelper.getStringValue(paramMap, "city_settled");
    if (MsgPackHelper.getIntValue(paramMap, "is_manager") == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    this.isLiveManager = bool;
    this.channelType = MsgPackHelper.getIntValue(paramMap, "channel_type");
    this.avatarPendant = MsgPackHelper.getStringValue(paramMap, "avatar_pendant");
    if (MsgPackHelper.getIntValue(paramMap, "is_open_privilege", 0) == 1)
      this.invisibleUid = MsgPackHelper.getLongValue(paramMap, "true_uid"); 
    this.liangType = MsgPackHelper.getIntValue(paramMap, "liang_type");
    this.liangId = MsgPackHelper.getStringValue(paramMap, "liang_id");
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[uid:");
    stringBuilder.append(this.uid);
    stringBuilder.append(", name:");
    stringBuilder.append(this.name);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\data\ProfileData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */