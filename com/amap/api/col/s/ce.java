package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.RejectedExecutionException;

public final class ce {
  public static final String a = "/a/";
  
  static final String b = "b";
  
  static final String c = "c";
  
  static final String d = "d";
  
  public static String e = "s";
  
  public static final String f = "g";
  
  public static final String g = "h";
  
  public static final String h = "e";
  
  public static final String i = "f";
  
  public static final String j = "j";
  
  public static final String k = "k";
  
  private static long l;
  
  private static Vector<br> m = new Vector<br>();
  
  public static String a(Context paramContext, String paramString) {
    return paramContext.getSharedPreferences("AMSKLG_CFG", 0).getString(paramString, "");
  }
  
  static List<br> a() {
    try {
    
    } finally {
      Exception exception = null;
      exception.printStackTrace();
    } 
  }
  
  public static void a(Context paramContext) {
    try {
      if (System.currentTimeMillis() - l < 60000L)
        return; 
      l = System.currentTimeMillis();
      return;
    } finally {
      paramContext = null;
      cg.c((Throwable)paramContext, "Lg", "proL");
    } 
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2) {
    SharedPreferences.Editor editor = paramContext.getSharedPreferences("AMSKLG_CFG", 0).edit();
    editor.putString(paramString1, paramString2);
    editor.apply();
  }
  
  public static void a(br parambr) {
    // Byte code:
    //   0: invokestatic getMainLooper : ()Landroid/os/Looper;
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: aload_0
    //   7: ifnonnull -> 13
    //   10: aload_1
    //   11: monitorexit
    //   12: return
    //   13: getstatic com/amap/api/col/s/ce.m : Ljava/util/Vector;
    //   16: aload_0
    //   17: invokevirtual contains : (Ljava/lang/Object;)Z
    //   20: ifeq -> 26
    //   23: aload_1
    //   24: monitorexit
    //   25: return
    //   26: getstatic com/amap/api/col/s/ce.m : Ljava/util/Vector;
    //   29: aload_0
    //   30: invokevirtual add : (Ljava/lang/Object;)Z
    //   33: pop
    //   34: aload_1
    //   35: monitorexit
    //   36: return
    //   37: astore_0
    //   38: aload_1
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    //   42: astore_0
    //   43: return
    // Exception table:
    //   from	to	target	type
    //   0	6	42	finally
    //   10	12	37	finally
    //   13	25	37	finally
    //   26	36	37	finally
    //   38	40	37	finally
    //   40	42	42	finally
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
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */