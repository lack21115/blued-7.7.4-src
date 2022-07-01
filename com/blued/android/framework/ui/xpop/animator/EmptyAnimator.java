package com.blued.android.framework.ui.xpop.animator;

import android.view.View;
import com.blued.android.framework.ui.xpop.XPopup;

public class EmptyAnimator extends PopupAnimator {
  public EmptyAnimator(View paramView) {
    super(paramView, null);
  }
  
  public void a() {
    this.c.setAlpha(0.0F);
  }
  
  public void b() {
    this.c.animate().alpha(1.0F).setDuration(XPopup.b()).withLayer().start();
  }
  
  public void c() {
    this.c.animate().alpha(0.0F).setDuration(XPopup.b()).withLayer().start();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\xpop\animator\EmptyAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */