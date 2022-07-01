package android.support.v4.util;

import java.util.Collection;
import java.util.Iterator;

final class MapCollections$ValuesCollection implements Collection {
  public final boolean add(Object paramObject) {
    throw new UnsupportedOperationException();
  }
  
  public final boolean addAll(Collection paramCollection) {
    throw new UnsupportedOperationException();
  }
  
  public final void clear() {
    MapCollections.this.colClear();
  }
  
  public final boolean contains(Object paramObject) {
    return (MapCollections.this.colIndexOfValue(paramObject) >= 0);
  }
  
  public final boolean containsAll(Collection paramCollection) {
    Iterator iterator = paramCollection.iterator();
    while (iterator.hasNext()) {
      if (!contains(iterator.next()))
        return false; 
    } 
    return true;
  }
  
  public final boolean isEmpty() {
    return (MapCollections.this.colGetSize() == 0);
  }
  
  public final Iterator iterator() {
    return new MapCollections$ArrayIterator(MapCollections.this, 1);
  }
  
  public final boolean remove(Object paramObject) {
    int i = MapCollections.this.colIndexOfValue(paramObject);
    if (i >= 0) {
      MapCollections.this.colRemoveAt(i);
      return true;
    } 
    return false;
  }
  
  public final boolean removeAll(Collection paramCollection) {
    int j = MapCollections.this.colGetSize();
    int i = 0;
    boolean bool = false;
    while (i < j) {
      int k = j;
      int m = i;
      if (paramCollection.contains(MapCollections.this.colGetEntry(i, 1))) {
        MapCollections.this.colRemoveAt(i);
        m = i - 1;
        k = j - 1;
        bool = true;
      } 
      i = m + 1;
      j = k;
    } 
    return bool;
  }
  
  public final boolean retainAll(Collection paramCollection) {
    int j = MapCollections.this.colGetSize();
    int i = 0;
    boolean bool = false;
    while (i < j) {
      int k = j;
      int m = i;
      if (!paramCollection.contains(MapCollections.this.colGetEntry(i, 1))) {
        MapCollections.this.colRemoveAt(i);
        m = i - 1;
        k = j - 1;
        bool = true;
      } 
      i = m + 1;
      j = k;
    } 
    return bool;
  }
  
  public final int size() {
    return MapCollections.this.colGetSize();
  }
  
  public final Object[] toArray() {
    return MapCollections.this.toArrayHelper(1);
  }
  
  public final Object[] toArray(Object[] paramArrayOfObject) {
    return MapCollections.this.toArrayHelper(paramArrayOfObject, 1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v\\util\MapCollections$ValuesCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */