package com.bumptech.glide.load.resource.bitmap;

import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.DrawableResource;
import com.bumptech.glide.util.Util;

public class BitmapDrawableResource extends DrawableResource<BitmapDrawable> implements Initializable {
  private final BitmapPool a;
  
  public Class<BitmapDrawable> a() {
    return BitmapDrawable.class;
  }
  
  public int b() {
    return Util.a(((BitmapDrawable)this.d).getBitmap());
  }
  
  public void c() {
    this.a.a(((BitmapDrawable)this.d).getBitmap());
  }
  
  public void d() {
    ((BitmapDrawable)this.d).getBitmap().prepareToDraw();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\BitmapDrawableResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */