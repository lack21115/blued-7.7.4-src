package com.alibaba.mtl.appmonitor.model;

import com.alibaba.mtl.appmonitor.a.d;
import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.c.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetricValueSet implements b {
  private Map<Metric, d> l = Collections.synchronizedMap(new HashMap<Metric, d>());
  
  public void clean() {
    for (d d : this.l.values())
      a.a().a((b)d); 
    this.l.clear();
  }
  
  public void fill(Object... paramVarArgs) {
    if (this.l == null)
      this.l = Collections.synchronizedMap(new HashMap<Metric, d>()); 
  }
  
  public d getEvent(Integer paramInteger, String paramString1, String paramString2, String paramString3, Class<? extends d> paramClass) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual intValue : ()I
    //   4: getstatic com/alibaba/mtl/appmonitor/a/f.d : Lcom/alibaba/mtl/appmonitor/a/f;
    //   7: invokevirtual a : ()I
    //   10: if_icmpne -> 29
    //   13: invokestatic getRepo : ()Lcom/alibaba/mtl/appmonitor/model/MetricRepo;
    //   16: aload_2
    //   17: aload_3
    //   18: invokevirtual getMetric : (Ljava/lang/String;Ljava/lang/String;)Lcom/alibaba/mtl/appmonitor/model/Metric;
    //   21: astore #7
    //   23: iconst_0
    //   24: istore #6
    //   26: goto -> 62
    //   29: invokestatic a : ()Lcom/alibaba/mtl/appmonitor/c/a;
    //   32: ldc com/alibaba/mtl/appmonitor/model/Metric
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
    //   54: checkcast com/alibaba/mtl/appmonitor/model/Metric
    //   57: astore #7
    //   59: iconst_1
    //   60: istore #6
    //   62: aconst_null
    //   63: astore #8
    //   65: aload #7
    //   67: ifnull -> 181
    //   70: aload_0
    //   71: getfield l : Ljava/util/Map;
    //   74: aload #7
    //   76: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   81: ifeq -> 102
    //   84: aload_0
    //   85: getfield l : Ljava/util/Map;
    //   88: aload #7
    //   90: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   95: checkcast com/alibaba/mtl/appmonitor/a/d
    //   98: astore_1
    //   99: goto -> 157
    //   102: ldc com/alibaba/mtl/appmonitor/model/MetricValueSet
    //   104: monitorenter
    //   105: invokestatic a : ()Lcom/alibaba/mtl/appmonitor/c/a;
    //   108: aload #5
    //   110: iconst_4
    //   111: anewarray java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: aload_1
    //   117: aastore
    //   118: dup
    //   119: iconst_1
    //   120: aload_2
    //   121: aastore
    //   122: dup
    //   123: iconst_2
    //   124: aload_3
    //   125: aastore
    //   126: dup
    //   127: iconst_3
    //   128: aload #4
    //   130: aastore
    //   131: invokevirtual a : (Ljava/lang/Class;[Ljava/lang/Object;)Lcom/alibaba/mtl/appmonitor/c/b;
    //   134: checkcast com/alibaba/mtl/appmonitor/a/d
    //   137: astore_1
    //   138: aload_0
    //   139: getfield l : Ljava/util/Map;
    //   142: aload #7
    //   144: aload_1
    //   145: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   150: pop
    //   151: ldc com/alibaba/mtl/appmonitor/model/MetricValueSet
    //   153: monitorexit
    //   154: iconst_0
    //   155: istore #6
    //   157: aload_1
    //   158: astore #8
    //   160: iload #6
    //   162: ifeq -> 181
    //   165: invokestatic a : ()Lcom/alibaba/mtl/appmonitor/c/a;
    //   168: aload #7
    //   170: invokevirtual a : (Lcom/alibaba/mtl/appmonitor/c/b;)V
    //   173: aload_1
    //   174: areturn
    //   175: astore_1
    //   176: ldc com/alibaba/mtl/appmonitor/model/MetricValueSet
    //   178: monitorexit
    //   179: aload_1
    //   180: athrow
    //   181: aload #8
    //   183: areturn
    // Exception table:
    //   from	to	target	type
    //   105	154	175	finally
    //   176	179	175	finally
  }
  
  public List<d> getEvents() {
    return new ArrayList<d>(this.l.values());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\model\MetricValueSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */