package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import java.io.File;

public interface DiskCache {
  File a(Key paramKey);
  
  void a();
  
  void a(Key paramKey, Writer paramWriter);
  
  public static interface Factory {
    DiskCache a();
  }
  
  public static interface Writer {
    boolean a(File param1File);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\cache\DiskCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */