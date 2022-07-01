package com.alibaba.mtl.appmonitor.a;

import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.f.b;
import com.alibaba.mtl.appmonitor.f.c;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import com.alibaba.mtl.appmonitor.model.MetricValueSet;
import com.alibaba.mtl.appmonitor.model.UTDimensionValueSet;
import com.alibaba.mtl.log.a;
import com.alibaba.mtl.log.a.a;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.r;
import com.alibaba.mtl.log.model.LogField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class e {
  private static e a;
  
  private AtomicInteger a = new AtomicInteger(0);
  
  private AtomicInteger b = new AtomicInteger(0);
  
  private AtomicInteger c = new AtomicInteger(0);
  
  private Map<String, c> g = new ConcurrentHashMap<String, c>();
  
  private Map<UTDimensionValueSet, MetricValueSet> h = new ConcurrentHashMap<UTDimensionValueSet, MetricValueSet>();
  
  private d a(UTDimensionValueSet paramUTDimensionValueSet, String paramString1, String paramString2, String paramString3, Class<? extends d> paramClass) {
    if (b.c(paramString1) && b.c(paramString2)) {
      Integer integer = paramUTDimensionValueSet.getEventId();
      if (integer != null)
        synchronized (this.h) {
          MetricValueSet metricValueSet2 = this.h.get(paramUTDimensionValueSet);
          MetricValueSet metricValueSet1 = metricValueSet2;
          if (metricValueSet2 == null) {
            metricValueSet1 = (MetricValueSet)a.a().a(MetricValueSet.class, new Object[0]);
            this.h.put(paramUTDimensionValueSet, metricValueSet1);
          } 
          return metricValueSet1.getEvent(integer, paramString1, paramString2, paramString3, paramClass);
        }  
    } 
    return null;
  }
  
  public static e a() {
    // Byte code:
    //   0: ldc com/alibaba/mtl/appmonitor/a/e
    //   2: monitorenter
    //   3: getstatic com/alibaba/mtl/appmonitor/a/e.a : Lcom/alibaba/mtl/appmonitor/a/e;
    //   6: ifnonnull -> 19
    //   9: new com/alibaba/mtl/appmonitor/a/e
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/alibaba/mtl/appmonitor/a/e.a : Lcom/alibaba/mtl/appmonitor/a/e;
    //   19: getstatic com/alibaba/mtl/appmonitor/a/e.a : Lcom/alibaba/mtl/appmonitor/a/e;
    //   22: astore_0
    //   23: ldc com/alibaba/mtl/appmonitor/a/e
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/alibaba/mtl/appmonitor/a/e
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
  }
  
  private UTDimensionValueSet a(int paramInt) {
    UTDimensionValueSet uTDimensionValueSet = (UTDimensionValueSet)a.a().a(UTDimensionValueSet.class, new Object[0]);
    uTDimensionValueSet.setValue(LogField.ACCESS.toString(), a.b());
    uTDimensionValueSet.setValue(LogField.ACCESS_SUBTYPE.toString(), a.c());
    uTDimensionValueSet.setValue(LogField.USERID.toString(), a.d());
    uTDimensionValueSet.setValue(LogField.USERNICK.toString(), a.e());
    uTDimensionValueSet.setValue(LogField.EVENTID.toString(), String.valueOf(paramInt));
    return uTDimensionValueSet;
  }
  
  private String a(String paramString1, String paramString2) {
    Metric metric = MetricRepo.getRepo().getMetric(paramString1, paramString2);
    return (metric != null) ? metric.getTransactionId() : null;
  }
  
  private void a(f paramf, AtomicInteger paramAtomicInteger) {
    int i = paramAtomicInteger.incrementAndGet();
    i.a("EventRepo", new String[] { paramf.toString(), " EVENT size:", String.valueOf(i) });
    if (i >= paramf.b()) {
      i.a("EventRepo", new Object[] { paramf.toString(), " event size exceed trigger count." });
      paramAtomicInteger.set(0);
      a(paramf.a());
    } 
  }
  
  private void b(String paramString1, String paramString2) {
    Metric metric = MetricRepo.getRepo().getMetric(paramString1, paramString2);
    if (metric != null)
      metric.resetTransactionId(); 
  }
  
  public Map<UTDimensionValueSet, List<d>> a(int paramInt) {
    null = new HashMap<Object, Object>();
    synchronized (this.h) {
      ArrayList<UTDimensionValueSet> arrayList = new ArrayList(this.h.keySet());
      int j = arrayList.size();
      for (int i = 0;; i++) {
        if (i < j) {
          UTDimensionValueSet uTDimensionValueSet = arrayList.get(i);
          if (uTDimensionValueSet != null && uTDimensionValueSet.getEventId().intValue() == paramInt) {
            null.put(uTDimensionValueSet, ((MetricValueSet)this.h.get(uTDimensionValueSet)).getEvents());
            this.h.remove(uTDimensionValueSet);
          } 
        } else {
          return (Map)null;
        } 
      } 
    } 
  }
  
  public void a(int paramInt) {
    Map<UTDimensionValueSet, List<d>> map = a(paramInt);
    r.a().b(new Runnable(this, map) {
          public void run() {
            c.b(this.i);
          }
        });
  }
  
  public void a(int paramInt, String paramString1, String paramString2, MeasureValueSet paramMeasureValueSet, DimensionValueSet paramDimensionValueSet) {
    Metric metric = MetricRepo.getRepo().getMetric(paramString1, paramString2);
    if (metric != null) {
      if (metric.getDimensionSet() != null)
        metric.getDimensionSet().setConstantValue(paramDimensionValueSet); 
      if (metric.getMeasureSet() != null)
        metric.getMeasureSet().setConstantValue(paramMeasureValueSet); 
      UTDimensionValueSet uTDimensionValueSet = a(paramInt);
      ((g)a(uTDimensionValueSet, paramString1, paramString2, (String)null, (Class)g.class)).a(paramDimensionValueSet, paramMeasureValueSet);
      if (a.g()) {
        g g = (g)a.a().a(g.class, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
        g.a(paramDimensionValueSet, paramMeasureValueSet);
        c.a(uTDimensionValueSet, g);
      } 
      a(f.a(paramInt), this.c);
      return;
    } 
    i.a("EventRepo", "metric is null");
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3) {
    UTDimensionValueSet uTDimensionValueSet = a(paramInt);
    ((a)a(uTDimensionValueSet, paramString1, paramString2, paramString3, (Class)a.class)).f();
    if (a.g()) {
      a a = (a)a.a().a(a.class, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, paramString3 });
      a.f();
      c.a(uTDimensionValueSet, a);
    } 
    a(f.a(paramInt), this.a);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, double paramDouble) {
    UTDimensionValueSet uTDimensionValueSet = a(paramInt);
    ((b)a(uTDimensionValueSet, paramString1, paramString2, paramString3, (Class)b.class)).a(paramDouble);
    if (a.g()) {
      b b = (b)a.a().a(b.class, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, paramString3 });
      b.a(paramDouble);
      c.a(uTDimensionValueSet, b);
    } 
    a(f.a(paramInt), this.b);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    UTDimensionValueSet uTDimensionValueSet = a(paramInt);
    a a = (a)a(uTDimensionValueSet, paramString1, paramString2, paramString3, (Class)a.class);
    a.g();
    a.a(paramString4, paramString5);
    if (a.g()) {
      a a1 = (a)a.a().a(a.class, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, paramString3 });
      a1.g();
      a1.a(paramString4, paramString5);
      c.a(uTDimensionValueSet, a1);
    } 
    a(f.a(paramInt), this.a);
  }
  
  public void a(Integer paramInteger, String paramString1, String paramString2, String paramString3) {
    String str = a(paramString1, paramString2);
    if (str != null)
      a(str, paramInteger, paramString1, paramString2, paramString3); 
  }
  
  public void a(String paramString1, Integer paramInteger, String paramString2, String paramString3, DimensionValueSet paramDimensionValueSet) {
    // Byte code:
    //   0: ldc_w com/alibaba/mtl/appmonitor/a/c
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield g : Ljava/util/Map;
    //   8: aload_1
    //   9: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   14: checkcast com/alibaba/mtl/appmonitor/a/c
    //   17: astore #7
    //   19: aload #7
    //   21: astore #6
    //   23: aload #7
    //   25: ifnonnull -> 72
    //   28: invokestatic a : ()Lcom/alibaba/mtl/appmonitor/c/a;
    //   31: ldc_w com/alibaba/mtl/appmonitor/a/c
    //   34: iconst_3
    //   35: anewarray java/lang/Object
    //   38: dup
    //   39: iconst_0
    //   40: aload_2
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: aload_3
    //   45: aastore
    //   46: dup
    //   47: iconst_2
    //   48: aload #4
    //   50: aastore
    //   51: invokevirtual a : (Ljava/lang/Class;[Ljava/lang/Object;)Lcom/alibaba/mtl/appmonitor/c/b;
    //   54: checkcast com/alibaba/mtl/appmonitor/a/c
    //   57: astore #6
    //   59: aload_0
    //   60: getfield g : Ljava/util/Map;
    //   63: aload_1
    //   64: aload #6
    //   66: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   71: pop
    //   72: ldc_w com/alibaba/mtl/appmonitor/a/c
    //   75: monitorexit
    //   76: aload #6
    //   78: aload #5
    //   80: invokevirtual a : (Lcom/alibaba/mtl/appmonitor/model/DimensionValueSet;)V
    //   83: return
    //   84: astore_1
    //   85: ldc_w com/alibaba/mtl/appmonitor/a/c
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Exception table:
    //   from	to	target	type
    //   4	19	84	finally
    //   28	72	84	finally
    //   72	76	84	finally
    //   85	89	84	finally
  }
  
  public void a(String paramString1, Integer paramInteger, String paramString2, String paramString3, String paramString4) {
    // Byte code:
    //   0: invokestatic getRepo : ()Lcom/alibaba/mtl/appmonitor/model/MetricRepo;
    //   3: aload_3
    //   4: aload #4
    //   6: invokevirtual getMetric : (Ljava/lang/String;Ljava/lang/String;)Lcom/alibaba/mtl/appmonitor/model/Metric;
    //   9: astore #6
    //   11: aload #6
    //   13: ifnull -> 128
    //   16: aload #6
    //   18: invokevirtual getMeasureSet : ()Lcom/alibaba/mtl/appmonitor/model/MeasureSet;
    //   21: ifnull -> 128
    //   24: aload #6
    //   26: invokevirtual getMeasureSet : ()Lcom/alibaba/mtl/appmonitor/model/MeasureSet;
    //   29: aload #5
    //   31: invokevirtual getMeasure : (Ljava/lang/String;)Lcom/alibaba/mtl/appmonitor/model/Measure;
    //   34: ifnull -> 128
    //   37: ldc_w com/alibaba/mtl/appmonitor/a/c
    //   40: monitorenter
    //   41: aload_0
    //   42: getfield g : Ljava/util/Map;
    //   45: aload_1
    //   46: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   51: checkcast com/alibaba/mtl/appmonitor/a/c
    //   54: astore #7
    //   56: aload #7
    //   58: astore #6
    //   60: aload #7
    //   62: ifnonnull -> 109
    //   65: invokestatic a : ()Lcom/alibaba/mtl/appmonitor/c/a;
    //   68: ldc_w com/alibaba/mtl/appmonitor/a/c
    //   71: iconst_3
    //   72: anewarray java/lang/Object
    //   75: dup
    //   76: iconst_0
    //   77: aload_2
    //   78: aastore
    //   79: dup
    //   80: iconst_1
    //   81: aload_3
    //   82: aastore
    //   83: dup
    //   84: iconst_2
    //   85: aload #4
    //   87: aastore
    //   88: invokevirtual a : (Ljava/lang/Class;[Ljava/lang/Object;)Lcom/alibaba/mtl/appmonitor/c/b;
    //   91: checkcast com/alibaba/mtl/appmonitor/a/c
    //   94: astore #6
    //   96: aload_0
    //   97: getfield g : Ljava/util/Map;
    //   100: aload_1
    //   101: aload #6
    //   103: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   108: pop
    //   109: ldc_w com/alibaba/mtl/appmonitor/a/c
    //   112: monitorexit
    //   113: aload #6
    //   115: aload #5
    //   117: invokevirtual a : (Ljava/lang/String;)V
    //   120: return
    //   121: astore_1
    //   122: ldc_w com/alibaba/mtl/appmonitor/a/c
    //   125: monitorexit
    //   126: aload_1
    //   127: athrow
    //   128: return
    // Exception table:
    //   from	to	target	type
    //   41	56	121	finally
    //   65	109	121	finally
    //   109	113	121	finally
    //   122	126	121	finally
  }
  
  public void a(String paramString1, String paramString2, String paramString3) {
    paramString1 = a(paramString1, paramString2);
    if (paramString1 != null)
      a(paramString1, paramString3, true); 
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean) {
    c c = this.g.get(paramString1);
    if (c != null && c.a(paramString2)) {
      this.g.remove(paramString1);
      if (paramBoolean)
        b(c.o, c.p); 
      a(c.e, c.o, c.p, c.a(), c.a());
      a.a().a(c);
    } 
  }
  
  public void h() {
    ArrayList<String> arrayList = new ArrayList(this.g.keySet());
    int j = arrayList.size();
    for (int i = 0; i < j; i++) {
      String str = arrayList.get(i);
      c c = this.g.get(str);
      if (c != null && c.e())
        this.g.remove(str); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */