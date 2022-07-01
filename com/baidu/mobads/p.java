package com.baidu.mobads;

import android.view.KeyEvent;
import com.baidu.mobads.component.XAdView;

class p implements XAdView.Listener {
  p(InterstitialAd paramInterstitialAd) {}
  
  public void onAttachedToWindow() {}
  
  public void onDetachedFromWindow() {}
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    return InterstitialAd.b(this.a).a(paramInt, paramKeyEvent);
  }
  
  public void onLayoutComplete(int paramInt1, int paramInt2) {}
  
  public void onWindowFocusChanged(boolean paramBoolean) {}
  
  public void onWindowVisibilityChanged(int paramInt) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */