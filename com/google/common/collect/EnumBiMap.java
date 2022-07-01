package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class EnumBiMap<K extends Enum<K>, V extends Enum<V>> extends AbstractBiMap<K, V> {
  K a(K paramK) {
    return (K)Preconditions.a(paramK);
  }
  
  V b(V paramV) {
    return (V)Preconditions.a(paramV);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\EnumBiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */