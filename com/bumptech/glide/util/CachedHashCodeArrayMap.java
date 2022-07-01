package com.bumptech.glide.util;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

public final class CachedHashCodeArrayMap<K, V> extends ArrayMap<K, V> {
  private int i;
  
  public void clear() {
    this.i = 0;
    super.clear();
  }
  
  public int hashCode() {
    if (this.i == 0)
      this.i = super.hashCode(); 
    return this.i;
  }
  
  public V put(K paramK, V paramV) {
    this.i = 0;
    return (V)super.put(paramK, paramV);
  }
  
  public void putAll(SimpleArrayMap<? extends K, ? extends V> paramSimpleArrayMap) {
    this.i = 0;
    super.putAll(paramSimpleArrayMap);
  }
  
  public V removeAt(int paramInt) {
    this.i = 0;
    return (V)super.removeAt(paramInt);
  }
  
  public V setValueAt(int paramInt, V paramV) {
    this.i = 0;
    return (V)super.setValueAt(paramInt, paramV);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glid\\util\CachedHashCodeArrayMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */