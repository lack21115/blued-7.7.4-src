package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

public final class LazyBitmapDrawableResource implements Initializable, Resource<BitmapDrawable> {
  private final Resources a;
  
  private final Resource<Bitmap> b;
  
  private LazyBitmapDrawableResource(Resources paramResources, Resource<Bitmap> paramResource) {
    this.a = (Resources)Preconditions.a(paramResources);
    this.b = (Resource<Bitmap>)Preconditions.a(paramResource);
  }
  
  public static Resource<BitmapDrawable> a(Resources paramResources, Resource<Bitmap> paramResource) {
    return (paramResource == null) ? null : new LazyBitmapDrawableResource(paramResources, paramResource);
  }
  
  public Class<BitmapDrawable> a() {
    return BitmapDrawable.class;
  }
  
  public int b() {
    return this.b.b();
  }
  
  public void c() {
    this.b.c();
  }
  
  public void d() {
    Resource<Bitmap> resource = this.b;
    if (resource instanceof Initializable)
      ((Initializable)resource).d(); 
  }
  
  public BitmapDrawable e() {
    return new BitmapDrawable(this.a, (Bitmap)this.b.f());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\LazyBitmapDrawableResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */