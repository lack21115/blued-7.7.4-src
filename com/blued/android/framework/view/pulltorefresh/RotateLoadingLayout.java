package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.blued.android.framework.R;

public class RotateLoadingLayout extends LoadingLayout {
  private final Animation a;
  
  private final Matrix b;
  
  private float c;
  
  private float d;
  
  private final boolean e;
  
  public RotateLoadingLayout(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.Orientation paramOrientation, TypedArray paramTypedArray) {
    super(paramContext, paramMode, paramOrientation, paramTypedArray);
    this.e = paramTypedArray.getBoolean(R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling, true);
    this.mHeaderImage.setScaleType(ImageView.ScaleType.MATRIX);
    this.b = new Matrix();
    this.mHeaderImage.setImageMatrix(this.b);
    this.a = (Animation)new RotateAnimation(0.0F, 720.0F, 1, 0.5F, 1, 0.5F);
    this.a.setInterpolator(ANIMATION_INTERPOLATOR);
    if (this.isHeaderStyleEnabled) {
      this.a.setDuration(30L);
    } else {
      this.a.setDuration(1000L);
    } 
    this.a.setRepeatCount(-1);
    this.a.setRepeatMode(1);
  }
  
  private void a() {
    Matrix matrix = this.b;
    if (matrix != null) {
      matrix.reset();
      this.mHeaderImage.setImageMatrix(this.b);
    } 
  }
  
  protected int getDefaultDrawableResId() {
    return this.isHeaderStyleEnabled ? R.drawable.pullrefresh_animation_list : R.drawable.loading_progress;
  }
  
  public void onLoadingDrawableSet(Drawable paramDrawable) {
    if (paramDrawable != null) {
      this.c = Math.round(paramDrawable.getIntrinsicWidth() / 2.0F);
      this.d = Math.round(paramDrawable.getIntrinsicHeight() / 2.0F);
    } 
  }
  
  protected void onPullImpl(float paramFloat) {
    if (this.e) {
      paramFloat *= 90.0F;
    } else {
      paramFloat = Math.max(0.0F, Math.min(180.0F, paramFloat * 360.0F - 180.0F));
    } 
    this.b.setRotate(paramFloat, this.c, this.d);
    this.mHeaderImage.setImageMatrix(this.b);
  }
  
  protected void pullToRefreshImpl() {}
  
  protected void refreshingImpl() {
    this.mHeaderImage.startAnimation(this.a);
  }
  
  protected void releaseToRefreshImpl() {}
  
  protected void resetImpl() {
    this.mHeaderImage.clearAnimation();
    a();
  }
  
  public void setHeaderBgImage() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\pulltorefresh\RotateLoadingLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */