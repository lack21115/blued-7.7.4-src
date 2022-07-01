package com.google.android.material.transition;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.TransitionValues;

public final class MaterialFade extends MaterialVisibility<FadeProvider> {
  public MaterialFade() {
    super(e(), f());
  }
  
  private static FadeProvider e() {
    FadeProvider fadeProvider = new FadeProvider();
    fadeProvider.a(0.3F);
    return fadeProvider;
  }
  
  private static VisibilityAnimatorProvider f() {
    ScaleProvider scaleProvider = new ScaleProvider();
    scaleProvider.a(false);
    scaleProvider.a(0.8F);
    return scaleProvider;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\transition\MaterialFade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */