package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;
import java.net.URL;

public class UrlLoader implements ModelLoader<URL, InputStream> {
  private final ModelLoader<GlideUrl, InputStream> a;
  
  public UrlLoader(ModelLoader<GlideUrl, InputStream> paramModelLoader) {
    this.a = paramModelLoader;
  }
  
  public ModelLoader.LoadData<InputStream> a(URL paramURL, int paramInt1, int paramInt2, Options paramOptions) {
    return this.a.a(new GlideUrl(paramURL), paramInt1, paramInt2, paramOptions);
  }
  
  public boolean a(URL paramURL) {
    return true;
  }
  
  public static class StreamFactory implements ModelLoaderFactory<URL, InputStream> {
    public ModelLoader<URL, InputStream> a(MultiModelLoaderFactory param1MultiModelLoaderFactory) {
      return new UrlLoader(param1MultiModelLoaderFactory.b(GlideUrl.class, InputStream.class));
    }
    
    public void a() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\model\stream\UrlLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */