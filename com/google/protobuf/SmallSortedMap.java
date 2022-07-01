package com.google.protobuf;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class SmallSortedMap extends AbstractMap {
  private List entryList;
  
  boolean isImmutable;
  
  private volatile SmallSortedMap$EntrySet lazyEntrySet;
  
  private final int maxArraySize;
  
  private Map overflowEntries;
  
  private SmallSortedMap(int paramInt) {
    this.maxArraySize = paramInt;
    this.entryList = Collections.emptyList();
    this.overflowEntries = Collections.emptyMap();
  }
  
  private int binarySearchInArray(Comparable<Comparable> paramComparable) {
    int j = this.entryList.size() - 1;
    if (j >= 0) {
      int k = paramComparable.compareTo(((SmallSortedMap$Entry)this.entryList.get(j)).key);
      if (k > 0)
        return -(j + 2); 
      if (k == 0)
        return j; 
    } 
    int i = 0;
    while (i <= j) {
      int k = (i + j) / 2;
      int m = paramComparable.compareTo(((SmallSortedMap$Entry)this.entryList.get(k)).key);
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
  
  private SortedMap getOverflowEntriesMutable() {
    checkMutable();
    if (this.overflowEntries.isEmpty() && !(this.overflowEntries instanceof TreeMap))
      this.overflowEntries = new TreeMap<Object, Object>(); 
    return (SortedMap)this.overflowEntries;
  }
  
  static SmallSortedMap newFieldMap(int paramInt) {
    return new SmallSortedMap$1(paramInt);
  }
  
  private Object removeArrayEntryAt(int paramInt) {
    checkMutable();
    Object object = ((SmallSortedMap$Entry)this.entryList.remove(paramInt)).getValue();
    if (!this.overflowEntries.isEmpty()) {
      Iterator<Map.Entry> iterator = getOverflowEntriesMutable().entrySet().iterator();
      this.entryList.add(new SmallSortedMap$Entry(this, iterator.next()));
      iterator.remove();
    } 
    return object;
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
    return (binarySearchInArray((Comparable)paramObject) >= 0 || this.overflowEntries.containsKey(paramObject));
  }
  
  public Set entrySet() {
    if (this.lazyEntrySet == null)
      this.lazyEntrySet = new SmallSortedMap$EntrySet(this, (byte)0); 
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
  
  public Object get(Object paramObject) {
    paramObject = paramObject;
    int i = binarySearchInArray((Comparable)paramObject);
    return (i >= 0) ? ((SmallSortedMap$Entry)this.entryList.get(i)).getValue() : this.overflowEntries.get(paramObject);
  }
  
  public final Map.Entry getArrayEntryAt(int paramInt) {
    return this.entryList.get(paramInt);
  }
  
  public final int getNumArrayEntries() {
    return this.entryList.size();
  }
  
  public final Iterable getOverflowEntries() {
    return this.overflowEntries.isEmpty() ? SmallSortedMap$EmptySet.iterable() : this.overflowEntries.entrySet();
  }
  
  public int hashCode() {
    int k = getNumArrayEntries();
    int j = 0;
    int i = 0;
    while (j < k) {
      i += ((SmallSortedMap$Entry)this.entryList.get(j)).hashCode();
      j++;
    } 
    j = i;
    if (this.overflowEntries.size() > 0)
      j = i + this.overflowEntries.hashCode(); 
    return j;
  }
  
  public void makeImmutable() {
    if (!this.isImmutable) {
      Map<?, ?> map;
      if (this.overflowEntries.isEmpty()) {
        map = Collections.emptyMap();
      } else {
        map = Collections.unmodifiableMap(this.overflowEntries);
      } 
      this.overflowEntries = map;
      this.isImmutable = true;
    } 
  }
  
  public final Object put(Comparable paramComparable, Object paramObject) {
    checkMutable();
    int i = binarySearchInArray(paramComparable);
    if (i >= 0)
      return ((SmallSortedMap$Entry)this.entryList.get(i)).setValue(paramObject); 
    checkMutable();
    if (this.entryList.isEmpty() && !(this.entryList instanceof ArrayList))
      this.entryList = new ArrayList(this.maxArraySize); 
    i = -(i + 1);
    if (i >= this.maxArraySize)
      return getOverflowEntriesMutable().put(paramComparable, paramObject); 
    if (this.entryList.size() == this.maxArraySize) {
      SmallSortedMap$Entry smallSortedMap$Entry = this.entryList.remove(this.maxArraySize - 1);
      getOverflowEntriesMutable().put(smallSortedMap$Entry.key, smallSortedMap$Entry.getValue());
    } 
    this.entryList.add(i, new SmallSortedMap$Entry(this, paramComparable, paramObject));
    return null;
  }
  
  public Object remove(Object paramObject) {
    checkMutable();
    paramObject = paramObject;
    int i = binarySearchInArray((Comparable)paramObject);
    return (i >= 0) ? removeArrayEntryAt(i) : (this.overflowEntries.isEmpty() ? null : this.overflowEntries.remove(paramObject));
  }
  
  public int size() {
    return this.entryList.size() + this.overflowEntries.size();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\SmallSortedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */