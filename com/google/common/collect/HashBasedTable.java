package com.google.common.collect;

import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class HashBasedTable<R, C, V> extends StandardTable<R, C, V> {
  public boolean a(@NullableDecl Object paramObject) {
    return super.a(paramObject);
  }
  
  public boolean a(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2) {
    return super.a(paramObject1, paramObject2);
  }
  
  public V b(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2) {
    return super.b(paramObject1, paramObject2);
  }
  
  public boolean b(@NullableDecl Object paramObject) {
    return super.b(paramObject);
  }
  
  public V c(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2) {
    return super.c(paramObject1, paramObject2);
  }
  
  public boolean c(@NullableDecl Object paramObject) {
    return super.c(paramObject);
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    return super.equals(paramObject);
  }
  
  static class Factory<C, V> implements Supplier<Map<C, V>>, Serializable {
    final int a;
    
    public Map<C, V> a() {
      return Maps.b(this.a);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\HashBasedTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */