package com.bumptech.glide.load.model;

import android.util.Base64;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.signature.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class DataUrlLoader<Model, Data> implements ModelLoader<Model, Data> {
  private final DataDecoder<Data> a;
  
  public DataUrlLoader(DataDecoder<Data> paramDataDecoder) {
    this.a = paramDataDecoder;
  }
  
  public ModelLoader.LoadData<Data> a(Model paramModel, int paramInt1, int paramInt2, Options paramOptions) {
    return new ModelLoader.LoadData<Data>((Key)new ObjectKey(paramModel), new DataUriFetcher<Data>(paramModel.toString(), this.a));
  }
  
  public boolean a(Model paramModel) {
    return paramModel.toString().startsWith("data:image");
  }
  
  public static interface DataDecoder<Data> {
    Class<Data> a();
    
    Data a(String param1String) throws IllegalArgumentException;
    
    void a(Data param1Data) throws IOException;
  }
  
  static final class DataUriFetcher<Data> implements DataFetcher<Data> {
    private final String a;
    
    private final DataUrlLoader.DataDecoder<Data> b;
    
    private Data c;
    
    DataUriFetcher(String param1String, DataUrlLoader.DataDecoder<Data> param1DataDecoder) {
      this.a = param1String;
      this.b = param1DataDecoder;
    }
    
    public void a() {
      try {
        this.b.a(this.c);
        return;
      } catch (IOException iOException) {
        return;
      } 
    }
    
    public void a(Priority param1Priority, DataFetcher.DataCallback<? super Data> param1DataCallback) {
      try {
        this.c = this.b.a(this.a);
        param1DataCallback.a(this.c);
        return;
      } catch (IllegalArgumentException illegalArgumentException) {
        param1DataCallback.a(illegalArgumentException);
        return;
      } 
    }
    
    public void b() {}
    
    public Class<Data> c() {
      return this.b.a();
    }
    
    public DataSource d() {
      return DataSource.a;
    }
  }
  
  public static final class StreamFactory<Model> implements ModelLoaderFactory<Model, InputStream> {
    private final DataUrlLoader.DataDecoder<InputStream> a = new DataUrlLoader.DataDecoder<InputStream>(this) {
        public Class<InputStream> a() {
          return InputStream.class;
        }
        
        public void a(InputStream param2InputStream) throws IOException {
          param2InputStream.close();
        }
        
        public InputStream b(String param2String) {
          if (param2String.startsWith("data:image")) {
            int i = param2String.indexOf(',');
            if (i != -1) {
              if (param2String.substring(0, i).endsWith(";base64"))
                return new ByteArrayInputStream(Base64.decode(param2String.substring(i + 1), 0)); 
              throw new IllegalArgumentException("Not a base64 image data URL.");
            } 
            throw new IllegalArgumentException("Missing comma in data URL.");
          } 
          throw new IllegalArgumentException("Not a valid image data URL.");
        }
      };
    
    public ModelLoader<Model, InputStream> a(MultiModelLoaderFactory param1MultiModelLoaderFactory) {
      return new DataUrlLoader<Model, InputStream>(this.a);
    }
    
    public void a() {}
  }
  
  class null implements DataDecoder<InputStream> {
    null(DataUrlLoader this$0) {}
    
    public Class<InputStream> a() {
      return InputStream.class;
    }
    
    public void a(InputStream param1InputStream) throws IOException {
      param1InputStream.close();
    }
    
    public InputStream b(String param1String) {
      if (param1String.startsWith("data:image")) {
        int i = param1String.indexOf(',');
        if (i != -1) {
          if (param1String.substring(0, i).endsWith(";base64"))
            return new ByteArrayInputStream(Base64.decode(param1String.substring(i + 1), 0)); 
          throw new IllegalArgumentException("Not a base64 image data URL.");
        } 
        throw new IllegalArgumentException("Missing comma in data URL.");
      } 
      throw new IllegalArgumentException("Not a valid image data URL.");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\model\DataUrlLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */