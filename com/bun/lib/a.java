package com.bun.lib;

import android.util.Log;

public class a {
  private static a b;
  
  private int a = -1;
  
  public static void a(String paramString1, String paramString2) {
    if (a())
      Log.d(paramString1, paramString2); 
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable) {
    if (a())
      Log.d(paramString1, paramString2, paramThrowable); 
  }
  
  public static void a(boolean paramBoolean) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static boolean a() {
    return ((b()).a == 1);
  }
  
  public static a b() {
    // Byte code:
    //   0: getstatic com/bun/lib/a.b : Lcom/bun/lib/a;
    //   3: ifnonnull -> 28
    //   6: ldc com/bun/lib/a
    //   8: monitorenter
    //   9: getstatic com/bun/lib/a.b : Lcom/bun/lib/a;
    //   12: ifnonnull -> 25
    //   15: new com/bun/lib/a
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bun/lib/a.b : Lcom/bun/lib/a;
    //   25: ldc com/bun/lib/a
    //   27: monitorexit
    //   28: getstatic com/bun/lib/a.b : Lcom/bun/lib/a;
    //   31: areturn
    //   32: astore_0
    //   33: ldc com/bun/lib/a
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    // Exception table:
    //   from	to	target	type
    //   9	25	32	finally
    //   25	28	32	finally
    //   33	36	32	finally
  }
  
  public static void b(String paramString1, String paramString2) {
    if (a())
      Log.i(paramString1, paramString2); 
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable) {
    if (a())
      Log.e(paramString1, paramString2, paramThrowable); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\lib\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */