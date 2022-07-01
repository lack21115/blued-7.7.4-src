package android.support.v7.widget;

import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.ShowableListMenu;

final class ActionMenuPresenter$ActionMenuPopupCallback extends ActionMenuItemView.PopupCallback {
  public final ShowableListMenu getPopup() {
    return (ShowableListMenu)((ActionMenuPresenter.this.mActionButtonPopup != null) ? ActionMenuPresenter.this.mActionButtonPopup.getPopup() : null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ActionMenuPresenter$ActionMenuPopupCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */