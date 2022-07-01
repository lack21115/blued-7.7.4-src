package org.chromium.base.metrics;

import java.util.List;

abstract class CachedMetrics$CachedMetric {
  static final List sMetrics;
  
  private boolean mCached;
  
  protected final String mName;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  protected CachedMetrics$CachedMetric(String paramString) {
    this.mName = paramString;
  }
  
  protected final void addToCache() {
    assert false;
    throw new AssertionError();
  }
  
  protected abstract void commitAndClear();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\metrics\CachedMetrics$CachedMetric.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */