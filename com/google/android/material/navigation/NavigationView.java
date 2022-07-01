package com.google.android.material.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class NavigationView extends ScrimInsetsFrameLayout {
  private static final int[] d = new int[] { 16842912 };
  
  private static final int[] e = new int[] { -16842910 };
  
  private static final int f = R.style.Widget_Design_NavigationView;
  
  OnNavigationItemSelectedListener c;
  
  private final NavigationMenu g;
  
  private final NavigationMenuPresenter h;
  
  private final int i;
  
  private final int[] j;
  
  private MenuInflater k;
  
  private ViewTreeObserver.OnGlobalLayoutListener l;
  
  public NavigationView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.navigationViewStyle);
  }
  
  public NavigationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, f), paramAttributeSet, paramInt);
    ColorStateList colorStateList1;
    ColorStateList colorStateList2;
    boolean bool;
    this.h = new NavigationMenuPresenter();
    this.j = new int[2];
    Context context = getContext();
    this.g = new NavigationMenu(context);
    TintTypedArray tintTypedArray = ThemeEnforcement.b(context, paramAttributeSet, R.styleable.NavigationView, paramInt, f, new int[0]);
    if (tintTypedArray.hasValue(R.styleable.NavigationView_android_background))
      ViewCompat.setBackground((View)this, tintTypedArray.getDrawable(R.styleable.NavigationView_android_background)); 
    if (getBackground() == null || getBackground() instanceof ColorDrawable) {
      Drawable drawable = getBackground();
      MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
      if (drawable instanceof ColorDrawable)
        materialShapeDrawable.g(ColorStateList.valueOf(((ColorDrawable)drawable).getColor())); 
      materialShapeDrawable.a(context);
      ViewCompat.setBackground((View)this, (Drawable)materialShapeDrawable);
    } 
    if (tintTypedArray.hasValue(R.styleable.NavigationView_elevation))
      setElevation(tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_elevation, 0)); 
    setFitsSystemWindows(tintTypedArray.getBoolean(R.styleable.NavigationView_android_fitsSystemWindows, false));
    this.i = tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_android_maxWidth, 0);
    if (tintTypedArray.hasValue(R.styleable.NavigationView_itemIconTint)) {
      colorStateList2 = tintTypedArray.getColorStateList(R.styleable.NavigationView_itemIconTint);
    } else {
      colorStateList2 = c(16842808);
    } 
    if (tintTypedArray.hasValue(R.styleable.NavigationView_itemTextAppearance)) {
      bool = tintTypedArray.getResourceId(R.styleable.NavigationView_itemTextAppearance, 0);
      paramInt = 1;
    } else {
      paramInt = 0;
      bool = false;
    } 
    if (tintTypedArray.hasValue(R.styleable.NavigationView_itemIconSize))
      setItemIconSize(tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemIconSize, 0)); 
    paramContext = null;
    if (tintTypedArray.hasValue(R.styleable.NavigationView_itemTextColor))
      colorStateList1 = tintTypedArray.getColorStateList(R.styleable.NavigationView_itemTextColor); 
    ColorStateList colorStateList3 = colorStateList1;
    if (paramInt == 0) {
      colorStateList3 = colorStateList1;
      if (colorStateList1 == null)
        colorStateList3 = c(16842806); 
    } 
    Drawable drawable2 = tintTypedArray.getDrawable(R.styleable.NavigationView_itemBackground);
    Drawable drawable1 = drawable2;
    if (drawable2 == null) {
      drawable1 = drawable2;
      if (a(tintTypedArray))
        drawable1 = b(tintTypedArray); 
    } 
    if (tintTypedArray.hasValue(R.styleable.NavigationView_itemHorizontalPadding)) {
      int j = tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemHorizontalPadding, 0);
      this.h.d(j);
    } 
    int i = tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemIconPadding, 0);
    setItemMaxLines(tintTypedArray.getInt(R.styleable.NavigationView_itemMaxLines, 1));
    this.g.setCallback(new MenuBuilder.Callback(this) {
          public boolean onMenuItemSelected(MenuBuilder param1MenuBuilder, MenuItem param1MenuItem) {
            return (this.a.c != null && this.a.c.a(param1MenuItem));
          }
          
          public void onMenuModeChange(MenuBuilder param1MenuBuilder) {}
        });
    this.h.a(1);
    this.h.initForMenu(context, (MenuBuilder)this.g);
    this.h.a(colorStateList2);
    this.h.h(getOverScrollMode());
    if (paramInt != 0)
      this.h.c(bool); 
    this.h.b(colorStateList3);
    this.h.a(drawable1);
    this.h.e(i);
    this.g.addMenuPresenter((MenuPresenter)this.h);
    addView((View)this.h.getMenuView((ViewGroup)this));
    if (tintTypedArray.hasValue(R.styleable.NavigationView_menu))
      a(tintTypedArray.getResourceId(R.styleable.NavigationView_menu, 0)); 
    if (tintTypedArray.hasValue(R.styleable.NavigationView_headerLayout))
      b(tintTypedArray.getResourceId(R.styleable.NavigationView_headerLayout, 0)); 
    tintTypedArray.recycle();
    a();
  }
  
  private void a() {
    this.l = new ViewTreeObserver.OnGlobalLayoutListener(this) {
        public void onGlobalLayout() {
          boolean bool1;
          NavigationView navigationView = this.a;
          navigationView.getLocationOnScreen(NavigationView.a(navigationView));
          int[] arrayOfInt = NavigationView.a(this.a);
          boolean bool2 = true;
          if (arrayOfInt[1] == 0) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          NavigationView.b(this.a).b(bool1);
          this.a.setDrawTopInsetForeground(bool1);
          Activity activity = ContextUtils.a(this.a.getContext());
          if (activity != null && Build.VERSION.SDK_INT >= 21) {
            boolean bool3;
            boolean bool4;
            if (activity.findViewById(16908290).getHeight() == this.a.getHeight()) {
              bool3 = true;
            } else {
              bool3 = false;
            } 
            if (Color.alpha(activity.getWindow().getNavigationBarColor()) != 0) {
              bool4 = true;
            } else {
              bool4 = false;
            } 
            NavigationView navigationView1 = this.a;
            if (bool3 && bool4) {
              bool1 = bool2;
            } else {
              bool1 = false;
            } 
            navigationView1.setDrawBottomInsetForeground(bool1);
          } 
        }
      };
    getViewTreeObserver().addOnGlobalLayoutListener(this.l);
  }
  
  private boolean a(TintTypedArray paramTintTypedArray) {
    return (paramTintTypedArray.hasValue(R.styleable.NavigationView_itemShapeAppearance) || paramTintTypedArray.hasValue(R.styleable.NavigationView_itemShapeAppearanceOverlay));
  }
  
  private final Drawable b(TintTypedArray paramTintTypedArray) {
    int i = paramTintTypedArray.getResourceId(R.styleable.NavigationView_itemShapeAppearance, 0);
    int j = paramTintTypedArray.getResourceId(R.styleable.NavigationView_itemShapeAppearanceOverlay, 0);
    MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.a(getContext(), i, j).a());
    materialShapeDrawable.g(MaterialResources.a(getContext(), paramTintTypedArray, R.styleable.NavigationView_itemShapeFillColor));
    return (Drawable)new InsetDrawable((Drawable)materialShapeDrawable, paramTintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetStart, 0), paramTintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetTop, 0), paramTintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetEnd, 0), paramTintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetBottom, 0));
  }
  
  private ColorStateList c(int paramInt) {
    TypedValue typedValue = new TypedValue();
    if (!getContext().getTheme().resolveAttribute(paramInt, typedValue, true))
      return null; 
    ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
    if (!getContext().getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true))
      return null; 
    paramInt = typedValue.data;
    int i = colorStateList.getDefaultColor();
    int[] arrayOfInt1 = e;
    int[] arrayOfInt2 = d;
    int[] arrayOfInt3 = EMPTY_STATE_SET;
    int j = colorStateList.getColorForState(e, i);
    return new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3 }, new int[] { j, paramInt, i });
  }
  
  private MenuInflater getMenuInflater() {
    if (this.k == null)
      this.k = (MenuInflater)new SupportMenuInflater(getContext()); 
    return this.k;
  }
  
  public void a(int paramInt) {
    this.h.a(true);
    getMenuInflater().inflate(paramInt, (Menu)this.g);
    this.h.a(false);
    this.h.updateMenuView(false);
  }
  
  public void a(WindowInsetsCompat paramWindowInsetsCompat) {
    this.h.a(paramWindowInsetsCompat);
  }
  
  public View b(int paramInt) {
    return this.h.b(paramInt);
  }
  
  public MenuItem getCheckedItem() {
    return (MenuItem)this.h.a();
  }
  
  public int getHeaderCount() {
    return this.h.b();
  }
  
  public Drawable getItemBackground() {
    return this.h.e();
  }
  
  public int getItemHorizontalPadding() {
    return this.h.f();
  }
  
  public int getItemIconPadding() {
    return this.h.g();
  }
  
  public ColorStateList getItemIconTintList() {
    return this.h.c();
  }
  
  public int getItemMaxLines() {
    return this.h.h();
  }
  
  public ColorStateList getItemTextColor() {
    return this.h.d();
  }
  
  public Menu getMenu() {
    return (Menu)this.g;
  }
  
  public void onAttachedToWindow() {
    super.onAttachedToWindow();
    MaterialShapeUtils.a((View)this);
  }
  
  public void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    if (Build.VERSION.SDK_INT < 16) {
      getViewTreeObserver().removeGlobalOnLayoutListener(this.l);
      return;
    } 
    getViewTreeObserver().removeOnGlobalLayoutListener(this.l);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    int i = View.MeasureSpec.getMode(paramInt1);
    if (i != Integer.MIN_VALUE) {
      if (i == 0)
        paramInt1 = View.MeasureSpec.makeMeasureSpec(this.i, 1073741824); 
    } else {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(paramInt1), this.i), 1073741824);
    } 
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    SavedState savedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(savedState.getSuperState());
    this.g.restorePresenterStates(savedState.a);
  }
  
  protected Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    savedState.a = new Bundle();
    this.g.savePresenterStates(savedState.a);
    return (Parcelable)savedState;
  }
  
  public void setCheckedItem(int paramInt) {
    MenuItem menuItem = this.g.findItem(paramInt);
    if (menuItem != null)
      this.h.a((MenuItemImpl)menuItem); 
  }
  
  public void setCheckedItem(MenuItem paramMenuItem) {
    paramMenuItem = this.g.findItem(paramMenuItem.getItemId());
    if (paramMenuItem != null) {
      this.h.a((MenuItemImpl)paramMenuItem);
      return;
    } 
    throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
  }
  
  public void setElevation(float paramFloat) {
    if (Build.VERSION.SDK_INT >= 21)
      super.setElevation(paramFloat); 
    MaterialShapeUtils.a((View)this, paramFloat);
  }
  
  public void setItemBackground(Drawable paramDrawable) {
    this.h.a(paramDrawable);
  }
  
  public void setItemBackgroundResource(int paramInt) {
    setItemBackground(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setItemHorizontalPadding(int paramInt) {
    this.h.d(paramInt);
  }
  
  public void setItemHorizontalPaddingResource(int paramInt) {
    this.h.d(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setItemIconPadding(int paramInt) {
    this.h.e(paramInt);
  }
  
  public void setItemIconPaddingResource(int paramInt) {
    this.h.e(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setItemIconSize(int paramInt) {
    this.h.g(paramInt);
  }
  
  public void setItemIconTintList(ColorStateList paramColorStateList) {
    this.h.a(paramColorStateList);
  }
  
  public void setItemMaxLines(int paramInt) {
    this.h.f(paramInt);
  }
  
  public void setItemTextAppearance(int paramInt) {
    this.h.c(paramInt);
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList) {
    this.h.b(paramColorStateList);
  }
  
  public void setNavigationItemSelectedListener(OnNavigationItemSelectedListener paramOnNavigationItemSelectedListener) {
    this.c = paramOnNavigationItemSelectedListener;
  }
  
  public void setOverScrollMode(int paramInt) {
    super.setOverScrollMode(paramInt);
    NavigationMenuPresenter navigationMenuPresenter = this.h;
    if (navigationMenuPresenter != null)
      navigationMenuPresenter.h(paramInt); 
  }
  
  public static interface OnNavigationItemSelectedListener {
    boolean a(MenuItem param1MenuItem);
  }
  
  public static class SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = (Parcelable.Creator<SavedState>)new Parcelable.ClassLoaderCreator<SavedState>() {
        public NavigationView.SavedState a(Parcel param2Parcel) {
          return new NavigationView.SavedState(param2Parcel, null);
        }
        
        public NavigationView.SavedState a(Parcel param2Parcel, ClassLoader param2ClassLoader) {
          return new NavigationView.SavedState(param2Parcel, param2ClassLoader);
        }
        
        public NavigationView.SavedState[] a(int param2Int) {
          return new NavigationView.SavedState[param2Int];
        }
      };
    
    public Bundle a;
    
    public SavedState(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel, param1ClassLoader);
      this.a = param1Parcel.readBundle(param1ClassLoader);
    }
    
    public SavedState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      param1Parcel.writeBundle(this.a);
    }
  }
  
  static final class null implements Parcelable.ClassLoaderCreator<SavedState> {
    public NavigationView.SavedState a(Parcel param1Parcel) {
      return new NavigationView.SavedState(param1Parcel, null);
    }
    
    public NavigationView.SavedState a(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      return new NavigationView.SavedState(param1Parcel, param1ClassLoader);
    }
    
    public NavigationView.SavedState[] a(int param1Int) {
      return new NavigationView.SavedState[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\navigation\NavigationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */