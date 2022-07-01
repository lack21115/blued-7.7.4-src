package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

public final class GifBitmapProvider implements GifDecoder.BitmapProvider {
  private final BitmapPool a;
  
  private final ArrayPool b;
  
  public GifBitmapProvider(BitmapPool paramBitmapPool, ArrayPool paramArrayPool) {
    this.a = paramBitmapPool;
    this.b = paramArrayPool;
  }
  
  public Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig) {
    return this.a.b(paramInt1, paramInt2, paramConfig);
  }
  
  public void a(Bitmap paramBitmap) {
    this.a.a(paramBitmap);
  }
  
  public void a(byte[] paramArrayOfbyte) {
    ArrayPool arrayPool = this.b;
    if (arrayPool == null)
      return; 
    arrayPool.a(paramArrayOfbyte);
  }
  
  public void a(int[] paramArrayOfint) {
    ArrayPool arrayPool = this.b;
    if (arrayPool == null)
      return; 
    arrayPool.a(paramArrayOfint);
  }
  
  public byte[] a(int paramInt) {
    ArrayPool arrayPool = this.b;
    return (arrayPool == null) ? new byte[paramInt] : (byte[])arrayPool.a(paramInt, byte[].class);
  }
  
  public int[] b(int paramInt) {
    ArrayPool arrayPool = this.b;
    return (arrayPool == null) ? new int[paramInt] : (int[])arrayPool.a(paramInt, int[].class);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\gif\GifBitmapProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */