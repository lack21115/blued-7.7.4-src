package com.blued.android.module.media.selector.utils;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.media.selector.R;
import com.blued.android.module.media.selector.view.ActionSheet;

public class ViewUtils {
  public static void a(Context paramContext, View paramView) {
    if (paramView != null && paramContext != null) {
      paramView.clearAnimation();
      paramView.setAnimation(AnimationUtils.loadAnimation(paramContext, R.anim.vr_anim_bottom_in));
    } 
  }
  
  public static void a(View paramView) {
    ScaleAnimation scaleAnimation1 = new ScaleAnimation(1.0F, 1.1F, 1.0F, 1.1F, 1, 0.5F, 1, 0.5F);
    scaleAnimation1.setDuration(200L);
    ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.5F, 1.1F, 0.5F, 1.1F, 1, 0.5F, 1, 0.5F);
    scaleAnimation2.setDuration(100L);
    ScaleAnimation scaleAnimation3 = new ScaleAnimation(1.1F, 1.0F, 1.1F, 1.0F, 1, 0.5F, 1, 0.5F);
    scaleAnimation3.setDuration(50L);
    scaleAnimation1.setAnimationListener(new Animation.AnimationListener(paramView, scaleAnimation2) {
          public void onAnimationEnd(Animation param1Animation) {
            this.a.startAnimation((Animation)this.b);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    scaleAnimation2.setAnimationListener(new Animation.AnimationListener(paramView, scaleAnimation3) {
          public void onAnimationEnd(Animation param1Animation) {
            this.a.startAnimation((Animation)this.b);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    paramView.startAnimation((Animation)scaleAnimation1);
  }
  
  public static void b(Context paramContext, View paramView) {
    if (paramView != null && paramContext != null) {
      paramView.clearAnimation();
      Animation animation = AnimationUtils.loadAnimation(paramContext, R.anim.vr_anim_bottom_out);
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
      paramView.setAnimation(AnimationUtils.loadAnimation(paramContext, R.anim.vr_anim_top_in));
    } 
  }
  
  public static void d(Context paramContext, View paramView) {
    if (paramView != null && paramContext != null) {
      paramView.clearAnimation();
      Animation animation = AnimationUtils.loadAnimation(paramContext, R.anim.vr_anim_top_out);
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
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\media\selecto\\utils\ViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */