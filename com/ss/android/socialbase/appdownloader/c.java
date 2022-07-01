package com.ss.android.socialbase.appdownloader;

import android.app.NotificationChannel;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.ss.android.socialbase.appdownloader.c.a;
import com.ss.android.socialbase.appdownloader.c.c;
import com.ss.android.socialbase.appdownloader.c.d;
import com.ss.android.socialbase.downloader.b.f;
import com.ss.android.socialbase.downloader.d.q;
import com.ss.android.socialbase.downloader.d.z;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.f.a;
import com.ss.android.socialbase.downloader.h.b;
import com.ss.android.socialbase.downloader.k.a;
import com.ss.android.socialbase.downloader.m.b;
import com.ss.android.socialbase.downloader.m.i;
import com.ss.android.socialbase.downloader.m.k;
import java.io.File;
import java.text.DecimalFormat;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
  private static NotificationChannel a;
  
  public static int a() {
    return d.h().e() ? 16384 : 0;
  }
  
  public static int a(int paramInt) {
    return (paramInt == 0) ? 0 : ((paramInt == -2) ? 2 : ((paramInt == 1) ? 4 : (f.b(paramInt) ? 1 : (f.a(paramInt) ? 3 : 0))));
  }
  
  public static int a(Context paramContext, int paramInt, boolean paramBoolean) {
    com.ss.android.socialbase.downloader.g.c c1 = f.a(paramContext).h(paramInt);
    if (c1 == null || !"application/vnd.android.package-archive".equals(c1.ah()) || TextUtils.isEmpty(c1.k()) || TextUtils.isEmpty(c1.h()) || !(new File(c1.k(), c1.h())).exists())
      return 2; 
    a a = a.a(paramInt);
    boolean bool = false;
    if (a.a("install_queue_enable", 0) == 1)
      bool = true; 
    return bool ? i.a().a(paramContext, paramInt, paramBoolean) : b(paramContext, paramInt, paramBoolean);
  }
  
  private static Intent a(Context paramContext, com.ss.android.socialbase.downloader.g.c paramc, File paramFile, boolean paramBoolean, int[] paramArrayOfint) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:244)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static Uri a(int paramInt, q paramq, Context paramContext, String paramString, File paramFile) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 20
    //   4: aload_1
    //   5: aload_3
    //   6: aload #4
    //   8: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   11: invokeinterface a : (Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;
    //   16: astore_1
    //   17: goto -> 50
    //   20: invokestatic h : ()Lcom/ss/android/socialbase/appdownloader/d;
    //   23: invokevirtual d : ()Lcom/ss/android/socialbase/appdownloader/c/f;
    //   26: astore_1
    //   27: aload_1
    //   28: ifnull -> 48
    //   31: aload_1
    //   32: iload_0
    //   33: aload_3
    //   34: aload #4
    //   36: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   39: invokeinterface a : (ILjava/lang/String;Ljava/lang/String;)Landroid/net/Uri;
    //   44: astore_1
    //   45: goto -> 50
    //   48: aconst_null
    //   49: astore_1
    //   50: aload_1
    //   51: ifnonnull -> 90
    //   54: getstatic android/os/Build$VERSION.SDK_INT : I
    //   57: bipush #24
    //   59: if_icmplt -> 77
    //   62: aload_3
    //   63: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   66: ifne -> 77
    //   69: aload_2
    //   70: aload_3
    //   71: aload #4
    //   73: invokestatic getUriForFile : (Landroid/content/Context;Ljava/lang/String;Ljava/io/File;)Landroid/net/Uri;
    //   76: areturn
    //   77: aload #4
    //   79: invokestatic fromFile : (Ljava/io/File;)Landroid/net/Uri;
    //   82: astore_2
    //   83: aload_2
    //   84: areturn
    //   85: astore_2
    //   86: aload_2
    //   87: invokevirtual printStackTrace : ()V
    //   90: aload_1
    //   91: areturn
    //   92: astore_1
    //   93: goto -> 48
    // Exception table:
    //   from	to	target	type
    //   4	17	92	finally
    //   31	45	92	finally
    //   54	77	85	finally
    //   77	83	85	finally
  }
  
  public static String a(long paramLong) {
    StringBuilder stringBuilder;
    long[] arrayOfLong = new long[5];
    arrayOfLong[0] = 1099511627776L;
    arrayOfLong[1] = 1073741824L;
    arrayOfLong[2] = 1048576L;
    arrayOfLong[3] = 1024L;
    arrayOfLong[4] = 1L;
    String[] arrayOfString = new String[5];
    arrayOfString[0] = "TB";
    arrayOfString[1] = "GB";
    arrayOfString[2] = "MB";
    arrayOfString[3] = "KB";
    arrayOfString[4] = "B";
    if (paramLong < 1L) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("0 ");
      stringBuilder.append(arrayOfString[arrayOfString.length - 1]);
      return stringBuilder.toString();
    } 
    for (int i = 0; i < stringBuilder.length; i++) {
      StringBuilder stringBuilder1 = stringBuilder[i];
      if (paramLong >= stringBuilder1)
        return a(paramLong, stringBuilder1, arrayOfString[i]); 
    } 
    return null;
  }
  
  private static String a(long paramLong1, long paramLong2, String paramString) {
    double d2 = paramLong1;
    double d1 = d2;
    if (paramLong2 > 1L)
      d1 = d2 / paramLong2; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append((new DecimalFormat("#.##")).format(d1));
    stringBuilder.append(" ");
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
  
  public static String a(Context paramContext) {
    return a(paramContext, (String)null, (a)null);
  }
  
  public static String a(Context paramContext, String paramString, a parama) {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull -> 7
    //   4: ldc ''
    //   6: areturn
    //   7: invokestatic h : ()Lcom/ss/android/socialbase/appdownloader/d;
    //   10: invokevirtual f : ()Ljava/io/File;
    //   13: astore #4
    //   15: aload #4
    //   17: ifnull -> 39
    //   20: aload #4
    //   22: invokevirtual exists : ()Z
    //   25: ifeq -> 39
    //   28: aload #4
    //   30: astore_3
    //   31: aload #4
    //   33: invokevirtual isDirectory : ()Z
    //   36: ifne -> 44
    //   39: aload_0
    //   40: invokestatic d : (Landroid/content/Context;)Ljava/io/File;
    //   43: astore_3
    //   44: aload_3
    //   45: ifnull -> 297
    //   48: aload_3
    //   49: invokevirtual exists : ()Z
    //   52: ifeq -> 101
    //   55: aload_3
    //   56: invokevirtual isDirectory : ()Z
    //   59: ifeq -> 65
    //   62: goto -> 108
    //   65: new java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial <init> : ()V
    //   72: astore_0
    //   73: aload_0
    //   74: aload_3
    //   75: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   78: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_0
    //   83: ldc ' already exists and is not a directory'
    //   85: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: new java/lang/IllegalStateException
    //   92: dup
    //   93: aload_0
    //   94: invokevirtual toString : ()Ljava/lang/String;
    //   97: invokespecial <init> : (Ljava/lang/String;)V
    //   100: athrow
    //   101: aload_3
    //   102: invokevirtual mkdirs : ()Z
    //   105: ifeq -> 261
    //   108: aload_3
    //   109: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   112: astore_3
    //   113: aload_3
    //   114: astore_0
    //   115: aload_2
    //   116: ifnull -> 259
    //   119: aload_2
    //   120: ldc 'anti_hijack_dir'
    //   122: invokevirtual d : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   125: astore_2
    //   126: aload_3
    //   127: astore_0
    //   128: aload_2
    //   129: ifnull -> 259
    //   132: aload_2
    //   133: ldc 'dir_name'
    //   135: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   138: astore_2
    //   139: aload_3
    //   140: astore_0
    //   141: aload_2
    //   142: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   145: ifne -> 259
    //   148: aload_2
    //   149: ldc '%s'
    //   151: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   154: ifne -> 185
    //   157: new java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial <init> : ()V
    //   164: astore_0
    //   165: aload_0
    //   166: aload_2
    //   167: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload_0
    //   172: aload_1
    //   173: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_0
    //   178: invokevirtual toString : ()Ljava/lang/String;
    //   181: astore_0
    //   182: goto -> 201
    //   185: aload_2
    //   186: iconst_1
    //   187: anewarray java/lang/Object
    //   190: dup
    //   191: iconst_0
    //   192: aload_1
    //   193: aastore
    //   194: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   197: astore_0
    //   198: goto -> 201
    //   201: aload_0
    //   202: astore_1
    //   203: aload_0
    //   204: invokevirtual length : ()I
    //   207: sipush #255
    //   210: if_icmple -> 226
    //   213: aload_0
    //   214: aload_0
    //   215: invokevirtual length : ()I
    //   218: sipush #255
    //   221: isub
    //   222: invokevirtual substring : (I)Ljava/lang/String;
    //   225: astore_1
    //   226: new java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial <init> : ()V
    //   233: astore_0
    //   234: aload_0
    //   235: aload_3
    //   236: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload_0
    //   241: getstatic java/io/File.separator : Ljava/lang/String;
    //   244: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload_0
    //   249: aload_1
    //   250: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload_0
    //   255: invokevirtual toString : ()Ljava/lang/String;
    //   258: astore_0
    //   259: aload_0
    //   260: areturn
    //   261: new java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial <init> : ()V
    //   268: astore_0
    //   269: aload_0
    //   270: ldc 'Unable to create directory: '
    //   272: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload_0
    //   277: aload_3
    //   278: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   281: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: new java/lang/IllegalStateException
    //   288: dup
    //   289: aload_0
    //   290: invokevirtual toString : ()Ljava/lang/String;
    //   293: invokespecial <init> : (Ljava/lang/String;)V
    //   296: athrow
    //   297: new java/lang/IllegalStateException
    //   300: dup
    //   301: ldc 'Failed to get storage directory'
    //   303: invokespecial <init> : (Ljava/lang/String;)V
    //   306: athrow
    //   307: astore_0
    //   308: aload_2
    //   309: astore_0
    //   310: goto -> 201
    // Exception table:
    //   from	to	target	type
    //   185	198	307	finally
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifeq -> 10
    //   7: ldc ''
    //   9: areturn
    //   10: aload_0
    //   11: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   14: astore #4
    //   16: iload_3
    //   17: ifeq -> 49
    //   20: aload_1
    //   21: astore_0
    //   22: aload_1
    //   23: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   26: ifeq -> 81
    //   29: aload #4
    //   31: invokevirtual getLastPathSegment : ()Ljava/lang/String;
    //   34: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   37: ifne -> 74
    //   40: aload #4
    //   42: invokevirtual getLastPathSegment : ()Ljava/lang/String;
    //   45: astore_0
    //   46: goto -> 81
    //   49: aload #4
    //   51: invokevirtual getLastPathSegment : ()Ljava/lang/String;
    //   54: astore_0
    //   55: aload_0
    //   56: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   59: ifeq -> 81
    //   62: aload_1
    //   63: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   66: ifne -> 74
    //   69: aload_1
    //   70: astore_0
    //   71: goto -> 81
    //   74: ldc_w 'default.apk'
    //   77: astore_0
    //   78: goto -> 81
    //   81: aload_0
    //   82: astore_1
    //   83: aload_2
    //   84: invokestatic d : (Ljava/lang/String;)Z
    //   87: ifeq -> 129
    //   90: aload_0
    //   91: astore_1
    //   92: aload_0
    //   93: ldc_w '.apk'
    //   96: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   99: ifne -> 129
    //   102: new java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial <init> : ()V
    //   109: astore_1
    //   110: aload_1
    //   111: aload_0
    //   112: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload_1
    //   117: ldc_w '.apk'
    //   120: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload_1
    //   125: invokevirtual toString : ()Ljava/lang/String;
    //   128: astore_1
    //   129: aload_1
    //   130: areturn
  }
  
  public static boolean a(Context paramContext, int paramInt, File paramFile) {
    a.b("AppDownloadUtils", "start try silent install on miui");
    if (a.a(paramInt).a("back_miui_silent_install", 1) == 1) {
      a.b("AppDownloadUtils", "back_miui_silent_install = 1");
      return false;
    } 
    if (!i.j() && !i.k()) {
      a.b("AppDownloadUtils", "neither miui10 nor miui11");
      return false;
    } 
    if (k.a(paramContext, "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService")) {
      a.b("AppDownloadUtils", "EntInstallService exists");
      Intent intent = new Intent();
      intent.setComponent(new ComponentName("com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"));
      Bundle bundle = new Bundle();
      bundle.putInt("userId", 0);
      bundle.putInt("flag", 256);
      bundle.putString("apkPath", paramFile.getPath());
      bundle.putString("installerPkg", "com.miui.securitycore");
      intent.putExtras(bundle);
      try {
        paramContext.startService(intent);
        a.b("AppDownloadUtils", "start EntInstallService");
        return true;
      } catch (Exception exception) {
        a.b("AppDownloadUtils", "start EntInstallService error");
        exception.printStackTrace();
        return false;
      } 
    } 
    a.b("AppDownloadUtils", "EntInstallService does not exist");
    return false;
  }
  
  public static boolean a(Context paramContext, PackageInfo paramPackageInfo) {
    if (paramPackageInfo == null)
      return false; 
    String str = paramPackageInfo.packageName;
    int i = paramPackageInfo.versionCode;
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(str, a());
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      nameNotFoundException = null;
    } 
    return (nameNotFoundException == null) ? false : ((i <= ((PackageInfo)nameNotFoundException).versionCode));
  }
  
  public static boolean a(Context paramContext, com.ss.android.socialbase.downloader.g.c paramc, PackageInfo paramPackageInfo) {
    if (paramPackageInfo != null && !paramPackageInfo.packageName.equals(paramc.z())) {
      d d = d.h().b();
      if (d != null) {
        d.a(paramc.g(), 8, paramc.z(), paramPackageInfo.packageName, "");
        if (d.a())
          return true; 
      } 
      z z = f.a(paramContext).i(paramc.g());
      if (z != null) {
        z.a(8, paramc, paramPackageInfo.packageName, "");
        c c1 = d.h().a();
        if (c1 instanceof a && ((a)c1).c())
          return true; 
      } 
    } 
    return false;
  }
  
  public static boolean a(Context paramContext, com.ss.android.socialbase.downloader.g.c paramc, String paramString) {
    if (paramContext == null)
      return false; 
    try {
      PackageInfo packageInfo;
      File file = new File(paramc.k(), paramc.h());
      boolean bool = file.exists();
      PackageManager packageManager = null;
      PackageManager.NameNotFoundException nameNotFoundException2 = null;
      if (bool) {
        packageManager = paramContext.getPackageManager();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("isPackageNameEqualsWithApk fileName:");
        stringBuilder.append(paramc.h());
        stringBuilder.append(" apkFileSize：");
        stringBuilder.append(file.length());
        stringBuilder.append(" fileUrl：");
        stringBuilder.append(paramc.j());
        Log.e("AppDownloadUtils", stringBuilder.toString());
        packageInfo = packageManager.getPackageArchiveInfo(file.getAbsolutePath(), a());
        if (packageInfo == null)
          return false; 
        if (!packageInfo.packageName.equals(paramString))
          return false; 
        int i = packageInfo.versionCode;
        try {
          PackageInfo packageInfo1 = paramContext.getPackageManager().getPackageInfo(paramString, a());
        } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException1) {
          nameNotFoundException1 = nameNotFoundException2;
        } 
        if (nameNotFoundException1 == null)
          return false; 
        if (i == ((PackageInfo)nameNotFoundException1).versionCode)
          return true; 
      } else if (a.a(packageInfo.g()).a("install_callback_error")) {
        String str = packageInfo.bg().getString("extra_apk_package_name");
        int i = packageInfo.bg().getInt("extra_apk_version_code");
        if (str != null) {
          PackageManager packageManager1;
          if (TextUtils.isEmpty(str))
            return false; 
          bool = str.equals(paramString);
          if (!bool)
            return false; 
          try {
            PackageInfo packageInfo1 = nameNotFoundException1.getPackageManager().getPackageInfo(paramString, a());
          } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
            packageManager1 = packageManager;
          } 
          if (packageManager1 == null)
            return false; 
          int j = ((PackageInfo)packageManager1).versionCode;
          if (i == j)
            return true; 
        } else {
          return false;
        } 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    if (paramContext != null && !TextUtils.isEmpty(paramString1)) {
      if (TextUtils.isEmpty(paramString2))
        return false; 
      try {
        File file = new File(paramString1, paramString2);
        if (!file.exists())
          return false; 
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("isApkInstalled apkFileSize：fileName:");
        stringBuilder2.append(file.getPath());
        stringBuilder2.append(" apkFileSize");
        stringBuilder2.append(file.length());
        Log.e("AppDownloadUtils", stringBuilder2.toString());
        StringBuilder stringBuilder3 = null;
        if (com.ss.android.socialbase.downloader.m.c.a(268435456) && Build.VERSION.SDK_INT >= 21) {
          int i = Build.VERSION.SDK_INT;
          if (i < 26) {
            stringBuilder2 = stringBuilder3;
            return a(paramContext, packageInfo1);
          } 
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("sigbus:\n\turl: ");
        stringBuilder1.append(paramString3);
        stringBuilder1.append("\n\tmd5: ");
        stringBuilder1.append(b.a(file));
        stringBuilder1.append("\n\tfileName: ");
        stringBuilder1.append(file.getPath());
        stringBuilder1.append("\n\tfileLength: ");
        stringBuilder1.append(file.length());
        stringBuilder1.append("\n");
        b("sigbus_test6", stringBuilder1.toString());
        return a(paramContext, packageInfo);
      } finally {
        paramContext = null;
      } 
    } 
    return false;
  }
  
  public static boolean a(com.ss.android.socialbase.downloader.g.c paramc, String paramString) {
    return TextUtils.isEmpty(paramString) ? false : ((!TextUtils.isEmpty(paramc.z()) && paramString.equals(paramc.z())) ? true : ((!TextUtils.isEmpty(paramc.h()) && a(b.B(), paramc, paramString))));
  }
  
  public static boolean a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return false; 
    try {
      boolean bool = (new JSONObject(paramString)).optBoolean("bind_app", false);
      if (bool)
        return true; 
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return false;
  }
  
  public static int b(Context paramContext, int paramInt, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic a : (Landroid/content/Context;)Lcom/ss/android/socialbase/downloader/downloader/f;
    //   4: iload_1
    //   5: invokevirtual h : (I)Lcom/ss/android/socialbase/downloader/g/c;
    //   8: astore #7
    //   10: aload #7
    //   12: ifnull -> 424
    //   15: ldc 'application/vnd.android.package-archive'
    //   17: aload #7
    //   19: invokevirtual ah : ()Ljava/lang/String;
    //   22: invokevirtual equals : (Ljava/lang/Object;)Z
    //   25: ifeq -> 424
    //   28: aload #7
    //   30: invokevirtual k : ()Ljava/lang/String;
    //   33: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   36: ifne -> 424
    //   39: aload #7
    //   41: invokevirtual h : ()Ljava/lang/String;
    //   44: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   47: ifne -> 424
    //   50: new java/io/File
    //   53: dup
    //   54: aload #7
    //   56: invokevirtual k : ()Ljava/lang/String;
    //   59: aload #7
    //   61: invokevirtual h : ()Ljava/lang/String;
    //   64: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   67: astore #8
    //   69: aload #8
    //   71: invokevirtual exists : ()Z
    //   74: ifne -> 79
    //   77: iconst_2
    //   78: ireturn
    //   79: aload #8
    //   81: invokevirtual getPath : ()Ljava/lang/String;
    //   84: invokestatic getDataDirectory : ()Ljava/io/File;
    //   87: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   90: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   93: istore_3
    //   94: aconst_null
    //   95: astore #6
    //   97: iload_3
    //   98: ifeq -> 202
    //   101: new java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial <init> : ()V
    //   108: astore #4
    //   110: aload #4
    //   112: ldc_w 'chmod 555 '
    //   115: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload #4
    //   121: aload #8
    //   123: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   126: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload #4
    //   132: invokevirtual toString : ()Ljava/lang/String;
    //   135: astore #4
    //   137: invokestatic getRuntime : ()Ljava/lang/Runtime;
    //   140: aload #4
    //   142: invokevirtual exec : (Ljava/lang/String;)Ljava/lang/Process;
    //   145: astore #4
    //   147: aload #4
    //   149: invokevirtual waitFor : ()I
    //   152: pop
    //   153: aload #4
    //   155: ifnull -> 202
    //   158: goto -> 181
    //   161: astore #5
    //   163: goto -> 171
    //   166: astore #5
    //   168: aconst_null
    //   169: astore #4
    //   171: aload #5
    //   173: invokevirtual printStackTrace : ()V
    //   176: aload #4
    //   178: ifnull -> 202
    //   181: aload #4
    //   183: invokevirtual destroy : ()V
    //   186: goto -> 202
    //   189: astore_0
    //   190: aload #4
    //   192: ifnull -> 200
    //   195: aload #4
    //   197: invokevirtual destroy : ()V
    //   200: aload_0
    //   201: athrow
    //   202: aload_0
    //   203: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   206: astore #4
    //   208: aload #4
    //   210: aload #8
    //   212: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   215: invokestatic a : ()I
    //   218: invokevirtual getPackageArchiveInfo : (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   221: astore #4
    //   223: goto -> 226
    //   226: aload_0
    //   227: aload #7
    //   229: aload #4
    //   231: invokestatic a : (Landroid/content/Context;Lcom/ss/android/socialbase/downloader/g/c;Landroid/content/pm/PackageInfo;)Z
    //   234: ifeq -> 239
    //   237: iconst_2
    //   238: ireturn
    //   239: aload #4
    //   241: ifnull -> 293
    //   244: aload #7
    //   246: invokevirtual g : ()I
    //   249: invokestatic a : (I)Lcom/ss/android/socialbase/downloader/k/a;
    //   252: ldc_w 'install_callback_error'
    //   255: invokevirtual a : (Ljava/lang/String;)Z
    //   258: ifeq -> 293
    //   261: aload #7
    //   263: invokevirtual bg : ()Landroid/os/Bundle;
    //   266: ldc_w 'extra_apk_package_name'
    //   269: aload #4
    //   271: getfield packageName : Ljava/lang/String;
    //   274: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   277: aload #7
    //   279: invokevirtual bg : ()Landroid/os/Bundle;
    //   282: ldc_w 'extra_apk_version_code'
    //   285: aload #4
    //   287: getfield versionCode : I
    //   290: invokevirtual putInt : (Ljava/lang/String;I)V
    //   293: iconst_1
    //   294: newarray int
    //   296: astore #5
    //   298: aload_0
    //   299: aload #4
    //   301: invokestatic a : (Landroid/content/Context;Landroid/content/pm/PackageInfo;)Z
    //   304: ifeq -> 328
    //   307: aload #4
    //   309: getfield packageName : Ljava/lang/String;
    //   312: astore #4
    //   314: aload_0
    //   315: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   318: aload #4
    //   320: invokevirtual getLaunchIntentForPackage : (Ljava/lang/String;)Landroid/content/Intent;
    //   323: astore #4
    //   325: goto -> 369
    //   328: iload_2
    //   329: ifne -> 356
    //   332: aload_0
    //   333: iload_1
    //   334: aload #8
    //   336: invokestatic a : (Landroid/content/Context;ILjava/io/File;)Z
    //   339: ifeq -> 356
    //   342: aload #7
    //   344: invokevirtual bg : ()Landroid/os/Bundle;
    //   347: ldc_w 'extra_silent_install_succeed'
    //   350: iconst_1
    //   351: invokevirtual putBoolean : (Ljava/lang/String;Z)V
    //   354: iconst_1
    //   355: ireturn
    //   356: aload_0
    //   357: aload #7
    //   359: aload #8
    //   361: iload_2
    //   362: aload #5
    //   364: invokestatic a : (Landroid/content/Context;Lcom/ss/android/socialbase/downloader/g/c;Ljava/io/File;Z[I)Landroid/content/Intent;
    //   367: astore #4
    //   369: aload #4
    //   371: ifnonnull -> 386
    //   374: aload #5
    //   376: iconst_0
    //   377: iaload
    //   378: iconst_1
    //   379: if_icmpne -> 384
    //   382: iconst_2
    //   383: ireturn
    //   384: iconst_0
    //   385: ireturn
    //   386: aload #4
    //   388: ldc_w 268435456
    //   391: invokevirtual addFlags : (I)Landroid/content/Intent;
    //   394: pop
    //   395: aload #5
    //   397: iconst_0
    //   398: iaload
    //   399: ifne -> 416
    //   402: aload_0
    //   403: aload #7
    //   405: aload #4
    //   407: iload_2
    //   408: invokestatic a : (Landroid/content/Context;Lcom/ss/android/socialbase/downloader/g/c;Landroid/content/Intent;Z)Z
    //   411: ifeq -> 416
    //   414: iconst_1
    //   415: ireturn
    //   416: aload_0
    //   417: aload #4
    //   419: invokevirtual startActivity : (Landroid/content/Intent;)V
    //   422: iconst_1
    //   423: ireturn
    //   424: iconst_2
    //   425: ireturn
    //   426: astore #4
    //   428: aload #6
    //   430: astore #4
    //   432: goto -> 226
    //   435: astore_0
    //   436: iconst_0
    //   437: ireturn
    // Exception table:
    //   from	to	target	type
    //   101	147	166	finally
    //   147	153	161	finally
    //   171	176	189	finally
    //   208	223	426	java/lang/Exception
    //   416	422	435	finally
  }
  
  private static void b(String paramString1, String paramString2) {
    b b = b.D();
    if (b == null)
      return; 
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("message", paramString2);
    } catch (JSONException jSONException) {}
    b.a(paramString1, jSONObject);
  }
  
  public static boolean b(Context paramContext) {
    // Byte code:
    //   0: getstatic android/os/Build$VERSION.SDK_INT : I
    //   3: bipush #20
    //   5: if_icmple -> 123
    //   8: aload_0
    //   9: ifnonnull -> 14
    //   12: iconst_0
    //   13: ireturn
    //   14: aconst_null
    //   15: astore #5
    //   17: aload #5
    //   19: astore #4
    //   21: invokestatic b : ()I
    //   24: istore_1
    //   25: aload #5
    //   27: astore #4
    //   29: aload_0
    //   30: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   33: iload_1
    //   34: invokevirtual getColor : (I)I
    //   37: istore_1
    //   38: aload #5
    //   40: astore #4
    //   42: invokestatic c : ()I
    //   45: istore_2
    //   46: aload #5
    //   48: astore #4
    //   50: invokestatic d : ()I
    //   53: istore_3
    //   54: aload #5
    //   56: astore #4
    //   58: aload_0
    //   59: invokestatic e : ()I
    //   62: iconst_2
    //   63: newarray int
    //   65: dup
    //   66: iconst_0
    //   67: iload_2
    //   68: iastore
    //   69: dup
    //   70: iconst_1
    //   71: iload_3
    //   72: iastore
    //   73: invokevirtual obtainStyledAttributes : (I[I)Landroid/content/res/TypedArray;
    //   76: astore_0
    //   77: aload_0
    //   78: astore #4
    //   80: aload_0
    //   81: iconst_0
    //   82: iconst_0
    //   83: invokevirtual getColor : (II)I
    //   86: istore_2
    //   87: iload_1
    //   88: iload_2
    //   89: if_icmpne -> 102
    //   92: aload_0
    //   93: ifnull -> 100
    //   96: aload_0
    //   97: invokevirtual recycle : ()V
    //   100: iconst_1
    //   101: ireturn
    //   102: aload_0
    //   103: ifnull -> 123
    //   106: aload_0
    //   107: invokevirtual recycle : ()V
    //   110: iconst_0
    //   111: ireturn
    //   112: aload #4
    //   114: ifnull -> 123
    //   117: aload #4
    //   119: astore_0
    //   120: goto -> 106
    //   123: iconst_0
    //   124: ireturn
    //   125: astore_0
    //   126: goto -> 112
    //   129: astore_0
    //   130: iconst_1
    //   131: ireturn
    //   132: astore_0
    //   133: iconst_0
    //   134: ireturn
    // Exception table:
    //   from	to	target	type
    //   21	25	125	finally
    //   29	38	125	finally
    //   42	46	125	finally
    //   50	54	125	finally
    //   58	77	125	finally
    //   80	87	125	finally
    //   96	100	129	finally
    //   106	110	132	finally
  }
  
  public static boolean b(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return false; 
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      if (!jSONObject.optBoolean("bind_app", false)) {
        boolean bool = jSONObject.optBoolean("auto_install_with_notification", true);
        if (!bool)
          return true; 
      } else {
        return true;
      } 
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return false;
  }
  
  public static String c(Context paramContext) {
    try {
      if (a == null) {
        a = new NotificationChannel("111111", "channel_appdownloader", 3);
        a.setSound(null, null);
        a.setShowBadge(false);
        return "111111";
      } 
    } finally {
      paramContext = null;
    } 
  }
  
  public static boolean c(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return false; 
    try {
      boolean bool = (new JSONObject(paramString)).optBoolean("auto_install_without_notification", false);
      if (bool)
        return true; 
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return false;
  }
  
  public static File d(Context paramContext) {
    String str1;
    String str2 = "";
    Context context = paramContext.getApplicationContext();
    try {
      str1 = Environment.getExternalStorageState();
    } catch (NullPointerException|IncompatibleClassChangeError nullPointerException) {
      str1 = str2;
    } 
    return "mounted".equals(str1) ? Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) : context.getFilesDir();
  }
  
  public static boolean d(String paramString) {
    return (!TextUtils.isEmpty(paramString) && paramString.equals("application/vnd.android.package-archive"));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\appdownloader\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */