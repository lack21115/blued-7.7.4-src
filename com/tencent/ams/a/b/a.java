package com.tencent.ams.a.b;

import android.util.Log;

public class a {
  public static void a(String paramString) {}
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("TENCENT_AMS_");
    stringBuilder.append(paramString1);
    Log.e(stringBuilder.toString(), paramString2, paramThrowable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\ams\a\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */