package com.bumptech.glide.request.transition;

import android.view.View;

public class ViewPropertyTransition<R> implements Transition<R> {
  private final Animator a;
  
  public ViewPropertyTransition(Animator paramAnimator) {
    this.a = paramAnimator;
  }
  
  public boolean a(R paramR, Transition.ViewAdapter paramViewAdapter) {
    if (paramViewAdapter.h() != null)
      this.a.a(paramViewAdapter.h()); 
    return false;
  }
  
  public static interface Animator {
    void a(View param1View);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\request\transition\ViewPropertyTransition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */