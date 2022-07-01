package com.google.common.hash;

import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;

final class LongAddables {
  private static final Supplier<LongAddable> a;
  
  static {
    Supplier<LongAddable> supplier;
    try {
      new LongAdder();
      supplier = new Supplier<LongAddable>() {
          public LongAddable a() {
            return new LongAdder();
          }
        };
    } finally {
      Exception exception = null;
    } 
  }
  
  static final class PureJavaLongAddable extends AtomicLong implements LongAddable {
    private PureJavaLongAddable() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\hash\LongAddables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */