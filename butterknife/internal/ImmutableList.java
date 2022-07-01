package butterknife.internal;

import java.util.AbstractList;
import java.util.RandomAccess;

final class ImmutableList<T> extends AbstractList<T> implements RandomAccess {
  private final T[] a;
  
  public boolean contains(Object paramObject) {
    T[] arrayOfT = this.a;
    int j = arrayOfT.length;
    for (int i = 0; i < j; i++) {
      if (arrayOfT[i] == paramObject)
        return true; 
    } 
    return false;
  }
  
  public T get(int paramInt) {
    return this.a[paramInt];
  }
  
  public int size() {
    return this.a.length;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\butterknife\internal\ImmutableList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */