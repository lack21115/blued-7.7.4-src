package android.support.v7.view.menu;

import android.view.View;

final class StandardMenuPopup$2 implements View.OnAttachStateChangeListener {
  public final void onViewAttachedToWindow(View paramView) {}
  
  public final void onViewDetachedFromWindow(View paramView) {
    if (StandardMenuPopup.access$000(StandardMenuPopup.this) != null) {
      if (!StandardMenuPopup.access$000(StandardMenuPopup.this).isAlive())
        StandardMenuPopup.access$002(StandardMenuPopup.this, paramView.getViewTreeObserver()); 
      StandardMenuPopup.access$000(StandardMenuPopup.this).removeGlobalOnLayoutListener(StandardMenuPopup.access$100(StandardMenuPopup.this));
    } 
    paramView.removeOnAttachStateChangeListener(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\view\menu\StandardMenuPopup$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */