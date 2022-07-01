package com.blued.android.framework.ui.xpop.animator;

import android.view.View;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;

public abstract class PopupAnimator {
  public View c;
  
  public PopupAnimation d;
  
  public PopupAnimator() {}
  
  public PopupAnimator(View paramView) {
    this(paramView, null);
  }
  
  public PopupAnimator(View paramView, PopupAnimation paramPopupAnimation) {
    this.c = paramView;
    this.d = paramPopupAnimation;
  }
  
  public abstract void a();
  
  public abstract void b();
  
  public abstract void c();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\xpop\animator\PopupAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */