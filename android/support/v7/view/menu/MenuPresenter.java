package android.support.v7.view.menu;

import android.content.Context;

public interface MenuPresenter {
  boolean collapseItemActionView$5c2da31d(MenuItemImpl paramMenuItemImpl);
  
  boolean expandItemActionView$5c2da31d(MenuItemImpl paramMenuItemImpl);
  
  boolean flagActionItems();
  
  void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder);
  
  void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean);
  
  boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder);
  
  void setCallback(MenuPresenter$Callback paramMenuPresenter$Callback);
  
  void updateMenuView(boolean paramBoolean);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\view\menu\MenuPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */