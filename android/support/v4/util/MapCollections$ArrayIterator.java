package android.support.v4.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class MapCollections$ArrayIterator implements Iterator {
  private boolean mCanRemove = false;
  
  private int mIndex;
  
  private int mOffset;
  
  private int mSize;
  
  MapCollections$ArrayIterator(int paramInt) {
    this.mOffset = paramInt;
    this.mSize = paramMapCollections.colGetSize();
  }
  
  public final boolean hasNext() {
    return (this.mIndex < this.mSize);
  }
  
  public final Object next() {
    if (hasNext()) {
      Object object = MapCollections.this.colGetEntry(this.mIndex, this.mOffset);
      this.mIndex++;
      this.mCanRemove = true;
      return object;
    } 
    throw new NoSuchElementException();
  }
  
  public final void remove() {
    if (this.mCanRemove) {
      this.mIndex--;
      this.mSize--;
      this.mCanRemove = false;
      MapCollections.this.colRemoveAt(this.mIndex);
      return;
    } 
    throw new IllegalStateException();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v\\util\MapCollections$ArrayIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */