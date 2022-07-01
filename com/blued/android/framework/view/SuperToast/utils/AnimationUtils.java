package com.blued.android.framework.view.SuperToast.utils;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import com.blued.android.framework.view.SuperToast.SuperActivityToast;

public class AnimationUtils {
  public static Animator a(SuperActivityToast paramSuperActivityToast) {
    PropertyValuesHolder propertyValuesHolder1 = PropertyValuesHolder.ofFloat("alpha", new float[] { 0.0F, 1.0F });
    PropertyValuesHolder propertyValuesHolder2 = PropertyValuesHolder.ofFloat("translationY", new float[] { -250.0F, 0.0F });
    return (Animator)ObjectAnimator.ofPropertyValuesHolder(paramSuperActivityToast.l(), new PropertyValuesHolder[] { propertyValuesHolder2, propertyValuesHolder1 }).setDuration(250L);
  }
  
  public static Animator b(SuperActivityToast paramSuperActivityToast) {
    PropertyValuesHolder propertyValuesHolder1 = PropertyValuesHolder.ofFloat("alpha", new float[] { 1.0F, 0.0F });
    PropertyValuesHolder propertyValuesHolder2 = PropertyValuesHolder.ofFloat("translationY", new float[] { 0.0F, -250.0F });
    return (Animator)ObjectAnimator.ofPropertyValuesHolder(paramSuperActivityToast.l(), new PropertyValuesHolder[] { propertyValuesHolder2, propertyValuesHolder1 }).setDuration(250L);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\SuperToas\\utils\AnimationUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */