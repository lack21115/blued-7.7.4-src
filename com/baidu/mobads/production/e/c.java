package com.baidu.mobads.production.e;

import android.graphics.Color;
import android.view.ViewGroup;

class c implements Runnable {
  c(b paramb) {}
  
  public void run() {
    if (this.a.t())
      b.a(this.a).setBackgroundColor(Color.argb(51, 0, 0, 0)); 
    if (this.a.h.getAdView() != null)
      this.a.h.getAdView().setVisibility(0); 
    if (b.b(this.a)) {
      this.a.z.d("add countdown view");
      b.c(this.a);
      b.f(this.a).addView(b.d(this.a), (ViewGroup.LayoutParams)b.e(this.a));
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */