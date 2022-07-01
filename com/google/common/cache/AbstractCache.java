package com.google.common.cache;

public abstract class AbstractCache<K, V> implements Cache<K, V> {
  public static final class SimpleStatsCounter implements StatsCounter {
    private final LongAddable a = LongAddables.a();
    
    private final LongAddable b = LongAddables.a();
    
    private final LongAddable c = LongAddables.a();
    
    private final LongAddable d = LongAddables.a();
    
    private final LongAddable e = LongAddables.a();
    
    private final LongAddable f = LongAddables.a();
    
    public void a() {
      this.f.a();
    }
    
    public void a(int param1Int) {
      this.a.a(param1Int);
    }
    
    public void a(long param1Long) {
      this.c.a();
      this.e.a(param1Long);
    }
    
    public void b(int param1Int) {
      this.b.a(param1Int);
    }
    
    public void b(long param1Long) {
      this.d.a();
      this.e.a(param1Long);
    }
  }
  
  public static interface StatsCounter {
    void a();
    
    void a(int param1Int);
    
    void a(long param1Long);
    
    void b(int param1Int);
    
    void b(long param1Long);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\cache\AbstractCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */