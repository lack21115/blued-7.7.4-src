package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

final class TintResources extends ResourcesWrapper {
  private final WeakReference mContextRef;
  
  public TintResources(Context paramContext, Resources paramResources) {
    super(paramResources);
    this.mContextRef = new WeakReference<Context>(paramContext);
  }
  
  public final Drawable getDrawable(int paramInt) {
    Drawable drawable = super.getDrawable(paramInt);
    Context context = this.mContextRef.get();
    if (drawable != null && context != null) {
      AppCompatDrawableManager.get();
      AppCompatDrawableManager.tintDrawableUsingColorFilter(context, paramInt, drawable);
    } 
    return drawable;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\TintResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */