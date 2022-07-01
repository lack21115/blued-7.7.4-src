package android.support.v4.widget;

import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;

final class AutoScrollHelper$ScrollAnimationRunnable implements Runnable {
  public final void run() {
    int i;
    if (!AutoScrollHelper.this.mAnimating)
      return; 
    if (AutoScrollHelper.this.mNeedsReset) {
      AutoScrollHelper.this.mNeedsReset = false;
      AutoScrollHelper$ClampedScroller autoScrollHelper$ClampedScroller1 = AutoScrollHelper.this.mScroller;
      autoScrollHelper$ClampedScroller1.mStartTime = AnimationUtils.currentAnimationTimeMillis();
      autoScrollHelper$ClampedScroller1.mStopTime = -1L;
      autoScrollHelper$ClampedScroller1.mDeltaTime = autoScrollHelper$ClampedScroller1.mStartTime;
      autoScrollHelper$ClampedScroller1.mStopValue = 0.5F;
      autoScrollHelper$ClampedScroller1.mDeltaY = 0;
    } 
    AutoScrollHelper$ClampedScroller autoScrollHelper$ClampedScroller = AutoScrollHelper.this.mScroller;
    if (autoScrollHelper$ClampedScroller.mStopTime > 0L && AnimationUtils.currentAnimationTimeMillis() > autoScrollHelper$ClampedScroller.mStopTime + autoScrollHelper$ClampedScroller.mEffectiveRampDown) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i || !AutoScrollHelper.this.shouldAnimate()) {
      AutoScrollHelper.this.mAnimating = false;
      return;
    } 
    if (AutoScrollHelper.this.mNeedsCancel) {
      AutoScrollHelper.this.mNeedsCancel = false;
      AutoScrollHelper autoScrollHelper = AutoScrollHelper.this;
      long l = SystemClock.uptimeMillis();
      MotionEvent motionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      autoScrollHelper.mTarget.onTouchEvent(motionEvent);
      motionEvent.recycle();
    } 
    if (autoScrollHelper$ClampedScroller.mDeltaTime != 0L) {
      long l1 = AnimationUtils.currentAnimationTimeMillis();
      float f = autoScrollHelper$ClampedScroller.getValueAt(l1);
      long l2 = autoScrollHelper$ClampedScroller.mDeltaTime;
      autoScrollHelper$ClampedScroller.mDeltaTime = l1;
      autoScrollHelper$ClampedScroller.mDeltaY = (int)((float)(l1 - l2) * (-4.0F * f * f + f * 4.0F) * autoScrollHelper$ClampedScroller.mTargetVelocityY);
      i = autoScrollHelper$ClampedScroller.mDeltaY;
      AutoScrollHelper.this.scrollTargetBy$255f295(i);
      ViewCompat.postOnAnimation(AutoScrollHelper.this.mTarget, this);
      return;
    } 
    throw new RuntimeException("Cannot compute scroll delta before calling start()");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\widget\AutoScrollHelper$ScrollAnimationRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */