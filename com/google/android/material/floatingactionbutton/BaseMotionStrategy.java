package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import androidx.core.util.Preconditions;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionSpec;
import java.util.ArrayList;
import java.util.List;

abstract class BaseMotionStrategy implements MotionStrategy {
  private final Context a;
  
  private final ExtendedFloatingActionButton b;
  
  private final ArrayList<Animator.AnimatorListener> c = new ArrayList<Animator.AnimatorListener>();
  
  private final AnimatorTracker d;
  
  private MotionSpec e;
  
  private MotionSpec f;
  
  BaseMotionStrategy(ExtendedFloatingActionButton paramExtendedFloatingActionButton, AnimatorTracker paramAnimatorTracker) {
    this.b = paramExtendedFloatingActionButton;
    this.a = paramExtendedFloatingActionButton.getContext();
    this.d = paramAnimatorTracker;
  }
  
  public final MotionSpec a() {
    MotionSpec motionSpec = this.f;
    if (motionSpec != null)
      return motionSpec; 
    if (this.e == null)
      this.e = MotionSpec.a(this.a, h()); 
    return (MotionSpec)Preconditions.checkNotNull(this.e);
  }
  
  public void a(Animator paramAnimator) {
    this.d.a(paramAnimator);
  }
  
  public final void a(MotionSpec paramMotionSpec) {
    this.f = paramMotionSpec;
  }
  
  AnimatorSet b(MotionSpec paramMotionSpec) {
    ArrayList<ObjectAnimator> arrayList = new ArrayList();
    if (paramMotionSpec.c("opacity"))
      arrayList.add(paramMotionSpec.a("opacity", this.b, View.ALPHA)); 
    if (paramMotionSpec.c("scale")) {
      arrayList.add(paramMotionSpec.a("scale", this.b, View.SCALE_Y));
      arrayList.add(paramMotionSpec.a("scale", this.b, View.SCALE_X));
    } 
    if (paramMotionSpec.c("width"))
      arrayList.add(paramMotionSpec.a("width", this.b, ExtendedFloatingActionButton.a)); 
    if (paramMotionSpec.c("height"))
      arrayList.add(paramMotionSpec.a("height", this.b, ExtendedFloatingActionButton.b)); 
    AnimatorSet animatorSet = new AnimatorSet();
    AnimatorSetCompat.a(animatorSet, arrayList);
    return animatorSet;
  }
  
  public final List<Animator.AnimatorListener> b() {
    return this.c;
  }
  
  public MotionSpec c() {
    return this.f;
  }
  
  public void d() {
    this.d.b();
  }
  
  public void e() {
    this.d.b();
  }
  
  public AnimatorSet f() {
    return b(a());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\floatingactionbutton\BaseMotionStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */