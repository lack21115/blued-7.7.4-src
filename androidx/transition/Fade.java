package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import org.xmlpull.v1.XmlPullParser;

public class Fade extends Visibility {
  public static final int IN = 1;
  
  public static final int OUT = 2;
  
  public Fade() {}
  
  public Fade(int paramInt) {
    setMode(paramInt);
  }
  
  public Fade(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, Styleable.f);
    setMode(TypedArrayUtils.getNamedInt(typedArray, (XmlPullParser)paramAttributeSet, "fadingMode", 0, getMode()));
    typedArray.recycle();
  }
  
  private static float a(TransitionValues paramTransitionValues, float paramFloat) {
    float f = paramFloat;
    if (paramTransitionValues != null) {
      Float float_ = (Float)paramTransitionValues.values.get("android:fade:transitionAlpha");
      f = paramFloat;
      if (float_ != null)
        f = float_.floatValue(); 
    } 
    return f;
  }
  
  private Animator a(View paramView, float paramFloat1, float paramFloat2) {
    if (paramFloat1 == paramFloat2)
      return null; 
    ViewUtils.a(paramView, paramFloat1);
    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(paramView, ViewUtils.a, new float[] { paramFloat2 });
    objectAnimator.addListener((Animator.AnimatorListener)new FadeAnimatorListener(paramView));
    addListener(new TransitionListenerAdapter(this, paramView) {
          public void onTransitionEnd(Transition param1Transition) {
            ViewUtils.a(this.a, 1.0F);
            ViewUtils.e(this.a);
            param1Transition.removeListener(this);
          }
        });
    return (Animator)objectAnimator;
  }
  
  public void captureStartValues(TransitionValues paramTransitionValues) {
    super.captureStartValues(paramTransitionValues);
    paramTransitionValues.values.put("android:fade:transitionAlpha", Float.valueOf(ViewUtils.c(paramTransitionValues.view)));
  }
  
  public Animator onAppear(ViewGroup paramViewGroup, View paramView, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2) {
    float f1 = 0.0F;
    float f2 = a(paramTransitionValues1, 0.0F);
    if (f2 != 1.0F)
      f1 = f2; 
    return a(paramView, f1, 1.0F);
  }
  
  public Animator onDisappear(ViewGroup paramViewGroup, View paramView, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2) {
    ViewUtils.d(paramView);
    return a(paramView, a(paramTransitionValues1, 1.0F), 0.0F);
  }
  
  static class FadeAnimatorListener extends AnimatorListenerAdapter {
    private final View a;
    
    private boolean b = false;
    
    FadeAnimatorListener(View param1View) {
      this.a = param1View;
    }
    
    public void onAnimationEnd(Animator param1Animator) {
      ViewUtils.a(this.a, 1.0F);
      if (this.b)
        this.a.setLayerType(0, null); 
    }
    
    public void onAnimationStart(Animator param1Animator) {
      if (ViewCompat.hasOverlappingRendering(this.a) && this.a.getLayerType() == 0) {
        this.b = true;
        this.a.setLayerType(2, null);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\Fade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */