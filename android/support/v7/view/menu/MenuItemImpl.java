package android.support.v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v7.content.res.AppCompatResources;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public final class MenuItemImpl implements SupportMenuItem {
  static String sDeleteShortcutLabel;
  
  static String sEnterShortcutLabel;
  
  static String sPrependShortcutLabel;
  
  static String sSpaceShortcutLabel;
  
  public ActionProvider mActionProvider;
  
  private View mActionView;
  
  private final int mCategoryOrder;
  
  private MenuItem.OnMenuItemClickListener mClickListener;
  
  private CharSequence mContentDescription;
  
  int mFlags = 16;
  
  private final int mGroup;
  
  private boolean mHasIconTint = false;
  
  private boolean mHasIconTintMode = false;
  
  private Drawable mIconDrawable;
  
  private int mIconResId = 0;
  
  private ColorStateList mIconTintList = null;
  
  private PorterDuff.Mode mIconTintMode = null;
  
  private final int mId;
  
  private Intent mIntent;
  
  private boolean mIsActionViewExpanded = false;
  
  private Runnable mItemCallback;
  
  MenuBuilder mMenu;
  
  ContextMenu.ContextMenuInfo mMenuInfo;
  
  private boolean mNeedToApplyIconTint = false;
  
  private MenuItem.OnActionExpandListener mOnActionExpandListener;
  
  final int mOrdering;
  
  private char mShortcutAlphabeticChar;
  
  private int mShortcutAlphabeticModifiers = 4096;
  
  private char mShortcutNumericChar;
  
  private int mShortcutNumericModifiers = 4096;
  
  int mShowAsAction = 0;
  
  private SubMenuBuilder mSubMenu;
  
  private CharSequence mTitle;
  
  private CharSequence mTitleCondensed;
  
  private CharSequence mTooltipText;
  
  MenuItemImpl(MenuBuilder paramMenuBuilder, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5) {
    this.mMenu = paramMenuBuilder;
    this.mId = paramInt2;
    this.mGroup = paramInt1;
    this.mCategoryOrder = paramInt3;
    this.mOrdering = paramInt4;
    this.mTitle = paramCharSequence;
    this.mShowAsAction = paramInt5;
  }
  
  private Drawable applyIconTintIfNecessary(Drawable paramDrawable) {
    // Byte code:
    //   0: aload_1
    //   1: astore_2
    //   2: aload_1
    //   3: ifnull -> 74
    //   6: aload_1
    //   7: astore_2
    //   8: aload_0
    //   9: getfield mNeedToApplyIconTint : Z
    //   12: ifeq -> 74
    //   15: aload_0
    //   16: getfield mHasIconTint : Z
    //   19: ifne -> 31
    //   22: aload_1
    //   23: astore_2
    //   24: aload_0
    //   25: getfield mHasIconTintMode : Z
    //   28: ifeq -> 74
    //   31: aload_1
    //   32: invokestatic wrap : (Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;
    //   35: invokevirtual mutate : ()Landroid/graphics/drawable/Drawable;
    //   38: astore_2
    //   39: aload_0
    //   40: getfield mHasIconTint : Z
    //   43: ifeq -> 54
    //   46: aload_2
    //   47: aload_0
    //   48: getfield mIconTintList : Landroid/content/res/ColorStateList;
    //   51: invokestatic setTintList : (Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;)V
    //   54: aload_0
    //   55: getfield mHasIconTintMode : Z
    //   58: ifeq -> 69
    //   61: aload_2
    //   62: aload_0
    //   63: getfield mIconTintMode : Landroid/graphics/PorterDuff$Mode;
    //   66: invokestatic setTintMode : (Landroid/graphics/drawable/Drawable;Landroid/graphics/PorterDuff$Mode;)V
    //   69: aload_0
    //   70: iconst_0
    //   71: putfield mNeedToApplyIconTint : Z
    //   74: aload_2
    //   75: areturn
  }
  
  private SupportMenuItem setActionView(View paramView) {
    this.mActionView = paramView;
    this.mActionProvider = null;
    if (paramView != null && paramView.getId() == -1 && this.mId > 0)
      paramView.setId(this.mId); 
    this.mMenu.onItemActionRequestChanged$4da0fe86();
    return this;
  }
  
  private void setCheckedInt(boolean paramBoolean) {
    boolean bool;
    int i = this.mFlags;
    int j = this.mFlags;
    if (paramBoolean) {
      bool = true;
    } else {
      bool = false;
    } 
    this.mFlags = bool | j & 0xFFFFFFFD;
    if (i != this.mFlags)
      this.mMenu.onItemsChanged(false); 
  }
  
  public final boolean collapseActionView() {
    return ((this.mShowAsAction & 0x8) == 0) ? false : ((this.mActionView == null) ? true : ((this.mOnActionExpandListener == null || this.mOnActionExpandListener.onMenuItemActionCollapse((MenuItem)this)) ? this.mMenu.collapseItemActionView(this) : false));
  }
  
  public final boolean expandActionView() {
    return !hasCollapsibleActionView() ? false : ((this.mOnActionExpandListener == null || this.mOnActionExpandListener.onMenuItemActionExpand((MenuItem)this)) ? this.mMenu.expandItemActionView(this) : false);
  }
  
  public final ActionProvider getActionProvider() {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
  }
  
  public final View getActionView() {
    if (this.mActionView != null)
      return this.mActionView; 
    if (this.mActionProvider != null) {
      this.mActionView = this.mActionProvider.onCreateActionView();
      return this.mActionView;
    } 
    return null;
  }
  
  public final int getAlphabeticModifiers() {
    return this.mShortcutAlphabeticModifiers;
  }
  
  public final char getAlphabeticShortcut() {
    return this.mShortcutAlphabeticChar;
  }
  
  public final CharSequence getContentDescription() {
    return this.mContentDescription;
  }
  
  public final int getGroupId() {
    return this.mGroup;
  }
  
  public final Drawable getIcon() {
    if (this.mIconDrawable != null)
      return applyIconTintIfNecessary(this.mIconDrawable); 
    if (this.mIconResId != 0) {
      Drawable drawable = AppCompatResources.getDrawable(this.mMenu.mContext, this.mIconResId);
      this.mIconResId = 0;
      this.mIconDrawable = drawable;
      return applyIconTintIfNecessary(drawable);
    } 
    return null;
  }
  
  public final ColorStateList getIconTintList() {
    return this.mIconTintList;
  }
  
  public final PorterDuff.Mode getIconTintMode() {
    return this.mIconTintMode;
  }
  
  public final Intent getIntent() {
    return this.mIntent;
  }
  
  @CapturedViewProperty
  public final int getItemId() {
    return this.mId;
  }
  
  public final ContextMenu.ContextMenuInfo getMenuInfo() {
    return this.mMenuInfo;
  }
  
  public final int getNumericModifiers() {
    return this.mShortcutNumericModifiers;
  }
  
  public final char getNumericShortcut() {
    return this.mShortcutNumericChar;
  }
  
  public final int getOrder() {
    return this.mCategoryOrder;
  }
  
  final char getShortcut() {
    return this.mMenu.isQwertyMode() ? this.mShortcutAlphabeticChar : this.mShortcutNumericChar;
  }
  
  public final SubMenu getSubMenu() {
    return this.mSubMenu;
  }
  
  @CapturedViewProperty
  public final CharSequence getTitle() {
    return this.mTitle;
  }
  
  public final CharSequence getTitleCondensed() {
    CharSequence charSequence;
    if (this.mTitleCondensed != null) {
      charSequence = this.mTitleCondensed;
    } else {
      charSequence = this.mTitle;
    } 
    return (Build.VERSION.SDK_INT < 18 && charSequence != null && !(charSequence instanceof String)) ? charSequence.toString() : charSequence;
  }
  
  final CharSequence getTitleForItemView(MenuView$ItemView paramMenuView$ItemView) {
    return (paramMenuView$ItemView != null && paramMenuView$ItemView.prefersCondensedTitle()) ? getTitleCondensed() : getTitle();
  }
  
  public final CharSequence getTooltipText() {
    return this.mTooltipText;
  }
  
  public final boolean hasCollapsibleActionView() {
    if ((this.mShowAsAction & 0x8) != 0) {
      if (this.mActionView == null && this.mActionProvider != null)
        this.mActionView = this.mActionProvider.onCreateActionView(); 
      return (this.mActionView != null);
    } 
    return false;
  }
  
  public final boolean hasSubMenu() {
    return (this.mSubMenu != null);
  }
  
  public final boolean invoke() {
    if (this.mClickListener != null && this.mClickListener.onMenuItemClick((MenuItem)this))
      return true; 
    if (this.mMenu.dispatchMenuItemSelected(this.mMenu, (MenuItem)this))
      return true; 
    if (this.mItemCallback != null) {
      this.mItemCallback.run();
      return true;
    } 
    if (this.mIntent != null)
      try {
        this.mMenu.mContext.startActivity(this.mIntent);
        return true;
      } catch (ActivityNotFoundException activityNotFoundException) {
        Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", (Throwable)activityNotFoundException);
      }  
    return false;
  }
  
  public final boolean isActionButton() {
    return ((this.mFlags & 0x20) == 32);
  }
  
  public final boolean isActionViewExpanded() {
    return this.mIsActionViewExpanded;
  }
  
  public final boolean isCheckable() {
    return ((this.mFlags & 0x1) == 1);
  }
  
  public final boolean isChecked() {
    return ((this.mFlags & 0x2) == 2);
  }
  
  public final boolean isEnabled() {
    return ((this.mFlags & 0x10) != 0);
  }
  
  public final boolean isExclusiveCheckable() {
    return ((this.mFlags & 0x4) != 0);
  }
  
  public final boolean isVisible() {
    return ((this.mFlags & 0x8) == 0);
  }
  
  public final boolean requestsActionButton() {
    return ((this.mShowAsAction & 0x1) == 1);
  }
  
  public final boolean requiresActionButton() {
    return ((this.mShowAsAction & 0x2) == 2);
  }
  
  public final MenuItem setActionProvider(ActionProvider paramActionProvider) {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
  }
  
  public final void setActionViewExpanded(boolean paramBoolean) {
    this.mIsActionViewExpanded = paramBoolean;
    this.mMenu.onItemsChanged(false);
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar) {
    if (this.mShortcutAlphabeticChar == paramChar)
      return (MenuItem)this; 
    this.mShortcutAlphabeticChar = Character.toLowerCase(paramChar);
    this.mMenu.onItemsChanged(false);
    return (MenuItem)this;
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar, int paramInt) {
    if (this.mShortcutAlphabeticChar == paramChar && this.mShortcutAlphabeticModifiers == paramInt)
      return (MenuItem)this; 
    this.mShortcutAlphabeticChar = Character.toLowerCase(paramChar);
    this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(paramInt);
    this.mMenu.onItemsChanged(false);
    return (MenuItem)this;
  }
  
  public final MenuItem setCheckable(boolean paramBoolean) {
    int i = this.mFlags;
    this.mFlags = paramBoolean | this.mFlags & 0xFFFFFFFE;
    if (i != this.mFlags)
      this.mMenu.onItemsChanged(false); 
    return (MenuItem)this;
  }
  
  public final MenuItem setChecked(boolean paramBoolean) {
    if ((this.mFlags & 0x4) != 0) {
      MenuBuilder menuBuilder = this.mMenu;
      int j = super.getGroupId();
      int k = menuBuilder.mItems.size();
      menuBuilder.stopDispatchingItemsChanged();
      for (int i = 0; i < k; i++) {
        MenuItemImpl menuItemImpl = menuBuilder.mItems.get(i);
        if (menuItemImpl.getGroupId() == j && menuItemImpl.isExclusiveCheckable() && menuItemImpl.isCheckable()) {
          if (menuItemImpl == this) {
            paramBoolean = true;
          } else {
            paramBoolean = false;
          } 
          menuItemImpl.setCheckedInt(paramBoolean);
        } 
      } 
      menuBuilder.startDispatchingItemsChanged();
      return (MenuItem)this;
    } 
    setCheckedInt(paramBoolean);
    return (MenuItem)this;
  }
  
  public final MenuItem setEnabled(boolean paramBoolean) {
    if (paramBoolean) {
      this.mFlags |= 0x10;
    } else {
      this.mFlags &= 0xFFFFFFEF;
    } 
    this.mMenu.onItemsChanged(false);
    return (MenuItem)this;
  }
  
  public final MenuItem setIcon(int paramInt) {
    this.mIconDrawable = null;
    this.mIconResId = paramInt;
    this.mNeedToApplyIconTint = true;
    this.mMenu.onItemsChanged(false);
    return (MenuItem)this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable) {
    this.mIconResId = 0;
    this.mIconDrawable = paramDrawable;
    this.mNeedToApplyIconTint = true;
    this.mMenu.onItemsChanged(false);
    return (MenuItem)this;
  }
  
  public final MenuItem setIconTintList(ColorStateList paramColorStateList) {
    this.mIconTintList = paramColorStateList;
    this.mHasIconTint = true;
    this.mNeedToApplyIconTint = true;
    this.mMenu.onItemsChanged(false);
    return (MenuItem)this;
  }
  
  public final MenuItem setIconTintMode(PorterDuff.Mode paramMode) {
    this.mIconTintMode = paramMode;
    this.mHasIconTintMode = true;
    this.mNeedToApplyIconTint = true;
    this.mMenu.onItemsChanged(false);
    return (MenuItem)this;
  }
  
  public final MenuItem setIntent(Intent paramIntent) {
    this.mIntent = paramIntent;
    return (MenuItem)this;
  }
  
  public final void setIsActionButton(boolean paramBoolean) {
    if (paramBoolean) {
      this.mFlags |= 0x20;
      return;
    } 
    this.mFlags &= 0xFFFFFFDF;
  }
  
  public final MenuItem setNumericShortcut(char paramChar) {
    if (this.mShortcutNumericChar == paramChar)
      return (MenuItem)this; 
    this.mShortcutNumericChar = paramChar;
    this.mMenu.onItemsChanged(false);
    return (MenuItem)this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar, int paramInt) {
    if (this.mShortcutNumericChar == paramChar && this.mShortcutNumericModifiers == paramInt)
      return (MenuItem)this; 
    this.mShortcutNumericChar = paramChar;
    this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(paramInt);
    this.mMenu.onItemsChanged(false);
    return (MenuItem)this;
  }
  
  public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener) {
    this.mOnActionExpandListener = paramOnActionExpandListener;
    return (MenuItem)this;
  }
  
  public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener) {
    this.mClickListener = paramOnMenuItemClickListener;
    return (MenuItem)this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2) {
    this.mShortcutNumericChar = paramChar1;
    this.mShortcutAlphabeticChar = Character.toLowerCase(paramChar2);
    this.mMenu.onItemsChanged(false);
    return (MenuItem)this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2) {
    this.mShortcutNumericChar = paramChar1;
    this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(paramInt1);
    this.mShortcutAlphabeticChar = Character.toLowerCase(paramChar2);
    this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(paramInt2);
    this.mMenu.onItemsChanged(false);
    return (MenuItem)this;
  }
  
  public final void setShowAsAction(int paramInt) {
    switch (paramInt & 0x3) {
      default:
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
      case 0:
      case 1:
      case 2:
        break;
    } 
    this.mShowAsAction = paramInt;
    this.mMenu.onItemActionRequestChanged$4da0fe86();
  }
  
  public final void setSubMenu(SubMenuBuilder paramSubMenuBuilder) {
    this.mSubMenu = paramSubMenuBuilder;
    paramSubMenuBuilder.setHeaderTitle(getTitle());
  }
  
  public final MenuItem setTitle(int paramInt) {
    return setTitle(this.mMenu.mContext.getString(paramInt));
  }
  
  public final MenuItem setTitle(CharSequence paramCharSequence) {
    this.mTitle = paramCharSequence;
    this.mMenu.onItemsChanged(false);
    if (this.mSubMenu != null)
      this.mSubMenu.setHeaderTitle(paramCharSequence); 
    return (MenuItem)this;
  }
  
  public final MenuItem setTitleCondensed(CharSequence paramCharSequence) {
    this.mTitleCondensed = paramCharSequence;
    this.mMenu.onItemsChanged(false);
    return (MenuItem)this;
  }
  
  public final MenuItem setVisible(boolean paramBoolean) {
    if (setVisibleInt(paramBoolean)) {
      MenuBuilder menuBuilder = this.mMenu;
      menuBuilder.mIsVisibleItemsStale = true;
      menuBuilder.onItemsChanged(true);
    } 
    return (MenuItem)this;
  }
  
  final boolean setVisibleInt(boolean paramBoolean) {
    byte b;
    int i = this.mFlags;
    int j = this.mFlags;
    if (paramBoolean) {
      b = 0;
    } else {
      b = 8;
    } 
    this.mFlags = b | j & 0xFFFFFFF7;
    return (i != this.mFlags);
  }
  
  final boolean shouldShowShortcut() {
    return (this.mMenu.isShortcutsVisible() && getShortcut() != '\000');
  }
  
  public final String toString() {
    return (this.mTitle != null) ? this.mTitle.toString() : null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\view\menu\MenuItemImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */