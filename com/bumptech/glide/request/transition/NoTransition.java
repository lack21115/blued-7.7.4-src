package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;

public class NoTransition<R> implements Transition<R> {
  static final NoTransition<?> a = new NoTransition();
  
  private static final TransitionFactory<?> b = new NoAnimationFactory();
  
  public static <R> TransitionFactory<R> a() {
    return (TransitionFactory)b;
  }
  
  public static <R> Transition<R> b() {
    return (Transition)a;
  }
  
  public boolean a(Object paramObject, Transition.ViewAdapter paramViewAdapter) {
    return false;
  }
  
  public static class NoAnimationFactory<R> implements TransitionFactory<R> {
    public Transition<R> a(DataSource param1DataSource, boolean param1Boolean) {
      return (Transition)NoTransition.a;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\request\transition\NoTransition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */