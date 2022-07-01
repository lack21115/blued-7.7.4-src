package com.baidu.mobads.production.e;

import android.os.CountDownTimer;

class e extends CountDownTimer {
  e(b paramb, long paramLong1, long paramLong2) {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish() {
    this.a.z.d("CountDownTimer finished");
    this.a.v();
    this.a.h.stop();
  }
  
  public void onTick(long paramLong) {
    int i = (int)(paramLong / 1000L);
    byte b1 = 5;
    if (i > 5)
      i = b1; 
    b.k(this.a).setText(String.valueOf(i));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\e\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */