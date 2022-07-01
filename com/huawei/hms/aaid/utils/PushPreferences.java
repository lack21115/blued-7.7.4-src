package com.huawei.hms.aaid.utils;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.util.HashMap;
import java.util.Map;

public class PushPreferences {
  public SharedPreferences a;
  
  public PushPreferences(Context paramContext, String paramString) {
    if (paramContext != null) {
      Context context = paramContext;
      if (Build.VERSION.SDK_INT >= 24) {
        context = paramContext.createDeviceProtectedStorageContext();
        SharedPreferences sharedPreferences = context.getSharedPreferences("move_to_de_records", 0);
        if (!sharedPreferences.getBoolean(paramString, false))
          if (!context.moveSharedPreferencesFrom(paramContext, paramString)) {
            context = paramContext;
          } else {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(paramString, true);
            editor.apply();
          }  
      } 
      this.a = context.getSharedPreferences(paramString, 0);
      return;
    } 
    throw new NullPointerException("context is null!");
  }
  
  public boolean clear() {
    SharedPreferences sharedPreferences = this.a;
    return (sharedPreferences != null) ? sharedPreferences.edit().clear().commit() : false;
  }
  
  public boolean containsKey(String paramString) {
    SharedPreferences sharedPreferences = this.a;
    return (sharedPreferences != null && sharedPreferences.contains(paramString));
  }
  
  public Map<String, ?> getAll() {
    SharedPreferences sharedPreferences = this.a;
    return (sharedPreferences != null) ? sharedPreferences.getAll() : new HashMap<String, Object>();
  }
  
  public boolean getBoolean(String paramString) {
    SharedPreferences sharedPreferences = this.a;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (sharedPreferences != null) {
      bool1 = bool2;
      if (sharedPreferences.getBoolean(paramString, false))
        bool1 = true; 
    } 
    return bool1;
  }
  
  public int getInt(String paramString) {
    SharedPreferences sharedPreferences = this.a;
    int i = 0;
    if (sharedPreferences != null)
      i = sharedPreferences.getInt(paramString, 0); 
    return i;
  }
  
  public long getLong(String paramString) {
    SharedPreferences sharedPreferences = this.a;
    long l = 0L;
    if (sharedPreferences != null)
      l = sharedPreferences.getLong(paramString, 0L); 
    return l;
  }
  
  public String getString(String paramString) {
    SharedPreferences sharedPreferences = this.a;
    String str = "";
    if (sharedPreferences != null)
      str = sharedPreferences.getString(paramString, ""); 
    return str;
  }
  
  public ContentValues read() {
    SharedPreferences sharedPreferences = this.a;
    if (sharedPreferences == null)
      return null; 
    Map map = sharedPreferences.getAll();
    if (map == null)
      return null; 
    ContentValues contentValues = new ContentValues();
    for (Map.Entry entry : map.entrySet()) {
      String str = (String)entry.getKey();
      entry = (Map.Entry)entry.getValue();
      if (entry instanceof String) {
        contentValues.put(str, String.valueOf(entry));
        continue;
      } 
      if (entry instanceof Integer || entry instanceof Short || entry instanceof Byte) {
        contentValues.put(str, (Integer)entry);
        continue;
      } 
      if (entry instanceof Long) {
        contentValues.put(str, (Long)entry);
        continue;
      } 
      if (entry instanceof Float) {
        contentValues.put(str, (Float)entry);
        continue;
      } 
      if (entry instanceof Double) {
        contentValues.put(str, Float.valueOf((float)((Double)entry).doubleValue()));
        continue;
      } 
      if (entry instanceof Boolean)
        contentValues.put(str, (Boolean)entry); 
    } 
    return contentValues;
  }
  
  public boolean removeKey(String paramString) {
    SharedPreferences sharedPreferences = this.a;
    if (sharedPreferences != null && sharedPreferences.contains(paramString)) {
      SharedPreferences.Editor editor = this.a.edit();
      if (editor != null)
        return editor.remove(paramString).commit(); 
    } 
    return false;
  }
  
  public boolean removeKey(String[] paramArrayOfString) {
    SharedPreferences sharedPreferences = this.a;
    int i = 0;
    if (sharedPreferences == null)
      return false; 
    int j = paramArrayOfString.length;
    while (i < j) {
      String str = paramArrayOfString[i];
      if (this.a.contains(str))
        this.a.edit().remove(str); 
      i++;
    } 
    this.a.edit().commit();
    return true;
  }
  
  public boolean save(String paramString, Object paramObject) {
    SharedPreferences.Editor editor = this.a.edit();
    if (paramObject instanceof String) {
      editor.putString(paramString, String.valueOf(paramObject));
    } else if (paramObject instanceof Integer) {
      editor.putInt(paramString, ((Integer)paramObject).intValue());
    } else if (paramObject instanceof Short) {
      editor.putInt(paramString, ((Short)paramObject).shortValue());
    } else if (paramObject instanceof Byte) {
      editor.putInt(paramString, ((Byte)paramObject).byteValue());
    } else if (paramObject instanceof Long) {
      editor.putLong(paramString, ((Long)paramObject).longValue());
    } else if (paramObject instanceof Float) {
      editor.putFloat(paramString, ((Float)paramObject).floatValue());
    } else if (paramObject instanceof Double) {
      editor.putFloat(paramString, (float)((Double)paramObject).doubleValue());
    } else if (paramObject instanceof Boolean) {
      editor.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
    } 
    return editor.commit();
  }
  
  public void saveBoolean(String paramString, boolean paramBoolean) {
    SharedPreferences sharedPreferences = this.a;
    if (sharedPreferences == null)
      return; 
    SharedPreferences.Editor editor = sharedPreferences.edit();
    if (editor != null)
      editor.putBoolean(paramString, paramBoolean).commit(); 
  }
  
  public void saveInt(String paramString, Integer paramInteger) {
    SharedPreferences sharedPreferences = this.a;
    if (sharedPreferences == null)
      return; 
    SharedPreferences.Editor editor = sharedPreferences.edit();
    if (editor != null)
      editor.putInt(paramString, paramInteger.intValue()).commit(); 
  }
  
  public void saveLong(String paramString, Long paramLong) {
    SharedPreferences sharedPreferences = this.a;
    if (sharedPreferences == null)
      return; 
    SharedPreferences.Editor editor = sharedPreferences.edit();
    if (editor != null)
      editor.putLong(paramString, paramLong.longValue()).commit(); 
  }
  
  public void saveMap(Map<String, Object> paramMap) {
    for (Map.Entry<String, Object> entry : paramMap.entrySet())
      save((String)entry.getKey(), entry.getValue()); 
  }
  
  public boolean saveString(String paramString1, String paramString2) {
    SharedPreferences sharedPreferences = this.a;
    if (sharedPreferences == null)
      return false; 
    SharedPreferences.Editor editor = sharedPreferences.edit();
    return (editor != null) ? editor.putString(paramString1, paramString2).commit() : false;
  }
  
  public boolean write(ContentValues paramContentValues) {
    if (this.a != null) {
      if (paramContentValues == null)
        return false; 
      boolean bool = true;
      for (Map.Entry entry : paramContentValues.valueSet()) {
        if (!save((String)entry.getKey(), entry.getValue()))
          bool = false; 
      } 
      return bool;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\aai\\utils\PushPreferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */