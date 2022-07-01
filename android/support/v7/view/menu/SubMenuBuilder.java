package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public final class SubMenuBuilder extends MenuBuilder implements SubMenu {
  private MenuItemImpl mItem;
  
  public MenuBuilder mParentMenu;
  
  public SubMenuBuilder(Context paramContext, MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl) {
    super(paramContext);
    this.mParentMenu = paramMenuBuilder;
    this.mItem = paramMenuItemImpl;
  }
  
  public final boolean collapseItemActionView(MenuItemImpl paramMenuItemImpl) {
    return this.mParentMenu.collapseItemActionView(paramMenuItemImpl);
  }
  
  final boolean dispatchMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem) {
    return (super.dispatchMenuItemSelected(paramMenuBuilder, paramMenuItem) || this.mParentMenu.dispatchMenuItemSelected(paramMenuBuilder, paramMenuItem));
  }
  
  public final boolean expandItemActionView(MenuItemImpl paramMenuItemImpl) {
    return this.mParentMenu.expandItemActionView(paramMenuItemImpl);
  }
  
  public final MenuItem getItem() {
    return (MenuItem)this.mItem;
  }
  
  public final MenuBuilder getRootMenu() {
    return this.mParentMenu.getRootMenu();
  }
  
  public final boolean isQwertyMode() {
    return this.mParentMenu.isQwertyMode();
  }
  
  public final boolean isShortcutsVisible() {
    return this.mParentMenu.isShortcutsVisible();
  }
  
  public final SubMenu setHeaderIcon(int paramInt) {
    setHeaderInternal$6c64639d(0, null, paramInt, null);
    return this;
  }
  
  public final SubMenu setHeaderIcon(Drawable paramDrawable) {
    setHeaderInternal$6c64639d(0, null, 0, null);
    return this;
  }
  
  public final SubMenu setHeaderTitle(int paramInt) {
    setHeaderInternal$6c64639d(paramInt, null, 0, null);
    return this;
  }
  
  public final SubMenu setHeaderTitle(CharSequence paramCharSequence) {
    setHeaderInternal$6c64639d(0, paramCharSequence, 0, null);
    return this;
  }
  
  public final SubMenu setHeaderView(View paramView) {
    setHeaderInternal$6c64639d(0, null, 0, paramView);
    return this;
  }
  
  public final SubMenu setIcon(int paramInt) {
    this.mItem.setIcon(paramInt);
    return this;
  }
  
  public final SubMenu setIcon(Drawable paramDrawable) {
    this.mItem.setIcon(paramDrawable);
    return this;
  }
  
  public final void setQwertyMode(boolean paramBoolean) {
    this.mParentMenu.setQwertyMode(paramBoolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\view\menu\SubMenuBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */