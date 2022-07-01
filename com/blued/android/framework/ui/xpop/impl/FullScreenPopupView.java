package com.blued.android.framework.ui.xpop.impl;

import android.animation.ArgbEvaluator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.framework.R;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.animator.PopupAnimator;
import com.blued.android.framework.ui.xpop.animator.TranslateAnimator;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;

public class FullScreenPopupView extends BasePopupView {
  public ArgbEvaluator a;
  
  protected View b;
  
  protected FrameLayout c;
  
  Paint d;
  
  Rect e;
  
  int f;
  
  protected void a() {
    this.b = LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup)this.c, false);
    this.c.addView(this.b);
  }
  
  public void b() {
    super.b();
    if (this.c.getChildCount() == 0)
      a(); 
    getPopupContentView().setTranslationX(this.l.x);
    getPopupContentView().setTranslationY(this.l.y);
  }
  
  public void c(boolean paramBoolean) {
    if (this.l.t.booleanValue()) {
      int i;
      ArgbEvaluator argbEvaluator = this.a;
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
      this.d.setColor(this.f);
      this.e = new Rect(0, 0, getMeasuredWidth(), XPopupUtils.a());
      paramCanvas.drawRect(this.e, this.d);
    } 
  }
  
  public PopupAnimator getPopupAnimator() {
    return (PopupAnimator)new TranslateAnimator(getPopupContentView(), PopupAnimation.m);
  }
  
  public int getPopupLayoutId() {
    return R.layout._xpopup_fullscreen_popup_view;
  }
  
  public void n() {
    super.n();
    c(true);
  }
  
  public void o() {
    super.o();
    c(false);
  }
  
  public void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    this.d = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\xpop\impl\FullScreenPopupView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */