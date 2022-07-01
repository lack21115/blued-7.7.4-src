package android.arch.core.internal;

import java.util.Iterator;

public final class SafeIterableMap$IteratorWithAdditions implements Iterator {
  private boolean mBeforeStart = true;
  
  private SafeIterableMap$Entry mCurrent;
  
  private SafeIterableMap$IteratorWithAdditions() {}
  
  public final boolean hasNext() {
    return this.mBeforeStart ? ((SafeIterableMap.access$100(SafeIterableMap.this) != null)) : ((this.mCurrent != null && this.mCurrent.mNext != null));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\arch\core\internal\SafeIterableMap$IteratorWithAdditions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */