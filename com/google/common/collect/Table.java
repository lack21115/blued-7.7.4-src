package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@DoNotMock("Use ImmutableTable, HashBasedTable, or another implementation")
public interface Table<R, C, V> {
  @NullableDecl
  V a(R paramR, C paramC, V paramV);
  
  Set<R> a();
  
  boolean a(@NullableDecl Object paramObject);
  
  boolean a(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2);
  
  @NullableDecl
  V b(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2);
  
  Set<C> b();
  
  boolean b(@NullableDecl Object paramObject);
  
  @NullableDecl
  V c(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2);
  
  boolean c(@NullableDecl Object paramObject);
  
  Map<R, V> d(C paramC);
  
  void d();
  
  Map<C, V> e(R paramR);
  
  Set<Cell<R, C, V>> e();
  
  boolean equals(@NullableDecl Object paramObject);
  
  Collection<V> h();
  
  int hashCode();
  
  int k();
  
  Map<C, Map<R, V>> m();
  
  Map<R, Map<C, V>> o();
  
  public static interface Cell<R, C, V> {
    @NullableDecl
    R a();
    
    @NullableDecl
    C b();
    
    @NullableDecl
    V c();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\Table.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */