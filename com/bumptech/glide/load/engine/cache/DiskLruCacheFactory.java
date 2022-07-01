package com.bumptech.glide.load.engine.cache;

import java.io.File;

public class DiskLruCacheFactory implements DiskCache.Factory {
  private final long a;
  
  private final CacheDirectoryGetter b;
  
  public DiskLruCacheFactory(CacheDirectoryGetter paramCacheDirectoryGetter, long paramLong) {
    this.a = paramLong;
    this.b = paramCacheDirectoryGetter;
  }
  
  public DiskLruCacheFactory(String paramString, long paramLong) {
    this(new CacheDirectoryGetter(paramString) {
          public File a() {
            return new File(this.a);
          }
        },  paramLong);
  }
  
  public DiskCache a() {
    File file = this.b.a();
    return (file == null) ? null : ((!file.mkdirs() && (!file.exists() || !file.isDirectory())) ? null : DiskLruCacheWrapper.a(file, this.a));
  }
  
  public static interface CacheDirectoryGetter {
    File a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\cache\DiskLruCacheFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */