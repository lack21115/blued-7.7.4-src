package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import java.util.Map;

public class TextScale extends Transition {
  private void b(TransitionValues paramTransitionValues) {
    if (paramTransitionValues.view instanceof TextView) {
      TextView textView = (TextView)paramTransitionValues.view;
      paramTransitionValues.values.put("android:textscale:scale", Float.valueOf(textView.getScaleX()));
    } 
  }
  
  public void captureEndValues(TransitionValues paramTransitionValues) {
    b(paramTransitionValues);
  }
  
  public void captureStartValues(TransitionValues paramTransitionValues) {
    b(paramTransitionValues);
  }
  
  public Animator createAnimator(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2) {
    ValueAnimator valueAnimator;
    ViewGroup viewGroup = null;
    paramViewGroup = viewGroup;
    if (paramTransitionValues1 != null) {
      paramViewGroup = viewGroup;
      if (paramTransitionValues2 != null) {
        paramViewGroup = viewGroup;
        if (paramTransitionValues1.view instanceof TextView) {
          float f1;
          if (!(paramTransitionValues2.view instanceof TextView))
            return null; 
          TextView textView = (TextView)paramTransitionValues2.view;
          Map map1 = paramTransitionValues1.values;
          Map map2 = paramTransitionValues2.values;
          paramTransitionValues2 = (TransitionValues)map1.get("android:textscale:scale");
          float f2 = 1.0F;
          if (paramTransitionValues2 != null) {
            f1 = ((Float)map1.get("android:textscale:scale")).floatValue();
          } else {
            f1 = 1.0F;
          } 
          if (map2.get("android:textscale:scale") != null)
            f2 = ((Float)map2.get("android:textscale:scale")).floatValue(); 
          if (f1 == f2)
            return null; 
          valueAnimator = ValueAnimator.ofFloat(new float[] { f1, f2 });
          valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, textView) {
                public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
                  float f = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
                  this.a.setScaleX(f);
                  this.a.setScaleY(f);
                }
              });
        } 
      } 
    } 
    return (Animator)valueAnimator;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\internal\TextScale.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */