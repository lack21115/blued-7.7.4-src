package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.R;
import java.util.ArrayList;

public class ListMenuPresenter implements AdapterView.OnItemClickListener, MenuPresenter {
  public static final String VIEWS_TAG = "android:menu:list";
  
  Context a;
  
  LayoutInflater b;
  
  MenuBuilder c;
  
  ExpandedMenuView d;
  
  int e;
  
  int f;
  
  int g;
  
  MenuAdapter h;
  
  private MenuPresenter.Callback i;
  
  private int j;
  
  public ListMenuPresenter(int paramInt1, int paramInt2) {
    this.g = paramInt1;
    this.f = paramInt2;
  }
  
  public ListMenuPresenter(Context paramContext, int paramInt) {
    this(paramInt, 0);
    this.a = paramContext;
    this.b = LayoutInflater.from(this.a);
  }
  
  public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl) {
    return false;
  }
  
  public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl) {
    return false;
  }
  
  public boolean flagActionItems() {
    return false;
  }
  
  public ListAdapter getAdapter() {
    if (this.h == null)
      this.h = new MenuAdapter(this); 
    return (ListAdapter)this.h;
  }
  
  public int getId() {
    return this.j;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup) {
    if (this.d == null) {
      this.d = (ExpandedMenuView)this.b.inflate(R.layout.abc_expanded_menu_layout, paramViewGroup, false);
      if (this.h == null)
        this.h = new MenuAdapter(this); 
      this.d.setAdapter((ListAdapter)this.h);
      this.d.setOnItemClickListener(this);
    } 
    return this.d;
  }
  
  public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder) {
    int i = this.f;
    if (i != 0) {
      this.a = (Context)new ContextThemeWrapper(paramContext, i);
      this.b = LayoutInflater.from(this.a);
    } else if (this.a != null) {
      this.a = paramContext;
      if (this.b == null)
        this.b = LayoutInflater.from(this.a); 
    } 
    this.c = paramMenuBuilder;
    MenuAdapter menuAdapter = this.h;
    if (menuAdapter != null)
      menuAdapter.notifyDataSetChanged(); 
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {
    MenuPresenter.Callback callback = this.i;
    if (callback != null)
      callback.onCloseMenu(paramMenuBuilder, paramBoolean); 
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    this.c.performItemAction((MenuItem)this.h.getItem(paramInt), this, 0);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    restoreHierarchyState((Bundle)paramParcelable);
  }
  
  public Parcelable onSaveInstanceState() {
    if (this.d == null)
      return null; 
    Bundle bundle = new Bundle();
    saveHierarchyState(bundle);
    return (Parcelable)bundle;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder) {
    if (!paramSubMenuBuilder.hasVisibleItems())
      return false; 
    (new MenuDialogHelper(paramSubMenuBuilder)).show(null);
    MenuPresenter.Callback callback = this.i;
    if (callback != null)
      callback.onOpenSubMenu(paramSubMenuBuilder); 
    return true;
  }
  
  public void restoreHierarchyState(Bundle paramBundle) {
    SparseArray sparseArray = paramBundle.getSparseParcelableArray("android:menu:list");
    if (sparseArray != null)
      this.d.restoreHierarchyState(sparseArray); 
  }
  
  public void saveHierarchyState(Bundle paramBundle) {
    SparseArray sparseArray = new SparseArray();
    ExpandedMenuView expandedMenuView = this.d;
    if (expandedMenuView != null)
      expandedMenuView.saveHierarchyState(sparseArray); 
    paramBundle.putSparseParcelableArray("android:menu:list", sparseArray);
  }
  
  public void setCallback(MenuPresenter.Callback paramCallback) {
    this.i = paramCallback;
  }
  
  public void setId(int paramInt) {
    this.j = paramInt;
  }
  
  public void setItemIndexOffset(int paramInt) {
    this.e = paramInt;
    if (this.d != null)
      updateMenuView(false); 
  }
  
  public void updateMenuView(boolean paramBoolean) {
    MenuAdapter menuAdapter = this.h;
    if (menuAdapter != null)
      menuAdapter.notifyDataSetChanged(); 
  }
  
  class MenuAdapter extends BaseAdapter {
    private int b = -1;
    
    public MenuAdapter(ListMenuPresenter this$0) {
      a();
    }
    
    void a() {
      MenuItemImpl menuItemImpl = this.a.c.getExpandedItem();
      if (menuItemImpl != null) {
        ArrayList<MenuItemImpl> arrayList = this.a.c.getNonActionItems();
        int j = arrayList.size();
        for (int i = 0; i < j; i++) {
          if ((MenuItemImpl)arrayList.get(i) == menuItemImpl) {
            this.b = i;
            return;
          } 
        } 
      } 
      this.b = -1;
    }
    
    public int getCount() {
      int i = this.a.c.getNonActionItems().size() - this.a.e;
      return (this.b < 0) ? i : (i - 1);
    }
    
    public MenuItemImpl getItem(int param1Int) {
      ArrayList<MenuItemImpl> arrayList = this.a.c.getNonActionItems();
      int i = param1Int + this.a.e;
      int j = this.b;
      param1Int = i;
      if (j >= 0) {
        param1Int = i;
        if (i >= j)
          param1Int = i + 1; 
      } 
      return arrayList.get(param1Int);
    }
    
    public long getItemId(int param1Int) {
      return param1Int;
    }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      View view = param1View;
      if (param1View == null)
        view = this.a.b.inflate(this.a.g, param1ViewGroup, false); 
      ((MenuView.ItemView)view).initialize(getItem(param1Int), 0);
      return view;
    }
    
    public void notifyDataSetChanged() {
      a();
      super.notifyDataSetChanged();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\view\menu\ListMenuPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */