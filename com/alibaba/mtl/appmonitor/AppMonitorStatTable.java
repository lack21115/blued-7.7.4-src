package com.alibaba.mtl.appmonitor;

import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;

public class AppMonitorStatTable {
  private String o;
  
  private String p;
  
  public AppMonitorStatTable(String paramString1, String paramString2) {
    this.o = paramString1;
    this.p = paramString2;
  }
  
  public AppMonitorStatTable registerRowAndColumn(DimensionSet paramDimensionSet, MeasureSet paramMeasureSet, boolean paramBoolean) {
    AppMonitor.register(this.o, this.p, paramMeasureSet, paramDimensionSet, paramBoolean);
    return this;
  }
  
  public AppMonitorStatTable update(DimensionValueSet paramDimensionValueSet, MeasureValueSet paramMeasureValueSet) {
    AppMonitor.Stat.commit(this.o, this.p, paramDimensionValueSet, paramMeasureValueSet);
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\AppMonitorStatTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */