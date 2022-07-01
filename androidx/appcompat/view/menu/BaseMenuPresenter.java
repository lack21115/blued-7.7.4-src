package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class BaseMenuPresenter implements MenuPresenter {
  protected Context a;
  
  protected Context b;
  
  public MenuBuilder c;
  
  protected LayoutInflater d;
  
  protected LayoutInflater e;
  
  public MenuView f;
  
  private MenuPresenter.Callback g;
  
  private int h;
  
  private int i;
  
  private int j;
  
  public BaseMenuPresenter(Context paramContext, int paramInt1, int paramInt2) {
    this.a = paramContext;
    this.d = LayoutInflater.from(paramContext);
    this.h = paramInt1;
    this.i = paramInt2;
  }
  
  protected void a(View paramView, int paramInt) {
    ViewGroup viewGroup = (ViewGroup)paramView.getParent();
    if (viewGroup != null)
      viewGroup.removeView(paramView); 
    ((ViewGroup)this.f).addView(paramView, paramInt);
  }
  
  public abstract void bindItemView(MenuItemImpl paramMenuItemImpl, MenuView.ItemView paramItemView);
  
  public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl) {
    return false;
  }
  
  public MenuView.ItemView createItemView(ViewGroup paramViewGroup) {
    return (MenuView.ItemView)this.d.inflate(this.i, paramViewGroup, false);
  }
  
  public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl) {
    return false;
  }
  
  public boolean filterLeftoverView(ViewGroup paramViewGroup, int paramInt) {
    paramViewGroup.removeViewAt(paramInt);
    return true;
  }
  
  public boolean flagActionItems() {
    return false;
  }
  
  public MenuPresenter.Callback getCallback() {
    return this.g;
  }
  
  public int getId() {
    return this.j;
  }
  
  public View getItemView(MenuItemImpl paramMenuItemImpl, View paramView, ViewGroup paramViewGroup) {
    MenuView.ItemView itemView;
    if (paramView instanceof MenuView.ItemView) {
      itemView = (MenuView.ItemView)paramView;
    } else {
      itemView = createItemView(paramViewGroup);
    } 
    bindItemView(paramMenuItemImpl, itemView);
    return (View)itemView;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup) {
    if (this.f == null) {
      this.f = (MenuView)this.d.inflate(this.h, paramViewGroup, false);
      this.f.initialize(this.c);
      updateMenuView(true);
    } 
    return this.f;
  }
  
  public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder) {
    this.b = paramContext;
    this.e = LayoutInflater.from(this.b);
    this.c = paramMenuBuilder;
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {
    MenuPresenter.Callback callback = this.g;
    if (callback != null)
      callback.onCloseMenu(paramMenuBuilder, paramBoolean); 
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder) {
    MenuPresenter.Callback callback = this.g;
    return (callback != null) ? callback.onOpenSubMenu(paramSubMenuBuilder) : false;
  }
  
  public void setCallback(MenuPresenter.Callback paramCallback) {
    this.g = paramCallback;
  }
  
  public void setId(int paramInt) {
    this.j = paramInt;
  }
  
  public boolean shouldIncludeItem(int paramInt, MenuItemImpl paramMenuItemImpl) {
    return true;
  }
  
  public void updateMenuView(boolean paramBoolean) {
    ViewGroup viewGroup = (ViewGroup)this.f;
    if (viewGroup == null)
      return; 
    MenuBuilder menuBuilder = this.c;
    int i = 0;
    if (menuBuilder != null) {
      menuBuilder.flagActionItems();
      ArrayList<MenuItemImpl> arrayList = this.c.getVisibleItems();
      int k = arrayList.size();
      int j = 0;
      for (i = 0; j < k; i = m) {
        MenuItemImpl menuItemImpl = arrayList.get(j);
        int m = i;
        if (shouldIncludeItem(i, menuItemImpl)) {
          View view1 = viewGroup.getChildAt(i);
          if (view1 instanceof MenuView.ItemView) {
            MenuItemImpl menuItemImpl1 = ((MenuView.ItemView)view1).getItemData();
          } else {
            menuBuilder = null;
          } 
          View view2 = getItemView(menuItemImpl, view1, viewGroup);
          if (menuItemImpl != menuBuilder) {
            view2.setPressed(false);
            view2.jumpDrawablesToCurrentState();
          } 
          if (view2 != view1)
            a(view2, i); 
          m = i + 1;
        } 
        j++;
      } 
    } 
    while (i < viewGroup.getChildCount()) {
      if (!filterLeftoverView(viewGroup, i))
        i++; 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\view\menu\BaseMenuPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */