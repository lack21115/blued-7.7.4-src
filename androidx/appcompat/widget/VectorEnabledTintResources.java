package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

public class VectorEnabledTintResources extends Resources {
  public static final int MAX_SDK_WHERE_REQUIRED = 20;
  
  private static boolean a = false;
  
  private final WeakReference<Context> b;
  
  public VectorEnabledTintResources(Context paramContext, Resources paramResources) {
    super(paramResources.getAssets(), paramResources.getDisplayMetrics(), paramResources.getConfiguration());
    this.b = new WeakReference<Context>(paramContext);
  }
  
  public static boolean isCompatVectorFromResourcesEnabled() {
    return a;
  }
  
  public static void setCompatVectorFromResourcesEnabled(boolean paramBoolean) {
    a = paramBoolean;
  }
  
  public static boolean shouldBeUsed() {
    return (isCompatVectorFromResourcesEnabled() && Build.VERSION.SDK_INT <= 20);
  }
  
  final Drawable a(int paramInt) {
    return super.getDrawable(paramInt);
  }
  
  public Drawable getDrawable(int paramInt) throws Resources.NotFoundException {
    Context context = this.b.get();
    return (context != null) ? ResourceManagerInternal.get().a(context, this, paramInt) : super.getDrawable(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\VectorEnabledTintResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */