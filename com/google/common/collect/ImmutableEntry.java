package com.google.common.collect;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class ImmutableEntry<K, V> extends AbstractMapEntry<K, V> implements Serializable {
  @NullableDecl
  final K a;
  
  @NullableDecl
  final V b;
  
  ImmutableEntry(@NullableDecl K paramK, @NullableDecl V paramV) {
    this.a = paramK;
    this.b = paramV;
  }
  
  @NullableDecl
  public final K getKey() {
    return this.a;
  }
  
  @NullableDecl
  public final V getValue() {
    return this.b;
  }
  
  public final V setValue(V paramV) {
    throw new UnsupportedOperationException();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ImmutableEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */