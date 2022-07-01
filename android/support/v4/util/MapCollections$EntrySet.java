package android.support.v4.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class MapCollections$EntrySet implements Set {
  public final boolean addAll(Collection paramCollection) {
    int i = MapCollections.this.colGetSize();
    for (Map.Entry entry : paramCollection)
      MapCollections.this.colPut(entry.getKey(), entry.getValue()); 
    return (i != MapCollections.this.colGetSize());
  }
  
  public final void clear() {
    MapCollections.this.colClear();
  }
  
  public final boolean contains(Object paramObject) {
    if (!(paramObject instanceof Map.Entry))
      return false; 
    paramObject = paramObject;
    int i = MapCollections.this.colIndexOfKey(paramObject.getKey());
    return (i < 0) ? false : ContainerHelpers.equal(MapCollections.this.colGetEntry(i, 1), paramObject.getValue());
  }
  
  public final boolean containsAll(Collection paramCollection) {
    Iterator iterator = paramCollection.iterator();
    while (iterator.hasNext()) {
      if (!contains(iterator.next()))
        return false; 
    } 
    return true;
  }
  
  public final boolean equals(Object paramObject) {
    return MapCollections.equalsSetHelper(this, paramObject);
  }
  
  public final int hashCode() {
    int i = MapCollections.this.colGetSize() - 1;
    int j = 0;
    while (i >= 0) {
      int k;
      int m;
      Object object1 = MapCollections.this.colGetEntry(i, 0);
      Object object2 = MapCollections.this.colGetEntry(i, 1);
      if (object1 == null) {
        k = 0;
      } else {
        k = object1.hashCode();
      } 
      if (object2 == null) {
        m = 0;
      } else {
        m = object2.hashCode();
      } 
      j += k ^ m;
      i--;
    } 
    return j;
  }
  
  public final boolean isEmpty() {
    return (MapCollections.this.colGetSize() == 0);
  }
  
  public final Iterator iterator() {
    return new MapCollections$MapIterator(MapCollections.this);
  }
  
  public final boolean remove(Object paramObject) {
    throw new UnsupportedOperationException();
  }
  
  public final boolean removeAll(Collection paramCollection) {
    throw new UnsupportedOperationException();
  }
  
  public final boolean retainAll(Collection paramCollection) {
    throw new UnsupportedOperationException();
  }
  
  public final int size() {
    return MapCollections.this.colGetSize();
  }
  
  public final Object[] toArray() {
    throw new UnsupportedOperationException();
  }
  
  public final Object[] toArray(Object[] paramArrayOfObject) {
    throw new UnsupportedOperationException();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v\\util\MapCollections$EntrySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */