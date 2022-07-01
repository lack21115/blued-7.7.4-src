package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

class TintResources extends ResourcesWrapper {
  private final WeakReference<Context> a;
  
  public TintResources(Context paramContext, Resources paramResources) {
    super(paramResources);
    this.a = new WeakReference<Context>(paramContext);
  }
  
  public Drawable getDrawable(int paramInt) throws Resources.NotFoundException {
    Drawable drawable = super.getDrawable(paramInt);
    Context context = this.a.get();
    if (drawable != null && context != null)
      ResourceManagerInternal.get().a(context, paramInt, drawable); 
    return drawable;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\TintResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */