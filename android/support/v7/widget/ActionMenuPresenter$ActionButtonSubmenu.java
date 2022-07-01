package android.support.v7.widget;

import android.content.Context;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.SubMenuBuilder;
import android.view.View;

final class ActionMenuPresenter$ActionButtonSubmenu extends MenuPopupHelper {
  public ActionMenuPresenter$ActionButtonSubmenu(Context paramContext, SubMenuBuilder paramSubMenuBuilder, View paramView) {
    super(paramContext, (MenuBuilder)paramSubMenuBuilder, paramView, false, R.attr.actionOverflowMenuStyle);
    if (!((MenuItemImpl)paramSubMenuBuilder.getItem()).isActionButton()) {
      ActionMenuPresenter$OverflowMenuButton actionMenuPresenter$OverflowMenuButton;
      if (paramActionMenuPresenter.mOverflowButton == null) {
        View view = (View)paramActionMenuPresenter.mMenuView;
      } else {
        actionMenuPresenter$OverflowMenuButton = paramActionMenuPresenter.mOverflowButton;
      } 
      this.mAnchorView = (View)actionMenuPresenter$OverflowMenuButton;
    } 
    setPresenterCallback(paramActionMenuPresenter.mPopupPresenterCallback);
  }
  
  protected final void onDismiss() {
    ActionMenuPresenter.this.mActionButtonPopup = null;
    super.onDismiss();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ActionMenuPresenter$ActionButtonSubmenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */