package com.loc;

import android.content.Context;
import android.content.SharedPreferences;

public final class eo {
  public static int a(Context paramContext, String paramString1, String paramString2, int paramInt) {
    try {
      return paramContext.getSharedPreferences(paramString1, 0).getInt(paramString2, paramInt);
    } finally {
      paramContext = null;
      ej.a((Throwable)paramContext, "SpUtil", "getPrefsInt");
    } 
  }
  
  public static long a(Context paramContext, String paramString1, String paramString2, long paramLong) {
    try {
      return paramContext.getSharedPreferences(paramString1, 0).getLong(paramString2, paramLong);
    } finally {
      paramContext = null;
      ej.a((Throwable)paramContext, "SpUtil", "getPrefsLong");
    } 
  }
  
  public static SharedPreferences.Editor a(Context paramContext, String paramString) {
    return paramContext.getSharedPreferences(paramString, 0).edit();
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    try {
      return paramContext.getSharedPreferences(paramString1, 0).getString(paramString2, paramString3);
    } finally {
      paramContext = null;
      ej.a((Throwable)paramContext, "SpUtil", "getPrefsInt");
    } 
  }
  
  public static void a(SharedPreferences.Editor paramEditor) {
    if (paramEditor == null)
      return; 
    paramEditor.apply();
  }
  
  public static void a(SharedPreferences.Editor paramEditor, String paramString) {
    try {
      return;
    } finally {
      paramEditor = null;
      ej.a((Throwable)paramEditor, "SpUtil", "setPrefsLong");
    } 
  }
  
  public static void a(SharedPreferences.Editor paramEditor, String paramString, int paramInt) {
    try {
      return;
    } finally {
      paramEditor = null;
      ej.a((Throwable)paramEditor, "SpUtil", "setPrefsInt");
    } 
  }
  
  public static void a(SharedPreferences.Editor paramEditor, String paramString, long paramLong) {
    try {
      return;
    } finally {
      paramEditor = null;
      ej.a((Throwable)paramEditor, "SpUtil", "setPrefsLong");
    } 
  }
  
  public static void a(SharedPreferences.Editor paramEditor, String paramString1, String paramString2) {
    try {
      return;
    } finally {
      paramEditor = null;
      ej.a((Throwable)paramEditor, "SpUtil", "setPrefsStr");
    } 
  }
  
  public static void a(SharedPreferences.Editor paramEditor, String paramString, boolean paramBoolean) {
    try {
      return;
    } finally {
      paramEditor = null;
      ej.a((Throwable)paramEditor, "SpUtil", "updatePrefsBoolean");
    } 
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean) {
    try {
      return paramContext.getSharedPreferences(paramString1, 0).getBoolean(paramString2, paramBoolean);
    } finally {
      paramContext = null;
      ej.a((Throwable)paramContext, "SpUtil", "getPrefsBoolean");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\eo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */