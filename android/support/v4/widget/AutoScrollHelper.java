package android.support.v4.widget;

import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public abstract class AutoScrollHelper implements View.OnTouchListener {
  private static final int DEFAULT_ACTIVATION_DELAY = ViewConfiguration.getTapTimeout();
  
  private int mActivationDelay;
  
  private boolean mAlreadyDelayed;
  
  boolean mAnimating;
  
  private final Interpolator mEdgeInterpolator = (Interpolator)new AccelerateInterpolator();
  
  private int mEdgeType;
  
  private boolean mEnabled;
  
  private boolean mExclusive;
  
  private float[] mMaximumEdges = new float[] { Float.MAX_VALUE, Float.MAX_VALUE };
  
  private float[] mMaximumVelocity = new float[] { Float.MAX_VALUE, Float.MAX_VALUE };
  
  private float[] mMinimumVelocity = new float[] { 0.0F, 0.0F };
  
  boolean mNeedsCancel;
  
  boolean mNeedsReset;
  
  private float[] mRelativeEdges = new float[] { 0.0F, 0.0F };
  
  private float[] mRelativeVelocity = new float[] { 0.0F, 0.0F };
  
  private Runnable mRunnable;
  
  final AutoScrollHelper$ClampedScroller mScroller = new AutoScrollHelper$ClampedScroller();
  
  final View mTarget;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public AutoScrollHelper(View paramView) {
    this.mTarget = paramView;
    DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
    int i = (int)(displayMetrics.density * 1575.0F + 0.5F);
    int j = (int)(displayMetrics.density * 315.0F + 0.5F);
    float f = i;
    float[] arrayOfFloat = this.mMaximumVelocity;
    f /= 1000.0F;
    arrayOfFloat[0] = f;
    this.mMaximumVelocity[1] = f;
    f = j;
    arrayOfFloat = this.mMinimumVelocity;
    f /= 1000.0F;
    arrayOfFloat[0] = f;
    this.mMinimumVelocity[1] = f;
    this.mEdgeType = 1;
    this.mMaximumEdges[0] = Float.MAX_VALUE;
    this.mMaximumEdges[1] = Float.MAX_VALUE;
    this.mRelativeEdges[0] = 0.2F;
    this.mRelativeEdges[1] = 0.2F;
    this.mRelativeVelocity[0] = 0.001F;
    this.mRelativeVelocity[1] = 0.001F;
    this.mActivationDelay = DEFAULT_ACTIVATION_DELAY;
    this.mScroller.mRampUpDuration = 500;
    this.mScroller.mRampDownDuration = 500;
  }
  
  private float computeTargetVelocity(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3) {
    float f1 = constrain(this.mRelativeEdges[paramInt] * paramFloat2, 0.0F, this.mMaximumEdges[paramInt]);
    float f2 = constrainEdgeValue(paramFloat1, f1);
    paramFloat1 = constrainEdgeValue(paramFloat2 - paramFloat1, f1) - f2;
    if (paramFloat1 < 0.0F) {
      paramFloat1 = -this.mEdgeInterpolator.getInterpolation(-paramFloat1);
    } else if (paramFloat1 > 0.0F) {
      paramFloat1 = this.mEdgeInterpolator.getInterpolation(paramFloat1);
    } else {
      paramFloat1 = 0.0F;
      if (paramFloat1 == 0.0F)
        return 0.0F; 
    } 
    paramFloat1 = constrain(paramFloat1, -1.0F, 1.0F);
    if (paramFloat1 == 0.0F)
      return 0.0F; 
  }
  
  static float constrain(float paramFloat1, float paramFloat2, float paramFloat3) {
    return (paramFloat1 > paramFloat3) ? paramFloat3 : ((paramFloat1 < paramFloat2) ? paramFloat2 : paramFloat1);
  }
  
  private float constrainEdgeValue(float paramFloat1, float paramFloat2) {
    if (paramFloat2 == 0.0F)
      return 0.0F; 
    switch (this.mEdgeType) {
      default:
        return 0.0F;
      case 2:
        return (paramFloat1 < 0.0F) ? (paramFloat1 / -paramFloat2) : 0.0F;
      case 0:
      case 1:
        break;
    } 
    if (paramFloat1 < paramFloat2) {
      if (paramFloat1 >= 0.0F)
        return 1.0F - paramFloat1 / paramFloat2; 
      if (this.mAnimating && this.mEdgeType == 1)
        return 1.0F; 
    } 
    return 0.0F;
  }
  
  private void requestStop() {
    boolean bool = this.mNeedsReset;
    int i = 0;
    if (bool) {
      this.mAnimating = false;
      return;
    } 
    AutoScrollHelper$ClampedScroller autoScrollHelper$ClampedScroller = this.mScroller;
    long l = AnimationUtils.currentAnimationTimeMillis();
    int j = (int)(l - autoScrollHelper$ClampedScroller.mStartTime);
    int k = autoScrollHelper$ClampedScroller.mRampDownDuration;
    if (j > k) {
      i = k;
    } else if (j >= 0) {
      i = j;
    } 
    autoScrollHelper$ClampedScroller.mEffectiveRampDown = i;
    autoScrollHelper$ClampedScroller.mStopValue = autoScrollHelper$ClampedScroller.getValueAt(l);
    autoScrollHelper$ClampedScroller.mStopTime = l;
  }
  
  public abstract boolean canTargetScrollHorizontally$134632();
  
  public abstract boolean canTargetScrollVertically(int paramInt);
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    AutoScrollHelper$ClampedScroller autoScrollHelper$ClampedScroller;
    float f1;
    float f2;
    if (!this.mEnabled)
      return false; 
    switch (paramMotionEvent.getActionMasked()) {
      case 1:
      case 3:
        requestStop();
        break;
      case 0:
        this.mNeedsCancel = true;
        this.mAlreadyDelayed = false;
      case 2:
        f1 = computeTargetVelocity(0, paramMotionEvent.getX(), paramView.getWidth(), this.mTarget.getWidth());
        f2 = computeTargetVelocity(1, paramMotionEvent.getY(), paramView.getHeight(), this.mTarget.getHeight());
        autoScrollHelper$ClampedScroller = this.mScroller;
        autoScrollHelper$ClampedScroller.mTargetVelocityX = f1;
        autoScrollHelper$ClampedScroller.mTargetVelocityY = f2;
        if (!this.mAnimating && shouldAnimate()) {
          if (this.mRunnable == null)
            this.mRunnable = new AutoScrollHelper$ScrollAnimationRunnable(this); 
          this.mAnimating = true;
          this.mNeedsReset = true;
          if (!this.mAlreadyDelayed && this.mActivationDelay > 0) {
            ViewCompat.postOnAnimationDelayed(this.mTarget, this.mRunnable, this.mActivationDelay);
          } else {
            this.mRunnable.run();
          } 
          this.mAlreadyDelayed = true;
        } 
        break;
    } 
    return (this.mExclusive && this.mAnimating);
  }
  
  public abstract void scrollTargetBy$255f295(int paramInt);
  
  public final AutoScrollHelper setEnabled(boolean paramBoolean) {
    if (this.mEnabled && !paramBoolean)
      requestStop(); 
    this.mEnabled = paramBoolean;
    return this;
  }
  
  final boolean shouldAnimate() {
    AutoScrollHelper$ClampedScroller autoScrollHelper$ClampedScroller = this.mScroller;
    int i = (int)(autoScrollHelper$ClampedScroller.mTargetVelocityY / Math.abs(autoScrollHelper$ClampedScroller.mTargetVelocityY));
    int j = (int)(autoScrollHelper$ClampedScroller.mTargetVelocityX / Math.abs(autoScrollHelper$ClampedScroller.mTargetVelocityX));
    return ((i != 0 && canTargetScrollVertically(i)) || (j != 0 && canTargetScrollHorizontally$134632()));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\widget\AutoScrollHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */