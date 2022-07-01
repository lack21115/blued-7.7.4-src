package com.amap.api.mapcore2d;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;

public final class gx {
  public static int a(Context paramContext, String paramString1, String paramString2) {
    try {
      return paramContext.getSharedPreferences(paramString1, 0).getInt(paramString2, 200);
    } finally {
      paramContext = null;
      gu.a((Throwable)paramContext, "SpUtil", "getPrefsInt");
    } 
  }
  
  public static String a(Context paramContext) {
    return (paramContext == null) ? "00:00:00:00:00:00" : b(paramContext, "pref", "smac", "00:00:00:00:00:00");
  }
  
  public static void a(Context paramContext, String paramString) {
    if (paramContext == null)
      return; 
    if (TextUtils.isEmpty(paramString))
      return; 
    a(paramContext, "pref", "smac", paramString);
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    try {
      SharedPreferences.Editor editor = paramContext.getSharedPreferences(paramString1, 0).edit();
      return;
    } finally {
      paramContext = null;
      gu.a((Throwable)paramContext, "SpUtil", "setPrefsStr");
    } 
  }
  
  private static void a(SharedPreferences.Editor paramEditor) {
    if (paramEditor == null)
      return; 
    if (Build.VERSION.SDK_INT >= 9) {
      paramEditor.apply();
      return;
    } 
    b(paramEditor);
  }
  
  private static String b(Context paramContext, String paramString1, String paramString2, String paramString3) {
    try {
      return paramContext.getSharedPreferences(paramString1, 0).getString(paramString2, paramString3);
    } finally {
      paramContext = null;
      gu.a((Throwable)paramContext, "SpUtil", "getPrefsInt");
    } 
  }
  
  private static void b(SharedPreferences.Editor paramEditor) {
    try {
      return;
    } finally {
      paramEditor = null;
      gu.a((Throwable)paramEditor, "SpUtil", "commit1");
    } 
  }
  
  public static boolean b(Context paramContext, String paramString1, String paramString2) {
    try {
      return paramContext.getSharedPreferences(paramString1, 0).getBoolean(paramString2, true);
    } finally {
      paramContext = null;
      gu.a((Throwable)paramContext, "SpUtil", "getPrefsBoolean");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\gx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */