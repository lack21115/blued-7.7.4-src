package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;

public class ViewPropertyAnimationFactory<R> implements TransitionFactory<R> {
  private final ViewPropertyTransition.Animator a;
  
  private ViewPropertyTransition<R> b;
  
  public Transition<R> a(DataSource paramDataSource, boolean paramBoolean) {
    if (paramDataSource == DataSource.e || !paramBoolean)
      return NoTransition.b(); 
    if (this.b == null)
      this.b = new ViewPropertyTransition<R>(this.a); 
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\request\transition\ViewPropertyAnimationFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */