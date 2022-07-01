package com.blued.android.module.live_china.liveForMsg.model;

import com.blued.android.chat.data.ProfileData;
import com.blued.android.chat.utils.MsgPackHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LiveMsgBonusExtra {
  public int count;
  
  public long id;
  
  public String image;
  
  public ProfileData profile;
  
  public static List<LiveMsgBonusExtra> parseBonusMap(List<Map<String, Object>> paramList) {
    if (paramList == null)
      return null; 
    ArrayList<LiveMsgBonusExtra> arrayList = new ArrayList();
    for (Map<String, Object> map : paramList) {
      LiveMsgBonusExtra liveMsgBonusExtra = new LiveMsgBonusExtra();
      liveMsgBonusExtra.parseMsgPackData(map);
      arrayList.add(liveMsgBonusExtra);
    } 
    return arrayList;
  }
  
  public void parseMsgPackData(Map<String, Object> paramMap) {
    if (paramMap == null)
      return; 
    this.id = MsgPackHelper.getLongValue(paramMap, "id");
    this.count = MsgPackHelper.getIntValue(paramMap, "count");
    this.image = MsgPackHelper.getStringValue(paramMap, "image");
    this.profile = new ProfileData();
    this.profile.parseMsgPackData(MsgPackHelper.getMapValue(paramMap, "profile"));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\liveForMsg\model\LiveMsgBonusExtra.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */