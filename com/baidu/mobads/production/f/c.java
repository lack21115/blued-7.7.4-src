package com.baidu.mobads.production.f;

import android.view.View;
import android.view.ViewGroup;

class c implements Runnable {
  c(b paramb) {}
  
  public void run() {
    this.a.z.d("remote Interstitial.removeAd");
    b.a(this.a, false);
    try {
      b.a(this.a).removeAllViews();
      ViewGroup viewGroup = b.a(this.a, b.b(this.a).getContext());
      b.c(this.a).removeAllViews();
      viewGroup.removeView((View)b.c(this.a));
      return;
    } catch (Exception exception) {
      this.a.z.d("Interstitial.removeAd", exception);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\f\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */