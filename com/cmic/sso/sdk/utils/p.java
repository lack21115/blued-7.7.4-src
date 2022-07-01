package com.cmic.sso.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Set;

public class p {
  private static Context a;
  
  public static int a(String paramString, int paramInt) {
    return a.getSharedPreferences("ssoconfigs", 0).getInt(h.a(paramString), paramInt);
  }
  
  public static SharedPreferences.Editor a() {
    return new a();
  }
  
  public static void a(Context paramContext) {
    a = paramContext.getApplicationContext();
  }
  
  static void a(String paramString) {
    SharedPreferences sharedPreferences = a.getSharedPreferences("ssoconfigs", 0);
    paramString = h.a(paramString);
    sharedPreferences.edit().remove(paramString).apply();
  }
  
  public static void a(String paramString, long paramLong) {
    SharedPreferences sharedPreferences = a.getSharedPreferences("ssoconfigs", 0);
    paramString = h.a(paramString);
    sharedPreferences.edit().putLong(paramString, paramLong).apply();
  }
  
  public static void a(String paramString1, String paramString2) {
    SharedPreferences sharedPreferences = a.getSharedPreferences("ssoconfigs", 0);
    paramString1 = h.a(paramString1);
    sharedPreferences.edit().putString(paramString1, paramString2).apply();
  }
  
  public static void a(String paramString, boolean paramBoolean) {
    SharedPreferences sharedPreferences = a.getSharedPreferences("ssoconfigs", 0);
    paramString = h.a(paramString);
    sharedPreferences.edit().putBoolean(paramString, paramBoolean).apply();
  }
  
  public static long b(String paramString, long paramLong) {
    return a.getSharedPreferences("ssoconfigs", 0).getLong(h.a(paramString), paramLong);
  }
  
  public static String b(String paramString1, String paramString2) {
    return a.getSharedPreferences("ssoconfigs", 0).getString(h.a(paramString1), paramString2);
  }
  
  static class a implements SharedPreferences.Editor {
    private SharedPreferences.Editor a = p.b().getSharedPreferences("ssoconfigs", 0).edit();
    
    private a() {}
    
    private String a(String param1String) {
      return h.a(param1String);
    }
    
    public void apply() {
      this.a.apply();
    }
    
    public SharedPreferences.Editor clear() {
      return this.a.clear();
    }
    
    public boolean commit() {
      return this.a.commit();
    }
    
    public SharedPreferences.Editor putBoolean(String param1String, boolean param1Boolean) {
      return this.a.putBoolean(a(param1String), param1Boolean);
    }
    
    public SharedPreferences.Editor putFloat(String param1String, float param1Float) {
      return this.a.putFloat(a(param1String), param1Float);
    }
    
    public SharedPreferences.Editor putInt(String param1String, int param1Int) {
      return this.a.putInt(a(param1String), param1Int);
    }
    
    public SharedPreferences.Editor putLong(String param1String, long param1Long) {
      return this.a.putLong(a(param1String), param1Long);
    }
    
    public SharedPreferences.Editor putString(String param1String1, String param1String2) {
      return this.a.putString(a(param1String1), param1String2);
    }
    
    public SharedPreferences.Editor putStringSet(String param1String, Set<String> param1Set) {
      return this.a.putStringSet(a(param1String), param1Set);
    }
    
    public SharedPreferences.Editor remove(String param1String) {
      return this.a.remove(a(param1String));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sd\\utils\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */