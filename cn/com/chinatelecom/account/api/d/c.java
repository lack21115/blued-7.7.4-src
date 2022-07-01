package cn.com.chinatelecom.account.api.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

public final class c {
  private static SharedPreferences a(Context paramContext) {
    return paramContext.getSharedPreferences(b(paramContext), 0);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt) {
    if (paramContext != null && !TextUtils.isEmpty(paramString))
      try {
        a(paramContext).edit().putInt(paramString, paramInt).commit();
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2) {
    if (paramContext != null && !TextUtils.isEmpty(paramString1))
      try {
        a(paramContext).edit().putString(paramString1, paramString2).commit();
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public static boolean a(Context paramContext, String paramString, long paramLong) {
    if (paramContext != null && !TextUtils.isEmpty(paramString))
      try {
        return a(paramContext).edit().putLong(paramString, paramLong).commit();
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return false;
  }
  
  public static int b(Context paramContext, String paramString, int paramInt) {
    if (paramContext != null && !TextUtils.isEmpty(paramString))
      try {
        return a(paramContext).getInt(paramString, paramInt);
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return paramInt;
  }
  
  public static long b(Context paramContext, String paramString, long paramLong) {
    if (paramContext != null && !TextUtils.isEmpty(paramString))
      try {
        return a(paramContext).getLong(paramString, paramLong);
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return paramLong;
  }
  
  private static String b(Context paramContext) {
    return "ct_account_api_sdk";
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2) {
    if (paramContext != null && !TextUtils.isEmpty(paramString1))
      try {
        return a(paramContext).getString(paramString1, paramString2);
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return paramString2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\com\chinatelecom\account\api\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */