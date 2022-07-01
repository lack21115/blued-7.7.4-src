package org.chromium.android_webview;

import android.content.Context;
import android.view.View;
import android.widget.EdgeEffect;

final class OverScrollGlow {
  EdgeEffect mEdgeGlowBottom;
  
  EdgeEffect mEdgeGlowLeft;
  
  EdgeEffect mEdgeGlowRight;
  
  EdgeEffect mEdgeGlowTop;
  
  View mHostView;
  
  int mOverScrollDeltaX;
  
  int mOverScrollDeltaY;
  
  boolean mShouldPull;
  
  public OverScrollGlow(Context paramContext, View paramView) {
    this.mHostView = paramView;
    this.mEdgeGlowTop = new EdgeEffect(paramContext);
    this.mEdgeGlowBottom = new EdgeEffect(paramContext);
    this.mEdgeGlowLeft = new EdgeEffect(paramContext);
    this.mEdgeGlowRight = new EdgeEffect(paramContext);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\OverScrollGlow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */