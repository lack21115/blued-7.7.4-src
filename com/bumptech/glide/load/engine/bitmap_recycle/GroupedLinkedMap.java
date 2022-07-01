package com.bumptech.glide.load.engine.bitmap_recycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupedLinkedMap<K extends Poolable, V> {
  private final LinkedEntry<K, V> a = new LinkedEntry<K, V>();
  
  private final Map<K, LinkedEntry<K, V>> b = new HashMap<K, LinkedEntry<K, V>>();
  
  private void a(LinkedEntry<K, V> paramLinkedEntry) {
    d(paramLinkedEntry);
    LinkedEntry<K, V> linkedEntry = this.a;
    paramLinkedEntry.c = linkedEntry;
    paramLinkedEntry.b = linkedEntry.b;
    c(paramLinkedEntry);
  }
  
  private void b(LinkedEntry<K, V> paramLinkedEntry) {
    d(paramLinkedEntry);
    paramLinkedEntry.c = this.a.c;
    paramLinkedEntry.b = this.a;
    c(paramLinkedEntry);
  }
  
  private static <K, V> void c(LinkedEntry<K, V> paramLinkedEntry) {
    paramLinkedEntry.b.c = paramLinkedEntry;
    paramLinkedEntry.c.b = paramLinkedEntry;
  }
  
  private static <K, V> void d(LinkedEntry<K, V> paramLinkedEntry) {
    paramLinkedEntry.c.b = paramLinkedEntry.b;
    paramLinkedEntry.b.c = paramLinkedEntry.c;
  }
  
  public V a() {
    for (LinkedEntry<K, V> linkedEntry = this.a.c; !linkedEntry.equals(this.a); linkedEntry = linkedEntry.c) {
      V v = linkedEntry.a();
      if (v != null)
        return v; 
      d(linkedEntry);
      this.b.remove(linkedEntry.a);
      ((Poolable)linkedEntry.a).a();
    } 
    return null;
  }
  
  public V a(K paramK) {
    LinkedEntry<K, Object> linkedEntry1;
    LinkedEntry<K, Object> linkedEntry2 = (LinkedEntry)this.b.get(paramK);
    if (linkedEntry2 == null) {
      linkedEntry2 = new LinkedEntry<K, Object>(paramK);
      this.b.put(paramK, linkedEntry2);
      linkedEntry1 = linkedEntry2;
    } else {
      linkedEntry1.a();
      linkedEntry1 = linkedEntry2;
    } 
    a((LinkedEntry)linkedEntry1);
    return (V)linkedEntry1.a();
  }
  
  public void a(K paramK, V paramV) {
    LinkedEntry<K, Object> linkedEntry1;
    LinkedEntry<K, Object> linkedEntry2 = (LinkedEntry)this.b.get(paramK);
    if (linkedEntry2 == null) {
      linkedEntry2 = new LinkedEntry<K, Object>(paramK);
      b((LinkedEntry)linkedEntry2);
      this.b.put(paramK, linkedEntry2);
      linkedEntry1 = linkedEntry2;
    } else {
      linkedEntry1.a();
      linkedEntry1 = linkedEntry2;
    } 
    linkedEntry1.a(paramV);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("GroupedLinkedMap( ");
    LinkedEntry<K, V> linkedEntry = this.a.b;
    boolean bool = false;
    while (!linkedEntry.equals(this.a)) {
      bool = true;
      stringBuilder.append('{');
      stringBuilder.append(linkedEntry.a);
      stringBuilder.append(':');
      stringBuilder.append(linkedEntry.b());
      stringBuilder.append("}, ");
      linkedEntry = linkedEntry.b;
    } 
    if (bool)
      stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()); 
    stringBuilder.append(" )");
    return stringBuilder.toString();
  }
  
  static class LinkedEntry<K, V> {
    final K a;
    
    LinkedEntry<K, V> b = this;
    
    LinkedEntry<K, V> c = this;
    
    private List<V> d;
    
    LinkedEntry() {
      this(null);
    }
    
    LinkedEntry(K param1K) {
      this.a = param1K;
    }
    
    public V a() {
      int i = b();
      return (i > 0) ? this.d.remove(i - 1) : null;
    }
    
    public void a(V param1V) {
      if (this.d == null)
        this.d = new ArrayList<V>(); 
      this.d.add(param1V);
    }
    
    public int b() {
      List<V> list = this.d;
      return (list != null) ? list.size() : 0;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\bitmap_recycle\GroupedLinkedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */