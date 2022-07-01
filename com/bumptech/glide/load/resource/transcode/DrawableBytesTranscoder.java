package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.gif.GifDrawable;

public final class DrawableBytesTranscoder implements ResourceTranscoder<Drawable, byte[]> {
  private final BitmapPool a;
  
  private final ResourceTranscoder<Bitmap, byte[]> b;
  
  private final ResourceTranscoder<GifDrawable, byte[]> c;
  
  public DrawableBytesTranscoder(BitmapPool paramBitmapPool, ResourceTranscoder<Bitmap, byte[]> paramResourceTranscoder, ResourceTranscoder<GifDrawable, byte[]> paramResourceTranscoder1) {
    this.a = paramBitmapPool;
    this.b = paramResourceTranscoder;
    this.c = paramResourceTranscoder1;
  }
  
  private static Resource<GifDrawable> a(Resource<Drawable> paramResource) {
    return (Resource)paramResource;
  }
  
  public Resource<byte[]> a(Resource<Drawable> paramResource, Options paramOptions) {
    Drawable drawable = (Drawable)paramResource.f();
    return (Resource)((drawable instanceof BitmapDrawable) ? this.b.a((Resource<Bitmap>)BitmapResource.a(((BitmapDrawable)drawable).getBitmap(), this.a), paramOptions) : ((drawable instanceof GifDrawable) ? this.c.a(a(paramResource), paramOptions) : null));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\transcode\DrawableBytesTranscoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */