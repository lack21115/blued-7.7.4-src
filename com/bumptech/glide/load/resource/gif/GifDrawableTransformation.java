package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

public class GifDrawableTransformation implements Transformation<GifDrawable> {
  private final Transformation<Bitmap> b;
  
  public GifDrawableTransformation(Transformation<Bitmap> paramTransformation) {
    this.b = (Transformation<Bitmap>)Preconditions.a(paramTransformation);
  }
  
  public Resource<GifDrawable> a(Context paramContext, Resource<GifDrawable> paramResource, int paramInt1, int paramInt2) {
    GifDrawable gifDrawable = (GifDrawable)paramResource.f();
    BitmapPool bitmapPool = Glide.a(paramContext).a();
    BitmapResource bitmapResource = new BitmapResource(gifDrawable.b(), bitmapPool);
    Resource resource = this.b.a(paramContext, (Resource)bitmapResource, paramInt1, paramInt2);
    if (!bitmapResource.equals(resource))
      bitmapResource.c(); 
    Bitmap bitmap = (Bitmap)resource.f();
    gifDrawable.a(this.b, bitmap);
    return paramResource;
  }
  
  public void a(MessageDigest paramMessageDigest) {
    this.b.a(paramMessageDigest);
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject instanceof GifDrawableTransformation) {
      paramObject = paramObject;
      return this.b.equals(((GifDrawableTransformation)paramObject).b);
    } 
    return false;
  }
  
  public int hashCode() {
    return this.b.hashCode();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\gif\GifDrawableTransformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */