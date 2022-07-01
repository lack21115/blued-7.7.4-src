package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.ViewConfigurationCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MenuBuilder implements SupportMenu {
  private static final int[] d = new int[] { 1, 4, 5, 3, 2, 0 };
  
  private boolean A;
  
  CharSequence a;
  
  Drawable b;
  
  View c;
  
  private final Context e;
  
  private final Resources f;
  
  private boolean g;
  
  private boolean h;
  
  private Callback i;
  
  private ArrayList<MenuItemImpl> j;
  
  private ArrayList<MenuItemImpl> k;
  
  private boolean l;
  
  private ArrayList<MenuItemImpl> m;
  
  private ArrayList<MenuItemImpl> n;
  
  private boolean o;
  
  private int p = 0;
  
  private ContextMenu.ContextMenuInfo q;
  
  private boolean r = false;
  
  private boolean s = false;
  
  private boolean t = false;
  
  private boolean u = false;
  
  private boolean v = false;
  
  private ArrayList<MenuItemImpl> w = new ArrayList<MenuItemImpl>();
  
  private CopyOnWriteArrayList<WeakReference<MenuPresenter>> x = new CopyOnWriteArrayList<WeakReference<MenuPresenter>>();
  
  private MenuItemImpl y;
  
  private boolean z = false;
  
  public MenuBuilder(Context paramContext) {
    this.e = paramContext;
    this.f = paramContext.getResources();
    this.j = new ArrayList<MenuItemImpl>();
    this.k = new ArrayList<MenuItemImpl>();
    this.l = true;
    this.m = new ArrayList<MenuItemImpl>();
    this.n = new ArrayList<MenuItemImpl>();
    this.o = true;
    b(true);
  }
  
  private static int a(ArrayList<MenuItemImpl> paramArrayList, int paramInt) {
    for (int i = paramArrayList.size() - 1; i >= 0; i--) {
      if (((MenuItemImpl)paramArrayList.get(i)).getOrdering() <= paramInt)
        return i + 1; 
    } 
    return 0;
  }
  
  private MenuItemImpl a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5) {
    return new MenuItemImpl(this, paramInt1, paramInt2, paramInt3, paramInt4, paramCharSequence, paramInt5);
  }
  
  private void a(int paramInt1, CharSequence paramCharSequence, int paramInt2, Drawable paramDrawable, View paramView) {
    Resources resources = a();
    if (paramView != null) {
      this.c = paramView;
      this.a = null;
      this.b = null;
    } else {
      if (paramInt1 > 0) {
        this.a = resources.getText(paramInt1);
      } else if (paramCharSequence != null) {
        this.a = paramCharSequence;
      } 
      if (paramInt2 > 0) {
        this.b = ContextCompat.getDrawable(getContext(), paramInt2);
      } else if (paramDrawable != null) {
        this.b = paramDrawable;
      } 
      this.c = null;
    } 
    onItemsChanged(false);
  }
  
  private void a(int paramInt, boolean paramBoolean) {
    if (paramInt >= 0) {
      if (paramInt >= this.j.size())
        return; 
      this.j.remove(paramInt);
      if (paramBoolean)
        onItemsChanged(true); 
    } 
  }
  
  private void a(Bundle paramBundle) {
    if (this.x.isEmpty())
      return; 
    SparseArray sparseArray = new SparseArray();
    for (WeakReference<MenuPresenter> weakReference : this.x) {
      MenuPresenter menuPresenter = weakReference.get();
      if (menuPresenter == null) {
        this.x.remove(weakReference);
        continue;
      } 
      int i = menuPresenter.getId();
      if (i > 0) {
        Parcelable parcelable = menuPresenter.onSaveInstanceState();
        if (parcelable != null)
          sparseArray.put(i, parcelable); 
      } 
    } 
    paramBundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
  }
  
  private void a(boolean paramBoolean) {
    if (this.x.isEmpty())
      return; 
    stopDispatchingItemsChanged();
    for (WeakReference<MenuPresenter> weakReference : this.x) {
      MenuPresenter menuPresenter = weakReference.get();
      if (menuPresenter == null) {
        this.x.remove(weakReference);
        continue;
      } 
      menuPresenter.updateMenuView(paramBoolean);
    } 
    startDispatchingItemsChanged();
  }
  
  private boolean a(SubMenuBuilder paramSubMenuBuilder, MenuPresenter paramMenuPresenter) {
    boolean bool2 = this.x.isEmpty();
    boolean bool1 = false;
    if (bool2)
      return false; 
    if (paramMenuPresenter != null)
      bool1 = paramMenuPresenter.onSubMenuSelected(paramSubMenuBuilder); 
    for (WeakReference<MenuPresenter> weakReference : this.x) {
      MenuPresenter menuPresenter = weakReference.get();
      if (menuPresenter == null) {
        this.x.remove(weakReference);
        continue;
      } 
      if (!bool1)
        bool1 = menuPresenter.onSubMenuSelected(paramSubMenuBuilder); 
    } 
    return bool1;
  }
  
  private void b(Bundle paramBundle) {
    SparseArray sparseArray = paramBundle.getSparseParcelableArray("android:menu:presenters");
    if (sparseArray != null) {
      if (this.x.isEmpty())
        return; 
      for (WeakReference<MenuPresenter> weakReference : this.x) {
        MenuPresenter menuPresenter = weakReference.get();
        if (menuPresenter == null) {
          this.x.remove(weakReference);
          continue;
        } 
        int i = menuPresenter.getId();
        if (i > 0) {
          Parcelable parcelable = (Parcelable)sparseArray.get(i);
          if (parcelable != null)
            menuPresenter.onRestoreInstanceState(parcelable); 
        } 
      } 
    } 
  }
  
  private void b(boolean paramBoolean) {
    boolean bool = true;
    if (paramBoolean && (this.f.getConfiguration()).keyboard != 1 && ViewConfigurationCompat.shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration.get(this.e), this.e)) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    } 
    this.h = paramBoolean;
  }
  
  private static int c(int paramInt) {
    int i = (0xFFFF0000 & paramInt) >> 16;
    if (i >= 0) {
      int[] arrayOfInt = d;
      if (i < arrayOfInt.length)
        return paramInt & 0xFFFF | arrayOfInt[i] << 16; 
    } 
    throw new IllegalArgumentException("order does not contain a valid category.");
  }
  
  Resources a() {
    return this.f;
  }
  
  public MenuItem a(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence) {
    int i = c(paramInt3);
    MenuItemImpl menuItemImpl = a(paramInt1, paramInt2, paramInt3, i, paramCharSequence, this.p);
    ContextMenu.ContextMenuInfo contextMenuInfo = this.q;
    if (contextMenuInfo != null)
      menuItemImpl.a(contextMenuInfo); 
    ArrayList<MenuItemImpl> arrayList = this.j;
    arrayList.add(a(arrayList, i), menuItemImpl);
    onItemsChanged(true);
    return (MenuItem)menuItemImpl;
  }
  
  protected MenuBuilder a(int paramInt) {
    a(paramInt, null, 0, null, null);
    return this;
  }
  
  protected MenuBuilder a(Drawable paramDrawable) {
    a(0, null, 0, paramDrawable, null);
    return this;
  }
  
  protected MenuBuilder a(View paramView) {
    a(0, null, 0, null, paramView);
    return this;
  }
  
  protected MenuBuilder a(CharSequence paramCharSequence) {
    a(0, paramCharSequence, 0, null, null);
    return this;
  }
  
  MenuItemImpl a(int paramInt, KeyEvent paramKeyEvent) {
    ArrayList<MenuItemImpl> arrayList = this.w;
    arrayList.clear();
    a(arrayList, paramInt, paramKeyEvent);
    if (arrayList.isEmpty())
      return null; 
    int j = paramKeyEvent.getMetaState();
    KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
    paramKeyEvent.getKeyData(keyData);
    int k = arrayList.size();
    if (k == 1)
      return arrayList.get(0); 
    boolean bool = isQwertyMode();
    for (int i = 0; i < k; i++) {
      char c;
      MenuItemImpl menuItemImpl = arrayList.get(i);
      if (bool) {
        c = menuItemImpl.getAlphabeticShortcut();
      } else {
        c = menuItemImpl.getNumericShortcut();
      } 
      if ((c == keyData.meta[0] && (j & 0x2) == 0) || (c == keyData.meta[2] && (j & 0x2) != 0) || (bool && c == '\b' && paramInt == 67))
        return menuItemImpl; 
    } 
    return null;
  }
  
  void a(MenuItem paramMenuItem) {
    int j = paramMenuItem.getGroupId();
    int k = this.j.size();
    stopDispatchingItemsChanged();
    for (int i = 0; i < k; i++) {
      MenuItemImpl menuItemImpl = this.j.get(i);
      if (menuItemImpl.getGroupId() == j && menuItemImpl.isExclusiveCheckable() && menuItemImpl.isCheckable()) {
        boolean bool;
        if (menuItemImpl == paramMenuItem) {
          bool = true;
        } else {
          bool = false;
        } 
        menuItemImpl.a(bool);
      } 
    } 
    startDispatchingItemsChanged();
  }
  
  void a(MenuItemImpl paramMenuItemImpl) {
    this.l = true;
    onItemsChanged(true);
  }
  
  void a(List<MenuItemImpl> paramList, int paramInt, KeyEvent paramKeyEvent) {
    boolean bool = isQwertyMode();
    int j = paramKeyEvent.getModifiers();
    KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
    if (!paramKeyEvent.getKeyData(keyData) && paramInt != 67)
      return; 
    int k = this.j.size();
    int i;
    for (i = 0; i < k; i++) {
      char c;
      int m;
      MenuItemImpl menuItemImpl = this.j.get(i);
      if (menuItemImpl.hasSubMenu())
        ((MenuBuilder)menuItemImpl.getSubMenu()).a(paramList, paramInt, paramKeyEvent); 
      if (bool) {
        c = menuItemImpl.getAlphabeticShortcut();
      } else {
        c = menuItemImpl.getNumericShortcut();
      } 
      if (bool) {
        m = menuItemImpl.getAlphabeticModifiers();
      } else {
        m = menuItemImpl.getNumericModifiers();
      } 
      if ((j & 0x1100F) == (m & 0x1100F)) {
        m = 1;
      } else {
        m = 0;
      } 
      if (m != 0 && c != '\000' && (c == keyData.meta[0] || c == keyData.meta[2] || (bool && c == '\b' && paramInt == 67)) && menuItemImpl.isEnabled())
        paramList.add(menuItemImpl); 
    } 
  }
  
  boolean a(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem) {
    Callback callback = this.i;
    return (callback != null && callback.onMenuItemSelected(paramMenuBuilder, paramMenuItem));
  }
  
  public MenuItem add(int paramInt) {
    return a(0, 0, 0, this.f.getString(paramInt));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return a(paramInt1, paramInt2, paramInt3, this.f.getString(paramInt4));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence) {
    return a(paramInt1, paramInt2, paramInt3, paramCharSequence);
  }
  
  public MenuItem add(CharSequence paramCharSequence) {
    return a(0, 0, 0, paramCharSequence);
  }
  
  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem) {
    byte b1;
    PackageManager packageManager = this.e.getPackageManager();
    byte b2 = 0;
    List<ResolveInfo> list = packageManager.queryIntentActivityOptions(paramComponentName, paramArrayOfIntent, paramIntent, 0);
    if (list != null) {
      b1 = list.size();
    } else {
      b1 = 0;
    } 
    int i = b2;
    if ((paramInt4 & 0x1) == 0) {
      removeGroup(paramInt1);
      i = b2;
    } 
    while (i < b1) {
      ResolveInfo resolveInfo = list.get(i);
      if (resolveInfo.specificIndex < 0) {
        intent = paramIntent;
      } else {
        intent = paramArrayOfIntent[resolveInfo.specificIndex];
      } 
      Intent intent = new Intent(intent);
      intent.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
      MenuItem menuItem = add(paramInt1, paramInt2, paramInt3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent);
      if (paramArrayOfMenuItem != null && resolveInfo.specificIndex >= 0)
        paramArrayOfMenuItem[resolveInfo.specificIndex] = menuItem; 
      i++;
    } 
    return b1;
  }
  
  public void addMenuPresenter(MenuPresenter paramMenuPresenter) {
    addMenuPresenter(paramMenuPresenter, this.e);
  }
  
  public void addMenuPresenter(MenuPresenter paramMenuPresenter, Context paramContext) {
    this.x.add(new WeakReference<MenuPresenter>(paramMenuPresenter));
    paramMenuPresenter.initForMenu(paramContext, this);
    this.o = true;
  }
  
  public SubMenu addSubMenu(int paramInt) {
    return addSubMenu(0, 0, 0, this.f.getString(paramInt));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return addSubMenu(paramInt1, paramInt2, paramInt3, this.f.getString(paramInt4));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence) {
    MenuItemImpl menuItemImpl = (MenuItemImpl)a(paramInt1, paramInt2, paramInt3, paramCharSequence);
    SubMenuBuilder subMenuBuilder = new SubMenuBuilder(this.e, this, menuItemImpl);
    menuItemImpl.setSubMenu(subMenuBuilder);
    return subMenuBuilder;
  }
  
  public SubMenu addSubMenu(CharSequence paramCharSequence) {
    return addSubMenu(0, 0, 0, paramCharSequence);
  }
  
  protected MenuBuilder b(int paramInt) {
    a(0, null, paramInt, null, null);
    return this;
  }
  
  void b(MenuItemImpl paramMenuItemImpl) {
    this.o = true;
    onItemsChanged(true);
  }
  
  boolean b() {
    return this.u;
  }
  
  public void changeMenuMode() {
    Callback callback = this.i;
    if (callback != null)
      callback.onMenuModeChange(this); 
  }
  
  public void clear() {
    MenuItemImpl menuItemImpl = this.y;
    if (menuItemImpl != null)
      collapseItemActionView(menuItemImpl); 
    this.j.clear();
    onItemsChanged(true);
  }
  
  public void clearAll() {
    this.r = true;
    clear();
    clearHeader();
    this.x.clear();
    this.r = false;
    this.s = false;
    this.t = false;
    onItemsChanged(true);
  }
  
  public void clearHeader() {
    this.b = null;
    this.a = null;
    this.c = null;
    onItemsChanged(false);
  }
  
  public void close() {
    close(true);
  }
  
  public final void close(boolean paramBoolean) {
    if (this.v)
      return; 
    this.v = true;
    for (WeakReference<MenuPresenter> weakReference : this.x) {
      MenuPresenter menuPresenter = weakReference.get();
      if (menuPresenter == null) {
        this.x.remove(weakReference);
        continue;
      } 
      menuPresenter.onCloseMenu(this, paramBoolean);
    } 
    this.v = false;
  }
  
  public boolean collapseItemActionView(MenuItemImpl paramMenuItemImpl) {
    boolean bool3 = this.x.isEmpty();
    boolean bool1 = false;
    boolean bool2 = false;
    if (!bool3) {
      if (this.y != paramMenuItemImpl)
        return false; 
      stopDispatchingItemsChanged();
      Iterator<WeakReference<MenuPresenter>> iterator = this.x.iterator();
      bool1 = bool2;
      while (true) {
        bool2 = bool1;
        if (iterator.hasNext()) {
          WeakReference<MenuPresenter> weakReference = iterator.next();
          MenuPresenter menuPresenter = weakReference.get();
          if (menuPresenter == null) {
            this.x.remove(weakReference);
            continue;
          } 
          bool2 = menuPresenter.collapseItemActionView(this, paramMenuItemImpl);
          bool1 = bool2;
          if (bool2)
            break; 
          continue;
        } 
        break;
      } 
      startDispatchingItemsChanged();
      bool1 = bool2;
      if (bool2) {
        this.y = null;
        bool1 = bool2;
      } 
    } 
    return bool1;
  }
  
  public boolean expandItemActionView(MenuItemImpl paramMenuItemImpl) {
    boolean bool2 = this.x.isEmpty();
    boolean bool1 = false;
    if (bool2)
      return false; 
    stopDispatchingItemsChanged();
    Iterator<WeakReference<MenuPresenter>> iterator = this.x.iterator();
    while (true) {
      bool2 = bool1;
      if (iterator.hasNext()) {
        WeakReference<MenuPresenter> weakReference = iterator.next();
        MenuPresenter menuPresenter = weakReference.get();
        if (menuPresenter == null) {
          this.x.remove(weakReference);
          continue;
        } 
        bool2 = menuPresenter.expandItemActionView(this, paramMenuItemImpl);
        bool1 = bool2;
        if (bool2)
          break; 
        continue;
      } 
      break;
    } 
    startDispatchingItemsChanged();
    if (bool2)
      this.y = paramMenuItemImpl; 
    return bool2;
  }
  
  public int findGroupIndex(int paramInt) {
    return findGroupIndex(paramInt, 0);
  }
  
  public int findGroupIndex(int paramInt1, int paramInt2) {
    int j = size();
    int i = paramInt2;
    if (paramInt2 < 0)
      i = 0; 
    while (i < j) {
      if (((MenuItemImpl)this.j.get(i)).getGroupId() == paramInt1)
        return i; 
      i++;
    } 
    return -1;
  }
  
  public MenuItem findItem(int paramInt) {
    int j = size();
    for (int i = 0; i < j; i++) {
      MenuItemImpl menuItemImpl = this.j.get(i);
      if (menuItemImpl.getItemId() == paramInt)
        return (MenuItem)menuItemImpl; 
      if (menuItemImpl.hasSubMenu()) {
        MenuItem menuItem = menuItemImpl.getSubMenu().findItem(paramInt);
        if (menuItem != null)
          return menuItem; 
      } 
    } 
    return null;
  }
  
  public int findItemIndex(int paramInt) {
    int j = size();
    for (int i = 0; i < j; i++) {
      if (((MenuItemImpl)this.j.get(i)).getItemId() == paramInt)
        return i; 
    } 
    return -1;
  }
  
  public void flagActionItems() {
    ArrayList<MenuItemImpl> arrayList = getVisibleItems();
    if (!this.o)
      return; 
    Iterator<WeakReference<MenuPresenter>> iterator = this.x.iterator();
    boolean bool;
    for (bool = false; iterator.hasNext(); bool |= menuPresenter.flagActionItems()) {
      WeakReference<MenuPresenter> weakReference = iterator.next();
      MenuPresenter menuPresenter = weakReference.get();
      if (menuPresenter == null) {
        this.x.remove(weakReference);
        continue;
      } 
    } 
    if (bool) {
      this.m.clear();
      this.n.clear();
      int i = arrayList.size();
      bool = false;
      while (bool < i) {
        MenuItemImpl menuItemImpl = arrayList.get(bool);
        if (menuItemImpl.isActionButton()) {
          this.m.add(menuItemImpl);
        } else {
          this.n.add(menuItemImpl);
        } 
        int j = bool + 1;
      } 
    } else {
      this.m.clear();
      this.n.clear();
      this.n.addAll(getVisibleItems());
    } 
    this.o = false;
  }
  
  public ArrayList<MenuItemImpl> getActionItems() {
    flagActionItems();
    return this.m;
  }
  
  protected String getActionViewStatesKey() {
    return "android:menu:actionviewstates";
  }
  
  public Context getContext() {
    return this.e;
  }
  
  public MenuItemImpl getExpandedItem() {
    return this.y;
  }
  
  public Drawable getHeaderIcon() {
    return this.b;
  }
  
  public CharSequence getHeaderTitle() {
    return this.a;
  }
  
  public View getHeaderView() {
    return this.c;
  }
  
  public MenuItem getItem(int paramInt) {
    return (MenuItem)this.j.get(paramInt);
  }
  
  public ArrayList<MenuItemImpl> getNonActionItems() {
    flagActionItems();
    return this.n;
  }
  
  public MenuBuilder getRootMenu() {
    return this;
  }
  
  public ArrayList<MenuItemImpl> getVisibleItems() {
    if (!this.l)
      return this.k; 
    this.k.clear();
    int j = this.j.size();
    for (int i = 0; i < j; i++) {
      MenuItemImpl menuItemImpl = this.j.get(i);
      if (menuItemImpl.isVisible())
        this.k.add(menuItemImpl); 
    } 
    this.l = false;
    this.o = true;
    return this.k;
  }
  
  public boolean hasVisibleItems() {
    if (this.A)
      return true; 
    int j = size();
    for (int i = 0; i < j; i++) {
      if (((MenuItemImpl)this.j.get(i)).isVisible())
        return true; 
    } 
    return false;
  }
  
  public boolean isGroupDividerEnabled() {
    return this.z;
  }
  
  boolean isQwertyMode() {
    return this.g;
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent) {
    return (a(paramInt, paramKeyEvent) != null);
  }
  
  public boolean isShortcutsVisible() {
    return this.h;
  }
  
  public void onItemsChanged(boolean paramBoolean) {
    if (!this.r) {
      if (paramBoolean) {
        this.l = true;
        this.o = true;
      } 
      a(paramBoolean);
      return;
    } 
    this.s = true;
    if (paramBoolean)
      this.t = true; 
  }
  
  public boolean performIdentifierAction(int paramInt1, int paramInt2) {
    return performItemAction(findItem(paramInt1), paramInt2);
  }
  
  public boolean performItemAction(MenuItem paramMenuItem, int paramInt) {
    return performItemAction(paramMenuItem, null, paramInt);
  }
  
  public boolean performItemAction(MenuItem paramMenuItem, MenuPresenter paramMenuPresenter, int paramInt) {
    MenuItemImpl menuItemImpl = (MenuItemImpl)paramMenuItem;
    if (menuItemImpl != null) {
      boolean bool;
      boolean bool1;
      if (!menuItemImpl.isEnabled())
        return false; 
      boolean bool2 = menuItemImpl.invoke();
      ActionProvider actionProvider = menuItemImpl.getSupportActionProvider();
      if (actionProvider != null && actionProvider.hasSubMenu()) {
        bool = true;
      } else {
        bool = false;
      } 
      if (menuItemImpl.hasCollapsibleActionView()) {
        bool2 |= menuItemImpl.expandActionView();
        bool1 = bool2;
        if (bool2) {
          close(true);
          return bool2;
        } 
      } else {
        if (menuItemImpl.hasSubMenu() || bool) {
          if ((paramInt & 0x4) == 0)
            close(false); 
          if (!menuItemImpl.hasSubMenu())
            menuItemImpl.setSubMenu(new SubMenuBuilder(getContext(), this, menuItemImpl)); 
          SubMenuBuilder subMenuBuilder = (SubMenuBuilder)menuItemImpl.getSubMenu();
          if (bool)
            actionProvider.onPrepareSubMenu(subMenuBuilder); 
          bool2 |= a(subMenuBuilder, paramMenuPresenter);
          boolean bool3 = bool2;
          if (!bool2) {
            close(true);
            bool3 = bool2;
          } 
          return bool3;
        } 
        bool1 = bool2;
        if ((paramInt & 0x1) == 0) {
          close(true);
          return bool2;
        } 
      } 
      return bool1;
    } 
    return false;
  }
  
  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2) {
    boolean bool;
    MenuItemImpl menuItemImpl = a(paramInt1, paramKeyEvent);
    if (menuItemImpl != null) {
      bool = performItemAction((MenuItem)menuItemImpl, paramInt2);
    } else {
      bool = false;
    } 
    if ((paramInt2 & 0x2) != 0)
      close(true); 
    return bool;
  }
  
  public void removeGroup(int paramInt) {
    int i = findGroupIndex(paramInt);
    if (i >= 0) {
      int k = this.j.size();
      for (int j = 0; j < k - i && ((MenuItemImpl)this.j.get(i)).getGroupId() == paramInt; j++)
        a(i, false); 
      onItemsChanged(true);
    } 
  }
  
  public void removeItem(int paramInt) {
    a(findItemIndex(paramInt), true);
  }
  
  public void removeItemAt(int paramInt) {
    a(paramInt, true);
  }
  
  public void removeMenuPresenter(MenuPresenter paramMenuPresenter) {
    for (WeakReference<MenuPresenter> weakReference : this.x) {
      MenuPresenter menuPresenter = weakReference.get();
      if (menuPresenter == null || menuPresenter == paramMenuPresenter)
        this.x.remove(weakReference); 
    } 
  }
  
  public void restoreActionViewStates(Bundle paramBundle) {
    if (paramBundle == null)
      return; 
    SparseArray sparseArray = paramBundle.getSparseParcelableArray(getActionViewStatesKey());
    int j = size();
    int i;
    for (i = 0; i < j; i++) {
      MenuItem menuItem = getItem(i);
      View view = menuItem.getActionView();
      if (view != null && view.getId() != -1)
        view.restoreHierarchyState(sparseArray); 
      if (menuItem.hasSubMenu())
        ((SubMenuBuilder)menuItem.getSubMenu()).restoreActionViewStates(paramBundle); 
    } 
    i = paramBundle.getInt("android:menu:expandedactionview");
    if (i > 0) {
      MenuItem menuItem = findItem(i);
      if (menuItem != null)
        menuItem.expandActionView(); 
    } 
  }
  
  public void restorePresenterStates(Bundle paramBundle) {
    b(paramBundle);
  }
  
  public void saveActionViewStates(Bundle paramBundle) {
    int j = size();
    SparseArray sparseArray = null;
    int i = 0;
    while (i < j) {
      MenuItem menuItem = getItem(i);
      View view = menuItem.getActionView();
      SparseArray sparseArray1 = sparseArray;
      if (view != null) {
        sparseArray1 = sparseArray;
        if (view.getId() != -1) {
          SparseArray sparseArray2 = sparseArray;
          if (sparseArray == null)
            sparseArray2 = new SparseArray(); 
          view.saveHierarchyState(sparseArray2);
          sparseArray1 = sparseArray2;
          if (menuItem.isActionViewExpanded()) {
            paramBundle.putInt("android:menu:expandedactionview", menuItem.getItemId());
            sparseArray1 = sparseArray2;
          } 
        } 
      } 
      if (menuItem.hasSubMenu())
        ((SubMenuBuilder)menuItem.getSubMenu()).saveActionViewStates(paramBundle); 
      i++;
      sparseArray = sparseArray1;
    } 
    if (sparseArray != null)
      paramBundle.putSparseParcelableArray(getActionViewStatesKey(), sparseArray); 
  }
  
  public void savePresenterStates(Bundle paramBundle) {
    a(paramBundle);
  }
  
  public void setCallback(Callback paramCallback) {
    this.i = paramCallback;
  }
  
  public void setCurrentMenuInfo(ContextMenu.ContextMenuInfo paramContextMenuInfo) {
    this.q = paramContextMenuInfo;
  }
  
  public MenuBuilder setDefaultShowAsAction(int paramInt) {
    this.p = paramInt;
    return this;
  }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
    int j = this.j.size();
    int i;
    for (i = 0; i < j; i++) {
      MenuItemImpl menuItemImpl = this.j.get(i);
      if (menuItemImpl.getGroupId() == paramInt) {
        menuItemImpl.setExclusiveCheckable(paramBoolean2);
        menuItemImpl.setCheckable(paramBoolean1);
      } 
    } 
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean) {
    this.z = paramBoolean;
  }
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean) {
    int j = this.j.size();
    for (int i = 0; i < j; i++) {
      MenuItemImpl menuItemImpl = this.j.get(i);
      if (menuItemImpl.getGroupId() == paramInt)
        menuItemImpl.setEnabled(paramBoolean); 
    } 
  }
  
  public void setGroupVisible(int paramInt, boolean paramBoolean) {
    int j = this.j.size();
    int i = 0;
    boolean bool;
    for (bool = false; i < j; bool = bool1) {
      MenuItemImpl menuItemImpl = this.j.get(i);
      boolean bool1 = bool;
      if (menuItemImpl.getGroupId() == paramInt) {
        bool1 = bool;
        if (menuItemImpl.b(paramBoolean))
          bool1 = true; 
      } 
      i++;
    } 
    if (bool)
      onItemsChanged(true); 
  }
  
  public void setOptionalIconsVisible(boolean paramBoolean) {
    this.u = paramBoolean;
  }
  
  public void setOverrideVisibleItems(boolean paramBoolean) {
    this.A = paramBoolean;
  }
  
  public void setQwertyMode(boolean paramBoolean) {
    this.g = paramBoolean;
    onItemsChanged(false);
  }
  
  public void setShortcutsVisible(boolean paramBoolean) {
    if (this.h == paramBoolean)
      return; 
    b(paramBoolean);
    onItemsChanged(false);
  }
  
  public int size() {
    return this.j.size();
  }
  
  public void startDispatchingItemsChanged() {
    this.r = false;
    if (this.s) {
      this.s = false;
      onItemsChanged(this.t);
    } 
  }
  
  public void stopDispatchingItemsChanged() {
    if (!this.r) {
      this.r = true;
      this.s = false;
      this.t = false;
    } 
  }
  
  public static interface Callback {
    boolean onMenuItemSelected(MenuBuilder param1MenuBuilder, MenuItem param1MenuItem);
    
    void onMenuModeChange(MenuBuilder param1MenuBuilder);
  }
  
  public static interface ItemInvoker {
    boolean invokeItem(MenuItemImpl param1MenuItemImpl);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\view\menu\MenuBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */