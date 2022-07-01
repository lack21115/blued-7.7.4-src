package com.bumptech.glide.load.model;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ByteBufferFileLoader implements ModelLoader<File, ByteBuffer> {
  public ModelLoader.LoadData<ByteBuffer> a(File paramFile, int paramInt1, int paramInt2, Options paramOptions) {
    return new ModelLoader.LoadData<ByteBuffer>((Key)new ObjectKey(paramFile), new ByteBufferFetcher(paramFile));
  }
  
  public boolean a(File paramFile) {
    return true;
  }
  
  static final class ByteBufferFetcher implements DataFetcher<ByteBuffer> {
    private final File a;
    
    ByteBufferFetcher(File param1File) {
      this.a = param1File;
    }
    
    public void a() {}
    
    public void a(Priority param1Priority, DataFetcher.DataCallback<? super ByteBuffer> param1DataCallback) {
      try {
        ByteBuffer byteBuffer = ByteBufferUtil.a(this.a);
        param1DataCallback.a(byteBuffer);
        return;
      } catch (IOException iOException) {
        if (Log.isLoggable("ByteBufferFileLoader", 3))
          Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", iOException); 
        param1DataCallback.a(iOException);
        return;
      } 
    }
    
    public void b() {}
    
    public Class<ByteBuffer> c() {
      return ByteBuffer.class;
    }
    
    public DataSource d() {
      return DataSource.a;
    }
  }
  
  public static class Factory implements ModelLoaderFactory<File, ByteBuffer> {
    public ModelLoader<File, ByteBuffer> a(MultiModelLoaderFactory param1MultiModelLoaderFactory) {
      return new ByteBufferFileLoader();
    }
    
    public void a() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\model\ByteBufferFileLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */