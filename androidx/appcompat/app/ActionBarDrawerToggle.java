package androidx.appcompat.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {
  boolean a = true;
  
  View.OnClickListener b;
  
  private final Delegate c;
  
  private final DrawerLayout d;
  
  private DrawerArrowDrawable e;
  
  private boolean f = true;
  
  private Drawable g;
  
  private boolean h;
  
  private final int i;
  
  private final int j;
  
  private boolean k = false;
  
  ActionBarDrawerToggle(Activity paramActivity, Toolbar paramToolbar, DrawerLayout paramDrawerLayout, DrawerArrowDrawable paramDrawerArrowDrawable, int paramInt1, int paramInt2) {
    if (paramToolbar != null) {
      this.c = new ToolbarCompatDelegate(paramToolbar);
      paramToolbar.setNavigationOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (this.a.a) {
                this.a.a();
                return;
              } 
              if (this.a.b != null)
                this.a.b.onClick(param1View); 
            }
          });
    } else if (paramActivity instanceof DelegateProvider) {
      this.c = ((DelegateProvider)paramActivity).getDrawerToggleDelegate();
    } else {
      this.c = new FrameworkActionBarDelegate(paramActivity);
    } 
    this.d = paramDrawerLayout;
    this.i = paramInt1;
    this.j = paramInt2;
    if (paramDrawerArrowDrawable == null) {
      this.e = new DrawerArrowDrawable(this.c.getActionBarThemedContext());
    } else {
      this.e = paramDrawerArrowDrawable;
    } 
    this.g = b();
  }
  
  public ActionBarDrawerToggle(Activity paramActivity, DrawerLayout paramDrawerLayout, int paramInt1, int paramInt2) {
    this(paramActivity, null, paramDrawerLayout, null, paramInt1, paramInt2);
  }
  
  public ActionBarDrawerToggle(Activity paramActivity, DrawerLayout paramDrawerLayout, Toolbar paramToolbar, int paramInt1, int paramInt2) {
    this(paramActivity, paramToolbar, paramDrawerLayout, null, paramInt1, paramInt2);
  }
  
  private void a(float paramFloat) {
    if (paramFloat == 1.0F) {
      this.e.setVerticalMirror(true);
    } else if (paramFloat == 0.0F) {
      this.e.setVerticalMirror(false);
    } 
    this.e.setProgress(paramFloat);
  }
  
  void a() {
    int i = this.d.getDrawerLockMode(8388611);
    if (this.d.isDrawerVisible(8388611) && i != 2) {
      this.d.closeDrawer(8388611);
      return;
    } 
    if (i != 1)
      this.d.openDrawer(8388611); 
  }
  
  void a(int paramInt) {
    this.c.setActionBarDescription(paramInt);
  }
  
  void a(Drawable paramDrawable, int paramInt) {
    if (!this.k && !this.c.isNavigationVisible()) {
      Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
      this.k = true;
    } 
    this.c.setActionBarUpIndicator(paramDrawable, paramInt);
  }
  
  Drawable b() {
    return this.c.getThemeUpIndicator();
  }
  
  public DrawerArrowDrawable getDrawerArrowDrawable() {
    return this.e;
  }
  
  public View.OnClickListener getToolbarNavigationClickListener() {
    return this.b;
  }
  
  public boolean isDrawerIndicatorEnabled() {
    return this.a;
  }
  
  public boolean isDrawerSlideAnimationEnabled() {
    return this.f;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    if (!this.h)
      this.g = b(); 
    syncState();
  }
  
  public void onDrawerClosed(View paramView) {
    a(0.0F);
    if (this.a)
      a(this.i); 
  }
  
  public void onDrawerOpened(View paramView) {
    a(1.0F);
    if (this.a)
      a(this.j); 
  }
  
  public void onDrawerSlide(View paramView, float paramFloat) {
    if (this.f) {
      a(Math.min(1.0F, Math.max(0.0F, paramFloat)));
      return;
    } 
    a(0.0F);
  }
  
  public void onDrawerStateChanged(int paramInt) {}
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
    if (paramMenuItem != null && paramMenuItem.getItemId() == 16908332 && this.a) {
      a();
      return true;
    } 
    return false;
  }
  
  public void setDrawerArrowDrawable(DrawerArrowDrawable paramDrawerArrowDrawable) {
    this.e = paramDrawerArrowDrawable;
    syncState();
  }
  
  public void setDrawerIndicatorEnabled(boolean paramBoolean) {
    if (paramBoolean != this.a) {
      if (paramBoolean) {
        int i;
        DrawerArrowDrawable drawerArrowDrawable = this.e;
        if (this.d.isDrawerOpen(8388611)) {
          i = this.j;
        } else {
          i = this.i;
        } 
        a((Drawable)drawerArrowDrawable, i);
      } else {
        a(this.g, 0);
      } 
      this.a = paramBoolean;
    } 
  }
  
  public void setDrawerSlideAnimationEnabled(boolean paramBoolean) {
    this.f = paramBoolean;
    if (!paramBoolean)
      a(0.0F); 
  }
  
  public void setHomeAsUpIndicator(int paramInt) {
    Drawable drawable;
    if (paramInt != 0) {
      drawable = this.d.getResources().getDrawable(paramInt);
    } else {
      drawable = null;
    } 
    setHomeAsUpIndicator(drawable);
  }
  
  public void setHomeAsUpIndicator(Drawable paramDrawable) {
    if (paramDrawable == null) {
      this.g = b();
      this.h = false;
    } else {
      this.g = paramDrawable;
      this.h = true;
    } 
    if (!this.a)
      a(this.g, 0); 
  }
  
  public void setToolbarNavigationClickListener(View.OnClickListener paramOnClickListener) {
    this.b = paramOnClickListener;
  }
  
  public void syncState() {
    if (this.d.isDrawerOpen(8388611)) {
      a(1.0F);
    } else {
      a(0.0F);
    } 
    if (this.a) {
      int i;
      DrawerArrowDrawable drawerArrowDrawable = this.e;
      if (this.d.isDrawerOpen(8388611)) {
        i = this.j;
      } else {
        i = this.i;
      } 
      a((Drawable)drawerArrowDrawable, i);
    } 
  }
  
  public static interface Delegate {
    Context getActionBarThemedContext();
    
    Drawable getThemeUpIndicator();
    
    boolean isNavigationVisible();
    
    void setActionBarDescription(int param1Int);
    
    void setActionBarUpIndicator(Drawable param1Drawable, int param1Int);
  }
  
  public static interface DelegateProvider {
    ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();
  }
  
  static class FrameworkActionBarDelegate implements Delegate {
    private final Activity a;
    
    private ActionBarDrawerToggleHoneycomb.SetIndicatorInfo b;
    
    FrameworkActionBarDelegate(Activity param1Activity) {
      this.a = param1Activity;
    }
    
    public Context getActionBarThemedContext() {
      ActionBar actionBar = this.a.getActionBar();
      return (Context)((actionBar != null) ? actionBar.getThemedContext() : this.a);
    }
    
    public Drawable getThemeUpIndicator() {
      if (Build.VERSION.SDK_INT >= 18) {
        TypedArray typedArray = getActionBarThemedContext().obtainStyledAttributes(null, new int[] { 16843531 }, 16843470, 0);
        Drawable drawable = typedArray.getDrawable(0);
        typedArray.recycle();
        return drawable;
      } 
      return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(this.a);
    }
    
    public boolean isNavigationVisible() {
      ActionBar actionBar = this.a.getActionBar();
      return (actionBar != null && (actionBar.getDisplayOptions() & 0x4) != 0);
    }
    
    public void setActionBarDescription(int param1Int) {
      if (Build.VERSION.SDK_INT >= 18) {
        ActionBar actionBar = this.a.getActionBar();
        if (actionBar != null) {
          actionBar.setHomeActionContentDescription(param1Int);
          return;
        } 
      } else {
        this.b = ActionBarDrawerToggleHoneycomb.setActionBarDescription(this.b, this.a, param1Int);
      } 
    }
    
    public void setActionBarUpIndicator(Drawable param1Drawable, int param1Int) {
      ActionBar actionBar = this.a.getActionBar();
      if (actionBar != null) {
        if (Build.VERSION.SDK_INT >= 18) {
          actionBar.setHomeAsUpIndicator(param1Drawable);
          actionBar.setHomeActionContentDescription(param1Int);
          return;
        } 
        actionBar.setDisplayShowHomeEnabled(true);
        this.b = ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(this.a, param1Drawable, param1Int);
        actionBar.setDisplayShowHomeEnabled(false);
      } 
    }
  }
  
  static class ToolbarCompatDelegate implements Delegate {
    final Toolbar a;
    
    final Drawable b;
    
    final CharSequence c;
    
    ToolbarCompatDelegate(Toolbar param1Toolbar) {
      this.a = param1Toolbar;
      this.b = param1Toolbar.getNavigationIcon();
      this.c = param1Toolbar.getNavigationContentDescription();
    }
    
    public Context getActionBarThemedContext() {
      return this.a.getContext();
    }
    
    public Drawable getThemeUpIndicator() {
      return this.b;
    }
    
    public boolean isNavigationVisible() {
      return true;
    }
    
    public void setActionBarDescription(int param1Int) {
      if (param1Int == 0) {
        this.a.setNavigationContentDescription(this.c);
        return;
      } 
      this.a.setNavigationContentDescription(param1Int);
    }
    
    public void setActionBarUpIndicator(Drawable param1Drawable, int param1Int) {
      this.a.setNavigationIcon(param1Drawable);
      setActionBarDescription(param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\app\ActionBarDrawerToggle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */