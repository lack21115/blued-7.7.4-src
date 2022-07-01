package androidx.collection;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

abstract class MapCollections<K, V> {
  EntrySet b;
  
  KeySet c;
  
  ValuesCollection d;
  
  public static <K, V> boolean containsAllHelper(Map<K, V> paramMap, Collection<?> paramCollection) {
    Iterator<?> iterator = paramCollection.iterator();
    while (iterator.hasNext()) {
      if (!paramMap.containsKey(iterator.next()))
        return false; 
    } 
    return true;
  }
  
  public static <T> boolean equalsSetHelper(Set<T> paramSet, Object paramObject) {
    if (paramSet == paramObject)
      return true; 
    if (paramObject instanceof Set) {
      paramObject = paramObject;
      try {
        if (paramSet.size() == paramObject.size()) {
          boolean bool = paramSet.containsAll((Collection<?>)paramObject);
          if (bool)
            return true; 
        } 
        return false;
      } catch (NullPointerException|ClassCastException nullPointerException) {
        return false;
      } 
    } 
    return false;
  }
  
  public static <K, V> boolean removeAllHelper(Map<K, V> paramMap, Collection<?> paramCollection) {
    int i = paramMap.size();
    Iterator<?> iterator = paramCollection.iterator();
    while (iterator.hasNext())
      paramMap.remove(iterator.next()); 
    return (i != paramMap.size());
  }
  
  public static <K, V> boolean retainAllHelper(Map<K, V> paramMap, Collection<?> paramCollection) {
    int i = paramMap.size();
    Iterator iterator = paramMap.keySet().iterator();
    while (iterator.hasNext()) {
      if (!paramCollection.contains(iterator.next()))
        iterator.remove(); 
    } 
    return (i != paramMap.size());
  }
  
  protected abstract int a();
  
  protected abstract int a(Object paramObject);
  
  protected abstract Object a(int paramInt1, int paramInt2);
  
  protected abstract V a(int paramInt, V paramV);
  
  protected abstract void a(int paramInt);
  
  protected abstract void a(K paramK, V paramV);
  
  protected abstract int b(Object paramObject);
  
  protected abstract Map<K, V> b();
  
  protected abstract void c();
  
  public Set<Map.Entry<K, V>> getEntrySet() {
    if (this.b == null)
      this.b = new EntrySet(this); 
    return this.b;
  }
  
  public Set<K> getKeySet() {
    if (this.c == null)
      this.c = new KeySet(this); 
    return this.c;
  }
  
  public Collection<V> getValues() {
    if (this.d == null)
      this.d = new ValuesCollection(this); 
    return this.d;
  }
  
  public Object[] toArrayHelper(int paramInt) {
    int j = a();
    Object[] arrayOfObject = new Object[j];
    for (int i = 0; i < j; i++)
      arrayOfObject[i] = a(i, paramInt); 
    return arrayOfObject;
  }
  
  public <T> T[] toArrayHelper(T[] paramArrayOfT, int paramInt) {
    int j = a();
    T[] arrayOfT = paramArrayOfT;
    if (paramArrayOfT.length < j)
      arrayOfT = (T[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), j); 
    for (int i = 0; i < j; i++)
      arrayOfT[i] = (T)a(i, paramInt); 
    if (arrayOfT.length > j)
      arrayOfT[j] = null; 
    return arrayOfT;
  }
  
  final class ArrayIterator<T> implements Iterator<T> {
    final int a;
    
    int b;
    
    int c;
    
    boolean d = false;
    
    ArrayIterator(MapCollections this$0, int param1Int) {
      this.a = param1Int;
      this.b = this$0.a();
    }
    
    public boolean hasNext() {
      return (this.c < this.b);
    }
    
    public T next() {
      if (hasNext()) {
        Object object = this.e.a(this.c, this.a);
        this.c++;
        this.d = true;
        return (T)object;
      } 
      throw new NoSuchElementException();
    }
    
    public void remove() {
      if (this.d) {
        this.c--;
        this.b--;
        this.d = false;
        this.e.a(this.c);
        return;
      } 
      throw new IllegalStateException();
    }
  }
  
  final class EntrySet implements Set<Map.Entry<K, V>> {
    EntrySet(MapCollections this$0) {}
    
    public boolean add(Map.Entry<K, V> param1Entry) {
      throw new UnsupportedOperationException();
    }
    
    public boolean addAll(Collection<? extends Map.Entry<K, V>> param1Collection) {
      int i = this.a.a();
      for (Map.Entry<K, V> entry : param1Collection)
        this.a.a(entry.getKey(), entry.getValue()); 
      return (i != this.a.a());
    }
    
    public void clear() {
      this.a.c();
    }
    
    public boolean contains(Object param1Object) {
      if (!(param1Object instanceof Map.Entry))
        return false; 
      param1Object = param1Object;
      int i = this.a.a(param1Object.getKey());
      return (i < 0) ? false : ContainerHelpers.equal(this.a.a(i, 1), param1Object.getValue());
    }
    
    public boolean containsAll(Collection<?> param1Collection) {
      Iterator<?> iterator = param1Collection.iterator();
      while (iterator.hasNext()) {
        if (!contains(iterator.next()))
          return false; 
      } 
      return true;
    }
    
    public boolean equals(Object param1Object) {
      return MapCollections.equalsSetHelper(this, param1Object);
    }
    
    public int hashCode() {
      int i = this.a.a() - 1;
      int j = 0;
      while (i >= 0) {
        int k;
        int m;
        Object object1 = this.a.a(i, 0);
        Object object2 = this.a.a(i, 1);
        if (object1 == null) {
          k = 0;
        } else {
          k = object1.hashCode();
        } 
        if (object2 == null) {
          m = 0;
        } else {
          m = object2.hashCode();
        } 
        j += k ^ m;
        i--;
      } 
      return j;
    }
    
    public boolean isEmpty() {
      return (this.a.a() == 0);
    }
    
    public Iterator<Map.Entry<K, V>> iterator() {
      return new MapCollections.MapIterator(this.a);
    }
    
    public boolean remove(Object param1Object) {
      throw new UnsupportedOperationException();
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      throw new UnsupportedOperationException();
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      throw new UnsupportedOperationException();
    }
    
    public int size() {
      return this.a.a();
    }
    
    public Object[] toArray() {
      throw new UnsupportedOperationException();
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      throw new UnsupportedOperationException();
    }
  }
  
  final class KeySet implements Set<K> {
    KeySet(MapCollections this$0) {}
    
    public boolean add(K param1K) {
      throw new UnsupportedOperationException();
    }
    
    public boolean addAll(Collection<? extends K> param1Collection) {
      throw new UnsupportedOperationException();
    }
    
    public void clear() {
      this.a.c();
    }
    
    public boolean contains(Object param1Object) {
      return (this.a.a(param1Object) >= 0);
    }
    
    public boolean containsAll(Collection<?> param1Collection) {
      return MapCollections.containsAllHelper(this.a.b(), param1Collection);
    }
    
    public boolean equals(Object param1Object) {
      return MapCollections.equalsSetHelper(this, param1Object);
    }
    
    public int hashCode() {
      int i = this.a.a() - 1;
      int j = 0;
      while (i >= 0) {
        int k;
        Object object = this.a.a(i, 0);
        if (object == null) {
          k = 0;
        } else {
          k = object.hashCode();
        } 
        j += k;
        i--;
      } 
      return j;
    }
    
    public boolean isEmpty() {
      return (this.a.a() == 0);
    }
    
    public Iterator<K> iterator() {
      return new MapCollections.ArrayIterator<K>(this.a, 0);
    }
    
    public boolean remove(Object param1Object) {
      int i = this.a.a(param1Object);
      if (i >= 0) {
        this.a.a(i);
        return true;
      } 
      return false;
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      return MapCollections.removeAllHelper(this.a.b(), param1Collection);
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return MapCollections.retainAllHelper(this.a.b(), param1Collection);
    }
    
    public int size() {
      return this.a.a();
    }
    
    public Object[] toArray() {
      return this.a.toArrayHelper(0);
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      return (T[])this.a.toArrayHelper((Object[])param1ArrayOfT, 0);
    }
  }
  
  final class MapIterator implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {
    int a;
    
    int b;
    
    boolean c = false;
    
    MapIterator(MapCollections this$0) {
      this.a = this$0.a() - 1;
      this.b = -1;
    }
    
    public boolean equals(Object param1Object) {
      if (this.c) {
        boolean bool = param1Object instanceof Map.Entry;
        boolean bool1 = false;
        if (!bool)
          return false; 
        param1Object = param1Object;
        bool = bool1;
        if (ContainerHelpers.equal(param1Object.getKey(), this.d.a(this.b, 0))) {
          bool = bool1;
          if (ContainerHelpers.equal(param1Object.getValue(), this.d.a(this.b, 1)))
            bool = true; 
        } 
        return bool;
      } 
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public K getKey() {
      if (this.c)
        return (K)this.d.a(this.b, 0); 
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public V getValue() {
      if (this.c)
        return (V)this.d.a(this.b, 1); 
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public boolean hasNext() {
      return (this.b < this.a);
    }
    
    public int hashCode() {
      if (this.c) {
        MapCollections mapCollections = this.d;
        int i = this.b;
        int j = 0;
        Object object1 = mapCollections.a(i, 0);
        Object object2 = this.d.a(this.b, 1);
        if (object1 == null) {
          i = 0;
        } else {
          i = object1.hashCode();
        } 
        if (object2 != null)
          j = object2.hashCode(); 
        return i ^ j;
      } 
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public Map.Entry<K, V> next() {
      if (hasNext()) {
        this.b++;
        this.c = true;
        return this;
      } 
      throw new NoSuchElementException();
    }
    
    public void remove() {
      if (this.c) {
        this.d.a(this.b);
        this.b--;
        this.a--;
        this.c = false;
        return;
      } 
      throw new IllegalStateException();
    }
    
    public V setValue(V param1V) {
      if (this.c)
        return (V)this.d.a(this.b, param1V); 
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(getKey());
      stringBuilder.append("=");
      stringBuilder.append(getValue());
      return stringBuilder.toString();
    }
  }
  
  final class ValuesCollection implements Collection<V> {
    ValuesCollection(MapCollections this$0) {}
    
    public boolean add(V param1V) {
      throw new UnsupportedOperationException();
    }
    
    public boolean addAll(Collection<? extends V> param1Collection) {
      throw new UnsupportedOperationException();
    }
    
    public void clear() {
      this.a.c();
    }
    
    public boolean contains(Object param1Object) {
      return (this.a.b(param1Object) >= 0);
    }
    
    public boolean containsAll(Collection<?> param1Collection) {
      Iterator<?> iterator = param1Collection.iterator();
      while (iterator.hasNext()) {
        if (!contains(iterator.next()))
          return false; 
      } 
      return true;
    }
    
    public boolean isEmpty() {
      return (this.a.a() == 0);
    }
    
    public Iterator<V> iterator() {
      return new MapCollections.ArrayIterator<V>(this.a, 1);
    }
    
    public boolean remove(Object param1Object) {
      int i = this.a.b(param1Object);
      if (i >= 0) {
        this.a.a(i);
        return true;
      } 
      return false;
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      int j = this.a.a();
      int i = 0;
      boolean bool = false;
      while (i < j) {
        int k = j;
        int m = i;
        if (param1Collection.contains(this.a.a(i, 1))) {
          this.a.a(i);
          m = i - 1;
          k = j - 1;
          bool = true;
        } 
        i = m + 1;
        j = k;
      } 
      return bool;
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      int j = this.a.a();
      int i = 0;
      boolean bool = false;
      while (i < j) {
        int k = j;
        int m = i;
        if (!param1Collection.contains(this.a.a(i, 1))) {
          this.a.a(i);
          m = i - 1;
          k = j - 1;
          bool = true;
        } 
        i = m + 1;
        j = k;
      } 
      return bool;
    }
    
    public int size() {
      return this.a.a();
    }
    
    public Object[] toArray() {
      return this.a.toArrayHelper(1);
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      return (T[])this.a.toArrayHelper((Object[])param1ArrayOfT, 1);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\collection\MapCollections.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */