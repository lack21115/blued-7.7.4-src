package androidx.appcompat.view.menu;

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

abstract class MenuPopup implements AdapterView.OnItemClickListener, MenuPresenter, ShowableListMenu {
  private Rect a;
  
  protected static int a(ListAdapter paramListAdapter, ViewGroup paramViewGroup, Context paramContext, int paramInt) {
    int j = 0;
    int m = View.MeasureSpec.makeMeasureSpec(0, 0);
    int n = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i1 = paramListAdapter.getCount();
    ViewGroup viewGroup = paramViewGroup;
    paramViewGroup = null;
    int i = 0;
    int k = 0;
    while (j < i1) {
      FrameLayout frameLayout2;
      int i3 = paramListAdapter.getItemViewType(j);
      int i2 = k;
      if (i3 != k) {
        paramViewGroup = null;
        i2 = i3;
      } 
      ViewGroup viewGroup1 = viewGroup;
      if (viewGroup == null)
        frameLayout2 = new FrameLayout(paramContext); 
      View view = paramListAdapter.getView(j, (View)paramViewGroup, (ViewGroup)frameLayout2);
      view.measure(m, n);
      k = view.getMeasuredWidth();
      if (k >= paramInt)
        return paramInt; 
      i3 = i;
      if (k > i)
        i3 = k; 
      j++;
      k = i2;
      FrameLayout frameLayout1 = frameLayout2;
      i = i3;
    } 
    return i;
  }
  
  protected static MenuAdapter a(ListAdapter paramListAdapter) {
    return (paramListAdapter instanceof HeaderViewListAdapter) ? (MenuAdapter)((HeaderViewListAdapter)paramListAdapter).getWrappedAdapter() : (MenuAdapter)paramListAdapter;
  }
  
  protected static boolean a(MenuBuilder paramMenuBuilder) {
    int j = paramMenuBuilder.size();
    for (int i = 0; i < j; i++) {
      MenuItem menuItem = paramMenuBuilder.getItem(i);
      if (menuItem.isVisible() && menuItem.getIcon() != null)
        return true; 
    } 
    return false;
  }
  
  protected boolean a() {
    return true;
  }
  
  public abstract void addMenu(MenuBuilder paramMenuBuilder);
  
  public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl) {
    return false;
  }
  
  public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl) {
    return false;
  }
  
  public Rect getEpicenterBounds() {
    return this.a;
  }
  
  public int getId() {
    return 0;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup) {
    throw new UnsupportedOperationException("MenuPopups manage their own views");
  }
  
  public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    ListAdapter listAdapter = (ListAdapter)paramAdapterView.getAdapter();
    MenuBuilder menuBuilder = (a(listAdapter)).a;
    MenuItem menuItem = (MenuItem)listAdapter.getItem(paramInt);
    if (a()) {
      paramInt = 0;
    } else {
      paramInt = 4;
    } 
    menuBuilder.performItemAction(menuItem, this, paramInt);
  }
  
  public abstract void setAnchorView(View paramView);
  
  public void setEpicenterBounds(Rect paramRect) {
    this.a = paramRect;
  }
  
  public abstract void setForceShowIcon(boolean paramBoolean);
  
  public abstract void setGravity(int paramInt);
  
  public abstract void setHorizontalOffset(int paramInt);
  
  public abstract void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener);
  
  public abstract void setShowTitle(boolean paramBoolean);
  
  public abstract void setVerticalOffset(int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\view\menu\MenuPopup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */