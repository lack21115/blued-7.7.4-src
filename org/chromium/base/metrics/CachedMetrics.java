package org.chromium.base.metrics;

import java.util.Iterator;

public class CachedMetrics {
  public static void commitCachedMetrics() {
    synchronized (CachedMetrics$CachedMetric.access$000()) {
      Iterator<CachedMetrics$CachedMetric> iterator = CachedMetrics$CachedMetric.access$000().iterator();
      while (iterator.hasNext())
        ((CachedMetrics$CachedMetric)iterator.next()).commitAndClear(); 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\metrics\CachedMetrics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */