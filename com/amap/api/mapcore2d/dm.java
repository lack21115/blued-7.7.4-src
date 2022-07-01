package com.amap.api.mapcore2d;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;

public class dm {
  public static final String a = "/a/";
  
  static final String b = "b";
  
  static final String c = "c";
  
  static final String d = "d";
  
  static final String e = "i";
  
  public static final String f = "g";
  
  public static final String g = "h";
  
  public static final String h = "e";
  
  public static final String i = "f";
  
  public static final String j = "j";
  
  public static String a(Context paramContext) {
    return c(paramContext, e);
  }
  
  public static String a(Context paramContext, String paramString) {
    return paramContext.getSharedPreferences("AMSKLG_CFG", 0).getString(paramString, "");
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2) {
    SharedPreferences.Editor editor = paramContext.getSharedPreferences("AMSKLG_CFG", 0).edit();
    editor.putString(paramString1, paramString2);
    editor.apply();
  }
  
  static boolean a(String paramString) {
    return TextUtils.isEmpty(paramString) ? false : (paramString.contains("uncaughtException"));
  }
  
  static boolean a(String[] paramArrayOfString, String paramString) {
    if (paramArrayOfString != null) {
      if (paramString == null)
        return false; 
      try {
        int i;
        String[] arrayOfString = paramString.split("\n");
        int j = arrayOfString.length;
      } finally {
        paramArrayOfString = null;
      } 
    } 
    return false;
  }
  
  public static void b(Context paramContext) {
    try {
      return;
    } finally {
      paramContext = null;
      do.c((Throwable)paramContext, "Lg", "proL");
    } 
  }
  
  public static void b(Context paramContext, String paramString) {
    SharedPreferences.Editor editor = paramContext.getSharedPreferences("AMSKLG_CFG", 0).edit();
    editor.remove(paramString);
    editor.apply();
  }
  
  static boolean b(String[] paramArrayOfString, String paramString) {
    if (paramArrayOfString != null) {
      if (paramString == null)
        return false; 
      try {
        int i;
        int j = paramArrayOfString.length;
      } finally {
        paramArrayOfString = null;
      } 
    } 
    return false;
  }
  
  public static String c(Context paramContext, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
    stringBuilder.append(a);
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
  
  static List<da> c(Context paramContext) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_3
    //   5: astore_1
    //   6: invokestatic getMainLooper : ()Landroid/os/Looper;
    //   9: astore #4
    //   11: aload_3
    //   12: astore_1
    //   13: aload #4
    //   15: monitorenter
    //   16: aload_2
    //   17: astore_1
    //   18: new com/amap/api/mapcore2d/dy
    //   21: dup
    //   22: aload_0
    //   23: iconst_0
    //   24: invokespecial <init> : (Landroid/content/Context;Z)V
    //   27: invokevirtual a : ()Ljava/util/List;
    //   30: astore_0
    //   31: aload_0
    //   32: astore_1
    //   33: aload #4
    //   35: monitorexit
    //   36: aload_0
    //   37: areturn
    //   38: astore_0
    //   39: aload #4
    //   41: monitorexit
    //   42: aload_0
    //   43: athrow
    //   44: astore_0
    //   45: aload_0
    //   46: invokevirtual printStackTrace : ()V
    //   49: aload_1
    //   50: areturn
    // Exception table:
    //   from	to	target	type
    //   6	11	44	finally
    //   13	16	44	finally
    //   18	31	38	finally
    //   33	36	38	finally
    //   39	42	38	finally
    //   42	44	44	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\dm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */