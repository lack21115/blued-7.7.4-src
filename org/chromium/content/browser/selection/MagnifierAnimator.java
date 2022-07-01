package org.chromium.content.browser.selection;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;

public final class MagnifierAnimator implements SelectionInsertionHandleObserver {
  float mAnimationCurrentX;
  
  float mAnimationCurrentY;
  
  float mAnimationStartX;
  
  float mAnimationStartY;
  
  private ValueAnimator mAnimator;
  
  MagnifierWrapper mMagnifier;
  
  private boolean mMagnifierIsShowing;
  
  float mTargetX;
  
  float mTargetY;
  
  public MagnifierAnimator(MagnifierWrapper paramMagnifierWrapper) {
    this.mMagnifier = paramMagnifierWrapper;
    createValueAnimator();
    this.mTargetX = -1.0F;
    this.mTargetY = -1.0F;
  }
  
  private void createValueAnimator() {
    this.mAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.mAnimator.setDuration(100L);
    this.mAnimator.setInterpolator((TimeInterpolator)new LinearInterpolator());
    this.mAnimator.addUpdateListener(new MagnifierAnimator$$Lambda$0(this));
  }
  
  static float currentValue(float paramFloat1, float paramFloat2, ValueAnimator paramValueAnimator) {
    return paramFloat1 + (paramFloat2 - paramFloat1) * paramValueAnimator.getAnimatedFraction();
  }
  
  public final void handleDragStartedOrMoved(float paramFloat1, float paramFloat2) {
    if (!this.mMagnifier.isAvailable())
      return; 
    if (this.mMagnifierIsShowing && paramFloat2 != this.mTargetY) {
      if (this.mAnimator.isRunning()) {
        this.mAnimator.cancel();
        createValueAnimator();
        this.mAnimationStartX = this.mAnimationCurrentX;
        this.mAnimationStartY = this.mAnimationCurrentY;
      } else {
        this.mAnimationStartX = this.mTargetX;
        this.mAnimationStartY = this.mTargetY;
      } 
      this.mAnimator.start();
    } else if (!this.mAnimator.isRunning()) {
      this.mMagnifier.show(paramFloat1, paramFloat2);
    } 
    this.mTargetX = paramFloat1;
    this.mTargetY = paramFloat2;
    this.mMagnifierIsShowing = true;
  }
  
  public final void handleDragStopped() {
    this.mMagnifier.dismiss();
    this.mAnimator.cancel();
    this.mMagnifierIsShowing = false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\selection\MagnifierAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */