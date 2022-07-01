package android.support.v7.widget;

import android.content.Context;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.view.View;

final class ActionMenuPresenter$OverflowPopup extends MenuPopupHelper {
  public ActionMenuPresenter$OverflowPopup(Context paramContext, MenuBuilder paramMenuBuilder, View paramView, boolean paramBoolean) {
    super(paramContext, paramMenuBuilder, paramView, paramBoolean, R.attr.actionOverflowMenuStyle);
    this.mDropDownGravity = 8388613;
    setPresenterCallback(paramActionMenuPresenter.mPopupPresenterCallback);
  }
  
  protected final void onDismiss() {
    if (ActionMenuPresenter.this.mMenu != null)
      ActionMenuPresenter.this.mMenu.close(); 
    ActionMenuPresenter.this.mOverflowPopup = null;
    super.onDismiss();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ActionMenuPresenter$OverflowPopup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */