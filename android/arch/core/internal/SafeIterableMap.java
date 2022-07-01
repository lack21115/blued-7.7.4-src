package android.arch.core.internal;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class SafeIterableMap implements Iterable {
  public SafeIterableMap$Entry mEnd;
  
  public WeakHashMap mIterators = new WeakHashMap<Object, Object>();
  
  public int mSize = 0;
  
  public SafeIterableMap$Entry mStart;
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof SafeIterableMap))
      return false; 
    SafeIterableMap safeIterableMap = (SafeIterableMap)paramObject;
    if (this.mSize != safeIterableMap.mSize)
      return false; 
    paramObject = iterator();
    Iterator<Object> iterator = safeIterableMap.iterator();
    while (paramObject.hasNext() && iterator.hasNext()) {
      Map.Entry entry = paramObject.next();
      Object object = iterator.next();
      if ((entry == null && object != null) || (entry != null && !entry.equals(object)))
        return false; 
    } 
    return (!paramObject.hasNext() && !iterator.hasNext());
  }
  
  public Iterator iterator() {
    SafeIterableMap$AscendingIterator safeIterableMap$AscendingIterator = new SafeIterableMap$AscendingIterator(this.mStart, this.mEnd);
    this.mIterators.put(safeIterableMap$AscendingIterator, Boolean.valueOf(false));
    return safeIterableMap$AscendingIterator;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");
    Iterator<Map.Entry> iterator = iterator();
    while (iterator.hasNext()) {
      stringBuilder.append(((Map.Entry)iterator.next()).toString());
      if (iterator.hasNext())
        stringBuilder.append(", "); 
    } 
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\arch\core\internal\SafeIterableMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */