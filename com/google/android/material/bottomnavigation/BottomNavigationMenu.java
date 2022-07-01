package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

public final class BottomNavigationMenu extends MenuBuilder {
  public BottomNavigationMenu(Context paramContext) {
    super(paramContext);
  }
  
  public MenuItem a(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence) {
    if (size() + 1 <= 5) {
      stopDispatchingItemsChanged();
      MenuItem menuItem = super.a(paramInt1, paramInt2, paramInt3, paramCharSequence);
      if (menuItem instanceof MenuItemImpl)
        ((MenuItemImpl)menuItem).setExclusiveCheckable(true); 
      startDispatchingItemsChanged();
      return menuItem;
    } 
    throw new IllegalArgumentException("Maximum number of items supported by BottomNavigationView is 5. Limit can be checked with BottomNavigationView#getMaxItemCount()");
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence) {
    throw new UnsupportedOperationException("BottomNavigationView does not support submenus");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\bottomnavigation\BottomNavigationMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */