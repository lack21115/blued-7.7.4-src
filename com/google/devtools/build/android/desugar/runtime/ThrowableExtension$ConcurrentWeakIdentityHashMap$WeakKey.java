package com.google.devtools.build.android.desugar.runtime;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class ThrowableExtension$ConcurrentWeakIdentityHashMap$WeakKey extends WeakReference {
  private final int hash;
  
  public ThrowableExtension$ConcurrentWeakIdentityHashMap$WeakKey(Throwable paramThrowable, ReferenceQueue<? super T> paramReferenceQueue) {
    super((T)paramThrowable, paramReferenceQueue);
    if (paramThrowable != null) {
      this.hash = System.identityHashCode(paramThrowable);
      return;
    } 
    throw new NullPointerException("The referent cannot be null");
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject != null) {
      if (paramObject.getClass() != getClass())
        return false; 
      if (this == paramObject)
        return true; 
      paramObject = paramObject;
      return (this.hash == ((ThrowableExtension$ConcurrentWeakIdentityHashMap$WeakKey)paramObject).hash && get() == paramObject.get());
    } 
    return false;
  }
  
  public final int hashCode() {
    return this.hash;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\devtools\build\android\desugar\runtime\ThrowableExtension$ConcurrentWeakIdentityHashMap$WeakKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */