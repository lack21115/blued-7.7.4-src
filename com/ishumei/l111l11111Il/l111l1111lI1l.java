package com.ishumei.l111l11111Il;

import android.os.Build;
import java.io.File;
import java.util.Locale;

public final class l111l1111lI1l {
  private static String l1111l111111Il = "sm";
  
  private static final String[] l111l11111I1l;
  
  private static final String[] l111l11111Il;
  
  private static final String[] l111l11111lIl = new String[] { "/dev/socket/qemud", "/dev/qemu_pipe" };
  
  private static final String[] l111l1111l1Il;
  
  private static final String[] l111l1111lI1l;
  
  private static final String[] l111l1111llIl;
  
  static {
    l111l11111I1l = new String[] { "goldfish" };
    l111l11111Il = new String[] { "/sys/qemu_trace", "/system/bin/qemu-props" };
    l111l1111l1Il = new String[] { "000000000000000" };
  }
  
  private static int l1111l111111Il(boolean paramBoolean) {
    return paramBoolean ? 1 : 0;
  }
  
  public static String l1111l111111Il() {
    l11l1111I1ll l11l1111I1ll = new l11l1111I1ll();
    Locale locale = Locale.CHINA;
    int i = l1111l111111Il(l111l11111lIl());
    boolean bool = false;
    int j = l1111l111111Il(l111l11111I1l());
    int k = l1111l111111Il(l111l11111Il());
    int m = l1111l111111Il(false);
    int n = l1111l111111Il(l1111l111111Il(l11l1111I1ll));
    String str1 = Build.BOARD;
    String str2 = Build.BOOTLOADER;
    String str3 = Build.BRAND;
    String str4 = Build.DEVICE;
    String str5 = Build.HARDWARE;
    String str6 = Build.MODEL;
    String str7 = Build.PRODUCT;
    if ("unknown".equals(str1) || "unknown".equals(str2) || "generic".equals(str3) || "generic".equals(str4) || "sdk".equals(str6) || "sdk".equals(str7) || "goldfish".equals(str5))
      bool = true; 
    return String.format(locale, "%d%d%d%d%d%d%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(l1111l111111Il(bool)), Integer.valueOf(l1111l111111Il(l111l11111lIl(l11l1111I1ll))) });
  }
  
  private static boolean l1111l111111Il(l11l1111I1ll paraml11l1111I1ll) {
    try {
      String str = paraml11l1111I1ll.l1111l111111Il();
      String[] arrayOfString = l111l1111l1Il;
      for (int i = 0; i; i++) {
        boolean bool = arrayOfString[0].equalsIgnoreCase(str);
        if (bool)
          return true; 
      } 
      return false;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  private static boolean l111l11111I1l() {
    try {
      File file = new File("/proc/tty/drivers");
      return false;
    } finally {
      Exception exception = null;
    } 
  }
  
  private static boolean l111l11111Il() {
    try {
      String[] arrayOfString = l111l11111Il;
      for (int i = 0; i < 2; i++) {
        boolean bool = (new File(arrayOfString[i])).exists();
        if (bool)
          return true; 
      } 
      return false;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  private static boolean l111l11111lIl() {
    try {
      String[] arrayOfString = l111l11111lIl;
      for (int i = 0; i < 2; i++) {
        boolean bool = (new File(arrayOfString[i])).exists();
        if (bool)
          return true; 
      } 
      return false;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  private static boolean l111l11111lIl(l11l1111I1ll paraml11l1111I1ll) {
    try {
      return paraml11l1111I1ll.l111l11111lIl().toLowerCase().equals("android");
    } catch (Exception exception) {
      return false;
    } 
  }
  
  private static boolean l111l1111l1Il() {
    return false;
  }
  
  private static boolean l111l1111llIl() {
    String str1 = Build.BOARD;
    String str2 = Build.BOOTLOADER;
    String str3 = Build.BRAND;
    String str4 = Build.DEVICE;
    String str5 = Build.HARDWARE;
    String str6 = Build.MODEL;
    String str7 = Build.PRODUCT;
    return ("unknown".equals(str1) || "unknown".equals(str2) || "generic".equals(str3) || "generic".equals(str4) || "sdk".equals(str6) || "sdk".equals(str7) || "goldfish".equals(str5));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111Il\l111l1111lI1l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */