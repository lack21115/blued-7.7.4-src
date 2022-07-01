package com.datavisor.vangogh.e.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.datavisor.vangogh.bridge.crypto;
import com.datavisor.vangogh.f.d;

public class a {
  public static String a(Context paramContext, String paramString) {
    if (paramContext == null || com.datavisor.vangogh.f.a.a(paramString))
      return null; 
    try {
      return paramContext.getSharedPreferences("DV", 0).getString(paramString, "");
    } finally {
      paramContext = null;
    } 
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2) {
    if (paramContext != null && !com.datavisor.vangogh.f.a.a(paramString1)) {
      if (com.datavisor.vangogh.f.a.a(paramString2))
        return null; 
      try {
        SharedPreferences.Editor editor = paramContext.getSharedPreferences("DV", 0).edit();
        editor.putString(paramString1, paramString2);
        return paramString2;
      } finally {
        paramContext = null;
      } 
    } 
    return null;
  }
  
  public static void a(Context paramContext, String paramString, int paramInt) {
    if (paramContext != null) {
      if (com.datavisor.vangogh.f.a.a(paramString))
        return; 
      try {
        SharedPreferences.Editor editor = paramContext.getSharedPreferences("DV", 0).edit();
        editor.putInt(paramString, paramInt);
        return;
      } finally {
        paramContext = null;
      } 
    } 
  }
  
  public static void a(Context paramContext, String paramString, long paramLong) {
    if (paramContext != null) {
      if (com.datavisor.vangogh.f.a.a(paramString))
        return; 
      try {
        SharedPreferences.Editor editor = paramContext.getSharedPreferences("DV", 0).edit();
        editor.putLong(paramString, paramLong);
        return;
      } finally {
        paramContext = null;
      } 
    } 
  }
  
  public static String b(Context paramContext, String paramString) {
    try {
      return null;
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2) {
    if (paramContext != null && !com.datavisor.vangogh.f.a.a(paramString1)) {
      if (com.datavisor.vangogh.f.a.a(paramString2))
        return; 
      try {
        String str1 = paramContext.getFilesDir().getAbsolutePath();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramContext.getFilesDir().getParentFile().getAbsolutePath());
        stringBuilder.append(crypto.convert("dI2WyGrZo/8fQpF4Aw=="));
        String str2 = stringBuilder.toString();
        return;
      } finally {
        paramContext = null;
      } 
    } 
  }
  
  public static int c(Context paramContext, String paramString) {
    if (paramContext != null) {
      if (com.datavisor.vangogh.f.a.a(paramString))
        return -1; 
      try {
        return paramContext.getSharedPreferences("DV", 0).getInt(paramString, -1);
      } finally {
        paramContext = null;
      } 
    } 
    return -1;
  }
  
  public static long d(Context paramContext, String paramString) {
    if (paramContext != null) {
      if (com.datavisor.vangogh.f.a.a(paramString))
        return -1L; 
      try {
        return paramContext.getSharedPreferences("DV", 0).getLong(paramString, -1L);
      } finally {
        paramContext = null;
      } 
    } 
    return -1L;
  }
  
  public static void e(Context paramContext, String paramString) {
    if (paramContext != null) {
      if (com.datavisor.vangogh.f.a.a(paramString))
        return; 
      try {
        SharedPreferences.Editor editor = paramContext.getSharedPreferences("DV", 0).edit();
        editor.remove(paramString);
        return;
      } finally {
        paramContext = null;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\datavisor\vangogh\e\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */