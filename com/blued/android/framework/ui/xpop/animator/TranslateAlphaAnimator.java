package com.blued.android.framework.ui.xpop.animator;

import android.animation.TimeInterpolator;
import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;

public class TranslateAlphaAnimator extends PopupAnimator {
  private float a;
  
  private float b;
  
  private float e;
  
  private float f;
  
  public TranslateAlphaAnimator(View paramView, PopupAnimation paramPopupAnimation) {
    super(paramView, paramPopupAnimation);
  }
  
  private void d() {
    int i = null.a[this.d.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 4)
            return; 
          this.c.setTranslationY(this.c.getMeasuredHeight());
          return;
        } 
        this.c.setTranslationX(this.c.getMeasuredWidth());
        return;
      } 
      this.c.setTranslationY(-this.c.getMeasuredHeight());
      return;
    } 
    this.c.setTranslationX(-this.c.getMeasuredWidth());
  }
  
  public void a() {
    this.e = this.c.getTranslationX();
    this.f = this.c.getTranslationY();
    this.c.setAlpha(0.0F);
    d();
    this.a = this.c.getTranslationX();
    this.b = this.c.getTranslationY();
  }
  
  public void b() {
    this.c.animate().translationX(this.e).translationY(this.f).alpha(1.0F).setInterpolator((TimeInterpolator)new FastOutSlowInInterpolator()).setDuration(XPopup.b()).withLayer().start();
  }
  
  public void c() {
    this.c.animate().translationX(this.a).translationY(this.b).alpha(0.0F).setInterpolator((TimeInterpolator)new FastOutSlowInInterpolator()).setDuration(XPopup.b()).withLayer().start();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\xpop\animator\TranslateAlphaAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */