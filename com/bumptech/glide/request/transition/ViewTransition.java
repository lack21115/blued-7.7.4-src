package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;

public class ViewTransition<R> implements Transition<R> {
  private final ViewTransitionAnimationFactory a;
  
  ViewTransition(ViewTransitionAnimationFactory paramViewTransitionAnimationFactory) {
    this.a = paramViewTransitionAnimationFactory;
  }
  
  public boolean a(R paramR, Transition.ViewAdapter paramViewAdapter) {
    View view = paramViewAdapter.h();
    if (view != null) {
      view.clearAnimation();
      view.startAnimation(this.a.a(view.getContext()));
    } 
    return false;
  }
  
  static interface ViewTransitionAnimationFactory {
    Animation a(Context param1Context);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\request\transition\ViewTransition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */