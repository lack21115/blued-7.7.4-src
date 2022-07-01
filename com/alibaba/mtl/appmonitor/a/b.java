package com.alibaba.mtl.appmonitor.a;

import org.json.JSONObject;

public class b extends d {
  public int count;
  
  public double e;
  
  public JSONObject a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial a : ()Lorg/json/JSONObject;
    //   6: astore_1
    //   7: aload_1
    //   8: ldc 'count'
    //   10: aload_0
    //   11: getfield count : I
    //   14: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   17: pop
    //   18: aload_1
    //   19: ldc 'value'
    //   21: aload_0
    //   22: getfield e : D
    //   25: invokevirtual put : (Ljava/lang/String;D)Lorg/json/JSONObject;
    //   28: pop
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: areturn
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    //   38: astore_2
    //   39: goto -> 29
    // Exception table:
    //   from	to	target	type
    //   2	7	33	finally
    //   7	29	38	java/lang/Exception
    //   7	29	33	finally
  }
  
  public void a(double paramDouble) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield e : D
    //   7: dload_1
    //   8: dadd
    //   9: putfield e : D
    //   12: aload_0
    //   13: aload_0
    //   14: getfield count : I
    //   17: iconst_1
    //   18: iadd
    //   19: putfield count : I
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: astore_3
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_3
    //   29: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	25	finally
  }
  
  public void fill(Object... paramVarArgs) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial fill : ([Ljava/lang/Object;)V
    //   7: aload_0
    //   8: dconst_0
    //   9: putfield e : D
    //   12: aload_0
    //   13: iconst_0
    //   14: putfield count : I
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	20	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */