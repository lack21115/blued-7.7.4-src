package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;

public class BksUtil {
  private static final String a = BksUtil.class.getSimpleName();
  
  private static final Uri b = Uri.parse("content://com.huawei.hwid");
  
  private static final String[] c = new String[] { "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05", "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539" };
  
  private static int a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return -1; 
    File file = new File(paramString);
    if (file.exists()) {
      g.c(a, "The directory  has already exists");
      return 1;
    } 
    if (file.mkdirs()) {
      g.a(a, "create directory  success");
      return 0;
    } 
    g.d(a, "create directory  failed");
    return -1;
  }
  
  public static InputStream a(Context paramContext) {
    // Byte code:
    //   0: ldc com/huawei/secure/android/common/ssl/util/BksUtil
    //   2: monitorenter
    //   3: getstatic com/huawei/secure/android/common/ssl/util/BksUtil.a : Ljava/lang/String;
    //   6: ldc 'get bks from tss begin'
    //   8: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   11: aload_0
    //   12: ifnull -> 19
    //   15: aload_0
    //   16: invokestatic a : (Landroid/content/Context;)V
    //   19: invokestatic a : ()Landroid/content/Context;
    //   22: astore_0
    //   23: aload_0
    //   24: ifnonnull -> 40
    //   27: getstatic com/huawei/secure/android/common/ssl/util/BksUtil.a : Ljava/lang/String;
    //   30: ldc 'context is null'
    //   32: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   35: ldc com/huawei/secure/android/common/ssl/util/BksUtil
    //   37: monitorexit
    //   38: aconst_null
    //   39: areturn
    //   40: ldc 'com.huawei.hwid'
    //   42: invokestatic a : (Ljava/lang/String;)Z
    //   45: ifne -> 69
    //   48: ldc 'com.huawei.hms'
    //   50: invokestatic a : (Ljava/lang/String;)Z
    //   53: ifne -> 69
    //   56: getstatic com/huawei/secure/android/common/ssl/util/BksUtil.a : Ljava/lang/String;
    //   59: ldc 'hms not exist'
    //   61: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   64: ldc com/huawei/secure/android/common/ssl/util/BksUtil
    //   66: monitorexit
    //   67: aconst_null
    //   68: areturn
    //   69: ldc 'com.huawei.hwid'
    //   71: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   74: invokestatic b : (Ljava/lang/String;)Z
    //   77: ifne -> 137
    //   80: ldc 'com.huawei.hms'
    //   82: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   85: invokestatic b : (Ljava/lang/String;)Z
    //   88: ifne -> 137
    //   91: getstatic com/huawei/secure/android/common/ssl/util/BksUtil.a : Ljava/lang/String;
    //   94: astore_0
    //   95: new java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial <init> : ()V
    //   102: astore #5
    //   104: aload #5
    //   106: ldc 'hms version code is too low : '
    //   108: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload #5
    //   114: ldc 'com.huawei.hwid'
    //   116: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   119: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload_0
    //   124: aload #5
    //   126: invokevirtual toString : ()Ljava/lang/String;
    //   129: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   132: ldc com/huawei/secure/android/common/ssl/util/BksUtil
    //   134: monitorexit
    //   135: aconst_null
    //   136: areturn
    //   137: aload_0
    //   138: ldc 'com.huawei.hwid'
    //   140: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Z
    //   143: ifne -> 168
    //   146: aload_0
    //   147: ldc 'com.huawei.hms'
    //   149: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)Z
    //   152: ifne -> 168
    //   155: getstatic com/huawei/secure/android/common/ssl/util/BksUtil.a : Ljava/lang/String;
    //   158: ldc 'hms sign error'
    //   160: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   163: ldc com/huawei/secure/android/common/ssl/util/BksUtil
    //   165: monitorexit
    //   166: aconst_null
    //   167: areturn
    //   168: getstatic com/huawei/secure/android/common/ssl/util/BksUtil.b : Landroid/net/Uri;
    //   171: ldc 'files/hmsrootcas.bks'
    //   173: invokestatic withAppendedPath : (Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   176: astore #5
    //   178: aload_0
    //   179: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   182: aload #5
    //   184: invokevirtual openInputStream : (Landroid/net/Uri;)Ljava/io/InputStream;
    //   187: astore #5
    //   189: ldc 'last_update_time'
    //   191: lconst_0
    //   192: aload_0
    //   193: invokestatic b : (Ljava/lang/String;JLandroid/content/Context;)J
    //   196: lstore_1
    //   197: invokestatic currentTimeMillis : ()J
    //   200: lstore_3
    //   201: aload_0
    //   202: invokestatic d : (Landroid/content/Context;)Z
    //   205: ifeq -> 241
    //   208: lload_3
    //   209: lload_1
    //   210: lsub
    //   211: ldc2_w 604800000
    //   214: lcmp
    //   215: ifgt -> 241
    //   218: lload_1
    //   219: lconst_0
    //   220: lcmp
    //   221: ifne -> 227
    //   224: goto -> 241
    //   227: getstatic com/huawei/secure/android/common/ssl/util/BksUtil.a : Ljava/lang/String;
    //   230: ldc 'load bks from hms core'
    //   232: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   235: ldc com/huawei/secure/android/common/ssl/util/BksUtil
    //   237: monitorexit
    //   238: aload #5
    //   240: areturn
    //   241: ldc 'last_update_time'
    //   243: lload_3
    //   244: aload_0
    //   245: invokestatic a : (Ljava/lang/String;JLandroid/content/Context;)V
    //   248: aload #5
    //   250: aload_0
    //   251: invokestatic a : (Ljava/io/InputStream;Landroid/content/Context;)V
    //   254: getstatic com/huawei/secure/android/common/ssl/util/BksUtil.a : Ljava/lang/String;
    //   257: ldc 'save last bks and update bks timestamp'
    //   259: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   262: aload #5
    //   264: ifnull -> 272
    //   267: aload #5
    //   269: invokestatic a : (Ljava/io/InputStream;)V
    //   272: aload_0
    //   273: invokestatic b : (Landroid/content/Context;)Ljava/io/InputStream;
    //   276: astore_0
    //   277: ldc com/huawei/secure/android/common/ssl/util/BksUtil
    //   279: monitorexit
    //   280: aload_0
    //   281: areturn
    //   282: getstatic com/huawei/secure/android/common/ssl/util/BksUtil.a : Ljava/lang/String;
    //   285: ldc 'Get bks from HMS_VERSION_CODE exception : No content provider'
    //   287: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   290: ldc com/huawei/secure/android/common/ssl/util/BksUtil
    //   292: monitorexit
    //   293: aconst_null
    //   294: areturn
    //   295: astore_0
    //   296: ldc com/huawei/secure/android/common/ssl/util/BksUtil
    //   298: monitorexit
    //   299: aload_0
    //   300: athrow
    //   301: astore_0
    //   302: goto -> 282
    // Exception table:
    //   from	to	target	type
    //   3	11	295	finally
    //   15	19	295	finally
    //   19	23	295	finally
    //   27	35	295	finally
    //   40	64	295	finally
    //   69	132	295	finally
    //   137	163	295	finally
    //   168	208	301	java/lang/Exception
    //   168	208	295	finally
    //   227	235	301	java/lang/Exception
    //   227	235	295	finally
    //   241	262	301	java/lang/Exception
    //   241	262	295	finally
    //   267	272	301	java/lang/Exception
    //   267	272	295	finally
    //   272	277	301	java/lang/Exception
    //   272	277	295	finally
    //   282	290	295	finally
  }
  
  private static String a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte != null) {
      if (paramArrayOfbyte.length == 0)
        return ""; 
      try {
        return b(MessageDigest.getInstance("SHA-256").digest(paramArrayOfbyte));
      } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NoSuchAlgorithmException");
        stringBuilder.append(noSuchAlgorithmException.getMessage());
        Log.e(str, stringBuilder.toString());
      } 
    } 
    return "";
  }
  
  private static void a(InputStream paramInputStream, Context paramContext) {
    if (paramInputStream != null) {
      FileOutputStream fileOutputStream;
      if (paramContext == null)
        return; 
      String str1 = c(paramContext);
      if (!(new File(str1)).exists())
        a(str1); 
      File file = new File(str1, "hmsrootcas.bks");
      if (file.exists())
        file.delete(); 
      IOException iOException = null;
      String str2 = null;
      str1 = str2;
      try {
        g.b(a, "write output stream ");
        str1 = str2;
        FileOutputStream fileOutputStream1 = new FileOutputStream(file);
      } catch (IOException iOException1) {
      
      } finally {
        f.a(fileOutputStream);
      } 
      InputStream inputStream = paramInputStream;
      g.d(a, " IOException");
      f.a((OutputStream)paramInputStream);
      return;
    } 
  }
  
  private static boolean a(Context paramContext, String paramString) {
    byte[] arrayOfByte = c(paramContext, paramString);
    String[] arrayOfString = c;
    int j = arrayOfString.length;
    for (int i = 0; i < j; i++) {
      if (arrayOfString[i].equalsIgnoreCase(a(arrayOfByte)))
        return true; 
    } 
    return false;
  }
  
  public static InputStream b(Context paramContext) {
    if (d(paramContext)) {
      f(paramContext);
      try {
        return new FileInputStream(e(paramContext));
      } catch (FileNotFoundException fileNotFoundException) {
        g.d(a, "FileNotFoundExceptio: ");
      } 
    } 
    return null;
  }
  
  private static String b(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    int j = paramArrayOfbyte.length;
    for (int i = 0; i < j; i++) {
      String str = Integer.toHexString(paramArrayOfbyte[i] & 0xFF);
      if (str.length() == 1)
        stringBuilder.append('0'); 
      stringBuilder.append(str);
    } 
    return stringBuilder.toString();
  }
  
  private static boolean b(Context paramContext, String paramString) {
    return "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539".equalsIgnoreCase(a(c(paramContext, paramString)));
  }
  
  private static boolean b(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: istore #8
    //   6: iconst_0
    //   7: istore #7
    //   9: iload #8
    //   11: ifeq -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: getstatic com/huawei/secure/android/common/ssl/util/BksUtil.a : Ljava/lang/String;
    //   19: astore #9
    //   21: new java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial <init> : ()V
    //   28: astore #10
    //   30: aload #10
    //   32: ldc_w 'hms version code is : '
    //   35: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload #10
    //   41: aload_0
    //   42: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload #9
    //   48: aload #10
    //   50: invokevirtual toString : ()Ljava/lang/String;
    //   53: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   56: aload_0
    //   57: ldc_w '\.'
    //   60: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   63: astore_0
    //   64: ldc_w '4.0.2.300'
    //   67: ldc_w '\.'
    //   70: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   73: astore #9
    //   75: aload_0
    //   76: arraylength
    //   77: istore #4
    //   79: aload #9
    //   81: arraylength
    //   82: istore #5
    //   84: iload #4
    //   86: iload #5
    //   88: invokestatic max : (II)I
    //   91: istore #6
    //   93: iconst_0
    //   94: istore_1
    //   95: iload_1
    //   96: iload #6
    //   98: if_icmpge -> 211
    //   101: iload_1
    //   102: iload #4
    //   104: if_icmpge -> 218
    //   107: aload_0
    //   108: iload_1
    //   109: aaload
    //   110: invokestatic parseInt : (Ljava/lang/String;)I
    //   113: istore_2
    //   114: goto -> 117
    //   117: iload_1
    //   118: iload #5
    //   120: if_icmpge -> 188
    //   123: aload #9
    //   125: iload_1
    //   126: aaload
    //   127: invokestatic parseInt : (Ljava/lang/String;)I
    //   130: istore_3
    //   131: goto -> 190
    //   134: getstatic com/huawei/secure/android/common/ssl/util/BksUtil.a : Ljava/lang/String;
    //   137: astore_0
    //   138: new java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial <init> : ()V
    //   145: astore #9
    //   147: aload #9
    //   149: ldc_w ' exception : '
    //   152: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload #9
    //   158: aload #10
    //   160: invokevirtual getMessage : ()Ljava/lang/String;
    //   163: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload_0
    //   168: aload #9
    //   170: invokevirtual toString : ()Ljava/lang/String;
    //   173: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   176: iload_1
    //   177: iload #5
    //   179: if_icmplt -> 185
    //   182: iconst_1
    //   183: istore #7
    //   185: iload #7
    //   187: ireturn
    //   188: iconst_0
    //   189: istore_3
    //   190: iload_2
    //   191: iload_3
    //   192: if_icmpge -> 197
    //   195: iconst_0
    //   196: ireturn
    //   197: iload_2
    //   198: iload_3
    //   199: if_icmple -> 204
    //   202: iconst_1
    //   203: ireturn
    //   204: iload_1
    //   205: iconst_1
    //   206: iadd
    //   207: istore_1
    //   208: goto -> 95
    //   211: iconst_1
    //   212: ireturn
    //   213: astore #10
    //   215: goto -> 134
    //   218: iconst_0
    //   219: istore_2
    //   220: goto -> 117
    // Exception table:
    //   from	to	target	type
    //   107	114	213	java/lang/Exception
    //   123	131	213	java/lang/Exception
  }
  
  private static String c(Context paramContext) {
    if (Build.VERSION.SDK_INT >= 24) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramContext.createDeviceProtectedStorageContext().getFilesDir());
      stringBuilder1.append(File.separator);
      stringBuilder1.append("aegis");
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramContext.getApplicationContext().getFilesDir());
    stringBuilder.append(File.separator);
    stringBuilder.append("aegis");
    return stringBuilder.toString();
  }
  
  private static byte[] c(Context paramContext, String paramString) {
    if (paramContext == null || TextUtils.isEmpty(paramString)) {
      Log.e(a, "packageName is null or context is null");
      return new byte[0];
    } 
    try {
      PackageManager packageManager = paramContext.getPackageManager();
      if (packageManager != null) {
        PackageInfo packageInfo = packageManager.getPackageInfo(paramString, 64);
        if (packageInfo != null)
          return packageInfo.signatures[0].toByteArray(); 
      } 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      paramString = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("PackageManager.NameNotFoundException : ");
      stringBuilder.append(nameNotFoundException.getMessage());
      Log.e(paramString, stringBuilder.toString());
    } catch (Exception exception) {
      paramString = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("get pm exception : ");
      stringBuilder.append(exception.getMessage());
      Log.e(paramString, stringBuilder.toString());
    } 
    return new byte[0];
  }
  
  private static boolean d(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(c(paramContext));
    stringBuilder.append(File.separator);
    stringBuilder.append("hmsrootcas.bks");
    return (new File(stringBuilder.toString())).exists();
  }
  
  private static String e(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(c(paramContext));
    stringBuilder.append(File.separator);
    stringBuilder.append("hmsrootcas.bks");
    return stringBuilder.toString();
  }
  
  private static void f(Context paramContext) {
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("load bks from aegis folder , time is : ");
    stringBuilder.append((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(Long.valueOf(i.b("last_update_time", 0L, paramContext))));
    g.b(str, stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\common\ss\\util\BksUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */