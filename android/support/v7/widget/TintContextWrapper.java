package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class TintContextWrapper extends ContextWrapper {
  private static final Object CACHE_LOCK = new Object();
  
  private static ArrayList sCache;
  
  private final Resources mResources;
  
  private final Resources.Theme mTheme;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private TintContextWrapper(Context paramContext) {
    super(paramContext);
    if (VectorEnabledTintResources.shouldBeUsed()) {
      this.mResources = new VectorEnabledTintResources((Context)this, paramContext.getResources());
      this.mTheme = this.mResources.newTheme();
      this.mTheme.setTo(paramContext.getTheme());
      return;
    } 
    this.mResources = new TintResources((Context)this, paramContext.getResources());
    this.mTheme = null;
  }
  
  public static Context wrap(Context paramContext) {
    boolean bool = paramContext instanceof TintContextWrapper;
    int i = 0;
    if (!bool && !(paramContext.getResources() instanceof TintResources) && !(paramContext.getResources() instanceof VectorEnabledTintResources) && (Build.VERSION.SDK_INT < 21 || VectorEnabledTintResources.shouldBeUsed()))
      i = 1; 
    if (i)
      synchronized (CACHE_LOCK) {
        if (sCache == null) {
          sCache = new ArrayList();
        } else {
          for (i = sCache.size() - 1;; i--) {
            if (i >= 0) {
              WeakReference weakReference = sCache.get(i);
              if (weakReference == null || weakReference.get() == null)
                sCache.remove(i); 
            } else {
              for (i = sCache.size() - 1;; i--) {
                if (i >= 0) {
                  WeakReference<TintContextWrapper> weakReference = sCache.get(i);
                  if (weakReference != null) {
                    TintContextWrapper tintContextWrapper1 = weakReference.get();
                  } else {
                    weakReference = null;
                  } 
                  if (weakReference != null && weakReference.getBaseContext() == paramContext)
                    return (Context)weakReference; 
                } else {
                  tintContextWrapper = new TintContextWrapper(paramContext);
                  sCache.add(new WeakReference<TintContextWrapper>(tintContextWrapper));
                  return (Context)tintContextWrapper;
                } 
              } 
            } 
          } 
          i--;
        } 
        TintContextWrapper tintContextWrapper = new TintContextWrapper((Context)tintContextWrapper);
        sCache.add(new WeakReference<TintContextWrapper>(tintContextWrapper));
        return (Context)tintContextWrapper;
      }  
    return paramContext;
  }
  
  public final AssetManager getAssets() {
    return this.mResources.getAssets();
  }
  
  public final Resources getResources() {
    return this.mResources;
  }
  
  public final Resources.Theme getTheme() {
    return (this.mTheme == null) ? super.getTheme() : this.mTheme;
  }
  
  public final void setTheme(int paramInt) {
    if (this.mTheme == null) {
      super.setTheme(paramInt);
      return;
    } 
    this.mTheme.applyStyle(paramInt, true);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\TintContextWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */