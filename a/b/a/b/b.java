package a.b.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class b<K, V> implements Iterable<Map.Entry<K, V>> {
  public c<K, V> b;
  
  public c<K, V> c;
  
  public WeakHashMap<f<K, V>, Boolean> d;
  
  public int e;
  
  public b() {
    new WeakHashMap<Object, Object>();
    throw new VerifyError("bad dex opcode");
  }
  
  public c<K, V> a(K paramK) {
    throw new VerifyError("bad dex opcode");
  }
  
  public d a() {
    new d(this);
    throw new VerifyError("bad dex opcode");
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof b))
      return false; 
    paramObject = paramObject;
    throw new VerifyError("bad dex opcode");
  }
  
  public int hashCode() {
    throw new VerifyError("bad dex opcode");
  }
  
  public Iterator<Map.Entry<K, V>> iterator() {
    throw new VerifyError("bad dex opcode");
  }
  
  public V remove(K paramK) {
    throw new VerifyError("bad dex opcode");
  }
  
  public String toString() {
    b.a.a.a.a.a("[");
    throw new VerifyError("bad dex opcode");
  }
  
  public static class a<K, V> extends e<K, V> {
    public a(b.c<K, V> param1c1, b.c<K, V> param1c2) {
      super(param1c1, param1c2);
      throw new VerifyError("bad dex opcode");
    }
    
    public b.c<K, V> b(b.c<K, V> param1c) {
      throw new VerifyError("bad dex opcode");
    }
    
    public b.c<K, V> c(b.c<K, V> param1c) {
      throw new VerifyError("bad dex opcode");
    }
  }
  
  public static class b<K, V> extends e<K, V> {
    public b(b.c<K, V> param1c1, b.c<K, V> param1c2) {
      super(param1c1, param1c2);
      throw new VerifyError("bad dex opcode");
    }
    
    public b.c<K, V> b(b.c<K, V> param1c) {
      throw new VerifyError("bad dex opcode");
    }
    
    public b.c<K, V> c(b.c<K, V> param1c) {
      throw new VerifyError("bad dex opcode");
    }
  }
  
  public static class c<K, V> implements Map.Entry<K, V> {
    public final K b;
    
    public final V c;
    
    public c<K, V> d;
    
    public c<K, V> e;
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof c))
        return false; 
      param1Object = param1Object;
      throw new VerifyError("bad dex opcode");
    }
    
    public K getKey() {
      throw new VerifyError("bad dex opcode");
    }
    
    public V getValue() {
      throw new VerifyError("bad dex opcode");
    }
    
    public int hashCode() {
      throw new VerifyError("bad dex opcode");
    }
    
    public V setValue(V param1V) {
      throw new UnsupportedOperationException("An entry modification is not supported");
    }
    
    public String toString() {
      new StringBuilder();
      throw new VerifyError("bad dex opcode");
    }
  }
  
  public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {
    public b.c<K, V> b;
    
    public boolean c;
    
    public d(b this$0) {}
    
    public void a(b.c<K, V> param1c) {
      throw new VerifyError("bad dex opcode");
    }
    
    public boolean hasNext() {
      throw new VerifyError("bad dex opcode");
    }
    
    public Object next() {
      throw new VerifyError("bad dex opcode");
    }
  }
  
  public static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {
    public b.c<K, V> b;
    
    public b.c<K, V> c;
    
    public e(b.c<K, V> param1c1, b.c<K, V> param1c2) {
      throw new VerifyError("bad dex opcode");
    }
    
    public final b.c<K, V> a() {
      throw new VerifyError("bad dex opcode");
    }
    
    public void a(b.c<K, V> param1c) {
      throw new VerifyError("bad dex opcode");
    }
    
    public abstract b.c<K, V> b(b.c<K, V> param1c);
    
    public abstract b.c<K, V> c(b.c<K, V> param1c);
    
    public boolean hasNext() {
      throw new VerifyError("bad dex opcode");
    }
    
    public Object next() {
      throw new VerifyError("bad dex opcode");
    }
  }
  
  public static interface f<K, V> {
    void a(b.c<K, V> param1c);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\a\b\a\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */