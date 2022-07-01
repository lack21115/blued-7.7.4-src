package com.sina.weibo.sdk.statistic;

import android.content.Context;
import android.content.SharedPreferences;

class PageLog {
  private static String FILE_SESSION = "session";
  
  private static long MIN_ENDTIME = 1000L;
  
  private long mDuration;
  
  private long mEnd_time;
  
  protected String mPage_id;
  
  protected long mStart_time;
  
  protected LogType mType;
  
  public PageLog(Context paramContext) {
    this.mStart_time = getSessionTime(paramContext, "starttime");
    this.mEnd_time = getSessionTime(paramContext, "endtime");
    this.mDuration = this.mEnd_time - this.mStart_time;
  }
  
  public PageLog(Context paramContext, long paramLong) {
    this.mStart_time = paramLong;
    this.mEnd_time = MIN_ENDTIME;
    updateSession(paramContext, null, Long.valueOf(this.mStart_time), Long.valueOf(this.mEnd_time));
  }
  
  public PageLog(String paramString) {
    this.mPage_id = paramString;
    this.mStart_time = System.currentTimeMillis();
  }
  
  public PageLog(String paramString, long paramLong) {
    this.mPage_id = paramString;
    this.mStart_time = paramLong;
  }
  
  private static long getSessionTime(Context paramContext, String paramString) {
    return paramContext.getSharedPreferences(FILE_SESSION, 0).getLong(paramString, 0L);
  }
  
  public static boolean isNewSession(Context paramContext, long paramLong) {
    long l1 = getSessionTime(paramContext, "endtime");
    long l2 = MIN_ENDTIME;
    return (l1 > l2) ? ((paramLong - l1 > StatisticConfig.kContinueSessionMillis)) : (!(l1 == l2));
  }
  
  public static void updateSession(Context paramContext, String paramString, Long paramLong1, Long paramLong2) {
    SharedPreferences.Editor editor = paramContext.getSharedPreferences(FILE_SESSION, 0).edit();
    if (paramLong1.longValue() != 0L)
      editor.putLong("starttime", paramLong1.longValue()); 
    editor.putLong("endtime", paramLong2.longValue());
    editor.commit();
  }
  
  public long getDuration() {
    return this.mDuration;
  }
  
  public long getEndTime() {
    return this.mEnd_time;
  }
  
  public String getPage_id() {
    return this.mPage_id;
  }
  
  public long getStartTime() {
    return this.mStart_time;
  }
  
  public LogType getType() {
    return this.mType;
  }
  
  public void setDuration(long paramLong) {
    this.mDuration = paramLong;
  }
  
  public void setType(LogType paramLogType) {
    this.mType = paramLogType;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\statistic\PageLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */