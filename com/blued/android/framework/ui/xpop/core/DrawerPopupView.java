package com.blued.android.framework.ui.xpop.core;

import android.animation.ArgbEvaluator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import com.blued.android.framework.R;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.animator.PopupAnimator;
import com.blued.android.framework.ui.xpop.enums.PopupStatus;
import com.blued.android.framework.ui.xpop.util.KeyboardUtils;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;
import com.blued.android.framework.ui.xpop.widget.PopupDrawerLayout;

public abstract class DrawerPopupView extends BasePopupView {
  PopupDrawerLayout a;
  
  float b;
  
  Paint c;
  
  Rect d;
  
  public ArgbEvaluator e;
  
  int f;
  
  int g;
  
  public void c(boolean paramBoolean) {
    if (this.l.t.booleanValue()) {
      int i;
      ArgbEvaluator argbEvaluator = this.e;
      int j = 0;
      if (paramBoolean) {
        i = 0;
      } else {
        i = XPopup.a;
      } 
      if (paramBoolean)
        j = XPopup.a; 
      ValueAnimator valueAnimator = ValueAnimator.ofObject((TypeEvaluator)argbEvaluator, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
            public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
              this.a.f = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
              this.a.postInvalidate();
            }
          });
      valueAnimator.setDuration(XPopup.b()).start();
    } 
  }
  
  protected void dispatchDraw(Canvas paramCanvas) {
    super.dispatchDraw(paramCanvas);
    if (this.l.t.booleanValue()) {
      if (this.d == null)
        this.d = new Rect(0, 0, getMeasuredWidth(), XPopupUtils.a()); 
      this.c.setColor(((Integer)this.e.evaluate(this.b, Integer.valueOf(this.g), Integer.valueOf(XPopup.a))).intValue());
      paramCanvas.drawRect(this.d, this.c);
    } 
  }
  
  public int getAnimationDuration() {
    return 0;
  }
  
  protected PopupAnimator getPopupAnimator() {
    return null;
  }
  
  protected int getPopupLayoutId() {
    return R.layout._xpopup_drawer_popup_view;
  }
  
  protected View getTargetSizeView() {
    return getPopupImplView();
  }
  
  public void p() {
    if (this.p == PopupStatus.d)
      return; 
    this.p = PopupStatus.d;
    if (this.l.o.booleanValue())
      KeyboardUtils.b((View)this); 
    clearFocus();
    c(false);
    this.a.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\xpop\core\DrawerPopupView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */