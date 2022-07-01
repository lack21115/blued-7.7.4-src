package com.google.common.cache;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

interface ReferenceEntry<K, V> {
  LocalCache.ValueReference<K, V> a();
  
  void a(long paramLong);
  
  void a(LocalCache.ValueReference<K, V> paramValueReference);
  
  void a(ReferenceEntry<K, V> paramReferenceEntry);
  
  @NullableDecl
  ReferenceEntry<K, V> b();
  
  void b(long paramLong);
  
  void b(ReferenceEntry<K, V> paramReferenceEntry);
  
  int c();
  
  void c(ReferenceEntry<K, V> paramReferenceEntry);
  
  @NullableDecl
  K d();
  
  void d(ReferenceEntry<K, V> paramReferenceEntry);
  
  long e();
  
  ReferenceEntry<K, V> f();
  
  ReferenceEntry<K, V> g();
  
  long h();
  
  ReferenceEntry<K, V> i();
  
  ReferenceEntry<K, V> j();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\cache\ReferenceEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */