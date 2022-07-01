package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.LruCache;

public class LruResourceCache extends LruCache<Key, Resource<?>> implements MemoryCache {
  private MemoryCache.ResourceRemovedListener a;
  
  public LruResourceCache(long paramLong) {
    super(paramLong);
  }
  
  protected int a(Resource<?> paramResource) {
    return (paramResource == null) ? super.a(null) : paramResource.b();
  }
  
  public void a(int paramInt) {
    if (paramInt >= 40) {
      c();
      return;
    } 
    if (paramInt >= 20 || paramInt == 15)
      a(b() / 2L); 
  }
  
  protected void a(Key paramKey, Resource<?> paramResource) {
    MemoryCache.ResourceRemovedListener resourceRemovedListener = this.a;
    if (resourceRemovedListener != null && paramResource != null)
      resourceRemovedListener.b(paramResource); 
  }
  
  public void a(MemoryCache.ResourceRemovedListener paramResourceRemovedListener) {
    this.a = paramResourceRemovedListener;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\cache\LruResourceCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */