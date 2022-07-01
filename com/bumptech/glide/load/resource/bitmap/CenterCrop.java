package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class CenterCrop extends BitmapTransformation {
  private static final byte[] b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(a);
  
  protected Bitmap a(BitmapPool paramBitmapPool, Bitmap paramBitmap, int paramInt1, int paramInt2) {
    return TransformationUtils.a(paramBitmapPool, paramBitmap, paramInt1, paramInt2);
  }
  
  public void a(MessageDigest paramMessageDigest) {
    paramMessageDigest.update(b);
  }
  
  public boolean equals(Object paramObject) {
    return paramObject instanceof CenterCrop;
  }
  
  public int hashCode() {
    return "com.bumptech.glide.load.resource.bitmap.CenterCrop".hashCode();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\CenterCrop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */