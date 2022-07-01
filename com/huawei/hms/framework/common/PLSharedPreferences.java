package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.util.Map;

public class PLSharedPreferences {
  private static final String MOVE_TO_DE_RECORDS = "grs_move2DE_records";
  
  private static final String TAG = "PLSharedPreferences";
  
  private SharedPreferences sp;
  
  public PLSharedPreferences(Context paramContext, String paramString) {
    this.sp = getSharedPreferences(paramContext, paramString);
  }
  
  private SharedPreferences getSharedPreferences(Context paramContext, String paramString) {
    if (paramContext == null) {
      Logger.e("PLSharedPreferences", "context is null, must call init method to set context");
      return null;
    } 
    Context context = paramContext;
    if (Build.VERSION.SDK_INT >= 24) {
      context = paramContext.createDeviceProtectedStorageContext();
      SharedPreferences sharedPreferences = context.getSharedPreferences("grs_move2DE_records", 0);
      if (!sharedPreferences.getBoolean(paramString, false))
        if (!context.moveSharedPreferencesFrom(paramContext, paramString)) {
          context = paramContext;
        } else {
          SharedPreferences.Editor editor = sharedPreferences.edit();
          editor.putBoolean(paramString, true);
          editor.apply();
        }  
    } 
    return context.getSharedPreferences(paramString, 0);
  }
  
  public void clear() {
    SharedPreferences sharedPreferences = this.sp;
    if (sharedPreferences == null)
      return; 
    sharedPreferences.edit().clear().apply();
  }
  
  public SharedPreferences.Editor edit() {
    SharedPreferences sharedPreferences = this.sp;
    return (sharedPreferences == null) ? null : sharedPreferences.edit();
  }
  
  public Map<String, ?> getAll() {
    SharedPreferences sharedPreferences = this.sp;
    return (sharedPreferences == null) ? null : sharedPreferences.getAll();
  }
  
  public long getLong(String paramString, long paramLong) {
    SharedPreferences sharedPreferences = this.sp;
    return (sharedPreferences == null) ? paramLong : sharedPreferences.getLong(paramString, paramLong);
  }
  
  public String getString(String paramString) {
    return getString(paramString, "");
  }
  
  public String getString(String paramString1, String paramString2) {
    SharedPreferences sharedPreferences = this.sp;
    return (sharedPreferences == null) ? paramString2 : sharedPreferences.getString(paramString1, paramString2);
  }
  
  public void putLong(String paramString, long paramLong) {
    SharedPreferences sharedPreferences = this.sp;
    if (sharedPreferences == null)
      return; 
    sharedPreferences.edit().putLong(paramString, paramLong).apply();
  }
  
  public void putString(String paramString1, String paramString2) {
    SharedPreferences sharedPreferences = this.sp;
    if (sharedPreferences == null)
      return; 
    sharedPreferences.edit().putString(paramString1, paramString2).apply();
  }
  
  public void remove(String paramString) {
    SharedPreferences sharedPreferences = this.sp;
    if (sharedPreferences == null)
      return; 
    sharedPreferences.edit().remove(paramString).apply();
  }
  
  public void removeKeyValue(String paramString) {
    SharedPreferences sharedPreferences = this.sp;
    if (sharedPreferences == null)
      return; 
    sharedPreferences.edit().remove(paramString).apply();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\common\PLSharedPreferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */