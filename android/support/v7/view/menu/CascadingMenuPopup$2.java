package android.support.v7.view.menu;

import android.view.View;

final class CascadingMenuPopup$2 implements View.OnAttachStateChangeListener {
  public final void onViewAttachedToWindow(View paramView) {}
  
  public final void onViewDetachedFromWindow(View paramView) {
    if (CascadingMenuPopup.access$000(CascadingMenuPopup.this) != null) {
      if (!CascadingMenuPopup.access$000(CascadingMenuPopup.this).isAlive())
        CascadingMenuPopup.access$002(CascadingMenuPopup.this, paramView.getViewTreeObserver()); 
      CascadingMenuPopup.access$000(CascadingMenuPopup.this).removeGlobalOnLayoutListener(CascadingMenuPopup.access$100(CascadingMenuPopup.this));
    } 
    paramView.removeOnAttachStateChangeListener(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\view\menu\CascadingMenuPopup$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */