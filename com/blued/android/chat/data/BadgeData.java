package com.blued.android.chat.data;

import com.blued.android.chat.utils.MsgPackHelper;
import java.io.Serializable;
import java.util.Map;

public class BadgeData implements Serializable {
  public long id;
  
  public String url;
  
  public void parseBadgeData(Map<String, Object> paramMap) {
    if (paramMap == null)
      return; 
    this.id = MsgPackHelper.getLongValue(paramMap, "id");
    this.url = MsgPackHelper.getStringValue(paramMap, "url");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\data\BadgeData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */