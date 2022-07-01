package com.bumptech.glide.provider;

import androidx.collection.ArrayMap;
import com.bumptech.glide.util.MultiClassKey;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ModelToResourceClassCache {
  private final AtomicReference<MultiClassKey> a = new AtomicReference<MultiClassKey>();
  
  private final ArrayMap<MultiClassKey, List<Class<?>>> b = new ArrayMap();
  
  public List<Class<?>> a(Class<?> paramClass1, Class<?> paramClass2, Class<?> paramClass3) {
    MultiClassKey multiClassKey = this.a.getAndSet(null);
    if (multiClassKey == null) {
      null = new MultiClassKey(paramClass1, paramClass2, paramClass3);
    } else {
      multiClassKey.a((Class)null, paramClass2, paramClass3);
      null = multiClassKey;
    } 
    synchronized (this.b) {
      List<Class<?>> list = (List)this.b.get(null);
      this.a.set(null);
      return list;
    } 
  }
  
  public void a(Class<?> paramClass1, Class<?> paramClass2, Class<?> paramClass3, List<Class<?>> paramList) {
    synchronized (this.b) {
      this.b.put(new MultiClassKey(paramClass1, paramClass2, paramClass3), paramList);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\provider\ModelToResourceClassCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */