package com.blued.android.module.shortvideo.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import com.blued.android.module.shortvideo.R;

public class StvViewUtils {
  private static Animation a;
  
  public static void a(Context paramContext, View paramView) {
    if (paramView != null && paramContext != null) {
      paramView.clearAnimation();
      paramView.setAnimation(AnimationUtils.loadAnimation(paramContext, R.anim.stv_anim_bottom_in));
    } 
  }
  
  public static void a(View paramView) {
    ScaleAnimation scaleAnimation1 = new ScaleAnimation(1.0F, 0.9F, 1.0F, 0.9F, 1, 0.5F, 1, 0.5F);
    scaleAnimation1.setDuration(100L);
    ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.9F, 1.0F, 0.9F, 1.0F, 1, 0.5F, 1, 0.5F);
    scaleAnimation2.setDuration(50L);
    scaleAnimation1.setAnimationListener(new Animation.AnimationListener(paramView, scaleAnimation2) {
          public void onAnimationEnd(Animation param1Animation) {
            this.a.startAnimation((Animation)this.b);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    scaleAnimation2.setAnimationListener(new Animation.AnimationListener() {
          public void onAnimationEnd(Animation param1Animation) {}
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    paramView.startAnimation((Animation)scaleAnimation1);
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (paramView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
      ((ViewGroup.MarginLayoutParams)paramView.getLayoutParams()).setMargins(paramInt1, paramInt2, paramInt3, paramInt4);
      paramView.requestLayout();
    } 
  }
  
  public static void a(View paramView, boolean paramBoolean) {
    if (paramView == null)
      return; 
    if (paramBoolean) {
      paramView.setAlpha(1.0F);
    } else {
      paramView.setAlpha(0.6F);
    } 
    paramView.setEnabled(paramBoolean);
  }
  
  public static void b(Context paramContext, View paramView) {
    if (paramView != null && paramContext != null) {
      paramView.clearAnimation();
      Animation animation = AnimationUtils.loadAnimation(paramContext, R.anim.stv_anim_bottom_out);
      animation.setAnimationListener(new Animation.AnimationListener(paramView) {
            public void onAnimationEnd(Animation param1Animation) {
              View view = this.a;
              if (view != null)
                view.setVisibility(8); 
            }
            
            public void onAnimationRepeat(Animation param1Animation) {}
            
            public void onAnimationStart(Animation param1Animation) {}
          });
      paramView.setAnimation(animation);
    } 
  }
  
  public static void c(Context paramContext, View paramView) {
    if (paramView != null && paramContext != null) {
      paramView.clearAnimation();
      paramView.setAnimation(AnimationUtils.loadAnimation(paramContext, R.anim.stv_anim_right_in));
    } 
  }
  
  public static void d(Context paramContext, View paramView) {
    if (paramView != null && paramContext != null) {
      paramView.clearAnimation();
      Animation animation = AnimationUtils.loadAnimation(paramContext, R.anim.stv_anim_right_out);
      animation.setAnimationListener(new Animation.AnimationListener(paramView) {
            public void onAnimationEnd(Animation param1Animation) {
              View view = this.a;
              if (view != null)
                view.setVisibility(8); 
            }
            
            public void onAnimationRepeat(Animation param1Animation) {}
            
            public void onAnimationStart(Animation param1Animation) {}
          });
      paramView.setAnimation(animation);
    } 
  }
  
  public static void e(Context paramContext, View paramView) {
    if (paramView != null && paramContext != null) {
      paramView.clearAnimation();
      paramView.setAnimation(AnimationUtils.loadAnimation(paramContext, R.anim.stv_anim_top_in));
    } 
  }
  
  public static void f(Context paramContext, View paramView) {
    if (paramView != null && paramContext != null) {
      paramView.clearAnimation();
      Animation animation = AnimationUtils.loadAnimation(paramContext, R.anim.stv_anim_top_out);
      animation.setAnimationListener(new Animation.AnimationListener(paramView) {
            public void onAnimationEnd(Animation param1Animation) {
              View view = this.a;
              if (view != null)
                view.setVisibility(8); 
            }
            
            public void onAnimationRepeat(Animation param1Animation) {}
            
            public void onAnimationStart(Animation param1Animation) {}
          });
      paramView.setAnimation(animation);
    } 
  }
  
  public static void g(Context paramContext, View paramView) {
    if (a == null)
      a = AnimationUtils.loadAnimation(paramContext, R.anim.stv_button_shake_anim); 
    paramView.startAnimation(a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvide\\utils\StvViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */