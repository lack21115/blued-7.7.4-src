package com.qiniu.pili.droid.shortvideo;

public class PLSpeedTimeRange {
  private long mEndTimeMs;
  
  private double mSpeed;
  
  private long mStartTimeMs;
  
  public PLSpeedTimeRange(double paramDouble, long paramLong1, long paramLong2) {
    this.mStartTimeMs = paramLong1;
    this.mEndTimeMs = paramLong2;
    this.mSpeed = paramDouble;
  }
  
  public long getEndTimeMs() {
    return this.mEndTimeMs;
  }
  
  public long getRangeTimeMs() {
    return this.mEndTimeMs - this.mStartTimeMs;
  }
  
  public double getSpeed() {
    return this.mSpeed;
  }
  
  public long getStartTimeMs() {
    return this.mStartTimeMs;
  }
  
  public boolean isIncludeTimeUs(long paramLong) {
    return (paramLong > this.mStartTimeMs * 1000L && paramLong < this.mEndTimeMs * 1000L);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("speed : ");
    stringBuilder.append(this.mSpeed);
    stringBuilder.append(" time : [");
    stringBuilder.append(this.mStartTimeMs);
    stringBuilder.append("-");
    stringBuilder.append(this.mEndTimeMs);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLSpeedTimeRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */