package com.qiniu.pili.droid.shortvideo.transcoder.audio;

public class d {
  private long a;
  
  private long b;
  
  public d(long paramLong1, long paramLong2) {
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  public long a() {
    return this.a;
  }
  
  public long b() {
    return this.b;
  }
  
  public long c() {
    return this.b - this.a;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");
    stringBuilder.append(this.a);
    stringBuilder.append("-");
    stringBuilder.append(this.b);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\transcoder\audio\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */