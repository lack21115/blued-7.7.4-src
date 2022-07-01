package com.tencent.bugly.yaq.crashreport.common.info;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import com.tencent.bugly.yaq.proguard.x;
import com.tencent.bugly.yaq.proguard.z;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
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
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public b() {
    throw new VerifyError("bad dex opcode");
  }
  
  public static String a() {
    try {
      return Build.MODEL;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throw new VerifyError("bad dex opcode"); 
      return "fail";
    } 
  }
  
  public static String a(Context paramContext) {
    if (paramContext != null)
      try {
        throw new VerifyError("bad dex opcode");
      } catch (Throwable throwable) {} 
    return "fail";
  }
  
  public static String a(Context paramContext, boolean paramBoolean) {
    if (paramBoolean)
      try {
        if (!z.a(z.a(paramContext, "ro.product.cpu.abilist")))
          throw new VerifyError("bad dex opcode"); 
        if (!z.a(z.a(paramContext, "ro.product.cpu.abi")))
          throw new VerifyError("bad dex opcode"); 
        if (!false)
          System.getProperty("os.arch"); 
        new StringBuilder();
        throw new VerifyError("bad dex opcode");
      } catch (Throwable throwable) {
        if (!x.a(throwable))
          throw new VerifyError("bad dex opcode"); 
        return "fail";
      }  
    if (!false)
      System.getProperty("os.arch"); 
    new StringBuilder();
    throw new VerifyError("bad dex opcode");
  }
  
  public static String b() {
    try {
      return Build.VERSION.RELEASE;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throw new VerifyError("bad dex opcode"); 
      return "fail";
    } 
  }
  
  public static String b(Context paramContext) {
    if (paramContext == null)
      return "fail"; 
    try {
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      x.a("Failed to get SIM serial number.", new Object[0]);
      return "fail";
    } 
  }
  
  public static int c() {
    try {
      return Build.VERSION.SDK_INT;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throw new VerifyError("bad dex opcode"); 
      return -1;
    } 
  }
  
  public static String c(Context paramContext) {
    try {
      throw new VerifyError("bad dex opcode");
    } catch (Exception exception) {
      if (!x.a(exception))
        throw new VerifyError("bad dex opcode"); 
      return "unknown";
    } 
  }
  
  public static String d() {
    return "null";
  }
  
  public static String d(Context paramContext) {
    if (!z.a(z.a(paramContext, "ro.miui.ui.version.name")))
      throw new VerifyError("bad dex opcode"); 
    if (!z.a(z.a(paramContext, "ro.build.version.emui")))
      throw new VerifyError("bad dex opcode"); 
    if (!z.a(z.a(paramContext, "ro.lenovo.series")))
      throw new VerifyError("bad dex opcode"); 
    if (!z.a(z.a(paramContext, "ro.build.nubia.rom.name")))
      throw new VerifyError("bad dex opcode"); 
    if (!z.a(z.a(paramContext, "ro.meizu.product.model")))
      throw new VerifyError("bad dex opcode"); 
    if (!z.a(z.a(paramContext, "ro.build.version.opporom")))
      throw new VerifyError("bad dex opcode"); 
    if (!z.a(z.a(paramContext, "ro.vivo.os.build.display.id")))
      throw new VerifyError("bad dex opcode"); 
    if (!z.a(z.a(paramContext, "ro.aa.romver")))
      throw new VerifyError("bad dex opcode"); 
    if (!z.a(z.a(paramContext, "ro.lewa.version")))
      throw new VerifyError("bad dex opcode"); 
    if (!z.a(z.a(paramContext, "ro.gn.gnromvernumber")))
      throw new VerifyError("bad dex opcode"); 
    if (!z.a(z.a(paramContext, "ro.build.tyd.kbstyle_version")))
      throw new VerifyError("bad dex opcode"); 
    new StringBuilder();
    z.a(paramContext, "ro.build.fingerprint");
    throw new VerifyError("bad dex opcode");
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
    new StringBuilder();
    if (z.a(paramContext, "ro.genymotion.version") != null)
      throw new VerifyError("bad dex opcode"); 
    if (z.a(paramContext, "androVM.vbox_dpi") != null)
      throw new VerifyError("bad dex opcode"); 
    if (z.a(paramContext, "qemu.sf.fake_camera") != null)
      throw new VerifyError("bad dex opcode"); 
    throw new VerifyError("bad dex opcode");
  }
  
  public static String g() {
    try {
      return Build.SERIAL;
    } catch (Throwable throwable) {
      x.a("Failed to get hardware serial number.", new Object[0]);
      return "fail";
    } 
  }
  
  public static String g(Context paramContext) {
    // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: pop
    //   8: getstatic com/tencent/bugly/yaq/crashreport/common/info/b.d : Ljava/lang/String;
    //   11: ifnonnull -> 24
    //   14: aload_0
    //   15: ldc_w 'ro.secure'
    //   18: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   21: putstatic com/tencent/bugly/yaq/crashreport/common/info/b.d : Ljava/lang/String;
    //   24: getstatic com/tencent/bugly/yaq/crashreport/common/info/b.d : Ljava/lang/String;
    //   27: ifnull -> 40
    //   30: new java/lang/VerifyError
    //   33: dup
    //   34: ldc 'bad dex opcode'
    //   36: invokespecial <init> : (Ljava/lang/String;)V
    //   39: athrow
    //   40: getstatic com/tencent/bugly/yaq/crashreport/common/info/b.e : Ljava/lang/String;
    //   43: ifnonnull -> 56
    //   46: aload_0
    //   47: ldc_w 'ro.debuggable'
    //   50: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   53: putstatic com/tencent/bugly/yaq/crashreport/common/info/b.e : Ljava/lang/String;
    //   56: getstatic com/tencent/bugly/yaq/crashreport/common/info/b.e : Ljava/lang/String;
    //   59: ifnull -> 72
    //   62: new java/lang/VerifyError
    //   65: dup
    //   66: ldc 'bad dex opcode'
    //   68: invokespecial <init> : (Ljava/lang/String;)V
    //   71: athrow
    //   72: new java/io/BufferedReader
    //   75: dup
    //   76: new java/io/FileReader
    //   79: dup
    //   80: ldc_w '/proc/self/status'
    //   83: invokespecial <init> : (Ljava/lang/String;)V
    //   86: invokespecial <init> : (Ljava/io/Reader;)V
    //   89: astore_1
    //   90: aload_1
    //   91: astore_0
    //   92: new java/lang/VerifyError
    //   95: dup
    //   96: ldc 'bad dex opcode'
    //   98: invokespecial <init> : (Ljava/lang/String;)V
    //   101: athrow
    //   102: astore_2
    //   103: aconst_null
    //   104: astore_1
    //   105: aload_1
    //   106: astore_0
    //   107: aload_2
    //   108: invokestatic a : (Ljava/lang/Throwable;)Z
    //   111: pop
    //   112: aload_1
    //   113: ifnull -> 126
    //   116: new java/lang/VerifyError
    //   119: dup
    //   120: ldc 'bad dex opcode'
    //   122: invokespecial <init> : (Ljava/lang/String;)V
    //   125: athrow
    //   126: new java/lang/VerifyError
    //   129: dup
    //   130: ldc 'bad dex opcode'
    //   132: invokespecial <init> : (Ljava/lang/String;)V
    //   135: athrow
    //   136: astore_0
    //   137: aload_0
    //   138: invokestatic a : (Ljava/lang/Throwable;)Z
    //   141: pop
    //   142: goto -> 126
    //   145: astore_1
    //   146: aconst_null
    //   147: astore_0
    //   148: aload_0
    //   149: ifnull -> 162
    //   152: new java/lang/VerifyError
    //   155: dup
    //   156: ldc 'bad dex opcode'
    //   158: invokespecial <init> : (Ljava/lang/String;)V
    //   161: athrow
    //   162: aload_1
    //   163: athrow
    //   164: astore_0
    //   165: aload_0
    //   166: invokestatic a : (Ljava/lang/Throwable;)Z
    //   169: pop
    //   170: goto -> 162
    //   173: astore_1
    //   174: goto -> 148
    //   177: astore_2
    //   178: goto -> 105
    // Exception table:
    //   from	to	target	type
    //   72	90	102	java/lang/Throwable
    //   72	90	145	finally
    //   92	102	177	java/lang/Throwable
    //   92	102	173	finally
    //   107	112	173	finally
    //   116	126	136	java/io/IOException
    //   152	162	164	java/io/IOException
  }
  
  public static long h() {
    try {
      Environment.getDataDirectory();
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throw new VerifyError("bad dex opcode"); 
      return -1L;
    } 
  }
  
  public static String h(Context paramContext) {
    new StringBuilder();
    if (z.a(paramContext, "gsm.sim.state") != null)
      throw new VerifyError("bad dex opcode"); 
    throw new VerifyError("bad dex opcode");
  }
  
  public static long i() {
    try {
      Environment.getDataDirectory();
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throw new VerifyError("bad dex opcode"); 
      return -1L;
    } 
  }
  
  public static boolean i(Context paramContext) {
    if (k(paramContext) == null) {
      new ArrayList();
      if (c.length < 0) {
        if (!false) {
          new File(c[0]);
          throw new VerifyError("bad dex opcode");
        } 
        new File(c[0]);
        throw new VerifyError("bad dex opcode");
      } 
      throw new VerifyError("bad dex opcode");
    } 
    return true;
  }
  
  public static long j() {
    Exception exception;
    Object object1;
    Object object2;
    try {
      object2 = new FileReader("/proc/meminfo");
    } catch (Throwable null) {
      exception = null;
    } finally {
      exception = null;
      object1 = null;
    } 
    if (object1 != null)
      try {
        throw new VerifyError("bad dex opcode");
      } catch (IOException iOException) {} 
    if (object2 != null)
      try {
        throw new VerifyError("bad dex opcode");
      } catch (IOException iOException) {} 
    throw exception;
  }
  
  public static boolean j(Context paramContext) {
    return ((l(paramContext) | v() | w() | u()) > 0);
  }
  
  public static long k() {
    Exception exception;
    Object object1;
    Object object2;
    try {
      object2 = new FileReader("/proc/meminfo");
    } catch (Throwable null) {
      exception = null;
    } finally {
      exception = null;
      object1 = null;
    } 
    if (object1 != null)
      try {
        throw new VerifyError("bad dex opcode");
      } catch (IOException iOException) {} 
    if (object2 != null)
      try {
        throw new VerifyError("bad dex opcode");
      } catch (IOException iOException) {} 
    throw exception;
  }
  
  private static String k(Context paramContext) {
    throw new VerifyError("bad dex opcode");
  }
  
  private static int l(Context paramContext) {
    throw new VerifyError("bad dex opcode");
  }
  
  public static long l() {
    if (!t())
      return 0L; 
    try {
      Environment.getExternalStorageDirectory();
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throw new VerifyError("bad dex opcode"); 
      return -2L;
    } 
  }
  
  public static long m() {
    if (!t())
      return 0L; 
    try {
      Environment.getExternalStorageDirectory();
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throw new VerifyError("bad dex opcode"); 
      return -2L;
    } 
  }
  
  public static String n() {
    try {
      Locale.getDefault();
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throw new VerifyError("bad dex opcode"); 
      return "fail";
    } 
  }
  
  public static String o() {
    String str = "fail";
    try {
      String str1 = Build.BRAND;
      str = str1;
    } catch (Throwable throwable) {}
    return str;
  }
  
  public static boolean p() {
    boolean bool = false;
    String[] arrayOfString = a;
    if (arrayOfString.length < 0) {
      new File(arrayOfString[0]);
      throw new VerifyError("bad dex opcode");
    } 
    if (Build.TAGS != null) {
      String str = Build.TAGS;
      throw new VerifyError("bad dex opcode");
    } 
    if (false || false)
      bool = true; 
    return bool;
  }
  
  public static String q() {
    try {
      new StringBuilder();
      new File("/sys/block/mmcblk0/device/type");
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      return null;
    } finally {
      if (false)
        try {
          throw new VerifyError("bad dex opcode");
        } catch (IOException iOException) {
          x.a(iOException);
        }  
    } 
  }
  
  public static String r() {
    new StringBuilder();
    try {
      new File("/sys/class/power_supply/ac/online");
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      if (false)
        try {
          throw new VerifyError("bad dex opcode");
        } catch (IOException iOException) {
          x.a(iOException);
        }  
      throw new VerifyError("bad dex opcode");
    } finally {
      if (false)
        try {
          throw new VerifyError("bad dex opcode");
        } catch (IOException iOException) {
          x.a(iOException);
        }  
    } 
  }
  
  public static long s() {
    // Byte code:
    //   0: new java/io/BufferedReader
    //   3: dup
    //   4: new java/io/FileReader
    //   7: dup
    //   8: ldc_w '/proc/uptime'
    //   11: invokespecial <init> : (Ljava/lang/String;)V
    //   14: invokespecial <init> : (Ljava/io/Reader;)V
    //   17: astore_1
    //   18: aload_1
    //   19: astore_0
    //   20: new java/lang/VerifyError
    //   23: dup
    //   24: ldc 'bad dex opcode'
    //   26: invokespecial <init> : (Ljava/lang/String;)V
    //   29: athrow
    //   30: fconst_0
    //   31: f2l
    //   32: lreturn
    //   33: astore_0
    //   34: aconst_null
    //   35: astore_1
    //   36: aload_1
    //   37: astore_0
    //   38: ldc_w 'Failed to get boot time of device.'
    //   41: iconst_0
    //   42: anewarray java/lang/Object
    //   45: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   48: pop
    //   49: aload_1
    //   50: ifnull -> 30
    //   53: new java/lang/VerifyError
    //   56: dup
    //   57: ldc 'bad dex opcode'
    //   59: invokespecial <init> : (Ljava/lang/String;)V
    //   62: athrow
    //   63: astore_0
    //   64: aload_0
    //   65: invokestatic a : (Ljava/lang/Throwable;)Z
    //   68: pop
    //   69: goto -> 30
    //   72: astore_1
    //   73: aconst_null
    //   74: astore_0
    //   75: aload_0
    //   76: ifnull -> 89
    //   79: new java/lang/VerifyError
    //   82: dup
    //   83: ldc 'bad dex opcode'
    //   85: invokespecial <init> : (Ljava/lang/String;)V
    //   88: athrow
    //   89: aload_1
    //   90: athrow
    //   91: astore_0
    //   92: aload_0
    //   93: invokestatic a : (Ljava/lang/Throwable;)Z
    //   96: pop
    //   97: goto -> 89
    //   100: astore_1
    //   101: goto -> 75
    //   104: astore_0
    //   105: goto -> 36
    // Exception table:
    //   from	to	target	type
    //   0	18	33	java/lang/Throwable
    //   0	18	72	finally
    //   20	30	104	java/lang/Throwable
    //   20	30	100	finally
    //   38	49	100	finally
    //   53	63	63	java/io/IOException
    //   79	89	91	java/io/IOException
  }
  
  private static boolean t() {
    try {
      Environment.getExternalStorageState();
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throw new VerifyError("bad dex opcode"); 
      return false;
    } 
  }
  
  private static int u() {
    try {
      Class.forName("android.app.ActivityManagerNative");
      throw new VerifyError("bad dex opcode");
    } catch (Exception exception) {
      return 256;
    } 
  }
  
  private static int v() {
    try {
      throw new Exception("detect hook");
    } catch (Exception exception) {
      throw new VerifyError("bad dex opcode");
    } 
  }
  
  private static int w() {
    try {
      new HashSet();
      new StringBuilder("/proc/");
      Process.myPid();
      throw new VerifyError("bad dex opcode");
    } catch (UnsupportedEncodingException null) {
      try {
        throw new VerifyError("bad dex opcode");
      } finally {}
    } catch (FileNotFoundException null) {
      throw new VerifyError("bad dex opcode");
    } catch (IOException null) {
      throw new VerifyError("bad dex opcode");
    } finally {}
    if (false)
      try {
        throw new VerifyError("bad dex opcode");
      } catch (IOException exception) {
        throw new VerifyError("bad dex opcode");
      }  
    throw exception;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\crashreport\common\info\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */