package com.google.android.material.internal;

import android.content.Context;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

public class NavigationMenu extends MenuBuilder {
  public NavigationMenu(Context paramContext) {
    super(paramContext);
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence) {
    MenuItemImpl menuItemImpl = (MenuItemImpl)a(paramInt1, paramInt2, paramInt3, paramCharSequence);
    NavigationSubMenu navigationSubMenu = new NavigationSubMenu(getContext(), this, menuItemImpl);
    menuItemImpl.setSubMenu(navigationSubMenu);
    return (SubMenu)navigationSubMenu;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\internal\NavigationMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */