package com.blued.android.chat.data;

import com.blued.android.chat.utils.MsgPackHelper;
import java.util.Map;

public class RelationProfileData extends ProfileData {
  public double distance;
  
  public int is_followed;
  
  public void parseMsgPackData(Map<String, Object> paramMap) {
    super.parseMsgPackData(paramMap);
    if (paramMap != null) {
      this.is_followed = MsgPackHelper.getIntValue(paramMap, "is_followed");
      this.distance = MsgPackHelper.getDoubleValue(paramMap, "distance");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\data\RelationProfileData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */