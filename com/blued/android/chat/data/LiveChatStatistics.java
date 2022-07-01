package com.blued.android.chat.data;

import com.blued.android.chat.utils.MsgPackHelper;
import java.util.Map;

public class LiveChatStatistics {
  public String audience_message;
  
  public int currentExperiencePoints;
  
  public int elapseTimeSec;
  
  public int lastExperiencePoints;
  
  public String message;
  
  public int reason;
  
  public int stopReason;
  
  public String title;
  
  public int topViewerCount;
  
  public int totalLikedCount;
  
  public int totalViewerCount;
  
  public static LiveChatStatistics parseData(Map<String, Object> paramMap) {
    LiveChatStatistics liveChatStatistics = null;
    if (paramMap == null)
      return null; 
    int i = MsgPackHelper.getIntValue(paramMap, "elapse_time");
    if (i > 0) {
      liveChatStatistics = new LiveChatStatistics();
      liveChatStatistics.elapseTimeSec = i;
      liveChatStatistics.topViewerCount = MsgPackHelper.getIntValue(paramMap, "top_count");
      liveChatStatistics.totalViewerCount = MsgPackHelper.getIntValue(paramMap, "watch_count");
      liveChatStatistics.totalLikedCount = MsgPackHelper.getIntValue(paramMap, "liked_count");
      liveChatStatistics.currentExperiencePoints = MsgPackHelper.getIntValue(paramMap, "current_exp");
      liveChatStatistics.lastExperiencePoints = MsgPackHelper.getIntValue(paramMap, "former_exp");
      liveChatStatistics.stopReason = MsgPackHelper.getIntValue(paramMap, "stop_reason");
      paramMap = MsgPackHelper.getMapValue(paramMap, "kick_info");
      liveChatStatistics.reason = MsgPackHelper.getIntValue(paramMap, "reason");
      liveChatStatistics.title = MsgPackHelper.getStringValue(paramMap, "title");
      liveChatStatistics.message = MsgPackHelper.getStringValue(paramMap, "message");
      liveChatStatistics.audience_message = MsgPackHelper.getStringValue(paramMap, "audience_message");
    } 
    return liveChatStatistics;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\data\LiveChatStatistics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */