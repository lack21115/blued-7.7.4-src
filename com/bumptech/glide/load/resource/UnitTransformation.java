package com.bumptech.glide.load.resource;

import android.content.Context;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;

public final class UnitTransformation<T> implements Transformation<T> {
  private static final Transformation<?> b = new UnitTransformation();
  
  public static <T> UnitTransformation<T> a() {
    return (UnitTransformation)b;
  }
  
  public Resource<T> a(Context paramContext, Resource<T> paramResource, int paramInt1, int paramInt2) {
    return paramResource;
  }
  
  public void a(MessageDigest paramMessageDigest) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\UnitTransformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */