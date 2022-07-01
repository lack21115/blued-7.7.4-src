package com.ishumei.l111l1111llIl;

import android.content.SharedPreferences;
import java.util.Set;

public final class l111l1111llIl {
  public static void l1111l111111Il(SharedPreferences paramSharedPreferences, String paramString, int paramInt) {
    SharedPreferences.Editor editor = paramSharedPreferences.edit();
    editor.putInt(paramString, paramInt);
    editor.apply();
  }
  
  public static void l1111l111111Il(SharedPreferences paramSharedPreferences, String paramString, long paramLong) {
    SharedPreferences.Editor editor = paramSharedPreferences.edit();
    editor.putLong(paramString, paramLong);
    editor.apply();
  }
  
  private static void l1111l111111Il(SharedPreferences paramSharedPreferences, String paramString1, String paramString2) {
    SharedPreferences.Editor editor = paramSharedPreferences.edit();
    editor.putString(paramString1, paramString2);
    editor.apply();
  }
  
  public static void l1111l111111Il(SharedPreferences paramSharedPreferences, String paramString, Set<String> paramSet) {
    SharedPreferences.Editor editor = paramSharedPreferences.edit();
    editor.putStringSet(paramString, paramSet);
    editor.apply();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l1111llIl\l111l1111llIl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */