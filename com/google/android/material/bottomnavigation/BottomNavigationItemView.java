package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;

public class BottomNavigationItemView extends FrameLayout implements MenuView.ItemView {
  private static final int[] a = new int[] { 16842912 };
  
  private final int b;
  
  private float c;
  
  private float d;
  
  private float e;
  
  private int f;
  
  private boolean g;
  
  private ImageView h;
  
  private final TextView i;
  
  private final TextView j;
  
  private int k = -1;
  
  private MenuItemImpl l;
  
  private ColorStateList m;
  
  private Drawable n;
  
  private Drawable o;
  
  private BadgeDrawable p;
  
  public BottomNavigationItemView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public BottomNavigationItemView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BottomNavigationItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    Resources resources = getResources();
    LayoutInflater.from(paramContext).inflate(R.layout.design_bottom_navigation_item, (ViewGroup)this, true);
    setBackgroundResource(R.drawable.design_bottom_navigation_item_background);
    this.b = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_margin);
    this.h = (ImageView)findViewById(R.id.icon);
    this.i = (TextView)findViewById(R.id.smallLabel);
    this.j = (TextView)findViewById(R.id.largeLabel);
    ViewCompat.setImportantForAccessibility((View)this.i, 2);
    ViewCompat.setImportantForAccessibility((View)this.j, 2);
    setFocusable(true);
    a(this.i.getTextSize(), this.j.getTextSize());
    ImageView imageView = this.h;
    if (imageView != null)
      imageView.addOnLayoutChangeListener(new View.OnLayoutChangeListener(this) {
            public void onLayoutChange(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, int param1Int6, int param1Int7, int param1Int8) {
              if (BottomNavigationItemView.a(this.a).getVisibility() == 0) {
                BottomNavigationItemView bottomNavigationItemView = this.a;
                BottomNavigationItemView.a(bottomNavigationItemView, (View)BottomNavigationItemView.a(bottomNavigationItemView));
              } 
            }
          }); 
  }
  
  private void a(float paramFloat1, float paramFloat2) {
    this.c = paramFloat1 - paramFloat2;
    this.d = paramFloat2 * 1.0F / paramFloat1;
    this.e = paramFloat1 * 1.0F / paramFloat2;
  }
  
  private void a(View paramView) {
    if (!b())
      return; 
    BadgeUtils.c(this.p, paramView, d(paramView));
  }
  
  private void a(View paramView, float paramFloat1, float paramFloat2, int paramInt) {
    paramView.setScaleX(paramFloat1);
    paramView.setScaleY(paramFloat2);
    paramView.setVisibility(paramInt);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2) {
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    layoutParams.topMargin = paramInt1;
    layoutParams.gravity = paramInt2;
    paramView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  private void b(View paramView) {
    if (!b())
      return; 
    if (paramView != null) {
      setClipChildren(false);
      setClipToPadding(false);
      BadgeUtils.a(this.p, paramView, d(paramView));
    } 
  }
  
  private boolean b() {
    return (this.p != null);
  }
  
  private void c(View paramView) {
    if (!b())
      return; 
    if (paramView != null) {
      setClipChildren(true);
      setClipToPadding(true);
      BadgeUtils.b(this.p, paramView, d(paramView));
    } 
    this.p = null;
  }
  
  private FrameLayout d(View paramView) {
    ImageView imageView = this.h;
    FrameLayout frameLayout2 = null;
    FrameLayout frameLayout1 = frameLayout2;
    if (paramView == imageView) {
      frameLayout1 = frameLayout2;
      if (BadgeUtils.a)
        frameLayout1 = (FrameLayout)this.h.getParent(); 
    } 
    return frameLayout1;
  }
  
  void a() {
    c((View)this.h);
  }
  
  BadgeDrawable getBadge() {
    return this.p;
  }
  
  public MenuItemImpl getItemData() {
    return this.l;
  }
  
  public int getItemPosition() {
    return this.k;
  }
  
  public void initialize(MenuItemImpl paramMenuItemImpl, int paramInt) {
    CharSequence charSequence;
    this.l = paramMenuItemImpl;
    setCheckable(paramMenuItemImpl.isCheckable());
    setChecked(paramMenuItemImpl.isChecked());
    setEnabled(paramMenuItemImpl.isEnabled());
    setIcon(paramMenuItemImpl.getIcon());
    setTitle(paramMenuItemImpl.getTitle());
    setId(paramMenuItemImpl.getItemId());
    if (!TextUtils.isEmpty(paramMenuItemImpl.getContentDescription()))
      setContentDescription(paramMenuItemImpl.getContentDescription()); 
    if (!TextUtils.isEmpty(paramMenuItemImpl.getTooltipText())) {
      charSequence = paramMenuItemImpl.getTooltipText();
    } else {
      charSequence = paramMenuItemImpl.getTitle();
    } 
    TooltipCompat.setTooltipText((View)this, charSequence);
    if (paramMenuItemImpl.isVisible()) {
      paramInt = 0;
    } else {
      paramInt = 8;
    } 
    setVisibility(paramInt);
  }
  
  public int[] onCreateDrawableState(int paramInt) {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    MenuItemImpl menuItemImpl = this.l;
    if (menuItemImpl != null && menuItemImpl.isCheckable() && this.l.isChecked())
      mergeDrawableStates(arrayOfInt, a); 
    return arrayOfInt;
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo) {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    BadgeDrawable badgeDrawable = this.p;
    if (badgeDrawable != null && badgeDrawable.isVisible()) {
      CharSequence charSequence = this.l.getTitle();
      if (!TextUtils.isEmpty(this.l.getContentDescription()))
        charSequence = this.l.getContentDescription(); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(charSequence);
      stringBuilder.append(", ");
      stringBuilder.append(this.p.f());
      paramAccessibilityNodeInfo.setContentDescription(stringBuilder.toString());
    } 
    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.wrap(paramAccessibilityNodeInfo);
    accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, getItemPosition(), 1, false, isSelected()));
    if (isSelected()) {
      accessibilityNodeInfoCompat.setClickable(false);
      accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
    } 
    accessibilityNodeInfoCompat.setRoleDescription(getResources().getString(R.string.item_view_role_description));
  }
  
  public boolean prefersCondensedTitle() {
    return false;
  }
  
  void setBadge(BadgeDrawable paramBadgeDrawable) {
    this.p = paramBadgeDrawable;
    ImageView imageView = this.h;
    if (imageView != null)
      b((View)imageView); 
  }
  
  public void setCheckable(boolean paramBoolean) {
    refreshDrawableState();
  }
  
  public void setChecked(boolean paramBoolean) {
    TextView textView = this.j;
    textView.setPivotX((textView.getWidth() / 2));
    textView = this.j;
    textView.setPivotY(textView.getBaseline());
    textView = this.i;
    textView.setPivotX((textView.getWidth() / 2));
    textView = this.i;
    textView.setPivotY(textView.getBaseline());
    int i = this.f;
    if (i != -1) {
      if (i != 0) {
        if (i != 1) {
          if (i == 2) {
            a((View)this.h, this.b, 17);
            this.j.setVisibility(8);
            this.i.setVisibility(8);
          } 
        } else if (paramBoolean) {
          a((View)this.h, (int)(this.b + this.c), 49);
          a((View)this.j, 1.0F, 1.0F, 0);
          textView = this.i;
          float f = this.d;
          a((View)textView, f, f, 4);
        } else {
          a((View)this.h, this.b, 49);
          textView = this.j;
          float f = this.e;
          a((View)textView, f, f, 4);
          a((View)this.i, 1.0F, 1.0F, 0);
        } 
      } else {
        if (paramBoolean) {
          a((View)this.h, this.b, 49);
          a((View)this.j, 1.0F, 1.0F, 0);
        } else {
          a((View)this.h, this.b, 17);
          a((View)this.j, 0.5F, 0.5F, 4);
        } 
        this.i.setVisibility(4);
      } 
    } else if (this.g) {
      if (paramBoolean) {
        a((View)this.h, this.b, 49);
        a((View)this.j, 1.0F, 1.0F, 0);
      } else {
        a((View)this.h, this.b, 17);
        a((View)this.j, 0.5F, 0.5F, 4);
      } 
      this.i.setVisibility(4);
    } else if (paramBoolean) {
      a((View)this.h, (int)(this.b + this.c), 49);
      a((View)this.j, 1.0F, 1.0F, 0);
      textView = this.i;
      float f = this.d;
      a((View)textView, f, f, 4);
    } else {
      a((View)this.h, this.b, 49);
      textView = this.j;
      float f = this.e;
      a((View)textView, f, f, 4);
      a((View)this.i, 1.0F, 1.0F, 0);
    } 
    refreshDrawableState();
    setSelected(paramBoolean);
  }
  
  public void setEnabled(boolean paramBoolean) {
    super.setEnabled(paramBoolean);
    this.i.setEnabled(paramBoolean);
    this.j.setEnabled(paramBoolean);
    this.h.setEnabled(paramBoolean);
    if (paramBoolean) {
      ViewCompat.setPointerIcon((View)this, PointerIconCompat.getSystemIcon(getContext(), 1002));
      return;
    } 
    ViewCompat.setPointerIcon((View)this, null);
  }
  
  public void setIcon(Drawable paramDrawable) {
    if (paramDrawable == this.n)
      return; 
    this.n = paramDrawable;
    Drawable drawable = paramDrawable;
    if (paramDrawable != null) {
      Drawable.ConstantState constantState = paramDrawable.getConstantState();
      if (constantState != null)
        paramDrawable = constantState.newDrawable(); 
      paramDrawable = DrawableCompat.wrap(paramDrawable).mutate();
      this.o = paramDrawable;
      ColorStateList colorStateList = this.m;
      drawable = paramDrawable;
      if (colorStateList != null) {
        DrawableCompat.setTintList(this.o, colorStateList);
        drawable = paramDrawable;
      } 
    } 
    this.h.setImageDrawable(drawable);
  }
  
  public void setIconSize(int paramInt) {
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.h.getLayoutParams();
    layoutParams.width = paramInt;
    layoutParams.height = paramInt;
    this.h.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  public void setIconTintList(ColorStateList paramColorStateList) {
    this.m = paramColorStateList;
    if (this.l != null) {
      Drawable drawable = this.o;
      if (drawable != null) {
        DrawableCompat.setTintList(drawable, this.m);
        this.o.invalidateSelf();
      } 
    } 
  }
  
  public void setItemBackground(int paramInt) {
    Drawable drawable;
    if (paramInt == 0) {
      drawable = null;
    } else {
      drawable = ContextCompat.getDrawable(getContext(), paramInt);
    } 
    setItemBackground(drawable);
  }
  
  public void setItemBackground(Drawable paramDrawable) {
    Drawable drawable = paramDrawable;
    if (paramDrawable != null) {
      drawable = paramDrawable;
      if (paramDrawable.getConstantState() != null)
        drawable = paramDrawable.getConstantState().newDrawable().mutate(); 
    } 
    ViewCompat.setBackground((View)this, drawable);
  }
  
  public void setItemPosition(int paramInt) {
    this.k = paramInt;
  }
  
  public void setLabelVisibilityMode(int paramInt) {
    if (this.f != paramInt) {
      this.f = paramInt;
      if (this.l != null) {
        paramInt = 1;
      } else {
        paramInt = 0;
      } 
      if (paramInt != 0)
        setChecked(this.l.isChecked()); 
    } 
  }
  
  public void setShifting(boolean paramBoolean) {
    if (this.g != paramBoolean) {
      boolean bool;
      this.g = paramBoolean;
      if (this.l != null) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool)
        setChecked(this.l.isChecked()); 
    } 
  }
  
  public void setShortcut(boolean paramBoolean, char paramChar) {}
  
  public void setTextAppearanceActive(int paramInt) {
    TextViewCompat.setTextAppearance(this.j, paramInt);
    a(this.i.getTextSize(), this.j.getTextSize());
  }
  
  public void setTextAppearanceInactive(int paramInt) {
    TextViewCompat.setTextAppearance(this.i, paramInt);
    a(this.i.getTextSize(), this.j.getTextSize());
  }
  
  public void setTextColor(ColorStateList paramColorStateList) {
    if (paramColorStateList != null) {
      this.i.setTextColor(paramColorStateList);
      this.j.setTextColor(paramColorStateList);
    } 
  }
  
  public void setTitle(CharSequence paramCharSequence) {
    this.i.setText(paramCharSequence);
    this.j.setText(paramCharSequence);
    MenuItemImpl menuItemImpl1 = this.l;
    if (menuItemImpl1 == null || TextUtils.isEmpty(menuItemImpl1.getContentDescription()))
      setContentDescription(paramCharSequence); 
    MenuItemImpl menuItemImpl2 = this.l;
    CharSequence charSequence = paramCharSequence;
    if (menuItemImpl2 != null)
      if (TextUtils.isEmpty(menuItemImpl2.getTooltipText())) {
        charSequence = paramCharSequence;
      } else {
        charSequence = this.l.getTooltipText();
      }  
    TooltipCompat.setTooltipText((View)this, charSequence);
  }
  
  public boolean showsIcon() {
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\bottomnavigation\BottomNavigationItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */