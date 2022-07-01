package com.google.devtools.build.android.desugar.runtime;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

final class ThrowableExtension$ConcurrentWeakIdentityHashMap {
  private final ConcurrentHashMap map = new ConcurrentHashMap<Object, Object>(16, 0.75F, 10);
  
  private final ReferenceQueue referenceQueue = new ReferenceQueue();
  
  public final List get(Throwable paramThrowable, boolean paramBoolean) {
    while (true) {
      Reference reference = this.referenceQueue.poll();
      if (reference != null) {
        this.map.remove(reference);
        continue;
      } 
      reference = new ThrowableExtension$ConcurrentWeakIdentityHashMap$WeakKey(paramThrowable, null);
      List list2 = (List)this.map.get(reference);
      if (!paramBoolean)
        return list2; 
      if (list2 != null)
        return list2; 
      list2 = new Vector(2);
      List list1 = this.map.putIfAbsent(new ThrowableExtension$ConcurrentWeakIdentityHashMap$WeakKey(paramThrowable, this.referenceQueue), list2);
      return (list1 == null) ? list2 : list1;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\devtools\build\android\desugar\runtime\ThrowableExtension$ConcurrentWeakIdentityHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */