package android.support.v4.util;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

final class MapCollections$MapIterator implements Iterator, Map.Entry {
  private int mEnd;
  
  private boolean mEntryValid = false;
  
  private int mIndex;
  
  MapCollections$MapIterator() {
    this.mEnd = paramMapCollections.colGetSize() - 1;
    this.mIndex = -1;
  }
  
  public final boolean equals(Object paramObject) {
    if (this.mEntryValid) {
      if (!(paramObject instanceof Map.Entry))
        return false; 
      paramObject = paramObject;
      return (ContainerHelpers.equal(paramObject.getKey(), MapCollections.this.colGetEntry(this.mIndex, 0)) && ContainerHelpers.equal(paramObject.getValue(), MapCollections.this.colGetEntry(this.mIndex, 1)));
    } 
    throw new IllegalStateException("This container does not support retaining Map.Entry objects");
  }
  
  public final Object getKey() {
    if (this.mEntryValid)
      return MapCollections.this.colGetEntry(this.mIndex, 0); 
    throw new IllegalStateException("This container does not support retaining Map.Entry objects");
  }
  
  public final Object getValue() {
    if (this.mEntryValid)
      return MapCollections.this.colGetEntry(this.mIndex, 1); 
    throw new IllegalStateException("This container does not support retaining Map.Entry objects");
  }
  
  public final boolean hasNext() {
    return (this.mIndex < this.mEnd);
  }
  
  public final int hashCode() {
    if (this.mEntryValid) {
      MapCollections mapCollections = MapCollections.this;
      int i = this.mIndex;
      int j = 0;
      Object object1 = mapCollections.colGetEntry(i, 0);
      Object object2 = MapCollections.this.colGetEntry(this.mIndex, 1);
      if (object1 == null) {
        i = 0;
      } else {
        i = object1.hashCode();
      } 
      if (object2 != null)
        j = object2.hashCode(); 
      return i ^ j;
    } 
    throw new IllegalStateException("This container does not support retaining Map.Entry objects");
  }
  
  public final void remove() {
    if (this.mEntryValid) {
      MapCollections.this.colRemoveAt(this.mIndex);
      this.mIndex--;
      this.mEnd--;
      this.mEntryValid = false;
      return;
    } 
    throw new IllegalStateException();
  }
  
  public final Object setValue(Object paramObject) {
    if (this.mEntryValid)
      return MapCollections.this.colSetValue(this.mIndex, paramObject); 
    throw new IllegalStateException("This container does not support retaining Map.Entry objects");
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getKey());
    stringBuilder.append("=");
    stringBuilder.append(getValue());
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v\\util\MapCollections$MapIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */