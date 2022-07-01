package com.baidu.mobads;

import android.view.KeyEvent;
import com.baidu.mobads.component.XAdView;

class c implements XAdView.Listener {
  c(AdView paramAdView) {}
  
  public void onAttachedToWindow() {
    AdView.c(this.a);
    AdView.b(this.a).p();
  }
  
  public void onDetachedFromWindow() {
    AdView.b(this.a).q();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    return AdView.b(this.a).a(paramInt, paramKeyEvent);
  }
  
  public void onLayoutComplete(int paramInt1, int paramInt2) {
    AdView.c(this.a);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    AdView.b(this.a).a(paramBoolean);
  }
  
  public void onWindowVisibilityChanged(int paramInt) {
    AdView.b(this.a).b(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */