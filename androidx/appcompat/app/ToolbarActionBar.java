package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.SpinnerAdapter;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;

class ToolbarActionBar extends ActionBar {
  DecorToolbar a;
  
  boolean b;
  
  Window.Callback c;
  
  private boolean d;
  
  private boolean e;
  
  private ArrayList<ActionBar.OnMenuVisibilityListener> f = new ArrayList<ActionBar.OnMenuVisibilityListener>();
  
  private final Runnable g = new Runnable(this) {
      public void run() {
        this.a.b();
      }
    };
  
  private final Toolbar.OnMenuItemClickListener h = new Toolbar.OnMenuItemClickListener(this) {
      public boolean onMenuItemClick(MenuItem param1MenuItem) {
        return this.a.c.onMenuItemSelected(0, param1MenuItem);
      }
    };
  
  ToolbarActionBar(Toolbar paramToolbar, CharSequence paramCharSequence, Window.Callback paramCallback) {
    this.a = (DecorToolbar)new ToolbarWidgetWrapper(paramToolbar, false);
    this.c = (Window.Callback)new ToolbarCallbackWrapper(this, paramCallback);
    this.a.setWindowCallback(this.c);
    paramToolbar.setOnMenuItemClickListener(this.h);
    this.a.setWindowTitle(paramCharSequence);
  }
  
  private Menu c() {
    if (!this.d) {
      this.a.setMenuCallbacks(new ActionMenuPresenterCallback(this), new MenuBuilderCallback(this));
      this.d = true;
    } 
    return this.a.getMenu();
  }
  
  void a() {
    this.a.getViewGroup().removeCallbacks(this.g);
  }
  
  public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener paramOnMenuVisibilityListener) {
    this.f.add(paramOnMenuVisibilityListener);
  }
  
  public void addTab(ActionBar.Tab paramTab) {
    throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
  }
  
  public void addTab(ActionBar.Tab paramTab, int paramInt) {
    throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
  }
  
  public void addTab(ActionBar.Tab paramTab, int paramInt, boolean paramBoolean) {
    throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
  }
  
  public void addTab(ActionBar.Tab paramTab, boolean paramBoolean) {
    throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
  }
  
  void b() {
    MenuBuilder menuBuilder;
    null = c();
    if (null instanceof MenuBuilder) {
      menuBuilder = (MenuBuilder)null;
    } else {
      menuBuilder = null;
    } 
    if (menuBuilder != null)
      menuBuilder.stopDispatchingItemsChanged(); 
    try {
      null.clear();
      if (!this.c.onCreatePanelMenu(0, null) || !this.c.onPreparePanel(0, null, null))
        null.clear(); 
      return;
    } finally {
      if (menuBuilder != null)
        menuBuilder.startDispatchingItemsChanged(); 
    } 
  }
  
  public boolean closeOptionsMenu() {
    return this.a.hideOverflowMenu();
  }
  
  public boolean collapseActionView() {
    if (this.a.hasExpandedActionView()) {
      this.a.collapseActionView();
      return true;
    } 
    return false;
  }
  
  public void dispatchMenuVisibilityChanged(boolean paramBoolean) {
    if (paramBoolean == this.e)
      return; 
    this.e = paramBoolean;
    int j = this.f.size();
    for (int i = 0; i < j; i++)
      ((ActionBar.OnMenuVisibilityListener)this.f.get(i)).onMenuVisibilityChanged(paramBoolean); 
  }
  
  public View getCustomView() {
    return this.a.getCustomView();
  }
  
  public int getDisplayOptions() {
    return this.a.getDisplayOptions();
  }
  
  public float getElevation() {
    return ViewCompat.getElevation((View)this.a.getViewGroup());
  }
  
  public int getHeight() {
    return this.a.getHeight();
  }
  
  public int getNavigationItemCount() {
    return 0;
  }
  
  public int getNavigationMode() {
    return 0;
  }
  
  public int getSelectedNavigationIndex() {
    return -1;
  }
  
  public ActionBar.Tab getSelectedTab() {
    throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
  }
  
  public CharSequence getSubtitle() {
    return this.a.getSubtitle();
  }
  
  public ActionBar.Tab getTabAt(int paramInt) {
    throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
  }
  
  public int getTabCount() {
    return 0;
  }
  
  public Context getThemedContext() {
    return this.a.getContext();
  }
  
  public CharSequence getTitle() {
    return this.a.getTitle();
  }
  
  public Window.Callback getWrappedWindowCallback() {
    return this.c;
  }
  
  public void hide() {
    this.a.setVisibility(8);
  }
  
  public boolean invalidateOptionsMenu() {
    this.a.getViewGroup().removeCallbacks(this.g);
    ViewCompat.postOnAnimation((View)this.a.getViewGroup(), this.g);
    return true;
  }
  
  public boolean isShowing() {
    return (this.a.getVisibility() == 0);
  }
  
  public boolean isTitleTruncated() {
    return super.isTitleTruncated();
  }
  
  public ActionBar.Tab newTab() {
    throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent) {
    Menu menu = c();
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
  
  public boolean onMenuKeyEvent(KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getAction() == 1)
      openOptionsMenu(); 
    return true;
  }
  
  public boolean openOptionsMenu() {
    return this.a.showOverflowMenu();
  }
  
  public void removeAllTabs() {
    throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
  }
  
  public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener paramOnMenuVisibilityListener) {
    this.f.remove(paramOnMenuVisibilityListener);
  }
  
  public void removeTab(ActionBar.Tab paramTab) {
    throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
  }
  
  public void removeTabAt(int paramInt) {
    throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
  }
  
  public boolean requestFocus() {
    ViewGroup viewGroup = this.a.getViewGroup();
    if (viewGroup != null && !viewGroup.hasFocus()) {
      viewGroup.requestFocus();
      return true;
    } 
    return false;
  }
  
  public void selectTab(ActionBar.Tab paramTab) {
    throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable) {
    this.a.setBackgroundDrawable(paramDrawable);
  }
  
  public void setCustomView(int paramInt) {
    setCustomView(LayoutInflater.from(this.a.getContext()).inflate(paramInt, this.a.getViewGroup(), false));
  }
  
  public void setCustomView(View paramView) {
    setCustomView(paramView, new ActionBar.LayoutParams(-2, -2));
  }
  
  public void setCustomView(View paramView, ActionBar.LayoutParams paramLayoutParams) {
    if (paramView != null)
      paramView.setLayoutParams((ViewGroup.LayoutParams)paramLayoutParams); 
    this.a.setCustomView(paramView);
  }
  
  public void setDefaultDisplayHomeAsUpEnabled(boolean paramBoolean) {}
  
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
    setDisplayOptions(paramInt, -1);
  }
  
  public void setDisplayOptions(int paramInt1, int paramInt2) {
    int i = this.a.getDisplayOptions();
    this.a.setDisplayOptions(paramInt1 & paramInt2 | paramInt2 & i);
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
    ViewCompat.setElevation((View)this.a.getViewGroup(), paramFloat);
  }
  
  public void setHomeActionContentDescription(int paramInt) {
    this.a.setNavigationContentDescription(paramInt);
  }
  
  public void setHomeActionContentDescription(CharSequence paramCharSequence) {
    this.a.setNavigationContentDescription(paramCharSequence);
  }
  
  public void setHomeAsUpIndicator(int paramInt) {
    this.a.setNavigationIcon(paramInt);
  }
  
  public void setHomeAsUpIndicator(Drawable paramDrawable) {
    this.a.setNavigationIcon(paramDrawable);
  }
  
  public void setHomeButtonEnabled(boolean paramBoolean) {}
  
  public void setIcon(int paramInt) {
    this.a.setIcon(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable) {
    this.a.setIcon(paramDrawable);
  }
  
  public void setListNavigationCallbacks(SpinnerAdapter paramSpinnerAdapter, ActionBar.OnNavigationListener paramOnNavigationListener) {
    this.a.setDropdownParams(paramSpinnerAdapter, new NavItemSelectedListener(paramOnNavigationListener));
  }
  
  public void setLogo(int paramInt) {
    this.a.setLogo(paramInt);
  }
  
  public void setLogo(Drawable paramDrawable) {
    this.a.setLogo(paramDrawable);
  }
  
  public void setNavigationMode(int paramInt) {
    if (paramInt != 2) {
      this.a.setNavigationMode(paramInt);
      return;
    } 
    throw new IllegalArgumentException("Tabs not supported in this configuration");
  }
  
  public void setSelectedNavigationItem(int paramInt) {
    if (this.a.getNavigationMode() == 1) {
      this.a.setDropdownSelectedPosition(paramInt);
      return;
    } 
    throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
  }
  
  public void setShowHideAnimationEnabled(boolean paramBoolean) {}
  
  public void setSplitBackgroundDrawable(Drawable paramDrawable) {}
  
  public void setStackedBackgroundDrawable(Drawable paramDrawable) {}
  
  public void setSubtitle(int paramInt) {
    CharSequence charSequence;
    DecorToolbar decorToolbar = this.a;
    if (paramInt != 0) {
      charSequence = decorToolbar.getContext().getText(paramInt);
    } else {
      charSequence = null;
    } 
    decorToolbar.setSubtitle(charSequence);
  }
  
  public void setSubtitle(CharSequence paramCharSequence) {
    this.a.setSubtitle(paramCharSequence);
  }
  
  public void setTitle(int paramInt) {
    CharSequence charSequence;
    DecorToolbar decorToolbar = this.a;
    if (paramInt != 0) {
      charSequence = decorToolbar.getContext().getText(paramInt);
    } else {
      charSequence = null;
    } 
    decorToolbar.setTitle(charSequence);
  }
  
  public void setTitle(CharSequence paramCharSequence) {
    this.a.setTitle(paramCharSequence);
  }
  
  public void setWindowTitle(CharSequence paramCharSequence) {
    this.a.setWindowTitle(paramCharSequence);
  }
  
  public void show() {
    this.a.setVisibility(0);
  }
  
  final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
    private boolean b;
    
    ActionMenuPresenterCallback(ToolbarActionBar this$0) {}
    
    public void onCloseMenu(MenuBuilder param1MenuBuilder, boolean param1Boolean) {
      if (this.b)
        return; 
      this.b = true;
      this.a.a.dismissPopupMenus();
      if (this.a.c != null)
        this.a.c.onPanelClosed(108, (Menu)param1MenuBuilder); 
      this.b = false;
    }
    
    public boolean onOpenSubMenu(MenuBuilder param1MenuBuilder) {
      if (this.a.c != null) {
        this.a.c.onMenuOpened(108, (Menu)param1MenuBuilder);
        return true;
      } 
      return false;
    }
  }
  
  final class MenuBuilderCallback implements MenuBuilder.Callback {
    MenuBuilderCallback(ToolbarActionBar this$0) {}
    
    public boolean onMenuItemSelected(MenuBuilder param1MenuBuilder, MenuItem param1MenuItem) {
      return false;
    }
    
    public void onMenuModeChange(MenuBuilder param1MenuBuilder) {
      if (this.a.c != null) {
        if (this.a.a.isOverflowMenuShowing()) {
          this.a.c.onPanelClosed(108, (Menu)param1MenuBuilder);
          return;
        } 
        if (this.a.c.onPreparePanel(0, null, (Menu)param1MenuBuilder))
          this.a.c.onMenuOpened(108, (Menu)param1MenuBuilder); 
      } 
    }
  }
  
  class ToolbarCallbackWrapper extends WindowCallbackWrapper {
    public ToolbarCallbackWrapper(ToolbarActionBar this$0, Window.Callback param1Callback) {
      super(param1Callback);
    }
    
    public View onCreatePanelView(int param1Int) {
      return (param1Int == 0) ? new View(this.a.a.getContext()) : super.onCreatePanelView(param1Int);
    }
    
    public boolean onPreparePanel(int param1Int, View param1View, Menu param1Menu) {
      boolean bool = super.onPreparePanel(param1Int, param1View, param1Menu);
      if (bool && !this.a.b) {
        this.a.a.setMenuPrepared();
        this.a.b = true;
      } 
      return bool;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\app\ToolbarActionBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */