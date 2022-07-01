package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.xmlpull.v1.XmlPullParser;

public class Slide extends Visibility {
  private static final TimeInterpolator a = (TimeInterpolator)new DecelerateInterpolator();
  
  private static final TimeInterpolator i = (TimeInterpolator)new AccelerateInterpolator();
  
  private static final CalculateSlide l = new CalculateSlideHorizontal() {
      public float getGoneX(ViewGroup param1ViewGroup, View param1View) {
        return param1View.getTranslationX() - param1ViewGroup.getWidth();
      }
    };
  
  private static final CalculateSlide m = new CalculateSlideHorizontal() {
      public float getGoneX(ViewGroup param1ViewGroup, View param1View) {
        int i = ViewCompat.getLayoutDirection((View)param1ViewGroup);
        boolean bool = true;
        if (i != 1)
          bool = false; 
        return bool ? (param1View.getTranslationX() + param1ViewGroup.getWidth()) : (param1View.getTranslationX() - param1ViewGroup.getWidth());
      }
    };
  
  private static final CalculateSlide n = new CalculateSlideVertical() {
      public float getGoneY(ViewGroup param1ViewGroup, View param1View) {
        return param1View.getTranslationY() - param1ViewGroup.getHeight();
      }
    };
  
  private static final CalculateSlide o = new CalculateSlideHorizontal() {
      public float getGoneX(ViewGroup param1ViewGroup, View param1View) {
        return param1View.getTranslationX() + param1ViewGroup.getWidth();
      }
    };
  
  private static final CalculateSlide p = new CalculateSlideHorizontal() {
      public float getGoneX(ViewGroup param1ViewGroup, View param1View) {
        int i = ViewCompat.getLayoutDirection((View)param1ViewGroup);
        boolean bool = true;
        if (i != 1)
          bool = false; 
        return bool ? (param1View.getTranslationX() - param1ViewGroup.getWidth()) : (param1View.getTranslationX() + param1ViewGroup.getWidth());
      }
    };
  
  private static final CalculateSlide q = new CalculateSlideVertical() {
      public float getGoneY(ViewGroup param1ViewGroup, View param1View) {
        return param1View.getTranslationY() + param1ViewGroup.getHeight();
      }
    };
  
  private CalculateSlide j = q;
  
  private int k = 80;
  
  public Slide() {
    setSlideEdge(80);
  }
  
  public Slide(int paramInt) {
    setSlideEdge(paramInt);
  }
  
  public Slide(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, Styleable.h);
    int i = TypedArrayUtils.getNamedInt(typedArray, (XmlPullParser)paramAttributeSet, "slideEdge", 0, 80);
    typedArray.recycle();
    setSlideEdge(i);
  }
  
  private void b(TransitionValues paramTransitionValues) {
    View view = paramTransitionValues.view;
    int[] arrayOfInt = new int[2];
    view.getLocationOnScreen(arrayOfInt);
    paramTransitionValues.values.put("android:slide:screenPosition", arrayOfInt);
  }
  
  public void captureEndValues(TransitionValues paramTransitionValues) {
    super.captureEndValues(paramTransitionValues);
    b(paramTransitionValues);
  }
  
  public void captureStartValues(TransitionValues paramTransitionValues) {
    super.captureStartValues(paramTransitionValues);
    b(paramTransitionValues);
  }
  
  public int getSlideEdge() {
    return this.k;
  }
  
  public Animator onAppear(ViewGroup paramViewGroup, View paramView, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2) {
    if (paramTransitionValues2 == null)
      return null; 
    int[] arrayOfInt = (int[])paramTransitionValues2.values.get("android:slide:screenPosition");
    float f1 = paramView.getTranslationX();
    float f2 = paramView.getTranslationY();
    float f3 = this.j.getGoneX(paramViewGroup, paramView);
    float f4 = this.j.getGoneY(paramViewGroup, paramView);
    return TranslationAnimationCreator.a(paramView, paramTransitionValues2, arrayOfInt[0], arrayOfInt[1], f3, f4, f1, f2, a, this);
  }
  
  public Animator onDisappear(ViewGroup paramViewGroup, View paramView, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2) {
    if (paramTransitionValues1 == null)
      return null; 
    int[] arrayOfInt = (int[])paramTransitionValues1.values.get("android:slide:screenPosition");
    float f1 = paramView.getTranslationX();
    float f2 = paramView.getTranslationY();
    float f3 = this.j.getGoneX(paramViewGroup, paramView);
    float f4 = this.j.getGoneY(paramViewGroup, paramView);
    return TranslationAnimationCreator.a(paramView, paramTransitionValues1, arrayOfInt[0], arrayOfInt[1], f1, f2, f3, f4, i, this);
  }
  
  public void setSlideEdge(int paramInt) {
    if (paramInt != 3) {
      if (paramInt != 5) {
        if (paramInt != 48) {
          if (paramInt != 80) {
            if (paramInt != 8388611) {
              if (paramInt == 8388613) {
                this.j = p;
              } else {
                throw new IllegalArgumentException("Invalid slide direction");
              } 
            } else {
              this.j = m;
            } 
          } else {
            this.j = q;
          } 
        } else {
          this.j = n;
        } 
      } else {
        this.j = o;
      } 
    } else {
      this.j = l;
    } 
    this.k = paramInt;
    SidePropagation sidePropagation = new SidePropagation();
    sidePropagation.setSide(paramInt);
    setPropagation(sidePropagation);
  }
  
  static interface CalculateSlide {
    float getGoneX(ViewGroup param1ViewGroup, View param1View);
    
    float getGoneY(ViewGroup param1ViewGroup, View param1View);
  }
  
  static abstract class CalculateSlideHorizontal implements CalculateSlide {
    private CalculateSlideHorizontal() {}
    
    public float getGoneY(ViewGroup param1ViewGroup, View param1View) {
      return param1View.getTranslationY();
    }
  }
  
  static abstract class CalculateSlideVertical implements CalculateSlide {
    private CalculateSlideVertical() {}
    
    public float getGoneX(ViewGroup param1ViewGroup, View param1View) {
      return param1View.getTranslationX();
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface GravityFlag {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\Slide.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */