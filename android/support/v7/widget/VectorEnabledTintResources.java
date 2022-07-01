package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatDelegate;
import java.lang.ref.WeakReference;

public final class VectorEnabledTintResources extends Resources {
  private final WeakReference mContextRef;
  
  public VectorEnabledTintResources(Context paramContext, Resources paramResources) {
    super(paramResources.getAssets(), paramResources.getDisplayMetrics(), paramResources.getConfiguration());
    this.mContextRef = new WeakReference<Context>(paramContext);
  }
  
  public static boolean shouldBeUsed() {
    return (AppCompatDelegate.isCompatVectorFromResourcesEnabled() && Build.VERSION.SDK_INT <= 20);
  }
  
  public final Drawable getDrawable(int paramInt) {
    Context context = this.mContextRef.get();
    if (context != null) {
      AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
      Drawable drawable2 = appCompatDrawableManager.loadDrawableFromDelegates(context, paramInt);
      Drawable drawable1 = drawable2;
      if (drawable2 == null)
        drawable1 = super.getDrawable(paramInt); 
      return (drawable1 != null) ? appCompatDrawableManager.tintDrawable(context, paramInt, false, drawable1) : null;
    } 
    return super.getDrawable(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\VectorEnabledTintResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */