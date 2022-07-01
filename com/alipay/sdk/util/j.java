package com.alipay.sdk.util;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.alipay.sdk.app.statistic.a;
import com.alipay.sdk.encrypt.f;
import com.alipay.sdk.sys.a;

public class j {
  private static String a;
  
  private static String a(Context paramContext) {
    if (TextUtils.isEmpty(a)) {
      String str;
      StringBuilder stringBuilder;
      try {
        str = paramContext.getApplicationContext().getPackageName();
      } finally {
        paramContext = null;
        c.a((Throwable)paramContext);
      } 
      stringBuilder.append("0000000000000000000000000000");
      a = stringBuilder.toString().substring(0, 24);
    } 
    return a;
  }
  
  public static void a(a parama, Context paramContext, String paramString1, String paramString2) {
    try {
      String str = f.a(a(paramContext), paramString2, paramString1);
      return;
    } finally {
      parama = null;
      c.a((Throwable)parama);
    } 
  }
  
  public static boolean a(Context paramContext, String paramString) {
    try {
      return PreferenceManager.getDefaultSharedPreferences(paramContext).contains(paramString);
    } finally {
      paramContext = null;
      c.a((Throwable)paramContext);
    } 
  }
  
  public static String b(a parama, Context paramContext, String paramString1, String paramString2) {
    String str1;
    String str3 = null;
    String str4 = null;
    String str2 = str3;
    try {
      String str = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString1, paramString2);
      paramString2 = str4;
      str2 = str3;
      if (!TextUtils.isEmpty(str)) {
        str2 = str3;
        paramString2 = f.b(a(paramContext), str, paramString1);
      } 
      str2 = paramString2;
      str1 = paramString2;
      if (!TextUtils.isEmpty(str)) {
        str2 = paramString2;
        str1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          str2 = paramString2;
          a.a(parama, "cp", "TriDesEncryptError", String.format("%s,%s", new Object[] { paramString1, str }));
          return paramString2;
        } 
      } 
    } catch (Exception exception) {
      c.a(exception);
      str1 = str2;
    } 
    return str1;
  }
  
  public static void b(Context paramContext, String paramString) {
    try {
      return;
    } finally {
      paramContext = null;
      c.a((Throwable)paramContext);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sd\\util\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */