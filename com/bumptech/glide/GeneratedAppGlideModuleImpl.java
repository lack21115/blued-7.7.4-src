package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import com.blued.android.core.image.ImageLoaderAppSetting;
import com.blued.android.core.image.ImageLoaderLibrarySetting;
import com.bumptech.glide.manager.RequestManagerRetriever;
import java.util.Collections;
import java.util.Set;

final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {
  private final ImageLoaderAppSetting a = new ImageLoaderAppSetting();
  
  public GeneratedAppGlideModuleImpl(Context paramContext) {
    if (Log.isLoggable("Glide", 3)) {
      Log.d("Glide", "Discovered AppGlideModule from annotation: com.blued.android.core.image.ImageLoaderAppSetting");
      Log.d("Glide", "Discovered LibraryGlideModule from annotation: com.blued.android.core.image.ImageLoaderLibrarySetting");
    } 
  }
  
  public Set<Class<?>> a() {
    return Collections.emptySet();
  }
  
  public void a(Context paramContext, Glide paramGlide, Registry paramRegistry) {
    (new ImageLoaderLibrarySetting()).a(paramContext, paramGlide, paramRegistry);
    this.a.a(paramContext, paramGlide, paramRegistry);
  }
  
  public void a(Context paramContext, GlideBuilder paramGlideBuilder) {
    this.a.a(paramContext, paramGlideBuilder);
  }
  
  public boolean c() {
    return this.a.c();
  }
  
  GeneratedRequestManagerFactory d() {
    return new GeneratedRequestManagerFactory();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\GeneratedAppGlideModuleImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */