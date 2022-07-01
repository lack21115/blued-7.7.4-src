package com.alibaba.mtl.appmonitor.c;

import com.alibaba.mtl.appmonitor.b.b;
import java.util.HashMap;
import java.util.Map;

public class a {
  private static a a = new a();
  
  private Map<Class<? extends b>, c<? extends b>> m = new HashMap<Class<? extends b>, c<? extends b>>();
  
  public static a a() {
    return a;
  }
  
  private <T extends b> c<T> a(Class<T> paramClass) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield m : Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   12: checkcast com/alibaba/mtl/appmonitor/c/c
    //   15: astore_3
    //   16: aload_3
    //   17: astore_2
    //   18: aload_3
    //   19: ifnonnull -> 42
    //   22: new com/alibaba/mtl/appmonitor/c/c
    //   25: dup
    //   26: invokespecial <init> : ()V
    //   29: astore_2
    //   30: aload_0
    //   31: getfield m : Ljava/util/Map;
    //   34: aload_1
    //   35: aload_2
    //   36: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   41: pop
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_2
    //   45: areturn
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	46	finally
    //   22	42	46	finally
  }
  
  public <T extends b> T a(Class<T> paramClass, Object... paramVarArgs) {
    Exception exception2 = (Exception)a((Class)paramClass).a();
    if (exception2 == null) {
      try {
        b b = (b)paramClass.newInstance();
      } catch (Exception exception) {
        b.a(exception);
        exception = exception2;
      } 
      if (exception != null)
        exception.fill(paramVarArgs); 
      return (T)exception;
    } 
    Exception exception1 = exception2;
  }
  
  public <T extends b> void a(T paramT) {
    if (paramT != null && !(paramT instanceof e)) {
      if (paramT instanceof d)
        return; 
      a((Class)paramT.getClass()).a(paramT);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */