package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class SlideDistanceProvider implements VisibilityAnimatorProvider {
  private int a;
  
  private int b;
  
  private int a(Context paramContext) {
    int i = this.b;
    return (i != -1) ? i : paramContext.getResources().getDimensionPixelSize(R.dimen.mtrl_transition_shared_axis_slide_distance);
  }
  
  private static Animator a(View paramView, float paramFloat1, float paramFloat2) {
    return (Animator)ObjectAnimator.ofPropertyValuesHolder(paramView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[] { paramFloat1, paramFloat2 }) });
  }
  
  private static Animator a(View paramView1, View paramView2, int paramInt1, int paramInt2) {
    if (paramInt1 != 3) {
      if (paramInt1 != 5) {
        if (paramInt1 != 48) {
          if (paramInt1 != 80) {
            StringBuilder stringBuilder;
            float f;
            if (paramInt1 != 8388611) {
              if (paramInt1 == 8388613) {
                if (a(paramView1)) {
                  f = -paramInt2;
                } else {
                  f = paramInt2;
                } 
                return a(paramView2, f, 0.0F);
              } 
              stringBuilder = new StringBuilder();
              stringBuilder.append("Invalid slide direction: ");
              stringBuilder.append(paramInt1);
              throw new IllegalArgumentException(stringBuilder.toString());
            } 
            if (a((View)stringBuilder)) {
              f = paramInt2;
            } else {
              f = -paramInt2;
            } 
            return a(paramView2, f, 0.0F);
          } 
          return b(paramView2, paramInt2, 0.0F);
        } 
        return b(paramView2, -paramInt2, 0.0F);
      } 
      return a(paramView2, -paramInt2, 0.0F);
    } 
    return a(paramView2, paramInt2, 0.0F);
  }
  
  private static boolean a(View paramView) {
    return (ViewCompat.getLayoutDirection(paramView) == 1);
  }
  
  private static Animator b(View paramView, float paramFloat1, float paramFloat2) {
    return (Animator)ObjectAnimator.ofPropertyValuesHolder(paramView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[] { paramFloat1, paramFloat2 }) });
  }
  
  private static Animator b(View paramView1, View paramView2, int paramInt1, int paramInt2) {
    if (paramInt1 != 3) {
      if (paramInt1 != 5) {
        if (paramInt1 != 48) {
          if (paramInt1 != 80) {
            StringBuilder stringBuilder;
            float f;
            if (paramInt1 != 8388611) {
              if (paramInt1 == 8388613) {
                if (a(paramView1)) {
                  f = paramInt2;
                } else {
                  f = -paramInt2;
                } 
                return a(paramView2, 0.0F, f);
              } 
              stringBuilder = new StringBuilder();
              stringBuilder.append("Invalid slide direction: ");
              stringBuilder.append(paramInt1);
              throw new IllegalArgumentException(stringBuilder.toString());
            } 
            if (a((View)stringBuilder)) {
              f = -paramInt2;
            } else {
              f = paramInt2;
            } 
            return a(paramView2, 0.0F, f);
          } 
          return b(paramView2, 0.0F, -paramInt2);
        } 
        return b(paramView2, 0.0F, paramInt2);
      } 
      return a(paramView2, 0.0F, paramInt2);
    } 
    return a(paramView2, 0.0F, -paramInt2);
  }
  
  public Animator a(ViewGroup paramViewGroup, View paramView) {
    return a((View)paramViewGroup, paramView, this.a, a(paramView.getContext()));
  }
  
  public Animator b(ViewGroup paramViewGroup, View paramView) {
    return b((View)paramViewGroup, paramView, this.a, a(paramView.getContext()));
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface GravityFlag {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\transition\platform\SlideDistanceProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */