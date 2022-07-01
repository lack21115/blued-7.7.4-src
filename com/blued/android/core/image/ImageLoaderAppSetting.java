package com.blued.android.core.image;

import android.content.Context;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.util.FileUtils;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.utils.Log;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.module.AppGlideModule;

public class ImageLoaderAppSetting extends AppGlideModule {
  public void a(Context paramContext, GlideBuilder paramGlideBuilder) {
    byte b;
    if (ImageLoader.a())
      Log.e("IMAGE", "ImageLoaderAppSetting -- applyDefaultOptions"); 
    long l = RecyclingUtils.a(AppInfo.t);
    paramGlideBuilder.a((MemoryCache)new LruResourceCache(2L * l / 5L));
    paramGlideBuilder.a((BitmapPool)new LruBitmapPool(l * 3L / 5L));
    paramGlideBuilder.a((DiskCache.Factory)new DiskLruCacheFactory(FileUtils.a(paramContext), AppInfo.u));
    if (AppInfo.m()) {
      b = 2;
    } else {
      b = 6;
    } 
    paramGlideBuilder.a(b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\ImageLoaderAppSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */