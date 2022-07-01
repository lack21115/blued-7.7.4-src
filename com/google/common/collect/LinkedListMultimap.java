package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class LinkedListMultimap<K, V> extends AbstractMultimap<K, V> implements ListMultimap<K, V>, Serializable {
  @NullableDecl
  private transient Node<K, V> a;
  
  @NullableDecl
  private transient Node<K, V> b;
  
  private transient Map<K, KeyList<K, V>> c;
  
  private transient int d;
  
  private transient int e;
  
  LinkedListMultimap() {
    this(12);
  }
  
  private LinkedListMultimap(int paramInt) {
    this.c = Platform.a(paramInt);
  }
  
  private Node<K, V> a(@NullableDecl K paramK, @NullableDecl V paramV, @NullableDecl Node<K, V> paramNode) {
    Node<K, V> node = new Node<K, V>(paramK, paramV);
    if (this.a == null) {
      this.b = node;
      this.a = node;
      this.c.put(paramK, new KeyList<K, V>(node));
      this.e++;
    } else {
      Node<K, V> node1;
      KeyList keyList;
      if (paramNode == null) {
        paramNode = this.b;
        paramNode.c = node;
        node.d = paramNode;
        this.b = node;
        keyList = this.c.get(paramK);
        if (keyList == null) {
          this.c.put(paramK, new KeyList<K, V>(node));
          this.e++;
        } else {
          keyList.c++;
          node1 = keyList.b;
          node1.e = node;
          node.f = node1;
          keyList.b = node;
        } 
      } else {
        KeyList keyList1 = this.c.get(node1);
        keyList1.c++;
        node.d = ((Node)keyList).d;
        node.f = ((Node)keyList).f;
        node.c = (Node<K, V>)keyList;
        node.e = (Node<K, V>)keyList;
        if (((Node)keyList).f == null) {
          ((KeyList)this.c.get(node1)).a = node;
        } else {
          ((Node)keyList).f.e = node;
        } 
        if (((Node)keyList).d == null) {
          this.a = node;
        } else {
          ((Node)keyList).d.c = node;
        } 
        ((Node)keyList).d = node;
        ((Node)keyList).f = node;
      } 
    } 
    this.d++;
    return node;
  }
  
  private void a(Node<K, V> paramNode) {
    if (paramNode.d != null) {
      paramNode.d.c = paramNode.c;
    } else {
      this.a = paramNode.c;
    } 
    if (paramNode.c != null) {
      paramNode.c.d = paramNode.d;
    } else {
      this.b = paramNode.d;
    } 
    if (paramNode.f == null && paramNode.e == null) {
      ((KeyList)this.c.remove(paramNode.a)).c = 0;
      this.e++;
    } else {
      KeyList keyList = this.c.get(paramNode.a);
      keyList.c--;
      if (paramNode.f == null) {
        keyList.a = paramNode.e;
      } else {
        paramNode.f.e = paramNode.e;
      } 
      if (paramNode.e == null) {
        keyList.b = paramNode.f;
      } else {
        paramNode.e.f = paramNode.f;
      } 
    } 
    this.d--;
  }
  
  private void h(@NullableDecl Object paramObject) {
    Iterators.h(new ValueForKeyIterator(this, paramObject));
  }
  
  private static void i(@NullableDecl Object paramObject) {
    if (paramObject != null)
      return; 
    throw new NoSuchElementException();
  }
  
  private List<V> j(@NullableDecl Object paramObject) {
    return Collections.unmodifiableList(Lists.a(new ValueForKeyIterator(this, paramObject)));
  }
  
  public List<V> a() {
    return (List<V>)super.j();
  }
  
  public List<V> a(@NullableDecl K paramK) {
    return new AbstractSequentialList<V>(this, paramK) {
        public ListIterator<V> listIterator(int param1Int) {
          return new LinkedListMultimap.ValueForKeyIterator(this.b, this.a, param1Int);
        }
        
        public int size() {
          LinkedListMultimap.KeyList keyList = (LinkedListMultimap.KeyList)LinkedListMultimap.d(this.b).get(this.a);
          return (keyList == null) ? 0 : keyList.c;
        }
      };
  }
  
  public boolean a(@NullableDecl K paramK, @NullableDecl V paramV) {
    a(paramK, paramV, null);
    return true;
  }
  
  List<V> b() {
    class ValuesImpl extends AbstractSequentialList<V> {
      ValuesImpl(LinkedListMultimap this$0) {}
      
      public ListIterator<V> listIterator(int param1Int) {
        LinkedListMultimap.NodeIterator nodeIterator = new LinkedListMultimap.NodeIterator(this.a, param1Int);
        return new TransformedListIterator<Map.Entry<K, V>, V>(this, nodeIterator, nodeIterator) {
            V a(Map.Entry<K, V> param2Entry) {
              return param2Entry.getValue();
            }
            
            public void set(V param2V) {
              this.a.a(param2V);
            }
          };
      }
      
      public int size() {
        return LinkedListMultimap.e(this.a);
      }
    };
    return new ValuesImpl(this);
  }
  
  public List<V> b(@NullableDecl Object paramObject) {
    List<V> list = j(paramObject);
    h(paramObject);
    return list;
  }
  
  public List<Map.Entry<K, V>> d() {
    return (List<Map.Entry<K, V>>)super.m();
  }
  
  List<Map.Entry<K, V>> e() {
    class EntriesImpl extends AbstractSequentialList<Map.Entry<K, V>> {
      EntriesImpl(LinkedListMultimap this$0) {}
      
      public ListIterator<Map.Entry<K, V>> listIterator(int param1Int) {
        return new LinkedListMultimap.NodeIterator(this.a, param1Int);
      }
      
      public int size() {
        return LinkedListMultimap.e(this.a);
      }
    };
    return new EntriesImpl(this);
  }
  
  public int f() {
    return this.d;
  }
  
  public boolean f(@NullableDecl Object paramObject) {
    return this.c.containsKey(paramObject);
  }
  
  public void g() {
    this.a = null;
    this.b = null;
    this.c.clear();
    this.d = 0;
    this.e++;
  }
  
  public boolean g(@NullableDecl Object paramObject) {
    return a().contains(paramObject);
  }
  
  Set<K> h() {
    class KeySetImpl extends Sets.ImprovedAbstractSet<K> {
      KeySetImpl(LinkedListMultimap this$0) {}
      
      public boolean contains(Object param1Object) {
        return this.a.f(param1Object);
      }
      
      public Iterator<K> iterator() {
        return new LinkedListMultimap.DistinctKeyIterator();
      }
      
      public boolean remove(Object param1Object) {
        return this.a.b(param1Object).isEmpty() ^ true;
      }
      
      public int size() {
        return LinkedListMultimap.d(this.a).size();
      }
    };
    return new KeySetImpl(this);
  }
  
  Iterator<Map.Entry<K, V>> o() {
    throw new AssertionError("should never be called");
  }
  
  Map<K, Collection<V>> p() {
    return new Multimaps.AsMap<K, V>(this);
  }
  
  public boolean r() {
    return (this.a == null);
  }
  
  class DistinctKeyIterator implements Iterator<K> {
    final Set<K> a = Sets.a(this.e.s().size());
    
    LinkedListMultimap.Node<K, V> b = LinkedListMultimap.c(this.e);
    
    @NullableDecl
    LinkedListMultimap.Node<K, V> c;
    
    int d = LinkedListMultimap.a(this.e);
    
    private DistinctKeyIterator(LinkedListMultimap this$0) {}
    
    private void a() {
      if (LinkedListMultimap.a(this.e) == this.d)
        return; 
      throw new ConcurrentModificationException();
    }
    
    public boolean hasNext() {
      a();
      return (this.b != null);
    }
    
    public K next() {
      LinkedListMultimap.Node<K, V> node;
      a();
      LinkedListMultimap.e(this.b);
      this.c = this.b;
      this.a.add(this.c.a);
      do {
        this.b = this.b.c;
        node = this.b;
      } while (node != null && !this.a.add(node.a));
      return this.c.a;
    }
    
    public void remove() {
      boolean bool;
      a();
      if (this.c != null) {
        bool = true;
      } else {
        bool = false;
      } 
      CollectPreconditions.a(bool);
      LinkedListMultimap.a(this.e, this.c.a);
      this.c = null;
      this.d = LinkedListMultimap.a(this.e);
    }
  }
  
  static class KeyList<K, V> {
    LinkedListMultimap.Node<K, V> a;
    
    LinkedListMultimap.Node<K, V> b;
    
    int c;
    
    KeyList(LinkedListMultimap.Node<K, V> param1Node) {
      this.a = param1Node;
      this.b = param1Node;
      param1Node.f = null;
      param1Node.e = null;
      this.c = 1;
    }
  }
  
  static final class Node<K, V> extends AbstractMapEntry<K, V> {
    @NullableDecl
    final K a;
    
    @NullableDecl
    V b;
    
    @NullableDecl
    Node<K, V> c;
    
    @NullableDecl
    Node<K, V> d;
    
    @NullableDecl
    Node<K, V> e;
    
    @NullableDecl
    Node<K, V> f;
    
    Node(@NullableDecl K param1K, @NullableDecl V param1V) {
      this.a = param1K;
      this.b = param1V;
    }
    
    public K getKey() {
      return this.a;
    }
    
    public V getValue() {
      return this.b;
    }
    
    public V setValue(@NullableDecl V param1V) {
      V v = this.b;
      this.b = param1V;
      return v;
    }
  }
  
  class NodeIterator implements ListIterator<Map.Entry<K, V>> {
    int a;
    
    @NullableDecl
    LinkedListMultimap.Node<K, V> b;
    
    @NullableDecl
    LinkedListMultimap.Node<K, V> c;
    
    @NullableDecl
    LinkedListMultimap.Node<K, V> d;
    
    int e = LinkedListMultimap.a(this.f);
    
    NodeIterator(LinkedListMultimap this$0, int param1Int) {
      int i = this$0.f();
      Preconditions.b(param1Int, i);
      if (param1Int >= i / 2) {
        this.d = LinkedListMultimap.b(this$0);
        this.a = i;
        while (param1Int < i) {
          b();
          param1Int++;
        } 
      } else {
        this.b = LinkedListMultimap.c(this$0);
        while (param1Int > 0) {
          a();
          param1Int--;
        } 
      } 
      this.c = null;
    }
    
    private void c() {
      if (LinkedListMultimap.a(this.f) == this.e)
        return; 
      throw new ConcurrentModificationException();
    }
    
    public LinkedListMultimap.Node<K, V> a() {
      c();
      LinkedListMultimap.e(this.b);
      LinkedListMultimap.Node<K, V> node = this.b;
      this.c = node;
      this.d = node;
      this.b = node.c;
      this.a++;
      return this.c;
    }
    
    void a(V param1V) {
      boolean bool;
      if (this.c != null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.b(bool);
      this.c.b = param1V;
    }
    
    public void a(Map.Entry<K, V> param1Entry) {
      throw new UnsupportedOperationException();
    }
    
    public LinkedListMultimap.Node<K, V> b() {
      c();
      LinkedListMultimap.e(this.d);
      LinkedListMultimap.Node<K, V> node = this.d;
      this.c = node;
      this.b = node;
      this.d = node.d;
      this.a--;
      return this.c;
    }
    
    public void b(Map.Entry<K, V> param1Entry) {
      throw new UnsupportedOperationException();
    }
    
    public boolean hasNext() {
      c();
      return (this.b != null);
    }
    
    public boolean hasPrevious() {
      c();
      return (this.d != null);
    }
    
    public int nextIndex() {
      return this.a;
    }
    
    public int previousIndex() {
      return this.a - 1;
    }
    
    public void remove() {
      boolean bool;
      c();
      if (this.c != null) {
        bool = true;
      } else {
        bool = false;
      } 
      CollectPreconditions.a(bool);
      LinkedListMultimap.Node<K, V> node = this.c;
      if (node != this.b) {
        this.d = node.d;
        this.a--;
      } else {
        this.b = node.c;
      } 
      LinkedListMultimap.a(this.f, this.c);
      this.c = null;
      this.e = LinkedListMultimap.a(this.f);
    }
  }
  
  class ValueForKeyIterator implements ListIterator<V> {
    @NullableDecl
    final Object a;
    
    int b;
    
    @NullableDecl
    LinkedListMultimap.Node<K, V> c;
    
    @NullableDecl
    LinkedListMultimap.Node<K, V> d;
    
    @NullableDecl
    LinkedListMultimap.Node<K, V> e;
    
    ValueForKeyIterator(@NullableDecl LinkedListMultimap this$0, Object param1Object) {
      LinkedListMultimap.Node<K, V> node;
      this.a = param1Object;
      LinkedListMultimap.KeyList keyList = (LinkedListMultimap.KeyList)LinkedListMultimap.d(this$0).get(param1Object);
      if (keyList == null) {
        keyList = null;
      } else {
        node = keyList.a;
      } 
      this.c = node;
    }
    
    public ValueForKeyIterator(@NullableDecl LinkedListMultimap this$0, Object param1Object, int param1Int) {
      LinkedListMultimap.Node<K, V> node;
      int i;
      LinkedListMultimap.KeyList keyList = (LinkedListMultimap.KeyList)LinkedListMultimap.d(this$0).get(param1Object);
      if (keyList == null) {
        i = 0;
      } else {
        i = keyList.c;
      } 
      Preconditions.b(param1Int, i);
      if (param1Int >= i / 2) {
        if (keyList == null) {
          keyList = null;
        } else {
          node = keyList.b;
        } 
        this.e = node;
        this.b = i;
        while (param1Int < i) {
          previous();
          param1Int++;
        } 
      } else {
        if (node == null) {
          node = null;
        } else {
          node = ((LinkedListMultimap.KeyList)node).a;
        } 
        this.c = node;
        while (param1Int > 0) {
          next();
          param1Int--;
        } 
      } 
      this.a = param1Object;
      this.d = null;
    }
    
    public void add(V param1V) {
      this.e = LinkedListMultimap.a(this.f, this.a, param1V, this.c);
      this.b++;
      this.d = null;
    }
    
    public boolean hasNext() {
      return (this.c != null);
    }
    
    public boolean hasPrevious() {
      return (this.e != null);
    }
    
    public V next() {
      LinkedListMultimap.e(this.c);
      LinkedListMultimap.Node<K, V> node = this.c;
      this.d = node;
      this.e = node;
      this.c = node.e;
      this.b++;
      return this.d.b;
    }
    
    public int nextIndex() {
      return this.b;
    }
    
    public V previous() {
      LinkedListMultimap.e(this.e);
      LinkedListMultimap.Node<K, V> node = this.e;
      this.d = node;
      this.c = node;
      this.e = node.f;
      this.b--;
      return this.d.b;
    }
    
    public int previousIndex() {
      return this.b - 1;
    }
    
    public void remove() {
      boolean bool;
      if (this.d != null) {
        bool = true;
      } else {
        bool = false;
      } 
      CollectPreconditions.a(bool);
      LinkedListMultimap.Node<K, V> node = this.d;
      if (node != this.c) {
        this.e = node.f;
        this.b--;
      } else {
        this.c = node.e;
      } 
      LinkedListMultimap.a(this.f, this.d);
      this.d = null;
    }
    
    public void set(V param1V) {
      boolean bool;
      if (this.d != null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.b(bool);
      this.d.b = param1V;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\LinkedListMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */