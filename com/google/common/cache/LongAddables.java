package com.google.common.cache;

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
  
  public static LongAddable a() {
    return (LongAddable)a.get();
  }
  
  static final class PureJavaLongAddable extends AtomicLong implements LongAddable {
    private PureJavaLongAddable() {}
    
    public void a() {
      getAndIncrement();
    }
    
    public void a(long param1Long) {
      getAndAdd(param1Long);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\cache\LongAddables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */