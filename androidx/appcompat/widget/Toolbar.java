package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
  private ColorStateList A;
  
  private ColorStateList B;
  
  private boolean C;
  
  private boolean D;
  
  private final ArrayList<View> E = new ArrayList<View>();
  
  private final ArrayList<View> F = new ArrayList<View>();
  
  private final int[] G = new int[2];
  
  private final ActionMenuView.OnMenuItemClickListener H = new ActionMenuView.OnMenuItemClickListener(this) {
      public boolean onMenuItemClick(MenuItem param1MenuItem) {
        return (this.a.d != null) ? this.a.d.onMenuItemClick(param1MenuItem) : false;
      }
    };
  
  private ToolbarWidgetWrapper I;
  
  private ActionMenuPresenter J;
  
  private ExpandedActionViewMenuPresenter K;
  
  private MenuPresenter.Callback L;
  
  private MenuBuilder.Callback M;
  
  private boolean N;
  
  private final Runnable O = new Runnable(this) {
      public void run() {
        this.a.showOverflowMenu();
      }
    };
  
  ImageButton a;
  
  View b;
  
  int c;
  
  OnMenuItemClickListener d;
  
  private ActionMenuView e;
  
  private TextView f;
  
  private TextView g;
  
  private ImageButton h;
  
  private ImageView i;
  
  private Drawable j;
  
  private CharSequence k;
  
  private Context l;
  
  private int m;
  
  private int n;
  
  private int o;
  
  private int p;
  
  private int q;
  
  private int r;
  
  private int s;
  
  private int t;
  
  private RtlSpacingHelper u;
  
  private int v;
  
  private int w;
  
  private int x = 8388627;
  
  private CharSequence y;
  
  private CharSequence z;
  
  public Toolbar(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.toolbarStyle);
  }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(getContext(), paramAttributeSet, R.styleable.Toolbar, paramInt, 0);
    this.n = tintTypedArray.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
    this.o = tintTypedArray.getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
    this.x = tintTypedArray.getInteger(R.styleable.Toolbar_android_gravity, this.x);
    this.c = tintTypedArray.getInteger(R.styleable.Toolbar_buttonGravity, 48);
    int i = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMargin, 0);
    paramInt = i;
    if (tintTypedArray.hasValue(R.styleable.Toolbar_titleMargins))
      paramInt = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMargins, i); 
    this.t = paramInt;
    this.s = paramInt;
    this.r = paramInt;
    this.q = paramInt;
    paramInt = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginStart, -1);
    if (paramInt >= 0)
      this.q = paramInt; 
    paramInt = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginEnd, -1);
    if (paramInt >= 0)
      this.r = paramInt; 
    paramInt = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginTop, -1);
    if (paramInt >= 0)
      this.s = paramInt; 
    paramInt = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginBottom, -1);
    if (paramInt >= 0)
      this.t = paramInt; 
    this.p = tintTypedArray.getDimensionPixelSize(R.styleable.Toolbar_maxButtonHeight, -1);
    paramInt = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStart, -2147483648);
    i = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEnd, -2147483648);
    int j = tintTypedArray.getDimensionPixelSize(R.styleable.Toolbar_contentInsetLeft, 0);
    int k = tintTypedArray.getDimensionPixelSize(R.styleable.Toolbar_contentInsetRight, 0);
    k();
    this.u.setAbsolute(j, k);
    if (paramInt != Integer.MIN_VALUE || i != Integer.MIN_VALUE)
      this.u.setRelative(paramInt, i); 
    this.v = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStartWithNavigation, -2147483648);
    this.w = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEndWithActions, -2147483648);
    this.j = tintTypedArray.getDrawable(R.styleable.Toolbar_collapseIcon);
    this.k = tintTypedArray.getText(R.styleable.Toolbar_collapseContentDescription);
    CharSequence charSequence3 = tintTypedArray.getText(R.styleable.Toolbar_title);
    if (!TextUtils.isEmpty(charSequence3))
      setTitle(charSequence3); 
    charSequence3 = tintTypedArray.getText(R.styleable.Toolbar_subtitle);
    if (!TextUtils.isEmpty(charSequence3))
      setSubtitle(charSequence3); 
    this.l = getContext();
    setPopupTheme(tintTypedArray.getResourceId(R.styleable.Toolbar_popupTheme, 0));
    Drawable drawable2 = tintTypedArray.getDrawable(R.styleable.Toolbar_navigationIcon);
    if (drawable2 != null)
      setNavigationIcon(drawable2); 
    CharSequence charSequence2 = tintTypedArray.getText(R.styleable.Toolbar_navigationContentDescription);
    if (!TextUtils.isEmpty(charSequence2))
      setNavigationContentDescription(charSequence2); 
    Drawable drawable1 = tintTypedArray.getDrawable(R.styleable.Toolbar_logo);
    if (drawable1 != null)
      setLogo(drawable1); 
    CharSequence charSequence1 = tintTypedArray.getText(R.styleable.Toolbar_logoDescription);
    if (!TextUtils.isEmpty(charSequence1))
      setLogoDescription(charSequence1); 
    if (tintTypedArray.hasValue(R.styleable.Toolbar_titleTextColor))
      setTitleTextColor(tintTypedArray.getColorStateList(R.styleable.Toolbar_titleTextColor)); 
    if (tintTypedArray.hasValue(R.styleable.Toolbar_subtitleTextColor))
      setSubtitleTextColor(tintTypedArray.getColorStateList(R.styleable.Toolbar_subtitleTextColor)); 
    if (tintTypedArray.hasValue(R.styleable.Toolbar_menu))
      inflateMenu(tintTypedArray.getResourceId(R.styleable.Toolbar_menu, 0)); 
    tintTypedArray.recycle();
  }
  
  private int a(int paramInt) {
    int i = paramInt & 0x70;
    paramInt = i;
    if (i != 16) {
      paramInt = i;
      if (i != 48) {
        paramInt = i;
        if (i != 80)
          paramInt = this.x & 0x70; 
      } 
    } 
    return paramInt;
  }
  
  private int a(View paramView, int paramInt) {
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    int j = paramView.getMeasuredHeight();
    if (paramInt > 0) {
      paramInt = (j - paramInt) / 2;
    } else {
      paramInt = 0;
    } 
    int i = a(layoutParams.gravity);
    if (i != 48) {
      if (i != 80) {
        int k = getPaddingTop();
        paramInt = getPaddingBottom();
        int m = getHeight();
        i = (m - k - paramInt - j) / 2;
        if (i < layoutParams.topMargin) {
          paramInt = layoutParams.topMargin;
        } else {
          j = m - paramInt - j - i - k;
          paramInt = i;
          if (j < layoutParams.bottomMargin)
            paramInt = Math.max(0, i - layoutParams.bottomMargin - j); 
        } 
        return k + paramInt;
      } 
      return getHeight() - getPaddingBottom() - j - layoutParams.bottomMargin - paramInt;
    } 
    return getPaddingTop() - paramInt;
  }
  
  private int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint) {
    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = marginLayoutParams.leftMargin - paramArrayOfint[0];
    int j = marginLayoutParams.rightMargin - paramArrayOfint[1];
    int k = Math.max(0, i) + Math.max(0, j);
    paramArrayOfint[0] = Math.max(0, -i);
    paramArrayOfint[1] = Math.max(0, -j);
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + k + paramInt2, marginLayoutParams.width), getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + paramInt4, marginLayoutParams.height));
    return paramView.getMeasuredWidth() + k;
  }
  
  private int a(View paramView, int paramInt1, int[] paramArrayOfint, int paramInt2) {
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = layoutParams.leftMargin - paramArrayOfint[0];
    paramInt1 += Math.max(0, i);
    paramArrayOfint[0] = Math.max(0, -i);
    paramInt2 = a(paramView, paramInt2);
    i = paramView.getMeasuredWidth();
    paramView.layout(paramInt1, paramInt2, paramInt1 + i, paramView.getMeasuredHeight() + paramInt2);
    return paramInt1 + i + layoutParams.rightMargin;
  }
  
  private int a(List<View> paramList, int[] paramArrayOfint) {
    int m = paramArrayOfint[0];
    int k = paramArrayOfint[1];
    int n = paramList.size();
    int i = 0;
    int j = 0;
    while (i < n) {
      View view = paramList.get(i);
      LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
      m = layoutParams.leftMargin - m;
      k = layoutParams.rightMargin - k;
      int i1 = Math.max(0, m);
      int i2 = Math.max(0, k);
      m = Math.max(0, -m);
      k = Math.max(0, -k);
      j += i1 + view.getMeasuredWidth() + i2;
      i++;
    } 
    return j;
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + paramInt2, marginLayoutParams.width);
    paramInt2 = getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + paramInt4, marginLayoutParams.height);
    paramInt3 = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = paramInt2;
    if (paramInt3 != 1073741824) {
      paramInt1 = paramInt2;
      if (paramInt5 >= 0) {
        paramInt1 = paramInt5;
        if (paramInt3 != 0)
          paramInt1 = Math.min(View.MeasureSpec.getSize(paramInt2), paramInt5); 
        paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      } 
    } 
    paramView.measure(i, paramInt1);
  }
  
  private void a(View paramView, boolean paramBoolean) {
    LayoutParams layoutParams;
    ViewGroup.LayoutParams layoutParams1 = paramView.getLayoutParams();
    if (layoutParams1 == null) {
      layoutParams = b();
    } else if (!checkLayoutParams((ViewGroup.LayoutParams)layoutParams)) {
      layoutParams = a((ViewGroup.LayoutParams)layoutParams);
    } else {
      layoutParams = layoutParams;
    } 
    layoutParams.a = 1;
    if (paramBoolean && this.b != null) {
      paramView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      this.F.add(paramView);
      return;
    } 
    addView(paramView, (ViewGroup.LayoutParams)layoutParams);
  }
  
  private void a(List<View> paramList, int paramInt) {
    int i = ViewCompat.getLayoutDirection((View)this);
    boolean bool = false;
    if (i == 1) {
      i = 1;
    } else {
      i = 0;
    } 
    int k = getChildCount();
    int j = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection((View)this));
    paramList.clear();
    paramInt = bool;
    if (i != 0) {
      for (paramInt = k - 1; paramInt >= 0; paramInt--) {
        View view = getChildAt(paramInt);
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (layoutParams.a == 0 && a(view) && b(layoutParams.gravity) == j)
          paramList.add(view); 
      } 
    } else {
      while (paramInt < k) {
        View view = getChildAt(paramInt);
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (layoutParams.a == 0 && a(view) && b(layoutParams.gravity) == j)
          paramList.add(view); 
        paramInt++;
      } 
    } 
  }
  
  private boolean a(View paramView) {
    return (paramView != null && paramView.getParent() == this && paramView.getVisibility() != 8);
  }
  
  private int b(int paramInt) {
    int i = ViewCompat.getLayoutDirection((View)this);
    int j = GravityCompat.getAbsoluteGravity(paramInt, i) & 0x7;
    if (j != 1) {
      paramInt = 3;
      if (j != 3 && j != 5) {
        if (i == 1)
          paramInt = 5; 
        return paramInt;
      } 
    } 
    return j;
  }
  
  private int b(View paramView) {
    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    return MarginLayoutParamsCompat.getMarginStart(marginLayoutParams) + MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams);
  }
  
  private int b(View paramView, int paramInt1, int[] paramArrayOfint, int paramInt2) {
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = layoutParams.rightMargin - paramArrayOfint[1];
    paramInt1 -= Math.max(0, i);
    paramArrayOfint[1] = Math.max(0, -i);
    paramInt2 = a(paramView, paramInt2);
    i = paramView.getMeasuredWidth();
    paramView.layout(paramInt1 - i, paramInt2, paramInt1, paramView.getMeasuredHeight() + paramInt2);
    return paramInt1 - i + layoutParams.leftMargin;
  }
  
  private int c(View paramView) {
    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
  }
  
  private boolean d(View paramView) {
    return (paramView.getParent() == this || this.F.contains(paramView));
  }
  
  private void e() {
    if (this.i == null)
      this.i = new AppCompatImageView(getContext()); 
  }
  
  private void f() {
    g();
    if (this.e.peekMenu() == null) {
      MenuBuilder menuBuilder = (MenuBuilder)this.e.getMenu();
      if (this.K == null)
        this.K = new ExpandedActionViewMenuPresenter(this); 
      this.e.setExpandedActionViewsExclusive(true);
      menuBuilder.addMenuPresenter(this.K, this.l);
    } 
  }
  
  private void g() {
    if (this.e == null) {
      this.e = new ActionMenuView(getContext());
      this.e.setPopupTheme(this.m);
      this.e.setOnMenuItemClickListener(this.H);
      this.e.setMenuCallbacks(this.L, this.M);
      LayoutParams layoutParams = b();
      layoutParams.gravity = 0x800005 | this.c & 0x70;
      this.e.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      a((View)this.e, false);
    } 
  }
  
  private MenuInflater getMenuInflater() {
    return (MenuInflater)new SupportMenuInflater(getContext());
  }
  
  private void h() {
    if (this.h == null) {
      this.h = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
      LayoutParams layoutParams = b();
      layoutParams.gravity = 0x800003 | this.c & 0x70;
      this.h.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    } 
  }
  
  private void i() {
    removeCallbacks(this.O);
    post(this.O);
  }
  
  private boolean j() {
    if (!this.N)
      return false; 
    int j = getChildCount();
    for (int i = 0; i < j; i++) {
      View view = getChildAt(i);
      if (a(view) && view.getMeasuredWidth() > 0 && view.getMeasuredHeight() > 0)
        return false; 
    } 
    return true;
  }
  
  private void k() {
    if (this.u == null)
      this.u = new RtlSpacingHelper(); 
  }
  
  protected LayoutParams a(ViewGroup.LayoutParams paramLayoutParams) {
    return (paramLayoutParams instanceof LayoutParams) ? new LayoutParams((LayoutParams)paramLayoutParams) : ((paramLayoutParams instanceof ActionBar.LayoutParams) ? new LayoutParams((ActionBar.LayoutParams)paramLayoutParams) : ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams) ? new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams) : new LayoutParams(paramLayoutParams)));
  }
  
  void a() {
    if (this.a == null) {
      this.a = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
      this.a.setImageDrawable(this.j);
      this.a.setContentDescription(this.k);
      LayoutParams layoutParams = b();
      layoutParams.gravity = 0x800003 | this.c & 0x70;
      layoutParams.a = 2;
      this.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      this.a.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              this.a.collapseActionView();
            }
          });
    } 
  }
  
  protected LayoutParams b() {
    return new LayoutParams(-2, -2);
  }
  
  void c() {
    for (int i = getChildCount() - 1; i >= 0; i--) {
      View view = getChildAt(i);
      if (((LayoutParams)view.getLayoutParams()).a != 2 && view != this.e) {
        removeViewAt(i);
        this.F.add(view);
      } 
    } 
  }
  
  public boolean canShowOverflowMenu() {
    if (getVisibility() == 0) {
      ActionMenuView actionMenuView = this.e;
      if (actionMenuView != null && actionMenuView.isOverflowReserved())
        return true; 
    } 
    return false;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (super.checkLayoutParams(paramLayoutParams) && paramLayoutParams instanceof LayoutParams);
  }
  
  public void collapseActionView() {
    MenuItemImpl menuItemImpl;
    ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.K;
    if (expandedActionViewMenuPresenter == null) {
      expandedActionViewMenuPresenter = null;
    } else {
      menuItemImpl = expandedActionViewMenuPresenter.b;
    } 
    if (menuItemImpl != null)
      menuItemImpl.collapseActionView(); 
  }
  
  void d() {
    for (int i = this.F.size() - 1; i >= 0; i--)
      addView(this.F.get(i)); 
    this.F.clear();
  }
  
  public void dismissPopupMenus() {
    ActionMenuView actionMenuView = this.e;
    if (actionMenuView != null)
      actionMenuView.dismissPopupMenus(); 
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  public CharSequence getCollapseContentDescription() {
    ImageButton imageButton = this.a;
    return (imageButton != null) ? imageButton.getContentDescription() : null;
  }
  
  public Drawable getCollapseIcon() {
    ImageButton imageButton = this.a;
    return (imageButton != null) ? imageButton.getDrawable() : null;
  }
  
  public int getContentInsetEnd() {
    RtlSpacingHelper rtlSpacingHelper = this.u;
    return (rtlSpacingHelper != null) ? rtlSpacingHelper.getEnd() : 0;
  }
  
  public int getContentInsetEndWithActions() {
    int i = this.w;
    return (i != Integer.MIN_VALUE) ? i : getContentInsetEnd();
  }
  
  public int getContentInsetLeft() {
    RtlSpacingHelper rtlSpacingHelper = this.u;
    return (rtlSpacingHelper != null) ? rtlSpacingHelper.getLeft() : 0;
  }
  
  public int getContentInsetRight() {
    RtlSpacingHelper rtlSpacingHelper = this.u;
    return (rtlSpacingHelper != null) ? rtlSpacingHelper.getRight() : 0;
  }
  
  public int getContentInsetStart() {
    RtlSpacingHelper rtlSpacingHelper = this.u;
    return (rtlSpacingHelper != null) ? rtlSpacingHelper.getStart() : 0;
  }
  
  public int getContentInsetStartWithNavigation() {
    int i = this.v;
    return (i != Integer.MIN_VALUE) ? i : getContentInsetStart();
  }
  
  public int getCurrentContentInsetEnd() {
    // Byte code:
    //   0: aload_0
    //   1: getfield e : Landroidx/appcompat/widget/ActionMenuView;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnull -> 30
    //   9: aload_2
    //   10: invokevirtual peekMenu : ()Landroidx/appcompat/view/menu/MenuBuilder;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull -> 30
    //   18: aload_2
    //   19: invokevirtual hasVisibleItems : ()Z
    //   22: ifeq -> 30
    //   25: iconst_1
    //   26: istore_1
    //   27: goto -> 32
    //   30: iconst_0
    //   31: istore_1
    //   32: iload_1
    //   33: ifeq -> 52
    //   36: aload_0
    //   37: invokevirtual getContentInsetEnd : ()I
    //   40: aload_0
    //   41: getfield w : I
    //   44: iconst_0
    //   45: invokestatic max : (II)I
    //   48: invokestatic max : (II)I
    //   51: ireturn
    //   52: aload_0
    //   53: invokevirtual getContentInsetEnd : ()I
    //   56: ireturn
  }
  
  public int getCurrentContentInsetLeft() {
    return (ViewCompat.getLayoutDirection((View)this) == 1) ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
  }
  
  public int getCurrentContentInsetRight() {
    return (ViewCompat.getLayoutDirection((View)this) == 1) ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
  }
  
  public int getCurrentContentInsetStart() {
    return (getNavigationIcon() != null) ? Math.max(getContentInsetStart(), Math.max(this.v, 0)) : getContentInsetStart();
  }
  
  public Drawable getLogo() {
    ImageView imageView = this.i;
    return (imageView != null) ? imageView.getDrawable() : null;
  }
  
  public CharSequence getLogoDescription() {
    ImageView imageView = this.i;
    return (imageView != null) ? imageView.getContentDescription() : null;
  }
  
  public Menu getMenu() {
    f();
    return this.e.getMenu();
  }
  
  public CharSequence getNavigationContentDescription() {
    ImageButton imageButton = this.h;
    return (imageButton != null) ? imageButton.getContentDescription() : null;
  }
  
  public Drawable getNavigationIcon() {
    ImageButton imageButton = this.h;
    return (imageButton != null) ? imageButton.getDrawable() : null;
  }
  
  ActionMenuPresenter getOuterActionMenuPresenter() {
    return this.J;
  }
  
  public Drawable getOverflowIcon() {
    f();
    return this.e.getOverflowIcon();
  }
  
  Context getPopupContext() {
    return this.l;
  }
  
  public int getPopupTheme() {
    return this.m;
  }
  
  public CharSequence getSubtitle() {
    return this.z;
  }
  
  final TextView getSubtitleTextView() {
    return this.g;
  }
  
  public CharSequence getTitle() {
    return this.y;
  }
  
  public int getTitleMarginBottom() {
    return this.t;
  }
  
  public int getTitleMarginEnd() {
    return this.r;
  }
  
  public int getTitleMarginStart() {
    return this.q;
  }
  
  public int getTitleMarginTop() {
    return this.s;
  }
  
  final TextView getTitleTextView() {
    return this.f;
  }
  
  public DecorToolbar getWrapper() {
    if (this.I == null)
      this.I = new ToolbarWidgetWrapper(this, true); 
    return this.I;
  }
  
  public boolean hasExpandedActionView() {
    ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.K;
    return (expandedActionViewMenuPresenter != null && expandedActionViewMenuPresenter.b != null);
  }
  
  public boolean hideOverflowMenu() {
    ActionMenuView actionMenuView = this.e;
    return (actionMenuView != null && actionMenuView.hideOverflowMenu());
  }
  
  public void inflateMenu(int paramInt) {
    getMenuInflater().inflate(paramInt, getMenu());
  }
  
  public boolean isOverflowMenuShowPending() {
    ActionMenuView actionMenuView = this.e;
    return (actionMenuView != null && actionMenuView.isOverflowMenuShowPending());
  }
  
  public boolean isOverflowMenuShowing() {
    ActionMenuView actionMenuView = this.e;
    return (actionMenuView != null && actionMenuView.isOverflowMenuShowing());
  }
  
  public boolean isTitleTruncated() {
    TextView textView = this.f;
    if (textView == null)
      return false; 
    Layout layout = textView.getLayout();
    if (layout == null)
      return false; 
    int j = layout.getLineCount();
    for (int i = 0; i < j; i++) {
      if (layout.getEllipsisCount(i) > 0)
        return true; 
    } 
    return false;
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    removeCallbacks(this.O);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getActionMasked();
    if (i == 9)
      this.D = false; 
    if (!this.D) {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if (i == 9 && !bool)
        this.D = true; 
    } 
    if (i == 10 || i == 3)
      this.D = false; 
    return true;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (ViewCompat.getLayoutDirection((View)this) == 1) {
      k = 1;
    } else {
      k = 0;
    } 
    int n = getWidth();
    int i3 = getHeight();
    int i = getPaddingLeft();
    int i1 = getPaddingRight();
    int i2 = getPaddingTop();
    int i4 = getPaddingBottom();
    int m = n - i1;
    int[] arrayOfInt = this.G;
    arrayOfInt[1] = 0;
    arrayOfInt[0] = 0;
    paramInt1 = ViewCompat.getMinimumHeight((View)this);
    if (paramInt1 >= 0) {
      paramInt4 = Math.min(paramInt1, paramInt4 - paramInt2);
    } else {
      paramInt4 = 0;
    } 
    if (a((View)this.h)) {
      if (k) {
        j = b((View)this.h, m, arrayOfInt, paramInt4);
        paramInt3 = i;
      } else {
        paramInt3 = a((View)this.h, i, arrayOfInt, paramInt4);
        j = m;
      } 
    } else {
      paramInt3 = i;
      j = m;
    } 
    paramInt1 = paramInt3;
    paramInt2 = j;
    if (a((View)this.a))
      if (k) {
        paramInt2 = b((View)this.a, j, arrayOfInt, paramInt4);
        paramInt1 = paramInt3;
      } else {
        paramInt1 = a((View)this.a, paramInt3, arrayOfInt, paramInt4);
        paramInt2 = j;
      }  
    int j = paramInt1;
    paramInt3 = paramInt2;
    if (a((View)this.e))
      if (k) {
        j = a((View)this.e, paramInt1, arrayOfInt, paramInt4);
        paramInt3 = paramInt2;
      } else {
        paramInt3 = b((View)this.e, paramInt2, arrayOfInt, paramInt4);
        j = paramInt1;
      }  
    paramInt2 = getCurrentContentInsetLeft();
    paramInt1 = getCurrentContentInsetRight();
    arrayOfInt[0] = Math.max(0, paramInt2 - j);
    arrayOfInt[1] = Math.max(0, paramInt1 - m - paramInt3);
    paramInt2 = Math.max(j, paramInt2);
    paramInt3 = Math.min(paramInt3, m - paramInt1);
    paramInt1 = paramInt2;
    j = paramInt3;
    if (a(this.b))
      if (k) {
        j = b(this.b, paramInt3, arrayOfInt, paramInt4);
        paramInt1 = paramInt2;
      } else {
        paramInt1 = a(this.b, paramInt2, arrayOfInt, paramInt4);
        j = paramInt3;
      }  
    paramInt3 = paramInt1;
    paramInt2 = j;
    if (a((View)this.i))
      if (k) {
        paramInt2 = b((View)this.i, j, arrayOfInt, paramInt4);
        paramInt3 = paramInt1;
      } else {
        paramInt3 = a((View)this.i, paramInt1, arrayOfInt, paramInt4);
        paramInt2 = j;
      }  
    paramBoolean = a((View)this.f);
    boolean bool = a((View)this.g);
    if (paramBoolean) {
      LayoutParams layoutParams = (LayoutParams)this.f.getLayoutParams();
      paramInt1 = layoutParams.topMargin + this.f.getMeasuredHeight() + layoutParams.bottomMargin + 0;
    } else {
      paramInt1 = 0;
    } 
    if (bool) {
      LayoutParams layoutParams = (LayoutParams)this.g.getLayoutParams();
      paramInt1 += layoutParams.topMargin + this.g.getMeasuredHeight() + layoutParams.bottomMargin;
    } 
    if (paramBoolean || bool) {
      TextView textView1;
      TextView textView2;
      if (paramBoolean) {
        textView1 = this.f;
      } else {
        textView1 = this.g;
      } 
      if (bool) {
        textView2 = this.g;
      } else {
        textView2 = this.f;
      } 
      LayoutParams layoutParams1 = (LayoutParams)textView1.getLayoutParams();
      LayoutParams layoutParams2 = (LayoutParams)textView2.getLayoutParams();
      if ((paramBoolean && this.f.getMeasuredWidth() > 0) || (bool && this.g.getMeasuredWidth() > 0)) {
        j = 1;
      } else {
        j = 0;
      } 
      m = this.x & 0x70;
      if (m != 48) {
        if (m != 80) {
          m = (i3 - i2 - i4 - paramInt1) / 2;
          if (m < layoutParams1.topMargin + this.s) {
            paramInt1 = layoutParams1.topMargin + this.s;
          } else {
            i3 = i3 - i4 - paramInt1 - m - i2;
            paramInt1 = m;
            if (i3 < layoutParams1.bottomMargin + this.t)
              paramInt1 = Math.max(0, m - layoutParams2.bottomMargin + this.t - i3); 
          } 
          paramInt1 = i2 + paramInt1;
        } else {
          paramInt1 = i3 - i4 - layoutParams2.bottomMargin - this.t - paramInt1;
        } 
      } else {
        paramInt1 = getPaddingTop() + layoutParams1.topMargin + this.s;
      } 
      if (k) {
        if (j != 0) {
          k = this.q;
        } else {
          k = 0;
        } 
        k -= arrayOfInt[1];
        paramInt2 -= Math.max(0, k);
        arrayOfInt[1] = Math.max(0, -k);
        if (paramBoolean) {
          layoutParams1 = (LayoutParams)this.f.getLayoutParams();
          m = paramInt2 - this.f.getMeasuredWidth();
          k = this.f.getMeasuredHeight() + paramInt1;
          this.f.layout(m, paramInt1, paramInt2, k);
          paramInt1 = m - this.r;
          m = k + layoutParams1.bottomMargin;
        } else {
          k = paramInt2;
          m = paramInt1;
          paramInt1 = k;
        } 
        if (bool) {
          layoutParams1 = (LayoutParams)this.g.getLayoutParams();
          k = m + layoutParams1.topMargin;
          m = this.g.getMeasuredWidth();
          i2 = this.g.getMeasuredHeight();
          this.g.layout(paramInt2 - m, k, paramInt2, i2 + k);
          k = paramInt2 - this.r;
          m = layoutParams1.bottomMargin;
        } else {
          k = paramInt2;
        } 
        if (j != 0)
          paramInt2 = Math.min(paramInt1, k); 
        paramInt1 = paramInt3;
      } else {
        if (j != 0) {
          k = this.q;
        } else {
          k = 0;
        } 
        k -= arrayOfInt[0];
        paramInt3 += Math.max(0, k);
        arrayOfInt[0] = Math.max(0, -k);
        if (paramBoolean) {
          layoutParams1 = (LayoutParams)this.f.getLayoutParams();
          k = this.f.getMeasuredWidth() + paramInt3;
          m = this.f.getMeasuredHeight() + paramInt1;
          this.f.layout(paramInt3, paramInt1, k, m);
          k += this.r;
          paramInt1 = m + layoutParams1.bottomMargin;
        } else {
          k = paramInt3;
        } 
        if (bool) {
          layoutParams1 = (LayoutParams)this.g.getLayoutParams();
          paramInt1 += layoutParams1.topMargin;
          m = this.g.getMeasuredWidth() + paramInt3;
          i2 = this.g.getMeasuredHeight();
          this.g.layout(paramInt3, paramInt1, m, i2 + paramInt1);
          m += this.r;
          paramInt1 = layoutParams1.bottomMargin;
        } else {
          m = paramInt3;
        } 
        paramInt1 = paramInt3;
        paramInt3 = paramInt2;
        if (j != 0) {
          paramInt1 = Math.max(k, m);
          paramInt3 = paramInt2;
        } 
        j = i;
        i = 0;
        a(this.E, 3);
        k = this.E.size();
        paramInt2 = 0;
      } 
    } else {
      paramInt1 = paramInt3;
    } 
    paramInt3 = paramInt2;
    j = i;
    i = 0;
    a(this.E, 3);
    int k = this.E.size();
    paramInt2 = 0;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    int[] arrayOfInt = this.G;
    if (ViewUtils.isLayoutRtl((View)this)) {
      i1 = 1;
      n = 0;
    } else {
      i1 = 0;
      n = 1;
    } 
    if (a((View)this.h)) {
      a((View)this.h, paramInt1, 0, paramInt2, 0, this.p);
      i = this.h.getMeasuredWidth() + b((View)this.h);
      m = Math.max(0, this.h.getMeasuredHeight() + c((View)this.h));
      k = View.combineMeasuredStates(0, this.h.getMeasuredState());
    } else {
      i = 0;
      m = 0;
      k = 0;
    } 
    int i2 = i;
    int j = m;
    int i = k;
    if (a((View)this.a)) {
      a((View)this.a, paramInt1, 0, paramInt2, 0, this.p);
      i2 = this.a.getMeasuredWidth() + b((View)this.a);
      j = Math.max(m, this.a.getMeasuredHeight() + c((View)this.a));
      i = View.combineMeasuredStates(k, this.a.getMeasuredState());
    } 
    int k = getCurrentContentInsetStart();
    int m = 0 + Math.max(k, i2);
    arrayOfInt[i1] = Math.max(0, k - i2);
    if (a((View)this.e)) {
      a((View)this.e, paramInt1, m, paramInt2, 0, this.p);
      k = this.e.getMeasuredWidth() + b((View)this.e);
      j = Math.max(j, this.e.getMeasuredHeight() + c((View)this.e));
      i = View.combineMeasuredStates(i, this.e.getMeasuredState());
    } else {
      k = 0;
    } 
    i2 = getCurrentContentInsetEnd();
    int i1 = m + Math.max(i2, k);
    arrayOfInt[n] = Math.max(0, i2 - k);
    int n = i1;
    m = j;
    k = i;
    if (a(this.b)) {
      n = i1 + a(this.b, paramInt1, i1, paramInt2, 0, arrayOfInt);
      m = Math.max(j, this.b.getMeasuredHeight() + c(this.b));
      k = View.combineMeasuredStates(i, this.b.getMeasuredState());
    } 
    j = n;
    i1 = m;
    i = k;
    if (a((View)this.i)) {
      j = n + a((View)this.i, paramInt1, n, paramInt2, 0, arrayOfInt);
      i1 = Math.max(m, this.i.getMeasuredHeight() + c((View)this.i));
      i = View.combineMeasuredStates(k, this.i.getMeasuredState());
    } 
    int i3 = getChildCount();
    n = i1;
    k = 0;
    m = j;
    j = k;
    while (j < i3) {
      View view = getChildAt(j);
      i2 = m;
      i1 = i;
      k = n;
      if (((LayoutParams)view.getLayoutParams()).a == 0)
        if (!a(view)) {
          i2 = m;
          i1 = i;
          k = n;
        } else {
          i2 = m + a(view, paramInt1, m, paramInt2, 0, arrayOfInt);
          k = Math.max(n, view.getMeasuredHeight() + c(view));
          i1 = View.combineMeasuredStates(i, view.getMeasuredState());
        }  
      j++;
      m = i2;
      i = i1;
      n = k;
    } 
    i1 = this.s + this.t;
    i2 = this.q + this.r;
    if (a((View)this.f)) {
      a((View)this.f, paramInt1, m + i2, paramInt2, i1, arrayOfInt);
      j = this.f.getMeasuredWidth();
      i3 = b((View)this.f);
      k = this.f.getMeasuredHeight();
      int i4 = c((View)this.f);
      i = View.combineMeasuredStates(i, this.f.getMeasuredState());
      k += i4;
      j += i3;
    } else {
      j = 0;
      k = 0;
    } 
    if (a((View)this.g)) {
      j = Math.max(j, a((View)this.g, paramInt1, m + i2, paramInt2, k + i1, arrayOfInt));
      k += this.g.getMeasuredHeight() + c((View)this.g);
      i = View.combineMeasuredStates(i, this.g.getMeasuredState());
    } 
    k = Math.max(n, k);
    i2 = getPaddingLeft();
    i3 = getPaddingRight();
    n = getPaddingTop();
    i1 = getPaddingBottom();
    j = View.resolveSizeAndState(Math.max(m + j + i2 + i3, getSuggestedMinimumWidth()), paramInt1, 0xFF000000 & i);
    paramInt1 = View.resolveSizeAndState(Math.max(k + n + i1, getSuggestedMinimumHeight()), paramInt2, i << 16);
    if (j())
      paramInt1 = 0; 
    setMeasuredDimension(j, paramInt1);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    SavedState savedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(savedState.getSuperState());
    ActionMenuView actionMenuView = this.e;
    if (actionMenuView != null) {
      MenuBuilder menuBuilder = actionMenuView.peekMenu();
    } else {
      actionMenuView = null;
    } 
    if (savedState.a != 0 && this.K != null && actionMenuView != null) {
      MenuItem menuItem = actionMenuView.findItem(savedState.a);
      if (menuItem != null)
        menuItem.expandActionView(); 
    } 
    if (savedState.b)
      i(); 
  }
  
  public void onRtlPropertiesChanged(int paramInt) {
    if (Build.VERSION.SDK_INT >= 17)
      super.onRtlPropertiesChanged(paramInt); 
    k();
    RtlSpacingHelper rtlSpacingHelper = this.u;
    boolean bool = true;
    if (paramInt != 1)
      bool = false; 
    rtlSpacingHelper.setDirection(bool);
  }
  
  public Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.K;
    if (expandedActionViewMenuPresenter != null && expandedActionViewMenuPresenter.b != null)
      savedState.a = this.K.b.getItemId(); 
    savedState.b = isOverflowMenuShowing();
    return (Parcelable)savedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0)
      this.C = false; 
    if (!this.C) {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if (i == 0 && !bool)
        this.C = true; 
    } 
    if (i == 1 || i == 3)
      this.C = false; 
    return true;
  }
  
  public void setCollapseContentDescription(int paramInt) {
    CharSequence charSequence;
    if (paramInt != 0) {
      charSequence = getContext().getText(paramInt);
    } else {
      charSequence = null;
    } 
    setCollapseContentDescription(charSequence);
  }
  
  public void setCollapseContentDescription(CharSequence paramCharSequence) {
    if (!TextUtils.isEmpty(paramCharSequence))
      a(); 
    ImageButton imageButton = this.a;
    if (imageButton != null)
      imageButton.setContentDescription(paramCharSequence); 
  }
  
  public void setCollapseIcon(int paramInt) {
    setCollapseIcon(AppCompatResources.getDrawable(getContext(), paramInt));
  }
  
  public void setCollapseIcon(Drawable paramDrawable) {
    if (paramDrawable != null) {
      a();
      this.a.setImageDrawable(paramDrawable);
      return;
    } 
    ImageButton imageButton = this.a;
    if (imageButton != null)
      imageButton.setImageDrawable(this.j); 
  }
  
  public void setCollapsible(boolean paramBoolean) {
    this.N = paramBoolean;
    requestLayout();
  }
  
  public void setContentInsetEndWithActions(int paramInt) {
    int i = paramInt;
    if (paramInt < 0)
      i = Integer.MIN_VALUE; 
    if (i != this.w) {
      this.w = i;
      if (getNavigationIcon() != null)
        requestLayout(); 
    } 
  }
  
  public void setContentInsetStartWithNavigation(int paramInt) {
    int i = paramInt;
    if (paramInt < 0)
      i = Integer.MIN_VALUE; 
    if (i != this.v) {
      this.v = i;
      if (getNavigationIcon() != null)
        requestLayout(); 
    } 
  }
  
  public void setContentInsetsAbsolute(int paramInt1, int paramInt2) {
    k();
    this.u.setAbsolute(paramInt1, paramInt2);
  }
  
  public void setContentInsetsRelative(int paramInt1, int paramInt2) {
    k();
    this.u.setRelative(paramInt1, paramInt2);
  }
  
  public void setLogo(int paramInt) {
    setLogo(AppCompatResources.getDrawable(getContext(), paramInt));
  }
  
  public void setLogo(Drawable paramDrawable) {
    if (paramDrawable != null) {
      e();
      if (!d((View)this.i))
        a((View)this.i, true); 
    } else {
      ImageView imageView1 = this.i;
      if (imageView1 != null && d((View)imageView1)) {
        removeView((View)this.i);
        this.F.remove(this.i);
      } 
    } 
    ImageView imageView = this.i;
    if (imageView != null)
      imageView.setImageDrawable(paramDrawable); 
  }
  
  public void setLogoDescription(int paramInt) {
    setLogoDescription(getContext().getText(paramInt));
  }
  
  public void setLogoDescription(CharSequence paramCharSequence) {
    if (!TextUtils.isEmpty(paramCharSequence))
      e(); 
    ImageView imageView = this.i;
    if (imageView != null)
      imageView.setContentDescription(paramCharSequence); 
  }
  
  public void setMenu(MenuBuilder paramMenuBuilder, ActionMenuPresenter paramActionMenuPresenter) {
    if (paramMenuBuilder == null && this.e == null)
      return; 
    g();
    MenuBuilder menuBuilder = this.e.peekMenu();
    if (menuBuilder == paramMenuBuilder)
      return; 
    if (menuBuilder != null) {
      menuBuilder.removeMenuPresenter((MenuPresenter)this.J);
      menuBuilder.removeMenuPresenter(this.K);
    } 
    if (this.K == null)
      this.K = new ExpandedActionViewMenuPresenter(this); 
    paramActionMenuPresenter.setExpandedActionViewsExclusive(true);
    if (paramMenuBuilder != null) {
      paramMenuBuilder.addMenuPresenter((MenuPresenter)paramActionMenuPresenter, this.l);
      paramMenuBuilder.addMenuPresenter(this.K, this.l);
    } else {
      paramActionMenuPresenter.initForMenu(this.l, null);
      this.K.initForMenu(this.l, null);
      paramActionMenuPresenter.updateMenuView(true);
      this.K.updateMenuView(true);
    } 
    this.e.setPopupTheme(this.m);
    this.e.setPresenter(paramActionMenuPresenter);
    this.J = paramActionMenuPresenter;
  }
  
  public void setMenuCallbacks(MenuPresenter.Callback paramCallback, MenuBuilder.Callback paramCallback1) {
    this.L = paramCallback;
    this.M = paramCallback1;
    ActionMenuView actionMenuView = this.e;
    if (actionMenuView != null)
      actionMenuView.setMenuCallbacks(paramCallback, paramCallback1); 
  }
  
  public void setNavigationContentDescription(int paramInt) {
    CharSequence charSequence;
    if (paramInt != 0) {
      charSequence = getContext().getText(paramInt);
    } else {
      charSequence = null;
    } 
    setNavigationContentDescription(charSequence);
  }
  
  public void setNavigationContentDescription(CharSequence paramCharSequence) {
    if (!TextUtils.isEmpty(paramCharSequence))
      h(); 
    ImageButton imageButton = this.h;
    if (imageButton != null)
      imageButton.setContentDescription(paramCharSequence); 
  }
  
  public void setNavigationIcon(int paramInt) {
    setNavigationIcon(AppCompatResources.getDrawable(getContext(), paramInt));
  }
  
  public void setNavigationIcon(Drawable paramDrawable) {
    if (paramDrawable != null) {
      h();
      if (!d((View)this.h))
        a((View)this.h, true); 
    } else {
      ImageButton imageButton1 = this.h;
      if (imageButton1 != null && d((View)imageButton1)) {
        removeView((View)this.h);
        this.F.remove(this.h);
      } 
    } 
    ImageButton imageButton = this.h;
    if (imageButton != null)
      imageButton.setImageDrawable(paramDrawable); 
  }
  
  public void setNavigationOnClickListener(View.OnClickListener paramOnClickListener) {
    h();
    this.h.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnMenuItemClickListener(OnMenuItemClickListener paramOnMenuItemClickListener) {
    this.d = paramOnMenuItemClickListener;
  }
  
  public void setOverflowIcon(Drawable paramDrawable) {
    f();
    this.e.setOverflowIcon(paramDrawable);
  }
  
  public void setPopupTheme(int paramInt) {
    if (this.m != paramInt) {
      this.m = paramInt;
      if (paramInt == 0) {
        this.l = getContext();
        return;
      } 
      this.l = (Context)new ContextThemeWrapper(getContext(), paramInt);
    } 
  }
  
  public void setSubtitle(int paramInt) {
    setSubtitle(getContext().getText(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence) {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      if (this.g == null) {
        Context context = getContext();
        this.g = new AppCompatTextView(context);
        this.g.setSingleLine();
        this.g.setEllipsize(TextUtils.TruncateAt.END);
        int i = this.o;
        if (i != 0)
          this.g.setTextAppearance(context, i); 
        ColorStateList colorStateList = this.B;
        if (colorStateList != null)
          this.g.setTextColor(colorStateList); 
      } 
      if (!d((View)this.g))
        a((View)this.g, true); 
    } else {
      TextView textView1 = this.g;
      if (textView1 != null && d((View)textView1)) {
        removeView((View)this.g);
        this.F.remove(this.g);
      } 
    } 
    TextView textView = this.g;
    if (textView != null)
      textView.setText(paramCharSequence); 
    this.z = paramCharSequence;
  }
  
  public void setSubtitleTextAppearance(Context paramContext, int paramInt) {
    this.o = paramInt;
    TextView textView = this.g;
    if (textView != null)
      textView.setTextAppearance(paramContext, paramInt); 
  }
  
  public void setSubtitleTextColor(int paramInt) {
    setSubtitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setSubtitleTextColor(ColorStateList paramColorStateList) {
    this.B = paramColorStateList;
    TextView textView = this.g;
    if (textView != null)
      textView.setTextColor(paramColorStateList); 
  }
  
  public void setTitle(int paramInt) {
    setTitle(getContext().getText(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence) {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      if (this.f == null) {
        Context context = getContext();
        this.f = new AppCompatTextView(context);
        this.f.setSingleLine();
        this.f.setEllipsize(TextUtils.TruncateAt.END);
        int i = this.n;
        if (i != 0)
          this.f.setTextAppearance(context, i); 
        ColorStateList colorStateList = this.A;
        if (colorStateList != null)
          this.f.setTextColor(colorStateList); 
      } 
      if (!d((View)this.f))
        a((View)this.f, true); 
    } else {
      TextView textView1 = this.f;
      if (textView1 != null && d((View)textView1)) {
        removeView((View)this.f);
        this.F.remove(this.f);
      } 
    } 
    TextView textView = this.f;
    if (textView != null)
      textView.setText(paramCharSequence); 
    this.y = paramCharSequence;
  }
  
  public void setTitleMargin(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.q = paramInt1;
    this.s = paramInt2;
    this.r = paramInt3;
    this.t = paramInt4;
    requestLayout();
  }
  
  public void setTitleMarginBottom(int paramInt) {
    this.t = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginEnd(int paramInt) {
    this.r = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginStart(int paramInt) {
    this.q = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginTop(int paramInt) {
    this.s = paramInt;
    requestLayout();
  }
  
  public void setTitleTextAppearance(Context paramContext, int paramInt) {
    this.n = paramInt;
    TextView textView = this.f;
    if (textView != null)
      textView.setTextAppearance(paramContext, paramInt); 
  }
  
  public void setTitleTextColor(int paramInt) {
    setTitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setTitleTextColor(ColorStateList paramColorStateList) {
    this.A = paramColorStateList;
    TextView textView = this.f;
    if (textView != null)
      textView.setTextColor(paramColorStateList); 
  }
  
  public boolean showOverflowMenu() {
    ActionMenuView actionMenuView = this.e;
    return (actionMenuView != null && actionMenuView.showOverflowMenu());
  }
  
  class ExpandedActionViewMenuPresenter implements MenuPresenter {
    MenuBuilder a;
    
    MenuItemImpl b;
    
    ExpandedActionViewMenuPresenter(Toolbar this$0) {}
    
    public boolean collapseItemActionView(MenuBuilder param1MenuBuilder, MenuItemImpl param1MenuItemImpl) {
      if (this.c.b instanceof CollapsibleActionView)
        ((CollapsibleActionView)this.c.b).onActionViewCollapsed(); 
      Toolbar toolbar = this.c;
      toolbar.removeView(toolbar.b);
      toolbar = this.c;
      toolbar.removeView((View)toolbar.a);
      toolbar = this.c;
      toolbar.b = null;
      toolbar.d();
      this.b = null;
      this.c.requestLayout();
      param1MenuItemImpl.setActionViewExpanded(false);
      return true;
    }
    
    public boolean expandItemActionView(MenuBuilder param1MenuBuilder, MenuItemImpl param1MenuItemImpl) {
      this.c.a();
      ViewParent viewParent = this.c.a.getParent();
      Toolbar toolbar = this.c;
      if (viewParent != toolbar) {
        if (viewParent instanceof ViewGroup)
          ((ViewGroup)viewParent).removeView((View)toolbar.a); 
        Toolbar toolbar1 = this.c;
        toolbar1.addView((View)toolbar1.a);
      } 
      this.c.b = param1MenuItemImpl.getActionView();
      this.b = param1MenuItemImpl;
      viewParent = this.c.b.getParent();
      toolbar = this.c;
      if (viewParent != toolbar) {
        if (viewParent instanceof ViewGroup)
          ((ViewGroup)viewParent).removeView(toolbar.b); 
        Toolbar.LayoutParams layoutParams = this.c.b();
        layoutParams.gravity = 0x800003 | this.c.c & 0x70;
        layoutParams.a = 2;
        this.c.b.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        Toolbar toolbar1 = this.c;
        toolbar1.addView(toolbar1.b);
      } 
      this.c.c();
      this.c.requestLayout();
      param1MenuItemImpl.setActionViewExpanded(true);
      if (this.c.b instanceof CollapsibleActionView)
        ((CollapsibleActionView)this.c.b).onActionViewExpanded(); 
      return true;
    }
    
    public boolean flagActionItems() {
      return false;
    }
    
    public int getId() {
      return 0;
    }
    
    public MenuView getMenuView(ViewGroup param1ViewGroup) {
      return null;
    }
    
    public void initForMenu(Context param1Context, MenuBuilder param1MenuBuilder) {
      MenuBuilder menuBuilder = this.a;
      if (menuBuilder != null) {
        MenuItemImpl menuItemImpl = this.b;
        if (menuItemImpl != null)
          menuBuilder.collapseItemActionView(menuItemImpl); 
      } 
      this.a = param1MenuBuilder;
    }
    
    public void onCloseMenu(MenuBuilder param1MenuBuilder, boolean param1Boolean) {}
    
    public void onRestoreInstanceState(Parcelable param1Parcelable) {}
    
    public Parcelable onSaveInstanceState() {
      return null;
    }
    
    public boolean onSubMenuSelected(SubMenuBuilder param1SubMenuBuilder) {
      return false;
    }
    
    public void setCallback(MenuPresenter.Callback param1Callback) {}
    
    public void updateMenuView(boolean param1Boolean) {
      if (this.b != null) {
        MenuBuilder menuBuilder = this.a;
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (menuBuilder != null) {
          int j = menuBuilder.size();
          int i = 0;
          while (true) {
            bool1 = bool2;
            if (i < j) {
              if (this.a.getItem(i) == this.b) {
                bool1 = true;
                break;
              } 
              i++;
              continue;
            } 
            break;
          } 
        } 
        if (!bool1)
          collapseItemActionView(this.a, this.b); 
      } 
    }
  }
  
  public static class LayoutParams extends ActionBar.LayoutParams {
    int a = 0;
    
    public LayoutParams(int param1Int) {
      this(-2, -1, param1Int);
    }
    
    public LayoutParams(int param1Int1, int param1Int2) {
      super(param1Int1, param1Int2);
      this.gravity = 8388627;
    }
    
    public LayoutParams(int param1Int1, int param1Int2, int param1Int3) {
      super(param1Int1, param1Int2);
      this.gravity = param1Int3;
    }
    
    public LayoutParams(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams param1MarginLayoutParams) {
      super((ViewGroup.LayoutParams)param1MarginLayoutParams);
      a(param1MarginLayoutParams);
    }
    
    public LayoutParams(ActionBar.LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
    }
    
    public LayoutParams(LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
      this.a = param1LayoutParams.a;
    }
    
    void a(ViewGroup.MarginLayoutParams param1MarginLayoutParams) {
      this.leftMargin = param1MarginLayoutParams.leftMargin;
      this.topMargin = param1MarginLayoutParams.topMargin;
      this.rightMargin = param1MarginLayoutParams.rightMargin;
      this.bottomMargin = param1MarginLayoutParams.bottomMargin;
    }
  }
  
  public static interface OnMenuItemClickListener {
    boolean onMenuItemClick(MenuItem param1MenuItem);
  }
  
  public static class SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = (Parcelable.Creator<SavedState>)new Parcelable.ClassLoaderCreator<SavedState>() {
        public Toolbar.SavedState createFromParcel(Parcel param2Parcel) {
          return new Toolbar.SavedState(param2Parcel, null);
        }
        
        public Toolbar.SavedState createFromParcel(Parcel param2Parcel, ClassLoader param2ClassLoader) {
          return new Toolbar.SavedState(param2Parcel, param2ClassLoader);
        }
        
        public Toolbar.SavedState[] newArray(int param2Int) {
          return new Toolbar.SavedState[param2Int];
        }
      };
    
    int a;
    
    boolean b;
    
    public SavedState(Parcel param1Parcel) {
      this(param1Parcel, null);
    }
    
    public SavedState(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel, param1ClassLoader);
      boolean bool;
      this.a = param1Parcel.readInt();
      if (param1Parcel.readInt() != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      this.b = bool;
    }
    
    public SavedState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }
  
  static final class null implements Parcelable.ClassLoaderCreator<SavedState> {
    public Toolbar.SavedState createFromParcel(Parcel param1Parcel) {
      return new Toolbar.SavedState(param1Parcel, null);
    }
    
    public Toolbar.SavedState createFromParcel(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      return new Toolbar.SavedState(param1Parcel, param1ClassLoader);
    }
    
    public Toolbar.SavedState[] newArray(int param1Int) {
      return new Toolbar.SavedState[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\Toolbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */