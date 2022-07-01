package com.bumptech.glide;

import com.bumptech.glide.request.transition.NoTransition;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.Preconditions;

public abstract class TransitionOptions<CHILD extends TransitionOptions<CHILD, TranscodeType>, TranscodeType> implements Cloneable {
  private TransitionFactory<? super TranscodeType> a = NoTransition.a();
  
  private CHILD c() {
    return (CHILD)this;
  }
  
  public final CHILD a() {
    try {
      return (CHILD)super.clone();
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      throw new RuntimeException(cloneNotSupportedException);
    } 
  }
  
  public final CHILD a(TransitionFactory<? super TranscodeType> paramTransitionFactory) {
    this.a = (TransitionFactory<? super TranscodeType>)Preconditions.a(paramTransitionFactory);
    return c();
  }
  
  final TransitionFactory<? super TranscodeType> b() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\TransitionOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */