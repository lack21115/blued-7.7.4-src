package com.qiniu.android.dns.util;

import java.util.HashMap;
import java.util.LinkedList;

public final class LruCache<K, V> {
  private LinkedList<K> list = new LinkedList<K>();
  
  private HashMap<K, V> map = new HashMap<K, V>();
  
  private int size;
  
  public LruCache() {
    this(256);
  }
  
  public LruCache(int paramInt) {
    this.size = paramInt;
  }
  
  public void clear() {
    this.list.clear();
    this.map.clear();
  }
  
  public LruCache delete(K paramK) {
    this.list.remove(paramK);
    this.map.remove(paramK);
    return this;
  }
  
  public V get(K paramK) {
    V v = this.map.get(paramK);
    this.list.remove(paramK);
    this.list.push(paramK);
    return v;
  }
  
  public LruCache put(K paramK, V paramV) {
    if (this.list.size() == this.size) {
      K k = this.list.pollLast();
      this.map.remove(k);
    } 
    this.map.put(paramK, paramV);
    this.list.push(paramK);
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\dn\\util\LruCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */