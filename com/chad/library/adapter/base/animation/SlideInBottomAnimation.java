package com.chad.library.adapter.base.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

public class SlideInBottomAnimation implements BaseAnimation {
  public Animator[] a(View paramView) {
    return new Animator[] { (Animator)ObjectAnimator.ofFloat(paramView, "translationY", new float[] { paramView.getMeasuredHeight(), 0.0F }) };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\chad\library\adapter\base\animation\SlideInBottomAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */