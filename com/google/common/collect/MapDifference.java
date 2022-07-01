package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Map;

@DoNotMock("Use Maps.difference")
public interface MapDifference<K, V> {
  Map<K, V> a();
  
  Map<K, V> b();
  
  Map<K, V> c();
  
  Map<K, ValueDifference<V>> d();
  
  @DoNotMock("Use Maps.difference")
  public static interface ValueDifference<V> {
    V a();
    
    V b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\MapDifference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */