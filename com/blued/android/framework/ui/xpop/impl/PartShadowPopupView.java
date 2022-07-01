package com.blued.android.framework.ui.xpop.impl;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.framework.R;
import com.blued.android.framework.ui.xpop.animator.PopupAnimator;
import com.blued.android.framework.ui.xpop.animator.TranslateAnimator;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.framework.ui.xpop.interfaces.OnClickOutsideListener;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;
import com.blued.android.framework.ui.xpop.widget.PartShadowContainer;

public abstract class PartShadowPopupView extends BasePopupView {
  protected PartShadowContainer a;
  
  public boolean b;
  
  public void a() {
    if (this.l.a() != null) {
      View view;
      ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)getPopupContentView().getLayoutParams();
      marginLayoutParams.width = getMeasuredWidth();
      int[] arrayOfInt = new int[2];
      this.l.a().getLocationOnScreen(arrayOfInt);
      Rect rect = new Rect(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + this.l.a().getMeasuredWidth(), arrayOfInt[1] + this.l.a().getMeasuredHeight());
      if (this.l.A && getPopupImplView() != null) {
        int i = (rect.left + rect.right) / 2;
        int j = getPopupImplView().getMeasuredWidth() / 2;
        getPopupImplView().setTranslationX((i - j));
      } else {
        int j = rect.left + this.l.x;
        int i = j;
        if (getPopupImplView().getMeasuredWidth() + j > XPopupUtils.a(getContext()))
          i = j - getPopupImplView().getMeasuredWidth() + j - XPopupUtils.a(getContext()); 
        getPopupImplView().setTranslationX(i);
      } 
      if ((rect.top + rect.height() / 2 > getMeasuredHeight() / 2 || this.l.s == PopupPosition.c) && this.l.s != PopupPosition.d) {
        marginLayoutParams.height = rect.top;
        this.b = true;
        view = ((ViewGroup)getPopupContentView()).getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
        layoutParams.gravity = 80;
        if (getMaxHeight() != 0)
          layoutParams.height = Math.min(view.getMeasuredHeight(), getMaxHeight()); 
        view.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      } else {
        marginLayoutParams.height = getMeasuredHeight() - ((Rect)view).bottom;
        this.b = false;
        marginLayoutParams.topMargin = ((Rect)view).bottom;
        view = ((ViewGroup)getPopupContentView()).getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
        layoutParams.gravity = 48;
        if (getMaxHeight() != 0)
          layoutParams.height = Math.min(view.getMeasuredHeight(), getMaxHeight()); 
        view.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      } 
      getPopupContentView().setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
      getPopupImplView().setTranslationY(this.l.y);
      this.a.setOnLongClickListener(new View.OnLongClickListener(this) {
            public boolean onLongClick(View param1View) {
              if (this.a.l.c.booleanValue())
                this.a.p(); 
              return false;
            }
          });
      this.a.setOnClickOutsideListener(new OnClickOutsideListener(this) {
            public void a() {
              if (this.a.l.c.booleanValue())
                this.a.p(); 
            }
          });
      return;
    } 
    throw new IllegalArgumentException("atView must not be null for PartShadowPopupView！");
  }
  
  public PopupAnimator getPopupAnimator() {
    PopupAnimation popupAnimation;
    View view = getPopupImplView();
    if (this.b) {
      popupAnimation = PopupAnimation.m;
    } else {
      popupAnimation = PopupAnimation.l;
    } 
    return (PopupAnimator)new TranslateAnimator(view, popupAnimation);
  }
  
  public int getPopupLayoutId() {
    return R.layout._xpopup_partshadow_popup_view;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    post(new Runnable(this) {
          public void run() {
            this.a.a();
          }
        });
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (this.l.c.booleanValue())
      p(); 
    if (this.r != null && this.l.D)
      this.r.a(paramMotionEvent); 
    return this.l.D;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\xpop\impl\PartShadowPopupView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */