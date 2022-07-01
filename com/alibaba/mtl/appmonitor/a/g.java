package com.alibaba.mtl.appmonitor.a;

import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureValue;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class g extends d {
  private Metric a;
  
  private Map<DimensionValueSet, a> j;
  
  public JSONObject a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial a : ()Lorg/json/JSONObject;
    //   6: astore #4
    //   8: aload_0
    //   9: getfield a : Lcom/alibaba/mtl/appmonitor/model/Metric;
    //   12: ifnull -> 33
    //   15: aload #4
    //   17: ldc 'isCommitDetail'
    //   19: aload_0
    //   20: getfield a : Lcom/alibaba/mtl/appmonitor/model/Metric;
    //   23: invokevirtual isCommitDetail : ()Z
    //   26: invokestatic valueOf : (Z)Ljava/lang/String;
    //   29: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   32: pop
    //   33: invokestatic a : ()Lcom/alibaba/mtl/appmonitor/c/a;
    //   36: ldc com/alibaba/mtl/appmonitor/c/d
    //   38: iconst_0
    //   39: anewarray java/lang/Object
    //   42: invokevirtual a : (Ljava/lang/Class;[Ljava/lang/Object;)Lcom/alibaba/mtl/appmonitor/c/b;
    //   45: checkcast org/json/JSONArray
    //   48: astore #5
    //   50: aload_0
    //   51: getfield j : Ljava/util/Map;
    //   54: ifnull -> 388
    //   57: aload_0
    //   58: getfield j : Ljava/util/Map;
    //   61: invokeinterface entrySet : ()Ljava/util/Set;
    //   66: invokeinterface iterator : ()Ljava/util/Iterator;
    //   71: astore #6
    //   73: aload #6
    //   75: invokeinterface hasNext : ()Z
    //   80: ifeq -> 388
    //   83: aload #6
    //   85: invokeinterface next : ()Ljava/lang/Object;
    //   90: checkcast java/util/Map$Entry
    //   93: astore #8
    //   95: invokestatic a : ()Lcom/alibaba/mtl/appmonitor/c/a;
    //   98: ldc com/alibaba/mtl/appmonitor/c/e
    //   100: iconst_0
    //   101: anewarray java/lang/Object
    //   104: invokevirtual a : (Ljava/lang/Class;[Ljava/lang/Object;)Lcom/alibaba/mtl/appmonitor/c/b;
    //   107: checkcast org/json/JSONObject
    //   110: astore #7
    //   112: aload #8
    //   114: invokeinterface getKey : ()Ljava/lang/Object;
    //   119: checkcast com/alibaba/mtl/appmonitor/model/DimensionValueSet
    //   122: astore_3
    //   123: aload #8
    //   125: invokeinterface getValue : ()Ljava/lang/Object;
    //   130: checkcast com/alibaba/mtl/appmonitor/a/g$a
    //   133: astore #8
    //   135: aload #8
    //   137: invokestatic a : (Lcom/alibaba/mtl/appmonitor/a/g$a;)I
    //   140: istore_1
    //   141: aload #8
    //   143: invokestatic b : (Lcom/alibaba/mtl/appmonitor/a/g$a;)I
    //   146: istore_2
    //   147: aload #7
    //   149: ldc 'count'
    //   151: iload_1
    //   152: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   155: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   158: pop
    //   159: aload #7
    //   161: ldc 'noise'
    //   163: iload_2
    //   164: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   167: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   170: pop
    //   171: aload_3
    //   172: ifnull -> 412
    //   175: new org/json/JSONObject
    //   178: dup
    //   179: aload_3
    //   180: invokevirtual getMap : ()Ljava/util/Map;
    //   183: invokespecial <init> : (Ljava/util/Map;)V
    //   186: astore_3
    //   187: goto -> 190
    //   190: aload #7
    //   192: ldc 'dimensions'
    //   194: aload_3
    //   195: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   198: pop
    //   199: aload #8
    //   201: invokevirtual a : ()Ljava/util/List;
    //   204: astore_3
    //   205: new org/json/JSONArray
    //   208: dup
    //   209: invokespecial <init> : ()V
    //   212: astore #8
    //   214: iconst_0
    //   215: istore_1
    //   216: iload_1
    //   217: aload_3
    //   218: invokeinterface size : ()I
    //   223: if_icmpge -> 367
    //   226: new org/json/JSONObject
    //   229: dup
    //   230: invokespecial <init> : ()V
    //   233: astore #9
    //   235: aload_3
    //   236: iload_1
    //   237: invokeinterface get : (I)Ljava/lang/Object;
    //   242: checkcast java/util/Map
    //   245: astore #10
    //   247: aload #10
    //   249: ifnull -> 352
    //   252: aload #10
    //   254: invokeinterface keySet : ()Ljava/util/Set;
    //   259: astore #11
    //   261: aload #11
    //   263: ifnull -> 352
    //   266: aload #11
    //   268: invokeinterface iterator : ()Ljava/util/Iterator;
    //   273: astore #11
    //   275: aload #11
    //   277: invokeinterface hasNext : ()Z
    //   282: ifeq -> 352
    //   285: aload #11
    //   287: invokeinterface next : ()Ljava/lang/Object;
    //   292: checkcast java/lang/String
    //   295: astore #12
    //   297: aload #10
    //   299: aload #12
    //   301: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   306: ifnull -> 339
    //   309: aload #9
    //   311: aload #12
    //   313: new org/json/JSONObject
    //   316: dup
    //   317: aload #10
    //   319: aload #12
    //   321: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   326: checkcast java/util/Map
    //   329: invokespecial <init> : (Ljava/util/Map;)V
    //   332: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   335: pop
    //   336: goto -> 275
    //   339: aload #9
    //   341: aload #12
    //   343: ldc ''
    //   345: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   348: pop
    //   349: goto -> 275
    //   352: aload #8
    //   354: aload #9
    //   356: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   359: pop
    //   360: iload_1
    //   361: iconst_1
    //   362: iadd
    //   363: istore_1
    //   364: goto -> 216
    //   367: aload #7
    //   369: ldc 'measures'
    //   371: aload #8
    //   373: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   376: pop
    //   377: aload #5
    //   379: aload #7
    //   381: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   384: pop
    //   385: goto -> 73
    //   388: aload #4
    //   390: ldc 'values'
    //   392: aload #5
    //   394: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   397: pop
    //   398: aload_0
    //   399: monitorexit
    //   400: aload #4
    //   402: areturn
    //   403: astore_3
    //   404: aload_0
    //   405: monitorexit
    //   406: aload_3
    //   407: athrow
    //   408: astore_3
    //   409: goto -> 398
    //   412: ldc ''
    //   414: astore_3
    //   415: goto -> 190
    // Exception table:
    //   from	to	target	type
    //   2	8	403	finally
    //   8	33	408	java/lang/Exception
    //   8	33	403	finally
    //   33	73	408	java/lang/Exception
    //   33	73	403	finally
    //   73	171	408	java/lang/Exception
    //   73	171	403	finally
    //   175	187	408	java/lang/Exception
    //   175	187	403	finally
    //   190	214	408	java/lang/Exception
    //   190	214	403	finally
    //   216	247	408	java/lang/Exception
    //   216	247	403	finally
    //   252	261	408	java/lang/Exception
    //   252	261	403	finally
    //   266	275	408	java/lang/Exception
    //   266	275	403	finally
    //   275	336	408	java/lang/Exception
    //   275	336	403	finally
    //   339	349	408	java/lang/Exception
    //   339	349	403	finally
    //   352	360	408	java/lang/Exception
    //   352	360	403	finally
    //   367	385	408	java/lang/Exception
    //   367	385	403	finally
    //   388	398	408	java/lang/Exception
    //   388	398	403	finally
  }
  
  public void a(DimensionValueSet paramDimensionValueSet, MeasureValueSet paramMeasureValueSet) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: astore #4
    //   5: aload_1
    //   6: ifnonnull -> 33
    //   9: invokestatic a : ()Lcom/alibaba/mtl/appmonitor/c/a;
    //   12: ldc com/alibaba/mtl/appmonitor/model/DimensionValueSet
    //   14: iconst_0
    //   15: anewarray java/lang/Object
    //   18: invokevirtual a : (Ljava/lang/Class;[Ljava/lang/Object;)Lcom/alibaba/mtl/appmonitor/c/b;
    //   21: checkcast com/alibaba/mtl/appmonitor/model/DimensionValueSet
    //   24: astore #4
    //   26: aload #4
    //   28: aload_1
    //   29: invokevirtual addValues : (Lcom/alibaba/mtl/appmonitor/model/DimensionValueSet;)Lcom/alibaba/mtl/appmonitor/model/DimensionValueSet;
    //   32: pop
    //   33: aload_0
    //   34: getfield j : Ljava/util/Map;
    //   37: aload #4
    //   39: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   44: ifeq -> 65
    //   47: aload_0
    //   48: getfield j : Ljava/util/Map;
    //   51: aload #4
    //   53: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   58: checkcast com/alibaba/mtl/appmonitor/a/g$a
    //   61: astore_1
    //   62: goto -> 112
    //   65: invokestatic a : ()Lcom/alibaba/mtl/appmonitor/c/a;
    //   68: ldc com/alibaba/mtl/appmonitor/model/DimensionValueSet
    //   70: iconst_0
    //   71: anewarray java/lang/Object
    //   74: invokevirtual a : (Ljava/lang/Class;[Ljava/lang/Object;)Lcom/alibaba/mtl/appmonitor/c/b;
    //   77: checkcast com/alibaba/mtl/appmonitor/model/DimensionValueSet
    //   80: astore #5
    //   82: aload #5
    //   84: aload #4
    //   86: invokevirtual addValues : (Lcom/alibaba/mtl/appmonitor/model/DimensionValueSet;)Lcom/alibaba/mtl/appmonitor/model/DimensionValueSet;
    //   89: pop
    //   90: new com/alibaba/mtl/appmonitor/a/g$a
    //   93: dup
    //   94: aload_0
    //   95: invokespecial <init> : (Lcom/alibaba/mtl/appmonitor/a/g;)V
    //   98: astore_1
    //   99: aload_0
    //   100: getfield j : Ljava/util/Map;
    //   103: aload #5
    //   105: aload_1
    //   106: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   111: pop
    //   112: aload_0
    //   113: getfield a : Lcom/alibaba/mtl/appmonitor/model/Metric;
    //   116: ifnull -> 215
    //   119: aload_0
    //   120: getfield a : Lcom/alibaba/mtl/appmonitor/model/Metric;
    //   123: aload #4
    //   125: aload_2
    //   126: invokevirtual valid : (Lcom/alibaba/mtl/appmonitor/model/DimensionValueSet;Lcom/alibaba/mtl/appmonitor/model/MeasureValueSet;)Z
    //   129: istore_3
    //   130: goto -> 133
    //   133: iload_3
    //   134: ifeq -> 149
    //   137: aload_1
    //   138: invokevirtual i : ()V
    //   141: aload_1
    //   142: aload_2
    //   143: invokevirtual a : (Lcom/alibaba/mtl/appmonitor/model/MeasureValueSet;)V
    //   146: goto -> 168
    //   149: aload_1
    //   150: invokevirtual j : ()V
    //   153: aload_0
    //   154: getfield a : Lcom/alibaba/mtl/appmonitor/model/Metric;
    //   157: invokevirtual isCommitDetail : ()Z
    //   160: ifeq -> 168
    //   163: aload_1
    //   164: aload_2
    //   165: invokevirtual a : (Lcom/alibaba/mtl/appmonitor/model/MeasureValueSet;)V
    //   168: ldc 'StatEvent'
    //   170: iconst_4
    //   171: anewarray java/lang/Object
    //   174: dup
    //   175: iconst_0
    //   176: ldc 'entity  count:'
    //   178: aastore
    //   179: dup
    //   180: iconst_1
    //   181: aload_1
    //   182: invokestatic a : (Lcom/alibaba/mtl/appmonitor/a/g$a;)I
    //   185: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   188: aastore
    //   189: dup
    //   190: iconst_2
    //   191: ldc ' noise:'
    //   193: aastore
    //   194: dup
    //   195: iconst_3
    //   196: aload_1
    //   197: invokestatic b : (Lcom/alibaba/mtl/appmonitor/a/g$a;)I
    //   200: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   203: aastore
    //   204: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   207: aload_0
    //   208: monitorexit
    //   209: return
    //   210: astore_1
    //   211: aload_0
    //   212: monitorexit
    //   213: aload_1
    //   214: athrow
    //   215: iconst_0
    //   216: istore_3
    //   217: goto -> 133
    // Exception table:
    //   from	to	target	type
    //   9	33	210	finally
    //   33	62	210	finally
    //   65	112	210	finally
    //   112	130	210	finally
    //   137	146	210	finally
    //   149	168	210	finally
    //   168	207	210	finally
  }
  
  public void clean() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial clean : ()V
    //   6: aload_0
    //   7: aconst_null
    //   8: putfield a : Lcom/alibaba/mtl/appmonitor/model/Metric;
    //   11: aload_0
    //   12: getfield j : Ljava/util/Map;
    //   15: invokeinterface keySet : ()Ljava/util/Set;
    //   20: invokeinterface iterator : ()Ljava/util/Iterator;
    //   25: astore_1
    //   26: aload_1
    //   27: invokeinterface hasNext : ()Z
    //   32: ifeq -> 55
    //   35: aload_1
    //   36: invokeinterface next : ()Ljava/lang/Object;
    //   41: checkcast com/alibaba/mtl/appmonitor/model/DimensionValueSet
    //   44: astore_2
    //   45: invokestatic a : ()Lcom/alibaba/mtl/appmonitor/c/a;
    //   48: aload_2
    //   49: invokevirtual a : (Lcom/alibaba/mtl/appmonitor/c/b;)V
    //   52: goto -> 26
    //   55: aload_0
    //   56: getfield j : Ljava/util/Map;
    //   59: invokeinterface clear : ()V
    //   64: aload_0
    //   65: monitorexit
    //   66: return
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    // Exception table:
    //   from	to	target	type
    //   2	26	67	finally
    //   26	52	67	finally
    //   55	64	67	finally
  }
  
  public void fill(Object... paramVarArgs) {
    super.fill(paramVarArgs);
    if (this.j == null)
      this.j = new HashMap<DimensionValueSet, a>(); 
    this.a = MetricRepo.getRepo().getMetric(this.o, this.p);
  }
  
  public class a {
    private List<MeasureValueSet> b = new ArrayList<MeasureValueSet>();
    
    private int count = 0;
    
    private int l = 0;
    
    public a(g this$0) {}
    
    private MeasureValueSet a(MeasureValueSet param1MeasureValueSet) {
      MeasureValueSet measureValueSet = (MeasureValueSet)com.alibaba.mtl.appmonitor.c.a.a().a(MeasureValueSet.class, new Object[0]);
      if (g.a(this.a) != null && g.a(this.a).getMeasureSet() != null) {
        List<Measure> list = g.a(this.a).getMeasureSet().getMeasures();
        if (list != null) {
          int j = list.size();
          for (int i = 0; i < j; i++) {
            Measure measure = list.get(i);
            if (measure != null) {
              MeasureValue measureValue1 = (MeasureValue)com.alibaba.mtl.appmonitor.c.a.a().a(MeasureValue.class, new Object[0]);
              MeasureValue measureValue2 = param1MeasureValueSet.getValue(measure.getName());
              if (measureValue2.getOffset() != null)
                measureValue1.setOffset(measureValue2.getOffset().doubleValue()); 
              measureValue1.setValue(measureValue2.getValue());
              measureValueSet.setValue(measure.getName(), measureValue1);
            } 
          } 
        } 
      } 
      return measureValueSet;
    }
    
    public List<Map<String, Map<String, Double>>> a() {
      List<MeasureValueSet> list = this.b;
      if (list == null || list.isEmpty())
        return null; 
      list = new ArrayList<MeasureValueSet>();
      int j = this.b.size();
      for (int i = 0; i < j; i++) {
        MeasureValueSet measureValueSet = this.b.get(i);
        if (measureValueSet != null) {
          Map map = measureValueSet.getMap();
          if (map != null && !map.isEmpty()) {
            HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
            for (Map.Entry entry : map.entrySet()) {
              HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
              String str = (String)entry.getKey();
              MeasureValue measureValue = (MeasureValue)entry.getValue();
              hashMap1.put("value", Double.valueOf(measureValue.getValue()));
              if (measureValue.getOffset() != null)
                hashMap1.put("offset", measureValue.getOffset()); 
              hashMap.put(str, hashMap1);
            } 
            list.add(hashMap);
          } 
        } 
      } 
      return (List)list;
    }
    
    public void a(MeasureValueSet param1MeasureValueSet) {
      if (param1MeasureValueSet != null) {
        if (g.a(this.a) != null && g.a(this.a).isCommitDetail()) {
          this.b.add(a(param1MeasureValueSet));
          return;
        } 
        if (this.b.isEmpty()) {
          this.b.add(a(param1MeasureValueSet));
          return;
        } 
        ((MeasureValueSet)this.b.get(0)).merge(param1MeasureValueSet);
      } 
    }
    
    public void i() {
      this.count++;
    }
    
    public void j() {
      this.l++;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */