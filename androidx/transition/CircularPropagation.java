package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

public class CircularPropagation extends VisibilityPropagation {
  private float a = 3.0F;
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    paramFloat1 = paramFloat3 - paramFloat1;
    paramFloat2 = paramFloat4 - paramFloat2;
    return (float)Math.sqrt((paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2));
  }
  
  public long getStartDelay(ViewGroup paramViewGroup, Transition paramTransition, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2) {
    boolean bool;
    int i;
    int j;
    if (paramTransitionValues1 == null && paramTransitionValues2 == null)
      return 0L; 
    if (paramTransitionValues2 == null || getViewVisibility(paramTransitionValues1) == 0) {
      bool = true;
    } else {
      bool = true;
      paramTransitionValues1 = paramTransitionValues2;
    } 
    int k = getViewX(paramTransitionValues1);
    int m = getViewY(paramTransitionValues1);
    Rect rect = paramTransition.getEpicenter();
    if (rect != null) {
      i = rect.centerX();
      j = rect.centerY();
    } else {
      int[] arrayOfInt = new int[2];
      paramViewGroup.getLocationOnScreen(arrayOfInt);
      i = Math.round((arrayOfInt[0] + paramViewGroup.getWidth() / 2) + paramViewGroup.getTranslationX());
      j = Math.round((arrayOfInt[1] + paramViewGroup.getHeight() / 2) + paramViewGroup.getTranslationY());
    } 
    float f = a(k, m, i, j) / a(0.0F, 0.0F, paramViewGroup.getWidth(), paramViewGroup.getHeight());
    long l2 = paramTransition.getDuration();
    long l1 = l2;
    if (l2 < 0L)
      l1 = 300L; 
    return Math.round((float)(l1 * bool) / this.a * f);
  }
  
  public void setPropagationSpeed(float paramFloat) {
    if (paramFloat != 0.0F) {
      this.a = paramFloat;
      return;
    } 
    throw new IllegalArgumentException("propagationSpeed may not be 0");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\CircularPropagation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */