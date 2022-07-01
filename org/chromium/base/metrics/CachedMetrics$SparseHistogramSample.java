package org.chromium.base.metrics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.chromium.base.library_loader.LibraryLoader;

public final class CachedMetrics$SparseHistogramSample extends CachedMetrics$CachedMetric {
  private final List mSamples = new ArrayList();
  
  public CachedMetrics$SparseHistogramSample(String paramString) {
    super(paramString);
  }
  
  private void recordWithNative(int paramInt) {
    RecordHistogram.recordSparseSlowlyHistogram(this.mName, paramInt);
  }
  
  protected final void commitAndClear() {
    Iterator<Integer> iterator = this.mSamples.iterator();
    while (iterator.hasNext())
      recordWithNative(((Integer)iterator.next()).intValue()); 
    this.mSamples.clear();
  }
  
  public final void record(int paramInt) {
    synchronized (CachedMetrics$CachedMetric.sMetrics) {
      if ((LibraryLoader.getInstance()).mInitialized) {
        recordWithNative(paramInt);
      } else {
        this.mSamples.add(Integer.valueOf(paramInt));
        addToCache();
      } 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\metrics\CachedMetrics$SparseHistogramSample.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */