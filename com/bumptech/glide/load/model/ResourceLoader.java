package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.Options;
import java.io.InputStream;

public class ResourceLoader<Data> implements ModelLoader<Integer, Data> {
  private final ModelLoader<Uri, Data> a;
  
  private final Resources b;
  
  public ResourceLoader(Resources paramResources, ModelLoader<Uri, Data> paramModelLoader) {
    this.b = paramResources;
    this.a = paramModelLoader;
  }
  
  private Uri b(Integer paramInteger) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("android.resource://");
      stringBuilder.append(this.b.getResourcePackageName(paramInteger.intValue()));
      stringBuilder.append('/');
      stringBuilder.append(this.b.getResourceTypeName(paramInteger.intValue()));
      stringBuilder.append('/');
      stringBuilder.append(this.b.getResourceEntryName(paramInteger.intValue()));
      return Uri.parse(stringBuilder.toString());
    } catch (android.content.res.Resources.NotFoundException notFoundException) {
      if (Log.isLoggable("ResourceLoader", 5)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Received invalid resource id: ");
        stringBuilder.append(paramInteger);
        Log.w("ResourceLoader", stringBuilder.toString(), (Throwable)notFoundException);
      } 
      return null;
    } 
  }
  
  public ModelLoader.LoadData<Data> a(Integer paramInteger, int paramInt1, int paramInt2, Options paramOptions) {
    Uri uri = b(paramInteger);
    return (uri == null) ? null : this.a.a(uri, paramInt1, paramInt2, paramOptions);
  }
  
  public boolean a(Integer paramInteger) {
    return true;
  }
  
  public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Integer, AssetFileDescriptor> {
    private final Resources a;
    
    public AssetFileDescriptorFactory(Resources param1Resources) {
      this.a = param1Resources;
    }
    
    public ModelLoader<Integer, AssetFileDescriptor> a(MultiModelLoaderFactory param1MultiModelLoaderFactory) {
      return new ResourceLoader<AssetFileDescriptor>(this.a, param1MultiModelLoaderFactory.b(Uri.class, AssetFileDescriptor.class));
    }
    
    public void a() {}
  }
  
  public static class FileDescriptorFactory implements ModelLoaderFactory<Integer, ParcelFileDescriptor> {
    private final Resources a;
    
    public FileDescriptorFactory(Resources param1Resources) {
      this.a = param1Resources;
    }
    
    public ModelLoader<Integer, ParcelFileDescriptor> a(MultiModelLoaderFactory param1MultiModelLoaderFactory) {
      return new ResourceLoader<ParcelFileDescriptor>(this.a, param1MultiModelLoaderFactory.b(Uri.class, ParcelFileDescriptor.class));
    }
    
    public void a() {}
  }
  
  public static class StreamFactory implements ModelLoaderFactory<Integer, InputStream> {
    private final Resources a;
    
    public StreamFactory(Resources param1Resources) {
      this.a = param1Resources;
    }
    
    public ModelLoader<Integer, InputStream> a(MultiModelLoaderFactory param1MultiModelLoaderFactory) {
      return new ResourceLoader<InputStream>(this.a, param1MultiModelLoaderFactory.b(Uri.class, InputStream.class));
    }
    
    public void a() {}
  }
  
  public static class UriFactory implements ModelLoaderFactory<Integer, Uri> {
    private final Resources a;
    
    public UriFactory(Resources param1Resources) {
      this.a = param1Resources;
    }
    
    public ModelLoader<Integer, Uri> a(MultiModelLoaderFactory param1MultiModelLoaderFactory) {
      return new ResourceLoader<Uri>(this.a, UnitModelLoader.a());
    }
    
    public void a() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\model\ResourceLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */