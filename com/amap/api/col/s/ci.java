package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import java.util.Arrays;

public final class ci {
  static byte[] a;
  
  static byte[] b;
  
  private String c;
  
  public ci(String paramString) {
    String str = paramString;
    if (TextUtils.isDigitsOnly(paramString))
      str = "SPUtil"; 
    this.c = bq.a(str);
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2, int paramInt) {
    try {
      return paramContext.getSharedPreferences(paramString1, 0).getInt(paramString2, paramInt);
    } finally {
      paramContext = null;
      cg.c((Throwable)paramContext, "csp", "giv");
    } 
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    if (paramContext != null && !TextUtils.isEmpty(paramString2)) {
      if (TextUtils.isEmpty(paramString3))
        return; 
      try {
        SharedPreferences.Editor editor = paramContext.getSharedPreferences(paramString1, 0).edit();
        editor.putString(paramString2, bs.g(a(paramContext, bs.a(paramString3))));
        return;
      } finally {
        paramContext = null;
      } 
    } 
  }
  
  public static void a(SharedPreferences.Editor paramEditor) {
    if (paramEditor == null)
      return; 
    try {
      return;
    } finally {
      paramEditor = null;
      cd.a((Throwable)paramEditor, "sp", "cm");
    } 
  }
  
  public static void a(SharedPreferences.Editor paramEditor, String paramString) {
    if (paramEditor != null)
      try {
        if (TextUtils.isEmpty(paramString))
          return; 
        return;
      } finally {
        paramEditor = null;
      }  
  }
  
  public static void a(SharedPreferences.Editor paramEditor, String paramString, int paramInt) {
    try {
      return;
    } finally {
      paramEditor = null;
      cg.c((Throwable)paramEditor, "csp", "putPrefsInt");
    } 
  }
  
  public static void a(SharedPreferences.Editor paramEditor, String paramString, long paramLong) {
    if (paramEditor != null) {
      if (TextUtils.isEmpty(paramString))
        return; 
      try {
        return;
      } finally {
        paramEditor = null;
      } 
    } 
  }
  
  public static void a(SharedPreferences.Editor paramEditor, String paramString1, String paramString2) {
    if (paramEditor != null)
      try {
        if (!TextUtils.isEmpty(paramString1)) {
          if (TextUtils.isEmpty(paramString2))
            return; 
          return;
        } 
      } finally {
        paramEditor = null;
      }  
  }
  
  public static void a(SharedPreferences.Editor paramEditor, String paramString, boolean paramBoolean) {
    try {
      return;
    } finally {
      paramEditor = null;
      cg.c((Throwable)paramEditor, "csp", "setPrefsStr");
    } 
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean) {
    try {
      return paramContext.getSharedPreferences(paramString1, 0).getBoolean(paramString2, paramBoolean);
    } finally {
      paramContext = null;
      cg.c((Throwable)paramContext, "csp", "gbv");
    } 
  }
  
  private static byte[] a(Context paramContext) {
    if (paramContext == null)
      return new byte[0]; 
    byte[] arrayOfByte2 = a;
    if (arrayOfByte2 != null && arrayOfByte2.length > 0)
      return arrayOfByte2; 
    byte[] arrayOfByte1 = bi.f(paramContext).getBytes();
    a = arrayOfByte1;
    return arrayOfByte1;
  }
  
  private static byte[] a(Context paramContext, byte[] paramArrayOfbyte) {
    try {
      return bn.b(a(paramContext), paramArrayOfbyte, b(paramContext));
    } finally {
      paramContext = null;
    } 
  }
  
  public static SharedPreferences.Editor b(Context paramContext, String paramString) {
    if (paramContext != null)
      try {
        return TextUtils.isEmpty(paramString) ? null : paramContext.getSharedPreferences(paramString, 0).edit();
      } finally {
        paramContext = null;
      }  
    return null;
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2) {
    if (paramContext == null)
      return ""; 
    try {
      return bs.a(b(paramContext, bs.d(paramContext.getSharedPreferences(paramString1, 0).getString(paramString2, ""))));
    } finally {
      paramContext = null;
    } 
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2, String paramString3) {
    if (paramContext == null)
      return null; 
    try {
      return paramContext.getSharedPreferences(paramString1, 0).getString(paramString2, paramString3);
    } finally {
      paramContext = null;
      cg.c((Throwable)paramContext, "csp", "gsv");
    } 
  }
  
  private static byte[] b(Context paramContext) {
    byte[] arrayOfByte = b;
    if (arrayOfByte != null && arrayOfByte.length > 0)
      return arrayOfByte; 
    int j = Build.VERSION.SDK_INT;
    int i = 0;
    if (j >= 9) {
      b = Arrays.copyOfRange(a(paramContext), 0, (a(paramContext)).length / 2);
    } else {
      b = new byte[(a(paramContext)).length / 2];
      while (true) {
        arrayOfByte = b;
        if (i < arrayOfByte.length) {
          arrayOfByte[i] = a(paramContext)[i];
          i++;
          continue;
        } 
        break;
      } 
    } 
    return b;
  }
  
  private static byte[] b(Context paramContext, byte[] paramArrayOfbyte) {
    try {
      return bn.a(a(paramContext), paramArrayOfbyte, b(paramContext));
    } catch (Exception exception) {
      return new byte[0];
    } 
  }
  
  public static long c(Context paramContext, String paramString1, String paramString2) {
    try {
      return paramContext.getSharedPreferences(paramString1, 0).getLong(paramString2, 0L);
    } finally {
      paramContext = null;
      cg.c((Throwable)paramContext, "csp", "glv");
    } 
  }
  
  public final String a(Context paramContext, String paramString) {
    return (paramContext == null) ? "" : b(paramContext, this.c, paramString);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2) {
    if (paramContext != null && !TextUtils.isEmpty(paramString1)) {
      if (TextUtils.isEmpty(paramString2))
        return; 
      a(paramContext, this.c, paramString1, paramString2);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */