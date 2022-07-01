package com.heytap.mcssdk.mode;

import android.text.TextUtils;

public class AppMessage extends Message {
  private String a;
  
  private String b;
  
  private long c;
  
  private long d;
  
  private int e;
  
  private String f = "08:00-22:00";
  
  private String g;
  
  private int h = 0;
  
  private int i = 0;
  
  public String a() {
    return this.b;
  }
  
  public void a(int paramInt) {
    this.e = paramInt;
  }
  
  public void a(long paramLong) {
    this.c = paramLong;
  }
  
  public void a(String paramString) {
    this.b = paramString;
  }
  
  public int b() {
    return 4098;
  }
  
  public void b(int paramInt) {
    this.h = paramInt;
  }
  
  public void b(long paramLong) {
    this.d = paramLong;
  }
  
  public void b(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    this.f = paramString;
  }
  
  public void c(int paramInt) {
    this.i = paramInt;
  }
  
  public void c(String paramString) {
    this.a = paramString;
  }
  
  public void d(String paramString) {
    this.g = paramString;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("AppMessage{mTitle='");
    stringBuilder.append(this.a);
    stringBuilder.append('\'');
    stringBuilder.append(", mContent='");
    stringBuilder.append(this.b);
    stringBuilder.append('\'');
    stringBuilder.append(", mStartDate=");
    stringBuilder.append(this.c);
    stringBuilder.append(", mEndDate=");
    stringBuilder.append(this.d);
    stringBuilder.append(", mBalanceTime=");
    stringBuilder.append(this.e);
    stringBuilder.append(", mTimeRanges='");
    stringBuilder.append(this.f);
    stringBuilder.append('\'');
    stringBuilder.append(", mRule='");
    stringBuilder.append(this.g);
    stringBuilder.append('\'');
    stringBuilder.append(", mForcedDelivery=");
    stringBuilder.append(this.h);
    stringBuilder.append(", mDistinctBycontent=");
    stringBuilder.append(this.i);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\heytap\mcssdk\mode\AppMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */