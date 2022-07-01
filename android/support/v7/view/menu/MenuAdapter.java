package android.support.v7.view.menu;

import android.support.v7.appcompat.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public final class MenuAdapter extends BaseAdapter {
  private static int ITEM_LAYOUT = R.layout.abc_popup_menu_item_layout;
  
  public MenuBuilder mAdapterMenu;
  
  private int mExpandedIndex = -1;
  
  boolean mForceShowIcon;
  
  private final LayoutInflater mInflater;
  
  private final boolean mOverflowOnly;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public MenuAdapter(MenuBuilder paramMenuBuilder, LayoutInflater paramLayoutInflater, boolean paramBoolean) {
    this.mOverflowOnly = paramBoolean;
    this.mInflater = paramLayoutInflater;
    this.mAdapterMenu = paramMenuBuilder;
    findExpandedIndex();
  }
  
  private void findExpandedIndex() {
    MenuItemImpl menuItemImpl = this.mAdapterMenu.mExpandedItem;
    if (menuItemImpl != null) {
      ArrayList<MenuItemImpl> arrayList = this.mAdapterMenu.getNonActionItems();
      int j = arrayList.size();
      for (int i = 0; i < j; i++) {
        if ((MenuItemImpl)arrayList.get(i) == menuItemImpl) {
          this.mExpandedIndex = i;
          return;
        } 
      } 
    } 
    this.mExpandedIndex = -1;
  }
  
  public final int getCount() {
    ArrayList arrayList;
    if (this.mOverflowOnly) {
      arrayList = this.mAdapterMenu.getNonActionItems();
    } else {
      arrayList = this.mAdapterMenu.getVisibleItems();
    } 
    return (this.mExpandedIndex < 0) ? arrayList.size() : (arrayList.size() - 1);
  }
  
  public final MenuItemImpl getItem(int paramInt) {
    ArrayList<MenuItemImpl> arrayList;
    if (this.mOverflowOnly) {
      arrayList = this.mAdapterMenu.getNonActionItems();
    } else {
      arrayList = this.mAdapterMenu.getVisibleItems();
    } 
    int i = paramInt;
    if (this.mExpandedIndex >= 0) {
      i = paramInt;
      if (paramInt >= this.mExpandedIndex)
        i = paramInt + 1; 
    } 
    return arrayList.get(i);
  }
  
  public final long getItemId(int paramInt) {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    View view = paramView;
    if (paramView == null)
      view = this.mInflater.inflate(ITEM_LAYOUT, paramViewGroup, false); 
    MenuView$ItemView menuView$ItemView = (MenuView$ItemView)view;
    if (this.mForceShowIcon) {
      ListMenuItemView listMenuItemView = (ListMenuItemView)view;
      listMenuItemView.mForceShowIcon = true;
      listMenuItemView.mPreserveIconSpacing = true;
    } 
    menuView$ItemView.initialize$667f453d(getItem(paramInt));
    return view;
  }
  
  public final void notifyDataSetChanged() {
    findExpandedIndex();
    super.notifyDataSetChanged();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\view\menu\MenuAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */