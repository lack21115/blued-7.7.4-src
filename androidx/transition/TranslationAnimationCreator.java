package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;

class TranslationAnimationCreator {
  static Animator a(View paramView, TransitionValues paramTransitionValues, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, TimeInterpolator paramTimeInterpolator, Transition paramTransition) {
    float f1 = paramView.getTranslationX();
    float f2 = paramView.getTranslationY();
    int[] arrayOfInt = (int[])paramTransitionValues.view.getTag(R.id.transition_position);
    if (arrayOfInt != null) {
      paramFloat1 = (arrayOfInt[0] - paramInt1) + f1;
      paramFloat2 = (arrayOfInt[1] - paramInt2) + f2;
    } 
    int i = Math.round(paramFloat1 - f1);
    int j = Math.round(paramFloat2 - f2);
    paramView.setTranslationX(paramFloat1);
    paramView.setTranslationY(paramFloat2);
    if (paramFloat1 == paramFloat3 && paramFloat2 == paramFloat4)
      return null; 
    ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(paramView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[] { paramFloat1, paramFloat3 }), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[] { paramFloat2, paramFloat4 }) });
    TransitionPositionListener transitionPositionListener = new TransitionPositionListener(paramView, paramTransitionValues.view, paramInt1 + i, paramInt2 + j, f1, f2);
    paramTransition.addListener(transitionPositionListener);
    objectAnimator.addListener((Animator.AnimatorListener)transitionPositionListener);
    AnimatorUtils.a((Animator)objectAnimator, transitionPositionListener);
    objectAnimator.setInterpolator(paramTimeInterpolator);
    return (Animator)objectAnimator;
  }
  
  static class TransitionPositionListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
    private final View a;
    
    private final View b;
    
    private final int c;
    
    private final int d;
    
    private int[] e;
    
    private float f;
    
    private float g;
    
    private final float h;
    
    private final float i;
    
    TransitionPositionListener(View param1View1, View param1View2, int param1Int1, int param1Int2, float param1Float1, float param1Float2) {
      this.b = param1View1;
      this.a = param1View2;
      this.c = param1Int1 - Math.round(this.b.getTranslationX());
      this.d = param1Int2 - Math.round(this.b.getTranslationY());
      this.h = param1Float1;
      this.i = param1Float2;
      this.e = (int[])this.a.getTag(R.id.transition_position);
      if (this.e != null)
        this.a.setTag(R.id.transition_position, null); 
    }
    
    public void onAnimationCancel(Animator param1Animator) {
      if (this.e == null)
        this.e = new int[2]; 
      this.e[0] = Math.round(this.c + this.b.getTranslationX());
      this.e[1] = Math.round(this.d + this.b.getTranslationY());
      this.a.setTag(R.id.transition_position, this.e);
    }
    
    public void onAnimationPause(Animator param1Animator) {
      this.f = this.b.getTranslationX();
      this.g = this.b.getTranslationY();
      this.b.setTranslationX(this.h);
      this.b.setTranslationY(this.i);
    }
    
    public void onAnimationResume(Animator param1Animator) {
      this.b.setTranslationX(this.f);
      this.b.setTranslationY(this.g);
    }
    
    public void onTransitionCancel(Transition param1Transition) {}
    
    public void onTransitionEnd(Transition param1Transition) {
      this.b.setTranslationX(this.h);
      this.b.setTranslationY(this.i);
      param1Transition.removeListener(this);
    }
    
    public void onTransitionPause(Transition param1Transition) {}
    
    public void onTransitionResume(Transition param1Transition) {}
    
    public void onTransitionStart(Transition param1Transition) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\TranslationAnimationCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */