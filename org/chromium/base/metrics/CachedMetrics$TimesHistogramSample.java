package org.chromium.base.metrics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.chromium.base.library_loader.LibraryLoader;

public final class CachedMetrics$TimesHistogramSample extends CachedMetrics$CachedMetric {
  private final List mSamples = new ArrayList();
  
  private final TimeUnit mTimeUnit;
  
  public CachedMetrics$TimesHistogramSample(String paramString, TimeUnit paramTimeUnit) {
    super(paramString);
    RecordHistogram.assertTimesHistogramSupportsUnit(paramTimeUnit);
    this.mTimeUnit = paramTimeUnit;
  }
  
  private void recordWithNative(long paramLong) {
    RecordHistogram.recordTimesHistogram(this.mName, paramLong, this.mTimeUnit);
  }
  
  protected final void commitAndClear() {
    Iterator<Long> iterator = this.mSamples.iterator();
    while (iterator.hasNext())
      recordWithNative(((Long)iterator.next()).longValue()); 
    this.mSamples.clear();
  }
  
  public final void record(long paramLong) {
    synchronized (CachedMetrics$CachedMetric.sMetrics) {
      if ((LibraryLoader.getInstance()).mInitialized) {
        recordWithNative(paramLong);
      } else {
        this.mSamples.add(Long.valueOf(paramLong));
        addToCache();
      } 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\metrics\CachedMetrics$TimesHistogramSample.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */