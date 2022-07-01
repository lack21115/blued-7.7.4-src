package androidx.collection;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {
  MapCollections<K, V> a;
  
  public ArrayMap() {}
  
  public ArrayMap(int paramInt) {
    super(paramInt);
  }
  
  public ArrayMap(SimpleArrayMap<K, V> paramSimpleArrayMap) {
    super(paramSimpleArrayMap);
  }
  
  private MapCollections<K, V> b() {
    if (this.a == null)
      this.a = new MapCollections<K, V>(this) {
          protected int a() {
            return this.a.h;
          }
          
          protected int a(Object param1Object) {
            return this.a.indexOfKey(param1Object);
          }
          
          protected Object a(int param1Int1, int param1Int2) {
            return this.a.g[(param1Int1 << 1) + param1Int2];
          }
          
          protected V a(int param1Int, V param1V) {
            return (V)this.a.setValueAt(param1Int, param1V);
          }
          
          protected void a(int param1Int) {
            this.a.removeAt(param1Int);
          }
          
          protected void a(K param1K, V param1V) {
            this.a.put(param1K, param1V);
          }
          
          protected int b(Object param1Object) {
            return this.a.a(param1Object);
          }
          
          protected Map<K, V> b() {
            return this.a;
          }
          
          protected void c() {
            this.a.clear();
          }
        }; 
    return this.a;
  }
  
  public boolean containsAll(Collection<?> paramCollection) {
    return MapCollections.containsAllHelper(this, paramCollection);
  }
  
  public Set<Map.Entry<K, V>> entrySet() {
    return b().getEntrySet();
  }
  
  public Set<K> keySet() {
    return b().getKeySet();
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap) {
    ensureCapacity(this.h + paramMap.size());
    for (Map.Entry<? extends K, ? extends V> entry : paramMap.entrySet())
      put((K)entry.getKey(), (V)entry.getValue()); 
  }
  
  public boolean removeAll(Collection<?> paramCollection) {
    return MapCollections.removeAllHelper(this, paramCollection);
  }
  
  public boolean retainAll(Collection<?> paramCollection) {
    return MapCollections.retainAllHelper(this, paramCollection);
  }
  
  public Collection<V> values() {
    return b().getValues();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\collection\ArrayMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */