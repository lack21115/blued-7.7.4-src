package android.arch.core.internal;

import java.util.HashMap;

public final class FastSafeIterableMap extends SafeIterableMap {
  private HashMap mHashMap = new HashMap<Object, Object>();
  
  public final boolean contains(Object paramObject) {
    return this.mHashMap.containsKey(paramObject);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\arch\core\internal\FastSafeIterableMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */