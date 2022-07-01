package com.sina.weibo.sdk.statistic;

import java.util.Map;

class EventLog extends PageLog {
  private String mEvent_id;
  
  private Map<String, String> mExtend;
  
  public EventLog(String paramString1, String paramString2, Map<String, String> paramMap) {
    super(paramString1);
    this.mEvent_id = paramString2;
    this.mExtend = paramMap;
  }
  
  public String getEvent_id() {
    return this.mEvent_id;
  }
  
  public Map<String, String> getExtend() {
    return this.mExtend;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\statistic\EventLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */