package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import java.io.File;

public final class InternalCacheDiskCacheFactory extends DiskLruCacheFactory {
  public InternalCacheDiskCacheFactory(Context paramContext) {
    this(paramContext, "image_manager_disk_cache", 262144000L);
  }
  
  public InternalCacheDiskCacheFactory(Context paramContext, String paramString, long paramLong) {
    super(new DiskLruCacheFactory.CacheDirectoryGetter(paramContext, paramString) {
          public File a() {
            File file = this.a.getCacheDir();
            if (file == null)
              return null; 
            String str = this.b;
            return (str != null) ? new File(file, str) : file;
          }
        }paramLong);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\cache\InternalCacheDiskCacheFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */