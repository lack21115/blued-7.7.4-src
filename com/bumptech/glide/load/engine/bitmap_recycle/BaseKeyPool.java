package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.util.Util;
import java.util.Queue;

abstract class BaseKeyPool<T extends Poolable> {
  private final Queue<T> a = Util.a(20);
  
  public void a(T paramT) {
    if (this.a.size() < 20)
      this.a.offer(paramT); 
  }
  
  abstract T b();
  
  T c() {
    Poolable poolable2 = (Poolable)this.a.poll();
    Poolable poolable1 = poolable2;
    if (poolable2 == null)
      poolable1 = (Poolable)b(); 
    return (T)poolable1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\bitmap_recycle\BaseKeyPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */