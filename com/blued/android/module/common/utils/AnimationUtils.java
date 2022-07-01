package com.blued.android.module.common.utils;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;

public class AnimationUtils {
  public static AnimationSet a(View paramView, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {
    if (paramView != null) {
      AnimationSet animationSet = new AnimationSet(true);
      AlphaAnimation alphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      alphaAnimation.setRepeatCount(paramInt1);
      ScaleAnimation scaleAnimation = new ScaleAnimation(1.0F, paramFloat1, 1.0F, paramFloat2, 1, 0.5F, 1, 0.5F);
      scaleAnimation.setRepeatCount(paramInt1);
      animationSet.addAnimation((Animation)alphaAnimation);
      animationSet.addAnimation((Animation)scaleAnimation);
      animationSet.setDuration(paramInt2);
      animationSet.setFillAfter(false);
      animationSet.setRepeatCount(paramInt1);
      return animationSet;
    } 
    return null;
  }
  
  public static void a(View paramView) {
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.1F, 1.0F);
    alphaAnimation.setDuration(600L);
    paramView.startAnimation((Animation)alphaAnimation);
  }
  
  public static void a(View paramView, long paramLong) {
    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    alphaAnimation.setDuration(paramLong);
    alphaAnimation.setAnimationListener(new Animation.AnimationListener(paramView) {
          public void onAnimationEnd(Animation param1Animation) {
            this.a.setVisibility(8);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    paramView.startAnimation((Animation)alphaAnimation);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\commo\\utils\AnimationUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */