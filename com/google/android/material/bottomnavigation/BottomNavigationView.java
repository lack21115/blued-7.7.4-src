package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class BottomNavigationView extends FrameLayout {
  private static final int b = R.style.Widget_Design_BottomNavigationView;
  
  final BottomNavigationMenuView a;
  
  private final MenuBuilder c;
  
  private final BottomNavigationPresenter d = new BottomNavigationPresenter();
  
  private ColorStateList e;
  
  private MenuInflater f;
  
  private OnNavigationItemSelectedListener g;
  
  private OnNavigationItemReselectedListener h;
  
  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.bottomNavigationStyle);
  }
  
  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, b), paramAttributeSet, paramInt);
    paramContext = getContext();
    this.c = new BottomNavigationMenu(paramContext);
    this.a = new BottomNavigationMenuView(paramContext);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
    layoutParams.gravity = 17;
    this.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.d.a(this.a);
    this.d.a(1);
    this.a.setPresenter(this.d);
    this.c.addMenuPresenter(this.d);
    this.d.initForMenu(getContext(), this.c);
    TintTypedArray tintTypedArray = ThemeEnforcement.b(paramContext, paramAttributeSet, R.styleable.BottomNavigationView, paramInt, R.style.Widget_Design_BottomNavigationView, new int[] { R.styleable.BottomNavigationView_itemTextAppearanceInactive, R.styleable.BottomNavigationView_itemTextAppearanceActive });
    if (tintTypedArray.hasValue(R.styleable.BottomNavigationView_itemIconTint)) {
      this.a.setIconTintList(tintTypedArray.getColorStateList(R.styleable.BottomNavigationView_itemIconTint));
    } else {
      BottomNavigationMenuView bottomNavigationMenuView = this.a;
      bottomNavigationMenuView.setIconTintList(bottomNavigationMenuView.a(16842808));
    } 
    setItemIconSize(tintTypedArray.getDimensionPixelSize(R.styleable.BottomNavigationView_itemIconSize, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_icon_size)));
    if (tintTypedArray.hasValue(R.styleable.BottomNavigationView_itemTextAppearanceInactive))
      setItemTextAppearanceInactive(tintTypedArray.getResourceId(R.styleable.BottomNavigationView_itemTextAppearanceInactive, 0)); 
    if (tintTypedArray.hasValue(R.styleable.BottomNavigationView_itemTextAppearanceActive))
      setItemTextAppearanceActive(tintTypedArray.getResourceId(R.styleable.BottomNavigationView_itemTextAppearanceActive, 0)); 
    if (tintTypedArray.hasValue(R.styleable.BottomNavigationView_itemTextColor))
      setItemTextColor(tintTypedArray.getColorStateList(R.styleable.BottomNavigationView_itemTextColor)); 
    if (getBackground() == null || getBackground() instanceof ColorDrawable)
      ViewCompat.setBackground((View)this, (Drawable)a(paramContext)); 
    if (tintTypedArray.hasValue(R.styleable.BottomNavigationView_elevation))
      ViewCompat.setElevation((View)this, tintTypedArray.getDimensionPixelSize(R.styleable.BottomNavigationView_elevation, 0)); 
    ColorStateList colorStateList = MaterialResources.a(paramContext, tintTypedArray, R.styleable.BottomNavigationView_backgroundTint);
    DrawableCompat.setTintList(getBackground().mutate(), colorStateList);
    setLabelVisibilityMode(tintTypedArray.getInteger(R.styleable.BottomNavigationView_labelVisibilityMode, -1));
    setItemHorizontalTranslationEnabled(tintTypedArray.getBoolean(R.styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
    paramInt = tintTypedArray.getResourceId(R.styleable.BottomNavigationView_itemBackground, 0);
    if (paramInt != 0) {
      this.a.setItemBackgroundRes(paramInt);
    } else {
      setItemRippleColor(MaterialResources.a(paramContext, tintTypedArray, R.styleable.BottomNavigationView_itemRippleColor));
    } 
    if (tintTypedArray.hasValue(R.styleable.BottomNavigationView_menu))
      a(tintTypedArray.getResourceId(R.styleable.BottomNavigationView_menu, 0)); 
    tintTypedArray.recycle();
    addView((View)this.a, (ViewGroup.LayoutParams)layoutParams);
    if (Build.VERSION.SDK_INT < 21)
      b(paramContext); 
    this.c.setCallback(new MenuBuilder.Callback(this) {
          public boolean onMenuItemSelected(MenuBuilder param1MenuBuilder, MenuItem param1MenuItem) {
            if (BottomNavigationView.a(this.a) != null && param1MenuItem.getItemId() == this.a.getSelectedItemId()) {
              BottomNavigationView.a(this.a).a(param1MenuItem);
              return true;
            } 
            return (BottomNavigationView.b(this.a) != null && !BottomNavigationView.b(this.a).a(param1MenuItem));
          }
          
          public void onMenuModeChange(MenuBuilder param1MenuBuilder) {}
        });
    a();
  }
  
  private MaterialShapeDrawable a(Context paramContext) {
    MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
    Drawable drawable = getBackground();
    if (drawable instanceof ColorDrawable)
      materialShapeDrawable.g(ColorStateList.valueOf(((ColorDrawable)drawable).getColor())); 
    materialShapeDrawable.a(paramContext);
    return materialShapeDrawable;
  }
  
  private void a() {
    ViewUtils.a((View)this, new ViewUtils.OnApplyWindowInsetsListener(this) {
          public WindowInsetsCompat a(View param1View, WindowInsetsCompat param1WindowInsetsCompat, ViewUtils.RelativePadding param1RelativePadding) {
            param1RelativePadding.d += param1WindowInsetsCompat.getSystemWindowInsetBottom();
            param1RelativePadding.a(param1View);
            return param1WindowInsetsCompat;
          }
        });
  }
  
  private void b(Context paramContext) {
    View view = new View(paramContext);
    view.setBackgroundColor(ContextCompat.getColor(paramContext, R.color.design_bottom_navigation_shadow_color));
    view.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_shadow_height)));
    addView(view);
  }
  
  private MenuInflater getMenuInflater() {
    if (this.f == null)
      this.f = (MenuInflater)new SupportMenuInflater(getContext()); 
    return this.f;
  }
  
  public void a(int paramInt) {
    this.d.a(true);
    getMenuInflater().inflate(paramInt, (Menu)this.c);
    this.d.a(false);
    this.d.updateMenuView(true);
  }
  
  public Drawable getItemBackground() {
    return this.a.getItemBackground();
  }
  
  @Deprecated
  public int getItemBackgroundResource() {
    return this.a.getItemBackgroundRes();
  }
  
  public int getItemIconSize() {
    return this.a.getItemIconSize();
  }
  
  public ColorStateList getItemIconTintList() {
    return this.a.getIconTintList();
  }
  
  public ColorStateList getItemRippleColor() {
    return this.e;
  }
  
  public int getItemTextAppearanceActive() {
    return this.a.getItemTextAppearanceActive();
  }
  
  public int getItemTextAppearanceInactive() {
    return this.a.getItemTextAppearanceInactive();
  }
  
  public ColorStateList getItemTextColor() {
    return this.a.getItemTextColor();
  }
  
  public int getLabelVisibilityMode() {
    return this.a.getLabelVisibilityMode();
  }
  
  public int getMaxItemCount() {
    return 5;
  }
  
  public Menu getMenu() {
    return (Menu)this.c;
  }
  
  public int getSelectedItemId() {
    return this.a.getSelectedItemId();
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    MaterialShapeUtils.a((View)this);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    SavedState savedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(savedState.getSuperState());
    this.c.restorePresenterStates(savedState.a);
  }
  
  protected Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    savedState.a = new Bundle();
    this.c.savePresenterStates(savedState.a);
    return (Parcelable)savedState;
  }
  
  public void setElevation(float paramFloat) {
    super.setElevation(paramFloat);
    MaterialShapeUtils.a((View)this, paramFloat);
  }
  
  public void setItemBackground(Drawable paramDrawable) {
    this.a.setItemBackground(paramDrawable);
    this.e = null;
  }
  
  public void setItemBackgroundResource(int paramInt) {
    this.a.setItemBackgroundRes(paramInt);
    this.e = null;
  }
  
  public void setItemHorizontalTranslationEnabled(boolean paramBoolean) {
    if (this.a.a() != paramBoolean) {
      this.a.setItemHorizontalTranslationEnabled(paramBoolean);
      this.d.updateMenuView(false);
    } 
  }
  
  public void setItemIconSize(int paramInt) {
    this.a.setItemIconSize(paramInt);
  }
  
  public void setItemIconSizeRes(int paramInt) {
    setItemIconSize(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setItemIconTintList(ColorStateList paramColorStateList) {
    this.a.setIconTintList(paramColorStateList);
  }
  
  public void setItemRippleColor(ColorStateList paramColorStateList) {
    if (this.e == paramColorStateList) {
      if (paramColorStateList == null && this.a.getItemBackground() != null)
        this.a.setItemBackground((Drawable)null); 
      return;
    } 
    this.e = paramColorStateList;
    if (paramColorStateList == null) {
      this.a.setItemBackground((Drawable)null);
      return;
    } 
    paramColorStateList = RippleUtils.a(paramColorStateList);
    if (Build.VERSION.SDK_INT >= 21) {
      this.a.setItemBackground((Drawable)new RippleDrawable(paramColorStateList, null, null));
      return;
    } 
    GradientDrawable gradientDrawable = new GradientDrawable();
    gradientDrawable.setCornerRadius(1.0E-5F);
    Drawable drawable = DrawableCompat.wrap((Drawable)gradientDrawable);
    DrawableCompat.setTintList(drawable, paramColorStateList);
    this.a.setItemBackground(drawable);
  }
  
  public void setItemTextAppearanceActive(int paramInt) {
    this.a.setItemTextAppearanceActive(paramInt);
  }
  
  public void setItemTextAppearanceInactive(int paramInt) {
    this.a.setItemTextAppearanceInactive(paramInt);
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList) {
    this.a.setItemTextColor(paramColorStateList);
  }
  
  public void setLabelVisibilityMode(int paramInt) {
    if (this.a.getLabelVisibilityMode() != paramInt) {
      this.a.setLabelVisibilityMode(paramInt);
      this.d.updateMenuView(false);
    } 
  }
  
  public void setOnNavigationItemReselectedListener(OnNavigationItemReselectedListener paramOnNavigationItemReselectedListener) {
    this.h = paramOnNavigationItemReselectedListener;
  }
  
  public void setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener paramOnNavigationItemSelectedListener) {
    this.g = paramOnNavigationItemSelectedListener;
  }
  
  public void setSelectedItemId(int paramInt) {
    MenuItem menuItem = this.c.findItem(paramInt);
    if (menuItem != null && !this.c.performItemAction(menuItem, this.d, 0))
      menuItem.setChecked(true); 
  }
  
  public static interface OnNavigationItemReselectedListener {
    void a(MenuItem param1MenuItem);
  }
  
  public static interface OnNavigationItemSelectedListener {
    boolean a(MenuItem param1MenuItem);
  }
  
  static class SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = (Parcelable.Creator<SavedState>)new Parcelable.ClassLoaderCreator<SavedState>() {
        public BottomNavigationView.SavedState a(Parcel param2Parcel) {
          return new BottomNavigationView.SavedState(param2Parcel, null);
        }
        
        public BottomNavigationView.SavedState a(Parcel param2Parcel, ClassLoader param2ClassLoader) {
          return new BottomNavigationView.SavedState(param2Parcel, param2ClassLoader);
        }
        
        public BottomNavigationView.SavedState[] a(int param2Int) {
          return new BottomNavigationView.SavedState[param2Int];
        }
      };
    
    Bundle a;
    
    public SavedState(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel, param1ClassLoader);
      ClassLoader classLoader = param1ClassLoader;
      if (param1ClassLoader == null)
        classLoader = getClass().getClassLoader(); 
      a(param1Parcel, classLoader);
    }
    
    public SavedState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    private void a(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      this.a = param1Parcel.readBundle(param1ClassLoader);
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      param1Parcel.writeBundle(this.a);
    }
  }
  
  static final class null implements Parcelable.ClassLoaderCreator<SavedState> {
    public BottomNavigationView.SavedState a(Parcel param1Parcel) {
      return new BottomNavigationView.SavedState(param1Parcel, null);
    }
    
    public BottomNavigationView.SavedState a(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      return new BottomNavigationView.SavedState(param1Parcel, param1ClassLoader);
    }
    
    public BottomNavigationView.SavedState[] a(int param1Int) {
      return new BottomNavigationView.SavedState[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\bottomnavigation\BottomNavigationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */