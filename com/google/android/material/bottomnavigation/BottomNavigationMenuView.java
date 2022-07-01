package com.google.android.material.bottomnavigation;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.util.Pools;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.TextScale;
import java.util.HashSet;

public class BottomNavigationMenuView extends ViewGroup implements MenuView {
  private static final int[] a = new int[] { 16842912 };
  
  private static final int[] b = new int[] { -16842910 };
  
  private MenuBuilder A;
  
  private final TransitionSet c;
  
  private final int d;
  
  private final int e;
  
  private final int f;
  
  private final int g;
  
  private final int h;
  
  private final View.OnClickListener i;
  
  private final Pools.Pool<BottomNavigationItemView> j = (Pools.Pool<BottomNavigationItemView>)new Pools.SynchronizedPool(5);
  
  private boolean k;
  
  private int l;
  
  private BottomNavigationItemView[] m;
  
  private int n = 0;
  
  private int o = 0;
  
  private ColorStateList p;
  
  private int q;
  
  private ColorStateList r;
  
  private final ColorStateList s;
  
  private int t;
  
  private int u;
  
  private Drawable v;
  
  private int w;
  
  private int[] x;
  
  private SparseArray<BadgeDrawable> y = new SparseArray(5);
  
  private BottomNavigationPresenter z;
  
  public BottomNavigationMenuView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public BottomNavigationMenuView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    Resources resources = getResources();
    this.d = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
    this.e = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
    this.f = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
    this.g = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
    this.h = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_height);
    this.s = a(16842808);
    this.c = (TransitionSet)new AutoTransition();
    this.c.setOrdering(0);
    this.c.setDuration(115L);
    this.c.setInterpolator((TimeInterpolator)new FastOutSlowInInterpolator());
    this.c.addTransition((Transition)new TextScale());
    this.i = new View.OnClickListener(this) {
        public void onClick(View param1View) {
          MenuItemImpl menuItemImpl = ((BottomNavigationItemView)param1View).getItemData();
          if (!BottomNavigationMenuView.b(this.a).performItemAction((MenuItem)menuItemImpl, BottomNavigationMenuView.a(this.a), 0))
            menuItemImpl.setChecked(true); 
        }
      };
    this.x = new int[5];
    ViewCompat.setImportantForAccessibility((View)this, 1);
  }
  
  private boolean a(int paramInt1, int paramInt2) {
    if (paramInt1 == -1) {
      if (paramInt2 > 3)
        return true; 
    } else if (paramInt1 == 0) {
      return true;
    } 
    return false;
  }
  
  private boolean c(int paramInt) {
    return (paramInt != -1);
  }
  
  private void d() {
    int i;
    HashSet<Integer> hashSet = new HashSet();
    byte b = 0;
    int j = 0;
    while (true) {
      i = b;
      if (j < this.A.size()) {
        hashSet.add(Integer.valueOf(this.A.getItem(j).getItemId()));
        j++;
        continue;
      } 
      break;
    } 
    while (i < this.y.size()) {
      j = this.y.keyAt(i);
      if (!hashSet.contains(Integer.valueOf(j)))
        this.y.delete(j); 
      i++;
    } 
  }
  
  private BottomNavigationItemView getNewItem() {
    BottomNavigationItemView bottomNavigationItemView2 = (BottomNavigationItemView)this.j.acquire();
    BottomNavigationItemView bottomNavigationItemView1 = bottomNavigationItemView2;
    if (bottomNavigationItemView2 == null)
      bottomNavigationItemView1 = new BottomNavigationItemView(getContext()); 
    return bottomNavigationItemView1;
  }
  
  private void setBadgeIfNeeded(BottomNavigationItemView paramBottomNavigationItemView) {
    int i = paramBottomNavigationItemView.getId();
    if (!c(i))
      return; 
    BadgeDrawable badgeDrawable = (BadgeDrawable)this.y.get(i);
    if (badgeDrawable != null)
      paramBottomNavigationItemView.setBadge(badgeDrawable); 
  }
  
  public ColorStateList a(int paramInt) {
    TypedValue typedValue = new TypedValue();
    if (!getContext().getTheme().resolveAttribute(paramInt, typedValue, true))
      return null; 
    ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
    if (!getContext().getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true))
      return null; 
    paramInt = typedValue.data;
    int i = colorStateList.getDefaultColor();
    int[] arrayOfInt1 = b;
    int[] arrayOfInt2 = a;
    int[] arrayOfInt3 = EMPTY_STATE_SET;
    int j = colorStateList.getColorForState(b, i);
    return new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3 }, new int[] { j, paramInt, i });
  }
  
  public boolean a() {
    return this.k;
  }
  
  public void b() {
    removeAllViews();
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.m;
    if (arrayOfBottomNavigationItemView != null) {
      int k = arrayOfBottomNavigationItemView.length;
      for (int j = 0; j < k; j++) {
        BottomNavigationItemView bottomNavigationItemView = arrayOfBottomNavigationItemView[j];
        if (bottomNavigationItemView != null) {
          this.j.release(bottomNavigationItemView);
          bottomNavigationItemView.a();
        } 
      } 
    } 
    if (this.A.size() == 0) {
      this.n = 0;
      this.o = 0;
      this.m = null;
      return;
    } 
    d();
    this.m = new BottomNavigationItemView[this.A.size()];
    boolean bool = a(this.l, this.A.getVisibleItems().size());
    for (int i = 0; i < this.A.size(); i++) {
      this.z.a(true);
      this.A.getItem(i).setCheckable(true);
      this.z.a(false);
      BottomNavigationItemView bottomNavigationItemView = getNewItem();
      this.m[i] = bottomNavigationItemView;
      bottomNavigationItemView.setIconTintList(this.p);
      bottomNavigationItemView.setIconSize(this.q);
      bottomNavigationItemView.setTextColor(this.s);
      bottomNavigationItemView.setTextAppearanceInactive(this.t);
      bottomNavigationItemView.setTextAppearanceActive(this.u);
      bottomNavigationItemView.setTextColor(this.r);
      Drawable drawable = this.v;
      if (drawable != null) {
        bottomNavigationItemView.setItemBackground(drawable);
      } else {
        bottomNavigationItemView.setItemBackground(this.w);
      } 
      bottomNavigationItemView.setShifting(bool);
      bottomNavigationItemView.setLabelVisibilityMode(this.l);
      bottomNavigationItemView.initialize((MenuItemImpl)this.A.getItem(i), 0);
      bottomNavigationItemView.setItemPosition(i);
      bottomNavigationItemView.setOnClickListener(this.i);
      if (this.n != 0 && this.A.getItem(i).getItemId() == this.n)
        this.o = i; 
      setBadgeIfNeeded(bottomNavigationItemView);
      addView((View)bottomNavigationItemView);
    } 
    this.o = Math.min(this.A.size() - 1, this.o);
    this.A.getItem(this.o).setChecked(true);
  }
  
  void b(int paramInt) {
    int j = this.A.size();
    for (int i = 0; i < j; i++) {
      MenuItem menuItem = this.A.getItem(i);
      if (paramInt == menuItem.getItemId()) {
        this.n = paramInt;
        this.o = i;
        menuItem.setChecked(true);
        return;
      } 
    } 
  }
  
  public void c() {
    MenuBuilder menuBuilder = this.A;
    if (menuBuilder != null) {
      if (this.m == null)
        return; 
      int j = menuBuilder.size();
      if (j != this.m.length) {
        b();
        return;
      } 
      int k = this.n;
      int i;
      for (i = 0; i < j; i++) {
        MenuItem menuItem = this.A.getItem(i);
        if (menuItem.isChecked()) {
          this.n = menuItem.getItemId();
          this.o = i;
        } 
      } 
      if (k != this.n)
        TransitionManager.beginDelayedTransition(this, (Transition)this.c); 
      boolean bool = a(this.l, this.A.getVisibleItems().size());
      for (i = 0; i < j; i++) {
        this.z.a(true);
        this.m[i].setLabelVisibilityMode(this.l);
        this.m[i].setShifting(bool);
        this.m[i].initialize((MenuItemImpl)this.A.getItem(i), 0);
        this.z.a(false);
      } 
    } 
  }
  
  SparseArray<BadgeDrawable> getBadgeDrawables() {
    return this.y;
  }
  
  public ColorStateList getIconTintList() {
    return this.p;
  }
  
  public Drawable getItemBackground() {
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.m;
    return (arrayOfBottomNavigationItemView != null && arrayOfBottomNavigationItemView.length > 0) ? arrayOfBottomNavigationItemView[0].getBackground() : this.v;
  }
  
  @Deprecated
  public int getItemBackgroundRes() {
    return this.w;
  }
  
  public int getItemIconSize() {
    return this.q;
  }
  
  public int getItemTextAppearanceActive() {
    return this.u;
  }
  
  public int getItemTextAppearanceInactive() {
    return this.t;
  }
  
  public ColorStateList getItemTextColor() {
    return this.r;
  }
  
  public int getLabelVisibilityMode() {
    return this.l;
  }
  
  public int getSelectedItemId() {
    return this.n;
  }
  
  public int getWindowAnimations() {
    return 0;
  }
  
  public void initialize(MenuBuilder paramMenuBuilder) {
    this.A = paramMenuBuilder;
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo) {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    AccessibilityNodeInfoCompat.wrap(paramAccessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.A.getVisibleItems().size(), false, 1));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i = getChildCount();
    int j = paramInt4 - paramInt2;
    paramInt2 = 0;
    paramInt4 = 0;
    while (paramInt2 < i) {
      View view = getChildAt(paramInt2);
      if (view.getVisibility() != 8) {
        if (ViewCompat.getLayoutDirection((View)this) == 1) {
          int k = paramInt3 - paramInt1 - paramInt4;
          view.layout(k - view.getMeasuredWidth(), 0, k, j);
        } else {
          view.layout(paramInt4, 0, view.getMeasuredWidth() + paramInt4, j);
        } 
        paramInt4 += view.getMeasuredWidth();
      } 
      paramInt2++;
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    int j = View.MeasureSpec.getSize(paramInt1);
    int i = this.A.getVisibleItems().size();
    int k = getChildCount();
    int m = View.MeasureSpec.makeMeasureSpec(this.h, 1073741824);
    if (a(this.l, i) && this.k) {
      View view = getChildAt(this.o);
      paramInt2 = this.g;
      paramInt1 = paramInt2;
      if (view.getVisibility() != 8) {
        view.measure(View.MeasureSpec.makeMeasureSpec(this.f, -2147483648), m);
        paramInt1 = Math.max(paramInt2, view.getMeasuredWidth());
      } 
      if (view.getVisibility() != 8) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      } 
      paramInt2 = i - paramInt2;
      int n = Math.min(j - this.e * paramInt2, Math.min(paramInt1, this.f));
      i = j - n;
      if (paramInt2 == 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = paramInt2;
      } 
      j = Math.min(i / paramInt1, this.d);
      paramInt2 = i - paramInt2 * j;
      paramInt1 = 0;
      while (paramInt1 < k) {
        if (getChildAt(paramInt1).getVisibility() != 8) {
          int[] arrayOfInt = this.x;
          if (paramInt1 == this.o) {
            i = n;
          } else {
            i = j;
          } 
          arrayOfInt[paramInt1] = i;
          i = paramInt2;
          if (paramInt2 > 0) {
            arrayOfInt = this.x;
            arrayOfInt[paramInt1] = arrayOfInt[paramInt1] + 1;
            i = paramInt2 - 1;
          } 
        } else {
          this.x[paramInt1] = 0;
          i = paramInt2;
        } 
        paramInt1++;
        paramInt2 = i;
      } 
    } else {
      if (i == 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = i;
      } 
      int n = Math.min(j / paramInt1, this.f);
      paramInt2 = j - i * n;
      paramInt1 = 0;
      while (paramInt1 < k) {
        if (getChildAt(paramInt1).getVisibility() != 8) {
          int[] arrayOfInt = this.x;
          arrayOfInt[paramInt1] = n;
          i = paramInt2;
          if (paramInt2 > 0) {
            arrayOfInt[paramInt1] = arrayOfInt[paramInt1] + 1;
            i = paramInt2 - 1;
          } 
        } else {
          this.x[paramInt1] = 0;
          i = paramInt2;
        } 
        paramInt1++;
        paramInt2 = i;
      } 
    } 
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt1 < k) {
      View view = getChildAt(paramInt1);
      if (view.getVisibility() != 8) {
        view.measure(View.MeasureSpec.makeMeasureSpec(this.x[paramInt1], 1073741824), m);
        (view.getLayoutParams()).width = view.getMeasuredWidth();
        paramInt2 += view.getMeasuredWidth();
      } 
      paramInt1++;
    } 
    setMeasuredDimension(View.resolveSizeAndState(paramInt2, View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824), 0), View.resolveSizeAndState(this.h, m, 0));
  }
  
  void setBadgeDrawables(SparseArray<BadgeDrawable> paramSparseArray) {
    this.y = paramSparseArray;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.m;
    if (arrayOfBottomNavigationItemView != null) {
      int j = arrayOfBottomNavigationItemView.length;
      for (int i = 0; i < j; i++) {
        BottomNavigationItemView bottomNavigationItemView = arrayOfBottomNavigationItemView[i];
        bottomNavigationItemView.setBadge((BadgeDrawable)paramSparseArray.get(bottomNavigationItemView.getId()));
      } 
    } 
  }
  
  public void setIconTintList(ColorStateList paramColorStateList) {
    this.p = paramColorStateList;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.m;
    if (arrayOfBottomNavigationItemView != null) {
      int j = arrayOfBottomNavigationItemView.length;
      for (int i = 0; i < j; i++)
        arrayOfBottomNavigationItemView[i].setIconTintList(paramColorStateList); 
    } 
  }
  
  public void setItemBackground(Drawable paramDrawable) {
    this.v = paramDrawable;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.m;
    if (arrayOfBottomNavigationItemView != null) {
      int j = arrayOfBottomNavigationItemView.length;
      for (int i = 0; i < j; i++)
        arrayOfBottomNavigationItemView[i].setItemBackground(paramDrawable); 
    } 
  }
  
  public void setItemBackgroundRes(int paramInt) {
    this.w = paramInt;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.m;
    if (arrayOfBottomNavigationItemView != null) {
      int j = arrayOfBottomNavigationItemView.length;
      for (int i = 0; i < j; i++)
        arrayOfBottomNavigationItemView[i].setItemBackground(paramInt); 
    } 
  }
  
  public void setItemHorizontalTranslationEnabled(boolean paramBoolean) {
    this.k = paramBoolean;
  }
  
  public void setItemIconSize(int paramInt) {
    this.q = paramInt;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.m;
    if (arrayOfBottomNavigationItemView != null) {
      int j = arrayOfBottomNavigationItemView.length;
      for (int i = 0; i < j; i++)
        arrayOfBottomNavigationItemView[i].setIconSize(paramInt); 
    } 
  }
  
  public void setItemTextAppearanceActive(int paramInt) {
    this.u = paramInt;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.m;
    if (arrayOfBottomNavigationItemView != null) {
      int j = arrayOfBottomNavigationItemView.length;
      for (int i = 0; i < j; i++) {
        BottomNavigationItemView bottomNavigationItemView = arrayOfBottomNavigationItemView[i];
        bottomNavigationItemView.setTextAppearanceActive(paramInt);
        ColorStateList colorStateList = this.r;
        if (colorStateList != null)
          bottomNavigationItemView.setTextColor(colorStateList); 
      } 
    } 
  }
  
  public void setItemTextAppearanceInactive(int paramInt) {
    this.t = paramInt;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.m;
    if (arrayOfBottomNavigationItemView != null) {
      int j = arrayOfBottomNavigationItemView.length;
      for (int i = 0; i < j; i++) {
        BottomNavigationItemView bottomNavigationItemView = arrayOfBottomNavigationItemView[i];
        bottomNavigationItemView.setTextAppearanceInactive(paramInt);
        ColorStateList colorStateList = this.r;
        if (colorStateList != null)
          bottomNavigationItemView.setTextColor(colorStateList); 
      } 
    } 
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList) {
    this.r = paramColorStateList;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.m;
    if (arrayOfBottomNavigationItemView != null) {
      int j = arrayOfBottomNavigationItemView.length;
      for (int i = 0; i < j; i++)
        arrayOfBottomNavigationItemView[i].setTextColor(paramColorStateList); 
    } 
  }
  
  public void setLabelVisibilityMode(int paramInt) {
    this.l = paramInt;
  }
  
  public void setPresenter(BottomNavigationPresenter paramBottomNavigationPresenter) {
    this.z = paramBottomNavigationPresenter;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\bottomnavigation\BottomNavigationMenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */