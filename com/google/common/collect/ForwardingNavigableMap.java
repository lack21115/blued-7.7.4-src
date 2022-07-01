package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;

public abstract class ForwardingNavigableMap<K, V> extends ForwardingSortedMap<K, V> implements NavigableMap<K, V> {
  public class StandardDescendingMap extends Maps.DescendingMap<K, V> {
    NavigableMap<K, V> c() {
      return this.a;
    }
    
    protected Iterator<Map.Entry<K, V>> d() {
      return new Iterator<Map.Entry<K, V>>(this) {
          private Map.Entry<K, V> b = null;
          
          private Map.Entry<K, V> c = this.a.c().lastEntry();
          
          public Map.Entry<K, V> a() {
            if (hasNext())
              try {
                return this.c;
              } finally {
                this.b = this.c;
                this.c = this.a.c().lowerEntry(this.c.getKey());
              }  
            throw new NoSuchElementException();
          }
          
          public boolean hasNext() {
            return (this.c != null);
          }
          
          public void remove() {
            boolean bool;
            if (this.b != null) {
              bool = true;
            } else {
              bool = false;
            } 
            CollectPreconditions.a(bool);
            this.a.c().remove(this.b.getKey());
            this.b = null;
          }
        };
    }
  }
  
  class null implements Iterator<Map.Entry<K, V>> {
    private Map.Entry<K, V> b = null;
    
    private Map.Entry<K, V> c = this.a.c().lastEntry();
    
    null(ForwardingNavigableMap this$0) {}
    
    public Map.Entry<K, V> a() {
      if (hasNext())
        try {
          return this.c;
        } finally {
          this.b = this.c;
          this.c = this.a.c().lowerEntry(this.c.getKey());
        }  
      throw new NoSuchElementException();
    }
    
    public boolean hasNext() {
      return (this.c != null);
    }
    
    public void remove() {
      boolean bool;
      if (this.b != null) {
        bool = true;
      } else {
        bool = false;
      } 
      CollectPreconditions.a(bool);
      this.a.c().remove(this.b.getKey());
      this.b = null;
    }
  }
  
  public class StandardNavigableKeySet extends Maps.NavigableKeySet<K, V> {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ForwardingNavigableMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */