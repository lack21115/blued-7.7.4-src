package com.blued.android.core.image;

import com.bumptech.glide.load.Option;

public class ImageLoaderOptions {
  public static final Option<String> a = Option.a("com.blued.android.core.image.IMAGE_LOADER_LOCAL_PATH");
  
  public static final Option<Boolean> b = Option.a("com.blued.android.core.image.IMAGE_LOADER_FROMAT_APNG", Boolean.valueOf(false));
  
  public static final Option<Integer> c = Option.a("com.blued.android.core.image.IMAGE_LOADER_CACHE_CODE", Integer.valueOf(0));
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\ImageLoaderOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */