package com.alibaba.mtl.appmonitor.d;

import com.alibaba.mtl.log.e.i;
import java.util.Map;
import org.json.JSONObject;

public class d extends h {
  private int o = this.n;
  
  private int p = this.n;
  
  public d(String paramString, int paramInt1, int paramInt2) {
    super(paramString, 0);
  }
  
  protected void a(JSONObject paramJSONObject) {
    super.a(paramJSONObject);
    this.o = this.n;
    this.p = this.n;
    try {
      Integer integer1 = Integer.valueOf(paramJSONObject.getInt("successSampling"));
      if (integer1 != null)
        this.o = integer1.intValue(); 
      Integer integer2 = Integer.valueOf(paramJSONObject.getInt("failSampling"));
      if (integer2 != null)
        this.p = integer2.intValue(); 
      i.a("AlarmModuleSampling", new Object[] { "[updateSelfSampling]", paramJSONObject, "successSampling:", integer1, "failSampling" });
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public boolean a(int paramInt, String paramString, Boolean paramBoolean, Map<String, String> paramMap) {
    // Byte code:
    //   0: ldc 'AlarmModuleSampling'
    //   2: bipush #8
    //   4: anewarray java/lang/Object
    //   7: dup
    //   8: iconst_0
    //   9: ldc 'samplingSeed:'
    //   11: aastore
    //   12: dup
    //   13: iconst_1
    //   14: iload_1
    //   15: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   18: aastore
    //   19: dup
    //   20: iconst_2
    //   21: ldc 'isSuccess:'
    //   23: aastore
    //   24: dup
    //   25: iconst_3
    //   26: aload_3
    //   27: aastore
    //   28: dup
    //   29: iconst_4
    //   30: ldc 'successSampling:'
    //   32: aastore
    //   33: dup
    //   34: iconst_5
    //   35: aload_0
    //   36: getfield o : I
    //   39: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   42: aastore
    //   43: dup
    //   44: bipush #6
    //   46: ldc 'failSampling:'
    //   48: aastore
    //   49: dup
    //   50: bipush #7
    //   52: aload_0
    //   53: getfield p : I
    //   56: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   59: aastore
    //   60: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   63: aload_0
    //   64: getfield p : Ljava/util/Map;
    //   67: ifnull -> 107
    //   70: aload_0
    //   71: getfield p : Ljava/util/Map;
    //   74: aload_2
    //   75: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   80: checkcast com/alibaba/mtl/appmonitor/d/i
    //   83: astore_2
    //   84: aload_2
    //   85: ifnull -> 107
    //   88: aload_2
    //   89: instanceof com/alibaba/mtl/appmonitor/d/e
    //   92: ifeq -> 107
    //   95: aload_2
    //   96: checkcast com/alibaba/mtl/appmonitor/d/e
    //   99: iload_1
    //   100: aload_3
    //   101: aload #4
    //   103: invokevirtual a : (ILjava/lang/Boolean;Ljava/util/Map;)Z
    //   106: ireturn
    //   107: aload_0
    //   108: iload_1
    //   109: aload_3
    //   110: invokevirtual booleanValue : ()Z
    //   113: invokevirtual a : (IZ)Z
    //   116: ireturn
  }
  
  protected boolean a(int paramInt, boolean paramBoolean) {
    return paramBoolean ? ((paramInt < this.o)) : ((paramInt < this.p));
  }
  
  public void b(JSONObject paramJSONObject) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual a : (Lorg/json/JSONObject;)V
    //   5: aload_1
    //   6: ldc 'monitorPoints'
    //   8: invokevirtual getJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   11: astore #4
    //   13: aload #4
    //   15: ifnull -> 119
    //   18: iconst_0
    //   19: istore_2
    //   20: iload_2
    //   21: aload #4
    //   23: invokevirtual length : ()I
    //   26: if_icmpge -> 119
    //   29: aload #4
    //   31: iload_2
    //   32: invokevirtual getJSONObject : (I)Lorg/json/JSONObject;
    //   35: astore #5
    //   37: aload #5
    //   39: ldc 'monitorPoint'
    //   41: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   44: astore #6
    //   46: aload #6
    //   48: invokestatic c : (Ljava/lang/String;)Z
    //   51: ifeq -> 112
    //   54: aload_0
    //   55: getfield p : Ljava/util/Map;
    //   58: aload #6
    //   60: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   65: checkcast com/alibaba/mtl/appmonitor/d/i
    //   68: astore_3
    //   69: aload_3
    //   70: astore_1
    //   71: aload_3
    //   72: ifnonnull -> 106
    //   75: new com/alibaba/mtl/appmonitor/d/e
    //   78: dup
    //   79: aload #6
    //   81: aload_0
    //   82: getfield o : I
    //   85: aload_0
    //   86: getfield p : I
    //   89: invokespecial <init> : (Ljava/lang/String;II)V
    //   92: astore_1
    //   93: aload_0
    //   94: getfield p : Ljava/util/Map;
    //   97: aload #6
    //   99: aload_1
    //   100: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   105: pop
    //   106: aload_1
    //   107: aload #5
    //   109: invokevirtual b : (Lorg/json/JSONObject;)V
    //   112: iload_2
    //   113: iconst_1
    //   114: iadd
    //   115: istore_2
    //   116: goto -> 20
    //   119: return
    //   120: astore_1
    //   121: return
    // Exception table:
    //   from	to	target	type
    //   5	13	120	java/lang/Exception
    //   20	69	120	java/lang/Exception
    //   75	106	120	java/lang/Exception
    //   106	112	120	java/lang/Exception
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */