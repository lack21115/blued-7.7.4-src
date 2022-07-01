package com.blued.android.core.imagecache;

import android.util.SparseArray;
import java.lang.ref.WeakReference;

public class MemoryRequest {
  private SparseArray<WeakReference<MemoryListener>> a = new SparseArray();
  
  public static MemoryRequest a() {
    return SingletonCreator.a();
  }
  
  public void a(int paramInt) {
    RecyclingImageLoader.a(paramInt);
  }
  
  public void a(MemoryListener paramMemoryListener) {
    if (paramMemoryListener != null)
      this.a.put(paramMemoryListener.hashCode(), new WeakReference<MemoryListener>(paramMemoryListener)); 
  }
  
  public void b() {
    RecyclingImageLoader.d();
    for (int i = 0; i < this.a.size(); i++) {
      MemoryListener memoryListener = ((WeakReference<MemoryListener>)this.a.valueAt(i)).get();
      if (memoryListener != null)
        memoryListener.a(); 
    } 
    System.gc();
  }
  
  public void b(MemoryListener paramMemoryListener) {
    if (paramMemoryListener != null)
      this.a.remove(paramMemoryListener.hashCode()); 
  }
  
  public static interface MemoryListener {
    void a();
  }
  
  static class SingletonCreator {
    private static final MemoryRequest a = new MemoryRequest();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imagecache\MemoryRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */