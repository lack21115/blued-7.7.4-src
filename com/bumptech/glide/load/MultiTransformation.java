package com.bumptech.glide.load;

import android.content.Context;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MultiTransformation<T> implements Transformation<T> {
  private final Collection<? extends Transformation<T>> b;
  
  @SafeVarargs
  public MultiTransformation(Transformation<T>... paramVarArgs) {
    if (paramVarArgs.length != 0) {
      this.b = Arrays.asList(paramVarArgs);
      return;
    } 
    throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
  }
  
  public Resource<T> a(Context paramContext, Resource<T> paramResource, int paramInt1, int paramInt2) {
    Iterator<? extends Transformation<T>> iterator = this.b.iterator();
    Resource<T> resource;
    for (resource = paramResource; iterator.hasNext(); resource = resource1) {
      Resource<T> resource1 = ((Transformation<T>)iterator.next()).a(paramContext, resource, paramInt1, paramInt2);
      if (resource != null && !resource.equals(paramResource) && !resource.equals(resource1))
        resource.c(); 
    } 
    return resource;
  }
  
  public void a(MessageDigest paramMessageDigest) {
    Iterator<? extends Transformation<T>> iterator = this.b.iterator();
    while (iterator.hasNext())
      ((Transformation)iterator.next()).a(paramMessageDigest); 
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject instanceof MultiTransformation) {
      paramObject = paramObject;
      return this.b.equals(((MultiTransformation)paramObject).b);
    } 
    return false;
  }
  
  public int hashCode() {
    return this.b.hashCode();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\MultiTransformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */