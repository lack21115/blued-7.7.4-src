package androidx.legacy.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import java.lang.reflect.Method;

@Deprecated
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {
  private static final int[] b = new int[] { 16843531 };
  
  final Activity a;
  
  private final Delegate c;
  
  private final DrawerLayout d;
  
  private boolean e;
  
  private boolean f;
  
  private Drawable g;
  
  private Drawable h;
  
  private SlideDrawable i;
  
  private final int j;
  
  private final int k;
  
  private final int l;
  
  private SetIndicatorInfo m;
  
  public ActionBarDrawerToggle(Activity paramActivity, DrawerLayout paramDrawerLayout, int paramInt1, int paramInt2, int paramInt3) {
    this(paramActivity, paramDrawerLayout, a((Context)paramActivity) ^ true, paramInt1, paramInt2, paramInt3);
  }
  
  public ActionBarDrawerToggle(Activity paramActivity, DrawerLayout paramDrawerLayout, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3) {
    float f;
    this.e = true;
    this.a = paramActivity;
    if (paramActivity instanceof DelegateProvider) {
      this.c = ((DelegateProvider)paramActivity).getDrawerToggleDelegate();
    } else {
      this.c = null;
    } 
    this.d = paramDrawerLayout;
    this.j = paramInt1;
    this.k = paramInt2;
    this.l = paramInt3;
    this.g = a();
    this.h = ContextCompat.getDrawable((Context)paramActivity, paramInt1);
    this.i = new SlideDrawable(this, this.h);
    SlideDrawable slideDrawable = this.i;
    if (paramBoolean) {
      f = 0.33333334F;
    } else {
      f = 0.0F;
    } 
    slideDrawable.setOffset(f);
  }
  
  private Drawable a() {
    Delegate delegate = this.c;
    if (delegate != null)
      return delegate.getThemeUpIndicator(); 
    if (Build.VERSION.SDK_INT >= 18) {
      Activity activity;
      ActionBar actionBar = this.a.getActionBar();
      if (actionBar != null) {
        Context context = actionBar.getThemedContext();
      } else {
        activity = this.a;
      } 
      TypedArray typedArray1 = activity.obtainStyledAttributes(null, b, 16843470, 0);
      Drawable drawable1 = typedArray1.getDrawable(0);
      typedArray1.recycle();
      return drawable1;
    } 
    TypedArray typedArray = this.a.obtainStyledAttributes(b);
    Drawable drawable = typedArray.getDrawable(0);
    typedArray.recycle();
    return drawable;
  }
  
  private void a(int paramInt) {
    Delegate delegate = this.c;
    if (delegate != null) {
      delegate.setActionBarDescription(paramInt);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 18) {
      ActionBar actionBar = this.a.getActionBar();
      if (actionBar != null) {
        actionBar.setHomeActionContentDescription(paramInt);
        return;
      } 
    } else {
      if (this.m == null)
        this.m = new SetIndicatorInfo(this.a); 
      if (this.m.a != null)
        try {
          ActionBar actionBar = this.a.getActionBar();
          this.m.b.invoke(actionBar, new Object[] { Integer.valueOf(paramInt) });
          actionBar.setSubtitle(actionBar.getSubtitle());
          return;
        } catch (Exception exception) {
          Log.w("ActionBarDrawerToggle", "Couldn't set content description via JB-MR2 API", exception);
        }  
    } 
  }
  
  private void a(Drawable paramDrawable, int paramInt) {
    Delegate delegate = this.c;
    if (delegate != null) {
      delegate.setActionBarUpIndicator(paramDrawable, paramInt);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 18) {
      ActionBar actionBar = this.a.getActionBar();
      if (actionBar != null) {
        actionBar.setHomeAsUpIndicator(paramDrawable);
        actionBar.setHomeActionContentDescription(paramInt);
        return;
      } 
    } else {
      if (this.m == null)
        this.m = new SetIndicatorInfo(this.a); 
      if (this.m.a != null)
        try {
          ActionBar actionBar = this.a.getActionBar();
          this.m.a.invoke(actionBar, new Object[] { paramDrawable });
          this.m.b.invoke(actionBar, new Object[] { Integer.valueOf(paramInt) });
          return;
        } catch (Exception exception) {
          Log.w("ActionBarDrawerToggle", "Couldn't set home-as-up indicator via JB-MR2 API", exception);
          return;
        }  
      if (this.m.c != null) {
        this.m.c.setImageDrawable((Drawable)exception);
        return;
      } 
      Log.w("ActionBarDrawerToggle", "Couldn't set home-as-up indicator");
    } 
  }
  
  private static boolean a(Context paramContext) {
    return ((paramContext.getApplicationInfo()).targetSdkVersion >= 21 && Build.VERSION.SDK_INT >= 21);
  }
  
  public boolean isDrawerIndicatorEnabled() {
    return this.e;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    if (!this.f)
      this.g = a(); 
    this.h = ContextCompat.getDrawable((Context)this.a, this.j);
    syncState();
  }
  
  public void onDrawerClosed(View paramView) {
    this.i.setPosition(0.0F);
    if (this.e)
      a(this.k); 
  }
  
  public void onDrawerOpened(View paramView) {
    this.i.setPosition(1.0F);
    if (this.e)
      a(this.l); 
  }
  
  public void onDrawerSlide(View paramView, float paramFloat) {
    float f = this.i.getPosition();
    if (paramFloat > 0.5F) {
      paramFloat = Math.max(f, Math.max(0.0F, paramFloat - 0.5F) * 2.0F);
    } else {
      paramFloat = Math.min(f, paramFloat * 2.0F);
    } 
    this.i.setPosition(paramFloat);
  }
  
  public void onDrawerStateChanged(int paramInt) {}
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
    if (paramMenuItem != null && paramMenuItem.getItemId() == 16908332 && this.e) {
      if (this.d.isDrawerVisible(8388611)) {
        this.d.closeDrawer(8388611);
      } else {
        this.d.openDrawer(8388611);
      } 
      return true;
    } 
    return false;
  }
  
  public void setDrawerIndicatorEnabled(boolean paramBoolean) {
    if (paramBoolean != this.e) {
      if (paramBoolean) {
        int i;
        SlideDrawable slideDrawable = this.i;
        if (this.d.isDrawerOpen(8388611)) {
          i = this.l;
        } else {
          i = this.k;
        } 
        a((Drawable)slideDrawable, i);
      } else {
        a(this.g, 0);
      } 
      this.e = paramBoolean;
    } 
  }
  
  public void setHomeAsUpIndicator(int paramInt) {
    Drawable drawable;
    if (paramInt != 0) {
      drawable = ContextCompat.getDrawable((Context)this.a, paramInt);
    } else {
      drawable = null;
    } 
    setHomeAsUpIndicator(drawable);
  }
  
  public void setHomeAsUpIndicator(Drawable paramDrawable) {
    if (paramDrawable == null) {
      this.g = a();
      this.f = false;
    } else {
      this.g = paramDrawable;
      this.f = true;
    } 
    if (!this.e)
      a(this.g, 0); 
  }
  
  public void syncState() {
    if (this.d.isDrawerOpen(8388611)) {
      this.i.setPosition(1.0F);
    } else {
      this.i.setPosition(0.0F);
    } 
    if (this.e) {
      int i;
      SlideDrawable slideDrawable = this.i;
      if (this.d.isDrawerOpen(8388611)) {
        i = this.l;
      } else {
        i = this.k;
      } 
      a((Drawable)slideDrawable, i);
    } 
  }
  
  @Deprecated
  public static interface Delegate {
    Drawable getThemeUpIndicator();
    
    void setActionBarDescription(int param1Int);
    
    void setActionBarUpIndicator(Drawable param1Drawable, int param1Int);
  }
  
  @Deprecated
  public static interface DelegateProvider {
    ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();
  }
  
  static class SetIndicatorInfo {
    Method a;
    
    Method b;
    
    ImageView c;
    
    SetIndicatorInfo(Activity param1Activity) {
      try {
        this.a = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[] { Drawable.class });
        this.b = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[] { int.class });
        return;
      } catch (NoSuchMethodException noSuchMethodException) {
        View view1 = param1Activity.findViewById(16908332);
        if (view1 == null)
          return; 
        ViewGroup viewGroup = (ViewGroup)view1.getParent();
        if (viewGroup.getChildCount() != 2)
          return; 
        view1 = viewGroup.getChildAt(0);
        View view2 = viewGroup.getChildAt(1);
        if (view1.getId() == 16908332)
          view1 = view2; 
        if (view1 instanceof ImageView)
          this.c = (ImageView)view1; 
        return;
      } 
    }
  }
  
  class SlideDrawable extends InsetDrawable implements Drawable.Callback {
    private final boolean b;
    
    private final Rect c;
    
    private float d;
    
    private float e;
    
    SlideDrawable(ActionBarDrawerToggle this$0, Drawable param1Drawable) {
      super(param1Drawable, 0);
      if (Build.VERSION.SDK_INT > 18)
        bool = true; 
      this.b = bool;
      this.c = new Rect();
    }
    
    public void draw(Canvas param1Canvas) {
      copyBounds(this.c);
      param1Canvas.save();
      int i = ViewCompat.getLayoutDirection(this.a.a.getWindow().getDecorView());
      byte b = 1;
      if (i == 1) {
        i = 1;
      } else {
        i = 0;
      } 
      if (i != 0)
        b = -1; 
      int j = this.c.width();
      float f1 = -this.e;
      float f2 = j;
      param1Canvas.translate(f1 * f2 * this.d * b, 0.0F);
      if (i != 0 && !this.b) {
        param1Canvas.translate(f2, 0.0F);
        param1Canvas.scale(-1.0F, 1.0F);
      } 
      super.draw(param1Canvas);
      param1Canvas.restore();
    }
    
    public float getPosition() {
      return this.d;
    }
    
    public void setOffset(float param1Float) {
      this.e = param1Float;
      invalidateSelf();
    }
    
    public void setPosition(float param1Float) {
      this.d = param1Float;
      invalidateSelf();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\legacy\app\ActionBarDrawerToggle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */