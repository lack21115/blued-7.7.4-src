package com.bumptech.glide.load.model;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.AssetFileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.FileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.data.StreamLocalUriFetcher;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UriLoader<Data> implements ModelLoader<Uri, Data> {
  private static final Set<String> a = Collections.unmodifiableSet(new HashSet<String>(Arrays.asList(new String[] { "file", "android.resource", "content" })));
  
  private final LocalUriFetcherFactory<Data> b;
  
  public UriLoader(LocalUriFetcherFactory<Data> paramLocalUriFetcherFactory) {
    this.b = paramLocalUriFetcherFactory;
  }
  
  public ModelLoader.LoadData<Data> a(Uri paramUri, int paramInt1, int paramInt2, Options paramOptions) {
    return new ModelLoader.LoadData<Data>((Key)new ObjectKey(paramUri), this.b.a(paramUri));
  }
  
  public boolean a(Uri paramUri) {
    return a.contains(paramUri.getScheme());
  }
  
  public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Uri, AssetFileDescriptor>, LocalUriFetcherFactory<AssetFileDescriptor> {
    private final ContentResolver a;
    
    public AssetFileDescriptorFactory(ContentResolver param1ContentResolver) {
      this.a = param1ContentResolver;
    }
    
    public DataFetcher<AssetFileDescriptor> a(Uri param1Uri) {
      return (DataFetcher<AssetFileDescriptor>)new AssetFileDescriptorLocalUriFetcher(this.a, param1Uri);
    }
    
    public ModelLoader<Uri, AssetFileDescriptor> a(MultiModelLoaderFactory param1MultiModelLoaderFactory) {
      return new UriLoader<AssetFileDescriptor>(this);
    }
    
    public void a() {}
  }
  
  public static class FileDescriptorFactory implements ModelLoaderFactory<Uri, ParcelFileDescriptor>, LocalUriFetcherFactory<ParcelFileDescriptor> {
    private final ContentResolver a;
    
    public FileDescriptorFactory(ContentResolver param1ContentResolver) {
      this.a = param1ContentResolver;
    }
    
    public DataFetcher<ParcelFileDescriptor> a(Uri param1Uri) {
      return (DataFetcher<ParcelFileDescriptor>)new FileDescriptorLocalUriFetcher(this.a, param1Uri);
    }
    
    public ModelLoader<Uri, ParcelFileDescriptor> a(MultiModelLoaderFactory param1MultiModelLoaderFactory) {
      return new UriLoader<ParcelFileDescriptor>(this);
    }
    
    public void a() {}
  }
  
  public static interface LocalUriFetcherFactory<Data> {
    DataFetcher<Data> a(Uri param1Uri);
  }
  
  public static class StreamFactory implements ModelLoaderFactory<Uri, InputStream>, LocalUriFetcherFactory<InputStream> {
    private final ContentResolver a;
    
    public StreamFactory(ContentResolver param1ContentResolver) {
      this.a = param1ContentResolver;
    }
    
    public DataFetcher<InputStream> a(Uri param1Uri) {
      return (DataFetcher<InputStream>)new StreamLocalUriFetcher(this.a, param1Uri);
    }
    
    public ModelLoader<Uri, InputStream> a(MultiModelLoaderFactory param1MultiModelLoaderFactory) {
      return new UriLoader<InputStream>(this);
    }
    
    public void a() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\model\UriLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */