package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

public class ToolbarWidgetWrapper implements DecorToolbar {
  Toolbar a;
  
  CharSequence b;
  
  Window.Callback c;
  
  boolean d;
  
  private int e;
  
  private View f;
  
  private Spinner g;
  
  private View h;
  
  private Drawable i;
  
  private Drawable j;
  
  private Drawable k;
  
  private boolean l;
  
  private CharSequence m;
  
  private CharSequence n;
  
  private ActionMenuPresenter o;
  
  private int p;
  
  private int q;
  
  private Drawable r;
  
  public ToolbarWidgetWrapper(Toolbar paramToolbar, boolean paramBoolean) {
    this(paramToolbar, paramBoolean, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_material);
  }
  
  public ToolbarWidgetWrapper(Toolbar paramToolbar, boolean paramBoolean, int paramInt1, int paramInt2) {
    boolean bool;
    this.p = 0;
    this.q = 0;
    this.a = paramToolbar;
    this.b = paramToolbar.getTitle();
    this.m = paramToolbar.getSubtitle();
    if (this.b != null) {
      bool = true;
    } else {
      bool = false;
    } 
    this.l = bool;
    this.k = paramToolbar.getNavigationIcon();
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(paramToolbar.getContext(), null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
    this.r = tintTypedArray.getDrawable(R.styleable.ActionBar_homeAsUpIndicator);
    if (paramBoolean) {
      CharSequence charSequence = tintTypedArray.getText(R.styleable.ActionBar_title);
      if (!TextUtils.isEmpty(charSequence))
        setTitle(charSequence); 
      charSequence = tintTypedArray.getText(R.styleable.ActionBar_subtitle);
      if (!TextUtils.isEmpty(charSequence))
        setSubtitle(charSequence); 
      Drawable drawable = tintTypedArray.getDrawable(R.styleable.ActionBar_logo);
      if (drawable != null)
        setLogo(drawable); 
      drawable = tintTypedArray.getDrawable(R.styleable.ActionBar_icon);
      if (drawable != null)
        setIcon(drawable); 
      if (this.k == null) {
        drawable = this.r;
        if (drawable != null)
          setNavigationIcon(drawable); 
      } 
      setDisplayOptions(tintTypedArray.getInt(R.styleable.ActionBar_displayOptions, 0));
      paramInt2 = tintTypedArray.getResourceId(R.styleable.ActionBar_customNavigationLayout, 0);
      if (paramInt2 != 0) {
        setCustomView(LayoutInflater.from(this.a.getContext()).inflate(paramInt2, this.a, false));
        setDisplayOptions(this.e | 0x10);
      } 
      paramInt2 = tintTypedArray.getLayoutDimension(R.styleable.ActionBar_height, 0);
      if (paramInt2 > 0) {
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        layoutParams.height = paramInt2;
        this.a.setLayoutParams(layoutParams);
      } 
      paramInt2 = tintTypedArray.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetStart, -1);
      int i = tintTypedArray.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetEnd, -1);
      if (paramInt2 >= 0 || i >= 0)
        this.a.setContentInsetsRelative(Math.max(paramInt2, 0), Math.max(i, 0)); 
      paramInt2 = tintTypedArray.getResourceId(R.styleable.ActionBar_titleTextStyle, 0);
      if (paramInt2 != 0) {
        Toolbar toolbar = this.a;
        toolbar.setTitleTextAppearance(toolbar.getContext(), paramInt2);
      } 
      paramInt2 = tintTypedArray.getResourceId(R.styleable.ActionBar_subtitleTextStyle, 0);
      if (paramInt2 != 0) {
        Toolbar toolbar = this.a;
        toolbar.setSubtitleTextAppearance(toolbar.getContext(), paramInt2);
      } 
      paramInt2 = tintTypedArray.getResourceId(R.styleable.ActionBar_popupTheme, 0);
      if (paramInt2 != 0)
        this.a.setPopupTheme(paramInt2); 
    } else {
      this.e = a();
    } 
    tintTypedArray.recycle();
    setDefaultNavigationContentDescription(paramInt1);
    this.n = this.a.getNavigationContentDescription();
    this.a.setNavigationOnClickListener(new View.OnClickListener(this) {
          final ActionMenuItem a = new ActionMenuItem(this.b.a.getContext(), 0, 16908332, 0, 0, this.b.b);
          
          public void onClick(View param1View) {
            if (this.b.c != null && this.b.d)
              this.b.c.onMenuItemSelected(0, (MenuItem)this.a); 
          }
        });
  }
  
  private int a() {
    if (this.a.getNavigationIcon() != null) {
      this.r = this.a.getNavigationIcon();
      return 15;
    } 
    return 11;
  }
  
  private void a(CharSequence paramCharSequence) {
    this.b = paramCharSequence;
    if ((this.e & 0x8) != 0)
      this.a.setTitle(paramCharSequence); 
  }
  
  private void b() {
    Drawable drawable;
    int i = this.e;
    if ((i & 0x2) != 0) {
      if ((i & 0x1) != 0) {
        drawable = this.j;
        if (drawable == null)
          drawable = this.i; 
      } else {
        drawable = this.i;
      } 
    } else {
      drawable = null;
    } 
    this.a.setLogo(drawable);
  }
  
  private void c() {
    if (this.g == null) {
      this.g = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
      Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(-2, -2, 8388627);
      this.g.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    } 
  }
  
  private void d() {
    if ((this.e & 0x4) != 0) {
      Toolbar toolbar = this.a;
      Drawable drawable = this.k;
      if (drawable == null)
        drawable = this.r; 
      toolbar.setNavigationIcon(drawable);
      return;
    } 
    this.a.setNavigationIcon((Drawable)null);
  }
  
  private void e() {
    if ((this.e & 0x4) != 0) {
      if (TextUtils.isEmpty(this.n)) {
        this.a.setNavigationContentDescription(this.q);
        return;
      } 
      this.a.setNavigationContentDescription(this.n);
    } 
  }
  
  public void animateToVisibility(int paramInt) {
    ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = setupAnimatorToVisibility(paramInt, 200L);
    if (viewPropertyAnimatorCompat != null)
      viewPropertyAnimatorCompat.start(); 
  }
  
  public boolean canShowOverflowMenu() {
    return this.a.canShowOverflowMenu();
  }
  
  public void collapseActionView() {
    this.a.collapseActionView();
  }
  
  public void dismissPopupMenus() {
    this.a.dismissPopupMenus();
  }
  
  public Context getContext() {
    return this.a.getContext();
  }
  
  public View getCustomView() {
    return this.h;
  }
  
  public int getDisplayOptions() {
    return this.e;
  }
  
  public int getDropdownItemCount() {
    Spinner spinner = this.g;
    return (spinner != null) ? spinner.getCount() : 0;
  }
  
  public int getDropdownSelectedPosition() {
    Spinner spinner = this.g;
    return (spinner != null) ? spinner.getSelectedItemPosition() : 0;
  }
  
  public int getHeight() {
    return this.a.getHeight();
  }
  
  public Menu getMenu() {
    return this.a.getMenu();
  }
  
  public int getNavigationMode() {
    return this.p;
  }
  
  public CharSequence getSubtitle() {
    return this.a.getSubtitle();
  }
  
  public CharSequence getTitle() {
    return this.a.getTitle();
  }
  
  public ViewGroup getViewGroup() {
    return this.a;
  }
  
  public int getVisibility() {
    return this.a.getVisibility();
  }
  
  public boolean hasEmbeddedTabs() {
    return (this.f != null);
  }
  
  public boolean hasExpandedActionView() {
    return this.a.hasExpandedActionView();
  }
  
  public boolean hasIcon() {
    return (this.i != null);
  }
  
  public boolean hasLogo() {
    return (this.j != null);
  }
  
  public boolean hideOverflowMenu() {
    return this.a.hideOverflowMenu();
  }
  
  public void initIndeterminateProgress() {
    Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
  }
  
  public void initProgress() {
    Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
  }
  
  public boolean isOverflowMenuShowPending() {
    return this.a.isOverflowMenuShowPending();
  }
  
  public boolean isOverflowMenuShowing() {
    return this.a.isOverflowMenuShowing();
  }
  
  public boolean isTitleTruncated() {
    return this.a.isTitleTruncated();
  }
  
  public void restoreHierarchyState(SparseArray<Parcelable> paramSparseArray) {
    this.a.restoreHierarchyState(paramSparseArray);
  }
  
  public void saveHierarchyState(SparseArray<Parcelable> paramSparseArray) {
    this.a.saveHierarchyState(paramSparseArray);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable) {
    ViewCompat.setBackground((View)this.a, paramDrawable);
  }
  
  public void setCollapsible(boolean paramBoolean) {
    this.a.setCollapsible(paramBoolean);
  }
  
  public void setCustomView(View paramView) {
    View view = this.h;
    if (view != null && (this.e & 0x10) != 0)
      this.a.removeView(view); 
    this.h = paramView;
    if (paramView != null && (this.e & 0x10) != 0)
      this.a.addView(this.h); 
  }
  
  public void setDefaultNavigationContentDescription(int paramInt) {
    if (paramInt == this.q)
      return; 
    this.q = paramInt;
    if (TextUtils.isEmpty(this.a.getNavigationContentDescription()))
      setNavigationContentDescription(this.q); 
  }
  
  public void setDefaultNavigationIcon(Drawable paramDrawable) {
    if (this.r != paramDrawable) {
      this.r = paramDrawable;
      d();
    } 
  }
  
  public void setDisplayOptions(int paramInt) {
    int i = this.e ^ paramInt;
    this.e = paramInt;
    if (i != 0) {
      if ((i & 0x4) != 0) {
        if ((paramInt & 0x4) != 0)
          e(); 
        d();
      } 
      if ((i & 0x3) != 0)
        b(); 
      if ((i & 0x8) != 0)
        if ((paramInt & 0x8) != 0) {
          this.a.setTitle(this.b);
          this.a.setSubtitle(this.m);
        } else {
          this.a.setTitle((CharSequence)null);
          this.a.setSubtitle((CharSequence)null);
        }  
      if ((i & 0x10) != 0) {
        View view = this.h;
        if (view != null) {
          if ((paramInt & 0x10) != 0) {
            this.a.addView(view);
            return;
          } 
          this.a.removeView(view);
        } 
      } 
    } 
  }
  
  public void setDropdownParams(SpinnerAdapter paramSpinnerAdapter, AdapterView.OnItemSelectedListener paramOnItemSelectedListener) {
    c();
    this.g.setAdapter(paramSpinnerAdapter);
    this.g.setOnItemSelectedListener(paramOnItemSelectedListener);
  }
  
  public void setDropdownSelectedPosition(int paramInt) {
    Spinner spinner = this.g;
    if (spinner != null) {
      spinner.setSelection(paramInt);
      return;
    } 
    throw new IllegalStateException("Can't set dropdown selected position without an adapter");
  }
  
  public void setEmbeddedTabView(ScrollingTabContainerView paramScrollingTabContainerView) {
    View view = this.f;
    if (view != null) {
      ViewParent viewParent = view.getParent();
      Toolbar toolbar = this.a;
      if (viewParent == toolbar)
        toolbar.removeView(this.f); 
    } 
    this.f = (View)paramScrollingTabContainerView;
    if (paramScrollingTabContainerView != null && this.p == 2) {
      this.a.addView(this.f, 0);
      Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams)this.f.getLayoutParams();
      layoutParams.width = -2;
      layoutParams.height = -2;
      layoutParams.gravity = 8388691;
      paramScrollingTabContainerView.setAllowCollapse(true);
    } 
  }
  
  public void setHomeButtonEnabled(boolean paramBoolean) {}
  
  public void setIcon(int paramInt) {
    Drawable drawable;
    if (paramInt != 0) {
      drawable = AppCompatResources.getDrawable(getContext(), paramInt);
    } else {
      drawable = null;
    } 
    setIcon(drawable);
  }
  
  public void setIcon(Drawable paramDrawable) {
    this.i = paramDrawable;
    b();
  }
  
  public void setLogo(int paramInt) {
    Drawable drawable;
    if (paramInt != 0) {
      drawable = AppCompatResources.getDrawable(getContext(), paramInt);
    } else {
      drawable = null;
    } 
    setLogo(drawable);
  }
  
  public void setLogo(Drawable paramDrawable) {
    this.j = paramDrawable;
    b();
  }
  
  public void setMenu(Menu paramMenu, MenuPresenter.Callback paramCallback) {
    if (this.o == null) {
      this.o = new ActionMenuPresenter(this.a.getContext());
      this.o.setId(R.id.action_menu_presenter);
    } 
    this.o.setCallback(paramCallback);
    this.a.setMenu((MenuBuilder)paramMenu, this.o);
  }
  
  public void setMenuCallbacks(MenuPresenter.Callback paramCallback, MenuBuilder.Callback paramCallback1) {
    this.a.setMenuCallbacks(paramCallback, paramCallback1);
  }
  
  public void setMenuPrepared() {
    this.d = true;
  }
  
  public void setNavigationContentDescription(int paramInt) {
    String str;
    if (paramInt == 0) {
      str = null;
    } else {
      str = getContext().getString(paramInt);
    } 
    setNavigationContentDescription(str);
  }
  
  public void setNavigationContentDescription(CharSequence paramCharSequence) {
    this.n = paramCharSequence;
    e();
  }
  
  public void setNavigationIcon(int paramInt) {
    Drawable drawable;
    if (paramInt != 0) {
      drawable = AppCompatResources.getDrawable(getContext(), paramInt);
    } else {
      drawable = null;
    } 
    setNavigationIcon(drawable);
  }
  
  public void setNavigationIcon(Drawable paramDrawable) {
    this.k = paramDrawable;
    d();
  }
  
  public void setNavigationMode(int paramInt) {
    int i = this.p;
    if (paramInt != i) {
      if (i != 1) {
        if (i == 2) {
          View view = this.f;
          if (view != null) {
            ViewParent viewParent = view.getParent();
            Toolbar toolbar = this.a;
            if (viewParent == toolbar)
              toolbar.removeView(this.f); 
          } 
        } 
      } else {
        Spinner spinner = this.g;
        if (spinner != null) {
          ViewParent viewParent = spinner.getParent();
          Toolbar toolbar = this.a;
          if (viewParent == toolbar)
            toolbar.removeView((View)this.g); 
        } 
      } 
      this.p = paramInt;
      if (paramInt != 0)
        if (paramInt != 1) {
          if (paramInt == 2) {
            View view = this.f;
            if (view != null) {
              this.a.addView(view, 0);
              Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams)this.f.getLayoutParams();
              layoutParams.width = -2;
              layoutParams.height = -2;
              layoutParams.gravity = 8388691;
              return;
            } 
          } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid navigation mode ");
            stringBuilder.append(paramInt);
            throw new IllegalArgumentException(stringBuilder.toString());
          } 
        } else {
          c();
          this.a.addView((View)this.g, 0);
        }  
    } 
  }
  
  public void setSubtitle(CharSequence paramCharSequence) {
    this.m = paramCharSequence;
    if ((this.e & 0x8) != 0)
      this.a.setSubtitle(paramCharSequence); 
  }
  
  public void setTitle(CharSequence paramCharSequence) {
    this.l = true;
    a(paramCharSequence);
  }
  
  public void setVisibility(int paramInt) {
    this.a.setVisibility(paramInt);
  }
  
  public void setWindowCallback(Window.Callback paramCallback) {
    this.c = paramCallback;
  }
  
  public void setWindowTitle(CharSequence paramCharSequence) {
    if (!this.l)
      a(paramCharSequence); 
  }
  
  public ViewPropertyAnimatorCompat setupAnimatorToVisibility(int paramInt, long paramLong) {
    float f;
    ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = ViewCompat.animate((View)this.a);
    if (paramInt == 0) {
      f = 1.0F;
    } else {
      f = 0.0F;
    } 
    return viewPropertyAnimatorCompat.alpha(f).setDuration(paramLong).setListener((ViewPropertyAnimatorListener)new ViewPropertyAnimatorListenerAdapter(this, paramInt) {
          private boolean c = false;
          
          public void onAnimationCancel(View param1View) {
            this.c = true;
          }
          
          public void onAnimationEnd(View param1View) {
            if (!this.c)
              this.b.a.setVisibility(this.a); 
          }
          
          public void onAnimationStart(View param1View) {
            this.b.a.setVisibility(0);
          }
        });
  }
  
  public boolean showOverflowMenu() {
    return this.a.showOverflowMenu();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\ToolbarWidgetWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */