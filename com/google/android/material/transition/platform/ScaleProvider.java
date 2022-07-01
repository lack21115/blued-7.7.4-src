package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.ViewGroup;

public final class ScaleProvider implements VisibilityAnimatorProvider {
  private float a = 1.0F;
  
  private float b = 1.1F;
  
  private float c = 0.8F;
  
  private float d = 1.0F;
  
  private boolean e;
  
  private boolean f = true;
  
  public ScaleProvider() {
    this(true);
  }
  
  public ScaleProvider(boolean paramBoolean) {
    this.e = paramBoolean;
  }
  
  private static Animator a(View paramView, float paramFloat1, float paramFloat2) {
    return (Animator)ObjectAnimator.ofPropertyValuesHolder(paramView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(View.SCALE_X, new float[] { paramFloat1, paramFloat2 }), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[] { paramFloat1, paramFloat2 }) });
  }
  
  public Animator a(ViewGroup paramViewGroup, View paramView) {
    return this.e ? a(paramView, this.c, this.d) : a(paramView, this.b, this.a);
  }
  
  public void a(float paramFloat) {
    this.c = paramFloat;
  }
  
  public void a(boolean paramBoolean) {
    this.f = paramBoolean;
  }
  
  public Animator b(ViewGroup paramViewGroup, View paramView) {
    return !this.f ? null : (this.e ? a(paramView, this.a, this.b) : a(paramView, this.d, this.c));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\transition\platform\ScaleProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */