package com.soft.blued.ui.video.uitls;

import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import java.lang.reflect.Method;

public class ViewUtils {
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
  
  public static int b(View paramView) {
    try {
      Method method;
      String str = paramView.getClass().getPackage().getName();
      boolean bool = TextUtils.isEmpty(str);
      if (!bool && str.startsWith("skin.support")) {
        method = paramView.getClass().getSuperclass().getDeclaredMethod("onMeasure", new Class[] { int.class, int.class });
      } else {
        method = paramView.getClass().getDeclaredMethod("onMeasure", new Class[] { int.class, int.class });
      } 
      method.setAccessible(true);
      method.invoke(paramView, new Object[] { Integer.valueOf(View.MeasureSpec.makeMeasureSpec(((View)paramView.getParent()).getMeasuredWidth(), -2147483648)), Integer.valueOf(View.MeasureSpec.makeMeasureSpec(0, 0)) });
    } catch (Exception exception) {}
    return paramView.getMeasuredHeight();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\vide\\uitls\ViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */