package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class FilteredMultimapValues<K, V> extends AbstractCollection<V> {
  private final FilteredMultimap<K, V> a;
  
  FilteredMultimapValues(FilteredMultimap<K, V> paramFilteredMultimap) {
    this.a = (FilteredMultimap<K, V>)Preconditions.a(paramFilteredMultimap);
  }
  
  public void clear() {
    this.a.g();
  }
  
  public boolean contains(@NullableDecl Object paramObject) {
    return this.a.g(paramObject);
  }
  
  public Iterator<V> iterator() {
    return Maps.b(this.a.m().iterator());
  }
  
  public boolean remove(@NullableDecl Object paramObject) {
    Predicate<? super Map.Entry<K, V>> predicate = this.a.b();
    Iterator<Map.Entry> iterator = this.a.a().m().iterator();
    while (iterator.hasNext()) {
      Map.Entry entry = iterator.next();
      if (predicate.a(entry) && Objects.a(entry.getValue(), paramObject)) {
        iterator.remove();
        return true;
      } 
    } 
    return false;
  }
  
  public boolean removeAll(Collection<?> paramCollection) {
    return Iterables.a(this.a.a().m(), Predicates.a(this.a.b(), Maps.b(Predicates.a(paramCollection))));
  }
  
  public boolean retainAll(Collection<?> paramCollection) {
    return Iterables.a(this.a.a().m(), Predicates.a(this.a.b(), Maps.b(Predicates.a(Predicates.a(paramCollection)))));
  }
  
  public int size() {
    return this.a.f();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\FilteredMultimapValues.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */