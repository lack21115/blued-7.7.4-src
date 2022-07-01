package android.support.v7.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class BaseMenuPresenter implements MenuPresenter {
  public MenuPresenter$Callback mCallback;
  
  public Context mContext;
  
  private int mItemLayoutRes;
  
  public MenuBuilder mMenu;
  
  public MenuView mMenuView;
  
  public Context mSystemContext;
  
  private LayoutInflater mSystemInflater;
  
  public abstract void bindItemView(MenuItemImpl paramMenuItemImpl, MenuView$ItemView paramMenuView$ItemView);
  
  public final boolean collapseItemActionView$5c2da31d(MenuItemImpl paramMenuItemImpl) {
    return false;
  }
  
  public final boolean expandItemActionView$5c2da31d(MenuItemImpl paramMenuItemImpl) {
    return false;
  }
  
  public boolean filterLeftoverView(ViewGroup paramViewGroup, int paramInt) {
    paramViewGroup.removeViewAt(paramInt);
    return true;
  }
  
  public boolean flagActionItems() {
    return false;
  }
  
  public View getItemView(MenuItemImpl paramMenuItemImpl, View paramView, ViewGroup paramViewGroup) {
    MenuView$ItemView menuView$ItemView;
    if (paramView instanceof MenuView$ItemView) {
      menuView$ItemView = (MenuView$ItemView)paramView;
    } else {
      menuView$ItemView = (MenuView$ItemView)this.mSystemInflater.inflate(this.mItemLayoutRes, paramViewGroup, false);
    } 
    bindItemView(paramMenuItemImpl, menuView$ItemView);
    return (View)menuView$ItemView;
  }
  
  public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder) {
    this.mContext = paramContext;
    LayoutInflater.from(this.mContext);
    this.mMenu = paramMenuBuilder;
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {
    if (this.mCallback != null)
      this.mCallback.onCloseMenu(paramMenuBuilder, paramBoolean); 
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder) {
    return (this.mCallback != null) ? this.mCallback.onOpenSubMenu(paramSubMenuBuilder) : false;
  }
  
  public final void setCallback(MenuPresenter$Callback paramMenuPresenter$Callback) {
    this.mCallback = paramMenuPresenter$Callback;
  }
  
  public boolean shouldIncludeItem$6edfc5cf(MenuItemImpl paramMenuItemImpl) {
    return true;
  }
  
  public void updateMenuView(boolean paramBoolean) {
    ViewGroup viewGroup = (ViewGroup)this.mMenuView;
    if (viewGroup == null)
      return; 
    MenuBuilder menuBuilder = this.mMenu;
    int i = 0;
    if (menuBuilder != null) {
      this.mMenu.flagActionItems();
      ArrayList<MenuItemImpl> arrayList = this.mMenu.getVisibleItems();
      int k = arrayList.size();
      int j = 0;
      for (i = 0; j < k; i = m) {
        MenuItemImpl menuItemImpl = arrayList.get(j);
        int m = i;
        if (shouldIncludeItem$6edfc5cf(menuItemImpl)) {
          View view1 = viewGroup.getChildAt(i);
          if (view1 instanceof MenuView$ItemView) {
            MenuItemImpl menuItemImpl1 = ((MenuView$ItemView)view1).getItemData();
          } else {
            menuBuilder = null;
          } 
          View view2 = getItemView(menuItemImpl, view1, viewGroup);
          if (menuItemImpl != menuBuilder) {
            view2.setPressed(false);
            view2.jumpDrawablesToCurrentState();
          } 
          if (view2 != view1) {
            ViewGroup viewGroup1 = (ViewGroup)view2.getParent();
            if (viewGroup1 != null)
              viewGroup1.removeView(view2); 
            ((ViewGroup)this.mMenuView).addView(view2, i);
          } 
          m = i + 1;
        } 
        j++;
      } 
    } 
    while (i < viewGroup.getChildCount()) {
      if (!filterLeftoverView(viewGroup, i))
        i++; 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\view\menu\BaseMenuPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */