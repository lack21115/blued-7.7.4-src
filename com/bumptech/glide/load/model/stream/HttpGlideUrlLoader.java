package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.HttpUrlFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;

public class HttpGlideUrlLoader implements ModelLoader<GlideUrl, InputStream> {
  public static final Option<Integer> a = Option.a("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", Integer.valueOf(2500));
  
  private final ModelCache<GlideUrl, GlideUrl> b;
  
  public HttpGlideUrlLoader() {
    this(null);
  }
  
  public HttpGlideUrlLoader(ModelCache<GlideUrl, GlideUrl> paramModelCache) {
    this.b = paramModelCache;
  }
  
  public ModelLoader.LoadData<InputStream> a(GlideUrl paramGlideUrl, int paramInt1, int paramInt2, Options paramOptions) {
    ModelCache<GlideUrl, GlideUrl> modelCache = this.b;
    GlideUrl glideUrl = paramGlideUrl;
    if (modelCache != null) {
      glideUrl = (GlideUrl)modelCache.a(paramGlideUrl, 0, 0);
      if (glideUrl == null) {
        this.b.a(paramGlideUrl, 0, 0, paramGlideUrl);
        glideUrl = paramGlideUrl;
      } 
    } 
    return new ModelLoader.LoadData((Key)glideUrl, (DataFetcher)new HttpUrlFetcher(glideUrl, ((Integer)paramOptions.a(a)).intValue()));
  }
  
  public boolean a(GlideUrl paramGlideUrl) {
    return true;
  }
  
  public static class Factory implements ModelLoaderFactory<GlideUrl, InputStream> {
    private final ModelCache<GlideUrl, GlideUrl> a = new ModelCache(500L);
    
    public ModelLoader<GlideUrl, InputStream> a(MultiModelLoaderFactory param1MultiModelLoaderFactory) {
      return new HttpGlideUrlLoader(this.a);
    }
    
    public void a() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\model\stream\HttpGlideUrlLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */