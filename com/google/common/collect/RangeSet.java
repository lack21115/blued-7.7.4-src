package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Set;

@DoNotMock("Use ImmutableRangeSet or TreeRangeSet")
public interface RangeSet<C extends Comparable> {
  Set<Range<C>> e();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\RangeSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */