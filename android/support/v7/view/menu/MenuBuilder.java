package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.support.v4.internal.view.SupportMenu;
import android.support.v7.appcompat.R;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MenuBuilder implements SupportMenu {
  private static final int[] sCategoryToOrder = new int[] { 1, 4, 5, 3, 2, 0 };
  
  public ArrayList mActionItems;
  
  private MenuBuilder$Callback mCallback;
  
  final Context mContext;
  
  private ContextMenu.ContextMenuInfo mCurrentMenuInfo;
  
  private int mDefaultShowAsAction = 0;
  
  MenuItemImpl mExpandedItem;
  
  CharSequence mHeaderTitle;
  
  private boolean mIsActionItemsStale;
  
  private boolean mIsClosing = false;
  
  boolean mIsVisibleItemsStale;
  
  ArrayList mItems;
  
  private boolean mItemsChangedWhileDispatchPrevented = false;
  
  private ArrayList mNonActionItems;
  
  boolean mOptionalIconsVisible = false;
  
  private boolean mOverrideVisibleItems;
  
  CopyOnWriteArrayList mPresenters = new CopyOnWriteArrayList();
  
  private boolean mPreventDispatchingItemsChanged = false;
  
  private boolean mQwertyMode;
  
  private final Resources mResources;
  
  private boolean mShortcutsVisible;
  
  private boolean mStructureChangedWhileDispatchPrevented = false;
  
  private ArrayList mTempShortcutItemList = new ArrayList();
  
  private ArrayList mVisibleItems;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public MenuBuilder(Context paramContext) {
    this.mContext = paramContext;
    this.mResources = paramContext.getResources();
    this.mItems = new ArrayList();
    this.mVisibleItems = new ArrayList();
    boolean bool = true;
    this.mIsVisibleItemsStale = true;
    this.mActionItems = new ArrayList();
    this.mNonActionItems = new ArrayList();
    this.mIsActionItemsStale = true;
    if ((this.mResources.getConfiguration()).keyboard == 1 || !this.mResources.getBoolean(R.bool.abc_config_showMenuShortcutsWhenKeyboardPresent))
      bool = false; 
    this.mShortcutsVisible = bool;
  }
  
  private MenuItem addInternal(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence) {
    int i = paramInt3 >> 16;
    if (i >= 0 && i < sCategoryToOrder.length) {
      i = sCategoryToOrder[i] << 16 | 0xFFFF & paramInt3;
      MenuItemImpl menuItemImpl = new MenuItemImpl(this, paramInt1, paramInt2, paramInt3, i, paramCharSequence, this.mDefaultShowAsAction);
      if (this.mCurrentMenuInfo != null)
        menuItemImpl.mMenuInfo = this.mCurrentMenuInfo; 
      this.mItems.add(findInsertIndex(this.mItems, i), menuItemImpl);
      onItemsChanged(true);
      return (MenuItem)menuItemImpl;
    } 
    throw new IllegalArgumentException("order does not contain a valid category.");
  }
  
  private static int findInsertIndex(ArrayList paramArrayList, int paramInt) {
    for (int i = paramArrayList.size() - 1; i >= 0; i--) {
      if (((MenuItemImpl)paramArrayList.get(i)).mOrdering <= paramInt)
        return i + 1; 
    } 
    return 0;
  }
  
  private MenuItemImpl findItemWithShortcutForKey(int paramInt, KeyEvent paramKeyEvent) {
    ArrayList<MenuItemImpl> arrayList = this.mTempShortcutItemList;
    arrayList.clear();
    findItemsWithShortcutForKey(arrayList, paramInt, paramKeyEvent);
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
  
  private void findItemsWithShortcutForKey(List<MenuItemImpl> paramList, int paramInt, KeyEvent paramKeyEvent) {
    boolean bool = isQwertyMode();
    int j = paramKeyEvent.getModifiers();
    KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
    if (!paramKeyEvent.getKeyData(keyData) && paramInt != 67)
      return; 
    int k = this.mItems.size();
    int i;
    for (i = 0; i < k; i++) {
      char c;
      int m;
      MenuItemImpl menuItemImpl = this.mItems.get(i);
      if (menuItemImpl.hasSubMenu())
        ((MenuBuilder)menuItemImpl.getSubMenu()).findItemsWithShortcutForKey(paramList, paramInt, paramKeyEvent); 
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
  
  private void removeItemAtInt(int paramInt, boolean paramBoolean) {
    if (paramInt >= 0) {
      if (paramInt >= this.mItems.size())
        return; 
      this.mItems.remove(paramInt);
      if (paramBoolean)
        onItemsChanged(true); 
      return;
    } 
  }
  
  public MenuItem add(int paramInt) {
    return addInternal(0, 0, 0, this.mResources.getString(paramInt));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return addInternal(paramInt1, paramInt2, paramInt3, this.mResources.getString(paramInt4));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence) {
    return addInternal(paramInt1, paramInt2, paramInt3, paramCharSequence);
  }
  
  public MenuItem add(CharSequence paramCharSequence) {
    return addInternal(0, 0, 0, paramCharSequence);
  }
  
  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem) {
    byte b1;
    PackageManager packageManager = this.mContext.getPackageManager();
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
  
  public final void addMenuPresenter(MenuPresenter paramMenuPresenter, Context paramContext) {
    this.mPresenters.add(new WeakReference<MenuPresenter>(paramMenuPresenter));
    paramMenuPresenter.initForMenu(paramContext, this);
    this.mIsActionItemsStale = true;
  }
  
  public SubMenu addSubMenu(int paramInt) {
    return addSubMenu(0, 0, 0, this.mResources.getString(paramInt));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return addSubMenu(paramInt1, paramInt2, paramInt3, this.mResources.getString(paramInt4));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence) {
    MenuItemImpl menuItemImpl = (MenuItemImpl)addInternal(paramInt1, paramInt2, paramInt3, paramCharSequence);
    SubMenuBuilder subMenuBuilder = new SubMenuBuilder(this.mContext, this, menuItemImpl);
    menuItemImpl.setSubMenu(subMenuBuilder);
    return subMenuBuilder;
  }
  
  public SubMenu addSubMenu(CharSequence paramCharSequence) {
    return addSubMenu(0, 0, 0, paramCharSequence);
  }
  
  public void clear() {
    if (this.mExpandedItem != null)
      collapseItemActionView(this.mExpandedItem); 
    this.mItems.clear();
    onItemsChanged(true);
  }
  
  public void clearHeader() {
    this.mHeaderTitle = null;
    onItemsChanged(false);
  }
  
  public void close() {
    close(true);
  }
  
  public final void close(boolean paramBoolean) {
    if (this.mIsClosing)
      return; 
    this.mIsClosing = true;
    for (WeakReference<MenuPresenter> weakReference : (Iterable<WeakReference<MenuPresenter>>)this.mPresenters) {
      MenuPresenter menuPresenter = weakReference.get();
      if (menuPresenter == null) {
        this.mPresenters.remove(weakReference);
        continue;
      } 
      menuPresenter.onCloseMenu(this, paramBoolean);
    } 
    this.mIsClosing = false;
  }
  
  public boolean collapseItemActionView(MenuItemImpl paramMenuItemImpl) {
    boolean bool2 = this.mPresenters.isEmpty();
    boolean bool1 = false;
    if (!bool2) {
      if (this.mExpandedItem != paramMenuItemImpl)
        return false; 
      stopDispatchingItemsChanged();
      Iterator<WeakReference> iterator = this.mPresenters.iterator();
      while (true) {
        bool2 = bool1;
        if (iterator.hasNext()) {
          WeakReference<MenuPresenter> weakReference = iterator.next();
          MenuPresenter menuPresenter = weakReference.get();
          if (menuPresenter == null) {
            this.mPresenters.remove(weakReference);
            continue;
          } 
          bool2 = menuPresenter.collapseItemActionView$5c2da31d(paramMenuItemImpl);
          bool1 = bool2;
          if (bool2)
            break; 
          continue;
        } 
        break;
      } 
      startDispatchingItemsChanged();
      if (bool2)
        this.mExpandedItem = null; 
      return bool2;
    } 
    return false;
  }
  
  boolean dispatchMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem) {
    return (this.mCallback != null && this.mCallback.onMenuItemSelected$6cb56673());
  }
  
  public boolean expandItemActionView(MenuItemImpl paramMenuItemImpl) {
    boolean bool2 = this.mPresenters.isEmpty();
    boolean bool1 = false;
    if (bool2)
      return false; 
    stopDispatchingItemsChanged();
    Iterator<WeakReference> iterator = this.mPresenters.iterator();
    while (true) {
      bool2 = bool1;
      if (iterator.hasNext()) {
        WeakReference<MenuPresenter> weakReference = iterator.next();
        MenuPresenter menuPresenter = weakReference.get();
        if (menuPresenter == null) {
          this.mPresenters.remove(weakReference);
          continue;
        } 
        bool2 = menuPresenter.expandItemActionView$5c2da31d(paramMenuItemImpl);
        bool1 = bool2;
        if (bool2)
          break; 
        continue;
      } 
      break;
    } 
    startDispatchingItemsChanged();
    if (bool2)
      this.mExpandedItem = paramMenuItemImpl; 
    return bool2;
  }
  
  public MenuItem findItem(int paramInt) {
    int j = size();
    for (int i = 0; i < j; i++) {
      MenuItemImpl menuItemImpl = this.mItems.get(i);
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
  
  public final void flagActionItems() {
    ArrayList<MenuItemImpl> arrayList = getVisibleItems();
    if (!this.mIsActionItemsStale)
      return; 
    Iterator<WeakReference> iterator = this.mPresenters.iterator();
    boolean bool;
    for (bool = false; iterator.hasNext(); bool |= menuPresenter.flagActionItems()) {
      WeakReference<MenuPresenter> weakReference = iterator.next();
      MenuPresenter menuPresenter = weakReference.get();
      if (menuPresenter == null) {
        this.mPresenters.remove(weakReference);
        continue;
      } 
    } 
    if (bool) {
      this.mActionItems.clear();
      this.mNonActionItems.clear();
      int i = arrayList.size();
      bool = false;
      while (bool < i) {
        MenuItemImpl menuItemImpl = arrayList.get(bool);
        if (menuItemImpl.isActionButton()) {
          this.mActionItems.add(menuItemImpl);
        } else {
          this.mNonActionItems.add(menuItemImpl);
        } 
        int j = bool + 1;
      } 
    } else {
      this.mActionItems.clear();
      this.mNonActionItems.clear();
      this.mNonActionItems.addAll(getVisibleItems());
    } 
    this.mIsActionItemsStale = false;
  }
  
  public MenuItem getItem(int paramInt) {
    return this.mItems.get(paramInt);
  }
  
  public final ArrayList getNonActionItems() {
    flagActionItems();
    return this.mNonActionItems;
  }
  
  public MenuBuilder getRootMenu() {
    return this;
  }
  
  public final ArrayList getVisibleItems() {
    if (!this.mIsVisibleItemsStale)
      return this.mVisibleItems; 
    this.mVisibleItems.clear();
    int j = this.mItems.size();
    for (int i = 0; i < j; i++) {
      MenuItemImpl menuItemImpl = this.mItems.get(i);
      if (menuItemImpl.isVisible())
        this.mVisibleItems.add(menuItemImpl); 
    } 
    this.mIsVisibleItemsStale = false;
    this.mIsActionItemsStale = true;
    return this.mVisibleItems;
  }
  
  public boolean hasVisibleItems() {
    if (this.mOverrideVisibleItems)
      return true; 
    int j = size();
    for (int i = 0; i < j; i++) {
      if (((MenuItemImpl)this.mItems.get(i)).isVisible())
        return true; 
    } 
    return false;
  }
  
  boolean isQwertyMode() {
    return this.mQwertyMode;
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent) {
    return (findItemWithShortcutForKey(paramInt, paramKeyEvent) != null);
  }
  
  public boolean isShortcutsVisible() {
    return this.mShortcutsVisible;
  }
  
  final void onItemActionRequestChanged$4da0fe86() {
    this.mIsActionItemsStale = true;
    onItemsChanged(true);
  }
  
  public final void onItemsChanged(boolean paramBoolean) {
    if (!this.mPreventDispatchingItemsChanged) {
      if (paramBoolean) {
        this.mIsVisibleItemsStale = true;
        this.mIsActionItemsStale = true;
      } 
      if (!this.mPresenters.isEmpty()) {
        stopDispatchingItemsChanged();
        for (WeakReference<MenuPresenter> weakReference : (Iterable<WeakReference<MenuPresenter>>)this.mPresenters) {
          MenuPresenter menuPresenter = weakReference.get();
          if (menuPresenter == null) {
            this.mPresenters.remove(weakReference);
            continue;
          } 
          menuPresenter.updateMenuView(paramBoolean);
        } 
        startDispatchingItemsChanged();
      } 
      return;
    } 
    this.mItemsChangedWhileDispatchPrevented = true;
    if (paramBoolean)
      this.mStructureChangedWhileDispatchPrevented = true; 
  }
  
  public boolean performIdentifierAction(int paramInt1, int paramInt2) {
    return performItemAction(findItem(paramInt1), null, paramInt2);
  }
  
  public final boolean performItemAction(MenuItem paramMenuItem, MenuPresenter paramMenuPresenter, int paramInt) {
    MenuItemImpl menuItemImpl = (MenuItemImpl)paramMenuItem;
    boolean bool2 = false;
    boolean bool1 = false;
    if (menuItemImpl != null) {
      if (!menuItemImpl.isEnabled())
        return false; 
      boolean bool = menuItemImpl.invoke();
      if (menuItemImpl.hasCollapsibleActionView()) {
        bool2 = bool | menuItemImpl.expandActionView();
        bool1 = bool2;
        if (bool2) {
          close(true);
          return bool2;
        } 
      } else {
        if (menuItemImpl.hasSubMenu()) {
          if ((paramInt & 0x4) == 0)
            close(false); 
          if (!menuItemImpl.hasSubMenu())
            menuItemImpl.setSubMenu(new SubMenuBuilder(this.mContext, this, menuItemImpl)); 
          SubMenuBuilder subMenuBuilder = (SubMenuBuilder)menuItemImpl.getSubMenu();
          if (this.mPresenters.isEmpty()) {
            bool1 = bool2;
          } else {
            if (paramMenuPresenter != null)
              bool1 = paramMenuPresenter.onSubMenuSelected(subMenuBuilder); 
            for (WeakReference<MenuPresenter> weakReference : (Iterable<WeakReference<MenuPresenter>>)this.mPresenters) {
              MenuPresenter menuPresenter = weakReference.get();
              if (menuPresenter == null) {
                this.mPresenters.remove(weakReference);
                continue;
              } 
              bool2 = bool1;
              if (!bool1)
                bool2 = menuPresenter.onSubMenuSelected(subMenuBuilder); 
              bool1 = bool2;
            } 
          } 
          bool1 = bool | bool1;
          if (!bool1)
            close(true); 
          return bool1;
        } 
        bool1 = bool;
        if ((paramInt & 0x1) == 0) {
          close(true);
          bool1 = bool;
        } 
      } 
      return bool1;
    } 
    return false;
  }
  
  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2) {
    boolean bool;
    MenuItemImpl menuItemImpl = findItemWithShortcutForKey(paramInt1, paramKeyEvent);
    if (menuItemImpl != null) {
      bool = performItemAction((MenuItem)menuItemImpl, null, paramInt2);
    } else {
      bool = false;
    } 
    if ((paramInt2 & 0x2) != 0)
      close(true); 
    return bool;
  }
  
  public void removeGroup(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual size : ()I
    //   4: istore_3
    //   5: iconst_0
    //   6: istore_2
    //   7: iload_2
    //   8: iload_3
    //   9: if_icmpge -> 40
    //   12: aload_0
    //   13: getfield mItems : Ljava/util/ArrayList;
    //   16: iload_2
    //   17: invokevirtual get : (I)Ljava/lang/Object;
    //   20: checkcast android/support/v7/view/menu/MenuItemImpl
    //   23: invokevirtual getGroupId : ()I
    //   26: iload_1
    //   27: if_icmpne -> 33
    //   30: goto -> 42
    //   33: iload_2
    //   34: iconst_1
    //   35: iadd
    //   36: istore_2
    //   37: goto -> 7
    //   40: iconst_m1
    //   41: istore_2
    //   42: iload_2
    //   43: iflt -> 101
    //   46: aload_0
    //   47: getfield mItems : Ljava/util/ArrayList;
    //   50: invokevirtual size : ()I
    //   53: istore #4
    //   55: iconst_0
    //   56: istore_3
    //   57: iload_3
    //   58: iload #4
    //   60: iload_2
    //   61: isub
    //   62: if_icmpge -> 96
    //   65: aload_0
    //   66: getfield mItems : Ljava/util/ArrayList;
    //   69: iload_2
    //   70: invokevirtual get : (I)Ljava/lang/Object;
    //   73: checkcast android/support/v7/view/menu/MenuItemImpl
    //   76: invokevirtual getGroupId : ()I
    //   79: iload_1
    //   80: if_icmpne -> 96
    //   83: aload_0
    //   84: iload_2
    //   85: iconst_0
    //   86: invokespecial removeItemAtInt : (IZ)V
    //   89: iload_3
    //   90: iconst_1
    //   91: iadd
    //   92: istore_3
    //   93: goto -> 57
    //   96: aload_0
    //   97: iconst_1
    //   98: invokevirtual onItemsChanged : (Z)V
    //   101: return
  }
  
  public void removeItem(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual size : ()I
    //   4: istore_3
    //   5: iconst_0
    //   6: istore_2
    //   7: iload_2
    //   8: iload_3
    //   9: if_icmpge -> 40
    //   12: aload_0
    //   13: getfield mItems : Ljava/util/ArrayList;
    //   16: iload_2
    //   17: invokevirtual get : (I)Ljava/lang/Object;
    //   20: checkcast android/support/v7/view/menu/MenuItemImpl
    //   23: invokevirtual getItemId : ()I
    //   26: iload_1
    //   27: if_icmpne -> 33
    //   30: goto -> 42
    //   33: iload_2
    //   34: iconst_1
    //   35: iadd
    //   36: istore_2
    //   37: goto -> 7
    //   40: iconst_m1
    //   41: istore_2
    //   42: aload_0
    //   43: iload_2
    //   44: iconst_1
    //   45: invokespecial removeItemAtInt : (IZ)V
    //   48: return
  }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
    int j = this.mItems.size();
    int i;
    for (i = 0; i < j; i++) {
      MenuItemImpl menuItemImpl = this.mItems.get(i);
      if (menuItemImpl.getGroupId() == paramInt) {
        boolean bool;
        int k = menuItemImpl.mFlags;
        if (paramBoolean2) {
          bool = true;
        } else {
          bool = false;
        } 
        menuItemImpl.mFlags = k & 0xFFFFFFFB | bool;
        menuItemImpl.setCheckable(paramBoolean1);
      } 
    } 
  }
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean) {
    int j = this.mItems.size();
    for (int i = 0; i < j; i++) {
      MenuItemImpl menuItemImpl = this.mItems.get(i);
      if (menuItemImpl.getGroupId() == paramInt)
        menuItemImpl.setEnabled(paramBoolean); 
    } 
  }
  
  public void setGroupVisible(int paramInt, boolean paramBoolean) {
    int j = this.mItems.size();
    int i = 0;
    boolean bool;
    for (bool = false; i < j; bool = bool1) {
      MenuItemImpl menuItemImpl = this.mItems.get(i);
      boolean bool1 = bool;
      if (menuItemImpl.getGroupId() == paramInt) {
        bool1 = bool;
        if (menuItemImpl.setVisibleInt(paramBoolean))
          bool1 = true; 
      } 
      i++;
    } 
    if (bool)
      onItemsChanged(true); 
  }
  
  final void setHeaderInternal$6c64639d(int paramInt1, CharSequence paramCharSequence, int paramInt2, View paramView) {
    Resources resources = this.mResources;
    if (paramView != null) {
      this.mHeaderTitle = null;
    } else {
      if (paramInt1 > 0) {
        this.mHeaderTitle = resources.getText(paramInt1);
      } else if (paramCharSequence != null) {
        this.mHeaderTitle = paramCharSequence;
      } 
      if (paramInt2 > 0)
        ContextCompat.getDrawable(this.mContext, paramInt2); 
    } 
    onItemsChanged(false);
  }
  
  public void setQwertyMode(boolean paramBoolean) {
    this.mQwertyMode = paramBoolean;
    onItemsChanged(false);
  }
  
  public int size() {
    return this.mItems.size();
  }
  
  public final void startDispatchingItemsChanged() {
    this.mPreventDispatchingItemsChanged = false;
    if (this.mItemsChangedWhileDispatchPrevented) {
      this.mItemsChangedWhileDispatchPrevented = false;
      onItemsChanged(this.mStructureChangedWhileDispatchPrevented);
    } 
  }
  
  public final void stopDispatchingItemsChanged() {
    if (!this.mPreventDispatchingItemsChanged) {
      this.mPreventDispatchingItemsChanged = true;
      this.mItemsChangedWhileDispatchPrevented = false;
      this.mStructureChangedWhileDispatchPrevented = false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\view\menu\MenuBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */