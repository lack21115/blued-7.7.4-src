package com.bumptech.glide.load.model;

import android.net.Uri;
import com.bumptech.glide.load.Options;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UrlUriLoader<Data> implements ModelLoader<Uri, Data> {
  private static final Set<String> a = Collections.unmodifiableSet(new HashSet<String>(Arrays.asList(new String[] { "http", "https" })));
  
  private final ModelLoader<GlideUrl, Data> b;
  
  public UrlUriLoader(ModelLoader<GlideUrl, Data> paramModelLoader) {
    this.b = paramModelLoader;
  }
  
  public ModelLoader.LoadData<Data> a(Uri paramUri, int paramInt1, int paramInt2, Options paramOptions) {
    GlideUrl glideUrl = new GlideUrl(paramUri.toString());
    return this.b.a(glideUrl, paramInt1, paramInt2, paramOptions);
  }
  
  public boolean a(Uri paramUri) {
    return a.contains(paramUri.getScheme());
  }
  
  public static class StreamFactory implements ModelLoaderFactory<Uri, InputStream> {
    public ModelLoader<Uri, InputStream> a(MultiModelLoaderFactory param1MultiModelLoaderFactory) {
      return new UrlUriLoader<InputStream>(param1MultiModelLoaderFactory.b(GlideUrl.class, InputStream.class));
    }
    
    public void a() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\model\UrlUriLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */