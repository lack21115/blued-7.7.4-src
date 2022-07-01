package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.ExceptionCatchingInputStream;
import com.bumptech.glide.util.MarkEnforcingInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamBitmapDecoder implements ResourceDecoder<InputStream, Bitmap> {
  private final Downsampler a;
  
  private final ArrayPool b;
  
  public StreamBitmapDecoder(Downsampler paramDownsampler, ArrayPool paramArrayPool) {
    this.a = paramDownsampler;
    this.b = paramArrayPool;
  }
  
  public Resource<Bitmap> a(InputStream paramInputStream, int paramInt1, int paramInt2, Options paramOptions) throws IOException {
    boolean bool;
    if (paramInputStream instanceof RecyclableBufferedInputStream) {
      paramInputStream = paramInputStream;
      bool = false;
    } else {
      paramInputStream = new RecyclableBufferedInputStream(paramInputStream, this.b);
      bool = true;
    } 
    ExceptionCatchingInputStream exceptionCatchingInputStream = ExceptionCatchingInputStream.a(paramInputStream);
    MarkEnforcingInputStream markEnforcingInputStream = new MarkEnforcingInputStream((InputStream)exceptionCatchingInputStream);
    UntrustedCallbacks untrustedCallbacks = new UntrustedCallbacks((RecyclableBufferedInputStream)paramInputStream, exceptionCatchingInputStream);
    try {
      return this.a.a((InputStream)markEnforcingInputStream, paramInt1, paramInt2, paramOptions, untrustedCallbacks);
    } finally {
      exceptionCatchingInputStream.b();
      if (bool)
        paramInputStream.b(); 
    } 
  }
  
  public boolean a(InputStream paramInputStream, Options paramOptions) {
    return this.a.a(paramInputStream);
  }
  
  static class UntrustedCallbacks implements Downsampler.DecodeCallbacks {
    private final RecyclableBufferedInputStream a;
    
    private final ExceptionCatchingInputStream b;
    
    UntrustedCallbacks(RecyclableBufferedInputStream param1RecyclableBufferedInputStream, ExceptionCatchingInputStream param1ExceptionCatchingInputStream) {
      this.a = param1RecyclableBufferedInputStream;
      this.b = param1ExceptionCatchingInputStream;
    }
    
    public void a() {
      this.a.a();
    }
    
    public void a(BitmapPool param1BitmapPool, Bitmap param1Bitmap) throws IOException {
      IOException iOException = this.b.a();
      if (iOException != null) {
        if (param1Bitmap != null)
          param1BitmapPool.a(param1Bitmap); 
        throw iOException;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\StreamBitmapDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */