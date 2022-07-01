package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.appcompat.R;

public class ContextThemeWrapper extends ContextWrapper {
  private int a;
  
  private Resources.Theme b;
  
  private LayoutInflater c;
  
  private Configuration d;
  
  private Resources e;
  
  public ContextThemeWrapper() {
    super(null);
  }
  
  public ContextThemeWrapper(Context paramContext, int paramInt) {
    super(paramContext);
    this.a = paramInt;
  }
  
  public ContextThemeWrapper(Context paramContext, Resources.Theme paramTheme) {
    super(paramContext);
    this.b = paramTheme;
  }
  
  private Resources a() {
    if (this.e == null)
      if (this.d == null) {
        this.e = super.getResources();
      } else if (Build.VERSION.SDK_INT >= 17) {
        this.e = createConfigurationContext(this.d).getResources();
      }  
    return this.e;
  }
  
  private void b() {
    boolean bool;
    if (this.b == null) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      this.b = getResources().newTheme();
      Resources.Theme theme = getBaseContext().getTheme();
      if (theme != null)
        this.b.setTo(theme); 
    } 
    a(this.b, this.a, bool);
  }
  
  protected void a(Resources.Theme paramTheme, int paramInt, boolean paramBoolean) {
    paramTheme.applyStyle(paramInt, true);
  }
  
  public void applyOverrideConfiguration(Configuration paramConfiguration) {
    if (this.e == null) {
      if (this.d == null) {
        this.d = new Configuration(paramConfiguration);
        return;
      } 
      throw new IllegalStateException("Override configuration has already been set");
    } 
    throw new IllegalStateException("getResources() or getAssets() has already been called");
  }
  
  protected void attachBaseContext(Context paramContext) {
    super.attachBaseContext(paramContext);
  }
  
  public AssetManager getAssets() {
    return getResources().getAssets();
  }
  
  public Resources getResources() {
    return a();
  }
  
  public Object getSystemService(String paramString) {
    if ("layout_inflater".equals(paramString)) {
      if (this.c == null)
        this.c = LayoutInflater.from(getBaseContext()).cloneInContext((Context)this); 
      return this.c;
    } 
    return getBaseContext().getSystemService(paramString);
  }
  
  public Resources.Theme getTheme() {
    Resources.Theme theme = this.b;
    if (theme != null)
      return theme; 
    if (this.a == 0)
      this.a = R.style.Theme_AppCompat_Light; 
    b();
    return this.b;
  }
  
  public int getThemeResId() {
    return this.a;
  }
  
  public void setTheme(int paramInt) {
    if (this.a != paramInt) {
      this.a = paramInt;
      b();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\view\ContextThemeWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */