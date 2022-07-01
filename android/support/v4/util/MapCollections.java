package android.support.v4.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class MapCollections {
  MapCollections$EntrySet mEntrySet;
  
  private MapCollections$KeySet mKeySet;
  
  MapCollections$ValuesCollection mValues;
  
  public static boolean equalsSetHelper(Set paramSet, Object paramObject) {
    if (paramSet == paramObject)
      return true; 
    if (paramObject instanceof Set) {
      paramObject = paramObject;
      try {
        if (paramSet.size() == paramObject.size()) {
          boolean bool = paramSet.containsAll((Collection<?>)paramObject);
          if (bool)
            return true; 
        } 
        return false;
      } catch (NullPointerException nullPointerException) {
        return false;
      } catch (ClassCastException classCastException) {
        return false;
      } 
    } 
    return false;
  }
  
  public static boolean retainAllHelper(Map paramMap, Collection paramCollection) {
    int i = paramMap.size();
    Iterator iterator = paramMap.keySet().iterator();
    while (iterator.hasNext()) {
      if (!paramCollection.contains(iterator.next()))
        iterator.remove(); 
    } 
    return (i != paramMap.size());
  }
  
  protected abstract void colClear();
  
  protected abstract Object colGetEntry(int paramInt1, int paramInt2);
  
  protected abstract Map colGetMap();
  
  protected abstract int colGetSize();
  
  protected abstract int colIndexOfKey(Object paramObject);
  
  protected abstract int colIndexOfValue(Object paramObject);
  
  protected abstract void colPut(Object paramObject1, Object paramObject2);
  
  protected abstract void colRemoveAt(int paramInt);
  
  protected abstract Object colSetValue(int paramInt, Object paramObject);
  
  public final Set getKeySet() {
    if (this.mKeySet == null)
      this.mKeySet = new MapCollections$KeySet(this); 
    return this.mKeySet;
  }
  
  public final Object[] toArrayHelper(int paramInt) {
    int j = colGetSize();
    Object[] arrayOfObject = new Object[j];
    for (int i = 0; i < j; i++)
      arrayOfObject[i] = colGetEntry(i, paramInt); 
    return arrayOfObject;
  }
  
  public final Object[] toArrayHelper(Object[] paramArrayOfObject, int paramInt) {
    int j = colGetSize();
    Object[] arrayOfObject = paramArrayOfObject;
    if (paramArrayOfObject.length < j)
      arrayOfObject = (Object[])Array.newInstance(paramArrayOfObject.getClass().getComponentType(), j); 
    for (int i = 0; i < j; i++)
      arrayOfObject[i] = colGetEntry(i, paramInt); 
    if (arrayOfObject.length > j)
      arrayOfObject[j] = null; 
    return arrayOfObject;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v\\util\MapCollections.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */