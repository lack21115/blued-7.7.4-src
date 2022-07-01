package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;

public class MemoryCacheAdapter implements MemoryCache {
  private MemoryCache.ResourceRemovedListener a;
  
  public long a() {
    return 0L;
  }
  
  public Resource<?> a(Key paramKey) {
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(MemoryCache.ResourceRemovedListener paramResourceRemovedListener) {
    this.a = paramResourceRemovedListener;
  }
  
  public long b() {
    return 0L;
  }
  
  public Resource<?> b(Key paramKey, Resource<?> paramResource) {
    if (paramResource != null)
      this.a.b(paramResource); 
    return null;
  }
  
  public void c() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\cache\MemoryCacheAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */