package android.support.v4.util;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.Set;

public class ArrayMap extends SimpleArrayMap implements Map {
  private MapCollections mCollections;
  
  public ArrayMap() {}
  
  public ArrayMap(int paramInt) {
    super(paramInt);
  }
  
  private MapCollections getCollection() {
    if (this.mCollections == null)
      this.mCollections = new ArrayMap$1(this); 
    return this.mCollections;
  }
  
  public Set entrySet() {
    MapCollections mapCollections = getCollection();
    if (mapCollections.mEntrySet == null)
      mapCollections.mEntrySet = new MapCollections$EntrySet(mapCollections); 
    return mapCollections.mEntrySet;
  }
  
  public Set keySet() {
    return getCollection().getKeySet();
  }
  
  public void putAll(Map paramMap) {
    int i = this.mSize + paramMap.size();
    int j = this.mSize;
    if (this.mHashes.length < i) {
      int[] arrayOfInt = this.mHashes;
      Object[] arrayOfObject = this.mArray;
      allocArrays(i);
      if (this.mSize > 0) {
        System.arraycopy(arrayOfInt, 0, this.mHashes, 0, j);
        System.arraycopy(arrayOfObject, 0, this.mArray, 0, j << 1);
      } 
      SimpleArrayMap.freeArrays(arrayOfInt, arrayOfObject, j);
    } 
    if (this.mSize == j) {
      for (Map.Entry entry : paramMap.entrySet())
        put(entry.getKey(), entry.getValue()); 
      return;
    } 
    throw new ConcurrentModificationException();
  }
  
  public Collection values() {
    MapCollections mapCollections = getCollection();
    if (mapCollections.mValues == null)
      mapCollections.mValues = new MapCollections$ValuesCollection(mapCollections); 
    return mapCollections.mValues;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v\\util\ArrayMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */