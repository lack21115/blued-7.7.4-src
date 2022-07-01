package android.support.v7.widget;

import android.graphics.PorterDuff;
import android.support.v4.util.LruCache;

final class AppCompatDrawableManager$ColorFilterLruCache extends LruCache {
  public AppCompatDrawableManager$ColorFilterLruCache(int paramInt) {
    super(paramInt);
  }
  
  static int generateCacheKey(int paramInt, PorterDuff.Mode paramMode) {
    return (paramInt + 31) * 31 + paramMode.hashCode();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\AppCompatDrawableManager$ColorFilterLruCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */