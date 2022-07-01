package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class TintContextWrapper extends ContextWrapper {
  private static final Object a = new Object();
  
  private static ArrayList<WeakReference<TintContextWrapper>> b;
  
  private final Resources c;
  
  private final Resources.Theme d;
  
  private TintContextWrapper(Context paramContext) {
    super(paramContext);
    if (VectorEnabledTintResources.shouldBeUsed()) {
      this.c = new VectorEnabledTintResources((Context)this, paramContext.getResources());
      this.d = this.c.newTheme();
      this.d.setTo(paramContext.getTheme());
      return;
    } 
    this.c = new TintResources((Context)this, paramContext.getResources());
    this.d = null;
  }
  
  private static boolean a(Context paramContext) {
    boolean bool1 = paramContext instanceof TintContextWrapper;
    boolean bool = false;
    null = bool;
    if (!bool1) {
      null = bool;
      if (!(paramContext.getResources() instanceof TintResources)) {
        if (paramContext.getResources() instanceof VectorEnabledTintResources)
          return false; 
        if (Build.VERSION.SDK_INT >= 21) {
          null = bool;
          return VectorEnabledTintResources.shouldBeUsed() ? true : null;
        } 
      } else {
        return null;
      } 
    } else {
      return null;
    } 
    return true;
  }
  
  public static Context wrap(Context paramContext) {
    if (a(paramContext))
      synchronized (a) {
        if (b == null) {
          b = new ArrayList<WeakReference<TintContextWrapper>>();
        } else {
          for (int i = b.size() - 1;; i--) {
            if (i >= 0) {
              WeakReference weakReference = b.get(i);
              if (weakReference == null || weakReference.get() == null)
                b.remove(i); 
            } else {
              for (i = b.size() - 1;; i--) {
                if (i >= 0) {
                  WeakReference<TintContextWrapper> weakReference = b.get(i);
                  if (weakReference != null) {
                    TintContextWrapper tintContextWrapper1 = weakReference.get();
                  } else {
                    weakReference = null;
                  } 
                  if (weakReference != null && weakReference.getBaseContext() == paramContext)
                    return (Context)weakReference; 
                } else {
                  tintContextWrapper = new TintContextWrapper(paramContext);
                  b.add(new WeakReference<TintContextWrapper>(tintContextWrapper));
                  return (Context)tintContextWrapper;
                } 
              } 
            } 
          } 
          i--;
        } 
        TintContextWrapper tintContextWrapper = new TintContextWrapper((Context)tintContextWrapper);
        b.add(new WeakReference<TintContextWrapper>(tintContextWrapper));
        return (Context)tintContextWrapper;
      }  
    return paramContext;
  }
  
  public AssetManager getAssets() {
    return this.c.getAssets();
  }
  
  public Resources getResources() {
    return this.c;
  }
  
  public Resources.Theme getTheme() {
    Resources.Theme theme2 = this.d;
    Resources.Theme theme1 = theme2;
    if (theme2 == null)
      theme1 = super.getTheme(); 
    return theme1;
  }
  
  public void setTheme(int paramInt) {
    Resources.Theme theme = this.d;
    if (theme == null) {
      super.setTheme(paramInt);
      return;
    } 
    theme.applyStyle(paramInt, true);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\TintContextWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */