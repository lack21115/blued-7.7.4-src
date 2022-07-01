package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.bumptech.glide.load.Options;
import java.io.File;
import java.io.InputStream;

public class StringLoader<Data> implements ModelLoader<String, Data> {
  private final ModelLoader<Uri, Data> a;
  
  public StringLoader(ModelLoader<Uri, Data> paramModelLoader) {
    this.a = paramModelLoader;
  }
  
  private static Uri b(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    if (paramString.charAt(0) == '/')
      return c(paramString); 
    Uri uri = Uri.parse(paramString);
    return (uri.getScheme() == null) ? c(paramString) : uri;
  }
  
  private static Uri c(String paramString) {
    return Uri.fromFile(new File(paramString));
  }
  
  public ModelLoader.LoadData<Data> a(String paramString, int paramInt1, int paramInt2, Options paramOptions) {
    Uri uri = b(paramString);
    return (uri == null || !this.a.a(uri)) ? null : this.a.a(uri, paramInt1, paramInt2, paramOptions);
  }
  
  public boolean a(String paramString) {
    return true;
  }
  
  public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<String, AssetFileDescriptor> {
    public ModelLoader<String, AssetFileDescriptor> a(MultiModelLoaderFactory param1MultiModelLoaderFactory) {
      return new StringLoader<AssetFileDescriptor>(param1MultiModelLoaderFactory.b(Uri.class, AssetFileDescriptor.class));
    }
    
    public void a() {}
  }
  
  public static class FileDescriptorFactory implements ModelLoaderFactory<String, ParcelFileDescriptor> {
    public ModelLoader<String, ParcelFileDescriptor> a(MultiModelLoaderFactory param1MultiModelLoaderFactory) {
      return new StringLoader<ParcelFileDescriptor>(param1MultiModelLoaderFactory.b(Uri.class, ParcelFileDescriptor.class));
    }
    
    public void a() {}
  }
  
  public static class StreamFactory implements ModelLoaderFactory<String, InputStream> {
    public ModelLoader<String, InputStream> a(MultiModelLoaderFactory param1MultiModelLoaderFactory) {
      return new StringLoader<InputStream>(param1MultiModelLoaderFactory.b(Uri.class, InputStream.class));
    }
    
    public void a() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\model\StringLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */