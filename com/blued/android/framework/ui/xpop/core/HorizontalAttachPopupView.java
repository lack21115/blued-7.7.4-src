package com.blued.android.framework.ui.xpop.core;

import android.graphics.PointF;
import android.graphics.Rect;
import com.blued.android.framework.ui.xpop.animator.PopupAnimator;
import com.blued.android.framework.ui.xpop.animator.ScrollScaleAnimator;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;

public class HorizontalAttachPopupView extends AttachPopupView {
  private boolean y() {
    return ((this.e || this.l.s == PopupPosition.a) && this.l.s != PopupPosition.b);
  }
  
  protected void b() {
    int i;
    super.b();
    this.a = this.l.y;
    if (this.l.x == 0) {
      i = XPopupUtils.a(getContext(), 4.0F);
    } else {
      i = this.l.x;
    } 
    this.b = i;
  }
  
  public void d() {
    float f1;
    float f2;
    boolean bool = XPopupUtils.c(getContext());
    int i = getPopupContentView().getMeasuredWidth();
    int j = getPopupContentView().getMeasuredHeight();
    PointF pointF = this.l.k;
    boolean bool2 = true;
    boolean bool1 = true;
    if (pointF != null) {
      if (this.l.k.x <= (XPopupUtils.a(getContext()) / 2))
        bool1 = false; 
      this.e = bool1;
      if (bool) {
        if (this.e) {
          f1 = XPopupUtils.a(getContext()) - this.l.k.x + this.b;
        } else {
          f1 = XPopupUtils.a(getContext()) - this.l.k.x - getPopupContentView().getMeasuredWidth() - this.b;
        } 
        f1 = -f1;
      } else if (y()) {
        f1 = this.l.k.x - i - this.b;
      } else {
        f1 = this.l.k.x + this.b;
      } 
      f2 = this.l.k.y - j * 0.5F + this.a;
    } else {
      int[] arrayOfInt = new int[2];
      this.l.a().getLocationOnScreen(arrayOfInt);
      Rect rect = new Rect(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + this.l.a().getMeasuredWidth(), arrayOfInt[1] + this.l.a().getMeasuredHeight());
      if ((rect.left + rect.right) / 2 > XPopupUtils.a(getContext()) / 2) {
        bool1 = bool2;
      } else {
        bool1 = false;
      } 
      this.e = bool1;
      if (bool) {
        if (this.e) {
          i = XPopupUtils.a(getContext()) - rect.left + this.b;
        } else {
          i = XPopupUtils.a(getContext()) - rect.right - getPopupContentView().getMeasuredWidth() - this.b;
        } 
        i = -i;
      } else if (y()) {
        i = rect.left - i - this.b;
      } else {
        i = rect.right + this.b;
      } 
      f1 = i;
      f2 = (rect.top + (rect.height() - j) / 2 + this.a);
    } 
    getPopupContentView().setTranslationX(f1);
    getPopupContentView().setTranslationY(f2);
  }
  
  protected PopupAnimator getPopupAnimator() {
    ScrollScaleAnimator scrollScaleAnimator;
    if (y()) {
      scrollScaleAnimator = new ScrollScaleAnimator(getPopupContentView(), PopupAnimation.r);
    } else {
      scrollScaleAnimator = new ScrollScaleAnimator(getPopupContentView(), PopupAnimation.n);
    } 
    scrollScaleAnimator.a = true;
    return (PopupAnimator)scrollScaleAnimator;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\xpop\core\HorizontalAttachPopupView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */