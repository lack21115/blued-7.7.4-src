package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import java.lang.reflect.Method;

public class MenuPopupWindow extends ListPopupWindow implements MenuItemHoverListener {
  private static Method a;
  
  private MenuItemHoverListener b;
  
  static {
    try {
      if (Build.VERSION.SDK_INT <= 28) {
        a = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[] { boolean.class });
        return;
      } 
    } catch (NoSuchMethodException noSuchMethodException) {
      Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
    } 
  }
  
  public MenuPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  DropDownListView a(Context paramContext, boolean paramBoolean) {
    MenuDropDownListView menuDropDownListView = new MenuDropDownListView(paramContext, paramBoolean);
    menuDropDownListView.setHoverListener(this);
    return menuDropDownListView;
  }
  
  public void onItemHoverEnter(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem) {
    MenuItemHoverListener menuItemHoverListener = this.b;
    if (menuItemHoverListener != null)
      menuItemHoverListener.onItemHoverEnter(paramMenuBuilder, paramMenuItem); 
  }
  
  public void onItemHoverExit(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem) {
    MenuItemHoverListener menuItemHoverListener = this.b;
    if (menuItemHoverListener != null)
      menuItemHoverListener.onItemHoverExit(paramMenuBuilder, paramMenuItem); 
  }
  
  public void setEnterTransition(Object paramObject) {
    if (Build.VERSION.SDK_INT >= 23)
      this.g.setEnterTransition((Transition)paramObject); 
  }
  
  public void setExitTransition(Object paramObject) {
    if (Build.VERSION.SDK_INT >= 23)
      this.g.setExitTransition((Transition)paramObject); 
  }
  
  public void setHoverListener(MenuItemHoverListener paramMenuItemHoverListener) {
    this.b = paramMenuItemHoverListener;
  }
  
  public void setTouchModal(boolean paramBoolean) {
    if (Build.VERSION.SDK_INT <= 28) {
      Method method = a;
      if (method != null)
        try {
          method.invoke(this.g, new Object[] { Boolean.valueOf(paramBoolean) });
          return;
        } catch (Exception exception) {
          Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
          return;
        }  
    } else {
      this.g.setTouchModal(paramBoolean);
    } 
  }
  
  public static class MenuDropDownListView extends DropDownListView {
    final int b;
    
    final int c;
    
    private MenuItemHoverListener d;
    
    private MenuItem e;
    
    public MenuDropDownListView(Context param1Context, boolean param1Boolean) {
      super(param1Context, param1Boolean);
      Configuration configuration = param1Context.getResources().getConfiguration();
      if (Build.VERSION.SDK_INT >= 17 && 1 == configuration.getLayoutDirection()) {
        this.b = 21;
        this.c = 22;
        return;
      } 
      this.b = 22;
      this.c = 21;
    }
    
    public void clearSelection() {
      setSelection(-1);
    }
    
    public boolean onHoverEvent(MotionEvent param1MotionEvent) {
      if (this.d != null) {
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
        if (param1MotionEvent.getAction() != 10) {
          int j = pointToPosition((int)param1MotionEvent.getX(), (int)param1MotionEvent.getY());
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
        MenuItem menuItem = this.e;
        if (menuItem != menuItemImpl1) {
          MenuBuilder menuBuilder = menuAdapter.getAdapterMenu();
          if (menuItem != null)
            this.d.onItemHoverExit(menuBuilder, menuItem); 
          this.e = (MenuItem)menuItemImpl1;
          if (menuItemImpl1 != null)
            this.d.onItemHoverEnter(menuBuilder, (MenuItem)menuItemImpl1); 
        } 
      } 
      return super.onHoverEvent(param1MotionEvent);
    }
    
    public boolean onKeyDown(int param1Int, KeyEvent param1KeyEvent) {
      ListMenuItemView listMenuItemView = (ListMenuItemView)getSelectedView();
      if (listMenuItemView != null && param1Int == this.b) {
        if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu())
          performItemClick((View)listMenuItemView, getSelectedItemPosition(), getSelectedItemId()); 
        return true;
      } 
      if (listMenuItemView != null && param1Int == this.c) {
        setSelection(-1);
        ((MenuAdapter)getAdapter()).getAdapterMenu().close(false);
        return true;
      } 
      return super.onKeyDown(param1Int, param1KeyEvent);
    }
    
    public void setHoverListener(MenuItemHoverListener param1MenuItemHoverListener) {
      this.d = param1MenuItemHoverListener;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\MenuPopupWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */