package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class ChangeScroll extends Transition {
  private static final String[] a = new String[] { "android:changeScroll:x", "android:changeScroll:y" };
  
  public ChangeScroll() {}
  
  public ChangeScroll(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  private void b(TransitionValues paramTransitionValues) {
    paramTransitionValues.values.put("android:changeScroll:x", Integer.valueOf(paramTransitionValues.view.getScrollX()));
    paramTransitionValues.values.put("android:changeScroll:y", Integer.valueOf(paramTransitionValues.view.getScrollY()));
  }
  
  public void captureEndValues(TransitionValues paramTransitionValues) {
    b(paramTransitionValues);
  }
  
  public void captureStartValues(TransitionValues paramTransitionValues) {
    b(paramTransitionValues);
  }
  
  public Animator createAnimator(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2) {
    Animator animator;
    paramViewGroup = null;
    TransitionValues transitionValues = null;
    if (paramTransitionValues1 != null) {
      ObjectAnimator objectAnimator;
      if (paramTransitionValues2 == null)
        return null; 
      View view = paramTransitionValues2.view;
      int i = ((Integer)paramTransitionValues1.values.get("android:changeScroll:x")).intValue();
      int j = ((Integer)paramTransitionValues2.values.get("android:changeScroll:x")).intValue();
      int k = ((Integer)paramTransitionValues1.values.get("android:changeScroll:y")).intValue();
      int m = ((Integer)paramTransitionValues2.values.get("android:changeScroll:y")).intValue();
      if (i != j) {
        view.setScrollX(i);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofInt(view, "scrollX", new int[] { i, j });
      } else {
        paramViewGroup = null;
      } 
      paramTransitionValues1 = transitionValues;
      if (k != m) {
        view.setScrollY(k);
        objectAnimator = ObjectAnimator.ofInt(view, "scrollY", new int[] { k, m });
      } 
      animator = TransitionUtils.a((Animator)paramViewGroup, (Animator)objectAnimator);
    } 
    return animator;
  }
  
  public String[] getTransitionProperties() {
    return a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\ChangeScroll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */