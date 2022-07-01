package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;

public class ChangeClipBounds extends Transition {
  private static final String[] a = new String[] { "android:clipBounds:clip" };
  
  public ChangeClipBounds() {}
  
  public ChangeClipBounds(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  private void b(TransitionValues paramTransitionValues) {
    View view = paramTransitionValues.view;
    if (view.getVisibility() == 8)
      return; 
    Rect rect = ViewCompat.getClipBounds(view);
    paramTransitionValues.values.put("android:clipBounds:clip", rect);
    if (rect == null) {
      Rect rect1 = new Rect(0, 0, view.getWidth(), view.getHeight());
      paramTransitionValues.values.put("android:clipBounds:bounds", rect1);
    } 
  }
  
  public void captureEndValues(TransitionValues paramTransitionValues) {
    b(paramTransitionValues);
  }
  
  public void captureStartValues(TransitionValues paramTransitionValues) {
    b(paramTransitionValues);
  }
  
  public Animator createAnimator(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2) {
    ObjectAnimator objectAnimator;
    ViewGroup viewGroup = null;
    paramViewGroup = viewGroup;
    if (paramTransitionValues1 != null) {
      paramViewGroup = viewGroup;
      if (paramTransitionValues2 != null) {
        paramViewGroup = viewGroup;
        if (paramTransitionValues1.values.containsKey("android:clipBounds:clip")) {
          Rect rect1;
          Rect rect2;
          boolean bool;
          if (!paramTransitionValues2.values.containsKey("android:clipBounds:clip"))
            return null; 
          Rect rect3 = (Rect)paramTransitionValues1.values.get("android:clipBounds:clip");
          Rect rect4 = (Rect)paramTransitionValues2.values.get("android:clipBounds:clip");
          if (rect4 == null) {
            bool = true;
          } else {
            bool = false;
          } 
          if (rect3 == null && rect4 == null)
            return null; 
          if (rect3 == null) {
            rect1 = (Rect)paramTransitionValues1.values.get("android:clipBounds:bounds");
            rect2 = rect4;
          } else {
            rect1 = rect3;
            rect2 = rect4;
            if (rect4 == null) {
              rect2 = (Rect)paramTransitionValues2.values.get("android:clipBounds:bounds");
              rect1 = rect3;
            } 
          } 
          if (rect1.equals(rect2))
            return null; 
          ViewCompat.setClipBounds(paramTransitionValues2.view, rect1);
          RectEvaluator rectEvaluator = new RectEvaluator(new Rect());
          ObjectAnimator objectAnimator1 = ObjectAnimator.ofObject(paramTransitionValues2.view, ViewUtils.b, rectEvaluator, (Object[])new Rect[] { rect1, rect2 });
          objectAnimator = objectAnimator1;
          if (bool) {
            objectAnimator1.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this, paramTransitionValues2.view) {
                  public void onAnimationEnd(Animator param1Animator) {
                    ViewCompat.setClipBounds(this.a, null);
                  }
                });
            objectAnimator = objectAnimator1;
          } 
        } 
      } 
    } 
    return (Animator)objectAnimator;
  }
  
  public String[] getTransitionProperties() {
    return a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\ChangeClipBounds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */