package com.blued.android.framework.ui.xpop.animator;

import android.animation.TimeInterpolator;
import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;

public class TranslateAnimator extends PopupAnimator {
  public boolean a = false;
  
  private float b;
  
  private float e;
  
  private int f;
  
  private int g;
  
  private float h;
  
  private float i;
  
  public TranslateAnimator(View paramView, PopupAnimation paramPopupAnimation) {
    super(paramView, paramPopupAnimation);
  }
  
  private void d() {
    int i = null.a[this.d.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 4)
            return; 
          this.c.setTranslationY((((View)this.c.getParent()).getMeasuredHeight() - this.c.getTop()));
          return;
        } 
        this.c.setTranslationX((((View)this.c.getParent()).getMeasuredWidth() - this.c.getLeft()));
        return;
      } 
      this.c.setTranslationY(-this.c.getBottom());
      return;
    } 
    this.c.setTranslationX(-this.c.getRight());
  }
  
  public void a() {
    if (!this.a) {
      this.h = this.c.getTranslationX();
      this.i = this.c.getTranslationY();
      this.a = true;
    } 
    d();
    this.b = this.c.getTranslationX();
    this.e = this.c.getTranslationY();
    this.f = this.c.getMeasuredWidth();
    this.g = this.c.getMeasuredHeight();
  }
  
  public void b() {
    this.c.animate().translationX(this.h).translationY(this.i).setInterpolator((TimeInterpolator)new FastOutSlowInInterpolator()).setDuration(XPopup.b()).withLayer().start();
  }
  
  public void c() {
    int i = null.a[this.d.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i == 4)
            this.e += (this.c.getMeasuredHeight() - this.g); 
        } else {
          this.b += (this.c.getMeasuredWidth() - this.f);
        } 
      } else {
        this.e -= (this.c.getMeasuredHeight() - this.g);
      } 
    } else {
      this.b -= (this.c.getMeasuredWidth() - this.f);
    } 
    this.c.animate().translationX(this.b).translationY(this.e).setInterpolator((TimeInterpolator)new FastOutSlowInInterpolator()).setDuration(XPopup.b()).withLayer().start();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\xpop\animator\TranslateAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */