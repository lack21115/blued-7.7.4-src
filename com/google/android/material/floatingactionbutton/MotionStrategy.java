package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import com.google.android.material.animation.MotionSpec;
import java.util.List;

interface MotionStrategy {
  void a(Animator paramAnimator);
  
  void a(MotionSpec paramMotionSpec);
  
  void a(ExtendedFloatingActionButton.OnChangedCallback paramOnChangedCallback);
  
  List<Animator.AnimatorListener> b();
  
  MotionSpec c();
  
  void d();
  
  void e();
  
  AnimatorSet f();
  
  void g();
  
  int h();
  
  boolean i();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\floatingactionbutton\MotionStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */