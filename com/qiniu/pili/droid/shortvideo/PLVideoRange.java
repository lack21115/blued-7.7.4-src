package com.qiniu.pili.droid.shortvideo;

public class PLVideoRange {
  private long mEndTimeMs;
  
  private long mStartTimeMs;
  
  private String mVideoPath;
  
  public PLVideoRange(String paramString) {
    this.mVideoPath = paramString;
  }
  
  public long getEndTime() {
    return this.mEndTimeMs;
  }
  
  public long getRangeTime() {
    return this.mEndTimeMs - this.mStartTimeMs;
  }
  
  public long getStartTime() {
    return this.mStartTimeMs;
  }
  
  public String getVideoPath() {
    return this.mVideoPath;
  }
  
  public boolean isValidRange() {
    long l = this.mStartTimeMs;
    if (l >= 0L) {
      long l1 = this.mEndTimeMs;
      if (l1 > 0L && l1 > l)
        return true; 
    } 
    return false;
  }
  
  public PLVideoRange setEndTime(long paramLong) {
    this.mEndTimeMs = paramLong;
    return this;
  }
  
  public PLVideoRange setStartTime(long paramLong) {
    this.mStartTimeMs = paramLong;
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLVideoRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */