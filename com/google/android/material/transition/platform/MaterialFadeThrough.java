package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;

public final class MaterialFadeThrough extends MaterialVisibility<FadeThroughProvider> {
  public MaterialFadeThrough() {
    super(a(), b());
  }
  
  private static FadeThroughProvider a() {
    return new FadeThroughProvider();
  }
  
  private static VisibilityAnimatorProvider b() {
    ScaleProvider scaleProvider = new ScaleProvider();
    scaleProvider.a(false);
    scaleProvider.a(0.92F);
    return scaleProvider;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\transition\platform\MaterialFadeThrough.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */