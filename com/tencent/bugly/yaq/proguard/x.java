package com.tencent.bugly.yaq.proguard;

import android.util.Log;
import java.io.File;
import java.util.Locale;

public final class x {
  public static String a;
  
  public static boolean b;
  
  private static String c = "CrashReportInfo";
  
  static {
    a = "CrashReport";
    b = false;
    throw new VerifyError("bad dex opcode");
  }
  
  private static boolean a(int paramInt, String paramString, Object... paramVarArgs) {
    String str;
    if (!b)
      return false; 
    if (paramString == null) {
      str = "null";
    } else {
      str = paramString;
      if (paramVarArgs != null) {
        str = paramString;
        if (paramVarArgs.length != 0)
          str = String.format(Locale.US, paramString, paramVarArgs); 
      } 
    } 
    switch (paramInt) {
      default:
        return false;
      case 0:
        Log.i(a, str);
        return true;
      case 5:
        Log.i(c, str);
        return true;
      case 1:
        Log.d(a, str);
        return true;
      case 2:
        Log.w(a, str);
        return true;
      case 3:
        break;
    } 
    Log.e(a, str);
    return true;
  }
  
  public static boolean a(Class paramClass, String paramString, Object... paramVarArgs) {
    Locale locale = Locale.US;
    Object[] arrayOfObject = new Object[2];
    throw new VerifyError("bad dex opcode");
  }
  
  public static boolean a(String paramString, Object... paramVarArgs) {
    return a(0, paramString, paramVarArgs);
  }
  
  public static boolean a(Throwable paramThrowable) {
    return !b ? false : a(2, z.a(paramThrowable), new Object[0]);
  }
  
  public static boolean b(Class paramClass, String paramString, Object... paramVarArgs) {
    Locale locale = Locale.US;
    Object[] arrayOfObject = new Object[2];
    throw new VerifyError("bad dex opcode");
  }
  
  public static boolean b(String paramString, Object... paramVarArgs) {
    return a(5, paramString, paramVarArgs);
  }
  
  public static boolean b(Throwable paramThrowable) {
    return !b ? false : a(3, z.a(paramThrowable), new Object[0]);
  }
  
  public static boolean c(String paramString, Object... paramVarArgs) {
    return a(1, paramString, paramVarArgs);
  }
  
  public static boolean d(String paramString, Object... paramVarArgs) {
    return a(2, paramString, paramVarArgs);
  }
  
  public static boolean e(String paramString, Object... paramVarArgs) {
    return a(3, paramString, paramVarArgs);
  }
  
  public static final class a {
    private boolean a;
    
    private File b;
    
    private String c;
    
    private long d;
    
    private long e;
    
    public a(String param1String) {
      throw new VerifyError("bad dex opcode");
    }
    
    private boolean a() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: new java/lang/VerifyError
      //   5: dup
      //   6: ldc 'bad dex opcode'
      //   8: invokespecial <init> : (Ljava/lang/String;)V
      //   11: athrow
      //   12: astore_1
      //   13: new java/lang/VerifyError
      //   16: dup
      //   17: ldc 'bad dex opcode'
      //   19: invokespecial <init> : (Ljava/lang/String;)V
      //   22: athrow
      //   23: astore_1
      //   24: aload_0
      //   25: monitorexit
      //   26: aload_1
      //   27: athrow
      // Exception table:
      //   from	to	target	type
      //   2	12	12	java/lang/Throwable
      //   2	12	23	finally
      //   13	23	23	finally
    }
    
    public final boolean a(String param1String) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: new java/lang/VerifyError
      //   5: dup
      //   6: ldc 'bad dex opcode'
      //   8: invokespecial <init> : (Ljava/lang/String;)V
      //   11: athrow
      //   12: astore_1
      //   13: aload_0
      //   14: monitorexit
      //   15: aload_1
      //   16: athrow
      // Exception table:
      //   from	to	target	type
      //   2	12	12	finally
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\proguard\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */