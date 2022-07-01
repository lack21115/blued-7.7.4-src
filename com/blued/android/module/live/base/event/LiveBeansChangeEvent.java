package com.blued.android.module.live.base.event;

public class LiveBeansChangeEvent {
  public long currentScore;
  
  public String roomId;
  
  public long totalScore;
  
  public LiveBeansChangeEvent(String paramString, long paramLong1, long paramLong2) {
    this.roomId = paramString;
    this.currentScore = paramLong1;
    this.totalScore = paramLong2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\base\event\LiveBeansChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */