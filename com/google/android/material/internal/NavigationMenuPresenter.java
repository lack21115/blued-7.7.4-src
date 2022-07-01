package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import com.google.android.material.R;
import java.util.ArrayList;

public class NavigationMenuPresenter implements MenuPresenter {
  LinearLayout a;
  
  MenuBuilder b;
  
  NavigationMenuAdapter c;
  
  LayoutInflater d;
  
  int e;
  
  boolean f;
  
  ColorStateList g;
  
  ColorStateList h;
  
  Drawable i;
  
  int j;
  
  int k;
  
  int l;
  
  boolean m;
  
  boolean n = true;
  
  int o;
  
  final View.OnClickListener p = new View.OnClickListener(this) {
      public void onClick(View param1View) {
        NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView)param1View;
        NavigationMenuPresenter navigationMenuPresenter = this.a;
        boolean bool = true;
        navigationMenuPresenter.a(true);
        MenuItemImpl menuItemImpl = navigationMenuItemView.getItemData();
        boolean bool1 = this.a.b.performItemAction((MenuItem)menuItemImpl, this.a, 0);
        if (menuItemImpl != null && menuItemImpl.isCheckable() && bool1) {
          this.a.c.a(menuItemImpl);
        } else {
          bool = false;
        } 
        this.a.a(false);
        if (bool)
          this.a.updateMenuView(false); 
      }
    };
  
  private NavigationMenuView q;
  
  private MenuPresenter.Callback r;
  
  private int s;
  
  private int t;
  
  private int u;
  
  private int v = -1;
  
  private void i() {
    boolean bool;
    if (this.a.getChildCount() == 0 && this.n) {
      bool = this.u;
    } else {
      bool = false;
    } 
    NavigationMenuView navigationMenuView = this.q;
    navigationMenuView.setPadding(0, bool, 0, navigationMenuView.getPaddingBottom());
  }
  
  public MenuItemImpl a() {
    return this.c.b();
  }
  
  public void a(int paramInt) {
    this.s = paramInt;
  }
  
  public void a(ColorStateList paramColorStateList) {
    this.h = paramColorStateList;
    updateMenuView(false);
  }
  
  public void a(Drawable paramDrawable) {
    this.i = paramDrawable;
    updateMenuView(false);
  }
  
  public void a(View paramView) {
    this.a.addView(paramView);
    NavigationMenuView navigationMenuView = this.q;
    navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
  }
  
  public void a(MenuItemImpl paramMenuItemImpl) {
    this.c.a(paramMenuItemImpl);
  }
  
  public void a(WindowInsetsCompat paramWindowInsetsCompat) {
    int i = paramWindowInsetsCompat.getSystemWindowInsetTop();
    if (this.u != i) {
      this.u = i;
      i();
    } 
    NavigationMenuView navigationMenuView = this.q;
    navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, paramWindowInsetsCompat.getSystemWindowInsetBottom());
    ViewCompat.dispatchApplyWindowInsets((View)this.a, paramWindowInsetsCompat);
  }
  
  public void a(boolean paramBoolean) {
    NavigationMenuAdapter navigationMenuAdapter = this.c;
    if (navigationMenuAdapter != null)
      navigationMenuAdapter.a(paramBoolean); 
  }
  
  public int b() {
    return this.a.getChildCount();
  }
  
  public View b(int paramInt) {
    View view = this.d.inflate(paramInt, (ViewGroup)this.a, false);
    a(view);
    return view;
  }
  
  public void b(ColorStateList paramColorStateList) {
    this.g = paramColorStateList;
    updateMenuView(false);
  }
  
  public void b(boolean paramBoolean) {
    if (this.n != paramBoolean) {
      this.n = paramBoolean;
      i();
    } 
  }
  
  public ColorStateList c() {
    return this.h;
  }
  
  public void c(int paramInt) {
    this.e = paramInt;
    this.f = true;
    updateMenuView(false);
  }
  
  public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl) {
    return false;
  }
  
  public ColorStateList d() {
    return this.g;
  }
  
  public void d(int paramInt) {
    this.j = paramInt;
    updateMenuView(false);
  }
  
  public Drawable e() {
    return this.i;
  }
  
  public void e(int paramInt) {
    this.k = paramInt;
    updateMenuView(false);
  }
  
  public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl) {
    return false;
  }
  
  public int f() {
    return this.j;
  }
  
  public void f(int paramInt) {
    this.t = paramInt;
    updateMenuView(false);
  }
  
  public boolean flagActionItems() {
    return false;
  }
  
  public int g() {
    return this.k;
  }
  
  public void g(int paramInt) {
    if (this.l != paramInt) {
      this.l = paramInt;
      this.m = true;
      updateMenuView(false);
    } 
  }
  
  public int getId() {
    return this.s;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup) {
    if (this.q == null) {
      this.q = (NavigationMenuView)this.d.inflate(R.layout.design_navigation_menu, paramViewGroup, false);
      NavigationMenuView navigationMenuView = this.q;
      navigationMenuView.setAccessibilityDelegateCompat(new NavigationMenuViewAccessibilityDelegate(this, navigationMenuView));
      if (this.c == null)
        this.c = new NavigationMenuAdapter(this); 
      int i = this.v;
      if (i != -1)
        this.q.setOverScrollMode(i); 
      this.a = (LinearLayout)this.d.inflate(R.layout.design_navigation_item_header, (ViewGroup)this.q, false);
      this.q.setAdapter(this.c);
    } 
    return this.q;
  }
  
  public int h() {
    return this.t;
  }
  
  public void h(int paramInt) {
    this.v = paramInt;
    NavigationMenuView navigationMenuView = this.q;
    if (navigationMenuView != null)
      navigationMenuView.setOverScrollMode(paramInt); 
  }
  
  public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder) {
    this.d = LayoutInflater.from(paramContext);
    this.b = paramMenuBuilder;
    this.o = paramContext.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {
    MenuPresenter.Callback callback = this.r;
    if (callback != null)
      callback.onCloseMenu(paramMenuBuilder, paramBoolean); 
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    if (paramParcelable instanceof Bundle) {
      Bundle bundle1 = (Bundle)paramParcelable;
      SparseArray sparseArray2 = bundle1.getSparseParcelableArray("android:menu:list");
      if (sparseArray2 != null)
        this.q.restoreHierarchyState(sparseArray2); 
      Bundle bundle2 = bundle1.getBundle("android:menu:adapter");
      if (bundle2 != null)
        this.c.a(bundle2); 
      SparseArray sparseArray1 = bundle1.getSparseParcelableArray("android:menu:header");
      if (sparseArray1 != null)
        this.a.restoreHierarchyState(sparseArray1); 
    } 
  }
  
  public Parcelable onSaveInstanceState() {
    Bundle bundle = new Bundle();
    if (this.q != null) {
      SparseArray sparseArray = new SparseArray();
      this.q.saveHierarchyState(sparseArray);
      bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    } 
    NavigationMenuAdapter navigationMenuAdapter = this.c;
    if (navigationMenuAdapter != null)
      bundle.putBundle("android:menu:adapter", navigationMenuAdapter.c()); 
    if (this.a != null) {
      SparseArray sparseArray = new SparseArray();
      this.a.saveHierarchyState(sparseArray);
      bundle.putSparseParcelableArray("android:menu:header", sparseArray);
    } 
    return (Parcelable)bundle;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder) {
    return false;
  }
  
  public void setCallback(MenuPresenter.Callback paramCallback) {
    this.r = paramCallback;
  }
  
  public void updateMenuView(boolean paramBoolean) {
    NavigationMenuAdapter navigationMenuAdapter = this.c;
    if (navigationMenuAdapter != null)
      navigationMenuAdapter.a(); 
  }
  
  static class HeaderViewHolder extends ViewHolder {
    public HeaderViewHolder(View param1View) {
      super(param1View);
    }
  }
  
  class NavigationMenuAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final ArrayList<NavigationMenuPresenter.NavigationMenuItem> b = new ArrayList<NavigationMenuPresenter.NavigationMenuItem>();
    
    private MenuItemImpl c;
    
    private boolean d;
    
    NavigationMenuAdapter(NavigationMenuPresenter this$0) {
      e();
    }
    
    private void a(int param1Int1, int param1Int2) {
      while (param1Int1 < param1Int2) {
        ((NavigationMenuPresenter.NavigationMenuTextItem)this.b.get(param1Int1)).a = true;
        param1Int1++;
      } 
    }
    
    private void e() {
      if (this.d)
        return; 
      this.d = true;
      this.b.clear();
      this.b.add(new NavigationMenuPresenter.NavigationMenuHeaderItem());
      int m = this.a.b.getVisibleItems().size();
      int j = 0;
      int k = -1;
      boolean bool = false;
      for (int i = 0; j < m; i = n) {
        int n;
        int i1;
        boolean bool1;
        MenuItemImpl menuItemImpl = this.a.b.getVisibleItems().get(j);
        if (menuItemImpl.isChecked())
          a(menuItemImpl); 
        if (menuItemImpl.isCheckable())
          menuItemImpl.setExclusiveCheckable(false); 
        if (menuItemImpl.hasSubMenu()) {
          SubMenu subMenu = menuItemImpl.getSubMenu();
          i1 = k;
          bool1 = bool;
          n = i;
          if (subMenu.hasVisibleItems()) {
            if (j != 0)
              this.b.add(new NavigationMenuPresenter.NavigationMenuSeparatorItem(this.a.o, 0)); 
            this.b.add(new NavigationMenuPresenter.NavigationMenuTextItem(menuItemImpl));
            int i3 = this.b.size();
            int i4 = subMenu.size();
            i1 = 0;
            int i2;
            for (i2 = 0; i1 < i4; i2 = n) {
              MenuItemImpl menuItemImpl1 = (MenuItemImpl)subMenu.getItem(i1);
              n = i2;
              if (menuItemImpl1.isVisible()) {
                n = i2;
                if (!i2) {
                  n = i2;
                  if (menuItemImpl1.getIcon() != null)
                    n = 1; 
                } 
                if (menuItemImpl1.isCheckable())
                  menuItemImpl1.setExclusiveCheckable(false); 
                if (menuItemImpl.isChecked())
                  a(menuItemImpl); 
                this.b.add(new NavigationMenuPresenter.NavigationMenuTextItem(menuItemImpl1));
              } 
              i1++;
            } 
            i1 = k;
            bool1 = bool;
            n = i;
            if (i2) {
              a(i3, this.b.size());
              i1 = k;
              bool1 = bool;
              n = i;
            } 
          } 
        } else {
          int i2;
          i1 = menuItemImpl.getGroupId();
          if (i1 != k) {
            i = this.b.size();
            if (menuItemImpl.getIcon() != null) {
              bool1 = true;
            } else {
              bool1 = false;
            } 
            i2 = i;
            if (j != 0) {
              i2 = i + 1;
              this.b.add(new NavigationMenuPresenter.NavigationMenuSeparatorItem(this.a.o, this.a.o));
            } 
          } else {
            bool1 = bool;
            i2 = i;
            if (!bool) {
              bool1 = bool;
              i2 = i;
              if (menuItemImpl.getIcon() != null) {
                a(i, this.b.size());
                bool1 = true;
                i2 = i;
              } 
            } 
          } 
          NavigationMenuPresenter.NavigationMenuTextItem navigationMenuTextItem = new NavigationMenuPresenter.NavigationMenuTextItem(menuItemImpl);
          navigationMenuTextItem.a = bool1;
          this.b.add(navigationMenuTextItem);
          n = i2;
        } 
        j++;
        k = i1;
        bool = bool1;
      } 
      this.d = false;
    }
    
    public NavigationMenuPresenter.ViewHolder a(ViewGroup param1ViewGroup, int param1Int) {
      return (NavigationMenuPresenter.ViewHolder)((param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? null : new NavigationMenuPresenter.HeaderViewHolder((View)this.a.a)) : new NavigationMenuPresenter.SeparatorViewHolder(this.a.d, param1ViewGroup)) : new NavigationMenuPresenter.SubheaderViewHolder(this.a.d, param1ViewGroup)) : new NavigationMenuPresenter.NormalViewHolder(this.a.d, param1ViewGroup, this.a.p));
    }
    
    public void a() {
      e();
      notifyDataSetChanged();
    }
    
    public void a(Bundle param1Bundle) {
      byte b = 0;
      int i = param1Bundle.getInt("android:menu:checked", 0);
      if (i != 0) {
        this.d = true;
        int k = this.b.size();
        for (int j = 0; j < k; j++) {
          NavigationMenuPresenter.NavigationMenuItem navigationMenuItem = this.b.get(j);
          if (navigationMenuItem instanceof NavigationMenuPresenter.NavigationMenuTextItem) {
            MenuItemImpl menuItemImpl = ((NavigationMenuPresenter.NavigationMenuTextItem)navigationMenuItem).a();
            if (menuItemImpl != null && menuItemImpl.getItemId() == i) {
              a(menuItemImpl);
              break;
            } 
          } 
        } 
        this.d = false;
        e();
      } 
      SparseArray sparseArray = param1Bundle.getSparseParcelableArray("android:menu:action_views");
      if (sparseArray != null) {
        i = this.b.size();
        for (int j = b; j < i; j++) {
          NavigationMenuPresenter.NavigationMenuItem navigationMenuItem = this.b.get(j);
          if (navigationMenuItem instanceof NavigationMenuPresenter.NavigationMenuTextItem) {
            MenuItemImpl menuItemImpl = ((NavigationMenuPresenter.NavigationMenuTextItem)navigationMenuItem).a();
            if (menuItemImpl != null) {
              View view = menuItemImpl.getActionView();
              if (view != null) {
                ParcelableSparseArray parcelableSparseArray = (ParcelableSparseArray)sparseArray.get(menuItemImpl.getItemId());
                if (parcelableSparseArray != null)
                  view.restoreHierarchyState(parcelableSparseArray); 
              } 
            } 
          } 
        } 
      } 
    }
    
    public void a(MenuItemImpl param1MenuItemImpl) {
      if (this.c != param1MenuItemImpl) {
        if (!param1MenuItemImpl.isCheckable())
          return; 
        MenuItemImpl menuItemImpl = this.c;
        if (menuItemImpl != null)
          menuItemImpl.setChecked(false); 
        this.c = param1MenuItemImpl;
        param1MenuItemImpl.setChecked(true);
      } 
    }
    
    public void a(NavigationMenuPresenter.ViewHolder param1ViewHolder) {
      if (param1ViewHolder instanceof NavigationMenuPresenter.NormalViewHolder)
        ((NavigationMenuItemView)param1ViewHolder.itemView).a(); 
    }
    
    public void a(NavigationMenuPresenter.ViewHolder param1ViewHolder, int param1Int) {
      int i = getItemViewType(param1Int);
      if (i != 0) {
        if (i != 1) {
          if (i != 2)
            return; 
          NavigationMenuPresenter.NavigationMenuSeparatorItem navigationMenuSeparatorItem = (NavigationMenuPresenter.NavigationMenuSeparatorItem)this.b.get(param1Int);
          param1ViewHolder.itemView.setPadding(0, navigationMenuSeparatorItem.a(), 0, navigationMenuSeparatorItem.b());
          return;
        } 
        ((TextView)param1ViewHolder.itemView).setText(((NavigationMenuPresenter.NavigationMenuTextItem)this.b.get(param1Int)).a().getTitle());
        return;
      } 
      NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView)param1ViewHolder.itemView;
      navigationMenuItemView.setIconTintList(this.a.h);
      if (this.a.f)
        navigationMenuItemView.setTextAppearance(this.a.e); 
      if (this.a.g != null)
        navigationMenuItemView.setTextColor(this.a.g); 
      if (this.a.i != null) {
        Drawable drawable = this.a.i.getConstantState().newDrawable();
      } else {
        param1ViewHolder = null;
      } 
      ViewCompat.setBackground((View)navigationMenuItemView, (Drawable)param1ViewHolder);
      NavigationMenuPresenter.NavigationMenuTextItem navigationMenuTextItem = (NavigationMenuPresenter.NavigationMenuTextItem)this.b.get(param1Int);
      navigationMenuItemView.setNeedsEmptyIcon(navigationMenuTextItem.a);
      navigationMenuItemView.setHorizontalPadding(this.a.j);
      navigationMenuItemView.setIconPadding(this.a.k);
      if (this.a.m)
        navigationMenuItemView.setIconSize(this.a.l); 
      navigationMenuItemView.setMaxLines(NavigationMenuPresenter.a(this.a));
      navigationMenuItemView.initialize(navigationMenuTextItem.a(), 0);
    }
    
    public void a(boolean param1Boolean) {
      this.d = param1Boolean;
    }
    
    public MenuItemImpl b() {
      return this.c;
    }
    
    public Bundle c() {
      Bundle bundle = new Bundle();
      MenuItemImpl menuItemImpl = this.c;
      if (menuItemImpl != null)
        bundle.putInt("android:menu:checked", menuItemImpl.getItemId()); 
      SparseArray sparseArray = new SparseArray();
      int i = 0;
      int j = this.b.size();
      while (i < j) {
        NavigationMenuPresenter.NavigationMenuItem navigationMenuItem = this.b.get(i);
        if (navigationMenuItem instanceof NavigationMenuPresenter.NavigationMenuTextItem) {
          MenuItemImpl menuItemImpl1 = ((NavigationMenuPresenter.NavigationMenuTextItem)navigationMenuItem).a();
          if (menuItemImpl1 != null) {
            View view = menuItemImpl1.getActionView();
          } else {
            navigationMenuItem = null;
          } 
          if (navigationMenuItem != null) {
            ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
            navigationMenuItem.saveHierarchyState(parcelableSparseArray);
            sparseArray.put(menuItemImpl1.getItemId(), parcelableSparseArray);
          } 
        } 
        i++;
      } 
      bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
      return bundle;
    }
    
    int d() {
      int i = this.a.a.getChildCount();
      int j = 0;
      if (i == 0) {
        i = 0;
      } else {
        i = 1;
      } 
      while (j < this.a.c.getItemCount()) {
        int k = i;
        if (this.a.c.getItemViewType(j) == 0)
          k = i + 1; 
        j++;
        i = k;
      } 
      return i;
    }
    
    public int getItemCount() {
      return this.b.size();
    }
    
    public long getItemId(int param1Int) {
      return param1Int;
    }
    
    public int getItemViewType(int param1Int) {
      NavigationMenuPresenter.NavigationMenuItem navigationMenuItem = this.b.get(param1Int);
      if (navigationMenuItem instanceof NavigationMenuPresenter.NavigationMenuSeparatorItem)
        return 2; 
      if (navigationMenuItem instanceof NavigationMenuPresenter.NavigationMenuHeaderItem)
        return 3; 
      if (navigationMenuItem instanceof NavigationMenuPresenter.NavigationMenuTextItem)
        return ((NavigationMenuPresenter.NavigationMenuTextItem)navigationMenuItem).a().hasSubMenu() ? 1 : 0; 
      throw new RuntimeException("Unknown item type.");
    }
  }
  
  static class NavigationMenuHeaderItem implements NavigationMenuItem {}
  
  static interface NavigationMenuItem {}
  
  static class NavigationMenuSeparatorItem implements NavigationMenuItem {
    private final int a;
    
    private final int b;
    
    public NavigationMenuSeparatorItem(int param1Int1, int param1Int2) {
      this.a = param1Int1;
      this.b = param1Int2;
    }
    
    public int a() {
      return this.a;
    }
    
    public int b() {
      return this.b;
    }
  }
  
  static class NavigationMenuTextItem implements NavigationMenuItem {
    boolean a;
    
    private final MenuItemImpl b;
    
    NavigationMenuTextItem(MenuItemImpl param1MenuItemImpl) {
      this.b = param1MenuItemImpl;
    }
    
    public MenuItemImpl a() {
      return this.b;
    }
  }
  
  class NavigationMenuViewAccessibilityDelegate extends RecyclerViewAccessibilityDelegate {
    NavigationMenuViewAccessibilityDelegate(NavigationMenuPresenter this$0, RecyclerView param1RecyclerView) {
      super(param1RecyclerView);
    }
    
    public void onInitializeAccessibilityNodeInfo(View param1View, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
      super.onInitializeAccessibilityNodeInfo(param1View, param1AccessibilityNodeInfoCompat);
      param1AccessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(this.b.c.d(), 0, false));
    }
  }
  
  static class NormalViewHolder extends ViewHolder {
    public NormalViewHolder(LayoutInflater param1LayoutInflater, ViewGroup param1ViewGroup, View.OnClickListener param1OnClickListener) {
      super(param1LayoutInflater.inflate(R.layout.design_navigation_item, param1ViewGroup, false));
      this.itemView.setOnClickListener(param1OnClickListener);
    }
  }
  
  static class SeparatorViewHolder extends ViewHolder {
    public SeparatorViewHolder(LayoutInflater param1LayoutInflater, ViewGroup param1ViewGroup) {
      super(param1LayoutInflater.inflate(R.layout.design_navigation_item_separator, param1ViewGroup, false));
    }
  }
  
  static class SubheaderViewHolder extends ViewHolder {
    public SubheaderViewHolder(LayoutInflater param1LayoutInflater, ViewGroup param1ViewGroup) {
      super(param1LayoutInflater.inflate(R.layout.design_navigation_item_subheader, param1ViewGroup, false));
    }
  }
  
  static abstract class ViewHolder extends RecyclerView.ViewHolder {
    public ViewHolder(View param1View) {
      super(param1View);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\internal\NavigationMenuPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */