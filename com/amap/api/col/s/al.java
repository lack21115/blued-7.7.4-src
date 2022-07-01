package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;

public final class al {
  public static void a(Context paramContext, String paramString1, String paramString2, Object paramObject) {
    String str = paramObject.getClass().getSimpleName();
    SharedPreferences.Editor editor = paramContext.getSharedPreferences(paramString1, 0).edit();
    if ("String".equals(str)) {
      editor.putString(paramString2, (String)paramObject);
    } else if ("Integer".equals(str)) {
      editor.putInt(paramString2, ((Integer)paramObject).intValue());
    } else if ("Boolean".equals(str)) {
      editor.putBoolean(paramString2, ((Boolean)paramObject).booleanValue());
    } else if ("Float".equals(str)) {
      editor.putFloat(paramString2, ((Float)paramObject).floatValue());
    } else if ("Long".equals(str)) {
      editor.putLong(paramString2, ((Long)paramObject).longValue());
    } 
    editor.commit();
  }
  
  public static Object b(Context paramContext, String paramString1, String paramString2, Object paramObject) {
    String str = paramObject.getClass().getSimpleName();
    SharedPreferences sharedPreferences = paramContext.getSharedPreferences(paramString1, 0);
    return "String".equals(str) ? sharedPreferences.getString(paramString2, (String)paramObject) : ("Integer".equals(str) ? Integer.valueOf(sharedPreferences.getInt(paramString2, ((Integer)paramObject).intValue())) : ("Boolean".equals(str) ? Boolean.valueOf(sharedPreferences.getBoolean(paramString2, ((Boolean)paramObject).booleanValue())) : ("Float".equals(str) ? Float.valueOf(sharedPreferences.getFloat(paramString2, ((Float)paramObject).floatValue())) : ("Long".equals(str) ? Long.valueOf(sharedPreferences.getLong(paramString2, ((Long)paramObject).longValue())) : null))));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */