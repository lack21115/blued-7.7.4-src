package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class SubMenuBuilder extends MenuBuilder implements SubMenu {
  private MenuBuilder d;
  
  private MenuItemImpl e;
  
  public SubMenuBuilder(Context paramContext, MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl) {
    super(paramContext);
    this.d = paramMenuBuilder;
    this.e = paramMenuItemImpl;
  }
  
  boolean a(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem) {
    return (super.a(paramMenuBuilder, paramMenuItem) || this.d.a(paramMenuBuilder, paramMenuItem));
  }
  
  public boolean collapseItemActionView(MenuItemImpl paramMenuItemImpl) {
    return this.d.collapseItemActionView(paramMenuItemImpl);
  }
  
  public boolean expandItemActionView(MenuItemImpl paramMenuItemImpl) {
    return this.d.expandItemActionView(paramMenuItemImpl);
  }
  
  public String getActionViewStatesKey() {
    boolean bool;
    MenuItemImpl menuItemImpl = this.e;
    if (menuItemImpl != null) {
      bool = menuItemImpl.getItemId();
    } else {
      bool = false;
    } 
    if (!bool)
      return null; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.getActionViewStatesKey());
    stringBuilder.append(":");
    stringBuilder.append(bool);
    return stringBuilder.toString();
  }
  
  public MenuItem getItem() {
    return (MenuItem)this.e;
  }
  
  public Menu getParentMenu() {
    return (Menu)this.d;
  }
  
  public MenuBuilder getRootMenu() {
    return this.d.getRootMenu();
  }
  
  public boolean isGroupDividerEnabled() {
    return this.d.isGroupDividerEnabled();
  }
  
  public boolean isQwertyMode() {
    return this.d.isQwertyMode();
  }
  
  public boolean isShortcutsVisible() {
    return this.d.isShortcutsVisible();
  }
  
  public void setCallback(MenuBuilder.Callback paramCallback) {
    this.d.setCallback(paramCallback);
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean) {
    this.d.setGroupDividerEnabled(paramBoolean);
  }
  
  public SubMenu setHeaderIcon(int paramInt) {
    return (SubMenu)b(paramInt);
  }
  
  public SubMenu setHeaderIcon(Drawable paramDrawable) {
    return (SubMenu)a(paramDrawable);
  }
  
  public SubMenu setHeaderTitle(int paramInt) {
    return (SubMenu)a(paramInt);
  }
  
  public SubMenu setHeaderTitle(CharSequence paramCharSequence) {
    return (SubMenu)a(paramCharSequence);
  }
  
  public SubMenu setHeaderView(View paramView) {
    return (SubMenu)a(paramView);
  }
  
  public SubMenu setIcon(int paramInt) {
    this.e.setIcon(paramInt);
    return this;
  }
  
  public SubMenu setIcon(Drawable paramDrawable) {
    this.e.setIcon(paramDrawable);
    return this;
  }
  
  public void setQwertyMode(boolean paramBoolean) {
    this.d.setQwertyMode(paramBoolean);
  }
  
  public void setShortcutsVisible(boolean paramBoolean) {
    this.d.setShortcutsVisible(paramBoolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\view\menu\SubMenuBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */