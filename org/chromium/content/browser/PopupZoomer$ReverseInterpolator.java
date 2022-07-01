package org.chromium.content.browser;

import android.view.animation.Interpolator;

final class PopupZoomer$ReverseInterpolator implements Interpolator {
  private final Interpolator mInterpolator;
  
  public PopupZoomer$ReverseInterpolator(Interpolator paramInterpolator) {
    this.mInterpolator = paramInterpolator;
  }
  
  public final float getInterpolation(float paramFloat) {
    paramFloat = 1.0F - paramFloat;
    return (this.mInterpolator == null) ? paramFloat : this.mInterpolator.getInterpolation(paramFloat);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\PopupZoomer$ReverseInterpolator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */