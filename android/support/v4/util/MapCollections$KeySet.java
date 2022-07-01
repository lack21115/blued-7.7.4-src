package android.support.v4.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class MapCollections$KeySet implements Set {
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
    return (MapCollections.this.colIndexOfKey(paramObject) >= 0);
  }
  
  public final boolean containsAll(Collection paramCollection) {
    Map map = MapCollections.this.colGetMap();
    Iterator iterator = paramCollection.iterator();
    while (iterator.hasNext()) {
      if (!map.containsKey(iterator.next()))
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
      Object object = MapCollections.this.colGetEntry(i, 0);
      if (object == null) {
        k = 0;
      } else {
        k = object.hashCode();
      } 
      j += k;
      i--;
    } 
    return j;
  }
  
  public final boolean isEmpty() {
    return (MapCollections.this.colGetSize() == 0);
  }
  
  public final Iterator iterator() {
    return new MapCollections$ArrayIterator(MapCollections.this, 0);
  }
  
  public final boolean remove(Object paramObject) {
    int i = MapCollections.this.colIndexOfKey(paramObject);
    if (i >= 0) {
      MapCollections.this.colRemoveAt(i);
      return true;
    } 
    return false;
  }
  
  public final boolean removeAll(Collection paramCollection) {
    Map map = MapCollections.this.colGetMap();
    int i = map.size();
    Iterator iterator = paramCollection.iterator();
    while (iterator.hasNext())
      map.remove(iterator.next()); 
    return (i != map.size());
  }
  
  public final boolean retainAll(Collection paramCollection) {
    return MapCollections.retainAllHelper(MapCollections.this.colGetMap(), paramCollection);
  }
  
  public final int size() {
    return MapCollections.this.colGetSize();
  }
  
  public final Object[] toArray() {
    return MapCollections.this.toArrayHelper(0);
  }
  
  public final Object[] toArray(Object[] paramArrayOfObject) {
    return MapCollections.this.toArrayHelper(paramArrayOfObject, 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v\\util\MapCollections$KeySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */