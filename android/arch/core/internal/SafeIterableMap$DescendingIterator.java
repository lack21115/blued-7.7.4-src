package android.arch.core.internal;

public final class SafeIterableMap$DescendingIterator extends SafeIterableMap$ListIterator {
  public SafeIterableMap$DescendingIterator(SafeIterableMap$Entry paramSafeIterableMap$Entry1, SafeIterableMap$Entry paramSafeIterableMap$Entry2) {
    super(paramSafeIterableMap$Entry1, paramSafeIterableMap$Entry2);
  }
  
  final SafeIterableMap$Entry forward(SafeIterableMap$Entry paramSafeIterableMap$Entry) {
    return paramSafeIterableMap$Entry.mPrevious;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\arch\core\internal\SafeIterableMap$DescendingIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */