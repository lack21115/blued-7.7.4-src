package com.alibaba.mtl.appmonitor.model;

import java.util.ArrayList;
import java.util.List;

public class MetricRepo {
  private static MetricRepo a;
  
  public List<Metric> metrics;
  
  private MetricRepo(int paramInt) {
    this.metrics = new ArrayList<Metric>(paramInt);
  }
  
  public static MetricRepo getRepo() {
    if (a == null)
      a = new MetricRepo(3); 
    return a;
  }
  
  public static MetricRepo getRepo(int paramInt) {
    return new MetricRepo(paramInt);
  }
  
  public void add(Metric paramMetric) {
    if (!this.metrics.contains(paramMetric))
      this.metrics.add(paramMetric); 
  }
  
  public Metric getMetric(String paramString1, String paramString2) {
    if (paramString1 != null && paramString2 != null) {
      List<Metric> list = this.metrics;
      if (list == null)
        return null; 
      int j = list.size();
      for (int i = 0; i < j; i++) {
        Metric metric = this.metrics.get(i);
        if (metric != null && metric.getModule().equals(paramString1) && metric.getMonitorPoint().equals(paramString2))
          return metric; 
      } 
    } 
    return null;
  }
  
  public boolean remove(Metric paramMetric) {
    return this.metrics.contains(paramMetric) ? this.metrics.remove(paramMetric) : true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\model\MetricRepo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */