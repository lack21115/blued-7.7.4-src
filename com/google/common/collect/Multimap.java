package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@DoNotMock("Use ImmutableMultimap, HashMultimap, or another implementation")
public interface Multimap<K, V> {
  boolean a(@NullableDecl K paramK, @NullableDecl V paramV);
  
  boolean b(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2);
  
  Collection<V> c(@NullableDecl K paramK);
  
  Map<K, Collection<V>> c();
  
  boolean c(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2);
  
  Collection<V> d(@NullableDecl Object paramObject);
  
  boolean equals(@NullableDecl Object paramObject);
  
  int f();
  
  boolean f(@NullableDecl Object paramObject);
  
  void g();
  
  boolean g(@NullableDecl Object paramObject);
  
  int hashCode();
  
  Collection<Map.Entry<K, V>> m();
  
  boolean r();
  
  Set<K> s();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\Multimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */