package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;

@Deprecated
public class BitmapDrawableTransformation implements Transformation<BitmapDrawable> {
  private final Transformation<Drawable> b;
  
  private static Resource<BitmapDrawable> a(Resource<Drawable> paramResource) {
    if (paramResource.f() instanceof BitmapDrawable)
      return (Resource)paramResource; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Wrapped transformation unexpectedly returned a non BitmapDrawable resource: ");
    stringBuilder.append(paramResource.f());
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private static Resource<Drawable> b(Resource<BitmapDrawable> paramResource) {
    return (Resource)paramResource;
  }
  
  public Resource<BitmapDrawable> a(Context paramContext, Resource<BitmapDrawable> paramResource, int paramInt1, int paramInt2) {
    paramResource = (Resource)b(paramResource);
    return a(this.b.a(paramContext, paramResource, paramInt1, paramInt2));
  }
  
  public void a(MessageDigest paramMessageDigest) {
    this.b.a(paramMessageDigest);
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject instanceof BitmapDrawableTransformation) {
      paramObject = paramObject;
      return this.b.equals(((BitmapDrawableTransformation)paramObject).b);
    } 
    return false;
  }
  
  public int hashCode() {
    return this.b.hashCode();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\BitmapDrawableTransformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */