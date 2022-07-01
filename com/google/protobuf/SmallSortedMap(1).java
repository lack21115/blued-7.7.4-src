package com.google.protobuf;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class SmallSortedMap<K extends Comparable<K>, V> extends AbstractMap<K, V> {
  private List<Entry> entryList;
  
  private boolean isImmutable;
  
  private volatile DescendingEntrySet lazyDescendingEntrySet;
  
  private volatile EntrySet lazyEntrySet;
  
  private final int maxArraySize;
  
  private Map<K, V> overflowEntries;
  
  private Map<K, V> overflowEntriesDescending;
  
  private SmallSortedMap(int paramInt) {
    this.maxArraySize = paramInt;
    this.entryList = Collections.emptyList();
    this.overflowEntries = Collections.emptyMap();
    this.overflowEntriesDescending = Collections.emptyMap();
  }
  
  private int binarySearchInArray(K paramK) {
    int j = this.entryList.size() - 1;
    if (j >= 0) {
      int k = paramK.compareTo(((Entry)this.entryList.get(j)).getKey());
      if (k > 0)
        return -(j + 2); 
      if (k == 0)
        return j; 
    } 
    int i = 0;
    while (i <= j) {
      int k = (i + j) / 2;
      int m = paramK.compareTo(((Entry)this.entryList.get(k)).getKey());
      if (m < 0) {
        j = k - 1;
        continue;
      } 
      if (m > 0) {
        i = k + 1;
        continue;
      } 
      return k;
    } 
    return -(i + 1);
  }
  
  private void checkMutable() {
    if (!this.isImmutable)
      return; 
    throw new UnsupportedOperationException();
  }
  
  private void ensureEntryArrayMutable() {
    checkMutable();
    if (this.entryList.isEmpty() && !(this.entryList instanceof ArrayList))
      this.entryList = new ArrayList<Entry>(this.maxArraySize); 
  }
  
  private SortedMap<K, V> getOverflowEntriesMutable() {
    checkMutable();
    if (this.overflowEntries.isEmpty() && !(this.overflowEntries instanceof TreeMap)) {
      this.overflowEntries = new TreeMap<K, V>();
      this.overflowEntriesDescending = ((TreeMap<K, V>)this.overflowEntries).descendingMap();
    } 
    return (SortedMap<K, V>)this.overflowEntries;
  }
  
  static <FieldDescriptorType extends FieldSet.FieldDescriptorLite<FieldDescriptorType>> SmallSortedMap<FieldDescriptorType, Object> newFieldMap(int paramInt) {
    return new SmallSortedMap<FieldDescriptorType, Object>(paramInt) {
        public void makeImmutable() {
          if (!isImmutable()) {
            for (int i = 0; i < getNumArrayEntries(); i++) {
              Map.Entry<FieldDescriptorType, Object> entry = getArrayEntryAt(i);
              if (((FieldSet.FieldDescriptorLite)entry.getKey()).isRepeated())
                entry.setValue(Collections.unmodifiableList((List)entry.getValue())); 
            } 
            for (Map.Entry<FieldDescriptorType, Object> entry : getOverflowEntries()) {
              if (((FieldSet.FieldDescriptorLite)entry.getKey()).isRepeated())
                entry.setValue(Collections.unmodifiableList((List)entry.getValue())); 
            } 
          } 
          super.makeImmutable();
        }
      };
  }
  
  static <K extends Comparable<K>, V> SmallSortedMap<K, V> newInstanceForTest(int paramInt) {
    return new SmallSortedMap<K, V>(paramInt);
  }
  
  private V removeArrayEntryAt(int paramInt) {
    checkMutable();
    V v = ((Entry)this.entryList.remove(paramInt)).getValue();
    if (!this.overflowEntries.isEmpty()) {
      Iterator<Map.Entry<K, V>> iterator = getOverflowEntriesMutable().entrySet().iterator();
      this.entryList.add(new Entry(iterator.next()));
      iterator.remove();
    } 
    return v;
  }
  
  public void clear() {
    checkMutable();
    if (!this.entryList.isEmpty())
      this.entryList.clear(); 
    if (!this.overflowEntries.isEmpty())
      this.overflowEntries.clear(); 
  }
  
  public boolean containsKey(Object paramObject) {
    paramObject = paramObject;
    return (binarySearchInArray((K)paramObject) >= 0 || this.overflowEntries.containsKey(paramObject));
  }
  
  Set<Map.Entry<K, V>> descendingEntrySet() {
    if (this.lazyDescendingEntrySet == null)
      this.lazyDescendingEntrySet = new DescendingEntrySet(); 
    return this.lazyDescendingEntrySet;
  }
  
  public Set<Map.Entry<K, V>> entrySet() {
    if (this.lazyEntrySet == null)
      this.lazyEntrySet = new EntrySet(); 
    return this.lazyEntrySet;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof SmallSortedMap))
      return super.equals(paramObject); 
    paramObject = paramObject;
    int j = size();
    if (j != paramObject.size())
      return false; 
    int k = getNumArrayEntries();
    if (k != paramObject.getNumArrayEntries())
      return entrySet().equals(paramObject.entrySet()); 
    for (int i = 0; i < k; i++) {
      if (!getArrayEntryAt(i).equals(paramObject.getArrayEntryAt(i)))
        return false; 
    } 
    return (k != j) ? this.overflowEntries.equals(((SmallSortedMap)paramObject).overflowEntries) : true;
  }
  
  public V get(Object paramObject) {
    paramObject = paramObject;
    int i = binarySearchInArray((K)paramObject);
    return (i >= 0) ? ((Entry)this.entryList.get(i)).getValue() : this.overflowEntries.get(paramObject);
  }
  
  public Map.Entry<K, V> getArrayEntryAt(int paramInt) {
    return this.entryList.get(paramInt);
  }
  
  public int getNumArrayEntries() {
    return this.entryList.size();
  }
  
  public int getNumOverflowEntries() {
    return this.overflowEntries.size();
  }
  
  public Iterable<Map.Entry<K, V>> getOverflowEntries() {
    return this.overflowEntries.isEmpty() ? EmptySet.iterable() : this.overflowEntries.entrySet();
  }
  
  Iterable<Map.Entry<K, V>> getOverflowEntriesDescending() {
    return this.overflowEntriesDescending.isEmpty() ? EmptySet.iterable() : this.overflowEntriesDescending.entrySet();
  }
  
  public int hashCode() {
    int k = getNumArrayEntries();
    int j = 0;
    int i = 0;
    while (j < k) {
      i += ((Entry)this.entryList.get(j)).hashCode();
      j++;
    } 
    j = i;
    if (getNumOverflowEntries() > 0)
      j = i + this.overflowEntries.hashCode(); 
    return j;
  }
  
  public boolean isImmutable() {
    return this.isImmutable;
  }
  
  public void makeImmutable() {
    if (!this.isImmutable) {
      Map<?, ?> map;
      if (this.overflowEntries.isEmpty()) {
        map = Collections.emptyMap();
      } else {
        map = Collections.unmodifiableMap(this.overflowEntries);
      } 
      this.overflowEntries = (Map)map;
      if (this.overflowEntriesDescending.isEmpty()) {
        map = Collections.emptyMap();
      } else {
        map = Collections.unmodifiableMap(this.overflowEntriesDescending);
      } 
      this.overflowEntriesDescending = (Map)map;
      this.isImmutable = true;
    } 
  }
  
  public V put(K paramK, V paramV) {
    checkMutable();
    int i = binarySearchInArray(paramK);
    if (i >= 0)
      return ((Entry)this.entryList.get(i)).setValue(paramV); 
    ensureEntryArrayMutable();
    i = -(i + 1);
    if (i >= this.maxArraySize)
      return getOverflowEntriesMutable().put(paramK, paramV); 
    int j = this.entryList.size();
    int k = this.maxArraySize;
    if (j == k) {
      Entry entry = this.entryList.remove(k - 1);
      getOverflowEntriesMutable().put(entry.getKey(), entry.getValue());
    } 
    this.entryList.add(i, new Entry(paramK, paramV));
    return null;
  }
  
  public V remove(Object paramObject) {
    checkMutable();
    paramObject = paramObject;
    int i = binarySearchInArray((K)paramObject);
    return (i >= 0) ? removeArrayEntryAt(i) : (this.overflowEntries.isEmpty() ? null : this.overflowEntries.remove(paramObject));
  }
  
  public int size() {
    return this.entryList.size() + this.overflowEntries.size();
  }
  
  class DescendingEntryIterator implements Iterator<Map.Entry<K, V>> {
    private Iterator<Map.Entry<K, V>> lazyOverflowIterator;
    
    private int pos = SmallSortedMap.access$600(SmallSortedMap.this).size();
    
    private DescendingEntryIterator() {}
    
    private Iterator<Map.Entry<K, V>> getOverflowIterator() {
      if (this.lazyOverflowIterator == null)
        this.lazyOverflowIterator = SmallSortedMap.this.overflowEntriesDescending.entrySet().iterator(); 
      return this.lazyOverflowIterator;
    }
    
    public boolean hasNext() {
      int i = this.pos;
      return ((i > 0 && i <= SmallSortedMap.access$600(SmallSortedMap.this).size()) || getOverflowIterator().hasNext());
    }
    
    public Map.Entry<K, V> next() {
      if (getOverflowIterator().hasNext())
        return getOverflowIterator().next(); 
      List<Map.Entry<K, V>> list = SmallSortedMap.access$600(SmallSortedMap.this);
      int i = this.pos - 1;
      this.pos = i;
      return list.get(i);
    }
    
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
  
  class DescendingEntrySet extends EntrySet {
    private DescendingEntrySet() {}
    
    public Iterator<Map.Entry<K, V>> iterator() {
      return new SmallSortedMap.DescendingEntryIterator();
    }
  }
  
  static class EmptySet {
    private static final Iterable<Object> ITERABLE = new Iterable() {
        public Iterator<Object> iterator() {
          return SmallSortedMap.EmptySet.ITERATOR;
        }
      };
    
    private static final Iterator<Object> ITERATOR = new Iterator() {
        public boolean hasNext() {
          return false;
        }
        
        public Object next() {
          throw new NoSuchElementException();
        }
        
        public void remove() {
          throw new UnsupportedOperationException();
        }
      };
    
    static {
    
    }
    
    static <T> Iterable<T> iterable() {
      return (Iterable)ITERABLE;
    }
  }
  
  static final class null implements Iterator<Object> {
    public boolean hasNext() {
      return false;
    }
    
    public Object next() {
      throw new NoSuchElementException();
    }
    
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
  
  static final class null implements Iterable<Object> {
    public Iterator<Object> iterator() {
      return SmallSortedMap.EmptySet.ITERATOR;
    }
  }
  
  class Entry implements Comparable<Entry>, Map.Entry<K, V> {
    private final K key;
    
    private V value;
    
    Entry(K param1K, V param1V) {
      this.key = param1K;
      this.value = param1V;
    }
    
    Entry(Map.Entry<K, V> param1Entry) {
      this(param1Entry.getKey(), param1Entry.getValue());
    }
    
    private boolean equals(Object param1Object1, Object param1Object2) {
      return (param1Object1 == null) ? ((param1Object2 == null)) : param1Object1.equals(param1Object2);
    }
    
    public int compareTo(Entry param1Entry) {
      return getKey().compareTo(param1Entry.getKey());
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof Map.Entry))
        return false; 
      param1Object = param1Object;
      return (equals(this.key, param1Object.getKey()) && equals(this.value, param1Object.getValue()));
    }
    
    public K getKey() {
      return this.key;
    }
    
    public V getValue() {
      return this.value;
    }
    
    public int hashCode() {
      int i;
      K k = this.key;
      int j = 0;
      if (k == null) {
        i = 0;
      } else {
        i = k.hashCode();
      } 
      V v = this.value;
      if (v != null)
        j = v.hashCode(); 
      return i ^ j;
    }
    
    public V setValue(V param1V) {
      SmallSortedMap.this.checkMutable();
      V v = this.value;
      this.value = param1V;
      return v;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.key);
      stringBuilder.append("=");
      stringBuilder.append(this.value);
      return stringBuilder.toString();
    }
  }
  
  class EntryIterator implements Iterator<Map.Entry<K, V>> {
    private Iterator<Map.Entry<K, V>> lazyOverflowIterator;
    
    private boolean nextCalledBeforeRemove;
    
    private int pos = -1;
    
    private EntryIterator() {}
    
    private Iterator<Map.Entry<K, V>> getOverflowIterator() {
      if (this.lazyOverflowIterator == null)
        this.lazyOverflowIterator = SmallSortedMap.this.overflowEntries.entrySet().iterator(); 
      return this.lazyOverflowIterator;
    }
    
    public boolean hasNext() {
      int i = this.pos;
      boolean bool = true;
      if (i + 1 >= SmallSortedMap.access$600(SmallSortedMap.this).size()) {
        if (!SmallSortedMap.this.overflowEntries.isEmpty() && getOverflowIterator().hasNext())
          return true; 
        bool = false;
      } 
      return bool;
    }
    
    public Map.Entry<K, V> next() {
      this.nextCalledBeforeRemove = true;
      int i = this.pos + 1;
      this.pos = i;
      return (i < SmallSortedMap.access$600(SmallSortedMap.this).size()) ? SmallSortedMap.access$600(SmallSortedMap.this).get(this.pos) : getOverflowIterator().next();
    }
    
    public void remove() {
      if (this.nextCalledBeforeRemove) {
        this.nextCalledBeforeRemove = false;
        SmallSortedMap.this.checkMutable();
        if (this.pos < SmallSortedMap.access$600(SmallSortedMap.this).size()) {
          SmallSortedMap smallSortedMap = SmallSortedMap.this;
          int i = this.pos;
          this.pos = i - 1;
          smallSortedMap.removeArrayEntryAt(i);
          return;
        } 
        getOverflowIterator().remove();
        return;
      } 
      throw new IllegalStateException("remove() was called before next()");
    }
  }
  
  class EntrySet extends AbstractSet<Map.Entry<K, V>> {
    private EntrySet() {}
    
    public boolean add(Map.Entry<K, V> param1Entry) {
      if (!contains(param1Entry)) {
        SmallSortedMap.this.put((Comparable)param1Entry.getKey(), param1Entry.getValue());
        return true;
      } 
      return false;
    }
    
    public void clear() {
      SmallSortedMap.this.clear();
    }
    
    public boolean contains(Object param1Object) {
      Map.Entry entry = (Map.Entry)param1Object;
      param1Object = SmallSortedMap.this.get(entry.getKey());
      entry = (Map.Entry)entry.getValue();
      return (param1Object == entry || (param1Object != null && param1Object.equals(entry)));
    }
    
    public Iterator<Map.Entry<K, V>> iterator() {
      return new SmallSortedMap.EntryIterator();
    }
    
    public boolean remove(Object param1Object) {
      param1Object = param1Object;
      if (contains(param1Object)) {
        SmallSortedMap.this.remove(param1Object.getKey());
        return true;
      } 
      return false;
    }
    
    public int size() {
      return SmallSortedMap.this.size();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\SmallSortedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */