package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;

public class NavigationMenuItemView extends ForegroundLinearLayout implements MenuView.ItemView {
  private static final int[] d = new int[] { 16842912 };
  
  boolean c;
  
  private int e;
  
  private boolean f;
  
  private final CheckedTextView g;
  
  private FrameLayout h;
  
  private MenuItemImpl i;
  
  private ColorStateList j;
  
  private boolean k;
  
  private Drawable l;
  
  private final AccessibilityDelegateCompat m = new AccessibilityDelegateCompat(this) {
      public void onInitializeAccessibilityNodeInfo(View param1View, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(param1View, param1AccessibilityNodeInfoCompat);
        param1AccessibilityNodeInfoCompat.setCheckable(this.a.c);
      }
    };
  
  public NavigationMenuItemView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
    LayoutInflater.from(paramContext).inflate(R.layout.design_navigation_menu_item, (ViewGroup)this, true);
    setIconSize(paramContext.getResources().getDimensionPixelSize(R.dimen.design_navigation_icon_size));
    this.g = (CheckedTextView)findViewById(R.id.design_menu_item_text);
    this.g.setDuplicateParentStateEnabled(true);
    ViewCompat.setAccessibilityDelegate((View)this.g, this.m);
  }
  
  private boolean c() {
    return (this.i.getTitle() == null && this.i.getIcon() == null && this.i.getActionView() != null);
  }
  
  private void d() {
    if (c()) {
      this.g.setVisibility(8);
      FrameLayout frameLayout = this.h;
      if (frameLayout != null) {
        LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams)frameLayout.getLayoutParams();
        layoutParams.width = -1;
        this.h.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        return;
      } 
    } else {
      this.g.setVisibility(0);
      FrameLayout frameLayout = this.h;
      if (frameLayout != null) {
        LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams)frameLayout.getLayoutParams();
        layoutParams.width = -2;
        this.h.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      } 
    } 
  }
  
  private StateListDrawable e() {
    TypedValue typedValue = new TypedValue();
    if (getContext().getTheme().resolveAttribute(R.attr.colorControlHighlight, typedValue, true)) {
      StateListDrawable stateListDrawable = new StateListDrawable();
      stateListDrawable.addState(d, (Drawable)new ColorDrawable(typedValue.data));
      stateListDrawable.addState(EMPTY_STATE_SET, (Drawable)new ColorDrawable(0));
      return stateListDrawable;
    } 
    return null;
  }
  
  private void setActionView(View paramView) {
    if (paramView != null) {
      if (this.h == null)
        this.h = (FrameLayout)((ViewStub)findViewById(R.id.design_menu_item_action_area_stub)).inflate(); 
      this.h.removeAllViews();
      this.h.addView(paramView);
    } 
  }
  
  public void a() {
    FrameLayout frameLayout = this.h;
    if (frameLayout != null)
      frameLayout.removeAllViews(); 
    this.g.setCompoundDrawables(null, null, null, null);
  }
  
  public MenuItemImpl getItemData() {
    return this.i;
  }
  
  public void initialize(MenuItemImpl paramMenuItemImpl, int paramInt) {
    this.i = paramMenuItemImpl;
    if (paramMenuItemImpl.getItemId() > 0)
      setId(paramMenuItemImpl.getItemId()); 
    if (paramMenuItemImpl.isVisible()) {
      paramInt = 0;
    } else {
      paramInt = 8;
    } 
    setVisibility(paramInt);
    if (getBackground() == null)
      ViewCompat.setBackground((View)this, (Drawable)e()); 
    setCheckable(paramMenuItemImpl.isCheckable());
    setChecked(paramMenuItemImpl.isChecked());
    setEnabled(paramMenuItemImpl.isEnabled());
    setTitle(paramMenuItemImpl.getTitle());
    setIcon(paramMenuItemImpl.getIcon());
    setActionView(paramMenuItemImpl.getActionView());
    setContentDescription(paramMenuItemImpl.getContentDescription());
    TooltipCompat.setTooltipText((View)this, paramMenuItemImpl.getTooltipText());
    d();
  }
  
  protected int[] onCreateDrawableState(int paramInt) {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    MenuItemImpl menuItemImpl = this.i;
    if (menuItemImpl != null && menuItemImpl.isCheckable() && this.i.isChecked())
      mergeDrawableStates(arrayOfInt, d); 
    return arrayOfInt;
  }
  
  public boolean prefersCondensedTitle() {
    return false;
  }
  
  public void setCheckable(boolean paramBoolean) {
    refreshDrawableState();
    if (this.c != paramBoolean) {
      this.c = paramBoolean;
      this.m.sendAccessibilityEvent((View)this.g, 2048);
    } 
  }
  
  public void setChecked(boolean paramBoolean) {
    refreshDrawableState();
    this.g.setChecked(paramBoolean);
  }
  
  public void setHorizontalPadding(int paramInt) {
    setPadding(paramInt, 0, paramInt, 0);
  }
  
  public void setIcon(Drawable paramDrawable) {
    if (paramDrawable != null) {
      Drawable drawable = paramDrawable;
      if (this.k) {
        Drawable.ConstantState constantState = paramDrawable.getConstantState();
        if (constantState != null)
          paramDrawable = constantState.newDrawable(); 
        drawable = DrawableCompat.wrap(paramDrawable).mutate();
        DrawableCompat.setTintList(drawable, this.j);
      } 
      int i = this.e;
      drawable.setBounds(0, 0, i, i);
      paramDrawable = drawable;
    } else if (this.f) {
      if (this.l == null) {
        this.l = ResourcesCompat.getDrawable(getResources(), R.drawable.navigation_empty_icon, getContext().getTheme());
        paramDrawable = this.l;
        if (paramDrawable != null) {
          int i = this.e;
          paramDrawable.setBounds(0, 0, i, i);
        } 
      } 
      paramDrawable = this.l;
    } 
    TextViewCompat.setCompoundDrawablesRelative((TextView)this.g, paramDrawable, null, null, null);
  }
  
  public void setIconPadding(int paramInt) {
    this.g.setCompoundDrawablePadding(paramInt);
  }
  
  public void setIconSize(int paramInt) {
    this.e = paramInt;
  }
  
  void setIconTintList(ColorStateList paramColorStateList) {
    boolean bool;
    this.j = paramColorStateList;
    if (this.j != null) {
      bool = true;
    } else {
      bool = false;
    } 
    this.k = bool;
    MenuItemImpl menuItemImpl = this.i;
    if (menuItemImpl != null)
      setIcon(menuItemImpl.getIcon()); 
  }
  
  public void setMaxLines(int paramInt) {
    this.g.setMaxLines(paramInt);
  }
  
  public void setNeedsEmptyIcon(boolean paramBoolean) {
    this.f = paramBoolean;
  }
  
  public void setShortcut(boolean paramBoolean, char paramChar) {}
  
  public void setTextAppearance(int paramInt) {
    TextViewCompat.setTextAppearance((TextView)this.g, paramInt);
  }
  
  public void setTextColor(ColorStateList paramColorStateList) {
    this.g.setTextColor(paramColorStateList);
  }
  
  public void setTitle(CharSequence paramCharSequence) {
    this.g.setText(paramCharSequence);
  }
  
  public boolean showsIcon() {
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\internal\NavigationMenuItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */