package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.TransitionValues;
import androidx.transition.Visibility;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import java.util.ArrayList;

abstract class MaterialVisibility<P extends VisibilityAnimatorProvider> extends Visibility {
  private final P a;
  
  private VisibilityAnimatorProvider i;
  
  protected MaterialVisibility(P paramP, VisibilityAnimatorProvider paramVisibilityAnimatorProvider) {
    this.a = paramP;
    this.i = paramVisibilityAnimatorProvider;
    setInterpolator(AnimationUtils.b);
  }
  
  private Animator a(ViewGroup paramViewGroup, View paramView, boolean paramBoolean) {
    Animator animator;
    AnimatorSet animatorSet = new AnimatorSet();
    ArrayList<Animator> arrayList = new ArrayList();
    if (paramBoolean) {
      animator = this.a.a(paramViewGroup, paramView);
    } else {
      animator = this.a.b(paramViewGroup, paramView);
    } 
    if (animator != null)
      arrayList.add(animator); 
    VisibilityAnimatorProvider visibilityAnimatorProvider = this.i;
    if (visibilityAnimatorProvider != null) {
      Animator animator1;
      if (paramBoolean) {
        animator1 = visibilityAnimatorProvider.a(paramViewGroup, paramView);
      } else {
        animator1 = visibilityAnimatorProvider.b((ViewGroup)animator1, paramView);
      } 
      if (animator1 != null)
        arrayList.add(animator1); 
    } 
    AnimatorSetCompat.a(animatorSet, arrayList);
    return (Animator)animatorSet;
  }
  
  public Animator onAppear(ViewGroup paramViewGroup, View paramView, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2) {
    return a(paramViewGroup, paramView, true);
  }
  
  public Animator onDisappear(ViewGroup paramViewGroup, View paramView, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2) {
    return a(paramViewGroup, paramView, false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\transition\MaterialVisibility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */