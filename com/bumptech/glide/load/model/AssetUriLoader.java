package com.bumptech.glide.load.model;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.FileDescriptorAssetPathFetcher;
import com.bumptech.glide.load.data.StreamAssetPathFetcher;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

public class AssetUriLoader<Data> implements ModelLoader<Uri, Data> {
  private static final int a = 22;
  
  private final AssetManager b;
  
  private final AssetFetcherFactory<Data> c;
  
  public AssetUriLoader(AssetManager paramAssetManager, AssetFetcherFactory<Data> paramAssetFetcherFactory) {
    this.b = paramAssetManager;
    this.c = paramAssetFetcherFactory;
  }
  
  public ModelLoader.LoadData<Data> a(Uri paramUri, int paramInt1, int paramInt2, Options paramOptions) {
    String str = paramUri.toString().substring(a);
    return new ModelLoader.LoadData<Data>((Key)new ObjectKey(paramUri), this.c.a(this.b, str));
  }
  
  public boolean a(Uri paramUri) {
    boolean bool = "file".equals(paramUri.getScheme());
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      bool1 = bool2;
      if (!paramUri.getPathSegments().isEmpty()) {
        bool1 = bool2;
        if ("android_asset".equals(paramUri.getPathSegments().get(0)))
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  public static interface AssetFetcherFactory<Data> {
    DataFetcher<Data> a(AssetManager param1AssetManager, String param1String);
  }
  
  public static class FileDescriptorFactory implements AssetFetcherFactory<ParcelFileDescriptor>, ModelLoaderFactory<Uri, ParcelFileDescriptor> {
    private final AssetManager a;
    
    public FileDescriptorFactory(AssetManager param1AssetManager) {
      this.a = param1AssetManager;
    }
    
    public DataFetcher<ParcelFileDescriptor> a(AssetManager param1AssetManager, String param1String) {
      return (DataFetcher<ParcelFileDescriptor>)new FileDescriptorAssetPathFetcher(param1AssetManager, param1String);
    }
    
    public ModelLoader<Uri, ParcelFileDescriptor> a(MultiModelLoaderFactory param1MultiModelLoaderFactory) {
      return new AssetUriLoader<ParcelFileDescriptor>(this.a, this);
    }
    
    public void a() {}
  }
  
  public static class StreamFactory implements AssetFetcherFactory<InputStream>, ModelLoaderFactory<Uri, InputStream> {
    private final AssetManager a;
    
    public StreamFactory(AssetManager param1AssetManager) {
      this.a = param1AssetManager;
    }
    
    public DataFetcher<InputStream> a(AssetManager param1AssetManager, String param1String) {
      return (DataFetcher<InputStream>)new StreamAssetPathFetcher(param1AssetManager, param1String);
    }
    
    public ModelLoader<Uri, InputStream> a(MultiModelLoaderFactory param1MultiModelLoaderFactory) {
      return new AssetUriLoader<InputStream>(this.a, this);
    }
    
    public void a() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\model\AssetUriLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */