package com.huawei.updatesdk.b.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.huawei.updatesdk.a.a.b.a.a.a;

public class b {
  private SharedPreferences a;
  
  private b(SharedPreferences paramSharedPreferences) {
    this.a = paramSharedPreferences;
  }
  
  public static b a(String paramString, Context paramContext) {
    Context context = paramContext;
    try {
      if (Build.VERSION.SDK_INT >= 24)
        context = paramContext.createDeviceProtectedStorageContext(); 
      SharedPreferences sharedPreferences = context.getSharedPreferences(paramString, 0);
    } catch (Exception exception) {
      a.b("SharedPreferencesWrapper", "getSharedPreference error");
      exception = null;
    } 
    return new b((SharedPreferences)exception);
  }
  
  public long a(String paramString, long paramLong) {
    try {
      return this.a.getLong(paramString, paramLong);
    } catch (Exception exception) {
      return paramLong;
    } 
  }
  
  public String a(String paramString1, String paramString2) {
    try {
      return this.a.getString(paramString1, paramString2);
    } catch (Exception exception) {
      return paramString2;
    } 
  }
  
  public void b(String paramString, long paramLong) {
    try {
      SharedPreferences.Editor editor = this.a.edit();
      editor.putLong(paramString, paramLong);
      editor.commit();
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("putLong error!!key:");
      stringBuilder.append(paramString);
      a.a("SharedPreferencesWrapper", stringBuilder.toString(), exception);
      return;
    } 
  }
  
  public void b(String paramString1, String paramString2) {
    try {
      SharedPreferences.Editor editor = this.a.edit();
      editor.putString(paramString1, paramString2);
      editor.commit();
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("putString error!!key:");
      stringBuilder.append(paramString1);
      a.a("SharedPreferencesWrapper", stringBuilder.toString(), exception);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\b\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */