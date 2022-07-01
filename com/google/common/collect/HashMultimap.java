package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class HashMultimap<K, V> extends HashMultimapGwtSerializationDependencies<K, V> {
  transient int a;
  
  private HashMultimap() {
    this(12, 2);
  }
  
  private HashMultimap(int paramInt1, int paramInt2) {
    super(Platform.a(paramInt1));
    boolean bool;
    this.a = 2;
    if (paramInt2 >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool);
    this.a = paramInt2;
  }
  
  Set<V> a() {
    return Platform.c(this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\HashMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */