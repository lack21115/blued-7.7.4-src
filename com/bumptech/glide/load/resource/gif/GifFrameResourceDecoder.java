package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import java.io.IOException;

public final class GifFrameResourceDecoder implements ResourceDecoder<GifDecoder, Bitmap> {
  private final BitmapPool a;
  
  public GifFrameResourceDecoder(BitmapPool paramBitmapPool) {
    this.a = paramBitmapPool;
  }
  
  public Resource<Bitmap> a(GifDecoder paramGifDecoder, int paramInt1, int paramInt2, Options paramOptions) {
    return (Resource<Bitmap>)BitmapResource.a(paramGifDecoder.i(), this.a);
  }
  
  public boolean a(GifDecoder paramGifDecoder, Options paramOptions) {
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\gif\GifFrameResourceDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */