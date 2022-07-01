package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;

public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {
  MenuBuilder.Callback a;
  
  OnMenuItemClickListener b;
  
  private MenuBuilder c;
  
  private Context d;
  
  private int e;
  
  private boolean f;
  
  private ActionMenuPresenter g;
  
  private MenuPresenter.Callback h;
  
  private boolean i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  public ActionMenuView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public ActionMenuView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    setBaselineAligned(false);
    float f = (paramContext.getResources().getDisplayMetrics()).density;
    this.k = (int)(56.0F * f);
    this.l = (int)(f * 4.0F);
    this.d = paramContext;
    this.e = 0;
  }
  
  static int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    ActionMenuItemView actionMenuItemView;
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt3) - paramInt4, View.MeasureSpec.getMode(paramInt3));
    if (paramView instanceof ActionMenuItemView) {
      actionMenuItemView = (ActionMenuItemView)paramView;
    } else {
      actionMenuItemView = null;
    } 
    boolean bool = true;
    if (actionMenuItemView != null && actionMenuItemView.hasText()) {
      paramInt3 = 1;
    } else {
      paramInt3 = 0;
    } 
    paramInt4 = 2;
    if (paramInt2 > 0 && (paramInt3 == 0 || paramInt2 >= 2)) {
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt2 * paramInt1, -2147483648), i);
      int k = paramView.getMeasuredWidth();
      int j = k / paramInt1;
      paramInt2 = j;
      if (k % paramInt1 != 0)
        paramInt2 = j + 1; 
      if (paramInt3 != 0 && paramInt2 < 2)
        paramInt2 = paramInt4; 
    } else {
      paramInt2 = 0;
    } 
    if (layoutParams.isOverflowButton || paramInt3 == 0)
      bool = false; 
    layoutParams.expandable = bool;
    layoutParams.cellsUsed = paramInt2;
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 * paramInt2, 1073741824), i);
    return paramInt2;
  }
  
  private void c(int paramInt1, int paramInt2) {
    int i3 = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt2);
    int j = getPaddingLeft();
    int k = getPaddingRight();
    int i4 = getPaddingTop() + getPaddingBottom();
    int i7 = getChildMeasureSpec(paramInt2, i4, -2);
    int i6 = paramInt1 - j + k;
    paramInt2 = this.k;
    paramInt1 = i6 / paramInt2;
    if (paramInt1 == 0) {
      setMeasuredDimension(i6, 0);
      return;
    } 
    int i8 = paramInt2 + i6 % paramInt2 / paramInt1;
    int i9 = getChildCount();
    int i2 = 0;
    paramInt2 = 0;
    j = 0;
    int i1 = 0;
    int n = 0;
    k = 0;
    long l = 0L;
    while (i2 < i9) {
      View view = getChildAt(i2);
      if (view.getVisibility() != 8) {
        boolean bool = view instanceof ActionMenuItemView;
        i1++;
        if (bool) {
          i10 = this.l;
          view.setPadding(i10, 0, i10, 0);
        } 
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        layoutParams.a = false;
        layoutParams.extraPixels = 0;
        layoutParams.cellsUsed = 0;
        layoutParams.expandable = false;
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        if (bool && ((ActionMenuItemView)view).hasText()) {
          bool = true;
        } else {
          bool = false;
        } 
        layoutParams.preventEdgeOffset = bool;
        if (layoutParams.isOverflowButton) {
          i10 = 1;
        } else {
          i10 = paramInt1;
        } 
        int i11 = a(view, i8, i10, i7, i4);
        n = Math.max(n, i11);
        int i10 = k;
        if (layoutParams.expandable)
          i10 = k + 1; 
        if (layoutParams.isOverflowButton)
          j = 1; 
        paramInt1 -= i11;
        paramInt2 = Math.max(paramInt2, view.getMeasuredHeight());
        if (i11 == 1)
          l |= (1 << i2); 
        k = i10;
      } 
      i2++;
    } 
    if (j != 0 && i1 == 2) {
      i4 = 1;
    } else {
      i4 = 0;
    } 
    int m = 0;
    int i5 = paramInt1;
    paramInt1 = m;
    i2 = i6;
    while (k > 0 && i5 > 0) {
      i6 = Integer.MAX_VALUE;
      int i10 = 0;
      int i11 = 0;
      long l1;
      for (l1 = 0L; i10 < i9; l1 = l2) {
        int i12;
        long l2;
        LayoutParams layoutParams = (LayoutParams)getChildAt(i10).getLayoutParams();
        if (!layoutParams.expandable) {
          i12 = i6;
          m = i11;
          l2 = l1;
        } else if (layoutParams.cellsUsed < i6) {
          i12 = layoutParams.cellsUsed;
          l2 = 1L << i10;
          m = 1;
        } else {
          i12 = i6;
          m = i11;
          l2 = l1;
          if (layoutParams.cellsUsed == i6) {
            l2 = l1 | 1L << i10;
            m = i11 + 1;
            i12 = i6;
          } 
        } 
        i10++;
        i6 = i12;
        i11 = m;
      } 
      m = paramInt1;
      paramInt1 = paramInt2;
      l |= l1;
      if (i11 > i5) {
        paramInt2 = paramInt1;
        paramInt1 = m;
        break;
      } 
      paramInt2 = i6 + 1;
      for (m = 0; m < i9; m++) {
        View view = getChildAt(m);
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        long l2 = (1 << m);
        if ((l1 & l2) == 0L) {
          long l3 = l;
          if (layoutParams.cellsUsed == paramInt2)
            l3 = l | l2; 
          l = l3;
        } else {
          if (i4 != 0 && layoutParams.preventEdgeOffset && i5 == 1) {
            i6 = this.l;
            view.setPadding(i6 + i8, 0, i6, 0);
          } 
          layoutParams.cellsUsed++;
          layoutParams.a = true;
          i5--;
        } 
      } 
      paramInt2 = paramInt1;
      paramInt1 = 1;
    } 
    if (j == 0 && i1 == 1) {
      j = 1;
    } else {
      j = 0;
    } 
    if (i5 > 0 && l != 0L && (i5 < i1 - 1 || j != 0 || n > 1)) {
      float f = Long.bitCount(l);
      if (j == 0) {
        float f1 = f;
        if ((l & 0x1L) != 0L) {
          f1 = f;
          if (!((LayoutParams)getChildAt(0).getLayoutParams()).preventEdgeOffset)
            f1 = f - 0.5F; 
        } 
        j = i9 - 1;
        f = f1;
        if ((l & (1 << j)) != 0L) {
          f = f1;
          if (!((LayoutParams)getChildAt(j).getLayoutParams()).preventEdgeOffset)
            f = f1 - 0.5F; 
        } 
      } 
      if (f > 0.0F) {
        j = (int)((i5 * i8) / f);
      } else {
        j = 0;
      } 
      k = 0;
      while (true) {
        m = paramInt1;
        if (k < i9) {
          if ((l & (1 << k)) == 0L) {
            m = paramInt1;
          } else {
            View view = getChildAt(k);
            LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
            if (view instanceof ActionMenuItemView) {
              layoutParams.extraPixels = j;
              layoutParams.a = true;
              if (k == 0 && !layoutParams.preventEdgeOffset)
                layoutParams.leftMargin = -j / 2; 
            } else if (layoutParams.isOverflowButton) {
              layoutParams.extraPixels = j;
              layoutParams.a = true;
              layoutParams.rightMargin = -j / 2;
            } else {
              if (k != 0)
                layoutParams.leftMargin = j / 2; 
              m = paramInt1;
              if (k != i9 - 1) {
                layoutParams.rightMargin = j / 2;
                m = paramInt1;
              } 
              k++;
              paramInt1 = m;
            } 
            m = 1;
          } 
        } else {
          break;
        } 
        k++;
        paramInt1 = m;
      } 
    } else {
      m = paramInt1;
    } 
    paramInt1 = 0;
    if (m != 0)
      while (paramInt1 < i9) {
        View view = getChildAt(paramInt1);
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (layoutParams.a)
          view.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.cellsUsed * i8 + layoutParams.extraPixels, 1073741824), i7); 
        paramInt1++;
      }  
    if (i3 == 1073741824)
      paramInt2 = i; 
    setMeasuredDimension(i2, paramInt2);
  }
  
  protected LayoutParams a() {
    LayoutParams layoutParams = new LayoutParams(-2, -2);
    layoutParams.gravity = 16;
    return layoutParams;
  }
  
  protected LayoutParams a(ViewGroup.LayoutParams paramLayoutParams) {
    if (paramLayoutParams != null) {
      LayoutParams layoutParams;
      if (paramLayoutParams instanceof LayoutParams) {
        layoutParams = new LayoutParams((LayoutParams)paramLayoutParams);
      } else {
        layoutParams = new LayoutParams((ViewGroup.LayoutParams)layoutParams);
      } 
      if (layoutParams.gravity <= 0)
        layoutParams.gravity = 16; 
      return layoutParams;
    } 
    return a();
  }
  
  protected boolean a(int paramInt) {
    boolean bool;
    int j = 0;
    if (paramInt == 0)
      return false; 
    View view1 = getChildAt(paramInt - 1);
    View view2 = getChildAt(paramInt);
    int i = j;
    if (paramInt < getChildCount()) {
      i = j;
      if (view1 instanceof ActionMenuChildView)
        i = false | ((ActionMenuChildView)view1).needsDividerAfter(); 
    } 
    j = i;
    if (paramInt > 0) {
      j = i;
      if (view2 instanceof ActionMenuChildView)
        bool = i | ((ActionMenuChildView)view2).needsDividerBefore(); 
    } 
    return bool;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void dismissPopupMenus() {
    ActionMenuPresenter actionMenuPresenter = this.g;
    if (actionMenuPresenter != null)
      actionMenuPresenter.dismissPopupMenus(); 
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
    return false;
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  public LayoutParams generateOverflowButtonLayoutParams() {
    LayoutParams layoutParams = a();
    layoutParams.isOverflowButton = true;
    return layoutParams;
  }
  
  public Menu getMenu() {
    if (this.c == null) {
      Context context = getContext();
      this.c = new MenuBuilder(context);
      this.c.setCallback(new MenuBuilderCallback(this));
      this.g = new ActionMenuPresenter(context);
      this.g.setReserveOverflow(true);
      ActionMenuPresenter actionMenuPresenter = this.g;
      MenuPresenter.Callback callback = this.h;
      if (callback == null)
        callback = new ActionMenuPresenterCallback(); 
      actionMenuPresenter.setCallback(callback);
      this.c.addMenuPresenter((MenuPresenter)this.g, this.d);
      this.g.setMenuView(this);
    } 
    return (Menu)this.c;
  }
  
  public Drawable getOverflowIcon() {
    getMenu();
    return this.g.getOverflowIcon();
  }
  
  public int getPopupTheme() {
    return this.e;
  }
  
  public int getWindowAnimations() {
    return 0;
  }
  
  public boolean hideOverflowMenu() {
    ActionMenuPresenter actionMenuPresenter = this.g;
    return (actionMenuPresenter != null && actionMenuPresenter.hideOverflowMenu());
  }
  
  public void initialize(MenuBuilder paramMenuBuilder) {
    this.c = paramMenuBuilder;
  }
  
  public boolean invokeItem(MenuItemImpl paramMenuItemImpl) {
    return this.c.performItemAction((MenuItem)paramMenuItemImpl, 0);
  }
  
  public boolean isOverflowMenuShowPending() {
    ActionMenuPresenter actionMenuPresenter = this.g;
    return (actionMenuPresenter != null && actionMenuPresenter.isOverflowMenuShowPending());
  }
  
  public boolean isOverflowMenuShowing() {
    ActionMenuPresenter actionMenuPresenter = this.g;
    return (actionMenuPresenter != null && actionMenuPresenter.isOverflowMenuShowing());
  }
  
  public boolean isOverflowReserved() {
    return this.f;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
    ActionMenuPresenter actionMenuPresenter = this.g;
    if (actionMenuPresenter != null) {
      actionMenuPresenter.updateMenuView(false);
      if (this.g.isOverflowMenuShowing()) {
        this.g.hideOverflowMenu();
        this.g.showOverflowMenu();
      } 
    } 
  }
  
  public void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    dismissPopupMenus();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!this.i) {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    } 
    int k = getChildCount();
    int j = (paramInt4 - paramInt2) / 2;
    int m = getDividerWidth();
    int n = paramInt3 - paramInt1;
    paramInt1 = getPaddingRight();
    paramInt2 = getPaddingLeft();
    paramBoolean = ViewUtils.isLayoutRtl((View)this);
    paramInt1 = n - paramInt1 - paramInt2;
    paramInt2 = 0;
    paramInt4 = 0;
    paramInt3 = 0;
    while (paramInt2 < k) {
      View view = getChildAt(paramInt2);
      if (view.getVisibility() != 8) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (layoutParams.isOverflowButton) {
          int i2;
          int i1 = view.getMeasuredWidth();
          paramInt4 = i1;
          if (a(paramInt2))
            paramInt4 = i1 + m; 
          int i3 = view.getMeasuredHeight();
          if (paramBoolean) {
            i2 = getPaddingLeft() + layoutParams.leftMargin;
            i1 = i2 + paramInt4;
          } else {
            i1 = getWidth() - getPaddingRight() - layoutParams.rightMargin;
            i2 = i1 - paramInt4;
          } 
          int i4 = j - i3 / 2;
          view.layout(i2, i4, i1, i3 + i4);
          paramInt1 -= paramInt4;
          paramInt4 = 1;
        } else {
          paramInt1 -= view.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
          a(paramInt2);
          paramInt3++;
        } 
      } 
      paramInt2++;
    } 
    if (k == 1 && paramInt4 == 0) {
      View view = getChildAt(0);
      paramInt1 = view.getMeasuredWidth();
      paramInt2 = view.getMeasuredHeight();
      paramInt3 = n / 2 - paramInt1 / 2;
      paramInt4 = j - paramInt2 / 2;
      view.layout(paramInt3, paramInt4, paramInt1 + paramInt3, paramInt2 + paramInt4);
      return;
    } 
    paramInt2 = paramInt3 - (paramInt4 ^ 0x1);
    if (paramInt2 > 0) {
      paramInt1 /= paramInt2;
    } else {
      paramInt1 = 0;
    } 
    paramInt4 = 0;
    paramInt3 = 0;
    int i = Math.max(0, paramInt1);
    if (paramBoolean) {
      paramInt2 = getWidth() - getPaddingRight();
      paramInt1 = paramInt3;
      while (paramInt1 < k) {
        View view = getChildAt(paramInt1);
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        paramInt3 = paramInt2;
        if (view.getVisibility() != 8)
          if (layoutParams.isOverflowButton) {
            paramInt3 = paramInt2;
          } else {
            paramInt2 -= layoutParams.rightMargin;
            paramInt3 = view.getMeasuredWidth();
            paramInt4 = view.getMeasuredHeight();
            int i1 = j - paramInt4 / 2;
            view.layout(paramInt2 - paramInt3, i1, paramInt2, paramInt4 + i1);
            paramInt3 = paramInt2 - paramInt3 + layoutParams.leftMargin + i;
          }  
        paramInt1++;
        paramInt2 = paramInt3;
      } 
    } else {
      paramInt2 = getPaddingLeft();
      paramInt1 = paramInt4;
      while (paramInt1 < k) {
        View view = getChildAt(paramInt1);
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        paramInt3 = paramInt2;
        if (view.getVisibility() != 8)
          if (layoutParams.isOverflowButton) {
            paramInt3 = paramInt2;
          } else {
            paramInt2 += layoutParams.leftMargin;
            paramInt3 = view.getMeasuredWidth();
            paramInt4 = view.getMeasuredHeight();
            int i1 = j - paramInt4 / 2;
            view.layout(paramInt2, i1, paramInt2 + paramInt3, paramInt4 + i1);
            paramInt3 = paramInt2 + paramInt3 + layoutParams.rightMargin + i;
          }  
        paramInt1++;
        paramInt2 = paramInt3;
      } 
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    boolean bool;
    boolean bool1 = this.i;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824) {
      bool = true;
    } else {
      bool = false;
    } 
    this.i = bool;
    if (bool1 != this.i)
      this.j = 0; 
    int i = View.MeasureSpec.getSize(paramInt1);
    if (this.i) {
      MenuBuilder menuBuilder = this.c;
      if (menuBuilder != null && i != this.j) {
        this.j = i;
        menuBuilder.onItemsChanged(true);
      } 
    } 
    int j = getChildCount();
    if (this.i && j > 0) {
      c(paramInt1, paramInt2);
      return;
    } 
    for (i = 0; i < j; i++) {
      LayoutParams layoutParams = (LayoutParams)getChildAt(i).getLayoutParams();
      layoutParams.rightMargin = 0;
      layoutParams.leftMargin = 0;
    } 
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public MenuBuilder peekMenu() {
    return this.c;
  }
  
  public void setExpandedActionViewsExclusive(boolean paramBoolean) {
    this.g.setExpandedActionViewsExclusive(paramBoolean);
  }
  
  public void setMenuCallbacks(MenuPresenter.Callback paramCallback, MenuBuilder.Callback paramCallback1) {
    this.h = paramCallback;
    this.a = paramCallback1;
  }
  
  public void setOnMenuItemClickListener(OnMenuItemClickListener paramOnMenuItemClickListener) {
    this.b = paramOnMenuItemClickListener;
  }
  
  public void setOverflowIcon(Drawable paramDrawable) {
    getMenu();
    this.g.setOverflowIcon(paramDrawable);
  }
  
  public void setOverflowReserved(boolean paramBoolean) {
    this.f = paramBoolean;
  }
  
  public void setPopupTheme(int paramInt) {
    if (this.e != paramInt) {
      this.e = paramInt;
      if (paramInt == 0) {
        this.d = getContext();
        return;
      } 
      this.d = (Context)new ContextThemeWrapper(getContext(), paramInt);
    } 
  }
  
  public void setPresenter(ActionMenuPresenter paramActionMenuPresenter) {
    this.g = paramActionMenuPresenter;
    this.g.setMenuView(this);
  }
  
  public boolean showOverflowMenu() {
    ActionMenuPresenter actionMenuPresenter = this.g;
    return (actionMenuPresenter != null && actionMenuPresenter.showOverflowMenu());
  }
  
  public static interface ActionMenuChildView {
    boolean needsDividerAfter();
    
    boolean needsDividerBefore();
  }
  
  static class ActionMenuPresenterCallback implements MenuPresenter.Callback {
    public void onCloseMenu(MenuBuilder param1MenuBuilder, boolean param1Boolean) {}
    
    public boolean onOpenSubMenu(MenuBuilder param1MenuBuilder) {
      return false;
    }
  }
  
  public static class LayoutParams extends LinearLayoutCompat.LayoutParams {
    boolean a;
    
    @ExportedProperty
    public int cellsUsed;
    
    @ExportedProperty
    public boolean expandable;
    
    @ExportedProperty
    public int extraPixels;
    
    @ExportedProperty
    public boolean isOverflowButton;
    
    @ExportedProperty
    public boolean preventEdgeOffset;
    
    public LayoutParams(int param1Int1, int param1Int2) {
      super(param1Int1, param1Int2);
      this.isOverflowButton = false;
    }
    
    public LayoutParams(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
    }
    
    public LayoutParams(LayoutParams param1LayoutParams) {
      super((ViewGroup.LayoutParams)param1LayoutParams);
      this.isOverflowButton = param1LayoutParams.isOverflowButton;
    }
  }
  
  class MenuBuilderCallback implements MenuBuilder.Callback {
    MenuBuilderCallback(ActionMenuView this$0) {}
    
    public boolean onMenuItemSelected(MenuBuilder param1MenuBuilder, MenuItem param1MenuItem) {
      return (this.a.b != null && this.a.b.onMenuItemClick(param1MenuItem));
    }
    
    public void onMenuModeChange(MenuBuilder param1MenuBuilder) {
      if (this.a.a != null)
        this.a.a.onMenuModeChange(param1MenuBuilder); 
    }
  }
  
  public static interface OnMenuItemClickListener {
    boolean onMenuItemClick(MenuItem param1MenuItem);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\ActionMenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */