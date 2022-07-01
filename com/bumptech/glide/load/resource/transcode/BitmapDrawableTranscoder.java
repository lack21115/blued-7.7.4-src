package com.bumptech.glide.load.resource.transcode;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource;
import com.bumptech.glide.util.Preconditions;

public class BitmapDrawableTranscoder implements ResourceTranscoder<Bitmap, BitmapDrawable> {
  private final Resources a;
  
  public BitmapDrawableTranscoder(Resources paramResources) {
    this.a = (Resources)Preconditions.a(paramResources);
  }
  
  public Resource<BitmapDrawable> a(Resource<Bitmap> paramResource, Options paramOptions) {
    return LazyBitmapDrawableResource.a(this.a, paramResource);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\transcode\BitmapDrawableTranscoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */