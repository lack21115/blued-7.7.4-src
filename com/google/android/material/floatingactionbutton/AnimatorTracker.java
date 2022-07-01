package com.google.android.material.floatingactionbutton;

import android.animation.Animator;

class AnimatorTracker {
  private Animator a;
  
  public void a() {
    Animator animator = this.a;
    if (animator != null)
      animator.cancel(); 
  }
  
  public void a(Animator paramAnimator) {
    a();
    this.a = paramAnimator;
  }
  
  public void b() {
    this.a = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\floatingactionbutton\AnimatorTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */