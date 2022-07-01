package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bumptech.glide.load.DataSource;

public class ViewAnimationFactory<R> implements TransitionFactory<R> {
  private final ViewTransition.ViewTransitionAnimationFactory a;
  
  private Transition<R> b;
  
  public Transition<R> a(DataSource paramDataSource, boolean paramBoolean) {
    if (paramDataSource == DataSource.e || !paramBoolean)
      return NoTransition.b(); 
    if (this.b == null)
      this.b = new ViewTransition<R>(this.a); 
    return this.b;
  }
  
  static class ConcreteViewTransitionAnimationFactory implements ViewTransition.ViewTransitionAnimationFactory {
    private final Animation a;
    
    public Animation a(Context param1Context) {
      return this.a;
    }
  }
  
  static class ResourceViewTransitionAnimationFactory implements ViewTransition.ViewTransitionAnimationFactory {
    private final int a;
    
    public Animation a(Context param1Context) {
      return AnimationUtils.loadAnimation(param1Context, this.a);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\request\transition\ViewAnimationFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */