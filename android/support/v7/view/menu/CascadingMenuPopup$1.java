package android.support.v7.view.menu;

import android.support.v7.widget.ListPopupWindow;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Iterator;

final class CascadingMenuPopup$1 implements ViewTreeObserver.OnGlobalLayoutListener {
  public final void onGlobalLayout() {
    if (CascadingMenuPopup.this.isShowing() && CascadingMenuPopup.this.mShowingMenus.size() > 0 && !((ListPopupWindow)((CascadingMenuPopup$CascadingMenuInfo)CascadingMenuPopup.this.mShowingMenus.get(0)).window).mModal) {
      View view = CascadingMenuPopup.this.mShownAnchorView;
      if (view == null || !view.isShown()) {
        CascadingMenuPopup.this.dismiss();
        return;
      } 
      Iterator iterator = CascadingMenuPopup.this.mShowingMenus.iterator();
      while (iterator.hasNext())
        ((CascadingMenuPopup$CascadingMenuInfo)iterator.next()).window.show(); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\view\menu\CascadingMenuPopup$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */