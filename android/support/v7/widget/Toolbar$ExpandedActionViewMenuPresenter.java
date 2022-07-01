package android.support.v7.widget;

import android.content.Context;
import android.support.v7.view.CollapsibleActionView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.SubMenuBuilder;
import android.view.View;
import android.view.ViewGroup;

final class Toolbar$ExpandedActionViewMenuPresenter implements MenuPresenter {
  MenuItemImpl mCurrentExpandedItem;
  
  private MenuBuilder mMenu;
  
  public final boolean collapseItemActionView$5c2da31d(MenuItemImpl paramMenuItemImpl) {
    if (this.this$0.mExpandedActionView instanceof CollapsibleActionView)
      ((CollapsibleActionView)this.this$0.mExpandedActionView).onActionViewCollapsed(); 
    this.this$0.removeView(this.this$0.mExpandedActionView);
    this.this$0.removeView((View)this.this$0.mCollapseButtonView);
    this.this$0.mExpandedActionView = null;
    Toolbar toolbar = this.this$0;
    for (int i = toolbar.mHiddenViews.size() - 1; i >= 0; i--)
      toolbar.addView(toolbar.mHiddenViews.get(i)); 
    toolbar.mHiddenViews.clear();
    this.mCurrentExpandedItem = null;
    this.this$0.requestLayout();
    paramMenuItemImpl.setActionViewExpanded(false);
    return true;
  }
  
  public final boolean expandItemActionView$5c2da31d(MenuItemImpl paramMenuItemImpl) {
    this.this$0.ensureCollapseButtonView();
    if (this.this$0.mCollapseButtonView.getParent() != this.this$0)
      this.this$0.addView((View)this.this$0.mCollapseButtonView); 
    this.this$0.mExpandedActionView = paramMenuItemImpl.getActionView();
    this.mCurrentExpandedItem = paramMenuItemImpl;
    if (this.this$0.mExpandedActionView.getParent() != this.this$0) {
      Toolbar$LayoutParams toolbar$LayoutParams = Toolbar.generateDefaultLayoutParams();
      toolbar$LayoutParams.gravity = 0x800003 | this.this$0.mButtonGravity & 0x70;
      toolbar$LayoutParams.mViewType = 2;
      this.this$0.mExpandedActionView.setLayoutParams((ViewGroup.LayoutParams)toolbar$LayoutParams);
      this.this$0.addView(this.this$0.mExpandedActionView);
    } 
    Toolbar toolbar = this.this$0;
    for (int i = toolbar.getChildCount() - 1; i >= 0; i--) {
      View view = toolbar.getChildAt(i);
      if (((Toolbar$LayoutParams)view.getLayoutParams()).mViewType != 2 && view != toolbar.mMenuView) {
        toolbar.removeViewAt(i);
        toolbar.mHiddenViews.add(view);
      } 
    } 
    this.this$0.requestLayout();
    paramMenuItemImpl.setActionViewExpanded(true);
    if (this.this$0.mExpandedActionView instanceof CollapsibleActionView)
      ((CollapsibleActionView)this.this$0.mExpandedActionView).onActionViewExpanded(); 
    return true;
  }
  
  public final boolean flagActionItems() {
    return false;
  }
  
  public final void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder) {
    if (this.mMenu != null && this.mCurrentExpandedItem != null)
      this.mMenu.collapseItemActionView(this.mCurrentExpandedItem); 
    this.mMenu = paramMenuBuilder;
  }
  
  public final void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {}
  
  public final boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder) {
    return false;
  }
  
  public final void setCallback(MenuPresenter.Callback paramCallback) {}
  
  public final void updateMenuView(boolean paramBoolean) {
    if (this.mCurrentExpandedItem != null) {
      MenuBuilder menuBuilder = this.mMenu;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (menuBuilder != null) {
        int j = this.mMenu.size();
        int i = 0;
        while (true) {
          bool1 = bool2;
          if (i < j) {
            if (this.mMenu.getItem(i) == this.mCurrentExpandedItem) {
              bool1 = true;
              break;
            } 
            i++;
            continue;
          } 
          break;
        } 
      } 
      if (!bool1)
        collapseItemActionView$5c2da31d(this.mCurrentExpandedItem); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\Toolbar$ExpandedActionViewMenuPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */