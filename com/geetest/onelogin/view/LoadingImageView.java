package com.geetest.onelogin.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class LoadingImageView extends ImageView {
  private Animation a = null;
  
  private LinearInterpolator b = null;
  
  public LoadingImageView(Context paramContext) {
    super(paramContext);
  }
  
  public LoadingImageView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public LoadingImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void c() {
    try {
      this.a = (Animation)new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
      this.a.setRepeatCount(-1);
      this.a.setDuration(1000L);
      this.b = new LinearInterpolator();
      this.a.setInterpolator((Interpolator)this.b);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public void a() {
    if (this.a == null)
      c(); 
    setVisibility(0);
    startAnimation(this.a);
  }
  
  public void b() {
    setVisibility(8);
    clearAnimation();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\view\LoadingImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */