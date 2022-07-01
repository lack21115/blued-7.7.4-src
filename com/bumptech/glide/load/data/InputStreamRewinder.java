package com.bumptech.glide.load.data;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class InputStreamRewinder implements DataRewinder<InputStream> {
  private final RecyclableBufferedInputStream a;
  
  public InputStreamRewinder(InputStream paramInputStream, ArrayPool paramArrayPool) {
    this.a = new RecyclableBufferedInputStream(paramInputStream, paramArrayPool);
    this.a.mark(5242880);
  }
  
  public void b() {
    this.a.b();
  }
  
  public InputStream c() throws IOException {
    this.a.reset();
    return (InputStream)this.a;
  }
  
  public void d() {
    this.a.a();
  }
  
  public static final class Factory implements DataRewinder.Factory<InputStream> {
    private final ArrayPool a;
    
    public Factory(ArrayPool param1ArrayPool) {
      this.a = param1ArrayPool;
    }
    
    public DataRewinder<InputStream> a(InputStream param1InputStream) {
      return new InputStreamRewinder(param1InputStream, this.a);
    }
    
    public Class<InputStream> a() {
      return InputStream.class;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\data\InputStreamRewinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */