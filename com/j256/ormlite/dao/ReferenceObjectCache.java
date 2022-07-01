package com.j256.ormlite.dao;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReferenceObjectCache implements ObjectCache {
  private final ConcurrentHashMap<Class<?>, Map<Object, Reference<Object>>> classMaps = new ConcurrentHashMap<Class<?>, Map<Object, Reference<Object>>>();
  
  private final boolean useWeak;
  
  public ReferenceObjectCache(boolean paramBoolean) {
    this.useWeak = paramBoolean;
  }
  
  private void cleanMap(Map<Object, Reference<Object>> paramMap) {
    Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
    while (iterator.hasNext()) {
      if (((Reference)((Map.Entry)iterator.next()).getValue()).get() == null)
        iterator.remove(); 
    } 
  }
  
  private Map<Object, Reference<Object>> getMapForClass(Class<?> paramClass) {
    Map<Object, Reference<Object>> map2 = this.classMaps.get(paramClass);
    Map<Object, Reference<Object>> map1 = map2;
    if (map2 == null)
      map1 = null; 
    return map1;
  }
  
  public static ReferenceObjectCache makeSoftCache() {
    return new ReferenceObjectCache(false);
  }
  
  public static ReferenceObjectCache makeWeakCache() {
    return new ReferenceObjectCache(true);
  }
  
  public <T> void cleanNullReferences(Class<T> paramClass) {
    Map<Object, Reference<Object>> map = getMapForClass(paramClass);
    if (map != null)
      cleanMap(map); 
  }
  
  public <T> void cleanNullReferencesAll() {
    Iterator<Map<Object, Reference<Object>>> iterator = this.classMaps.values().iterator();
    while (iterator.hasNext())
      cleanMap(iterator.next()); 
  }
  
  public <T> void clear(Class<T> paramClass) {
    Map<Object, Reference<Object>> map = getMapForClass(paramClass);
    if (map != null)
      map.clear(); 
  }
  
  public void clearAll() {
    Iterator<Map> iterator = this.classMaps.values().iterator();
    while (iterator.hasNext())
      ((Map)iterator.next()).clear(); 
  }
  
  public <T, ID> T get(Class<T> paramClass, ID paramID) {
    Map<Object, Reference<Object>> map = getMapForClass(paramClass);
    if (map == null)
      return null; 
    Reference<Reference> reference = (Reference)map.get(paramID);
    if (reference == null)
      return null; 
    reference = reference.get();
    if (reference == null) {
      map.remove(paramID);
      return null;
    } 
    return (T)reference;
  }
  
  public <T, ID> void put(Class<T> paramClass, ID paramID, T paramT) {
    Map<Object, Reference<Object>> map = getMapForClass(paramClass);
    if (map != null) {
      if (this.useWeak) {
        map.put(paramID, new WeakReference(paramT));
        return;
      } 
      map.put(paramID, new SoftReference(paramT));
    } 
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
    //   13: ifnonnull -> 34
    //   16: new java/util/concurrent/ConcurrentHashMap
    //   19: dup
    //   20: invokespecial <init> : ()V
    //   23: astore_2
    //   24: aload_0
    //   25: getfield classMaps : Ljava/util/concurrent/ConcurrentHashMap;
    //   28: aload_1
    //   29: aload_2
    //   30: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   33: pop
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   2	34	37	finally
  }
  
  public <T, ID> void remove(Class<T> paramClass, ID paramID) {
    Map<Object, Reference<Object>> map = getMapForClass(paramClass);
    if (map != null)
      map.remove(paramID); 
  }
  
  public <T> int size(Class<T> paramClass) {
    Map<Object, Reference<Object>> map = getMapForClass(paramClass);
    return (map == null) ? 0 : map.size();
  }
  
  public int sizeAll() {
    Iterator<Map> iterator = this.classMaps.values().iterator();
    int i;
    for (i = 0; iterator.hasNext(); i += ((Map)iterator.next()).size());
    return i;
  }
  
  public <T, ID> T updateId(Class<T> paramClass, ID paramID1, ID paramID2) {
    Map<Object, Reference<Object>> map = getMapForClass(paramClass);
    if (map == null)
      return null; 
    Reference<Object> reference = map.remove(paramID1);
    if (reference == null)
      return null; 
    map.put(paramID2, reference);
    return (T)reference.get();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\dao\ReferenceObjectCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */