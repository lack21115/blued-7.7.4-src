package com.j256.ormlite.dao;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LruObjectCache implements ObjectCache {
  private final int capacity;
  
  private final ConcurrentHashMap<Class<?>, Map<Object, Object>> classMaps = new ConcurrentHashMap<Class<?>, Map<Object, Object>>();
  
  public LruObjectCache(int paramInt) {
    this.capacity = paramInt;
  }
  
  private Map<Object, Object> getMapForClass(Class<?> paramClass) {
    Map<Object, Object> map2 = this.classMaps.get(paramClass);
    Map<Object, Object> map1 = map2;
    if (map2 == null)
      map1 = null; 
    return map1;
  }
  
  public <T> void clear(Class<T> paramClass) {
    Map<Object, Object> map = getMapForClass(paramClass);
    if (map != null)
      map.clear(); 
  }
  
  public void clearAll() {
    Iterator<Map> iterator = this.classMaps.values().iterator();
    while (iterator.hasNext())
      ((Map)iterator.next()).clear(); 
  }
  
  public <T, ID> T get(Class<T> paramClass, ID paramID) {
    Map<Object, Object> map = getMapForClass(paramClass);
    return (T)((map == null) ? null : map.get(paramID));
  }
  
  public <T, ID> void put(Class<T> paramClass, ID paramID, T paramT) {
    Map<Object, Object> map = getMapForClass(paramClass);
    if (map != null)
      map.put(paramID, paramT); 
  }
  
  public <T> void registerClass(Class<T> paramClass) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield classMaps : Ljava/util/concurrent/ConcurrentHashMap;
    //   6: aload_1
    //   7: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast java/util/Map
    //   13: ifnonnull -> 41
    //   16: new com/j256/ormlite/dao/LruObjectCache$LimitedLinkedHashMap
    //   19: dup
    //   20: aload_0
    //   21: getfield capacity : I
    //   24: invokespecial <init> : (I)V
    //   27: invokestatic synchronizedMap : (Ljava/util/Map;)Ljava/util/Map;
    //   30: astore_2
    //   31: aload_0
    //   32: getfield classMaps : Ljava/util/concurrent/ConcurrentHashMap;
    //   35: aload_1
    //   36: aload_2
    //   37: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   40: pop
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Exception table:
    //   from	to	target	type
    //   2	41	44	finally
  }
  
  public <T, ID> void remove(Class<T> paramClass, ID paramID) {
    Map<Object, Object> map = getMapForClass(paramClass);
    if (map != null)
      map.remove(paramID); 
  }
  
  public <T> int size(Class<T> paramClass) {
    Map<Object, Object> map = getMapForClass(paramClass);
    return (map == null) ? 0 : map.size();
  }
  
  public int sizeAll() {
    Iterator<Map> iterator = this.classMaps.values().iterator();
    int i;
    for (i = 0; iterator.hasNext(); i += ((Map)iterator.next()).size());
    return i;
  }
  
  public <T, ID> T updateId(Class<T> paramClass, ID paramID1, ID paramID2) {
    Map<Object, Object> map = getMapForClass(paramClass);
    if (map == null)
      return null; 
    paramID1 = (ID)map.remove(paramID1);
    if (paramID1 == null)
      return null; 
    map.put(paramID2, paramID1);
    return (T)paramID1;
  }
  
  static class LimitedLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    private static final long serialVersionUID = -4566528080395573236L;
    
    private final int capacity;
    
    public LimitedLinkedHashMap(int param1Int) {
      super(param1Int, 0.75F, true);
      this.capacity = param1Int;
    }
    
    protected boolean removeEldestEntry(Map.Entry<K, V> param1Entry) {
      return (size() > this.capacity);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\dao\LruObjectCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */