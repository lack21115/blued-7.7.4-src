package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Parcelable;
import android.view.ViewGroup;

public interface MenuPresenter {
  boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl);
  
  boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl);
  
  boolean flagActionItems();
  
  int getId();
  
  MenuView getMenuView(ViewGroup paramViewGroup);
  
  void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder);
  
  void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean);
  
  void onRestoreInstanceState(Parcelable paramParcelable);
  
  Parcelable onSaveInstanceState();
  
  boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder);
  
  void setCallback(Callback paramCallback);
  
  void updateMenuView(boolean paramBoolean);
  
  public static interface Callback {
    void onCloseMenu(MenuBuilder param1MenuBuilder, boolean param1Boolean);
    
    boolean onOpenSubMenu(MenuBuilder param1MenuBuilder);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\view\menu\MenuPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */