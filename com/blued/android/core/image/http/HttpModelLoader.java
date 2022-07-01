package com.blued.android.core.image.http;

import android.text.TextUtils;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageLoaderOptions;
import com.blued.android.core.image.util.FileUtils;
import com.blued.android.core.utils.Log;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.File;
import java.io.InputStream;

public class HttpModelLoader implements ModelLoader<GlideUrl, InputStream> {
  public ModelLoader.LoadData<InputStream> a(GlideUrl paramGlideUrl, int paramInt1, int paramInt2, Options paramOptions) {
    StringBuilder stringBuilder;
    String str2 = paramGlideUrl.b();
    if (ImageLoader.a()) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("-- buildLoadData : ");
      stringBuilder1.append(str2);
      Log.e("IMAGE", stringBuilder1.toString());
    } 
    File file = FileUtils.a(str2);
    if (file != null) {
      if (ImageLoader.a()) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("-- buildLoadData 0: ");
        stringBuilder.append(file.getPath());
        Log.e("IMAGE", stringBuilder.toString());
      } 
      return new ModelLoader.LoadData((Key)paramGlideUrl, new PrevCacheFileDataFetcher(file));
    } 
    String str1 = (String)stringBuilder.a(ImageLoaderOptions.a);
    if (ImageLoader.a()) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("-- buildLoadData 1: ");
      stringBuilder1.append(str1);
      Log.e("IMAGE", stringBuilder1.toString());
    } 
    return !TextUtils.isEmpty(str1) ? new ModelLoader.LoadData((Key)paramGlideUrl, new FileDataFetcher(str1)) : new ModelLoader.LoadData((Key)paramGlideUrl, new HttpDataFetcher(paramGlideUrl));
  }
  
  public boolean a(GlideUrl paramGlideUrl) {
    return true;
  }
  
  public static class Factory implements ModelLoaderFactory<GlideUrl, InputStream> {
    public ModelLoader<GlideUrl, InputStream> a(MultiModelLoaderFactory param1MultiModelLoaderFactory) {
      if (ImageLoader.a())
        Log.e("IMAGE", "-- new HttpModelLoader "); 
      return new HttpModelLoader();
    }
    
    public void a() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\http\HttpModelLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */