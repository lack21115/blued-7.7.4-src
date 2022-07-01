package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;

public class BitmapResource implements Initializable, Resource<Bitmap> {
  private final Bitmap a;
  
  private final BitmapPool b;
  
  public BitmapResource(Bitmap paramBitmap, BitmapPool paramBitmapPool) {
    this.a = (Bitmap)Preconditions.a(paramBitmap, "Bitmap must not be null");
    this.b = (BitmapPool)Preconditions.a(paramBitmapPool, "BitmapPool must not be null");
  }
  
  public static BitmapResource a(Bitmap paramBitmap, BitmapPool paramBitmapPool) {
    return (paramBitmap == null) ? null : new BitmapResource(paramBitmap, paramBitmapPool);
  }
  
  public Class<Bitmap> a() {
    return Bitmap.class;
  }
  
  public int b() {
    return Util.a(this.a);
  }
  
  public void c() {
    this.b.a(this.a);
  }
  
  public void d() {
    this.a.prepareToDraw();
  }
  
  public Bitmap e() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\BitmapResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */