package org.chromium.base.metrics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.chromium.base.library_loader.LibraryLoader;

public class CachedMetrics$CustomCountHistogramSample extends CachedMetrics$CachedMetric {
  private final int mMax;
  
  private final int mMin;
  
  private final int mNumBuckets;
  
  private final List mSamples = new ArrayList();
  
  public CachedMetrics$CustomCountHistogramSample(String paramString, int paramInt1, int paramInt2, int paramInt3) {
    super(paramString);
    this.mMin = paramInt1;
    this.mMax = paramInt2;
    this.mNumBuckets = paramInt3;
  }
  
  private void recordWithNative(int paramInt) {
    RecordHistogram.recordCustomCountHistogram(this.mName, paramInt, this.mMin, this.mMax, this.mNumBuckets);
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\metrics\CachedMetrics$CustomCountHistogramSample.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */