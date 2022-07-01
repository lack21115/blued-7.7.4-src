package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapField<K, V> implements MutabilityOracle {
  private final Converter<K, V> converter;
  
  private volatile boolean isMutable;
  
  private List<Message> listData;
  
  private MutatabilityAwareMap<K, V> mapData;
  
  private volatile StorageMode mode;
  
  private MapField(MapEntry<K, V> paramMapEntry, StorageMode paramStorageMode, Map<K, V> paramMap) {
    this(new ImmutableMessageConverter<K, V>(paramMapEntry), paramStorageMode, paramMap);
  }
  
  private MapField(Converter<K, V> paramConverter, StorageMode paramStorageMode, Map<K, V> paramMap) {
    this.converter = paramConverter;
    this.isMutable = true;
    this.mode = paramStorageMode;
    this.mapData = new MutatabilityAwareMap<K, V>(this, paramMap);
    this.listData = null;
  }
  
  private Message convertKeyAndValueToMessage(K paramK, V paramV) {
    return this.converter.convertKeyAndValueToMessage(paramK, paramV);
  }
  
  private MutatabilityAwareMap<K, V> convertListToMap(List<Message> paramList) {
    LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
    Iterator<Message> iterator = paramList.iterator();
    while (iterator.hasNext())
      convertMessageToKeyAndValue(iterator.next(), (Map)linkedHashMap); 
    return new MutatabilityAwareMap<K, V>(this, (Map)linkedHashMap);
  }
  
  private List<Message> convertMapToList(MutatabilityAwareMap<K, V> paramMutatabilityAwareMap) {
    ArrayList<Message> arrayList = new ArrayList();
    for (Map.Entry<K, V> entry : paramMutatabilityAwareMap.entrySet())
      arrayList.add(convertKeyAndValueToMessage((K)entry.getKey(), (V)entry.getValue())); 
    return arrayList;
  }
  
  private void convertMessageToKeyAndValue(Message paramMessage, Map<K, V> paramMap) {
    this.converter.convertMessageToKeyAndValue(paramMessage, paramMap);
  }
  
  public static <K, V> MapField<K, V> emptyMapField(MapEntry<K, V> paramMapEntry) {
    return new MapField<K, V>(paramMapEntry, StorageMode.MAP, Collections.emptyMap());
  }
  
  public static <K, V> MapField<K, V> newMapField(MapEntry<K, V> paramMapEntry) {
    return new MapField<K, V>(paramMapEntry, StorageMode.MAP, new LinkedHashMap<K, V>());
  }
  
  public void clear() {
    this.mapData = new MutatabilityAwareMap<K, V>(this, new LinkedHashMap<K, V>());
    this.mode = StorageMode.MAP;
  }
  
  public MapField<K, V> copy() {
    return new MapField(this.converter, StorageMode.MAP, MapFieldLite.copy(getMap()));
  }
  
  public void ensureMutable() {
    if (isMutable())
      return; 
    throw new UnsupportedOperationException();
  }
  
  public boolean equals(Object paramObject) {
    if (!(paramObject instanceof MapField))
      return false; 
    paramObject = paramObject;
    return MapFieldLite.equals(getMap(), paramObject.getMap());
  }
  
  List<Message> getList() {
    // Byte code:
    //   0: aload_0
    //   1: getfield mode : Lcom/google/protobuf/MapField$StorageMode;
    //   4: getstatic com/google/protobuf/MapField$StorageMode.MAP : Lcom/google/protobuf/MapField$StorageMode;
    //   7: if_acmpne -> 51
    //   10: aload_0
    //   11: monitorenter
    //   12: aload_0
    //   13: getfield mode : Lcom/google/protobuf/MapField$StorageMode;
    //   16: getstatic com/google/protobuf/MapField$StorageMode.MAP : Lcom/google/protobuf/MapField$StorageMode;
    //   19: if_acmpne -> 41
    //   22: aload_0
    //   23: aload_0
    //   24: aload_0
    //   25: getfield mapData : Lcom/google/protobuf/MapField$MutatabilityAwareMap;
    //   28: invokespecial convertMapToList : (Lcom/google/protobuf/MapField$MutatabilityAwareMap;)Ljava/util/List;
    //   31: putfield listData : Ljava/util/List;
    //   34: aload_0
    //   35: getstatic com/google/protobuf/MapField$StorageMode.BOTH : Lcom/google/protobuf/MapField$StorageMode;
    //   38: putfield mode : Lcom/google/protobuf/MapField$StorageMode;
    //   41: aload_0
    //   42: monitorexit
    //   43: goto -> 51
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    //   51: aload_0
    //   52: getfield listData : Ljava/util/List;
    //   55: invokestatic unmodifiableList : (Ljava/util/List;)Ljava/util/List;
    //   58: areturn
    // Exception table:
    //   from	to	target	type
    //   12	41	46	finally
    //   41	43	46	finally
    //   47	49	46	finally
  }
  
  public Map<K, V> getMap() {
    // Byte code:
    //   0: aload_0
    //   1: getfield mode : Lcom/google/protobuf/MapField$StorageMode;
    //   4: getstatic com/google/protobuf/MapField$StorageMode.LIST : Lcom/google/protobuf/MapField$StorageMode;
    //   7: if_acmpne -> 51
    //   10: aload_0
    //   11: monitorenter
    //   12: aload_0
    //   13: getfield mode : Lcom/google/protobuf/MapField$StorageMode;
    //   16: getstatic com/google/protobuf/MapField$StorageMode.LIST : Lcom/google/protobuf/MapField$StorageMode;
    //   19: if_acmpne -> 41
    //   22: aload_0
    //   23: aload_0
    //   24: aload_0
    //   25: getfield listData : Ljava/util/List;
    //   28: invokespecial convertListToMap : (Ljava/util/List;)Lcom/google/protobuf/MapField$MutatabilityAwareMap;
    //   31: putfield mapData : Lcom/google/protobuf/MapField$MutatabilityAwareMap;
    //   34: aload_0
    //   35: getstatic com/google/protobuf/MapField$StorageMode.BOTH : Lcom/google/protobuf/MapField$StorageMode;
    //   38: putfield mode : Lcom/google/protobuf/MapField$StorageMode;
    //   41: aload_0
    //   42: monitorexit
    //   43: goto -> 51
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    //   51: aload_0
    //   52: getfield mapData : Lcom/google/protobuf/MapField$MutatabilityAwareMap;
    //   55: invokestatic unmodifiableMap : (Ljava/util/Map;)Ljava/util/Map;
    //   58: areturn
    // Exception table:
    //   from	to	target	type
    //   12	41	46	finally
    //   41	43	46	finally
    //   47	49	46	finally
  }
  
  Message getMapEntryMessageDefaultInstance() {
    return this.converter.getMessageDefaultInstance();
  }
  
  List<Message> getMutableList() {
    if (this.mode != StorageMode.LIST) {
      if (this.mode == StorageMode.MAP)
        this.listData = convertMapToList(this.mapData); 
      this.mapData = null;
      this.mode = StorageMode.LIST;
    } 
    return this.listData;
  }
  
  public Map<K, V> getMutableMap() {
    if (this.mode != StorageMode.MAP) {
      if (this.mode == StorageMode.LIST)
        this.mapData = convertListToMap(this.listData); 
      this.listData = null;
      this.mode = StorageMode.MAP;
    } 
    return this.mapData;
  }
  
  public int hashCode() {
    return MapFieldLite.calculateHashCodeForMap(getMap());
  }
  
  public boolean isMutable() {
    return this.isMutable;
  }
  
  public void makeImmutable() {
    this.isMutable = false;
  }
  
  public void mergeFrom(MapField<K, V> paramMapField) {
    getMutableMap().putAll(MapFieldLite.copy(paramMapField.getMap()));
  }
  
  static interface Converter<K, V> {
    Message convertKeyAndValueToMessage(K param1K, V param1V);
    
    void convertMessageToKeyAndValue(Message param1Message, Map<K, V> param1Map);
    
    Message getMessageDefaultInstance();
  }
  
  static class ImmutableMessageConverter<K, V> implements Converter<K, V> {
    private final MapEntry<K, V> defaultEntry;
    
    public ImmutableMessageConverter(MapEntry<K, V> param1MapEntry) {
      this.defaultEntry = param1MapEntry;
    }
    
    public Message convertKeyAndValueToMessage(K param1K, V param1V) {
      return this.defaultEntry.newBuilderForType().setKey(param1K).setValue(param1V).buildPartial();
    }
    
    public void convertMessageToKeyAndValue(Message param1Message, Map<K, V> param1Map) {
      param1Message = param1Message;
      param1Map.put((K)param1Message.getKey(), (V)param1Message.getValue());
    }
    
    public Message getMessageDefaultInstance() {
      return this.defaultEntry;
    }
  }
  
  static class MutatabilityAwareMap<K, V> implements Map<K, V> {
    private final Map<K, V> delegate;
    
    private final MutabilityOracle mutabilityOracle;
    
    MutatabilityAwareMap(MutabilityOracle param1MutabilityOracle, Map<K, V> param1Map) {
      this.mutabilityOracle = param1MutabilityOracle;
      this.delegate = param1Map;
    }
    
    public void clear() {
      this.mutabilityOracle.ensureMutable();
      this.delegate.clear();
    }
    
    public boolean containsKey(Object param1Object) {
      return this.delegate.containsKey(param1Object);
    }
    
    public boolean containsValue(Object param1Object) {
      return this.delegate.containsValue(param1Object);
    }
    
    public Set<Map.Entry<K, V>> entrySet() {
      return new MutatabilityAwareSet<Map.Entry<K, V>>(this.mutabilityOracle, this.delegate.entrySet());
    }
    
    public boolean equals(Object param1Object) {
      return this.delegate.equals(param1Object);
    }
    
    public V get(Object param1Object) {
      return this.delegate.get(param1Object);
    }
    
    public int hashCode() {
      return this.delegate.hashCode();
    }
    
    public boolean isEmpty() {
      return this.delegate.isEmpty();
    }
    
    public Set<K> keySet() {
      return new MutatabilityAwareSet<K>(this.mutabilityOracle, this.delegate.keySet());
    }
    
    public V put(K param1K, V param1V) {
      this.mutabilityOracle.ensureMutable();
      Internal.checkNotNull(param1K);
      Internal.checkNotNull(param1V);
      return this.delegate.put(param1K, param1V);
    }
    
    public void putAll(Map<? extends K, ? extends V> param1Map) {
      this.mutabilityOracle.ensureMutable();
      for (K k : param1Map.keySet()) {
        Internal.checkNotNull(k);
        Internal.checkNotNull(param1Map.get(k));
      } 
      this.delegate.putAll(param1Map);
    }
    
    public V remove(Object param1Object) {
      this.mutabilityOracle.ensureMutable();
      return this.delegate.remove(param1Object);
    }
    
    public int size() {
      return this.delegate.size();
    }
    
    public String toString() {
      return this.delegate.toString();
    }
    
    public Collection<V> values() {
      return new MutatabilityAwareCollection<V>(this.mutabilityOracle, this.delegate.values());
    }
    
    static class MutatabilityAwareCollection<E> implements Collection<E> {
      private final Collection<E> delegate;
      
      private final MutabilityOracle mutabilityOracle;
      
      MutatabilityAwareCollection(MutabilityOracle param2MutabilityOracle, Collection<E> param2Collection) {
        this.mutabilityOracle = param2MutabilityOracle;
        this.delegate = param2Collection;
      }
      
      public boolean add(E param2E) {
        throw new UnsupportedOperationException();
      }
      
      public boolean addAll(Collection<? extends E> param2Collection) {
        throw new UnsupportedOperationException();
      }
      
      public void clear() {
        this.mutabilityOracle.ensureMutable();
        this.delegate.clear();
      }
      
      public boolean contains(Object param2Object) {
        return this.delegate.contains(param2Object);
      }
      
      public boolean containsAll(Collection<?> param2Collection) {
        return this.delegate.containsAll(param2Collection);
      }
      
      public boolean equals(Object param2Object) {
        return this.delegate.equals(param2Object);
      }
      
      public int hashCode() {
        return this.delegate.hashCode();
      }
      
      public boolean isEmpty() {
        return this.delegate.isEmpty();
      }
      
      public Iterator<E> iterator() {
        return new MapField.MutatabilityAwareMap.MutatabilityAwareIterator<E>(this.mutabilityOracle, this.delegate.iterator());
      }
      
      public boolean remove(Object param2Object) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.remove(param2Object);
      }
      
      public boolean removeAll(Collection<?> param2Collection) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.removeAll(param2Collection);
      }
      
      public boolean retainAll(Collection<?> param2Collection) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.retainAll(param2Collection);
      }
      
      public int size() {
        return this.delegate.size();
      }
      
      public Object[] toArray() {
        return this.delegate.toArray();
      }
      
      public <T> T[] toArray(T[] param2ArrayOfT) {
        return this.delegate.toArray(param2ArrayOfT);
      }
      
      public String toString() {
        return this.delegate.toString();
      }
    }
    
    static class MutatabilityAwareIterator<E> implements Iterator<E> {
      private final Iterator<E> delegate;
      
      private final MutabilityOracle mutabilityOracle;
      
      MutatabilityAwareIterator(MutabilityOracle param2MutabilityOracle, Iterator<E> param2Iterator) {
        this.mutabilityOracle = param2MutabilityOracle;
        this.delegate = param2Iterator;
      }
      
      public boolean equals(Object param2Object) {
        return this.delegate.equals(param2Object);
      }
      
      public boolean hasNext() {
        return this.delegate.hasNext();
      }
      
      public int hashCode() {
        return this.delegate.hashCode();
      }
      
      public E next() {
        return this.delegate.next();
      }
      
      public void remove() {
        this.mutabilityOracle.ensureMutable();
        this.delegate.remove();
      }
      
      public String toString() {
        return this.delegate.toString();
      }
    }
    
    static class MutatabilityAwareSet<E> implements Set<E> {
      private final Set<E> delegate;
      
      private final MutabilityOracle mutabilityOracle;
      
      MutatabilityAwareSet(MutabilityOracle param2MutabilityOracle, Set<E> param2Set) {
        this.mutabilityOracle = param2MutabilityOracle;
        this.delegate = param2Set;
      }
      
      public boolean add(E param2E) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.add(param2E);
      }
      
      public boolean addAll(Collection<? extends E> param2Collection) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.addAll(param2Collection);
      }
      
      public void clear() {
        this.mutabilityOracle.ensureMutable();
        this.delegate.clear();
      }
      
      public boolean contains(Object param2Object) {
        return this.delegate.contains(param2Object);
      }
      
      public boolean containsAll(Collection<?> param2Collection) {
        return this.delegate.containsAll(param2Collection);
      }
      
      public boolean equals(Object param2Object) {
        return this.delegate.equals(param2Object);
      }
      
      public int hashCode() {
        return this.delegate.hashCode();
      }
      
      public boolean isEmpty() {
        return this.delegate.isEmpty();
      }
      
      public Iterator<E> iterator() {
        return new MapField.MutatabilityAwareMap.MutatabilityAwareIterator<E>(this.mutabilityOracle, this.delegate.iterator());
      }
      
      public boolean remove(Object param2Object) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.remove(param2Object);
      }
      
      public boolean removeAll(Collection<?> param2Collection) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.removeAll(param2Collection);
      }
      
      public boolean retainAll(Collection<?> param2Collection) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.retainAll(param2Collection);
      }
      
      public int size() {
        return this.delegate.size();
      }
      
      public Object[] toArray() {
        return this.delegate.toArray();
      }
      
      public <T> T[] toArray(T[] param2ArrayOfT) {
        return this.delegate.toArray(param2ArrayOfT);
      }
      
      public String toString() {
        return this.delegate.toString();
      }
    }
  }
  
  static class MutatabilityAwareCollection<E> implements Collection<E> {
    private final Collection<E> delegate;
    
    private final MutabilityOracle mutabilityOracle;
    
    MutatabilityAwareCollection(MutabilityOracle param1MutabilityOracle, Collection<E> param1Collection) {
      this.mutabilityOracle = param1MutabilityOracle;
      this.delegate = param1Collection;
    }
    
    public boolean add(E param1E) {
      throw new UnsupportedOperationException();
    }
    
    public boolean addAll(Collection<? extends E> param1Collection) {
      throw new UnsupportedOperationException();
    }
    
    public void clear() {
      this.mutabilityOracle.ensureMutable();
      this.delegate.clear();
    }
    
    public boolean contains(Object param1Object) {
      return this.delegate.contains(param1Object);
    }
    
    public boolean containsAll(Collection<?> param1Collection) {
      return this.delegate.containsAll(param1Collection);
    }
    
    public boolean equals(Object param1Object) {
      return this.delegate.equals(param1Object);
    }
    
    public int hashCode() {
      return this.delegate.hashCode();
    }
    
    public boolean isEmpty() {
      return this.delegate.isEmpty();
    }
    
    public Iterator<E> iterator() {
      return new MapField.MutatabilityAwareMap.MutatabilityAwareIterator<E>(this.mutabilityOracle, this.delegate.iterator());
    }
    
    public boolean remove(Object param1Object) {
      this.mutabilityOracle.ensureMutable();
      return this.delegate.remove(param1Object);
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      this.mutabilityOracle.ensureMutable();
      return this.delegate.removeAll(param1Collection);
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      this.mutabilityOracle.ensureMutable();
      return this.delegate.retainAll(param1Collection);
    }
    
    public int size() {
      return this.delegate.size();
    }
    
    public Object[] toArray() {
      return this.delegate.toArray();
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      return this.delegate.toArray(param1ArrayOfT);
    }
    
    public String toString() {
      return this.delegate.toString();
    }
  }
  
  static class MutatabilityAwareIterator<E> implements Iterator<E> {
    private final Iterator<E> delegate;
    
    private final MutabilityOracle mutabilityOracle;
    
    MutatabilityAwareIterator(MutabilityOracle param1MutabilityOracle, Iterator<E> param1Iterator) {
      this.mutabilityOracle = param1MutabilityOracle;
      this.delegate = param1Iterator;
    }
    
    public boolean equals(Object param1Object) {
      return this.delegate.equals(param1Object);
    }
    
    public boolean hasNext() {
      return this.delegate.hasNext();
    }
    
    public int hashCode() {
      return this.delegate.hashCode();
    }
    
    public E next() {
      return this.delegate.next();
    }
    
    public void remove() {
      this.mutabilityOracle.ensureMutable();
      this.delegate.remove();
    }
    
    public String toString() {
      return this.delegate.toString();
    }
  }
  
  static class MutatabilityAwareSet<E> implements Set<E> {
    private final Set<E> delegate;
    
    private final MutabilityOracle mutabilityOracle;
    
    MutatabilityAwareSet(MutabilityOracle param1MutabilityOracle, Set<E> param1Set) {
      this.mutabilityOracle = param1MutabilityOracle;
      this.delegate = param1Set;
    }
    
    public boolean add(E param1E) {
      this.mutabilityOracle.ensureMutable();
      return this.delegate.add(param1E);
    }
    
    public boolean addAll(Collection<? extends E> param1Collection) {
      this.mutabilityOracle.ensureMutable();
      return this.delegate.addAll(param1Collection);
    }
    
    public void clear() {
      this.mutabilityOracle.ensureMutable();
      this.delegate.clear();
    }
    
    public boolean contains(Object param1Object) {
      return this.delegate.contains(param1Object);
    }
    
    public boolean containsAll(Collection<?> param1Collection) {
      return this.delegate.containsAll(param1Collection);
    }
    
    public boolean equals(Object param1Object) {
      return this.delegate.equals(param1Object);
    }
    
    public int hashCode() {
      return this.delegate.hashCode();
    }
    
    public boolean isEmpty() {
      return this.delegate.isEmpty();
    }
    
    public Iterator<E> iterator() {
      return new MapField.MutatabilityAwareMap.MutatabilityAwareIterator<E>(this.mutabilityOracle, this.delegate.iterator());
    }
    
    public boolean remove(Object param1Object) {
      this.mutabilityOracle.ensureMutable();
      return this.delegate.remove(param1Object);
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      this.mutabilityOracle.ensureMutable();
      return this.delegate.removeAll(param1Collection);
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      this.mutabilityOracle.ensureMutable();
      return this.delegate.retainAll(param1Collection);
    }
    
    public int size() {
      return this.delegate.size();
    }
    
    public Object[] toArray() {
      return this.delegate.toArray();
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      return this.delegate.toArray(param1ArrayOfT);
    }
    
    public String toString() {
      return this.delegate.toString();
    }
  }
  
  enum StorageMode {
    BOTH, LIST, MAP;
    
    static {
      BOTH = new StorageMode("BOTH", 2);
      $VALUES = new StorageMode[] { MAP, LIST, BOTH };
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\MapField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */