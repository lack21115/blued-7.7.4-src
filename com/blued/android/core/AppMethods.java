package com.blued.android.core;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.blued.android.core.utils.ByteArrayPool;
import com.blued.android.core.utils.Log;
import com.blued.android.core.utils.toast.ToastUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

public class AppMethods {
  private static Toast a;
  
  public static int a(float paramFloat) {
    return (int)((paramFloat * AppInfo.j) + 0.5D);
  }
  
  public static int a(int paramInt) {
    return (int)((paramInt * AppInfo.j) + 0.5D);
  }
  
  public static String a() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Build.VERSION.SDK);
    stringBuilder.append("_");
    stringBuilder.append(Build.VERSION.RELEASE);
    stringBuilder.append("_");
    stringBuilder.append(Build.MODEL);
    return stringBuilder.toString();
  }
  
  public static String a(String paramString) {
    File file = AppInfo.d().getExternalCacheDir();
    if (file != null) {
      file = new File(file, paramString);
      if (!file.exists())
        file.mkdirs(); 
      if (file.canRead() && file.canWrite())
        return file.getAbsolutePath(); 
    } 
    file = AppInfo.d().getCacheDir();
    if (file != null) {
      File file1 = new File(file, paramString);
      if (!file1.exists())
        file1.mkdirs(); 
      if (file1.canRead() && file1.canWrite())
        return file1.getAbsolutePath(); 
    } 
    return null;
  }
  
  public static void a(Context paramContext, Throwable paramThrowable, String paramString, CrashInfoInterface paramCrashInfoInterface) {
    // Byte code:
    //   0: new java/io/StringWriter
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #9
    //   9: new java/io/PrintWriter
    //   12: dup
    //   13: aload #9
    //   15: invokespecial <init> : (Ljava/io/Writer;)V
    //   18: astore #8
    //   20: aload_1
    //   21: aload #8
    //   23: invokevirtual printStackTrace : (Ljava/io/PrintWriter;)V
    //   26: aload_1
    //   27: invokevirtual getCause : ()Ljava/lang/Throwable;
    //   30: astore_1
    //   31: aload_1
    //   32: ifnull -> 49
    //   35: aload_1
    //   36: aload #8
    //   38: invokevirtual printStackTrace : (Ljava/io/PrintWriter;)V
    //   41: aload_1
    //   42: invokevirtual getCause : ()Ljava/lang/Throwable;
    //   45: astore_1
    //   46: goto -> 31
    //   49: aload_0
    //   50: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   53: aload_0
    //   54: invokevirtual getPackageName : ()Ljava/lang/String;
    //   57: iconst_1
    //   58: invokevirtual getPackageInfo : (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   61: astore_0
    //   62: aload_0
    //   63: ifnull -> 147
    //   66: new java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial <init> : ()V
    //   73: astore_1
    //   74: aload_1
    //   75: ldc '\\r\\n'
    //   77: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload_1
    //   82: aload_0
    //   83: getfield versionName : Ljava/lang/String;
    //   86: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload #8
    //   92: aload_1
    //   93: invokevirtual toString : ()Ljava/lang/String;
    //   96: invokevirtual append : (Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
    //   99: pop
    //   100: new java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial <init> : ()V
    //   107: astore_1
    //   108: aload_1
    //   109: ldc '\\r\\nversionCode='
    //   111: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload_1
    //   116: aload_0
    //   117: getfield versionCode : I
    //   120: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload #8
    //   126: aload_1
    //   127: invokevirtual toString : ()Ljava/lang/String;
    //   130: invokevirtual append : (Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
    //   133: pop
    //   134: goto -> 147
    //   137: astore_0
    //   138: ldc 'logCrashOnFile'
    //   140: ldc 'Error while collect package info'
    //   142: aload_0
    //   143: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   146: pop
    //   147: aload_3
    //   148: ifnull -> 196
    //   151: aload_3
    //   152: invokeinterface b : ()Ljava/lang/String;
    //   157: astore_0
    //   158: aload_0
    //   159: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   162: ifne -> 196
    //   165: new java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial <init> : ()V
    //   172: astore_1
    //   173: aload_1
    //   174: ldc '\\r\\n'
    //   176: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload_1
    //   181: aload_0
    //   182: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload #8
    //   188: aload_1
    //   189: invokevirtual toString : ()Ljava/lang/String;
    //   192: invokevirtual append : (Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
    //   195: pop
    //   196: invokestatic currentTimeMillis : ()J
    //   199: lstore #6
    //   201: new java/text/SimpleDateFormat
    //   204: dup
    //   205: ldc 'yyyy_MM_dd_HH_mm_ss'
    //   207: invokespecial <init> : (Ljava/lang/String;)V
    //   210: lload #6
    //   212: invokestatic valueOf : (J)Ljava/lang/Long;
    //   215: invokevirtual format : (Ljava/lang/Object;)Ljava/lang/String;
    //   218: astore_0
    //   219: new java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial <init> : ()V
    //   226: astore_1
    //   227: aload_1
    //   228: ldc '\\r\\ncrashTime='
    //   230: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload_1
    //   235: aload_0
    //   236: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload #8
    //   242: aload_1
    //   243: invokevirtual toString : ()Ljava/lang/String;
    //   246: invokevirtual append : (Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
    //   249: pop
    //   250: aload #8
    //   252: ldc '\\r\\nbuildTime=<unknown>'
    //   254: invokevirtual append : (Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
    //   257: pop
    //   258: aload #8
    //   260: ldc '\\r\\nfromid=<unknown>'
    //   262: invokevirtual append : (Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
    //   265: pop
    //   266: ldc android/os/Build
    //   268: invokevirtual getDeclaredFields : ()[Ljava/lang/reflect/Field;
    //   271: astore_0
    //   272: aload_0
    //   273: arraylength
    //   274: istore #5
    //   276: iconst_0
    //   277: istore #4
    //   279: iload #4
    //   281: iload #5
    //   283: if_icmpge -> 375
    //   286: aload_0
    //   287: iload #4
    //   289: aaload
    //   290: astore_1
    //   291: aload_1
    //   292: iconst_1
    //   293: invokevirtual setAccessible : (Z)V
    //   296: new java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial <init> : ()V
    //   303: astore #10
    //   305: aload #10
    //   307: ldc '\\r\\n'
    //   309: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload #10
    //   315: aload_1
    //   316: invokevirtual getName : ()Ljava/lang/String;
    //   319: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload #10
    //   325: ldc ': '
    //   327: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload #10
    //   333: aload_1
    //   334: aconst_null
    //   335: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   338: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: aload #8
    //   344: aload #10
    //   346: invokevirtual toString : ()Ljava/lang/String;
    //   349: invokevirtual append : (Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
    //   352: pop
    //   353: goto -> 366
    //   356: astore_1
    //   357: ldc 'logCrashOnFile'
    //   359: ldc 'Error while collect crash info'
    //   361: aload_1
    //   362: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   365: pop
    //   366: iload #4
    //   368: iconst_1
    //   369: iadd
    //   370: istore #4
    //   372: goto -> 279
    //   375: aload #9
    //   377: invokevirtual toString : ()Ljava/lang/String;
    //   380: astore #9
    //   382: aload #8
    //   384: invokevirtual close : ()V
    //   387: ldc ''
    //   389: astore_0
    //   390: aload_3
    //   391: ifnull -> 401
    //   394: aload_3
    //   395: invokeinterface a : ()Ljava/lang/String;
    //   400: astore_0
    //   401: aload_0
    //   402: astore_1
    //   403: aload_0
    //   404: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   407: ifeq -> 414
    //   410: invokestatic c : ()Ljava/lang/String;
    //   413: astore_1
    //   414: aload #9
    //   416: aload_2
    //   417: aload_1
    //   418: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   421: return
    //   422: astore_0
    //   423: ldc 'logCrashOnFile'
    //   425: ldc 'an error occured while writing report file...'
    //   427: aload_0
    //   428: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   431: pop
    //   432: return
    // Exception table:
    //   from	to	target	type
    //   49	62	137	android/content/pm/PackageManager$NameNotFoundException
    //   66	134	137	android/content/pm/PackageManager$NameNotFoundException
    //   291	353	356	java/lang/Exception
    //   394	401	422	java/lang/Exception
    //   403	414	422	java/lang/Exception
    //   414	421	422	java/lang/Exception
  }
  
  public static void a(View paramView) {
    ((InputMethodManager)paramView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
  }
  
  public static void a(OutputStream paramOutputStream) {
    if (paramOutputStream != null)
      try {
        paramOutputStream.close();
        return;
      } catch (Exception exception) {
        return;
      }  
  }
  
  public static void a(CharSequence paramCharSequence) {
    ToastUtils.a(paramCharSequence, 0);
  }
  
  public static void a(CharSequence paramCharSequence, boolean paramBoolean) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void a(String paramString1, String paramString2, String paramString3) {
    Log.e("logOnFile", paramString1);
    try {
      File file = new File(paramString2);
      if (!file.exists() && !file.mkdirs())
        return; 
      file = new File(file, paramString3);
      boolean bool = file.exists();
      if (!bool) {
        try {
          file.createNewFile();
        } catch (IOException iOException) {
          iOException.printStackTrace();
        } 
      } else {
        long l = file.length();
        if (l > 102400L)
          try {
            if (file.delete())
              file.createNewFile(); 
          } catch (IOException iOException) {
            iOException.printStackTrace();
          }  
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("\r\n");
      stringBuilder.append(paramString1);
      paramString1 = stringBuilder.toString();
      FileOutputStream fileOutputStream = new FileOutputStream(file, true);
      try {
        fileOutputStream.write(paramString1.getBytes());
        fileOutputStream.close();
        return;
      } catch (Exception exception) {
      
      } finally {}
    } catch (Exception exception) {
    
    } finally {}
    paramString1.printStackTrace();
  }
  
  public static boolean a(Context paramContext) {
    NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (networkInfo != null && networkInfo.getType() == 1);
  }
  
  public static boolean a(Intent paramIntent) {
    List list = AppInfo.d().getPackageManager().queryIntentActivities(paramIntent, 65536);
    return (list != null && list.size() > 0);
  }
  
  public static boolean a(String paramString1, String paramString2) {
    if (TextUtils.isEmpty(paramString1))
      return false; 
    File file1 = new File(paramString1);
    if (!file1.exists())
      return false; 
    File file2 = new File(paramString2);
    file2.delete();
    return !!file1.renameTo(file2);
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean) {
    File file = new File(paramString2);
    if (file.exists())
      if (paramBoolean) {
        if (!file.delete())
          return false; 
      } else {
        return true;
      }  
    file = file.getParentFile();
    if (file != null && !file.exists())
      file.mkdirs(); 
    try {
      StringBuilder stringBuilder;
      file = new File(paramString1);
      paramBoolean = file.exists();
      if (!paramBoolean) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("saveImageCacheTo failed, fromFile don't exist, fromFilePath:");
        stringBuilder.append(paramString1);
        Log.e("IMAGE_LOADER", stringBuilder.toString());
        return false;
      } 
      if (!file.canRead()) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("saveImageCacheTo failed, fromFile don't read, fromFilePath:");
        stringBuilder.append(paramString1);
        Log.e("IMAGE_LOADER", stringBuilder.toString());
        return false;
      } 
      FileInputStream fileInputStream = new FileInputStream(paramString1);
      FileOutputStream fileOutputStream = new FileOutputStream((String)stringBuilder);
      byte[] arrayOfByte = ByteArrayPool.a.a(1024);
      while (true) {
        int i = fileInputStream.read(arrayOfByte);
        if (i > 0) {
          fileOutputStream.write(arrayOfByte, 0, i);
          continue;
        } 
        fileInputStream.close();
        fileOutputStream.close();
        ByteArrayPool.a.a(arrayOfByte);
        return true;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      return false;
    } 
  }
  
  public static byte[] a(InputStream paramInputStream) throws IOException {
    return a(paramInputStream, 0);
  }
  
  public static byte[] a(InputStream paramInputStream, int paramInt) throws IOException {
    // Byte code:
    //   0: new com/blued/android/core/utils/PoolingByteArrayOutputStream
    //   3: dup
    //   4: getstatic com/blued/android/core/utils/ByteArrayPool.a : Lcom/blued/android/core/utils/ByteArrayPool;
    //   7: iload_1
    //   8: invokespecial <init> : (Lcom/blued/android/core/utils/ByteArrayPool;I)V
    //   11: astore #4
    //   13: aconst_null
    //   14: astore_2
    //   15: aload_0
    //   16: ifnonnull -> 49
    //   19: aload_0
    //   20: ifnull -> 35
    //   23: aload_0
    //   24: invokevirtual close : ()V
    //   27: goto -> 35
    //   30: astore_0
    //   31: aload_0
    //   32: invokevirtual printStackTrace : ()V
    //   35: getstatic com/blued/android/core/utils/ByteArrayPool.a : Lcom/blued/android/core/utils/ByteArrayPool;
    //   38: aconst_null
    //   39: invokevirtual a : ([B)V
    //   42: aload #4
    //   44: invokevirtual close : ()V
    //   47: aconst_null
    //   48: areturn
    //   49: getstatic com/blued/android/core/utils/ByteArrayPool.a : Lcom/blued/android/core/utils/ByteArrayPool;
    //   52: sipush #1024
    //   55: invokevirtual a : (I)[B
    //   58: astore_3
    //   59: aload_3
    //   60: astore_2
    //   61: aload_0
    //   62: aload_3
    //   63: invokevirtual read : ([B)I
    //   66: istore_1
    //   67: iload_1
    //   68: iconst_m1
    //   69: if_icmpeq -> 85
    //   72: aload_3
    //   73: astore_2
    //   74: aload #4
    //   76: aload_3
    //   77: iconst_0
    //   78: iload_1
    //   79: invokevirtual write : ([BII)V
    //   82: goto -> 59
    //   85: aload_3
    //   86: astore_2
    //   87: aload #4
    //   89: invokevirtual toByteArray : ()[B
    //   92: astore #5
    //   94: aload_0
    //   95: ifnull -> 110
    //   98: aload_0
    //   99: invokevirtual close : ()V
    //   102: goto -> 110
    //   105: astore_0
    //   106: aload_0
    //   107: invokevirtual printStackTrace : ()V
    //   110: getstatic com/blued/android/core/utils/ByteArrayPool.a : Lcom/blued/android/core/utils/ByteArrayPool;
    //   113: aload_3
    //   114: invokevirtual a : ([B)V
    //   117: aload #4
    //   119: invokevirtual close : ()V
    //   122: aload #5
    //   124: areturn
    //   125: astore_3
    //   126: aload_0
    //   127: ifnull -> 142
    //   130: aload_0
    //   131: invokevirtual close : ()V
    //   134: goto -> 142
    //   137: astore_0
    //   138: aload_0
    //   139: invokevirtual printStackTrace : ()V
    //   142: getstatic com/blued/android/core/utils/ByteArrayPool.a : Lcom/blued/android/core/utils/ByteArrayPool;
    //   145: aload_2
    //   146: invokevirtual a : ([B)V
    //   149: aload #4
    //   151: invokevirtual close : ()V
    //   154: aload_3
    //   155: athrow
    // Exception table:
    //   from	to	target	type
    //   23	27	30	java/io/IOException
    //   49	59	125	finally
    //   61	67	125	finally
    //   74	82	125	finally
    //   87	94	125	finally
    //   98	102	105	java/io/IOException
    //   130	134	137	java/io/IOException
  }
  
  public static int b(int paramInt) {
    return (int)((paramInt * AppInfo.j) + 0.5D);
  }
  
  public static String b(String paramString) {
    File file = AppInfo.d().getExternalFilesDir(null);
    if (file != null) {
      file = new File(file, paramString);
      if (!file.exists())
        file.mkdirs(); 
      if (file.canRead() && file.canWrite())
        return file.getAbsolutePath(); 
    } 
    file = AppInfo.d().getFilesDir();
    if (file != null) {
      File file1 = new File(file, paramString);
      if (!file1.exists())
        file1.mkdirs(); 
      if (file1.canRead() && file1.canWrite())
        return file1.getAbsolutePath(); 
    } 
    return null;
  }
  
  public static String b(String paramString1, String paramString2) {
    String str3 = paramString1;
    if (paramString1 == null)
      str3 = ""; 
    int i = str3.indexOf(" (");
    if (i > 0) {
      String str = str3.substring(0, i);
      paramString1 = str;
      if (str.contains("Mozilla"))
        paramString1 = ""; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Mozilla/5.0 ");
      stringBuilder.append(str3.substring(i + 1));
      str3 = stringBuilder.toString();
      str4 = paramString1;
      paramString1 = str3;
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Mozilla/5.0 ");
      stringBuilder.append(str3);
      str1 = stringBuilder.toString();
      str4 = "";
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("");
    stringBuilder1.append(AppInfo.l);
    stringBuilder1.append("_");
    stringBuilder1.append(AppInfo.m);
    stringBuilder1.append("_");
    stringBuilder1.append(AppInfo.g);
    stringBuilder1.append("_");
    stringBuilder1.append(AppInfo.h);
    String str2 = (new StringBuffer(stringBuilder1.toString())).reverse().toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("Android/");
    stringBuilder2.append(str2);
    str2 = stringBuilder2.toString();
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str1);
    stringBuilder2.append(" ");
    stringBuilder2.append(str2);
    str2 = stringBuilder2.toString();
    String str5 = TimeZone.getDefault().getID();
    String str1 = str2;
    if (!TextUtils.isEmpty(str5)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str2);
      stringBuilder.append(" (");
      stringBuilder.append(str5);
      stringBuilder.append(")");
      str1 = stringBuilder.toString();
    } 
    str2 = str1;
    if (!TextUtils.isEmpty(str4)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str1);
      stringBuilder.append(" ");
      stringBuilder.append(str4);
      str2 = stringBuilder.toString();
    } 
    String str4 = AppInfo.e();
    str1 = str2;
    if (!TextUtils.isEmpty(str4)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str2);
      stringBuilder.append(" app/");
      stringBuilder.append(str4);
      str1 = stringBuilder.toString();
    } 
    str2 = str1;
    if (!TextUtils.isEmpty(paramString2)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str1);
      stringBuilder.append(" ");
      stringBuilder.append(paramString2);
      str2 = stringBuilder.toString();
    } 
    return str2;
  }
  
  public static void b(InputStream paramInputStream) {
    if (paramInputStream != null)
      try {
        paramInputStream.close();
        return;
      } catch (Exception exception) {
        return;
      }  
  }
  
  public static boolean b() {
    return (Looper.myLooper() == Looper.getMainLooper());
  }
  
  public static String c() {
    long l = System.currentTimeMillis();
    String str = (new SimpleDateFormat("yyyyMMdd-HHmmss")).format(Long.valueOf(l));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("crash-");
    stringBuilder.append(str);
    stringBuilder.append(".txt");
    return stringBuilder.toString();
  }
  
  public static boolean c(int paramInt) {
    try {
      int i = Integer.parseInt(Build.VERSION.SDK);
      if (i >= paramInt)
        return true; 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return false;
  }
  
  public static boolean c(String paramString) {
    boolean bool = TextUtils.isEmpty(paramString);
    byte b = 0;
    if (bool)
      return false; 
    char c = paramString.charAt(0);
    int i = 1;
    while (true) {
      if (i < paramString.length()) {
        if (c != paramString.charAt(i)) {
          i = b;
          break;
        } 
        i++;
        continue;
      } 
      i = 1;
      break;
    } 
    return i ^ 0x1;
  }
  
  public static String d() {
    File file;
    if (Environment.getExternalStorageState().equals("mounted")) {
      file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
    } else {
      file = null;
    } 
    if (file != null) {
      if (!file.exists())
        file.mkdirs(); 
      if (file.canRead() && file.canWrite())
        return file.getAbsolutePath(); 
    } 
    return null;
  }
  
  public static void d(int paramInt) {
    ToastUtils.a(paramInt, 0);
  }
  
  public static boolean d(String paramString) {
    boolean bool = TextUtils.isEmpty(paramString);
    byte b = 0;
    if (bool)
      return false; 
    paramString = paramString.replace(":", "");
    char c = paramString.charAt(0);
    int i = 1;
    while (true) {
      if (i < paramString.length()) {
        if (c != paramString.charAt(i)) {
          i = b;
          break;
        } 
        i++;
        continue;
      } 
      i = 1;
      break;
    } 
    return i ^ 0x1;
  }
  
  public static String e() {
    WifiManager wifiManager = (WifiManager)AppInfo.d().getApplicationContext().getSystemService("wifi");
    if (wifiManager != null)
      try {
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        if (wifiInfo != null)
          return wifiInfo.getMacAddress(); 
      } catch (SecurityException securityException) {
        securityException.printStackTrace();
      }  
    return "00:00:00:00:00:00";
  }
  
  public static boolean f() {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public static String g() {
    String str = System.getProperty("http.agent");
    if (str == null)
      return ""; 
    StringBuffer stringBuffer = new StringBuffer();
    int j = str.length();
    for (int i = 0; i < j; i++) {
      char c = str.charAt(i);
      if (c <= '\037' || c >= '') {
        stringBuffer.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c) }));
      } else {
        stringBuffer.append(c);
      } 
    } 
    return stringBuffer.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\AppMethods.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */