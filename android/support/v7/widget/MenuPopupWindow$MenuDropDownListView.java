package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.support.v7.view.menu.ListMenuItemView;
import android.support.v7.view.menu.MenuAdapter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;

public final class MenuPopupWindow$MenuDropDownListView extends DropDownListView {
  private int mAdvanceKey;
  
  MenuItemHoverListener mHoverListener;
  
  private MenuItem mHoveredMenuItem;
  
  private int mRetreatKey;
  
  public MenuPopupWindow$MenuDropDownListView(Context paramContext, boolean paramBoolean) {
    super(paramContext, paramBoolean);
    Configuration configuration = paramContext.getResources().getConfiguration();
    if (Build.VERSION.SDK_INT >= 17 && 1 == configuration.getLayoutDirection()) {
      this.mAdvanceKey = 21;
      this.mRetreatKey = 22;
      return;
    } 
    this.mAdvanceKey = 22;
    this.mRetreatKey = 21;
  }
  
  public final boolean onHoverEvent(MotionEvent paramMotionEvent) {
    if (this.mHoverListener != null) {
      int i;
      MenuAdapter menuAdapter;
      ListAdapter listAdapter = getAdapter();
      if (listAdapter instanceof HeaderViewListAdapter) {
        HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter)listAdapter;
        i = headerViewListAdapter.getHeadersCount();
        menuAdapter = (MenuAdapter)headerViewListAdapter.getWrappedAdapter();
      } else {
        i = 0;
        menuAdapter = menuAdapter;
      } 
      MenuItemImpl menuItemImpl2 = null;
      MenuItemImpl menuItemImpl1 = menuItemImpl2;
      if (paramMotionEvent.getAction() != 10) {
        int j = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
        menuItemImpl1 = menuItemImpl2;
        if (j != -1) {
          i = j - i;
          menuItemImpl1 = menuItemImpl2;
          if (i >= 0) {
            menuItemImpl1 = menuItemImpl2;
            if (i < menuAdapter.getCount())
              menuItemImpl1 = menuAdapter.getItem(i); 
          } 
        } 
      } 
      MenuItem menuItem = this.mHoveredMenuItem;
      if (menuItem != menuItemImpl1) {
        MenuBuilder menuBuilder = menuAdapter.mAdapterMenu;
        if (menuItem != null)
          this.mHoverListener.onItemHoverExit(menuBuilder, menuItem); 
        this.mHoveredMenuItem = (MenuItem)menuItemImpl1;
        if (menuItemImpl1 != null)
          this.mHoverListener.onItemHoverEnter(menuBuilder, (MenuItem)menuItemImpl1); 
      } 
    } 
    return super.onHoverEvent(paramMotionEvent);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    ListMenuItemView listMenuItemView = (ListMenuItemView)getSelectedView();
    if (listMenuItemView != null && paramInt == this.mAdvanceKey) {
      if (listMenuItemView.isEnabled() && listMenuItemView.mItemData.hasSubMenu())
        performItemClick((View)listMenuItemView, getSelectedItemPosition(), getSelectedItemId()); 
      return true;
    } 
    if (listMenuItemView != null && paramInt == this.mRetreatKey) {
      setSelection(-1);
      ((MenuAdapter)getAdapter()).mAdapterMenu.close(false);
      return true;
    } 
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\MenuPopupWindow$MenuDropDownListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */