package com.qq.e.comm.plugin.l;

import android.text.TextUtils;
import com.qq.e.comm.plugin.s.e;
import com.qq.e.comm.plugin.util.ak;

public class a {
  private static volatile a a;
  
  public static a a() {
    // Byte code:
    //   0: getstatic com/qq/e/comm/plugin/l/a.a : Lcom/qq/e/comm/plugin/l/a;
    //   3: ifnonnull -> 37
    //   6: ldc com/qq/e/comm/plugin/l/a
    //   8: monitorenter
    //   9: getstatic com/qq/e/comm/plugin/l/a.a : Lcom/qq/e/comm/plugin/l/a;
    //   12: ifnonnull -> 25
    //   15: new com/qq/e/comm/plugin/l/a
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/qq/e/comm/plugin/l/a.a : Lcom/qq/e/comm/plugin/l/a;
    //   25: ldc com/qq/e/comm/plugin/l/a
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/qq/e/comm/plugin/l/a
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/qq/e/comm/plugin/l/a.a : Lcom/qq/e/comm/plugin/l/a;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private <T> T a(e parame, String paramString, Class<T> paramClass, T paramT) {
    ak.a("ABTestManager", "---------------------ABTest------------------");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("cfg : ");
    stringBuilder.append(parame);
    ak.a("ABTestManager", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("key : ");
    stringBuilder.append(paramString);
    ak.a("ABTestManager", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("defValue : ");
    stringBuilder.append(paramT);
    ak.a("ABTestManager", stringBuilder.toString());
    T t = paramT;
    if (parame != null) {
      t = paramT;
      if (parame.a != null) {
        if (TextUtils.isEmpty(paramString))
          return paramT; 
        try {
          Object object = parame.a.opt(paramString);
          if (object != null) {
            object = paramClass.cast(object);
            paramT = (T)object;
          } else {
            object = new StringBuilder();
            object.append("cannot find key : ");
            object.append(paramString);
            object.append(" in [cfg -> playcfg]");
            ak.a("ABTestManager", object.toString());
          } 
        } catch (Exception exception) {
          ak.a("ABTestManager", "get cfg value error.", exception);
          exception.printStackTrace();
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("value : ");
        stringBuilder1.append(paramT);
        ak.a("ABTestManager", stringBuilder1.toString());
        t = paramT;
      } 
    } 
    return t;
  }
  
  public int a(e parame, String paramString, int paramInt) {
    return ((Integer)a(parame, paramString, Integer.class, Integer.valueOf(paramInt))).intValue();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\l\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */