package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

public final class StateListAnimator {
  ValueAnimator a = null;
  
  private final ArrayList<Tuple> b = new ArrayList<Tuple>();
  
  private Tuple c = null;
  
  private final Animator.AnimatorListener d = (Animator.AnimatorListener)new AnimatorListenerAdapter(this) {
      public void onAnimationEnd(Animator param1Animator) {
        if (this.a.a == param1Animator)
          this.a.a = null; 
      }
    };
  
  private void a(Tuple paramTuple) {
    this.a = paramTuple.b;
    this.a.start();
  }
  
  private void b() {
    ValueAnimator valueAnimator = this.a;
    if (valueAnimator != null) {
      valueAnimator.cancel();
      this.a = null;
    } 
  }
  
  public void a() {
    ValueAnimator valueAnimator = this.a;
    if (valueAnimator != null) {
      valueAnimator.end();
      this.a = null;
    } 
  }
  
  public void a(int[] paramArrayOfint) {
    int j = this.b.size();
    int i = 0;
    while (true) {
      if (i < j) {
        Tuple tuple1 = this.b.get(i);
        if (StateSet.stateSetMatches(tuple1.a, paramArrayOfint)) {
          Tuple tuple2 = tuple1;
          break;
        } 
        i++;
        continue;
      } 
      paramArrayOfint = null;
      break;
    } 
    Tuple tuple = this.c;
    if (paramArrayOfint == tuple)
      return; 
    if (tuple != null)
      b(); 
    this.c = (Tuple)paramArrayOfint;
    if (paramArrayOfint != null)
      a((Tuple)paramArrayOfint); 
  }
  
  public void a(int[] paramArrayOfint, ValueAnimator paramValueAnimator) {
    Tuple tuple = new Tuple(paramArrayOfint, paramValueAnimator);
    paramValueAnimator.addListener(this.d);
    this.b.add(tuple);
  }
  
  static class Tuple {
    final int[] a;
    
    final ValueAnimator b;
    
    Tuple(int[] param1ArrayOfint, ValueAnimator param1ValueAnimator) {
      this.a = param1ArrayOfint;
      this.b = param1ValueAnimator;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\internal\StateListAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */