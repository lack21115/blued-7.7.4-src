package android.support.v7.widget;

import android.support.v7.view.menu.MenuItemImpl;
import android.view.View;

final class Toolbar$3 implements View.OnClickListener {
  public final void onClick(View paramView) {
    MenuItemImpl menuItemImpl;
    Toolbar toolbar = Toolbar.this;
    if (toolbar.mExpandedMenuPresenter == null) {
      toolbar = null;
    } else {
      menuItemImpl = toolbar.mExpandedMenuPresenter.mCurrentExpandedItem;
    } 
    if (menuItemImpl != null)
      menuItemImpl.collapseActionView(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\Toolbar$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */