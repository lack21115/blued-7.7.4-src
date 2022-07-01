package com.google.common.collect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class ArrayListMultimap<K, V> extends ArrayListMultimapGwtSerializationDependencies<K, V> {
  transient int a;
  
  private ArrayListMultimap() {
    this(12, 3);
  }
  
  private ArrayListMultimap(int paramInt1, int paramInt2) {
    super(Platform.a(paramInt1));
    CollectPreconditions.a(paramInt2, "expectedValuesPerKey");
    this.a = paramInt2;
  }
  
  List<V> a() {
    return new ArrayList<V>(this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ArrayListMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */