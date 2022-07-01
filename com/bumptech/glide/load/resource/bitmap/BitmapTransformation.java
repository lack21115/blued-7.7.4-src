package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;

public abstract class BitmapTransformation implements Transformation<Bitmap> {
  protected abstract Bitmap a(BitmapPool paramBitmapPool, Bitmap paramBitmap, int paramInt1, int paramInt2);
  
  public final Resource<Bitmap> a(Context paramContext, Resource<Bitmap> paramResource, int paramInt1, int paramInt2) {
    if (Util.a(paramInt1, paramInt2)) {
      BitmapPool bitmapPool = Glide.a(paramContext).a();
      Bitmap bitmap1 = (Bitmap)paramResource.f();
      int i = paramInt1;
      if (paramInt1 == Integer.MIN_VALUE)
        i = bitmap1.getWidth(); 
      paramInt1 = paramInt2;
      if (paramInt2 == Integer.MIN_VALUE)
        paramInt1 = bitmap1.getHeight(); 
      Bitmap bitmap2 = a(bitmapPool, bitmap1, i, paramInt1);
      return bitmap1.equals(bitmap2) ? paramResource : BitmapResource.a(bitmap2, bitmapPool);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Cannot apply transformation on width: ");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" or height: ");
    stringBuilder.append(paramInt2);
    stringBuilder.append(" less than or equal to zero and not Target.SIZE_ORIGINAL");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\BitmapTransformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */