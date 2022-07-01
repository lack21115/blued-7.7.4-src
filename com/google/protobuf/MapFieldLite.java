package com.google.protobuf;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class MapFieldLite<K, V> extends LinkedHashMap<K, V> {
  private static final MapFieldLite EMPTY_MAP_FIELD = new MapFieldLite();
  
  private boolean isMutable = true;
  
  static {
    EMPTY_MAP_FIELD.makeImmutable();
  }
  
  private MapFieldLite() {}
  
  private MapFieldLite(Map<K, V> paramMap) {
    super(paramMap);
  }
  
  static <K, V> int calculateHashCodeForMap(Map<K, V> paramMap) {
    Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
    int i;
    for (i = 0; iterator.hasNext(); i += calculateHashCodeForObject(entry.getValue()) ^ j) {
      Map.Entry entry = iterator.next();
      int j = calculateHashCodeForObject(entry.getKey());
    } 
    return i;
  }
  
  private static int calculateHashCodeForObject(Object paramObject) {
    if (paramObject instanceof byte[])
      return Internal.hashCode((byte[])paramObject); 
    if (!(paramObject instanceof Internal.EnumLite))
      return paramObject.hashCode(); 
    throw new UnsupportedOperationException();
  }
  
  private static void checkForNullKeysAndValues(Map<?, ?> paramMap) {
    for (Object object : paramMap.keySet()) {
      Internal.checkNotNull(object);
      Internal.checkNotNull(paramMap.get(object));
    } 
  }
  
  private static Object copy(Object paramObject) {
    Object object = paramObject;
    if (paramObject instanceof byte[]) {
      paramObject = paramObject;
      object = Arrays.copyOf((byte[])paramObject, paramObject.length);
    } 
    return object;
  }
  
  static <K, V> Map<K, V> copy(Map<K, V> paramMap) {
    LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
    for (Map.Entry<K, V> entry : paramMap.entrySet())
      linkedHashMap.put(entry.getKey(), copy(entry.getValue())); 
    return (Map)linkedHashMap;
  }
  
  public static <K, V> MapFieldLite<K, V> emptyMapField() {
    return EMPTY_MAP_FIELD;
  }
  
  private void ensureMutable() {
    if (isMutable())
      return; 
    throw new UnsupportedOperationException();
  }
  
  private static boolean equals(Object paramObject1, Object paramObject2) {
    return (paramObject1 instanceof byte[] && paramObject2 instanceof byte[]) ? Arrays.equals((byte[])paramObject1, (byte[])paramObject2) : paramObject1.equals(paramObject2);
  }
  
  static <K, V> boolean equals(Map<K, V> paramMap1, Map<K, V> paramMap2) {
    if (paramMap1 == paramMap2)
      return true; 
    if (paramMap1.size() != paramMap2.size())
      return false; 
    for (Map.Entry<K, V> entry : paramMap1.entrySet()) {
      if (!paramMap2.containsKey(entry.getKey()))
        return false; 
      if (!equals(entry.getValue(), paramMap2.get(entry.getKey())))
        return false; 
    } 
    return true;
  }
  
  public void clear() {
    ensureMutable();
    super.clear();
  }
  
  public Set<Map.Entry<K, V>> entrySet() {
    return isEmpty() ? Collections.emptySet() : super.entrySet();
  }
  
  public boolean equals(Object paramObject) {
    return (paramObject instanceof Map && equals(this, (Map<?, ?>)paramObject));
  }
  
  public int hashCode() {
    return calculateHashCodeForMap(this);
  }
  
  public boolean isMutable() {
    return this.isMutable;
  }
  
  public void makeImmutable() {
    this.isMutable = false;
  }
  
  public void mergeFrom(MapFieldLite<K, V> paramMapFieldLite) {
    ensureMutable();
    if (!paramMapFieldLite.isEmpty())
      putAll(paramMapFieldLite); 
  }
  
  public MapFieldLite<K, V> mutableCopy() {
    return isEmpty() ? new MapFieldLite() : new MapFieldLite(this);
  }
  
  public V put(K paramK, V paramV) {
    ensureMutable();
    Internal.checkNotNull(paramK);
    Internal.checkNotNull(paramV);
    return super.put(paramK, paramV);
  }
  
  public V put(Map.Entry<K, V> paramEntry) {
    return put(paramEntry.getKey(), paramEntry.getValue());
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap) {
    ensureMutable();
    checkForNullKeysAndValues(paramMap);
    super.putAll(paramMap);
  }
  
  public V remove(Object paramObject) {
    ensureMutable();
    return super.remove(paramObject);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\MapFieldLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */