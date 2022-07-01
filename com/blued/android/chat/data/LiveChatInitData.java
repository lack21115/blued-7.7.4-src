package com.blued.android.chat.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LiveChatInitData implements Serializable {
  public int admin_type;
  
  public List<BadgeData> badges;
  
  public double beansCount;
  
  public double beansCurrentCount;
  
  public String bluedBadgePic;
  
  public long elapseTimeSec = 0L;
  
  public EntranceData entranceData;
  
  public String icon;
  
  public String joinLiveConferenceId;
  
  public String joinLiveToken;
  
  public String liveDescription;
  
  public int liveType;
  
  public String liveUrl;
  
  public int live_quic;
  
  public ProfileData liverProfile;
  
  public int privateFlag;
  
  public String publish_url;
  
  public long rank;
  
  public int screenPattern;
  
  public long sessionId;
  
  public short sessionType;
  
  public String streamUrl;
  
  public long topCardCount;
  
  public String topCardUrl;
  
  public static List<BadgeData> parseBadgeMap(List<Map<String, Object>> paramList) {
    if (paramList == null)
      return null; 
    ArrayList<BadgeData> arrayList = new ArrayList();
    for (Map<String, Object> map : paramList) {
      BadgeData badgeData = new BadgeData();
      badgeData.parseBadgeData(map);
      arrayList.add(badgeData);
    } 
    return arrayList;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\data\LiveChatInitData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */