package android.support.v7.view.menu;

import android.support.v7.widget.ListPopupWindow;
import android.view.View;
import android.view.ViewTreeObserver;

final class StandardMenuPopup$1 implements ViewTreeObserver.OnGlobalLayoutListener {
  public final void onGlobalLayout() {
    if (StandardMenuPopup.this.isShowing() && !((ListPopupWindow)StandardMenuPopup.this.mPopup).mModal) {
      View view = StandardMenuPopup.this.mShownAnchorView;
      if (view == null || !view.isShown()) {
        StandardMenuPopup.this.dismiss();
        return;
      } 
      StandardMenuPopup.this.mPopup.show();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\view\menu\StandardMenuPopup$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */