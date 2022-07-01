package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.File;

public class BitmapDrawableEncoder implements ResourceEncoder<BitmapDrawable> {
  private final BitmapPool a;
  
  private final ResourceEncoder<Bitmap> b;
  
  public BitmapDrawableEncoder(BitmapPool paramBitmapPool, ResourceEncoder<Bitmap> paramResourceEncoder) {
    this.a = paramBitmapPool;
    this.b = paramResourceEncoder;
  }
  
  public EncodeStrategy a(Options paramOptions) {
    return this.b.a(paramOptions);
  }
  
  public boolean a(Resource<BitmapDrawable> paramResource, File paramFile, Options paramOptions) {
    return this.b.a(new BitmapResource(((BitmapDrawable)paramResource.f()).getBitmap(), this.a), paramFile, paramOptions);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\BitmapDrawableEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */