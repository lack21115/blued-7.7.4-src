package com.alibaba.mtl.appmonitor.model;

import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.c.b;
import java.util.List;

public class Metric implements b {
  private DimensionSet b;
  
  private MeasureSet b;
  
  private boolean g;
  
  private String o;
  
  private String p;
  
  private String r;
  
  private String s;
  
  private String z = null;
  
  @Deprecated
  public Metric() {}
  
  public Metric(String paramString1, String paramString2, MeasureSet paramMeasureSet, DimensionSet paramDimensionSet, boolean paramBoolean) {
    this.o = paramString1;
    this.p = paramString2;
    this.b = (MeasureSet)paramDimensionSet;
    this.b = paramMeasureSet;
    this.s = null;
    this.g = paramBoolean;
  }
  
  private Measure a(String paramString, List<Measure> paramList) {
    if (paramList != null)
      for (Measure measure : paramList) {
        if (TextUtils.equals(paramString, measure.name))
          return measure; 
      }  
    return null;
  }
  
  public void clean() {
    this.o = null;
    this.p = null;
    this.s = null;
    this.g = false;
    this.b = null;
    this.b = null;
    this.r = null;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    String str = this.s;
    if (str == null) {
      if (((Metric)paramObject).s != null)
        return false; 
    } else if (!str.equals(((Metric)paramObject).s)) {
      return false;
    } 
    str = this.o;
    if (str == null) {
      if (((Metric)paramObject).o != null)
        return false; 
    } else if (!str.equals(((Metric)paramObject).o)) {
      return false;
    } 
    str = this.p;
    if (str == null) {
      if (((Metric)paramObject).p != null)
        return false; 
    } else if (!str.equals(((Metric)paramObject).p)) {
      return false;
    } 
    return true;
  }
  
  public void fill(Object... paramVarArgs) {
    this.o = (String)paramVarArgs[0];
    this.p = (String)paramVarArgs[1];
    if (paramVarArgs.length > 2)
      this.s = (String)paramVarArgs[2]; 
  }
  
  public DimensionSet getDimensionSet() {
    return (DimensionSet)this.b;
  }
  
  public MeasureSet getMeasureSet() {
    return this.b;
  }
  
  public String getModule() {
    return this.o;
  }
  
  public String getMonitorPoint() {
    return this.p;
  }
  
  public String getTransactionId() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield r : Ljava/lang/String;
    //   6: ifnonnull -> 68
    //   9: new java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: astore_1
    //   17: aload_1
    //   18: invokestatic randomUUID : ()Ljava/util/UUID;
    //   21: invokevirtual toString : ()Ljava/lang/String;
    //   24: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_1
    //   29: ldc '$'
    //   31: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_1
    //   36: aload_0
    //   37: getfield o : Ljava/lang/String;
    //   40: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload_1
    //   45: ldc '$'
    //   47: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_1
    //   52: aload_0
    //   53: getfield p : Ljava/lang/String;
    //   56: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload_0
    //   61: aload_1
    //   62: invokevirtual toString : ()Ljava/lang/String;
    //   65: putfield r : Ljava/lang/String;
    //   68: aload_0
    //   69: getfield r : Ljava/lang/String;
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: areturn
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Exception table:
    //   from	to	target	type
    //   2	68	77	finally
    //   68	73	77	finally
  }
  
  public int hashCode() {
    int i;
    int j;
    String str = this.s;
    int k = 0;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    } 
    str = this.o;
    if (str == null) {
      j = 0;
    } else {
      j = str.hashCode();
    } 
    str = this.p;
    if (str != null)
      k = str.hashCode(); 
    return ((i + 31) * 31 + j) * 31 + k;
  }
  
  public boolean isCommitDetail() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc '1'
    //   4: aload_0
    //   5: getfield z : Ljava/lang/String;
    //   8: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   11: istore_1
    //   12: iload_1
    //   13: ifeq -> 20
    //   16: aload_0
    //   17: monitorexit
    //   18: iconst_1
    //   19: ireturn
    //   20: ldc '0'
    //   22: aload_0
    //   23: getfield z : Ljava/lang/String;
    //   26: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   29: istore_1
    //   30: iload_1
    //   31: ifeq -> 38
    //   34: aload_0
    //   35: monitorexit
    //   36: iconst_0
    //   37: ireturn
    //   38: aload_0
    //   39: getfield g : Z
    //   42: istore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: iload_1
    //   46: ireturn
    //   47: astore_2
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_2
    //   51: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	47	finally
    //   20	30	47	finally
    //   38	43	47	finally
  }
  
  public void resetTransactionId() {
    this.r = null;
  }
  
  public void setCommitDetailFromConfig(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield z : Ljava/lang/String;
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_1
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	10	finally
  }
  
  public boolean valid(DimensionValueSet paramDimensionValueSet, MeasureValueSet paramMeasureValueSet) {
    boolean bool1;
    MeasureSet measureSet2 = this.b;
    if (measureSet2 != null) {
      bool1 = measureSet2.valid(paramDimensionValueSet);
    } else {
      bool1 = true;
    } 
    MetricRepo metricRepo = MetricRepo.getRepo();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("config_prefix");
    stringBuilder1.append(this.o);
    String str = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("config_prefix");
    stringBuilder2.append(this.p);
    Metric metric = metricRepo.getMetric(str, stringBuilder2.toString());
    if (metric != null && metric.getMeasureSet() != null && paramMeasureValueSet != null && paramMeasureValueSet.getMap() != null && this.b != null) {
      List<Measure> list = metric.getMeasureSet().getMeasures();
      for (String str1 : paramMeasureValueSet.getMap().keySet()) {
        Measure measure2 = a(str1, list);
        Measure measure1 = measure2;
        if (measure2 == null)
          measure1 = a(str1, this.b.getMeasures()); 
        if (measure1 == null || !measure1.valid(paramMeasureValueSet.getValue(str1)))
          return false; 
      } 
      return bool1;
    } 
    MeasureSet measureSet1 = this.b;
    boolean bool2 = bool1;
    if (measureSet1 != null) {
      if (bool1 && measureSet1.valid(paramMeasureValueSet))
        return true; 
      bool2 = false;
    } 
    return bool2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\model\Metric.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */