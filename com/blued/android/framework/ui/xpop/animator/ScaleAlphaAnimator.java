package com.blued.android.framework.ui.xpop.animator;

import android.animation.TimeInterpolator;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;

public class ScaleAlphaAnimator extends PopupAnimator {
  public ScaleAlphaAnimator(View paramView, PopupAnimation paramPopupAnimation) {
    super(paramView, paramPopupAnimation);
  }
  
  private void d() {
    int i = null.a[this.d.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 4) {
            if (i != 5)
              return; 
            this.c.setPivotX(this.c.getMeasuredWidth());
            this.c.setPivotY(this.c.getMeasuredHeight());
            return;
          } 
          this.c.setPivotX(0.0F);
          this.c.setPivotY(this.c.getMeasuredHeight());
          return;
        } 
        this.c.setPivotX(this.c.getMeasuredWidth());
        this.c.setPivotY(0.0F);
        return;
      } 
      this.c.setPivotX(0.0F);
      this.c.setPivotY(0.0F);
      return;
    } 
    this.c.setPivotX((this.c.getMeasuredWidth() / 2));
    this.c.setPivotY((this.c.getMeasuredHeight() / 2));
  }
  
  public void a() {
    this.c.setScaleX(0.0F);
    this.c.setScaleY(0.0F);
    this.c.setAlpha(0.0F);
    this.c.post(new Runnable(this) {
          public void run() {
            ScaleAlphaAnimator.a(this.a);
          }
        });
  }
  
  public void b() {
    this.c.post(new Runnable(this) {
          public void run() {
            this.a.c.animate().scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(XPopup.b()).setInterpolator((TimeInterpolator)new OvershootInterpolator(1.0F)).start();
          }
        });
  }
  
  public void c() {
    this.c.animate().scaleX(0.0F).scaleY(0.0F).alpha(0.0F).setDuration(XPopup.b()).setInterpolator((TimeInterpolator)new FastOutSlowInInterpolator()).start();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\xpop\animator\ScaleAlphaAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */