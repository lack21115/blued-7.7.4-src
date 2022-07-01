package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

public class SimpleResource<T> implements Resource<T> {
  protected final T a;
  
  public SimpleResource(T paramT) {
    this.a = (T)Preconditions.a(paramT);
  }
  
  public Class<T> a() {
    return (Class)this.a.getClass();
  }
  
  public final int b() {
    return 1;
  }
  
  public void c() {}
  
  public final T f() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\SimpleResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */