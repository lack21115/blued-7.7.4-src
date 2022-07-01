package com.blued.android.module.shortvideo.utils;

import android.content.SharedPreferences;
import com.blued.android.core.AppInfo;

public class StvPreferences {
  private static StvPreferences a;
  
  private SharedPreferences b = AppInfo.d().getSharedPreferences("stv_preferences_name", 0);
  
  public static StvPreferences a() {
    // Byte code:
    //   0: getstatic com/blued/android/module/shortvideo/utils/StvPreferences.a : Lcom/blued/android/module/shortvideo/utils/StvPreferences;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/module/shortvideo/utils/StvPreferences
    //   8: monitorenter
    //   9: getstatic com/blued/android/module/shortvideo/utils/StvPreferences.a : Lcom/blued/android/module/shortvideo/utils/StvPreferences;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/module/shortvideo/utils/StvPreferences
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/module/shortvideo/utils/StvPreferences.a : Lcom/blued/android/module/shortvideo/utils/StvPreferences;
    //   25: ldc com/blued/android/module/shortvideo/utils/StvPreferences
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/module/shortvideo/utils/StvPreferences
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/module/shortvideo/utils/StvPreferences.a : Lcom/blued/android/module/shortvideo/utils/StvPreferences;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public SharedPreferences b() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvide\\utils\StvPreferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */