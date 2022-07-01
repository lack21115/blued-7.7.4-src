package com.qiniu.pili.droid.shortvideo.a.a;

import com.qiniu.pili.droid.shortvideo.f.e;

public final class d {
  private int a = 30;
  
  private float b = -1.0F;
  
  private float c = 0.0F;
  
  private long d = 0L;
  
  private long e = 0L;
  
  public void a(int paramInt) {
    this.a = paramInt;
    e e = e.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("set desire fps:");
    stringBuilder.append(this.a);
    e.c("FPSController", stringBuilder.toString());
  }
  
  public boolean a() {
    this.d++;
    long l1 = System.currentTimeMillis();
    long l2 = this.d;
    if (l2 != 0L) {
      long l = this.e;
      if (l1 - l > 1000L) {
        int i = Math.round((float)(l2 * 1000L / (l1 - l)));
        this.e = l1;
        this.d = 0L;
        int j = this.a;
        if (i <= j) {
          this.b = -1.0F;
        } else {
          this.b = i / (i - j);
        } 
        e e = e.f;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("average fps = ");
        stringBuilder.append(i);
        stringBuilder.append(", delta fps = ");
        stringBuilder.append(this.b);
        e.b("FPSController", stringBuilder.toString());
      } 
    } 
    float f1 = this.b;
    if (f1 < 0.0F)
      return false; 
    float f2 = ++this.c;
    if (f2 >= f1) {
      this.c = f2 - f1;
      return true;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\a\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */