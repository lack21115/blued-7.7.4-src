package com.tencent.bugly.yaq.proguard;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.bugly.yaq.crashreport.common.info.AppInfo;
import com.tencent.bugly.yaq.crashreport.common.info.PlugInBean;
import com.tencent.bugly.yaq.crashreport.common.info.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class z {
  private static Map<String, String> a = null;
  
  private static boolean b = false;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public z() {
    throw new VerifyError("bad dex opcode");
  }
  
  public static Context a(Context paramContext) {
    if (paramContext == null)
      return paramContext; 
    throw new VerifyError("bad dex opcode");
  }
  
  public static SharedPreferences a(String paramString, Context paramContext) {
    if (paramContext != null)
      throw new VerifyError("bad dex opcode"); 
    return null;
  }
  
  private static BufferedReader a(File paramFile) {
    if (paramFile != null)
      throw new VerifyError("bad dex opcode"); 
    return null;
  }
  
  public static BufferedReader a(String paramString1, String paramString2) {
    if (paramString1 == null)
      return null; 
    try {
      new File(paramString1, paramString2);
      throw new VerifyError("bad dex opcode");
    } catch (NullPointerException nullPointerException) {
      x.a(nullPointerException);
      return null;
    } 
  }
  
  public static Object a(String paramString1, String paramString2, Object paramObject, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject) {
    try {
      Class.forName(paramString1);
      throw new VerifyError("bad dex opcode");
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static <T> T a(byte[] paramArrayOfbyte, Parcelable.Creator<T> paramCreator) {
    Parcel.obtain();
    int i = paramArrayOfbyte.length;
    throw new VerifyError("bad dex opcode");
  }
  
  public static String a() {
    return a(System.currentTimeMillis());
  }
  
  public static String a(long paramLong) {
    try {
      new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
      new Date(paramLong);
      throw new VerifyError("bad dex opcode");
    } catch (Exception exception) {
      new Date();
      throw new VerifyError("bad dex opcode");
    } 
  }
  
  public static String a(Context paramContext, int paramInt, String paramString) {
    if (!AppInfo.a(paramContext, "android.permission.READ_LOGS")) {
      x.d("no read_log permission!", new Object[0]);
      return null;
    } 
    if (paramString == null);
    new StringBuilder();
    try {
      Runtime.getRuntime();
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throw new VerifyError("bad dex opcode"); 
      new StringBuilder("\n[error:");
      throw new VerifyError("bad dex opcode");
    } finally {
      paramContext = null;
      if (false)
        try {
          throw new VerifyError("bad dex opcode");
        } catch (IOException iOException) {
          throw new VerifyError("bad dex opcode");
        }  
    } 
  }
  
  public static String a(Context paramContext, String paramString) {
    if (paramString != null)
      throw new VerifyError("bad dex opcode"); 
    return "";
  }
  
  public static String a(File paramFile, int paramInt, boolean paramBoolean) {
    if (paramFile != null)
      throw new VerifyError("bad dex opcode"); 
    return null;
  }
  
  public static String a(Throwable paramThrowable) {
    if (paramThrowable == null)
      return ""; 
    try {
      new PrintWriter(new StringWriter());
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throw new VerifyError("bad dex opcode"); 
      return "fail";
    } 
  }
  
  public static String a(Date paramDate) {
    if (paramDate == null)
      return null; 
    try {
      new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
      throw new VerifyError("bad dex opcode");
    } catch (Exception exception) {
      new Date();
      throw new VerifyError("bad dex opcode");
    } 
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return ""; 
    new StringBuffer();
    if (paramArrayOfbyte.length < 0) {
      Integer.toHexString(paramArrayOfbyte[0] & 0xFF);
      throw new VerifyError("bad dex opcode");
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  public static Thread a(Runnable paramRunnable, String paramString) {
    try {
      new Thread(paramRunnable);
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      Object[] arrayOfObject = new Object[1];
      throw new VerifyError("bad dex opcode");
    } 
  }
  
  public static Map<String, String> a(int paramInt, boolean paramBoolean) {
    new HashMap<Object, Object>(12);
    if (Thread.getAllStackTraces() == null)
      return null; 
    Looper.getMainLooper();
    throw new VerifyError("bad dex opcode");
  }
  
  public static Map<String, PlugInBean> a(Parcel paramParcel) {
    throw new VerifyError("bad dex opcode");
  }
  
  public static void a(Parcel paramParcel, Map<String, PlugInBean> paramMap) {
    if (paramMap == null || paramMap.size() <= 0)
      throw new VerifyError("bad dex opcode"); 
    int i = paramMap.size();
    new ArrayList(i);
    new ArrayList(i);
    Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
    if (iterator.hasNext()) {
      ((Map.Entry)iterator.next()).getKey();
      throw new VerifyError("bad dex opcode");
    } 
    new Bundle();
    throw new VerifyError("bad dex opcode");
  }
  
  public static void a(Class<?> paramClass, String paramString, Object paramObject1, Object paramObject2) {
    try {
      throw new VerifyError("bad dex opcode");
    } catch (Exception exception) {
      throw new VerifyError("bad dex opcode");
    } 
  }
  
  public static boolean a(Context paramContext, String paramString, long paramLong) {
    x.c("[Util] Try to lock file:%s (pid=%d | tid=%d)", new Object[] { paramString, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    try {
      new StringBuilder();
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      x.a(throwable);
      return false;
    } 
  }
  
  public static boolean a(File paramFile1, File paramFile2, int paramInt) {
    x.c("rqdp{  ZF start}", new Object[0]);
    if (paramFile1 != null && paramFile2 != null)
      throw new VerifyError("bad dex opcode"); 
    x.d("rqdp{  err ZF 1R!}", new Object[0]);
    return false;
  }
  
  public static boolean a(Runnable paramRunnable) {
    if (paramRunnable != null) {
      if (w.a() != null)
        throw new VerifyError("bad dex opcode"); 
      throw new VerifyError("bad dex opcode");
    } 
    return false;
  }
  
  public static boolean a(String paramString) {
    if (paramString != null)
      throw new VerifyError("bad dex opcode"); 
    return true;
  }
  
  public static byte[] a(int paramInt) {
    // Byte code:
    //   0: ldc com/tencent/bugly/yaq/proguard/z
    //   2: monitorenter
    //   3: bipush #16
    //   5: newarray byte
    //   7: astore_1
    //   8: new java/io/DataInputStream
    //   11: dup
    //   12: new java/io/FileInputStream
    //   15: dup
    //   16: new java/io/File
    //   19: dup
    //   20: ldc '/dev/urandom'
    //   22: invokespecial <init> : (Ljava/lang/String;)V
    //   25: invokespecial <init> : (Ljava/io/File;)V
    //   28: invokespecial <init> : (Ljava/io/InputStream;)V
    //   31: astore_2
    //   32: aload_2
    //   33: astore_1
    //   34: new java/lang/VerifyError
    //   37: dup
    //   38: ldc 'bad dex opcode'
    //   40: invokespecial <init> : (Ljava/lang/String;)V
    //   43: athrow
    //   44: ldc com/tencent/bugly/yaq/proguard/z
    //   46: monitorexit
    //   47: aconst_null
    //   48: areturn
    //   49: astore_3
    //   50: aconst_null
    //   51: astore_2
    //   52: aload_2
    //   53: astore_1
    //   54: ldc_w 'Failed to read from /dev/urandom : %s'
    //   57: iconst_1
    //   58: anewarray java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: aload_3
    //   64: aastore
    //   65: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   68: pop
    //   69: aload_2
    //   70: ifnull -> 83
    //   73: new java/lang/VerifyError
    //   76: dup
    //   77: ldc 'bad dex opcode'
    //   79: invokespecial <init> : (Ljava/lang/String;)V
    //   82: athrow
    //   83: ldc_w 'AES'
    //   86: invokestatic getInstance : (Ljava/lang/String;)Ljavax/crypto/KeyGenerator;
    //   89: pop
    //   90: new java/security/SecureRandom
    //   93: dup
    //   94: invokespecial <init> : ()V
    //   97: pop
    //   98: new java/lang/VerifyError
    //   101: dup
    //   102: ldc 'bad dex opcode'
    //   104: invokespecial <init> : (Ljava/lang/String;)V
    //   107: athrow
    //   108: aload_1
    //   109: ifnull -> 122
    //   112: new java/lang/VerifyError
    //   115: dup
    //   116: ldc 'bad dex opcode'
    //   118: invokespecial <init> : (Ljava/lang/String;)V
    //   121: athrow
    //   122: aload_2
    //   123: athrow
    //   124: astore_1
    //   125: aload_1
    //   126: invokestatic b : (Ljava/lang/Throwable;)Z
    //   129: ifne -> 142
    //   132: new java/lang/VerifyError
    //   135: dup
    //   136: ldc 'bad dex opcode'
    //   138: invokespecial <init> : (Ljava/lang/String;)V
    //   141: athrow
    //   142: goto -> 44
    //   145: astore_1
    //   146: ldc com/tencent/bugly/yaq/proguard/z
    //   148: monitorexit
    //   149: aload_1
    //   150: athrow
    //   151: astore_2
    //   152: goto -> 108
    //   155: astore_3
    //   156: goto -> 52
    //   159: astore_2
    //   160: aconst_null
    //   161: astore_1
    //   162: goto -> 108
    // Exception table:
    //   from	to	target	type
    //   3	32	49	java/lang/Exception
    //   3	32	159	finally
    //   34	44	155	java/lang/Exception
    //   34	44	151	finally
    //   54	69	151	finally
    //   73	83	124	java/lang/Exception
    //   73	83	145	finally
    //   83	108	124	java/lang/Exception
    //   83	108	145	finally
    //   112	122	124	java/lang/Exception
    //   112	122	145	finally
    //   122	124	124	java/lang/Exception
    //   122	124	145	finally
    //   125	142	145	finally
  }
  
  @TargetApi(19)
  public static byte[] a(int paramInt, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    try {
      new SecretKeySpec(paramArrayOfbyte2, "AES");
      Cipher.getInstance("AES/GCM/NoPadding");
      if (Build.VERSION.SDK_INT < 21 || b) {
        new IvParameterSpec(paramArrayOfbyte2);
        throw new VerifyError("bad dex opcode");
      } 
      throw new VerifyError("bad dex opcode");
    } catch (Exception exception) {
      if (!x.b(exception))
        throw new VerifyError("bad dex opcode"); 
      return null;
    } 
  }
  
  public static byte[] a(Parcelable paramParcelable) {
    paramParcelable.writeToParcel(Parcel.obtain(), 0);
    throw new VerifyError("bad dex opcode");
  }
  
  public static byte[] a(File paramFile, String paramString1, String paramString2) {
    if (paramString1 != null)
      throw new VerifyError("bad dex opcode"); 
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfbyte, int paramInt) {
    String str;
    if (paramArrayOfbyte == null || paramInt == -1)
      return paramArrayOfbyte; 
    int i = paramArrayOfbyte.length;
    if (paramInt == 2) {
      str = "Gzip";
    } else {
      str = "zip";
    } 
    x.c("[Util] Zip %d bytes data with type %s", new Object[] { Integer.valueOf(i), str });
    try {
      ab ab = aa.a(paramInt);
      return (ab == null) ? null : ab.a(paramArrayOfbyte);
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throw new VerifyError("bad dex opcode"); 
      return null;
    } 
  }
  
  public static byte[] a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, String paramString) {
    if (paramArrayOfbyte != null)
      try {
        return a(a(paramArrayOfbyte, 2), 1, paramString);
      } catch (Throwable throwable) {} 
    return null;
  }
  
  private static byte[] a(byte[] paramArrayOfbyte, int paramInt, String paramString) {
    if (paramArrayOfbyte == null || paramInt == -1)
      return paramArrayOfbyte; 
    x.c("rqdp{  enD:} %d %d", new Object[] { Integer.valueOf(paramArrayOfbyte.length), Integer.valueOf(paramInt) });
    try {
      ag ag = a.a(paramInt);
      if (ag == null)
        return null; 
      ag.a(paramString);
      return ag.b(paramArrayOfbyte);
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throw new VerifyError("bad dex opcode"); 
      return null;
    } 
  }
  
  public static long b() {
    try {
      System.currentTimeMillis();
      TimeZone.getDefault();
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throw new VerifyError("bad dex opcode"); 
      return -1L;
    } 
  }
  
  public static String b(String paramString1, String paramString2) {
    if (a.b() != null) {
      a.b();
      throw new VerifyError("bad dex opcode");
    } 
    return "";
  }
  
  public static String b(Throwable paramThrowable) {
    if (paramThrowable == null)
      return ""; 
    new PrintWriter(new StringWriter());
    throw new VerifyError("bad dex opcode");
  }
  
  public static String b(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0)
      return "NULL"; 
    try {
      MessageDigest.getInstance("SHA-1");
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throw new VerifyError("bad dex opcode"); 
      return null;
    } 
  }
  
  public static Map<String, String> b(Parcel paramParcel) {
    throw new VerifyError("bad dex opcode");
  }
  
  public static void b(long paramLong) {
    try {
      Thread.sleep(paramLong);
      throw new VerifyError("bad dex opcode");
    } catch (InterruptedException interruptedException) {
      throw new VerifyError("bad dex opcode");
    } 
  }
  
  public static void b(Parcel paramParcel, Map<String, String> paramMap) {
    if (paramMap == null || paramMap.size() <= 0)
      throw new VerifyError("bad dex opcode"); 
    int i = paramMap.size();
    new ArrayList(i);
    new ArrayList(i);
    Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
    if (iterator.hasNext()) {
      ((Map.Entry)iterator.next()).getKey();
      throw new VerifyError("bad dex opcode");
    } 
    new Bundle();
    throw new VerifyError("bad dex opcode");
  }
  
  public static void b(String paramString) {
    if (paramString == null)
      throw new VerifyError("bad dex opcode"); 
    new File(paramString);
    throw new VerifyError("bad dex opcode");
  }
  
  public static boolean b(Context paramContext, String paramString) {
    x.c("[Util] Try to unlock file: %s (pid=%d | tid=%d)", new Object[] { paramString, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    try {
      new StringBuilder();
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      x.a(throwable);
      return false;
    } 
  }
  
  public static byte[] b(int paramInt, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    try {
      KeyFactory.getInstance("RSA");
      new X509EncodedKeySpec(paramArrayOfbyte2);
      throw new VerifyError("bad dex opcode");
    } catch (Exception exception) {
      if (!x.b(exception))
        throw new VerifyError("bad dex opcode"); 
      return null;
    } 
  }
  
  public static byte[] b(byte[] paramArrayOfbyte, int paramInt) {
    String str;
    if (paramArrayOfbyte == null || paramInt == -1)
      return paramArrayOfbyte; 
    int i = paramArrayOfbyte.length;
    if (paramInt == 2) {
      str = "Gzip";
    } else {
      str = "zip";
    } 
    x.c("[Util] Unzip %d bytes data with type %s", new Object[] { Integer.valueOf(i), str });
    try {
      ab ab = aa.a(paramInt);
      return (ab == null) ? null : ab.b(paramArrayOfbyte);
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throw new VerifyError("bad dex opcode"); 
      return null;
    } 
  }
  
  public static byte[] b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, String paramString) {
    try {
      return b(b(paramArrayOfbyte, 1, paramString), 2);
    } catch (Exception exception) {
      if (!x.a(exception))
        throw new VerifyError("bad dex opcode"); 
      return null;
    } 
  }
  
  private static byte[] b(byte[] paramArrayOfbyte, int paramInt, String paramString) {
    if (paramArrayOfbyte == null || paramInt == -1)
      return paramArrayOfbyte; 
    try {
      ag ag = a.a(paramInt);
      if (ag == null)
        return null; 
      ag.a(paramString);
      return ag.a(paramArrayOfbyte);
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throw new VerifyError("bad dex opcode"); 
      x.d("encrytype %d %s", new Object[] { Integer.valueOf(paramInt), paramString });
      return null;
    } 
  }
  
  public static long c(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return -1L; 
    try {
      return Long.parseLong(new String(paramArrayOfbyte, "utf-8"));
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new VerifyError("bad dex opcode");
    } 
  }
  
  private static ArrayList<String> c(Context paramContext, String paramString) {
    if (AppInfo.f(paramContext))
      return new ArrayList<String>(Arrays.asList(new String[] { "unknown(low memory)" })); 
    new ArrayList();
    try {
      new File("/system/bin/sh");
      throw new VerifyError("bad dex opcode");
    } catch (Throwable null) {
      try {
        if (!x.a(throwable))
          throw new VerifyError("bad dex opcode"); 
        if (false)
          try {
            throw new VerifyError("bad dex opcode");
          } catch (IOException iOException) {
            throw new VerifyError("bad dex opcode");
          }  
        if (false)
          try {
            throw new VerifyError("bad dex opcode");
          } catch (IOException iOException) {
            throw new VerifyError("bad dex opcode");
          }  
        return null;
      } finally {}
    } finally {}
    if (false)
      try {
        throw new VerifyError("bad dex opcode");
      } catch (IOException null) {
        throw new VerifyError("bad dex opcode");
      }  
    if (false)
      try {
        throw new VerifyError("bad dex opcode");
      } catch (IOException throwable) {
        throw new VerifyError("bad dex opcode");
      }  
    throw throwable;
  }
  
  public static boolean c(String paramString) {
    if (paramString != null)
      throw new VerifyError("bad dex opcode"); 
    if (true)
      return false; 
    throw new VerifyError("bad dex opcode");
  }
  
  public static byte[] c(long paramLong) {
    try {
      new StringBuilder();
      throw new VerifyError("bad dex opcode");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new VerifyError("bad dex opcode");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\proguard\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */