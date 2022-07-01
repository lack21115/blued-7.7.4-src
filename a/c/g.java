package a.c;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class g<K, V> {
  public b a;
  
  public c b;
  
  public e c;
  
  public g() {
    throw new VerifyError("bad dex opcode");
  }
  
  public static <K, V> boolean a(Map<K, V> paramMap, Collection<?> paramCollection) {
    int i = paramMap.size();
    Iterator iterator = paramMap.keySet().iterator();
    while (iterator.hasNext()) {
      if (!paramCollection.contains(iterator.next()))
        iterator.remove(); 
    } 
    return (i != paramMap.size());
  }
  
  public static <T> boolean a(Set<T> paramSet, Object paramObject) {
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
  
  public abstract int a(Object paramObject);
  
  public abstract Object a(int paramInt1, int paramInt2);
  
  public abstract V a(int paramInt, V paramV);
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(K paramK, V paramV);
  
  public <T> T[] a(T[] paramArrayOfT, int paramInt) {
    throw new VerifyError("bad dex opcode");
  }
  
  public abstract int b(Object paramObject);
  
  public abstract Map<K, V> b();
  
  public Object[] b(int paramInt) {
    throw new VerifyError("bad dex opcode");
  }
  
  public abstract int c();
  
  public final class a<T> implements Iterator<T> {
    public final int b;
    
    public int c;
    
    public int d;
    
    public boolean e;
    
    public a(g this$0, int param1Int) {}
    
    public boolean hasNext() {
      throw new VerifyError("bad dex opcode");
    }
    
    public T next() {
      throw new VerifyError("bad dex opcode");
    }
    
    public void remove() {
      throw new VerifyError("bad dex opcode");
    }
  }
  
  public final class b implements Set<Map.Entry<K, V>> {
    public b(g this$0) {}
    
    public boolean add(Object param1Object) {
      param1Object = param1Object;
      throw new UnsupportedOperationException();
    }
    
    public boolean addAll(Collection<? extends Map.Entry<K, V>> param1Collection) {
      throw new VerifyError("bad dex opcode");
    }
    
    public void clear() {
      throw new VerifyError("bad dex opcode");
    }
    
    public boolean contains(Object param1Object) {
      if (!(param1Object instanceof Map.Entry))
        return false; 
      param1Object = param1Object;
      throw new VerifyError("bad dex opcode");
    }
    
    public boolean containsAll(Collection<?> param1Collection) {
      Iterator<?> iterator = param1Collection.iterator();
      if (iterator.hasNext()) {
        iterator.next();
        throw new VerifyError("bad dex opcode");
      } 
      return true;
    }
    
    public boolean equals(Object param1Object) {
      return g.a(this, param1Object);
    }
    
    public int hashCode() {
      throw new VerifyError("bad dex opcode");
    }
    
    public boolean isEmpty() {
      throw new VerifyError("bad dex opcode");
    }
    
    public Iterator<Map.Entry<K, V>> iterator() {
      throw new VerifyError("bad dex opcode");
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
      throw new VerifyError("bad dex opcode");
    }
    
    public Object[] toArray() {
      throw new UnsupportedOperationException();
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      throw new UnsupportedOperationException();
    }
  }
  
  public final class c implements Set<K> {
    public c(g this$0) {}
    
    public boolean add(K param1K) {
      throw new UnsupportedOperationException();
    }
    
    public boolean addAll(Collection<? extends K> param1Collection) {
      throw new UnsupportedOperationException();
    }
    
    public void clear() {
      throw new VerifyError("bad dex opcode");
    }
    
    public boolean contains(Object param1Object) {
      throw new VerifyError("bad dex opcode");
    }
    
    public boolean containsAll(Collection<?> param1Collection) {
      throw new VerifyError("bad dex opcode");
    }
    
    public boolean equals(Object param1Object) {
      return g.a(this, param1Object);
    }
    
    public int hashCode() {
      throw new VerifyError("bad dex opcode");
    }
    
    public boolean isEmpty() {
      throw new VerifyError("bad dex opcode");
    }
    
    public Iterator<K> iterator() {
      throw new VerifyError("bad dex opcode");
    }
    
    public boolean remove(Object param1Object) {
      throw new VerifyError("bad dex opcode");
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      throw new VerifyError("bad dex opcode");
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      throw new VerifyError("bad dex opcode");
    }
    
    public int size() {
      throw new VerifyError("bad dex opcode");
    }
    
    public Object[] toArray() {
      throw new VerifyError("bad dex opcode");
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      throw new VerifyError("bad dex opcode");
    }
  }
  
  public final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {
    public int b;
    
    public int c;
    
    public boolean d;
    
    public d(g this$0) {}
    
    public boolean equals(Object param1Object) {
      throw new VerifyError("bad dex opcode");
    }
    
    public K getKey() {
      throw new VerifyError("bad dex opcode");
    }
    
    public V getValue() {
      throw new VerifyError("bad dex opcode");
    }
    
    public boolean hasNext() {
      throw new VerifyError("bad dex opcode");
    }
    
    public int hashCode() {
      throw new VerifyError("bad dex opcode");
    }
    
    public Object next() {
      throw new VerifyError("bad dex opcode");
    }
    
    public void remove() {
      throw new VerifyError("bad dex opcode");
    }
    
    public V setValue(V param1V) {
      throw new VerifyError("bad dex opcode");
    }
    
    public String toString() {
      new StringBuilder();
      throw new VerifyError("bad dex opcode");
    }
  }
  
  public final class e implements Collection<V> {
    public e(g this$0) {}
    
    public boolean add(V param1V) {
      throw new UnsupportedOperationException();
    }
    
    public boolean addAll(Collection<? extends V> param1Collection) {
      throw new UnsupportedOperationException();
    }
    
    public void clear() {
      throw new VerifyError("bad dex opcode");
    }
    
    public boolean contains(Object param1Object) {
      throw new VerifyError("bad dex opcode");
    }
    
    public boolean containsAll(Collection<?> param1Collection) {
      Iterator<?> iterator = param1Collection.iterator();
      if (iterator.hasNext()) {
        iterator.next();
        throw new VerifyError("bad dex opcode");
      } 
      return true;
    }
    
    public boolean isEmpty() {
      throw new VerifyError("bad dex opcode");
    }
    
    public Iterator<V> iterator() {
      throw new VerifyError("bad dex opcode");
    }
    
    public boolean remove(Object param1Object) {
      throw new VerifyError("bad dex opcode");
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      throw new VerifyError("bad dex opcode");
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      throw new VerifyError("bad dex opcode");
    }
    
    public int size() {
      throw new VerifyError("bad dex opcode");
    }
    
    public Object[] toArray() {
      throw new VerifyError("bad dex opcode");
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      throw new VerifyError("bad dex opcode");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\a\c\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */