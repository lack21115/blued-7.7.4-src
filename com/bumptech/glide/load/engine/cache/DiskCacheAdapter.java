package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import java.io.File;

public class DiskCacheAdapter implements DiskCache {
  public File a(Key paramKey) {
    return null;
  }
  
  public void a() {}
  
  public void a(Key paramKey, DiskCache.Writer paramWriter) {}
  
  public static final class Factory implements DiskCache.Factory {
    public DiskCache a() {
      return new DiskCacheAdapter();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\cache\DiskCacheAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */