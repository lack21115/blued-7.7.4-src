package com.google.android.material.animation;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

public class AnimationUtils {
  public static final TimeInterpolator a = (TimeInterpolator)new LinearInterpolator();
  
  public static final TimeInterpolator b = (TimeInterpolator)new FastOutSlowInInterpolator();
  
  public static final TimeInterpolator c = (TimeInterpolator)new FastOutLinearInInterpolator();
  
  public static final TimeInterpolator d = (TimeInterpolator)new LinearOutSlowInInterpolator();
  
  public static final TimeInterpolator e = (TimeInterpolator)new DecelerateInterpolator();
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3) {
    return paramFloat1 + paramFloat3 * (paramFloat2 - paramFloat1);
  }
  
  public static int a(int paramInt1, int paramInt2, float paramFloat) {
    return paramInt1 + Math.round(paramFloat * (paramInt2 - paramInt1));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\animation\AnimationUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */