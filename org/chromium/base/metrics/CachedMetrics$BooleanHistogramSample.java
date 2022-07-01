package org.chromium.base.metrics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.chromium.base.library_loader.LibraryLoader;

public final class CachedMetrics$BooleanHistogramSample extends CachedMetrics$CachedMetric {
  private final List mSamples = new ArrayList();
  
  public CachedMetrics$BooleanHistogramSample(String paramString) {
    super(paramString);
  }
  
  private void recordWithNative(boolean paramBoolean) {
    RecordHistogram.recordBooleanHistogram(this.mName, paramBoolean);
  }
  
  protected final void commitAndClear() {
    Iterator<Boolean> iterator = this.mSamples.iterator();
    while (iterator.hasNext())
      recordWithNative(((Boolean)iterator.next()).booleanValue()); 
    this.mSamples.clear();
  }
  
  public final void record(boolean paramBoolean) {
    synchronized (CachedMetrics$CachedMetric.sMetrics) {
      if ((LibraryLoader.getInstance()).mInitialized) {
        recordWithNative(paramBoolean);
      } else {
        this.mSamples.add(Boolean.valueOf(paramBoolean));
        addToCache();
      } 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\metrics\CachedMetrics$BooleanHistogramSample.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */