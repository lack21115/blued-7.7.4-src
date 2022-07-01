package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public class MenuAdapter extends BaseAdapter {
  MenuBuilder a;
  
  private int b = -1;
  
  private boolean c;
  
  private final boolean d;
  
  private final LayoutInflater e;
  
  private final int f;
  
  public MenuAdapter(MenuBuilder paramMenuBuilder, LayoutInflater paramLayoutInflater, boolean paramBoolean, int paramInt) {
    this.d = paramBoolean;
    this.e = paramLayoutInflater;
    this.a = paramMenuBuilder;
    this.f = paramInt;
    a();
  }
  
  void a() {
    MenuItemImpl menuItemImpl = this.a.getExpandedItem();
    if (menuItemImpl != null) {
      ArrayList<MenuItemImpl> arrayList = this.a.getNonActionItems();
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
  
  public MenuBuilder getAdapterMenu() {
    return this.a;
  }
  
  public int getCount() {
    ArrayList<MenuItemImpl> arrayList;
    if (this.d) {
      arrayList = this.a.getNonActionItems();
    } else {
      arrayList = this.a.getVisibleItems();
    } 
    return (this.b < 0) ? arrayList.size() : (arrayList.size() - 1);
  }
  
  public boolean getForceShowIcon() {
    return this.c;
  }
  
  public MenuItemImpl getItem(int paramInt) {
    ArrayList<MenuItemImpl> arrayList;
    if (this.d) {
      arrayList = this.a.getNonActionItems();
    } else {
      arrayList = this.a.getVisibleItems();
    } 
    int j = this.b;
    int i = paramInt;
    if (j >= 0) {
      i = paramInt;
      if (paramInt >= j)
        i = paramInt + 1; 
    } 
    return arrayList.get(i);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    boolean bool;
    View view = paramView;
    if (paramView == null)
      view = this.e.inflate(this.f, paramViewGroup, false); 
    int j = getItem(paramInt).getGroupId();
    int i = paramInt - 1;
    if (i >= 0) {
      i = getItem(i).getGroupId();
    } else {
      i = j;
    } 
    ListMenuItemView listMenuItemView = (ListMenuItemView)view;
    if (this.a.isGroupDividerEnabled() && j != i) {
      bool = true;
    } else {
      bool = false;
    } 
    listMenuItemView.setGroupDividerEnabled(bool);
    MenuView.ItemView itemView = (MenuView.ItemView)view;
    if (this.c)
      listMenuItemView.setForceShowIcon(true); 
    itemView.initialize(getItem(paramInt), 0);
    return view;
  }
  
  public void notifyDataSetChanged() {
    a();
    super.notifyDataSetChanged();
  }
  
  public void setForceShowIcon(boolean paramBoolean) {
    this.c = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\view\menu\MenuAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */