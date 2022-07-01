package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Locale;

public class b {
  private static final String[] a = new String[] { 
      "/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", 
      "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb" };
  
  private static final String[] b = new String[] { 
      "com.ami.duosupdater.ui", "com.ami.launchmetro", "com.ami.syncduosservices", "com.bluestacks.home", "com.bluestacks.windowsfilemanager", "com.bluestacks.settings", "com.bluestacks.bluestackslocationprovider", "com.bluestacks.appsettings", "com.bluestacks.bstfolder", "com.bluestacks.BstCommandProcessor", 
      "com.bluestacks.s2p", "com.bluestacks.setup", "com.kaopu001.tiantianserver", "com.kpzs.helpercenter", "com.kaopu001.tiantianime", "com.android.development_settings", "com.android.development", "com.android.customlocale2", "com.genymotion.superuser", "com.genymotion.clipboardproxy", 
      "com.uc.xxzs.keyboard", "com.uc.xxzs", "com.blue.huang17.agent", "com.blue.huang17.launcher", "com.blue.huang17.ime", "com.microvirt.guide", "com.microvirt.market", "com.microvirt.memuime", "cn.itools.vm.launcher", "cn.itools.vm.proxy", 
      "cn.itools.vm.softkeyboard", "cn.itools.avdmarket", "com.syd.IME", "com.bignox.app.store.hd", "com.bignox.launcher", "com.bignox.app.phone", "com.bignox.app.noxservice", "com.android.noxpush", "com.haimawan.push", "me.haima.helpcenter", 
      "com.windroy.launcher", "com.windroy.superuser", "com.windroy.launcher", "com.windroy.ime", "com.android.flysilkworm", "com.android.emu.inputservice", "com.tiantian.ime", "com.microvirt.launcher", "me.le8.androidassist", "com.vphone.helper", 
      "com.vphone.launcher", "com.duoyi.giftcenter.giftcenter" };
  
  private static final String[] c = new String[] { "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/qemud", "/dev/qemu_pipe", "/dev/socket/baseband_genyd", "/dev/socket/genyd" };
  
  private static String d = null;
  
  private static String e = null;
  
  public static String a() {
    try {
      return Build.MODEL;
    } finally {
      Exception exception = null;
      if (!x.a(exception))
        exception.printStackTrace(); 
    } 
  }
  
  public static String a(Context paramContext) {
    String str = "fail";
    if (paramContext == null)
      return "fail"; 
    try {
      null = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      return null.toLowerCase();
    } finally {
      paramContext = null;
      if (!x.a((Throwable)paramContext))
        x.a("Failed to get Android ID.", new Object[0]); 
    } 
  }
  
  public static String a(Context paramContext, boolean paramBoolean) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #4
    //   3: aload #4
    //   5: astore_2
    //   6: iload_1
    //   7: ifeq -> 110
    //   10: aload_0
    //   11: ldc 'ro.product.cpu.abilist'
    //   13: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   16: astore_2
    //   17: aload_2
    //   18: invokestatic a : (Ljava/lang/String;)Z
    //   21: ifne -> 35
    //   24: aload_2
    //   25: astore_3
    //   26: aload_2
    //   27: ldc 'fail'
    //   29: invokevirtual equals : (Ljava/lang/Object;)Z
    //   32: ifeq -> 42
    //   35: aload_0
    //   36: ldc 'ro.product.cpu.abi'
    //   38: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   41: astore_3
    //   42: aload #4
    //   44: astore_2
    //   45: aload_3
    //   46: invokestatic a : (Ljava/lang/String;)Z
    //   49: ifne -> 110
    //   52: aload_3
    //   53: ldc 'fail'
    //   55: invokevirtual equals : (Ljava/lang/Object;)Z
    //   58: ifeq -> 67
    //   61: aload #4
    //   63: astore_2
    //   64: goto -> 110
    //   67: new java/lang/StringBuilder
    //   70: dup
    //   71: ldc 'ABI list: '
    //   73: invokespecial <init> : (Ljava/lang/String;)V
    //   76: astore_0
    //   77: aload_0
    //   78: aload_3
    //   79: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: ldc com/tencent/bugly/crashreport/common/info/b
    //   85: aload_0
    //   86: invokevirtual toString : ()Ljava/lang/String;
    //   89: iconst_0
    //   90: anewarray java/lang/Object
    //   93: invokestatic b : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)Z
    //   96: pop
    //   97: aload_3
    //   98: ldc_w ','
    //   101: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   104: iconst_0
    //   105: aaload
    //   106: astore_2
    //   107: goto -> 110
    //   110: aload_2
    //   111: astore_0
    //   112: aload_2
    //   113: ifnonnull -> 123
    //   116: ldc_w 'os.arch'
    //   119: invokestatic getProperty : (Ljava/lang/String;)Ljava/lang/String;
    //   122: astore_0
    //   123: new java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial <init> : ()V
    //   130: astore_2
    //   131: aload_2
    //   132: aload_0
    //   133: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload_2
    //   138: invokevirtual toString : ()Ljava/lang/String;
    //   141: astore_0
    //   142: aload_0
    //   143: areturn
    //   144: aload_0
    //   145: invokestatic a : (Ljava/lang/Throwable;)Z
    //   148: ifne -> 155
    //   151: aload_0
    //   152: invokevirtual printStackTrace : ()V
    //   155: ldc 'fail'
    //   157: areturn
    //   158: astore_0
    //   159: goto -> 144
    // Exception table:
    //   from	to	target	type
    //   10	24	158	finally
    //   26	35	158	finally
    //   35	42	158	finally
    //   45	61	158	finally
    //   67	107	158	finally
    //   116	123	158	finally
    //   123	142	158	finally
  }
  
  public static String b() {
    try {
      return Build.VERSION.RELEASE;
    } finally {
      Exception exception = null;
      if (!x.a(exception))
        exception.printStackTrace(); 
    } 
  }
  
  public static String b(Context paramContext) {
    String str1;
    String str2 = "fail";
    if (paramContext == null)
      return "fail"; 
    try {
      TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    } finally {
      paramContext = null;
      x.a("Failed to get SIM serial number.", new Object[0]);
    } 
    return str1;
  }
  
  public static int c() {
    try {
      return Build.VERSION.SDK_INT;
    } finally {
      Exception exception = null;
      if (!x.a(exception))
        exception.printStackTrace(); 
    } 
  }
  
  public static String c(Context paramContext) {
    try {
      NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (networkInfo == null)
        return null; 
      if (networkInfo.getType() == 1)
        return "WIFI"; 
      if (networkInfo.getType() == 0) {
        TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
        if (telephonyManager != null) {
          StringBuilder stringBuilder;
          int i = telephonyManager.getNetworkType();
          switch (i) {
            default:
              stringBuilder = new StringBuilder("MOBILE(");
              stringBuilder.append(i);
              stringBuilder.append(")");
              return stringBuilder.toString();
            case 15:
              return "HSPA+";
            case 14:
              return "eHRPD";
            case 13:
              return "LTE";
            case 12:
              return "EVDO_B";
            case 11:
              return "iDen";
            case 10:
              return "HSPA";
            case 9:
              return "HSUPA";
            case 8:
              return "HSDPA";
            case 7:
              return "1xRTT";
            case 6:
              return "EVDO_A";
            case 5:
              return "EVDO_0";
            case 4:
              return "CDMA";
            case 3:
              return "UMTS";
            case 2:
              return "EDGE";
            case 1:
              break;
          } 
        } else {
          return "unknown";
        } 
      } else {
        return "unknown";
      } 
    } catch (Exception exception) {
      if (!x.a(exception))
        exception.printStackTrace(); 
      return "unknown";
    } 
    return "GPRS";
  }
  
  public static String d() {
    return "null";
  }
  
  public static String d(Context paramContext) {
    StringBuilder stringBuilder2;
    String str1;
    StringBuilder stringBuilder1;
    String str2 = z.a(paramContext, "ro.miui.ui.version.name");
    if (!z.a(str2) && !str2.equals("fail")) {
      stringBuilder2 = new StringBuilder("XiaoMi/MIUI/");
      stringBuilder2.append(str2);
      return stringBuilder2.toString();
    } 
    str2 = z.a((Context)stringBuilder2, "ro.build.version.emui");
    if (!z.a(str2) && !str2.equals("fail")) {
      stringBuilder2 = new StringBuilder("HuaWei/EMOTION/");
      stringBuilder2.append(str2);
      return stringBuilder2.toString();
    } 
    str2 = z.a((Context)stringBuilder2, "ro.lenovo.series");
    if (!z.a(str2) && !str2.equals("fail")) {
      str1 = z.a((Context)stringBuilder2, "ro.build.version.incremental");
      StringBuilder stringBuilder = new StringBuilder("Lenovo/VIBE/");
      stringBuilder.append(str1);
      return stringBuilder.toString();
    } 
    str2 = z.a((Context)str1, "ro.build.nubia.rom.name");
    if (!z.a(str2) && !str2.equals("fail")) {
      StringBuilder stringBuilder = new StringBuilder("Zte/NUBIA/");
      stringBuilder.append(str2);
      stringBuilder.append("_");
      stringBuilder.append(z.a((Context)str1, "ro.build.nubia.rom.code"));
      return stringBuilder.toString();
    } 
    str2 = z.a((Context)str1, "ro.meizu.product.model");
    if (!z.a(str2) && !str2.equals("fail")) {
      StringBuilder stringBuilder = new StringBuilder("Meizu/FLYME/");
      stringBuilder.append(z.a((Context)str1, "ro.build.display.id"));
      return stringBuilder.toString();
    } 
    str2 = z.a((Context)str1, "ro.build.version.opporom");
    if (!z.a(str2) && !str2.equals("fail")) {
      stringBuilder1 = new StringBuilder("Oppo/COLOROS/");
      stringBuilder1.append(str2);
      return stringBuilder1.toString();
    } 
    str2 = z.a((Context)stringBuilder1, "ro.vivo.os.build.display.id");
    if (!z.a(str2) && !str2.equals("fail")) {
      stringBuilder1 = new StringBuilder("vivo/FUNTOUCH/");
      stringBuilder1.append(str2);
      return stringBuilder1.toString();
    } 
    str2 = z.a((Context)stringBuilder1, "ro.aa.romver");
    if (!z.a(str2) && !str2.equals("fail")) {
      StringBuilder stringBuilder = new StringBuilder("htc/");
      stringBuilder.append(str2);
      stringBuilder.append("/");
      stringBuilder.append(z.a((Context)stringBuilder1, "ro.build.description"));
      return stringBuilder.toString();
    } 
    str2 = z.a((Context)stringBuilder1, "ro.lewa.version");
    if (!z.a(str2) && !str2.equals("fail")) {
      StringBuilder stringBuilder = new StringBuilder("tcl/");
      stringBuilder.append(str2);
      stringBuilder.append("/");
      stringBuilder.append(z.a((Context)stringBuilder1, "ro.build.display.id"));
      return stringBuilder.toString();
    } 
    str2 = z.a((Context)stringBuilder1, "ro.gn.gnromvernumber");
    if (!z.a(str2) && !str2.equals("fail")) {
      StringBuilder stringBuilder = new StringBuilder("amigo/");
      stringBuilder.append(str2);
      stringBuilder.append("/");
      stringBuilder.append(z.a((Context)stringBuilder1, "ro.build.display.id"));
      return stringBuilder.toString();
    } 
    str2 = z.a((Context)stringBuilder1, "ro.build.tyd.kbstyle_version");
    if (!z.a(str2) && !str2.equals("fail")) {
      stringBuilder1 = new StringBuilder("dido/");
      stringBuilder1.append(str2);
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(z.a((Context)stringBuilder1, "ro.build.fingerprint"));
    stringBuilder3.append("/");
    stringBuilder3.append(z.a((Context)stringBuilder1, "ro.build.rom.id"));
    return stringBuilder3.toString();
  }
  
  public static String e() {
    return "null";
  }
  
  public static String e(Context paramContext) {
    return z.a(paramContext, "ro.board.platform");
  }
  
  public static String f() {
    return "null";
  }
  
  public static String f(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    String str2 = z.a(paramContext, "ro.genymotion.version");
    if (str2 != null) {
      stringBuilder.append("ro.genymotion.version");
      stringBuilder.append("|");
      stringBuilder.append(str2);
      stringBuilder.append("\n");
    } 
    str2 = z.a(paramContext, "androVM.vbox_dpi");
    if (str2 != null) {
      stringBuilder.append("androVM.vbox_dpi");
      stringBuilder.append("|");
      stringBuilder.append(str2);
      stringBuilder.append("\n");
    } 
    String str1 = z.a(paramContext, "qemu.sf.fake_camera");
    if (str1 != null) {
      stringBuilder.append("qemu.sf.fake_camera");
      stringBuilder.append("|");
      stringBuilder.append(str1);
    } 
    return stringBuilder.toString();
  }
  
  public static String g() {
    try {
      return Build.SERIAL;
    } finally {
      Exception exception = null;
      x.a("Failed to get hardware serial number.", new Object[0]);
    } 
  }
  
  public static String g(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    if (d == null)
      d = z.a(paramContext, "ro.secure"); 
    if (d != null) {
      stringBuilder.append("ro.secure");
      stringBuilder.append("|");
      stringBuilder.append(d);
      stringBuilder.append("\n");
    } 
    if (e == null)
      e = z.a(paramContext, "ro.debuggable"); 
    if (e != null) {
      stringBuilder.append("ro.debuggable");
      stringBuilder.append("|");
      stringBuilder.append(e);
      stringBuilder.append("\n");
    } 
    try {
      BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/self/status"));
    } finally {
      null = null;
    } 
    try {
      x.a(null);
      return stringBuilder.toString();
    } finally {
      if (iOException != null)
        try {
          iOException.close();
        } catch (IOException iOException1) {
          x.a(iOException1);
        }  
    } 
  }
  
  public static long h() {
    try {
      StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
      return i * l;
    } finally {
      Exception exception = null;
      if (!x.a(exception))
        exception.printStackTrace(); 
    } 
  }
  
  public static String h(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    String str2 = z.a(paramContext, "gsm.sim.state");
    if (str2 != null) {
      stringBuilder.append("gsm.sim.state");
      stringBuilder.append("|");
      stringBuilder.append(str2);
    } 
    stringBuilder.append("\n");
    String str1 = z.a(paramContext, "gsm.sim.state2");
    if (str1 != null) {
      stringBuilder.append("gsm.sim.state2");
      stringBuilder.append("|");
      stringBuilder.append(str1);
    } 
    return stringBuilder.toString();
  }
  
  public static long i() {
    try {
      StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
      return i * l;
    } finally {
      Exception exception = null;
      if (!x.a(exception))
        exception.printStackTrace(); 
    } 
  }
  
  public static boolean i(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic k : (Landroid/content/Context;)Ljava/lang/String;
    //   4: ifnonnull -> 112
    //   7: new java/util/ArrayList
    //   10: dup
    //   11: invokespecial <init> : ()V
    //   14: astore_0
    //   15: iconst_0
    //   16: istore_1
    //   17: getstatic com/tencent/bugly/crashreport/common/info/b.c : [Ljava/lang/String;
    //   20: astore_2
    //   21: iload_1
    //   22: aload_2
    //   23: arraylength
    //   24: if_icmpge -> 86
    //   27: iload_1
    //   28: ifne -> 52
    //   31: new java/io/File
    //   34: dup
    //   35: aload_2
    //   36: iload_1
    //   37: aaload
    //   38: invokespecial <init> : (Ljava/lang/String;)V
    //   41: astore_2
    //   42: aload_2
    //   43: invokevirtual exists : ()Z
    //   46: ifne -> 79
    //   49: goto -> 70
    //   52: new java/io/File
    //   55: dup
    //   56: aload_2
    //   57: iload_1
    //   58: aaload
    //   59: invokespecial <init> : (Ljava/lang/String;)V
    //   62: astore_2
    //   63: aload_2
    //   64: invokevirtual exists : ()Z
    //   67: ifeq -> 79
    //   70: aload_0
    //   71: iload_1
    //   72: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   75: invokevirtual add : (Ljava/lang/Object;)Z
    //   78: pop
    //   79: iload_1
    //   80: iconst_1
    //   81: iadd
    //   82: istore_1
    //   83: goto -> 17
    //   86: aload_0
    //   87: invokevirtual isEmpty : ()Z
    //   90: ifeq -> 98
    //   93: aconst_null
    //   94: astore_0
    //   95: goto -> 103
    //   98: aload_0
    //   99: invokevirtual toString : ()Ljava/lang/String;
    //   102: astore_0
    //   103: aload_0
    //   104: ifnull -> 110
    //   107: goto -> 112
    //   110: iconst_0
    //   111: ireturn
    //   112: iconst_1
    //   113: ireturn
  }
  
  public static long j() {
    BufferedReader bufferedReader1;
    BufferedReader bufferedReader2;
    try {
    
    } finally {
      null = null;
      bufferedReader2 = null;
    } 
    try {
      if (!x.a(null))
        null.printStackTrace(); 
      return -2L;
    } finally {
      if (iOException != null)
        try {
          iOException.close();
        } catch (IOException iOException1) {
          if (!x.a(iOException1))
            iOException1.printStackTrace(); 
        }  
      if (bufferedReader2 != null)
        try {
          bufferedReader2.close();
        } catch (IOException iOException1) {
          if (!x.a(iOException1))
            iOException1.printStackTrace(); 
        }  
    } 
  }
  
  public static boolean j(Context paramContext) {
    return ((l(paramContext) | w() | x() | v()) > 0);
  }
  
  public static long k() {
    BufferedReader bufferedReader1;
    BufferedReader bufferedReader2;
    try {
    
    } finally {
      null = null;
      bufferedReader1 = null;
    } 
    try {
      if (!x.a(null))
        null.printStackTrace(); 
      return -2L;
    } finally {
      if (bufferedReader1 != null)
        try {
          bufferedReader1.close();
        } catch (IOException iOException) {
          if (!x.a(iOException))
            iOException.printStackTrace(); 
        }  
      if (bufferedReader2 != null)
        try {
          bufferedReader2.close();
        } catch (IOException iOException) {
          if (!x.a(iOException))
            iOException.printStackTrace(); 
        }  
    } 
  }
  
  private static String k(Context paramContext) {
    PackageManager packageManager = paramContext.getPackageManager();
    ArrayList<Integer> arrayList = new ArrayList();
    int i = 0;
    while (true) {
      String[] arrayOfString = b;
      if (i < arrayOfString.length) {
        try {
          packageManager.getPackageInfo(arrayOfString[i], 1);
          arrayList.add(Integer.valueOf(i));
        } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {}
        i++;
        continue;
      } 
      return arrayList.isEmpty() ? null : arrayList.toString();
    } 
  }
  
  private static int l(Context paramContext) {
    boolean bool;
    PackageManager packageManager = paramContext.getPackageManager();
    try {
      packageManager.getInstallerPackageName("de.robv.android.xposed.installer");
      bool = true;
    } catch (Exception exception) {
      bool = false;
    } 
    try {
      packageManager.getInstallerPackageName("com.saurik.substrate");
      return bool | 0x2;
    } catch (Exception exception) {
      return bool;
    } 
  }
  
  public static long l() {
    if (!u())
      return 0L; 
    try {
      StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      return j * i;
    } finally {
      Exception exception = null;
      if (!x.a(exception))
        exception.printStackTrace(); 
    } 
  }
  
  public static long m() {
    if (!u())
      return 0L; 
    try {
      StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      return j * i;
    } finally {
      Exception exception = null;
      if (!x.a(exception))
        exception.printStackTrace(); 
    } 
  }
  
  public static String n() {
    try {
      return Locale.getDefault().getCountry();
    } finally {
      Exception exception = null;
      if (!x.a(exception))
        exception.printStackTrace(); 
    } 
  }
  
  public static String o() {
    try {
      return Build.BRAND;
    } finally {
      Exception exception = null;
      if (!x.a(exception))
        exception.printStackTrace(); 
    } 
  }
  
  public static boolean p() {
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    while (true) {
      if (i < j) {
        if ((new File(arrayOfString[i])).exists()) {
          i = 1;
          break;
        } 
        i++;
        continue;
      } 
      i = 0;
      break;
    } 
    if (Build.TAGS != null && Build.TAGS.contains("test-keys")) {
      j = 1;
    } else {
      j = 0;
    } 
    return (j == 0) ? ((i != 0)) : true;
  }
  
  public static String q() {
    // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_3
    //   8: new java/io/File
    //   11: dup
    //   12: ldc_w '/sys/block/mmcblk0/device/type'
    //   15: invokespecial <init> : (Ljava/lang/String;)V
    //   18: invokevirtual exists : ()Z
    //   21: ifeq -> 297
    //   24: new java/io/BufferedReader
    //   27: dup
    //   28: new java/io/FileReader
    //   31: dup
    //   32: ldc_w '/sys/block/mmcblk0/device/type'
    //   35: invokespecial <init> : (Ljava/lang/String;)V
    //   38: invokespecial <init> : (Ljava/io/Reader;)V
    //   41: astore_0
    //   42: aload_0
    //   43: astore_1
    //   44: aload_0
    //   45: invokevirtual readLine : ()Ljava/lang/String;
    //   48: astore_2
    //   49: aload_2
    //   50: ifnull -> 61
    //   53: aload_0
    //   54: astore_1
    //   55: aload_3
    //   56: aload_2
    //   57: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload_0
    //   62: astore_1
    //   63: aload_0
    //   64: invokevirtual close : ()V
    //   67: goto -> 70
    //   70: aload_0
    //   71: astore_1
    //   72: aload_3
    //   73: ldc_w ','
    //   76: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_0
    //   81: astore_1
    //   82: new java/io/File
    //   85: dup
    //   86: ldc_w '/sys/block/mmcblk0/device/name'
    //   89: invokespecial <init> : (Ljava/lang/String;)V
    //   92: invokevirtual exists : ()Z
    //   95: ifeq -> 302
    //   98: aload_0
    //   99: astore_1
    //   100: new java/io/BufferedReader
    //   103: dup
    //   104: new java/io/FileReader
    //   107: dup
    //   108: ldc_w '/sys/block/mmcblk0/device/name'
    //   111: invokespecial <init> : (Ljava/lang/String;)V
    //   114: invokespecial <init> : (Ljava/io/Reader;)V
    //   117: astore_0
    //   118: aload_0
    //   119: astore_1
    //   120: aload_0
    //   121: invokevirtual readLine : ()Ljava/lang/String;
    //   124: astore_2
    //   125: aload_2
    //   126: ifnull -> 137
    //   129: aload_0
    //   130: astore_1
    //   131: aload_3
    //   132: aload_2
    //   133: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload_0
    //   138: astore_1
    //   139: aload_0
    //   140: invokevirtual close : ()V
    //   143: goto -> 146
    //   146: aload_0
    //   147: astore_1
    //   148: aload_3
    //   149: ldc_w ','
    //   152: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload_0
    //   157: astore_1
    //   158: new java/io/File
    //   161: dup
    //   162: ldc_w '/sys/block/mmcblk0/device/cid'
    //   165: invokespecial <init> : (Ljava/lang/String;)V
    //   168: invokevirtual exists : ()Z
    //   171: ifeq -> 305
    //   174: aload_0
    //   175: astore_1
    //   176: new java/io/BufferedReader
    //   179: dup
    //   180: new java/io/FileReader
    //   183: dup
    //   184: ldc_w '/sys/block/mmcblk0/device/cid'
    //   187: invokespecial <init> : (Ljava/lang/String;)V
    //   190: invokespecial <init> : (Ljava/io/Reader;)V
    //   193: astore_2
    //   194: aload_2
    //   195: astore_0
    //   196: aload_2
    //   197: invokevirtual readLine : ()Ljava/lang/String;
    //   200: astore #4
    //   202: aload_2
    //   203: astore_1
    //   204: aload #4
    //   206: ifnull -> 223
    //   209: aload_2
    //   210: astore_0
    //   211: aload_3
    //   212: aload #4
    //   214: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload_2
    //   219: astore_1
    //   220: goto -> 223
    //   223: aload_1
    //   224: astore_0
    //   225: aload_3
    //   226: invokevirtual toString : ()Ljava/lang/String;
    //   229: astore_2
    //   230: aload_1
    //   231: ifnull -> 246
    //   234: aload_1
    //   235: invokevirtual close : ()V
    //   238: aload_2
    //   239: areturn
    //   240: astore_0
    //   241: aload_0
    //   242: invokestatic a : (Ljava/lang/Throwable;)Z
    //   245: pop
    //   246: aload_2
    //   247: areturn
    //   248: goto -> 263
    //   251: aload_1
    //   252: astore_0
    //   253: goto -> 263
    //   256: aload_1
    //   257: astore_0
    //   258: goto -> 263
    //   261: aconst_null
    //   262: astore_0
    //   263: aload_0
    //   264: ifnull -> 279
    //   267: aload_0
    //   268: invokevirtual close : ()V
    //   271: aconst_null
    //   272: areturn
    //   273: astore_0
    //   274: aload_0
    //   275: invokestatic a : (Ljava/lang/Throwable;)Z
    //   278: pop
    //   279: aconst_null
    //   280: areturn
    //   281: astore_0
    //   282: goto -> 261
    //   285: astore_0
    //   286: goto -> 256
    //   289: astore_0
    //   290: goto -> 251
    //   293: astore_1
    //   294: goto -> 248
    //   297: aconst_null
    //   298: astore_0
    //   299: goto -> 70
    //   302: goto -> 146
    //   305: aload_0
    //   306: astore_1
    //   307: goto -> 223
    // Exception table:
    //   from	to	target	type
    //   0	42	281	finally
    //   44	49	285	finally
    //   55	61	285	finally
    //   63	67	285	finally
    //   72	80	285	finally
    //   82	98	285	finally
    //   100	118	285	finally
    //   120	125	289	finally
    //   131	137	289	finally
    //   139	143	289	finally
    //   148	156	289	finally
    //   158	174	289	finally
    //   176	194	289	finally
    //   196	202	293	finally
    //   211	218	293	finally
    //   225	230	293	finally
    //   234	238	240	java/io/IOException
    //   267	271	273	java/io/IOException
  }
  
  public static String r() {
    // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #4
    //   9: aconst_null
    //   10: astore_3
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_3
    //   14: astore_1
    //   15: new java/io/File
    //   18: dup
    //   19: ldc_w '/sys/class/power_supply/ac/online'
    //   22: invokespecial <init> : (Ljava/lang/String;)V
    //   25: invokevirtual exists : ()Z
    //   28: istore_0
    //   29: iload_0
    //   30: ifeq -> 99
    //   33: aload_3
    //   34: astore_1
    //   35: new java/io/BufferedReader
    //   38: dup
    //   39: new java/io/FileReader
    //   42: dup
    //   43: ldc_w '/sys/class/power_supply/ac/online'
    //   46: invokespecial <init> : (Ljava/lang/String;)V
    //   49: invokespecial <init> : (Ljava/io/Reader;)V
    //   52: astore_2
    //   53: aload_2
    //   54: invokevirtual readLine : ()Ljava/lang/String;
    //   57: astore_1
    //   58: aload_1
    //   59: ifnull -> 87
    //   62: aload #4
    //   64: ldc_w 'ac_online'
    //   67: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload #4
    //   73: ldc_w '|'
    //   76: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload #4
    //   82: aload_1
    //   83: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload_2
    //   88: invokevirtual close : ()V
    //   91: goto -> 99
    //   94: aload_2
    //   95: astore_1
    //   96: goto -> 306
    //   99: aload_2
    //   100: astore_1
    //   101: aload #4
    //   103: ldc_w '\\n'
    //   106: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload_2
    //   111: astore_3
    //   112: aload_2
    //   113: astore_1
    //   114: new java/io/File
    //   117: dup
    //   118: ldc_w '/sys/class/power_supply/usb/online'
    //   121: invokespecial <init> : (Ljava/lang/String;)V
    //   124: invokevirtual exists : ()Z
    //   127: ifeq -> 198
    //   130: aload_2
    //   131: astore_1
    //   132: new java/io/BufferedReader
    //   135: dup
    //   136: new java/io/FileReader
    //   139: dup
    //   140: ldc_w '/sys/class/power_supply/usb/online'
    //   143: invokespecial <init> : (Ljava/lang/String;)V
    //   146: invokespecial <init> : (Ljava/io/Reader;)V
    //   149: astore_2
    //   150: aload_2
    //   151: invokevirtual readLine : ()Ljava/lang/String;
    //   154: astore_1
    //   155: aload_1
    //   156: ifnull -> 184
    //   159: aload #4
    //   161: ldc_w 'usb_online'
    //   164: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload #4
    //   170: ldc_w '|'
    //   173: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload #4
    //   179: aload_1
    //   180: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_2
    //   185: invokevirtual close : ()V
    //   188: aload_2
    //   189: astore_3
    //   190: goto -> 198
    //   193: aload_2
    //   194: astore_1
    //   195: goto -> 306
    //   198: aload_3
    //   199: astore_1
    //   200: aload #4
    //   202: ldc_w '\\n'
    //   205: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload_3
    //   210: astore_1
    //   211: new java/io/File
    //   214: dup
    //   215: ldc_w '/sys/class/power_supply/battery/capacity'
    //   218: invokespecial <init> : (Ljava/lang/String;)V
    //   221: invokevirtual exists : ()Z
    //   224: ifeq -> 293
    //   227: aload_3
    //   228: astore_1
    //   229: new java/io/BufferedReader
    //   232: dup
    //   233: new java/io/FileReader
    //   236: dup
    //   237: ldc_w '/sys/class/power_supply/battery/capacity'
    //   240: invokespecial <init> : (Ljava/lang/String;)V
    //   243: invokespecial <init> : (Ljava/io/Reader;)V
    //   246: astore_2
    //   247: aload_2
    //   248: invokevirtual readLine : ()Ljava/lang/String;
    //   251: astore_1
    //   252: aload_1
    //   253: ifnull -> 281
    //   256: aload #4
    //   258: ldc_w 'battery_capacity'
    //   261: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload #4
    //   267: ldc_w '|'
    //   270: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload #4
    //   276: aload_1
    //   277: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload_2
    //   282: invokevirtual close : ()V
    //   285: goto -> 295
    //   288: aload_2
    //   289: astore_1
    //   290: goto -> 306
    //   293: aload_3
    //   294: astore_2
    //   295: aload_2
    //   296: ifnull -> 323
    //   299: aload_2
    //   300: invokevirtual close : ()V
    //   303: goto -> 323
    //   306: aload_1
    //   307: ifnull -> 323
    //   310: aload_1
    //   311: invokevirtual close : ()V
    //   314: goto -> 323
    //   317: astore_1
    //   318: aload_1
    //   319: invokestatic a : (Ljava/lang/Throwable;)Z
    //   322: pop
    //   323: aload #4
    //   325: invokevirtual toString : ()Ljava/lang/String;
    //   328: areturn
    //   329: astore_2
    //   330: goto -> 306
    //   333: astore_1
    //   334: goto -> 94
    //   337: astore_1
    //   338: goto -> 193
    //   341: astore_1
    //   342: goto -> 288
    // Exception table:
    //   from	to	target	type
    //   15	29	329	finally
    //   35	53	329	finally
    //   53	58	333	finally
    //   62	87	333	finally
    //   87	91	333	finally
    //   101	110	329	finally
    //   114	130	329	finally
    //   132	150	329	finally
    //   150	155	337	finally
    //   159	184	337	finally
    //   184	188	337	finally
    //   200	209	329	finally
    //   211	227	329	finally
    //   229	247	329	finally
    //   247	252	341	finally
    //   256	281	341	finally
    //   281	285	341	finally
    //   299	303	317	java/io/IOException
    //   310	314	317	java/io/IOException
  }
  
  public static long s() {
    Exception exception;
    float f2 = 0.0F;
    float f3 = 0.0F;
    float f1 = 0.0F;
    try {
      BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/uptime"));
    } finally {
      exception = null;
    } 
    try {
      x.a("Failed to get boot time of device.", new Object[0]);
      f1 = f3;
      return (long)f1;
    } finally {
      if (exception != null)
        try {
          exception.close();
        } catch (IOException iOException) {
          x.a(iOException);
        }  
    } 
  }
  
  public static boolean t() {
    float f1 = (float)(Runtime.getRuntime().maxMemory() / 1048576.0D);
    float f2 = (float)(Runtime.getRuntime().totalMemory() / 1048576.0D);
    float f3 = f1 - f2;
    x.c("maxMemory : %f", new Object[] { Float.valueOf(f1) });
    x.c("totalMemory : %f", new Object[] { Float.valueOf(f2) });
    x.c("freeMemory : %f", new Object[] { Float.valueOf(f3) });
    return (f3 < 10.0F);
  }
  
  private static boolean u() {
    try {
      boolean bool = Environment.getExternalStorageState().equals("mounted");
    } finally {
      Exception exception = null;
    } 
    return false;
  }
  
  private static int v() {
    try {
      Method method = Class.forName("android.app.ActivityManagerNative").getMethod("getDefault", new Class[0]);
      method.setAccessible(true);
      boolean bool = method.invoke((Object)null, new Object[0]).getClass().getName().startsWith("$Proxy");
      return bool ? 256 : 0;
    } catch (Exception exception) {
      return 256;
    } 
  }
  
  private static int w() {
    try {
      throw new Exception("detect hook");
    } catch (Exception exception) {
      StackTraceElement[] arrayOfStackTraceElement = exception.getStackTrace();
      int m = arrayOfStackTraceElement.length;
      int j = 0;
      int i = 0;
      for (int k = 0; j < m; k = i1) {
        StackTraceElement stackTraceElement = arrayOfStackTraceElement[j];
        int n = i;
        if (stackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge")) {
          n = i;
          if (stackTraceElement.getMethodName().equals("main"))
            n = i | 0x4; 
        } 
        i = n;
        if (stackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge")) {
          i = n;
          if (stackTraceElement.getMethodName().equals("handleHookedMethod"))
            i = n | 0x8; 
        } 
        n = i;
        if (stackTraceElement.getClassName().equals("com.saurik.substrate.MS$2")) {
          n = i;
          if (stackTraceElement.getMethodName().equals("invoked"))
            n = i | 0x10; 
        } 
        i = n;
        int i1 = k;
        if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit")) {
          k++;
          i = n;
          i1 = k;
          if (k == 2) {
            i = n | 0x20;
            i1 = k;
          } 
        } 
        j++;
      } 
      return i;
    } 
  }
  
  private static int x() {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iconst_0
    //   3: istore #5
    //   5: iconst_0
    //   6: istore #6
    //   8: iconst_0
    //   9: istore_2
    //   10: iconst_0
    //   11: istore_3
    //   12: iconst_0
    //   13: istore #4
    //   15: iconst_0
    //   16: istore_0
    //   17: new java/util/HashSet
    //   20: dup
    //   21: invokespecial <init> : ()V
    //   24: astore #10
    //   26: new java/lang/StringBuilder
    //   29: dup
    //   30: ldc_w '/proc/'
    //   33: invokespecial <init> : (Ljava/lang/String;)V
    //   36: astore #8
    //   38: aload #8
    //   40: invokestatic myPid : ()I
    //   43: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload #8
    //   49: ldc_w '/maps'
    //   52: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: new java/io/BufferedReader
    //   59: dup
    //   60: new java/io/InputStreamReader
    //   63: dup
    //   64: new java/io/FileInputStream
    //   67: dup
    //   68: aload #8
    //   70: invokevirtual toString : ()Ljava/lang/String;
    //   73: invokespecial <init> : (Ljava/lang/String;)V
    //   76: ldc_w 'utf-8'
    //   79: invokespecial <init> : (Ljava/io/InputStream;Ljava/lang/String;)V
    //   82: invokespecial <init> : (Ljava/io/Reader;)V
    //   85: astore #9
    //   87: iload_1
    //   88: istore_2
    //   89: iload #5
    //   91: istore_3
    //   92: iload #6
    //   94: istore #4
    //   96: aload #9
    //   98: astore #8
    //   100: aload #9
    //   102: invokevirtual readLine : ()Ljava/lang/String;
    //   105: astore #11
    //   107: aload #11
    //   109: ifnull -> 197
    //   112: iload_1
    //   113: istore_2
    //   114: iload #5
    //   116: istore_3
    //   117: iload #6
    //   119: istore #4
    //   121: aload #9
    //   123: astore #8
    //   125: aload #11
    //   127: ldc_w '.so'
    //   130: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   133: ifne -> 160
    //   136: iload_1
    //   137: istore_2
    //   138: iload #5
    //   140: istore_3
    //   141: iload #6
    //   143: istore #4
    //   145: aload #9
    //   147: astore #8
    //   149: aload #11
    //   151: ldc_w '.jar'
    //   154: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   157: ifeq -> 87
    //   160: iload_1
    //   161: istore_2
    //   162: iload #5
    //   164: istore_3
    //   165: iload #6
    //   167: istore #4
    //   169: aload #9
    //   171: astore #8
    //   173: aload #10
    //   175: aload #11
    //   177: aload #11
    //   179: ldc_w ' '
    //   182: invokevirtual lastIndexOf : (Ljava/lang/String;)I
    //   185: iconst_1
    //   186: iadd
    //   187: invokevirtual substring : (I)Ljava/lang/String;
    //   190: invokevirtual add : (Ljava/lang/Object;)Z
    //   193: pop
    //   194: goto -> 87
    //   197: iload_1
    //   198: istore_2
    //   199: iload #5
    //   201: istore_3
    //   202: iload #6
    //   204: istore #4
    //   206: aload #9
    //   208: astore #8
    //   210: aload #10
    //   212: invokevirtual iterator : ()Ljava/util/Iterator;
    //   215: astore #10
    //   217: iload_0
    //   218: istore_2
    //   219: iload_0
    //   220: istore_3
    //   221: iload_0
    //   222: istore #4
    //   224: aload #9
    //   226: astore #8
    //   228: aload #10
    //   230: invokeinterface hasNext : ()Z
    //   235: ifeq -> 333
    //   238: iload_0
    //   239: istore_2
    //   240: iload_0
    //   241: istore_3
    //   242: iload_0
    //   243: istore #4
    //   245: aload #9
    //   247: astore #8
    //   249: aload #10
    //   251: invokeinterface next : ()Ljava/lang/Object;
    //   256: astore #11
    //   258: iload_0
    //   259: istore_1
    //   260: iload_0
    //   261: istore_2
    //   262: iload_0
    //   263: istore_3
    //   264: iload_0
    //   265: istore #4
    //   267: aload #9
    //   269: astore #8
    //   271: aload #11
    //   273: checkcast java/lang/String
    //   276: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   279: ldc_w 'xposed'
    //   282: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   285: ifeq -> 293
    //   288: iload_0
    //   289: bipush #64
    //   291: ior
    //   292: istore_1
    //   293: iload_1
    //   294: istore_2
    //   295: iload_1
    //   296: istore_3
    //   297: iload_1
    //   298: istore #4
    //   300: aload #9
    //   302: astore #8
    //   304: aload #11
    //   306: checkcast java/lang/String
    //   309: ldc_w 'com.saurik.substrate'
    //   312: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   315: istore #7
    //   317: iload_1
    //   318: istore_0
    //   319: iload #7
    //   321: ifeq -> 217
    //   324: iload_1
    //   325: sipush #128
    //   328: ior
    //   329: istore_0
    //   330: goto -> 217
    //   333: iload_0
    //   334: istore_1
    //   335: aload #9
    //   337: invokevirtual close : ()V
    //   340: iload_0
    //   341: ireturn
    //   342: astore #8
    //   344: aload #8
    //   346: invokevirtual printStackTrace : ()V
    //   349: iload_1
    //   350: ireturn
    //   351: astore #10
    //   353: goto -> 379
    //   356: astore #10
    //   358: goto -> 409
    //   361: astore #10
    //   363: goto -> 439
    //   366: astore #8
    //   368: aconst_null
    //   369: astore #9
    //   371: goto -> 479
    //   374: astore #10
    //   376: aconst_null
    //   377: astore #9
    //   379: aload #9
    //   381: astore #8
    //   383: aload #10
    //   385: invokevirtual printStackTrace : ()V
    //   388: iload_2
    //   389: istore_0
    //   390: aload #9
    //   392: ifnull -> 467
    //   395: iload_2
    //   396: istore_1
    //   397: aload #9
    //   399: invokevirtual close : ()V
    //   402: iload_2
    //   403: ireturn
    //   404: astore #10
    //   406: aconst_null
    //   407: astore #9
    //   409: aload #9
    //   411: astore #8
    //   413: aload #10
    //   415: invokevirtual printStackTrace : ()V
    //   418: iload_3
    //   419: istore_0
    //   420: aload #9
    //   422: ifnull -> 467
    //   425: iload_3
    //   426: istore_1
    //   427: aload #9
    //   429: invokevirtual close : ()V
    //   432: iload_3
    //   433: ireturn
    //   434: astore #10
    //   436: aconst_null
    //   437: astore #9
    //   439: aload #9
    //   441: astore #8
    //   443: aload #10
    //   445: invokevirtual printStackTrace : ()V
    //   448: iload #4
    //   450: istore_0
    //   451: aload #9
    //   453: ifnull -> 467
    //   456: iload #4
    //   458: istore_1
    //   459: aload #9
    //   461: invokevirtual close : ()V
    //   464: iload #4
    //   466: istore_0
    //   467: iload_0
    //   468: ireturn
    //   469: astore #10
    //   471: aload #8
    //   473: astore #9
    //   475: aload #10
    //   477: astore #8
    //   479: aload #9
    //   481: ifnull -> 499
    //   484: aload #9
    //   486: invokevirtual close : ()V
    //   489: goto -> 499
    //   492: astore #9
    //   494: aload #9
    //   496: invokevirtual printStackTrace : ()V
    //   499: aload #8
    //   501: athrow
    // Exception table:
    //   from	to	target	type
    //   17	87	434	java/io/UnsupportedEncodingException
    //   17	87	404	java/io/FileNotFoundException
    //   17	87	374	java/io/IOException
    //   17	87	366	finally
    //   100	107	361	java/io/UnsupportedEncodingException
    //   100	107	356	java/io/FileNotFoundException
    //   100	107	351	java/io/IOException
    //   100	107	469	finally
    //   125	136	361	java/io/UnsupportedEncodingException
    //   125	136	356	java/io/FileNotFoundException
    //   125	136	351	java/io/IOException
    //   125	136	469	finally
    //   149	160	361	java/io/UnsupportedEncodingException
    //   149	160	356	java/io/FileNotFoundException
    //   149	160	351	java/io/IOException
    //   149	160	469	finally
    //   173	194	361	java/io/UnsupportedEncodingException
    //   173	194	356	java/io/FileNotFoundException
    //   173	194	351	java/io/IOException
    //   173	194	469	finally
    //   210	217	361	java/io/UnsupportedEncodingException
    //   210	217	356	java/io/FileNotFoundException
    //   210	217	351	java/io/IOException
    //   210	217	469	finally
    //   228	238	361	java/io/UnsupportedEncodingException
    //   228	238	356	java/io/FileNotFoundException
    //   228	238	351	java/io/IOException
    //   228	238	469	finally
    //   249	258	361	java/io/UnsupportedEncodingException
    //   249	258	356	java/io/FileNotFoundException
    //   249	258	351	java/io/IOException
    //   249	258	469	finally
    //   271	288	361	java/io/UnsupportedEncodingException
    //   271	288	356	java/io/FileNotFoundException
    //   271	288	351	java/io/IOException
    //   271	288	469	finally
    //   304	317	361	java/io/UnsupportedEncodingException
    //   304	317	356	java/io/FileNotFoundException
    //   304	317	351	java/io/IOException
    //   304	317	469	finally
    //   335	340	342	java/io/IOException
    //   383	388	469	finally
    //   397	402	342	java/io/IOException
    //   413	418	469	finally
    //   427	432	342	java/io/IOException
    //   443	448	469	finally
    //   459	464	342	java/io/IOException
    //   484	489	492	java/io/IOException
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\crashreport\common\info\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */