package com.baidu.mobads.production.e;

import android.view.View;
import android.view.ViewGroup;

class d implements Runnable {
  d(b paramb) {}
  
  public void run() {
    this.a.z.d("remote Interstitial.removeAd");
    try {
      if (b.g(this.a).getParent() != null)
        ((ViewGroup)b.i(this.a).getParent()).removeView((View)b.h(this.a)); 
      b.j(this.a).removeAllViews();
      return;
    } catch (Exception exception) {
      this.a.z.d("Interstitial.removeAd", exception);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\e\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */