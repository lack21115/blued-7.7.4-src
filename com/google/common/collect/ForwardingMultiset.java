package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class ForwardingMultiset<E> extends ForwardingCollection<E> implements Multiset<E> {
  public int a(Object paramObject) {
    return g().a(paramObject);
  }
  
  public int a(E paramE, int paramInt) {
    return g().a(paramE, paramInt);
  }
  
  public boolean a(E paramE, int paramInt1, int paramInt2) {
    return g().a(paramE, paramInt1, paramInt2);
  }
  
  public int b(Object paramObject, int paramInt) {
    return g().b(paramObject, paramInt);
  }
  
  protected boolean b(Collection<? extends E> paramCollection) {
    return Multisets.a(this, paramCollection);
  }
  
  public int c(E paramE, int paramInt) {
    return g().c(paramE, paramInt);
  }
  
  protected boolean c(Collection<?> paramCollection) {
    return Multisets.b(this, paramCollection);
  }
  
  public Set<E> d() {
    return g().d();
  }
  
  protected boolean d(Collection<?> paramCollection) {
    return Multisets.c(this, paramCollection);
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    return (paramObject == this || g().equals(paramObject));
  }
  
  public Set<Multiset.Entry<E>> f() {
    return g().f();
  }
  
  protected abstract Multiset<E> g();
  
  public int hashCode() {
    return g().hashCode();
  }
  
  protected String n() {
    return f().toString();
  }
  
  public class StandardElementSet extends Multisets.ElementSet<E> {
    Multiset<E> a() {
      return this.a;
    }
    
    public Iterator<E> iterator() {
      return Multisets.a(a().f().iterator());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ForwardingMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */