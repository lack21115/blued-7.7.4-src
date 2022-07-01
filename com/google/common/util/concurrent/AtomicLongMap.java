package com.google.common.util.concurrent;

import com.google.common.base.Function;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public final class AtomicLongMap<K> implements Serializable {
  private final ConcurrentHashMap<K, AtomicLong> a;
  
  public String toString() {
    return this.a.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\AtomicLongMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */