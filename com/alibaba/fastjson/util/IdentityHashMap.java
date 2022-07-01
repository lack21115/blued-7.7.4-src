package com.alibaba.fastjson.util;

public class IdentityHashMap<K, V> {
  private final Entry<K, V>[] buckets;
  
  private final int indexMask;
  
  public IdentityHashMap() {
    this(1024);
  }
  
  public IdentityHashMap(int paramInt) {
    this.indexMask = paramInt - 1;
    this.buckets = (Entry<K, V>[])new Entry[paramInt];
  }
  
  public final V get(K paramK) {
    int i = System.identityHashCode(paramK);
    int j = this.indexMask;
    for (Entry<K, V> entry = this.buckets[i & j]; entry != null; entry = entry.next) {
      if (paramK == entry.key)
        return entry.value; 
    } 
    return null;
  }
  
  public boolean put(K paramK, V paramV) {
    int i = System.identityHashCode(paramK);
    int j = this.indexMask & i;
    for (Entry<K, V> entry2 = this.buckets[j]; entry2 != null; entry2 = entry2.next) {
      if (paramK == entry2.key) {
        entry2.value = paramV;
        return true;
      } 
    } 
    Entry<K, V> entry1 = new Entry<K, V>(paramK, paramV, i, this.buckets[j]);
    this.buckets[j] = entry1;
    return false;
  }
  
  public static final class Entry<K, V> {
    public final int hashCode;
    
    public final K key;
    
    public final Entry<K, V> next;
    
    public V value;
    
    public Entry(K param1K, V param1V, int param1Int, Entry<K, V> param1Entry) {
      this.key = param1K;
      this.value = param1V;
      this.next = param1Entry;
      this.hashCode = param1Int;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjso\\util\IdentityHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */