package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class DrawableTransformation implements Transformation<Drawable> {
  private final Transformation<Bitmap> b;
  
  private final boolean c;
  
  public DrawableTransformation(Transformation<Bitmap> paramTransformation, boolean paramBoolean) {
    this.b = paramTransformation;
    this.c = paramBoolean;
  }
  
  private Resource<Drawable> a(Context paramContext, Resource<Bitmap> paramResource) {
    return (Resource)LazyBitmapDrawableResource.a(paramContext.getResources(), paramResource);
  }
  
  public Transformation<BitmapDrawable> a() {
    return this;
  }
  
  public Resource<Drawable> a(Context paramContext, Resource<Drawable> paramResource, int paramInt1, int paramInt2) {
    StringBuilder stringBuilder;
    BitmapPool bitmapPool = Glide.a(paramContext).a();
    Drawable drawable = (Drawable)paramResource.f();
    Resource<Bitmap> resource2 = DrawableToBitmapConverter.a(bitmapPool, drawable, paramInt1, paramInt2);
    if (resource2 == null) {
      if (!this.c)
        return paramResource; 
      stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to convert ");
      stringBuilder.append(drawable);
      stringBuilder.append(" to a Bitmap");
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    Resource<Bitmap> resource1 = this.b.a((Context)stringBuilder, resource2, paramInt1, paramInt2);
    if (resource1.equals(resource2)) {
      resource1.c();
      return paramResource;
    } 
    return a((Context)stringBuilder, resource1);
  }
  
  public void a(MessageDigest paramMessageDigest) {
    this.b.a(paramMessageDigest);
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject instanceof DrawableTransformation) {
      paramObject = paramObject;
      return this.b.equals(((DrawableTransformation)paramObject).b);
    } 
    return false;
  }
  
  public int hashCode() {
    return this.b.hashCode();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\DrawableTransformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */