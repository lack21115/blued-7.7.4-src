package com.ishumei.l111l11111Il;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.ishumei.l1111l111111Il.l111l11111lIl;
import java.util.Locale;

public final class l111l1111llIl {
  public static String l1111l111111Il() {
    boolean bool1;
    Context context = com.ishumei.l1111l111111Il.l111l1111llIl.l1111l111111Il.l111l11111Il;
    if (context == null)
      return ""; 
    try {
      DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
      bool1 = displayMetrics.widthPixels;
      try {
        int i = displayMetrics.heightPixels;
        try {
          int j = displayMetrics.densityDpi;
          return String.format(Locale.CHINA, "%d,%d,%d", new Object[] { Integer.valueOf(bool1), Integer.valueOf(i), Integer.valueOf(j) });
        } catch (Exception exception) {}
        boolean bool = false;
        return String.format(Locale.CHINA, "%d,%d,%d", new Object[] { Integer.valueOf(bool1), Integer.valueOf(i), Integer.valueOf(bool) });
      } catch (Exception exception) {}
    } catch (Exception exception) {
      bool1 = false;
    } 
    boolean bool2 = false;
    boolean bool3 = false;
    return String.format(Locale.CHINA, "%d,%d,%d", new Object[] { Integer.valueOf(bool1), Integer.valueOf(bool2), Integer.valueOf(bool3) });
  }
  
  public static void l1111l111111Il(l111l11111lIl paraml111l11111lIl) {
    try {
      if (Build.VERSION.SDK_INT >= 18) {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        paraml111l11111lIl.l111l1111l1Il(Long.valueOf(statFs.getAvailableBytes()));
        paraml111l11111lIl.l111l1111llIl(Long.valueOf(statFs.getFreeBytes()));
        paraml111l11111lIl.l111l1111lI1l(Long.valueOf(statFs.getTotalBytes()));
      } 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static int l111l11111I1l() {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static String l111l11111lIl() {
    boolean bool1;
    Context context = com.ishumei.l1111l111111Il.l111l1111llIl.l1111l111111Il.l111l11111Il;
    if (context == null)
      return ""; 
    try {
      DisplayMetrics displayMetrics = new DisplayMetrics();
      ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
      bool1 = displayMetrics.widthPixels;
      try {
        int i = displayMetrics.heightPixels;
        return String.format(Locale.CHINA, "%d,%d", new Object[] { Integer.valueOf(bool1), Integer.valueOf(i) });
      } catch (Exception exception) {}
    } catch (Exception exception) {
      bool1 = false;
    } 
    boolean bool2 = false;
    return String.format(Locale.CHINA, "%d,%d", new Object[] { Integer.valueOf(bool1), Integer.valueOf(bool2) });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111Il\l111l1111llIl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */