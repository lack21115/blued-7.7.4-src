package com.baidu.mobads.openad.e;

import java.util.TimerTask;

class b extends TimerTask {
  b(a parama) {}
  
  public void run() {
    if (a.a(this.a).get() != 0)
      return; 
    if (a.b(this.a) != null) {
      a a1 = this.a;
      a.a(a1, a.c(a1) - a.d(this.a));
      a.b(this.a).onTimer(a.e(this.a));
    } 
    if (a.d(this.a) > 0) {
      a.f(this.a);
      return;
    } 
    this.a.stop();
    if (a.b(this.a) != null)
      a.b(this.a).onTimerComplete(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\openad\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */