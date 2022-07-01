package com.alibaba.mtl.appmonitor.a;

import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.c.b;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureValue;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import com.alibaba.mtl.log.e.i;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class c extends d {
  private static final Long a = Long.valueOf(300000L);
  
  private Metric a;
  
  private DimensionValueSet b;
  
  private MeasureValueSet b;
  
  private Long b;
  
  private Map<String, MeasureValue> f;
  
  public DimensionValueSet a() {
    return (DimensionValueSet)this.b;
  }
  
  public MeasureValueSet a() {
    return (MeasureValueSet)this.b;
  }
  
  public void a(DimensionValueSet paramDimensionValueSet) {
    Long long_ = this.b;
    if (long_ == null) {
      this.b = (Long)paramDimensionValueSet;
      return;
    } 
    long_.addValues(paramDimensionValueSet);
  }
  
  public void a(String paramString) {
    long l = System.currentTimeMillis();
    if (this.f.isEmpty())
      this.b = Long.valueOf(l); 
    MeasureValue measureValue = (MeasureValue)a.a().a(MeasureValue.class, new Object[] { Double.valueOf(l), Double.valueOf((l - this.b.longValue())) });
    this.f.put(paramString, measureValue);
  }
  
  public boolean a(String paramString) {
    MeasureValue measureValue = this.f.get(paramString);
    if (measureValue != null) {
      long l = System.currentTimeMillis();
      String str1 = this.o;
      String str2 = this.p;
      double d1 = l;
      i.a("DurationEvent", new Object[] { "statEvent consumeTime. module:", str1, " monitorPoint:", str2, " measureName:", paramString, " time:", Double.valueOf(d1 - measureValue.getValue()) });
      measureValue.setValue(d1 - measureValue.getValue());
      measureValue.setFinish(true);
      this.b.setValue(paramString, measureValue);
      if (this.a.getMeasureSet().valid((MeasureValueSet)this.b))
        return true; 
    } 
    return false;
  }
  
  public void clean() {
    super.clean();
    this.a = null;
    this.b = null;
    for (MeasureValue measureValue : this.f.values())
      a.a().a((b)measureValue); 
    this.f.clear();
    if (this.b != null) {
      a.a().a((b)this.b);
      this.b = null;
    } 
    if (this.b != null) {
      a.a().a((b)this.b);
      this.b = null;
    } 
  }
  
  public boolean e() {
    long l = System.currentTimeMillis();
    List<Measure> list = this.a.getMeasureSet().getMeasures();
    if (list != null) {
      int j = list.size();
      for (int i = 0; i < j; i++) {
        Measure measure = list.get(i);
        if (measure != null) {
          double d1;
          if (measure.getMax() != null) {
            d1 = measure.getMax().doubleValue();
          } else {
            d1 = a.longValue();
          } 
          MeasureValue measureValue = this.f.get(measure.getName());
          if (measureValue != null && !measureValue.isFinish() && l - measureValue.getValue() > d1)
            return true; 
        } 
      } 
    } 
    return false;
  }
  
  public void fill(Object... paramVarArgs) {
    super.fill(paramVarArgs);
    if (this.f == null)
      this.f = new HashMap<String, MeasureValue>(); 
    this.a = MetricRepo.getRepo().getMetric(this.o, this.p);
    if (this.a.getDimensionSet() != null) {
      this.b = (Long)a.a().a(DimensionValueSet.class, new Object[0]);
      this.a.getDimensionSet().setConstantValue((DimensionValueSet)this.b);
    } 
    this.b = (Long)a.a().a(MeasureValueSet.class, new Object[0]);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */