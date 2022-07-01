package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.signature.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ByteArrayLoader<Data> implements ModelLoader<byte[], Data> {
  private final Converter<Data> a;
  
  public ByteArrayLoader(Converter<Data> paramConverter) {
    this.a = paramConverter;
  }
  
  public ModelLoader.LoadData<Data> a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, Options paramOptions) {
    return new ModelLoader.LoadData<Data>((Key)new ObjectKey(paramArrayOfbyte), new Fetcher<Data>(paramArrayOfbyte, this.a));
  }
  
  public boolean a(byte[] paramArrayOfbyte) {
    return true;
  }
  
  public static class ByteBufferFactory implements ModelLoaderFactory<byte[], ByteBuffer> {
    public ModelLoader<byte[], ByteBuffer> a(MultiModelLoaderFactory param1MultiModelLoaderFactory) {
      return new ByteArrayLoader<ByteBuffer>(new ByteArrayLoader.Converter<ByteBuffer>(this) {
            public Class<ByteBuffer> a() {
              return ByteBuffer.class;
            }
            
            public ByteBuffer a(byte[] param2ArrayOfbyte) {
              return ByteBuffer.wrap(param2ArrayOfbyte);
            }
          });
    }
    
    public void a() {}
  }
  
  class null implements Converter<ByteBuffer> {
    null(ByteArrayLoader this$0) {}
    
    public Class<ByteBuffer> a() {
      return ByteBuffer.class;
    }
    
    public ByteBuffer a(byte[] param1ArrayOfbyte) {
      return ByteBuffer.wrap(param1ArrayOfbyte);
    }
  }
  
  public static interface Converter<Data> {
    Class<Data> a();
    
    Data b(byte[] param1ArrayOfbyte);
  }
  
  static class Fetcher<Data> implements DataFetcher<Data> {
    private final byte[] a;
    
    private final ByteArrayLoader.Converter<Data> b;
    
    Fetcher(byte[] param1ArrayOfbyte, ByteArrayLoader.Converter<Data> param1Converter) {
      this.a = param1ArrayOfbyte;
      this.b = param1Converter;
    }
    
    public void a() {}
    
    public void a(Priority param1Priority, DataFetcher.DataCallback<? super Data> param1DataCallback) {
      param1DataCallback.a(this.b.b(this.a));
    }
    
    public void b() {}
    
    public Class<Data> c() {
      return this.b.a();
    }
    
    public DataSource d() {
      return DataSource.a;
    }
  }
  
  public static class StreamFactory implements ModelLoaderFactory<byte[], InputStream> {
    public ModelLoader<byte[], InputStream> a(MultiModelLoaderFactory param1MultiModelLoaderFactory) {
      return new ByteArrayLoader<InputStream>(new ByteArrayLoader.Converter<InputStream>(this) {
            public InputStream a(byte[] param2ArrayOfbyte) {
              return new ByteArrayInputStream(param2ArrayOfbyte);
            }
            
            public Class<InputStream> a() {
              return InputStream.class;
            }
          });
    }
    
    public void a() {}
  }
  
  class null implements Converter<InputStream> {
    null(ByteArrayLoader this$0) {}
    
    public InputStream a(byte[] param1ArrayOfbyte) {
      return new ByteArrayInputStream(param1ArrayOfbyte);
    }
    
    public Class<InputStream> a() {
      return InputStream.class;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\model\ByteArrayLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */