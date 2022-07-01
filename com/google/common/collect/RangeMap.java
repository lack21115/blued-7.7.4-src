package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Map;

@DoNotMock("Use ImmutableRangeMap or TreeRangeMap")
public interface RangeMap<K extends Comparable, V> {
  Map<Range<K>, V> b();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\RangeMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */