package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.Resource;

final class NonOwnedDrawableResource extends DrawableResource<Drawable> {
  private NonOwnedDrawableResource(Drawable paramDrawable) {
    super(paramDrawable);
  }
  
  static Resource<Drawable> a(Drawable paramDrawable) {
    return (paramDrawable != null) ? new NonOwnedDrawableResource(paramDrawable) : null;
  }
  
  public Class<Drawable> a() {
    return (Class)this.d.getClass();
  }
  
  public int b() {
    return Math.max(1, this.d.getIntrinsicWidth() * this.d.getIntrinsicHeight() * 4);
  }
  
  public void c() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\drawable\NonOwnedDrawableResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */