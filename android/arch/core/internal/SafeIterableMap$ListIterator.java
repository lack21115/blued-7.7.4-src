package android.arch.core.internal;

import java.util.Iterator;

abstract class SafeIterableMap$ListIterator implements Iterator {
  private SafeIterableMap$Entry mExpectedEnd;
  
  private SafeIterableMap$Entry mNext;
  
  SafeIterableMap$ListIterator(SafeIterableMap$Entry paramSafeIterableMap$Entry1, SafeIterableMap$Entry paramSafeIterableMap$Entry2) {
    this.mExpectedEnd = paramSafeIterableMap$Entry2;
    this.mNext = paramSafeIterableMap$Entry1;
  }
  
  abstract SafeIterableMap$Entry forward(SafeIterableMap$Entry paramSafeIterableMap$Entry);
  
  public boolean hasNext() {
    return (this.mNext != null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\arch\core\internal\SafeIterableMap$ListIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */