package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

abstract class MenuPopup implements MenuPresenter, ShowableListMenu, AdapterView.OnItemClickListener {
  Rect mEpicenterBounds;
  
  protected static int measureIndividualMenuWidth(ListAdapter paramListAdapter, ViewGroup paramViewGroup, Context paramContext, int paramInt) {
    int i = 0;
    int m = View.MeasureSpec.makeMeasureSpec(0, 0);
    int n = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i1 = paramListAdapter.getCount();
    ViewGroup viewGroup = paramViewGroup;
    paramViewGroup = null;
    int k = 0;
    int j = 0;
    while (i < i1) {
      FrameLayout frameLayout2;
      int i3 = paramListAdapter.getItemViewType(i);
      int i2 = k;
      if (i3 != k) {
        paramViewGroup = null;
        i2 = i3;
      } 
      ViewGroup viewGroup1 = viewGroup;
      if (viewGroup == null)
        frameLayout2 = new FrameLayout(paramContext); 
      View view = paramListAdapter.getView(i, (View)paramViewGroup, (ViewGroup)frameLayout2);
      view.measure(m, n);
      i3 = view.getMeasuredWidth();
      if (i3 >= paramInt)
        return paramInt; 
      k = j;
      if (i3 > j)
        k = i3; 
      i++;
      j = k;
      FrameLayout frameLayout1 = frameLayout2;
      k = i2;
    } 
    return j;
  }
  
  protected static boolean shouldPreserveIconSpacing(MenuBuilder paramMenuBuilder) {
    int j = paramMenuBuilder.size();
    for (int i = 0; i < j; i++) {
      MenuItem menuItem = paramMenuBuilder.getItem(i);
      if (menuItem.isVisible() && menuItem.getIcon() != null)
        return true; 
    } 
    return false;
  }
  
  protected static MenuAdapter toMenuAdapter(ListAdapter paramListAdapter) {
    return (paramListAdapter instanceof HeaderViewListAdapter) ? (MenuAdapter)((HeaderViewListAdapter)paramListAdapter).getWrappedAdapter() : (MenuAdapter)paramListAdapter;
  }
  
  public abstract void addMenu(MenuBuilder paramMenuBuilder);
  
  protected boolean closeMenuOnSubMenuOpened() {
    return true;
  }
  
  public final boolean collapseItemActionView$5c2da31d(MenuItemImpl paramMenuItemImpl) {
    return false;
  }
  
  public final boolean expandItemActionView$5c2da31d(MenuItemImpl paramMenuItemImpl) {
    return false;
  }
  
  public final void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {
    ListAdapter listAdapter = (ListAdapter)paramAdapterView.getAdapter();
    MenuBuilder menuBuilder = (toMenuAdapter(listAdapter)).mAdapterMenu;
    MenuItem menuItem = (MenuItem)listAdapter.getItem(paramInt);
    if (closeMenuOnSubMenuOpened()) {
      paramInt = 0;
    } else {
      paramInt = 4;
    } 
    menuBuilder.performItemAction(menuItem, this, paramInt);
  }
  
  public abstract void setAnchorView(View paramView);
  
  public abstract void setForceShowIcon(boolean paramBoolean);
  
  public abstract void setGravity(int paramInt);
  
  public abstract void setHorizontalOffset(int paramInt);
  
  public abstract void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener);
  
  public abstract void setShowTitle(boolean paramBoolean);
  
  public abstract void setVerticalOffset(int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\view\menu\MenuPopup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */