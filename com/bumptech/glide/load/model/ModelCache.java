package com.bumptech.glide.load.model;

import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.util.Queue;

public class ModelCache<A, B> {
  private final LruCache<ModelKey<A>, B> a;
  
  public ModelCache() {
    this(250L);
  }
  
  public ModelCache(long paramLong) {
    this.a = new LruCache<ModelKey<A>, B>(this, paramLong) {
        protected void a(ModelCache.ModelKey<A> param1ModelKey, B param1B) {
          param1ModelKey.a();
        }
      };
  }
  
  public B a(A paramA, int paramInt1, int paramInt2) {
    ModelKey<A> modelKey = ModelKey.a(paramA, paramInt1, paramInt2);
    Object object = this.a.b(modelKey);
    modelKey.a();
    return (B)object;
  }
  
  public void a(A paramA, int paramInt1, int paramInt2, B paramB) {
    ModelKey<A> modelKey = ModelKey.a(paramA, paramInt1, paramInt2);
    this.a.b(modelKey, paramB);
  }
  
  static final class ModelKey<A> {
    private static final Queue<ModelKey<?>> a = Util.a(0);
    
    private int b;
    
    private int c;
    
    private A d;
    
    static <A> ModelKey<A> a(A param1A, int param1Int1, int param1Int2) {
      Queue<ModelKey<?>> queue;
      ModelKey<A> modelKey;
      synchronized (a) {
        ModelKey<A> modelKey1 = (ModelKey)a.poll();
        modelKey = modelKey1;
        if (modelKey1 == null)
          modelKey = new ModelKey(); 
        modelKey.b(param1A, param1Int1, param1Int2);
        return modelKey;
      } 
    }
    
    private void b(A param1A, int param1Int1, int param1Int2) {
      this.d = param1A;
      this.c = param1Int1;
      this.b = param1Int2;
    }
    
    public void a() {
      synchronized (a) {
        a.offer(this);
        return;
      } 
    }
    
    public boolean equals(Object param1Object) {
      boolean bool = param1Object instanceof ModelKey;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        param1Object = param1Object;
        bool1 = bool2;
        if (this.c == ((ModelKey)param1Object).c) {
          bool1 = bool2;
          if (this.b == ((ModelKey)param1Object).b) {
            bool1 = bool2;
            if (this.d.equals(((ModelKey)param1Object).d))
              bool1 = true; 
          } 
        } 
      } 
      return bool1;
    }
    
    public int hashCode() {
      return (this.b * 31 + this.c) * 31 + this.d.hashCode();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\model\ModelCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */