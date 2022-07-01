package com.tencent.tbs.sdk.extension.partner.c;

import android.util.Log;
import java.lang.reflect.Method;

public class g {
  private static Method[] a = new Method[] { null, null, null, null, null };
  
  private static String[] b = new String[] { "i", "d", "e", "v", "w" };
  
  private static String c = "com.tencent.smtt.utils.TbsLog";
  
  private static boolean d = false;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private static void a() {
    // Byte code:
    //   0: ldc com/tencent/tbs/sdk/extension/partner/c/g
    //   2: monitorenter
    //   3: iconst_1
    //   4: putstatic com/tencent/tbs/sdk/extension/partner/c/g.d : Z
    //   7: getstatic com/tencent/tbs/sdk/extension/partner/c/g.c : Ljava/lang/String;
    //   10: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   13: astore_1
    //   14: iconst_0
    //   15: istore_0
    //   16: iload_0
    //   17: getstatic com/tencent/tbs/sdk/extension/partner/c/g.a : [Ljava/lang/reflect/Method;
    //   20: arraylength
    //   21: if_icmpge -> 68
    //   24: getstatic com/tencent/tbs/sdk/extension/partner/c/g.a : [Ljava/lang/reflect/Method;
    //   27: iload_0
    //   28: aload_1
    //   29: getstatic com/tencent/tbs/sdk/extension/partner/c/g.b : [Ljava/lang/String;
    //   32: iload_0
    //   33: aaload
    //   34: iconst_2
    //   35: anewarray java/lang/Class
    //   38: dup
    //   39: iconst_0
    //   40: ldc java/lang/String
    //   42: aastore
    //   43: dup
    //   44: iconst_1
    //   45: ldc java/lang/String
    //   47: aastore
    //   48: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   51: aastore
    //   52: getstatic com/tencent/tbs/sdk/extension/partner/c/g.a : [Ljava/lang/reflect/Method;
    //   55: iload_0
    //   56: aaload
    //   57: iconst_1
    //   58: invokevirtual setAccessible : (Z)V
    //   61: iload_0
    //   62: iconst_1
    //   63: iadd
    //   64: istore_0
    //   65: goto -> 16
    //   68: ldc com/tencent/tbs/sdk/extension/partner/c/g
    //   70: monitorexit
    //   71: return
    //   72: astore_1
    //   73: ldc com/tencent/tbs/sdk/extension/partner/c/g
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Exception table:
    //   from	to	target	type
    //   3	14	72	finally
    //   16	61	72	finally
  }
  
  public static void a(String paramString1, String paramString2) {
    a("i", paramString1, paramString2);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3) {
    StringBuilder stringBuilder;
    byte b;
    if ("i".equals(paramString1)) {
      b = 0;
    } else if ("d".equals(paramString1)) {
      b = 1;
    } else if ("e".equals(paramString1)) {
      b = 2;
    } else if ("v".equals(paramString1)) {
      b = 3;
    } else if ("w".equals(paramString1)) {
      b = 4;
    } else {
      stringBuilder = new StringBuilder();
      stringBuilder.append("tbslog exceptions - invalid level:");
      stringBuilder.append(paramString1);
      Log.e(paramString2, stringBuilder.toString());
      return;
    } 
    try {
      if (!d)
        a(); 
      Method method = a[b];
      if (method != null) {
        method.invoke(null, new Object[] { paramString2, stringBuilder });
        return;
      } 
    } catch (Throwable throwable) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("tbslog exceptions:");
      stringBuilder.append(Log.getStackTraceString(throwable));
      Log.e(paramString2, stringBuilder.toString());
    } 
  }
  
  public static void b(String paramString1, String paramString2) {
    a("d", paramString1, paramString2);
  }
  
  public static void c(String paramString1, String paramString2) {
    a("e", paramString1, paramString2);
  }
  
  public static void d(String paramString1, String paramString2) {
    a("w", paramString1, paramString2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\c\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */