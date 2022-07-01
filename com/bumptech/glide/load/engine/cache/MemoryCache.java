package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;

public interface MemoryCache {
  long a();
  
  Resource<?> a(Key paramKey);
  
  void a(int paramInt);
  
  void a(ResourceRemovedListener paramResourceRemovedListener);
  
  long b();
  
  Resource<?> b(Key paramKey, Resource<?> paramResource);
  
  void c();
  
  public static interface ResourceRemovedListener {
    void b(Resource<?> param1Resource);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\cache\MemoryCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */