package com.tencent.bugly.yaq.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.yaq.crashreport.common.info.a;
import com.tencent.bugly.yaq.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.yaq.proguard.x;
import com.tencent.bugly.yaq.proguard.z;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b {
  private static List<File> a = new ArrayList<File>();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static CrashDetailBean a(Context paramContext, String paramString, NativeExceptionHandler paramNativeExceptionHandler) {
    if (paramContext == null || paramString == null || paramNativeExceptionHandler == null) {
      x.e("get eup record file args error", new Object[0]);
      return null;
    } 
    new File(paramString, "rqd_record.eup");
    throw new VerifyError("bad dex opcode");
  }
  
  private static CrashDetailBean a(Context paramContext, Map<String, String> paramMap, NativeExceptionHandler paramNativeExceptionHandler) {
    if (paramMap == null)
      return null; 
    if (a.a(paramContext) == null) {
      x.e("abnormal com info not created", new Object[0]);
      return null;
    } 
    if ((String)paramMap.get("intStateStr") != null)
      throw new VerifyError("bad dex opcode"); 
    x.e("no intStateStr", new Object[0]);
    return null;
  }
  
  private static String a(BufferedInputStream paramBufferedInputStream) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new java/io/ByteArrayOutputStream
    //   9: dup
    //   10: sipush #1024
    //   13: invokespecial <init> : (I)V
    //   16: astore_1
    //   17: aload_1
    //   18: astore_0
    //   19: new java/lang/VerifyError
    //   22: dup
    //   23: ldc 'bad dex opcode'
    //   25: invokespecial <init> : (Ljava/lang/String;)V
    //   28: athrow
    //   29: astore_2
    //   30: aload_1
    //   31: astore_0
    //   32: aload_2
    //   33: invokestatic a : (Ljava/lang/Throwable;)Z
    //   36: pop
    //   37: aload_1
    //   38: ifnull -> 4
    //   41: new java/lang/VerifyError
    //   44: dup
    //   45: ldc 'bad dex opcode'
    //   47: invokespecial <init> : (Ljava/lang/String;)V
    //   50: athrow
    //   51: astore_1
    //   52: aconst_null
    //   53: astore_0
    //   54: aload_0
    //   55: ifnull -> 68
    //   58: new java/lang/VerifyError
    //   61: dup
    //   62: ldc 'bad dex opcode'
    //   64: invokespecial <init> : (Ljava/lang/String;)V
    //   67: athrow
    //   68: aload_1
    //   69: athrow
    //   70: astore_1
    //   71: goto -> 54
    //   74: astore_2
    //   75: aconst_null
    //   76: astore_1
    //   77: goto -> 30
    // Exception table:
    //   from	to	target	type
    //   6	17	74	java/lang/Throwable
    //   6	17	51	finally
    //   19	29	29	java/lang/Throwable
    //   19	29	70	finally
    //   32	37	70	finally
  }
  
  protected static String a(String paramString) {
    if (paramString == null)
      return ""; 
    throw new VerifyError("bad dex opcode");
  }
  
  public static String a(String paramString1, int paramInt, String paramString2, boolean paramBoolean) {
    if (paramString1 == null || paramInt <= 0)
      return null; 
    new File(paramString1);
    throw new VerifyError("bad dex opcode");
  }
  
  public static String a(String paramString1, String paramString2) {
    if (paramString1 == null || paramString2 == null)
      return null; 
    new StringBuilder();
    if (b(paramString1, paramString2) != null)
      throw new VerifyError("bad dex opcode"); 
    if (c(paramString1, paramString2) != null)
      throw new VerifyError("bad dex opcode"); 
    throw new VerifyError("bad dex opcode");
  }
  
  public static void a(boolean paramBoolean, String paramString) {
    if (paramString != null) {
      a.add(new File(paramString, "rqd_record.eup"));
      a.add(new File(paramString, "reg_record.txt"));
      a.add(new File(paramString, "map_record.txt"));
      a.add(new File(paramString, "backup_record.txt"));
      if (paramBoolean)
        c(paramString); 
    } 
    if (a != null && a.size() > 0) {
      Iterator<File> iterator = a.iterator();
      if (iterator.hasNext()) {
        File file = iterator.next();
        throw new VerifyError("bad dex opcode");
      } 
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  public static String b(String paramString) {
    if (paramString == null)
      return null; 
    new File(paramString, "backup_record.txt");
    throw new VerifyError("bad dex opcode");
  }
  
  private static String b(String paramString1, String paramString2) {
    BufferedReader bufferedReader = z.a(paramString1, "reg_record.txt");
    if (bufferedReader != null)
      try {
        new StringBuilder();
        throw new VerifyError("bad dex opcode");
      } catch (Throwable throwable) {
        x.a(throwable);
        return null;
      } finally {
        if (exception != null)
          try {
            throw new VerifyError("bad dex opcode");
          } catch (Exception exception1) {
            x.a(exception1);
          }  
      }  
    return null;
  }
  
  private static String c(String paramString1, String paramString2) {
    BufferedReader bufferedReader = z.a(paramString1, "map_record.txt");
    if (bufferedReader != null)
      try {
        new StringBuilder();
        throw new VerifyError("bad dex opcode");
      } catch (Throwable throwable) {
        x.a(throwable);
        return null;
      } finally {
        if (exception != null)
          try {
            throw new VerifyError("bad dex opcode");
          } catch (Exception exception1) {
            x.a(exception1);
          }  
      }  
    return null;
  }
  
  public static void c(String paramString) {
    if (paramString != null)
      try {
        new File(paramString);
        throw new VerifyError("bad dex opcode");
      } catch (Throwable throwable) {
        x.a(throwable);
      }  
    throw new VerifyError("bad dex opcode");
  }
  
  private static Map<String, Integer> d(String paramString) {
    if (paramString == null)
      return null; 
    try {
      new HashMap<Object, Object>();
      throw new VerifyError("bad dex opcode");
    } catch (Exception exception) {
      x.e("error format intStateStr %s", new Object[] { paramString });
      throw new VerifyError("bad dex opcode");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\crashreport\crash\jni\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */