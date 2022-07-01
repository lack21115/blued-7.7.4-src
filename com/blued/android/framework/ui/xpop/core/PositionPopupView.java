package com.blued.android.framework.ui.xpop.core;

import android.view.ViewGroup;
import com.blued.android.framework.R;
import com.blued.android.framework.ui.xpop.animator.PopupAnimator;
import com.blued.android.framework.ui.xpop.animator.ScaleAlphaAnimator;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;
import com.blued.android.framework.ui.xpop.widget.PartShadowContainer;

public class PositionPopupView extends BasePopupView {
  PartShadowContainer a;
  
  protected void b() {
    super.b();
    XPopupUtils.a((ViewGroup)getPopupContentView(), getMaxWidth(), getMaxHeight(), new Runnable(this) {
          public void run() {
            if (this.a.l.A) {
              int i;
              if (!XPopupUtils.c(this.a.getContext())) {
                i = XPopupUtils.a(this.a.getContext()) - this.a.a.getMeasuredWidth();
              } else {
                i = -(XPopupUtils.a(this.a.getContext()) - this.a.a.getMeasuredWidth());
              } 
              float f = i / 2.0F;
              this.a.a.setTranslationX(f);
            } else {
              this.a.a.setTranslationX(this.a.l.x);
            } 
            this.a.a.setTranslationY(this.a.l.y);
          }
        });
  }
  
  protected PopupAnimator getPopupAnimator() {
    return (PopupAnimator)new ScaleAlphaAnimator(getPopupContentView(), PopupAnimation.a);
  }
  
  protected int getPopupLayoutId() {
    return R.layout._xpopup_attach_popup_view;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\xpop\core\PositionPopupView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */