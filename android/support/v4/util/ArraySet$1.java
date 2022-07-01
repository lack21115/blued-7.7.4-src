package android.support.v4.util;

import java.util.Map;

final class ArraySet$1 extends MapCollections {
  protected final void colClear() {
    ArraySet.this.clear();
  }
  
  protected final Object colGetEntry(int paramInt1, int paramInt2) {
    return ArraySet.this.mArray[paramInt1];
  }
  
  protected final Map colGetMap() {
    throw new UnsupportedOperationException("not a map");
  }
  
  protected final int colGetSize() {
    return ArraySet.this.mSize;
  }
  
  protected final int colIndexOfKey(Object paramObject) {
    return ArraySet.this.indexOf(paramObject);
  }
  
  protected final int colIndexOfValue(Object paramObject) {
    return ArraySet.this.indexOf(paramObject);
  }
  
  protected final void colPut(Object paramObject1, Object paramObject2) {
    ArraySet.this.add(paramObject1);
  }
  
  protected final void colRemoveAt(int paramInt) {
    ArraySet.this.removeAt(paramInt);
  }
  
  protected final Object colSetValue(int paramInt, Object paramObject) {
    throw new UnsupportedOperationException("not a map");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v\\util\ArraySet$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */