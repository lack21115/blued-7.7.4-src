package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

public class Explode extends Visibility {
  private static final TimeInterpolator a = (TimeInterpolator)new DecelerateInterpolator();
  
  private static final TimeInterpolator i = (TimeInterpolator)new AccelerateInterpolator();
  
  private int[] j = new int[2];
  
  public Explode() {
    setPropagation(new CircularPropagation());
  }
  
  public Explode(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    setPropagation(new CircularPropagation());
  }
  
  private static float a(float paramFloat1, float paramFloat2) {
    return (float)Math.sqrt((paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2));
  }
  
  private static float a(View paramView, int paramInt1, int paramInt2) {
    paramInt1 = Math.max(paramInt1, paramView.getWidth() - paramInt1);
    paramInt2 = Math.max(paramInt2, paramView.getHeight() - paramInt2);
    return a(paramInt1, paramInt2);
  }
  
  private void a(View paramView, Rect paramRect, int[] paramArrayOfint) {
    int i;
    int j;
    paramView.getLocationOnScreen(this.j);
    int[] arrayOfInt = this.j;
    int k = arrayOfInt[0];
    int m = arrayOfInt[1];
    Rect rect = getEpicenter();
    if (rect == null) {
      i = paramView.getWidth() / 2 + k + Math.round(paramView.getTranslationX());
      j = paramView.getHeight() / 2 + m + Math.round(paramView.getTranslationY());
    } else {
      i = rect.centerX();
      j = rect.centerY();
    } 
    int n = paramRect.centerX();
    int i1 = paramRect.centerY();
    float f3 = (n - i);
    float f4 = (i1 - j);
    float f2 = f3;
    float f1 = f4;
    if (f3 == 0.0F) {
      f2 = f3;
      f1 = f4;
      if (f4 == 0.0F) {
        f2 = (float)(Math.random() * 2.0D) - 1.0F;
        f1 = (float)(Math.random() * 2.0D) - 1.0F;
      } 
    } 
    f3 = a(f2, f1);
    f2 /= f3;
    f1 /= f3;
    f3 = a(paramView, i - k, j - m);
    paramArrayOfint[0] = Math.round(f2 * f3);
    paramArrayOfint[1] = Math.round(f3 * f1);
  }
  
  private void b(TransitionValues paramTransitionValues) {
    View view = paramTransitionValues.view;
    view.getLocationOnScreen(this.j);
    int[] arrayOfInt = this.j;
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = view.getWidth();
    int m = view.getHeight();
    paramTransitionValues.values.put("android:explode:screenBounds", new Rect(i, j, k + i, m + j));
  }
  
  public void captureEndValues(TransitionValues paramTransitionValues) {
    super.captureEndValues(paramTransitionValues);
    b(paramTransitionValues);
  }
  
  public void captureStartValues(TransitionValues paramTransitionValues) {
    super.captureStartValues(paramTransitionValues);
    b(paramTransitionValues);
  }
  
  public Animator onAppear(ViewGroup paramViewGroup, View paramView, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2) {
    if (paramTransitionValues2 == null)
      return null; 
    Rect rect = (Rect)paramTransitionValues2.values.get("android:explode:screenBounds");
    float f1 = paramView.getTranslationX();
    float f2 = paramView.getTranslationY();
    a((View)paramViewGroup, rect, this.j);
    int[] arrayOfInt = this.j;
    float f3 = arrayOfInt[0];
    float f4 = arrayOfInt[1];
    return TranslationAnimationCreator.a(paramView, paramTransitionValues2, rect.left, rect.top, f1 + f3, f2 + f4, f1, f2, a, this);
  }
  
  public Animator onDisappear(ViewGroup paramViewGroup, View paramView, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2) {
    float f1;
    float f2;
    if (paramTransitionValues1 == null)
      return null; 
    Rect rect = (Rect)paramTransitionValues1.values.get("android:explode:screenBounds");
    int i = rect.left;
    int j = rect.top;
    float f3 = paramView.getTranslationX();
    float f4 = paramView.getTranslationY();
    int[] arrayOfInt2 = (int[])paramTransitionValues1.view.getTag(R.id.transition_position);
    if (arrayOfInt2 != null) {
      f1 = (arrayOfInt2[0] - rect.left) + f3;
      f2 = (arrayOfInt2[1] - rect.top) + f4;
      rect.offsetTo(arrayOfInt2[0], arrayOfInt2[1]);
    } else {
      f1 = f3;
      f2 = f4;
    } 
    a((View)paramViewGroup, rect, this.j);
    int[] arrayOfInt1 = this.j;
    return TranslationAnimationCreator.a(paramView, paramTransitionValues1, i, j, f3, f4, f1 + arrayOfInt1[0], f2 + arrayOfInt1[1], i, this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\Explode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */