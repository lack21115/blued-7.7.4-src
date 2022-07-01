package com.alibaba.mtl.appmonitor.d;

import java.util.Map;
import org.json.JSONObject;

public class f extends g {
  String TAG = "AlarmSampling";
  
  private int o = 0;
  
  private int p = 0;
  
  public f(com.alibaba.mtl.appmonitor.a.f paramf, int paramInt) {
    super(paramf, paramInt);
    this.o = paramInt;
    this.p = paramInt;
  }
  
  protected void a(JSONObject paramJSONObject) {
    super.a(paramJSONObject);
    this.o = this.n;
    this.p = this.n;
    try {
      Integer integer2 = Integer.valueOf(paramJSONObject.getInt("successSampling"));
      if (integer2 != null)
        this.o = integer2.intValue(); 
      Integer integer1 = Integer.valueOf(paramJSONObject.getInt("failSampling"));
      if (integer1 != null)
        this.p = integer1.intValue(); 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2, Boolean paramBoolean, Map<String, String> paramMap) {
    // Byte code:
    //   0: aload_0
    //   1: getfield TAG : Ljava/lang/String;
    //   4: astore #9
    //   6: iconst_0
    //   7: istore #8
    //   9: iconst_0
    //   10: istore #7
    //   12: aload_0
    //   13: getfield o : I
    //   16: istore #6
    //   18: new java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial <init> : ()V
    //   25: astore #10
    //   27: aload #10
    //   29: ldc 'failSampling:'
    //   31: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload #10
    //   37: aload_0
    //   38: getfield p : I
    //   41: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload #9
    //   47: bipush #7
    //   49: anewarray java/lang/Object
    //   52: dup
    //   53: iconst_0
    //   54: ldc 'samplingSeed:'
    //   56: aastore
    //   57: dup
    //   58: iconst_1
    //   59: iload_1
    //   60: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   63: aastore
    //   64: dup
    //   65: iconst_2
    //   66: ldc 'isSuccess:'
    //   68: aastore
    //   69: dup
    //   70: iconst_3
    //   71: aload #4
    //   73: aastore
    //   74: dup
    //   75: iconst_4
    //   76: ldc 'successSampling:'
    //   78: aastore
    //   79: dup
    //   80: iconst_5
    //   81: iload #6
    //   83: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   86: aastore
    //   87: dup
    //   88: bipush #6
    //   90: aload #10
    //   92: invokevirtual toString : ()Ljava/lang/String;
    //   95: aastore
    //   96: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   99: aload_0
    //   100: getfield o : Ljava/util/Map;
    //   103: ifnull -> 145
    //   106: aload_0
    //   107: getfield o : Ljava/util/Map;
    //   110: aload_2
    //   111: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   116: checkcast com/alibaba/mtl/appmonitor/d/h
    //   119: astore_2
    //   120: aload_2
    //   121: ifnull -> 145
    //   124: aload_2
    //   125: instanceof com/alibaba/mtl/appmonitor/d/d
    //   128: ifeq -> 145
    //   131: aload_2
    //   132: checkcast com/alibaba/mtl/appmonitor/d/d
    //   135: iload_1
    //   136: aload_3
    //   137: aload #4
    //   139: aload #5
    //   141: invokevirtual a : (ILjava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;)Z
    //   144: ireturn
    //   145: aload #4
    //   147: invokevirtual booleanValue : ()Z
    //   150: ifeq -> 167
    //   153: iload_1
    //   154: aload_0
    //   155: getfield o : I
    //   158: if_icmpge -> 164
    //   161: iconst_1
    //   162: istore #7
    //   164: iload #7
    //   166: ireturn
    //   167: iload #8
    //   169: istore #7
    //   171: iload_1
    //   172: aload_0
    //   173: getfield p : I
    //   176: if_icmpge -> 182
    //   179: iconst_1
    //   180: istore #7
    //   182: iload #7
    //   184: ireturn
  }
  
  public void b(JSONObject paramJSONObject) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual a : (Lorg/json/JSONObject;)V
    //   5: aload_0
    //   6: aload_1
    //   7: invokevirtual c : (Lorg/json/JSONObject;)V
    //   10: aload_0
    //   11: getfield o : Ljava/util/Map;
    //   14: invokeinterface clear : ()V
    //   19: aload_1
    //   20: ldc 'metrics'
    //   22: invokevirtual getJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   25: astore #4
    //   27: aload #4
    //   29: ifnull -> 133
    //   32: iconst_0
    //   33: istore_2
    //   34: iload_2
    //   35: aload #4
    //   37: invokevirtual length : ()I
    //   40: if_icmpge -> 133
    //   43: aload #4
    //   45: iload_2
    //   46: invokevirtual getJSONObject : (I)Lorg/json/JSONObject;
    //   49: astore #5
    //   51: aload #5
    //   53: ldc 'module'
    //   55: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   58: astore #6
    //   60: aload #6
    //   62: invokestatic c : (Ljava/lang/String;)Z
    //   65: ifeq -> 126
    //   68: aload_0
    //   69: getfield o : Ljava/util/Map;
    //   72: aload #6
    //   74: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   79: checkcast com/alibaba/mtl/appmonitor/d/h
    //   82: astore_3
    //   83: aload_3
    //   84: astore_1
    //   85: aload_3
    //   86: ifnonnull -> 120
    //   89: new com/alibaba/mtl/appmonitor/d/d
    //   92: dup
    //   93: aload #6
    //   95: aload_0
    //   96: getfield o : I
    //   99: aload_0
    //   100: getfield p : I
    //   103: invokespecial <init> : (Ljava/lang/String;II)V
    //   106: astore_1
    //   107: aload_0
    //   108: getfield o : Ljava/util/Map;
    //   111: aload #6
    //   113: aload_1
    //   114: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   119: pop
    //   120: aload_1
    //   121: aload #5
    //   123: invokevirtual b : (Lorg/json/JSONObject;)V
    //   126: iload_2
    //   127: iconst_1
    //   128: iadd
    //   129: istore_2
    //   130: goto -> 34
    //   133: return
    //   134: astore_1
    //   135: return
    // Exception table:
    //   from	to	target	type
    //   19	27	134	java/lang/Exception
    //   34	83	134	java/lang/Exception
    //   89	120	134	java/lang/Exception
    //   120	126	134	java/lang/Exception
  }
  
  public void setSampling(int paramInt) {
    super.setSampling(paramInt);
    this.o = paramInt;
    this.p = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\d\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */