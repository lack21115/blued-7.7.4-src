package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.blued.android.framework.R;

public class FlipLoadingLayout extends LoadingLayout {
  private final Animation a;
  
  private final Animation b;
  
  public FlipLoadingLayout(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.Orientation paramOrientation, TypedArray paramTypedArray) {
    super(paramContext, paramMode, paramOrientation, paramTypedArray);
    char c;
    if (paramMode == PullToRefreshBase.Mode.b) {
      c = 'ｌ';
    } else {
      c = '´';
    } 
    float f = c;
    this.a = (Animation)new RotateAnimation(0.0F, f, 1, 0.5F, 1, 0.5F);
    this.a.setInterpolator(ANIMATION_INTERPOLATOR);
    this.a.setDuration(150L);
    this.a.setFillAfter(true);
    this.b = (Animation)new RotateAnimation(f, 0.0F, 1, 0.5F, 1, 0.5F);
    this.b.setInterpolator(ANIMATION_INTERPOLATOR);
    this.b.setDuration(150L);
    this.b.setFillAfter(true);
  }
  
  private float getDrawableRotationAngle() {
    int i = null.a[this.mMode.ordinal()];
    return (i != 1) ? ((i == 2 && this.mScrollDirection == PullToRefreshBase.Orientation.b) ? 270.0F : 0.0F) : ((this.mScrollDirection == PullToRefreshBase.Orientation.b) ? 90.0F : 180.0F);
  }
  
  protected int getDefaultDrawableResId() {
    return R.drawable.loading_progress;
  }
  
  protected void onLoadingDrawableSet(Drawable paramDrawable) {
    if (paramDrawable != null) {
      int i = paramDrawable.getIntrinsicHeight();
      int j = paramDrawable.getIntrinsicWidth();
      ViewGroup.LayoutParams layoutParams = this.mHeaderImage.getLayoutParams();
      int k = Math.max(i, j);
      layoutParams.height = k;
      layoutParams.width = k;
      this.mHeaderImage.requestLayout();
      this.mHeaderImage.setScaleType(ImageView.ScaleType.MATRIX);
      Matrix matrix = new Matrix();
      matrix.postTranslate((layoutParams.width - j) / 2.0F, (layoutParams.height - i) / 2.0F);
      matrix.postRotate(getDrawableRotationAngle(), layoutParams.width / 2.0F, layoutParams.height / 2.0F);
      this.mHeaderImage.setImageMatrix(matrix);
    } 
  }
  
  protected void onPullImpl(float paramFloat) {}
  
  protected void pullToRefreshImpl() {
    if (this.a == this.mHeaderImage.getAnimation())
      this.mHeaderImage.startAnimation(this.b); 
  }
  
  protected void refreshingImpl() {
    this.mHeaderImage.clearAnimation();
    this.mHeaderImage.setVisibility(4);
    this.mHeaderProgress.setVisibility(0);
  }
  
  protected void releaseToRefreshImpl() {
    this.mHeaderImage.startAnimation(this.a);
  }
  
  protected void resetImpl() {
    this.mHeaderImage.clearAnimation();
    this.mHeaderProgress.setVisibility(8);
    this.mHeaderImage.setVisibility(0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\pulltorefresh\FlipLoadingLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */