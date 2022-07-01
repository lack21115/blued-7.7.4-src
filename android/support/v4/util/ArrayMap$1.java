package android.support.v4.util;

import java.util.Map;

final class ArrayMap$1 extends MapCollections {
  protected final void colClear() {
    ArrayMap.this.clear();
  }
  
  protected final Object colGetEntry(int paramInt1, int paramInt2) {
    return ArrayMap.this.mArray[(paramInt1 << 1) + paramInt2];
  }
  
  protected final Map colGetMap() {
    return ArrayMap.this;
  }
  
  protected final int colGetSize() {
    return ArrayMap.this.mSize;
  }
  
  protected final int colIndexOfKey(Object paramObject) {
    return ArrayMap.this.indexOfKey(paramObject);
  }
  
  protected final int colIndexOfValue(Object paramObject) {
    return ArrayMap.this.indexOfValue(paramObject);
  }
  
  protected final void colPut(Object paramObject1, Object paramObject2) {
    ArrayMap.this.put(paramObject1, paramObject2);
  }
  
  protected final void colRemoveAt(int paramInt) {
    ArrayMap.this.removeAt(paramInt);
  }
  
  protected final Object colSetValue(int paramInt, Object paramObject) {
    ArrayMap arrayMap = ArrayMap.this;
    paramInt = (paramInt << 1) + 1;
    Object object = arrayMap.mArray[paramInt];
    arrayMap.mArray[paramInt] = paramObject;
    return object;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v\\util\ArrayMap$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */