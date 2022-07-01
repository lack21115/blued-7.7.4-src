package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.internal.view.SupportMenuItem;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public final class ActionMenuItem implements SupportMenuItem {
  private CharSequence mContentDescription;
  
  private Context mContext;
  
  private int mFlags = 16;
  
  private final int mGroup;
  
  private boolean mHasIconTint = false;
  
  private boolean mHasIconTintMode = false;
  
  private Drawable mIconDrawable;
  
  private ColorStateList mIconTintList = null;
  
  private PorterDuff.Mode mIconTintMode = null;
  
  private final int mId;
  
  private Intent mIntent;
  
  private final int mOrdering;
  
  private char mShortcutAlphabeticChar;
  
  private int mShortcutAlphabeticModifiers = 4096;
  
  private char mShortcutNumericChar;
  
  private int mShortcutNumericModifiers = 4096;
  
  private CharSequence mTitle;
  
  private CharSequence mTitleCondensed;
  
  private CharSequence mTooltipText;
  
  public ActionMenuItem(Context paramContext, int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence) {
    this.mContext = paramContext;
    this.mId = paramInt2;
    this.mGroup = paramInt1;
    this.mOrdering = paramInt3;
    this.mTitle = paramCharSequence;
  }
  
  private void applyIconTint() {
    if (this.mIconDrawable != null && (this.mHasIconTint || this.mHasIconTintMode)) {
      this.mIconDrawable = DrawableCompat.wrap(this.mIconDrawable);
      this.mIconDrawable = this.mIconDrawable.mutate();
      if (this.mHasIconTint)
        DrawableCompat.setTintList(this.mIconDrawable, this.mIconTintList); 
      if (this.mHasIconTintMode)
        DrawableCompat.setTintMode(this.mIconDrawable, this.mIconTintMode); 
    } 
  }
  
  public final boolean collapseActionView() {
    return false;
  }
  
  public final boolean expandActionView() {
    return false;
  }
  
  public final ActionProvider getActionProvider() {
    throw new UnsupportedOperationException();
  }
  
  public final View getActionView() {
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
    return this.mIconDrawable;
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
  
  public final int getItemId() {
    return this.mId;
  }
  
  public final ContextMenu.ContextMenuInfo getMenuInfo() {
    return null;
  }
  
  public final int getNumericModifiers() {
    return this.mShortcutNumericModifiers;
  }
  
  public final char getNumericShortcut() {
    return this.mShortcutNumericChar;
  }
  
  public final int getOrder() {
    return this.mOrdering;
  }
  
  public final SubMenu getSubMenu() {
    return null;
  }
  
  public final CharSequence getTitle() {
    return this.mTitle;
  }
  
  public final CharSequence getTitleCondensed() {
    return (this.mTitleCondensed != null) ? this.mTitleCondensed : this.mTitle;
  }
  
  public final CharSequence getTooltipText() {
    return this.mTooltipText;
  }
  
  public final boolean hasSubMenu() {
    return false;
  }
  
  public final boolean isActionViewExpanded() {
    return false;
  }
  
  public final boolean isCheckable() {
    return ((this.mFlags & 0x1) != 0);
  }
  
  public final boolean isChecked() {
    return ((this.mFlags & 0x2) != 0);
  }
  
  public final boolean isEnabled() {
    return ((this.mFlags & 0x10) != 0);
  }
  
  public final boolean isVisible() {
    return ((this.mFlags & 0x8) == 0);
  }
  
  public final MenuItem setActionProvider(ActionProvider paramActionProvider) {
    throw new UnsupportedOperationException();
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar) {
    this.mShortcutAlphabeticChar = Character.toLowerCase(paramChar);
    return (MenuItem)this;
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar, int paramInt) {
    this.mShortcutAlphabeticChar = Character.toLowerCase(paramChar);
    this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(paramInt);
    return (MenuItem)this;
  }
  
  public final MenuItem setCheckable(boolean paramBoolean) {
    this.mFlags = paramBoolean | this.mFlags & 0xFFFFFFFE;
    return (MenuItem)this;
  }
  
  public final MenuItem setChecked(boolean paramBoolean) {
    boolean bool;
    int i = this.mFlags;
    if (paramBoolean) {
      bool = true;
    } else {
      bool = false;
    } 
    this.mFlags = bool | i & 0xFFFFFFFD;
    return (MenuItem)this;
  }
  
  public final MenuItem setEnabled(boolean paramBoolean) {
    boolean bool;
    int i = this.mFlags;
    if (paramBoolean) {
      bool = true;
    } else {
      bool = false;
    } 
    this.mFlags = bool | i & 0xFFFFFFEF;
    return (MenuItem)this;
  }
  
  public final MenuItem setIcon(int paramInt) {
    this.mIconDrawable = ContextCompat.getDrawable(this.mContext, paramInt);
    applyIconTint();
    return (MenuItem)this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable) {
    this.mIconDrawable = paramDrawable;
    applyIconTint();
    return (MenuItem)this;
  }
  
  public final MenuItem setIconTintList(ColorStateList paramColorStateList) {
    this.mIconTintList = paramColorStateList;
    this.mHasIconTint = true;
    applyIconTint();
    return (MenuItem)this;
  }
  
  public final MenuItem setIconTintMode(PorterDuff.Mode paramMode) {
    this.mIconTintMode = paramMode;
    this.mHasIconTintMode = true;
    applyIconTint();
    return (MenuItem)this;
  }
  
  public final MenuItem setIntent(Intent paramIntent) {
    this.mIntent = paramIntent;
    return (MenuItem)this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar) {
    this.mShortcutNumericChar = paramChar;
    return (MenuItem)this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar, int paramInt) {
    this.mShortcutNumericChar = paramChar;
    this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(paramInt);
    return (MenuItem)this;
  }
  
  public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener) {
    throw new UnsupportedOperationException();
  }
  
  public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener) {
    return (MenuItem)this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2) {
    this.mShortcutNumericChar = paramChar1;
    this.mShortcutAlphabeticChar = Character.toLowerCase(paramChar2);
    return (MenuItem)this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2) {
    this.mShortcutNumericChar = paramChar1;
    this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(paramInt1);
    this.mShortcutAlphabeticChar = Character.toLowerCase(paramChar2);
    this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(paramInt2);
    return (MenuItem)this;
  }
  
  public final void setShowAsAction(int paramInt) {}
  
  public final MenuItem setTitle(int paramInt) {
    this.mTitle = this.mContext.getResources().getString(paramInt);
    return (MenuItem)this;
  }
  
  public final MenuItem setTitle(CharSequence paramCharSequence) {
    this.mTitle = paramCharSequence;
    return (MenuItem)this;
  }
  
  public final MenuItem setTitleCondensed(CharSequence paramCharSequence) {
    this.mTitleCondensed = paramCharSequence;
    return (MenuItem)this;
  }
  
  public final MenuItem setVisible(boolean paramBoolean) {
    int i = this.mFlags;
    byte b = 8;
    if (paramBoolean)
      b = 0; 
    this.mFlags = i & 0x8 | b;
    return (MenuItem)this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\view\menu\ActionMenuItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */