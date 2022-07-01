package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.SpinnerAdapter;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout.ActionBarVisibilityCallback {
  private static final Interpolator t = (Interpolator)new AccelerateInterpolator();
  
  private static final Interpolator u = (Interpolator)new DecelerateInterpolator();
  
  private int A = -1;
  
  private boolean B;
  
  private boolean C;
  
  private ArrayList<ActionBar.OnMenuVisibilityListener> D = new ArrayList<ActionBar.OnMenuVisibilityListener>();
  
  private boolean E;
  
  private int F = 0;
  
  private boolean G;
  
  private boolean H = true;
  
  private boolean I;
  
  Context a;
  
  ActionBarOverlayLayout b;
  
  ActionBarContainer c;
  
  DecorToolbar d;
  
  ActionBarContextView e;
  
  View f;
  
  ScrollingTabContainerView g;
  
  ActionModeImpl h;
  
  ActionMode i;
  
  ActionMode.Callback j;
  
  boolean k = true;
  
  boolean l;
  
  boolean m;
  
  ViewPropertyAnimatorCompatSet n;
  
  boolean o;
  
  final ViewPropertyAnimatorListener p = (ViewPropertyAnimatorListener)new ViewPropertyAnimatorListenerAdapter(this) {
      public void onAnimationEnd(View param1View) {
        if (this.a.k && this.a.f != null) {
          this.a.f.setTranslationY(0.0F);
          this.a.c.setTranslationY(0.0F);
        } 
        this.a.c.setVisibility(8);
        this.a.c.setTransitioning(false);
        WindowDecorActionBar windowDecorActionBar = this.a;
        windowDecorActionBar.n = null;
        windowDecorActionBar.b();
        if (this.a.b != null)
          ViewCompat.requestApplyInsets((View)this.a.b); 
      }
    };
  
  final ViewPropertyAnimatorListener q = (ViewPropertyAnimatorListener)new ViewPropertyAnimatorListenerAdapter(this) {
      public void onAnimationEnd(View param1View) {
        WindowDecorActionBar windowDecorActionBar = this.a;
        windowDecorActionBar.n = null;
        windowDecorActionBar.c.requestLayout();
      }
    };
  
  final ViewPropertyAnimatorUpdateListener r = new ViewPropertyAnimatorUpdateListener(this) {
      public void onAnimationUpdate(View param1View) {
        ((View)this.a.c.getParent()).invalidate();
      }
    };
  
  private Context v;
  
  private Activity w;
  
  private Dialog x;
  
  private ArrayList<TabImpl> y = new ArrayList<TabImpl>();
  
  private TabImpl z;
  
  public WindowDecorActionBar(Activity paramActivity, boolean paramBoolean) {
    this.w = paramActivity;
    View view = paramActivity.getWindow().getDecorView();
    a(view);
    if (!paramBoolean)
      this.f = view.findViewById(16908290); 
  }
  
  public WindowDecorActionBar(Dialog paramDialog) {
    this.x = paramDialog;
    a(paramDialog.getWindow().getDecorView());
  }
  
  public WindowDecorActionBar(View paramView) {
    if (s || paramView.isInEditMode()) {
      a(paramView);
      return;
    } 
    throw new AssertionError();
  }
  
  private void a(View paramView) {
    this.b = (ActionBarOverlayLayout)paramView.findViewById(R.id.decor_content_parent);
    ActionBarOverlayLayout actionBarOverlayLayout = this.b;
    if (actionBarOverlayLayout != null)
      actionBarOverlayLayout.setActionBarVisibilityCallback(this); 
    this.d = b(paramView.findViewById(R.id.action_bar));
    this.e = (ActionBarContextView)paramView.findViewById(R.id.action_context_bar);
    this.c = (ActionBarContainer)paramView.findViewById(R.id.action_bar_container);
    DecorToolbar decorToolbar = this.d;
    if (decorToolbar != null && this.e != null && this.c != null) {
      boolean bool;
      this.a = decorToolbar.getContext();
      if ((this.d.getDisplayOptions() & 0x4) != 0) {
        i = 1;
      } else {
        i = 0;
      } 
      if (i)
        this.B = true; 
      ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(this.a);
      if (actionBarPolicy.enableHomeButtonByDefault() || i) {
        bool = true;
      } else {
        bool = false;
      } 
      setHomeButtonEnabled(bool);
      a(actionBarPolicy.hasEmbeddedTabs());
      TypedArray typedArray = this.a.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
      if (typedArray.getBoolean(R.styleable.ActionBar_hideOnContentScroll, false))
        setHideOnContentScrollEnabled(true); 
      int i = typedArray.getDimensionPixelSize(R.styleable.ActionBar_elevation, 0);
      if (i != 0)
        setElevation(i); 
      typedArray.recycle();
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getSimpleName());
    stringBuilder.append(" can only be used with a compatible window decor layout");
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  private void a(ActionBar.Tab paramTab, int paramInt) {
    paramTab = paramTab;
    if (paramTab.getCallback() != null) {
      paramTab.setPosition(paramInt);
      this.y.add(paramInt, paramTab);
      int i = this.y.size();
      while (true) {
        if (++paramInt < i) {
          ((TabImpl)this.y.get(paramInt)).setPosition(paramInt);
          continue;
        } 
        break;
      } 
      return;
    } 
    throw new IllegalStateException("Action Bar Tab must have a Callback");
  }
  
  private void a(boolean paramBoolean) {
    this.E = paramBoolean;
    if (!this.E) {
      this.d.setEmbeddedTabView(null);
      this.c.setTabContainer(this.g);
    } else {
      this.c.setTabContainer(null);
      this.d.setEmbeddedTabView(this.g);
    } 
    int i = getNavigationMode();
    boolean bool = true;
    if (i == 2) {
      i = 1;
    } else {
      i = 0;
    } 
    ScrollingTabContainerView scrollingTabContainerView = this.g;
    if (scrollingTabContainerView != null) {
      ActionBarOverlayLayout actionBarOverlayLayout1;
      if (i != 0) {
        scrollingTabContainerView.setVisibility(0);
        actionBarOverlayLayout1 = this.b;
        if (actionBarOverlayLayout1 != null)
          ViewCompat.requestApplyInsets((View)actionBarOverlayLayout1); 
      } else {
        actionBarOverlayLayout1.setVisibility(8);
      } 
    } 
    DecorToolbar decorToolbar = this.d;
    if (!this.E && i != 0) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    } 
    decorToolbar.setCollapsible(paramBoolean);
    ActionBarOverlayLayout actionBarOverlayLayout = this.b;
    if (!this.E && i != 0) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    } 
    actionBarOverlayLayout.setHasNonEmbeddedTabs(paramBoolean);
  }
  
  static boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    return paramBoolean3 ? true : (!(paramBoolean1 || paramBoolean2));
  }
  
  private DecorToolbar b(View paramView) {
    String str;
    if (paramView instanceof DecorToolbar)
      return (DecorToolbar)paramView; 
    if (paramView instanceof Toolbar)
      return ((Toolbar)paramView).getWrapper(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Can't make a decor toolbar out of ");
    if (paramView != null) {
      str = paramView.getClass().getSimpleName();
    } else {
      str = "null";
    } 
    stringBuilder.append(str);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  private void b(boolean paramBoolean) {
    if (a(this.l, this.m, this.G)) {
      if (!this.H) {
        this.H = true;
        doShow(paramBoolean);
        return;
      } 
    } else if (this.H) {
      this.H = false;
      doHide(paramBoolean);
    } 
  }
  
  private void c() {
    if (this.g != null)
      return; 
    ScrollingTabContainerView scrollingTabContainerView = new ScrollingTabContainerView(this.a);
    if (this.E) {
      scrollingTabContainerView.setVisibility(0);
      this.d.setEmbeddedTabView(scrollingTabContainerView);
    } else {
      if (getNavigationMode() == 2) {
        scrollingTabContainerView.setVisibility(0);
        ActionBarOverlayLayout actionBarOverlayLayout = this.b;
        if (actionBarOverlayLayout != null)
          ViewCompat.requestApplyInsets((View)actionBarOverlayLayout); 
      } else {
        scrollingTabContainerView.setVisibility(8);
      } 
      this.c.setTabContainer(scrollingTabContainerView);
    } 
    this.g = scrollingTabContainerView;
  }
  
  private void d() {
    if (this.z != null)
      selectTab(null); 
    this.y.clear();
    ScrollingTabContainerView scrollingTabContainerView = this.g;
    if (scrollingTabContainerView != null)
      scrollingTabContainerView.removeAllTabs(); 
    this.A = -1;
  }
  
  private void e() {
    if (!this.G) {
      this.G = true;
      ActionBarOverlayLayout actionBarOverlayLayout = this.b;
      if (actionBarOverlayLayout != null)
        actionBarOverlayLayout.setShowingForActionMode(true); 
      b(false);
    } 
  }
  
  private void f() {
    if (this.G) {
      this.G = false;
      ActionBarOverlayLayout actionBarOverlayLayout = this.b;
      if (actionBarOverlayLayout != null)
        actionBarOverlayLayout.setShowingForActionMode(false); 
      b(false);
    } 
  }
  
  private boolean g() {
    return ViewCompat.isLaidOut((View)this.c);
  }
  
  public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener paramOnMenuVisibilityListener) {
    this.D.add(paramOnMenuVisibilityListener);
  }
  
  public void addTab(ActionBar.Tab paramTab) {
    addTab(paramTab, this.y.isEmpty());
  }
  
  public void addTab(ActionBar.Tab paramTab, int paramInt) {
    addTab(paramTab, paramInt, this.y.isEmpty());
  }
  
  public void addTab(ActionBar.Tab paramTab, int paramInt, boolean paramBoolean) {
    c();
    this.g.addTab(paramTab, paramInt, paramBoolean);
    a(paramTab, paramInt);
    if (paramBoolean)
      selectTab(paramTab); 
  }
  
  public void addTab(ActionBar.Tab paramTab, boolean paramBoolean) {
    c();
    this.g.addTab(paramTab, paramBoolean);
    a(paramTab, this.y.size());
    if (paramBoolean)
      selectTab(paramTab); 
  }
  
  public void animateToMode(boolean paramBoolean) {
    if (paramBoolean) {
      e();
    } else {
      f();
    } 
    if (g()) {
      ViewPropertyAnimatorCompat viewPropertyAnimatorCompat1;
      ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2;
      if (paramBoolean) {
        viewPropertyAnimatorCompat2 = this.d.setupAnimatorToVisibility(4, 100L);
        viewPropertyAnimatorCompat1 = this.e.setupAnimatorToVisibility(0, 200L);
      } else {
        viewPropertyAnimatorCompat1 = this.d.setupAnimatorToVisibility(0, 200L);
        viewPropertyAnimatorCompat2 = this.e.setupAnimatorToVisibility(8, 100L);
      } 
      ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
      viewPropertyAnimatorCompatSet.playSequentially(viewPropertyAnimatorCompat2, viewPropertyAnimatorCompat1);
      viewPropertyAnimatorCompatSet.start();
      return;
    } 
    if (paramBoolean) {
      this.d.setVisibility(4);
      this.e.setVisibility(0);
      return;
    } 
    this.d.setVisibility(0);
    this.e.setVisibility(8);
  }
  
  void b() {
    ActionMode.Callback callback = this.j;
    if (callback != null) {
      callback.onDestroyActionMode(this.i);
      this.i = null;
      this.j = null;
    } 
  }
  
  public boolean collapseActionView() {
    DecorToolbar decorToolbar = this.d;
    if (decorToolbar != null && decorToolbar.hasExpandedActionView()) {
      this.d.collapseActionView();
      return true;
    } 
    return false;
  }
  
  public void dispatchMenuVisibilityChanged(boolean paramBoolean) {
    if (paramBoolean == this.C)
      return; 
    this.C = paramBoolean;
    int j = this.D.size();
    for (int i = 0; i < j; i++)
      ((ActionBar.OnMenuVisibilityListener)this.D.get(i)).onMenuVisibilityChanged(paramBoolean); 
  }
  
  public void doHide(boolean paramBoolean) {
    ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.n;
    if (viewPropertyAnimatorCompatSet != null)
      viewPropertyAnimatorCompatSet.cancel(); 
    if (this.F == 0 && (this.I || paramBoolean)) {
      this.c.setAlpha(1.0F);
      this.c.setTransitioning(true);
      viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
      float f2 = -this.c.getHeight();
      float f1 = f2;
      if (paramBoolean) {
        int[] arrayOfInt = new int[2];
        arrayOfInt[0] = 0;
        arrayOfInt[1] = 0;
        this.c.getLocationInWindow(arrayOfInt);
        f1 = f2 - arrayOfInt[1];
      } 
      ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = ViewCompat.animate((View)this.c).translationY(f1);
      viewPropertyAnimatorCompat.setUpdateListener(this.r);
      viewPropertyAnimatorCompatSet.play(viewPropertyAnimatorCompat);
      if (this.k) {
        View view = this.f;
        if (view != null)
          viewPropertyAnimatorCompatSet.play(ViewCompat.animate(view).translationY(f1)); 
      } 
      viewPropertyAnimatorCompatSet.setInterpolator(t);
      viewPropertyAnimatorCompatSet.setDuration(250L);
      viewPropertyAnimatorCompatSet.setListener(this.p);
      this.n = viewPropertyAnimatorCompatSet;
      viewPropertyAnimatorCompatSet.start();
      return;
    } 
    this.p.onAnimationEnd(null);
  }
  
  public void doShow(boolean paramBoolean) {
    ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.n;
    if (viewPropertyAnimatorCompatSet != null)
      viewPropertyAnimatorCompatSet.cancel(); 
    this.c.setVisibility(0);
    if (this.F == 0 && (this.I || paramBoolean)) {
      this.c.setTranslationY(0.0F);
      float f2 = -this.c.getHeight();
      float f1 = f2;
      if (paramBoolean) {
        int[] arrayOfInt = new int[2];
        arrayOfInt[0] = 0;
        arrayOfInt[1] = 0;
        this.c.getLocationInWindow(arrayOfInt);
        f1 = f2 - arrayOfInt[1];
      } 
      this.c.setTranslationY(f1);
      viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
      ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = ViewCompat.animate((View)this.c).translationY(0.0F);
      viewPropertyAnimatorCompat.setUpdateListener(this.r);
      viewPropertyAnimatorCompatSet.play(viewPropertyAnimatorCompat);
      if (this.k) {
        View view = this.f;
        if (view != null) {
          view.setTranslationY(f1);
          viewPropertyAnimatorCompatSet.play(ViewCompat.animate(this.f).translationY(0.0F));
        } 
      } 
      viewPropertyAnimatorCompatSet.setInterpolator(u);
      viewPropertyAnimatorCompatSet.setDuration(250L);
      viewPropertyAnimatorCompatSet.setListener(this.q);
      this.n = viewPropertyAnimatorCompatSet;
      viewPropertyAnimatorCompatSet.start();
    } else {
      this.c.setAlpha(1.0F);
      this.c.setTranslationY(0.0F);
      if (this.k) {
        View view = this.f;
        if (view != null)
          view.setTranslationY(0.0F); 
      } 
      this.q.onAnimationEnd(null);
    } 
    ActionBarOverlayLayout actionBarOverlayLayout = this.b;
    if (actionBarOverlayLayout != null)
      ViewCompat.requestApplyInsets((View)actionBarOverlayLayout); 
  }
  
  public void enableContentAnimations(boolean paramBoolean) {
    this.k = paramBoolean;
  }
  
  public View getCustomView() {
    return this.d.getCustomView();
  }
  
  public int getDisplayOptions() {
    return this.d.getDisplayOptions();
  }
  
  public float getElevation() {
    return ViewCompat.getElevation((View)this.c);
  }
  
  public int getHeight() {
    return this.c.getHeight();
  }
  
  public int getHideOffset() {
    return this.b.getActionBarHideOffset();
  }
  
  public int getNavigationItemCount() {
    int i = this.d.getNavigationMode();
    return (i != 1) ? ((i != 2) ? 0 : this.y.size()) : this.d.getDropdownItemCount();
  }
  
  public int getNavigationMode() {
    return this.d.getNavigationMode();
  }
  
  public int getSelectedNavigationIndex() {
    int i = this.d.getNavigationMode();
    if (i != 1) {
      int j = -1;
      if (i != 2)
        return -1; 
      TabImpl tabImpl = this.z;
      if (tabImpl != null)
        j = tabImpl.getPosition(); 
      return j;
    } 
    return this.d.getDropdownSelectedPosition();
  }
  
  public ActionBar.Tab getSelectedTab() {
    return this.z;
  }
  
  public CharSequence getSubtitle() {
    return this.d.getSubtitle();
  }
  
  public ActionBar.Tab getTabAt(int paramInt) {
    return this.y.get(paramInt);
  }
  
  public int getTabCount() {
    return this.y.size();
  }
  
  public Context getThemedContext() {
    if (this.v == null) {
      TypedValue typedValue = new TypedValue();
      this.a.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
      int i = typedValue.resourceId;
      if (i != 0) {
        this.v = (Context)new ContextThemeWrapper(this.a, i);
      } else {
        this.v = this.a;
      } 
    } 
    return this.v;
  }
  
  public CharSequence getTitle() {
    return this.d.getTitle();
  }
  
  public boolean hasIcon() {
    return this.d.hasIcon();
  }
  
  public boolean hasLogo() {
    return this.d.hasLogo();
  }
  
  public void hide() {
    if (!this.l) {
      this.l = true;
      b(false);
    } 
  }
  
  public void hideForSystem() {
    if (!this.m) {
      this.m = true;
      b(true);
    } 
  }
  
  public boolean isHideOnContentScrollEnabled() {
    return this.b.isHideOnContentScrollEnabled();
  }
  
  public boolean isShowing() {
    int i = getHeight();
    return (this.H && (i == 0 || getHideOffset() < i));
  }
  
  public boolean isTitleTruncated() {
    DecorToolbar decorToolbar = this.d;
    return (decorToolbar != null && decorToolbar.isTitleTruncated());
  }
  
  public ActionBar.Tab newTab() {
    return new TabImpl(this);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    a(ActionBarPolicy.get(this.a).hasEmbeddedTabs());
  }
  
  public void onContentScrollStarted() {
    ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.n;
    if (viewPropertyAnimatorCompatSet != null) {
      viewPropertyAnimatorCompatSet.cancel();
      this.n = null;
    } 
  }
  
  public void onContentScrollStopped() {}
  
  public boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent) {
    ActionModeImpl actionModeImpl = this.h;
    if (actionModeImpl == null)
      return false; 
    Menu menu = actionModeImpl.getMenu();
    if (menu != null) {
      if (paramKeyEvent != null) {
        i = paramKeyEvent.getDeviceId();
      } else {
        i = -1;
      } 
      int i = KeyCharacterMap.load(i).getKeyboardType();
      boolean bool = true;
      if (i == 1)
        bool = false; 
      menu.setQwertyMode(bool);
      return menu.performShortcut(paramInt, paramKeyEvent, 0);
    } 
    return false;
  }
  
  public void onWindowVisibilityChanged(int paramInt) {
    this.F = paramInt;
  }
  
  public void removeAllTabs() {
    d();
  }
  
  public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener paramOnMenuVisibilityListener) {
    this.D.remove(paramOnMenuVisibilityListener);
  }
  
  public void removeTab(ActionBar.Tab paramTab) {
    removeTabAt(paramTab.getPosition());
  }
  
  public void removeTabAt(int paramInt) {
    int i;
    if (this.g == null)
      return; 
    TabImpl tabImpl = this.z;
    if (tabImpl != null) {
      i = tabImpl.getPosition();
    } else {
      i = this.A;
    } 
    this.g.removeTabAt(paramInt);
    tabImpl = this.y.remove(paramInt);
    if (tabImpl != null)
      tabImpl.setPosition(-1); 
    int k = this.y.size();
    for (int j = paramInt; j < k; j++)
      ((TabImpl)this.y.get(j)).setPosition(j); 
    if (i == paramInt) {
      if (this.y.isEmpty()) {
        tabImpl = null;
      } else {
        tabImpl = this.y.get(Math.max(0, paramInt - 1));
      } 
      selectTab(tabImpl);
    } 
  }
  
  public boolean requestFocus() {
    ViewGroup viewGroup = this.d.getViewGroup();
    if (viewGroup != null && !viewGroup.hasFocus()) {
      viewGroup.requestFocus();
      return true;
    } 
    return false;
  }
  
  public void selectTab(ActionBar.Tab paramTab) {
    FragmentTransaction fragmentTransaction;
    int j = getNavigationMode();
    int i = -1;
    if (j != 2) {
      if (paramTab != null)
        i = paramTab.getPosition(); 
      this.A = i;
      return;
    } 
    if (this.w instanceof FragmentActivity && !this.d.getViewGroup().isInEditMode()) {
      fragmentTransaction = ((FragmentActivity)this.w).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
    } else {
      fragmentTransaction = null;
    } 
    TabImpl tabImpl = this.z;
    if (tabImpl == paramTab) {
      if (tabImpl != null) {
        tabImpl.getCallback().onTabReselected(this.z, fragmentTransaction);
        this.g.animateToTab(paramTab.getPosition());
      } 
    } else {
      ScrollingTabContainerView scrollingTabContainerView = this.g;
      if (paramTab != null)
        i = paramTab.getPosition(); 
      scrollingTabContainerView.setTabSelected(i);
      TabImpl tabImpl1 = this.z;
      if (tabImpl1 != null)
        tabImpl1.getCallback().onTabUnselected(this.z, fragmentTransaction); 
      this.z = (TabImpl)paramTab;
      paramTab = this.z;
      if (paramTab != null)
        paramTab.getCallback().onTabSelected(this.z, fragmentTransaction); 
    } 
    if (fragmentTransaction != null && !fragmentTransaction.isEmpty())
      fragmentTransaction.commit(); 
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable) {
    this.c.setPrimaryBackground(paramDrawable);
  }
  
  public void setCustomView(int paramInt) {
    setCustomView(LayoutInflater.from(getThemedContext()).inflate(paramInt, this.d.getViewGroup(), false));
  }
  
  public void setCustomView(View paramView) {
    this.d.setCustomView(paramView);
  }
  
  public void setCustomView(View paramView, ActionBar.LayoutParams paramLayoutParams) {
    paramView.setLayoutParams((ViewGroup.LayoutParams)paramLayoutParams);
    this.d.setCustomView(paramView);
  }
  
  public void setDefaultDisplayHomeAsUpEnabled(boolean paramBoolean) {
    if (!this.B)
      setDisplayHomeAsUpEnabled(paramBoolean); 
  }
  
  public void setDisplayHomeAsUpEnabled(boolean paramBoolean) {
    boolean bool;
    if (paramBoolean) {
      bool = true;
    } else {
      bool = false;
    } 
    setDisplayOptions(bool, 4);
  }
  
  public void setDisplayOptions(int paramInt) {
    if ((paramInt & 0x4) != 0)
      this.B = true; 
    this.d.setDisplayOptions(paramInt);
  }
  
  public void setDisplayOptions(int paramInt1, int paramInt2) {
    int i = this.d.getDisplayOptions();
    if ((paramInt2 & 0x4) != 0)
      this.B = true; 
    this.d.setDisplayOptions(paramInt1 & paramInt2 | paramInt2 & i);
  }
  
  public void setDisplayShowCustomEnabled(boolean paramBoolean) {
    boolean bool;
    if (paramBoolean) {
      bool = true;
    } else {
      bool = false;
    } 
    setDisplayOptions(bool, 16);
  }
  
  public void setDisplayShowHomeEnabled(boolean paramBoolean) {
    boolean bool;
    if (paramBoolean) {
      bool = true;
    } else {
      bool = false;
    } 
    setDisplayOptions(bool, 2);
  }
  
  public void setDisplayShowTitleEnabled(boolean paramBoolean) {
    boolean bool;
    if (paramBoolean) {
      bool = true;
    } else {
      bool = false;
    } 
    setDisplayOptions(bool, 8);
  }
  
  public void setDisplayUseLogoEnabled(boolean paramBoolean) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void setElevation(float paramFloat) {
    ViewCompat.setElevation((View)this.c, paramFloat);
  }
  
  public void setHideOffset(int paramInt) {
    if (paramInt == 0 || this.b.isInOverlayMode()) {
      this.b.setActionBarHideOffset(paramInt);
      return;
    } 
    throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
  }
  
  public void setHideOnContentScrollEnabled(boolean paramBoolean) {
    if (!paramBoolean || this.b.isInOverlayMode()) {
      this.o = paramBoolean;
      this.b.setHideOnContentScrollEnabled(paramBoolean);
      return;
    } 
    throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
  }
  
  public void setHomeActionContentDescription(int paramInt) {
    this.d.setNavigationContentDescription(paramInt);
  }
  
  public void setHomeActionContentDescription(CharSequence paramCharSequence) {
    this.d.setNavigationContentDescription(paramCharSequence);
  }
  
  public void setHomeAsUpIndicator(int paramInt) {
    this.d.setNavigationIcon(paramInt);
  }
  
  public void setHomeAsUpIndicator(Drawable paramDrawable) {
    this.d.setNavigationIcon(paramDrawable);
  }
  
  public void setHomeButtonEnabled(boolean paramBoolean) {
    this.d.setHomeButtonEnabled(paramBoolean);
  }
  
  public void setIcon(int paramInt) {
    this.d.setIcon(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable) {
    this.d.setIcon(paramDrawable);
  }
  
  public void setListNavigationCallbacks(SpinnerAdapter paramSpinnerAdapter, ActionBar.OnNavigationListener paramOnNavigationListener) {
    this.d.setDropdownParams(paramSpinnerAdapter, new NavItemSelectedListener(paramOnNavigationListener));
  }
  
  public void setLogo(int paramInt) {
    this.d.setLogo(paramInt);
  }
  
  public void setLogo(Drawable paramDrawable) {
    this.d.setLogo(paramDrawable);
  }
  
  public void setNavigationMode(int paramInt) {
    int i = this.d.getNavigationMode();
    if (i == 2) {
      this.A = getSelectedNavigationIndex();
      selectTab(null);
      this.g.setVisibility(8);
    } 
    if (i != paramInt && !this.E) {
      ActionBarOverlayLayout actionBarOverlayLayout1 = this.b;
      if (actionBarOverlayLayout1 != null)
        ViewCompat.requestApplyInsets((View)actionBarOverlayLayout1); 
    } 
    this.d.setNavigationMode(paramInt);
    boolean bool2 = false;
    if (paramInt == 2) {
      c();
      this.g.setVisibility(0);
      i = this.A;
      if (i != -1) {
        setSelectedNavigationItem(i);
        this.A = -1;
      } 
    } 
    DecorToolbar decorToolbar = this.d;
    if (paramInt == 2 && !this.E) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    decorToolbar.setCollapsible(bool1);
    ActionBarOverlayLayout actionBarOverlayLayout = this.b;
    boolean bool1 = bool2;
    if (paramInt == 2) {
      bool1 = bool2;
      if (!this.E)
        bool1 = true; 
    } 
    actionBarOverlayLayout.setHasNonEmbeddedTabs(bool1);
  }
  
  public void setSelectedNavigationItem(int paramInt) {
    int i = this.d.getNavigationMode();
    if (i != 1) {
      if (i == 2) {
        selectTab(this.y.get(paramInt));
        return;
      } 
      throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
    } 
    this.d.setDropdownSelectedPosition(paramInt);
  }
  
  public void setShowHideAnimationEnabled(boolean paramBoolean) {
    this.I = paramBoolean;
    if (!paramBoolean) {
      ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.n;
      if (viewPropertyAnimatorCompatSet != null)
        viewPropertyAnimatorCompatSet.cancel(); 
    } 
  }
  
  public void setSplitBackgroundDrawable(Drawable paramDrawable) {}
  
  public void setStackedBackgroundDrawable(Drawable paramDrawable) {
    this.c.setStackedBackground(paramDrawable);
  }
  
  public void setSubtitle(int paramInt) {
    setSubtitle(this.a.getString(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence) {
    this.d.setSubtitle(paramCharSequence);
  }
  
  public void setTitle(int paramInt) {
    setTitle(this.a.getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence) {
    this.d.setTitle(paramCharSequence);
  }
  
  public void setWindowTitle(CharSequence paramCharSequence) {
    this.d.setWindowTitle(paramCharSequence);
  }
  
  public void show() {
    if (this.l) {
      this.l = false;
      b(false);
    } 
  }
  
  public void showForSystem() {
    if (this.m) {
      this.m = false;
      b(true);
    } 
  }
  
  public ActionMode startActionMode(ActionMode.Callback paramCallback) {
    ActionModeImpl actionModeImpl2 = this.h;
    if (actionModeImpl2 != null)
      actionModeImpl2.finish(); 
    this.b.setHideOnContentScrollEnabled(false);
    this.e.killMode();
    ActionModeImpl actionModeImpl1 = new ActionModeImpl(this, this.e.getContext(), paramCallback);
    if (actionModeImpl1.dispatchOnCreate()) {
      this.h = actionModeImpl1;
      actionModeImpl1.invalidate();
      this.e.initForMode(actionModeImpl1);
      animateToMode(true);
      this.e.sendAccessibilityEvent(32);
      return actionModeImpl1;
    } 
    return null;
  }
  
  public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
    private final Context b;
    
    private final MenuBuilder c;
    
    private ActionMode.Callback d;
    
    private WeakReference<View> e;
    
    public ActionModeImpl(WindowDecorActionBar this$0, Context param1Context, ActionMode.Callback param1Callback) {
      this.b = param1Context;
      this.d = param1Callback;
      this.c = (new MenuBuilder(param1Context)).setDefaultShowAsAction(1);
      this.c.setCallback(this);
    }
    
    public boolean dispatchOnCreate() {
      this.c.stopDispatchingItemsChanged();
      try {
        return this.d.onCreateActionMode(this, (Menu)this.c);
      } finally {
        this.c.startDispatchingItemsChanged();
      } 
    }
    
    public void finish() {
      if (this.a.h != this)
        return; 
      if (!WindowDecorActionBar.a(this.a.l, this.a.m, false)) {
        WindowDecorActionBar windowDecorActionBar = this.a;
        windowDecorActionBar.i = this;
        windowDecorActionBar.j = this.d;
      } else {
        this.d.onDestroyActionMode(this);
      } 
      this.d = null;
      this.a.animateToMode(false);
      this.a.e.closeMode();
      this.a.d.getViewGroup().sendAccessibilityEvent(32);
      this.a.b.setHideOnContentScrollEnabled(this.a.o);
      this.a.h = null;
    }
    
    public View getCustomView() {
      WeakReference<View> weakReference = this.e;
      return (weakReference != null) ? weakReference.get() : null;
    }
    
    public Menu getMenu() {
      return (Menu)this.c;
    }
    
    public MenuInflater getMenuInflater() {
      return (MenuInflater)new SupportMenuInflater(this.b);
    }
    
    public CharSequence getSubtitle() {
      return this.a.e.getSubtitle();
    }
    
    public CharSequence getTitle() {
      return this.a.e.getTitle();
    }
    
    public void invalidate() {
      if (this.a.h != this)
        return; 
      this.c.stopDispatchingItemsChanged();
      try {
        this.d.onPrepareActionMode(this, (Menu)this.c);
        return;
      } finally {
        this.c.startDispatchingItemsChanged();
      } 
    }
    
    public boolean isTitleOptional() {
      return this.a.e.isTitleOptional();
    }
    
    public void onCloseMenu(MenuBuilder param1MenuBuilder, boolean param1Boolean) {}
    
    public void onCloseSubMenu(SubMenuBuilder param1SubMenuBuilder) {}
    
    public boolean onMenuItemSelected(MenuBuilder param1MenuBuilder, MenuItem param1MenuItem) {
      ActionMode.Callback callback = this.d;
      return (callback != null) ? callback.onActionItemClicked(this, param1MenuItem) : false;
    }
    
    public void onMenuModeChange(MenuBuilder param1MenuBuilder) {
      if (this.d == null)
        return; 
      invalidate();
      this.a.e.showOverflowMenu();
    }
    
    public boolean onSubMenuSelected(SubMenuBuilder param1SubMenuBuilder) {
      if (this.d == null)
        return false; 
      if (!param1SubMenuBuilder.hasVisibleItems())
        return true; 
      (new MenuPopupHelper(this.a.getThemedContext(), (MenuBuilder)param1SubMenuBuilder)).show();
      return true;
    }
    
    public void setCustomView(View param1View) {
      this.a.e.setCustomView(param1View);
      this.e = new WeakReference<View>(param1View);
    }
    
    public void setSubtitle(int param1Int) {
      setSubtitle(this.a.a.getResources().getString(param1Int));
    }
    
    public void setSubtitle(CharSequence param1CharSequence) {
      this.a.e.setSubtitle(param1CharSequence);
    }
    
    public void setTitle(int param1Int) {
      setTitle(this.a.a.getResources().getString(param1Int));
    }
    
    public void setTitle(CharSequence param1CharSequence) {
      this.a.e.setTitle(param1CharSequence);
    }
    
    public void setTitleOptionalHint(boolean param1Boolean) {
      super.setTitleOptionalHint(param1Boolean);
      this.a.e.setTitleOptional(param1Boolean);
    }
  }
  
  public class TabImpl extends ActionBar.Tab {
    private ActionBar.TabListener b;
    
    private Object c;
    
    private Drawable d;
    
    private CharSequence e;
    
    private CharSequence f;
    
    private int g = -1;
    
    private View h;
    
    public TabImpl(WindowDecorActionBar this$0) {}
    
    public ActionBar.TabListener getCallback() {
      return this.b;
    }
    
    public CharSequence getContentDescription() {
      return this.f;
    }
    
    public View getCustomView() {
      return this.h;
    }
    
    public Drawable getIcon() {
      return this.d;
    }
    
    public int getPosition() {
      return this.g;
    }
    
    public Object getTag() {
      return this.c;
    }
    
    public CharSequence getText() {
      return this.e;
    }
    
    public void select() {
      this.a.selectTab(this);
    }
    
    public ActionBar.Tab setContentDescription(int param1Int) {
      return setContentDescription(this.a.a.getResources().getText(param1Int));
    }
    
    public ActionBar.Tab setContentDescription(CharSequence param1CharSequence) {
      this.f = param1CharSequence;
      if (this.g >= 0)
        this.a.g.updateTab(this.g); 
      return this;
    }
    
    public ActionBar.Tab setCustomView(int param1Int) {
      return setCustomView(LayoutInflater.from(this.a.getThemedContext()).inflate(param1Int, null));
    }
    
    public ActionBar.Tab setCustomView(View param1View) {
      this.h = param1View;
      if (this.g >= 0)
        this.a.g.updateTab(this.g); 
      return this;
    }
    
    public ActionBar.Tab setIcon(int param1Int) {
      return setIcon(AppCompatResources.getDrawable(this.a.a, param1Int));
    }
    
    public ActionBar.Tab setIcon(Drawable param1Drawable) {
      this.d = param1Drawable;
      if (this.g >= 0)
        this.a.g.updateTab(this.g); 
      return this;
    }
    
    public void setPosition(int param1Int) {
      this.g = param1Int;
    }
    
    public ActionBar.Tab setTabListener(ActionBar.TabListener param1TabListener) {
      this.b = param1TabListener;
      return this;
    }
    
    public ActionBar.Tab setTag(Object param1Object) {
      this.c = param1Object;
      return this;
    }
    
    public ActionBar.Tab setText(int param1Int) {
      return setText(this.a.a.getResources().getText(param1Int));
    }
    
    public ActionBar.Tab setText(CharSequence param1CharSequence) {
      this.e = param1CharSequence;
      if (this.g >= 0)
        this.a.g.updateTab(this.g); 
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\app\WindowDecorActionBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */