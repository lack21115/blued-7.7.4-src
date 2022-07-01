package com.bumptech.glide.provider;

import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.UnitTranscoder;
import com.bumptech.glide.util.MultiClassKey;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

public class LoadPathCache {
  private static final LoadPath<?, ?, ?> a = new LoadPath(Object.class, Object.class, Object.class, Collections.singletonList(new DecodePath(Object.class, Object.class, Object.class, Collections.emptyList(), (ResourceTranscoder)new UnitTranscoder(), null)), null);
  
  private final ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> b = new ArrayMap();
  
  private final AtomicReference<MultiClassKey> c = new AtomicReference<MultiClassKey>();
  
  private MultiClassKey b(Class<?> paramClass1, Class<?> paramClass2, Class<?> paramClass3) {
    MultiClassKey multiClassKey2 = this.c.getAndSet(null);
    MultiClassKey multiClassKey1 = multiClassKey2;
    if (multiClassKey2 == null)
      multiClassKey1 = new MultiClassKey(); 
    multiClassKey1.a(paramClass1, paramClass2, paramClass3);
    return multiClassKey1;
  }
  
  public <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> a(Class<Data> paramClass, Class<TResource> paramClass1, Class<Transcode> paramClass2) {
    null = b(paramClass, paramClass1, paramClass2);
    synchronized (this.b) {
      LoadPath<Data, TResource, Transcode> loadPath = (LoadPath)this.b.get(null);
      this.c.set(null);
      return loadPath;
    } 
  }
  
  public void a(Class<?> paramClass1, Class<?> paramClass2, Class<?> paramClass3, LoadPath<?, ?, ?> paramLoadPath) {
    synchronized (this.b) {
      ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> arrayMap = this.b;
      MultiClassKey multiClassKey = new MultiClassKey(paramClass1, paramClass2, paramClass3);
      if (paramLoadPath == null)
        paramLoadPath = a; 
      arrayMap.put(multiClassKey, paramLoadPath);
      return;
    } 
  }
  
  public boolean a(LoadPath<?, ?, ?> paramLoadPath) {
    return a.equals(paramLoadPath);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\provider\LoadPathCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */